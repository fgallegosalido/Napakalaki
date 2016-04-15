#encoding: utf-8

module NapakalakiGame
  class Monster
    attr_reader :name, :combatLevel, :badConsequence

    def initialize (aString, someLevels, badCons, somePrize)
      @name = aString
      @combatLevel = someLevels
      @badConsequence = badCons
      @prize = somePrize
    end

    def getLevelsGained
      @prize.level
    end

    def getTreasuresGained
      @prize.treasures
    end

    def to_s
      "Name = #{@name}\nCombat Level = #{@combatLevel}\nBad Consequence:\n" + @badConsequence.to_s + "Prize:\n" + @prize.to_s + "\n"
    end
  end
end
