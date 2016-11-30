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
    m = @currentMonster;
    combat = @currentPlayer.combat(m)
    @dealer.giveMonsterBack(m)
    return combat
  end
  
  def discardVisibleTreasures(tr_vis)
    
  end
  
  def discardHiddenTreasures(tr_hid)
    tr_hid.each do |descartar|
      @currentPlayer.discardHiddenTreasures(descartar)
      @dealer.giveTreasuresBack(descartar)
    end
  end
  
  def makeTreasuresVisible(tr)
    tr.each do |t|
      @currentPlayer.makeTreasureVisible(t)
    end
  end
  
  def initGame(players)
    initPlayers(players)
    setEnemies
    @dealer.initCards
    nextTurn
  end

  def nextTurn
    stateOK= nextTurnAllowed
    stateOK= @currentPlayer.validState
        
    if(stateOK)
      @currentMonster = @dealer.nextMonster
      @currentPlayer = nextPlayer
      dead = @currentPlayer.isDead
      if(dead)
          @currentPlayer.initTreasures
      end
    end

    return stateOK;
  end
  
  def endOfGame(result)
    if result == result.WINGAME
      return true
    end
    return false
  end
  
  private
  def initPlayers(names)
    
  end
  
  def nextPlayer
    index_next = 0
    n_pl = null
    if @currentPlayer == null
      index_next = rand(players.size - 1)
      n_pl = players[index_next]
    else
      index_next = players.index(@currentPlayer)
      if index_next == @players.size
          index_next = 0
      else
          index_next++
      end
    end
    
    n_pl = @players[index_next]
    @currentPlayer = n_pl
    return n_pl
    
  end
  
  def nextTurnAllowed
    
  end
  
  def setEnemies
    no_asignado = true;
    @players.each_with_index do |item, index|
      while no_asignado
        aleatorio = rand(@players.size + 1)
        if(aleatorio != index)
          @players[index].setEnemy(@players[aleatorio])
          no_asignado = false
        end
      end
      no_asignado = true
    end
  end
end
