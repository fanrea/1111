package com.tkruntime.v8;

import com.kuaishou.socket.nano.SocketMessages;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public class V8Object extends V8Value {
    private Object mObj;

    public String[] onPropEnumerator() {
        return null;
    }

    public V8Object(V8 v8) {
        this(v8, (Object) null);
    }

    protected V8Object(V8 v8, Object obj) {
        super(v8);
        this.mObj = null;
        if (v8 != null) {
            this.v8.checkThread();
            initialize(this.v8.getV8RuntimePtr(), obj);
        }
    }

    public void setNativeObject(Object obj) {
        this.mObj = obj;
    }

    public Object getNativeObject() {
        return this.mObj;
    }

    public V8Object(V8 v8, long j) {
        super(v8);
        this.mObj = null;
        if (v8 != null) {
            this.objectHandle = j;
            this.released = false;
            this.v8.checkThread();
            addObjectReference(this.objectHandle);
        }
    }

    protected V8Object() {
        this.mObj = null;
    }

    public Object onPropCall(boolean z, String str, Object obj) {
        return this.v8.onPropCall(this, null, null, z, str, obj);
    }

    public boolean contains(String str) {
        this.v8.checkThread();
        checkReleased();
        checkKey(str);
        return this.v8.contains(this.v8.getV8RuntimePtr(), this.objectHandle, str);
    }

    public Object get(String str) {
        this.v8.checkThread();
        checkReleased();
        checkKey(str);
        return this.v8.get(this.v8.getV8RuntimePtr(), 6, this.objectHandle, str);
    }

    public Map getAll() {
        this.v8.checkThread();
        checkReleased();
        return this.v8.getAll(this.objectHandle);
    }

    public int getInteger(String str) {
        this.v8.checkThread();
        checkReleased();
        checkKey(str);
        return this.v8.getInteger(this.v8.getV8RuntimePtr(), this.objectHandle, str);
    }

    public boolean getBoolean(String str) {
        this.v8.checkThread();
        checkReleased();
        checkKey(str);
        return this.v8.getBoolean(this.v8.getV8RuntimePtr(), this.objectHandle, str);
    }

    public double getDouble(String str) {
        this.v8.checkThread();
        checkReleased();
        checkKey(str);
        return this.v8.getDouble(this.v8.getV8RuntimePtr(), this.objectHandle, str);
    }

    public String getString(String str) {
        this.v8.checkThread();
        checkReleased();
        checkKey(str);
        return this.v8.getString(this.v8.getV8RuntimePtr(), this.objectHandle, str);
    }

    public V8Array getArray(String str) {
        this.v8.checkThread();
        checkReleased();
        checkKey(str);
        Object obj = this.v8.get(this.v8.getV8RuntimePtr(), 5, this.objectHandle, str);
        if (obj == null || (obj instanceof V8Array)) {
            return (V8Array) obj;
        }
        throw new V8ResultUndefined();
    }

    public V8Object getObject(String str) {
        this.v8.checkThread();
        checkReleased();
        checkKey(str);
        Object obj = this.v8.get(this.v8.getV8RuntimePtr(), 6, this.objectHandle, str);
        if (obj == null || (obj instanceof V8Object)) {
            return (V8Object) obj;
        }
        throw new V8ResultUndefined();
    }

    public V8Array executeArrayFunction(String str, Object... objArr) {
        this.v8.checkThread();
        checkReleased();
        Object objExecuteFunction = this.v8.executeFunction(this.v8.getV8RuntimePtr(), 5, this.objectHandle, str, objArr);
        if (objExecuteFunction instanceof V8Array) {
            return (V8Array) objExecuteFunction;
        }
        throw new V8ResultUndefined();
    }

    public V8Object executeObjectFunction(String str, Object... objArr) {
        this.v8.checkThread();
        checkReleased();
        Object objExecuteFunction = this.v8.executeFunction(this.v8.getV8RuntimePtr(), 6, this.objectHandle, str, objArr);
        if (objExecuteFunction instanceof V8Object) {
            return (V8Object) objExecuteFunction;
        }
        throw new V8ResultUndefined();
    }

    public Object executeFunction(String str, Object... objArr) {
        this.v8.checkThread();
        checkReleased();
        return this.v8.executeFunction(this.v8.getV8RuntimePtr(), 0, this.objectHandle, str, objArr);
    }

    public Object executeJSFunction(String str) {
        return executeFunction(str, new Object[0]);
    }

    public Object executeJSFunction(String str, Object... objArr) {
        if (objArr == null) {
            return executeFunction(str, new Object[0]);
        }
        return executeFunction(str, objArr);
    }

    public void executeVoidFunction(String str, Object... objArr) {
        this.v8.checkThread();
        checkReleased();
        this.v8.executeVoidFunction(this.v8.getV8RuntimePtr(), this.objectHandle, str, objArr);
    }

    public V8Object add(String str, int i) {
        this.v8.checkThread();
        checkReleased();
        this.v8.add(this.v8.getV8RuntimePtr(), this.objectHandle, str, i);
        return this;
    }

    public V8Object add(String str, boolean z) {
        this.v8.checkThread();
        checkReleased();
        this.v8.add(this.v8.getV8RuntimePtr(), this.objectHandle, str, z);
        return this;
    }

    public V8Object add(String str, double d) {
        this.v8.checkThread();
        checkReleased();
        this.v8.add(this.v8.getV8RuntimePtr(), this.objectHandle, str, d);
        return this;
    }

    public V8Object add(String str, String str2) {
        this.v8.checkThread();
        checkReleased();
        if (str2 == null) {
            this.v8.addNull(this.v8.getV8RuntimePtr(), this.objectHandle, str);
        } else if (str2.equals(V8.getUndefined())) {
            this.v8.addUndefined(this.v8.getV8RuntimePtr(), this.objectHandle, str);
        } else {
            this.v8.add(this.v8.getV8RuntimePtr(), this.objectHandle, str, str2);
        }
        return this;
    }

    public V8Object add(String str, V8Value v8Value) {
        this.v8.checkThread();
        checkReleased();
        this.v8.checkRuntime(v8Value);
        if (v8Value == null) {
            this.v8.addNull(this.v8.getV8RuntimePtr(), this.objectHandle, str);
        } else if (v8Value.equals(V8.getUndefined())) {
            this.v8.addUndefined(this.v8.getV8RuntimePtr(), this.objectHandle, str);
        } else {
            this.v8.addObject(this.v8.getV8RuntimePtr(), this.objectHandle, str, v8Value.getHandle());
        }
        return this;
    }

    public V8Object addUndefined(String str) {
        this.v8.checkThread();
        checkReleased();
        this.v8.addUndefined(this.v8.getV8RuntimePtr(), this.objectHandle, str);
        return this;
    }

    public V8Object addNull(String str) {
        this.v8.checkThread();
        checkReleased();
        this.v8.addNull(this.v8.getV8RuntimePtr(), this.objectHandle, str);
        return this;
    }

    public String toString() {
        if (isReleased() || this.v8.isReleased()) {
            return "[Object released]";
        }
        this.v8.checkThread();
        return this.v8.toString(this.v8.getV8RuntimePtr(), getHandle());
    }

    private void checkKey(String str) {
        if (str == null) {
            throw new IllegalArgumentException("Key cannot be null");
        }
    }

    public static class Undefined extends V8Object {
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

        @Override // com.tkruntime.v8.V8Object
        public String toString() {
            return "undefined";
        }

        @Override // com.tkruntime.v8.V8Value
        public boolean equals(Object obj) {
            return (obj instanceof V8Object) && ((V8Object) obj).isUndefined();
        }

        @Override // com.tkruntime.v8.V8Object
        public V8Object add(String str, boolean z) {
            throw new UnsupportedOperationException();
        }

        @Override // com.tkruntime.v8.V8Value
        public V8 getRuntime() {
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
        public Object executeJSFunction(String str, Object... objArr) {
            throw new UnsupportedOperationException();
        }

        @Override // com.tkruntime.v8.V8Object
        public Object executeFunction(String str, Object... objArr) {
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
    }
}
