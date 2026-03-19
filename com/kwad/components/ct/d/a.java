package com.kwad.components.ct.d;

import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import com.kwad.lottie.LottieAnimationView;
import com.kwad.lottie.e.c;
import com.kwad.lottie.i;
import com.kwad.lottie.model.e;
import com.kwad.sdk.R;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class a {
    private Map<Boolean, Integer> aQY;
    private Map<Boolean, Integer> aQZ;

    /* renamed from: com.kwad.components.ct.d.a$a, reason: collision with other inner class name */
    static class C0503a {
        private static final a aRa = new a(0);
    }

    /* synthetic */ a(byte b) {
        this();
    }

    public static a Jd() {
        return C0503a.aRa;
    }

    private a() {
        this.aQY = new ConcurrentHashMap(4);
        this.aQZ = new ConcurrentHashMap(4);
        setLoadingLottieAnimation(true, R.raw.ksad_page_loading_light_anim);
        setLoadingLottieAnimation(false, R.raw.ksad_detail_loading_amin_new);
    }

    public final void setLoadingLottieAnimation(boolean z, int i) {
        this.aQY.put(Boolean.valueOf(z), Integer.valueOf(i));
    }

    public final void setLoadingLottieAnimationColor(boolean z, int i) {
        this.aQZ.put(Boolean.valueOf(z), Integer.valueOf(i));
    }

    public final void b(LottieAnimationView lottieAnimationView, boolean z) {
        Integer num;
        if (lottieAnimationView == null || (num = this.aQY.get(Boolean.valueOf(z))) == null) {
            return;
        }
        c(lottieAnimationView, z);
        lottieAnimationView.setAnimation(num.intValue());
    }

    private void c(LottieAnimationView lottieAnimationView, boolean z) {
        Integer num;
        if (lottieAnimationView == null || (num = this.aQZ.get(Boolean.valueOf(z))) == null) {
            return;
        }
        lottieAnimationView.a(new e("**"), i.bkU, new c(new PorterDuffColorFilter(num.intValue(), PorterDuff.Mode.SRC_ATOP)));
    }
}
