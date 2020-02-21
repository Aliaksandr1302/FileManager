package com.secourse.file;

import java.io.File;
import java.io.IOException;

public class MKDirExmpl {
    public static void main(String[] args) {
        File file = new File("test\\test1", "Test.txt");
        File parent = file.getParentFile();
        parent.mkdirs();
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        file.renameTo(new File("Test.txt"));
    }
}
