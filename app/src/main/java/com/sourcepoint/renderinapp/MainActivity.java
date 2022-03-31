package com.sourcepoint.renderinapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

import com.sourcepoint.renderinapp.databinding.ActivityMainBinding;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    WebView webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        webview = findViewById(R.id.webview);
        
        webview.getSettings().setLoadsImagesAutomatically(true);
        webview.getSettings().setJavaScriptEnabled(true);

        String preProdRenderingAppHost = "https://preprod-cdn.privacy-mgmt.com";
        String localRenderingAppHost = "http://192.168.0.10:8080";
        String ottPMPath = "/privacy-manager-ott/index.html";
        String messageId = "623981";

        webview.loadUrl(
                localRenderingAppHost       +
                ottPMPath                   +
                "?message_id=" + messageId  +
                "&mms_origin=https://cdn.privacy-mgmt.com/mms/v2&cmpv2_origin=https://cdn.privacy-mgmt.com/consent/tcfv2"
        );
    }
}