package question6.enoca.api.controllers;

import java.util.List;
import java.util.Set;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import question6.enoca.business.concretes.RemainingManager;
import question6.enoca.core.utilities.DataResult;
import question6.enoca.entities.concretes.Remaining;
import question6.enoca.entities.dtos.GetDetailsDto;

@RestController
@RequestMapping("/api/remaining")
@CrossOrigin
public class RemainingController {

	private final RemainingManager remainingManager;

	public RemainingController(RemainingManager remainingManager) {
		super();
		this.remainingManager = remainingManager;
	}
}
