package ch.heigvd.res.chill.domain.texx94;

import ch.heigvd.res.chill.domain.Bartender;
import ch.heigvd.res.chill.protocol.OrderRequest;
import ch.heigvd.res.chill.protocol.OrderResponse;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CoronaTest {

    @Test
    void thePriceAndNameForCoronaShouldBeCorrect() {
        Corona beer = new Corona();
        assertEquals(beer.getName(), Corona.NAME);
        assertEquals(beer.getPrice(), Corona.PRICE);
    }

    @Test
    void aBartenderShouldAcceptAnOrderForCorona() {
        Bartender jane = new Bartender();
        String productName = "ch.heigvd.res.chill.domain.texx94.Corona";
        OrderRequest request = new OrderRequest(3, productName);
        OrderResponse response = jane.order(request);
        BigDecimal expectedTotalPrice = Corona.PRICE.multiply(new BigDecimal(3));
        assertEquals(expectedTotalPrice, response.getTotalPrice());
    }
}