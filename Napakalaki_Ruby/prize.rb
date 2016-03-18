#encoding: utf-8

module Napakalaki
  class Prize
    attr_reader :treasures, :level

    def initialize (someTreasures, someLevels)
      @treasures = someTreasures
      @level = someLevels
    end

    def to_s
      "Treasures = #{@treasures}\nLevels = #{@level}\n"
    end
  end
end
