package me.zcratx.view;

import me.zcratx.controller.MainController;
import me.zcratx.model.Objective;
import me.zcratx.utils.FileManager;
import me.zcratx.utils.Messages;

import java.text.MessageFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TerminalView {

    public static void start() {
        int value = -256;
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("Welcome");
            System.out.println("-".repeat(5));
            System.out.println("0 - " + Messages.getMessage("listElement"));
            System.out.println("1 - " + Messages.getMessage("openElement"));
            System.out.println("2 - " + Messages.getMessage("newElement"));
            System.out.println("-1 - " + Messages.getMessage("close"));
            try {
                System.out.println("Input: ");
                value = input.nextInt();
            } catch (InputMismatchException e) {
                //TODO Make a loop until correct selection happen
            }
            switch (value) {
                case -1:
                    System.out.println("Good Bye!");
                    System.out.close();
                    break;
                case 0:
                    System.out.println("READING FILES\n" + "-".repeat(5));
                    MainController.listAllObjective().forEach(objective -> System.out.println(objective));
                    break;
                case 1:
                    System.out.println(Messages.getMessage("fileSelect"));
                    String fileName = input.next();
                    Objective objective = MainController.openObjective(fileName);
                    if (objective != null) {
                        showObjective(objective);
                    } else {
                        System.out.println(Messages.getMessage("fileNotExist"));
                    }
                    break;
                case 2:
                    Objective objective1 = null;
                    do {
                        String s = askUserToWrite(Messages.getMessage("specific")),
                                m = askUserToWrite(Messages.getMessage("measurable")),
                                a = askUserToWrite(Messages.getMessage("attainable")),
                                r = askUserToWrite(Messages.getMessage("relevant")),
                                t = askUserToWrite(Messages.getMessage("timeBound"));
                        objective1 = new Objective(s, m, a, r, t, null);
                        showObjective(objective1);
                        System.out.println("-".repeat(10) + Messages.getMessage("saveObjective") + " " + Messages.isCorrect());
                    } while (!input.next().equalsIgnoreCase(Messages.getMessage("yes")));
                    FileManager.save(objective1);
                    break;
                default:
                    System.out.println(Messages.getMessage("invalidOption"));

            }
        } while (value != -1);


    }


    private static String askUserToWrite(String message) {
        Scanner input = new Scanner(System.in);
        String userInput = "";
        do {
            System.out.println(message + ": ");
            userInput = input.next() + input.nextLine();
            System.out.println( Messages.getMessage("isCorrect") + " " + Messages.isCorrect() +" " + userInput);
        } while (!input.next().equalsIgnoreCase(Messages.getMessage("yes")));
        return userInput;
    }

    private static void showObjective(Objective objective) {
        System.out.println(MessageFormat.format("{11}\n{10}\n{0}:    {1}\n{2}:    {3}\n{4}:    {5}\n{6}:  {7}\n{8}:  {9}\n{10}",
                Messages.getMessage("specific"), objective.getSpecific(),
                Messages.getMessage("measurable"), objective.getMeasurable(),
                Messages.getMessage("attainable"), objective.getAttainable(),
                Messages.getMessage("relevant"), objective.getRelevant(),
                Messages.getMessage("timeBound"), objective.getTimeBound(), "-".repeat(10),Messages.getMessage("objective"))
                );
    }

}
