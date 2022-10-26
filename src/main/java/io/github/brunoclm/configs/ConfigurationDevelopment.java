package io.github.brunoclm.configs;

import java.net.InetAddress;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import io.github.brunoclm.annotations.ConfigDevelopment;

@ConfigDevelopment
public class ConfigurationDevelopment {
	
	@Bean(name = "applicationName")
	public String applicationName() {
		return "VendasOnline";
	}
	
	@Bean
	public CommandLineRunner executar() {
		
		return args -> {
			System.out.println("\u001B[31m" + "*******************************************************************\r\n"
					+ "*** DEVELOPMENT mode.                                           ***\r\n"
					+ "*** ^^^^^^^^^^^					                ***\r\n"
					+ "***                                                 		***\r\n"
					+ "*** IP:"+ InetAddress.getLocalHost().getHostAddress() +"                                             ***\r\n"
					+ "*******************************************************************");
		};
	}


}
