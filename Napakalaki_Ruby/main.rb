#encoding: utf-8
require_relative 'prize.rb'
require_relative 'bad_consequence.rb'
require_relative 'monster.rb'
require_relative 'treasure_kind.rb'

module Napakalaki
  class PruebaNapakalaki
    def self.more10CombatLevel(monsterArray)
      monsterArray.each do |element|
        if element.combatLevel > 10
          puts element.to_s
        end
      end
    end

    def self.justLevelLose(monsterArray)
      monsterArray.each do |element|
        if (element.badConsequence.nVisibleTreasures == 0) && (element.badConsequence.nHiddenTreasures == 0)
          puts element.to_s
        end
      end
    end

    def self.more1LevelPrize(monsterArray)
      monsterArray.each do |element|
        if element.prize.level > 1
          puts element.to_s
        end
      end
    end

    def self.specificTreasureLose(monsterArray)
      monsterArray.each do |element|
        if element.badConsequence.nVisibleTreasures < 0
          puts element.to_s
        end
      end
    end

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

    badConsequence = BadConsequence.newLevelSpecificTreasures("Te atrapan para llevarte de fiesta y te dejan caer en mitad "\
                                                              + "del vuelo. Descarta 1 mano visible y 1 mano oculta", 0,
                                                              [TreasureKind::ONEHAND], [TreasureKind::ONEHAND])
    prize = Prize.new(4, 1)
    monsters << Monster.new("Ángeles de la noche ibicenca", 14, badConsequence, prize)

    badConsequence = BadConsequence.newLevelNumberOfTreasures("Pierdes todos tus tesoros visibles", 0, 10, 0)
    prize = Prize.new(3, 1)
    monsters << Monster.new("El gorrón en el umbral", 10, badConsequence, prize)

    badConsequence = BadConsequence.newLevelSpecificTreasures("Pierdes la armadura visible", 0,
                                                              [TreasureKind::ARMOR], Array.new)
    prize = Prize.new(2, 1)
    monsters << Monster.new("H.P. Munchcraft", 6, badConsequence, prize)

    badConsequence = BadConsequence.newLevelSpecificTreasures("Sientes bichos bajo la ropa. Descarta la armadura visible", 0,
                                                              [TreasureKind::ARMOR], Array.new)
    prize = Prize.new(1, 1)
    monsters << Monster.new("Bichgooth", 2, badConsequence, prize)

    badConsequence = BadConsequence.newLevelNumberOfTreasures("Pierdes 5 niveles y 3 tesoros visibles", 5, 3, 0)
    prize = Prize.new(4, 2)
    monsters << Monster.new("El rey de la rosa", 13, badConsequence, prize)

    badConsequence = BadConsequence.newLevelNumberOfTreasures("Toses los pulmones y pierdes 2 niveles", 2, 0, 0)
    prize = Prize.new(1, 1)
    monsters << Monster.new("La que redacta en las tinieblas", 2, badConsequence, prize)

    badConsequence = BadConsequence.newDeath("Estos monstruos resultan bastante superficiales y "\
                                              + "te aburren mortalmente. Estás muerto")
    prize = Prize.new(2, 1)
    monsters << Monster.new("Los hondos", 8, badConsequence, prize)

    badConsequence = BadConsequence.newLevelNumberOfTreasures("Pierdes 2 niveles y 2 tesoros ocultos", 2, 0, 2)
    prize = Prize.new(2, 1)
    monsters << Monster.new("Semillas Cthulhu", 4, badConsequence, prize)

    badConsequence = BadConsequence.newLevelSpecificTreasures("Te intentas escaquear. Pierdes una mano visible", 0,
                                                              [TreasureKind::ONEHAND], Array.new)
    prize = Prize.new(2, 1)
    monsters << Monster.new("Dameargo", 1, badConsequence, prize)

    badConsequence = BadConsequence.newLevelNumberOfTreasures("Da mucho asquito. Pierdes 3 niveles", 3, 0, 0)
    prize = Prize.new(1, 1)
    monsters << Monster.new("Pollipólipo volante", 3, badConsequence, prize)

    badConsequence = BadConsequence.newDeath("No le hace gracia que pronuncien mal su nombre. Estás muerto")
    prize = Prize.new(3, 1)
    monsters << Monster.new("Yskhtihyssg-Goth", 12, badConsequence, prize)

    badConsequence = BadConsequence.newDeath("La familia te atrapa. Estás muerto")
    prize = Prize.new(4, 1)
    monsters << Monster.new("Familia feliz", 1, badConsequence, prize)

    badConsequence = BadConsequence.newLevelSpecificTreasures("La quinta directiva primaria te obliga a perder 2 "\
                                                              + "niveles y un tesoro 2 manos visible", 2,
                                                              [TreasureKind::BOTHHANDS], Array.new)
    prize = Prize.new(2, 1)
    monsters << Monster.new("Roboggoth", 8, badConsequence, prize)

    badConsequence = BadConsequence.newLevelSpecificTreasures("Te asusta en la noche. Pierdes un casco visible", 0,
                                                              [TreasureKind::HELMET], Array.new)
    prize = Prize.new(1, 1)
    monsters << Monster.new("El espia", 5, badConsequence, prize)

    badConsequence = BadConsequence.newLevelNumberOfTreasures("Menudo susto te llevas. Pierdes 2 niveles y 5 tesoros visibles", 2, 5, 0)
    prize = Prize.new(1, 1)
    monsters << Monster.new("El lenguas", 20, badConsequence, prize)

    badConsequence = BadConsequence.newLevelSpecificTreasures("Te faltan manos para tanta cabeza. "\
                                                              + "Pierdes 3 niveles y tus tesoros visibles de las manos", 3,
                                                              [TreasureKind::ONEHAND, TreasureKind::BOTHHANDS], Array.new)
    prize = Prize.new(1, 1)
    monsters << Monster.new("Bicéfalo", 20, badConsequence, prize)

    puts "Más de nivel 10 de combate:\n\n"
    more10CombatLevel(monsters)
    puts "Solo pérdida de niveles:\n\n"
    justLevelLose(monsters)
    puts "Más de 1 nivel de buen rollo:\n\n"
    more1LevelPrize(monsters)
    puts "Pérdida de algún tipo de tesoros:\n\n"
    specificTreasureLose(monsters)
  end
end
