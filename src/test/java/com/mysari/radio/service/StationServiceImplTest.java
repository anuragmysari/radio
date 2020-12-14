/**
 * 
 */
package com.mysari.radio.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.mysari.radio.entity.Station;
import com.mysari.radio.exception.StationException;
import com.mysari.radio.mapper.StationMapper;

/**
 * @author anuragmysari
 *
 */
@ExtendWith(SpringExtension.class)
class StationServiceImplTest {

	@InjectMocks
	private StationServiceImpl service;

	@Mock
	private StationMapper stationMapper;

	private Station station;

	private List<Station> list;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
		list = new ArrayList<>();
		station = Station.builder().stationId("123Z").name("Test Radio").hd_Enabled(true).callSign("12Z").build();
	}

	/**
	 * Test method for
	 * {@link com.mysari.radio.service.StationServiceImpl#findAll()}.
	 */
	@Test
	void testFindAll() {
		service.findAll();
		verify(stationMapper, times(1)).findAll();
	}

	/**
	 * Test method for
	 * {@link com.mysari.radio.service.StationServiceImpl#addStation(com.mysari.radio.entity.Station)}.
	 * 
	 * @throws StationException
	 */
	@Test
	void testAddStation() throws StationException {
		service.addStation(station);
		verify(stationMapper, times(1)).addStation(station);
	}

	@Test
	void testAddStationException() throws StationException {
		when(stationMapper.findByID("123Z")).thenReturn(station);
		Assertions.assertThrows(StationException.class, () -> service.addStation(station));
	}

	/**
	 * Test method for
	 * {@link com.mysari.radio.service.StationServiceImpl#removeStation(java.lang.String)}.
	 * 
	 * @throws StationException
	 */
	@Test
	void testRemoveStation() throws StationException {
		when(stationMapper.findByID("123Z")).thenReturn(station);
		service.removeStation("123Z");
		verify(stationMapper, times(1)).removeStation("123Z");
	}

	@Test
	void testRemoveStationException() throws StationException {
		when(stationMapper.findByID("123Z")).thenReturn(null);
		Assertions.assertThrows(StationException.class, () -> service.removeStation("123Z"));
	}

	/**
	 * Test method for
	 * {@link com.mysari.radio.service.StationServiceImpl#updateStation(com.mysari.radio.entity.Station, java.lang.String)}.
	 * 
	 * @throws StationException
	 */
	@Test
	void testUpdateStation() throws StationException {
		when(stationMapper.findByID("123Z")).thenReturn(station);
		service.updateStation(station, "123Z");
		verify(stationMapper, times(1)).updateStation("123Z", "Test Radio", true, "12Z");
	}

	@Test
	void testUpdateStationExceptionMismatch() throws StationException {
		when(stationMapper.findByID("12Z")).thenReturn(station);
		Assertions.assertThrows(StationException.class, () -> service.updateStation(station, "12Z"));
	}

	@Test
	void testUpdateStationException() throws StationException {
		when(stationMapper.findByID("123Z")).thenReturn(null);
		Assertions.assertThrows(StationException.class, () -> service.updateStation(station, "123Z"));
	}

	/**
	 * Test method for
	 * {@link com.mysari.radio.service.StationServiceImpl#findByID(java.lang.String)}.
	 * 
	 * @throws StationException
	 */
	@Test
	void testFindByID() throws StationException {
		when(stationMapper.findByID("123Z")).thenReturn(station);
		service.findByID("123Z");
		assertThat(service.findByID("123Z")).isEqualTo(station);
	}

	@Test
	void testFindByIDException() throws StationException {
		when(stationMapper.findByID("123Z")).thenReturn(null);
		Assertions.assertThrows(StationException.class, () -> service.findByID("123Z"));
	}

	/**
	 * Test method for
	 * {@link com.mysari.radio.service.StationServiceImpl#findByName(java.lang.String)}.
	 * 
	 * @throws StationException
	 */
	@Test
	void testFindByName() throws StationException {
		when(stationMapper.findByName("Hit Music")).thenReturn(station);
		assertThat(service.findByName("Hit Music")).isEqualTo(station);
	}

	@Test
	void testFindByNameException() throws StationException {
		when(stationMapper.findByName("Hit Music")).thenReturn(null);
		Assertions.assertThrows(StationException.class, () -> service.findByName("Hit Music"));
	}

	/**
	 * Test method for
	 * {@link com.mysari.radio.service.StationServiceImpl#findByIdorName(java.lang.String)}.
	 * 
	 * @throws StationException
	 */
	@Test
	void testFindByIdorName() throws StationException {
		list.add(station);
		when(stationMapper.findByIDorName("Hit Music")).thenReturn(list);
		assertThat(service.findByIdorName("Hit Music")).isEqualTo(list);
	}

	@Test
	void testFindByIdorNameException() throws StationException {
		when(stationMapper.findByIDorName("Hit Music")).thenReturn(null);
		Assertions.assertThrows(StationException.class, () -> service.findByIdorName("Hit Music"));
	}

	/**
	 * Test method for
	 * {@link com.mysari.radio.service.StationServiceImpl#findHDEnabled()}.
	 */
	@Test
	void testFindHDEnabled() {
		service.findHDEnabled();
		verify(stationMapper, times(1)).findHDEnabled();
	}

}
