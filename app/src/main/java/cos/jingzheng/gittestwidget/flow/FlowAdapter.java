package cos.jingzheng.gittestwidget.flow;

import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Created by zhengjing on 2018/11/20.
 */

public abstract class FlowAdapter<T> {

    private List<T> mDatas;

//    public View getView(Context context){
//        return View.inflate(context, R.layout.text, null);
//    }


    public void setDatas(List<T> data){
        mDatas = data==null?new ArrayList<T>():data;
    }

    public List<T> getData(){
        mDatas=mDatas==null?new ArrayList<T>():mDatas;
        return mDatas;
    }

    public abstract View getView(FlowLayout parent,int postion,T t);
}
