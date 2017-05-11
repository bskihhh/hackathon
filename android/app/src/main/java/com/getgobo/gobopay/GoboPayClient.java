package com.getgobo.gobopay;

import com.getgobo.gobopay.dto.Visit;
import com.getgobo.gobopay.dto.Payment;
import com.getgobo.gobopay.dto.Registration;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface GoboPayClient {

    @POST("/register")
    @Headers( "Content-Type: application/json" )
    Call<Registration> register(@Body String table);

    @POST("/checkout")
    @Headers( "Content-Type: application/json" )
    Call<Visit> checkout(@Body String orderId);

    @POST("/pay")
    @Headers( "Content-Type: application/json" )
    Call<Void> pay(@Body Payment payment);
}