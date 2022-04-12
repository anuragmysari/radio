/**
 * 
 */
package com.mysari.radio.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author anuragmysari
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StationDTO {

	public String stationId;
	public String name;
	public boolean hd_Enabled;
	public String callSign;

}
