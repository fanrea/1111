package com.bytedance.msdk.core.d.d.hc.d.b;

import android.util.SparseArray;
import android.view.View;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.msdk.core.tc.tc;
import com.bytedance.msdk.d.u.an;
import com.bytedance.sdk.component.utils.mq;
import com.bytedance.sdk.openadsdk.w.c;
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

    public b(com.bytedance.msdk.core.d.d.hc.d dVar, Function<SparseArray<Object>, Object> function) {
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
        if (this.tt != null) {
            Object objApply = this.tt.apply(c.d().d(40033).d(String.class).hc());
            if (objApply instanceof String) {
                return (String) objApply;
            }
        }
        return "";
    }

    private String xq() {
        if (this.tt != null) {
            Object objApply = this.tt.apply(c.d().d(40032).d(String.class).hc());
            if (objApply instanceof String) {
                return (String) objApply;
            }
        }
        return "";
    }

    private void yl() {
        if (this.tt != null) {
            this.tt.apply(c.d().d(40022).d(Void.class).hc());
        }
    }

    private int nz() {
        if (this.tt != null) {
            Object objApply = this.tt.apply(c.d().d(40021).d(Integer.class).hc());
            if (objApply instanceof Integer) {
                return ((Integer) objApply).intValue();
            }
        }
        return 0;
    }

    private void eh() {
        if (this.tt != null) {
            this.tt.apply(c.d().d(40009).d(Void.class).d(50009, this).hc());
        }
    }

    private double ua() {
        int iBq;
        if (this.tt == null) {
            return 0.0d;
        }
        com.bytedance.msdk.core.d.d.hc.d dVar = this.mk;
        if (dVar != null && dVar.b()) {
            iBq = sz();
        } else {
            iBq = bq();
        }
        return iBq;
    }

    private int sz() {
        try {
            Integer num = (Integer) an.d(new Callable<Integer>() { // from class: com.bytedance.msdk.core.d.d.hc.d.b.b.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public Integer call() throws Exception {
                    return Integer.valueOf(b.this.bq());
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
    public int bq() {
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
            String str = (String) an.d(new Callable<String>() { // from class: com.bytedance.msdk.core.d.d.hc.d.b.b.2
                @Override // java.util.concurrent.Callable
                public String call() throws Exception {
                    return b.this.ij();
                }
            }).get(500L, TimeUnit.MILLISECONDS);
            return str != null ? str : "";
        } catch (Exception e) {
            mq.d(e);
            return "";
        }
    }

    private String qo() {
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

    @Override // com.bytedance.msdk.hc.b
    public void yo() {
        super.yo();
        com.bytedance.msdk.core.d.d.hc.d dVar = this.mk;
        if (dVar != null && dVar.b()) {
            an.b(new Runnable() { // from class: com.bytedance.msdk.core.d.d.hc.d.b.b.3
                @Override // java.lang.Runnable
                public void run() {
                    b.this.bt();
                }
            });
        } else {
            bt();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bt() {
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
                an.c(new Runnable() { // from class: com.bytedance.msdk.core.d.d.hc.d.b.b.4
                    @Override // java.lang.Runnable
                    public void run() {
                        b.this.np(iKb);
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
            an.c(new Runnable() { // from class: com.bytedance.msdk.core.d.d.hc.d.b.b.5
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
            this.tt.apply(c.d().d(40014).d(Void.class).d(50010, map).hc());
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
            return (String) an.d(new Callable<String>() { // from class: com.bytedance.msdk.core.d.d.hc.d.b.b.6
                @Override // java.util.concurrent.Callable
                public String call() throws Exception {
                    return b.this.fj();
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
        Object objApply = this.tt.apply(c.d().d(40015).d(Map.class).hc());
        return (!(objApply instanceof Map) || (obj = ((Map) objApply).get("request_id")) == null) ? "" : obj.toString();
    }

    @Override // com.bytedance.msdk.hc.b
    public boolean cw() {
        return lt();
    }

    private boolean lt() {
        if (this.tt != null) {
            Object objApply = this.tt.apply(c.d().d(40012).d(Boolean.class).hc());
            if ((objApply instanceof Boolean) && ((Boolean) objApply).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.bytedance.msdk.hc.b
    public void mk() {
        com.bytedance.msdk.core.d.d.hc.d dVar = this.mk;
        if (dVar != null && dVar.b()) {
            an.b(new Runnable() { // from class: com.bytedance.msdk.core.d.d.hc.d.b.b.7
                @Override // java.lang.Runnable
                public void run() {
                    b.this.ri();
                }
            });
        } else {
            ri();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ri() {
        if (this.tt != null) {
            this.tt.apply(c.d().d(40034).d(Void.class).hc());
        }
    }

    @Override // com.bytedance.msdk.hc.b
    public View tt() {
        tc tcVar = this.tc;
        if (tcVar != null && tcVar.s()) {
            yi(bq());
        }
        return hu();
    }

    private View hu() {
        if (this.tt != null) {
            Object objApply = this.tt.apply(c.d().d(40035).d(View.class).hc());
            if (objApply instanceof View) {
                return (View) objApply;
            }
        }
        return null;
    }

    private void yi(int i) {
        if (this.tt != null) {
            this.tt.apply(c.d().d(40007).d(50007, Integer.valueOf(i)).d(Void.class).hc());
        }
    }

    @Override // com.bytedance.msdk.hc.b
    public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        if (i == 60016) {
            View view = (View) pluginValueSet.objectValue(8042, View.class);
            if (nv() == 5) {
                if (this.an instanceof com.bytedance.msdk.api.c.d.b.c) {
                    ((com.bytedance.msdk.api.c.d.b.c) this.an).d(view, "渲染失败", 80003);
                }
            } else if (this.d instanceof com.bytedance.msdk.api.c.d.h.an) {
                ((com.bytedance.msdk.api.c.d.h.an) this.d).d(view, "渲染失败", 80003);
            }
        } else if (i == 60017) {
            int iIntValue = pluginValueSet.intValue(50014);
            int iIntValue2 = pluginValueSet.intValue(50016);
            if (nv() == 5) {
                if (this.an instanceof com.bytedance.msdk.api.c.d.b.c) {
                    ((com.bytedance.msdk.api.c.d.b.c) this.an).d(iIntValue, iIntValue2);
                }
            } else if (this.d instanceof com.bytedance.msdk.api.c.d.h.an) {
                ((com.bytedance.msdk.api.c.d.h.an) this.d).d(iIntValue, iIntValue2);
            }
        } else if (i == 60009) {
            if (nv() == 5) {
                if (this.an != null) {
                    this.an.d();
                }
            } else if (this.d != null) {
                this.d.d();
            }
        } else if (i == 60004) {
            if (nv() == 5) {
                if (this.an != null) {
                    this.an.d(null);
                }
            } else if (this.d != null) {
                this.d.d(null);
            }
        } else if (i == 60005) {
            if (this.hc != null) {
                this.hc.u();
            }
        } else if (i == 60006) {
            com.bytedance.msdk.u.an.d(this, this.mq, "gdt信息流模板dislike接口无关闭原因");
            com.bytedance.msdk.core.hc.d.d(this.mq.v());
            if (rf() != null) {
                rf().d(-1, "gdt信息流模板dislike接口无关闭原因", false);
            }
        } else if (i == 60010) {
            com.bytedance.msdk.core.d.d.hc.d.an.hc hcVar = new com.bytedance.msdk.core.d.d.hc.d.an.hc((Function) pluginValueSet.objectValue(50006, Function.class));
            if (this.hc != null) {
                this.hc.d(new com.bytedance.msdk.api.d(hcVar.d(), hcVar.hc()));
            }
        }
        return null;
    }
}
