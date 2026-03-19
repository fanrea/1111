package com.kwad.components.ct.emotion.a;

import com.kwad.components.ct.emotion.a.e;
import com.kwad.components.ct.emotion.model.EmotionPackage;
import com.kwad.components.ct.emotion.model.EmotionResponse;
import com.kwad.sdk.utils.ax;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class d {
    private static volatile d aBZ;
    private static com.kwad.components.ct.emotion.model.a aCd;
    private static com.kwad.components.ct.emotion.model.b aCe;
    private int aCc;
    private boolean aCa = false;
    private final Map<Integer, f> aCb = new ConcurrentHashMap();
    private String aCf = "0";

    static /* synthetic */ List a(d dVar, EmotionResponse emotionResponse) {
        return a(emotionResponse);
    }

    public static d DG() {
        if (aBZ == null) {
            synchronized (d.class) {
                if (aBZ == null) {
                    aBZ = new d();
                }
            }
        }
        return aBZ;
    }

    private d() {
    }

    public final void a(com.kwad.components.ct.emotion.model.a aVar, com.kwad.components.ct.emotion.model.b bVar) {
        ax.checkNotNull(com.kwad.components.ct.emotion.model.b.getContext());
        ax.iA(aVar.DL());
        aCd = aVar;
        aCe = bVar;
        com.kwad.components.ct.emotion.b.e.bK(aVar.DL());
        com.kwad.sdk.core.d.c.d("EmotionManager", "sConfig.getSaveDir()" + aCd.DL());
        a(new com.kwad.components.ct.emotion.b() { // from class: com.kwad.components.ct.emotion.a.d.1
            @Override // com.kwad.components.ct.emotion.b
            public final void onError(Throwable th) {
                com.kwad.sdk.core.d.c.e("EmotionManager", "fetchEmotionInfo e", null);
            }

            @Override // com.kwad.components.ct.emotion.b
            public final void onSuccess() {
                d.this.DH();
                com.kwad.sdk.core.d.c.d("EmotionManager", "fetchEmotionInfo");
            }
        });
    }

    private void a(final com.kwad.components.ct.emotion.b bVar) {
        e.a(new e.a() { // from class: com.kwad.components.ct.emotion.a.d.2
            @Override // com.kwad.components.ct.emotion.a.e.a
            public final void b(EmotionResponse emotionResponse) {
                d.this.aCa = true;
                d dVar = d.this;
                dVar.B(d.a(dVar, emotionResponse));
                com.kwad.components.ct.emotion.b bVar2 = bVar;
                if (bVar2 != null) {
                    bVar2.onSuccess();
                }
            }

            @Override // com.kwad.components.ct.emotion.a.e.a
            public final void zH() {
                d.this.aCa = false;
                com.kwad.components.ct.emotion.b bVar2 = bVar;
                if (bVar2 != null) {
                    bVar2.onError(null);
                }
            }
        });
    }

    public final void DH() {
        com.kwad.components.ct.emotion.b.b.DO().bJ(aCd.DL());
        if (this.aCa) {
            c.DD().a(this.aCb.get(1), aCe.DN());
            return;
        }
        com.kwad.components.ct.emotion.c cVarDN = aCe.DN();
        new IllegalStateException("not available: invoke `#fetchEmotionInfo()` or check `#isAvailable()`");
        cVarDN.b(null);
    }

    private static List<EmotionPackage> a(EmotionResponse emotionResponse) {
        if (emotionResponse == null) {
            return new ArrayList();
        }
        com.kwad.sdk.core.d.c.d("EmotionManager", "load form network: size=" + emotionResponse.mEmotionPackageList.size());
        return emotionResponse.mEmotionPackageList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<Integer, f> B(List<EmotionPackage> list) {
        com.kwad.sdk.core.d.c.d("EmotionManager", "load form network: size=" + list.size());
        this.aCb.clear();
        this.aCc = 0;
        for (EmotionPackage emotionPackage : list) {
            this.aCc++;
            f fVar = this.aCb.get(Integer.valueOf(emotionPackage.type));
            if (fVar != null) {
                fVar.a(emotionPackage.id, emotionPackage);
            } else {
                f fVar2 = new f();
                fVar2.a(emotionPackage.id, emotionPackage);
                this.aCb.put(Integer.valueOf(emotionPackage.type), fVar2);
            }
        }
        return this.aCb;
    }
}
