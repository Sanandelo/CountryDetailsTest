package models;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * Created by radga on 18.05.2017.
 */
@XmlRootElement(name = "NewDataSet")
@XmlAccessorType(XmlAccessType.FIELD)
public class CountryByCode {
        @XmlElement(name = "Table")
        private List<TableCountryByCode> TableCountryByCode;

    public List<TableCountryByCode> getTablesCountryByCode() {
        return TableCountryByCode;
    }

    public TableCountryByCode getFirstTableCountryByCode(){
        return getTablesCountryByCode().get(0);
    }
    public void setTables(List<TableCountryByCode> tableCountryByCodes) {
        TableCountryByCode = tableCountryByCodes;
    }

}
