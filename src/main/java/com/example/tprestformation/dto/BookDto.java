package com.example.tprestformation.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {
    private int id;
    private String isbn;
    private String name;
    private String author;
    private String category;
    private String description;
}
