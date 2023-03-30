package com.example.tprestformation.service;

import com.example.tprestformation.dto.BookDto;
import com.example.tprestformation.entity.Book;
import com.example.tprestformation.exception.BookNotFoundException;
import com.example.tprestformation.mapper.BookMapper;
import com.example.tprestformation.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookRepository bookRepository;

    @Override
    public BookDto getById(int id) throws BookNotFoundException {
        Optional<Book> book=bookRepository.findById(id);
        if(book.isPresent())
        {
            return BookMapper.toDto(book.get());
        }
        else{
            throw  new BookNotFoundException("book does not exist");
        }
    }

    @Override
    public List<BookDto> getAllBooks() {
        return bookRepository.findAll()
                .stream()
                .map(user -> BookMapper.toDto(user))
                .collect(Collectors.toList());
    }

    @Override
    public BookDto addBook(BookDto bookDto) {
        Book book= BookMapper.toEntity(bookDto);
        Book savedBook=bookRepository.save(book);
        return BookMapper.toDto(savedBook);
    }

    @Override
    public BookDto updateBook(BookDto bookDto) throws Exception {
        return BookMapper.toDto(bookRepository.save(BookMapper.toEntity(bookDto)));
    }

    @Override
    public void deleteBook(int id) {
        bookRepository.deleteById(id);
    }


    @Override
    public List<BookDto> searchByName(String name) {
        return bookRepository.findBookByNameContainingIgnoreCase(name)
                .stream()
                .map(user -> BookMapper.toDto(user))
                .collect(Collectors.toList());
    }

    @Override
    public List<BookDto> searchByNameByCategoryByAuthor(String name,String category,String author){
        return bookRepository.findBookByNameContainingIgnoreCaseAndCategoryContainingIgnoreCaseAndAuthorContainingIgnoreCase(name,category,author)
                .stream()
                .map(user -> BookMapper.toDto(user))
                .collect(Collectors.toList());
    }

    @Override
    public List<BookDto> searchByCategory(String category) {
        return bookRepository.findBookByCategoryContainingIgnoreCase(category)
                .stream()
                .map(user -> BookMapper.toDto(user))
                .collect(Collectors.toList());
    }

    @Override
    public List<BookDto> searchByNameByCategory(String name, String category) {
        return bookRepository.findBookByNameContainingIgnoreCaseAndCategoryContainingIgnoreCase(name,category)
                .stream()
                .map(user -> BookMapper.toDto(user))
                .collect(Collectors.toList());
    }

    @Override
    public List<BookDto> searchByAuthor(String author) {
        return bookRepository.findBookByAuthorContainingIgnoreCase(author)
                .stream()
                .map(user -> BookMapper.toDto(user))
                .collect(Collectors.toList());
    }


}
