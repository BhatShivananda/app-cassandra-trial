package com.trial.home.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trial.entities.Cache;
import com.trial.home.dao.CassandraDao;


/**
 * @author z078713
 *
 */
@Service
public class AppServiceImpl implements AppService {

	Logger LOGGER = LoggerFactory.getLogger(AppServiceImpl.class);
	
	private final CassandraDao cassandraDao;
	
	@Autowired
	public AppServiceImpl(CassandraDao cassandraDao) {
		this.cassandraDao = cassandraDao;
	}

	@Override
	public Cache processRequest() {
		cassandraDao.save();
		return cassandraDao.fetch();
	}
	

}
