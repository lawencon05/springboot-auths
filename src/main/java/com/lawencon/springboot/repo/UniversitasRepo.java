package com.lawencon.springboot.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lawencon.springboot.model.Universitas;

/*
 * @author lawencon05
 */

@Repository
public interface UniversitasRepo extends JpaRepository<Universitas, Long> {

}
