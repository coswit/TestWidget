package cos.jingzheng.gittestwidget.js;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.webkit.JavascriptInterface;

import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cos.jingzheng.gittestwidget.R;

public class JsActivity extends AppCompatActivity {

    private static final String TAG = "js";
    @BindView(R.id.web)
    WebView mWebView;
//    BridgeWebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_js);
        ButterKnife.bind(this);
        loadX5();
    }


    private void loadJs() {
//        mWebView.loadUrl("file:///android_asset/demo.html");
//
////        mWebView.registerHandler("submitFromWeb", new BridgeHandler() {
////            @Override
////            public void handler(String data, CallBackFunction function) {
////                Log.i("tag", "handler = submitFromWeb, data from web = " + data);
////                function.onCallBack("submitFromWeb exe, response data from Java");
////            }
////        });
//        mWebView.setDefaultHandler(new DefaultHandler());
//        mWebView.callHandler("functionInJs", "...", new CallBackFunction() {
//            @Override
//            public void onCallBack(String data) {
//
//            }
//        });
    }

    @OnClick(R.id.btn)
    public void onViewClicked() {
//        mWebView.callHandler("functionInJs", "...", new CallBackFunction() {
//            @Override
//            public void onCallBack(String data) {
//
//            }
//        });
        loadX5();
    }

    private void loadX5() {
        mWebView.setVisibility(View.INVISIBLE);
        WebSettings webSetting = mWebView.getSettings();
        webSetting.setJavaScriptEnabled(true);
        webSetting.setJavaScriptCanOpenWindowsAutomatically(true);
        webSetting.setAllowFileAccess(true);
        webSetting.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        webSetting.setSupportZoom(true);
        webSetting.setBuiltInZoomControls(true);
        webSetting.setUseWideViewPort(true);
        webSetting.setSupportMultipleWindows(true);
        // webSetting.setLoadWithOverviewMode(true);
        webSetting.setAppCacheEnabled(true);
        // webSetting.setDatabaseEnabled(true);
        webSetting.setDomStorageEnabled(true);
        webSetting.setGeolocationEnabled(true);
        webSetting.setAppCacheMaxSize(Long.MAX_VALUE);
        // webSetting.setPageCacheCapacity(IX5WebSettings.DEFAULT_CACHE_CAPACITY);
        webSetting.setPluginState(WebSettings.PluginState.ON_DEMAND);
        // webSetting.setRenderPriority(WebSettings.RenderPriority.HIGH);
        webSetting.setCacheMode(WebSettings.LOAD_NO_CACHE);


//        WebView temp = new WebView(this);
//
//        temp.setWebViewClient(new WebViewClient(){
//            @Override
//            public void onPageFinished(WebView webView, String s) {
//                super.onPageFinished(webView, s);
//                mWebView.loadUrl("http://lijt.yunduoketang.cn/interfaces/getVideoDetail?id=267267&type=class");
//            }
//        });

        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView webView, String s) {
//                webView.loadUrl("javascript:MyApp.resize(document.body.getBoundingClientRect().height)");
                super.onPageFinished(webView, s);
                webView.loadUrl("javascript:MyApp.resize(document.body.scrollHeight)");
                webView.loadUrl("javascript:MyApp.resize(document.documentElement.getBoundingClientRect().height)");
                int height = webView.getMeasuredHeight();

                mWebView.setVisibility(View.VISIBLE);
                Log.d(TAG, "onPageFinished: " + height);


            }
        });
//        mWebView.reload();
        mWebView.addJavascriptInterface(this, "MyApp");
        mWebView.loadUrl("http://lijt.yunduoketang.cn/interfaces/getVideoDetail?id=267267&type=class");
    }


    @JavascriptInterface
    public void resize(final float height) {
        JsActivity.this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                int height1 = (int) (height * getResources().getDisplayMetrics().density);
                Log.d(TAG, "run: " + height1);
//                mWebView.setLayoutParams(
//                        new LinearLayout.LayoutParams(getResources().getDisplayMetrics().widthPixels,
//                                height1));
//                mWebView.setVisibility(View.VISIBLE);
//                mWebView.requestLayout();
            }
        });
    }

}
