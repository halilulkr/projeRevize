package question6.enoca.dataAccess.abstracs;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import question6.enoca.entities.concretes.Remaining;
import question6.enoca.entities.dtos.GetDetailsDto;

public interface RemainingDao extends JpaRepository<Remaining, String> {

}
