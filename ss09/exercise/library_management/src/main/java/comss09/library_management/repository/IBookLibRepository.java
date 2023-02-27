package comss09.library_management.repository;

import comss09.library_management.model.BookLib;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface IBookLibRepository extends JpaRepository<BookLib, Integer> {

    @Query(value = "select * from `book` where name like  concat('%', :name, '%')  or author like concat('%', :author, '%')", nativeQuery = true)
    Page<BookLib> getBooks(@Param("name") String name, @Param("author") String author, Pageable pageable);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "update `book` set quantity = quantity - :qty where id = :id", nativeQuery = true)
    void leanBook(@Param("id") int id, @Param("qty") int qty);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "update `book` set quantity = quantity + :qty where id = :id", nativeQuery = true)
    void returnBook(@Param("id")int id, @Param("qty") int qty);

}
