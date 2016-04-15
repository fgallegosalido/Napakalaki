#encoding: utf-8

require_relative 'bad_consequence.rb'
require_relative 'monster.rb'
require_relative 'prize.rb'
require_relative 'referee.rb'
require_relative 'treasure_kind.rb'

module NapakalakiGame
  r = Referee.getInstance(4)
  puts r.nextNumber
  monsters = Array.new

  badConsequence = BadConsequence.newLevelSpecificTreasures("Pierdes tu armadura visible y otra oculta", 0,
                                                            [TreasureKind::ARMOR], [TreasureKind::ARMOR])
  prize = Prize.new(2, 1)
  monsters << Monster.new("3 Byakhees de bonanza", 8, badConsequence, prize)

  badConsequence = BadConsequence.newLevelSpecificTreasures("Embobados con el lindo primigenio te descartas de tu casco visible",
                                                            0, [TreasureKind::HELMET],Array.new)
  prize = Prize.new(1, 1)
  monsters << Monster.new("Chibithulhu", 2, badConsequence, prize)

  badConsequence = BadConsequence.newLevelSpecificTreasures("El primordial bostezo contagioso. Pierdes el calzado visible", 0,
                                                            [TreasureKind::SHOES],Array.new)
  prize = Prize.new(1, 1)
  monsters << Monster.new("El sopor de Dunwich", 2, badConsequence, prize)

  puts Monster.getNumberOfMonsters
end
