package question6.enoca.dataAccess.abstracs;

import org.springframework.data.jpa.repository.JpaRepository;

import question6.enoca.entities.concretes.Product;

public interface ProductDao extends JpaRepository<Product, String> {

}
