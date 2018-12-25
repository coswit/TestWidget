package cos.jingzheng.gittestwidget.flow;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cos.jingzheng.gittestwidget.R;

public class FlowActivity extends AppCompatActivity {

    @BindView(R.id.flow)
    FlowLayout flowLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flow);
        ButterKnife.bind(this);


    }

    @OnClick(R.id.empty)
    public void onViewClicked(View v) {
//        final ArrayList<CourseBean> list = new ArrayList<>();
//        for (int i = 0; i < 30; i++) {
//            CourseBean courseBean = new CourseBean();
//            courseBean.setId((long) i);
//            courseBean.setItemName(i + "条");
//            list.add(courseBean);
//            CourseBean courseBean1 = new CourseBean();
//            courseBean1.setId((long) i);
//            courseBean1.setItemName(i + "个测试数据");
//            list.add(courseBean1);
//        }
        List list = getData();
        FlowAdapter<CourseBean> adapter = new FlowAdapter<CourseBean>() {
            @Override
            public View getView(FlowLayout parent, int postion, CourseBean o) {
                TextView view = (TextView) getLayoutInflater().inflate(R.layout.text, null);
                view.setText(o.getItemName());
                return view;
            }
        };
        adapter.setDatas(list);
        flowLayout.setAdapter(adapter);

    }



    private List getData(){
        String json = "[{\n" +
                "\t\t\"id\": 127835,\n" +
                "\t\t\"itemName\": \"海米分期\",\n" +
                "\t\t\"parentId\": 127834\n" +
                "\t}, {\n" +
                "\t\t\"id\": 127845,\n" +
                "\t\t\"itemName\": \"lm学科1小类\",\n" +
                "\t\t\"parentId\": 127836\n" +
                "\t}, {\n" +
                "\t\t\"id\": 127854,\n" +
                "\t\t\"itemName\": \"所有类型的课程\",\n" +
                "\t\t\"parentId\": 127853\n" +
                "\t}, {\n" +
                "\t\t\"id\": 127873,\n" +
                "\t\t\"itemName\": \"1111\",\n" +
                "\t\t\"parentId\": 127853\n" +
                "\t}, {\n" +
                "\t\t\"id\": 127874,\n" +
                "\t\t\"itemName\": \"学科小类学科小类学科小类\",\n" +
                "\t\t\"parentId\": 127853\n" +
                "\t}, {\n" +
                "\t\t\"id\": 127878,\n" +
                "\t\t\"itemName\": \"语文语文\",\n" +
                "\t\t\"parentId\": 127875\n" +
                "\t}, {\n" +
                "\t\t\"id\": 127879,\n" +
                "\t\t\"itemName\": \"语文1语文1\",\n" +
                "\t\t\"parentId\": 127875\n" +
                "\t}, {\n" +
                "\t\t\"id\": 127880,\n" +
                "\t\t\"itemName\": \"语文2语文2\",\n" +
                "\t\t\"parentId\": 127875\n" +
                "\t}, {\n" +
                "\t\t\"id\": 127881,\n" +
                "\t\t\"itemName\": \"语文3语文3\",\n" +
                "\t\t\"parentId\": 127875\n" +
                "\t}, {\n" +
                "\t\t\"id\": 127882,\n" +
                "\t\t\"itemName\": \"语文4语文4\",\n" +
                "\t\t\"parentId\": 127875\n" +
                "\t}, {\n" +
                "\t\t\"id\": 127883,\n" +
                "\t\t\"itemName\": \"语文5语文5\",\n" +
                "\t\t\"parentId\": 127875\n" +
                "\t}, {\n" +
                "\t\t\"id\": 127884,\n" +
                "\t\t\"itemName\": \"语文6语文6\",\n" +
                "\t\t\"parentId\": 127875\n" +
                "\t}, {\n" +
                "\t\t\"id\": 127885,\n" +
                "\t\t\"itemName\": \"语文7语文7\",\n" +
                "\t\t\"parentId\": 127875\n" +
                "\t}, {\n" +
                "\t\t\"id\": 127941,\n" +
                "\t\t\"itemName\": \"中考语文\",\n" +
                "\t\t\"parentId\": 127939\n" +
                "\t}, {\n" +
                "\t\t\"id\": 127942,\n" +
                "\t\t\"itemName\": \"中考数学\",\n" +
                "\t\t\"parentId\": 127939\n" +
                "\t}, {\n" +
                "\t\t\"id\": 127943,\n" +
                "\t\t\"itemName\": \"中考英语\",\n" +
                "\t\t\"parentId\": 127939\n" +
                "\t}, {\n" +
                "\t\t\"id\": 127944,\n" +
                "\t\t\"itemName\": \"中考政治\",\n" +
                "\t\t\"parentId\": 127939\n" +
                "\t}, {\n" +
                "\t\t\"id\": 127945,\n" +
                "\t\t\"itemName\": \"中考历史\",\n" +
                "\t\t\"parentId\": 127939\n" +
                "\t}, {\n" +
                "\t\t\"id\": 127946,\n" +
                "\t\t\"itemName\": \"中考物理\",\n" +
                "\t\t\"parentId\": 127939\n" +
                "\t}, {\n" +
                "\t\t\"id\": 128055,\n" +
                "\t\t\"itemName\": \"中国地理\",\n" +
                "\t\t\"parentId\": 21171\n" +
                "\t}, {\n" +
                "\t\t\"id\": 128056,\n" +
                "\t\t\"itemName\": \"世界地理\",\n" +
                "\t\t\"parentId\": 21171\n" +
                "\t}, {\n" +
                "\t\t\"id\": 128085,\n" +
                "\t\t\"itemName\": \"直播\",\n" +
                "\t\t\"parentId\": 128084\n" +
                "\t}, {\n" +
                "\t\t\"id\": 128150,\n" +
                "\t\t\"itemName\": \"做题筛选\",\n" +
                "\t\t\"parentId\": 128149\n" +
                "\t}, {\n" +
                "\t\t\"id\": 128160,\n" +
                "\t\t\"itemName\": \"前台展示课程\",\n" +
                "\t\t\"parentId\": 128159\n" +
                "\t}, {\n" +
                "\t\t\"id\": 128197,\n" +
                "\t\t\"itemName\": \"sysConfigItem\",\n" +
                "\t\t\"parentId\": 54878\n" +
                "\t}, {\n" +
                "\t\t\"id\": 128206,\n" +
                "\t\t\"itemName\": \"1aa\",\n" +
                "\t\t\"parentId\": 128205\n" +
                "\t}, {\n" +
                "\t\t\"id\": 128207,\n" +
                "\t\t\"itemName\": \"2\",\n" +
                "\t\t\"parentId\": 128205\n" +
                "\t}, {\n" +
                "\t\t\"id\": 128214,\n" +
                "\t\t\"itemName\": \"录播\",\n" +
                "\t\t\"parentId\": 128084\n" +
                "\t}, {\n" +
                "\t\t\"id\": 128215,\n" +
                "\t\t\"itemName\": \"1V1\",\n" +
                "\t\t\"parentId\": 128084\n" +
                "\t}, {\n" +
                "\t\t\"id\": 128216,\n" +
                "\t\t\"itemName\": \"混合\",\n" +
                "\t\t\"parentId\": 128084\n" +
                "\t}, {\n" +
                "\t\t\"id\": 128230,\n" +
                "\t\t\"itemName\": \"小类1\",\n" +
                "\t\t\"parentId\": 128229\n" +
                "\t}, {\n" +
                "\t\t\"id\": 128235,\n" +
                "\t\t\"itemName\": \"课后作业\",\n" +
                "\t\t\"parentId\": 128149\n" +
                "\t}, {\n" +
                "\t\t\"id\": 128252,\n" +
                "\t\t\"itemName\": \"11.6\",\n" +
                "\t\t\"parentId\": 128084\n" +
                "\t}, {\n" +
                "\t\t\"id\": 128255,\n" +
                "\t\t\"itemName\": \"11.7\",\n" +
                "\t\t\"parentId\": 128084\n" +
                "\t}, {\n" +
                "\t\t\"id\": 128279,\n" +
                "\t\t\"itemName\": \"一对一师资查看\",\n" +
                "\t\t\"parentId\": 128149\n" +
                "\t}, {\n" +
                "\t\t\"id\": 128289,\n" +
                "\t\t\"itemName\": \"一对一取消约课\",\n" +
                "\t\t\"parentId\": 128149\n" +
                "\t}, {\n" +
                "\t\t\"id\": 128292,\n" +
                "\t\t\"itemName\": \"罗刚\",\n" +
                "\t\t\"parentId\": 0\n" +
                "\t}, {\n" +
                "\t\t\"id\": 128293,\n" +
                "\t\t\"itemName\": \"语文\",\n" +
                "\t\t\"parentId\": 128292\n" +
                "\t}, {\n" +
                "\t\t\"id\": 128294,\n" +
                "\t\t\"itemName\": \"数学\",\n" +
                "\t\t\"parentId\": 128292\n" +
                "\t}, {\n" +
                "\t\t\"id\": 21171,\n" +
                "\t\t\"itemName\": \"默认学科\",\n" +
                "\t\t\"parentId\": 0\n" +
                "\t}, {\n" +
                "\t\t\"id\": 29971,\n" +
                "\t\t\"itemName\": \"20160602回归测试\",\n" +
                "\t\t\"parentId\": 29970\n" +
                "\t}, {\n" +
                "\t\t\"id\": 33238,\n" +
                "\t\t\"itemName\": \"会员\",\n" +
                "\t\t\"parentId\": 33237\n" +
                "\t}, {\n" +
                "\t\t\"id\": 43577,\n" +
                "\t\t\"itemName\": \"一000000000000000000\",\n" +
                "\t\t\"parentId\": 43576\n" +
                "\t}, {\n" +
                "\t\t\"id\": 46263,\n" +
                "\t\t\"itemName\": \"美容\",\n" +
                "\t\t\"parentId\": 46262\n" +
                "\t}, {\n" +
                "\t\t\"id\": 46265,\n" +
                "\t\t\"itemName\": \"会议\",\n" +
                "\t\t\"parentId\": 46264\n" +
                "\t}, {\n" +
                "\t\t\"id\": 49520,\n" +
                "\t\t\"itemName\": \"11111111\",\n" +
                "\t\t\"parentId\": 46319\n" +
                "\t}, {\n" +
                "\t\t\"id\": 51415,\n" +
                "\t\t\"itemName\": \"测试--学科小类\",\n" +
                "\t\t\"parentId\": 51414\n" +
                "\t}, {\n" +
                "\t\t\"id\": 54657,\n" +
                "\t\t\"itemName\": \"4.0\",\n" +
                "\t\t\"parentId\": 54656\n" +
                "\t}, {\n" +
                "\t\t\"id\": 54879,\n" +
                "\t\t\"itemName\": \"9.28日发版本前\",\n" +
                "\t\t\"parentId\": 54878\n" +
                "\t}, {\n" +
                "\t\t\"id\": 63413,\n" +
                "\t\t\"itemName\": \"购买前协议\",\n" +
                "\t\t\"parentId\": 63412\n" +
                "\t}, {\n" +
                "\t\t\"id\": 88013,\n" +
                "\t\t\"itemName\": \"学科小类5123\",\n" +
                "\t\t\"parentId\": 26194\n" +
                "\t}, {\n" +
                "\t\t\"id\": 106059,\n" +
                "\t\t\"itemName\": \"学科小类1\",\n" +
                "\t\t\"parentId\": 106058\n" +
                "\t}, {\n" +
                "\t\t\"id\": 108820,\n" +
                "\t\t\"itemName\": \"测试支付退费11\",\n" +
                "\t\t\"parentId\": 108819\n" +
                "\t}, {\n" +
                "\t\t\"id\": 109239,\n" +
                "\t\t\"itemName\": \"测试一对一约课前后台报名\",\n" +
                "\t\t\"parentId\": 109238\n" +
                "\t}, {\n" +
                "\t\t\"id\": 109342,\n" +
                "\t\t\"itemName\": \"邹天宇测试直播\",\n" +
                "\t\t\"parentId\": 109341\n" +
                "\t}, {\n" +
                "\t\t\"id\": 111120,\n" +
                "\t\t\"itemName\": \"学科小类1\",\n" +
                "\t\t\"parentId\": 111119\n" +
                "\t}, {\n" +
                "\t\t\"id\": 127481,\n" +
                "\t\t\"itemName\": \"学科小类\",\n" +
                "\t\t\"parentId\": 113814\n" +
                "\t}, {\n" +
                "\t\t\"id\": 127659,\n" +
                "\t\t\"itemName\": \"课程小类\",\n" +
                "\t\t\"parentId\": 127658\n" +
                "\t}, {\n" +
                "\t\t\"id\": 19817,\n" +
                "\t\t\"itemName\": \"学科2小类02\",\n" +
                "\t\t\"parentId\": 19816\n" +
                "\t}, {\n" +
                "\t\t\"id\": 33239,\n" +
                "\t\t\"itemName\": \"积分\",\n" +
                "\t\t\"parentId\": 33237\n" +
                "\t}, {\n" +
                "\t\t\"id\": 43578,\n" +
                "\t\t\"itemName\": \"二\",\n" +
                "\t\t\"parentId\": 43576\n" +
                "\t}, {\n" +
                "\t\t\"id\": 46320,\n" +
                "\t\t\"itemName\": \"123\",\n" +
                "\t\t\"parentId\": 46319\n" +
                "\t}, {\n" +
                "\t\t\"id\": 48076,\n" +
                "\t\t\"itemName\": \"等等负担\",\n" +
                "\t\t\"parentId\": 46262\n" +
                "\t}, {\n" +
                "\t\t\"id\": 54880,\n" +
                "\t\t\"itemName\": \"9.28发版本后\",\n" +
                "\t\t\"parentId\": 54878\n" +
                "\t}, {\n" +
                "\t\t\"id\": 63414,\n" +
                "\t\t\"itemName\": \"学习前协议\",\n" +
                "\t\t\"parentId\": 63412\n" +
                "\t}, {\n" +
                "\t\t\"id\": 78376,\n" +
                "\t\t\"itemName\": \"1234567890\",\n" +
                "\t\t\"parentId\": 54656\n" +
                "\t}, {\n" +
                "\t\t\"id\": 105877,\n" +
                "\t\t\"itemName\": \"千艺\",\n" +
                "\t\t\"parentId\": 26194\n" +
                "\t}, {\n" +
                "\t\t\"id\": 111121,\n" +
                "\t\t\"itemName\": \"学科小类2\",\n" +
                "\t\t\"parentId\": 111119\n" +
                "\t}, {\n" +
                "\t\t\"id\": 118479,\n" +
                "\t\t\"itemName\": \"课后作业的发都是范德萨范德萨发电风扇士大夫\",\n" +
                "\t\t\"parentId\": 113814\n" +
                "\t}, {\n" +
                "\t\t\"id\": 127660,\n" +
                "\t\t\"itemName\": \"财务小类\",\n" +
                "\t\t\"parentId\": 127658\n" +
                "\t}, {\n" +
                "\t\t\"id\": 128084,\n" +
                "\t\t\"itemName\": \"徐源泽测试学科\",\n" +
                "\t\t\"parentId\": 0\n" +
                "\t}, {\n" +
                "\t\t\"id\": 43579,\n" +
                "\t\t\"itemName\": \"三\",\n" +
                "\t\t\"parentId\": 43576\n" +
                "\t}, {\n" +
                "\t\t\"id\": 46507,\n" +
                "\t\t\"itemName\": \"333333\",\n" +
                "\t\t\"parentId\": 46319\n" +
                "\t}, {\n" +
                "\t\t\"id\": 88014,\n" +
                "\t\t\"itemName\": \"学科小类6学科小类6\",\n" +
                "\t\t\"parentId\": 26194\n" +
                "\t}, {\n" +
                "\t\t\"id\": 111122,\n" +
                "\t\t\"itemName\": \"学科小类3\",\n" +
                "\t\t\"parentId\": 111119\n" +
                "\t}, {\n" +
                "\t\t\"id\": 128229,\n" +
                "\t\t\"itemName\": \"刘松涛测试学科\",\n" +
                "\t\t\"parentId\": 0\n" +
                "\t}, {\n" +
                "\t\t\"id\": 43580,\n" +
                "\t\t\"itemName\": \"四\",\n" +
                "\t\t\"parentId\": 43576\n" +
                "\t}, {\n" +
                "\t\t\"id\": 46508,\n" +
                "\t\t\"itemName\": \"ere\",\n" +
                "\t\t\"parentId\": 46319\n" +
                "\t}, {\n" +
                "\t\t\"id\": 88018,\n" +
                "\t\t\"itemName\": \"学科小类10学科小类\",\n" +
                "\t\t\"parentId\": 26194\n" +
                "\t}, {\n" +
                "\t\t\"id\": 127939,\n" +
                "\t\t\"itemName\": \"2018中考冲刺名师讲座\",\n" +
                "\t\t\"parentId\": 0\n" +
                "\t}, {\n" +
                "\t\t\"id\": 88017,\n" +
                "\t\t\"itemName\": \"学科小类9\",\n" +
                "\t\t\"parentId\": 26194\n" +
                "\t}, {\n" +
                "\t\t\"id\": 108819,\n" +
                "\t\t\"itemName\": \"语文\",\n" +
                "\t\t\"parentId\": 0\n" +
                "\t}, {\n" +
                "\t\t\"id\": 88020,\n" +
                "\t\t\"itemName\": \"学科小类12学科小类\",\n" +
                "\t\t\"parentId\": 26194\n" +
                "\t}, {\n" +
                "\t\t\"id\": 127853,\n" +
                "\t\t\"itemName\": \"CRM对接网校测试数据\",\n" +
                "\t\t\"parentId\": 0\n" +
                "\t}, {\n" +
                "\t\t\"id\": 88021,\n" +
                "\t\t\"itemName\": \"学科小类13\",\n" +
                "\t\t\"parentId\": 26194\n" +
                "\t}, {\n" +
                "\t\t\"id\": 106058,\n" +
                "\t\t\"itemName\": \"学科\",\n" +
                "\t\t\"parentId\": 0\n" +
                "\t}, {\n" +
                "\t\t\"id\": 88023,\n" +
                "\t\t\"itemName\": \"学科小类15学科小类\",\n" +
                "\t\t\"parentId\": 26194\n" +
                "\t}, {\n" +
                "\t\t\"id\": 26194,\n" +
                "\t\t\"itemName\": \"免费\",\n" +
                "\t\t\"parentId\": 0\n" +
                "\t}, {\n" +
                "\t\t\"id\": 88015,\n" +
                "\t\t\"itemName\": \"学科小类7学科小类7\",\n" +
                "\t\t\"parentId\": 26194\n" +
                "\t}, {\n" +
                "\t\t\"id\": 88019,\n" +
                "\t\t\"itemName\": \"学科小类11学科小类\",\n" +
                "\t\t\"parentId\": 26194\n" +
                "\t}, {\n" +
                "\t\t\"id\": 109238,\n" +
                "\t\t\"itemName\": \"测试一对一约课前后台报名\",\n" +
                "\t\t\"parentId\": 0\n" +
                "\t}, {\n" +
                "\t\t\"id\": 54878,\n" +
                "\t\t\"itemName\": \"4.0测试\",\n" +
                "\t\t\"parentId\": 0\n" +
                "\t}, {\n" +
                "\t\t\"id\": 88016,\n" +
                "\t\t\"itemName\": \"学科小类8学科小类8\",\n" +
                "\t\t\"parentId\": 26194\n" +
                "\t}, {\n" +
                "\t\t\"id\": 77282,\n" +
                "\t\t\"itemName\": \"版本通告\",\n" +
                "\t\t\"parentId\": 0\n" +
                "\t}, {\n" +
                "\t\t\"id\": 88022,\n" +
                "\t\t\"itemName\": \"学科小类14学科小类\",\n" +
                "\t\t\"parentId\": 26194\n" +
                "\t}, {\n" +
                "\t\t\"id\": 46319,\n" +
                "\t\t\"itemName\": \"123\",\n" +
                "\t\t\"parentId\": 0\n" +
                "\t}, {\n" +
                "\t\t\"id\": 88024,\n" +
                "\t\t\"itemName\": \"学科小类17学科小类\",\n" +
                "\t\t\"parentId\": 26194\n" +
                "\t}, {\n" +
                "\t\t\"id\": 51414,\n" +
                "\t\t\"itemName\": \"于立东-测试\",\n" +
                "\t\t\"parentId\": 0\n" +
                "\t}, {\n" +
                "\t\t\"id\": 88025,\n" +
                "\t\t\"itemName\": \"学科小类18\",\n" +
                "\t\t\"parentId\": 26194\n" +
                "\t}, {\n" +
                "\t\t\"id\": 19816,\n" +
                "\t\t\"itemName\": \"工程设计\",\n" +
                "\t\t\"parentId\": 0\n" +
                "\t}, {\n" +
                "\t\t\"id\": 88009,\n" +
                "\t\t\"itemName\": \"学科小类1\",\n" +
                "\t\t\"parentId\": 26194\n" +
                "\t}, {\n" +
                "\t\t\"id\": 43576,\n" +
                "\t\t\"itemName\": \"3.8.1\",\n" +
                "\t\t\"parentId\": 0\n" +
                "\t}, {\n" +
                "\t\t\"id\": 88010,\n" +
                "\t\t\"itemName\": \"学科小类2\",\n" +
                "\t\t\"parentId\": 26194\n" +
                "\t}, {\n" +
                "\t\t\"id\": 113814,\n" +
                "\t\t\"itemName\": \"中华人民共和国万岁中华人民共和国万岁\",\n" +
                "\t\t\"parentId\": 0\n" +
                "\t}, {\n" +
                "\t\t\"id\": 88012,\n" +
                "\t\t\"itemName\": \"学科小类4\",\n" +
                "\t\t\"parentId\": 26194\n" +
                "\t}, {\n" +
                "\t\t\"id\": 109341,\n" +
                "\t\t\"itemName\": \"邹天宇测试直播\",\n" +
                "\t\t\"parentId\": 0\n" +
                "\t}, {\n" +
                "\t\t\"id\": 26195,\n" +
                "\t\t\"itemName\": \"名称长了会不会变形01\",\n" +
                "\t\t\"parentId\": 26194\n" +
                "\t}, {\n" +
                "\t\t\"id\": 46264,\n" +
                "\t\t\"itemName\": \"视频会议\",\n" +
                "\t\t\"parentId\": 0\n" +
                "\t}, {\n" +
                "\t\t\"id\": 26196,\n" +
                "\t\t\"itemName\": \"名称长了会不会变形00000000001\",\n" +
                "\t\t\"parentId\": 26194\n" +
                "\t}, {\n" +
                "\t\t\"id\": 26197,\n" +
                "\t\t\"itemName\": \"名称长了会不会变形00000000002\",\n" +
                "\t\t\"parentId\": 26194\n" +
                "\t}, {\n" +
                "\t\t\"id\": 54656,\n" +
                "\t\t\"itemName\": \"一二三四五六七八九十1234\",\n" +
                "\t\t\"parentId\": 0\n" +
                "\t}, {\n" +
                "\t\t\"id\": 26199,\n" +
                "\t\t\"itemName\": \"名称长了界面会不会变形零零零零零零零零五\",\n" +
                "\t\t\"parentId\": 26194\n" +
                "\t}, {\n" +
                "\t\t\"id\": 46262,\n" +
                "\t\t\"itemName\": \"医疗Spa\",\n" +
                "\t\t\"parentId\": 0\n" +
                "\t}, {\n" +
                "\t\t\"id\": 26200,\n" +
                "\t\t\"itemName\": \"小类多了界面怎么展现01\",\n" +
                "\t\t\"parentId\": 26194\n" +
                "\t}, {\n" +
                "\t\t\"id\": 63412,\n" +
                "\t\t\"itemName\": \"4.2版本\",\n" +
                "\t\t\"parentId\": 0\n" +
                "\t}, {\n" +
                "\t\t\"id\": 26201,\n" +
                "\t\t\"itemName\": \"小类多了界面怎么展现02\",\n" +
                "\t\t\"parentId\": 26194\n" +
                "\t}, {\n" +
                "\t\t\"id\": 29970,\n" +
                "\t\t\"itemName\": \"资产绩效管理\",\n" +
                "\t\t\"parentId\": 0\n" +
                "\t}, {\n" +
                "\t\t\"id\": 127658,\n" +
                "\t\t\"itemName\": \"财务课程\",\n" +
                "\t\t\"parentId\": 0\n" +
                "\t}, {\n" +
                "\t\t\"id\": 33237,\n" +
                "\t\t\"itemName\": \"会员积分\",\n" +
                "\t\t\"parentId\": 0\n" +
                "\t}, {\n" +
                "\t\t\"id\": 111119,\n" +
                "\t\t\"itemName\": \"测试题库整体逻辑\",\n" +
                "\t\t\"parentId\": 0\n" +
                "\t}, {\n" +
                "\t\t\"id\": 127834,\n" +
                "\t\t\"itemName\": \"海米分期\",\n" +
                "\t\t\"parentId\": 0\n" +
                "\t}, {\n" +
                "\t\t\"id\": 127836,\n" +
                "\t\t\"itemName\": \"lm学科1\",\n" +
                "\t\t\"parentId\": 0\n" +
                "\t}, {\n" +
                "\t\t\"id\": 127875,\n" +
                "\t\t\"itemName\": \"语文语文语文语文语文语文语文语语文语文语文语文语文\",\n" +
                "\t\t\"parentId\": 0\n" +
                "\t}, {\n" +
                "\t\t\"id\": 128149,\n" +
                "\t\t\"itemName\": \"lijie\",\n" +
                "\t\t\"parentId\": 0\n" +
                "\t}, {\n" +
                "\t\t\"id\": 128159,\n" +
                "\t\t\"itemName\": \"前台展示\",\n" +
                "\t\t\"parentId\": 0\n" +
                "\t}, {\n" +
                "\t\t\"id\": 128205,\n" +
                "\t\t\"itemName\": \"929\",\n" +
                "\t\t\"parentId\": 0\n" +
                "\t}]";

        Gson gson = new Gson();
        TypeToken<List<CourseBean>> typeToken = new TypeToken<List<CourseBean>>() {};
        List<CourseBean> list= gson.fromJson(json, typeToken.getType());
        return list;
    }

}
