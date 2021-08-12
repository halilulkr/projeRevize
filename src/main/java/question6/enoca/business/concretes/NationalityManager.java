package question6.enoca.business.concretes;

import org.springframework.stereotype.Service;

import question6.enoca.core.utilities.Result;
import question6.enoca.core.utilities.SuccessResult;
import question6.enoca.dataAccess.abstracs.NationalityDao;
import question6.enoca.entities.concretes.Nationality;
import question6.enoca.entities.concretes.Remaining;

@Service
public class NationalityManager {

	private final NationalityDao nationalityDao;

	public NationalityManager(NationalityDao nationalityDao) {
		super();
		this.nationalityDao = nationalityDao;
	}

	public Result add(Nationality nationality) {
		this.nationalityDao.save(nationality);
		return new SuccessResult("Remaining Eklendi");
	}
}
