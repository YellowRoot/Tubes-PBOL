package books;

import java.io.Serializable;

public class Book implements Serializable {
    private int isbn;
    private String title, author, genre;
    private double price;

    public Book(int isbn, String title, String author, String genre, double price){
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.price = price;
    }

    public int getIsbn() {
        return isbn;
    }

    @Override
    public String toString(){
        return "\nISBN\t: " + isbn + "\nTitle\t: " + title +
                "\nAuthor\t: " + author + "\nGenre\t: " + genre +
                "\nPrice\t: " + price + "\n";
    }
}
