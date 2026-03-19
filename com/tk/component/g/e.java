package com.tk.component.g;

import android.content.Context;
import android.support.v7.widget.al;
import android.view.View;
import com.kuaishou.tk.export.NativeModuleInitParams;
import com.tk.component.scroll.b.b.h;
import com.tk.core.component.TKBaseNativeModule;
import com.tk.core.o.ac;
import com.tk.core.o.ad;
import com.tk.core.o.o;
import com.tkruntime.v8.JsValueRef;
import com.tkruntime.v8.V8Array;
import com.tkruntime.v8.V8Function;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class e extends com.tk.core.component.e<h> implements View.OnAttachStateChangeListener, a, b {
    private boolean Ph;
    public boolean SJ;
    public long SK;
    public V8Function SS;
    private JsValueRef<V8Function> ST;
    public V8Function SU;
    private JsValueRef<V8Function> SV;
    public V8Function SX;
    private JsValueRef<V8Function> SY;
    public V8Function XA;
    public V8Function XB;
    public int XC;
    private com.tk.component.scroll.b.b.e XD;
    public boolean XE;
    public V8Function XF;
    private c Xn;
    private h.g Xo;
    private com.tk.component.scroll.b.b.c Xp;
    private com.tk.component.g.a.a Xq;
    private d Xr;
    private f Xs;
    private boolean Xt;
    private boolean Xu;
    private boolean Xv;
    private boolean Xw;
    public int Xx;
    public int Xy;
    public V8Function Xz;

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
    }

    public e(NativeModuleInitParams nativeModuleInitParams) {
        super(nativeModuleInitParams);
        this.Ph = false;
        this.Xu = false;
        this.Xv = false;
        this.Xw = false;
        this.Xx = -1;
        this.SK = 400L;
        this.Xy = 1;
        this.SJ = true;
        this.XE = true;
        getView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tk.core.component.e
    /* renamed from: E, reason: merged with bridge method [inline-methods] */
    public h n(Context context) {
        Object[] objArr = this.ZX.args;
        if (objArr != null) {
            if (objArr.length > 0 && (objArr[0] instanceof Boolean)) {
                this.Ph = ((Boolean) objArr[0]).booleanValue();
            }
            if (objArr.length > 1 && (objArr[1] instanceof Boolean)) {
                this.Xt = ((Boolean) objArr[1]).booleanValue();
            }
        }
        h hVar = new h(context);
        hVar.setOffscreenPageLimit(1);
        hVar.setClipToPadding(false);
        hVar.setOrientation(!this.Ph ? 1 : 0);
        if (hVar.getChildCount() > 0) {
            View childAt = hVar.getChildAt(0);
            if (childAt instanceof al) {
                ((al) childAt).setItemAnimator(null);
            }
        }
        hVar.addOnAttachStateChangeListener(this);
        return hVar;
    }

    public final void dr(int i) {
        int i2;
        this.Xx = i;
        if (this.Xu) {
            oL();
            if (this.Xs.oN() <= 0 || (i2 = this.Xx) < 0) {
                return;
            }
            b(i2, false, 0, false);
            this.Xx = -1;
        }
    }

    public final void setScrollEventThrottle(long j) {
        this.SK = j;
        c cVar = this.Xn;
        if (cVar != null) {
            cVar.setScrollEventThrottle(j);
        }
    }

    public final void setOffscreenPageLimit(int i) {
        if (i > 0 || i == -1) {
            this.Xy = i;
            getView().setOffscreenPageLimit(this.Xy);
        }
    }

    public final void N(boolean z) {
        this.SJ = z;
        getView().setUserInputEnabled(z);
    }

    public final void aB(V8Function v8Function) {
        oJ();
        this.Xn.h(ad.retainJsValue(v8Function, this));
        this.Xz = v8Function;
        if (this.Xu && this.Xv) {
            this.Xn.di(getView().getCurrentItem());
        }
    }

    public final void aC(V8Function v8Function) {
        oJ();
        this.Xn.g(ad.retainJsValue(v8Function, this));
        this.XA = v8Function;
    }

    public final void aD(V8Function v8Function) {
        oJ();
        this.Xn.i(ad.retainJsValue(v8Function, this));
        this.XB = v8Function;
        this.Xn.dj(getView().getScrollState());
    }

    public final void ak(V8Function v8Function) {
        ad.unRetainJsValue(this.ST);
        this.ST = ad.retainJsValue(v8Function, this);
        this.SS = this.ST.get();
        oL();
        this.Xs.f(this.ST);
    }

    public final void al(V8Function v8Function) {
        ad.unRetainJsValue(this.SV);
        this.SV = ad.retainJsValue(v8Function, this);
        this.SU = this.SV.get();
        oL();
        this.Xs.d(this.SV);
    }

    public final void am(V8Function v8Function) {
        ad.unRetainJsValue(this.SY);
        this.SY = ad.retainJsValue(v8Function, this);
        this.SX = this.SY.get();
        oL();
        this.Xs.e(this.SY);
    }

    public final void ds(int i) {
        this.XC = i;
        oK();
        com.tk.component.scroll.b.b.e eVar = this.XD;
        if (eVar != null) {
            this.Xp.b(eVar);
        }
        this.XD = new com.tk.component.scroll.b.b.e(o.eb(i));
        this.Xp.a(this.XD);
        getView().oy();
    }

    public final void setClipChildren(boolean z) {
        this.XE = z;
        getView().setClipChildren(z);
    }

    public final void aE(V8Function v8Function) {
        JsValueRef<V8Function> jsValueRefRetainJsValue = ad.retainJsValue(v8Function, this);
        this.XF = v8Function;
        oM();
        this.Xq.j(jsValueRefRetainJsValue);
    }

    public final void a(int i, boolean z, int i2, boolean z2) {
        b(i, z, i2, z2);
    }

    public final void d(V8Array v8Array) {
        Map<Float, com.tk.component.g.a.a.b> mapM;
        if (v8Array == null) {
            return;
        }
        List list = null;
        try {
            list = v8Array.getList();
        } catch (Exception e) {
            com.tk.core.i.a.a("TKViewPager2", "ViewPager2 setKeyFramePageTransformer error", e);
        }
        if (list == null || list.isEmpty() || (mapM = com.tk.component.g.a.c.m(list)) == null || mapM.isEmpty()) {
            return;
        }
        h.g gVar = this.Xo;
        if (gVar != null) {
            b(gVar);
        }
        com.tk.component.g.a.b bVar = new com.tk.component.g.a.b(mapM);
        c(bVar);
        this.Xo = bVar;
        getView().oy();
    }

    private void b(int i, boolean z, int i2, boolean z2) {
        oL();
        int iMin = Math.min(this.Xs.oN() - 1, Math.max(i, 0));
        if (this.Xs.oO()) {
            int currentItem = getView().getCurrentItem();
            if (!z && currentItem < 10000) {
                int itemCount = this.Xs.getItemCount() / 2;
                currentItem = itemCount - this.Xs.cU(itemCount);
            } else {
                iMin -= this.Xs.cU(currentItem);
            }
            iMin += currentItem;
        }
        oI();
        this.Xr.a(iMin, z, i2, z2);
    }

    public final void c(int i, boolean z, int i2, boolean z2) {
        oL();
        int currentItem = getView().getCurrentItem();
        int iMin = Math.min(this.Xs.getItemCount() - 1, Math.max(i + currentItem, 0));
        if (currentItem != iMin) {
            oI();
            this.Xr.a(iMin, z, i2, z2);
        }
    }

    public final void cV(int i) {
        oL();
        int iCU = this.Xs.cU(getView().getCurrentItem());
        this.Xs.cX(i);
        this.Xu = true;
        int i2 = this.Xx;
        if (i2 > 0) {
            b(i2, false, 0, false);
            this.Xx = -1;
        } else {
            b(iCU, false, 0, false);
        }
    }

    public final void dX() {
        d dVar = this.Xr;
        if (dVar == null) {
            getView().og();
        } else {
            dVar.dX();
        }
    }

    private void c(h.g gVar) {
        oK();
        this.Xp.a(gVar);
    }

    private void b(h.g gVar) {
        oK();
        this.Xp.b(gVar);
    }

    private void oI() {
        if (this.Xr != null) {
            return;
        }
        this.Xr = new d(getView());
    }

    private void oJ() {
        if (this.Xn != null) {
            return;
        }
        this.Xn = new c(this, pO());
        this.Xn.a(this);
        this.Xn.setScrollEventThrottle(this.SK);
        getView().c(this.Xn);
    }

    private void oK() {
        if (this.Xp != null) {
            return;
        }
        this.Xp = new com.tk.component.scroll.b.b.c();
        getView().setPageTransformer(this.Xp);
    }

    private void oL() {
        if (this.Xs != null) {
            return;
        }
        this.Xs = new f(pO(), this.Xt);
        getView().setAdapter(this.Xs);
    }

    private void oM() {
        if (this.Xq == null) {
            this.Xq = new com.tk.component.g.a.a(pO());
        }
        h.g gVar = this.Xo;
        if (gVar != this.Xq) {
            if (gVar != null) {
                b(gVar);
            }
            c(this.Xq);
            this.Xo = this.Xq;
            getView().post(new Runnable() { // from class: com.tk.component.g.e.1
                @Override // java.lang.Runnable
                public final void run() {
                    e.this.getView().oy();
                }
            });
        }
    }

    @Override // com.tk.component.g.a
    public final int cU(int i) {
        oL();
        return this.Xs.cU(i);
    }

    @Override // com.tk.component.g.b
    public final void oF() {
        if (this.Xw) {
            return;
        }
        this.Xw = this.Xz != null;
    }

    @Override // com.tk.component.g.b
    public final void oG() {
        c cVar = this.Xn;
        if (cVar != null) {
            cVar.am(getView().oe());
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        this.Xv = true;
        c cVar = this.Xn;
        if (cVar == null || this.Xw || !this.Xu) {
            return;
        }
        cVar.di(getView().getCurrentItem());
    }

    @Override // com.tk.core.component.e, com.tk.core.component.TKBaseNativeModule
    public final void ih() {
        super.ih();
        c cVar = this.Xn;
        if (cVar != null) {
            cVar.nG();
        }
        f fVar = this.Xs;
        if (fVar != null) {
            fVar.nG();
        }
        com.tk.component.g.a.a aVar = this.Xq;
        if (aVar != null) {
            aVar.nG();
        }
    }

    @Override // com.tk.core.component.e, com.tk.core.component.TKBaseNativeModule
    public final void a(TKBaseNativeModule.DestroyReason destroyReason, boolean z) {
        super.a(destroyReason, z);
        com.tk.component.g.a.a aVar = this.Xq;
        if (aVar != null) {
            aVar.onDestroy();
        }
        c cVar = this.Xn;
        if (cVar != null) {
            cVar.oH();
        }
        f fVar = this.Xs;
        if (fVar != null) {
            fVar.onDestroy();
        }
        d dVar = this.Xr;
        if (dVar != null) {
            dVar.oH();
        }
        if (z) {
            mN();
        } else {
            ac.runOnUiThread(new Runnable() { // from class: com.tk.component.g.e.2
                @Override // java.lang.Runnable
                public final void run() {
                    e.this.mN();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mN() {
        c cVar = this.Xn;
        if (cVar != null) {
            cVar.onDestroy();
        }
        d dVar = this.Xr;
        if (dVar != null) {
            dVar.onDestroy();
        }
        getView().removeOnAttachStateChangeListener(this);
    }
}
