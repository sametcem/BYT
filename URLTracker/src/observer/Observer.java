package observer;

import service.Monitor;

import java.io.IOException;
import java.io.Serializable;
import java.net.URL;

public abstract class Observer implements Serializable {

    protected String name;
    protected URL url;
    protected Monitor monitor;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

    public Monitor getMonitor() {
        return monitor;
    }

    public void setMonitor(Monitor monitor) {
        this.monitor = monitor;
    }

    public abstract String update() throws IOException;
}
