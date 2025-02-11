import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class HTMLGenerator {

    public static void createIndexHTML(File currentDir, List<File> directories, List<Image> images, File mainPage) {
        //HTML kód index.html-hez
        String listDir = listDirectories(directories, mainPage, currentDir);
        String listImg = listImages(images);
        String title = currentDir.getName();
        String main = FileUtils.getRelativePath(currentDir, mainPage);

        String htmlContent = dirHTML(title, main, listDir, listImg);
        writeToFile(new File(currentDir, "index.html"), htmlContent);
    }

    public static void createImagePages(List<Image> images, File mainPage) {
        //HTML a képekhez
        for (int i = 0; i < images.size(); i++) {
            Image currentImage = images.get(i);
            Image previous = i > 0 ? images.get(i - 1) : currentImage;
            Image next = i < images.size() - 1 ? images.get(i + 1) : currentImage;

            String main = FileUtils.getRelativePath(currentImage.getParentDir(), mainPage);
            String htmlContent = imageHTML(
                    currentImage.getName(),
                    main,
                    previous.getName() + ".html",
                    next.getName() + ".html",
                    currentImage.getName(),
                    currentImage.getRelativePath()
            );

            writeToFile(new File(currentImage.getParentDir(), currentImage.getName() + ".html"), htmlContent);
        }
    }

    private static String dirHTML(String title, String mainPage, String directories, String images) {
        //HTML sablon - index.html
        return String.format("""
            <!DOCTYPE html>
            <html lang="hu">
            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>%s</title>
            </head>
            <body>
                <div style="border-bottom: 3px solid; border-color: black; padding: 10px;">
                    <a href="%s" style="font-size: 25px; font-family: 'Calibri';">Start Page</a>
                </div>
            
                <div style="border-bottom: 2px solid;">
                    <h1 style="font-size: 25px; font-family: 'Calibri';">Mappák:</h1>
                    <ul>%s</ul>
                </div>
                
                <div>
                    <h1 style="font-size: 25px; font-family: 'Calibri';">Képek:</h1>
                    <ul>%s</ul>
                </div>
            </body>
            </html>
            """, title, mainPage, directories, images);
    }

    private static String imageHTML(String title, String mainPage, String previous, String next, String imgName, String location) {
        //HTML Sablon képekhez
        return String.format("""
            <!DOCTYPE html>
            <html lang="hu">
            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>%s</title>
            </head>
            <body>
                <div style="border-bottom: 3px solid; border-color: black; padding: 10px;">
                    <a href="%s" style="font-size: 25px; font-family: 'Calibri';">Start Page</a>
                </div>
            
                <a style="display: block; padding-top: 15px;" href="index.html">^^</a>
                <div style="display: flex; align-items: center; padding-top: 15px;">
                    <a href="%s"><<</a>
                    <h4 style="margin: 0 15px; font-weight: bold;">%s</h4>
                    <a href="%s">>></a>
                </div>
            
                <a href="%s">
                    <img style="height: 30%%; width: 30%%; padding-top: 20px;" src="%s" alt="">
                </a>
            </body>
            </html>
            """, title, mainPage, previous, imgName, next, next, location);
    }

    private static String listDirectories(List<File> directories, File mainPage, File currentDir) {
        //Könyvtár listázás
        StringBuilder sb = new StringBuilder();
        if (directories.isEmpty() || !currentDir.equals(mainPage.getParentFile())) {
            sb.append("""
                <li>
                    <a href="../index.html"><<</a>
                </li>
                """);
        }

        for (File dir : directories) {
            String relativePath = FileUtils.getRelativePath(currentDir, dir);
            sb.append(String.format("""
                <li>
                    <a href="%s/index.html">%s</a>
                </li>
                """, relativePath, dir.getName()));
        }
        return sb.toString();
    }

    private static String listImages(List<Image> images) {
        //Kép listázás
        StringBuilder sb = new StringBuilder();
        for (Image img : images) {
            sb.append(String.format("""
                <li>
                    <a href="%s.html">%s</a>
                </li>
                """, img.getName(), img.getName()));
        }
        return sb.toString();
    }

    private static void writeToFile(File file, String content) {
        //Fájlba írás
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(content);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
