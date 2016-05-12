#encoding: utf-8

require_relative 'numeric_bad_consequence.rb'

module NapakalakiGame
  class DeathBadConsequence < NumericBadConsequence
    def initialize (aText)
      super(aText, 10, @@MAXTREASURES, @@MAXTREASURES)
    end
  end
end
