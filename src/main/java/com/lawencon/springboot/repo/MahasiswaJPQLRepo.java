package com.lawencon.springboot.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lawencon.springboot.model.Mahasiswa;

@Repository
public interface MahasiswaJPQLRepo extends JpaRepository<Mahasiswa, Long> {
	
	Mahasiswa findByNim(String nim) throws Exception;
	
	Mahasiswa findByNimAndNama(String nim, String nama) throws Exception;

	@Modifying
	@Query(value = "DELETE FROM Mahasiswa WHERE id = ?1 ")
	void delete(Long id) throws Exception;

	@Query(value = "FROM Mahasiswa WHERE id = ?1 ")
	Mahasiswa getMhsById(Long id) throws Exception;

	@Query(value = "FROM Mahasiswa ")
	List<Mahasiswa> getAllMhs() throws Exception;
	
	@Query(value = "SELECT m, u.nama FROM Mahasiswa m "
			+ " INNER JOIN m.universitas u ")
	List<Mahasiswa> getAllMhsCustom() throws Exception;
}
