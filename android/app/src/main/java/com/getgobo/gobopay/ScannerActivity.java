package com.getgobo.gobopay;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;

import com.getgobo.gobopay.dto.Registration;
import com.getgobo.gobopay.dto.TableId;
import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;

/**
 * Created by chenb on 5/11/17.
 */

public class ScannerActivity extends Activity implements ZXingScannerView.ResultHandler {
    private ZXingScannerView mScannerView;

    @Override
    public void onCreate(Bundle state) {
        super.onCreate(state);
        mScannerView = new ZXingScannerView(this);   // Programmatically initialize the scanner view
        setContentView(mScannerView);                // Set the scanner view as the content view
    }

    @Override
    public void onResume() {
        super.onResume();
        mScannerView.setResultHandler(this); // Register ourselves as a handler for scan results.
        mScannerView.startCamera();          // Start camera on resume
    }

    @Override
    public void onPause() {
        super.onPause();
        mScannerView.stopCamera();           // Stop camera on pause
    }

    @Override
    public void handleResult(Result rawResult) {
        // Do something with the result here
        Log.v(TAG, rawResult.getText()); // Prints scan results
        Log.v(TAG, rawResult.getBarcodeFormat().toString()); // Prints the scan format (qrcode, pdf417 etc.)
        // If you would like to resume scanning, call this method below:
        mScannerView.resumeCameraPreview(this);
        GoboPayClient goboPayClient = new Dependencies().getGoboPayClient();
        TableId tableId = new TableId();
        tableId.setTableId("1");
        goboPayClient.register(tableId)
                .enqueue(new Callback<Registration>() {

                    @Override
                    public void onResponse(Call<Registration> call, Response<Registration> response) {
                        startActivity(new Intent(ScannerActivity.this, CheckoutActivity.class));
                    }

                    @Override
                    public void onFailure(Call<Registration> call, Throwable t) {
                        startActivity(new Intent(ScannerActivity.this, CheckoutActivity.class));
                    }
                });
    }
}
