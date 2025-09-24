import java.nio.file.Path;
import java.nio.file.Paths;
public class Task13 {
    public static void main(String[] args) {
        Path p = Paths.get("D:\\Java\\Codes\\BasicClg\\Lecture\\abc.txt");
        System.out.println(p.getFileName());
        System.out.println(p.getNameCount());
        System.out.println(p.getParent());
        System.out.println(p.getRoot());
        System.out.println(p.toAbsolutePath());
        
        System.out.println(p.getFileSystem());
        System.out.println(p.isAbsolute());
        System.out.println(p.toUri());
        System.out.println(p.toString());
        System.out.println(p.getFileName());
        System.out.println(p.getName(-1));
        System.out.println(p.subpath(0,3));
    }
}


