package com.trial.home.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.HostDistance;
import com.datastax.driver.core.PoolingOptions;
import com.datastax.driver.core.ProtocolVersion;
import com.datastax.driver.core.Session;
import com.datastax.driver.mapping.MappingManager;

/**
 * @author z078713
 *
 */
@Configuration
public class ConnectionConfiguration {

	@Bean
	public Cluster cluster() {
		return Cluster
				.builder()
				.addContactPoint(
						"127.0.0.1")
				.withPoolingOptions(poolingOptions())
				.withProtocolVersion(ProtocolVersion.V3)
				.build();
	}

	@Bean
	protected PoolingOptions poolingOptions() {
		PoolingOptions options = new PoolingOptions();
		options.setCoreConnectionsPerHost(HostDistance.LOCAL, 1);
		options.setMaxConnectionsPerHost(HostDistance.LOCAL, 8);
		options.setMaxRequestsPerConnection(HostDistance.LOCAL, 2560);
		return options;
	}

	@Bean
	public Session session() {
		return cluster().connect("cwl_local");
	}

	@Bean
	public MappingManager mappingMananger() {
		return new MappingManager(session());
	}

}