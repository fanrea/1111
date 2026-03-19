package com.baidu.mobads.container.components;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.baidu.mobads.container.adrequest.t;
import com.baidu.mobads.container.util.bv;
import java.lang.reflect.InvocationTargetException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class e extends RelativeLayout {
    private ImageView a;
    private Context b;
    private int c;

    public e(t tVar, int i, int i2) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Bitmap bitmapB;
        super(tVar.v().getContext());
        this.c = 10;
        this.c = i2;
        this.b = tVar.v().getContext();
        setGravity(17);
        this.a = new ImageView(this.b);
        if (i == 2) {
            bitmapB = com.component.b.a.a().b("ic_yellow_dl_black_bg");
        } else {
            bitmapB = com.component.b.a.a().b("ic_yellow_lp_black_bg");
        }
        try {
            ImageView.class.getMethod("setBackground", BitmapDrawable.class).invoke(this.a, new BitmapDrawable(this.b.getResources(), bitmapB));
        } catch (Exception e) {
            this.a.setBackgroundDrawable(new BitmapDrawable(this.b.getResources(), bitmapB));
        }
        this.a.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        addView(this.a);
        a(tVar);
    }

    private void a(t tVar) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(bv.b((Context) tVar.u(), (int) Math.round(77.0d)), bv.b((Context) tVar.u(), (int) Math.round(33.0d)));
        layoutParams.addRule(11, this.c);
        layoutParams.addRule(12, this.c);
        layoutParams.rightMargin = bv.b((Context) tVar.u(), 30);
        layoutParams.bottomMargin = bv.b((Context) tVar.u(), 10);
        setLayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }
}
