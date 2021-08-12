package question6.enoca.entities.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetDetailsDto {

	private String phone;

	private String mail;

	private String nationalityName;

	private String productName;

	private String code;

	private LocalDate startDate;

	private LocalDate expireDate;
}
