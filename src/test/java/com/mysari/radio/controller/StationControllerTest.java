/**
 * 
 */
package com.mysari.radio.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.mysari.radio.dto.ResponseDTO;
import com.mysari.radio.dto.StationDTO;
import com.mysari.radio.exception.StationException;
import com.mysari.radio.service.StationService;

/**
 * @author anuragmysari
 *
 */
@ExtendWith(SpringExtension.class)
class StationControllerTest {

	@InjectMocks
	private StationController stationController;

	@Mock
	private StationService stationService;

	private StationDTO stationDTO;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
		stationDTO = new StationDTO("123Z", "Test Radio", true, "12Z");
	}

	/**
	 * Test method for
	 * {@link com.mysari.radio.controller.StationController#findAll()}.
	 */
	@Test
	void testFindAll() {
		ResponseEntity<ResponseDTO> response = stationController.findAll();
		assertThat(response.getBody().getMessage()).isEqualTo("SUCCESS");
	}

	@Test
	void testFindAllException() {
		when(stationService.findAll()).thenThrow(new RuntimeException("error"));
		ResponseEntity<ResponseDTO> response = stationController.findAll();
		assertThat(response.getBody().getMessageCode()).isEqualTo("500");
		// Assertions.assertThrows(RuntimeException.class, () ->
		// stationController.findAll());

	}

	/**
	 * Test method for
	 * {@link com.mysari.radio.controller.StationController#addStation(com.mysari.radio.dto.StationDTO)}.
	 */
	@Test
	void testAddStation() {
		ResponseEntity<ResponseDTO> response = stationController.addStation(stationDTO);
		assertThat(response.getBody().getMessage()).isEqualTo("CREATED");
	}

	@Test
	void testAddStationException() throws StationException {
		doThrow(new RuntimeException("error")).when(stationService).addStation(Mockito.any());
		ResponseEntity<ResponseDTO> response = stationController.addStation(stationDTO);
		assertThat(response.getBody().getMessage()).isEqualTo("error");
	}

	@Test
	void testAddStationExceptionStation() throws StationException {
		doThrow(new StationException("error")).when(stationService).addStation(Mockito.any());
		ResponseEntity<ResponseDTO> response = stationController.addStation(stationDTO);
		assertThat(response.getBody().getMessageCode()).isEqualTo("400");
	}

	/**
	 * Test method for
	 * {@link com.mysari.radio.controller.StationController#removeStation(java.lang.String)}.
	 */
	@Test
	void testDelete() {
		ResponseEntity<ResponseDTO> response = stationController.removeStation("123Z");
		assertThat(response.getBody().getMessage()).isEqualTo("DELETED");
	}

	@Test
	void testDeleteStationException() throws StationException {
		doThrow(new RuntimeException("error")).when(stationService).removeStation(Mockito.any());
		ResponseEntity<ResponseDTO> response = stationController.removeStation("123Z");
		assertThat(response.getBody().getMessage()).isEqualTo("error");
	}

	@Test
	void testDeleteStationExceptionStation() throws StationException {
		doThrow(new StationException("error")).when(stationService).removeStation(Mockito.any());
		ResponseEntity<ResponseDTO> response = stationController.removeStation("123Z");
		assertThat(response.getBody().getMessageCode()).isEqualTo("400");
	}

	/**
	 * Test method for
	 * {@link com.mysari.radio.controller.StationController#update(java.lang.String, com.mysari.radio.dto.StationDTO)}.
	 */
	@Test
	void testUpdate() {
		ResponseEntity<ResponseDTO> response = stationController.update("123Z", stationDTO);
		assertThat(response.getBody().getMessage()).isEqualTo("UPDATED");
	}

	@Test
	void testUpdateStationException() throws StationException {
		doThrow(new RuntimeException("error")).when(stationService).updateStation(Mockito.any(), Mockito.any());
		ResponseEntity<ResponseDTO> response = stationController.update("123Z", stationDTO);
		assertThat(response.getBody().getMessage()).isEqualTo("error");
	}

	@Test
	void testUpdateStationExceptionStation() throws StationException {
		doThrow(new StationException("error")).when(stationService).updateStation(Mockito.any(), Mockito.any());
		ResponseEntity<ResponseDTO> response = stationController.update("123Z", stationDTO);
		assertThat(response.getBody().getMessageCode()).isEqualTo("400");
	}

	/**
	 * Test method for
	 * {@link com.mysari.radio.controller.StationController#searchByIdorName(java.lang.String)}.
	 */
	@Test
	void testSearchByIdorName() {
		ResponseEntity<ResponseDTO> response = stationController.searchByIdorName("123Z");
		assertThat(response.getBody().getMessage()).isEqualTo("SUCCESS");
	}

	@Test
	void testSearchByIdorNameException() throws StationException {
		doThrow(new RuntimeException("error")).when(stationService).findByIdorName(Mockito.any());
		ResponseEntity<ResponseDTO> response = stationController.searchByIdorName("123Z");
		assertThat(response.getBody().getMessage()).isEqualTo("error");
	}

	@Test
	void testSearchByIdorNameExceptionStation() throws StationException {
		doThrow(new StationException("error")).when(stationService).findByIdorName(Mockito.any());
		ResponseEntity<ResponseDTO> response = stationController.searchByIdorName("123Z");
		assertThat(response.getBody().getMessageCode()).isEqualTo("400");
	}

	/**
	 * Test method for
	 * {@link com.mysari.radio.controller.StationController#findHDEnabled()}.
	 */
	@Test
	void testFindHDEnabled() {
		ResponseEntity<ResponseDTO> response = stationController.findHDEnabled();
		assertThat(response.getBody().getMessage()).isEqualTo("SUCCESS");
	}

	@Test
	void testFindHDEnabledException() {
		when(stationService.findHDEnabled()).thenThrow(new RuntimeException("error"));
		ResponseEntity<ResponseDTO> response = stationController.findHDEnabled();
		assertThat(response.getBody().getMessageCode()).isEqualTo("500");
	}

	/**
	 * Test method for
	 * {@link com.mysari.radio.controller.StationController#getById(java.lang.String)}.
	 */
	@Test
	void testGetById() {
		ResponseEntity<ResponseDTO> response = stationController.getById("123Z");
		assertThat(response.getBody().getMessage()).isEqualTo("SUCCESS");
	}

	@Test
	void testGetByIdException() throws StationException {
		doThrow(new RuntimeException("error")).when(stationService).findByID(Mockito.any());
		ResponseEntity<ResponseDTO> response = stationController.getById("123Z");
		assertThat(response.getBody().getMessage()).isEqualTo("error");
	}

	@Test
	void testGetByIdExceptionStation() throws StationException {
		doThrow(new StationException("error")).when(stationService).findByID(Mockito.any());
		ResponseEntity<ResponseDTO> response = stationController.getById("123Z");
		assertThat(response.getBody().getMessageCode()).isEqualTo("400");
	}

	/**
	 * Test method for
	 * {@link com.mysari.radio.controller.StationController#findByName(java.lang.String)}.
	 */
	@Test
	void testFindByName() {
		ResponseEntity<ResponseDTO> response = stationController.findByName("Hit Music");
		assertThat(response.getBody().getMessage()).isEqualTo("SUCCESS");
	}

	@Test
	void testFindByNameException() throws StationException {
		doThrow(new RuntimeException("error")).when(stationService).findByName(Mockito.any());
		ResponseEntity<ResponseDTO> response = stationController.findByName("Hit Music");
		assertThat(response.getBody().getMessage()).isEqualTo("error");
	}

	@Test
	void testFindByNameExceptionStation() throws StationException {
		doThrow(new StationException("error")).when(stationService).findByName(Mockito.any());
		ResponseEntity<ResponseDTO> response = stationController.findByName("Hit Music");
		assertThat(response.getBody().getMessageCode()).isEqualTo("400");
	}

}
