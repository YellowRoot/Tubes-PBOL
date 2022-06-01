package app;

import books.Book;
import books.Library;

import javax.swing.*;

public class AddBook extends JFrame{
    private JPanel addBookPanel;
    private JButton saveButton;
    private JButton closeButton;
    private JTextField tfIsbn;
    private JTextField tfTitle;
    private JTextField tfAuthor;
    private JTextField tfGenre;
    private JTextField tfPrice;

    public AddBook(Library lib) {
        setContentPane(addBookPanel);
        setTitle("Simple Library Management System");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        saveButton.addActionListener(e -> {
            int isbn = Integer.parseInt(tfIsbn.getText());
            String title = tfTitle.getText();
            String author = tfAuthor.getText();
            String genre = tfGenre.getText();
            double price = Double.parseDouble(tfPrice.getText());

            Book b = new Book(isbn, title, author, genre, price);
            lib.addBook(b);

            JOptionPane.showMessageDialog(null, "Book successfully added");
            setVisible(false);
            new AddBook(lib).setVisible(true);
        });

        closeButton.addActionListener(e -> {
            setVisible(false);
            new Home(lib).setVisible(true);
        });
    }
}
