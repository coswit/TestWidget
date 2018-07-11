package cos.jingzheng.gittestwidget.progressBar;

import android.graphics.Point;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.blankj.utilcode.util.SpanUtils;

import cos.jingzheng.gittestwidget.R;
import lombok.Setter;

/**
 * Created by jingzheng on 2018/6/17.
 */

public class ProgressDialogFragment extends DialogFragment {


    private RecyclerView mRecylerView;
    private CardAnswerAdapter mAdapter;
    @Setter
    public CardAnswerBean cardAnswer;
    TextView total;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getDialog().setCanceledOnTouchOutside(false);
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        View rootView = inflater.inflate(R.layout.dialog_progress_bar, container, false);
        mRecylerView = rootView.findViewById(R.id.recylerview);
        total = rootView.findViewById(R.id.total);
//        mFlowLayout = rootView.findViewById(R.id.flowlayout);
//        btn_submit = rootView.findViewById(R.id.btn_submit);
//        btn_submit.setClickable(true);
//
//        setListener(rootView);
        Window window = getDialog().getWindow();
        window.setBackgroundDrawableResource(R.color.transparent);
        window.getDecorView().setPadding(0, 0, 0, 0);

        WindowManager.LayoutParams wlp = window.getAttributes();
//        wlp.gravity = Gravity.CENTER;
        wlp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        Point point = new Point();
        window.getWindowManager().getDefaultDisplay().getSize(point);
        wlp.width = (int) (point.x * 0.9);
        window.setAttributes(wlp);

        RecyclerView.LayoutManager manager = new LinearLayoutManager(getActivity());
        mRecylerView.setLayoutManager(manager);
        mRecylerView.setOverScrollMode(View.OVER_SCROLL_NEVER);
        mAdapter = new CardAnswerAdapter(cardAnswer.getAnswers());
        mRecylerView.setAdapter(mAdapter);

        return rootView;
    }


    public void setDatas(CardAnswerBean cardAnswer) {
        mAdapter.setNewData(cardAnswer.getAnswers());
    }


    @Override
    public void onResume() {
        super.onResume();

        new SpanUtils().append("我的答案：").appendImage(R.mipmap.ic_zs_answer_right)
                ;
    }
}
