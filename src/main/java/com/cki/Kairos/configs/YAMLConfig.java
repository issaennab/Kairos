package com.cki.Kairos.configs;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties
public class YAMLConfig {

	private String name;
	private String environment;
	private List<String> servers = new ArrayList<>();

	private String connectToServerName;
	private String onUrl;
	private String qcUrl;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEnvironment() {
		return environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}

	public List<String> getServers() {
		return servers;
	}

	public void setServers(List<String> servers) {
		this.servers = servers;
	}

	public String getQcUrl() {
		return qcUrl;
	}

	public void setQcUrl(String qcUrl) {
		this.qcUrl = qcUrl;
	}

	public String getOnUrl() {
		return onUrl;
	}

	public void setOnUrl(String onUrl) {
		this.onUrl = onUrl;
	}

	public String getConnectToServerName() {
		return connectToServerName;
	}

	public void setConnectToServerName(String connectToServerName) {
		this.connectToServerName = connectToServerName;
	}

	

}
