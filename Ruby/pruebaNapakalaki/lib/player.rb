# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

class Player
  @@MAXLEVEL=10
  
  attr_reader :canISteal, :level, :name
  attr_writer :enemy, :pendingBadConsequence
  
  def initialize(name_p)
    @name=name_p
    @level= 0
    @dead=true
    @canISteal= true
    @enemy= Player.new
    @hiddenTreasures= Array.new
    @visibleTreasures= Array.new
    @pendingBadConsequence= BadConsequence.new
  end
  
  private
  def bringToLife
    @dead= false
  end
  
  def getCombatLevel
    level_combat= @level
    for i in(0..@hiddenTreasures.length)
      level_combat+=hiddenTreasures[i].bonus
    end
    
    for i in(0..@visibleTreasures.length)
      level_combat+=visibleTreasures[i]
    end
    
    return level_combat
  end
  
  def incrementLevels(i)
    @level+=i
  end
  
  def decrementLevels(i)
    @level-=i
  end
  
  def applyPrize(m)
    
  end
  
  def applyBadConsequence(bc)
    
  end
  
  def canMakeTreasureVisible(t)
    
  end
  
  def howManyVisibleTreasures(t)
    n_trs=0
    @visibleTreasures.each do |v_tr|
      if(v_tr==t)
        n_trs+=1
      end
    end
    return n_trs
  end
  
  def dielfNoTreasures
    @dead=true
  end
  
  def giveMeATreasure
    
  end
  
  def canYouGiveMeATreasure
    return @visibleTreasures.length
  end
  
  def haveStolen
    @canISteal = false
  end
  
  public
  def isDead
    return @dead
  end
  
  def combat(monstruo)
    
  end
  
  def makeTreasureVisible(tesoro)
    
  end
  
  def discardVisibleTreasure(tesoro)
    
  end
  
  def discardHiddenTreasure(tesoro)
    
  end
  
  def validState
    return @hiddenTreasures.size < 5 && @pendingBadConsequence.isEmpty
  end
  
  def initTreasures
    
  end
  
  def stealTreasure
    
  end
  
  def canISteal
    return @canISteal
  end
  
  def discardAllTreasures
    
  end
end
