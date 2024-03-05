package me.zcratx.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import me.zcratx.model.Objective;

import java.io.*;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;


public class FileManager {

    static String filePath = "stored/";
    static ObjectMapper mapper = new ObjectMapper();

    // Add a function to check if folder exist and create if not.
    public static boolean folderCheck() {
        boolean status = false;
        if (Files.exists(Paths.get(filePath))) {
            System.out.println("Folder already exists!");
            return true;
        }
        try {
            Files.createDirectory(Paths.get(filePath)).getFileName();
            System.out.println("Folder created!");
            status = true;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return status;

    }

    public static ArrayList<String> readAllFiles() {
        ArrayList<String> files = new ArrayList<>();
        try {
            Files.list(Paths.get(filePath)).forEach(
                    path -> {
                        files.add(String.valueOf(path.getFileName()));
                    }
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return files;
    }


    public static boolean save(Objective objetive) {
        boolean result = false;
        String value = null;
        //TODO Fix the Try Mess.
        try {
            value = mapper.writeValueAsString(objetive);
            // Convert String to Byte
            byte[] bytes = value.getBytes();

            // Create the file
            FileOutputStream file = null;
            try {
                folderCheck();
                String fileName = filePath + System.currentTimeMillis() + ".json";
                file = new FileOutputStream(fileName);
                try {
                    // Save the file
                    file.write(bytes);
                    file.close();
                    result = true;
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public static Objective load(String path) {
        Objective objective = null;
        try {
            // Read the file
            //TODO Add a checker if the extension is in the path.
            InputStream file = new FileInputStream(filePath + path);
            byte[] data = file.readAllBytes();
            objective = mapper.readValue(data, Objective.class);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return objective;
    }



}
