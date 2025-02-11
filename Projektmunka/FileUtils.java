import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {
    //Almappák listázása
    public static List<File> listDirectories(File parentDir) {
        File[] files = parentDir.listFiles();
        List<File> directories = new ArrayList<>();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    directories.add(file);
                }
            }
        }
        return directories;
    }
    //Képek listázása
    public static List<Image> listImages(File parentDir) {
        File[] files = parentDir.listFiles();
        List<Image> images = new ArrayList<>();
        if (files != null) {
            for (File file : files) {
                if (isImage(file)) {
                    images.add(new Image(file));
                }
            }
        }
        return images;
    }

    public static boolean isImage(File file) {
        String name = file.getName().toLowerCase();
        return name.endsWith(".jpg") || name.endsWith(".jpeg") || name.endsWith(".png") || name.endsWith(".gif");
    }
    //Relatív út
    public static String getRelativePath(File base, File target) {
        return base.toPath().relativize(target.toPath()).toString();
    }
}
