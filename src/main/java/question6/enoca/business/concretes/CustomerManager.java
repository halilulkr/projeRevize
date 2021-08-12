package question6.enoca.business.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.management.AttributeNotFoundException;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;

import question6.enoca.core.exception.CustomerNotFoundException;
import question6.enoca.core.exception.GeneralExceptionHandler;
import question6.enoca.dataAccess.abstracs.CustomerDao;
import question6.enoca.entities.concretes.Customer;
import question6.enoca.entities.dtos.CreateCustomerRequest;
import question6.enoca.entities.dtos.CustomerDto;
import question6.enoca.entities.dtos.CustomerDtoConverter;
import question6.enoca.entities.dtos.UpdateCustomerRequest;

@Service
public class CustomerManager {

	private final CustomerDao customerDao;
	private final CustomerDtoConverter customerDtoConverter;

	public CustomerManager(CustomerDao customerDao, CustomerDtoConverter customerDtoConverter) {
		this.customerDao = customerDao;
		this.customerDtoConverter = customerDtoConverter;
	}

	public CustomerDto add(CreateCustomerRequest createCustomerRequest) {

		Customer customer = new Customer();
		customer.setId(createCustomerRequest.getId());
		customer.setFirstName(createCustomerRequest.getFirstName());
		customer.setLastName(createCustomerRequest.getLastName());
		customer.setIdentityNumber(createCustomerRequest.getIdentityNumber());

		customerDao.save(customer);

		return customerDtoConverter.convert(customer);
	}

	public CustomerDto update(String id, UpdateCustomerRequest updateCustomerRequest) {
		Optional<Customer> customerOptional = customerDao.findById(id);

		customerOptional.ifPresent(customer -> {
			customer.setFirstName(updateCustomerRequest.getFirstName());
			customer.setLastName(updateCustomerRequest.getLastName());
			customer.setIdentityNumber(updateCustomerRequest.getIdentityNumber());
			customerDao.save(customer);
		});

		return customerOptional.map(customerDtoConverter::convert).orElse(new CustomerDto());
	}

	//@CacheEvict(value = "customer", allEntries = true)
	public void deleteById(String id) {
		customerDao.deleteById(id);
	}

	public List<CustomerDto> findAll() {
		List<Customer> customerList = customerDao.findAll();

		List<CustomerDto> customerDtoList = new ArrayList<>();

		for (Customer customer : customerList) {
			customerDtoList.add(customerDtoConverter.convert(customer));
		}

		return customerDtoList;
	}

	public CustomerDto findById(String id) {

		return customerDtoConverter.convert(customerDao.findById(id)
				.orElseThrow(() -> new CustomerNotFoundException("Bu id'ye ait kullanıcı bulunamadı: " + id)));
	}
}
