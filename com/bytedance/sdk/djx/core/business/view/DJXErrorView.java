package com.bytedance.sdk.djx.core.business.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.pangle.cn.pangrowth.djx.sdk.lite.R;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class DJXErrorView extends LinearLayout {
    private View.OnClickListener mRetryListener;
    private TextView mTvBtn;
    private TextView mTvTip;

    public DJXErrorView(Context context) {
        super(context);
        init(context);
    }

    public DJXErrorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public DJXErrorView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.djx_view_error, (ViewGroup) this, true);
        setGravity(17);
        setOrientation(1);
        setClickable(true);
        setFocusable(true);
        this.mTvTip = (TextView) findViewById(R.id.djx_error_tip);
        TextView textView = (TextView) findViewById(R.id.djx_error_btn);
        this.mTvBtn = textView;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.djx.core.business.view.DJXErrorView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (DJXErrorView.this.mRetryListener != null) {
                    DJXErrorView.this.mRetryListener.onClick(view);
                }
            }
        });
    }

    public void setTipText(String str) {
        this.mTvTip.setText(str);
    }

    public void setTipColor(int i) {
        this.mTvTip.setTextColor(i);
    }

    public TextView getTipView() {
        return this.mTvTip;
    }

    public TextView getBtnView() {
        return this.mTvBtn;
    }

    public void setBtnTvColor(int i) {
        this.mTvBtn.setTextColor(i);
    }

    public void setBtnBackground(int i) {
        this.mTvBtn.setBackgroundResource(i);
    }

    public void show(boolean z) {
        setVisibility(z ? 0 : 8);
    }

    public void setRetryListener(View.OnClickListener onClickListener) {
        this.mRetryListener = onClickListener;
    }

    public void performRetryClick() {
        View.OnClickListener onClickListener = this.mRetryListener;
        if (onClickListener != null) {
            onClickListener.onClick(this.mTvBtn);
        }
    }
}
