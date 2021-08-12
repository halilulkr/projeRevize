package question6.enoca.dataAccess.abstracs;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import question6.enoca.entities.concretes.Nationality;

public interface NationalityDao extends JpaRepository<Nationality, String> {

}
