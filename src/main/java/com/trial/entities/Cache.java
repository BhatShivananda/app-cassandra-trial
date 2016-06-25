package com.trial.entities;

import com.datastax.driver.mapping.annotations.Column;
import com.datastax.driver.mapping.annotations.PartitionKey;
import com.datastax.driver.mapping.annotations.Table;

/**
 * @author Shivananda Bhat
 *
 */
@Table(name = CacheTable.NAME)
public class Cache {

	@PartitionKey
	@Column(name = CacheTable.Columns.KEY)
	private String key;

	@Column(name = CacheTable.Columns.VALUE)
	private String value;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
