package com.tkruntime.v8;

import java.nio.ByteBuffer;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public class V8ObjectProxy extends V8Object {
    public static Object PROP_SET_HANDLED;
    public static Object PROP_SET_IGNORE = V8.sPropUnSupported;
    public static BindingObjectCreator sCreator;
    private int mCliValue;
    private Object[] mConstructArgs;
    protected Object mNativeObject;
    private String mOriginClzzName;

    public interface BindingObjectCreator {
        Object constructRealObject(String str, String str2, Object[] objArr);

        Object onPropCall(V8ObjectProxy v8ObjectProxy, Object obj, boolean z, String str, Object obj2);

        String[] onPropEnumerator(V8ObjectProxy v8ObjectProxy);
    }

    public static void newInstance(V8 v8, long j, long j2, int i, ByteBuffer byteBuffer) {
        Object[] objArr;
        V8MemBufferFromJS v8MemBufferFromJSObtain = V8MemBufferFromJS.obtain(byteBuffer, v8);
        if (i > 0) {
            objArr = new Object[i];
            for (int i2 = 0; i2 < i; i2++) {
                objArr[i2] = v8MemBufferFromJSObtain.readObject();
            }
        } else {
            objArr = null;
        }
        new V8ObjectProxy(v8, j, j2, objArr);
        while (v8MemBufferFromJSObtain.hasRemaining()) {
            new V8ObjectProxy(v8, ((Long) v8MemBufferFromJSObtain.readObject()).longValue(), ((Long) v8MemBufferFromJSObtain.readObject()).longValue(), V8MemBufferFromJS.EMPTY_OBJECT_ARRAY);
        }
        v8MemBufferFromJSObtain.recycle();
    }

    private V8ObjectProxy(V8 v8, long j, long j2, int i, ByteBuffer byteBuffer) {
        this.mConstructArgs = null;
        this.mOriginClzzName = null;
        this.mNativeObject = null;
        this.mCliValue = 0;
        this.mCliValue = 0;
        V8MemBufferFromJS v8MemBufferFromJSObtain = V8MemBufferFromJS.obtain(byteBuffer, v8);
        this.objectHandle = j;
        this.v8 = v8;
        this.released = false;
        this.mOriginClzzName = v8.v8ExportDescriptorIndex[(int) j2];
        this.mConstructArgs = v8MemBufferFromJSObtain.getAllObjects();
        v8MemBufferFromJSObtain.recycle();
        addObjectReferenceAndTrackedObj(this.objectHandle);
        this.mNativeObject = this.v8.constructRealObject(this, this.mOriginClzzName, this.mConstructArgs);
    }

    public V8ObjectProxy(V8 v8, long j, long j2, Object[] objArr) {
        this.mConstructArgs = null;
        this.mOriginClzzName = null;
        this.mNativeObject = null;
        this.mCliValue = 0;
        this.objectHandle = j;
        this.v8 = v8;
        this.mConstructArgs = objArr;
        this.released = false;
        this.mOriginClzzName = v8.v8ExportDescriptorIndex[(int) j2];
        addObjectReferenceAndTrackedObj(this.objectHandle);
        this.mNativeObject = this.v8.constructRealObject(this, this.mOriginClzzName, this.mConstructArgs);
    }

    public V8ObjectProxy(V8 v8, String str) {
        this(v8, str, false);
    }

    public V8ObjectProxy(V8 v8, String str, boolean z) {
        this.mConstructArgs = null;
        this.mOriginClzzName = null;
        this.mNativeObject = null;
        this.mCliValue = 0;
        this.v8 = v8;
        this.mOriginClzzName = str;
        Integer num = v8.v8ExportDescriptorMapping.get(str);
        long jInitNewV8ObjectProxy = v8.initNewV8ObjectProxy(v8.getV8RuntimePtr(), this, (num == null ? -1 : num).intValue(), z);
        this.released = false;
        addObjectReferenceAndTrackedObj(jInitNewV8ObjectProxy);
    }

    @Override // com.tkruntime.v8.V8Object
    public void setNativeObject(Object obj) {
        this.mNativeObject = obj;
    }

    @Override // com.tkruntime.v8.V8Object
    public Object getNativeObject() {
        return this.mNativeObject;
    }

    public String getOriginClzzName() {
        return this.mOriginClzzName;
    }

    @Override // com.tkruntime.v8.V8Object
    public Object onPropCall(boolean z, String str, Object obj) {
        if (this.v8 == null) {
            return null;
        }
        return this.v8.onPropCall(this, this.mNativeObject, this.mOriginClzzName, z, str, obj);
    }

    @Override // com.tkruntime.v8.V8Object
    public String[] onPropEnumerator() {
        if (this.v8 == null) {
            return null;
        }
        return this.v8.onPropEnumerator(this);
    }

    private static String flatString(V8Array v8Array) {
        if (v8Array == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < v8Array.length(); i++) {
            sb.append(i + " = " + v8Array.get(i) + " , ");
        }
        return sb.toString();
    }

    private static String flatString(Object[] objArr) {
        if (objArr == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < objArr.length; i++) {
            sb.append(i + " = " + objArr[i] + " , ");
        }
        return sb.toString();
    }

    @Override // com.tkruntime.v8.V8Value, com.tkruntime.v8.Releasable
    public void release() {
        super.release();
    }

    @Override // com.tkruntime.v8.V8Value
    protected void onJsRefDestroy() {
        super.onJsRefDestroy();
        if (this.v8 != null) {
            this.v8.onJsRefDestroy(this.mNativeObject);
        }
    }

    @Override // com.tkruntime.v8.V8Object
    public String toString() {
        return super.toString();
    }

    public int getCliValue() {
        return this.mCliValue;
    }
}
