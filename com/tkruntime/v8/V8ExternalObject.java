package com.tkruntime.v8;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public class V8ExternalObject extends V8Object {
    private Object mExternal;

    public V8ExternalObject(V8 v8, Object obj) {
        super(v8);
        this.mExternal = null;
        this.mExternal = obj;
    }

    public Object getExternalObject() {
        return this.mExternal;
    }
}
