package com.example.tprestformation.repository;

import com.example.tprestformation.dto.BookDto;
import com.example.tprestformation.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {
    public List<Book> findBookByNameContainingIgnoreCase(String nameTerm);
    public List<Book> findBookByCategoryContainingIgnoreCase(String categoryTerm);
    public List<Book> findBookByNameContainingIgnoreCaseAndCategoryContainingIgnoreCase(String nameTerm,String categoryTerm);

    public List<Book> findBookByNameContainingIgnoreCaseAndCategoryContainingIgnoreCaseAndAuthorContainingIgnoreCase(String nameTerm,String categoryTerm,String authorTerm);
    public List<Book> findBookByAuthorContainingIgnoreCase(String author);
}
