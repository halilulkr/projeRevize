package question6.enoca;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

import question6.enoca.dataAccess.abstracs.NationalityDao;
import question6.enoca.dataAccess.abstracs.ProductDao;
import question6.enoca.dataAccess.abstracs.RemainingDao;
import question6.enoca.dataAccess.abstracs.UserDao;
import question6.enoca.entities.concretes.Nationality;
import question6.enoca.entities.concretes.Product;
import question6.enoca.entities.concretes.Remaining;
import question6.enoca.entities.concretes.User;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableCaching
public class EnocaApplication /*implements CommandLineRunner */{

	private final NationalityDao nationalityDao;
	private final UserDao userDao;
	private final ProductDao productDao;
	private final RemainingDao remainingDao;

	public EnocaApplication(NationalityDao nationalityDao, UserDao userDao, ProductDao productDao,
			RemainingDao remainingDao) {
		super();
		this.nationalityDao = nationalityDao;
		this.userDao = userDao;
		this.productDao = productDao;
		this.remainingDao = remainingDao;
	}

	public static void main(String[] args) {
		SpringApplication.run(EnocaApplication.class, args);
	}

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("question6.enoca")).build();
	}

/* Bu alanı H2 database kullanarak değerleri default olarak uygulama ayağa kalktığında oluştursun diye eklemiştim. 
 * Ancak alanları getirmesine rağmen product değerleri dışındaki değerler null döndüğü için postgre veritabınında oluşturduğum 
 * hazır değerleri kullandım hatasız değerler geliyor sonuç kısımının ekran görüntüsünü de ekledim.
	
	@Override
	public void run(String... args) throws Exception {
		Remaining remaining = remainingDao.save(new Remaining(LocalDate.of(1995, 7, 28), LocalDate.of(2021, 8, 11)));
		User user = userDao.save(new User("Halil", "halilulkr@gmail.com", "05001230000"));
		Product product = productDao.save(new Product("Asus", "code1"));
		Nationality nationality = nationalityDao.save(new Nationality("Turkish"));
		
		System.out.println(remaining);
		
		Nationality nationality2 = nationalityDao.save(new Nationality("American"));
		User user2 = userDao.save(new User("Bella", "bella@gmail.com", "05001233162"));
		Product product2 = productDao.save(new Product("Lenovo", "code2"));
		Remaining remaining2 = remainingDao.save(new Remaining(LocalDate.of(1475, 7, 12), LocalDate.of(2050, 2, 17)));
	}
*/
}
