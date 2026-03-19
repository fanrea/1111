package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.RelativeLayout;
import com.baidu.mobads.sdk.api.BiddingListener;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IOAdEventListener;
import com.baidu.mobads.sdk.api.IXAdContainerFactory;
import com.baidu.mobads.sdk.internal.a.c;
import com.ss.texturerender.effect.ICEffect.ICEffectKeys;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Observable;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public abstract class bj extends Observable {
    private static final String a = "b_f";
    public static final String b = "XAbstractProdTemplate";
    public static final String c = "error_message";
    public static final String d = "error_code";
    public static final String e = "error_uniqueid";
    protected static final String f = "instanceInfo";
    protected static final String g = "showState";
    protected RelativeLayout h;
    protected Context i;
    protected String j;
    public HashMap<String, String> o;
    public String p;
    public String q;
    protected bu k = bu.a();
    public IAdInterListener m = null;
    public boolean n = true;
    public int r = -1;
    protected long s = 0;
    public IOAdEventListener l = new a();

    public abstract void a();

    protected void a(IOAdEvent iOAdEvent) {
    }

    protected void a(String str, boolean z) {
    }

    protected void b() {
    }

    protected void b(IOAdEvent iOAdEvent) {
    }

    protected void b(String str, boolean z) {
    }

    protected void b(boolean z) {
    }

    protected void c() {
    }

    protected void c(IOAdEvent iOAdEvent) {
    }

    protected void d() {
    }

    protected void d(IOAdEvent iOAdEvent) {
    }

    protected void d(String str) {
    }

    protected void e(IOAdEvent iOAdEvent) {
    }

    protected void e(String str) {
    }

    protected void f(IOAdEvent iOAdEvent) {
    }

    protected void f(String str) {
    }

    protected void g(String str) {
    }

    protected void h(IOAdEvent iOAdEvent) {
    }

    protected void i(IOAdEvent iOAdEvent) {
    }

    protected void j(IOAdEvent iOAdEvent) {
    }

    protected void k(IOAdEvent iOAdEvent) {
    }

    protected void q() {
    }

    protected void s() {
    }

    protected void t() {
    }

    protected void u() {
    }

    protected void v() {
    }

    public bj(Context context) {
        this.i = context;
        aa.a().a(this.i, new bk(this));
    }

    public void h() {
        this.m = (IAdInterListener) av.a(z.k, bt.a(this.i), (Class<?>[]) new Class[]{Context.class}, this.i);
        if (this.n) {
            return;
        }
        a();
    }

    public void i() {
        a("SDK未初始化", 1, "");
    }

    public void a(View view, JSONObject jSONObject) {
        IAdInterListener iAdInterListener = this.m;
        if (iAdInterListener != null) {
            iAdInterListener.onAdTaskProcess(view, a(IAdInterListener.AdCommandType.AD_IMPRESSION, jSONObject));
        }
    }

    public void a(Activity activity) {
        if (this.m != null) {
            HashMap map = new HashMap();
            map.put("setActivity", activity);
            this.m.onAdTaskProcess(a(IAdInterListener.AdCommandType.CHANGE_ACTIVITY, new JSONObject()), map);
        }
    }

    public void b(View view, JSONObject jSONObject) {
        IAdInterListener iAdInterListener = this.m;
        if (iAdInterListener != null) {
            iAdInterListener.onAdTaskProcess(view, a(IAdInterListener.AdCommandType.AD_CLICK, jSONObject));
        }
    }

    public void a(JSONObject jSONObject) {
        IAdInterListener iAdInterListener = this.m;
        if (iAdInterListener != null) {
            iAdInterListener.onAdTaskProcess(a(IAdInterListener.AdCommandType.HANDLE_EVENT, jSONObject));
        }
    }

    public void a(JSONObject jSONObject, Map<String, Object> map) {
        IAdInterListener iAdInterListener = this.m;
        if (iAdInterListener != null) {
            iAdInterListener.onAdTaskProcess(a(IAdInterListener.AdCommandType.HANDLE_EVENT, jSONObject), map);
        }
    }

    public void a(String str, Map<String, Object> map) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(ICEffectKeys.KEY_IS_IC_EFFECT_EVENT_TYPE, "server_bidding");
            jSONObject.put("msg", str);
            IAdInterListener iAdInterListener = this.m;
            if (iAdInterListener != null) {
                iAdInterListener.onAdTaskProcess(a(IAdInterListener.AdCommandType.HANDLE_EVENT, jSONObject), map);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void a(String str, boolean z, LinkedHashMap<String, Object> linkedHashMap, BiddingListener biddingListener) {
        try {
            if (k.a(z, linkedHashMap, biddingListener)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("uniqueId", str);
                jSONObject.put("result", z);
                try {
                    for (Map.Entry<String, Object> entry : linkedHashMap.entrySet()) {
                        jSONObject.put(String.valueOf(entry.getKey()), entry.getValue());
                    }
                } catch (Throwable th) {
                    az.f(th.getMessage());
                }
                IAdInterListener iAdInterListener = this.m;
                if (iAdInterListener != null) {
                    iAdInterListener.onAdTaskProcess(a("onBiddingResult", jSONObject), (Map<String, Object>) null);
                }
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void a(String str, HashMap<String, Object> map) throws JSONException {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(ICEffectKeys.KEY_IS_IC_EFFECT_EVENT_TYPE, str);
            IAdInterListener iAdInterListener = this.m;
            if (iAdInterListener != null) {
                iAdInterListener.onAdTaskProcess(a(IAdInterListener.AdCommandType.NOVEL_EVENT, jSONObject), map);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public JSONObject j() {
        return new JSONObject();
    }

    public JSONObject k() {
        return new JSONObject();
    }

    public String l() {
        JSONObject jSONObjectJ = j();
        JSONObject jSONObjectK = k();
        HashMap map = new HashMap();
        map.put("param_info", jSONObjectJ);
        map.put("ad_buss_param", jSONObjectK);
        a("get_request_token", (Map<String, Object>) map);
        Object obj = map.get("request_token");
        if (obj instanceof String) {
            return (String) obj;
        }
        return null;
    }

    public void b(String str) {
        if (TextUtils.isEmpty(str)) {
            a("bidding data is empty", 2, "");
        }
        if (this.m != null) {
            HashMap map = new HashMap();
            map.put("bidding_data", str);
            a("load_bidding_data", (Map<String, Object>) map);
            return;
        }
        a("Initialization doesn't finish yet.", 1, "");
    }

    public void c(String str) {
        if (TextUtils.isEmpty(str)) {
            a("bidding id is empty", 2, "");
        }
        if (this.m != null) {
            HashMap map = new HashMap();
            map.put("bid_id", str);
            a("load_bidding_ad", (Map<String, Object>) map);
            return;
        }
        a("Initialization doesn't finish yet.", 1, "");
    }

    public void m() {
        IAdInterListener iAdInterListener = this.m;
        if (iAdInterListener != null) {
            iAdInterListener.addEventListener(com.baidu.mobads.sdk.internal.a.c.h, new c.a());
            this.m.addEventListener(z.G, this.l);
            this.m.addEventListener(z.I, this.l);
            this.m.addEventListener(z.f748K, this.l);
            this.m.addEventListener(z.L, this.l);
            this.m.addEventListener(z.V, this.l);
            this.m.addEventListener(z.q, this.l);
            this.m.addEventListener(z.W, this.l);
            this.m.addEventListener(z.r, this.l);
            this.m.addEventListener(z.M, this.l);
            this.m.addEventListener(z.N, this.l);
            this.m.addEventListener(z.J, this.l);
            this.m.addEventListener(z.C, this.l);
            this.m.addEventListener(z.ab, this.l);
            this.m.addEventListener(z.ac, this.l);
            this.m.addEventListener(z.ad, this.l);
            this.m.addEventListener(z.Z, this.l);
            this.m.addEventListener(z.U, this.l);
            this.m.addEventListener(z.ae, this.l);
            this.m.addEventListener(z.af, this.l);
            this.m.addEventListener(z.ag, this.l);
            this.m.addEventListener(z.ah, this.l);
            this.m.addEventListener(z.ai, this.l);
            this.m.addEventListener(z.aj, this.l);
            this.m.addEventListener(z.ak, this.l);
            this.m.addEventListener(z.al, this.l);
            this.m.addEventListener(z.aa, this.l);
            this.m.addEventListener(z.am, this.l);
            this.m.addEventListener(z.X, this.l);
            this.m.addEventListener(z.an, this.l);
            this.m.addEventListener(z.ao, this.l);
        }
    }

    public void n() {
        IAdInterListener iAdInterListener = this.m;
        if (iAdInterListener != null) {
            iAdInterListener.onAttachedToWindow();
        }
    }

    public void o() {
        IAdInterListener iAdInterListener = this.m;
        if (iAdInterListener != null) {
            iAdInterListener.onDetachedFromWindow();
        }
    }

    public void b(int i) {
        IAdInterListener iAdInterListener = this.m;
        if (iAdInterListener != null) {
            iAdInterListener.onWindowVisibilityChanged(i);
        }
    }

    public void a(boolean z) {
        IAdInterListener iAdInterListener = this.m;
        if (iAdInterListener != null) {
            iAdInterListener.onWindowFocusChanged(z);
        }
    }

    public boolean a(int i, KeyEvent keyEvent) {
        IAdInterListener iAdInterListener = this.m;
        if (iAdInterListener != null) {
            return iAdInterListener.onKeyDown(i, keyEvent);
        }
        return false;
    }

    public void p() {
        IAdInterListener iAdInterListener = this.m;
        if (iAdInterListener != null) {
            iAdInterListener.destroyAd();
        }
    }

    protected void g(IOAdEvent iOAdEvent) {
        r();
    }

    protected void a(int i, String str, String str2) {
        r();
    }

    protected void a(String str, int i, String str2) {
        r();
    }

    public void r() {
        IAdInterListener iAdInterListener = this.m;
        if (iAdInterListener != null) {
            iAdInterListener.removeAllListeners();
        }
    }

    public class a implements IOAdEventListener {
        public a() {
        }

        @Override // com.baidu.mobads.sdk.api.IOAdEventListener
        public void run(IOAdEvent iOAdEvent) {
            bj.a(new bm(this, iOAdEvent));
        }

        private String a(IOAdEvent iOAdEvent) {
            Map<String, Object> data;
            Object obj;
            if (iOAdEvent == null) {
                return null;
            }
            String message = iOAdEvent.getMessage();
            return (!TextUtils.isEmpty(message) || (data = iOAdEvent.getData()) == null || (obj = data.get("msg")) == null || !(obj instanceof String)) ? message : (String) obj;
        }
    }

    public static void a(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        try {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                runnable.run();
            } else {
                new Handler(Looper.getMainLooper()).post(new bl(runnable));
            }
        } catch (Exception unused) {
        }
    }

    public void a(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        this.o = (HashMap) map;
    }

    public View w() {
        IAdInterListener iAdInterListener = this.m;
        if (iAdInterListener != null) {
            return iAdInterListener.getAdContainerView();
        }
        return null;
    }

    public JSONObject b(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        try {
            return new JSONObject(map);
        } catch (Exception unused) {
            return null;
        }
    }

    public void h(String str) {
        this.q = str;
    }

    private String a(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            try {
                jSONObject = new JSONObject();
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }
        return "bdsdk://" + str + "?jsonObj=" + Uri.encode(jSONObject.toString());
    }

    public String i(String str) {
        IXAdContainerFactory iXAdContainerFactoryC;
        aa aaVarA = aa.a();
        if (aaVarA != null && (iXAdContainerFactoryC = aaVarA.c()) != null) {
            Object remoteParam = iXAdContainerFactoryC.getRemoteParam(str, new Object[0]);
            if (remoteParam instanceof String) {
                return (String) remoteParam;
            }
        }
        return null;
    }

    protected void b(JSONObject jSONObject) {
        int i = this.r;
        if (i >= 0 && jSONObject != null) {
            try {
                jSONObject.put(a, i);
            } catch (Throwable th) {
                this.k.a(th);
            }
        }
        if (jSONObject != null) {
            try {
                jSONObject.put("load_time", this.s);
            } catch (Throwable th2) {
                this.k.a(th2);
            }
        }
    }
}
