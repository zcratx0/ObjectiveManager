package me.zcratx;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import me.zcratx.model.Objective;
import me.zcratx.utils.FileManager;
import me.zcratx.utils.Messages;
import me.zcratx.view.TerminalView;

import java.util.Locale;

public class Main {
    public static void main(String[] args) throws JsonProcessingException {
        System.out.println("Hello World");
        ObjectMapper mapper = new ObjectMapper();
        Messages.loadLanguage(new Locale("es"));
//
//        Objective newObjective = new Objective("Crear un programa para anotar SMART");
//        System.out.println(FileManager.save(newObjective));
//        System.out.println(FileManager.load("1709625944524"));
        TerminalView.start();
    }
}