package com.elbers.Ue4.A3_MVC_untersuchen_und_umsetzen;

public class TableViewController implements IControllerInterface {
    private IModelInterface m_model;
    private TableView m_tableView;

    public TableViewController(IModelInterface model, TableView tableView) {
        m_model = model;
        m_tableView = tableView;
    }

    public void setValues(String red, String green, String blue) {
        int r = 0;
        int g = 0;
        int b = 0;
        r = Integer.parseInt(red);
        g = Integer.parseInt(green);
        b = Integer.parseInt(blue);
        m_model.setRedValue(r);
        m_model.setGreenValue(g);
        m_model.setBlueValue(b);
    }
}
