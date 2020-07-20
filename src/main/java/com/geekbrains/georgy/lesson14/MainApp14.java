package com.geekbrains.georgy.lesson14;

import java.io.*;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainApp14 {
    public static void main(String[] args) {

    }

    public static int getCountOfRepeat(File file, String text) {
        if (!text.matches("^[\\p{ASCII}]+$")) return 0;
        int count = 0;

        try (BufferedReader out = new BufferedReader(new FileReader(file))){
            StringBuilder fileText = new StringBuilder();

            while (out.ready()) {
                fileText.append(out.readLine());
            }
            Pattern pattern = Pattern.compile(text);
            Matcher matcher = pattern.matcher(fileText);

            while(matcher.find()) {
                count++;
            }
        } catch (IOException e){
            e.printStackTrace();
        }

        return count;
    }

    public static void stitchAllFiles(File newFile, File directory){
        for (File file : Objects.requireNonNull(directory.listFiles())){
            try (FileInputStream inputStream = new FileInputStream(file);
                 FileOutputStream out = new FileOutputStream(newFile, true)){
                int x;
                while ((x = inputStream.read()) != -1) {
                    out.write(x);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean deleteDir(File directory) {
        File[] allFile = directory.listFiles();
        if (allFile != null) {
            for (File file : allFile) {
                deleteDir(file);
            }
        }
        return directory.delete();
    }
}



