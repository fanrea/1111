package com.tkruntime.v8;

import android.text.TextUtils;
import com.baidu.mobstat.forbes.Config;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public class V8Function extends V8Object {
    private Object mCallback;
    protected String mFunctionName;
    protected boolean mVoidFunction;

    public V8Function(V8 v8, JavaVoidCallback javaVoidCallback) {
        this.mFunctionName = null;
        this.mVoidFunction = false;
        this.mCallback = null;
        this.v8 = v8;
        this.mVoidFunction = true;
        if (v8 != null) {
            v8.checkThread();
            initialize(v8.getV8RuntimePtr(), javaVoidCallback);
        }
    }

    public V8Function(V8 v8, JavaCallback javaCallback) {
        this.mFunctionName = null;
        this.mVoidFunction = false;
        this.mCallback = null;
        this.v8 = v8;
        this.mVoidFunction = false;
        if (v8 != null) {
            v8.checkThread();
            initialize(v8.getV8RuntimePtr(), javaCallback);
        }
    }

    public V8Function(V8 v8, String str, JavaCallback javaCallback) {
        this.mFunctionName = null;
        this.mVoidFunction = false;
        this.mCallback = null;
        this.v8 = v8;
        this.mFunctionName = str;
        if (v8 != null) {
            v8.checkThread();
            initialize(v8.getV8RuntimePtr(), javaCallback);
        }
    }

    public void setFunctionName(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.mFunctionName = str;
    }

    public V8Function(V8 v8, long j) {
        super(v8, j);
        this.mFunctionName = null;
        this.mVoidFunction = false;
        this.mCallback = null;
    }

    protected V8Function(V8 v8) {
        this(v8, (JavaCallback) null);
    }

    @Override // com.tkruntime.v8.V8Object
    public String toString() {
        if (this.released || this.v8.isReleased()) {
            return "[Function released]";
        }
        return super.toString() + ",callback = " + this.mCallback;
    }

    @Override // com.tkruntime.v8.V8Value
    protected void initialize(long j, Object obj) {
        this.releaseCheck = false;
        if (obj == null) {
            super.initialize(j, null);
            return;
        }
        long[] jArrInitNewV8Function = this.v8.initNewV8Function(j, this.mFunctionName, !this.mVoidFunction);
        if (this.mVoidFunction) {
            JavaVoidCallback javaVoidCallback = (JavaVoidCallback) obj;
            this.mCallback = javaVoidCallback;
            this.v8.createAndRegisterVoidMethodDescriptor(javaVoidCallback, jArrInitNewV8Function[1], this.mFunctionName);
        } else {
            JavaCallback javaCallback = (JavaCallback) obj;
            this.mCallback = javaCallback;
            this.v8.createAndRegisterMethodDescriptor(javaCallback, jArrInitNewV8Function[1], this.mFunctionName);
        }
        this.released = false;
        this.objectHandle = jArrInitNewV8Function[0];
        addObjectReference(jArrInitNewV8Function[0]);
    }

    public Object call(V8Object v8Object, Object... objArr) throws Throwable {
        boolean z;
        if (BuildConfig.ENABLE_ANALYZE_PERFORMANCE.booleanValue() && this.v8.currentState % 2 == 0) {
            z = true;
            this.v8.currentState = 9;
            V8 v8 = this.v8;
            StringBuilder sb = new StringBuilder(V8Trace.SECTION_JS_CALLBACK);
            sb.append(this.mFunctionName);
            sb.append(Config.replace);
            V8 v82 = this.v8;
            long j = v82.jsCallbackIndex;
            v82.jsCallbackIndex = 1 + j;
            sb.append(j);
            V8Trace.beginSection(v8, "", sb.toString());
        } else {
            z = false;
        }
        this.v8.checkThread();
        checkReleased();
        this.v8.checkRuntime(v8Object);
        if (v8Object == null) {
            v8Object = this.v8;
        }
        Object objExecuteFunction = this.v8.executeFunction(this.v8.getV8RuntimePtr(), v8Object.isUndefined() ? this.v8.getHandle() : v8Object.getHandle(), this.objectHandle, objArr);
        if (BuildConfig.ENABLE_ANALYZE_PERFORMANCE.booleanValue() && z) {
            V8Trace.endSection(this.v8);
            this.v8.currentState = 10;
        }
        return objExecuteFunction;
    }
}
