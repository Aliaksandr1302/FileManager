package com.secourse.file;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class FileExample {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\LAS");
        if (!file.exists()) {
            try {
                boolean created = file.createNewFile();
                if (created) {
                    System.out.println("Created");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println(file.getAbsolutePath());
        try {
            System.out.println(file.getCanonicalPath());
            System.out.println(file.getPath());
            System.out.println(file.getName());
            System.out.println(file.getParent());
            System.out.println(Arrays.toString(file.list()));
            System.out.println(Arrays.toString(file.listFiles()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}