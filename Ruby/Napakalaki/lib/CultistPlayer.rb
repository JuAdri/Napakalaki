# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

class CultistPlayer < Player
  
  @@totalCultistPlayers = 0
  
  def initialize(player, cultist)
    super.copyPlayer(player)
    @myCultistCard = cultist
    @@totalCultistPlayers + 1;
  end
  
  def getOponentLevel(monster)
    monster.getCombatLevelAgainstCultistPlayer
  end
  
  def getCombatLevel
    combat_level= super.getCombatLevel
    return combat_level + (70*combat_level/100) + myCultistCard.getGainedLevels * totalCultistPlayers
  end
  
  def shouldConvert
    return false
  end
end
