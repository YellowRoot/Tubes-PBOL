import app.Home;
import books.Database;
import books.Library;

import javax.swing.*;

public class Main {
    public static Home hMenu;
    private static final Library lib = new Library();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Database.loadScript();
            Main.hMenu = new Home(lib);
        });
    }
}