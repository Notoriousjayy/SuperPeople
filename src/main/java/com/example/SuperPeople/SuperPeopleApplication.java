package com.example.SuperPeople;

import com.example.SuperPeople.DAO.SuperPersonRepository;
import com.example.SuperPeople.Entity.SuperPerson;
import com.example.SuperPeople.Enums.Aliance;
import com.example.SuperPeople.Enums.Gender;
import com.example.SuperPeople.Enums.Universe;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.math.BigInteger;
import java.util.List;

@SpringBootApplication
public class SuperPeopleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SuperPeopleApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(SuperPersonRepository superPersonRepository, MongoTemplate mongoTemplate){
		return args -> {
			String name = "Vegeta";
			SuperPerson superPerson = new SuperPerson(
					name,
					BigInteger.valueOf(0),
					List.of("Galick Gun", "Lucora Gun", "Big Bang Attack", "Final Flash", "Gamma Burst Flash", "Spirit Control", "Hakai","Ultra Ego", "Final Shine Attack"),
					Universe.DBZ,
					Aliance.GOOD,
					Gender.MALE,
					164,
					123
			);

			superPersonRepository.findPersonByName(name).ifPresentOrElse(superPerson1-> {
				System.out.println(superPerson + " already exists");
			}, () -> System.out.println("Inserting Super person " + superPerson));
			superPersonRepository.insert(superPerson);
		};
	}
	private void usingMongoTemplateAndQuery(SuperPersonRepository superPersonRepository, MongoTemplate mongoTemplate, String name, SuperPerson superPerson){
		Query query = new Query();
		query.addCriteria(Criteria.where("name").is(name));
		List<SuperPerson> superPeople = mongoTemplate.find(query, SuperPerson.class);
		if(superPeople.isEmpty()){
			System.out.println("Adding Super person "+ superPerson);
			superPersonRepository.insert(superPerson);
		}else{
			System.out.println(superPerson + " already exists");
		}
	}
}
