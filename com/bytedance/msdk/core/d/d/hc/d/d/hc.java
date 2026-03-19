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
public class hc extends com.bytedance.msdk.hc.b {
    private com.bytedance.msdk.core.d.d.hc.d mk;
    private com.bytedance.msdk.api.d.hc mq;
    private tc tc;
    private Function<SparseArray<Object>, Object> tt;
    private volatile boolean uo = false;

    public hc(com.bytedance.msdk.core.d.d.hc.d dVar, Function<SparseArray<Object>, Object> function) {
        this.tt = function;
        this.mk = dVar;
        this.tc = dVar.hc;
        this.mq = dVar.d;
        g();
        tc tcVar = this.tc;
        if (tcVar != null) {
            if (tcVar.us()) {
                d(xq());
            } else if (this.tc.fs()) {
                k(eh());
            }
        }
    }

    private void g() {
        if (this.tt != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 40009);
            sparseArray.put(-99999985, Void.class);
            sparseArray.put(50009, this);
            this.tt.apply(sparseArray);
        }
    }

    private double xq() {
        int iYl;
        if (this.tt == null) {
            return 0.0d;
        }
        com.bytedance.msdk.core.d.d.hc.d dVar = this.mk;
        if (dVar != null && dVar.b()) {
            iYl = nz();
        } else {
            iYl = yl();
        }
        return iYl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int yl() {
        if (this.tt == null) {
            return 0;
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 40003);
        sparseArray.put(-99999985, Integer.class);
        Object objApply = this.tt.apply(sparseArray);
        int iIntValue = objApply instanceof Integer ? ((Integer) objApply).intValue() : 0;
        if (iIntValue == -1) {
            return 0;
        }
        return iIntValue;
    }

    private int nz() {
        try {
            Integer num = (Integer) an.d(new Callable<Integer>() { // from class: com.bytedance.msdk.core.d.d.hc.d.d.hc.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public Integer call() throws Exception {
                    return Integer.valueOf(hc.this.yl());
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
    public String eh() {
        com.bytedance.msdk.core.d.d.hc.d dVar = this.mk;
        if (dVar != null && dVar.b()) {
            return ua();
        }
        return sz();
    }

    private String ua() {
        try {
            String str = (String) an.d(new Callable<String>() { // from class: com.bytedance.msdk.core.d.d.hc.d.d.hc.2
                @Override // java.util.concurrent.Callable
                public String call() throws Exception {
                    return hc.this.eh();
                }
            }).get(500L, TimeUnit.MILLISECONDS);
            return str != null ? str : "";
        } catch (Exception e) {
            mq.d(e);
            return "";
        }
    }

    private String sz() {
        if (this.tt == null) {
            return "";
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 40004);
        sparseArray.put(-99999985, String.class);
        Object objApply = this.tt.apply(sparseArray);
        if (objApply instanceof String) {
            return (String) objApply;
        }
        return null;
    }

    @Override // com.bytedance.msdk.hc.b
    public Integer an() {
        com.bytedance.msdk.core.d.d.hc.d dVar = this.mk;
        if (dVar != null && dVar.b()) {
            return bq();
        }
        return ij();
    }

    private Integer bq() {
        try {
            Integer num = (Integer) an.d(new Callable<Integer>() { // from class: com.bytedance.msdk.core.d.d.hc.d.d.hc.3
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public Integer call() throws Exception {
                    return hc.this.ij();
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
    public Integer ij() {
        if (this.tt != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 40010);
            sparseArray.put(-99999985, Boolean.class);
            if (((Boolean) this.tt.apply(sparseArray)).booleanValue()) {
                return 2;
            }
        }
        return 4;
    }

    @Override // com.bytedance.msdk.hc.b
    public void yo() {
        super.yo();
        this.uo = true;
        an.b(new Runnable() { // from class: com.bytedance.msdk.core.d.d.hc.d.d.hc.4
            @Override // java.lang.Runnable
            public void run() {
                hc.this.is();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void is() {
        if (this.tt != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 40011);
            sparseArray.put(-99999985, Void.class);
            this.tt.apply(sparseArray);
        }
    }

    @Override // com.bytedance.msdk.hc.b
    public boolean u() {
        return this.uo;
    }

    @Override // com.bytedance.msdk.hc.b
    public void hc(Map<String, Object> map) {
        tc tcVar = this.tc;
        if (tcVar != null && tcVar.us()) {
            final int iKb = (int) kb();
            com.bytedance.msdk.core.d.d.hc.d dVar = this.mk;
            if (dVar != null && dVar.b()) {
                an.c(new Runnable() { // from class: com.bytedance.msdk.core.d.d.hc.d.d.hc.5
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
            an.c(new Runnable() { // from class: com.bytedance.msdk.core.d.d.hc.d.d.hc.6
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
            return qo();
        }
        return bt();
    }

    private String qo() {
        try {
            return (String) an.d(new Callable<String>() { // from class: com.bytedance.msdk.core.d.d.hc.d.d.hc.7
                @Override // java.util.concurrent.Callable
                public String call() throws Exception {
                    return hc.this.bt();
                }
            }).get(500L, TimeUnit.MILLISECONDS);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String bt() {
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

    private com.bytedance.msdk.api.c.d.d.d dd() {
        return (com.bytedance.msdk.api.c.d.d.d) this.h;
    }

    @Override // com.bytedance.msdk.hc.b
    public View tt() {
        return fj();
    }

    private View fj() {
        if (this.tt != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 40035);
            sparseArray.put(-99999985, View.class);
            Object objApply = this.tt.apply(sparseArray);
            if (objApply instanceof View) {
                return (View) objApply;
            }
        }
        return null;
    }

    @Override // com.bytedance.msdk.hc.b
    public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        if (i == 60009) {
            if (this.h instanceof com.bytedance.msdk.api.c.d.d.d) {
                dd().hc(null);
            }
        } else if (i == 60006) {
            if (this.h instanceof com.bytedance.msdk.api.c.d.d.d) {
                com.bytedance.msdk.api.d.hc hcVar = this.mq;
                if (hcVar != null) {
                    com.bytedance.msdk.core.hc.d.d(hcVar.v());
                }
                dd().f_();
            }
        } else if (i == 60004 && (this.h instanceof com.bytedance.msdk.api.c.d.d.d)) {
            dd().d((View) null);
        }
        return null;
    }
}
