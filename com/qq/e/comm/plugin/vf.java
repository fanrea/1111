package com.qq.e.comm.plugin;

import android.content.Context;
import android.graphics.Canvas;
import android.util.Pair;
import android.view.View;
import com.qq.e.comm.plugin.w40;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class vf extends u4<b> {
    public static final String G = m10.a("R0RURExBdXRvQ2xpY2tWaWV3");

    /* compiled from: A */
    public static class a implements w40.e {
        @Override // com.qq.e.comm.plugin.w40.e
        public w40 a() {
            if (xc.a("cacit", "", 0) == 1) {
                return null;
            }
            return new vf();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.comm.plugin.w40
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public b b(e8 e8Var) {
        return new b(e8Var.d());
    }

    @Override // com.qq.e.comm.plugin.w40
    protected boolean a(String str, cm cmVar) {
        str.hashCode();
        if (!str.equals("adModel")) {
            return super.a(str, cmVar);
        }
        ((b) this.A).a((h4) cmVar.e(new JSONObject[0]));
        return true;
    }

    /* compiled from: A */
    static class b extends a4 implements dl<vf> {
        protected w40 e;

        public b(Context context) {
            super(context);
        }

        @Override // com.qq.e.comm.plugin.dl
        public void a(vf vfVar) {
            this.e = vfVar;
        }

        @Override // android.view.View
        public void setBackgroundColor(int i) {
            this.e.f(i);
        }

        @Override // android.widget.LinearLayout, android.view.View
        protected void onMeasure(int i, int i2) {
            v40 v40VarV = this.e.v();
            if (v40VarV == null) {
                super.onMeasure(i, i2);
                return;
            }
            Pair<Integer, Integer> pairB = v40VarV.b(i, i2);
            super.onMeasure(((Integer) pairB.first).intValue(), ((Integer) pairB.second).intValue());
            Pair<Integer, Integer> pairA = v40VarV.a(i, i2);
            if (pairA != null) {
                super.onMeasure(((Integer) pairA.first).intValue(), ((Integer) pairA.second).intValue());
            }
        }

        @Override // android.view.View
        public void draw(Canvas canvas) {
            int width;
            int height;
            w40 w40Var = this.e;
            xj xjVarS = w40Var == null ? null : w40Var.s();
            if (xjVarS != null) {
                width = getWidth();
                height = getHeight();
                xjVarS.a(canvas, width, height);
            } else {
                width = 0;
                height = 0;
            }
            super.draw(canvas);
            if (xjVarS != null) {
                xjVarS.b(canvas, width, height);
            }
        }

        @Override // android.view.View
        protected void onVisibilityChanged(View view, int i) {
            w40 w40Var = this.e;
            if (w40Var != null) {
                w40Var.a(view, i);
            }
        }
    }
}
