package com.qq.e.comm.plugin;

import android.text.TextUtils;
import com.qq.e.comm.plugin.gb;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class qn {
    private static volatile String a;

    private static pn a(f5 f5Var, boolean z, int i) throws JSONException {
        pn pnVar = new pn(f5Var);
        pnVar.f(i);
        if (z) {
            pnVar.g(1);
        } else {
            pnVar.g(2);
        }
        return pnVar;
    }

    /* compiled from: A */
    class a extends ez {
        @Override // com.qq.e.comm.plugin.ez, com.qq.e.comm.plugin.bb
        public void a(db dbVar) {
        }

        a() {
        }

        @Override // com.qq.e.comm.plugin.bb
        public void a(File file, long j) {
            if (file.exists()) {
                String unused = qn.a = gu.d(file);
            }
        }
    }

    public static void a(int i, boolean z, int i2, f5 f5Var, long j) throws JSONException {
        ja jaVarA;
        pn pnVarA = a(f5Var, z, i2);
        if (j > 0) {
            long jCurrentTimeMillis = System.currentTimeMillis() - j;
            pnVarA.a(jCurrentTimeMillis);
            jaVarA = new ja().a("du", Long.valueOf(jCurrentTimeMillis));
        } else {
            jaVarA = null;
        }
        b10.a(i, pnVarA, Integer.valueOf(i2), Integer.valueOf(z ? 1 : 2), jaVarA);
    }

    public static void a(int i, boolean z, int i2, f5 f5Var, JSONObject jSONObject) throws JSONException {
        pn pnVarA = a(f5Var, z, i2);
        pnVarA.b(jSONObject);
        b10.a(i, pnVarA, Integer.valueOf(i2));
    }

    public static void a(e2 e2Var, f5 f5Var) throws JSONException {
        int i;
        if (e2Var.h()) {
            i = 2;
        } else {
            i = e2Var.k() ? 1 : 0;
        }
        if (i != 0) {
            pn pnVar = new pn(f5Var);
            pnVar.e(i);
            b10.b(4003053, pnVar, Integer.valueOf(i));
        }
    }

    public static void a(int i, boolean z, int i2, f5 f5Var, long j, int i3) throws JSONException {
        pn pnVarA = a(f5Var, z, i2);
        pnVarA.d(i3);
        if (j > 0) {
            pnVarA.a(System.currentTimeMillis() - j);
        }
        b10.a(i, pnVarA, Integer.valueOf(i2), Integer.valueOf(i3), null);
    }

    public static void a(h4 h4Var) {
        if (TextUtils.isEmpty(a) && xc.a("lpcije", h4Var.y0(), 0, h4Var.x0()) != 0) {
            String strA = r1.d().f().a("lpciju", h4Var.y0(), "https://i.gtimg.cn/ams-web/page-performance/page-performance.min.js?v=1");
            if (TextUtils.isEmpty(strA)) {
                return;
            }
            File fileL = gu.l();
            String strD = gu.d(strA);
            File file = new File(fileL, strD);
            if (file.exists()) {
                a = gu.d(file);
            } else {
                fb.a().a(new gb.b().d(strA).a(fileL).a(strD).d(false).b(false).a(), new a());
            }
        }
    }

    public static String a() {
        return a;
    }
}
