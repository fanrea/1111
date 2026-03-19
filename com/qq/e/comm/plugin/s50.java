package com.qq.e.comm.plugin;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import androidx.core.location.LocationRequestCompat;
import com.qq.e.comm.plugin.a30;
import com.qq.e.comm.plugin.mf;
import java.io.InputStream;
import org.json.JSONException;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class s50 {
    private boolean a = true;
    private int b = 0;
    private h4 c;
    private f5 d;

    s50() {
    }

    public boolean b(String str) {
        Uri uri = Uri.parse(str);
        if (TextUtils.isEmpty(str) || a30.c(uri)) {
            return false;
        }
        if (!a30.b(uri) && this.a) {
            boolean zF = a30.f(str);
            try {
                b10.a(9120004, this.d, Integer.valueOf(zF ? 1 : 0), Integer.valueOf(this.b), null);
                if (!c(str)) {
                    Intent intent = new Intent("android.intent.action.VIEW", uri);
                    intent.addFlags(268435456);
                    if (!zF) {
                        ct.a(intent, null, str, true);
                    }
                    r1.d().a().startActivity(intent);
                }
                b10.a(9120005, this.d, Integer.valueOf(zF ? 1 : 0), Integer.valueOf(this.b), null);
            } catch (Exception e) {
                a(e, zF ? 1 : 0, this.b);
            }
        }
        return true;
    }

    private boolean c(String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String strA = a(str);
        if (TextUtils.isEmpty(strA)) {
            return false;
        }
        Context contextA = r1.d().a();
        h4 h4Var = this.c;
        bp bpVarM0 = h4Var == null ? null : h4Var.m0();
        Intent intentA = ap.a(contextA, bpVarM0, strA, LocationRequestCompat.PASSIVE_INTERVAL);
        int i = bpVarM0 == null ? 1 : 2;
        b10.a(9120006, this.d, Integer.valueOf(i), 0, null);
        if (intentA == null) {
            b10.a(9120006, this.d, Integer.valueOf(i), 1, null);
            return false;
        }
        boolean zA = ap.a(bpVarM0);
        if (zA) {
            try {
                z50.a().a(strA, new mf.i(this.d));
            } catch (Exception e) {
                ja jaVar = new ja();
                jaVar.a("msg", e.getMessage());
                jaVar.a("url", str);
                b10.a(9120006, this.d, Integer.valueOf(i), 2, jaVar);
                if (zA) {
                    z50.a().a(strA);
                }
                return false;
            }
        }
        contextA.startActivity(intentA);
        return true;
    }

    public void a(jm jmVar, String str, boolean z) {
        if (jmVar == null || jmVar.c() == null) {
            return;
        }
        jmVar.c().e();
    }

    public Pair<? extends InputStream, a30.a> a(boolean z, Uri uri) {
        if (!z) {
            return null;
        }
        q50 q50VarE = q50.e();
        if (!q50VarE.b() || q50VarE.b(uri)) {
            return null;
        }
        return q50VarE.a(uri);
    }

    String a(String str) {
        Uri uri;
        return (str.contains("market://details?id=") && (uri = Uri.parse(str)) != null) ? uri.getQueryParameter("id") : "";
    }

    public void a(h4 h4Var) {
        this.c = h4Var;
        this.d = f5.a(h4Var);
    }

    public void a(boolean z) {
        this.a = z;
    }

    public void a(int i) {
        this.b = i;
    }

    private void a(Exception exc, int i, int i2) throws JSONException {
        ja jaVar = new ja();
        if (exc != null) {
            jaVar.a("ot", exc.toString());
        }
        b10.a(9120003, this.d, Integer.valueOf(i), Integer.valueOf(i2), jaVar);
    }
}
