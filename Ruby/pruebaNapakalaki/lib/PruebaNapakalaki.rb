<<<<<<< HEAD
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
    
  # Monstruo 1 -> Byakhees de bonanza
  prize = Prize.new(2, 1)
  bad_consequence = BadConsequence.newLevelSpecificTreasures('Pierdes tu armadura visible y otra oculta', 0, [TreasureKind::ARMOR], [TreasureKind::ARMOR])
  @@monsters << Monster.new('Byakhees de bonanza', 8, prize, bad_consequence)
  
  # Monstruo 2 -> Tenochtitlan
  prize = Prize.new(1, 1)
  bad_consequence = BadConsequence.newLevelSpecificTreasures('Embobados con el lindo primigenio te descartas de tu casco visible.', 0, [TreasureKind::HELMET], Array.new)
  @@monsters << Monster.new('Tenochtitlan', 2, prize, bad_consequence)
  
  # Monstruo 3 -> El sopor de dunwich
  prize = Prize.new(1, 1)
  bad_consequence = BadConsequence.newLevelSpecificTreasures('Pierdes tu armadura visible y otra oculta.', 0, [TreasureKind::SHOES], Array.new)
  @@monsters << Monster.new('El sopor de dunwich', 2, prize, bad_consequence)
  
  # Monstruo 4 -> DEMONIOS DE MAGALUF
  prize = Prize.new(4, 1)
  bad_consequence = BadConsequence.newLevelSpecificTreasures('Te atrapan para llevarte de fiesta y te dejan caer en mitad del vuelo. Descarta una mano visible y una mano oculta.', 0, [TreasureKind::ONEHAND], [TreasureKind::ONEHAND])
  @@monsters << Monster.new('Demonios de Magaluf', 2, prize, bad_consequence)
  
 # Monstruo 5 -> EL GORRON DEL UMBRAL
  prize = Prize.new(3, 1)
  bad_consequence = BadConsequence.newLevelNumberOfTreasures('Pierdes todos tus tesoros visibles.', 0, 0, 0 )
  @@monsters << Monster.new('Demonios de Magaluf', 2, prize, bad_consequence)
  
  # Monstruo 6 -> H.P Munchcraft
  prize = Prize.new(2, 1)
  bad_consequence = BadConsequence.newLevelSpecificTreasures('Pierdes la armadura visible.', 0, [TreasureKind::ARMOR], Array.new)
  @@monsters << Monster.new('H.P. Munchcraft', 6, prize, bad_consequence)
  
  # Monstruo 7 -> Necrofago
  prize = Prize.new(1, 1)
  bad_consequence = BadConsequence.newLevelSpecificTreasures('Sientes bichos bajo la ropa. Descarta la armadura visible.', 0, [TreasureKind::ARMOR], Array.new)
  @@monsters << Monster.new('Necrofago', 13, prize, bad_consequence)
  
  # Monstruo 8 -> El rey de rosado
  prize = Prize.new(3, 2)
  bad_consequence = BadConsequence.newLevelNumberOfTreasures('Pierdes 5 niveles y 3 tesoros visibles.', 5, 3, 0)
  @@monsters << Monster.new('El rey de rosado', 11, prize, bad_consequence)
  
  # Monstruo 9 -> FLECHER
  prize = Prize.new(1, 1)
  bad_consequence = BadConsequence.newLevelNumberOfTreasures('Toses los pulmones y pierdes 2 niveles.', 2, 0, 0)
  @@monsters << Monster.new('Flecher', 2, prize, bad_consequence)
  
  # Monstruo 10 -> Los hondos
  prize = Prize.new(2, 1)
  bad_consequence = BadConsequence.newDeath('Estos monstruos resultan bastante superficiales y te aburren mortalmente. Estas muerto')
  @@monsters << Monster.new('Los hondos', 8, prize, bad_consequence)
  
  # Monstruo 11 -> Semillas Cthulhu
  prize = Prize.new(2, 1)
  bad_consequence = BadConsequence.newLevelNumberOfTreasures('Pierdes 2 niveles y 2 tesoros ocultos.', 2, 0, 2)
  @@monsters << Monster.new('Semillas Cthulhu', 4, prize, bad_consequence)
  
  # Monstruo 12 -> Dameargo
  prize = Prize.new(2, 1)
  bad_consequence = BadConsequence.newLevelSpecificTreasures('Te intentas escaquear. Pierdes una mano visible.', 0, [TreasureKind::ONEHAND], Array.new)
  @@monsters << Monster.new('Dameargo', 1, prize, bad_consequence)
  
  # Monstruo 13 -> Pollipólipo volante
  prize = Prize.new(2, 1)
  bad_consequence = BadConsequence.newLevelNumberOfTreasures('Da mucho asquito. Pierdes 3 niveles.', 3, 0, 0)
  @@monsters << Monster.new('Pollipólipo volante', 3, prize, bad_consequence)
  
  # Monstruo 14 -> Yskhtihyssg-Goth
  prize = Prize.new(3, 1)
  bad_consequence = BadConsequence.newDeath('No le hace gracia que pronuncien mal su nombre. Estas muerto')
  @@monsters << Monster.new('Yskhtihyssg-Goth', 14, prize, bad_consequence)
  
  # Monstruo 15 -> Familia feliz
  prize = Prize.new(3, 1)
  bad_consequence = BadConsequence.newDeath('La familia te atrapa. Estás muerto.')
  @@monsters << Monster.new('Familia feliz', 1, prize, bad_consequence)
  
  # Monstruo 16 -> Roboggoth
  prize = Prize.new(2, 1)
  bad_consequence = BadConsequence.newLevelSpecificTreasures('La quinta directiva primaria te obliga a perder 2 niveles y un tesoro 2 manos visible', 2, [TreasureKind::BOTHHANDS], Array.new)
  @@monsters << Monster.new('Roboggoth', 8, prize, bad_consequence)
  
  # Monstruo 17 -> El espía sordo
  prize = Prize.new(1, 1)
  bad_consequence = BadConsequence.newLevelSpecificTreasures('Te asusta en la noche. Pierdes un casco visible.', 0, [TreasureKind::HELMET], Array.new)
  @@monsters << Monster.new('El espía sordo', 5, prize, bad_consequence)
  
  # Monstruo 18 -> Tongue
  prize = Prize.new(2, 1)
  bad_consequence = BadConsequence.newLevelNumberOfTreasures('Menudo susto te llevas. Pierdes 2 niveles y 5 tesoros visibles.', 2, 5, 0)
  @@monsters << Monster.new('Tongue', 19, prize, bad_consequence)
  
   # Monstruo 19 -> Bicefalo
  prize = Prize.new(2, 1)
  bad_consequence = BadConsequence.newLevelSpecificTreasures('Te faltan manos para tanta cabeza. Pierdes 3 niveles y tus tesoros visibles de las manos.', 3, [TreasureKind::ONEHAND], [TreasureKind::BOTHHANDS])
  @@monsters << Monster.new('Bicefalo', 21, prize, bad_consequence)
  
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
=======
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
>>>>>>> origin/master
