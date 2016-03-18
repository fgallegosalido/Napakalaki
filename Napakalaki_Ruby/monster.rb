#encoding: utf-8

module Napakalaki
  class Monster
    attr_reader :name, :combatLevel, :badConsequence, :prize

    def initialize (aString, someLevels, badCons, somePrize)
      @name = aString
      @combatLevel = someLevels
      @badConsequence = badCons
      @prize = somePrize
    end

    def to_s
      "Name = #{@name}\nCombat Level = #{@combatLevel}\nBad Consequence:\n" + @badConsequence.to_s + "Prize:\n" + @prize.to_s + "\n"
    end
  end
end
