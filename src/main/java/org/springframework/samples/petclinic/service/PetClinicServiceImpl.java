package org.springframework.samples.petclinic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.repository.VetRepository2;
import org.springframework.samples.petclinic.vet.Vet;
import org.springframework.stereotype.Service;

@Service
public class PetClinicServiceImpl implements PetClinicService {
//Los metodos que devuelven los objetos directos de repository deverian devolver una copia que
// no esten relacionados con la base de datos.

	@Autowired
	private VetRepository2 vetRepository;

	@Override
	public List<Vet> findVetsByLastName(String lastname) {
		return vetRepository.findByLastName(lastname);
	}

	@Override
	public List<Vet> findVetsByLastNameOrFirstName(String lastname, String firstname) {
		return vetRepository.findByLastNameOrFirstName(lastname, firstname);
	}

	@Override
	public List<Vet> findVetsByLastNameAndFirstName(String lastname, String firstname) {
		return vetRepository.findByLastNameAndFirstName(lastname, firstname);
	}

	@Override
	public Vet findVetByLastName(String lastname) {
		return vetRepository.findDistinctByLastName(lastname);
	}

}
