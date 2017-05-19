package models;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by radga on 18.05.2017.
 */
public class TableCountries {
    String name;

    public String getName() {
        return name;
    }
    @XmlElement(name = "Name")
    public void setName(String name) {
        this.name = name;
    }
}
