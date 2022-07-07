package pojo;

public class CurrenciesAlfaRates {

    private String currencyCode;
    private String clientType;
    private String rateType;

    public CurrenciesAlfaRates(String currencyCode, String clientType, String rateType) {
        this.currencyCode = currencyCode;
        this.clientType = clientType;
        this.rateType = rateType;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public String getClientType() {
        return clientType;
    }

    public String getRateType() {
        return rateType;
    }
}
