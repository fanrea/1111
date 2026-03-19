package com.qq.e.comm.plugin;

import android.content.Context;
import android.graphics.Movie;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import org.json.JSONException;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class r40 extends xh implements View.OnClickListener {
    private final View h;
    private final String i;
    private View.OnClickListener j;

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        r5 r5VarD = u2.a().d(this.h);
        if (r5VarD != null) {
            r5VarD.a(motionEvent, true);
        }
        return super.onTouchEvent(motionEvent);
    }

    public r40(Context context, View view, String str) {
        super(context);
        this.h = view;
        this.i = str;
        setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        setOnClickListener(this);
        setVisibility(8);
    }

    public void b(int i, int i2, ViewGroup viewGroup) {
        if (viewGroup == null || getParent() != null) {
            return;
        }
        a(i2, i, viewGroup);
    }

    public r40(Context context, String str) {
        this(context, null, str);
    }

    private void a(int i, int i2, ViewGroup viewGroup) throws JSONException {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(yu.a(getContext(), 112), yu.a(getContext(), 90));
        layoutParams.topMargin = yu.a(getContext(), i - 90);
        layoutParams.leftMargin = yu.a(getContext(), i2);
        viewGroup.addView(this, layoutParams);
        mm.a().a(this.i, this);
        setVisibility(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View.OnClickListener onClickListener = this.j;
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
    }

    @Override // com.qq.e.comm.plugin.xh, com.qq.e.comm.plugin.nk
    public void a(Movie movie) {
        this.a = movie;
        if (movie != null) {
            this.c = yu.a(getContext(), 112);
            this.b = yu.a(getContext(), 90);
            this.f = this.a.width();
            this.g = this.a.height();
            invalidate();
        }
    }

    public void a(View.OnClickListener onClickListener) {
        this.j = onClickListener;
    }
}
