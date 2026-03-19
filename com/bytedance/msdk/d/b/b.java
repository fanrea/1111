package com.bytedance.msdk.d.b;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class b {
    private PluginValueSet b;
    private com.bytedance.sdk.openadsdk.w.b.b.d c = new com.bytedance.sdk.openadsdk.w.b.b.d(com.bytedance.msdk.core.d.mk().y().sparseArray());
    private PluginValueSet d;
    private PluginValueSet hc;
    private Function<SparseArray<Object>, Object> u;

    private b(SparseArray<Object> sparseArray) {
        this.u = null;
        PluginValueSet pluginValueSetHc = com.bykv.d.d.d.d.d.d(sparseArray).hc();
        this.d = pluginValueSetHc;
        if (pluginValueSetHc != null) {
            this.b = com.bytedance.sdk.openadsdk.w.b.c.d(8457, pluginValueSetHc);
            PluginValueSet pluginValueSetD = com.bytedance.sdk.openadsdk.w.b.c.d(8475, this.d);
            this.hc = pluginValueSetD;
            if (pluginValueSetD != null) {
                this.u = (Function) pluginValueSetD.objectValue(8311, Function.class);
            }
        }
        wl();
    }

    private void wl() {
        ru();
        yn();
        q();
    }

    private void q() {
        com.bytedance.msdk.d.u.b.hc("---------  sdk 聚合信息 start ----");
        com.bytedance.msdk.d.u.b.hc("getHttps：" + z());
        com.bytedance.msdk.d.u.b.hc("getWxAppId：" + fs());
        com.bytedance.msdk.d.u.b.hc("getPublisherDid：" + ba());
        com.bytedance.msdk.d.u.b.hc("isOpenAdnTest：" + mt());
        com.bytedance.msdk.d.u.b.hc("getMediationConfigUserInfoForSegment：" + r());
        com.bytedance.msdk.d.u.b.hc("getLocalExtra：" + hv());
        com.bytedance.msdk.d.u.b.hc("getCustomLocalConfig：" + bc());
        com.bytedance.msdk.d.u.b.hc("getOpensdkVer：" + dc());
        com.bytedance.msdk.d.u.b.hc("isWxInstalled：" + tr());
        com.bytedance.msdk.d.u.b.hc("isSupportH265：" + nv());
        com.bytedance.msdk.d.u.b.hc("isSupportSplashZoomout：" + y());
        com.bytedance.msdk.d.u.b.hc("---------  sdk 聚合信息 end ----");
    }

    private void ru() {
        com.bytedance.msdk.d.u.b.hc("---------  sdk 初始化信息 start ----");
        com.bytedance.msdk.d.u.b.hc("isDebug：" + j());
        com.bytedance.msdk.d.u.b.hc("getClassName：" + d());
        com.bytedance.msdk.d.u.b.hc("getAppId：" + hc());
        com.bytedance.msdk.d.u.b.hc("getAppName：" + b());
        com.bytedance.msdk.d.u.b.hc("getADNName：" + c());
        com.bytedance.msdk.d.u.b.hc("getAppKey：" + u());
        com.bytedance.msdk.d.u.b.hc("getInitCallback：" + an());
        com.bytedance.msdk.d.u.b.hc("getAgeGroup：" + yi());
        com.bytedance.msdk.d.u.b.hc("isCustom：" + he());
        com.bytedance.msdk.d.u.b.hc("getCustomInitMap：" + vv());
        com.bytedance.msdk.d.u.b.hc("getCustomGMConfiguration：" + zw());
        com.bytedance.msdk.d.u.b.hc("getGromoreVersion：" + s());
        com.bytedance.msdk.d.u.b.hc("getMap：" + us());
        com.bytedance.msdk.d.u.b.hc("---------  sdk 初始化信息 end ----");
    }

    private void yn() {
        com.bytedance.msdk.d.u.b.hc("---------  sdk 隐私设置 start ----");
        com.bytedance.msdk.d.u.b.hc("isCanUseLocation：" + tt());
        c cVarE = e();
        com.bytedance.msdk.d.u.b.hc("getLocation：".concat(String.valueOf(cVarE)));
        if (cVarE != null) {
            com.bytedance.msdk.d.u.b.hc("getLocation getLatitude：" + cVarE.d());
            com.bytedance.msdk.d.u.b.hc("getLocation getLongitude：" + cVarE.hc());
        }
        com.bytedance.msdk.d.u.b.hc("appList：" + mk());
        com.bytedance.msdk.d.u.b.hc("isCanUsePhoneState：" + gb());
        com.bytedance.msdk.d.u.b.hc("isLimitPersonalAds：" + h());
        com.bytedance.msdk.d.u.b.hc("getDevImei：" + cb());
        com.bytedance.msdk.d.u.b.hc("isCanUseWifiState：" + v());
        com.bytedance.msdk.d.u.b.hc("getMacAddress：" + sy());
        com.bytedance.msdk.d.u.b.hc("userPrivacyConfig：" + de());
        com.bytedance.msdk.d.u.b.hc("isCanUseWriteExternal：" + tc());
        com.bytedance.msdk.d.u.b.hc("isCanUseAndroidId：" + uo());
        com.bytedance.msdk.d.u.b.hc("getAndroidId：" + yo());
        List<String> listNp = np();
        com.bytedance.msdk.d.u.b.hc("getAppList：".concat(String.valueOf(listNp)));
        if (listNp != null) {
            Iterator<String> it = listNp.iterator();
            while (it.hasNext()) {
                com.bytedance.msdk.d.u.b.hc("getAppList item: ".concat(String.valueOf(it.next())));
            }
        }
        List<String> listW = w();
        com.bytedance.msdk.d.u.b.hc("getDevImeis：".concat(String.valueOf(listW)));
        if (listW != null) {
            Iterator<String> it2 = listW.iterator();
            while (it2.hasNext()) {
                com.bytedance.msdk.d.u.b.hc("getDevImeis item: ".concat(String.valueOf(it2.next())));
            }
        }
        com.bytedance.msdk.d.u.b.hc("getDevOaid：" + jh());
        com.bytedance.msdk.d.u.b.hc("isCanUseOaid：" + rf());
        com.bytedance.msdk.d.u.b.hc("isCanUseMacAddress：" + mq());
        com.bytedance.msdk.d.u.b.hc("isProgrammaticRecommend：" + k());
        com.bytedance.msdk.d.u.b.hc("---------  sdk 隐私设置 end ----");
    }

    public static b d(SparseArray<Object> sparseArray) {
        return new b(sparseArray);
    }

    public void hc(SparseArray<Object> sparseArray) {
        PluginValueSet pluginValueSetHc = com.bykv.d.d.d.d.d.d(sparseArray).hc();
        this.hc = pluginValueSetHc;
        if (pluginValueSetHc != null) {
            this.u = (Function) pluginValueSetHc.objectValue(8311, Function.class);
        }
        yn();
    }

    private boolean l() {
        PluginValueSet pluginValueSet = this.d;
        return (pluginValueSet == null || pluginValueSet.isEmpty()) ? false : true;
    }

    public String d() {
        return l() ? this.d.stringValue(8010) : "";
    }

    public String hc() {
        if (l()) {
            return this.d.stringValue(3);
        }
        return null;
    }

    public String b() {
        return l() ? this.d.stringValue(8) : "";
    }

    public String c() {
        return l() ? this.d.stringValue(8003) : "";
    }

    public String u() {
        return l() ? this.d.stringValue(8005) : "";
    }

    public Function<SparseArray<Object>, Object> an() {
        if (l()) {
            return (Function) this.d.objectValue(8300, Function.class);
        }
        return null;
    }

    public boolean h() {
        PluginValueSet pluginValueSetHc;
        Function<SparseArray<Object>, Object> function = this.u;
        if (function == null || (pluginValueSetHc = com.bytedance.sdk.openadsdk.w.b.hc(function)) == null) {
            return false;
        }
        return pluginValueSetHc.booleanValue(8027);
    }

    public boolean gb() {
        PluginValueSet pluginValueSet = this.hc;
        if (pluginValueSet != null) {
            return pluginValueSet.booleanValue(8023);
        }
        return true;
    }

    public boolean tt() {
        PluginValueSet pluginValueSet = this.hc;
        if (pluginValueSet != null) {
            return pluginValueSet.booleanValue(8024);
        }
        return true;
    }

    public boolean tc() {
        PluginValueSet pluginValueSet = this.hc;
        if (pluginValueSet != null) {
            return pluginValueSet.booleanValue(8025);
        }
        return true;
    }

    public boolean mk() {
        PluginValueSet pluginValueSet = this.hc;
        if (pluginValueSet != null) {
            return pluginValueSet.booleanValue(8026);
        }
        return true;
    }

    public boolean mq() {
        return v();
    }

    public boolean uo() {
        PluginValueSet pluginValueSet = this.hc;
        if (pluginValueSet != null) {
            return pluginValueSet.booleanValue(8479);
        }
        return true;
    }

    public boolean k() {
        PluginValueSet pluginValueSetHc;
        Function<SparseArray<Object>, Object> function = this.u;
        if (function == null || (pluginValueSetHc = com.bytedance.sdk.openadsdk.w.b.hc(function)) == null) {
            return true;
        }
        return pluginValueSetHc.booleanValue(8028);
    }

    public c e() {
        if (fu() == -1.0d || fu() == -1.0d) {
            return null;
        }
        return new c() { // from class: com.bytedance.msdk.d.b.b.1
            @Override // com.bytedance.msdk.d.b.c
            public double d() {
                return b.this.fu();
            }

            @Override // com.bytedance.msdk.d.b.c
            public double hc() {
                return b.this.xp();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public double fu() {
        Function function;
        PluginValueSet pluginValueSetHc;
        PluginValueSet pluginValueSet = this.hc;
        if (pluginValueSet == null || (function = (Function) pluginValueSet.objectValue(8312, Function.class)) == null || (pluginValueSetHc = com.bytedance.sdk.openadsdk.w.b.hc(function)) == null) {
            return -1.0d;
        }
        return pluginValueSetHc.doubleValue(8481);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public double xp() {
        Function function;
        PluginValueSet pluginValueSetHc;
        PluginValueSet pluginValueSet = this.hc;
        if (pluginValueSet == null || (function = (Function) pluginValueSet.objectValue(8312, Function.class)) == null || (pluginValueSetHc = com.bytedance.sdk.openadsdk.w.b.hc(function)) == null) {
            return -1.0d;
        }
        return pluginValueSetHc.doubleValue(8482);
    }

    public String cb() {
        PluginValueSet pluginValueSet = this.hc;
        return pluginValueSet != null ? pluginValueSet.stringValue(8484) : "";
    }

    public List<String> w() {
        PluginValueSet pluginValueSetHc;
        Function<SparseArray<Object>, Object> function = this.u;
        if (function != null && (pluginValueSetHc = com.bytedance.sdk.openadsdk.w.b.hc(function)) != null) {
            return (List) pluginValueSetHc.objectValue(8477, List.class);
        }
        return new LinkedList();
    }

    public String yo() {
        PluginValueSet pluginValueSet = this.hc;
        return pluginValueSet != null ? pluginValueSet.stringValue(8485) : "";
    }

    public boolean rf() {
        PluginValueSet pluginValueSetHc;
        Function<SparseArray<Object>, Object> function = this.u;
        if (function == null || (pluginValueSetHc = com.bytedance.sdk.openadsdk.w.b.hc(function)) == null) {
            return true;
        }
        return pluginValueSetHc.booleanValue(8478);
    }

    public String jh() {
        PluginValueSet pluginValueSet = this.hc;
        return pluginValueSet != null ? pluginValueSet.stringValue(8486) : "";
    }

    public String sy() {
        PluginValueSet pluginValueSet = this.hc;
        return pluginValueSet != null ? pluginValueSet.stringValue(8487) : "";
    }

    public Map<String, Object> de() {
        PluginValueSet pluginValueSet = this.hc;
        if (pluginValueSet != null) {
            return (Map) pluginValueSet.objectValue(8554, Map.class);
        }
        return null;
    }

    public boolean v() {
        PluginValueSet pluginValueSet = this.hc;
        if (pluginValueSet != null) {
            return pluginValueSet.booleanValue(8480);
        }
        return true;
    }

    public List<String> np() {
        PluginValueSet pluginValueSetHc;
        Function<SparseArray<Object>, Object> function = this.u;
        if (function != null && (pluginValueSetHc = com.bytedance.sdk.openadsdk.w.b.hc(function)) != null) {
            return (List) pluginValueSetHc.objectValue(8476, List.class);
        }
        return new LinkedList();
    }

    public int yi() {
        return this.c.uo();
    }

    public boolean he() {
        if (l()) {
            return this.d.booleanValue(8098);
        }
        return false;
    }

    public Map vv() {
        if (l()) {
            return (Map) this.d.objectValue(8400, Map.class);
        }
        return null;
    }

    public Function<SparseArray<Object>, Object> zw() {
        if (l()) {
            return (Function) this.d.objectValue(8401, Function.class);
        }
        return null;
    }

    public boolean j() {
        PluginValueSet pluginValueSet = this.d;
        if (pluginValueSet != null) {
            return pluginValueSet.booleanValue(1);
        }
        return false;
    }

    public String s() {
        PluginValueSet pluginValueSet = this.d;
        return pluginValueSet != null ? pluginValueSet.stringValue(8411) : "";
    }

    public Map us() {
        PluginValueSet pluginValueSet = this.d;
        if (pluginValueSet != null) {
            return (Map) pluginValueSet.objectValue(8425, Map.class);
        }
        return new HashMap();
    }

    public boolean z() {
        PluginValueSet pluginValueSet = this.b;
        if (pluginValueSet != null) {
            return pluginValueSet.booleanValue(8458);
        }
        return false;
    }

    public String fs() {
        PluginValueSet pluginValueSet = this.b;
        return pluginValueSet != null ? pluginValueSet.stringValue(8459) : "";
    }

    public String ba() {
        PluginValueSet pluginValueSet = this.b;
        return pluginValueSet != null ? pluginValueSet.stringValue(8460) : "";
    }

    public boolean mt() {
        PluginValueSet pluginValueSet = this.b;
        if (pluginValueSet != null) {
            return pluginValueSet.booleanValue(8461);
        }
        return false;
    }

    public Function<SparseArray<Object>, Object> r() {
        PluginValueSet pluginValueSet = this.b;
        if (pluginValueSet != null) {
            return (Function) pluginValueSet.objectValue(8310, Function.class);
        }
        return null;
    }

    public Map hv() {
        PluginValueSet pluginValueSet = this.b;
        if (pluginValueSet != null) {
            return (Map) pluginValueSet.objectValue(8462, Map.class);
        }
        return new HashMap();
    }

    public JSONObject bc() {
        PluginValueSet pluginValueSet = this.b;
        if (pluginValueSet != null) {
            return (JSONObject) pluginValueSet.objectValue(8463, JSONObject.class);
        }
        return null;
    }

    public String dc() {
        PluginValueSet pluginValueSet = this.b;
        return pluginValueSet != null ? pluginValueSet.stringValue(8464) : "";
    }

    public boolean tr() {
        PluginValueSet pluginValueSet = this.b;
        if (pluginValueSet != null) {
            return pluginValueSet.booleanValue(8465);
        }
        return false;
    }

    public boolean nv() {
        PluginValueSet pluginValueSet = this.b;
        if (pluginValueSet != null) {
            return pluginValueSet.booleanValue(8466);
        }
        return false;
    }

    public boolean y() {
        PluginValueSet pluginValueSet = this.b;
        if (pluginValueSet != null) {
            return pluginValueSet.booleanValue(8467);
        }
        return false;
    }
}
