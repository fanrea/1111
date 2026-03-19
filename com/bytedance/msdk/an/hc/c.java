package com.bytedance.msdk.an.hc;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.msdk.api.c.k;
import com.bytedance.sdk.component.utils.mq;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Function;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class c extends com.bytedance.sdk.openadsdk.core.ba.c implements com.bytedance.msdk.d.d.c {
    private com.bytedance.msdk.api.c.b an;
    private String b;
    private b d;
    private Function<SparseArray<Object>, Object> hc;
    private Function<SparseArray<Object>, Object> u;
    private List<com.bytedance.msdk.d.d.b> c = new CopyOnWriteArrayList();
    private long h = 0;
    private int gb = 0;

    @Override // com.bytedance.msdk.d.d.c
    public String b() {
        return null;
    }

    public c() {
        b bVarD = b.d(com.bytedance.msdk.core.d.mk().y());
        this.d = bVarD;
        this.hc = bVarD.d();
    }

    @Override // com.bytedance.msdk.d.d.hc
    public void d(Context context, Map<String, Object> map, com.bytedance.msdk.d.d.b bVar) {
        if (!this.c.contains(bVar)) {
            this.c.add(bVar);
        }
        com.bytedance.sdk.openadsdk.w.c cVarD = com.bytedance.sdk.openadsdk.w.c.d();
        u.d(cVarD);
        cVarD.d(3, map.get(com.alipay.sdk.m.k.b.D0));
        cVarD.d(8550, Boolean.valueOf(com.bytedance.msdk.core.d.mk().yi()));
        cVarD.d(8, com.bytedance.msdk.core.d.mk().sy());
        cVarD.d(8005, map.get(com.alipay.sdk.m.l.b.h));
        String str = (String) map.get("adn_name");
        this.b = str;
        cVarD.d(8010, d(str));
        cVarD.d(8560, hc(this.b));
        cVarD.d(8003, map.get("adn_name"));
        cVarD.d(8410, "3.3.76.5.4");
        cVarD.d(8411, com.bytedance.msdk.hc.hc.b());
        cVarD.d(8412, "17.2.0.70");
        cVarD.d(8413, "9.3905.5");
        cVarD.d(8414, "4.640.1510.4");
        cVarD.d(8415, "2.11.0.3.31");
        cVarD.d(8417, "4.22.2.4");
        cVarD.d(8418, "4.3.0.37");
        cVarD.d(8416, "16.6.57.13");
        cVarD.d(8558, "2.11.0.3.31");
        cVarD.d(7, Integer.valueOf(tt()));
        cVarD.d(8425, map);
        cVarD.d(8300, this);
        try {
            Function<SparseArray<Object>, Object> functionB = com.bytedance.msdk.core.d.d.u.b(this.b);
            if (functionB != null) {
                this.u = functionB;
                functionB.apply(com.bytedance.sdk.openadsdk.w.c.d().d(8240).d(Void.class).d(8009, context).d(8424, cVarD.hc()).hc());
            } else {
                cVarD.d(8100).d(Void.class);
                this.hc.apply(cVarD.hc());
            }
        } catch (Throwable th) {
            mq.d(th);
        }
    }

    private int tt() {
        com.bytedance.msdk.d.b.b bVarHc = com.bytedance.msdk.core.d.mk().hc();
        if (bVarHc != null) {
            return bVarHc.yi();
        }
        return 0;
    }

    public static String d(String str) {
        str.hashCode();
        switch (str) {
            case "klevin":
                return "com.bytedance.msdk.adapter.klevin.KlevinAdapterConfiguration";
            case "sigmob":
                return "com.bytedance.msdk.adapter.sigmob.SigmobAdapterConfiguration";
            case "xiaomi":
                return "com.bytedance.msdk.adapter.xiaomi.XiaomiAdapterConfiguration";
            case "ks":
                return "com.bytedance.msdk.adapter.ks.KsAdapterConfiguration";
            case "gdt":
                return "com.bytedance.msdk.adapter.gdt.GdtAdapterConfiguration";
            case "admob":
                return "com.bytedance.msdk.adapter.admob.AdmobAdapterConfiguration";
            case "baidu":
                return "com.bytedance.msdk.adapter.baidu.BaiduAdapterConfiguration";
            case "unity":
                return "com.bytedance.msdk.adapter.unity.UnityAdapterConfiguration";
            case "mintegral":
                return "com.bytedance.msdk.adapter.mintegral.MintegralAdapterConfiguration";
            default:
                return null;
        }
    }

    public static String hc(String str) {
        str.hashCode();
        switch (str) {
            case "sigmob":
                return "a.b.c.d.e.f.sob.SobFunction";
            case "xiaomi":
                return "a.b.c.d.e.f.xmi.XmiFunction";
            case "ks":
                return "a.b.c.d.e.f.kou.KouFunction";
            case "gdt":
                return "a.b.c.d.e.f.gng.GngFunction";
            case "admob":
                return "a.b.c.d.e.f.aob.AobFunction";
            case "baidu":
                return "a.b.c.d.e.f.bdu.BduFunction";
            case "unity":
                return "a.b.c.d.e.f.uty.UtyFunction";
            case "mintegral":
                return "a.b.c.d.e.f.mal.MalFunction";
            default:
                return null;
        }
    }

    @Override // com.bytedance.msdk.d.d.c
    public String d() {
        Function<SparseArray<Object>, Object> function = this.u;
        if (function != null) {
            Object objApply = function.apply(com.bytedance.sdk.openadsdk.w.c.d().d(8101).d(String.class).hc());
            if (objApply instanceof String) {
                return (String) objApply;
            }
        }
        return "";
    }

    @Override // com.bytedance.msdk.d.d.c
    public String d(Context context, Map<String, Object> map) {
        if (this.u != null) {
            Object objApply = this.u.apply(com.bytedance.sdk.openadsdk.w.c.d().d(8102).d(String.class).d(8009, context).d(8006, map).hc());
            if (objApply instanceof String) {
                return (String) objApply;
            }
        }
        return null;
    }

    @Override // com.bytedance.msdk.d.d.c
    public Map<String, Object> hc(Context context, Map<String, Object> map) {
        if (this.u != null) {
            Object objApply = this.u.apply(com.bytedance.sdk.openadsdk.w.c.d().d(8103).d(String.class).d(8009, context).d(8006, map).hc());
            if (objApply instanceof Map) {
                return (Map) objApply;
            }
        }
        return null;
    }

    public String gb() {
        return this.b;
    }

    @Override // com.bytedance.msdk.d.d.c
    public String hc() {
        try {
            Function<SparseArray<Object>, Object> function = this.u;
            if (function != null) {
                Object objApply = function.apply(com.bytedance.sdk.openadsdk.w.c.d().d(8104).d(String.class).hc());
                return objApply instanceof String ? (String) objApply : "";
            }
        } catch (Throwable th) {
            mq.d(th);
        }
        return "";
    }

    @Override // com.bytedance.msdk.d.d.c
    public void d(Map<String, Object> map) {
        Function<SparseArray<Object>, Object> function = this.u;
        if (function != null) {
            function.apply(com.bytedance.sdk.openadsdk.w.c.d().d(8242).d(Void.class).d(8006, map).hc());
        }
    }

    @Override // com.bytedance.msdk.d.d.c
    public int d(com.bytedance.msdk.api.c.b bVar) {
        Function<SparseArray<Object>, Object> function = this.u;
        if (function != null) {
            this.an = bVar;
            Object objApply = function.apply(com.bytedance.sdk.openadsdk.w.c.d().d(8126).d(Integer.class).hc());
            if (objApply != null) {
                return ((Integer) objApply).intValue();
            }
        }
        return 0;
    }

    @Override // com.bytedance.msdk.d.d.c
    public void d(k kVar, SparseArray<Object> sparseArray) {
        Function<SparseArray<Object>, Object> function = this.u;
        if (function == null || kVar == null) {
            return;
        }
        function.apply(com.bytedance.sdk.openadsdk.w.c.d().d(8124).d(Void.class).d(8517, sparseArray).hc());
    }

    @Override // com.bytedance.msdk.d.d.c
    public void c() {
        try {
            if (com.bytedance.msdk.core.d.d.u.b(gb()) != null) {
                tc();
            } else {
                mk();
            }
        } catch (Exception e) {
            mq.d(e);
        }
    }

    private void tc() {
        com.bytedance.msdk.d.u.b.hc("TTMediationSDK_SDK_Init", gb() + "版本号：" + hc() + " , 聚合版本号：" + com.bytedance.sdk.gromore.init.d.b());
    }

    private void mk() {
        String strB = com.bytedance.sdk.gromore.init.d.b();
        if (!TextUtils.isEmpty(d())) {
            com.bytedance.msdk.d.u.b.hc("TTMediationSDK_SDK_Init", gb() + "版本号：" + hc() + " , " + gb() + "Adapter版本号：" + d() + " , 聚合版本号：" + strB);
        } else {
            com.bytedance.msdk.d.u.b.c("TTMediationSDK_SDK_Init", gb() + "版本号：" + hc() + " , ***" + gb() + "Adapter未接入，请检查***, 聚合版本号：" + strB);
        }
    }

    @Override // com.bytedance.msdk.d.d.c
    public long u() {
        return this.h;
    }

    @Override // com.bytedance.msdk.d.d.c
    public int an() {
        return this.gb;
    }

    @Override // com.bytedance.msdk.d.d.c
    public void h() {
        this.gb = 0;
        this.h = 0L;
    }

    private void mq() {
        Iterator<com.bytedance.msdk.d.d.b> it = this.c.iterator();
        while (it.hasNext()) {
            it.next().d();
        }
        this.c.clear();
    }

    private void d(com.bytedance.msdk.api.d dVar) {
        Iterator<com.bytedance.msdk.d.d.b> it = this.c.iterator();
        while (it.hasNext()) {
            it.next().d(dVar);
        }
        this.c.clear();
    }

    public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        if (i == 8122) {
            this.u = (Function) pluginValueSet.objectValue(8021, Function.class);
            mq();
        } else if (i == 8123) {
            SparseArray sparseArray = (SparseArray) pluginValueSet.objectValue(-99999979, SparseArray.class);
            if (sparseArray == null) {
                sparseArray = (SparseArray) pluginValueSet.objectValue(-999902, SparseArray.class);
            }
            if (sparseArray == null) {
                sparseArray = (SparseArray) pluginValueSet.objectValue(8022, SparseArray.class);
            }
            if (sparseArray != null) {
                PluginValueSet pluginValueSetHc = com.bykv.d.d.d.d.d.d((SparseArray<Object>) sparseArray).hc();
                d(new com.bytedance.msdk.api.d(pluginValueSetHc.intValue(-999900), pluginValueSetHc.stringValue(-999901)));
                return null;
            }
        } else if (i == 8212) {
            if (this.an != null) {
                this.an.d(pluginValueSet.intValue(8095));
            }
        } else if (i == 8266) {
            this.u = (Function) pluginValueSet.objectValue(8021, Function.class);
        } else if (i == 8270) {
            this.gb = pluginValueSet.intValue(8557);
            this.h = pluginValueSet.longValue(8556) - pluginValueSet.longValue(8555);
        }
        return null;
    }
}
