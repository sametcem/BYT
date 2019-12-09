package service;

import java.io.Serializable;
import java.net.URL;
import java.util.Date;

public class ObserverMapKey implements Serializable {
    private URL url;
    private Date lastExportDate;

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

    public Date getLastExportDate() {
        return lastExportDate;
    }

    public void setLastExportDate(Date lastExportDate) {
        this.lastExportDate = lastExportDate;
    }
}
