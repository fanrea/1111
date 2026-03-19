package com.baidu.mobads.container.util.animation;

import android.content.Context;
import android.widget.FrameLayout;
import android.widget.ImageView;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class aj extends FrameLayout {
    private float a;
    private final ImageView b;
    private final ImageView c;
    private float d;

    public aj(Context context) {
        super(context);
        this.a = 0.0f;
        this.d = 1.0f;
        setClipChildren(false);
        this.b = new ImageView(context);
        com.component.b.a.a().a(this.b, "ic_guide_circle");
        addView(this.b, new FrameLayout.LayoutParams(-1, -1));
        this.c = new ImageView(context);
        com.component.b.a.a().a(this.c, "ic_guide_finger");
        addView(this.c, new FrameLayout.LayoutParams(-1, -1));
    }

    public void a(float f) {
        this.d = f;
    }

    public void b(float f) {
        this.a = f * this.d;
        if (!Float.isNaN(this.a)) {
            this.b.setScaleX((this.a * 0.25f) + 1.0f);
            ImageView imageView = this.b;
            double width = this.a * getWidth();
            Double.isNaN(width);
            imageView.setX((float) (width * 0.025d));
            this.b.setScaleY((this.a * 0.25f) + 1.0f);
            ImageView imageView2 = this.b;
            double height = this.a * getHeight();
            Double.isNaN(height);
            imageView2.setY((float) (height * 0.025d));
            ImageView imageView3 = this.c;
            double width2 = (-this.a) * getWidth();
            Double.isNaN(width2);
            imageView3.setX((float) (width2 * 0.025d));
            ImageView imageView4 = this.c;
            double height2 = (-this.a) * getHeight();
            Double.isNaN(height2);
            imageView4.setY((float) (height2 * 0.025d));
        }
    }
}
