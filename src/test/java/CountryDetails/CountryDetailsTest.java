package CountryDetails;

import utils.HttpRequestsHandler;
import utils.EnvelopCreator;
import models.Countries;
import models.CountryByCode;
import utils.XmlToJavaConveror;
import models.CountryByCurrencyCode;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.xml.bind.JAXBException;
import javax.xml.bind.UnmarshalException;

/**
 * Created by radga on 18.05.2017.
 */
public class CountryDetailsTest {
    public static final String WEBSERVICE_URL = "http://www.webservicex.net/country.asmx?WSDL";
    public static final String ACTION_GET_COUNTRY_BY_COUNTRY_CODE = "GetCountryByCountryCode";
    public static final String COUNTRY_NAME = "United Kingdom";
    public static final String PARAM_NAME_COUNTRY_CODE = "CountryCode" ;
    public static final String COUNTRY_UK = "UK";
    public static final String COUNTRY_UP = "UP";
    public static final String ACTION_GET_COUNTRIES = "GetCountries";
    public static final String FIRST_COUNTRY = "Afghanistan, Islamic State of";
    public static final String LAST_COUNTRY = "Zimbabwe";
    public static final int LAST_INDEX = 243;
    public static final int NUMBER_OF_COUNTRIES = 244;
    public static final String ACTION_GET_COUNTRY_BY_CURRENCY_CODE="GetCountryByCurrencyCode";
    public static final String PARAM_NAME_CURRENCY_COD = "CurrencyCode";
    public static final String CURRENCY_CODE_USD = "USD";
    public static final String EXPECTED_COUNTRY = "us";
    public static final String WRONG_CURRENCY_CODE= "USS";

    @Test
    public static void testGetCountryByCountryCode() throws JAXBException {
        String body = EnvelopCreator.createEnvelopeWithParams(ACTION_GET_COUNTRY_BY_COUNTRY_CODE, PARAM_NAME_COUNTRY_CODE,COUNTRY_UK);
        String response = HttpRequestsHandler.invokeWebService(WEBSERVICE_URL,body, ACTION_GET_COUNTRY_BY_COUNTRY_CODE);
        CountryByCode countryByCode = (CountryByCode)XmlToJavaConveror.convert(XmlToJavaConveror.extractBody(response), CountryByCode.class);
        Assert.assertEquals(countryByCode.getFirstTableCountryByCode().getCountryName(),COUNTRY_NAME, "Name in response don't match expected");
    }
    @Test(expectedExceptions = UnmarshalException.class)
    public static void testGetCountryByCountryCodeInvalidValue() throws JAXBException {
            String body = EnvelopCreator.createEnvelopeWithParams(ACTION_GET_COUNTRY_BY_COUNTRY_CODE, PARAM_NAME_COUNTRY_CODE, COUNTRY_UP);
            String response = HttpRequestsHandler.invokeWebService(WEBSERVICE_URL, body, ACTION_GET_COUNTRY_BY_COUNTRY_CODE);
            XmlToJavaConveror.convert(XmlToJavaConveror.extractBody(response), CountryByCode.class);
    }
    @Test
    public static void testGetCountries() throws JAXBException {
        String body = EnvelopCreator.createEnvelopeWithoutParams(ACTION_GET_COUNTRIES);
        String response = HttpRequestsHandler.invokeWebService(WEBSERVICE_URL, body, ACTION_GET_COUNTRIES);
        Countries countries = (Countries)XmlToJavaConveror.convert(XmlToJavaConveror.extractBody(response), Countries.class);
        Assert.assertEquals(countries.getCoutries().size(),NUMBER_OF_COUNTRIES,"Number of countries by ISO match");
        Assert.assertTrue(countries.getCoutries().get(0).equals(FIRST_COUNTRY) && countries.getCoutries().get(LAST_INDEX).equals(LAST_COUNTRY));
    }
    @Test
    public static void testGetCountryByCurrencyCode() throws JAXBException {
        String body = EnvelopCreator.createEnvelopeWithParams(ACTION_GET_COUNTRY_BY_CURRENCY_CODE,PARAM_NAME_CURRENCY_COD, CURRENCY_CODE_USD);
        String response = HttpRequestsHandler.invokeWebService(WEBSERVICE_URL,body,ACTION_GET_COUNTRY_BY_CURRENCY_CODE);
        CountryByCurrencyCode countryByCurrencyCode = (CountryByCurrencyCode) XmlToJavaConveror.convert(XmlToJavaConveror.extractBody(response), CountryByCurrencyCode.class);
        Assert.assertEquals(countryByCurrencyCode.getFirstTableCountryByCurrencyCode().getCountry(),EXPECTED_COUNTRY);
    }
    @Test(expectedExceptions = UnmarshalException.class)
    public static void testGetCountryByCurrencyCodeInvalidValue() throws JAXBException {
        String body = EnvelopCreator.createEnvelopeWithParams(ACTION_GET_COUNTRY_BY_CURRENCY_CODE,PARAM_NAME_CURRENCY_COD, WRONG_CURRENCY_CODE);
        String response = HttpRequestsHandler.invokeWebService(WEBSERVICE_URL,body,ACTION_GET_COUNTRY_BY_CURRENCY_CODE);
        XmlToJavaConveror.convert(XmlToJavaConveror.extractBody(response), CountryByCurrencyCode.class);
    }

}
