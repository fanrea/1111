package com.baidu.mobads.container.e;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class a {
    public static final int a = 0;
    public static final int b = 1;
    d c;
    Context d;
    int e;
    private RelativeLayout f;
    private InterfaceC0126a g;

    /* renamed from: com.baidu.mobads.container.e.a$a, reason: collision with other inner class name */
    public interface InterfaceC0126a {
        void a(MotionEvent motionEvent);
    }

    public a(Context context) {
        this(context, 0);
    }

    public a(Context context, int i) {
        this.e = i;
        this.d = context;
        e();
    }

    private void e() {
        Window window;
        try {
            this.c = new d(this.d);
            this.c.requestWindowFeature(1);
            this.c.getWindow().setDimAmount(0.0f);
            window = this.c.getWindow();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (window != null) {
            window.getDecorView().setPadding(0, 0, 0, 0);
            this.f = new b(this, this.d);
            switch (this.e) {
                case 0:
                    try {
                        WindowManager.LayoutParams attributes = window.getAttributes();
                        this.d.getResources().getDisplayMetrics();
                        attributes.width = -1;
                        attributes.gravity = 80;
                        attributes.height = -1;
                        this.f.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
                        this.c.getWindow().setBackgroundDrawableResource(R.color.transparent);
                        this.c.getWindow().getDecorView().setSystemUiVisibility(0);
                        this.c.getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new c(this));
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    this.c.setContentView(this.f);
                    return;
                case 1:
                    WindowManager.LayoutParams attributes2 = window.getAttributes();
                    DisplayMetrics displayMetrics = this.d.getResources().getDisplayMetrics();
                    attributes2.width = displayMetrics.widthPixels;
                    attributes2.gravity = 80;
                    double d = displayMetrics.heightPixels;
                    Double.isNaN(d);
                    attributes2.height = (int) (d * 0.5d);
                    window.setAttributes(attributes2);
                    return;
                default:
                    return;
            }
            e.printStackTrace();
        }
    }

    public void a(InterfaceC0126a interfaceC0126a) {
        this.g = interfaceC0126a;
    }

    public RelativeLayout a() {
        return this.f;
    }

    public void b() {
        if (this.c != null) {
            this.c.show();
        }
    }

    public void c() {
        if (this.c != null) {
            this.c.dismiss();
        }
    }

    public Dialog d() {
        return this.c;
    }
}
