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
end
