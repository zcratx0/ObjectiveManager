package me.zcratx;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import me.zcratx.model.Objective;
import me.zcratx.utils.FileManager;
import me.zcratx.utils.Messages;
import me.zcratx.view.GUIView;
import me.zcratx.view.TerminalView;

import java.util.Locale;

public class Main {
    public static void main(String[] args) throws JsonProcessingException {
        System.out.println("Hello World");
        ObjectMapper mapper = new ObjectMapper();
        Messages.loadLanguage(new Locale("en"));

        if (args != null) {
            switch (args[0]) {
                case "-t":
                    TerminalView.start();
                    break;
                case "-g":
                    GUIView.start();
                    break;
            }
        } else {
            System.out.println("Utilize arguments: -t for terminal view, -g for GUI view");
        }
    }
}