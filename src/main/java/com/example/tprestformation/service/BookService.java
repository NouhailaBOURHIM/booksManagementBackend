package com.example.tprestformation.service;

import com.example.tprestformation.dto.BookDto;
import com.example.tprestformation.exception.BookNotFoundException;

import java.util.List;

public interface BookService {
    BookDto getById(int id) throws BookNotFoundException;
    List<BookDto> getAllBooks();
    BookDto addBook(BookDto bookDto);
    BookDto updateBook(BookDto bookDto) throws Exception;
    void deleteBook(int id) throws Exception;
    List<BookDto> searchByName(String name);
    List<BookDto> searchByCategory(String category);

    List<BookDto> searchByNameByCategory(String name,String category);
    List<BookDto> searchByAuthor(String author);

    List<BookDto> searchByNameByCategoryByAuthor(String name,String category,String author);
}
