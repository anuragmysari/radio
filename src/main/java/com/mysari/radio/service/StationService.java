/**
 * 
 */
package com.mysari.radio.service;

import java.util.List;

import com.mysari.radio.entity.Station;

/**
 * @author anuragmysari
 *
 */
public interface StationService {

	List<Station> findAll();

	void addStation(Station station);

	void removeStation(String stationId);

	void updateStation(Station station);

	Station findByID(String id);

	Station findByName(String name);

	List<Station> findHDEnabled();

}
