package com.example.tprestformation;

import com.example.tprestformation.dto.BookDto;
import com.example.tprestformation.entity.Book;
import com.example.tprestformation.exception.BookNotFoundException;
import com.example.tprestformation.service.BookService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.Ignore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class TpRestFormationApplicationTests {
  /* @Autowired
   private MockMvc mockMvc;
   @Autowired
   private ObjectMapper objectMapper;
   @MockBean
   BookService bookService;

   private BookDto firstBook,secondBook,bookDto;

    @Test
    void contextLoads() {
    }
    @BeforeEach
    public void setup()
    {
        bookDto=new BookDto("D77882","Clean Code","19/08/200");
        firstBook=new BookDto("C78963","Secops","15/05/1998r");
        secondBook=new BookDto("C45321","Docker","07/03/2005");
    }

    @Test
    public void shouldAddBook() throws Exception {
        String uri="/books";
        when(bookService.addBook(any(BookDto.class))).thenReturn(bookDto);
        String expectedJson = objectMapper
                .writeValueAsString(bookDto);
        this.mockMvc.perform(MockMvcRequestBuilders.post(uri)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(expectedJson))
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("isbn").value(bookDto.getIsbn()))
                .andExpect(MockMvcResultMatchers.jsonPath("titre").value(bookDto.getTitre()))
                .andExpect(MockMvcResultMatchers.jsonPath("dateApparition").value(bookDto.getDateApparition()));
    }

    @Test
    public void shouldGetBook() throws Exception {
        String uri="/books/{id}";
        when(bookService.getByISBN(anyString())).thenReturn(bookDto);
        this.mockMvc.perform(MockMvcRequestBuilders.get(uri,"D77882")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("isbn").value(bookDto.getIsbn()))
                .andExpect(MockMvcResultMatchers.jsonPath("titre").value(bookDto.getTitre()))
                .andExpect(MockMvcResultMatchers.jsonPath("dateApparition").value(bookDto.getDateApparition()));
    }

    @Test
    public void whenGetBook_thenThrowBookNotFoundException() throws Exception {
        when(bookService.getByISBN(anyString())).thenThrow(new BookNotFoundException("Book does not exist"));

        this.mockMvc.perform(MockMvcRequestBuilders.get("/books/{id}", "h4587")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(MockMvcResultMatchers.content().string(Matchers.equalTo("Book does not exist")));
    }

    @Test
    public void shouldGetAllBooks() throws Exception {
        String uri="/books";
        List<BookDto> listBook = new ArrayList<>();
        listBook.add(firstBook);
        listBook.add(secondBook);
        when(bookService.getAllBooks()).thenReturn(listBook);
        this.mockMvc.perform(MockMvcRequestBuilders.get(uri)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].isbn").value(firstBook.getIsbn()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].titre").value(firstBook.getTitre()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].dateApparition").value(firstBook.getDateApparition()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].isbn").value(secondBook.getIsbn()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].titre").value(secondBook.getTitre()))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].dateApparition").value(secondBook.getDateApparition()));
    }

    @Test
    public void shouldUpdateBook() throws Exception {
        String uri="/books";
        String expectedJson = objectMapper
                .writeValueAsString(firstBook);
        when(bookService.updateBook(any(BookDto.class))).thenReturn(firstBook);
        this.mockMvc.perform(MockMvcRequestBuilders.put(uri)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(expectedJson))
                .andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("isbn").value(firstBook.getIsbn()))
                .andExpect(MockMvcResultMatchers.jsonPath("titre").value(firstBook.getTitre()))
                .andExpect(MockMvcResultMatchers.jsonPath("dateApparition").value(firstBook.getDateApparition()));
    }
    @Ignore
    @Test
    public void shouldDeleteBook() throws Exception {
        doNothing().when(bookService).deleteBook(anyString());
        this.mockMvc.perform(MockMvcRequestBuilders.delete("/books/{id}","D77882"))
                .andExpect(status().isNoContent());
    }
*/
}
