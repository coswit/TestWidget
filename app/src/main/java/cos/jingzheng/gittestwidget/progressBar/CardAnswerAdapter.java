package cos.jingzheng.gittestwidget.progressBar;

import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.widget.ProgressBar;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.text.DecimalFormat;
import java.util.List;

import cos.jingzheng.gittestwidget.R;

/**
 * Created by jingzheng on 2018/6/17.
 */

public class CardAnswerAdapter extends BaseQuickAdapter<CardAnswerBean.Answer, BaseViewHolder> {
    public CardAnswerAdapter(@Nullable List data) {
        super(R.layout.item_zs_progress, data);
    }


    @Override
    protected void convert(BaseViewHolder helper, CardAnswerBean.Answer item) {
        helper.setText(R.id.tv_letter, item.letter + "");
        ProgressBar progress = helper.getView(R.id.progressbar);
        progress.setMax(100);
        DecimalFormat df = new DecimalFormat("0");
        if (item.all > 0) {
            double d = (double) item.answered / item.all;

            String percent = df.format(d * 100);
            int per = 0;
            try {
                per = Integer.parseInt(percent);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
            helper.setText(R.id.tv_percent, item.answered + "人" + " （" + percent + "%)");
            progress.setProgressDrawable(ContextCompat.getDrawable(mContext,per>=50?R.drawable.progress_bar_more:R.drawable.progress_bar_less));
            progress.setProgress(per);

        } else {
            helper.setText(R.id.tv_percent, item.answered + "人" + " （" + 0 + "%)");
            progress.setProgress(0);
        }
    }
}
