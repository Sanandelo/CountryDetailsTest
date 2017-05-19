package models;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by radga on 18.05.2017.
 */
public class TableCountryByCode {
    String countrycode;
    String name;

    public String getCountryCode() {
        return countrycode;
    }

    @XmlElement(name = "countrycode")
    public void setCountrycode(String countrycode) {
        this.countrycode = countrycode;
    }

    public String getCountryName() {
        return name;
    }

    @XmlElement(name = "name")
    public void setName(String name) {
        this.name = name;
    }
}

