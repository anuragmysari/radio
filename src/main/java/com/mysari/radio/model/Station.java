/**
 * 
 */
package com.mysari.radio.model;

import lombok.Data;

/**
 * @author anuragmysari
 *
 */
@Data
public class Station {

	public String stationId;
	public String name;
	public boolean hdEnabled;
	public String callSign;

}
