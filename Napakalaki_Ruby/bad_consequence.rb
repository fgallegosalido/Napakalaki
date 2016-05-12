#encoding: utf-8

module NapakalakiGame
  class BadConsequence
    attr_reader :text, :level

    def initialize (aText, someLevels)
      @text = aText
      @level = someLevels
    end
    private_class_method :new

    def isEmpty
      raise NotImplementdError.new
    end

    def substractVisibleTreasure (t)
      raise NotImplementdError.new
    end

    def substractHiddenTreasure (t)
      raise NotImplementdError.new
    end

    def adjustToFitTreasureLists (v, h)
      raise NotImplementdError.new
    end

    def to_s
      "Text = #{@text}\nLevels = #{@level}\n"
    end
  end
end
