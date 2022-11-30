package com.elbers.Ue4.A3_MVC_untersuchen_und_umsetzen;

import java.util.ArrayList;

public class DataModel implements IModelInterface {
    private int m_redValue = 0;
    private int m_greenValue = 0;
    private int m_blueValue = 0;
    private ArrayList<IObserverInterface> m_observers = new ArrayList<>();

    public double getBluePercentage() {
        double total = m_redValue + m_greenValue + m_blueValue;
        if (total > 0) {
            return m_blueValue / total;
        }
        return 0;
    }

    @Override
    public void setBlueValue(int blueValue) {
        this.m_blueValue = blueValue;
        notifyObservers();
    }

    @Override
    public Integer getBlueValue() {
        return m_blueValue;
    }

    @Override
    public Integer getGreenValue() {
        return m_greenValue;
    }

    @Override
    public Integer getRedValue() {
        return m_redValue;
    }

    public double getGreenPercentage() {
        double total = m_redValue + m_greenValue + m_blueValue;
        if (total > 0) {
            return m_greenValue / total;
        }
        return 0;
    }

    @Override
    public void setGreenValue(int greenValue) {
        this.m_greenValue = greenValue;
        notifyObservers();
    }

    public double getRedPercentage() {
        double total = m_redValue + m_greenValue + m_blueValue;
        if (total > 0) {
            return m_redValue / total;
        }
        return 0;
    }

    @Override
    public void setRedValue(int redValue) {
        this.m_redValue = redValue;
        notifyObservers();
    }

    @Override
    public void registerObserver(IObserverInterface o) {
        m_observers.add(o);
    }

    @Override
    public void removeObserver(IObserverInterface o) {
        m_observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (IObserverInterface m_observer : m_observers) {
            m_observer.update();
        }
    }
}
