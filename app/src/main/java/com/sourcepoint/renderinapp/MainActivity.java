package com.sourcepoint.renderinapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {
    WebView webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webview = findViewById(R.id.webview);

        webview.getSettings().setLoadsImagesAutomatically(true);
        webview.getSettings().setJavaScriptEnabled(true);

        // MARK Papito, here's the magic number we were all looking for.
        webview.setInitialScale(100);

        String preProdRenderingAppHost = "https://preprod-cdn.privacy-mgmt.com";
        String localRenderingAppHost = "http://192.168.0.10:8080";
        String ottPMPath = "/privacy-manager-ott/index.html";
        String messageId = "623981";

        webview.loadUrl(
                preProdRenderingAppHost         +
                ottPMPath                       +
                "?message_id=" + messageId      +
                "&mms_origin=https://cdn.privacy-mgmt.com/mms/v2&cmpv2_origin=https://cdn.privacy-mgmt.com/consent/tcfv2"
        );
    }
}