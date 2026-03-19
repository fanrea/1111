package com.bytedance.msdk.core.d.d.hc.d.an;

import android.app.Activity;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.msdk.core.tc.tc;
import com.bytedance.msdk.d.u.an;
import com.bytedance.sdk.component.utils.mq;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class b extends com.bytedance.msdk.hc.b {
    private com.bytedance.msdk.core.d.d.hc.d mk;
    private com.bytedance.msdk.api.d.hc mq;
    private tc tc;
    private Function<SparseArray<Object>, Object> tt;

    @Override // com.bytedance.msdk.hc.b
    public boolean cw() {
        return true;
    }

    public b(com.bytedance.msdk.core.d.d.hc.d dVar, Function<SparseArray<Object>, Object> function) {
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
        int iNz;
        if (this.tt == null) {
            return 0.0d;
        }
        com.bytedance.msdk.core.d.d.hc.d dVar = this.mk;
        if (dVar != null && dVar.b()) {
            iNz = yl();
        } else {
            iNz = nz();
        }
        return iNz;
    }

    private int yl() {
        try {
            Integer num = (Integer) an.d(new Callable<Integer>() { // from class: com.bytedance.msdk.core.d.d.hc.d.an.b.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public Integer call() throws Exception {
                    return Integer.valueOf(b.this.nz());
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
    public int nz() {
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
            String str = (String) an.d(new Callable<String>() { // from class: com.bytedance.msdk.core.d.d.hc.d.an.b.2
                @Override // java.util.concurrent.Callable
                public String call() throws Exception {
                    return b.this.eh();
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

    private void np(int i) {
        if (this.tt != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 40007);
            sparseArray.put(-99999985, Void.class);
            sparseArray.put(50007, Integer.valueOf(i));
            this.tt.apply(sparseArray);
        }
    }

    private void b(Activity activity) {
        if (this.tt != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 40008);
            sparseArray.put(-99999985, Void.class);
            sparseArray.put(50008, activity);
            this.tt.apply(sparseArray);
        }
    }

    @Override // com.bytedance.msdk.hc.b
    public void d(final Activity activity, Object obj, String str) {
        com.bytedance.msdk.core.d.d.hc.d dVar = this.mk;
        if (dVar != null && dVar.b()) {
            an.b(new Runnable() { // from class: com.bytedance.msdk.core.d.d.hc.d.an.b.3
                @Override // java.lang.Runnable
                public void run() {
                    b.this.c(activity);
                }
            });
        } else {
            c(activity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Activity activity) {
        tc tcVar = this.tc;
        if (tcVar != null && tcVar.s()) {
            np(nz());
        }
        b(activity);
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
            Integer num = (Integer) an.d(new Callable<Integer>() { // from class: com.bytedance.msdk.core.d.d.hc.d.an.b.4
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public Integer call() throws Exception {
                    return b.this.ij();
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
                an.c(new Runnable() { // from class: com.bytedance.msdk.core.d.d.hc.d.an.b.5
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.yi(iKb);
                    }
                });
            } else {
                yi(iKb);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void yi(int i) {
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
            an.c(new Runnable() { // from class: com.bytedance.msdk.core.d.d.hc.d.an.b.6
                @Override // java.lang.Runnable
                public void run() {
                    b.this.an((Map<String, Object>) map);
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
            return is();
        }
        return qo();
    }

    private String is() {
        try {
            return (String) an.d(new Callable<String>() { // from class: com.bytedance.msdk.core.d.d.hc.d.an.b.7
                @Override // java.util.concurrent.Callable
                public String call() throws Exception {
                    return b.this.qo();
                }
            }).get(500L, TimeUnit.MILLISECONDS);
        } catch (Throwable th) {
            mq.d(th);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String qo() {
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

    private com.bytedance.msdk.api.c.d.gb.d bt() {
        return (com.bytedance.msdk.api.c.d.gb.d) this.h;
    }

    @Override // com.bytedance.msdk.hc.b
    public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        if (i == 60002) {
            if (!(this.h instanceof com.bytedance.msdk.api.c.d.gb.d)) {
                return null;
            }
            bt().i_();
            return null;
        }
        if (i == 60004) {
            if (!(this.h instanceof com.bytedance.msdk.api.c.d.gb.d)) {
                return null;
            }
            bt().j_();
            return null;
        }
        if (i == 60005) {
            if (!(this.h instanceof com.bytedance.msdk.api.c.d.gb.d)) {
                return null;
            }
            bt().c();
            return null;
        }
        if (i == 60006) {
            if (!(this.h instanceof com.bytedance.msdk.api.c.d.gb.d)) {
                return null;
            }
            bt().b();
            return null;
        }
        if (i != 60007) {
            return null;
        }
        Map map = (Map) pluginValueSet.objectValue(50010, Map.class);
        if (!(this.h instanceof com.bytedance.msdk.api.c.d.gb.d)) {
            return null;
        }
        final HashMap map2 = new HashMap();
        if (map != null) {
            map2.putAll(map);
        }
        bt().d(new com.bytedance.msdk.api.b.d() { // from class: com.bytedance.msdk.core.d.d.hc.d.an.b.8
            @Override // com.bytedance.msdk.api.b.d
            public boolean d() {
                return true;
            }

            @Override // com.bytedance.msdk.api.b.d
            public float hc() {
                if (b.this.mq != null) {
                    return b.this.mq.s();
                }
                return 0.0f;
            }

            @Override // com.bytedance.msdk.api.b.d
            public String b() {
                return b.this.mq != null ? b.this.mq.j() : "";
            }

            @Override // com.bytedance.msdk.api.b.d
            public Map<String, Object> c() {
                return map2;
            }
        });
        return null;
    }
}
