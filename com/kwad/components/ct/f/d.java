package com.kwad.components.ct.f;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.ksad.annotation.invoker.ForInvoker;
import com.kwad.components.ct.detail.photo.comment.i;
import com.kwad.sdk.api.SdkConfig;
import com.kwad.sdk.utils.ad;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class d {
    private static volatile d aVk;
    private static Map<String, c> aVl = new HashMap();
    private Context aVn;
    private ad aVo;
    private Map<Class<? extends a>, a> aVm = new HashMap();
    private volatile int aVp = 0;

    public static d Kb() {
        if (aVk == null) {
            synchronized (d.class) {
                if (aVk == null) {
                    aVk = new d();
                }
            }
        }
        return aVk;
    }

    private d() {
    }

    public final void init(Context context, SdkConfig sdkConfig) {
        if (this.aVn == null) {
            this.aVn = context;
            this.aVo = ad.dq(context);
            Kc();
        }
        try {
            e.cd(sdkConfig.nightThemeStyleAssetsFileName);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th);
        }
    }

    public final <T extends a> void a(Class<T> cls, a aVar) {
        this.aVm.put(cls, aVar);
    }

    public final <T extends a> T a(Class<T> cls) {
        return (T) this.aVm.get(cls);
    }

    @ForInvoker(methodId = "initForInvoker")
    private static void Kc() {
        com.kwad.components.ct.detail.photo.a.b.register();
        i.register();
        com.kwad.components.ct.entry.c.b.register();
        com.kwad.components.ct.feed.b.b.register();
        com.kwad.components.ct.hotspot.b.b.register();
        com.kwad.components.ct.tube.c.b.register();
    }

    private void cJ(int i) {
        Intent intent = new Intent("ks_sdk_theme_mode_change");
        intent.putExtra("themeModeType", i);
        this.aVo.i(intent);
    }

    public final void a(f fVar) {
        com.kwad.sdk.core.d.c.d("[ThemeMode]", "registerThemeModeChangeReceiver " + fVar);
        if (this.aVo != null) {
            this.aVo.a(fVar, new IntentFilter("ks_sdk_theme_mode_change"));
        }
    }

    public final void b(f fVar) {
        com.kwad.sdk.core.d.c.d("[ThemeMode]", "unregisterThemeModeChangeReceiver " + fVar);
        ad adVar = this.aVo;
        if (adVar != null) {
            adVar.unregisterReceiver(fVar);
        }
    }

    public final void bx(int i) {
        this.aVp = i;
        cJ(i);
    }

    public final int wR() {
        return this.aVp;
    }

    public static void a(String str, c cVar) {
        if (cVar != null) {
            aVl.put(str, cVar);
        }
    }

    public static c b(String str, c cVar) {
        if (!aVl.containsKey(str)) {
            aVl.put(str, cVar);
        }
        return aVl.get(str);
    }
}
