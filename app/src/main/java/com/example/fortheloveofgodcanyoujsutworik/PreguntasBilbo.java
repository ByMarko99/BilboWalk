package com.example.fortheloveofgodcanyoujsutworik;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

public class PreguntasBilbo extends AppCompatActivity {
    private WebView webview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Your Feedback");

        webview = (WebView)findViewById(R.id.webview);
        WebSettings webSettings = webview.getSettings();


        webSettings.setJavaScriptEnabled(true);
        webview.loadUrl("https://docs.google.com/forms/d/e/1FAIpQLScGW7oYPfWvku32WNKd9xrsMweqYkr5leKY3rNv2oXSPauIkA/viewform");
        webview.setWebViewClient(new WebViewClient());
    }

    @Override
    public void onBackPressed() {
        if (webview.canGoBack()){
            webview.goBack();
        } else
            super.onBackPressed();
    }
}