package com.fendasz.moku.planet.ui.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.fendasz.moku.planet.R;
import com.fendasz.moku.planet.utils.PhoneScreenUtils;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class TitleView extends RelativeLayout {
    private static final int HEIGHT = 146;
    private TextView leftTextView;
    private Context mContext;
    private PhoneScreenUtils phoneScreenUtils;
    private ImageView righTagImage;
    private RelativeLayout rlTitle;
    private RelativeLayout rlTitleBg;
    private TextView tvTitleCenter;
    private MokuIconTextView tvTitleRight;

    public TitleView(Context context) {
        super(context);
        this.mContext = context;
        initView();
    }

    public TitleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        initView();
    }

    public TitleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        initView();
    }

    private void initView() {
        this.phoneScreenUtils = PhoneScreenUtils.getInstance();
        View.inflate(this.mContext, R.layout.moku_titleview_layout, this);
        this.leftTextView = (TextView) findViewById(R.id.tv_title_left);
        this.tvTitleCenter = (TextView) findViewById(R.id.tv_title_center);
        this.tvTitleRight = (MokuIconTextView) findViewById(R.id.tv_title_right);
        this.rlTitle = (RelativeLayout) findViewById(R.id.rl_title);
        this.rlTitleBg = (RelativeLayout) findViewById(R.id.rl_title_bg);
        this.righTagImage = (ImageView) findViewById(R.id.iv_title_tag);
        this.tvTitleCenter.setTextSize(this.phoneScreenUtils.getTitleTextSize(this.mContext));
        this.tvTitleRight.setTextSize(this.phoneScreenUtils.getNormalTextSize(this.mContext));
        this.leftTextView.setTextSize(this.phoneScreenUtils.getScaleTextSize(this.mContext, 80));
        this.leftTextView.setPadding(this.phoneScreenUtils.getScale(this.mContext, 30.0f), 0, 0, 0);
        this.tvTitleRight.setPadding(0, this.phoneScreenUtils.getScale(this.mContext, 30.0f), this.phoneScreenUtils.getScale(this.mContext, 30.0f), this.phoneScreenUtils.getScale(this.mContext, 30.0f));
    }

    public void initViewHeight(ViewGroup.LayoutParams layoutParams) {
        layoutParams.height = this.phoneScreenUtils.getScale(this.mContext, 146.0f);
    }

    public RelativeLayout getTitleBg() {
        return this.rlTitleBg;
    }

    public TextView getLeftTextView() {
        return this.leftTextView;
    }

    public TextView getCenterTextView() {
        return this.tvTitleCenter;
    }

    public MokuIconTextView getRightTextView() {
        return this.tvTitleRight;
    }

    public ImageView getRighTagImage() {
        return this.righTagImage;
    }

    public RelativeLayout getTitleCenterRelativeLayout() {
        return this.rlTitle;
    }
}
