package models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by radga on 18.05.2017.
 */
    @XmlRootElement(name = "NewDataSet")
    @XmlAccessorType(XmlAccessType.FIELD)
    public class CountryByCurrencyCode {

        @XmlElement(name = "Table")
        private List<TableCountryByCurrencyCode> TableCountryByCurrencyCode;

        public List<TableCountryByCurrencyCode> getTableCountryByCurrencyCode() {
            return TableCountryByCurrencyCode;
        }

        public TableCountryByCurrencyCode getFirstTableCountryByCurrencyCode(){
            return getTableCountryByCurrencyCode().get(0);
        }
        public void setTableCountryByCurrencyCode(List<TableCountryByCurrencyCode> tableCountryByCurrencyCodes) {
            TableCountryByCurrencyCode = tableCountryByCurrencyCodes;
        }


}
