package com.bytedance.msdk.b.b.hc.d.d;

import android.content.Context;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.msdk.api.c.d.hc.hc.d;
import com.ss.mediakit.medialoader.AVMDLDataLoader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public abstract class hc extends com.bytedance.msdk.b.b.hc.d.hc {
    protected boolean an;
    protected Function<SparseArray<Object>, Object> b;
    protected com.bytedance.msdk.b.an.hc.hc c;
    protected int gb;
    protected int h;
    protected com.bytedance.msdk.api.c.d.hc.b.b hc;
    private com.bytedance.msdk.api.d.hc mk;
    private String tc;
    private String tt;
    protected Map<String, Object> u;

    public abstract <T> T d(int i, PluginValueSet pluginValueSet, Class<T> cls);

    public hc(String str, com.bytedance.msdk.b.d.hc hcVar) {
        super(hcVar);
        this.u = new ConcurrentHashMap();
        this.an = false;
        this.h = 0;
        this.gb = 0;
        this.tc = str;
    }

    public void d(int i, String str) {
        d(new com.bytedance.msdk.api.d(i, str));
    }

    @Override // com.bytedance.msdk.b.b.hc.d.hc
    public final void hc(Context context, com.bytedance.msdk.b.an.hc.hc hcVar, com.bytedance.msdk.api.d.hc hcVar2, Map<String, Object> map) {
        this.c = hcVar;
        this.mk = hcVar2;
        this.hc = new com.bytedance.msdk.api.c.d.hc.b.b(hcVar.de(), hcVar.mq(), hcVar.k(), hcVar.e(), hcVar.ba());
        com.bytedance.msdk.api.c.d.hc.an.d dVarD = com.bytedance.msdk.an.hc.d.d(hcVar.uo());
        this.tt = dVarD != null ? dVarD.d() : "";
        com.bytedance.sdk.openadsdk.w.c cVarD = com.bytedance.sdk.openadsdk.w.c.d();
        cVarD.d(8011, this);
        if (com.bytedance.sdk.gromore.init.d.d() >= 5900) {
            cVarD.d(8009, com.bytedance.msdk.d.u.d.d(context));
        } else {
            cVarD.d(8009, context);
        }
        cVarD.d(8010, this.tc);
        cVarD.d(8546, com.bytedance.sdk.openadsdk.w.b.c.d(this.hc.d()));
        if (hcVar2.bc() != null) {
            cVarD.d(8548, com.bytedance.sdk.openadsdk.w.b.c.d(hcVar2.bc()));
        }
        Function<SparseArray<Object>, Object> functionH = com.bytedance.msdk.core.mk.d.d().h();
        if (functionH != null) {
            cVarD.d(Void.class);
            cVarD.d(8106);
            functionH.apply(cVarD.hc());
            return;
        }
        d(new com.bytedance.msdk.api.d("Adn custom class loader is null"));
    }

    @Override // com.bytedance.msdk.b.d.d
    public String d(String str) {
        return this.tt;
    }

    public void an() {
        this.an = true;
    }

    public String h() {
        com.bytedance.msdk.b.an.hc.hc hcVar = this.c;
        return hcVar != null ? hcVar.yi() : "";
    }

    public Object gb() {
        com.bytedance.msdk.b.an.hc.hc hcVar = this.c;
        return hcVar != null ? hcVar.mt() : "";
    }

    public int tt() {
        com.bytedance.msdk.b.an.hc.hc hcVar = this.c;
        if (hcVar != null) {
            return hcVar.rf();
        }
        return 0;
    }

    public void d(Map<String, Object> map) {
        if (map != null) {
            this.u.clear();
            this.u.putAll(map);
        }
    }

    public Integer tc() {
        if (this.b != null) {
            Integer numD = com.bytedance.sdk.openadsdk.core.ba.d.d.d(this.b.apply(com.bytedance.sdk.openadsdk.w.c.d().d(8121).d(Object.class).d(20068, 1).hc()));
            if (numD == null) {
                return 1;
            }
            return numD;
        }
        return 1;
    }

    public void d(boolean z, double d, int i, Map<String, Object> map) {
        if (this.b != null) {
            this.b.apply(com.bytedance.sdk.openadsdk.w.c.d().d(AVMDLDataLoader.KeyIsEnableSpeedReport).d(Void.class).d(8406, Boolean.valueOf(z)).d(8407, Double.valueOf(d)).d(8408, Integer.valueOf(i)).d(8075, map).hc());
        }
    }

    public void mk() {
        if (this.b != null) {
            this.b.apply(com.bytedance.sdk.openadsdk.w.c.d().d(8149).d(Void.class).hc());
        }
    }

    public void mq() {
        if (this.b != null) {
            this.b.apply(com.bytedance.sdk.openadsdk.w.c.d().d(8148).d(Void.class).hc());
        }
    }

    public void uo() {
        if (this.b != null) {
            this.b.apply(com.bytedance.sdk.openadsdk.w.c.d().d(8109).d(Void.class).hc());
        }
    }

    @Override // com.bytedance.msdk.b.b.hc.d.hc
    public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        if (i == 8221) {
            this.b = (Function) pluginValueSet.objectValue(8405, Function.class);
        } else {
            if (i == 8137) {
                T t = (T) h();
                com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "Adn custom loader : getAdm = ".concat(String.valueOf(t)));
                return t;
            }
            if (i == 8224) {
                T t2 = (T) gb();
                com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "Adn custom loader : getExtraDataNoParse = ".concat(String.valueOf(t2)));
                return t2;
            }
            if (i == 8226) {
                T t3 = (T) Integer.valueOf(tt());
                com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "Adn custom loader : getBiddingType = ".concat(String.valueOf(t3)));
                return t3;
            }
            if (i == 8227 && pluginValueSet != null) {
                Map<String, Object> map = (Map) pluginValueSet.objectValue(8075, Map.class);
                com.bytedance.msdk.d.u.b.hc("TTMediationSDK", "Adn custom loader : setExtraInfo map =".concat(String.valueOf(map)));
                d(map);
            }
        }
        return (T) d(i, pluginValueSet, cls);
    }

    public final void d(d.InterfaceC0213d interfaceC0213d) {
        if (!hc()) {
            com.bytedance.msdk.d.u.b.c("TTMediationSDK", "自定义Adapter 调用错误需要在load成功之后才可以调用");
        } else if (interfaceC0213d != null) {
            interfaceC0213d.d();
        }
    }

    public final void hc(d.InterfaceC0213d interfaceC0213d) {
        if (this.an) {
            int i = this.h;
            if (i < 2) {
                this.h = i + 1;
                if (interfaceC0213d != null) {
                    interfaceC0213d.d();
                    return;
                }
                return;
            }
            com.bytedance.msdk.d.u.b.c("TTMediationSDK", "自定义Adapter show方法回调次数需要小于2次");
            return;
        }
        com.bytedance.msdk.d.u.b.c("TTMediationSDK", "自定义Adapter show方法回调必须由GroMore触发show时才会生效");
    }

    public final void b(d.InterfaceC0213d interfaceC0213d) {
        int i = this.gb;
        if (i < 60) {
            this.gb = i + 1;
            if (interfaceC0213d != null) {
                interfaceC0213d.d();
                return;
            }
            return;
        }
        com.bytedance.msdk.d.u.b.c("TTMediationSDK", "自定义Adapter click方法回调次数需要小于60次");
    }

    @Override // com.bytedance.msdk.b.b.hc.d.hc
    public void d(com.bytedance.msdk.hc.b bVar) {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(bVar);
        d(arrayList);
    }

    protected void d(com.bytedance.msdk.hc.b bVar, double d, Map<String, Object> map) {
        if (d > 0.0d && tt() == 1) {
            bVar.d(d);
        }
        if (map != null) {
            this.u.putAll(map);
        }
        bVar.c(this.u);
        d(bVar);
    }

    @Override // com.bytedance.msdk.b.b.hc.d.hc, com.bytedance.msdk.b.d.hc
    public void d(List<com.bytedance.msdk.hc.b> list) {
        for (com.bytedance.msdk.hc.b bVar : list) {
            bVar.b(this.u);
            bVar.k(this.c.he());
        }
        super.d(list);
    }
}
