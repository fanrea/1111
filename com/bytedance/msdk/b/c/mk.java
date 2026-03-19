package com.bytedance.msdk.b.c;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.bytedance.msdk.core.views.RefreshableBannerView;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class mk {
    private RefreshableBannerView an;
    private com.bytedance.msdk.api.d.hc b;
    private an c;
    private final Runnable cb;
    private final com.bytedance.msdk.api.c.d.d.d e;
    private final Handler gb;
    private final Handler h;
    private final SoftReference<Context> hc;
    private final View.OnAttachStateChangeListener k;
    private com.bytedance.msdk.api.c.d.d.c tc;
    private com.bytedance.msdk.api.c.d.d.d tt;
    private an u;
    private int d = 0;
    private SoftReference<Activity> mk = new SoftReference<>(null);
    private SoftReference<com.bytedance.sdk.openadsdk.jh.d.hc.d.d> mq = new SoftReference<>(null);
    private SoftReference<Map<String, Object>> uo = new SoftReference<>(null);

    /* renamed from: com.bytedance.msdk.b.c.mk$3, reason: invalid class name */
    class AnonymousClass3 implements Runnable {
        AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public void run() {
            mk.this.gb.post(new Runnable() { // from class: com.bytedance.msdk.b.c.mk.3.1
                @Override // java.lang.Runnable
                public void run() {
                    if (mk.this.d == 0 || mk.this.u == null) {
                        return;
                    }
                    View viewD = mk.this.u.d((Context) mk.this.hc.get());
                    if (viewD != null) {
                        mk.this.d(mk.this.u);
                        if (mk.this.an != null) {
                            mk.this.an.d(viewD);
                        }
                        mk.this.gb.postDelayed(new Runnable() { // from class: com.bytedance.msdk.b.c.mk.3.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (mk.this.c != null) {
                                    mk.this.c.d();
                                }
                                mk.this.c = mk.this.u;
                                mk.this.w();
                            }
                        }, 250L);
                    } else {
                        if (mk.this.u != null) {
                            mk.this.u.d();
                        }
                        mk.this.w();
                    }
                    mk.this.e();
                }
            });
        }
    }

    public mk(Context context) {
        View.OnAttachStateChangeListener onAttachStateChangeListener = new View.OnAttachStateChangeListener() { // from class: com.bytedance.msdk.b.c.mk.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                if (mk.this.d == 0) {
                    return;
                }
                mk.this.w();
                mk.this.e();
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                mk.this.cb();
            }
        };
        this.k = onAttachStateChangeListener;
        this.e = new com.bytedance.msdk.api.c.d.d.d() { // from class: com.bytedance.msdk.b.c.mk.2
            @Override // com.bytedance.msdk.api.c.d.d.d
            public void f_() {
                mk.this.cb();
                if (mk.this.tt != null) {
                    mk.this.tt.f_();
                }
            }

            @Override // com.bytedance.msdk.api.c.d.d.d
            public void d(View view) {
                if (mk.this.tt != null) {
                    mk.this.tt.d(view);
                }
            }

            @Override // com.bytedance.msdk.api.c.d.d.d
            public void hc(View view) {
                if (mk.this.tt != null) {
                    mk.this.tt.hc(view);
                }
            }

            @Override // com.bytedance.msdk.api.c.d.d.d
            public void d(com.bytedance.msdk.api.d dVar) {
                if (mk.this.tt != null) {
                    mk.this.tt.d(dVar);
                }
            }
        };
        this.cb = new AnonymousClass3();
        this.hc = new SoftReference<>(context);
        this.c = new an(context);
        if (context != null) {
            RefreshableBannerView refreshableBannerView = new RefreshableBannerView(context);
            this.an = refreshableBannerView;
            refreshableBannerView.addOnAttachStateChangeListener(onAttachStateChangeListener);
            this.an.setVisibilityChangeListener(new RefreshableBannerView.d() { // from class: com.bytedance.msdk.b.c.mk.4
                @Override // com.bytedance.msdk.core.views.RefreshableBannerView.d
                public void d(boolean z) {
                    if (z) {
                        if (mk.this.d == 0) {
                            return;
                        }
                        mk.this.e();
                        return;
                    }
                    mk.this.cb();
                }
            });
        }
        this.h = new Handler(com.bytedance.msdk.d.u.an.hc());
        this.gb = new Handler(Looper.getMainLooper());
    }

    private void d(com.bytedance.msdk.api.d.hc hcVar) {
        com.bytedance.msdk.core.tc.hc hcVarD;
        if (hcVar == null || (hcVarD = com.bytedance.msdk.core.hc.hc().d(hcVar.v(), 1, 100)) == null) {
            return;
        }
        int iTt = hcVarD.tt(1);
        if (iTt >= 10000 && iTt <= 180000) {
            this.d = iTt;
            com.bytedance.msdk.d.u.b.d("TMe", "---==-----banner轮播时间：" + this.d);
        } else {
            com.bytedance.msdk.d.u.b.d("TMe", "---==-----banner轮播时间下发不在10*1000～180*1000范围内：" + iTt + "，禁止banner轮播");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.h.removeCallbacksAndMessages(null);
        this.h.postDelayed(this.cb, this.d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cb() {
        this.h.removeCallbacksAndMessages(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        Context context;
        SoftReference<Context> softReference = this.hc;
        if (softReference == null || (context = softReference.get()) == null) {
            return;
        }
        an anVar = new an(context);
        this.u = anVar;
        anVar.d(this.e);
        this.u.d(this.tc);
        d(this.b);
        this.u.d(this.b, (com.bytedance.msdk.api.c.d.d.hc) null);
    }

    public void d(com.bytedance.msdk.api.d.hc hcVar, com.bytedance.msdk.api.c.d.d.hc hcVar2) {
        SoftReference<Context> softReference;
        if (this.c == null || (softReference = this.hc) == null || softReference.get() == null) {
            return;
        }
        this.b = hcVar;
        d(hcVar);
        if (!com.bytedance.msdk.core.hc.hc().d(hcVar.v(), 1) && hcVar2 != null) {
            hcVar2.d(new com.bytedance.msdk.api.d(840031, com.bytedance.msdk.api.d.d(840031)));
        } else if (com.bytedance.msdk.core.hc.hc().e()) {
            this.c.d(this.b, hcVar2);
        } else if (hcVar2 != null) {
            hcVar2.d(new com.bytedance.msdk.api.d(840032, com.bytedance.msdk.api.d.d(840032)));
        }
    }

    public void d(com.bytedance.msdk.api.c.d.d.d dVar) {
        this.tt = dVar;
        an anVar = this.c;
        if (anVar != null) {
            anVar.d(this.e);
        }
    }

    public void d(com.bytedance.msdk.api.c.d.d.c cVar) {
        this.tc = cVar;
        an anVar = this.c;
        if (anVar != null) {
            anVar.d(cVar);
        }
    }

    public void d() {
        an anVar = this.c;
        if (anVar != null) {
            anVar.u();
        }
    }

    public void hc() {
        an anVar = this.c;
        if (anVar != null) {
            anVar.an();
        }
    }

    public void b() {
        this.gb.removeCallbacksAndMessages(null);
        cb();
        RefreshableBannerView refreshableBannerView = this.an;
        if (refreshableBannerView != null) {
            refreshableBannerView.removeOnAttachStateChangeListener(this.k);
        }
        an anVar = this.c;
        if (anVar != null) {
            anVar.d();
        }
        an anVar2 = this.u;
        if (anVar2 != null) {
            anVar2.d();
        }
    }

    public boolean c() {
        an anVar = this.c;
        if (anVar != null) {
            return anVar.b();
        }
        return false;
    }

    public View u() {
        an anVar = this.c;
        if (anVar == null) {
            return null;
        }
        View viewD = anVar.d(this.hc.get());
        an anVar2 = this.c;
        anVar2.d(anVar2.c);
        if (viewD == null || this.an == null) {
            return null;
        }
        viewD.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.bytedance.msdk.b.c.mk.5
            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                if (view.getVisibility() == 0) {
                    mk mkVar = mk.this;
                    mkVar.d(mkVar.c);
                    view.removeOnLayoutChangeListener(this);
                }
            }
        });
        this.an.removeAllViews();
        ViewParent parent = viewD.getParent();
        if (parent != null && (parent instanceof ViewGroup)) {
            ((ViewGroup) parent).removeView(viewD);
        }
        this.an.addView(viewD);
        return this.an;
    }

    public int an() {
        an anVar = this.c;
        if (anVar != null) {
            return anVar.c();
        }
        return 0;
    }

    public Map<String, Object> h() {
        an anVar = this.c;
        if (anVar != null) {
            return anVar.yo();
        }
        return new HashMap();
    }

    public List<com.bytedance.msdk.api.hc> gb() {
        an anVar = this.c;
        if (anVar != null) {
            return anVar.tc();
        }
        return new ArrayList();
    }

    public List<com.bytedance.msdk.api.b> tt() {
        an anVar = this.c;
        if (anVar != null) {
            return anVar.mk();
        }
        return null;
    }

    public com.bytedance.msdk.api.b tc() {
        an anVar = this.c;
        if (anVar != null) {
            return anVar.cb();
        }
        return null;
    }

    public List<com.bytedance.msdk.api.b> mk() {
        an anVar = this.c;
        if (anVar != null) {
            return anVar.mq();
        }
        return null;
    }

    public com.bytedance.msdk.api.b mq() {
        an anVar = this.c;
        if (anVar != null) {
            return anVar.e();
        }
        return null;
    }

    public int uo() {
        an anVar = this.c;
        if (anVar != null) {
            return anVar.w();
        }
        return -1;
    }

    public void d(com.bytedance.sdk.openadsdk.w.b.d.b bVar) {
        an anVar = this.c;
        if (anVar != null) {
            anVar.d(bVar);
        }
    }

    public void d(com.bytedance.sdk.openadsdk.w.b.d.hc hcVar) {
        an anVar = this.c;
        if (anVar != null) {
            anVar.hc(hcVar);
        }
    }

    public void d(com.bytedance.sdk.openadsdk.he.d.hc.d.b bVar) {
        an anVar = this.c;
        if (anVar != null) {
            anVar.d(bVar);
        }
    }

    public void d(Activity activity, com.bytedance.sdk.openadsdk.jh.d.hc.d.d dVar) {
        this.mk = new SoftReference<>(activity);
        this.mq = new SoftReference<>(dVar);
    }

    public void d(Dialog dialog, Integer[] numArr) {
        HashMap map = new HashMap();
        map.put("dislike_dialog", dialog);
        map.put("dislike_ids", numArr);
        this.uo = new SoftReference<>(map);
    }

    public com.bytedance.sdk.openadsdk.w.b.hc.h d(Activity activity) {
        an anVar = this.c;
        if (anVar != null) {
            return anVar.d(activity);
        }
        return null;
    }

    public com.bytedance.sdk.openadsdk.w.b.hc.c k() {
        an anVar = this.c;
        if (anVar != null) {
            return anVar.sy();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(an anVar) {
        Map<String, Object> map = this.uo.get();
        if (map != null) {
            Dialog dialog = (Dialog) map.get("dislike_dialog");
            Integer[] numArr = (Integer[]) map.get("dislike_ids");
            if (dialog != null && numArr != null) {
                anVar.d(dialog, numArr);
            }
        }
        Activity activity = this.mk.get();
        com.bytedance.sdk.openadsdk.jh.d.hc.d.d dVar = this.mq.get();
        if (activity == null || dVar == null) {
            return;
        }
        anVar.d(activity, dVar);
    }

    public void d(String str) {
        an anVar = this.c;
        if (anVar != null) {
            anVar.c(str);
        }
    }
}
