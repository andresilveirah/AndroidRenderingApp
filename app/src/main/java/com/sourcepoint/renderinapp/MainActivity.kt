package com.sourcepoint.renderinapp

import android.os.Bundle
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private fun getScaleFactor() : Int{
        return resources.displayMetrics.densityDpi / 2
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val webview = findViewById<WebView>(R.id.webview)
        webview.settings.loadsImagesAutomatically = true
        webview.settings.javaScriptEnabled = true

        webview.setInitialScale(getScaleFactor())

        val preProdRenderingAppHost = "https://preprod-cdn.privacy-mgmt.com"
        val ottPMPath = "/privacy-manager-ott/index.html"
        val messageId = "623981"
        webview.loadUrl(
            preProdRenderingAppHost +
                ottPMPath +
                "?message_id=" + messageId +
                "&mms_origin=https://cdn.privacy-mgmt.com/mms/v2&cmpv2_origin=https://cdn.privacy-mgmt.com/consent/tcfv2"
        )
    }
}