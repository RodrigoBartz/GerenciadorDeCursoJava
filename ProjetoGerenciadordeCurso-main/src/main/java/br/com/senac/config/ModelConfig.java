package br.com.senac.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelConfig {
	@Bean
	public ModelMapper modelmapper() {
		return new ModelMapper();
	}
}
