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

    public int findBook(int isbn) {
        int intReturn = -1;

        for (Book book : collection) {
            String b = book.toString();

            if (book.getIsbn() == isbn) {
                intReturn =  collection.indexOf(book);
                break;
            }
        }
        return intReturn;
    }

    public String deleteBook(int isbn) {
        String stringReturn = null;

        for (Book book : collection) {
            if (book.getIsbn() == isbn) {
                collection.remove(book);
                stringReturn = "\nThe book with the ISBN : " + isbn + " has been removed";
                break;
            } else {
                stringReturn = "ISBN not found";
            }
        }
        return stringReturn;
    }

    public int size() {
        return collection.size();
    }

    public Book get(int index) {
        return collection.get(index);
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
