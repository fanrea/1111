package com.fendasz.moku.planet.ui.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.fendasz.moku.planet.R;
import com.fendasz.moku.planet.entity.Status;
import com.fendasz.moku.planet.utils.PhoneScreenUtils;
import com.fendasz.moku.planet.utils.ScreenAdaptationUtils;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class StatusEmptyView extends RelativeLayout {
    private ImageView mIvEmpty;
    private TextView mTvBtnEmptyBottom;
    private TextView mTvBtnEmptyTop;
    private TextView mTvEmptyDetail;
    private TextView mTvEmptyTitle;

    public StatusEmptyView(Context context) {
        super(context);
        onLoad(context, null);
    }

    public StatusEmptyView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        onLoad(context, attributeSet);
    }

    public StatusEmptyView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        onLoad(context, attributeSet);
    }

    private void onLoad(Context context, AttributeSet attributeSet) {
        initView();
        if (attributeSet != null) {
            initData(context, attributeSet);
        }
    }

    private void initData(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MokuStatusEmptyView);
        String string = typedArrayObtainStyledAttributes.getString(R.styleable.MokuStatusEmptyView_title_text);
        String string2 = typedArrayObtainStyledAttributes.getString(R.styleable.MokuStatusEmptyView_detail_text);
        String string3 = typedArrayObtainStyledAttributes.getString(R.styleable.MokuStatusEmptyView_button_top_text);
        String string4 = typedArrayObtainStyledAttributes.getString(R.styleable.MokuStatusEmptyView_button_bottom_text);
        int i = typedArrayObtainStyledAttributes.getInt(R.styleable.MokuStatusEmptyView_image_background, R.drawable.moku_no_data);
        typedArrayObtainStyledAttributes.recycle();
        setImageBackground(Integer.valueOf(i));
        setTitleText(string);
        setDetailText(string2);
        setButtonTop(string3, null);
        setButtonBottom(string4, null);
    }

    public void show(Status status, View.OnClickListener onClickListener, View.OnClickListener onClickListener2) {
        setImageBackground(status.getImage());
        setTitleText(status.getTitle());
        setDetailText(status.getDetail());
        setButtonTop(status.getBtnTop(), onClickListener);
        setButtonBottom(status.getBtnBottom(), onClickListener2);
        setVisibility(0);
    }

    public void show() {
        setVisibility(0);
    }

    public void hide() {
        setVisibility(8);
        setImageBackground(null);
        setTitleText(null);
        setDetailText(null);
        setButtonTop(null, null);
        setButtonBottom(null, null);
    }

    public boolean isShowing() {
        return getVisibility() == 0;
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(R.layout.moku_status_empty_view, (ViewGroup) this, true);
        this.mIvEmpty = (ImageView) findViewById(R.id.iv_empty);
        this.mTvEmptyTitle = (TextView) findViewById(R.id.tv_empty_title);
        this.mTvEmptyDetail = (TextView) findViewById(R.id.tv_empty_detail);
        this.mTvBtnEmptyTop = (TextView) findViewById(R.id.tv_btn_empty_top);
        this.mTvBtnEmptyBottom = (TextView) findViewById(R.id.tv_btn_empty_bottom);
        PhoneScreenUtils phoneScreenUtils = PhoneScreenUtils.getInstance();
        ScreenAdaptationUtils.setSize(getContext(), this.mIvEmpty, 343, 237);
        this.mTvEmptyTitle.setTextSize(phoneScreenUtils.getBigTextSize(getContext()));
        this.mTvEmptyDetail.setTextSize(phoneScreenUtils.getBigTextSize(getContext()));
        this.mTvBtnEmptyTop.setTextSize(phoneScreenUtils.getNormalTextSize(getContext()));
        ScreenAdaptationUtils.setSize(getContext(), this.mTvBtnEmptyTop, 300, 120);
        this.mTvBtnEmptyBottom.setTextSize(phoneScreenUtils.getNormalTextSize(getContext()));
        ScreenAdaptationUtils.setSize(getContext(), this.mTvBtnEmptyBottom, 300, 120);
        setVisibility(8);
    }

    public void setImageBackground(Integer num) {
        if (num != null) {
            this.mIvEmpty.setImageResource(num.intValue());
        }
        this.mIvEmpty.setVisibility(num != null ? 0 : 8);
    }

    public void setTitleText(String str) {
        this.mTvEmptyTitle.setText(str);
        this.mTvEmptyTitle.setVisibility(str != null ? 0 : 8);
    }

    public void setDetailText(String str) {
        this.mTvEmptyDetail.setText(str);
        this.mTvEmptyDetail.setVisibility(str != null ? 0 : 8);
    }

    public void setButtonTop(String str, View.OnClickListener onClickListener) {
        this.mTvBtnEmptyTop.setText(str);
        this.mTvBtnEmptyTop.setVisibility(str != null ? 0 : 8);
        this.mTvBtnEmptyTop.setOnClickListener(onClickListener);
    }

    public void setButtonBottom(String str, View.OnClickListener onClickListener) {
        this.mTvBtnEmptyBottom.setText(str);
        this.mTvBtnEmptyBottom.setVisibility(str != null ? 0 : 8);
        this.mTvBtnEmptyBottom.setOnClickListener(onClickListener);
    }
}
