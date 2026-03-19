package com.tkruntime.v8;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public class NativeObjectWrapper {
    private boolean mIsNeedReadPropertyFromJs;
    private Object mNativeObject;

    public static NativeObjectWrapper wrapNativeObject(Object obj) {
        return wrapNativeObject(obj, false);
    }

    public static NativeObjectWrapper wrapNativeObject(Object obj, boolean z) {
        return new NativeObjectWrapper(obj, z);
    }

    private NativeObjectWrapper(Object obj, boolean z) {
        this.mNativeObject = obj;
        this.mIsNeedReadPropertyFromJs = z;
    }

    public Object getNativeObject() {
        return this.mNativeObject;
    }

    public boolean isNeedReadPropertyFromJs() {
        return this.mIsNeedReadPropertyFromJs;
    }
}
