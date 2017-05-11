package com.getgobo.gobopay;

import com.getgobo.gobopay.dto.Registration;
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
    public void register_shouldReceiveRegistrationResponse() throws Exception {
        Response<Registration> response = goboPayClient.register("12345").execute();
        assertEquals(200, response.code());
    }
}