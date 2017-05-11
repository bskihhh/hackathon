package com.getgobo.gobopay;

import com.getgobo.gobopay.dto.*;
import org.junit.Test;
import retrofit2.Response;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class GoboPayClientTest {

    private GoboPayClient goboPayClient = new Dependencies().getGoboPayClient();

    @Test
    public void register_shouldReceiveRegistration() throws Exception {
        TableId tableId = new TableId();
        tableId.setTableId("1");
        Response<Registration> response = goboPayClient.register(tableId).execute();
        assertEquals(201, response.code());

        Registration registration = response.body();
        assertEquals("1", registration.getTableId());
    }

    @Test
    public void checkout_shouldReceiveOrderDetails() throws Exception {
        TableId tableId = new TableId();
        tableId.setTableId("1");
        Response<Registration> registerResponse = goboPayClient.register(tableId).execute();
        assertEquals(201, registerResponse.code());

        Registration registration = registerResponse.body();

        OrderId orderId = new OrderId();
        orderId.setOrderId(registration.getOrderId());

        Response<OrderDetails> checkoutResponse = goboPayClient.checkout(orderId).execute();
        assertEquals(200, checkoutResponse.code());
    }

    @Test
    public void pay_shouldReceive204() throws Exception {
        TableId tableId = new TableId();
        tableId.setTableId("1");
        Response<Registration> response = goboPayClient.register(tableId).execute();
        assertEquals(201, response.code());

        Registration registration = response.body();

        Payment p = new Payment();
        p.setOrderId(registration.getOrderId());
        p.setAmount(BigDecimal.valueOf(12345, 2));
        p.setCard("4500123412345678");

        Response<Void> payResponse = goboPayClient.pay(p).execute();
        assertEquals(201, payResponse.code());



    }
}