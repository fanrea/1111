package com.bytedance.msdk.core.d.d.hc.d.c;

import android.app.Activity;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.msdk.core.tc.tc;
import com.bytedance.msdk.d.u.an;
import com.bytedance.msdk.hc.b;
import com.bytedance.sdk.component.utils.mq;
import com.bytedance.sdk.openadsdk.w.c;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class hc extends b {
    private com.bytedance.msdk.core.d.d.hc.d mk;
    private com.bytedance.msdk.api.d.hc mq;
    private tc tc;
    private Function<SparseArray<Object>, Object> tt;

    @Override // com.bytedance.msdk.hc.b
    public boolean cw() {
        return true;
    }

    public hc(com.bytedance.msdk.core.d.d.hc.d dVar, Function<SparseArray<Object>, Object> function) {
        this.tt = function;
        this.mk = dVar;
        this.tc = dVar.hc;
        this.mq = dVar.d;
        nz();
        tc tcVar = this.tc;
        if (tcVar != null) {
            if (tcVar.us()) {
                d(eh());
            } else if (this.tc.fs()) {
                k(bq());
            }
        }
        if (yl() == 2) {
            mk(5);
            xq();
            g();
        }
    }

    private void g() {
        if (this.tt != null) {
            this.tt.apply(c.d().d(40023).d(Void.class).hc());
        }
    }

    private void xq() {
        if (this.tt != null) {
            this.tt.apply(c.d().d(40022).d(Void.class).hc());
        }
    }

    private int yl() {
        if (this.tt != null) {
            Object objApply = this.tt.apply(c.d().d(40021).d(Void.class).hc());
            if (objApply instanceof Integer) {
                return ((Integer) objApply).intValue();
            }
        }
        return 0;
    }

    private void nz() {
        if (this.tt != null) {
            this.tt.apply(c.d().d(40009).d(50009, this).d(Void.class).hc());
        }
    }

    private double eh() {
        int iUa;
        if (this.tt == null) {
            return 0.0d;
        }
        com.bytedance.msdk.core.d.d.hc.d dVar = this.mk;
        if (dVar != null && dVar.b()) {
            iUa = sz();
        } else {
            iUa = ua();
        }
        return iUa;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int ua() {
        Function<SparseArray<Object>, Object> function = this.tt;
        if (function == null) {
            return 0;
        }
        Object objApply = function.apply(c.d().d(40003).d(Integer.class).hc());
        int iIntValue = objApply instanceof Integer ? ((Integer) objApply).intValue() : 0;
        if (iIntValue == -1) {
            return 0;
        }
        return iIntValue;
    }

    private int sz() {
        try {
            Integer num = (Integer) an.d(new Callable<Integer>() { // from class: com.bytedance.msdk.core.d.d.hc.d.c.hc.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public Integer call() throws Exception {
                    return Integer.valueOf(hc.this.ua());
                }
            }).get(500L, TimeUnit.MILLISECONDS);
            if (num != null) {
                return num.intValue();
            }
            return 0;
        } catch (Exception e) {
            mq.d(e);
            return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String bq() {
        com.bytedance.msdk.core.d.d.hc.d dVar = this.mk;
        if (dVar != null && dVar.b()) {
            return ij();
        }
        return is();
    }

    private String ij() {
        try {
            String str = (String) an.d(new Callable<String>() { // from class: com.bytedance.msdk.core.d.d.hc.d.c.hc.2
                @Override // java.util.concurrent.Callable
                public String call() throws Exception {
                    return hc.this.bq();
                }
            }).get(500L, TimeUnit.MILLISECONDS);
            return str != null ? str : "";
        } catch (Exception e) {
            mq.d(e);
            return "";
        }
    }

    private String is() {
        Function<SparseArray<Object>, Object> function = this.tt;
        if (function == null) {
            return "";
        }
        Object objApply = function.apply(c.d().d(40004).d(String.class).hc());
        if (objApply instanceof String) {
            return objApply.toString();
        }
        return null;
    }

    private void b(Activity activity) {
        Function<SparseArray<Object>, Object> function = this.tt;
        if (function != null) {
            function.apply(c.d().d(40008).d(50008, activity).d(String.class).hc());
        }
    }

    @Override // com.bytedance.msdk.hc.b
    public void d(final Activity activity, Object obj, String str) {
        com.bytedance.msdk.core.d.d.hc.d dVar = this.mk;
        if (dVar != null && dVar.b()) {
            an.b(new Runnable() { // from class: com.bytedance.msdk.core.d.d.hc.d.c.hc.3
                @Override // java.lang.Runnable
                public void run() {
                    hc.this.c(activity);
                }
            });
        } else {
            c(activity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Activity activity) {
        b(activity);
    }

    @Override // com.bytedance.msdk.hc.b
    public Integer an() {
        com.bytedance.msdk.core.d.d.hc.d dVar = this.mk;
        if (dVar != null && dVar.b()) {
            return qo();
        }
        return bt();
    }

    private Integer qo() {
        try {
            Integer num = (Integer) an.d(new Callable<Integer>() { // from class: com.bytedance.msdk.core.d.d.hc.d.c.hc.4
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public Integer call() throws Exception {
                    return hc.this.bt();
                }
            }).get(500L, TimeUnit.MILLISECONDS);
            if (num != null) {
                return num;
            }
            return 4;
        } catch (Exception e) {
            mq.d(e);
            return 4;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Integer bt() {
        if (this.tt != null) {
            Object objApply = this.tt.apply(c.d().d(40010).d(Boolean.class).hc());
            if ((objApply instanceof Boolean) && ((Boolean) objApply).booleanValue()) {
                return 2;
            }
        }
        return 4;
    }

    @Override // com.bytedance.msdk.hc.b
    public void yo() {
        super.yo();
        com.bytedance.msdk.core.d.d.hc.d dVar = this.mk;
        if (dVar != null && dVar.b()) {
            an.b(new Runnable() { // from class: com.bytedance.msdk.core.d.d.hc.d.c.hc.5
                @Override // java.lang.Runnable
                public void run() {
                    hc.this.dd();
                }
            });
        } else {
            dd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dd() {
        if (this.tt != null) {
            this.tt.apply(c.d().d(40011).d(Void.class).hc());
        }
    }

    @Override // com.bytedance.msdk.hc.b
    public boolean u() {
        if (this.tt != null) {
            Object objApply = this.tt.apply(c.d().d(40012).d(Boolean.class).hc());
            if ((objApply instanceof Boolean) && ((Boolean) objApply).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.bytedance.msdk.hc.b
    public void hc(Map<String, Object> map) {
        tc tcVar = this.tc;
        if (tcVar != null && tcVar.us()) {
            final int iKb = (int) kb();
            com.bytedance.msdk.core.d.d.hc.d dVar = this.mk;
            if (dVar != null && dVar.b()) {
                an.c(new Runnable() { // from class: com.bytedance.msdk.core.d.d.hc.d.c.hc.6
                    @Override // java.lang.Runnable
                    public void run() {
                        hc.this.np(iKb);
                    }
                });
            } else {
                np(iKb);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void np(int i) {
        if (this.tt != null) {
            this.tt.apply(c.d().d(40013).d(Void.class).d(50007, Integer.valueOf(i)).hc());
        }
    }

    @Override // com.bytedance.msdk.hc.b
    public void d(final Map<String, Object> map) {
        tc tcVar = this.tc;
        if (tcVar == null || !tcVar.us() || map == null) {
            return;
        }
        com.bytedance.msdk.core.d.d.hc.d dVar = this.mk;
        if (dVar != null && dVar.b()) {
            an.c(new Runnable() { // from class: com.bytedance.msdk.core.d.d.hc.d.c.hc.7
                @Override // java.lang.Runnable
                public void run() {
                    hc.this.an((Map<String, Object>) map);
                }
            });
        } else {
            an(map);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void an(Map<String, Object> map) {
        if (this.tt != null) {
            this.tt.apply(c.d().d(40014).d(Void.class).d(50010, map).hc());
        }
    }

    @Override // com.bytedance.msdk.hc.b
    public String ai() {
        com.bytedance.msdk.core.d.d.hc.d dVar = this.mk;
        if (dVar != null && dVar.b()) {
            return fj();
        }
        return lt();
    }

    private String fj() {
        try {
            return (String) an.d(new Callable<String>() { // from class: com.bytedance.msdk.core.d.d.hc.d.c.hc.8
                @Override // java.util.concurrent.Callable
                public String call() throws Exception {
                    return hc.this.lt();
                }
            }).get(500L, TimeUnit.MILLISECONDS);
        } catch (Throwable th) {
            mq.d(th);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String lt() {
        Object obj;
        if (this.tt == null) {
            return "";
        }
        Object objApply = this.tt.apply(c.d().d(40015).d(Map.class).hc());
        return (!(objApply instanceof Map) || (obj = ((Map) objApply).get("request_id")) == null) ? "" : obj.toString();
    }

    private com.bytedance.msdk.api.c.d.c.d ri() {
        return (com.bytedance.msdk.api.c.d.c.d) this.h;
    }

    @Override // com.bytedance.msdk.hc.b
    public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        return (T) call(i, pluginValueSet, cls);
    }

    public <T> T call(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        if (i == 60009) {
            if (ri() == null) {
                return null;
            }
            ri().g_();
            return null;
        }
        if (i == 60004) {
            if (ri() == null) {
                return null;
            }
            ri().h_();
            return null;
        }
        if (i == 60005) {
            if (ri() == null) {
                return null;
            }
            ri().c();
            return null;
        }
        if (i == 60006) {
            if (ri() == null) {
                return null;
            }
            ri().b();
            return null;
        }
        if (i == 60010) {
            if (ri() == null) {
                return null;
            }
            ri().u();
            return null;
        }
        if (i != 60007) {
            return null;
        }
        Map map = (Map) pluginValueSet.objectValue(50010, Map.class);
        if (ri() == null) {
            return null;
        }
        final HashMap map2 = new HashMap();
        if (map != null) {
            map2.putAll(map);
        }
        ri().d(new com.bytedance.msdk.api.b.d() { // from class: com.bytedance.msdk.core.d.d.hc.d.c.hc.9
            @Override // com.bytedance.msdk.api.b.d
            public boolean d() {
                return true;
            }

            @Override // com.bytedance.msdk.api.b.d
            public float hc() {
                if (hc.this.mq != null) {
                    return hc.this.mq.s();
                }
                return 0.0f;
            }

            @Override // com.bytedance.msdk.api.b.d
            public String b() {
                return hc.this.mq != null ? hc.this.mq.j() : "";
            }

            @Override // com.bytedance.msdk.api.b.d
            public Map<String, Object> c() {
                return map2;
            }
        });
        return null;
    }
}
