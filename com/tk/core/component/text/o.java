package com.tk.core.component.text;

import android.widget.TextView;
import com.kuaishou.tk.export.NativeModuleInitParams;
import com.tk.core.component.TKBaseNativeModule;
import com.tkruntime.v8.V8Object;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Deprecated
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class o extends TKBaseNativeModule {
    private final k afT;
    private final List<V8Object> afU;

    public o(NativeModuleInitParams nativeModuleInitParams) {
        super(nativeModuleInitParams);
        this.afT = new k(getTKContext().getContext(), pn(), pq(), getVersionCode());
        this.afU = new ArrayList();
    }

    public final void A(V8Object v8Object) {
        this.afT.a(getNativeModule(v8Object));
        this.afU.add(v8Object);
    }

    public final void rp() {
        this.afT.rp();
        Iterator<V8Object> it = this.afU.iterator();
        while (it.hasNext()) {
            this.afT.a(getNativeModule(it.next()));
        }
    }

    @Override // com.tk.core.component.TKBaseNativeModule
    public final void ih() {
        super.ih();
        this.afT.ih();
    }

    public final CharSequence a(String str, TextView textView) {
        return this.afT.a(str, textView, pO());
    }
}
