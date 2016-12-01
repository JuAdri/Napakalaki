# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

class Dice
  include Singleton
  
  attr_reader :instance
  
  def nextNumber
    return rand(6) + 1
  end
end
