package observer;

import service.Monitor;

import java.io.IOException;
import java.net.URL;

public class PJATKObserver extends Observer {

    public PJATKObserver(Monitor monitor, URL url){
        this.name = "PJATK";
        this.url = url;
        this.monitor = monitor;
    }


    @Override
    public String update() throws IOException {
        String s = "Page:  '" + url + "' was updated!!!";
        System.out.println(s);
        return s;
    }
}
