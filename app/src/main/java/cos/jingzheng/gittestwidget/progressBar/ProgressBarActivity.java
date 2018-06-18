package cos.jingzheng.gittestwidget.progressBar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;
import cos.jingzheng.gittestwidget.R;

public class ProgressBarActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar);
        ButterKnife.bind(this);

    }


    @OnClick(R.id.btn_show)
    void showDialog() {
        ProgressDialogFragment dialog = new ProgressDialogFragment();

        CardAnswerBean bean = new CardAnswerBean();
        bean.setI1(2);
        bean.setInts(new int[]{0,1,1,1,3,0,4});
        bean.setInts1(new int[]{2,2,3,5,4,4,4});
        dialog.setCardAnswer(bean);
        dialog.show(getSupportFragmentManager(),"progressDialog");
    }

}
