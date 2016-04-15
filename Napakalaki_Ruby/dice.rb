#encoding: utf-8

require 'singleton'

module NapakalakiGame
  class Dice
    include Singleton

    def nextNumber
      [*1..6].sample
      #rand(6) + 1
    end
  end
end
