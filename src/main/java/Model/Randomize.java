package main.java.Model;

import main.java.Model.Extension;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Randomize {
    private static boolean selected;
    private static Path path;

    public static void refresh() {
        selected = false;
        Randomize.path = null;
    }

    public static Path makeRandom(String path,String types) throws IOException {
        Extension.setExtensions(types);
        List<Path> list = Files.walk(Paths.get(path))
                .filter(Files::isRegularFile)
                .filter(Extension::isExist)
                .collect(Collectors.toList());
        return list.size()==0?null:list.get(new Random().nextInt(list.size()));
    }
}
