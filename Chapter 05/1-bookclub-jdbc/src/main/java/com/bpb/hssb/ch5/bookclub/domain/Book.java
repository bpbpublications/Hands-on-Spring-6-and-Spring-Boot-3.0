package com.bpb.hssb.ch5.bookclub.domain;

import java.util.List;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Book {

    private int bookId;

    @NotBlank(message = "ISBN is required")
    @Pattern(regexp = "^\\d{13}$", message = "ISBN must be exactly 13 digits")
    private String isbn;

    @NotBlank(message = "Title is required")
    @Size(min = 10, max = 100, message = "Title must be between 10 and 100 characters")
    private String title;

    @NotBlank(message = "Author is required")
    @Size(min = 10, max = 100, message = "Author name must be between 10 and 100 characters")
    private String author;

    @NotNull(message = "Publication year is required")
    @Min(value = 1000, message = "Publication year must be after 1000")
    @Max(value = 9999, message = "Publication year must be before 9999")
    private int publicationYear;

    private List<BookCopy> copies;

}
