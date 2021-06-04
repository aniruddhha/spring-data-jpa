package com.ani.orm.ormdetails.mapping;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ChipRepository extends JpaRepository<Chip, Long> {

//    @Query("select ch from Chip ch left join ch.board brd where brd.brdId = :brd") // lazy
    @Query("select ch from Chip ch left join fetch ch.board brd where brd.brdId = :brd") //eager
    Optional<List<Chip>> chipOnBoard(@Param("brd") Long brd);
}
