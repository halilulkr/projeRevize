package question6.enoca.api.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import question6.enoca.business.concretes.CustomerManager;
import question6.enoca.core.utilities.ErrorDataResult;
import question6.enoca.entities.concretes.Customer;
import question6.enoca.entities.dtos.CreateCustomerRequest;
import question6.enoca.entities.dtos.CustomerDto;
import question6.enoca.entities.dtos.UpdateCustomerRequest;

@RestController
@RequestMapping("/api/enoca")
@CrossOrigin
public class CustomerController {

	private final CustomerManager customerManager;

	public CustomerController(CustomerManager customerManager) {
		super();
		this.customerManager = customerManager;
	}

	@PostMapping("/add")
	public ResponseEntity<CustomerDto> add(@RequestBody @Valid CreateCustomerRequest createCustomerRequest) {

		return ResponseEntity.ok(customerManager.add(createCustomerRequest));
	}

	@GetMapping("/findAll")
	public ResponseEntity<List<CustomerDto>> findAll() {
		return ResponseEntity.ok(customerManager.findAll());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		customerManager.deleteById(id);
		return ResponseEntity.ok().build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<CustomerDto> update(@PathVariable String id,
			@RequestBody UpdateCustomerRequest updateCustomerRequest) {
		return ResponseEntity.ok(customerManager.update(id, updateCustomerRequest));
	}

	@GetMapping("/{id}")
	public ResponseEntity<CustomerDto> findById(@PathVariable String id) {
		return ResponseEntity.ok(customerManager.findById(id));
	}

/*  Post işleminde boş değer göndermeye çalıştığımız da hata kodu dönüyor ancak benim girdiğim mesaj ya da default mesaj dönmüyor bu alanı mesajı döndürmek için eklemiştim.
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();

		ex.getBindingResult().getFieldErrors()
				.forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));

		return errors;
	}
*/
}
