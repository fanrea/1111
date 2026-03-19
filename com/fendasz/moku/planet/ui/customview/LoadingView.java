package com.fendasz.moku.planet.ui.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.fendasz.moku.planet.R;
import com.fendasz.moku.planet.utils.PhoneScreenUtils;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class LoadingView extends RelativeLayout {
    private boolean mIsCanTouchDismiss;
    private boolean mIsCancelable;
    private TextView mTvLoadingDesc;

    public LoadingView(Context context) {
        super(context);
        this.mIsCancelable = false;
        this.mIsCanTouchDismiss = false;
        onLoad(context, null);
    }

    public LoadingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mIsCancelable = false;
        this.mIsCanTouchDismiss = false;
        onLoad(context, attributeSet);
    }

    public LoadingView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mIsCancelable = false;
        this.mIsCanTouchDismiss = false;
        onLoad(context, attributeSet);
    }

    private void onLoad(Context context, AttributeSet attributeSet) {
        initView();
        initListener();
        if (attributeSet != null) {
            initData(context, attributeSet);
        }
    }

    private void initData(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MokuLoadingView);
        String string = typedArrayObtainStyledAttributes.getString(R.styleable.MokuLoadingView_desc_text);
        boolean z = typedArrayObtainStyledAttributes.getBoolean(R.styleable.MokuLoadingView_cancelable, false);
        boolean z2 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.MokuLoadingView_touch_dismiss, false);
        typedArrayObtainStyledAttributes.recycle();
        setTvLoadingDesc(string);
        setCancelable(z);
        setCanTouchDismiss(z2);
    }

    public void show() {
        setVisibility(0);
        ImageView imageView = (ImageView) findViewById(R.id.pb_image);
        imageView.clearAnimation();
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setInterpolator(new LinearInterpolator());
        rotateAnimation.setRepeatCount(-1);
        rotateAnimation.setDuration(1000L);
        imageView.startAnimation(rotateAnimation);
    }

    public void hide() {
        setVisibility(8);
        ((ImageView) findViewById(R.id.pb_image)).clearAnimation();
    }

    public boolean isShowing() {
        return getVisibility() == 0;
    }

    private void initListener() {
        setOnTouchListener(new View.OnTouchListener() { // from class: com.fendasz.moku.planet.ui.customview.LoadingView.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (!LoadingView.this.mIsCanTouchDismiss) {
                    return true;
                }
                LoadingView.this.setVisibility(8);
                return true;
            }
        });
    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(R.layout.moku_anysc_http_loading, (ViewGroup) this, true);
        TextView textView = (TextView) findViewById(R.id.tv_loading_desc);
        this.mTvLoadingDesc = textView;
        textView.setTextSize(PhoneScreenUtils.getInstance().getNormalTextSize(getContext()));
        setVisibility(8);
    }

    public void setTvLoadingDesc(String str) {
        this.mTvLoadingDesc.setText(str);
        this.mTvLoadingDesc.setVisibility(str != null ? 0 : 8);
    }

    public void setCancelable(boolean z) {
        this.mIsCancelable = z;
    }

    public void setCanTouchDismiss(boolean z) {
        this.mIsCanTouchDismiss = z;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (!this.mIsCancelable) {
                return false;
            }
            setVisibility(8);
            return false;
        }
        return super.onKeyDown(i, keyEvent);
    }
}
