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

            if (book.getIsbn() == isbn) {
                stringReturn =  b;
                break;
            } else {
                stringReturn = "\nISBN not found";
            }
        }
        return stringReturn;
    }

    public String deleteBook(int isbn) {
        String stringReturn = null;

        for (Book book : collection) {
            if (book.getIsbn() == isbn) {
                collection.remove(book);
                stringReturn = "\nThe book with the ISBN : " + isbn + " has been removed";
                break;
            } else {
                stringReturn = "\nISBN not found";
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
