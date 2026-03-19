package com.bytedance.msdk.core.d.d.hc.d.d;

import android.util.SparseArray;
import android.view.View;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.msdk.core.tc.tc;
import com.bytedance.msdk.d.u.an;
import com.bytedance.sdk.component.utils.mq;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class c extends com.bytedance.msdk.hc.b {
    private com.bytedance.msdk.core.d.d.hc.d mk;
    private com.bytedance.msdk.api.d.hc mq;
    private tc tc;
    private Function<SparseArray<Object>, Object> tt;

    public c(com.bytedance.msdk.core.d.d.hc.d dVar, Function<SparseArray<Object>, Object> function) {
        this.tt = function;
        this.mk = dVar;
        this.tc = dVar.hc;
        this.mq = dVar.d;
        eh();
        if (nz() == 2) {
            mk(5);
            yl();
        } else if (nz() != 1 && nz() != 4 && nz() == 3) {
            mk(4);
        } else {
            mk(3);
        }
        h(true);
        us(xq());
        z(g());
        mq(3);
        tc tcVar = this.tc;
        if (tcVar != null) {
            if (tcVar.us()) {
                d(ua());
            } else if (this.tc.fs()) {
                k(ij());
            }
        }
    }

    private String g() {
        if (this.tt == null) {
            return "";
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 40033);
        sparseArray.put(-99999985, String.class);
        return (String) this.tt.apply(sparseArray);
    }

    private String xq() {
        if (this.tt == null) {
            return "";
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 40032);
        sparseArray.put(-99999985, String.class);
        return (String) this.tt.apply(sparseArray);
    }

    private void yl() {
        if (this.tt != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 40022);
            sparseArray.put(-99999985, Void.class);
            this.tt.apply(sparseArray);
        }
    }

    private int nz() {
        if (this.tt == null) {
            return 0;
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 40021);
        sparseArray.put(-99999985, Integer.class);
        return ((Integer) this.tt.apply(sparseArray)).intValue();
    }

    private void eh() {
        if (this.tt != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 40009);
            sparseArray.put(-99999985, Void.class);
            sparseArray.put(50009, this);
            this.tt.apply(sparseArray);
        }
    }

    private double ua() {
        int iSz;
        if (this.tt == null) {
            return 0.0d;
        }
        com.bytedance.msdk.core.d.d.hc.d dVar = this.mk;
        if (dVar != null && dVar.b()) {
            iSz = bq();
        } else {
            iSz = sz();
        }
        return iSz;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int sz() {
        if (this.tt == null) {
            return 0;
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 40003);
        sparseArray.put(-99999985, Integer.class);
        Object objApply = this.tt.apply(sparseArray);
        if (objApply instanceof Integer) {
            Integer num = (Integer) objApply;
            if (num.intValue() != -1) {
                return num.intValue();
            }
        }
        return 0;
    }

    private int bq() {
        try {
            Integer num = (Integer) an.d(new Callable<Integer>() { // from class: com.bytedance.msdk.core.d.d.hc.d.d.c.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public Integer call() throws Exception {
                    return Integer.valueOf(c.this.sz());
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
    public String ij() {
        com.bytedance.msdk.core.d.d.hc.d dVar = this.mk;
        if (dVar != null && dVar.b()) {
            return is();
        }
        return qo();
    }

    private String is() {
        try {
            String str = (String) an.d(new Callable<String>() { // from class: com.bytedance.msdk.core.d.d.hc.d.d.c.2
                @Override // java.util.concurrent.Callable
                public String call() throws Exception {
                    return c.this.ij();
                }
            }).get(500L, TimeUnit.MILLISECONDS);
            return str != null ? str : "";
        } catch (Exception e) {
            mq.d(e);
            return "";
        }
    }

    private String qo() {
        if (this.tt == null) {
            return "";
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 40004);
        sparseArray.put(-99999985, String.class);
        return (String) this.tt.apply(sparseArray);
    }

    @Override // com.bytedance.msdk.hc.b
    public void yo() {
        super.yo();
        com.bytedance.msdk.core.d.d.hc.d dVar = this.mk;
        if (dVar != null && dVar.b()) {
            an.b(new Runnable() { // from class: com.bytedance.msdk.core.d.d.hc.d.d.c.3
                @Override // java.lang.Runnable
                public void run() {
                    c.this.bt();
                }
            });
        } else {
            bt();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bt() {
        if (this.tt != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 40011);
            sparseArray.put(-99999985, Void.class);
            this.tt.apply(sparseArray);
        }
    }

    @Override // com.bytedance.msdk.hc.b
    public boolean u() {
        if (this.tt == null) {
            return false;
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 40012);
        sparseArray.put(-99999985, Boolean.class);
        return ((Boolean) this.tt.apply(sparseArray)).booleanValue();
    }

    @Override // com.bytedance.msdk.hc.b
    public void hc(Map<String, Object> map) {
        tc tcVar = this.tc;
        if (tcVar != null && tcVar.us()) {
            final int iKb = (int) kb();
            com.bytedance.msdk.core.d.d.hc.d dVar = this.mk;
            if (dVar != null && dVar.b()) {
                an.c(new Runnable() { // from class: com.bytedance.msdk.core.d.d.hc.d.d.c.4
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.np(iKb);
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
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 40013);
            sparseArray.put(-99999985, Void.class);
            sparseArray.put(50007, Integer.valueOf(i));
            this.tt.apply(sparseArray);
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
            an.c(new Runnable() { // from class: com.bytedance.msdk.core.d.d.hc.d.d.c.5
                @Override // java.lang.Runnable
                public void run() {
                    c.this.an((Map<String, Object>) map);
                }
            });
        } else {
            an(map);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void an(Map<String, Object> map) {
        if (this.tt != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 40014);
            sparseArray.put(-99999985, Void.class);
            sparseArray.put(50010, map);
            this.tt.apply(sparseArray);
        }
    }

    @Override // com.bytedance.msdk.hc.b
    public String ai() {
        com.bytedance.msdk.core.d.d.hc.d dVar = this.mk;
        if (dVar != null && dVar.b()) {
            return dd();
        }
        return fj();
    }

    private String dd() {
        try {
            return (String) an.d(new Callable<String>() { // from class: com.bytedance.msdk.core.d.d.hc.d.d.c.6
                @Override // java.util.concurrent.Callable
                public String call() throws Exception {
                    return c.this.fj();
                }
            }).get(500L, TimeUnit.MILLISECONDS);
        } catch (Throwable th) {
            mq.d(th);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String fj() {
        Object obj;
        if (this.tt == null) {
            return "";
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 40015);
        sparseArray.put(-99999985, Map.class);
        Object objApply = this.tt.apply(sparseArray);
        return (!(objApply instanceof Map) || (obj = ((Map) objApply).get("request_id")) == null) ? "" : obj.toString();
    }

    @Override // com.bytedance.msdk.hc.b
    public boolean cw() {
        return lt();
    }

    private boolean lt() {
        if (this.tt == null) {
            return false;
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 40012);
        sparseArray.put(-99999985, Boolean.class);
        return ((Boolean) this.tt.apply(sparseArray)).booleanValue();
    }

    @Override // com.bytedance.msdk.hc.b
    public void mk() {
        com.bytedance.msdk.core.d.d.hc.d dVar = this.mk;
        if (dVar != null && dVar.b()) {
            an.b(new Runnable() { // from class: com.bytedance.msdk.core.d.d.hc.d.d.c.7
                @Override // java.lang.Runnable
                public void run() {
                    c.this.ri();
                }
            });
        } else {
            ri();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ri() {
        if (this.tt != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 40034);
            sparseArray.put(-99999985, Boolean.class);
            this.tt.apply(sparseArray);
        }
    }

    @Override // com.bytedance.msdk.hc.b
    public View tt() {
        tc tcVar = this.tc;
        if (tcVar != null && tcVar.s()) {
            yi(sz());
        }
        return hu();
    }

    private View hu() {
        if (this.tt != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 40035);
            sparseArray.put(-99999985, View.class);
            Object objApply = this.tt.apply(sparseArray);
            if (objApply != null) {
                return (View) objApply;
            }
        }
        return null;
    }

    private void yi(int i) {
        if (this.tt != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 40007);
            sparseArray.put(-99999985, Boolean.class);
            sparseArray.put(50007, Integer.valueOf(i));
            this.tt.apply(sparseArray);
        }
    }

    private com.bytedance.msdk.api.c.d.d.d jg() {
        return (com.bytedance.msdk.api.c.d.d.d) this.h;
    }

    @Override // com.bytedance.msdk.hc.b
    public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        if (i == 60009) {
            if (this.h instanceof com.bytedance.msdk.api.c.d.d.d) {
                jg().hc(null);
            }
        } else if (i == 60004) {
            if (this.h instanceof com.bytedance.msdk.api.c.d.d.d) {
                jg().d((View) null);
            }
        } else if (i == 60006 && (this.h instanceof com.bytedance.msdk.api.c.d.d.d)) {
            com.bytedance.msdk.api.d.hc hcVar = this.mq;
            if (hcVar != null) {
                com.bytedance.msdk.core.hc.d.d(hcVar.v());
            }
            jg().f_();
        }
        return null;
    }
}
