package com.tk.core.d.a;

import com.kuaishou.tk.api.export.ITKViewContainer;
import java.lang.ref.WeakReference;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class a {
    private Object[] ahL;
    private WeakReference<ITKViewContainer.IJS2NativeInvoker> ahM;

    public final void setData(Object[] objArr) {
        this.ahL = objArr;
    }

    public final void a(ITKViewContainer.IJS2NativeInvoker iJS2NativeInvoker) {
        WeakReference<ITKViewContainer.IJS2NativeInvoker> weakReference = this.ahM;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.ahM = new WeakReference<>(iJS2NativeInvoker);
    }

    public final Object[] rB() {
        return this.ahL;
    }
}
