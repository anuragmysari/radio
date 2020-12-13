/**
 * 
 */
package com.mysari.radio.dto;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author anuragmysari
 *
 */
@Data
@AllArgsConstructor
public class ResponseDTO {

	private HttpStatus status;

	private Object responseData;

	private String messageCode;

	private String message;

}
