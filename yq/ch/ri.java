package yq.ch;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import com.qq.e.mediation.interfaces.BaseBannerAd;
import com.qq.e.mediation.interfaces.BaseInterstitialAd;
import com.qq.e.mediation.interfaces.BaseNativeUnifiedAd;
import com.qq.e.mediation.interfaces.BaseRewardAd;
import com.qq.e.mediation.interfaces.BaseSplashAd;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class ri {
    private static final Handler a = new Handler(Looper.getMainLooper());

    /* compiled from: A */
    class a implements Runnable {
        final /* synthetic */ BaseBannerAd a;

        a(BaseBannerAd baseBannerAd) {
            this.a = baseBannerAd;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.loadAD();
        }
    }

    /* compiled from: A */
    class b implements Runnable {
        final /* synthetic */ BaseNativeUnifiedAd a;
        final /* synthetic */ int b;

        b(BaseNativeUnifiedAd baseNativeUnifiedAd, int i) {
            this.a = baseNativeUnifiedAd;
            this.b = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.loadData(this.b);
        }
    }

    /* compiled from: A */
    class c implements Runnable {
        final /* synthetic */ BaseRewardAd a;

        c(BaseRewardAd baseRewardAd) {
            this.a = baseRewardAd;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.loadAD();
        }
    }

    /* compiled from: A */
    class d implements Runnable {
        final /* synthetic */ Activity a;
        final /* synthetic */ BaseRewardAd b;

        d(Activity activity, BaseRewardAd baseRewardAd) {
            this.a = activity;
            this.b = baseRewardAd;
        }

        @Override // java.lang.Runnable
        public void run() {
            Activity activity = this.a;
            if (activity != null) {
                this.b.showAD(activity);
            } else {
                this.b.showAD();
            }
        }
    }

    /* compiled from: A */
    class e implements Runnable {
        final /* synthetic */ BaseInterstitialAd a;

        e(BaseInterstitialAd baseInterstitialAd) {
            this.a = baseInterstitialAd;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.loadAd();
        }
    }

    /* compiled from: A */
    class f implements Runnable {
        final /* synthetic */ Activity a;
        final /* synthetic */ BaseInterstitialAd b;

        f(Activity activity, BaseInterstitialAd baseInterstitialAd) {
            this.a = activity;
            this.b = baseInterstitialAd;
        }

        @Override // java.lang.Runnable
        public void run() {
            Activity activity = this.a;
            if (activity != null) {
                this.b.show(activity);
            } else {
                this.b.show();
            }
        }
    }

    /* compiled from: A */
    class g implements Runnable {
        final /* synthetic */ BaseInterstitialAd a;

        g(BaseInterstitialAd baseInterstitialAd) {
            this.a = baseInterstitialAd;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.loadFullScreenAD();
        }
    }

    /* compiled from: A */
    class h implements Runnable {
        final /* synthetic */ BaseInterstitialAd a;
        final /* synthetic */ Activity b;

        h(BaseInterstitialAd baseInterstitialAd, Activity activity) {
            this.a = baseInterstitialAd;
            this.b = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.showFullScreenAD(this.b);
        }
    }

    /* compiled from: A */
    class i implements Runnable {
        final /* synthetic */ BaseSplashAd a;

        i(BaseSplashAd baseSplashAd) {
            this.a = baseSplashAd;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.fetchAdOnly();
        }
    }

    /* compiled from: A */
    class j implements Runnable {
        final /* synthetic */ BaseSplashAd a;
        final /* synthetic */ ViewGroup b;

        j(BaseSplashAd baseSplashAd, ViewGroup viewGroup) {
            this.a = baseSplashAd;
            this.b = viewGroup;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.showAd(this.b);
        }
    }

    public static void a(BaseNativeUnifiedAd baseNativeUnifiedAd, int i2) {
        a.postAtFrontOfQueue(new b(baseNativeUnifiedAd, i2));
    }

    public static void b(BaseInterstitialAd baseInterstitialAd) {
        a.postAtFrontOfQueue(new e(baseInterstitialAd));
    }

    public static void a(BaseRewardAd baseRewardAd) {
        a.postAtFrontOfQueue(new c(baseRewardAd));
    }

    public static void b(BaseInterstitialAd baseInterstitialAd, Activity activity) {
        a.postAtFrontOfQueue(new f(activity, baseInterstitialAd));
    }

    public static void a(BaseRewardAd baseRewardAd, Activity activity) {
        a.postAtFrontOfQueue(new d(activity, baseRewardAd));
    }

    public static void a(BaseInterstitialAd baseInterstitialAd) {
        a.postAtFrontOfQueue(new g(baseInterstitialAd));
    }

    public static void a(BaseInterstitialAd baseInterstitialAd, Activity activity) {
        a.postAtFrontOfQueue(new h(baseInterstitialAd, activity));
    }

    public static void a(BaseSplashAd baseSplashAd) {
        a.postAtFrontOfQueue(new i(baseSplashAd));
    }

    public static void a(BaseSplashAd baseSplashAd, ViewGroup viewGroup) {
        a.postAtFrontOfQueue(new j(baseSplashAd, viewGroup));
    }

    public static void a(BaseBannerAd baseBannerAd) {
        a.postAtFrontOfQueue(new a(baseBannerAd));
    }
}
