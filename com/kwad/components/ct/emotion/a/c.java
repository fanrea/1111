package com.kwad.components.ct.emotion.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.kwad.components.ct.emotion.b.d;
import com.kwad.components.ct.emotion.model.EmotionCode;
import com.kwad.components.ct.emotion.model.EmotionInfo;
import com.kwad.components.ct.emotion.model.EmotionPackage;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class c {
    private static final HashMap<String, SoftReference<Bitmap>> aBL = new HashMap<>(168);
    private static final g aBM = new com.kwad.components.ct.emotion.a.a() { // from class: com.kwad.components.ct.emotion.a.c.1
    };
    private static volatile c aBN;
    private com.kwad.components.ct.emotion.c aBE;
    private final Map<String, a> aBO = new ConcurrentHashMap();
    private final Map<String, EmotionInfo> aBP = new ConcurrentHashMap();
    private final Map<String, b> aBQ = new ConcurrentHashMap();
    private com.kwad.components.ct.emotion.b.d aBR = new com.kwad.components.ct.emotion.b.d();
    private AtomicInteger aBS;

    public static c DD() {
        if (aBN == null) {
            synchronized (c.class) {
                if (aBN == null) {
                    aBN = new c();
                }
            }
        }
        return aBN;
    }

    private c() {
    }

    public final void a(f fVar, com.kwad.components.ct.emotion.c cVar) {
        if (fVar == null) {
            return;
        }
        List<EmotionPackage> listDJ = fVar.DJ();
        this.aBS = new AtomicInteger(listDJ.size());
        this.aBE = cVar;
        Iterator<EmotionPackage> it = listDJ.iterator();
        while (it.hasNext()) {
            c(it.next());
        }
    }

    private void c(EmotionPackage emotionPackage) {
        if (emotionPackage != null) {
            b bVar = new b(emotionPackage, this.aBE, new Runnable() { // from class: com.kwad.components.ct.emotion.a.c.2
                @Override // java.lang.Runnable
                public final void run() {
                    c.this.aBS.decrementAndGet();
                }
            });
            this.aBQ.put(emotionPackage.id, bVar);
            if (emotionPackage.emotions != null) {
                Iterator<EmotionInfo> it = emotionPackage.emotions.iterator();
                while (it.hasNext()) {
                    new a(it.next()).a(bVar);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(EmotionInfo emotionInfo, a aVar) {
        this.aBP.put(emotionInfo.id, emotionInfo);
        Iterator<EmotionCode> it = emotionInfo.emotionCodes.iterator();
        while (it.hasNext()) {
            Iterator<String> it2 = it.next().codes.iterator();
            while (it2.hasNext()) {
                this.aBO.put(it2.next(), aVar);
            }
        }
    }

    public final Bitmap b(Context context, String str, int i) {
        a aVar = this.aBO.get(str);
        Bitmap bitmapDF = aVar != null ? aVar.DF() : null;
        return bitmapDF != null ? bitmapDF : BitmapFactory.decodeResource(context.getResources(), i);
    }

    private String bD(String str) {
        return this.aBO.get(str).aBV;
    }

    public final Bitmap bE(String str) {
        return com.kwad.components.ct.emotion.b.d.e(bD(str), true);
    }

    public final boolean bF(String str) {
        return this.aBO.containsKey(str);
    }

    class a {
        private EmotionInfo aBU;
        private String aBV;
        private boolean aBW;

        static /* synthetic */ boolean a(a aVar, boolean z) {
            aVar.aBW = true;
            return true;
        }

        a(EmotionInfo emotionInfo) {
            this.aBU = emotionInfo;
            this.aBV = emotionInfo.id;
        }

        final void a(final b bVar) {
            Bitmap bitmapE = com.kwad.components.ct.emotion.b.d.e(this.aBU.id, false);
            if (bitmapE != null) {
                c.aBL.put(this.aBU.id, new SoftReference(bitmapE));
                a(this.aBU);
                bVar.Dy();
            } else {
                c.this.aBR.a(this.aBU, false, new d.a() { // from class: com.kwad.components.ct.emotion.a.c.a.1
                    @Override // com.kwad.components.ct.emotion.b.d.a
                    public final void onSuccess(String str) {
                        c.aBL.put(a.this.aBU.id, new SoftReference(BitmapFactory.decodeFile(str)));
                        a aVar = a.this;
                        aVar.a(aVar.aBU);
                        bVar.Dy();
                    }

                    @Override // com.kwad.components.ct.emotion.b.d.a
                    public final void onError() {
                        bVar.DB();
                    }
                });
            }
            if (!com.kwad.components.ct.emotion.b.b.DO().d(this.aBU.id, true)) {
                c.this.aBR.a(this.aBU, true, new d.a() { // from class: com.kwad.components.ct.emotion.a.c.a.2
                    @Override // com.kwad.components.ct.emotion.b.d.a
                    public final void onSuccess(String str) {
                        a.a(a.this, true);
                        a aVar = a.this;
                        aVar.a(aVar.aBU);
                        bVar.Dz();
                    }

                    @Override // com.kwad.components.ct.emotion.b.d.a
                    public final void onError() {
                        bVar.DB();
                    }
                });
                return;
            }
            this.aBW = true;
            a(this.aBU);
            bVar.Dz();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(EmotionInfo emotionInfo) {
            if (c.aBL.get(emotionInfo.id) == null || !this.aBW) {
                return;
            }
            c.this.a(emotionInfo, this);
        }

        final Bitmap DF() {
            SoftReference softReference = (SoftReference) c.aBL.get(this.aBV);
            Bitmap bitmap = softReference != null ? (Bitmap) softReference.get() : null;
            if (bitmap != null && !bitmap.isRecycled()) {
                return bitmap;
            }
            Bitmap bitmapE = com.kwad.components.ct.emotion.b.d.e(this.aBU.id, false);
            c.aBL.put(this.aBV, new SoftReference(bitmapE));
            return bitmapE;
        }
    }
}
