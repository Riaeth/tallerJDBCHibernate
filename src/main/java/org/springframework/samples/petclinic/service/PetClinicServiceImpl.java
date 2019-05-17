package org.springframework.samples.petclinic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.repository.VetRepository2;
import org.springframework.samples.petclinic.vet.Vet;
import org.springframework.stereotype.Service;

@Service
public class PetClinicServiceImpl implements PetClinicService {

	@Autowired
	private VetRepository2 vetRepository;

	@Override
	public List<Vet> findVetsByLastName(String lastname) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Vet> findVetsByLastNameOrFirstName(String lastname, String firstname) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Vet> findVetsByLastNameAndFirstName(String lastname, String firstname) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vet findVetByLastName(String lastname) {
		// TODO Auto-generated method stub
		return null;
	}

}
