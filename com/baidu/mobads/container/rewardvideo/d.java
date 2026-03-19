package com.baidu.mobads.container.rewardvideo;

import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import com.component.a.g.c.m;
import com.style.widget.viewpager2.AutoBannerHelper;
import com.style.widget.viewpager2.PagerIndicatorView;
import com.style.widget.viewpager2.State;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
class d extends dq {
    final /* synthetic */ NativeRewardActivity a;
    final /* synthetic */ com.component.a.d.c b;
    final /* synthetic */ RelativeLayout.LayoutParams c;
    final /* synthetic */ a d;
    private final List<View> h;
    private final List<View> i;
    private AutoBannerHelper j;
    private com.baidu.mobads.container.s.ab k;
    private m.b l;
    private View m;
    private com.component.a.a.f n;
    private boolean o;
    private boolean p;
    private int q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    d(a aVar, com.component.a.d.c cVar, com.baidu.mobads.container.activity.b bVar, NativeRewardActivity nativeRewardActivity, com.component.a.d.c cVar2, RelativeLayout.LayoutParams layoutParams) {
        super(cVar, bVar);
        this.d = aVar;
        this.a = nativeRewardActivity;
        this.b = cVar2;
        this.c = layoutParams;
        this.h = new ArrayList();
        this.i = new ArrayList();
        this.o = false;
        this.p = false;
        this.q = 0;
    }

    @Override // com.baidu.mobads.container.rewardvideo.dq
    void a(JSONObject jSONObject) {
    }

    @Override // com.baidu.mobads.container.rewardvideo.dq
    void a(View view, String str) {
        super.a(view, str);
        if ("indicator_view".equals(str) && (view instanceof PagerIndicatorView) && this.d.h != null) {
            PagerIndicatorView pagerIndicatorView = (PagerIndicatorView) view;
            pagerIndicatorView.setupWithViewPager2(this.d.h);
            this.j = pagerIndicatorView.getBannerHelper();
            this.j.bindWithViewPager(this.d.h);
            this.j.startTimer();
            return;
        }
        if ("shake_view".equals(str) && (view instanceof com.baidu.mobads.container.s.ab)) {
            this.k = (com.baidu.mobads.container.s.ab) view;
            if (this.k.b()) {
                this.g.a(new e(this), this.k.d());
                this.g.a(new f(this), this.k.d() + this.k.e());
                return;
            }
            return;
        }
        if ("segmented_countdown_text".equals(str) && (view instanceof m.b) && view.getVisibility() == 0) {
            this.l = (m.b) view;
            return;
        }
        if ("segmented_countdown_gift".equals(str) && (view instanceof m.b) && view.getVisibility() == 0 && this.l == null) {
            this.l = (m.b) view;
            return;
        }
        if ("egg_countdown_lottie".equals(str) && (view instanceof com.component.a.a.f)) {
            this.n = (com.component.a.a.f) view;
        } else if ("egg_countdown".equals(str)) {
            this.m = view;
            this.q = com.component.a.i.f.a(view, "reward_tips", 0);
        }
    }

    @Override // com.baidu.mobads.container.rewardvideo.dq
    void a(NativeRewardActivity nativeRewardActivity) {
        if (this.o) {
            return;
        }
        this.f.a(State.RESUMED);
        if (this.j != null) {
            this.j.resumeTimer();
        }
        c();
        if (this.l != null && !this.l.j()) {
            this.l.f();
        }
        if (this.n != null && !this.p) {
            this.n.g();
        }
        this.a.startTimer();
    }

    @Override // com.baidu.mobads.container.rewardvideo.dq
    void a(NativeRewardActivity nativeRewardActivity, int i) {
        this.f.a(State.STARTED);
        if (this.j != null) {
            this.j.pauseTimer();
        }
        if (this.k != null) {
            this.k.j();
        }
        boolean z = this.a.mTimingReward && i == 2;
        if (this.l != null && !z) {
            this.l.g();
        }
        if (this.n != null) {
            this.n.t();
        }
        this.a.stopTimer(z);
    }

    @Override // com.baidu.mobads.container.activity.b.a
    public void onActivityResumed(com.baidu.mobads.container.activity.b bVar) {
        a(this.a);
    }

    @Override // com.baidu.mobads.container.activity.b.a
    public void onActivityPaused(com.baidu.mobads.container.activity.b bVar) {
        a(this.a, 0);
    }

    @Override // com.baidu.mobads.container.activity.b.a
    public void onActivityDestroyed(com.baidu.mobads.container.activity.b bVar) {
        if (this.j != null) {
            this.j.stopTimer();
            this.j = null;
        }
        if (this.k != null) {
            this.k.m();
            this.k = null;
        }
        if (this.l != null) {
            this.l.h();
            this.l = null;
        }
        if (this.n != null) {
            this.n.s();
            this.n = null;
        }
        this.a.stopTimer();
    }

    @Override // com.baidu.mobads.container.rewardvideo.dq
    boolean a(int i, int i2) {
        if (this.l != null) {
            this.l.b(i);
        }
        Iterator it = this.d.d.iterator();
        while (it.hasNext()) {
            ((dk) it.next()).a().b(i2);
        }
        return true;
    }

    @Override // com.baidu.mobads.container.rewardvideo.dq
    void a() {
        Iterator it = this.d.d.iterator();
        while (it.hasNext()) {
            ((dk) it.next()).a().a();
        }
    }

    @Override // com.baidu.mobads.container.rewardvideo.dq
    void b() {
        this.p = true;
        if (this.q != 1) {
            if (this.m != null) {
                this.m.setVisibility(8);
            }
            if (this.n != null) {
                this.n.setVisibility(8);
            }
        }
        this.a.videoPlayCompletion();
    }

    @Override // com.baidu.mobads.container.rewardvideo.dq
    protected void a(View view) {
        this.h.add(view);
    }

    @Override // com.baidu.mobads.container.rewardvideo.dq
    protected void b(View view) {
        this.i.add(view);
    }

    @Override // com.baidu.mobads.container.rewardvideo.dq
    protected void c(View view) {
        try {
            if (this.b.getParent() == null) {
                this.d.f.addView(this.b, this.c);
            }
            if (this.l != null) {
                int userRewardTime = this.a.getUserRewardTime();
                this.l.a(userRewardTime, userRewardTime, 1);
                this.l.e();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.baidu.mobads.container.rewardvideo.dq
    boolean a(View view, boolean z, com.component.a.f.d dVar) {
        if (this.k != null) {
            this.k.setVisibility(8);
            this.k.m();
            this.k = null;
        }
        try {
            if (g(view)) {
                return this.d.a(z, dVar);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return super.a(view, z, dVar);
    }

    @Override // com.baidu.mobads.container.rewardvideo.dq
    boolean a(View view, int i) {
        try {
            if (f(view)) {
                return this.d.a(i);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return super.a(view, i);
    }

    @Override // com.baidu.mobads.container.rewardvideo.dq
    boolean d(View view) {
        if (f(view) && this.f != null) {
            this.o = true;
            if (TextUtils.equals("rvideo_front_retain_view", com.component.a.i.f.c(view).m(""))) {
                a(this.a, 3);
            } else {
                a(this.a, 2);
            }
            return true;
        }
        return super.d(view);
    }

    @Override // com.baidu.mobads.container.rewardvideo.dq
    boolean e(View view) {
        if (f(view) && this.f != null) {
            this.o = false;
            a(this.a);
            return true;
        }
        return super.e(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (this.k != null && this.k.b() && this.k.getVisibility() == 0 && this.f.b().isAtLeast(State.RESUMED)) {
            this.k.i();
        }
    }

    private boolean f(View view) {
        if (view != null) {
            Iterator<View> it = this.h.iterator();
            while (it.hasNext()) {
                if (it.next().findViewById(view.getId()) != null) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    private boolean g(View view) {
        if (view != null) {
            Iterator<View> it = this.i.iterator();
            while (it.hasNext()) {
                if (it.next().findViewById(view.getId()) != null) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }
}
