package com.qq.e.comm.plugin;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.fragment.app.FragmentTransaction;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class sp extends Dialog implements View.OnClickListener {
    private static final String m = "sp";
    static final String n = m10.a("56uL5Y2z5LiL6L2977yIJWRzIOWQjuiHquWKqOS4i-i9ve-8iQ==");
    private static volatile long o = 0;
    private final Context a;
    private final h4 b;
    private final rs c;
    private final int d;
    private final int e;
    private final int f;
    private final int g;
    private final boolean h;
    private i0 i;
    private boolean j;

    @Override // android.app.Dialog
    public void show() {
        if (o == 0 || System.currentTimeMillis() - o >= 1000) {
            o = System.currentTimeMillis();
            super.show();
            rs rsVar = this.c;
            if (rsVar != null) {
                rsVar.a(true);
            }
        }
    }

    public sp(Context context, h4 h4Var, rs rsVar, int i) {
        Window window;
        super(context, gw.b(context, "DialogFullScreen"));
        this.j = false;
        this.a = context;
        this.b = h4Var;
        this.c = rsVar;
        this.d = i;
        int i2 = context.getResources().getConfiguration().orientation;
        this.e = i2;
        if (h10.e(i)) {
            this.f = 2;
        } else {
            int iB = e3.b(h4Var);
            if (iB == 3 && (h10.d(i) || r1.d().c().p() != zr.WIFI)) {
                iB = 2;
            }
            this.f = iB;
        }
        this.g = e3.a(h4Var);
        this.h = this.f == 3;
        v20 v20VarA = j3.a(h4Var.o().e());
        int i3 = this.f;
        if (i3 == 1) {
            v20VarA.g = 6;
        } else if (i3 == 2) {
            v20VarA.g = 7;
        } else if (i3 == 3) {
            v20VarA.g = 8;
        }
        requestWindowFeature(1);
        if (i2 == 2 && Build.VERSION.SDK_INT > 19 && (window = getWindow()) != null) {
            window.getDecorView().setSystemUiVisibility(FragmentTransaction.TRANSIT_FRAGMENT_MATCH_ACTIVITY_OPEN);
        }
        setCanceledOnTouchOutside(true);
        b();
        setOnDismissListener(new a(rsVar));
    }

    /* compiled from: A */
    class a implements DialogInterface.OnDismissListener {
        final /* synthetic */ rs a;

        a(rs rsVar) {
            this.a = rsVar;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            String unused = sp.m;
            sp.this.i.f();
            rs rsVar = this.a;
            if (rsVar != null) {
                rsVar.b(sp.this.j);
            }
            long unused2 = sp.o = 0L;
        }
    }

    private void b() {
        if (this.f == 1) {
            this.i = new n50(this.a, this, this.b.p());
        } else {
            this.i = new wq(this.a, this, this.b, this.h, this.g, this.d);
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setStroke(0, 0);
        float fA = yu.a(this.a, 12);
        float[] fArr = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        int i = this.e;
        if (i == 1) {
            fArr = new float[]{fA, fA, fA, fA, 0.0f, 0.0f, 0.0f, 0.0f};
        } else if (i == 2) {
            fArr = new float[]{fA, fA, 0.0f, 0.0f, 0.0f, 0.0f, fA, fA};
        }
        gradientDrawable.setCornerRadii(fArr);
        gradientDrawable.setColor(-1);
        this.i.setBackgroundDrawable(gradientDrawable);
        if (h10.d(this.d)) {
            this.i.e("立即安装");
        } else if (h10.e(this.d)) {
            this.i.e(String.format("下载中(%d%%)", Integer.valueOf(com.qq.e.comm.plugin.apkmanager.l.e().a(this.b.o().e()))));
        } else {
            this.i.e("立即下载");
        }
        this.i.a(this);
        setContentView(this.i, new FrameLayout.LayoutParams(-1, -1));
    }

    @Override // android.app.Dialog
    protected void onStart() {
        int i;
        int iA = yu.a(this.a);
        Window window = getWindow();
        window.getDecorView().setPadding(0, 0, 0, 0);
        WindowManager.LayoutParams attributes = window.getAttributes();
        int i2 = this.e;
        if (i2 == 1) {
            attributes.width = -1;
            if (this.f == 1) {
                double d = iA;
                Double.isNaN(d);
                i = (int) (d * 0.6d);
            } else {
                i = -2;
            }
            attributes.height = i;
            attributes.gravity = 80;
            attributes.windowAnimations = gw.b(this.a, "DialogAnimationUp");
        } else if (i2 == 2) {
            attributes.width = yu.a(this.a, 375);
            attributes.height = -1;
            attributes.gravity = 5;
            attributes.windowAnimations = gw.b(this.a, "DialogAnimationRight");
        }
        attributes.dimAmount = 0.5f;
        window.setAttributes(attributes);
        setOnShowListener(new b());
        this.i.e();
    }

    /* compiled from: A */
    class b implements DialogInterface.OnShowListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnShowListener
        public void onShow(DialogInterface dialogInterface) {
            try {
                sp.this.getWindow().setWindowAnimations(0);
            } catch (Throwable unused) {
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.i.a()) {
            rs rsVar = this.c;
            if (rsVar != null) {
                rsVar.onCancel();
                this.j = true;
                c();
                return;
            }
            return;
        }
        if (view == this.i.b()) {
            rs rsVar2 = this.c;
            if (rsVar2 != null) {
                boolean zA = rsVar2.a((JSONObject) null);
                this.j = true;
                if (zA) {
                    c();
                    return;
                }
                return;
            }
            return;
        }
        this.i.a(view);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        super.cancel();
        this.j = true;
        rs rsVar = this.c;
        if (rsVar != null) {
            rsVar.onCancel();
        }
    }

    private void c() {
        try {
            Activity activityA = c1.a(this.a);
            if (activityA == null || c1.a(activityA)) {
                dismiss();
            }
        } catch (Throwable unused) {
        }
    }
}
