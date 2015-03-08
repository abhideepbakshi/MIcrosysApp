package com.microsys.app.config;

import org.junit.Test;

import com.microsys.app.config.util.ConfigException;


public class SystemConfigTest {

	@Test
	public void testSystemConfig() throws ConfigException{
		
		final SystemConfig systemConfig = new SystemConfig();
		System.out.println(systemConfig.getProperty("payroll.database.schema"));
		
		final SystemConfig systemConfig2 = new SystemConfig();
		System.out.println(systemConfig2.getProperty("payroll.database.password"));
		
		
	}
}
