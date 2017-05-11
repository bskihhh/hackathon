package com.getgobo.gobopay;

import com.getgobo.gobopay.dto.*;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface GoboPayClient {

    @Headers({
            "Content-Type: application/json; charset=utf-8",
            "Accept: application/json"
    })
    @POST("/register")
    Call<Registration> register(@Body TableId tableId);

    @Headers({
            "Content-Type: application/json; charset=utf-8",
            "Accept: application/json"
    })
    @POST("/checkout")
    Call<OrderDetails> checkout(@Body OrderId orderId);

    @Headers({
            "Content-Type: application/json; charset=utf-8",
            "Accept: application/json"
    })
    @POST("/pay")
    Call<Void> pay(@Body Payment payment);
}