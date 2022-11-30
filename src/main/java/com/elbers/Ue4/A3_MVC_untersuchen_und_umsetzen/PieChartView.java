package com.elbers.Ue4.A3_MVC_untersuchen_und_umsetzen;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;

import org.jfree.chart.ChartFactory;  
import org.jfree.chart.ChartPanel;  
import org.jfree.chart.JFreeChart;  
import org.jfree.chart.labels.PieSectionLabelGenerator;  
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;  
import org.jfree.data.general.PieDataset;

public class PieChartView extends JFrame implements IObserverInterface{
    private IModelInterface m_model;

    public PieChartView(IModelInterface model) {
        super("PieChart View");
        m_model = model;
        m_model.registerObserver(this);
        createComponents();
        update();
    }
    JFreeChart chart;
    ChartPanel panel;

    public void createComponents() {
        // Create dataset
        PieDataset dataset = createDataset();

        // Create chart
        chart = ChartFactory.createPieChart(
                "Pie Chart Example",
                dataset,
                true,
                true,
                false);

        //Format Label
        PieSectionLabelGenerator labelGenerator = new StandardPieSectionLabelGenerator(
                "{0} : ({2})", new DecimalFormat("0"), new DecimalFormat("0%"));
        ((PiePlot) chart.getPlot()).setLabelGenerator(labelGenerator);

        // Create Panel
        panel = new ChartPanel(chart);
        setContentPane(panel);
        setSize(800, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void update() {
        double red = m_model.getRedPercentage();
        double green = m_model.getGreenPercentage();
        double blue = m_model.getBluePercentage();
        updateChartDataset(red, green, blue);
    }

    private void updateChartDataset(final double red, final double green, final double blue) {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Red", red);
        dataset.setValue("Green", green);
        dataset.setValue("Blue", blue);

        PiePlot plot = (PiePlot) chart.getPlot();
        plot.setDataset(dataset);

        plot.setSectionPaint("Red", new Color(255,0,0));
        plot.setSectionPaint("Green", new Color(0,255,0));
        plot.setSectionPaint("Blue", new Color(0,0,255));
    }

    private PieDataset createDataset() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        return dataset;
    }

}
