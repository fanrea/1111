package com.bytedance.sdk.component.adexpress.widget;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import com.bytedance.sdk.component.adexpress.dynamic.c.mk;
import com.bytedance.sdk.component.utils.jh;
import com.bytedance.sdk.component.utils.zw;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class AnimationText extends TextSwitcher implements ViewSwitcher.ViewFactory, zw.d {
    private TextView an;
    private int b;
    private final int c;
    Animation.AnimationListener d;
    private int gb;
    private int h;
    private List<String> hc;
    private Handler k;
    private int mk;
    private int mq;
    private int tc;
    private float tt;
    private Context u;
    private int uo;

    public AnimationText(Context context, int i, float f, int i2, int i3) {
        super(context);
        this.hc = new ArrayList();
        this.b = 0;
        this.c = 1;
        this.k = new zw(Looper.getMainLooper(), this);
        this.d = new Animation.AnimationListener() { // from class: com.bytedance.sdk.component.adexpress.widget.AnimationText.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (AnimationText.this.an != null) {
                    AnimationText.this.an.setText("");
                }
            }
        };
        this.u = context;
        this.gb = i;
        this.tt = f;
        this.tc = i2;
        this.uo = i3;
        b();
    }

    private void b() {
        setFactory(this);
    }

    public void setAnimationType(int i) {
        this.mq = i;
    }

    public void setAnimationDuration(int i) {
        this.h = i;
    }

    public void d() {
        int i = this.mq;
        if (i == 1) {
            setInAnimation(getContext(), jh.mq(this.u, "tt_text_animation_y_in"));
            setOutAnimation(getContext(), jh.mq(this.u, "tt_text_animation_y_out"));
        } else if (i == 0) {
            setInAnimation(getContext(), jh.mq(this.u, "tt_text_animation_x_in"));
            setOutAnimation(getContext(), jh.mq(this.u, "tt_text_animation_x_in"));
            getInAnimation().setInterpolator(new LinearInterpolator());
            getOutAnimation().setInterpolator(new LinearInterpolator());
            getInAnimation().setAnimationListener(this.d);
            getOutAnimation().setAnimationListener(this.d);
        }
        this.k.sendEmptyMessage(1);
    }

    public void setAnimationText(List<String> list) {
        this.hc = list;
    }

    public void hc() {
        List<String> list = this.hc;
        if (list == null || list.size() <= 0) {
            return;
        }
        int i = this.b;
        this.b = i + 1;
        this.mk = i;
        setText(this.hc.get(i));
        if (this.b > this.hc.size() - 1) {
            this.b = 0;
        }
    }

    public void setTextColor(int i) {
        this.gb = i;
    }

    public void setTextSize(float f) {
        this.tt = f;
    }

    public void setMaxLines(int i) {
        this.tc = i;
    }

    @Override // android.widget.ViewSwitcher.ViewFactory
    public View makeView() {
        TextView textView = new TextView(getContext());
        this.an = textView;
        textView.setTextColor(this.gb);
        this.an.setTextSize(this.tt);
        this.an.setMaxLines(this.tc);
        if (Build.VERSION.SDK_INT >= 17) {
            this.an.setTextAlignment(this.uo);
        }
        return this.an;
    }

    @Override // com.bytedance.sdk.component.utils.zw.d
    public void d(Message message) {
        if (message.what != 1) {
            return;
        }
        hc();
        this.k.sendEmptyMessageDelayed(1, this.h);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        try {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(mk.hc(this.hc.get(this.mk), this.tt, false)[0], 1073741824), i);
        } catch (Exception unused) {
            super.onMeasure(i, i2);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.k.removeMessages(1);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.k.sendEmptyMessageDelayed(1, this.h);
    }
}
