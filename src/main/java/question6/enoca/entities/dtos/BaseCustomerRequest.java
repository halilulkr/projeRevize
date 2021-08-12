package question6.enoca.entities.dtos;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseCustomerRequest {

	@NotNull // (message = "Boş bırakılamaz")
	private String firstName;

	@NotNull // (message = "Boş bırakılamaz")
	private String lastName;

	@NotNull // (message = "Boş bırakılamaz")
	@Length(min = 11, max = 11, message = "TC No 11 haneli olmalı")
	private String identityNumber;

}
