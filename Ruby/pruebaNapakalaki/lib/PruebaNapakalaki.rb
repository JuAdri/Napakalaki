#encoding: utf-8

# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

require_relative "prize.rb"
require_relative "monster.rb"
require_relative "bad_consequence.rb"
require_relative "treasure_kind.rb"

  
class PruebaNapakalaki
  
  @@monsters = Array.new
  
  def self.level10
    array = []
    @@monsters.each do |monster|
      if(monster.combatLevel > 10)
        array << monster
      end
    end
    return array
  end
  
  def self.lostLevel
    array = []
    @@monsters.each do |monster|
      if(monster.bc.levels != 0 && monster.bc.nVisibleTreasures == 0 && monster.bc.nHiddenTreasures == 0)
        array << monster
      end
    end
    return array
  end
  
  def self.buenRollo
    array = []
    @@monsters.each do |monster|
      if(monster.prize.level > 1)
        array << monster
      end
    end
    return array
  end
  
  def self.lostSpecific(tr)
    array = []
    i = 0
    @@monsters.each do |monster|
      if(monster.bc.specificVisibleTreasures.size > 0)
        monster.bc.specificVisibleTreasures.each do |comp|
          if(comp == tr)
            array << monster
          end
        end
      end
      if(monster.bc.specificHiddenTreasures.size > 0)
        monster.bc.specificHiddenTreasures.each do |comp|
          if(comp == tr)
            array << monster
          end
        end
      end
      i = i +1
    end
    return array
  end
    
  # Monstruo 10 -> Los hondos
  prize = Prize.new(2, 1)
  badConsequence = BadConsequence.newDeath('Estos monstruos resultan bastante superficiales y te aburren mortalmente. Estas muerto')
  @@monsters << Monster.new('Los hondos', 8, prize, badConsequence)
  
  # Monstruo 11 -> Semillas Cthulhu
  prize = Prize.new(2, 1)
  badConsequence = BadConsequence.newLevelNumberOfTreasures('Pierdes 2 niveles y 2 tesoros ocultos.', 2, 0, 2)
  @@monsters << Monster.new('Semillas Cthulhu', 4, prize, badConsequence)
  
  # Monstruo 12 -> Dameargo
  prize = Prize.new(2, 1)
  badConsequence = BadConsequence.newLevelSpecificTreasures('Te intentas escaquear. Pierdes una mano visible.', 0, [TreasureKind::ONEHAND], Array.new)
  @@monsters << Monster.new('Dameargo', 1, prize, badConsequence)
  
  # Monstruo 13 -> Pollipólipo volante
  prize = Prize.new(2, 1)
  badConsequence = BadConsequence.newLevelNumberOfTreasures('Da mucho asquito. Pierdes 3 niveles.', 3, 0, 0)
  @@monsters << Monster.new('Pollipólipo volante', 3, prize, badConsequence)
  
  # Monstruo 14 -> Yskhtihyssg-Goth
  prize = Prize.new(3, 1)
  badConsequence = BadConsequence.newDeath('No le hace gracia que pronuncien mal su nombre. Estas muerto')
  @@monsters << Monster.new('Yskhtihyssg-Goth', 14, prize, badConsequence)
  
  # Monstruo 15 -> Familia feliz
  prize = Prize.new(3, 1)
  badConsequence = BadConsequence.newDeath('La familia te atrapa. Estás muerto.')
  @@monsters << Monster.new('Familia feliz', 1, prize, badConsequence)
  
  # Monstruo 16 -> Roboggoth
  prize = Prize.new(2, 1)
  badConsequence = BadConsequence.newLevelSpecificTreasures('La quinta directiva primaria te obliga a perder 2 niveles y un tesoro 2 manos visible', 2, [TreasureKind::BOTHHAND], Array.new)
  @@monsters << Monster.new('Roboggoth', 8, prize, badConsequence)
  
  # Monstruo 17 -> El espía sordo
  prize = Prize.new(1, 1)
  badConsequence = BadConsequence.newLevelSpecificTreasures('Te asusta en la noche. Pierdes un casco visible.', 0, [TreasureKind::HELMET], Array.new)
  @@monsters << Monster.new('El espía sordo', 5, prize, badConsequence)
  
  # Monstruo 18 -> Tongue
  prize = Prize.new(2, 1)
  badConsequence = BadConsequence.newLevelNumberOfTreasures('Menudo susto te llevas. Pierdes 2 niveles y 5 tesoros visibles.', 2, 5, 0)
  @@monsters << Monster.new('Tongue', 19, prize, badConsequence)
  
  #level10.each do |monster|
  #  puts monster.to_s
  #end
  
  #lostLevel.each do |monster|
  #  puts monster.to_s
  #end
  
  #buenRollo.each do |monster|
  #  puts monster.to_s
  #end
  
  lostSpecific(TreasureKind::HELMET).each do |monster|
    puts monster.to_s
  end
end
