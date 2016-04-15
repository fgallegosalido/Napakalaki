#encoding: utf-8

require_relative 'bad_consequence.rb'
require_relative 'treasure.rb'
require_relative 'treasure_kind.rb'

module NapakalakiGame
  class Player
    @@MAXLEVEL = 10

    attr_reader :name, :dead, :level, :visibleTreasures, :hiddenTreasures

    def initialize (n)
      @name = n
      @dead = true
      @level = 1
      @visibleTreasures = Array.new
      @hiddenTreasures = Array.new
      @pendingBadConsequence = BadConsequence.newLevelNumberOfTreasures("", 0, 0, 0)
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
    end

    def applyBadConsequence (m)
    end

    def canMakeTreasureVisible (t)
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
    end

    def makeTreasureVisible (t)
    end

    def discardVisibleTreasure (t)
    end

    def discardHiddenTreasure (t)
    end

    def validState
      @pendingBadConsequence.isEmpty && (@hiddenTreasures.length <= 4)
    end

    def initTreasures
    end

    def discardAllTreasures
    end

    private :bringToLife, :getCombatLevel, :incrementLevels, :decrementLevels, :setPendingBadConsequence, :applyPrize, :applyBadConsequence, :canMakeTreasureVisible, :howManyVisibleTreasures, :dieIfNoTreasures
  end
end
