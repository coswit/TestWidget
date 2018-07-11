package cos.jingzheng.gittestwidget;

import android.app.Application;

import com.blankj.utilcode.util.Utils;

/**
 * Created by jingzheng on 2018/6/19.
 */

public class MyApp extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        Utils.init(this);
    }


}
