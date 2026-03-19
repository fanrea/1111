package com.tkruntime.v8;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public abstract class V8Value implements Releasable {
    public static final int BINDING_OBJECT = 17;
    public static final int BOOLEAN = 3;
    public static final int BYTE = 9;
    public static final int DOUBLE = 2;
    public static final int FLOAT_32_ARRAY = 16;
    public static final int FLOAT_64_ARRAY = 2;
    public static final int INDEXED_STRING = 21;
    public static final int INTEGER = 1;
    public static final int INT_16_ARRAY = 13;
    public static final int INT_32_ARRAY = 1;
    public static final int INT_8_ARRAY = 9;
    public static final int LONG = 23;
    public static final int NULL = 0;
    public static final int STRING = 4;
    public static final int UNDEFINED = 99;
    public static final int UNKNOWN = 0;
    public static final int UNSIGNED_INT_16_ARRAY = 14;
    public static final int UNSIGNED_INT_32_ARRAY = 15;
    public static final int UNSIGNED_INT_8_ARRAY = 11;
    public static final int UNSIGNED_INT_8_CLAMPED_ARRAY = 12;
    public static final int V8_ARRAY = 5;
    public static final int V8_ARRAY_BUFFER = 10;
    public static final int V8_FUNCTION = 7;
    public static final int V8_HANDLE = 18;
    public static final int V8_MAP = 22;
    public static final int V8_OBJECT = 6;
    public static final int V8_TYPED_ARRAY = 8;
    public static final int V8_WEAK_HANDLE = 19;
    public static final int WEAK_STRING = 20;
    protected long objectHandle;
    public V8 v8;
    protected boolean released = true;
    private int mRefCnt = 0;
    protected boolean releaseCheck = false;

    public boolean isUndefined() {
        return false;
    }

    protected void onJsRefDestroy() {
    }

    protected V8Value() {
    }

    protected V8Value(V8 v8) {
        if (v8 == null) {
            this.v8 = (V8) this;
        } else {
            this.v8 = v8;
        }
    }

    protected void initialize(long j, Object obj) {
        long jInitNewV8Object = this.v8.initNewV8Object(j, this);
        this.released = false;
        addObjectReferenceAndTrackedObj(jInitNewV8Object);
    }

    protected void addObjectReference(long j) {
        this.objectHandle = j;
        this.v8.addTrackedObj(j, this);
    }

    protected void addRef() {
        this.mRefCnt++;
    }

    protected void releaseRef() {
        this.mRefCnt--;
    }

    protected void addObjectReferenceAndTrackedObj(long j) {
        addObjectReference(j);
    }

    public V8 getRuntime() {
        return this.v8;
    }

    public V8Value setWeak() {
        this.v8.checkReleased();
        if (this.mRefCnt <= 0) {
            V8 v8 = this.v8;
            v8.setWeak(v8.getV8RuntimePtr(), getHandle());
        }
        return this;
    }

    public JsValueRef clearWeak(Object obj) {
        this.v8.checkThread();
        this.v8.checkReleased();
        V8 v8 = this.v8;
        v8.clearWeak(v8.getV8RuntimePtr(), getHandle());
        return new JsValueRef(this, obj);
    }

    public boolean isWeak() {
        this.v8.checkThread();
        this.v8.checkReleased();
        V8 v8 = this.v8;
        return v8.isWeak(v8.getV8RuntimePtr(), getHandle());
    }

    @Override // com.tkruntime.v8.Releasable, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.v8.isPendingReleased) {
            return;
        }
        this.v8.checkThread();
        long j = this.objectHandle;
        if (this.released) {
            return;
        }
        this.released = true;
        if (this.v8.removeTrackedObj(j)) {
            V8 v8 = this.v8;
            v8.release(v8.getV8RuntimePtr(), j);
        }
        this.objectHandle = 0L;
    }

    @Override // com.tkruntime.v8.Releasable
    @Deprecated
    public void release() {
        close();
    }

    public boolean isReleased() {
        return this.released;
    }

    public boolean strictEquals(Object obj) {
        this.v8.checkThread();
        checkReleased();
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof V8Value)) {
            return false;
        }
        if (isUndefined() && ((V8Value) obj).isUndefined()) {
            return true;
        }
        V8Value v8Value = (V8Value) obj;
        if (v8Value.isUndefined()) {
            return false;
        }
        V8 v8 = this.v8;
        return v8.strictEquals(v8.getV8RuntimePtr(), getHandle(), v8Value.getHandle());
    }

    public long getHandle() {
        checkReleased();
        return this.objectHandle;
    }

    public boolean equals(Object obj) {
        return strictEquals(obj);
    }

    public boolean jsEquals(Object obj) {
        this.v8.checkThread();
        checkReleased();
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof V8Value)) {
            return false;
        }
        if (isUndefined() && ((V8Value) obj).isUndefined()) {
            return true;
        }
        V8Value v8Value = (V8Value) obj;
        if (v8Value.isUndefined()) {
            return false;
        }
        V8 v8 = this.v8;
        return v8.equals(v8.getV8RuntimePtr(), getHandle(), v8Value.getHandle());
    }

    public int hashCode() {
        return super.hashCode();
    }

    protected void checkReleased() {
        if (this.released) {
            throw new IllegalStateException("Object released");
        }
    }
}
