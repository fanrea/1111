package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.webkit.WebView;
import com.baidu.mobads.sdk.api.IOAdEvent;
import com.baidu.mobads.sdk.api.IXAdContainerFactory;
import com.baidu.mobads.sdk.api.NativeCPUAdData;
import com.baidu.mobads.sdk.api.NativeCPUManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class ae extends bj {
    public static final int a = 17;
    private static final String t = "javascript:";
    private NativeCPUManager.CPUAdListener A;
    private NativeCPUManager B;
    private int C;
    private int D;
    private boolean E;
    private String F;
    private int u;
    private int v;
    private int[] w;
    private boolean x;
    private int y;
    private HashMap<String, Object> z;

    public ae(Context context) {
        super(context);
        this.C = 5;
        this.D = 60;
    }

    public ae(Context context, String str, NativeCPUManager nativeCPUManager) {
        super(context);
        this.C = 5;
        this.D = 60;
        this.q = str;
        this.B = nativeCPUManager;
    }

    public void a(NativeCPUManager.CPUAdListener cPUAdListener) {
        this.A = cPUAdListener;
    }

    public void a(int i, int i2, int[] iArr, boolean z, HashMap<String, Object> map) {
        this.v = i;
        this.u = i2;
        this.w = iArr;
        this.x = z;
        this.z = map;
        this.E = ao.f();
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    public void a() {
        if (this.m == null) {
            this.n = false;
            return;
        }
        this.n = true;
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        try {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("prod", "cpu");
            this.m.createProdHandler(jSONObject3);
            m();
            this.m.addEventListener("Update_fbReader_Setting", new af(this));
            this.m.addEventListener("closeInterstitialAd", new ag(this));
            jSONObject.put("prod", "cpu");
            jSONObject.put("appsid", this.q);
            jSONObject.put("pageIndex", this.v);
            jSONObject.put("pageSize", this.u);
            jSONObject.put("channels", this.w);
            jSONObject.put("showAd", this.x);
            jSONObject.put("openActivitylink", this.F);
            if (!TextUtils.isEmpty(this.q)) {
                jSONObject.put("appid", this.q);
            }
            jSONObject2.put("timeout", this.y);
            HashMap<String, Object> map = this.z;
            if (map == null || map.isEmpty()) {
                az.c().e("内容联盟元素需要传入 CPUAdRequest配置信息");
            }
            jSONObject2 = m.a(this.z);
            if (jSONObject2 != null) {
                jSONObject2.put("isInitNovelSDK", this.E);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.m.loadAd(jSONObject, jSONObject2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Map<String, Object> map) {
        if (map != null) {
            Object obj = map.get("adInnerPageInterval");
            Object obj2 = map.get("adBottomRefreshInterval");
            Object obj3 = map.get("adFrontChapterInterval");
            Object obj4 = map.get("isShowFeeds");
            Object obj5 = map.get("isAdSwitch");
            Object obj6 = map.get("showCount");
            Object obj7 = map.get("clickCount");
            if (obj != null && obj2 != null) {
                ao.a(((Integer) obj).intValue());
                ao.b(((Integer) obj2).intValue());
            }
            if ((obj3 instanceof Integer) && (obj4 instanceof Boolean)) {
                ao.a(((Integer) obj3).intValue(), ((Boolean) obj4).booleanValue());
            }
            if (obj5 instanceof Integer) {
                ao.a(((Integer) obj5).intValue() != 0);
            }
            if ((obj6 instanceof Integer) && (obj7 instanceof Integer)) {
                ao.a(((Integer) obj6).intValue(), ((Integer) obj7).intValue());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        ao.b();
    }

    public void a(int i) {
        this.y = i;
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void a(IOAdEvent iOAdEvent) {
        if (this.A != null) {
            ArrayList arrayList = new ArrayList();
            Iterator it = ((List) iOAdEvent.getData().get("cpuAdList")).iterator();
            while (it.hasNext()) {
                NativeCPUAdData nativeCPUAdData = new NativeCPUAdData(this.i, it.next(), this.z);
                arrayList.add(nativeCPUAdData);
                addObserver(nativeCPUAdData);
            }
            this.A.onAdLoaded(arrayList);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void a(String str, int i, String str2) {
        super.a(str, i, str2);
        NativeCPUManager.CPUAdListener cPUAdListener = this.A;
        if (cPUAdListener != null) {
            cPUAdListener.onAdError(str, i);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void a(int i, String str, String str2) {
        super.a(i, str, str2);
        NativeCPUManager.CPUAdListener cPUAdListener = this.A;
        if (cPUAdListener != null) {
            cPUAdListener.onAdError(str, i);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void b(IOAdEvent iOAdEvent) {
        notifyObservers(iOAdEvent);
        setChanged();
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void b() {
        NativeCPUManager.CPUAdListener cPUAdListener = this.A;
        if (cPUAdListener != null) {
            cPUAdListener.onVideoDownloadSuccess();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void c() {
        NativeCPUManager.CPUAdListener cPUAdListener = this.A;
        if (cPUAdListener != null) {
            cPUAdListener.onVideoDownloadFailed();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void c(IOAdEvent iOAdEvent) {
        if (iOAdEvent != null) {
            Map<String, Object> data = iOAdEvent.getData();
            Integer num = (Integer) data.get("position");
            String str = (String) data.get("mislikereason");
            NativeCPUManager.CPUAdListener cPUAdListener = this.A;
            if (cPUAdListener == null || num == null || str == null) {
                return;
            }
            cPUAdListener.onDisLikeAdClick(num.intValue(), str);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void d() {
        NativeCPUManager.CPUAdListener cPUAdListener = this.A;
        if (cPUAdListener != null) {
            cPUAdListener.onExitLp();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.bj
    protected void d(IOAdEvent iOAdEvent) {
        try {
            if (this.A == null || iOAdEvent == null) {
                return;
            }
            HashMap<String, Object> map = (HashMap) iOAdEvent.getData();
            this.A.onLpCustomEventCallBack(map, new ah(this, map.get("activity")));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    protected void a(WebView webView, JSONObject jSONObject) {
        a(new ai(this, jSONObject, webView));
    }

    public void e() {
        ao.a(this.C);
        ao.b(this.D);
        ao.a(new aj(this));
    }

    private String j(String str) {
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

    public Activity f() {
        return ao.c();
    }

    public boolean g() {
        return ao.d();
    }

    public void a(String str) {
        this.F = str;
    }
}
