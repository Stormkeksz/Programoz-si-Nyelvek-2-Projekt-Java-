import java.io.File;

public class Image {
    private final String name;
    private final String relativePath;
    private final File parentDir;

    public Image(File file) {
        this.name = file.getName();
        this.relativePath = FileUtils.getRelativePath(file.getParentFile(), file);
        this.parentDir = file.getParentFile();
    }

    public String getName() {
        return name.split("\\.")[0]; //kiterjesztés nélkül
    }

    public String getRelativePath() {
        return relativePath;
    }

    public File getParentDir() {
        return parentDir;
    }
}
