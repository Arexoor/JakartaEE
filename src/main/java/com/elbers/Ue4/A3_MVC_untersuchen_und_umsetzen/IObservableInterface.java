package com.elbers.Ue4.A3_MVC_untersuchen_und_umsetzen;

public interface IObservableInterface {
    public void registerObserver(IObserverInterface o);
    public void removeObserver(IObserverInterface o);
    public void notifyObservers();
}
