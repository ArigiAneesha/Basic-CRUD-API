package com.aneesha.io.pojo;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class UserRequest {
	@NotEmpty(message = "Name can not be empty")
	private String name;
	@Email(message="Enter correct mailId")
	private String email;
}
