/**
 * 
 */
package com.mysari.radio.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author anuragmysari
 *
 */
@Data
@AllArgsConstructor
public class StationDTO {

	public String stationId;
	public String name;
	public boolean hd_Enabled;
	public String callSign;

}
