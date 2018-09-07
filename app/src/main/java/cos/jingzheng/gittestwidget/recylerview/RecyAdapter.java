package cos.jingzheng.gittestwidget.recylerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by jingzheng on 2018/8/23.
 */

public class RecyAdapter extends RecyclerView.Adapter<RecyAdapter.Holder> {

    private List<String> datas;

    public RecyAdapter(List<String> datas) {
        this.datas = datas;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        TextView textView = (TextView) View.inflate(parent.getContext(), android.R.layout.simple_list_item_1, null);
        return new Holder(textView);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        holder.tv.setText(datas.get(position));
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }


    class Holder extends RecyclerView.ViewHolder{
        TextView tv;
        Holder(View itemView) {
            super(itemView);
            tv = (TextView) itemView;
        }
    }
}
