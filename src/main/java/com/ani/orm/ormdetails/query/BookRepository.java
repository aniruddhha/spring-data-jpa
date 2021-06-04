package com.ani.orm.ormdetails.query;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

//https://www.mockaroo.com/ - fake data
//https://docs.spring.io/spring-data/jpa/docs/1.5.0.RELEASE/reference/html/jpa.repositories.html
public interface BookRepository extends JpaRepository<Book, Long> {

    Optional<Book> findByIsbn(String isbn);

    //SELECT * FROM movie WHERE title LIKE '%in%';
    Optional<List<Book>> findByNameContaining(String name);

    //SELECT * FROM movie WHERE title LIKE '%in%';
    Optional<List<Book>> findByNameLike(String name);

    //SELECT * FROM Movie WHERE Rating LIKE 'PG%';
    Optional<List<Book>> findByNameStartingWith(String name);

    Optional<List<Book>> findByNameIgnoreCaseStartingWith(String name);

    Optional<List<Book>> findByPubDtBetween(LocalDate st, LocalDate ed);

    Optional<List<Book>> findByPageCountGreaterThan(Integer cnt);

    Optional<List<Book>> findTop10ByPageCountLessThanOrderByPageCountDesc(Integer cnt);

    @Query("select bk from Book bk")
    Optional<List<Book>> sortJpql(Sort sort);

    @Query("select bk from Book bk where bk.isbn like '2%'")
    Optional<List<Book>> selectIsbn() ;

    @Query("select avg(bk.pageCount) from Book bk")
    Integer avgPageCount();

    @Query(value = "select * from book where isbn like '3%' ", nativeQuery = true)
    Optional<List<Book>> selectIsbnNative();
}
