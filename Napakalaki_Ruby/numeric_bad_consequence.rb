#encoding: utf-8

require_relative 'bad_consequence.rb'

module NapakalakiGame
  class NumericBadConsequence < BadConsequence
    @@MAXTREASURES = 10

    attr_reader :nVisibleTreasures, :nHiddenTreasures

    def initialize (aText, someLevels, someVisibleTreasures, someHiddenTreasures)
      super(aText, someLevels)
      @nVisibleTreasures = someVisibleTreasures
      @nHiddenTreasures = someHiddenTreasures
    end
    public_class_method :new

    def self.MAXTREASURES
      @@MAXTREASURES
    end

    def isEmpty
      (@nVisibleTreasures == 0) && (@nHiddenTreasures == 0)
    end

    def substractVisibleTreasure (t)
      if @nVisibleTreasures > 0
        @nVisibleTreasures -= 1
      end
    end

    def substractHiddenTreasure (t)
      if @nHiddenTreasures > 0
        @nHiddenTreasures -= 1
      end
    end

    def adjustToFitTreasureLists (v, h)
      nVisTre = @nVisibleTreasures
      nHidTre = @nHiddenTreasures
      if v.length < @nVisibleTreasures
        nVisTre = v.length
      end
      if h.length < @nHiddenTreasures
        nHidTre = h.length
      end

      newBadCons = NumericBadConsequence.new("", 0, nVisTre, nHidTre)
    end

    def to_s
      super + "Visible Treasures = #{@nVisibleTreasures}\nHidden Treasures = #{@nHiddenTreasures}\n"
    end
  end
end
