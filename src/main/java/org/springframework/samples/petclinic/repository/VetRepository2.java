package org.springframework.samples.petclinic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.samples.petclinic.vet.Vet;

public interface VetRepository2 extends JpaRepository<Vet, Integer> {
	List<Vet> findByLastName(String lastname);

	List<Vet> findByLastNameOrFirstName(String lastname, String firstname);

	List<Vet> findByLastNameAndFirstName(String lastname, String firstname);

	@Query("SELECT DISTINCT v FROM Vet v JOIN FETCH v.specialties s WHERE s.name = :name")
	List<Vet> findBySpeciality(@Param("name") String speciality);

	Vet findDistinctByLastName(String lastname);
}
