package com.kwad.components.ct.emotion.model;

import android.content.Context;
import com.kwad.components.ct.emotion.c;
import com.kwad.sdk.service.ServiceProvider;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public abstract class b {
    public static Context getContext() {
        return ServiceProvider.getContext();
    }

    public final c DN() {
        return new c() { // from class: com.kwad.components.ct.emotion.model.b.1
            @Override // com.kwad.components.ct.emotion.c
            public final void a(EmotionPackage emotionPackage) {
                com.kwad.sdk.core.d.c.d("EmotionManager", "onComplete:" + emotionPackage.id);
            }

            @Override // com.kwad.components.ct.emotion.c
            public final void b(EmotionPackage emotionPackage) {
                com.kwad.sdk.core.d.c.d("EmotionManager", "onError:" + emotionPackage.id);
            }
        };
    }
}
