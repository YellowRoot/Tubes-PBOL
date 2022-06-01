package books;

import java.io.*;

public class Database {
    private static final String fileName = "book_library.ser";
    private static Library lib = new Library();

    public static void loadScript() {
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

    public static void quit() {
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
}
