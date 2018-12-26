package cos.jingzheng.gittestwidget;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import butterknife.ButterKnife;
import butterknife.OnClick;
import cos.jingzheng.gittestwidget.activity.BarsActivity;
import cos.jingzheng.gittestwidget.activity.RecylerActivity;
import cos.jingzheng.gittestwidget.activity.ViewpagerActivity;
import cos.jingzheng.gittestwidget.flow.FlowActivity;
import cos.jingzheng.gittestwidget.js.JsActivity;
import cos.jingzheng.gittestwidget.progressBar.ProgressBarActivity;


public class MainActivity extends AppCompatActivity {

    private Button btnMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        btnMap = (Button) findViewById(R.id.btn_map);
    }



    @OnClick({R.id.btn_map, R.id.btn_dialog,R.id.btn_softKeyboard,
            R.id.recylerview,
            R.id.bars,
            R.id.js,
            R.id.btn_viewpager})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_map:
                startActivity(new Intent(this, ProgressBarActivity.class));
                break;
            case R.id.btn_dialog:
                initDialog();
                break;
            case R.id.btn_softKeyboard:
                startActivity(new Intent(this,SoftKeyboardActivity.class));
                break;
            case R.id.btn_viewpager:
                startActivity(new Intent(this, ViewpagerActivity.class));
                break;
            case R.id.recylerview:
                startActivity(new Intent(this,RecylerActivity.class));
                break;
            case R.id.bars:
                startActivity(new Intent(this, BarsActivity.class));
                break;

            case R.id.js:
                startActivity(new Intent(this, JsActivity.class));
                break;
            default:
                break;
        }
    }



    @OnClick(R.id.flow)
    void toFlow(){
        startActivity(new Intent(this, FlowActivity.class));

    }
    private void initDialog() {


        View view = getLayoutInflater().inflate(R.layout.dialog, null);
        AlertDialog alertDialog = new  AlertDialog.Builder(this).setView(view).create();
        alertDialog.setCanceledOnTouchOutside(false);
        alertDialog.show();
        alertDialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
    }
}
