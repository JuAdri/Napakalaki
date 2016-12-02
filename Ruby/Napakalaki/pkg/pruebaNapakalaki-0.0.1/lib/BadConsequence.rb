# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

#encoding: utf-8

class BadConsequence
  private_class_method :new
  
  def initialize(aText, someLevels, someVisibleTreasures, someHiddenTreasures,someSpecificVisibleTreasures, someSpecificHiddenTreasures, death)
    @text = aText
    @levels = someLevels
    @nVisibleTreasures = someVisibleTreasures
    @nHiddenTreasures = someHiddenTreasures
    @death = death
    @specificHiddenTreasures = someSpecificHiddenTreasures
    @specificVisibleTreasures = someSpecificVisibleTreasures
  end
  
  def self.newLevelNumberOfTreasures(aText, someLevels, someVisibleTreasures, someHiddenTreasures)
    new(aText, someLevels, someVisibleTreasures, someHiddenTreasures, Array.new, Array.new, false)
  end
  
  def self.newLevelSpecificTreasures(aText, someLevels, someSpecificVisibleTreasures, someSpecificHiddenTreasures)
    new(aText, someLevels, someSpecificVisibleTreasures.length, someSpecificHiddenTreasures.size, someSpecificVisibleTreasures, someSpecificHiddenTreasures, false)
  end

  def self.newDeath(aText)
    new(aText, '', '', '', Array.new, Array.new, true)
  end
  
  def isEmpty
    return @nVisibleTreasures==0 && 
           @nHiddenTreasures==0 && 
           @specificHiddenTreasures.isEmpty && 
           @specificVisibleTreasures.isEmpty
  end
  
  attr_reader :levels, :nVisibleTreasures, :nHiddenTreasures, :specificHiddenTreasures, :specificVisibleTreasures

  def to_s
    "Text = #{@text} \n  Levels = #{@levels} \n  VisibleObjects = #{@nVisibleTreasures} \n  HiddenObjects = #{@} \n  Death = #{@death} \n  SpecificHiddenObjects = #{@specificHiddenTreasures} \n  SpecificVisibleObjects = #{@specificVisibleTreasures}"
  end
  
  def substractVisibleTreasure(t)
    specificVisibleTreasures.remove(t.getType)
  end
  
  def substractHiddenTreasure(t)
    specificHiddenTreasures.remove(t.getType)
  end
  
  def adjustToFitTreasureLists(array1_tesoros, array2_tesoros)
    
  end
  
end
