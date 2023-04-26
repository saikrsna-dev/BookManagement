package Saikrishna.BookManagement;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Book {
    private int bookId;
    private String title;
    private String author;
    private int pages;

    public Book(int id, String title, String author, int pages) {
        this.bookId = id;
        this.title = title;
        this.author = author;
        this.pages = pages;
    }
}
