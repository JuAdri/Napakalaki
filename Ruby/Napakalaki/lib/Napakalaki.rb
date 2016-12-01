# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

require 'singleton'
require_relative 'Monster.rb'
require_relative 'Player.rb'
require_relative 'CardDealer.rb'

class Napakalaki
  include Singleton
  
  def initialize
    @players = Array.new
    @currentMonster= Monster.new("", 0, nil, nil)
    @dealer= CardDealer.instance
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
  
  def initPlayers(names)
    if names.length > 0
      for i in (0..names.length-1)
        aux = Player.new(names[i])
        @players.push(aux)
      end
    end
  end
  
  def nextPlayer
    index_next = 0
    n_pl = null
    if @currentPlayer == null
      index_next = rand(@players.size - 1)
      n_pl = @players[index_next]
    else
      index_next = @players.index(@currentPlayer)
      if index_next == @players.size
          index_next = 0
      else
          index_next+=1
      end
    end
    
    n_pl = @players[index_next]
    @currentPlayer = n_pl
    return n_pl
    
  end
  
  def nextTurnAllowed
    if @currentPlayer.nil?
      return true
    end
    return @currentPlayer.validState
  end
  
  def setEnemies
    no_asignado = true
    for i in(0..@players.length-1)
      while no_asignado
        aleatorio = rand(0..@players.length-1)
        if(aleatorio != i)
          @players[i].setEnemy(@players[aleatorio])
          no_asignado = false
        end
      end
      no_asignado = true
    end
  end
  
  def developCombat
    m = @currentMonster
    combat = @currentPlayer.combat(m)
    @dealer.giveMonsterBack(m)
    return combat
  end
  
  def discardVisibleTreasures(tr_vis)
    tr_vis.each do |descartar|
      @currentPlayer.discardVisibleTreasure(descartar)
      @dealer.giveTreasuresBack(descartar)
    end
  end
  
  def discardHiddenTreasures(tr_hid)
    tr_hid.each do |descartar|
      @currentPlayer.discardHiddenTreasure(descartar)
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
  
  def getCurrentPlayer
    return @currentPlayer
  end
    
  def getCurrentMonster
    return @currentMonster
  end
  
  def nextTurn
    stateOK = nextTurnAllowed

    if stateOK
      @currentMonster = @dealer.nextMonster
      @currentPlayer = nextPlayer
      @dead = @currentPlayer.isDead
      if dead
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
  
  attr_reader :currentPlayer, :currentMonster
  private :initPlayers, :nextPlayer, :nextTurnAllowed, :setEnemies
end