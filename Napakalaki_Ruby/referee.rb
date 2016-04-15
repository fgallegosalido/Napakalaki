#encoding: utf-8

module NapakalakiGame
  class Referee
    @@instance = [Referee.new, Referee.new, Referee.new, Referee.new, Referee.new]

    private_class_method :new

    def initialize
    end

    def self.getInstance (i)
      if i < 5
        @@instance[i]
      else
        nil
      end
    end

    def nextNumber
      [*7..13].sample
      #rand(6) + 1
    end
  end
end
