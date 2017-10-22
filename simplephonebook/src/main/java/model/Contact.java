package model;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author nagayya
 *
 * This class is value object for having COntact Object values
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Contact {

	@Size(min=2, max=30)
	private String name;
	
	@NotEmpty 
	private String phone_number;

	@NotEmpty 
	private String address;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
		
}
