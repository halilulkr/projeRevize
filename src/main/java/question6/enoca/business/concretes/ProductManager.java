package question6.enoca.business.concretes;

import org.springframework.stereotype.Service;

import question6.enoca.core.utilities.Result;
import question6.enoca.core.utilities.SuccessResult;
import question6.enoca.dataAccess.abstracs.ProductDao;
import question6.enoca.entities.concretes.Product;
import question6.enoca.entities.concretes.Remaining;

@Service
public class ProductManager {

	private final ProductDao productDao;

	public ProductManager(ProductDao productDao) {
		super();
		this.productDao = productDao;
	}

	public Result add(Product product) {
		this.productDao.save(product);
		return new SuccessResult("Remaining Eklendi");
	}
}
