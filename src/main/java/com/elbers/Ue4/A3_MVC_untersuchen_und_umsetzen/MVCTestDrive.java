package com.elbers.Ue4.A3_MVC_untersuchen_und_umsetzen;

public class MVCTestDrive {
    public static void main(String[] args) {
        DataModel model = new DataModel();
        TableView tableView = new TableView(model);
        PieChartView pieChartView = new PieChartView(model);
        BarChartView barChartView = new BarChartView(model);

    }
}
