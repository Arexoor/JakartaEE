package com.elbers.Ue4.A4_Schichtarchitektur_entwickeln;

import com.elbers.Ue4.A3_MVC_untersuchen_und_umsetzen.IModelInterface;
import com.elbers.Ue4.A3_MVC_untersuchen_und_umsetzen.IObserverInterface;

import java.util.ArrayList;

public class DataModel implements IModelInterface {

    DataModelEntity dataModelEntity;
    private ArrayList<IObserverInterface> m_observers = new ArrayList<>();

    public DataModel() {
        dataModelEntity = new DataModelEntity();
    }

    public DataModel(int red, int green, int blue) {
        dataModelEntity = new DataModelEntity();
        dataModelEntity.setM_redValue(red);
        dataModelEntity.setM_greenValue(green);
        dataModelEntity.setM_blueValue(blue);
    }

    public DataModel(DataModelEntity dataModelEntity) {
        this.dataModelEntity = dataModelEntity;
    }

    private int getTotal() {
        return dataModelEntity.getM_redValue() + dataModelEntity.getM_greenValue() + dataModelEntity.getM_blueValue();
    }

    public DataModelEntity getEntity() {
        return dataModelEntity;
    }
    @Override
    public double getRedPercentage() {
        return dataModelEntity.getM_redValue() / getTotal();
    }

    @Override
    public void setRedValue(int redValue) {
        dataModelEntity.setM_redValue(redValue);
    }

    public Integer getRedValue() {
        return dataModelEntity.getM_redValue();
    }

    @Override
    public double getGreenPercentage() {
        return dataModelEntity.getM_greenValue() / getTotal();
    }

    @Override
    public void setGreenValue(int greenValue) {
        dataModelEntity.setM_greenValue(greenValue);
    }

    public Integer getGreenValue() {
        return dataModelEntity.getM_greenValue();
    }

    @Override
    public double getBluePercentage() {
        return dataModelEntity.getM_blueValue() / getTotal();
    }

    @Override
    public void setBlueValue(int blueValue) {
        dataModelEntity.setM_blueValue(blueValue);
    }

    public Integer getBlueValue() {
        return dataModelEntity.getM_blueValue();
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
