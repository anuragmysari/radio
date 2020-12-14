/**
 * 
 */
package com.mysari.radio.entity;

import lombok.Builder;
import lombok.Data;

/**
 * @author anuragmysari
 *
 */
@Data
@Builder
public class Station {

	public String stationId;
	public String name;
	public boolean hd_Enabled;
	public String callSign;

}
