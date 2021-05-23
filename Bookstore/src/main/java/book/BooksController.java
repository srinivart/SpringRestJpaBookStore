package book;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/bookstore") 
public class BooksController {
	
	@Autowired
	private final BooksRepository booksrepo;
	
	BooksController(BooksRepository booksrepo){
		this.booksrepo = booksrepo;
	}

	@GetMapping(value = "/bookstore")
	List<Books> allBooks(){
		return booksrepo.findAll();
	}
	
	@GetMapping(value= "/bookstore/find/{title}")
	Books findTitle(@PathVariable final String title) {
		return booksrepo.findByName(title);
	}
	
	
	@PostMapping(value= "/bookstore/add")
	Books addNewTitle(@RequestBody final Books newTitle){
		return booksrepo.save(newTitle);
	}
	
	@PutMapping("bookstore/update/{title}")
	Books updateTitle(@RequestBody Books newTitle, @PathVariable String title) {
		Books result = booksrepo.findByName(title);
		System.out.println("**** "+ result);
		   result.setPrice(newTitle.getPrice());
		   return booksrepo.save(result);
					
	}
	
	
	@DeleteMapping(value= "/bookstore/delete/{title}")
	List<Books> deleteTitle(@PathVariable final String title) {
		Books result = booksrepo.findByName(title);
		   booksrepo.delete(result);
		   return booksrepo.findAll();
	}
	
	
	@GetMapping(value= "/bookstore/find/{id}")
	    Books findBookById(@PathVariable final Long id) {
		return booksrepo.findBookById(id);
	}
	
	
	
	
}

