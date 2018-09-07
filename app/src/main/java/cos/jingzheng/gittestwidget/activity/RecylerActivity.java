package cos.jingzheng.gittestwidget.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cos.jingzheng.gittestwidget.R;
import cos.jingzheng.gittestwidget.recylerview.RecyAdapter;

public class RecylerActivity extends AppCompatActivity {

    @BindView(R.id.recylerview)
    RecyclerView mRecyclerView;
    Context mCtx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyler);
        ButterKnife.bind(this);
        mCtx = this;

        RecyAdapter adapter = new RecyAdapter(genChars(50));
        LinearLayoutManager layoutManager = new LinearLayoutManager(mCtx,LinearLayoutManager.VERTICAL,false);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(adapter);

    }


    private List<String> genChars(int size) {
        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            char ch = (char) (i+50);
            list.add(String.valueOf(ch));
        }
        return list;
    }





}
