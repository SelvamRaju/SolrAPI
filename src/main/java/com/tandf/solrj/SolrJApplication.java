package com.tandf.solrj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
//@EnableMongoRepositories(basePackages="com.tandf.solrj.repository")
public class SolrJApplication {

	public static void main(String[] args) {
		SpringApplication.run(SolrJApplication.class, args);
	}
}
