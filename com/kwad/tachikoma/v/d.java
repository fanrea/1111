package com.kwad.tachikoma.v;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.kuaishou.tk.export.NativeModuleInitParams;
import com.kwad.tachikoma.t.g;
import com.kwad.tachikoma.t.j;
import com.kwad.tachikoma.v.f;
import com.tk.core.component.view.TKView;
import com.tkruntime.v8.V8Function;
import java.util.HashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class d extends TKView {
    private g Fq;

    @Override // com.tk.core.component.view.TKView, com.tk.core.component.e
    public final /* synthetic */ View n(Context context) {
        return t(context);
    }

    @Override // com.tk.core.component.view.TKView
    /* renamed from: s */
    public final /* synthetic */ com.tk.core.component.f n(Context context) {
        return t(context);
    }

    public d(NativeModuleInitParams nativeModuleInitParams) {
        super(nativeModuleInitParams);
    }

    private static f t(Context context) {
        return new f(context);
    }

    public final void A(V8Function v8Function) {
        g gVar = this.Fq;
        if (gVar != null) {
            gVar.destroy();
        }
        this.Fq = new g(v8Function, pO());
        ((f) getView()).a(new f.a() { // from class: com.kwad.tachikoma.v.d.1
            @Override // com.kwad.tachikoma.v.f.a
            public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
                if (d.this.Fq != null && motionEvent.getAction() == 0) {
                    HashMap map = new HashMap();
                    float fQ = j.q(d.this.getContext());
                    map.put("x", Float.valueOf(motionEvent.getX() / fQ));
                    map.put("y", Float.valueOf(motionEvent.getY() / fQ));
                    Object objCall = d.this.Fq.call(null, map);
                    if (objCall instanceof Boolean) {
                        return ((Boolean) objCall).booleanValue();
                    }
                }
                return false;
            }
        });
    }

    @Override // com.tk.core.component.view.TKView, com.tk.core.component.e, com.tk.core.component.TKBaseNativeModule
    public final void ih() {
        super.ih();
        g gVar = this.Fq;
        if (gVar != null) {
            gVar.destroy();
        }
    }
}
