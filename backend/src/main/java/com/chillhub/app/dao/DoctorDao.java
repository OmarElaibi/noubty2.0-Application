package com.chillhub.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.chillhub.app.entities.Doctor;
import com.chillhub.app.entities.Queuer;

@Repository
public interface DoctorDao extends JpaRepository<Doctor, Integer> {

	List<Doctor> findByDisponible(boolean dispo);
	Doctor findByRefMedicale(String refMedicale);
	Doctor findByRoom(String room);
	
	@Query(value = "SELECT q.id FROM queuer q WHERE q.fk_doctor = :id ORDER BY q.created_at DESC LIMIT 1", nativeQuery = true)
	Queuer getDoctorLatestQueuer(@Param("id") int id);
}
