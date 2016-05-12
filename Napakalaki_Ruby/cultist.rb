#encoding: utf-8

module NapakalakiGame
  class Cultist
    attr_reader :gainedLevels

    def initialize (n, gl)
        @name = n
        @gainedLevels = gl
    end

    def to_s
      "#{@name}, gainedLevels=#{@gainedLevels}"
    end
  end
end
