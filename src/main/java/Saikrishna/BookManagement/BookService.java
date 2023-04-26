package Saikrishna.BookManagement;

import java.util.Objects;
import java.util.Optional;

public class BookService {
    BookRepository bookRepositary = new BookRepository();
    public boolean addBook(Book book) throws BookAlreadyExistException{
        Optional<Book> bookOpt = bookRepositary.getById(book.getBookId());
        if(bookOpt.isPresent()){
            throw new BookAlreadyExistException(book.getBookId());
        }

        return bookRepositary.add(book);
    }
    public Book getBook(int id){
        Optional<Book> bookOpt = bookRepositary.getById(id);
        if(bookOpt.isEmpty()){
            throw new BookNotFoundException(id);
        }
        return bookOpt.get();
    }

    public String updateBook(int id, String title, String author, int pages){
//        Optional<Book> bookOpt = bookRepositary.getById();
        try{
            Book book = getBook(id);
            if(Objects.nonNull(title)){
                book.setTitle(title);
            }
            if(Objects.nonNull(author)){
                book.setAuthor(author);
            }
            if(Objects.nonNull(pages)){
                book.setPages(pages);
            }
            bookRepositary.add(book);
            return "book updated";
        }catch (BookNotFoundException ex){
            Book book = new Book(id, title, author, pages);
            bookRepositary.add(book);
            return "book created";
        }
    }

    public boolean deleteBook(int id){
        Optional<Book> bookOpt = bookRepositary.getById(id);
        if(bookOpt.isEmpty()){
            throw new BookNotFoundException(id);
        }
        bookRepositary.removeById(id);
        return true;
    }
}

