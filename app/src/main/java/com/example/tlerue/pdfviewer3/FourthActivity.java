package com.example.tlerue.pdfviewer3;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.WebSettings.PluginState;

import java.net.URLEncoder;

public class FourthActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        WebView mWebView = new WebView(FourthActivity.this);

        //Tell app to load webpage in app
        mWebView.setWebViewClient(new WebViewClient());

        //Use webview's built-in pinch and zoom
        mWebView.getSettings().setBuiltInZoomControls(true);

        //Makes webview more viewable...i.e. without this it seems
        //like android loads the webpage at too large a scaling
        mWebView.getSettings().setLoadWithOverviewMode(true);
        mWebView.getSettings().setUseWideViewPort(true);

        //Google docs viewere requires this
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.getSettings().setPluginState(PluginState.ON);

        String pdfurl = "http://www.metafuture.org/pdf/futureofindonesia.pdf";
        String link;
        try {
            link = "http://docs.google.com/viewer?url="
                    + URLEncoder.encode(pdfurl, "UTF-8")
                    + "&embedded=true";
            //Uri uri = Uri.parse(link);
            //Intent intent = new Intent(Intent.ACTION_VIEW,uri);
            //startActivity(intent);
            //WebView view = (WebView) this.findViewById(R.id.webView);
            //view.loadUrl(link);
            //mWebView.loadUrl("http://www.google.fr");
            mWebView.loadUrl(link);
            System.out.println(link);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Load the page into the webview
        //mWebView.loadUrl("http://www.metafuture.org/pdf/futureofindonesia.pdf");
        //mWebView.loadUrl("http://www.google.fr");
        //Set the app's main view to the webView that displays the pdf
        setContentView(mWebView);
    }
}
