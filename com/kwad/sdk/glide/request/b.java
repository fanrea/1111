package com.kwad.sdk.glide.request;

import aegon.chrome.net.NetError;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.kwad.sdk.glide.Priority;
import com.kwad.sdk.glide.load.DecodeFormat;
import com.kwad.sdk.glide.load.resource.bitmap.DownsampleStrategy;
import com.kwad.sdk.glide.load.resource.bitmap.m;
import com.kwad.sdk.glide.load.resource.bitmap.o;
import com.kwad.sdk.glide.request.b;
import com.kwad.sdk.utils.ax;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public abstract class b<T extends b<T>> implements Cloneable {
    private boolean bSG;
    private boolean bST;
    private boolean bTS;
    private boolean bUm;
    private int bZi;
    private Drawable bZk;
    private int bZl;
    private Drawable bZm;
    private int bZn;
    private Drawable bZr;
    private int bZs;
    private Resources.Theme bZt;
    private boolean bZu;
    private boolean bZv;
    private float bZj = 1.0f;
    private com.kwad.sdk.glide.load.engine.h bSF = com.kwad.sdk.glide.load.engine.h.bTt;
    private Priority bSE = Priority.NORMAL;
    private boolean bSk = true;
    private int bZo = -1;
    private int bZp = -1;
    private com.kwad.sdk.glide.load.c bSv = com.kwad.sdk.glide.d.a.ajw();
    private boolean bZq = true;
    private com.kwad.sdk.glide.load.f bSx = new com.kwad.sdk.glide.load.f();
    private Map<Class<?>, com.kwad.sdk.glide.load.i<?>> bSB = new com.kwad.sdk.glide.e.b();
    private Class<?> bSz = Object.class;
    private boolean bSH = true;

    private static boolean T(int i, int i2) {
        return (i & i2) != 0;
    }

    private T aiZ() {
        return this;
    }

    public T O(float f) {
        if (this.bZu) {
            return (T) clone().O(f);
        }
        if (f < 0.0f || f > 1.0f) {
            throw new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
        }
        this.bZj = f;
        this.bZi |= 2;
        return (T) aiF();
    }

    public T cS(boolean z) {
        if (this.bZu) {
            return (T) clone().cS(z);
        }
        this.bTS = z;
        this.bZi |= 1048576;
        return (T) aiF();
    }

    public T cT(boolean z) {
        if (this.bZu) {
            return (T) clone().cT(z);
        }
        this.bST = z;
        this.bZi |= 524288;
        return (T) aiF();
    }

    public T a(com.kwad.sdk.glide.load.engine.h hVar) {
        if (this.bZu) {
            return (T) clone().a(hVar);
        }
        this.bSF = (com.kwad.sdk.glide.load.engine.h) ax.checkNotNull(hVar);
        this.bZi |= 4;
        return (T) aiF();
    }

    public T b(Priority priority) {
        if (this.bZu) {
            return (T) clone().b(priority);
        }
        this.bSE = (Priority) ax.checkNotNull(priority);
        this.bZi |= 8;
        return (T) aiF();
    }

    public T d(Drawable drawable) {
        if (this.bZu) {
            return (T) clone().d(drawable);
        }
        this.bZm = drawable;
        int i = this.bZi | 64;
        this.bZn = 0;
        this.bZi = i & NetError.ERR_SSL_WEAK_SERVER_EPHEMERAL_DH_KEY;
        return (T) aiF();
    }

    public T e(Drawable drawable) {
        if (this.bZu) {
            return (T) clone().e(drawable);
        }
        this.bZr = drawable;
        int i = this.bZi | 8192;
        this.bZs = 0;
        this.bZi = i & (-16385);
        return (T) aiF();
    }

    public T f(Drawable drawable) {
        if (this.bZu) {
            return (T) clone().f(drawable);
        }
        this.bZk = drawable;
        int i = this.bZi | 16;
        this.bZl = 0;
        this.bZi = i & (-33);
        return (T) aiF();
    }

    public T cU(boolean z) {
        if (this.bZu) {
            return (T) clone().cU(true);
        }
        this.bSk = !z;
        this.bZi |= 256;
        return (T) aiF();
    }

    public T U(int i, int i2) {
        if (this.bZu) {
            return (T) clone().U(i, i2);
        }
        this.bZp = i;
        this.bZo = i2;
        this.bZi |= 512;
        return (T) aiF();
    }

    public T i(com.kwad.sdk.glide.load.c cVar) {
        if (this.bZu) {
            return (T) clone().i(cVar);
        }
        this.bSv = (com.kwad.sdk.glide.load.c) ax.checkNotNull(cVar);
        this.bZi |= 1024;
        return (T) aiF();
    }

    @Override // 
    /* renamed from: afn, reason: merged with bridge method [inline-methods] */
    public T clone() {
        try {
            T t = (T) super.clone();
            com.kwad.sdk.glide.load.f fVar = new com.kwad.sdk.glide.load.f();
            t.bSx = fVar;
            fVar.a(this.bSx);
            com.kwad.sdk.glide.e.b bVar = new com.kwad.sdk.glide.e.b();
            t.bSB = bVar;
            bVar.putAll(this.bSB);
            t.bUm = false;
            t.bZu = false;
            return t;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public <Y> T b(com.kwad.sdk.glide.load.e<Y> eVar, Y y) {
        if (this.bZu) {
            return (T) clone().b((com.kwad.sdk.glide.load.e<com.kwad.sdk.glide.load.e<Y>>) eVar, (com.kwad.sdk.glide.load.e<Y>) y);
        }
        ax.checkNotNull(eVar);
        ax.checkNotNull(y);
        this.bSx.a(eVar, y);
        return (T) aiF();
    }

    public T v(Class<?> cls) {
        if (this.bZu) {
            return (T) clone().v(cls);
        }
        this.bSz = (Class) ax.checkNotNull(cls);
        this.bZi |= 4096;
        return (T) aiF();
    }

    public final boolean aiy() {
        return this.bZq;
    }

    public final boolean aiz() {
        return isSet(2048);
    }

    public T a(DecodeFormat decodeFormat) {
        ax.checkNotNull(decodeFormat);
        return (T) b((com.kwad.sdk.glide.load.e<com.kwad.sdk.glide.load.e>) com.kwad.sdk.glide.load.resource.bitmap.k.bXr, (com.kwad.sdk.glide.load.e) decodeFormat).b((com.kwad.sdk.glide.load.e<com.kwad.sdk.glide.load.e<DecodeFormat>>) com.kwad.sdk.glide.load.resource.d.i.bXr, (com.kwad.sdk.glide.load.e<DecodeFormat>) decodeFormat);
    }

    public T a(DownsampleStrategy downsampleStrategy) {
        return (T) b((com.kwad.sdk.glide.load.e<com.kwad.sdk.glide.load.e>) DownsampleStrategy.bXq, (com.kwad.sdk.glide.load.e) ax.checkNotNull(downsampleStrategy));
    }

    public T aiA() {
        return (T) a(DownsampleStrategy.bXk, new com.kwad.sdk.glide.load.resource.bitmap.g());
    }

    public T aiB() {
        return (T) b(DownsampleStrategy.bXj, new o());
    }

    public T aiC() {
        return (T) b(DownsampleStrategy.bXn, new com.kwad.sdk.glide.load.resource.bitmap.h());
    }

    private T a(DownsampleStrategy downsampleStrategy, com.kwad.sdk.glide.load.i<Bitmap> iVar) {
        b<T> bVarClone = this;
        while (bVarClone.bZu) {
            bVarClone = bVarClone.clone();
        }
        bVarClone.a(downsampleStrategy);
        return (T) bVarClone.a(iVar, false);
    }

    private T b(DownsampleStrategy downsampleStrategy, com.kwad.sdk.glide.load.i<Bitmap> iVar) {
        return (T) a(downsampleStrategy, iVar, false);
    }

    private T a(DownsampleStrategy downsampleStrategy, com.kwad.sdk.glide.load.i<Bitmap> iVar, boolean z) {
        T t = (T) a(downsampleStrategy, iVar);
        t.bSH = true;
        return t;
    }

    public T a(com.kwad.sdk.glide.load.i<Bitmap> iVar) {
        return (T) a(iVar, true);
    }

    public T a(com.kwad.sdk.glide.load.i<Bitmap>... iVarArr) {
        if (iVarArr.length > 1) {
            return (T) a((com.kwad.sdk.glide.load.i<Bitmap>) new com.kwad.sdk.glide.load.d(iVarArr), true);
        }
        if (iVarArr.length == 1) {
            return (T) a(iVarArr[0]);
        }
        return (T) aiF();
    }

    public T b(com.kwad.sdk.glide.load.i<Bitmap> iVar) {
        return (T) a(iVar, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private T a(com.kwad.sdk.glide.load.i<Bitmap> iVar, boolean z) {
        b<T> bVarClone = this;
        while (bVarClone.bZu) {
            bVarClone = bVarClone.clone();
        }
        m mVar = new m(iVar, z);
        bVarClone.a(Bitmap.class, iVar, z);
        bVarClone.a(Drawable.class, mVar, z);
        bVarClone.a(BitmapDrawable.class, mVar.ahO(), z);
        bVarClone.a(com.kwad.sdk.glide.load.resource.d.c.class, new com.kwad.sdk.glide.load.resource.d.f(iVar), z);
        return (T) bVarClone.aiF();
    }

    public <Y> T a(Class<Y> cls, com.kwad.sdk.glide.load.i<Y> iVar) {
        return (T) a((Class) cls, (com.kwad.sdk.glide.load.i) iVar, false);
    }

    private <Y> T a(Class<Y> cls, com.kwad.sdk.glide.load.i<Y> iVar, boolean z) {
        b<T> bVarClone = this;
        while (bVarClone.bZu) {
            bVarClone = bVarClone.clone();
        }
        ax.checkNotNull(cls);
        ax.checkNotNull(iVar);
        bVarClone.bSB.put(cls, iVar);
        int i = bVarClone.bZi | 2048;
        bVarClone.bZi = i;
        bVarClone.bZq = true;
        int i2 = i | 65536;
        bVarClone.bZi = i2;
        bVarClone.bSH = false;
        if (z) {
            bVarClone.bZi = i2 | 131072;
            bVarClone.bSG = true;
        }
        return (T) bVarClone.aiF();
    }

    public T b(b<?> bVar) {
        if (this.bZu) {
            return (T) clone().b(bVar);
        }
        if (T(bVar.bZi, 2)) {
            this.bZj = bVar.bZj;
        }
        if (T(bVar.bZi, 262144)) {
            this.bZv = bVar.bZv;
        }
        if (T(bVar.bZi, 1048576)) {
            this.bTS = bVar.bTS;
        }
        if (T(bVar.bZi, 4)) {
            this.bSF = bVar.bSF;
        }
        if (T(bVar.bZi, 8)) {
            this.bSE = bVar.bSE;
        }
        if (T(bVar.bZi, 16)) {
            this.bZk = bVar.bZk;
            this.bZl = 0;
            this.bZi &= -33;
        }
        if (T(bVar.bZi, 32)) {
            this.bZl = bVar.bZl;
            this.bZk = null;
            this.bZi &= -17;
        }
        if (T(bVar.bZi, 64)) {
            this.bZm = bVar.bZm;
            this.bZn = 0;
            this.bZi &= NetError.ERR_SSL_WEAK_SERVER_EPHEMERAL_DH_KEY;
        }
        if (T(bVar.bZi, 128)) {
            this.bZn = bVar.bZn;
            this.bZm = null;
            this.bZi &= -65;
        }
        if (T(bVar.bZi, 256)) {
            this.bSk = bVar.bSk;
        }
        if (T(bVar.bZi, 512)) {
            this.bZp = bVar.bZp;
            this.bZo = bVar.bZo;
        }
        if (T(bVar.bZi, 1024)) {
            this.bSv = bVar.bSv;
        }
        if (T(bVar.bZi, 4096)) {
            this.bSz = bVar.bSz;
        }
        if (T(bVar.bZi, 8192)) {
            this.bZr = bVar.bZr;
            this.bZs = 0;
            this.bZi &= -16385;
        }
        if (T(bVar.bZi, 16384)) {
            this.bZs = bVar.bZs;
            this.bZr = null;
            this.bZi &= -8193;
        }
        if (T(bVar.bZi, 32768)) {
            this.bZt = bVar.bZt;
        }
        if (T(bVar.bZi, 65536)) {
            this.bZq = bVar.bZq;
        }
        if (T(bVar.bZi, 131072)) {
            this.bSG = bVar.bSG;
        }
        if (T(bVar.bZi, 2048)) {
            this.bSB.putAll(bVar.bSB);
            this.bSH = bVar.bSH;
        }
        if (T(bVar.bZi, 524288)) {
            this.bST = bVar.bST;
        }
        if (!this.bZq) {
            this.bSB.clear();
            int i = this.bZi & (-2049);
            this.bSG = false;
            this.bZi = i & (-131073);
            this.bSH = true;
        }
        this.bZi |= bVar.bZi;
        this.bSx.a(bVar.bSx);
        return (T) aiF();
    }

    public boolean equals(Object obj) {
        if (obj instanceof b) {
            b bVar = (b) obj;
            if (Float.compare(bVar.bZj, this.bZj) == 0 && this.bZl == bVar.bZl && com.kwad.sdk.glide.e.j.c(this.bZk, bVar.bZk) && this.bZn == bVar.bZn && com.kwad.sdk.glide.e.j.c(this.bZm, bVar.bZm) && this.bZs == bVar.bZs && com.kwad.sdk.glide.e.j.c(this.bZr, bVar.bZr) && this.bSk == bVar.bSk && this.bZo == bVar.bZo && this.bZp == bVar.bZp && this.bSG == bVar.bSG && this.bZq == bVar.bZq && this.bZv == bVar.bZv && this.bST == bVar.bST && this.bSF.equals(bVar.bSF) && this.bSE == bVar.bSE && this.bSx.equals(bVar.bSx) && this.bSB.equals(bVar.bSB) && this.bSz.equals(bVar.bSz) && com.kwad.sdk.glide.e.j.c(this.bSv, bVar.bSv) && com.kwad.sdk.glide.e.j.c(this.bZt, bVar.bZt)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return com.kwad.sdk.glide.e.j.a(this.bZt, com.kwad.sdk.glide.e.j.a(this.bSv, com.kwad.sdk.glide.e.j.a(this.bSz, com.kwad.sdk.glide.e.j.a(this.bSB, com.kwad.sdk.glide.e.j.a(this.bSx, com.kwad.sdk.glide.e.j.a(this.bSE, com.kwad.sdk.glide.e.j.a(this.bSF, com.kwad.sdk.glide.e.j.m(this.bST, com.kwad.sdk.glide.e.j.m(this.bZv, com.kwad.sdk.glide.e.j.m(this.bZq, com.kwad.sdk.glide.e.j.m(this.bSG, com.kwad.sdk.glide.e.j.hashCode(this.bZp, com.kwad.sdk.glide.e.j.hashCode(this.bZo, com.kwad.sdk.glide.e.j.m(this.bSk, com.kwad.sdk.glide.e.j.a(this.bZr, com.kwad.sdk.glide.e.j.hashCode(this.bZs, com.kwad.sdk.glide.e.j.a(this.bZm, com.kwad.sdk.glide.e.j.hashCode(this.bZn, com.kwad.sdk.glide.e.j.a(this.bZk, com.kwad.sdk.glide.e.j.hashCode(this.bZl, com.kwad.sdk.glide.e.j.hashCode(this.bZj)))))))))))))))))))));
    }

    public T aiD() {
        this.bUm = true;
        return (T) aiZ();
    }

    public T aiE() {
        if (this.bUm && !this.bZu) {
            throw new IllegalStateException("You cannot auto lock an already locked options object, try clone() first");
        }
        this.bZu = true;
        return (T) aiD();
    }

    private T aiF() {
        if (this.bUm) {
            throw new IllegalStateException("You cannot modify locked T, consider clone()");
        }
        return (T) aiZ();
    }

    public final boolean aiG() {
        return isSet(4);
    }

    public final boolean aiH() {
        return isSet(256);
    }

    public final Map<Class<?>, com.kwad.sdk.glide.load.i<?>> aiI() {
        return this.bSB;
    }

    public final boolean aiJ() {
        return this.bSG;
    }

    public final com.kwad.sdk.glide.load.f agh() {
        return this.bSx;
    }

    public final Class<?> afv() {
        return this.bSz;
    }

    public final com.kwad.sdk.glide.load.engine.h agf() {
        return this.bSF;
    }

    public final Drawable aiK() {
        return this.bZk;
    }

    public final int aiL() {
        return this.bZl;
    }

    public final int aiM() {
        return this.bZn;
    }

    public final Drawable aiN() {
        return this.bZm;
    }

    public final int aiO() {
        return this.bZs;
    }

    public final Drawable aiP() {
        return this.bZr;
    }

    public final Resources.Theme getTheme() {
        return this.bZt;
    }

    public final boolean aiQ() {
        return this.bSk;
    }

    public final com.kwad.sdk.glide.load.c agi() {
        return this.bSv;
    }

    public final boolean aiR() {
        return isSet(8);
    }

    public final Priority agg() {
        return this.bSE;
    }

    public final int aiS() {
        return this.bZp;
    }

    public final boolean aiT() {
        return com.kwad.sdk.glide.e.j.Y(this.bZp, this.bZo);
    }

    public final int aiU() {
        return this.bZo;
    }

    public final float aiV() {
        return this.bZj;
    }

    final boolean agm() {
        return this.bSH;
    }

    private boolean isSet(int i) {
        return T(this.bZi, i);
    }

    public final boolean aiW() {
        return this.bZv;
    }

    public final boolean aiX() {
        return this.bTS;
    }

    public final boolean aiY() {
        return this.bST;
    }
}
