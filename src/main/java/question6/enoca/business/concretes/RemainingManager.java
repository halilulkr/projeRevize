package question6.enoca.business.concretes;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import question6.enoca.core.utilities.DataResult;
import question6.enoca.core.utilities.Result;
import question6.enoca.core.utilities.SuccessDataResult;
import question6.enoca.core.utilities.SuccessResult;
import question6.enoca.dataAccess.abstracs.RemainingDao;
import question6.enoca.entities.concretes.Remaining;
import question6.enoca.entities.dtos.GetDetailsDto;

@Service
public class RemainingManager {

	private final RemainingDao remainingDao;

	public RemainingManager(RemainingDao remainingDao) {
		super();
		this.remainingDao = remainingDao;
	}

	public Result add(Remaining remaining) {
		this.remainingDao.save(remaining);
		return new SuccessResult("Remaining Eklendi");
	}
}
