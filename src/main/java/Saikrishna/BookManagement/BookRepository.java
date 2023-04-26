package Saikrishna.BookManagement;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class BookRepository {
    Map<Integer, Book> data = new HashMap<>();

    public boolean add(Book book){
        data.put(book.getBookId(), book);
        return true;
    }

    public Optional<Book> getById(int id){
        if(data.containsKey(id)){
            return Optional.of(data.get(id));
        }
        return Optional.empty();
    }

//    public void updateBook(Book book){
//        data.put(book.getBookId(), book);
//    }
    public void removeById(int id){
        data.remove(id);
    }
}
