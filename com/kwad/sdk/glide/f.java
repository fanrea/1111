package com.kwad.sdk.glide;

import android.content.Context;
import android.widget.ImageView;
import com.kwad.sdk.glide.request.SingleRequest;
import com.kwad.sdk.glide.request.a.j;
import com.kwad.sdk.glide.request.i;
import com.kwad.sdk.glide.request.k;
import com.kwad.sdk.utils.ax;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class f<TranscodeType> extends com.kwad.sdk.glide.request.b<f<TranscodeType>> implements Cloneable {
    protected static final i bQf = new i().a(com.kwad.sdk.glide.load.engine.h.bTr).b(Priority.LOW).cU(true);
    private final e bPB;
    private final c bPw;
    private final g bQg;
    private final Class<TranscodeType> bQh;
    private h<?, ? super TranscodeType> bQi;
    private Object bQj;
    private List<com.kwad.sdk.glide.request.h<TranscodeType>> bQk;
    private f<TranscodeType> bQl;
    private f<TranscodeType> bQm;
    private Float bQn;
    private boolean bQo = true;
    private boolean bQp;
    private boolean bQq;
    private final Context dR;

    @Override // com.kwad.sdk.glide.request.b
    public /* synthetic */ com.kwad.sdk.glide.request.b b(com.kwad.sdk.glide.request.b bVar) {
        return a((com.kwad.sdk.glide.request.b<?>) bVar);
    }

    protected f(c cVar, g gVar, Class<TranscodeType> cls, Context context) {
        this.bPw = cVar;
        this.bQg = gVar;
        this.bQh = cls;
        this.dR = context;
        this.bQi = gVar.h(cls);
        this.bPB = cVar.afc();
        au(gVar.aff());
        a(gVar.afg());
    }

    private void au(List<com.kwad.sdk.glide.request.h<Object>> list) {
        Iterator<com.kwad.sdk.glide.request.h<Object>> it = list.iterator();
        while (it.hasNext()) {
            b((com.kwad.sdk.glide.request.h) it.next());
        }
    }

    public f<TranscodeType> a(com.kwad.sdk.glide.request.b<?> bVar) {
        ax.checkNotNull(bVar);
        return (f) super.b(bVar);
    }

    public f<TranscodeType> a(com.kwad.sdk.glide.request.h<TranscodeType> hVar) {
        this.bQk = null;
        return b(hVar);
    }

    public f<TranscodeType> b(com.kwad.sdk.glide.request.h<TranscodeType> hVar) {
        if (hVar != null) {
            if (this.bQk == null) {
                this.bQk = new ArrayList();
            }
            this.bQk.add(hVar);
        }
        return this;
    }

    public f<TranscodeType> u(Object obj) {
        return v(obj);
    }

    private f<TranscodeType> v(Object obj) {
        this.bQj = obj;
        this.bQp = true;
        return this;
    }

    public f<TranscodeType> hh(String str) {
        return v(str);
    }

    public f<TranscodeType> g(byte[] bArr) {
        f<TranscodeType> fVarV = v(bArr);
        if (!fVarV.aiG()) {
            fVarV = fVarV.a(i.b(com.kwad.sdk.glide.load.engine.h.bTq));
        }
        return !fVarV.aiH() ? fVarV.a(i.cV(true)) : fVarV;
    }

    @Override // com.kwad.sdk.glide.request.b
    /* renamed from: afk, reason: merged with bridge method [inline-methods] */
    public f<TranscodeType> clone() {
        f<TranscodeType> fVar = (f) super.clone();
        fVar.bQi = fVar.bQi.clone();
        return fVar;
    }

    public final <Y extends j<TranscodeType>> Y b(Y y) {
        return (Y) a((f<TranscodeType>) y, (com.kwad.sdk.glide.request.h) null, com.kwad.sdk.glide.e.e.ajy());
    }

    private <Y extends j<TranscodeType>> Y a(Y y, com.kwad.sdk.glide.request.h<TranscodeType> hVar, Executor executor) {
        return (Y) a(y, hVar, this, executor);
    }

    private <Y extends j<TranscodeType>> Y a(Y y, com.kwad.sdk.glide.request.h<TranscodeType> hVar, com.kwad.sdk.glide.request.b<?> bVar, Executor executor) {
        ax.checkNotNull(y);
        if (!this.bQp) {
            throw new IllegalArgumentException("You must call #load() before calling #into()");
        }
        com.kwad.sdk.glide.request.e eVarB = b(y, hVar, bVar, executor);
        com.kwad.sdk.glide.request.e request = y.getRequest();
        if (eVarB.c(request) && !a(bVar, request)) {
            eVarB.recycle();
            if (!((com.kwad.sdk.glide.request.e) ax.checkNotNull(request)).isRunning()) {
                request.begin();
            }
            return y;
        }
        this.bQg.c(y);
        y.setRequest(eVarB);
        this.bQg.a(y, eVarB);
        return y;
    }

    private static boolean a(com.kwad.sdk.glide.request.b<?> bVar, com.kwad.sdk.glide.request.e eVar) {
        return !bVar.aiQ() && eVar.isComplete();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x004c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.kwad.sdk.glide.request.a.k<android.widget.ImageView, TranscodeType> b(android.widget.ImageView r4) {
        /*
            r3 = this;
            com.kwad.sdk.glide.e.j.ajB()
            com.kwad.sdk.utils.ax.checkNotNull(r4)
            boolean r0 = r3.aiz()
            if (r0 != 0) goto L4c
            boolean r0 = r3.aiy()
            if (r0 == 0) goto L4c
            android.widget.ImageView$ScaleType r0 = r4.getScaleType()
            if (r0 == 0) goto L4c
            int[] r0 = com.kwad.sdk.glide.f.AnonymousClass1.$SwitchMap$android$widget$ImageView$ScaleType
            android.widget.ImageView$ScaleType r1 = r4.getScaleType()
            int r1 = r1.ordinal()
            r0 = r0[r1]
            switch(r0) {
                case 1: goto L43;
                case 2: goto L3a;
                case 3: goto L31;
                case 4: goto L31;
                case 5: goto L31;
                case 6: goto L28;
                default: goto L27;
            }
        L27:
            goto L4c
        L28:
            com.kwad.sdk.glide.request.b r0 = r3.clone()
            com.kwad.sdk.glide.request.b r0 = r0.aiC()
            goto L4d
        L31:
            com.kwad.sdk.glide.request.b r0 = r3.clone()
            com.kwad.sdk.glide.request.b r0 = r0.aiB()
            goto L4d
        L3a:
            com.kwad.sdk.glide.request.b r0 = r3.clone()
            com.kwad.sdk.glide.request.b r0 = r0.aiC()
            goto L4d
        L43:
            com.kwad.sdk.glide.request.b r0 = r3.clone()
            com.kwad.sdk.glide.request.b r0 = r0.aiA()
            goto L4d
        L4c:
            r0 = r3
        L4d:
            com.kwad.sdk.glide.e r1 = r3.bPB
            java.lang.Class<TranscodeType> r2 = r3.bQh
            com.kwad.sdk.glide.request.a.k r4 = r1.a(r4, r2)
            r1 = 0
            java.util.concurrent.Executor r2 = com.kwad.sdk.glide.e.e.ajy()
            com.kwad.sdk.glide.request.a.j r4 = r3.a(r4, r1, r0, r2)
            com.kwad.sdk.glide.request.a.k r4 = (com.kwad.sdk.glide.request.a.k) r4
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.glide.f.b(android.widget.ImageView):com.kwad.sdk.glide.request.a.k");
    }

    @Deprecated
    public final com.kwad.sdk.glide.request.d<TranscodeType> M(int i, int i2) {
        return N(1080, 2340);
    }

    public final com.kwad.sdk.glide.request.d<TranscodeType> afl() {
        return N(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    private com.kwad.sdk.glide.request.d<TranscodeType> N(int i, int i2) {
        com.kwad.sdk.glide.request.g gVar = new com.kwad.sdk.glide.request.g(i, i2);
        return (com.kwad.sdk.glide.request.d) a((f<TranscodeType>) gVar, gVar, com.kwad.sdk.glide.e.e.ajz());
    }

    private j<TranscodeType> O(int i, int i2) {
        return b((f<TranscodeType>) com.kwad.sdk.glide.request.a.g.b(this.bQg, Integer.MIN_VALUE, Integer.MIN_VALUE));
    }

    public final j<TranscodeType> afm() {
        return O(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    /* renamed from: com.kwad.sdk.glide.f$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$android$widget$ImageView$ScaleType;
        static final /* synthetic */ int[] bQr;

        static {
            int[] iArr = new int[Priority.values().length];
            bQr = iArr;
            try {
                iArr[Priority.LOW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                bQr[Priority.NORMAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                bQr[Priority.HIGH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                bQr[Priority.IMMEDIATE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[ImageView.ScaleType.values().length];
            $SwitchMap$android$widget$ImageView$ScaleType = iArr2;
            try {
                iArr2[ImageView.ScaleType.CENTER_CROP.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.FIT_CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.FIT_START.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.FIT_END.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.FIT_XY.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.CENTER.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$android$widget$ImageView$ScaleType[ImageView.ScaleType.MATRIX.ordinal()] = 8;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    private Priority a(Priority priority) {
        int i = AnonymousClass1.bQr[priority.ordinal()];
        if (i == 1) {
            return Priority.NORMAL;
        }
        if (i == 2) {
            return Priority.HIGH;
        }
        if (i == 3 || i == 4) {
            return Priority.IMMEDIATE;
        }
        throw new IllegalArgumentException("unknown priority: " + agg());
    }

    private com.kwad.sdk.glide.request.e b(j<TranscodeType> jVar, com.kwad.sdk.glide.request.h<TranscodeType> hVar, com.kwad.sdk.glide.request.b<?> bVar, Executor executor) {
        return a(jVar, hVar, (com.kwad.sdk.glide.request.f) null, this.bQi, bVar.agg(), bVar.aiS(), bVar.aiU(), bVar, executor);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private com.kwad.sdk.glide.request.e a(j<TranscodeType> jVar, com.kwad.sdk.glide.request.h<TranscodeType> hVar, com.kwad.sdk.glide.request.f fVar, h<?, ? super TranscodeType> hVar2, Priority priority, int i, int i2, com.kwad.sdk.glide.request.b<?> bVar, Executor executor) {
        com.kwad.sdk.glide.request.f fVar2;
        com.kwad.sdk.glide.request.f cVar;
        if (this.bQm != null) {
            cVar = new com.kwad.sdk.glide.request.c(fVar);
            fVar2 = cVar;
        } else {
            fVar2 = null;
            cVar = fVar;
        }
        com.kwad.sdk.glide.request.e eVarB = b(jVar, hVar, cVar, hVar2, priority, i, i2, bVar, executor);
        if (fVar2 == null) {
            return eVarB;
        }
        int iAiS = this.bQm.aiS();
        int iAiU = this.bQm.aiU();
        if (com.kwad.sdk.glide.e.j.Y(i, i2) && !this.bQm.aiT()) {
            iAiS = bVar.aiS();
            iAiU = bVar.aiU();
        }
        f<TranscodeType> fVar3 = this.bQm;
        com.kwad.sdk.glide.request.c cVar2 = fVar2;
        cVar2.a(eVarB, fVar3.a(jVar, hVar, fVar2, fVar3.bQi, fVar3.agg(), iAiS, iAiU, this.bQm, executor));
        return cVar2;
    }

    private com.kwad.sdk.glide.request.e b(j<TranscodeType> jVar, com.kwad.sdk.glide.request.h<TranscodeType> hVar, com.kwad.sdk.glide.request.f fVar, h<?, ? super TranscodeType> hVar2, Priority priority, int i, int i2, com.kwad.sdk.glide.request.b<?> bVar, Executor executor) {
        f<TranscodeType> fVar2 = this.bQl;
        if (fVar2 != null) {
            if (this.bQq) {
                throw new IllegalStateException("You cannot use a request as both the main request and a thumbnail, consider using clone() on the request(s) passed to thumbnail()");
            }
            h<?, ? super TranscodeType> hVar3 = fVar2.bQo ? hVar2 : fVar2.bQi;
            Priority priorityAgg = fVar2.aiR() ? this.bQl.agg() : a(priority);
            int iAiS = this.bQl.aiS();
            int iAiU = this.bQl.aiU();
            if (com.kwad.sdk.glide.e.j.Y(i, i2) && !this.bQl.aiT()) {
                iAiS = bVar.aiS();
                iAiU = bVar.aiU();
            }
            int i3 = iAiS;
            int i4 = iAiU;
            k kVar = new k(fVar);
            com.kwad.sdk.glide.request.e eVarA = a(jVar, hVar, bVar, kVar, hVar2, priority, i, i2, executor);
            this.bQq = true;
            f<TranscodeType> fVar3 = this.bQl;
            com.kwad.sdk.glide.request.e eVarA2 = fVar3.a(jVar, hVar, kVar, hVar3, priorityAgg, i3, i4, fVar3, executor);
            this.bQq = false;
            kVar.a(eVarA, eVarA2);
            return kVar;
        }
        if (this.bQn != null) {
            k kVar2 = new k(fVar);
            kVar2.a(a(jVar, hVar, bVar, kVar2, hVar2, priority, i, i2, executor), a(jVar, hVar, bVar.clone().O(this.bQn.floatValue()), kVar2, hVar2, a(priority), i, i2, executor));
            return kVar2;
        }
        return a(jVar, hVar, bVar, fVar, hVar2, priority, i, i2, executor);
    }

    private com.kwad.sdk.glide.request.e a(j<TranscodeType> jVar, com.kwad.sdk.glide.request.h<TranscodeType> hVar, com.kwad.sdk.glide.request.b<?> bVar, com.kwad.sdk.glide.request.f fVar, h<?, ? super TranscodeType> hVar2, Priority priority, int i, int i2, Executor executor) {
        Context context = this.dR;
        e eVar = this.bPB;
        return SingleRequest.a(context, eVar, this.bQj, this.bQh, bVar, i, i2, priority, jVar, hVar, this.bQk, fVar, eVar.afh(), hVar2.afu(), executor);
    }
}
