package com.bytedance.sdk.component.adexpress.dynamic.d;

import android.content.Context;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.b;
import com.bytedance.sdk.component.adexpress.c.u;
import com.bytedance.sdk.component.adexpress.dynamic.b.an;
import com.bytedance.sdk.component.adexpress.dynamic.c.gb;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicRootView;
import com.bytedance.sdk.component.adexpress.hc.c;
import com.bytedance.sdk.component.adexpress.hc.h;
import com.bytedance.sdk.component.adexpress.hc.k;
import com.bytedance.sdk.component.adexpress.hc.mk;
import com.bytedance.sdk.component.adexpress.hc.uo;
import com.bytedance.sdk.component.adexpress.theme.ThemeStatusBroadcastReceiver;
import com.bytedance.sdk.component.utils.mq;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d implements c<DynamicRootView>, mk {
    private uo an;
    private Context b;
    private h c;
    private DynamicRootView d;
    private ScheduledFuture<?> h;
    private gb hc;
    private com.bytedance.sdk.component.adexpress.hc.gb u;
    private AtomicBoolean gb = new AtomicBoolean(false);
    private volatile boolean tt = false;

    public d(Context context, ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver, boolean z, gb gbVar, uo uoVar, com.bytedance.sdk.component.adexpress.dynamic.u.d dVar) {
        this.b = context;
        DynamicRootView dynamicRootView = new DynamicRootView(context, themeStatusBroadcastReceiver, z, uoVar, dVar);
        this.d = dynamicRootView;
        this.hc = gbVar;
        this.an = uoVar;
        dynamicRootView.setRenderListener(this);
        this.an = uoVar;
    }

    @Override // com.bytedance.sdk.component.adexpress.hc.c
    public void d(h hVar) {
        this.c = hVar;
        int iGb = this.an.gb();
        if (iGb < 0) {
            this.d.d(this.hc instanceof com.bytedance.sdk.component.adexpress.dynamic.c.h ? 127 : 117, "time is " + iGb);
            return;
        }
        this.h = u.d(new RunnableC0263d(2), iGb, TimeUnit.MILLISECONDS);
        if (this.tt) {
            com.bytedance.sdk.component.utils.gb.b().postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.d.d.1
                @Override // java.lang.Runnable
                public void run() {
                    d.this.gb();
                }
            }, this.an.mq());
        } else if (Looper.getMainLooper() == Looper.myLooper() && this.an.mq() <= 0) {
            gb();
        } else {
            com.bytedance.sdk.component.utils.gb.hc().postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.d.d.2
                @Override // java.lang.Runnable
                public void run() {
                    d.this.gb();
                }
            }, this.an.mq());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gb() {
        this.an.h().hc(b());
        JSONObject jSONObjectU = this.an.u();
        if (!com.bytedance.sdk.component.adexpress.d.hc.hc.d(jSONObjectU)) {
            this.d.d(this.hc instanceof com.bytedance.sdk.component.adexpress.dynamic.c.h ? 123 : 113, "data null is " + (jSONObjectU == null));
        } else {
            this.hc.d(new com.bytedance.sdk.component.adexpress.dynamic.u.hc() { // from class: com.bytedance.sdk.component.adexpress.dynamic.d.d.3
                @Override // com.bytedance.sdk.component.adexpress.dynamic.u.hc
                public void d(final com.bytedance.sdk.component.adexpress.dynamic.b.gb gbVar) {
                    d.this.tc();
                    d.this.an.h().b(d.this.b());
                    d.this.d(gbVar);
                    d.this.hc(gbVar);
                    if (d.this.tt) {
                        d.this.b(gbVar);
                    } else {
                        com.bytedance.sdk.component.utils.gb.hc().post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.d.d.3.1
                            @Override // java.lang.Runnable
                            public void run() {
                                d.this.b(gbVar);
                            }
                        });
                    }
                    if (d.this.d == null || gbVar == null) {
                        return;
                    }
                    d.this.d.setBgColor(gbVar.d());
                    d.this.d.setBgMaterialCenterCalcColor(gbVar.hc());
                }
            });
            this.hc.d(this.an);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.bytedance.sdk.component.adexpress.dynamic.b.gb gbVar) {
        List<com.bytedance.sdk.component.adexpress.dynamic.b.gb> listMk;
        if (gbVar == null || (listMk = gbVar.mk()) == null || listMk.size() <= 0) {
            return;
        }
        Collections.sort(listMk, new Comparator<com.bytedance.sdk.component.adexpress.dynamic.b.gb>() { // from class: com.bytedance.sdk.component.adexpress.dynamic.d.d.4
            @Override // java.util.Comparator
            /* renamed from: d, reason: merged with bridge method [inline-methods] */
            public int compare(com.bytedance.sdk.component.adexpress.dynamic.b.gb gbVar2, com.bytedance.sdk.component.adexpress.dynamic.b.gb gbVar3) {
                an anVarU = gbVar2.tc().u();
                an anVarU2 = gbVar3.tc().u();
                if (anVarU == null || anVarU2 == null) {
                    return 0;
                }
                return anVarU.fv() >= anVarU2.fv() ? 1 : -1;
            }
        });
        for (com.bytedance.sdk.component.adexpress.dynamic.b.gb gbVar2 : listMk) {
            if (gbVar2 != null) {
                d(gbVar2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hc(com.bytedance.sdk.component.adexpress.dynamic.b.gb gbVar) {
        float fH;
        float fAn;
        List<com.bytedance.sdk.component.adexpress.dynamic.b.gb> listMk;
        if (gbVar == null) {
            return;
        }
        List<com.bytedance.sdk.component.adexpress.dynamic.b.gb> listMk2 = gbVar.mk();
        if (listMk2 == null || listMk2.size() <= 0) {
            fH = 0.0f;
        } else {
            fH = 0.0f;
            for (com.bytedance.sdk.component.adexpress.dynamic.b.gb gbVar2 : listMk2) {
                if (gbVar2.h() > gbVar.h() - gbVar2.tt() || (listMk = gbVar2.mk()) == null || listMk.size() <= 0) {
                    fAn = 0.0f;
                } else {
                    fAn = 0.0f;
                    for (com.bytedance.sdk.component.adexpress.dynamic.b.gb gbVar3 : listMk) {
                        if (gbVar3.tc().getType().equals("logo-union")) {
                            fAn = gbVar3.tc().an();
                            fH = (((-fAn) + gbVar.h()) - gbVar2.h()) + gbVar2.tc().u().hr();
                        }
                    }
                }
                hc(gbVar2);
                if (fAn <= -15.0f) {
                    gbVar2.an(gbVar2.tt() - fAn);
                    gbVar2.c(gbVar2.h() + fAn);
                    for (com.bytedance.sdk.component.adexpress.dynamic.b.gb gbVar4 : gbVar2.mk()) {
                        gbVar4.c(gbVar4.h() - fAn);
                    }
                }
            }
        }
        com.bytedance.sdk.component.adexpress.dynamic.b.gb gbVarMq = gbVar.mq();
        if (gbVarMq == null) {
            return;
        }
        float fAn2 = gbVar.an() - gbVarMq.an();
        float fH2 = gbVar.h() - gbVarMq.h();
        gbVar.b(fAn2);
        gbVar.c(fH2);
        if (fH > 0.0f) {
            gbVar.c(gbVar.h() - fH);
            gbVar.an(gbVar.tt() + fH);
            for (com.bytedance.sdk.component.adexpress.dynamic.b.gb gbVar5 : gbVar.mk()) {
                gbVar5.c(gbVar5.h() + fH);
            }
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.hc.c
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public DynamicRootView h() {
        return an();
    }

    public void hc() {
        d(h());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void d(View view) {
        if (view == 0) {
            return;
        }
        if (view instanceof ViewGroup) {
            int i = 0;
            while (true) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (i >= viewGroup.getChildCount()) {
                    break;
                }
                d(viewGroup.getChildAt(i));
                i++;
            }
        }
        if (view instanceof com.bytedance.sdk.component.adexpress.dynamic.dynamicview.u) {
            ((com.bytedance.sdk.component.adexpress.dynamic.dynamicview.u) view).hc();
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.hc.c
    public int b() {
        return this.hc instanceof com.bytedance.sdk.component.adexpress.dynamic.c.h ? 3 : 2;
    }

    public void c() {
        this.d.d();
    }

    public void u() {
        this.d.hc();
    }

    public void d(boolean z) {
        this.d.setSoundMute(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.bytedance.sdk.component.adexpress.dynamic.b.gb gbVar) {
        if (gbVar == null) {
            this.d.d(this.hc instanceof com.bytedance.sdk.component.adexpress.dynamic.c.h ? 123 : 113, "layoutUnit is null");
            return;
        }
        this.an.h().c(b());
        try {
            this.d.d(gbVar, b());
        } catch (Exception e) {
            this.d.d(this.hc instanceof com.bytedance.sdk.component.adexpress.dynamic.c.h ? 128 : 118, "exception is " + e.getMessage());
        }
    }

    public DynamicRootView an() {
        return this.d;
    }

    public void d(com.bytedance.sdk.component.adexpress.hc.gb gbVar) {
        this.u = gbVar;
    }

    private boolean tt() {
        DynamicRootView dynamicRootView = this.d;
        return (dynamicRootView == null || dynamicRootView.getChildCount() == 0) ? false : true;
    }

    @Override // com.bytedance.sdk.component.adexpress.hc.mk
    public void d(k kVar) {
        if (this.gb.get()) {
            return;
        }
        this.gb.set(true);
        if (kVar.b() && tt()) {
            this.d.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            this.c.d(h(), kVar);
            return;
        }
        this.c.d(kVar.mk(), kVar.tc());
    }

    @Override // com.bytedance.sdk.component.adexpress.hc.mk
    public void d(View view, int i, b bVar) {
        com.bytedance.sdk.component.adexpress.hc.gb gbVar = this.u;
        if (gbVar != null) {
            gbVar.d(view, i, bVar);
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.hc.mk
    public void d(View view, int i, b bVar, int i2) {
        com.bytedance.sdk.component.adexpress.hc.gb gbVar = this.u;
        if (gbVar != null) {
            gbVar.d(view, i, bVar, i2);
        }
    }

    public void hc(boolean z) {
        this.tt = z;
    }

    /* renamed from: com.bytedance.sdk.component.adexpress.dynamic.d.d$d, reason: collision with other inner class name */
    private class RunnableC0263d implements Runnable {
        private int hc;

        public RunnableC0263d(int i) {
            this.hc = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.hc == 2) {
                d.this.d.d(d.this.hc instanceof com.bytedance.sdk.component.adexpress.dynamic.c.h ? 127 : 117, (String) null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tc() {
        try {
            ScheduledFuture<?> scheduledFuture = this.h;
            if (scheduledFuture == null || scheduledFuture.isCancelled()) {
                return;
            }
            this.h.cancel(false);
            this.h = null;
        } catch (Throwable th) {
            mq.d(th);
        }
    }
}
