package com.getgobo.gobopay;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.getgobo.gobopay.dto.OrderDetails;

import java.io.IOException;

import com.getgobo.gobopay.dto.OrderId;
import me.dm7.barcodescanner.zxing.ZXingScannerView;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.BufferedSink;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by chenb on 5/11/17.
 */

public class CheckoutActivity extends Activity {
    private Button checkout;
    private TextView orderInfo;

    @Override
    public void onCreate(Bundle state) {
        super.onCreate(state);
        setContentView(R.layout.activity_checkout);                // Set the scanner view as the content view
        checkout = (Button) findViewById(R.id.checkout);
        orderInfo = (TextView) findViewById(R.id.orderInfo);
        checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GoboPayClient goboPayClient = new Dependencies().getGoboPayClient();
                OrderId orderId = new OrderId();
                orderId.setOrderId("1");
                goboPayClient.checkout(orderId)
                            .enqueue(new Callback<OrderDetails>() {
                                @Override
                                public void onResponse(Call<OrderDetails> call, Response<OrderDetails> response) {
                                    showOrderAndPayment (response.body());
                                }

                                @Override
                                public void onFailure(Call<OrderDetails> call, Throwable t) {
                                    showOrderAndPayment (null);
                                }
                            });
            }
        });
    }

    private void showOrderAndPayment (OrderDetails orderDetails) {
        orderInfo.setText("{\n\t\"tableId\": 1,\n\t\"server\": {\n\t\t\"serverId\": 1,\n\t\t\"serverName\": \"Bo\"\n\t},\n\t\"restaurant\": {\n\t\t\"restaurantId\": 1,\n\t\t\"restaurantName\": \"GOBO\"\n\t},\n\t\"order\": {\n\t\t\"items\":[\n\t\t\t{\n\t\t\t\t\"itemId\": 1,\n\t\t\t\t\"name\": \"Royale with Cheese\",\n\t\t\t\t\"price\": {\n\t\t\t\t\t\"amount\": 10,\n\t\t\t\t\t\"currency\": \"CAD\"\n\t\t\t\t}\n\t\t\t},\n\t\t\t{\n\t\t\t\t\"itemId\": 2,\n\t\t\t\t\"name\": \"Vanilla Shake\",\n\t\t\t\t\"price\": {\n\t\t\t\t\t\"amount\": 10,\n\t\t\t\t\t\"currency\": \"CAD\"\n\t\t\t\t}\n\t\t\t}\n\t\t]\n\t},\n\t\"customer\": {\n\t\t\"name\": \"Gordon\",\n\t\t\"id\": 1\n\t}\n}");
        checkout.setText("Tap Your Card On The Back Of Your Phone!");
    }
}
