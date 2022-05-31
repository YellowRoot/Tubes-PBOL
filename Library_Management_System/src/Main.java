import books.Book;
import books.Library;

import java.io.*;
import java.util.Scanner;

public class Main {
    static String fileName = "book_library.ser";
    static Library lib = new Library();
    static Scanner in = new Scanner(System.in);
    static Boolean running = true;

    public static void main(String[] args) {
        // loads file
        loadScript();

        while (running) {
            System.out.println("""

                    ===============================
                    Select an action
                    Add a book to library\t\t[1]
                    Show a list of all books\t[2]
                    Exit\t\t\t\t\t\t[3]
                    ===============================""");
            int choice = in.nextInt();

            switch (choice) {
                case 1 -> addBook();
                case 2 -> System.out.println(lib.toString());
                case 3 -> quit();
            }
        }
        in.close();
    }

    private static void addBook() {
        int isbn;
        String title, author, genre;
        double price;

        System.out.println("\nEnter ISBN :");
        isbn = in.nextInt();
        in.nextLine(); // flush input

        System.out.println("\nEnter title :");
        title = in.nextLine();

        System.out.println("\nEnter author :");
        author = in.nextLine();

        System.out.println("\nEnter genre :");
        genre = in.nextLine();

        System.out.println("\nEnter price :");
        price = in.nextDouble();

        Book b = new Book(isbn, title, author, genre, price);
        lib.addBook(b);
    }

    private static void quit() {
        running = false;
        FileOutputStream fos;
        ObjectOutputStream oos;

        try {
            fos = new FileOutputStream(fileName);
            oos = new ObjectOutputStream(fos);

            oos.writeObject(lib);

            fos.close();
            oos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private static void loadScript() {
        FileInputStream fis;
        ObjectInputStream ois;

        File file = new File(fileName);
        if (file.exists()) {
            try {
                fis = new FileInputStream(file);
                ois = new ObjectInputStream(fis);

                lib = (Library) ois.readObject();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("File does not exist");
        }
    }
}
