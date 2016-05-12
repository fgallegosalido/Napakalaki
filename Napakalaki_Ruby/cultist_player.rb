#encoding: utf-8

require_relative 'cultist.rb'
require_relative 'player.rb'

module NapakalakiGame
  class CultistPlayer < Player
    @@totalCultistPlayers = 0

    def initialize (pl, cult)
      super(pl.name)
      auxpl = pl.createCopy
      @dead = auxpl.dead
      @level = auxpl.level
      @visibleTreasures = auxpl.visibleTreasures
      @hiddenTreasures = auxpl.hiddenTreasures
      @pendingBadConsequence = pl.pedingBadConsequence
      @myCultistCard = cult
      @@totalCultistPlayers += 1
    end

    def self.totalCultistPlayers
      @@totalCultistPlayers
    end

    def getCombatLevel
      suma = super
      suma = suma + suma/2 + @@totalCultistPlayers*@myCultistCard.gainedLevels
      suma = suma.to_int
    end

    def getOponentLevel (m)
      m.getCombatLevelAgainstCultistPlayer
    end

    def shouldConvert
      false
    end

    def to_s
      super + ", #{@myCultistCard.name}"
    end

    protected :getCombatLevel, :getOponentLevel, :shouldConvert
  end
end
