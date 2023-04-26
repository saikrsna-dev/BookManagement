package Saikrishna.BookManagement;

public class BookNotFoundException extends RuntimeException{
    BookNotFoundException(int id){
        super("Book with the " + id + " not exists in the database.");
    }
}
