package cos.jingzheng.gittestwidget.js;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cos.jingzheng.gittestwidget.R;

public class JsActivity extends AppCompatActivity {

    @BindView(R.id.web)
    WebView webView;
//    BridgeWebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_js);
        ButterKnife.bind(this);

    }


    private void loadJs(){
//        webView.loadUrl("file:///android_asset/demo.html");
//
////        webView.registerHandler("submitFromWeb", new BridgeHandler() {
////            @Override
////            public void handler(String data, CallBackFunction function) {
////                Log.i("tag", "handler = submitFromWeb, data from web = " + data);
////                function.onCallBack("submitFromWeb exe, response data from Java");
////            }
////        });
//        webView.setDefaultHandler(new DefaultHandler());
//        webView.callHandler("functionInJs", "...", new CallBackFunction() {
//            @Override
//            public void onCallBack(String data) {
//
//            }
//        });
    }
    @OnClick(R.id.btn)
    public void onViewClicked() {
//        webView.callHandler("functionInJs", "...", new CallBackFunction() {
//            @Override
//            public void onCallBack(String data) {
//
//            }
//        });
        loadX5();
    }

    private void loadX5(){
        WebSettings webSetting = webView.getSettings();
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
        webView.loadUrl("http://lijt.yunduoketang.cn/interfaces/getVideoDetail?id=267267&type=class");
    }
}
