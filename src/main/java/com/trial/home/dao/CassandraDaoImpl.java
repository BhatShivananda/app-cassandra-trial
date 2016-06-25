/**
 * 
 */
package com.trial.home.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.datastax.driver.mapping.MappingManager;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.trial.entities.Cache;
import com.trial.entities.SSAUser;

/**
 * @author z078713
 *
 */
@Repository
public class CassandraDaoImpl implements CassandraDao {
	
	Logger LOGGER = LoggerFactory.getLogger(CassandraDaoImpl.class);
	
	private final MappingManager mappingManager;
	
	@Autowired
	public CassandraDaoImpl(MappingManager mappingManager) {
		this.mappingManager = mappingManager;
	}

	@Override
	public void save() {
		
		SSAUser user = getUserObject();
		Gson gson = new Gson();
		Cache cache = new Cache();
		cache.setKey("1234");
		
		long startJsonconversionTime = new Date().getTime();		
		cache.setValue(gson.toJson(user));
		long endJsonConversionTime = new Date().getTime();
		LOGGER.info("conversion in --- "+ (endJsonConversionTime - startJsonconversionTime));
		
		long startTime = new Date().getTime();
		mappingManager.mapper(Cache.class).save(cache);
		long endTime = new Date().getTime();
		LOGGER.info("insert statement executed in --- "+ (endTime - startTime));
	}

	@Override
	public Cache fetch() {
		long startTime = new Date().getTime();
		Cache cache = mappingManager.mapper(Cache.class).get("1234");
		long endTime = new Date().getTime();
		LOGGER.info("select statement executed in --- "+ (endTime - startTime));
		
		long startJsonconversionTime = new Date().getTime();	
		ObjectMapper mapper = new ObjectMapper();
		try {
			SSAUser user = mapper.readValue(cache.getValue(), SSAUser.class);
			long endJsonConversionTime = new Date().getTime();
			LOGGER.info("conversion (GET) in --- "+ (endJsonConversionTime - startJsonconversionTime));
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cache;
	}
	
	private SSAUser getUserObject() {
		ObjectMapper mapper = new ObjectMapper();
		InputStream is = SSAUser.class.getResourceAsStream("/user.json");
		try {
			return mapper.readValue(is, SSAUser.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
