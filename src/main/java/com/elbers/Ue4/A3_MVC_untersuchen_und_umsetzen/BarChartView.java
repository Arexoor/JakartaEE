package com.elbers.Ue4.A3_MVC_untersuchen_und_umsetzen;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;


import javax.swing.*;
import java.awt.*;

public class BarChartView extends JFrame implements IObserverInterface {
    private IModelInterface m_model;

    public BarChartView(IModelInterface model) {
        super("BarChart View");
        m_model = model;
        m_model.registerObserver(this);
        createComponents();
    }
    JFreeChart chart;
    ChartPanel panel;

    public void createComponents() {
        // Create dataset
        CategoryDataset dataset = createDataset();

        // Create chart
        chart = ChartFactory.createBarChart(
                "Bar Chart Example",
                "Colour",
                "RGB value",
                dataset);

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
        createChartPanel(red, green, blue);
    }

    private void createChartPanel(final double red, final double green, final double blue) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.setValue(red, "Red", "value");
        dataset.setValue(green, "Green", "value");
        dataset.setValue(blue, "Blue", "value");

        CategoryPlot plot = chart.getCategoryPlot();
        plot.setDataset(dataset);

        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setSeriesPaint(0, new Color(255,0,0));
        renderer.setSeriesPaint(1, new Color(0,255,0));
        renderer.setSeriesPaint(2, new Color(0,0,255));
    }

    private DefaultCategoryDataset createDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        return dataset;
    }

}
