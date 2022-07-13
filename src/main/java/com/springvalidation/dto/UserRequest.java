package com.springvalidation.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
What is DTO class in Java Spring boot?
--> DTO is an object that carries data between processes. 
	When you're working with a remote interface, each call it is expensive. 
	As a result you need to reduce the number of calls. 
	The solution is to create a Data Transfer Object that can hold all the data for the call.
*/

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class UserRequest {
	// request will come from the PostMan or frontend application
	// on top this we need to add the validation
	@NotNull(message = "UserName shouldn't be null")
	private String name;
	
	@Email(message = "Invalid email id")
	private String email;
	
	@NotNull
	@Pattern(regexp = "\\^d{10}$", message = "Invalid mobile number")
	private String mobile;
	
	private String gender;
	
	@Min(18)
	@Max(60)
	private int age;
	
	// @NotBlank will together considered NotNull as well as NotEmpty
	@NotBlank(message = "Nationality should not be blank")
	private String nationality;

}
