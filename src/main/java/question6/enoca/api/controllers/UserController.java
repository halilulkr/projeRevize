package question6.enoca.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import question6.enoca.business.concretes.UserManager;
import question6.enoca.core.utilities.DataResult;
import question6.enoca.core.utilities.Result;
import question6.enoca.entities.concretes.Nationality;
import question6.enoca.entities.concretes.Product;
import question6.enoca.entities.concretes.Remaining;
import question6.enoca.entities.concretes.User;
import question6.enoca.entities.dtos.GetDetailsDto;

@RestController
@RequestMapping("/api/user")
@CrossOrigin
public class UserController {

	private final UserManager userManager;

	public UserController(UserManager userManager) {
		super();
		this.userManager = userManager;
	}

	@GetMapping("/getDetails")
	public DataResult<List<GetDetailsDto>> getDetails() {
		return this.userManager.getDetails();
	}
}
