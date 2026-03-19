package com.tkruntime.v8;

import com.kuaishou.socket.nano.SocketMessages;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public class V8Array extends V8Object {
    protected V8Array() {
    }

    public V8Array(V8 v8) {
        super(v8);
        v8.checkThread();
    }

    public V8Array(V8 v8, long j) {
        super(v8, j);
    }

    protected V8Array(V8 v8, Object obj) {
        super(v8, obj);
    }

    @Override // com.tkruntime.v8.V8Object
    public String toString() {
        return (this.released || this.v8.isReleased()) ? "[Array released]" : super.toString();
    }

    @Override // com.tkruntime.v8.V8Value
    protected void initialize(long j, Object obj) {
        this.releaseCheck = false;
        long jInitNewV8Array = this.v8.initNewV8Array(j);
        this.released = false;
        addObjectReference(jInitNewV8Array);
    }

    public int length() {
        this.v8.checkThread();
        checkReleased();
        return this.v8.arrayGetSize(this.v8.getV8RuntimePtr(), getHandle());
    }

    public int getType() {
        this.v8.checkThread();
        checkReleased();
        return this.v8.getArrayType(this.v8.getV8RuntimePtr(), getHandle());
    }

    public List getList() {
        this.v8.checkThread();
        checkReleased();
        return this.v8.getList(getHandle());
    }

    public int getInteger(int i) {
        this.v8.checkThread();
        checkReleased();
        return this.v8.arrayGetInteger(this.v8.getV8RuntimePtr(), getHandle(), i);
    }

    public boolean getBoolean(int i) {
        this.v8.checkThread();
        checkReleased();
        return this.v8.arrayGetBoolean(this.v8.getV8RuntimePtr(), getHandle(), i);
    }

    public byte getByte(int i) {
        this.v8.checkThread();
        checkReleased();
        return this.v8.arrayGetByte(this.v8.getV8RuntimePtr(), getHandle(), i);
    }

    public double getDouble(int i) {
        this.v8.checkThread();
        checkReleased();
        return this.v8.arrayGetDouble(this.v8.getV8RuntimePtr(), getHandle(), i);
    }

    public String getString(int i) {
        this.v8.checkThread();
        checkReleased();
        return this.v8.arrayGetString(this.v8.getV8RuntimePtr(), getHandle(), i);
    }

    public Object get(int i) {
        this.v8.checkThread();
        checkReleased();
        return this.v8.arrayGet(this.v8.getV8RuntimePtr(), 6, this.objectHandle, i);
    }

    public V8Array getArray(int i) {
        this.v8.checkThread();
        checkReleased();
        Object objArrayGet = this.v8.arrayGet(this.v8.getV8RuntimePtr(), 5, this.objectHandle, i);
        if (objArrayGet == null || (objArrayGet instanceof V8Array)) {
            return (V8Array) objArrayGet;
        }
        throw new V8ResultUndefined();
    }

    public V8Object getObject(int i) {
        this.v8.checkThread();
        checkReleased();
        Object objArrayGet = this.v8.arrayGet(this.v8.getV8RuntimePtr(), 6, this.objectHandle, i);
        if (objArrayGet == null || (objArrayGet instanceof V8Object)) {
            return (V8Object) objArrayGet;
        }
        throw new V8ResultUndefined();
    }

    public V8Array push(int i) {
        this.v8.checkThread();
        checkReleased();
        this.v8.addArrayIntItem(this.v8.getV8RuntimePtr(), getHandle(), i);
        return this;
    }

    public V8Array push(boolean z) {
        this.v8.checkThread();
        checkReleased();
        this.v8.addArrayBooleanItem(this.v8.getV8RuntimePtr(), getHandle(), z);
        return this;
    }

    public V8Array push(double d) {
        this.v8.checkThread();
        checkReleased();
        this.v8.addArrayDoubleItem(this.v8.getV8RuntimePtr(), getHandle(), d);
        return this;
    }

    public V8Array push(String str) {
        this.v8.checkThread();
        checkReleased();
        if (str == null) {
            this.v8.addArrayNullItem(this.v8.getV8RuntimePtr(), getHandle());
        } else if (str.equals(V8.getUndefined())) {
            this.v8.addArrayUndefinedItem(this.v8.getV8RuntimePtr(), getHandle());
        } else {
            this.v8.addArrayStringItem(this.v8.getV8RuntimePtr(), getHandle(), str);
        }
        return this;
    }

    public V8Array push(V8Value v8Value) {
        this.v8.checkThread();
        checkReleased();
        this.v8.checkRuntime(v8Value);
        if (v8Value == null) {
            this.v8.addArrayNullItem(this.v8.getV8RuntimePtr(), getHandle());
        } else if (v8Value.equals(V8.getUndefined())) {
            this.v8.addArrayUndefinedItem(this.v8.getV8RuntimePtr(), getHandle());
        } else {
            this.v8.addArrayObjectItem(this.v8.getV8RuntimePtr(), getHandle(), v8Value.getHandle());
        }
        return this;
    }

    public V8Array push(Object obj) {
        this.v8.checkThread();
        checkReleased();
        boolean z = obj instanceof V8Value;
        if (z) {
            this.v8.checkRuntime((V8Value) obj);
        }
        if (obj == null) {
            this.v8.addArrayNullItem(this.v8.getV8RuntimePtr(), getHandle());
        } else if (obj.equals(V8.getUndefined())) {
            this.v8.addArrayUndefinedItem(this.v8.getV8RuntimePtr(), getHandle());
        } else if (obj instanceof Double) {
            this.v8.addArrayDoubleItem(this.v8.getV8RuntimePtr(), getHandle(), ((Double) obj).doubleValue());
        } else if (obj instanceof Integer) {
            this.v8.addArrayIntItem(this.v8.getV8RuntimePtr(), getHandle(), ((Integer) obj).intValue());
        } else if (obj instanceof Float) {
            this.v8.addArrayDoubleItem(this.v8.getV8RuntimePtr(), getHandle(), ((Float) obj).doubleValue());
        } else if (obj instanceof Number) {
            this.v8.addArrayDoubleItem(this.v8.getV8RuntimePtr(), getHandle(), ((Number) obj).doubleValue());
        } else if (obj instanceof Boolean) {
            this.v8.addArrayBooleanItem(this.v8.getV8RuntimePtr(), getHandle(), ((Boolean) obj).booleanValue());
        } else if (obj instanceof String) {
            this.v8.addArrayStringItem(this.v8.getV8RuntimePtr(), getHandle(), (String) obj);
        } else if (z) {
            this.v8.addArrayObjectItem(this.v8.getV8RuntimePtr(), getHandle(), ((V8Value) obj).getHandle());
        } else {
            throw new IllegalArgumentException();
        }
        return this;
    }

    public V8Array pushNull() {
        this.v8.checkThread();
        checkReleased();
        this.v8.addArrayNullItem(this.v8.getV8RuntimePtr(), getHandle());
        return this;
    }

    public V8Array pushUndefined() {
        this.v8.checkThread();
        checkReleased();
        this.v8.addArrayUndefinedItem(this.v8.getV8RuntimePtr(), getHandle());
        return this;
    }

    static class Undefined extends V8Array {
        @Override // com.tkruntime.v8.V8Value, com.tkruntime.v8.Releasable, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // com.tkruntime.v8.V8Value
        public int hashCode() {
            return SocketMessages.PayloadType.SC_GZONE_PREDICTION_PK_END;
        }

        @Override // com.tkruntime.v8.V8Value
        public boolean isReleased() {
            return false;
        }

        @Override // com.tkruntime.v8.V8Value
        public boolean isUndefined() {
            return true;
        }

        @Override // com.tkruntime.v8.V8Value, com.tkruntime.v8.Releasable
        @Deprecated
        public void release() {
        }

        @Override // com.tkruntime.v8.V8Array, com.tkruntime.v8.V8Object
        public String toString() {
            return "undefined";
        }

        @Override // com.tkruntime.v8.V8Value
        public boolean equals(Object obj) {
            return (obj instanceof V8Object) && ((V8Object) obj).isUndefined();
        }

        @Override // com.tkruntime.v8.V8Value
        public V8 getRuntime() {
            throw new UnsupportedOperationException();
        }

        @Override // com.tkruntime.v8.V8Object
        public V8Object add(String str, boolean z) {
            throw new UnsupportedOperationException();
        }

        @Override // com.tkruntime.v8.V8Object
        public V8Object add(String str, double d) {
            throw new UnsupportedOperationException();
        }

        @Override // com.tkruntime.v8.V8Object
        public V8Object add(String str, int i) {
            throw new UnsupportedOperationException();
        }

        @Override // com.tkruntime.v8.V8Object
        public V8Object add(String str, String str2) {
            throw new UnsupportedOperationException();
        }

        @Override // com.tkruntime.v8.V8Object
        public V8Object add(String str, V8Value v8Value) {
            throw new UnsupportedOperationException();
        }

        @Override // com.tkruntime.v8.V8Object
        public V8Object addUndefined(String str) {
            throw new UnsupportedOperationException();
        }

        @Override // com.tkruntime.v8.V8Object
        public boolean contains(String str) {
            throw new UnsupportedOperationException();
        }

        @Override // com.tkruntime.v8.V8Object
        public V8Array executeArrayFunction(String str, Object... objArr) {
            throw new UnsupportedOperationException();
        }

        @Override // com.tkruntime.v8.V8Object
        public V8Object executeObjectFunction(String str, Object... objArr) {
            throw new UnsupportedOperationException();
        }

        @Override // com.tkruntime.v8.V8Object
        public void executeVoidFunction(String str, Object... objArr) {
            throw new UnsupportedOperationException();
        }

        @Override // com.tkruntime.v8.V8Object
        public V8Array getArray(String str) {
            throw new UnsupportedOperationException();
        }

        @Override // com.tkruntime.v8.V8Object
        public boolean getBoolean(String str) {
            throw new UnsupportedOperationException();
        }

        @Override // com.tkruntime.v8.V8Object
        public double getDouble(String str) {
            throw new UnsupportedOperationException();
        }

        @Override // com.tkruntime.v8.V8Object
        public int getInteger(String str) {
            throw new UnsupportedOperationException();
        }

        @Override // com.tkruntime.v8.V8Object
        public V8Object getObject(String str) {
            throw new UnsupportedOperationException();
        }

        @Override // com.tkruntime.v8.V8Object
        public String getString(String str) {
            throw new UnsupportedOperationException();
        }

        @Override // com.tkruntime.v8.V8Array
        public Object get(int i) {
            throw new UnsupportedOperationException();
        }

        @Override // com.tkruntime.v8.V8Array
        public V8Array getArray(int i) {
            throw new UnsupportedOperationException();
        }

        @Override // com.tkruntime.v8.V8Array
        public boolean getBoolean(int i) {
            throw new UnsupportedOperationException();
        }

        @Override // com.tkruntime.v8.V8Array
        public int getInteger(int i) {
            throw new UnsupportedOperationException();
        }

        @Override // com.tkruntime.v8.V8Array
        public V8Object getObject(int i) {
            throw new UnsupportedOperationException();
        }

        @Override // com.tkruntime.v8.V8Array
        public String getString(int i) {
            throw new UnsupportedOperationException();
        }

        @Override // com.tkruntime.v8.V8Array
        public int getType() {
            throw new UnsupportedOperationException();
        }

        @Override // com.tkruntime.v8.V8Array
        public int length() {
            throw new UnsupportedOperationException();
        }

        @Override // com.tkruntime.v8.V8Array
        public V8Array push(boolean z) {
            throw new UnsupportedOperationException();
        }

        @Override // com.tkruntime.v8.V8Array
        public V8Array push(double d) {
            throw new UnsupportedOperationException();
        }

        @Override // com.tkruntime.v8.V8Array
        public V8Array push(int i) {
            throw new UnsupportedOperationException();
        }

        @Override // com.tkruntime.v8.V8Array
        public V8Array push(String str) {
            throw new UnsupportedOperationException();
        }

        @Override // com.tkruntime.v8.V8Array
        public V8Array push(V8Value v8Value) {
            throw new UnsupportedOperationException();
        }

        @Override // com.tkruntime.v8.V8Array
        public V8Array pushUndefined() {
            throw new UnsupportedOperationException();
        }
    }
}
