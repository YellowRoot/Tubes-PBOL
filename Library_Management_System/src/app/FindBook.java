package app;

import books.Library;

import javax.swing.*;

public class FindBook extends JFrame{
    private JPanel findBookPanel;
    private JTextField tfIsbn;
    private JButton searchButton;
    private JButton closeButton;

    public FindBook(Library lib) {
        setContentPane(findBookPanel);
        setTitle("Simple Library Management System");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        searchButton.addActionListener(e -> {
            int isbn = Integer.parseInt(tfIsbn.getText());

            int index = lib.findBook(isbn);

            if (index != -1) {
                setVisible(false);
                new FoundBook(lib, index).setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "ISBN not found!");
                setVisible(false);
                new FindBook(lib).setVisible(true);
            }
        });

        closeButton.addActionListener(e -> {
            setVisible(false);
            new Home(lib).setVisible(true);
        });
    }
}
