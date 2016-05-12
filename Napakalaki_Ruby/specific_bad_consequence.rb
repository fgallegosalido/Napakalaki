#encoding: utf-8

require_relative 'bad_consequence.rb'

module NapakalakiGame
  class SpecificBadConsequence < BadConsequence

    attr_reader :specificVisibleTreasures, :specificHiddenTreasures

    def initialize (aText, someLevels, someSpecificVisibleTreasures, someSpecificHiddenTreasures)
      super(aText, someLevels)
      @specificVisibleTreasures = Array.new(someSpecificVisibleTreasures)
      @specificHiddenTreasures = Array.new(someSpecificHiddenTreasures)
    end
    public_class_method :new

    def isEmpty
      (@specificVisibleTreasures.empty?) && (@specificHiddenTreasures.empty?)
    end

    def substractVisibleTreasure (t)
      for i in 0..@specificVisibleTreasures.length-1 do
        if t.type == @specificVisibleTreasures[i]
          @specificVisibleTreasures.delete_at(i)
          break
        end
      end
    end

    def substractHiddenTreasure (t)
      for i in 0..@specificHiddenTreasures.length-1 do
        if t.type == @specificHiddenTreasures[i]
          @specificHiddenTreasures.delete_at(i)
          break
        end
      end
    end

    def adjustToFitTreasureLists (v, h)
      auxVisible = Array.new(@specificVisibleTreasures)
      auxArray = Array.new(auxVisible)
      v.each do |treasure|
        for i in 0..auxArray.length-1 do
          if auxArray[i] == treasure.type
            auxArray.delete_at(i)
            break
          end
        end
      end
      auxArray.each do |tKind|
        auxVisible.delete_at(auxVisible.find_index(tKind))
      end

      auxHidden = Array.new(@specificHiddenTreasures)
      auxArray = Array.new(auxHidden)
      h.each do |treasure|
        for i in 0..auxArray.length-1 do
          if auxArray[i] == treasure.type
            auxArray.delete_at(i)
            break
          end
        end
      end
      auxArray.each do |tKind|
        auxHidden.delete_at(auxHidden.find_index(tKind))
      end

      newBadCons = SpecificBadConsequence.new("", 0, auxVisible, auxHidden)
    end

    def to_s
      super + "Specific Visible Treasures = " + @specificVisibleTreasures.to_s + "\nSpecific Hidden Treasures = " + @specificHiddenTreasures.to_s + "\n"
    end
  end
end
