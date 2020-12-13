/**
 * 
 */
package com.mysari.radio.service;

import java.text.MessageFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysari.radio.entity.Station;
import com.mysari.radio.exception.StationException;
import com.mysari.radio.mapper.StationMapper;

/**
 * @author anuragmysari
 *
 */
@Service
public class StationServiceImpl implements StationService {

	@Autowired
	private StationMapper stationMapper;

	@Override
	public List<Station> findAll() {
		return stationMapper.findAll();
	}

	@Override
	public void addStation(Station station) throws StationException {
		if (stationMapper.findByID(station.getStationId()) != null) {
			String message = MessageFormat.format("Station for Id {0} already exists", station.getStationId());
			throw new StationException(message);
		}
		stationMapper.addStation(station);
	}

	@Override
	public void removeStation(String stationId) throws StationException {
		if (null == stationMapper.findByID(stationId)) {
			String message = MessageFormat.format("Station for Id {0} does not exist", stationId);
			throw new StationException(message);
		}
		stationMapper.removeStation(stationId);
	}

	@Override
	public void updateStation(Station station, String stationId) throws StationException {
		if (null != station.getStationId() && !station.getStationId().equalsIgnoreCase(stationId)) {
			throw new StationException("StationId Mismatch");
		}
		if (null == stationMapper.findByID(stationId)) {
			String message = MessageFormat.format("Station for Id {0} does not exist", stationId);
			throw new StationException(message);
		}
		stationMapper.updateStation(station.getStationId(), station.getName(), station.isHd_Enabled(),
				station.getCallSign());
	}

	@Override
	public Station findByID(String stationId) throws StationException {
		final Station station = stationMapper.findByID(stationId);
		if (null == station) {
			String message = MessageFormat.format("Station for Id {0} does not exist", stationId);
			throw new StationException(message);
		}
		return station;
	}

	@Override
	public Station findByName(String name) throws StationException {
		final Station station = stationMapper.findByName(name);
		if (null == station) {
			String message = MessageFormat.format("Station for Name {0} does not exist", name);
			throw new StationException(message);
		}
		return station;
	}

	@Override
	public List<Station> findByIdorName(String search) throws StationException {
		final List<Station> station = stationMapper.findByIDorName(search);
		if (null == station || station.isEmpty()) {
			String message = MessageFormat.format("Station for search {0} does not exist", search);
			throw new StationException(message);
		}
		return stationMapper.findByIDorName(search);
	}

	@Override
	public List<Station> findHDEnabled() {
		return stationMapper.findHDEnabled();
	}

}
