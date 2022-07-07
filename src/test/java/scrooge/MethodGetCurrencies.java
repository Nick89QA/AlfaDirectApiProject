package scrooge;

import org.testng.annotations.Test;
import pojo.CurrenciesAlfaRates;

import java.util.List;

import static constants.Constants.URL_ALFA_RATES;
import static constants.Constants.URL_STOCK_EXCHANGE;
import static io.restassured.RestAssured.given;


public class MethodGetCurrencies {

    @Test
    public void testCanGetCurrenciesStockExchange() {
        given().log().all()
                .when().get(URL_STOCK_EXCHANGE)
                .then().log().body().statusCode(200);
    }

    @Test
    public void testCanGetCurrenciesAlfaRates() {
        given()
                .queryParam("date.gt", "2022-06-23T14:29:45+03:00")
                .queryParam("date.lt", "2022-04-23T14:29:45+03:00")
                .queryParam("clientType.in", "aClub")
                .queryParam("currencyCode.in", "USD")
                .queryParam("currencyCode.in", "EUR")
                .when().get(URL_ALFA_RATES)
                .then().log().body().statusCode(200);

    }


//    @Test
//    public void testCanGetCurciesAlfaRates() {
//        List<CurrenciesAlfaRates> currency  = (List<CurrenciesAlfaRates>) given()
//                .queryParam("date.gt", "2022-06-23T14:29:45+03:00")
//                .queryParam("date.lt", "2022-04-23T14:29:45+03:00")
//                .queryParam("clientType.in", "aClub")
//                .queryParam("currencyCode.in", "USD")
//                .queryParam("currencyCode.in", "EUR")
//                .when().get(URL_ALFA_RATES)
//                .then().log().body().statusCode(200);




}
