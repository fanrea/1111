package com.fendasz.moku.planet.ui.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.fendasz.moku.planet.R;
import com.fendasz.moku.planet.helper.MokuConfigure;
import com.fendasz.moku.planet.source.bean.TagForm;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class TagNameAdapter extends BaseAdapter {
    private static final String TAG = "TagNameAdapter==>";
    private GradientDrawable itemShapeNor = new GradientDrawable();
    private GradientDrawable itemShapeSel;
    private LayoutInflater mInflater;
    private TextView tagNameText;
    private List<TagForm> taskLabelList;
    private int themeColor;

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public TagNameAdapter(Context context, List<TagForm> list) {
        this.taskLabelList = list;
        this.mInflater = LayoutInflater.from(context);
        this.themeColor = Color.parseColor(MokuConfigure.getInstance().getMokuOptions(context).getString("tabTextColor", "#D2E5CF"));
        this.itemShapeNor.setColor(-1);
        this.itemShapeNor.setStroke(1, this.themeColor);
        this.itemShapeNor.setCornerRadius(5.0f);
        this.itemShapeNor.setShape(0);
        GradientDrawable gradientDrawable = new GradientDrawable();
        this.itemShapeSel = gradientDrawable;
        gradientDrawable.setColor(this.themeColor);
        this.itemShapeSel.setStroke(1, this.themeColor);
        this.itemShapeSel.setCornerRadius(5.0f);
        this.itemShapeSel.setShape(0);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<TagForm> list = this.taskLabelList;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.taskLabelList.get(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = this.mInflater.inflate(R.layout.moku_grid_item_tag, (ViewGroup) null);
            viewHolder = new ViewHolder();
            viewHolder.tagNameText = (TextView) view.findViewById(R.id.tv_tag_name);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.tagNameText.setText(this.taskLabelList.get(i).getTagName());
        if (this.taskLabelList.get(i).isSelect()) {
            viewHolder.tagNameText.setTextColor(-1);
            view.setBackground(this.itemShapeSel);
        } else {
            viewHolder.tagNameText.setTextColor(this.themeColor);
            view.setBackground(this.itemShapeNor);
        }
        return view;
    }

    public List<TagForm> getTaskLabelList() {
        return this.taskLabelList;
    }

    public void setTaskLabelList(List<TagForm> list) {
        this.taskLabelList = list;
    }

    static class ViewHolder {
        TextView tagNameText;

        ViewHolder() {
        }
    }
}
