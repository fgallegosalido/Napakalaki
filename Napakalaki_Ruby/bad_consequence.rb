#encoding: utf-8

#require_relative 'player.rb'

module NapakalakiGame
  class BadConsequence
    @@MAXTREASURES = 10

    attr_reader :text, :level, :nVisibleTreasures, :nHiddenTreasures, :specificVisibleTreasures, :specificHiddenTreasures

    def initialize (aText, someLevels, someVisibleTreasures, someHiddenTreasures, someSpecificVisibleTreasures, someSpecificHiddenTreasures)
      @text = aText
      @level = someLevels
      @nVisibleTreasures = someVisibleTreasures
      @nHiddenTreasures = someHiddenTreasures
      @specificVisibleTreasures = someSpecificVisibleTreasures
      @specificHiddenTreasures = someSpecificHiddenTreasures
    end

    def self.MAXTREASURES
      @@MAXTREASURES
    end

    private_class_method :new
    def self.newLevelNumberOfTreasures (aText, someLevels, someVisibleTreasures, someHiddenTreasures)
      new(aText, someLevels, someVisibleTreasures, someHiddenTreasures, Array.new, Array.new)
    end

    def self.newLevelSpecificTreasures (aText, someLevels, someSpecificVisibleTreasures, someSpecificHiddenTreasures)
      new(aText, someLevels, -1, -1, someSpecificVisibleTreasures, someSpecificHiddenTreasures)
    end

    def self.newDeath (aText)
      new(aText, 10, @@MAXTREASURES, @@MAXTREASURES, Array.new, Array.new)
    end

    def isEmpty
      (@nVisibleTreasures == 0) && (@nHiddenTreasures == 0) && (@level == 0)
    end

    def substractVisibleTreasures (t)
    end

    def substractHiddenTreasures (t)
    end

    def adjustToFitTreasureList (v, h)
    end

    def to_s
      "Text = #{@text}\nLevels = #{@level}\nVisible Treasures = #{@nVisibleTreasures}\nHidden Treasures = #{@nHiddenTreasures}\n"\
      + "Specific Visible Treasures = " + @specificVisibleTreasures.to_s + "\nSpecific Hidden Treasures = " + @specificHiddenTreasures.to_s + "\n"
    end
  end
end
