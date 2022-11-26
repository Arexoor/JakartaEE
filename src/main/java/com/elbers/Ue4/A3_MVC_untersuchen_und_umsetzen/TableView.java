package com.elbers.Ue4.A3_MVC_untersuchen_und_umsetzen;

import javax.swing.*;
import java.awt.*;

public class TableView implements IObserverInterface {
    private IModelInterface m_model;
    private IControllerInterface m_controller;

    JFrame viewFrame;
    JPanel viewPanel;
    JTextField redTextField;
    JTextField greenTextField;
    JTextField blueTextField;
    JButton setButton;

    public TableView(IModelInterface model) {
        createComponents();
        m_model = model;
        m_model.registerObserver(this);
        m_controller = new TableViewController(m_model, this);
    }

    public void createComponents() {
        viewPanel = new JPanel();
        viewFrame = new JFrame("View");
        redTextField = new JTextField(10);
        greenTextField = new JTextField(10);
        blueTextField = new JTextField(10);
        setButton = new JButton("Set");
        setButton.addActionListener(e -> {
            m_controller.setValues(redTextField.getText(), greenTextField.getText(), blueTextField.getText());
        });
        viewPanel.add(redTextField);
        viewPanel.add(greenTextField);
        viewPanel.add(blueTextField);
        viewPanel.add(setButton);

        viewFrame.setLocationRelativeTo(null);
        viewFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        viewFrame.getContentPane().add(viewPanel,BorderLayout.CENTER);

        viewFrame.pack();
        viewFrame.setVisible(true);
    }

    public void update() {
        // wird nicht benötigt
    }
}
