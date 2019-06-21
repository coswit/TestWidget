package cos.jingzheng.gittestwidget.inject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import butterknife.OnClick;
import cos.bind.InjectView;
import cos.jingzheng.gittestwidget.R;

public class InjectActivity extends AppCompatActivity {


    //    @BindView(R.id.tv_inject)
    @InjectView(R.id.tv_inject)
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inject);

//        NewKnife.bind(this);
//        ViewInjector.inject(this);
        Binding.bind(this);

        textView.setText("text");

    }

    @OnClick(R.id.bt_1)
    void click() {

    }

}
