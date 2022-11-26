package com.elbers.Ue4.A3_MVC_untersuchen_und_umsetzen;

public interface IModelInterface extends IObservableInterface {

    public double getRedPercentage();
    public void setRedValue(int redValue);
    public double getGreenPercentage();
    public void setGreenValue(int greenValue);
    public double getBluePercentage();
    public void setBlueValue(int blueValue);
}

