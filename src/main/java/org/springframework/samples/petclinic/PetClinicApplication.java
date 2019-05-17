/*
 * Copyright 2002-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.samples.petclinic;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.samples.petclinic.repository.SpecialtyRepository;
import org.springframework.samples.petclinic.repository.VetRepository2;
import org.springframework.samples.petclinic.vet.Vet;

/**
 * PetClinic Spring Boot Application.
 * 
 * @author Dave Syer
 *
 */
@SpringBootApplication
public class PetClinicApplication {

	private static final Logger log = LoggerFactory.getLogger(PetClinicApplication.class);

	@Autowired
	private VetRepository2 vetRepo;

	@Autowired
	private SpecialtyRepository speRepo;

	public static void main(String[] args) throws Exception {
		SpringApplication.run(PetClinicApplication.class, args);

	}

	@Bean
	public CommandLineRunner demoVetRepository(VetRepository2 vetRepository, SpecialtyRepository speRepository) {
		return (args) -> {
			log.info("*****************************************************");
			log.info("BOOTCAMP - Spring y Spring Data - vetRepository");
			log.info("*****************************************************");

			// vetRepository.sa
			Vet vet;
//			vet = new Vet();
//			vet.setFirstName("Vet1");
//			vet.setLastName("VetA");
//
//			int id = vetRepository.save(vet).getId();
//			System.out.println("Creado con la id: " + id);
//
//			vet.setFirstName("Vet2");
//			id = vetRepository.save(vet).getId();
//			System.out.println("Creado con la id: " + id);

			log.info("Buscamos por nombre/Id");
			vet = vetRepository.findByLastName("VetA").get(0);

			vet = vetRepository.findOne(13);
		
			vet = vetRepository.findDistinctByLastName("vetA");
			log.info(vet.getFirstName());

			log.info("Le añadimos una Speciality");
			vet.addSpecialty(speRepository.findOne(1));
			vetRepository.save(vet);

			log.info("BOOTCAMP - Spring y Spring Data - vetRepository");
			for (Vet vet2 : vetRepository.findAll()) {
				log.info(vet2.toString());
			}

		};
	}

}
