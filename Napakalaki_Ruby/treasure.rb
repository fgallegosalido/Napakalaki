#encoding: utf-8

module NapakalakiGame
  class Treasure
    attr_reader :name, :bonus, :type

    def initialize (n, b, t)
        @name = n
        @bonus = b
        @type = t
    end
  end
end
