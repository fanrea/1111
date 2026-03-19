package com.qq.e.comm.plugin;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.Pair;
import com.ss.texturerender.TextureRenderKeys;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class m8 {
    private final jn a;

    public m8() {
        this.a = new jn();
    }

    public m8(String str) {
        this.a = new jn(str);
    }

    private m8 b(h4 h4Var) throws JSONException {
        String strA = vp.a(h4Var);
        if (TextUtils.isEmpty(strA)) {
            a(false);
        } else {
            a(true);
            a("miitInfo", strA);
        }
        if (!h4Var.k1()) {
            return this;
        }
        if (h4Var.o() != null) {
            Pair<String, String> pairA = m10.a(h4Var.o().f());
            a("pkgSize", (String) pairA.first);
            a("pkgSizeUnit", (String) pairA.second);
        }
        JSONArray jSONArray = new JSONArray();
        List<String> listI0 = h4Var.I0();
        if (listI0.size() != 0) {
            Iterator<String> it = listI0.iterator();
            while (it.hasNext()) {
                jSONArray.put(new jn().a("screenshot_url", it.next()).a());
            }
        } else {
            jSONArray.put(new jn().a("screenshot_url", h4Var.c0()).a());
        }
        a("screenshots", jSONArray);
        return this;
    }

    public m8 h(boolean z) {
        return a("volumeVis", z ? 0 : 2);
    }

    public m8 e(boolean z) {
        return a("closeVis", z ? 0 : 2);
    }

    public m8 g(String str) {
        return a("videoRes", str);
    }

    public m8 d(boolean z) {
        return a("bottomCardVis", z ? 0 : 2);
    }

    public m8 f(String str) {
        return a("tipText", str);
    }

    public m8 c(boolean z) {
        return a("autoTipVis", z ? 0 : 2);
    }

    public m8 d(h4 h4Var) {
        return a(h4Var).d().e(h4Var).c(h4Var).b(h4Var).b();
    }

    private m8 a(String str, double d) throws JSONException {
        this.a.a(str, d);
        return this;
    }

    private m8 c(h4 h4Var) throws JSONException {
        String strC;
        a("complianceText", h4Var.D());
        e2 e2VarK = h4Var.k();
        if (e2VarK.l()) {
            strC = gi.b(h4Var);
        } else if (e2VarK.i()) {
            strC = gi.a(h4Var);
        } else {
            strC = h4Var.C();
        }
        a("gxbText", strC);
        return this;
    }

    public m8 b(boolean z) {
        return a(b8.a, z ? 0 : 2);
    }

    public m8 g(boolean z) throws JSONException {
        a("vidMut", !z ? 1 : 0);
        a("volume", z ? 1 : 0);
        return this;
    }

    public m8 e(String str) {
        return a("timeLeft", str);
    }

    public m8 c() {
        a("frontCardVis", 2);
        a("endCardVis", 0);
        return this;
    }

    public m8 b() throws JSONException {
        a("frontCardVis", 0);
        a("endCardVis", 2);
        a("endCardClsVis", 2);
        return this;
    }

    public m8 f(boolean z) {
        return a("vVis", z);
    }

    public JSONObject f() {
        return this.a.a();
    }

    public m8 d(String str) {
        return a("landingPageUrl", str);
    }

    private m8 d() throws JSONException {
        boolean zA = r1.d().c().A();
        a("safeArea", zA ? 10 : 1);
        a("pVis", zA ? 2 : 0);
        a("lVis", zA ? 0 : 2);
        return this;
    }

    private m8 a(String str, int i) throws JSONException {
        this.a.a(str, i);
        return this;
    }

    public m8 c(String str) throws JSONException {
        a("clp", str);
        return this;
    }

    public m8 e() {
        return a("tipVis", 2);
    }

    private m8 e(h4 h4Var) {
        return a("widgetVis", TextUtils.isEmpty(h4Var.a1()) ? 2 : 0);
    }

    public m8 b(String str) {
        return a("imgObj", str);
    }

    private m8 a(String str, long j) throws JSONException {
        this.a.a(str, j);
        return this;
    }

    private m8 a(String str, Object obj) throws JSONException {
        this.a.a(str, obj);
        return this;
    }

    private m8 a(String str, String str2) throws JSONException {
        this.a.a(str, str2);
        return this;
    }

    private m8 a(String str, boolean z) throws JSONException {
        this.a.a(str, z);
        return this;
    }

    private m8 a(h4 h4Var) {
        return a("adModel", h4Var);
    }

    public m8 a(String str) {
        return a("adViewParentSize", str);
    }

    public m8 a(boolean z) {
        return a("appInfoVis", z ? 0 : 2);
    }

    public m8 a(Bitmap bitmap) {
        return a("devLogo", bitmap);
    }

    public m8 a() {
        return a("endCardClsVis", 0);
    }

    public m8 a(Float f) throws JSONException {
        a("novelPageCardVis", f.floatValue() > 0.0f ? 0 : 2);
        a("novelPageCardY", zu.b(f.doubleValue()));
        return this;
    }

    public m8 a(long j, long j2) {
        return a("vdoP", ((j * 1.0f) / j2) * 100.0f);
    }

    public m8 a(yg ygVar) {
        return a(TextureRenderKeys.KEY_IS_CALLBACK, ygVar);
    }

    public m8 a(long j) {
        return a("vdoTime", j);
    }

    public m8 a(sh shVar) {
        return a("webListener", shVar);
    }
}
