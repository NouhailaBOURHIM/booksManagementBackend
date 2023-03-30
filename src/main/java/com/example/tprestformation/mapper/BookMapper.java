package com.example.tprestformation.mapper;

import com.example.tprestformation.dto.BookDto;
import com.example.tprestformation.entity.Book;
import org.modelmapper.ModelMapper;

public class BookMapper {
    public static final ModelMapper MODEL_MAPPER=new ModelMapper();

    public static BookDto toDto(Book book)
    {
        return MODEL_MAPPER.map(book, BookDto.class);
    }

    public static Book toEntity(BookDto bookDto)
    {
        return MODEL_MAPPER.map(bookDto, Book.class);
    }
}
