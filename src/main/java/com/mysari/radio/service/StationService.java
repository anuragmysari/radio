/**
 * 
 */
package com.mysari.radio.service;

import java.util.List;

import com.mysari.radio.entity.Station;
import com.mysari.radio.exception.StationException;

/**
 * @author anuragmysari
 *
 */
public interface StationService {

	List<Station> findAll();

	void addStation(Station station) throws StationException;

	void removeStation(String stationId) throws StationException;

	void updateStation(Station station, String stationId) throws StationException;

	Station findByID(String stationId) throws StationException;

	Station findByName(String name) throws StationException;

	List<Station> findHDEnabled();

	List<Station> findByIdorName(String search) throws StationException;

}
