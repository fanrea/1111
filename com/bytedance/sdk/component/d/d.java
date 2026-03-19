package com.bytedance.sdk.component.d;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.alipay.sdk.m.u.i;
import com.bytedance.sdk.component.d.h;
import com.ss.texturerender.TextureRenderKeys;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public abstract class d {
    protected gb b;
    protected Context d;
    h h;
    protected uo hc;
    protected String u;
    protected Handler c = new Handler(Looper.getMainLooper());
    protected volatile boolean an = false;
    private final Map<String, h> gb = new HashMap();

    protected abstract String d();

    protected abstract void d(tc tcVar);

    protected abstract void d(String str);

    protected abstract Context getContext(tc tcVar);

    protected d() {
    }

    protected void invokeMethod(final String str) {
        if (this.an) {
            return;
        }
        tt.d("Received call: ".concat(String.valueOf(str)));
        this.c.post(new Runnable() { // from class: com.bytedance.sdk.component.d.d.1
            @Override // java.lang.Runnable
            public void run() {
                if (d.this.an) {
                    return;
                }
                cb cbVarD = null;
                try {
                    cbVarD = d.this.d(new JSONObject(str));
                } catch (Exception e) {
                    tt.hc("Exception thrown while parsing function.", e);
                }
                if (cb.d(cbVarD)) {
                    tt.d("By pass invalid call: ".concat(String.valueOf(cbVarD)));
                    if (cbVarD != null) {
                        d.this.hc(np.d(new yo(cbVarD.d, "Failed to parse invocation.")), cbVarD);
                        return;
                    }
                    return;
                }
                d.this.d(cbVarD);
            }
        });
    }

    protected void d(String str, cb cbVar) {
        d(str);
    }

    protected void hc() {
        this.h.d();
        Iterator<h> it = this.gb.values().iterator();
        while (it.hasNext()) {
            it.next().d();
        }
        this.c.removeCallbacksAndMessages(null);
        this.an = true;
    }

    protected final void d(cb cbVar) {
        String strD;
        if (this.an || (strD = d()) == null) {
            return;
        }
        h hVarHc = hc(cbVar.h);
        if (hVarHc == null) {
            tt.hc("Received call with unknown namespace, ".concat(String.valueOf(cbVar)));
            if (this.hc != null) {
                d();
            }
            hc(np.d(new yo(-4, "Namespace " + cbVar.h + " unknown.")), cbVar);
            return;
        }
        an anVar = new an();
        anVar.hc = strD;
        anVar.d = this.d;
        anVar.b = hVarHc;
        try {
            h.d dVarD = hVarHc.d(cbVar, anVar);
            if (dVarD == null) {
                tt.hc("Received call but not registered, ".concat(String.valueOf(cbVar)));
                if (this.hc != null) {
                    d();
                }
                hc(np.d(new yo(-2, "Function " + cbVar.c + " is not registered.")), cbVar);
                return;
            }
            if (dVarD.d) {
                hc(dVarD.hc, cbVar);
            }
            if (this.hc != null) {
                d();
            }
        } catch (Exception e) {
            tt.d("call finished with error, ".concat(String.valueOf(cbVar)), e);
            hc(np.d(e), cbVar);
        }
    }

    final void d(tc tcVar, sy syVar) {
        this.d = getContext(tcVar);
        this.b = tcVar.c;
        this.hc = tcVar.tt;
        this.h = new h(tcVar, this, syVar);
        this.u = tcVar.mk;
        d(tcVar);
    }

    final <T> void d(String str, T t) {
        if (this.an) {
            return;
        }
        String strD = this.b.d((gb) t);
        tt.d("Sending js event: ".concat(String.valueOf(str)));
        d("{\"__msg_type\":\"event\",\"__event_id\":\"" + str + "\",\"__params\":" + strD + i.d);
    }

    final void hc(String str, cb cbVar) {
        JSONObject jSONObject;
        if (this.an) {
            return;
        }
        if (TextUtils.isEmpty(cbVar.an)) {
            tt.d("By passing js callback due to empty callback: ".concat(String.valueOf(str)));
            return;
        }
        if (!str.startsWith("{") || !str.endsWith(i.d)) {
            tt.d(new IllegalArgumentException("Illegal callback data: ".concat(String.valueOf(str))));
        }
        tt.d("Invoking js callback: " + cbVar.an);
        try {
            jSONObject = new JSONObject(str);
        } catch (Exception unused) {
            jSONObject = new JSONObject();
        }
        d(e.d().d("__msg_type", TextureRenderKeys.KEY_IS_CALLBACK).d("__callback_id", cbVar.an).d("__params", jSONObject).hc(), cbVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public cb d(JSONObject jSONObject) throws JSONException {
        String strOptString;
        if (this.an) {
            return null;
        }
        String strOptString2 = jSONObject.optString("__callback_id");
        String strOptString3 = jSONObject.optString("func");
        if (d() == null) {
            return null;
        }
        try {
            String string = jSONObject.getString("__msg_type");
            String strValueOf = "";
            try {
                Object objOpt = jSONObject.opt("params");
                if (objOpt == null) {
                    strOptString = strValueOf;
                } else if (objOpt instanceof JSONObject) {
                    strOptString = String.valueOf((JSONObject) objOpt);
                } else {
                    if (objOpt instanceof String) {
                        strValueOf = (String) objOpt;
                    } else {
                        strValueOf = String.valueOf(objOpt);
                    }
                    strOptString = strValueOf;
                }
            } catch (Throwable unused) {
                strOptString = jSONObject.optString("params");
            }
            String string2 = jSONObject.getString("JSSDK");
            String strOptString4 = jSONObject.optString("namespace");
            return cb.d().d(string2).hc(string).b(strOptString3).c(strOptString).u(strOptString2).an(strOptString4).h(jSONObject.optString("__iframe_url")).d();
        } catch (JSONException e) {
            tt.hc("Failed to create call.", e);
            return cb.d(strOptString2, -1);
        }
    }

    private h hc(String str) {
        if (TextUtils.equals(str, this.u) || TextUtils.isEmpty(str)) {
            return this.h;
        }
        return this.gb.get(str);
    }
}
