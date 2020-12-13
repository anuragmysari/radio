/**
 * 
 */
package com.mysari.radio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mysari.radio.entity.Station;
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
	public void addStation(Station station) {
		stationMapper.addStation(station);
	}

	@Override
	public void removeStation(String stationId) {
		stationMapper.removeStation(stationId);
	}

	@Override
	public void updateStation(Station station) {
		stationMapper.updateStation(station.getStationId(), station.getName(), station.isHdEnabled(),
				station.getCallSign());
	}

	@Override
	public Station findByID(String stationId) {
		return stationMapper.findByID(stationId);
	}

	@Override
	public Station findByName(String name) {
		return stationMapper.findByName(name);
	}

	@Override
	public List<Station> findHDEnabled() {
		return stationMapper.findHDEnabled();
	}

}
