package com.secourse.file;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class FileGid {
    private StringBuilder currentPath = new StringBuilder();
    private Scanner scanner = new Scanner(System.in);

    public File pave() {
        while (true) {
            try {
                choiceRoot();
                printCurFileContent();
                run();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                currentPath = new StringBuilder();
            }
        }
    }

    private File run() {
        while (true) {
            String input = scanner.nextLine();
            implInput(input);
            printCurFileContent();
        }
    }


    private void implInput(String input) {
        input = input.trim();
        if (input.startsWith("cd ")) {
            input = input.substring(3);
            input = input.trim();
            String[] pathParts = input.split("\\\\");
            for (String path : pathParts) {
                if (path.equals("..")) {
//                    String newPath = currentPath.toString().replaceAll("\\\\[a-zA-Z0-9]*\\\\$", "\\");
//                    currentPath = new StringBuilder(newPath);
                    int slashIndex = currentPath.lastIndexOf("\\");
                    if (slashIndex != -1) {
                        currentPath.delete(slashIndex - 1, currentPath.length());
                        slashIndex = currentPath.lastIndexOf("\\");
                        currentPath.delete(slashIndex + 1, currentPath.length());
                    } else {
                        choiceRoot();
                    }
                } else {
                    currentPath.append(path).append("\\");
                }
            }
        }
    }


    private void choiceRoot() {
        File[] roots = File.listRoots();
        System.out.println(Arrays.toString(roots));
        String input = scanner.nextLine();
        for (File file : roots) {
            String path = file.getPath();
            if (path.startsWith(input) || path.equalsIgnoreCase(input)) {
                currentPath.append(path);
                return;
            }
        }
    }

    private void printCurFileContent() {
        File file = new File(currentPath.toString());
        if (!file.exists()) {
            throw new IllegalStateException("File do not exists");
        }
        File[] files = file.listFiles();
        if (files != null) {
            for (File innerFile : files) {
                System.out.println(innerFile);
            }
        } else {
            System.out.println("Directory is empty");
        }
    }


    public static void main(String[] args) {
        FileGid gid = new FileGid();
        gid.pave();
//        String s = "adwqa\\awdawfgvesrvgfer\\qwe\\";
//        Pattern pattern = Pattern.compile("\\\\[a-zA-Z0-9]*\\\\$");
//        Matcher matcher = pattern.matcher(s);
//        System.out.println(matcher.group());
//
////        dqwedweq\werfgergfvewr\fcwe\
//
//
    }
}
