package book;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {
	
	private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

	@Bean
	CommandLineRunner initDatabase(BooksRepository booksrepo) {
		
		return args -> {
			log.info("preloading" + booksrepo.save(new Books("In Search of Lost Time", "Marcel Proust", "Novel", 250, 1913)));
			log.info("preloading" + booksrepo.save(new Books("Ulysses", "James Joyce", "Fiction", 190, 1904)));
			log.info("preloading" + booksrepo.save(new Books("One Hundred Years of Solitude", "Gabriel Garcia Marquez", "Novel", 120, 1967)));
			log.info("preloading" + booksrepo.save(new Books("The Great Gatsby", "F. Scott Fitzgerald", "Historical", 180, 1925)));
		};
	}
}
