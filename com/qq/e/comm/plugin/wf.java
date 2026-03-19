package com.qq.e.comm.plugin;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.qq.e.comm.plugin.w40;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class wf extends u4<b> {
    private static final int H = Color.parseColor("#3185FC");
    private cr G;

    /* compiled from: A */
    public static class a implements w40.e {
        @Override // com.qq.e.comm.plugin.w40.e
        public w40 a() {
            return new wf();
        }
    }

    wf() {
    }

    private void a(h4 h4Var, String str) {
        if (!h4Var.k1() || h4Var.o() == null || this.A == 0) {
            return;
        }
        l3 l3VarO = h4Var.o();
        b bVar = (b) this.A;
        String strE = l3VarO.e();
        bVar.e = strE;
        if (TextUtils.isEmpty(strE)) {
            return;
        }
        ((b) this.A).d = h4Var.q();
        ((b) this.A).d.a(str);
        ((b) this.A).a(l3VarO.j(), com.qq.e.comm.plugin.apkmanager.l.e().a(((b) this.A).e));
        com.qq.e.comm.plugin.apkmanager.l lVarE = com.qq.e.comm.plugin.apkmanager.l.e();
        V v = this.A;
        lVarE.a(((b) v).e, (m) v);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.qq.e.comm.plugin.w40
    protected void M() {
        super.M();
        lb lbVar = this.t;
        if (lbVar == null || !lbVar.a() || A() == 0) {
            return;
        }
        ((b) A()).setWillNotDraw(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.w40
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public b b(e8 e8Var) {
        cr crVar = new cr();
        this.G = crVar;
        crVar.a(D());
        this.G.I();
        return new b(e8Var.d(), this.G.A());
    }

    @Override // com.qq.e.comm.plugin.w40
    public void clear() {
        super.clear();
        if (this.A != 0) {
            com.qq.e.comm.plugin.apkmanager.l lVarE = com.qq.e.comm.plugin.apkmanager.l.e();
            V v = this.A;
            lVarE.b(((b) v).e, (m) v);
        }
        this.G = null;
    }

    /* compiled from: A */
    static class b extends LinearLayout implements dl<wf>, m {
        final ImageView a;
        final TextView b;
        private wf c;
        q3 d;
        String e;

        public b(Context context, TextView textView) {
            super(context);
            setGravity(17);
            ImageView imageView = new ImageView(context);
            this.a = imageView;
            int iA = yu.a(context, 16);
            addView(imageView, iA, iA);
            this.b = textView;
            textView.setTextSize(1, 13.0f);
            textView.setTextColor(wf.H);
            ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
            marginLayoutParams.leftMargin = yu.a(context, 4);
            addView(textView, marginLayoutParams);
        }

        @Override // android.widget.LinearLayout, android.view.View
        protected void onDraw(Canvas canvas) {
            int width;
            int height;
            xj xjVarS = this.c.s();
            if (xjVarS != null) {
                width = getWidth();
                height = getHeight();
                xjVarS.a(canvas, width, height);
            } else {
                width = 0;
                height = 0;
            }
            super.onDraw(canvas);
            if (xjVarS != null) {
                xjVarS.b(canvas, width, height);
            }
        }

        @Override // android.view.View
        protected void onVisibilityChanged(View view, int i) {
            wf wfVar = this.c;
            if (wfVar != null) {
                wfVar.a(view, i);
            }
        }

        /* compiled from: A */
        class a implements Runnable {
            final /* synthetic */ int a;
            final /* synthetic */ int b;

            a(int i, int i2) {
                this.a = i;
                this.b = i2;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.a(this.a, this.b);
            }
        }

        @Override // com.qq.e.comm.plugin.m
        public void a(String str, int i, int i2, long j) {
            String str2 = this.e;
            if (str2 == null || str2.equals(str)) {
                xo.d(new a(i, i2));
            }
        }

        @Override // com.qq.e.comm.plugin.dl
        public void a(wf wfVar) {
            this.c = wfVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Removed duplicated region for block: B:23:0x002d  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x0057  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void a(int r3, int r4) {
            /*
                r2 = this;
                com.qq.e.comm.plugin.q3 r0 = r2.d
                if (r0 != 0) goto L5
                return
            L5:
                if (r3 == 0) goto L57
                r1 = 1
                if (r3 == r1) goto L52
                r1 = 4
                if (r3 == r1) goto L2d
                r1 = 8
                if (r3 == r1) goto L28
                r1 = 16
                if (r3 == r1) goto L57
                r1 = 32
                if (r3 == r1) goto L23
                r1 = 64
                if (r3 == r1) goto L57
                r0 = 128(0x80, float:1.8E-43)
                if (r3 == r0) goto L2d
                r3 = 0
                goto L5b
            L23:
                java.lang.String r3 = r0.b()
                goto L5b
            L28:
                java.lang.String r3 = r0.a()
                goto L5b
            L2d:
                r3 = 100
                if (r4 <= r3) goto L34
                r4 = 100
                goto L37
            L34:
                if (r4 >= 0) goto L37
                r4 = 0
            L37:
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                com.qq.e.comm.plugin.q3 r0 = r2.d
                java.lang.String r0 = r0.c()
                r3.append(r0)
                r3.append(r4)
                java.lang.String r4 = "%"
                r3.append(r4)
                java.lang.String r3 = r3.toString()
                goto L5b
            L52:
                java.lang.String r3 = r0.e()
                goto L5b
            L57:
                java.lang.String r3 = r0.d()
            L5b:
                boolean r4 = android.text.TextUtils.isEmpty(r3)
                if (r4 != 0) goto L66
                android.widget.TextView r4 = r2.b
                r4.setText(r3)
            L66:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.plugin.wf.b.a(int, int):void");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:61:0x00f9 A[PHI: r2
  0x00f9: PHI (r2v2 java.lang.String) = (r2v1 java.lang.String), (r2v0 java.lang.String) binds: [B:60:0x00f7, B:54:0x00e2] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private android.util.Pair<java.lang.String, java.lang.String> a(com.qq.e.comm.plugin.h4 r6) {
        /*
            Method dump skipped, instructions count: 277
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.plugin.wf.a(com.qq.e.comm.plugin.h4):android.util.Pair");
    }

    @Override // com.qq.e.comm.plugin.w40
    protected boolean a(String str, cm cmVar) {
        str.hashCode();
        if (str.equals("adModel")) {
            h4 h4Var = (h4) cmVar.e(new JSONObject[0]);
            Pair<String, String> pairA = a(h4Var);
            ((b) this.A).a.setImageBitmap(gw.a((String) pairA.first));
            ((b) this.A).b.setText((CharSequence) pairA.second);
            a(h4Var, (String) pairA.second);
            return true;
        }
        if (!str.equals("iconSize")) {
            return super.a(str, cmVar) || this.G.a(str, cmVar);
        }
        ViewGroup.LayoutParams layoutParams = ((b) this.A).a.getLayoutParams();
        layoutParams.width = cmVar.a(new JSONObject[0]);
        layoutParams.height = cmVar.a(new JSONObject[0]);
        ((b) this.A).a.setLayoutParams(layoutParams);
        if (layoutParams.width <= 0) {
            ViewGroup.LayoutParams layoutParams2 = ((b) this.A).b.getLayoutParams();
            if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin = 0;
            }
        }
        return true;
    }
}
