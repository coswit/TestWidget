package cos.jingzheng.gittestwidget;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends AppCompatActivity {

    private Button btnMap;
    private AlertDialog mAlertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        btnMap = (Button) findViewById(R.id.btn_map);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
    }



    @OnClick({R.id.btn_map, R.id.btn_dialog,R.id.btn_softKeyboard})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_map:
                startActivity(new Intent(this, BaiduMapActivity.class));
                break;
            case R.id.btn_dialog:
                initDialog();
                break;
            case R.id.btn_softKeyboard:
                startActivity(new Intent(this,SoftKeyboardActivity.class));
                break;
        }
    }

    private void initDialog() {


        View view = getLayoutInflater().inflate(R.layout.dialog, null);
        AlertDialog alertDialog = new  AlertDialog.Builder(this).setView(view).create();
        alertDialog.setCanceledOnTouchOutside(false);
        alertDialog.show();
        alertDialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
    }
}
