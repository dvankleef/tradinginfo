import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class CoinMarketCapTest {


    @Test
    public void doAPi() throws IOException {
        CoinMarketCap coinMarketCap = new CoinMarketCap();
        coinMarketCap.orderListByVolatility();
    }

    @Test
    public void orderBySupply() throws IOException {
        CoinMarketCap coinMarketCap = new CoinMarketCap();
        coinMarketCap.orderByMaxSupply();
    }

    @Test
    public void orderBy24HChange() throws IOException {
        CoinMarketCap coinMarketCap = new CoinMarketCap();
        coinMarketCap.orderBy();
    }



}
