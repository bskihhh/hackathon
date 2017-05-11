package com.getgobo.gobopay;

import com.getgobo.gobopay.dto.OrderDetails;
import com.getgobo.gobopay.dto.OrderId;
import com.getgobo.gobopay.dto.Registration;
import com.getgobo.gobopay.dto.TableId;
import org.junit.Test;
import retrofit2.Response;

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
    }
}