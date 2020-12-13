/**
 * 
 */
package com.mysari.radio.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.mysari.radio.entity.Station;

/**
 * @author anuragmysari
 *
 */
@Mapper
public interface StationMapper {

	List<Station> findAll();

	void addStation(Station station);

	void removeStation(String stationId);

	void updateStation(@Param("stationId") String stationId, @Param("name") String name,
			@Param("hdEnabled") boolean hdEnabled, @Param("callSign") String callSign);

	Station findByID(String stationId);

	Station findByName(String name);

	List<Station> findByIDorName(String search);

	List<Station> findHDEnabled();

}
