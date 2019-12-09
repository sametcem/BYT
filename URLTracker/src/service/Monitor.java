package service;

import observer.Observer;

import javax.swing.*;
import java.io.IOException;
import java.io.Serializable;
import java.net.URLConnection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Monitor implements Serializable {
    Map<ObserverMapKey, Observer> observersMap;

    public Monitor() {
        this.observersMap = new HashMap<>();
    }

    public void checkForModification(JTextArea jTextArea) throws InterruptedException, IOException {
        for (ObserverMapKey ob : observersMap.keySet()) {
            checkUrlForModification(ob, jTextArea);
        }
    }

    public void checkUrlForModification(ObserverMapKey ob, JTextArea jTextArea) throws IOException {
        URLConnection conn = ob.getUrl().openConnection();
        long longtime = conn.getLastModified();
        Date modifiedDate = new Date(longtime);
        if (ob.getLastExportDate() == null || modifiedDate.after(ob.getLastExportDate())) {

            ob.setLastExportDate(modifiedDate);
            observersMap.get(ob).update();
            jTextArea.append(observersMap.get(ob).update() + "\n");
        }
        print(ob, jTextArea);
    }


    public void addToObserversMap(Observer observer){
        ObserverMapKey observerMapKey = new ObserverMapKey();
        observerMapKey.setUrl(observer.getUrl());
        observersMap.put(observerMapKey, observer);
    }

    public void print(ObserverMapKey ob, JTextArea jTextArea){
        jTextArea.append(ob.getUrl()+" "+ob.getLastExportDate()+"\n");
        System.out.println(ob.getUrl()+" "+ob.getLastExportDate());
    }

    public Map<ObserverMapKey, Observer> getObserversMap() {
        return observersMap;
    }

    public void setObserversMap(Map<ObserverMapKey, Observer> observersMap) {
        this.observersMap = observersMap;
    }
}

