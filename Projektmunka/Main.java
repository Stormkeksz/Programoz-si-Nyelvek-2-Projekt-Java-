import java.io.File;

public class Main {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Hiba: Adjon meg egy könyvtár elérési útját!");
            System.exit(1);
        }

        File rootDir = new File(args[0]);
        if (!rootDir.exists() || !rootDir.isDirectory()) {
            System.err.println("Hiba: A megadott útvonal nem létezik vagy nem könyvtár!");
            System.exit(1);
        }
        HTMLProcessor processor = new HTMLProcessor(rootDir);   //HTML 
        processor.processDirectory();   //Könyvtár feldolgozás
        System.out.println("Generálás kész!");
    }
}
