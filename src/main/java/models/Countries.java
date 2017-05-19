package models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by radga on 18.05.2017.
 */
    @XmlRootElement(name = "NewDataSet")
    @XmlAccessorType(XmlAccessType.FIELD)
    public class Countries {
        @XmlElement(name = "Table")
        private List<TableCountries> TableCountries;

        public List<TableCountries> getTablesCountries() {
            return TableCountries;
        }

        public List<String> getCoutries(){
            List<String> result = new ArrayList<>();
            for(TableCountries tableCountries : getTablesCountries()){
                String name = tableCountries.getName();
                if(!result.contains(name)){
                    result.add(name);
                }
            }
        return result;
        }
        public void setTables(List<TableCountries> tableCountries) {
            TableCountries = tableCountries;
        }

    }
