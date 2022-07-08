package scrooge;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.Test;

import java.util.List;

import static constants.Constants.URL_ALFA_RATES;
import static constants.Constants.URL_STOCK_EXCHANGE;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


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


    @Test
    public void positiveTestWithValidParameters() {
        ValidatableResponse rs = given()
                .log().body()
                .queryParam("date.gt", "2022-06-23T14:29:45+03:00")
                .queryParam("date.lt", "2022-05-23T14:29:45+03:00")
                .queryParam("clientType.in", "aClub")
                .queryParam("currencyCode.in", "USD")
                .queryParam("currencyCode.in", "EUR")
                .contentType(ContentType.JSON)
                .expect().statusCode(200)
                .contentType(ContentType.JSON)
                .when().get(URL_ALFA_RATES)
                .then().log().body().statusCode(200)
                .body("data[0]. currencyCode", equalTo("EUR"));
    }

    @Test
    public void positiveTestMatchCurrencyCode() {
        List<String> curr = given()
                .log().body()
                .queryParam("date.gt", "2022-06-23T14:29:45+03:00")
                .queryParam("date.lt", "2022-05-23T14:29:45+03:00")
                .queryParam("clientType.in", "aClub")
                .queryParam("currencyCode.in", "USD")
                .queryParam("currencyCode.in", "EUR")
                .contentType(ContentType.JSON)
                .expect().statusCode(200)
                .contentType(ContentType.JSON)
                .when().get(URL_ALFA_RATES)
                .then().log().body().statusCode(200)
                .extract().jsonPath().getList("data.currencyCode");

    }

    @Test
    public void positiveTestMatchRateType() {
        List<String> curr = given()
                .log().body()
                .queryParam("date.gt", "2022-06-23T14:29:45+03:00")
                .queryParam("date.lt", "2022-05-23T14:29:45+03:00")
                .queryParam("clientType.in", "aClub")
                .queryParam("currencyCode.in", "USD")
                .queryParam("currencyCode.in", "EUR")
                .contentType(ContentType.JSON)
                .expect().statusCode(200)
                .contentType(ContentType.JSON)
                .when().get(URL_ALFA_RATES)
                .then().log().body().statusCode(200)
                .extract().jsonPath().getList("data.rateType");

    }


}