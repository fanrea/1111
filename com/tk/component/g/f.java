package com.tk.component.g;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.kuaishou.tk.export.NativeModuleInitParams;
import com.kwad.components.ct.api.tube.KSTubeParamInner;
import com.tk.core.component.view.TKView;
import com.tk.core.o.ad;
import com.tkruntime.v8.V8Object;
import com.tkruntime.v8.V8ObjectProxy;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class f extends com.tk.component.listview.a.a {
    private boolean XH;
    protected final List<V8Object> XI;
    private final boolean Xt;

    @Override // com.tk.component.listview.a.a
    public final void aJ(View view) {
    }

    public f(com.tk.core.bridge.b bVar, boolean z) {
        super(bVar);
        this.XI = new ArrayList();
        this.Xt = z;
    }

    @Override // com.tk.component.listview.a.a, android.support.v7.widget.al.a
    /* renamed from: f */
    public final com.tk.component.listview.a.b b(ViewGroup viewGroup, int i) {
        if (this.mIsDestroy) {
            return super.b(viewGroup, i);
        }
        V8Object v8ObjectProxy = new V8ObjectProxy(this.mTKJSContext.pj().pi(), "ViewPager2-Element");
        TKView tKView = new TKView(new NativeModuleInitParams.Builder(this.mTKJSContext, v8ObjectProxy).build());
        v8ObjectProxy.setNativeObject(tKView);
        this.XI.add(v8ObjectProxy);
        tKView.getView().setLayoutParams(nF());
        try {
            V8Object v8Object = (V8Object) this.Tk.get().call(null, Integer.valueOf(i));
            com.tk.core.component.e eVar = (com.tk.core.component.e) this.mTKJSContext.getNativeModule(v8Object);
            eVar.aaW = true;
            int i2 = this.To;
            this.To++;
            this.Tq.add(i2, ad.retainJsValue(eVar.getJsObj(), this));
            tKView.d(v8Object);
            return new com.tk.component.listview.a.b(tKView.getView(), i2);
        } catch (Throwable th) {
            com.tk.core.exception.a.a(this.mTKJSContext, th);
            return new com.tk.component.listview.a.b(new FrameLayout(viewGroup.getContext()), this.To);
        }
    }

    @Override // com.tk.component.listview.a.a
    public final ViewGroup.LayoutParams nF() {
        return new ViewGroup.LayoutParams(-1, -1);
    }

    @Override // com.tk.component.listview.a.a, android.support.v7.widget.al.a
    /* renamed from: a */
    public final void b(com.tk.component.listview.a.b bVar, int i) {
        super.b(bVar, cU(i));
    }

    @Override // com.tk.component.listview.a.a, android.support.v7.widget.al.a
    public final int getItemViewType(int i) {
        return super.getItemViewType(cU(i));
    }

    @Override // com.tk.component.listview.a.a, android.support.v7.widget.al.a
    public final int getItemCount() {
        return oO() ? KSTubeParamInner.FREE_ALL : oN();
    }

    @Override // com.tk.component.listview.a.a
    public final void cX(int i) {
        this.XH = i > 1;
        super.cX(i);
    }

    public final int oN() {
        return super.getItemCount();
    }

    public final int cU(int i) {
        return oO() ? i % oN() : i;
    }

    public final boolean oO() {
        return this.Xt && this.XH;
    }

    @Override // com.tk.component.listview.a.a
    public final void nG() {
        super.nG();
        for (V8Object v8Object : this.XI) {
            if (v8Object != null && !v8Object.isReleased()) {
                v8Object.setWeak();
            }
        }
        this.XI.clear();
    }
}
