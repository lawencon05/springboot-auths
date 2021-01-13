package com.lawencon.springboot.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lawencon.springboot.model.Mahasiswa;

@Repository
public interface MahasiswaNQRepo extends JpaRepository<Mahasiswa, Long> {
	
	@Query(value = "SELECT * FROM mahasiswa WHERE nim = ?1 ", nativeQuery = true)
	Mahasiswa findByNim(String nim) throws Exception;
	
	@Query(value = "SELECT * FROM mahasiswa WHERE nim = ?1 AND nama = ?2 ", nativeQuery = true)
	Mahasiswa findByNimAndNama(String nim, String nama) throws Exception;

	@Modifying
	@Query(value = "DELETE FROM mahasiswa WHERE id = ?1 ", nativeQuery = true)
	void delete(Long id) throws Exception;

	@Query(value = "SELECT * FROM mahasiswa WHERE id = ?1 ", nativeQuery = true)
	Mahasiswa getMhsById(Long id) throws Exception;

	@Query(value = "SELECT * FROM mahasiswa ", nativeQuery = true)
	List<Mahasiswa> getAllMhs() throws Exception;

	@Query(value = "SELECT m.id, m.nim, m.nama, u.id id_univ, u.nama as nama_univ, m.waktu_masuk FROM mahasiswa m "
			+ " INNER JOIN universitas u ON u.id = m.univ_id ", nativeQuery = true)
	List<Object[]> getAllMhsCustom() throws Exception;
}
