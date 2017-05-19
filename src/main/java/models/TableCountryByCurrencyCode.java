package models;

import javax.xml.bind.annotation.XmlElement;

/**
 * Created by radga on 18.05.2017.
 */
public class TableCountryByCurrencyCode {
    String name;
    String country;
    String currency;
    String currencyCode;


    public String getName() {
        return name;
    }

    @XmlElement(name = "Name")
    public void setName(String name) {
        this.name = name;
    }


    public String getCountry() {
        return country;
    }

    @XmlElement(name = "CountryCode")
    public void setCountryCode(String country) {
        this.country = country;
    }



    public String getCurrency() {
        return currency;
    }

    @XmlElement(name = "Currency")
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }
    @XmlElement(name = "CurrencyCode")
    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }
}

