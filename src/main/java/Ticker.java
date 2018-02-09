import java.math.BigDecimal;
import java.util.Comparator;

public class Ticker {

    String id;
    String name;
    String symbol;
    Double price_btc;
    BigDecimal price_usd;
    BigDecimal volume_usd_24h;
    BigDecimal market_cap_usd;
    Double available_supply;
    Double total_supply;
    Double max_supply;
    BigDecimal percent_change_1h;
    BigDecimal percent_change_24h;
    Double percent_change_7d;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Double getPrice_btc() {
        return price_btc;
    }

    public void setPrice_btc(Double price_btc) {
        this.price_btc = price_btc;
    }

    public BigDecimal getPrice_usd() {
        return price_usd;
    }

    public void setPrice_usd(BigDecimal price_usd) {
        this.price_usd = price_usd;
    }

    public BigDecimal getVolume_usd_24h() {
        return volume_usd_24h;
    }

    public void setVolume_usd_24h(BigDecimal volume_usd_24h) {
        this.volume_usd_24h = volume_usd_24h;
    }

    public BigDecimal getMarket_cap_usd() {
        return market_cap_usd;
    }

    public void setMarket_cap_usd(BigDecimal market_cap_usd) {
        this.market_cap_usd = market_cap_usd;
    }

    public Double getAvailable_supply() {
        return available_supply;
    }

    public void setAvailable_supply(Double available_supply) {
        this.available_supply = available_supply;
    }

    public Double getTotal_supply() {
        return total_supply;
    }

    public void setTotal_supply(Double total_supply) {
        this.total_supply = total_supply;
    }

    public Double getMax_supply() {
        return max_supply;
    }

    public void setMax_supply(Double max_supply) {
        this.max_supply = max_supply;
    }

    public BigDecimal getPercent_change_1h() {
        return percent_change_1h;
    }

    public void setPercent_change_1h(BigDecimal percent_change_1h) {
        this.percent_change_1h = percent_change_1h;
    }

    public BigDecimal getPercent_change_24h() {
        return percent_change_24h;
    }

    public void setPercent_change_24h(BigDecimal percent_change_24h) {
        this.percent_change_24h = percent_change_24h;
    }

    public Double getPercent_change_7d() {
        return percent_change_7d;
    }

    public void setPercent_change_7d(Double percent_change_7d) {
        this.percent_change_7d = percent_change_7d;
    }


    public static class Comparators {
        public static final Comparator<Ticker> PRICE_BTC = (Ticker t1, Ticker t2) -> t1.getPrice_btc().compareTo(t2.getPrice_btc());
        public static final Comparator<Ticker> VOLATILITY_7D = (Ticker t1, Ticker t2) -> t1.getPercent_change_7d().compareTo(t2.getPercent_change_7d());
        public static final Comparator<Ticker> VOLATILITY_24H = (Ticker t1, Ticker t2) -> t1.getPercent_change_24h().compareTo(t2.getPercent_change_24h());
        public static final Comparator<Ticker> MAX_SUPPLY = (Ticker t1, Ticker t2) -> t1.getMax_supply().compareTo(t2.getMax_supply());
        public static final Comparator<Ticker> VOLUME_24H = (Ticker t1, Ticker t2) -> t1.getVolume_usd_24h().compareTo(t2.getVolume_usd_24h());


    }

//    public static class Comparators {
//
//        public static Comparator<Ticker> PRICE = new Comparator<Ticker>() {
//            @Override
//            public int compare(Ticker o1, Ticker o2) {
//                return (int) (o1.getPrice_btc() - o2.getPrice_btc());
//            }
//        };
//    }

}
