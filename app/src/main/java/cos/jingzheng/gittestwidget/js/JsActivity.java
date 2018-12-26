package cos.jingzheng.gittestwidget.js;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.github.lzyzsd.jsbridge.BridgeWebView;
import com.github.lzyzsd.jsbridge.CallBackFunction;
import com.github.lzyzsd.jsbridge.DefaultHandler;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cos.jingzheng.gittestwidget.R;

public class JsActivity extends AppCompatActivity {

    @BindView(R.id.web)
    BridgeWebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_js);
        ButterKnife.bind(this);
        webView.loadUrl("file:///android_asset/demo.html");

//        webView.registerHandler("submitFromWeb", new BridgeHandler() {
//            @Override
//            public void handler(String data, CallBackFunction function) {
//                Log.i("tag", "handler = submitFromWeb, data from web = " + data);
//                function.onCallBack("submitFromWeb exe, response data from Java");
//            }
//        });
        webView.setDefaultHandler(new DefaultHandler());
        webView.callHandler("functionInJs", "...", new CallBackFunction() {
            @Override
            public void onCallBack(String data) {

            }
        });
    }

    @OnClick(R.id.btn)
    public void onViewClicked() {
        webView.callHandler("functionInJs", "...", new CallBackFunction() {
            @Override
            public void onCallBack(String data) {

            }
        });

    }
}
