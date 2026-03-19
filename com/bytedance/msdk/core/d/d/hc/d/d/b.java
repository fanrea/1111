package com.bytedance.msdk.core.d.d.hc.d.d;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.gromore.R;
import com.bytedance.msdk.core.tc.tc;
import com.bytedance.msdk.d.u.an;
import com.bytedance.sdk.component.utils.mq;
import java.util.ArrayList;
import java.util.List;
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
        ka();
        de(tb());
        v(jg());
        hc(hu());
        jh((int) hu());
        np(ri());
        yi(lt());
        he(fj());
        mq(dd());
        us(bt());
        z(qo());
        j(is());
        vv(ij());
        zw(bq());
        yo(sz());
        yo(ua());
        d(eh());
        c(nz());
        fs(bt());
        gb(yl());
        tc tcVar = this.tc;
        if (tcVar != null) {
            if (tcVar.us()) {
                d(nu());
            } else if (this.tc.fs()) {
                k(zg());
            }
        }
        if (x() == 2) {
            mk(5);
        } else if (x() != 1 && x() != 4 && x() == 3) {
            mk(4);
        } else {
            mk(3);
        }
        if (yl()) {
            mq(4);
        } else {
            mq(3);
        }
        h(false);
    }

    @Override // com.bytedance.msdk.hc.b
    public int c() {
        com.bytedance.msdk.core.d.d.hc.d dVar = this.mk;
        if (dVar != null && dVar.b()) {
            return g();
        }
        return xq();
    }

    private int g() {
        try {
            Integer num = (Integer) an.d(new Callable<Integer>() { // from class: com.bytedance.msdk.core.d.d.hc.d.d.b.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public Integer call() throws Exception {
                    return Integer.valueOf(b.this.xq());
                }
            }).get(500L, TimeUnit.MILLISECONDS);
            if (num != null) {
                return num.intValue();
            }
            return 1;
        } catch (Exception e) {
            mq.d(e);
            return 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int xq() {
        if (this.tt != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 40053);
            sparseArray.put(-99999985, Integer.class);
            Object objApply = this.tt.apply(sparseArray);
            int iIntValue = objApply instanceof Integer ? ((Integer) objApply).intValue() : -1;
            if (iIntValue == 0) {
                return 0;
            }
            if (iIntValue == 1) {
                return 6;
            }
            if (iIntValue == 2) {
                return 8;
            }
            if (iIntValue == 4) {
                return 2;
            }
            if (iIntValue == 8) {
                return 5;
            }
            if (iIntValue == 16) {
                return 4;
            }
            if (iIntValue == 32) {
                return 3;
            }
            if (iIntValue == 64) {
                return 7;
            }
        }
        return 1;
    }

    private boolean yl() {
        if (this.tt == null) {
            return false;
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 40052);
        sparseArray.put(-99999985, Boolean.class);
        return ((Boolean) this.tt.apply(sparseArray)).booleanValue();
    }

    private double nz() {
        if (this.tt != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 40051);
            sparseArray.put(-99999985, Integer.class);
            Object objApply = this.tt.apply(sparseArray);
            if (objApply instanceof Integer) {
                return ((Double) objApply).doubleValue();
            }
        }
        return 0.0d;
    }

    private List<String> eh() {
        if (this.tt != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 40050);
            sparseArray.put(-99999985, List.class);
            Object objApply = this.tt.apply(sparseArray);
            if (objApply instanceof List) {
                return (List) objApply;
            }
        }
        return null;
    }

    private int ua() {
        if (this.tt != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 40049);
            sparseArray.put(-99999985, Integer.class);
            Object objApply = this.tt.apply(sparseArray);
            if (objApply instanceof Integer) {
                return ((Integer) objApply).intValue();
            }
        }
        return 0;
    }

    private int sz() {
        if (this.tt != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 40048);
            sparseArray.put(-99999985, Integer.class);
            Object objApply = this.tt.apply(sparseArray);
            if (objApply instanceof Integer) {
                return ((Integer) objApply).intValue();
            }
        }
        return 0;
    }

    private String bq() {
        if (this.tt == null) {
            return "";
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 40047);
        sparseArray.put(-99999985, String.class);
        return (String) this.tt.apply(sparseArray);
    }

    private String ij() {
        if (this.tt == null) {
            return "";
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 40046);
        sparseArray.put(-99999985, String.class);
        return (String) this.tt.apply(sparseArray);
    }

    private String is() {
        if (this.tt == null) {
            return "";
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 40045);
        sparseArray.put(-99999985, String.class);
        return (String) this.tt.apply(sparseArray);
    }

    private String qo() {
        if (this.tt == null) {
            return "";
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 40033);
        sparseArray.put(-99999985, String.class);
        return (String) this.tt.apply(sparseArray);
    }

    private String bt() {
        if (this.tt == null) {
            return "";
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 40032);
        sparseArray.put(-99999985, String.class);
        return (String) this.tt.apply(sparseArray);
    }

    private String dd() {
        if (this.tt == null) {
            return "";
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 40044);
        sparseArray.put(-99999985, String.class);
        return (String) this.tt.apply(sparseArray);
    }

    private String fj() {
        if (this.tt == null) {
            return "";
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 40043);
        sparseArray.put(-99999985, String.class);
        return (String) this.tt.apply(sparseArray);
    }

    private String lt() {
        if (this.tt == null) {
            return "";
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 40042);
        sparseArray.put(-99999985, String.class);
        return (String) this.tt.apply(sparseArray);
    }

    private String ri() {
        if (this.tt == null) {
            return "";
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 40041);
        sparseArray.put(-99999985, String.class);
        return (String) this.tt.apply(sparseArray);
    }

    private long hu() {
        if (this.tt == null) {
            return 0L;
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 40040);
        sparseArray.put(-99999985, Long.class);
        return ((Long) this.tt.apply(sparseArray)).longValue();
    }

    private String jg() {
        if (this.tt == null) {
            return "";
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 40039);
        sparseArray.put(-99999985, String.class);
        return (String) this.tt.apply(sparseArray);
    }

    private String tb() {
        if (this.tt == null) {
            return "";
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 40038);
        sparseArray.put(-99999985, String.class);
        return (String) this.tt.apply(sparseArray);
    }

    private int x() {
        if (this.tt == null) {
            return 0;
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 40021);
        sparseArray.put(-99999985, Integer.class);
        return ((Integer) this.tt.apply(sparseArray)).intValue();
    }

    private void ka() {
        if (this.tt != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 40009);
            sparseArray.put(-99999985, Void.class);
            sparseArray.put(50009, this);
            this.tt.apply(sparseArray);
        }
    }

    private double nu() {
        int iSs;
        if (this.tt == null) {
            return 0.0d;
        }
        com.bytedance.msdk.core.d.d.hc.d dVar = this.mk;
        if (dVar != null && dVar.b()) {
            iSs = a();
        } else {
            iSs = ss();
        }
        return iSs;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int ss() {
        if (this.tt == null) {
            return 0;
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 40003);
        sparseArray.put(-99999985, Integer.class);
        int iIntValue = ((Integer) this.tt.apply(sparseArray)).intValue();
        if (iIntValue == -1) {
            return 0;
        }
        return iIntValue;
    }

    private int a() {
        try {
            Integer num = (Integer) an.d(new Callable<Integer>() { // from class: com.bytedance.msdk.core.d.d.hc.d.d.b.6
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public Integer call() throws Exception {
                    return Integer.valueOf(b.this.ss());
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
    public String zg() {
        com.bytedance.msdk.core.d.d.hc.d dVar = this.mk;
        if (dVar != null && dVar.b()) {
            return ol();
        }
        return ii();
    }

    private String ol() {
        try {
            String str = (String) an.d(new Callable<String>() { // from class: com.bytedance.msdk.core.d.d.hc.d.d.b.7
                @Override // java.util.concurrent.Callable
                public String call() throws Exception {
                    return b.this.zg();
                }
            }).get(500L, TimeUnit.MILLISECONDS);
            return str != null ? str : "";
        } catch (Exception e) {
            mq.d(e);
            return "";
        }
    }

    private String ii() {
        if (this.tt == null) {
            return "";
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 40004);
        sparseArray.put(-99999985, String.class);
        return (String) this.tt.apply(sparseArray);
    }

    @Override // com.bytedance.msdk.hc.b
    public void d(final Activity activity, final ViewGroup viewGroup, final List<View> list, final List<View> list2, final List<View> list3, final com.bytedance.msdk.api.c.d.h.tc tcVar, List<View> list4) {
        super.d(activity, viewGroup, list, list2, list3, tcVar, list4);
        com.bytedance.msdk.core.d.d.hc.d dVar = this.mk;
        if (dVar != null && dVar.b()) {
            an.b(new Runnable() { // from class: com.bytedance.msdk.core.d.d.hc.d.d.b.8
                @Override // java.lang.Runnable
                public void run() {
                    b.this.d(activity, viewGroup, (List<View>) list, (List<View>) list2, (List<View>) list3, tcVar);
                }
            });
        } else {
            d(activity, viewGroup, list, list2, list3, tcVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(Context context, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, com.bytedance.msdk.api.c.d.h.tc tcVar) {
        ViewGroup viewGroupHc;
        FrameLayout frameLayoutD;
        Object tag;
        if (list3 != null) {
            if (list2 == null) {
                list2 = new ArrayList<>();
            }
            list2.addAll(list3);
        }
        List<View> list4 = list2;
        tc tcVar2 = this.tc;
        if (tcVar2 != null && tcVar2.s()) {
            np(ss());
        }
        if (context == null) {
            context = viewGroup.getContext();
        }
        int i = 0;
        if (viewGroup.getChildCount() != 0 && b(viewGroup.getChildAt(0))) {
            viewGroupHc = (ViewGroup) viewGroup.getChildAt(0);
            while (i < viewGroupHc.getChildCount()) {
                View childAt = viewGroupHc.getChildAt(i);
                if (childAt == null || ((tag = childAt.getTag(R.id.tt_mediation_gdt_developer_view_tag_key)) != null && (tag instanceof String) && ((String) tag).equals("tt_gdt_developer_view"))) {
                    i++;
                } else {
                    viewGroupHc.removeView(childAt);
                }
            }
        } else {
            viewGroupHc = hc(context);
            if (viewGroupHc != null) {
                viewGroupHc.setTag(R.id.tt_mediation_gdt_developer_view_root_tag_key, "tt_gdt_developer_view_root");
                while (viewGroup.getChildCount() > 0) {
                    View childAt2 = viewGroup.getChildAt(0);
                    childAt2.setTag(R.id.tt_mediation_gdt_developer_view_tag_key, "tt_gdt_developer_view");
                    viewGroup.removeViewInLayout(childAt2);
                    if (childAt2 != null) {
                        viewGroupHc.addView(childAt2, childAt2.getLayoutParams());
                    }
                }
                viewGroup.removeAllViews();
                viewGroup.addView(viewGroupHc, -1, -1);
            }
        }
        ViewGroup viewGroup2 = viewGroupHc;
        FrameLayout frameLayout = (FrameLayout) viewGroup.findViewById(tcVar.h);
        d(context, viewGroup2, ji(), list, list4);
        if (frameLayout != null && ar() == 5 && (frameLayoutD = d(context)) != null) {
            frameLayout.removeAllViews();
            frameLayout.addView(frameLayoutD, -1, -1);
            d(frameLayoutD);
        }
        if (!TextUtils.isEmpty(is())) {
            View viewFindViewById = viewGroup.findViewById(tcVar.c);
            ArrayList arrayList = new ArrayList();
            arrayList.add(viewFindViewById);
            hc(arrayList);
        }
        qi();
    }

    private void qi() {
        if (this.tt != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 40060);
            sparseArray.put(-99999985, Void.class);
            this.tt.apply(sparseArray);
        }
    }

    private void hc(List<View> list) {
        if (this.tt != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 40059);
            sparseArray.put(-99999985, Void.class);
            sparseArray.put(50021, list);
            this.tt.apply(sparseArray);
        }
    }

    private void d(FrameLayout frameLayout) {
        Object obj;
        if (this.tt != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 40058);
            sparseArray.put(-99999985, Void.class);
            sparseArray.put(50013, frameLayout);
            com.bytedance.msdk.api.d.hc hcVar = this.mq;
            if (hcVar != null && hcVar.hv() != null && (obj = this.mq.hv().get("key_gdt_video_option")) != null) {
                sparseArray.put(50020, obj);
            }
            this.tt.apply(sparseArray);
        }
    }

    private FrameLayout d(Context context) {
        if (this.tt == null || context == null) {
            return null;
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 40057);
        sparseArray.put(-99999985, FrameLayout.class);
        sparseArray.put(10000, context);
        return (FrameLayout) this.tt.apply(sparseArray);
    }

    private void d(Context context, ViewGroup viewGroup, FrameLayout.LayoutParams layoutParams, List<View> list, List<View> list2) {
        if (this.tt == null || context == null) {
            return;
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 40056);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(10000, context);
        sparseArray.put(50013, viewGroup);
        sparseArray.put(50017, layoutParams);
        sparseArray.put(50018, list);
        sparseArray.put(50019, list2);
        this.tt.apply(sparseArray);
    }

    private FrameLayout.LayoutParams ji() {
        com.bytedance.msdk.api.d.hc hcVar = this.mq;
        if (hcVar == null || hcVar.hv() == null) {
            return null;
        }
        Object obj = this.mq.hv().get("key_gdt_native_logo_params");
        if (obj instanceof FrameLayout.LayoutParams) {
            return (FrameLayout.LayoutParams) obj;
        }
        return null;
    }

    private ViewGroup hc(Context context) {
        if (this.tt == null || context == null) {
            return null;
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 40055);
        sparseArray.put(-99999985, ViewGroup.class);
        sparseArray.put(10000, context);
        return (ViewGroup) this.tt.apply(sparseArray);
    }

    private boolean b(View view) {
        if (this.tt == null) {
            return false;
        }
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 40055);
        sparseArray.put(-99999985, Boolean.class);
        sparseArray.put(50013, view);
        return ((Boolean) this.tt.apply(sparseArray)).booleanValue();
    }

    private void np(int i) {
        if (this.tt != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 40007);
            sparseArray.put(-99999985, Boolean.class);
            sparseArray.put(50007, Integer.valueOf(i));
            this.tt.apply(sparseArray);
        }
    }

    @Override // com.bytedance.msdk.hc.b
    public Integer an() {
        com.bytedance.msdk.core.d.d.hc.d dVar = this.mk;
        if (dVar != null && dVar.b()) {
            return tl();
        }
        return nx();
    }

    private Integer tl() {
        try {
            Integer num = (Integer) an.d(new Callable<Integer>() { // from class: com.bytedance.msdk.core.d.d.hc.d.d.b.9
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public Integer call() throws Exception {
                    return b.this.nx();
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
    public Integer nx() {
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
        an.b(new Runnable() { // from class: com.bytedance.msdk.core.d.d.hc.d.d.b.10
            @Override // java.lang.Runnable
            public void run() {
                b.this.qa();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qa() {
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
                an.c(new Runnable() { // from class: com.bytedance.msdk.core.d.d.hc.d.d.b.11
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
            an.c(new Runnable() { // from class: com.bytedance.msdk.core.d.d.hc.d.d.b.12
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
            return pk();
        }
        return jw();
    }

    private String pk() {
        try {
            return (String) an.d(new Callable<String>() { // from class: com.bytedance.msdk.core.d.d.hc.d.d.b.13
                @Override // java.util.concurrent.Callable
                public String call() throws Exception {
                    return b.this.jw();
                }
            }).get(500L, TimeUnit.MILLISECONDS);
        } catch (Throwable th) {
            mq.d(th);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String jw() {
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
    public void w() {
        com.bytedance.msdk.core.d.d.hc.d dVar = this.mk;
        if (dVar != null && dVar.b()) {
            an.b(new Runnable() { // from class: com.bytedance.msdk.core.d.d.hc.d.d.b.2
                @Override // java.lang.Runnable
                public void run() {
                    b.this.le();
                }
            });
        } else {
            le();
        }
    }

    @Override // com.bytedance.msdk.hc.b
    public void cb() {
        com.bytedance.msdk.core.d.d.hc.d dVar = this.mk;
        if (dVar != null && dVar.b()) {
            an.b(new Runnable() { // from class: com.bytedance.msdk.core.d.d.hc.d.d.b.3
                @Override // java.lang.Runnable
                public void run() {
                    b.this.re();
                }
            });
        } else {
            re();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void le() {
        if (this.tt != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 40061);
            sparseArray.put(-99999985, Void.class);
            this.tt.apply(sparseArray);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void re() {
        if (this.tt != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 40062);
            sparseArray.put(-99999985, Void.class);
            this.tt.apply(sparseArray);
        }
    }

    @Override // com.bytedance.msdk.hc.b
    public void d() {
        com.bytedance.msdk.core.d.d.hc.d dVar = this.mk;
        if (dVar != null && dVar.b()) {
            an.c(new Runnable() { // from class: com.bytedance.msdk.core.d.d.hc.d.d.b.4
                @Override // java.lang.Runnable
                public void run() {
                    b.this.cs();
                }
            });
        } else {
            cs();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cs() {
        if (this.tt != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 40063);
            sparseArray.put(-99999985, Void.class);
            this.tt.apply(sparseArray);
        }
    }

    @Override // com.bytedance.msdk.hc.b
    public void hc() {
        com.bytedance.msdk.core.d.d.hc.d dVar = this.mk;
        if (dVar != null && dVar.b()) {
            an.c(new Runnable() { // from class: com.bytedance.msdk.core.d.d.hc.d.d.b.5
                @Override // java.lang.Runnable
                public void run() {
                    b.this.bk();
                }
            });
        } else {
            bk();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bk() {
        if (this.tt != null) {
            SparseArray<Object> sparseArray = new SparseArray<>();
            sparseArray.put(-99999987, 40064);
            sparseArray.put(-99999985, Void.class);
            this.tt.apply(sparseArray);
        }
    }

    private com.bytedance.msdk.api.c.d.d.d ww() {
        return (com.bytedance.msdk.api.c.d.d.d) this.h;
    }

    @Override // com.bytedance.msdk.hc.b
    public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        if (i == 60004) {
            if (this.h instanceof com.bytedance.msdk.api.c.d.d.d) {
                ww().d((View) null);
            }
        } else if (i == 60009 && (this.h instanceof com.bytedance.msdk.api.c.d.d.d)) {
            ww().hc(null);
        }
        return null;
    }
}
