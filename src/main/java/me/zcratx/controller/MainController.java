package me.zcratx.controller;

import me.zcratx.model.Objective;
import me.zcratx.utils.FileManager;

import java.nio.file.Files;
import java.util.ArrayList;

public class MainController {

    public static ArrayList listAllObjective() {
        return FileManager.readAllFiles();
    }

    public static Objective openObjective(String path) {
        if (!path.endsWith(".json")) path = path  + ".json";
        return FileManager.load(path);
    }

    public static void createObjective(String s, String m, String a, String r, String t) {
        Objective objective = new Objective(s, m, a, r, t, null);
        FileManager.save(objective);
    }




}
