import java.io.File;

public class Clean {

    public static void deleteGeneratedFiles(File directory) {
        //Rekurzív ".html" fájl törlés
        if (directory.isDirectory()) {
            for (File file : directory.listFiles()) {
                if (file.isDirectory()) {
                    deleteGeneratedFiles(file);
                } else if (file.getName().endsWith(".html")) {
                    if (file.delete()) {
                        System.out.println(file.getAbsolutePath() + " Torolve!");
                    } else {
                        System.out.println("Torles sikertelen: " + file.getAbsolutePath());
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Hiba: Nem adtal meg egy konyvtarat se!");
            System.exit(1);
        }

        File rootDirectory = new File(args[0]);

        if (!rootDirectory.exists() || !rootDirectory.isDirectory()) {
            System.out.println("Hiba: A megadott eleresu it nem konyvtar!");
            System.exit(1);
        }

        System.out.println("Generalt fajlok torlese: " + rootDirectory.getAbsolutePath());
        deleteGeneratedFiles(rootDirectory);
        System.out.println("Torles befejezve!");
    }
}
