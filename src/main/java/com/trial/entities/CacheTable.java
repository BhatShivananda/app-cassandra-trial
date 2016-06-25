package com.trial.entities;

/**
 * @author Shivananda Bhat
 *
 */
public interface CacheTable {

  String NAME = "cache";

  public interface Columns {
    String KEY   = "key";
    String VALUE = "value";
  }
}
