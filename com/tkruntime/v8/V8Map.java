package com.tkruntime.v8;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public class V8Map extends V8Object {
    public V8Map(V8 v8) {
        this(v8, (Object) null);
    }

    protected V8Map(V8 v8, Object obj) {
        super(v8);
        if (v8 != null) {
            this.v8.checkThread();
            initialize(this.v8.getV8RuntimePtr(), obj);
        }
    }

    public V8Map(V8 v8, long j) {
        super(v8);
        if (v8 != null) {
            this.objectHandle = j;
            this.released = false;
            this.v8.checkThread();
            addObjectReference(this.objectHandle);
        }
    }

    @Override // com.tkruntime.v8.V8Value
    protected void initialize(long j, Object obj) {
        long jInitNewV8Map = this.v8.initNewV8Map(j);
        this.released = false;
        addObjectReferenceAndTrackedObj(jInitNewV8Map);
    }
}
