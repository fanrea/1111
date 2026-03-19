package com.bytedance.msdk.core.d.d.hc.d.b;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.gromore.R;
import com.bytedance.msdk.core.tc.tc;
import com.bytedance.msdk.d.u.an;
import com.bytedance.sdk.component.utils.mq;
import com.bytedance.sdk.openadsdk.w.c;
import java.util.ArrayList;
import java.util.List;
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
    private Context uo;

    @Override // com.bytedance.msdk.hc.b
    public boolean cw() {
        return true;
    }

    public hc(Context context, com.bytedance.msdk.core.d.d.hc.d dVar, Function<SparseArray<Object>, Object> function) {
        this.uo = context;
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
            Integer num = (Integer) an.d(new Callable<Integer>() { // from class: com.bytedance.msdk.core.d.d.hc.d.b.hc.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public Integer call() throws Exception {
                    return Integer.valueOf(hc.this.xq());
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
            Object objApply = this.tt.apply(c.d().d(40053).d(Void.class).hc());
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
        Function<SparseArray<Object>, Object> function = this.tt;
        if (function != null) {
            Object objApply = function.apply(c.d().d(40052).d(Boolean.class).hc());
            if ((objApply instanceof Boolean) && ((Boolean) objApply).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    private double nz() {
        Function<SparseArray<Object>, Object> function = this.tt;
        if (function != null) {
            Object objApply = function.apply(c.d().d(40051).d(Integer.class).hc());
            if (objApply instanceof Integer) {
                return ((Double) objApply).doubleValue();
            }
        }
        return 0.0d;
    }

    private List<String> eh() {
        Function<SparseArray<Object>, Object> function = this.tt;
        if (function != null) {
            Object objApply = function.apply(c.d().d(40050).d(List.class).hc());
            if (objApply instanceof List) {
                return (List) objApply;
            }
        }
        return null;
    }

    private int ua() {
        Function<SparseArray<Object>, Object> function = this.tt;
        if (function != null) {
            Object objApply = function.apply(c.d().d(40049).d(Integer.class).hc());
            if (objApply instanceof Integer) {
                return ((Integer) objApply).intValue();
            }
        }
        return 0;
    }

    private int sz() {
        Function<SparseArray<Object>, Object> function = this.tt;
        if (function != null) {
            Object objApply = function.apply(c.d().d(40048).d(Integer.class).hc());
            if (objApply instanceof Integer) {
                return ((Integer) objApply).intValue();
            }
        }
        return 0;
    }

    private String bq() {
        Function<SparseArray<Object>, Object> function = this.tt;
        if (function == null) {
            return "";
        }
        Object objApply = function.apply(c.d().d(40047).d(String.class).hc());
        if (objApply instanceof String) {
            return (String) objApply;
        }
        return null;
    }

    private String ij() {
        Function<SparseArray<Object>, Object> function = this.tt;
        if (function == null) {
            return "";
        }
        Object objApply = function.apply(c.d().d(40046).d(String.class).hc());
        if (objApply instanceof String) {
            return (String) objApply;
        }
        return null;
    }

    private String is() {
        Function<SparseArray<Object>, Object> function = this.tt;
        if (function == null) {
            return "";
        }
        Object objApply = function.apply(c.d().d(40045).d(String.class).hc());
        if (objApply instanceof String) {
            return (String) objApply;
        }
        return null;
    }

    private String qo() {
        Function<SparseArray<Object>, Object> function = this.tt;
        if (function == null) {
            return "";
        }
        Object objApply = function.apply(c.d().d(40033).d(String.class).hc());
        if (objApply instanceof String) {
            return (String) objApply;
        }
        return null;
    }

    private String bt() {
        Function<SparseArray<Object>, Object> function = this.tt;
        if (function == null) {
            return "";
        }
        Object objApply = function.apply(c.d().d(40032).d(String.class).hc());
        if (objApply instanceof String) {
            return (String) objApply;
        }
        return null;
    }

    private String dd() {
        Function<SparseArray<Object>, Object> function = this.tt;
        if (function == null) {
            return "";
        }
        Object objApply = function.apply(c.d().d(40044).d(String.class).hc());
        if (objApply instanceof String) {
            return (String) objApply;
        }
        return null;
    }

    private String fj() {
        Function<SparseArray<Object>, Object> function = this.tt;
        if (function == null) {
            return "";
        }
        Object objApply = function.apply(c.d().d(40043).d(String.class).hc());
        if (objApply instanceof String) {
            return (String) objApply;
        }
        return null;
    }

    private String lt() {
        Function<SparseArray<Object>, Object> function = this.tt;
        if (function == null) {
            return "";
        }
        Object objApply = function.apply(c.d().d(40042).d(String.class).hc());
        if (objApply instanceof String) {
            return (String) objApply;
        }
        return null;
    }

    private String ri() {
        Function<SparseArray<Object>, Object> function = this.tt;
        if (function == null) {
            return "";
        }
        Object objApply = function.apply(c.d().d(40041).d(String.class).hc());
        if (objApply instanceof String) {
            return (String) objApply;
        }
        return null;
    }

    private long hu() {
        Function<SparseArray<Object>, Object> function = this.tt;
        if (function != null) {
            Object objApply = function.apply(c.d().d(40040).d(Long.class).hc());
            if (objApply instanceof Long) {
                return ((Long) objApply).longValue();
            }
        }
        return 0L;
    }

    private String jg() {
        Function<SparseArray<Object>, Object> function = this.tt;
        if (function == null) {
            return "";
        }
        Object objApply = function.apply(c.d().d(40039).d(Long.class).hc());
        if (objApply instanceof String) {
            return (String) objApply;
        }
        return null;
    }

    private String tb() {
        Function<SparseArray<Object>, Object> function = this.tt;
        if (function == null) {
            return "";
        }
        Object objApply = function.apply(c.d().d(40038).d(Long.class).hc());
        if (objApply instanceof String) {
            return (String) objApply;
        }
        return null;
    }

    private int x() {
        Function<SparseArray<Object>, Object> function = this.tt;
        if (function != null) {
            Object objApply = function.apply(c.d().d(40021).d(Integer.class).hc());
            if (objApply instanceof Integer) {
                return ((Integer) objApply).intValue();
            }
        }
        return 0;
    }

    private void ka() {
        Function<SparseArray<Object>, Object> function = this.tt;
        if (function != null) {
            function.apply(c.d().d(40009).d(50009, this).d(Integer.class).hc());
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

    private int a() {
        try {
            Integer num = (Integer) an.d(new Callable<Integer>() { // from class: com.bytedance.msdk.core.d.d.hc.d.b.hc.7
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public Integer call() throws Exception {
                    return Integer.valueOf(hc.this.ss());
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
            String str = (String) an.d(new Callable<String>() { // from class: com.bytedance.msdk.core.d.d.hc.d.b.hc.8
                @Override // java.util.concurrent.Callable
                public String call() throws Exception {
                    return hc.this.zg();
                }
            }).get(500L, TimeUnit.MILLISECONDS);
            return str != null ? str : "";
        } catch (Exception e) {
            mq.d(e);
            return "";
        }
    }

    private String ii() {
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
    public void d(final Activity activity, final ViewGroup viewGroup, final List<View> list, final List<View> list2, final List<View> list3, final com.bytedance.msdk.api.c.d.h.tc tcVar, List<View> list4) {
        super.d(activity, viewGroup, list, list2, list3, tcVar, list4);
        com.bytedance.msdk.core.d.d.hc.d dVar = this.mk;
        if (dVar != null && dVar.b()) {
            an.b(new Runnable() { // from class: com.bytedance.msdk.core.d.d.hc.d.b.hc.9
                @Override // java.lang.Runnable
                public void run() {
                    hc.this.d(activity, viewGroup, (List<View>) list, (List<View>) list2, (List<View>) list3, tcVar);
                }
            });
        } else {
            d(activity, viewGroup, list, list2, list3, tcVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(Context context, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, com.bytedance.msdk.api.c.d.h.tc tcVar) {
        ViewGroup viewGroupHc;
        Object tag;
        if (list3 != null) {
            if (list2 == null) {
                list2 = new ArrayList<>();
            }
            list2.addAll(list3);
        }
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
        d(context, viewGroupHc, ji(), list, list2);
        if (tcVar != null) {
            d(context, viewGroup, tcVar);
        } else {
            hc(list2);
        }
        qi();
    }

    private void d(Context context, ViewGroup viewGroup, com.bytedance.msdk.api.c.d.h.tc tcVar) {
        FrameLayout frameLayoutD;
        if (viewGroup == null || tcVar == null) {
            return;
        }
        FrameLayout frameLayout = (FrameLayout) viewGroup.findViewById(tcVar.h);
        if (frameLayout != null && ar() == 5 && (frameLayoutD = d(context)) != null) {
            frameLayout.removeAllViews();
            frameLayout.addView(frameLayoutD, -1, -1);
            d(frameLayoutD);
        }
        if (TextUtils.isEmpty(is())) {
            return;
        }
        View viewFindViewById = viewGroup.findViewById(tcVar.c);
        ArrayList arrayList = new ArrayList();
        arrayList.add(viewFindViewById);
        b(arrayList);
    }

    private void hc(List<View> list) {
        if (TextUtils.isEmpty(is())) {
            return;
        }
        b(list);
    }

    @Override // com.bytedance.msdk.hc.b
    public View tc() {
        if (!(com.bytedance.msdk.d.u.d.d(this.uo) instanceof Context)) {
            return null;
        }
        final FrameLayout frameLayoutD = d(this.uo);
        if (frameLayoutD != null) {
            frameLayoutD.removeAllViews();
            frameLayoutD.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            if (frameLayoutD.getViewTreeObserver() != null) {
                frameLayoutD.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.bytedance.msdk.core.d.d.hc.d.b.hc.10
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    public void onGlobalLayout() {
                        if (frameLayoutD.getVisibility() == 0) {
                            hc.this.d(frameLayoutD);
                            if (frameLayoutD.getViewTreeObserver() != null) {
                                frameLayoutD.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                            }
                        }
                    }
                });
            }
        }
        return frameLayoutD;
    }

    private void qi() {
        Function<SparseArray<Object>, Object> function = this.tt;
        if (function != null) {
            function.apply(c.d().d(40060).d(Void.class).hc());
        }
    }

    private void b(List<View> list) {
        Function<SparseArray<Object>, Object> function = this.tt;
        if (function != null) {
            function.apply(c.d().d(40059).d(50021, list).d(Void.class).hc());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(FrameLayout frameLayout) {
        Object obj;
        if (this.tt != null) {
            c cVarD = c.d().d(40058).d(50013, frameLayout).d(Void.class);
            com.bytedance.msdk.api.d.hc hcVar = this.mq;
            if (hcVar != null && hcVar.hv() != null && (obj = this.mq.hv().get("key_gdt_video_option")) != null) {
                cVarD.d(50020, obj);
            }
            this.tt.apply(cVarD.hc());
        }
    }

    private FrameLayout d(Context context) {
        Function<SparseArray<Object>, Object> function = this.tt;
        if (function != null && context != null) {
            Object objApply = function.apply(c.d().d(40057).d(10000, context).d(FrameLayout.class).hc());
            if (objApply instanceof FrameLayout) {
                return (FrameLayout) objApply;
            }
        }
        return null;
    }

    private void d(Context context, ViewGroup viewGroup, FrameLayout.LayoutParams layoutParams, List<View> list, List<View> list2) {
        if (this.tt == null || context == null) {
            return;
        }
        c.d().d(40056).d(Void.class).d(10000, context).d(50013, viewGroup).d(50017, layoutParams).d(50018, list).d(50019, list2);
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
        if (this.tt != null && context != null) {
            Object objApply = this.tt.apply(c.d().d(40055).d(10000, context).d(ViewGroup.class).hc());
            if (objApply instanceof ViewGroup) {
                return (ViewGroup) objApply;
            }
        }
        return null;
    }

    private boolean b(View view) {
        if (this.tt != null) {
            Object objApply = this.tt.apply(c.d().d(40054).d(50013, view).d(Boolean.class).hc());
            if ((objApply instanceof Boolean) && ((Boolean) objApply).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    private void np(int i) {
        if (this.tt != null) {
            this.tt.apply(c.d().d(40007).d(50007, Integer.valueOf(i)).d(Void.class).hc());
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
            Integer num = (Integer) an.d(new Callable<Integer>() { // from class: com.bytedance.msdk.core.d.d.hc.d.b.hc.11
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public Integer call() throws Exception {
                    return hc.this.nx();
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
        an.b(new Runnable() { // from class: com.bytedance.msdk.core.d.d.hc.d.b.hc.12
            @Override // java.lang.Runnable
            public void run() {
                hc.this.qa();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qa() {
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
                an.c(new Runnable() { // from class: com.bytedance.msdk.core.d.d.hc.d.b.hc.13
                    @Override // java.lang.Runnable
                    public void run() {
                        hc.this.yi(iKb);
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
            an.c(new Runnable() { // from class: com.bytedance.msdk.core.d.d.hc.d.b.hc.14
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
            return pk();
        }
        return jw();
    }

    private String pk() {
        try {
            return (String) an.d(new Callable<String>() { // from class: com.bytedance.msdk.core.d.d.hc.d.b.hc.2
                @Override // java.util.concurrent.Callable
                public String call() throws Exception {
                    return hc.this.jw();
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
        Object objApply = this.tt.apply(c.d().d(40015).d(Map.class).hc());
        return (!(objApply instanceof Map) || (obj = ((Map) objApply).get("request_id")) == null) ? "" : obj.toString();
    }

    @Override // com.bytedance.msdk.hc.b
    public void w() {
        com.bytedance.msdk.core.d.d.hc.d dVar = this.mk;
        if (dVar != null && dVar.b()) {
            an.b(new Runnable() { // from class: com.bytedance.msdk.core.d.d.hc.d.b.hc.3
                @Override // java.lang.Runnable
                public void run() {
                    hc.this.le();
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
            an.b(new Runnable() { // from class: com.bytedance.msdk.core.d.d.hc.d.b.hc.4
                @Override // java.lang.Runnable
                public void run() {
                    hc.this.re();
                }
            });
        } else {
            re();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void le() {
        if (this.tt != null) {
            this.tt.apply(c.d().d(40061).d(Void.class).hc());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void re() {
        if (this.tt != null) {
            this.tt.apply(c.d().d(40062).d(Void.class).hc());
        }
    }

    @Override // com.bytedance.msdk.hc.b
    public void d() {
        com.bytedance.msdk.core.d.d.hc.d dVar = this.mk;
        if (dVar != null && dVar.b()) {
            an.b(new Runnable() { // from class: com.bytedance.msdk.core.d.d.hc.d.b.hc.5
                @Override // java.lang.Runnable
                public void run() {
                    hc.this.cs();
                }
            });
        } else {
            cs();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cs() {
        if (this.tt != null) {
            this.tt.apply(c.d().d(40063).d(Void.class).hc());
        }
    }

    @Override // com.bytedance.msdk.hc.b
    public void hc() {
        com.bytedance.msdk.core.d.d.hc.d dVar = this.mk;
        if (dVar != null && dVar.b()) {
            an.b(new Runnable() { // from class: com.bytedance.msdk.core.d.d.hc.d.b.hc.6
                @Override // java.lang.Runnable
                public void run() {
                    hc.this.bk();
                }
            });
        } else {
            bk();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bk() {
        if (this.tt != null) {
            this.tt.apply(c.d().d(40064).d(Void.class).hc());
        }
    }

    @Override // com.bytedance.msdk.hc.b
    public <T> T applyFunction(int i, PluginValueSet pluginValueSet, Class<T> cls) {
        if (i == 60018) {
            if (this.hc != null) {
                this.hc.hc();
            }
        } else if (i == 60019) {
            if (this.hc != null) {
                this.hc.b();
            }
        } else if (i == 60020) {
            if (this.hc != null) {
                this.hc.c();
            }
        } else if (i == 60005) {
            if (this.hc != null) {
                this.hc.u();
            }
        } else if (i == 60010) {
            com.bytedance.msdk.core.d.d.hc.d.an.hc hcVar = new com.bytedance.msdk.core.d.d.hc.d.an.hc((Function) pluginValueSet.objectValue(50006, Function.class));
            if (this.hc != null) {
                this.hc.d(new com.bytedance.msdk.api.d(hcVar.d(), hcVar.hc()));
            }
        } else if (i == 60004) {
            if (nv() == 5) {
                if (this.an != null) {
                    this.an.d(null);
                }
            } else if (this.d != null) {
                this.d.d(null);
            }
        } else if (i == 60009) {
            if (nv() == 5) {
                if (this.an != null) {
                    this.an.d();
                }
            } else if (this.d != null) {
                this.d.d();
            }
        }
        return null;
    }
}
