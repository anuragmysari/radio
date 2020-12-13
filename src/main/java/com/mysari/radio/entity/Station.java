/**
 * 
 */
package com.mysari.radio.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.NonNull;

/**
 * @author anuragmysari
 *
 */
@Data
@Entity
public class Station {

	@Id
	@NonNull
	public String stationId;
	public String name;
	public boolean hd_Enabled;
	public String callSign;

}
