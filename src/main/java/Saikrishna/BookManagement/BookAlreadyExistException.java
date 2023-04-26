package Saikrishna.BookManagement;

public class BookAlreadyExistException extends RuntimeException{
    public BookAlreadyExistException(int id) {
        super("Book for id: " + id + " already exists in database");
    }
}
