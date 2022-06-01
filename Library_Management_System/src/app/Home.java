package app;

import books.Database;
import books.Library;

import javax.swing.*;

public class Home extends JFrame{
    private JButton newBookButton;
    private JButton findBookButton;
    private JButton catalogButton;
    private JButton deleteBookButton;
    private JPanel homePanel;
    private JButton saveAndExitButton;

    public Home(Library lib) {
        setTitle("Simple Library Management System");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        newBookButton.addActionListener(e -> {
            setVisible(false);
            new AddBook(lib).setVisible(true);
        });

        findBookButton.addActionListener(e -> {
            setVisible(false);
            new FindBook(lib).setVisible(true);
        });
        catalogButton.addActionListener(e -> {
            setVisible(false);
            new Catalog(lib).setVisible(true);
        });

        deleteBookButton.addActionListener(e -> {
            setVisible(false);
            new DeleteBook(lib).setVisible(true);
        });

        saveAndExitButton.addActionListener(e -> {
            Database.quit();
            dispose();
            System.exit(0);
        });

        setContentPane(homePanel);
        setVisible(true);
    }
}
