package com.fendasz.moku.planet.ui.popupwindow;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import com.fendasz.moku.planet.source.bean.TagForm;
import com.fendasz.moku.planet.ui.adapter.TagNameAdapter;
import com.fendasz.moku.planet.utils.PhoneInfoUtils;
import com.fendasz.moku.planet.utils.PhoneScreenUtils;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class LabelSearchPopupwindow extends PopupWindow {
    private Integer configId;
    private GridView gridView;
    private int lasetSelectIndex = -1;
    private OnTagFormSelectLisenter onTagFormSelectLisenter;
    private TagNameAdapter tagNameAdapter;

    public interface OnTagFormSelectLisenter {
        void onTagFormSelect(TagForm tagForm);
    }

    public LabelSearchPopupwindow(Context context, List<TagForm> list) {
        this.tagNameAdapter = new TagNameAdapter(context, list);
        initView(context);
    }

    public LabelSearchPopupwindow(Context context) {
        this.tagNameAdapter = new TagNameAdapter(context, null);
        initView(context);
    }

    protected void initView(Context context) {
        int iCountHieight;
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setGravity(17);
        int widthPixels = PhoneScreenUtils.getInstance().getWidthPixels(context);
        List<TagForm> taskLabelList = this.tagNameAdapter.getTaskLabelList();
        if (taskLabelList != null) {
            iCountHieight = countHieight(taskLabelList.size()) + dp2px(20);
            setHeight(iCountHieight);
            if (iCountHieight == 0) {
                throw new IllegalArgumentException("lab size is error");
            }
        } else {
            iCountHieight = 0;
        }
        GridView gridView = new GridView(context);
        this.gridView = gridView;
        linearLayout.addView(gridView);
        this.gridView.setNumColumns(4);
        this.gridView.setVerticalSpacing(dp2px(10));
        this.gridView.setHorizontalSpacing(dp2px(10));
        this.gridView.setLayoutParams(new LinearLayout.LayoutParams(widthPixels - dp2px(20), iCountHieight));
        this.gridView.setAdapter((ListAdapter) this.tagNameAdapter);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(widthPixels, iCountHieight + dp2px(40));
        layoutParams.gravity = 17;
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setBackgroundColor(-1);
        setFocusable(true);
        setOutsideTouchable(true);
        setBackgroundDrawable(new ColorDrawable(0));
        setWidth(PhoneScreenUtils.getInstance().getWidthPixels(context));
        setContentView(linearLayout);
        this.gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.fendasz.moku.planet.ui.popupwindow.LabelSearchPopupwindow.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (LabelSearchPopupwindow.this.lasetSelectIndex == -1) {
                    LabelSearchPopupwindow.this.lasetSelectIndex = i;
                    LabelSearchPopupwindow.this.tagNameAdapter.getTaskLabelList().get(i).setSelect(true);
                    LabelSearchPopupwindow.this.tagNameAdapter.notifyDataSetChanged();
                    if (LabelSearchPopupwindow.this.onTagFormSelectLisenter != null) {
                        LabelSearchPopupwindow.this.onTagFormSelectLisenter.onTagFormSelect(LabelSearchPopupwindow.this.tagNameAdapter.getTaskLabelList().get(i));
                        return;
                    }
                    return;
                }
                if (i != LabelSearchPopupwindow.this.lasetSelectIndex) {
                    LabelSearchPopupwindow.this.tagNameAdapter.getTaskLabelList().get(i).setSelect(true);
                    LabelSearchPopupwindow.this.tagNameAdapter.getTaskLabelList().get(LabelSearchPopupwindow.this.lasetSelectIndex).setSelect(false);
                    LabelSearchPopupwindow.this.tagNameAdapter.notifyDataSetChanged();
                    if (LabelSearchPopupwindow.this.onTagFormSelectLisenter != null) {
                        LabelSearchPopupwindow.this.onTagFormSelectLisenter.onTagFormSelect(LabelSearchPopupwindow.this.tagNameAdapter.getTaskLabelList().get(i));
                    }
                } else {
                    LabelSearchPopupwindow.this.dismiss();
                }
                LabelSearchPopupwindow.this.lasetSelectIndex = i;
            }
        });
    }

    public OnTagFormSelectLisenter getOnTagFormSelectLisenter() {
        return this.onTagFormSelectLisenter;
    }

    public void setOnTagFormSelectLisenter(OnTagFormSelectLisenter onTagFormSelectLisenter) {
        this.onTagFormSelectLisenter = onTagFormSelectLisenter;
    }

    private int countHieight(int i) {
        int i2;
        if (i % 4 == 0) {
            i2 = i / 4;
        } else {
            i2 = (i / 4) + 1;
        }
        return dp2px((i2 * ("Redmi".equals(PhoneInfoUtils.getInstance().getMobileBrandName()) ? 55 : 40)) + ((i2 - 1) * 10));
    }

    private int dp2px(int i) {
        return (int) ((i * ((int) Resources.getSystem().getDisplayMetrics().density)) + 0.5f);
    }

    public void setLabelList(List<TagForm> list) {
        int i = this.lasetSelectIndex;
        if (i != -1 && i < this.tagNameAdapter.getTaskLabelList().size()) {
            this.tagNameAdapter.getTaskLabelList().get(this.lasetSelectIndex).setSelect(false);
            this.lasetSelectIndex = -1;
        }
        this.tagNameAdapter.setTaskLabelList(list);
        this.tagNameAdapter.notifyDataSetChanged();
        if (list != null) {
            View contentView = getContentView();
            int widthPixels = PhoneScreenUtils.getInstance().getWidthPixels(contentView.getContext());
            int iCountHieight = countHieight(list.size());
            ViewGroup.LayoutParams layoutParams = this.gridView.getLayoutParams();
            layoutParams.width = widthPixels - dp2px(20);
            layoutParams.height = iCountHieight;
            this.gridView.setLayoutParams(layoutParams);
            int iDp2px = iCountHieight + dp2px(40);
            ViewGroup.LayoutParams layoutParams2 = contentView.getLayoutParams();
            layoutParams2.width = widthPixels;
            layoutParams2.height = iDp2px;
            setHeight(iDp2px);
            setWidth(widthPixels);
            contentView.setLayoutParams(layoutParams2);
        }
    }

    public Integer getConfigId() {
        return this.configId;
    }

    public void setConfigId(Integer num) {
        this.configId = num;
    }
}
