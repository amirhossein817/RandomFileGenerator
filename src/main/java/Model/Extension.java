package main.java.Model;

import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class Extension {
    private static List<String> extensions;

    public static void setExtensions(String extension) {
        extensions = Arrays.asList(extension.replaceAll(" ","").split("[,]"));
    }

    public static boolean isExist(Path path) {
        for( String extension : extensions){
            if (path.toString().endsWith(extension))
                return true;
        }
        return false;
    }
}
