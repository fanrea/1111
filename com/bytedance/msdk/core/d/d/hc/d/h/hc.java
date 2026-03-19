package com.bytedance.msdk.core.d.d.hc.d.h;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.util.SparseArray;
import android.view.ViewGroup;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.msdk.core.tc.tc;
import com.bytedance.msdk.d.hc.u;
import com.bytedance.msdk.d.u.an;
import com.bytedance.msdk.hc.b;
import com.bytedance.sdk.component.utils.mq;
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
            Integer num = (Integer) an.d(new Callable<Integer>() { // from class: com.bytedance.msdk.core.d.d.hc.d.h.hc.1
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
            String str = (String) an.d(new Callable<String>() { // from class: com.bytedance.msdk.core.d.d.hc.d.h.hc.2
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

    private void hc(ViewGroup viewGroup) {
        if (this.tt != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 40008);
            sparseArray.put(-99999985, Void.class);
            sparseArray.put(50013, viewGroup);
            this.tt.apply(sparseArray);
        }
    }

    private void b(ViewGroup viewGroup) {
        if (this.tt != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 40029);
            sparseArray.put(-99999985, Void.class);
            sparseArray.put(50013, viewGroup);
            this.tt.apply(sparseArray);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ViewGroup viewGroup) {
        if (viewGroup != null) {
            viewGroup.removeAllViews();
            Context context = viewGroup.getContext();
            if (context instanceof Activity) {
                ViewGroup viewGroup2 = (ViewGroup) ((Activity) context).findViewById(R.id.content);
                if (viewGroup.getParent() == null) {
                    if (viewGroup2 != null) {
                        viewGroup.setAlpha(0.0f);
                        viewGroup2.addView(viewGroup);
                    }
                    u(viewGroup);
                    if (viewGroup2 != null) {
                        viewGroup2.removeView(viewGroup);
                        viewGroup.setAlpha(1.0f);
                        return;
                    }
                    return;
                }
            }
            u(viewGroup);
        }
    }

    private void u(ViewGroup viewGroup) {
        tc tcVar = this.tc;
        if (tcVar != null) {
            int iTc = tcVar.tc();
            if (iTc == 2) {
                hc(viewGroup);
            } else if (iTc == 0 || iTc == 1) {
                b(viewGroup);
            }
        }
    }

    @Override // com.bytedance.msdk.hc.b
    public void d(final ViewGroup viewGroup) {
        com.bytedance.msdk.core.d.d.hc.d dVar = this.mk;
        if (dVar != null && dVar.b()) {
            an.b(new Runnable() { // from class: com.bytedance.msdk.core.d.d.hc.d.h.hc.3
                @Override // java.lang.Runnable
                public void run() {
                    hc.this.c(viewGroup);
                }
            });
        } else {
            c(viewGroup);
        }
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
            Integer num = (Integer) an.d(new Callable<Integer>() { // from class: com.bytedance.msdk.core.d.d.hc.d.h.hc.4
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
        is();
    }

    private void is() {
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
                an.c(new Runnable() { // from class: com.bytedance.msdk.core.d.d.hc.d.h.hc.5
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
            an.c(new Runnable() { // from class: com.bytedance.msdk.core.d.d.hc.d.h.hc.6
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
            return (String) an.d(new Callable<String>() { // from class: com.bytedance.msdk.core.d.d.hc.d.h.hc.7
                @Override // java.util.concurrent.Callable
                public String call() throws Exception {
                    return hc.this.bt();
                }
            }).get(500L, TimeUnit.MILLISECONDS);
        } catch (Throwable th) {
            mq.d(th);
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

    private u dd() {
        return (u) this.h;
    }

    public void d(com.bytedance.msdk.core.d.d.hc.d.an.hc hcVar) {
        String strHc;
        if (dd() != null) {
            int iD = 0;
            if (hcVar != null) {
                iD = hcVar.d();
                strHc = hcVar.hc();
            } else {
                strHc = "";
            }
            dd().d(new com.bytedance.msdk.api.d(iD, strHc));
        }
    }

    @Override // com.bytedance.msdk.hc.b
    public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        if (i == 60013) {
            if (dd() == null) {
                return null;
            }
            dd().hc(2);
            return null;
        }
        if (i == 60014) {
            dd();
            return null;
        }
        if (i == 60015) {
            dd();
            return null;
        }
        if (i == 60009) {
            if (dd() == null) {
                return null;
            }
            dd().u();
            return null;
        }
        if (i != 60004 || dd() == null) {
            return null;
        }
        dd().c();
        return null;
    }
}
