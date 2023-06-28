package com.dustdrive.infodustdrive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoTemplate;

@SpringBootApplication
public class InfoDustdriveApplication {

	public static void main(String[] args) {
		SpringApplication.run(InfoDustdriveApplication.class, args);
	}

}
