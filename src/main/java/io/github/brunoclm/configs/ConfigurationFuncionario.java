package io.github.brunoclm.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.github.brunoclm.model.Funcionario;

@Configuration
public class ConfigurationFuncionario {
	
	@Bean(name = "gerente")
	public Funcionario funcGerente() {
		return new Funcionario() {
			@Override
			public String tipoDeFuncionario() {
				return "Gerente";
			}
		};
	}
	
	@Bean(name = "operador")
	public Funcionario funcOperador() {
		return new Funcionario() {
			@Override
			public String tipoDeFuncionario() {
				return "Operador";
			}
		};
	}

}
