package question6.enoca.dataAccess.abstracs;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import question6.enoca.entities.concretes.User;
import question6.enoca.entities.dtos.GetDetailsDto;

public interface UserDao extends JpaRepository<User, String> {

	@Query("Select new question6.enoca.entities.dtos.GetDetailsDto(u.phone, u.mail, n.nationalityName, p.productName, p.code, r.startDate, r.expireDate) From Nationality n "
			+ "Right Join n.users u Right Join u.remainings r Right Join r.product p ")
	List<GetDetailsDto> getDetails();

}
