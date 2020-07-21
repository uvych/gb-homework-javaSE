package com.geekbrains.georgy.lesson15;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Collectors;

public class MainApp15 {
    public static void main(String[] args) throws IOException {
        String pathDir = "";
        String newPath = "";
        String findText = "";

        System.out.println(getCountOfRepeat(new File(newPath), findText));

        System.out.println(stitchAllFiles(Path.of(newPath) , Path.of(pathDir)));

        List<Path> list = findFile(Path.of(pathDir));
        for (Path path : list){
            System.out.println(path.toString());
        }
    }

    public static int getCountOfRepeat(File file, String text) throws IOException {
        String pattern = "^[\\p{ASCII}]+$";
        if (!text.matches(pattern)) return 0;

        ByteBuffer bytesText = ByteBuffer.wrap(text.getBytes());
        int count = 0;

        try (RandomAccessFile src = new RandomAccessFile(file, "rw");
        FileChannel srcChannel = src.getChannel()){
            ByteBuffer byteFile = ByteBuffer.allocate(8192);
            int byteCount = srcChannel.read(byteFile);

            while (byteCount != -1){
                byteFile.flip();
                while (byteFile.hasRemaining()) {
                    int bFile = byteFile.get();
                    int bText = bytesText.get();

                    if (bFile == bText){
                        if (bytesText.limit() == bytesText.position()){
                            count++;
                            bytesText.position(0);
                        }
                    } else {
                        if (bFile == bytesText.get(0)){
                            bytesText.position(1);
                        } else {
                             bytesText.position(0);
                        }
                    }
                }
                byteFile.clear();
                byteCount = srcChannel.read(byteFile);
            }
        }
        return count;
    }

    public static long stitchAllFiles(Path newFile, Path directory) throws IOException {
        return Files.list(directory)
                .filter(s -> s.toString().endsWith(".txt"))
                .filter(Files::isRegularFile)
                .map(s -> {
                    try {
                        return Files.readAllBytes(s);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return new byte[0];
                })
                .map(s -> {
                    try {
                        return Files.write(newFile, s, StandardOpenOption.APPEND);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return null;
                })
                .count();
    }

    public static List<Path> findFile(Path directory) throws IOException {
        return Files.walk(directory)
                .filter(Files::isRegularFile)
                .filter(s -> {
                    try {
                        return Files.size(s) < 102400;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return false;
                })
                .collect(Collectors.toList());
    }
}
