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

    public String findBook(int isbn) {
        String stringReturn = null;
        for (Book book : collection) {
            String b = book.toString();
            String pattern = "ISBN\t: " + isbn;
            int intIndex = b.indexOf(pattern);

            if(intIndex == -1) {
                stringReturn = "ISBN not found";
            } else {
                stringReturn =  b;
            }
        }
        return stringReturn;
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
