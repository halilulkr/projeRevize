package question6.enoca.entities.dtos;

import org.springframework.stereotype.Component;

import question6.enoca.entities.concretes.Customer;

@Component
public class CustomerDtoConverter {

	public CustomerDto convert(Customer customer) {
		CustomerDto customerDto = new CustomerDto();
		customerDto.setId(customer.getId());
		customerDto.setFirstName(customer.getFirstName());
		customerDto.setLastName(customer.getLastName());
		customerDto.setIdentityNumber(customer.getIdentityNumber());

		return customerDto;
	}
}
