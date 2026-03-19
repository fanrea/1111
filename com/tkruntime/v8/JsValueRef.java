package com.tkruntime.v8;

import java.lang.ref.WeakReference;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public class JsValueRef<T> {
    private boolean mIsWeak = false;
    private WeakReference mOwner;
    private V8Value mVal;

    protected JsValueRef(V8Value v8Value, Object obj) {
        this.mVal = null;
        this.mOwner = null;
        this.mVal = v8Value;
        this.mVal.addRef();
        this.mOwner = new WeakReference(obj);
    }

    public T get() {
        T t = (T) this.mVal;
        if (t == null) {
            return null;
        }
        return t;
    }

    public Object getOwner() {
        WeakReference weakReference = this.mOwner;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    public void setWeak() {
        if (this.mIsWeak) {
            return;
        }
        this.mIsWeak = true;
        this.mVal.releaseRef();
        if (this.mVal.isReleased()) {
            return;
        }
        this.mVal.setWeak();
    }
}
