package book;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BooksRepository extends JpaRepository<Books, Long> {

	//List<Books> findByName(String title);
	
	 @Query("select b from Books b where b.title = ?1")
	   Books findByName(String title);
       
	 @Modifying
	 @Query("delete from Books b where b.title = ?1")
	  Books deleteByName(String title);
	  //void deleteByName(@Param("title") String title);
	 //@Query("delete from Books b where b.title = ?1")

	 @Query("select b from Books b where b.id = ?1")
	 Books findBookById(Long id);

}
