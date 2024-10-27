package com.api.socialMaker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.api.socialMaker.repositories")
@EnableElasticsearchRepositories(basePackages = "com.api.socialMaker.repositories.elasticsearch")  // Elasticsearch repository'ler için
public class SocialMakerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SocialMakerApplication.class, args);
	}

}
