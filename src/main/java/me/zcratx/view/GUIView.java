package me.zcratx.view;

import me.zcratx.controller.MainController;
import me.zcratx.model.Objective;
import me.zcratx.utils.Messages;

import javax.swing.*;
import java.awt.*;

public class GUIView {

    public static void start() {
        GUI gui = new GUI(MainController.openObjective("1709672231742.json"));
    }

}

class GUI extends JFrame {
    public GUI(Objective objective) {
        JPanel panel = new JPanel();

        GridLayout layout = new GridLayout(2, 1);

        BoxLayout layoutMain = new BoxLayout(panel, BoxLayout.Y_AXIS);
        panel.setLayout(layoutMain);

        JLabel lblSpecific = new JLabel(Messages.getMessage("specific"));
        lblSpecific.setFont(lblSpecific.getFont().deriveFont(18f));
        JTextField txtSpecific = lblText(objective.getSpecific());

        JLabel lblMeasurable = new JLabel(Messages.getMessage("measurable"));
        lblMeasurable.setFont(lblMeasurable.getFont().deriveFont(18f));
        JTextField txtMeasurable = lblText(objective.getMeasurable());

        JLabel lblAttainable = new JLabel(Messages.getMessage("attainable"));
        lblAttainable.setFont(lblAttainable.getFont().deriveFont(18f));
        JTextField txtAttainable = lblText(objective.getAttainable());

        JLabel lblRelevant = new JLabel(Messages.getMessage("relevant"));
        lblRelevant.setFont(lblRelevant.getFont().deriveFont(18f));
        JTextField txtRelevant = lblText(objective.getRelevant());

//        panel.setLayout(layoutMain);

        JPanel panelSpecific = new JPanel();
        panelSpecific.setLayout(layout);

        panelSpecific.add(lblSpecific);
        panelSpecific.add(txtSpecific);
        panel.add(panelSpecific);

        JPanel panelMeasurable = new JPanel();
        panelMeasurable.setLayout(layout);

        panelMeasurable.add(lblMeasurable);
        panelMeasurable.add(txtMeasurable);
        panel.add(panelMeasurable);

        JPanel panelAttainble = new JPanel();
        panelAttainble.setLayout(layout);
        panelAttainble.add(lblAttainable);
        panelAttainble.add(txtAttainable);
        panel.add(panelAttainble);

        JPanel panelRelevant = new JPanel();
        panelRelevant.setLayout(layout);
        panelRelevant.add(lblRelevant);
        panelRelevant.add(txtRelevant);
        panel.add(panelRelevant);

        setContentPane(panel);
        setSize(500, 400);
        setMinimumSize(new Dimension(500, 400));
        setTitle("OBJETIVO");
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public JTextField lblText(String text) {
        Font f = new Font("serif", Font.PLAIN, 18);
        JTextField field = new JTextField(text, 32);
        field.setFont(f);
        return field;
    }

}

