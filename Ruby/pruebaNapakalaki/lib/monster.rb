# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

#encoding: utf-8

class Monster
  def initialize(name, combatLevel, prize, bc)
    @name = name
    @combatLevel = combatLevel
    @prize = prize
    @bc = bc
  end
  
  attr_reader :name, :combatLevel, :prize, :bc
  
  def to_s
    "\nName = #{@name} \nCombatLevel = #{@combatLevel} \nPrize: \n  #{@prize.to_s} \nBadConsequence: \n  #{@bc.to_s}"
  end
  
end
