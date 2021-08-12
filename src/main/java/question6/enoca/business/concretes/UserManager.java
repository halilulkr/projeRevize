package question6.enoca.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import question6.enoca.core.utilities.DataResult;
import question6.enoca.core.utilities.Result;
import question6.enoca.core.utilities.SuccessDataResult;
import question6.enoca.core.utilities.SuccessResult;
import question6.enoca.dataAccess.abstracs.UserDao;
import question6.enoca.entities.concretes.Nationality;
import question6.enoca.entities.concretes.Product;
import question6.enoca.entities.concretes.Remaining;
import question6.enoca.entities.concretes.User;
import question6.enoca.entities.dtos.GetDetailsDto;

@Service
public class UserManager {

	private final UserDao userDao;
	private final NationalityManager nationalityManager;
	private final RemainingManager remainingManager;
	private final ProductManager productManager;

	public UserManager(UserDao userDao, NationalityManager nationalityManager, RemainingManager remainingManager,
			ProductManager productManager) {
		super();
		this.userDao = userDao;
		this.nationalityManager = nationalityManager;
		this.remainingManager = remainingManager;
		this.productManager = productManager;
	}

	public DataResult<List<GetDetailsDto>> getDetails() {
		return new SuccessDataResult<List<GetDetailsDto>>(this.userDao.getDetails());
	}
}
