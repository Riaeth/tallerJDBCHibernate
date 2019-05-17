package org.springframework.samples.petclinic.service;

import java.util.List;

import org.springframework.samples.petclinic.vet.Vet;

public interface PetClinicService {
	List<Vet> findVetsByLastName(String lastname);

	List<Vet> findVetsByLastNameOrFirstName(String lastname, String firstname);

	List<Vet> findVetsByLastNameAndFirstName(String lastname, String firstname);
	
	Vet findVetByLastName(String lastname);

}
