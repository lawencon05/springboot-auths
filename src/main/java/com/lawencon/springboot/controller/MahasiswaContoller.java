package com.lawencon.springboot.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.lawencon.springboot.model.Mahasiswa;
import com.lawencon.springboot.model.Universitas;
import com.lawencon.springboot.service.MahasiswaService;

/**
 * @author lawencon05
 */
@RestController
@RequestMapping("/mhs")
public class MahasiswaContoller {

	@Autowired
	private MahasiswaService mahasiswaService;

	@GetMapping("all")
	public ResponseEntity<?> getAllMhs() {
		List<Mahasiswa> listMhs = new ArrayList<>();
		try {
			listMhs = mahasiswaService.getAllMhsCustom();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(listMhs, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<?> getMhs(@RequestParam("id") String id, @RequestParam("name") String name) {
		Long realId = Long.valueOf(id);
		return new ResponseEntity<>("Get data : " + realId + " with " + name, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getMhsPath(@PathVariable("id") String id) {
		try {
			Long realId = Long.valueOf(id);
			Mahasiswa m = new Mahasiswa();
			m.setNim("1111");
			m.setNama("Iqbal");

			Universitas u = new Universitas();
			u.setId(1L);

			m.setUniversitas(u);

			m.setWaktuMasuk(LocalDate.now());
			m.setWaktuMasukTime(LocalDateTime.now());

			// mahasiswaService.insert(m);
			// m = mahasiswaService.getMhsByNimAndNama("1111", "Iqbal2");

			// m.setNama("Iqbal2");
			// mahasiswaService.update(m);

			// mahasiswaService.delete(4L);
			List<Mahasiswa> listMhs = mahasiswaService.getAllMhsCustom();
			return new ResponseEntity<>(listMhs, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PostMapping
	public ResponseEntity<?> insert(@RequestBody String body) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			mapper.registerModule(new JavaTimeModule()); // for localdate or localdatetime
			Mahasiswa mhs = mapper.readValue(body, Mahasiswa.class);
			mahasiswaService.insert(mhs);
			return new ResponseEntity<>(mhs, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Failed", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
