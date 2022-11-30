package com.elbers.Ue4.A3_MVC_untersuchen_und_umsetzen;

import com.elbers.Ue4.A4_Schichtarchitektur_entwickeln.DataController;

public class MVCTestDrive {
    public static void main(String[] args) {
        //DataModel model = new DataModel();
        DataController model = new DataController();
        TableView tableView = new TableView(model);
        PieChartView pieChartView = new PieChartView(model);
        BarChartView barChartView = new BarChartView(model);
    }
}
