import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CoinMarketCap {

    List<Ticker> tickerList = new ArrayList<Ticker>();

    private void getDataFromCoinMarket() throws IOException {

        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("https://api.coinmarketcap.com/v1/ticker/?limit=100");

        //Get response and entity
        HttpResponse response = httpclient.execute(httpGet);
        HttpEntity entity = response.getEntity();

        // Read the contents of an entity and return it as a String.
        String content = EntityUtils.toString(entity);
        String jsonStr = content;

        Gson gson = new Gson();
        Type tickType = new TypeToken<ArrayList<Ticker>>() {
        }.getType();
        tickerList = gson.fromJson(jsonStr, tickType);
    }

    public void orderListByVolatility() throws IOException {
        getDataFromCoinMarket();
        for (Ticker t : tickerListWithVolatilityFilterFrom(0)) {
            printSortedList(t);
        }
    }

    public void orderByMaxSupply() throws IOException {
        getDataFromCoinMarket();
        for (Ticker t : tickerListSortedByMaxCoinsFilteredByZero()) {
            printSortedList(t);
        }
    }

    public void orderByVolume24() throws IOException {
        getDataFromCoinMarket();
        for (Ticker t : tickerListSortedByMaxCoinsFilteredByZero()) {
            printSortedList(t);
        }
    }

    public void orderBy() throws IOException {
        getDataFromCoinMarket();
        for (Ticker t : listSortedBy()) {
            printSortedList(t);
        }
    }



    private void printSortedList(Ticker t) {
        String name = t.getName();
        Double price = t.getPrice_btc();
        Double percent_change_7d = t.getPercent_change_7d();
        BigDecimal percent_change_24h = t.getPercent_change_24h();
        String symbol = t.getSymbol();
        Double max_supply = t.getMax_supply();

        System.out.printf("\n%-14s%-10s%-16s%-12s%-12s%-20s\n","Name","Symbol","BTC Price","Change 7D", "Change 24H", "Max supply");
        System.out.printf("%-14s%-10s%.10f%12.2f%12.2f%16.0f\n",name,symbol,price,percent_change_7d, percent_change_24h, max_supply);

//        + String.format("%.8f", price) + " percentage change 7d " + percent_change_7d + " max supply " + String.format("%.4f",max_supply
    }

    private List<Ticker> listSortedBy() {
        return  tickerList
                .stream()
                .filter(t -> t.getVolume_usd_24h() !=null)
                .sorted(Ticker.Comparators.VOLUME_24H)
                .collect(Collectors.toList());
    }

    private List<Ticker> tickerListWithVolatilityFilterFrom(int valuesFrom) {
        return tickerList
                .stream()
                .filter(t -> t.getPercent_change_7d() >= valuesFrom)
                .sorted(Ticker.Comparators.VOLATILITY_7D)
                .collect(Collectors.toList());
    }

    private List<Ticker> tickerListSortedByMaxCoinsFilteredByZero() {
        return tickerList
                .stream()
                .filter(t -> t.getMax_supply() !=null)
                .sorted(Ticker.Comparators.MAX_SUPPLY)
                .collect(Collectors.toList());
    }



}
