package cos.jingzheng.gittestwidget.js;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.widget.FrameLayout;

import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cos.jingzheng.gittestwidget.R;

public class JsActivity extends AppCompatActivity {

    private static final String TAG = "jsTag";
    @BindView(R.id.web)
    WebView mWebView;
//    BridgeWebView mWebView;

    @BindView(R.id.webView2)
    WebView webView2;


    private String url = "http://lijt.yunduoketang.cn/interfaces/getVideoDetail?id=267267&type=class";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_js);
        ButterKnife.bind(this);
        preloadWeb();
        resizeWebByJs();
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


//        resizeWebByJs();
//        loadWebFragment();

//        preloadWeb();

    }

    private void resizeWebByJs() {
        initWebSetting(mWebView);


        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView webView, String s) {
                super.onPageFinished(webView, s);
//                mWebView.loadUrl("javascript:MyApp.resize(document.body.getBoundingClientRect().height)");
                webView.loadUrl("javascript:MyApp.resize(document.body.scrollHeight)");
                webView.loadUrl("javascript:MyApp.resize(document.documentElement.getBoundingClientRect().height)");
                int height = webView.getMeasuredHeight();

                Log.d(TAG, "onPageFinished: " + height);


            }
        });
//        mWebView.reload();
        mWebView.addJavascriptInterface(this, "MyApp");
        mWebView.loadUrl(url);
    }

    private void initWebSetting(WebView mWebView) {
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
            }
        });
    }

    private void loadWebFragment() {
        String url = "http://lijt.yunduoketang.cn/interfaces/getVideoDetail?id=267267&type=class";
        FrameLayout frameLayout = new FrameLayout(this);
        FrameLayout.LayoutParams params = new FrameLayout.
                LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.WRAP_CONTENT);
        frameLayout.setLayoutParams(params);

        final WebFragment webFragment = WebFragment.newInstance(url);
        FragmentTransaction transaction = JsActivity.this.getSupportFragmentManager().beginTransaction();

        transaction.commit();

        webFragment.setOnInteractionListener(new WebFragment.OnFragmentInteractionListener() {
            @Override
            public void onFragmentInteraction() {
            }
        });
    }


    private void preloadWeb() {
        webView2.loadUrl(url);
        initWebSetting(webView2);
        webView2.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView webView, String s) {
                super.onPageFinished(webView, s);
                int contentHeight = webView.getContentHeight();
                //12825
                Log.d(TAG, "2——onPageFinished: " + contentHeight);

//                if (contentHeight > 0) {
//                    mWebView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, contentHeight));
//                    mWebView.loadUrl(url);
//                }
//                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, contentHeight);
//                mWebView.setLayoutParams(layoutParams);
//                mWebView.loadUrl(url);
            }
        });
    }


}
