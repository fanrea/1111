package com.bytedance.msdk.core.d.d.hc.d.u;

import android.app.Activity;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.msdk.core.tc.tc;
import com.bytedance.msdk.d.u.an;
import com.bytedance.msdk.hc.b;
import com.bytedance.sdk.component.utils.mq;
import com.bytedance.sdk.openadsdk.w.c;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class hc extends b {
    private com.bytedance.msdk.core.d.d.hc.d mk;
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
        xq();
        tc tcVar = this.tc;
        if (tcVar != null) {
            if (tcVar.us()) {
                d(yl());
            } else if (this.tc.fs()) {
                k(ua());
            }
        }
        if (g() == 2) {
            mk(5);
        } else {
            mk(3);
        }
    }

    private int g() {
        Function<SparseArray<Object>, Object> function = this.tt;
        if (function != null) {
            Object objApply = function.apply(c.d().d(40021).d(Integer.class).hc());
            if (objApply instanceof Integer) {
                return ((Integer) objApply).intValue();
            }
        }
        return 0;
    }

    private void xq() {
        Function<SparseArray<Object>, Object> function = this.tt;
        if (function != null) {
            function.apply(c.d().d(40009).d(50009, this).d(Integer.class).hc());
        }
    }

    private double yl() {
        int iNz;
        if (this.tt == null) {
            return 0.0d;
        }
        com.bytedance.msdk.core.d.d.hc.d dVar = this.mk;
        if (dVar != null && dVar.b()) {
            iNz = eh();
        } else {
            iNz = nz();
        }
        return iNz;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int nz() {
        Function<SparseArray<Object>, Object> function = this.tt;
        if (function == null) {
            return 0;
        }
        Object objApply = function.apply(c.d().d(40003).d(Integer.class).hc());
        if (objApply instanceof Integer) {
            Integer num = (Integer) objApply;
            if (num.intValue() != -1) {
                return num.intValue();
            }
        }
        return 0;
    }

    private int eh() {
        try {
            Integer num = (Integer) an.d(new Callable<Integer>() { // from class: com.bytedance.msdk.core.d.d.hc.d.u.hc.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public Integer call() throws Exception {
                    return Integer.valueOf(hc.this.nz());
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
    public String ua() {
        com.bytedance.msdk.core.d.d.hc.d dVar = this.mk;
        if (dVar != null && dVar.b()) {
            return sz();
        }
        return bq();
    }

    private String sz() {
        try {
            String str = (String) an.d(new Callable<String>() { // from class: com.bytedance.msdk.core.d.d.hc.d.u.hc.2
                @Override // java.util.concurrent.Callable
                public String call() throws Exception {
                    return hc.this.ua();
                }
            }).get(500L, TimeUnit.MILLISECONDS);
            return str != null ? str : "";
        } catch (Exception e) {
            mq.d(e);
            return "";
        }
    }

    private String bq() {
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
            function.apply(c.d().d(40008).d(50008, activity).d(Void.class).hc());
        }
    }

    @Override // com.bytedance.msdk.hc.b
    public void d(final Activity activity, Object obj, String str) {
        if (activity == null || activity.isFinishing()) {
            return;
        }
        com.bytedance.msdk.core.d.d.hc.d dVar = this.mk;
        if (dVar != null && dVar.b()) {
            an.b(new Runnable() { // from class: com.bytedance.msdk.core.d.d.hc.d.u.hc.3
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
            return ij();
        }
        return is();
    }

    private Integer ij() {
        try {
            Integer num = (Integer) an.d(new Callable<Integer>() { // from class: com.bytedance.msdk.core.d.d.hc.d.u.hc.4
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public Integer call() throws Exception {
                    return hc.this.is();
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
    public Integer is() {
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
            an.b(new Runnable() { // from class: com.bytedance.msdk.core.d.d.hc.d.u.hc.5
                @Override // java.lang.Runnable
                public void run() {
                    hc.this.qo();
                }
            });
        } else {
            qo();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qo() {
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
                an.c(new Runnable() { // from class: com.bytedance.msdk.core.d.d.hc.d.u.hc.6
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
            an.c(new Runnable() { // from class: com.bytedance.msdk.core.d.d.hc.d.u.hc.7
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
            return bt();
        }
        return dd();
    }

    private String bt() {
        try {
            return (String) an.d(new Callable<String>() { // from class: com.bytedance.msdk.core.d.d.hc.d.u.hc.8
                @Override // java.util.concurrent.Callable
                public String call() throws Exception {
                    return hc.this.dd();
                }
            }).get(500L, TimeUnit.MILLISECONDS);
        } catch (Throwable th) {
            mq.d(th);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String dd() {
        Object obj;
        if (this.tt == null) {
            return "";
        }
        Object objApply = this.tt.apply(c.d().d(40015).d(Map.class).hc());
        return (!(objApply instanceof Map) || (obj = ((Map) objApply).get("request_id")) == null) ? "" : obj.toString();
    }

    private com.bytedance.msdk.api.c.d.u.d fj() {
        return (com.bytedance.msdk.api.c.d.u.d) this.h;
    }

    @Override // com.bytedance.msdk.hc.b
    public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        if (i == 60011) {
            if (fj() == null) {
                return null;
            }
            fj().c();
            return null;
        }
        if (i == 60009) {
            if (fj() == null) {
                return null;
            }
            fj().d();
            return null;
        }
        if (i == 60004) {
            if (fj() == null) {
                return null;
            }
            fj().hc();
            return null;
        }
        if (i == 60012) {
            if (fj() == null) {
                return null;
            }
            fj().u();
            return null;
        }
        if (i != 60006 || fj() == null) {
            return null;
        }
        fj().b();
        return null;
    }
}
