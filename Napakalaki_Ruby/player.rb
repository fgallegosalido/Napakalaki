#encoding: utf-8

require_relative 'card_dealer.rb'
require_relative 'bad_consequence.rb'
require_relative 'treasure.rb'
require_relative 'treasure_kind.rb'
require_relative 'dice.rb'

module NapakalakiGame
  class Player
    @@MAXLEVEL = 10

    attr_reader :name
    attr_accessor :dead, :level, :visibleTreasures, :hiddenTreasures, :pendingBadConsequence

    def initialize (n)
      @name = n
      @dead = true
      @level = 1
      @visibleTreasures = Array.new
      @hiddenTreasures = Array.new
      @pendingBadConsequence = NumericBadConsequence.new("", 0, 0, 0)
    end

    def getName
      @name
    end

    def getVisibleTreasures
      @visibleTreasures
    end

    def getHiddenTreasures
      @hiddenTreasures
    end

    def createCopy
      nPlayer = Player.new(@name)
      nPlayer.dead = @dead
      nPlayer.level = @level
      nPlayer.visibleTreasures = Array.new(@visibleTreasures)
      nPlayer.hiddenTreasures = Array.new(@hiddenTreasures)
      nPlayer.pendingBadConsequence = @pendingBadConsequence
      nPlayer
    end

    def self.MAXLEVEL
      @@MAXLEVEL
    end

    def bringToLife
      @dead = false
    end

    def getCombatLevel
      suma = @level
      @visibleTreasures.each do |element|
        suma += element.bonus
      end
      suma
    end

    def getOponentLevel (m)
      m.combatLevel
    end

    def shouldConvert
      Dice.instance.nextNumber == 6
    end

    def incrementLevels (i)
      @level += i
    end

    def decrementLevels (i)
      if (@level - i) <= 1
        @level = 1
      else
        @level -= i
      end
    end

    def setPendingBadConsequence (b)
      @pendingBadConsequence = b
    end

    def applyPrize (m)
      nLevels = m.getLevelsGained
      incrementLevels(nLevels)
      nTreasures = m.getTreasuresGained

      if nTreasures > 0
        dealer = CardDealer.instance

        for i in 1..nTreasures do
          treasure = dealer.nextTreasure
          @hiddenTreasures << treasure
        end
      end
    end

    def applyBadConsequence (m)
      badConsequence = m.badConsequence
      nLevels = badConsequence.level
      decrementLevels(nLevels)
      pendingBad = badConsequence.adjustToFitTreasureLists(@visibleTreasures, @hiddenTreasures)
      setPendingBadConsequence(pendingBad)
    end

    def canMakeTreasureVisible (t)
      if t.type == TreasureKind::ONEHAND
        howManyVisibleTreasures(TreasureKind::ONEHAND) < 2 && howManyVisibleTreasures(TreasureKind::BOTHHANDS) == 0
      elsif t.type == TreasureKind::BOTHHANDS
        howManyVisibleTreasures(TreasureKind::ONEHAND) == 0 && howManyVisibleTreasures(TreasureKind::BOTHHANDS) == 0
      else
        howManyVisibleTreasures(t.type) == 0
      end
    end

    def howManyVisibleTreasures (tKind)
      suma = 0
      @visibleTreasures.each do |element|
        if element.type == tKind
          suma += 1
        end
      end
      suma
    end

    def dieIfNoTreasures
      if @visibleTreasures.empty? && @hiddenTreasures.empty?
        @dead = true
      end
    end

    def combat (m)
      myLevel = getCombatLevel
      monsterLevel = getOponentLevel(m)

      if myLevel > monsterLevel
        applyPrize(m)
        if @level >= @@MAXLEVEL
          combatResult = CombatResult::WINGAME
        else
          combatResult = CombatResult::WIN
        end
      else
        applyBadConsequence(m)
        if shouldConvert
          combatResult = CombatResult::LOSEANDCONVERT
        else
          combatResult = CombatResult::LOSE
        end
      end
    end

    def makeTreasureVisible (t)
      canI = canMakeTreasureVisible(t)

      if canI
        @visibleTreasures << t
        @hiddenTreasures.delete(t)
      end
    end

    def discardVisibleTreasure (t)
      @visibleTreasures.delete(t)
      CardDealer.instance.giveTreasureBack(t)

      if @pendingBadConsequence!=nil && !@pendingBadConsequence.isEmpty
        @pendingBadConsequence.substractVisibleTreasure(t)
      end

      dieIfNoTreasures
    end

    def discardHiddenTreasure (t)
      @hiddenTreasures.delete(t)
      CardDealer.instance.giveTreasureBack(t)

      if @pendingBadConsequence!=nil && !@pendingBadConsequence.isEmpty
        @pendingBadConsequence.substractHiddenTreasure(t)
      end

      dieIfNoTreasures
    end

    def validState
      @pendingBadConsequence.isEmpty && (@hiddenTreasures.length <= 4)
    end

    def initTreasures
      dealer = CardDealer.instance
      dice = Dice.instance
      bringToLife
      treasure = dealer.nextTreasure
      @hiddenTreasures << treasure
      number = dice.nextNumber

      if number > 1
        treasure = dealer.nextTreasure
        @hiddenTreasures << treasure
      end

      if number == 6
        treasure = dealer.nextTreasure
        @hiddenTreasures << treasure
      end
    end

    def discardAllTreasures
      auxVisible = Array.new(@visibleTreasures)
      auxHidden = Array.new(@hiddenTreasures)

      auxVisible.each do |treasure|
        discardVisibleTreasure(treasure)
      end

      auxHidden.each do |treasure|
        discardHiddenTreasure(treasure)
      end
    end

    def to_s
      "#{@name}, nivel #{@level}"
    end

    protected :getCombatLevel, :getOponentLevel, :shouldConvert
    private :bringToLife, :incrementLevels, :decrementLevels, :setPendingBadConsequence, :applyPrize, :applyBadConsequence, :canMakeTreasureVisible, :howManyVisibleTreasures, :dieIfNoTreasures
  end
end
