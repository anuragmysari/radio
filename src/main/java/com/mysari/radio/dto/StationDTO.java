/**
 * 
 */
package com.mysari.radio.dto;

import lombok.Builder;
import lombok.Data;

/**
 * @author anuragmysari
 *
 */
@Data
@Builder
public class StationDTO {

	public String stationId;
	public String name;
	public boolean hd_Enabled;
	public String callSign;

}
