# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

class Napakalaki
  include Singleton
  
  attr_reader :currentPlayer, :currentMonster
  
  def initialize
    @currentPlayer= Player.new
    @players= Array.new
    @dealer= CardDealer.new
    @currentMonster= Monster.new
  end
  
  def self.getInstance
    return instance
  end
  
  def developCombat
  end
  
  def discarfVisibleTreasures(tr_vis)
    
  end
  
  def discarfHiddenTreasures(tr_hid)
    
  end
  
  def makeTreasuresVisible(tr_vis)
    
  end
  
  def initGame(players)
    
  end

  def nextTurn
  end
  
  def endOfGame(result)
    
  end
  
  private
  def initPlayers(names)
    
  end
  
  def nextPlayer
    
  end
  
  def nextTurnAllowed
    
  end
  
  def setEnemies
    
  end
  
  
end
