# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.

#encoding: utf-8

require_relative 'Treasure.rb'

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
    "Text = #{@text} \n  Levels = #{@levels} \n  VisibleObjects = #{@nVisibleTreasures} \n  HiddenObjects = #{@nHiddenTreasures} \n  Death = #{@death} \n  SpecificHiddenObjects = #{@specificHiddenTreasures} \n  SpecificVisibleObjects = #{@specificVisibleTreasures}"
  end
  
  def substractVisibleTreasure(t)
    @specificVisibleTreasures.delete(t.getType)
  end
  
  def substractHiddenTreasure(t)
    @specificHiddenTreasures.delete(t.getType)
  end
  
  def adjustToFitTreasureLists(v, h)
    pn_vis = v.length
    pn_hid = h.length
        
    bad_ret = BadConsequence.new(text, levels, specificVisibleTreasures, specificHiddenTreasures )

    if !isEmpty
      if nHiddenTreasures == 0 && nVisibleTreasures == 0
        insertado = false;

        sp_v = Array.new
        sp_h = Array.new

        specificVisibleTreasures.each do |spvi|
          insertado = false;
          spvi.each do spvp
            if !insertado
              if spvi == spvp.getType
                if !sp_v.contains(spvi)
                  sp_v.push(spvi)
                  insertado = true
                end
              end
            end
          end
        end

        specificHiddenTreasures.each do |sphi|
          insertado = false;
          h.each do |sphp|
            if !insertado
              if sphi == sphp.getType
                if !sp_h.contains(sphi)
                  sp_h.push(sphi)
                  insertado = true
                end
              end
            end
          end
        end
        bad_ret.specificVisibleTreasures = sp_v
        bad_ret.specificHiddenTreasures = sp_h
      else
        if(pn_vis < nVisibleTreasures)
            bad_ret.nVisibleTreasures = pn_vis
        end

        if(pn_hid < nHiddenTreasures)
            bad_ret.nHiddenTreasures = pn_hid
        end
      end
      return bad_ret
    end
    return this
  end
  
end
