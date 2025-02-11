import java.io.File;
import java.util.List;

public class HTMLProcessor {
    private final File rootDirectory;

    public HTMLProcessor(File rootDirectory) {
        this.rootDirectory = rootDirectory;
    }

    public void processDirectory() {
        processDirectory(rootDirectory, new File(rootDirectory, "index.html"));
    }

    private void processDirectory(File currentDir, File mainPage) {
        if (!currentDir.isDirectory()) return;

        System.out.println("Feldolgozás alatt: " + currentDir.getAbsolutePath());
        
        //Könyvtár, kép listázás
        List<File> directories = FileUtils.listDirectories(currentDir);
        List<Image> images = FileUtils.listImages(currentDir);

        //HTML fájl generálás
        HTMLGenerator.createIndexHTML(currentDir, directories, images, mainPage);
        HTMLGenerator.createImagePages(images, mainPage);

        //Rekurzív feldolgozűs
        for (File subDir : directories) {
            processDirectory(new File(currentDir, subDir.getName()), mainPage);
        }
    }
}
