package com.example.tprestformation.controller;

import ch.qos.logback.core.model.Model;
import com.example.tprestformation.dto.BookDto;
import com.example.tprestformation.service.BookService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/books")
@CrossOrigin(origins = "http://localhost:4200/")
public class BookController {
    @Autowired
    BookService bookService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookDto addBook(@RequestBody BookDto bookDto)
    {
        return bookService.addBook(bookDto);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BookDto getBookById(@PathVariable("id") int id) throws Exception {
        return bookService.getById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<BookDto> getAllBooks()
    {
        return bookService.getAllBooks();
    }

    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookDto updateBook(@RequestBody BookDto bookDto) throws Exception{
        return bookService.updateBook(bookDto);   }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBookById(@PathVariable("id") int id) throws Exception {
        bookService.deleteBook(id);
    }

    @GetMapping("/search")
    public Set<BookDto> searchBook(@RequestParam(value = "name") String name, @RequestParam(value = "categories") String categories)
    {
        Set<BookDto> searchedBooks=new HashSet<>();
        if(name!=null && categories!=null)
        {
            for(String category: categories.split(","))
            {
                searchedBooks.addAll(bookService.searchByNameByCategory(name,category));
            }
            return searchedBooks;
        }
        else if(name!=null){
            searchedBooks.addAll(bookService.searchByName(name));
            return searchedBooks;
        }
        else if(categories!=null)
        {
            for(String category: categories.split(","))
            {
                searchedBooks.addAll(bookService.searchByCategory(category));
            }
            return searchedBooks;
        }
        return Collections.EMPTY_SET;
    }
    @GetMapping("/name/{name}")
    public List<BookDto> searchByName(@PathVariable("name") String name){
        return bookService.searchByName(name);
    }

    @GetMapping("/category/{category}")
    public List<BookDto> searchByCategory(@PathVariable("category") String category){
        return bookService.searchByCategory(category);
    }

    @GetMapping("/author/{author}")
    public List<BookDto> searchByAuthor(@PathVariable("author") String author){
        return bookService.searchByAuthor(author);
    }
}
