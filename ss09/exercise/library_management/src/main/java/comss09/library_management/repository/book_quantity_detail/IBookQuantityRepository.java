package comss09.library_management.repository.book_quantity_detail;


import comss09.library_management.model.BookQuantityDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookQuantityRepository extends JpaRepository<BookQuantityDetail, Integer> {
}
