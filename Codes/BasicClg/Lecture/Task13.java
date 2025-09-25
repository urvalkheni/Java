import java.nio.file.Path;
import java.nio.file.Paths;
public class Task13 {
    public static void main(String[] args) {
        Path p = Paths.get("D:\\Java\\Codes\\BasicClg\\Lecture\\abc.txt");
        System.out.println("File Name: " + p.getFileName());
        System.out.println("Name Count: " + p.getNameCount());
        System.out.println("Parent: " + p.getParent());
        System.out.println("Root: " + p.getRoot());
        System.out.println("Absolute Path: " + p.toAbsolutePath());

        System.out.println("File System: " + p.getFileSystem());
        System.out.println("Is Absolute: " + p.isAbsolute());
        System.out.println("URI: " + p.toUri());
        System.out.println("Path String: " + p.toString());
        System.out.println("File Name (again): " + p.getFileName());
        // getName(-1) will throw IllegalArgumentException, so handle it
        try {
            System.out.println("getName(-1): " + p.getName(-1));
        } catch (IllegalArgumentException e) {
            System.out.println("getName(-1): Exception - " + e.getMessage());
        }
        // subpath(0,3) may throw exception if name count < 3
        try {
            System.out.println("Subpath(0,3): " + p.subpath(0, 3));
        } catch (IllegalArgumentException | IndexOutOfBoundsException e) {
            System.out.println("Subpath(0,3): Exception - " + e.getMessage());
        }
    }
}


