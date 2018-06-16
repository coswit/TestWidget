package cos.jingzheng.gittestwidget.view;

import android.content.Context;
import android.content.res.AssetManager;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;

import com.solidfire.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import cos.jingzheng.gittestwidget.R;
import cos.jingzheng.gittestwidget.bean.CityBean;

/**
 * Created by jingzheng on 2017/9/9.
 */

public class CityPickyView extends FrameLayout {


    private ListView listview;


    public CityPickyView(@NonNull Context context) {
        super(context);
        init(context, null, 0);

    }

    public CityPickyView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0);
    }

    public CityPickyView(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr) {
        View view = LayoutInflater.from(context).inflate(R.layout.city_pick, this);
        listview = (ListView) view.findViewById(R.id.lv_city);
        AssetManager assetManager = getResources().getAssets();
        String result = "";
        try {
            InputStream inputStream = assetManager.open("city_json");
            int available = inputStream.available();
            byte[] bytes = new byte[available];

            int read = inputStream.read(bytes);
            inputStream.close();
            String  s = new String(bytes);


        } catch (IOException e) {
            e.printStackTrace();
        }


//        listview.setAdapter();
    }


    private List<String> getCityNames(String json) {
        List<String> cityNames = new ArrayList<>();
        Gson gson = new Gson();
        CityBean cityBean = gson.fromJson(json, CityBean.class);
        List<CityBean.ProvincesBean> provinces = cityBean.getProvinces();
        for (CityBean.ProvincesBean provincesBean : provinces) {
            List<CityBean.ProvincesBean.CitysBean> citys = provincesBean.getCitys();
            for (CityBean.ProvincesBean.CitysBean names : citys) {
                cityNames.add(names.getCitysName());
            }

        }
        return cityNames;
    }

    private class CityAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return 0;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            return null;
        }
    }
}
