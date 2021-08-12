package question6.enoca.dataAccess.abstracs;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import question6.enoca.entities.concretes.Customer;
import question6.enoca.entities.dtos.CustomerDto;

public interface CustomerDao extends JpaRepository<Customer, String> {

	Customer findByFirstName(String firstName);

	@Query("From Customer where firstName=:firstName and lastName=:lastName")
	Customer findByFirstNameAndLastName(String firstName, String lastName);

}
