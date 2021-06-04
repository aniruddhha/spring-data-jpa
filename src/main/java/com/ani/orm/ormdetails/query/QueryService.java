package com.ani.orm.ormdetails.query;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class QueryService {

    private final BookRepository repository;
    private final BookDao dao;

    public QueryService(
            BookRepository repository,
            BookDao dao
    ) {
        this.repository = repository;
        this.dao = dao;
    }

    public void findByIsbn() {
        Book book = repository.findByIsbn("820720406-0").orElseThrow(RuntimeException::new);
        System.out.println(book);
    }

    public void contain() {
//        List<Book> booksContaining = repository.findByNameContaining("an").orElseThrow(RuntimeException::new);
//        booksContaining.forEach(System.out::println);

        List<Book> booksLike = repository.findByNameLike("%an%").orElseThrow(RuntimeException::new);
        printBooks(booksLike);
    }

    public void startsWith() {
//        List<Book> books = repository.findByNameStartingWith("A").orElseThrow(RuntimeException::new);

        List<Book> books = repository.findByNameIgnoreCaseStartingWith("a").orElseThrow(RuntimeException::new);
        printBooks(books);
    }

    public void between() {
        List<Book> books = repository.findByPubDtBetween(
                LocalDate.of(2020, 2, 12),
                LocalDate.of(2021, 2, 12)
        ).orElseThrow(RuntimeException::new);
        printBooks(books);
    }

    public void conditional() {
        printBooks(
                repository.findByPageCountGreaterThan(80).orElseThrow(RuntimeException::new)
        );
    }

    public void top() {
        printBooks(
                repository.findTop10ByPageCountLessThanOrderByPageCountDesc(100).orElseThrow(RuntimeException::new)
        );
    }

    public void sorted() {
//        printBooks(
//                repository.findAll(Sort.by(Sort.Direction.DESC, "name"))
//        );

        printBooks(
                repository.sortJpql(
                        Sort.by(Sort.Direction.DESC, "name")
                ).orElseThrow(RuntimeException::new)
        );
    }

    public void query() {
//        printBooks(
//                repository.selectIsbn().orElseThrow(RuntimeException::new)
//        );

        printBooks(
                repository.selectIsbnNative().orElseThrow(RuntimeException::new)
        );
    }

    public void aggregateFn() {
        System.out.println("Avg Page Count - "+repository.avgPageCount());;
    }

    public void criteria() {
        printBooks(dao.findBookIsbnLike("2"));
    }

    private void printBooks(List<Book> books) {
        books.forEach(System.out::println);
    }
}
