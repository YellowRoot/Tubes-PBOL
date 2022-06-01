package app;

import books.Library;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

public class Catalog extends JFrame {
    private JPanel cataloguePanel;
    private JTable jtCatalog;
    private JScrollPane jspCatalog;
    private JButton closeButton;

    public Catalog(Library lib) {
        setTitle("Simple Library Management System");

        TableModel dataModel = new
                AbstractTableModel() {
                    public final String[] COLUMNS = {"ISBN", "Title", "Author", "Genre", "Price"};

                    public int getRowCount() {
                        return lib.size();
                    }

                    public int getColumnCount() {
                        return COLUMNS.length;
                    }

                    public Object getValueAt(int row, int col) {
                        return switch (col) {
                            case 0 -> lib.get(row).getIsbn();
                            case 1 -> lib.get(row).getTitle();
                            case 2 -> lib.get(row).getAuthor();
                            case 3 -> lib.get(row).getGenre();
                            case 4 -> lib.get(row).getPrice();
                            default -> "-";
                        };
                    }

                    public String getColumnName(int column) {
                        return COLUMNS[column];
                    }

                    public Class<?> getColumnClass(int col) {
                        if (getValueAt(0, col) != null) {
                            return getValueAt(0, col).getClass();
                        } else {
                            return Object.class;
                        }
                    }
                };

        jtCatalog.setModel(dataModel);

        setContentPane(cataloguePanel);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);


        closeButton.addActionListener(e -> {
            setVisible(false);
            new Home(lib).setVisible(true);
        });
    }
}
