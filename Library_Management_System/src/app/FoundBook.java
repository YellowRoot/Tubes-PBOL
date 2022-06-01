package app;

import books.Library;

import javax.swing.*;

public class FoundBook extends JFrame {
    private JPanel foundBookPanel;
    private JLabel tfIsbn;
    private JLabel tfTitle;
    private JLabel tfAuthor;
    private JLabel tfGenre;
    private JLabel tfPrice;
    private JButton closeButton;

    public FoundBook(Library lib, int index) {
        tfIsbn.setText(Integer.toString(lib.get(index).getIsbn()));
        tfTitle.setText(lib.get(index).getTitle());
        tfAuthor.setText(lib.get(index).getAuthor());
        tfGenre.setText(lib.get(index).getGenre());
        tfPrice.setText(Double.toString(lib.get(index).getPrice()));

        setContentPane(foundBookPanel);
        setTitle("Simple Library Management System");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        closeButton.addActionListener(e -> {
            setVisible(false);
            new Home(lib).setVisible(true);
        });
    }
}
