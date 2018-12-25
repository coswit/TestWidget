package cos.jingzheng.gittestwidget.flow;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.Checkable;
import android.widget.FrameLayout;

/**
 * @author Created by zhengjing on 2018/11/22.
 */

public class TagView extends FrameLayout implements Checkable{

    private boolean checked;
    public TagView(@NonNull Context context) {
        super(context);
    }
//    public TagView(@NonNull Context context, @Nullable AttributeSet attrs) {
//        this(context, attrs,0);
//    }
//
//    public TagView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
//        super(context, attrs, defStyleAttr);
//    }

    @Override
    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    @Override
    public boolean isChecked() {
        return checked;
    }

    @Override
    public void toggle() {

    }
}
