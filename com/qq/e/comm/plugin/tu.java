package com.qq.e.comm.plugin;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.TextView;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class tu extends FrameLayout implements m {
    public Cdo a;
    public TextView b;
    private h4 c;
    private int d;
    private String e;
    private String f;
    private String g;
    private String h;
    private String i;
    private String j;
    private m m;
    private int n;
    private int o;

    public tu(Context context, TextView textView) {
        super(context);
        this.e = "打开";
        this.f = "下载";
        this.g = "下载中";
        this.h = "继续下载";
        this.i = "安装";
        this.j = "打开";
        this.b = textView;
    }

    protected void a(b bVar) {
        if (bVar == null) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        Cdo cdo = this.a;
        if (cdo == null) {
            Cdo cdo2 = new Cdo(getContext());
            this.a = cdo2;
            cdo2.setLayoutParams(layoutParams);
            addView(this.a);
        } else {
            cdo.setLayoutParams(layoutParams);
        }
        if (bVar.c > 0) {
            layoutParams = new FrameLayout.LayoutParams(bVar.c, -1);
            layoutParams.gravity = 17;
        }
        if (this.b == null) {
            this.b = new TextView(getContext());
        }
        if (this.b.getParent() == null) {
            this.b.setLayoutParams(layoutParams);
            addView(this.b);
        }
        this.c = bVar.a;
        String strB = b();
        if (!TextUtils.isEmpty(strB)) {
            com.qq.e.comm.plugin.apkmanager.l.e().a(strB, this);
        }
        this.d = bVar.h;
        this.m = bVar.m;
        String[] strArr = bVar.l;
        if (strArr != null && strArr.length == 5) {
            String str = strArr[0];
            this.e = str;
            this.f = str;
            this.g = strArr[1];
            this.h = strArr[2];
            this.i = strArr[3];
            this.j = strArr[4];
        }
        Object[] objArr = bVar.i;
        if (objArr != null) {
            this.a.a(objArr);
        } else {
            Integer num = bVar.j;
            if (num != null) {
                this.a.b(num.intValue());
            }
        }
        Integer num2 = bVar.k;
        if (num2 != null) {
            this.a.setBackgroundColor(num2.intValue());
        }
        this.a.a(bVar.b);
        this.a.c(100);
        Cdo cdo3 = this.a;
        int i = bVar.n;
        this.o = i;
        cdo3.a(i);
        this.b.setBackgroundDrawable(null);
        this.b.setGravity(17);
        this.b.setTextColor(bVar.g);
        int i2 = bVar.e;
        if (i2 > 0) {
            this.b.setTextSize(0, i2);
        } else {
            this.b.setTextSize(2, bVar.d);
        }
        Typeface typeface = bVar.f;
        if (typeface != null) {
            this.b.setTypeface(typeface);
        }
        h4 h4Var = this.c;
        if (h4Var != null && h4Var.k1()) {
            a(com.qq.e.comm.plugin.apkmanager.l.e().b(strB), -1);
        } else {
            this.b.setText(this.e);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    /* compiled from: A */
    class a implements Runnable {
        final /* synthetic */ int a;
        final /* synthetic */ int b;
        final /* synthetic */ String c;
        final /* synthetic */ long d;

        a(int i, int i2, String str, long j) {
            this.a = i;
            this.b = i2;
            this.c = str;
            this.d = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            tu.this.a(this.a, this.b);
            if (tu.this.m != null) {
                tu.this.m.a(this.c, this.a, this.b, this.d);
            }
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        this.a.b(i);
    }

    private String b() {
        h4 h4Var = this.c;
        return (h4Var == null || !h4Var.k1() || this.c.o() == null) ? "" : this.c.o().e();
    }

    /* compiled from: A */
    public static class b {
        h4 a;
        int b;
        int c;
        int e;
        Typeface f;
        int g;
        int h;
        Object[] i;
        String[] l;
        m m;
        int d = 12;
        Integer j = null;
        Integer k = null;
        int n = 100;

        public b a(h4 h4Var) {
            this.a = h4Var;
            return this;
        }

        public b f(int i) {
            this.b = i;
            return this;
        }

        public b h(int i) {
            this.c = i;
            return this;
        }

        public b g(int i) {
            this.e = i;
            return this;
        }

        public b c(int i) {
            this.g = i;
            return this;
        }

        public b e(int i) {
            this.h = i;
            return this;
        }

        public b d(int i) {
            this.j = Integer.valueOf(i);
            return this;
        }

        public b b(int i) {
            this.n = i;
            return this;
        }

        public b a(int i) {
            this.k = Integer.valueOf(i);
            return this;
        }

        public b a(Object[] objArr) {
            this.i = objArr;
            return this;
        }

        public b a(String[] strArr) {
            if (strArr != null && strArr.length == 5) {
                this.l = strArr;
            }
            return this;
        }
    }

    @Override // com.qq.e.comm.plugin.m
    public void a(String str, int i, int i2, long j) {
        String strB = b();
        if (TextUtils.isEmpty(strB) || TextUtils.isEmpty(str) || !strB.equals(str)) {
            return;
        }
        xo.a((Runnable) new a(i, i2, str, j));
    }

    public void a(int i) {
        if (i == this.o) {
            return;
        }
        this.o = i;
        Cdo cdo = this.a;
        if (cdo != null) {
            cdo.a(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0072  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(int r3, int r4) {
        /*
            r2 = this;
            if (r3 == 0) goto L72
            r0 = 1
            if (r3 == r0) goto L5f
            r0 = 4
            r1 = 100
            if (r3 == r0) goto L45
            r0 = 8
            if (r3 == r0) goto L32
            r0 = 16
            if (r3 == r0) goto L72
            r0 = 32
            if (r3 == r0) goto L1f
            r0 = 64
            if (r3 == r0) goto L72
            r0 = 128(0x80, float:1.8E-43)
            if (r3 == r0) goto L45
            goto L84
        L1f:
            r2.o = r1
            com.qq.e.comm.plugin.do r0 = r2.a
            if (r0 == 0) goto L28
            r0.a(r4)
        L28:
            android.widget.TextView r4 = r2.b
            if (r4 == 0) goto L84
            java.lang.String r0 = r2.h
            r4.setText(r0)
            goto L84
        L32:
            com.qq.e.comm.plugin.do r4 = r2.a
            if (r4 == 0) goto L3b
            int r0 = r2.o
            r4.a(r0)
        L3b:
            android.widget.TextView r4 = r2.b
            if (r4 == 0) goto L84
            java.lang.String r0 = r2.i
            r4.setText(r0)
            goto L84
        L45:
            r2.o = r1
            com.qq.e.comm.plugin.do r0 = r2.a
            if (r0 == 0) goto L4e
            r0.a(r4)
        L4e:
            android.widget.TextView r4 = r2.b
            if (r4 == 0) goto L84
            java.lang.String r0 = r2.g
            r4.setText(r0)
            android.widget.TextView r4 = r2.b
            int r0 = r2.d
            r4.setTextColor(r0)
            goto L84
        L5f:
            com.qq.e.comm.plugin.do r4 = r2.a
            if (r4 == 0) goto L68
            int r0 = r2.o
            r4.a(r0)
        L68:
            android.widget.TextView r4 = r2.b
            if (r4 == 0) goto L84
            java.lang.String r0 = r2.j
            r4.setText(r0)
            goto L84
        L72:
            com.qq.e.comm.plugin.do r4 = r2.a
            if (r4 == 0) goto L7b
            int r0 = r2.o
            r4.a(r0)
        L7b:
            android.widget.TextView r4 = r2.b
            if (r4 == 0) goto L84
            java.lang.String r0 = r2.f
            r4.setText(r0)
        L84:
            r2.n = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.plugin.tu.a(int, int):void");
    }

    public void a() {
        com.qq.e.comm.plugin.apkmanager.l.e().b(b(), this);
    }
}
