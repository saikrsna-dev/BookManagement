package Saikrishna.BookManagement;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class BookController {

    BookService bookService = new BookService();

//    @PostMapping("/book")
//    public String addBook(@RequestBody Book book){
//        try{
//            boolean added = bookService.addBook(book);
//            return "Book with id:" + book.getBookId() + " added sucessfully";
//        }
//        catch(BookAlreadyExistException ex){
//            return "unable to add book as it already exists";
//        }
//    }

    @PostMapping("/book")
    public ResponseEntity addBook(@RequestBody Book book){
        try{
            boolean added = bookService.addBook(book);
            return new ResponseEntity("Added sucessfully", HttpStatus.CREATED);
        }
        catch(BookAlreadyExistException ex){
            return new ResponseEntity("unable to add the book as it already exists", HttpStatusCode.valueOf(400));
        }
    }

    @GetMapping("/book")
    public ResponseEntity findBook(@RequestParam int id){
        try{
            Book book = bookService.getBook(id);
            return new ResponseEntity(book, HttpStatus.FOUND);
        }catch(BookNotFoundException ex){
            return new ResponseEntity("Book not found", HttpStatusCode.valueOf(404));
        }catch(Exception e){
            return new ResponseEntity("Something went wrong", HttpStatusCode.valueOf(500));
        }
    }

    @PutMapping("/update-book/{id}")
    public String updateBook(@PathVariable int id, @RequestParam(required = false) String title, @RequestParam(required = false) String author, @RequestParam(required = false) int pages){
        try{
            String response = bookService.updateBook(id, title, author, pages);
            return response;
        }catch (Exception ex){
            return "Exception occured";
        }

    }
    @DeleteMapping("remove-book/{id}")
    public ResponseEntity deleteBook(@PathVariable int id){
        try{
            bookService.deleteBook(id);
            return new ResponseEntity("book removed sucessfully", HttpStatus.OK);
        }catch(BookNotFoundException ex){
            return new ResponseEntity(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }



//    @PostMapping("/add-book")
//    public String addBook(@RequestParam int bookId, @RequestParam String title, @RequestParam String author, @RequestParam int pages){
//        Book book = new Book(bookId, title, author, pages);
//        data.put(book.getBookId(), book);
//        return "str";
//    }
    //"Book with id:" + book.getBookId() + "added sucessfully"
    //------------------------------------------------------------------------------
//    @GetMapping("/book")
//    public Book findBook(@RequestParam int id){
//        return data.get(id);
//    }
//
//    //get using path variable
//    @GetMapping("/book/{id}")
//    public Book findBooks(@PathVariable int id){
//        return data.get(id);
//    }
//    @GetMapping("/all-books")
//    public List<Book> getAllBooks(){
//        return data.values().stream().toList();
//    }
//
//    //------------------------------------------------------------------------------
//    @PutMapping("/update-book/{id}")
//    public String updateBook(@PathVariable int id, @RequestParam(required = false) String title, @RequestParam(required = false) String author, @RequestParam(required = false) int pages){
//        Book book = data.get(id);
//        if(Objects.nonNull(title)){
//            book.setTitle(title);
//        }
//        if(Objects.nonNull(author)){
//            book.setAuthor(author);
//        }
//        if(Objects.nonNull(pages)){
//            book.setPages(pages);
//        }
//        data.put(id, book);
//        return "book updated";
//    }
//    //------------------------------------------------------------------------------
//    @DeleteMapping("/remove-book/{id}")
//    public String deleteBook(@PathVariable int id){
//        data.remove(id);
//        return "book removed";
//    }
}
///////////////////////////////////////////////////////////////////////////////////////////////
/*//    @PostMapping("/add-book")
//    public String addBook(@RequestBody Book book){
//        data.put(book.getBookId(), book);
//        return "Book with id:" + book.getBookId() + " added sucessfully";
//    }

    @PostMapping("/add-book")
    public String addBook(@RequestParam int bookId, @RequestParam String title, @RequestParam String author, @RequestParam int pages){
        Book book = new Book(bookId, title, author, pages);
        data.put(book.getBookId(), book);
        return "str";
    }
    //"Book with id:" + book.getBookId() + "added sucessfully"

    @GetMapping("/find-book")
    public Book findBook(@RequestParam int id){
        return data.get(id);
    }*/