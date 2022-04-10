package com.bookcode.dao;

import com.bookcode.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookDao extends JpaRepository<Book, Integer>, JpaSpecificationExecutor<Book> {
    @Query(value = "select * from t_book where t_book.name like %?1% ", nativeQuery = true)
    public List<Book> findByName(String name);

    @Query(value = "select * from t_book ORDER BY RAND() limit ?1 ", nativeQuery = true)
    public List<Book> randomList(Integer id);
}
