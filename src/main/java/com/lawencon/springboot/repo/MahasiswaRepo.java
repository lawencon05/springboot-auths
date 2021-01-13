package com.lawencon.springboot.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lawencon.springboot.model.Mahasiswa;

@Repository
public interface MahasiswaRepo extends JpaRepository<Mahasiswa, Long> {

	Mahasiswa findByNim(String nim) throws Exception;
	
	Mahasiswa findByNimAndNama(String nim, String nama) throws Exception;
}
