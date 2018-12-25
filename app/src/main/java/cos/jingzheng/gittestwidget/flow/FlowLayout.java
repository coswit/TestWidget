package cos.jingzheng.gittestwidget.flow;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * @author Created by zhengjing on 2018/11/20.
 */

public class FlowLayout extends ViewGroup {

    private Context context;
    private FlowAdapter mAdapter;
    private int maxLine = 1000;

    public FlowLayout(Context context) {
        this(context, null);
    }

    public FlowLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FlowLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;

    }

    private void addChildView() {
        List data = mAdapter.getData();
        for (int i = 0; i < data.size(); i++) {
            TagView tagView = new TagView(getContext());
            View view = mAdapter.getView(this,i,data.get(i));
            LayoutParams layoutParams = view.getLayoutParams();
            if(layoutParams!=null){
                tagView.setLayoutParams(layoutParams);
            }else {
                MarginLayoutParams ml = new MarginLayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
                tagView.setLayoutParams(ml);
            }
            tagView.addView(view);
            addView(tagView);
        }

    }

    public void setAdapter(FlowAdapter adapter) {
        mAdapter = adapter;
        addChildView();
        requestLayout();
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int childCount = getChildCount();
        int lineWidth = 0;
        int width = getMeasuredWidth();
        int lineHeight = 0;
        for (int i = 0; i < childCount; i++) {
            View child = getChildAt(i);
            int childWidth = child.getMeasuredWidth();
            int childHeight = child.getMeasuredHeight();

            MarginLayoutParams lp = (MarginLayoutParams) child.getLayoutParams();
            int marginStart = lp.getMarginStart();
            int marginEnd = lp.getMarginEnd();

            if(lineWidth+childWidth +marginStart +marginEnd>width-getPaddingStart()-getPaddingEnd()){
                lineWidth =0;
                lineHeight += childHeight;
            }

            int cl = lineWidth + marginStart;
            int cr = lineWidth + childWidth;
            int ct = lineHeight;
            int cb = childHeight + lineHeight;
            child.layout(cl, ct, cr, cb);
            lineWidth = lineWidth +childWidth +marginStart +marginEnd;



        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        int lineHeight = 0;
        int lineWidth = 0;

        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View child = getChildAt(i);
            measureChild(child, widthMeasureSpec, heightMeasureSpec);

            int childWidth = child.getMeasuredWidth();
            int childHeight = child.getMeasuredHeight();
            LayoutParams layoutParams = child.getLayoutParams();
            MarginLayoutParams lp = (MarginLayoutParams) layoutParams;
            int marginStart = lp.getMarginStart();
            int marginEnd = lp.getMarginEnd();
            lineWidth = lineWidth +childWidth +marginStart +marginEnd;
            if(lineWidth>widthSize-getPaddingStart()-getPaddingEnd()){
                lineWidth =0;
                lineHeight += childHeight;
            }else {
                lineHeight = Math.max(lineHeight,childHeight);
            }

        }
        setMeasuredDimension(widthSize, lineHeight);
    }
}
