package app;

import books.Library;

import javax.swing.*;

public class DeleteBook extends JFrame{
    private JPanel deleteBookPanel;
    private JTextField tfIsbn;
    private JButton searchButton;
    private JButton closeButton;

    public DeleteBook(Library lib) {
        setContentPane(deleteBookPanel);
        setTitle("Simple Library Management System");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        searchButton.addActionListener(e -> {
            int isbn = Integer.parseInt(tfIsbn.getText());

            String res = lib.deleteBook(isbn);

            JOptionPane.showMessageDialog(null, res);
            setVisible(false);
            new DeleteBook(lib).setVisible(true);
        });

        closeButton.addActionListener(e -> {
            setVisible(false);
            new Home(lib).setVisible(true);
        });
    }
}
