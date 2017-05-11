package com.getgobo.gobopay;

import com.getgobo.gobopay.dto.Visit;
import com.getgobo.gobopay.dto.Payment;
import com.getgobo.gobopay.dto.Registration;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface GoboPayClient {

    @POST("/register")
    Call<Registration> register(@Body String tableId);

    @POST("/checkout")
    Call<Visit> checkout(@Body String orderId);

    @POST("/pay")
    Call<Void> pay(@Body Payment payment);
}