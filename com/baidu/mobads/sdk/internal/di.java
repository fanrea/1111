package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import com.baidu.mobads.sdk.api.BiddingListener;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.RequestParameters;
import com.baidu.mobads.sdk.api.RewardVideoAd;
import com.baidu.mobads.sdk.api.ScreenVideoAdListener;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class di extends bj {
    private String A;
    private a B;
    private RequestParameters C;
    private boolean a;
    private int t;
    private String u;
    private ScreenVideoAdListener v;
    private final String w;
    private int x;
    private int y;
    private String z;

    public di(Context context, String str, boolean z) {
        this(context, str, z, "rvideo");
    }

    public di(Context context, String str, boolean z, String str2) {
        super(context);
        this.t = 3;
        this.u = str;
        this.a = z;
        this.w = str2;
    }

    public void e() {
        if (this.m != null) {
            this.m.showAd();
        }
    }

    public void a(Context context) throws JSONException {
        if (this.m != null) {
            JSONObject jSONObject = new JSONObject();
            HashMap map = new HashMap();
            try {
                jSONObject.put("msg", "setContext");
                map.put("context", context);
            } catch (JSONException e) {
                bu.a().a(e);
            }
            a(jSONObject, map);
            this.m.showAd();
        }
    }

    public void a(int i) {
        this.t = i;
    }

    public void a(String str) {
        this.z = str;
    }

    public void j(String str) {
        this.A = str;
    }

    public void a(ScreenVideoAdListener screenVideoAdListener) {
        this.v = screenVideoAdListener;
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void a() {
        if (this.m == null) {
            this.n = false;
        } else {
            this.n = true;
            this.m.loadAd(j(), k());
        }
    }

    public boolean f() {
        if (this.m != null) {
            return this.m.isAdReady();
        }
        return false;
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void q() {
        ScreenVideoAdListener screenVideoAdListener = this.v;
        if (screenVideoAdListener != null) {
            screenVideoAdListener.onAdShow();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void a(IOAdEvent iOAdEvent) {
        List<a> listA;
        if (iOAdEvent != null && (listA = b.a(iOAdEvent.getMessage()).a()) != null && listA.size() > 0) {
            this.B = listA.get(0);
        }
        ScreenVideoAdListener screenVideoAdListener = this.v;
        if (screenVideoAdListener != null) {
            screenVideoAdListener.onAdLoaded();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void h(IOAdEvent iOAdEvent) {
        ScreenVideoAdListener screenVideoAdListener = this.v;
        if (screenVideoAdListener != null) {
            screenVideoAdListener.onAdClick();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void g(IOAdEvent iOAdEvent) {
        super.g(iOAdEvent);
        float fFloatValue = (iOAdEvent == null || iOAdEvent.getData() == null) ? 0.0f : ((Float) iOAdEvent.getData().get("play_scale")).floatValue();
        ScreenVideoAdListener screenVideoAdListener = this.v;
        if (screenVideoAdListener != null) {
            screenVideoAdListener.onAdClose(fFloatValue);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void g(String str) {
        ScreenVideoAdListener screenVideoAdListener = this.v;
        if (screenVideoAdListener != null) {
            screenVideoAdListener.onAdSkip(Float.parseFloat(str));
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void b() {
        ScreenVideoAdListener screenVideoAdListener = this.v;
        if (screenVideoAdListener != null) {
            screenVideoAdListener.onVideoDownloadSuccess();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void c() {
        ScreenVideoAdListener screenVideoAdListener = this.v;
        if (screenVideoAdListener != null) {
            screenVideoAdListener.onVideoDownloadFailed();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void a(String str, int i, String str2) {
        super.a(str, i, str2);
        ScreenVideoAdListener screenVideoAdListener = this.v;
        if (screenVideoAdListener != null) {
            screenVideoAdListener.onAdFailed(str);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void a(int i, String str, String str2) {
        super.a(i, str, str2);
        ScreenVideoAdListener screenVideoAdListener = this.v;
        if (screenVideoAdListener != null) {
            screenVideoAdListener.onAdFailed(str);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void s() {
        ScreenVideoAdListener screenVideoAdListener = this.v;
        if (screenVideoAdListener != null) {
            screenVideoAdListener.playCompletion();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void b(boolean z) {
        ScreenVideoAdListener screenVideoAdListener = this.v;
        if (screenVideoAdListener == null || !(screenVideoAdListener instanceof RewardVideoAd.RewardVideoAdListener)) {
            return;
        }
        ((RewardVideoAd.RewardVideoAdListener) screenVideoAdListener).onRewardVerify(z);
    }

    public String g() {
        a aVar = this.B;
        return aVar != null ? aVar.z() : "";
    }

    public String x() {
        a aVar = this.B;
        return aVar != null ? aVar.A() : "";
    }

    public void a(boolean z, LinkedHashMap<String, Object> linkedHashMap, BiddingListener biddingListener) {
        a aVar = this.B;
        if (aVar != null) {
            a(aVar.I(), z, linkedHashMap, biddingListener);
        } else {
            a(this.j, z, linkedHashMap, biddingListener);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public JSONObject j() {
        this.s = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("prod", this.w);
            this.m.createProdHandler(jSONObject2);
            m();
            jSONObject.put("prod", this.w);
            jSONObject.put("apid", this.u);
            jSONObject.put("fet", "ANTI,MSSP,VIDEO,NMON");
            jSONObject.put("n", "1");
            jSONObject.put("at", "10");
            if (!TextUtils.isEmpty(this.q)) {
                jSONObject.put("appid", this.q);
            }
            Rect rectA = bb.a(this.i);
            this.x = rectA.width();
            this.y = rectA.height();
            if (this.i.getResources().getConfiguration().orientation == 2) {
                this.x = rectA.height();
                this.y = rectA.width();
            }
            jSONObject.put("w", "" + this.x);
            jSONObject.put("h", "" + this.y);
            jSONObject.put(com.baidu.mobads.container.components.h.b.e.f, 1);
            if ("rvideo".equals(this.w)) {
                jSONObject.put(com.baidu.mobads.container.adrequest.g.l, 5293);
            }
            jSONObject = m.a(jSONObject, b(this.o));
            b(jSONObject);
            return jSONObject;
        } catch (Throwable th) {
            th.printStackTrace();
            return jSONObject;
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public JSONObject k() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("timeout", 8000);
            jSONObject.put("useSurfaceView", this.a);
            jSONObject.put("downloadConfirmPolicy", this.t);
            jSONObject.put("userid", this.z);
            jSONObject.put("extra", this.A);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return jSONObject;
    }

    public void a(RequestParameters requestParameters) {
        this.C = requestParameters;
        a(requestParameters.getExt());
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void a(Map<String, String> map) {
        try {
            this.o = m.a(map);
        } catch (Throwable unused) {
            this.o = new HashMap<>();
        }
    }

    public Object k(String str) {
        if (this.B == null) {
            return null;
        }
        if ("request_id".equals(str)) {
            return this.B.V();
        }
        return this.B.a(str);
    }
}
