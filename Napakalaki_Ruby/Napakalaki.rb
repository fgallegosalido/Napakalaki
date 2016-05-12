#encoding: utf-8

require 'singleton'
require_relative 'card_dealer.rb'
require_relative 'cultist_player.rb'
require_relative 'combat_result.rb'

module NapakalakiGame
  class Napakalaki
    include Singleton

    attr_reader :currentPlayer, :currentMonster

    def initialize
      @currentPlayerIndex = -1
      @currentPlayer = nil
      @currentMonster = nil
      @players = Array.new
      @dealer = CardDealer.instance
    end

    def getCurrentPlayer
      @currentPlayer
    end

    def getCurrentMonster
      @currentMonster
    end

    def initPlayers (names)
      names.each do |string|
        @players << Player.new(string)
      end
    end

    def nextPlayer
      if @currentPlayerIndex < 0
        @currentPlayerIndex = rand(@players.length)
      elsif @currentPlayerIndex == @players.length-1
        @currentPlayerIndex = 0
      else
        @currentPlayerIndex = @currentPlayerIndex+1
      end

      @currentPlayer = @players[@currentPlayerIndex]
    end

    def nextTurnAllowed
      @currentPlayer == nil || @currentPlayer.validState
    end

    def developCombat
      combatResult = @currentPlayer.combat(@currentMonster)
      @dealer.giveMonsterBack(@currentMonster)
      if combatResult == CombatResult::LOSEANDCONVERT
        cultCard = @dealer.nextCultist
        cultPlayer = CultistPlayer.new(@currentPlayer, cultCard)
        @players[@currentPlayerIndex] = cultPlayer
        @currentPlayer = cultPlayer
      end
      combatResult
    end

    def discardVisibleTreasures (treasures)
      treasures.each do |element|
        @currentPlayer.discardVisibleTreasure(element)
      end
    end

    def discardHiddenTreasures (treasures)
      treasures.each do |element|
        @currentPlayer.discardHiddenTreasure(element)
      end
    end

    def makeTreasuresVisibles (treasures)
      treasures.each do |element|
        @currentPlayer.makeTreasureVisible(element)
      end
    end

    def initGame (players)
      initPlayers(players)
      @dealer.initCards
      nextTurn
    end

    def nextTurn
      stateOK = true
      if @currentPlayer != nil
        stateOK = nextTurnAllowed
      end
      if stateOK
        @currentMonster = @dealer.nextMonster
        @currentPlayer = nextPlayer
        dead = @currentPlayer.dead
        if dead
          @currentPlayer.initTreasures
        end
      end
      stateOK
    end

    def endOfGame (result)
      result == CombatResult::WINGAME
    end

    private :initPlayers, :nextPlayer, :nextTurnAllowed
  end
end
