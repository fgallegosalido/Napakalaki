#encoding: utf-8

require 'singleton'
require_relative 'card_dealer.rb'

module NapakalakiGame
  class Napakalaki
    include Singleton

    attr_reader :currentPlayer, :currentMonster

    def initialize
      @currentPlayerIndex = 0
      @currentPlayer = nil
      @currentMonster = nil
      @players = Array.new
      @dealer = CardDealer.instance
    end

    def initPlayers (names)
    end

    def nextPlayer
    end

    def nextTurnAllowed
    end

    def developCombat
    end

    def discardVisibleTreasures (treasures)
    end

    def discardHiddenTreasures (treasures)
    end

    def makeTreasuresVisibles (treasures)
    end

    def initGame (players)
    end

    def nextTurn
    end

    def endOfGame (result)
    end

    private :initPlayers, :nextPlayer, :nextTurnAllowed
  end
end
