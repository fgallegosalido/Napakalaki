#encoding: utf-8

module NapakalakiGame
  class Treasure
    attr_reader :name, :bonus, :type

    def initialize (n, b, t)
        @name = n
        @bonus = b
        @type = t
    end

    def to_s
      "#{@name}, bonus=#{@bonus}, tipo=#{@type}"
    end
  end
end
