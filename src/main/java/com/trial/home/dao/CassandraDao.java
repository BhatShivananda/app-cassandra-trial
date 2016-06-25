/**
 * 
 */
package com.trial.home.dao;

import com.trial.entities.Cache;

/**
 * @author z078713
 *
 */
public interface CassandraDao {

	void save();
	Cache fetch();
}
