package com.ani.orm.ormdetails.query;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class BookDao {

    private final EntityManager manager;

    public BookDao(EntityManager manager) {
        this.manager = manager;
    }

    public List<Book> findBookIsbnLike(String isbn) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Book> criteriaQuery = builder.createQuery(Book.class);

        Root<Book> book = criteriaQuery.from(Book.class);
        Predicate likePredicate = builder.like(book.get("isbn"), isbn + "%");
        criteriaQuery.where(likePredicate);

        TypedQuery<Book> typedQuery = manager.createQuery(criteriaQuery);

        return typedQuery.getResultList();
    }
}
