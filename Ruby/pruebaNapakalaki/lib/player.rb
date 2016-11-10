# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

class Player
  def combat(monstruo)
    
  end
  
  def makeTreasureVisible(tesoro)
    
  end
  
  def discardVisibleTreasure(tesoro)
    
  end
  
  def discardHiddenTreasure(tesoro)
    
  end
  
  def validState
    if(@hiddenTreasures.size < 5 && @pendingBadConsequence == false)
      return true
    return false
  end
  
  def initTreasures
    
  end
  
  attr_reader :level
  
  def stealTreasure
    
  end
  
  def setEnemy(jugador)
    @enemy = jugador
  end
  
  def self.giveMeATreasure
    
  end
  
  attr_reader :canISteal
  
  def self.canYouGiveMeATreasure
    if(@visibleTreasures.size)
      return true
    end
    
    return false
  end
  
  def self.haveStolen
    @canISteal = false
  end
  
  def discardAllTreasures
    
  end
end
