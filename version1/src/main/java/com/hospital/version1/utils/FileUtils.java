package com.hospital.version1.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileUtils {

    public static void writeToFile(String content, String filePath) throws IOException {
        File file = new File(filePath);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(content);
        }
    }

    public static boolean createFileIfNotExists(String filePath) throws IOException {
        File file = new File(filePath);
        if (!file.exists()) {
            return file.createNewFile();
        }
        return false;
    }
}
