package com.sap.olingo.jpa.processor.core.testmodel;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Transient;

import com.sap.olingo.jpa.metadata.core.edm.annotation.EdmTransient;
import com.sap.olingo.jpa.processor.core.errormodel.DummyPropertyCalculator;

@Embeddable
public class CollectionFirstLevelComplex {

  @Column(name = "\"LevelID\"")
  private Integer levelID;

  @Embedded
  private CollectionSecondLevelComplex secondLevel;

  @Transient
  @EdmTransient(requiredAttributes = { "levelID" }, calculator = DummyPropertyCalculator.class)
  private List<String> transientCollection = new ArrayList<>();

  public void setLevelID(Integer levelID) {
    this.levelID = levelID;
  }

  public void setSecondLevel(CollectionSecondLevelComplex secondLevel) {
    this.secondLevel = secondLevel;
  }

  public Integer getLevelID() {
    return levelID;
  }

  public CollectionSecondLevelComplex getSecondLevel() {
    return secondLevel;
  }
}
