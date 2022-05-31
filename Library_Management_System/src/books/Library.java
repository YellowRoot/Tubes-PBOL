package books;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Library implements Serializable {
    private List<Book> collection;

    public Library(){
        collection = new ArrayList<>();
    }

    public void addBook(Book book){
        collection.add(book);
    }

    @Override
    public String toString(){
        StringBuilder books = new StringBuilder("\n");

        for (Book book : collection) {
            books.append(book.toString());
        }

        return books.toString();
    }
}
