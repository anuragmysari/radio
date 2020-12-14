/**
 * 
 */
package com.mysari.radio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mysari.radio.dto.ResponseDTO;
import com.mysari.radio.dto.StationDTO;
import com.mysari.radio.entity.Station;
import com.mysari.radio.exception.StationException;
import com.mysari.radio.service.StationService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;

/**
 * @author anuragmysari
 *
 */
@org.springframework.web.bind.annotation.RestController
@RequestMapping("/station/")
@Api(tags = "Radio Station API")
public class StationController {

	@Autowired
	private StationService stationService;

	@GetMapping("all")
	public ResponseEntity<Object> findAll() {
		ResponseDTO response = null;
		try {
			final List<Station> findAll = stationService.findAll();
			response = new ResponseDTO(HttpStatus.OK, findAll, "200", "SUCCESS");
		} catch (Exception e) {
			response = new ResponseDTO(HttpStatus.INTERNAL_SERVER_ERROR, null, "500", e.getMessage());
		}
		return new ResponseEntity<>(response, response.getStatus());
	}

	@PostMapping("add")
	public ResponseEntity<Object> addStation(@RequestBody StationDTO stationDTO) {
		ResponseDTO response = null;
		try {

			Station station = Station.builder().stationId(stationDTO.getStationId()).name(stationDTO.getName())
					.hd_Enabled(stationDTO.isHd_Enabled()).callSign(stationDTO.getCallSign()).build();
			stationService.addStation(station);
			response = new ResponseDTO(HttpStatus.CREATED, station, "201", "CREATED");
		} catch (StationException e) {
			response = new ResponseDTO(HttpStatus.BAD_REQUEST, null, "400", e.getMessage());
		} catch (Exception e) {
			response = new ResponseDTO(HttpStatus.INTERNAL_SERVER_ERROR, null, "500", e.getMessage());
		}
		return new ResponseEntity<>(response, response.getStatus());

	}

	@DeleteMapping(value = "{stationId}")
	public ResponseEntity<Object> delete(
			@ApiParam(name = "stationId", value = "Station ID (e.g: Z100)") @PathVariable String stationId) {

		ResponseDTO response = null;
		try {
			Station station = stationService.findByID(stationId);
			stationService.removeStation(stationId);
			response = new ResponseDTO(HttpStatus.OK, station, "200", "DELETED");
		} catch (StationException e) {
			response = new ResponseDTO(HttpStatus.BAD_REQUEST, null, "400", e.getMessage());
		} catch (Exception e) {
			response = new ResponseDTO(HttpStatus.INTERNAL_SERVER_ERROR, null, "500", e.getMessage());
		}
		return new ResponseEntity<>(response, response.getStatus());

	}

	@PutMapping(value = "{stationId}")
	public ResponseEntity<Object> update(
			@ApiParam(name = "stationId", value = "Station ID (e.g: Z100)") @PathVariable String stationId,
			@RequestBody StationDTO stationDTO) {
		ResponseDTO response = null;
		try {
			Station station = Station.builder().stationId(stationDTO.getStationId()).name(stationDTO.getName())
					.hd_Enabled(stationDTO.isHd_Enabled()).callSign(stationDTO.getCallSign()).build();
			stationService.updateStation(station, stationId);
			station.setStationId(stationId);
			response = new ResponseDTO(HttpStatus.OK, station, "200", "UPDATED");
		} catch (StationException e) {
			response = new ResponseDTO(HttpStatus.BAD_REQUEST, null, "400", e.getMessage());
		} catch (Exception e) {
			response = new ResponseDTO(HttpStatus.INTERNAL_SERVER_ERROR, null, "500", e.getMessage());
		}
		return new ResponseEntity<>(response, response.getStatus());

	}

	@GetMapping(value = "search/{search}")
	public ResponseEntity<Object> searchByIdorName(
			@ApiParam(name = "search", value = "Station ID or Full Station Name (e.g: Z100, Hit Music)") @PathVariable String search) {
		ResponseDTO response = null;
		try {
			final List<Station> station = stationService.findByIdorName(search);
			response = new ResponseDTO(HttpStatus.OK, station, "200", "SUCCESS");
		} catch (StationException e) {
			response = new ResponseDTO(HttpStatus.BAD_REQUEST, null, "400", e.getMessage());
		} catch (Exception e) {
			response = new ResponseDTO(HttpStatus.INTERNAL_SERVER_ERROR, null, "500", e.getMessage());
		}
		return new ResponseEntity<>(response, response.getStatus());

	}

	@GetMapping("hd")
	public ResponseEntity<Object> findHDEnabled() {
		ResponseDTO response = null;
		try {
			final List<Station> findAll = stationService.findHDEnabled();
			response = new ResponseDTO(HttpStatus.OK, findAll, "200", "SUCCESS");
		} catch (Exception e) {
			response = new ResponseDTO(HttpStatus.INTERNAL_SERVER_ERROR, null, "500", e.getMessage());
		}
		return new ResponseEntity<>(response, response.getStatus());
	}

	@GetMapping(value = "id/{stationId}")
	public ResponseEntity<Object> getById(
			@ApiParam(name = "stationId", value = "Station ID (e.g: Z100)") @PathVariable String stationId) {
		ResponseDTO response = null;
		try {
			final Station station = stationService.findByID(stationId);
			response = new ResponseDTO(HttpStatus.OK, station, "200", "SUCCESS");
		} catch (StationException e) {
			response = new ResponseDTO(HttpStatus.BAD_REQUEST, null, "400", e.getMessage());
		} catch (Exception e) {
			response = new ResponseDTO(HttpStatus.INTERNAL_SERVER_ERROR, null, "500", e.getMessage());
		}
		return new ResponseEntity<>(response, response.getStatus());

	}

	@GetMapping("name/{name}")
	public ResponseEntity<Object> findByName(
			@ApiParam(name = "name", value = "Full Station Name (e.g: Hit Music)") @PathVariable String name) {
		ResponseDTO response = null;

		try {
			final Station station = stationService.findByName(name);
			response = new ResponseDTO(HttpStatus.OK, station, "200", "SUCCESS");
		} catch (StationException e) {
			response = new ResponseDTO(HttpStatus.BAD_REQUEST, null, "400", e.getMessage());
		} catch (Exception e) {
			response = new ResponseDTO(HttpStatus.INTERNAL_SERVER_ERROR, null, "500", e.getMessage());
		}
		return new ResponseEntity<>(response, response.getStatus());

	}

}
