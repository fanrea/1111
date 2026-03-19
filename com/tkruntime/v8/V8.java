package com.tkruntime.v8;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.bytedance.sdk.djx.core.log.ILogConst;
import com.tkruntime.v8.V8Locker;
import com.tkruntime.v8.V8Object;
import com.tkruntime.v8.utils.ArrayBuffer;
import com.tkruntime.v8.utils.AutoExpandedList;
import com.tkruntime.v8.utils.AutoExpandedMap;
import com.tkruntime.v8.utils.TypedArray;
import com.tkruntime.v8.utils.V8ObjectUtilsQuick;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public class V8 extends V8Object {
    public static final int CMD_CALL_METH = 4;
    public static final int CMD_CALL_METH_WITH_RT = 5;
    public static final int CMD_GET_PROP = 6;
    public static final int CMD_SET_PROP = 3;
    public static final int CMD_SET_RECIVER = 1;
    public static final int CMD_SET_STYLE = 2;
    public static final int GLOBAL_DIRECT_BUFFER_CNT = 16;
    public static final long INTERNAL_CLEARINTERVAL_INDEX = 2;
    public static final long INTERNAL_CLEARTIMEOUT_INDEX = 4;
    public static final long INTERNAL_MAX = 99;
    public static final long INTERNAL_SETINTERVAL_INDEX = 1;
    public static final long INTERNAL_SETTIMEOUT_INDEX = 3;
    public static final int OP_CREATE_LIST = 101;
    public static final int OP_CREATE_MAP = 100;
    private static final byte RETURN_BYTE_MAGIC_NUMBER = 127;
    private static V8Object sV8Receiver;
    public String bundleId;
    public String businessName;
    public String contextName;
    public int currentState;
    private Map<String, Object> data;
    private Map<Long, MethodDescriptor> functionRegistry;
    ByteBuffer gcBuffer;
    protected boolean isPendingReleased;
    private long isolatePtr;
    public long jsCallbackIndex;
    private final V8Locker locker;
    private BindingObjectCreator mBindingObjectCreator;
    private SparseArray<SeqCommandRunner> mCmds;
    private AutoExpandedMap mCurrentStyle;
    private boolean mIsGcing;
    private int mJsStackLevel;
    private int mJsonproxyNotLoad;
    private List<Runnable> mPendingAction;
    private Map<Long, V8Value> mPendingRemovingObjs;
    private float mPropCallCostTime;
    private V8ObjectProxy mReceiver;
    private long mSessionId;
    private int mStyleSeq;
    private Map<Long, V8Value> mTrackedObjs;
    private long objectReferences;
    private boolean runtimeRelesed;
    public String sessionId;
    protected long[] v8ExportDescriptor;
    protected String[] v8ExportDescriptorIndex;
    protected Map<String, Integer> v8ExportDescriptorMapping;
    private long v8RuntimePtr;
    protected Map<Long, V8Value> v8WeakReferences;
    private static final Object lock = new Object();
    private static volatile int runtimeCounter = 0;
    private static String v8Flags = null;
    private static boolean initialized = false;
    private static boolean nativeLibraryLoaded = false;
    private static Error nativeLoadError = null;
    private static Exception nativeLoadException = null;
    private static V8Value undefined = new V8Object.Undefined();
    private static Object invalid = new Object();
    public static final V8ResultUnSupported sPropUnSupported = new V8ResultUnSupported();
    public static final ByteBuffer[] sDirectBuffers = new ByteBuffer[16];
    private static boolean sGlobalEnvInited = false;
    private static Handler sAsyncHandler = null;
    private static volatile String[] sJSConstructors = null;

    public interface BindingObjectCreator {
        Object constructRealObject(V8ObjectProxy v8ObjectProxy, String str, Object[] objArr);

        String getPropNameByIndex(V8ObjectProxy v8ObjectProxy, String str, int i);

        JavaUnifiedCallback onExportMethodCall(V8Object v8Object, Object obj, String str, int i);

        Object onFlushCmd(SeqCommandRunner seqCommandRunner, V8 v8);

        void onJsRefDestroy(Object obj, boolean z);

        Object onPropCall(V8Object v8Object, Object obj, String str, boolean z, String str2, Object obj2);

        String[] onPropEnumerator(V8ObjectProxy v8ObjectProxy);
    }

    public interface CommandRunner {
        Object exec(V8 v8);

        boolean hasJSRef();
    }

    private native void _add(long j, long j2, String str, int i, double d);

    private native void _add(long j, long j2, String str, int i, int i2);

    private native void _add(long j, long j2, String str, int i, String str2, int i2);

    private native void _add(long j, long j2, String str, int i, boolean z);

    private native void _addArrayBooleanItem(long j, long j2, boolean z);

    private native void _addArrayDoubleItem(long j, long j2, double d);

    private native void _addArrayIntItem(long j, long j2, int i);

    private native void _addArrayNullItem(long j, long j2);

    private native void _addArrayObjectItem(long j, long j2, long j3);

    private native void _addArrayStringItem(long j, long j2, String str);

    private native void _addArrayUndefinedItem(long j, long j2);

    private native void _addNull(long j, long j2, String str, int i);

    private native void _addObject(long j, long j2, String str, int i, long j3);

    private native void _addUndefined(long j, long j2, String str, int i);

    private native Object _arrayGet(long j, int i, long j2, int i2);

    private native boolean _arrayGetBoolean(long j, long j2, int i);

    private native byte _arrayGetByte(long j, long j2, int i);

    private native double _arrayGetDouble(long j, long j2, int i);

    private native int _arrayGetInteger(long j, long j2, int i);

    private native int _arrayGetSize(long j, long j2);

    private native String _arrayGetString(long j, long j2, int i);

    private native void _clearWeak(long j, long j2);

    private native long _compileCodeCache(long j, String str, boolean z, String str2, int i);

    private native boolean _contains(long j, long j2, String str);

    private native long _createIsolate(String str, long j, ByteBuffer byteBuffer, boolean z);

    private native ByteBuffer _createV8ArrayBufferBackingStore(long j, long j2, int i);

    private static native void _destroyCodeCache(long j);

    private native boolean _equals(long j, long j2, long j3);

    private native Object _executeFunction(long j, long j2, int i, long j3, String str, long j4, int i2, Object... objArr);

    private native Object _executeFunction(long j, long j2, long j3, long j4, long j5, int i, Object... objArr);

    private native Object _executeScript(long j, long j2, int i, String str, String str2, int i2, long j3);

    private native void _executeVoidFunction(long j, long j2, long j3, String str, int i, Object... objArr);

    private native Object _get(long j, int i, long j2, String str);

    private native Map _getAll(long j, long j2, Object obj);

    private native ByteBuffer _getAllQuick(long j, long j2, boolean z, Map map);

    private native int _getArrayType(long j, long j2);

    private native boolean _getBoolean(long j, long j2, String str);

    private native long _getContextHandle(long j);

    private native double _getDouble(long j, long j2, String str);

    private native long _getGlobalObject(long j);

    private native Map<String, Integer> _getHeapInfo(long j);

    private native int _getInteger(long j, long j2, String str);

    private native long _getIsolatePtr(long j);

    private native List _getList(long j, long j2, List list);

    private native ByteBuffer _getListQuick(long j, long j2, List list);

    private native String _getString(long j, long j2, String str);

    private static native String _getVersion();

    private native int _identityHash(long j, long j2);

    private static native boolean _initGlobalEnv();

    private native long _initNewV8Array(long j);

    private native long _initNewV8ArrayBuffer(long j, int i);

    private native long _initNewV8ArrayBuffer(long j, ByteBuffer byteBuffer, int i);

    private native long[] _initNewV8Function(long j, String str, boolean z);

    private native long _initNewV8Map(long j);

    private native long _initNewV8Object(long j, Object obj);

    private native long _initNewV8ObjectProxy(long j, Object obj, int i, boolean z);

    private native void _initTracing(long j, String str);

    private static native int _injectProps(long j, String[] strArr, String[] strArr2, String[] strArr3);

    private static native void _injectSEnv(String str);

    public static native void _injectStyleKeys(String[] strArr);

    public static native boolean _isBigEndian();

    public static native boolean _isIsolateInUse(long j);

    private native boolean _isWeak(long j, long j2);

    private native void _markReleasing(long j);

    private static native boolean _pumpMessageLoop(long j);

    private native void _recycleDirectBuffer(int i);

    private native int _registerExposedComponents(long j, int i, String[] strArr, long[] jArr, boolean z);

    private native void _release(long j, long j2);

    private native void _releaseBatch(long j, long[] jArr, int i);

    public static native long _releaseIsolatePtr(long j);

    private native void _releaseMethodDescriptor(long j, long j2);

    private native void _releaseRuntime(long j, int i);

    private static native void _setFlags(String str);

    private native void _setWeak(long j, long j2);

    private native void _startTracing(long j);

    private native void _stopTracing(long j);

    private native boolean _strictEquals(long j, long j2, long j3);

    private native String _toString(long j, long j2);

    public static native void _updateDynamicEnv(String str, Object obj);

    public static native void _updateDynamicEnvs(Object[] objArr, int i);

    public static long getBuildID() {
        return 3L;
    }

    private void notifyReleaseHandlers(V8 v8) {
    }

    public String getTraceTag(String str, String str2) {
        return V8Trace.createTraceTag(this.businessName, this.bundleId, this.sessionId, str, str2);
    }

    public float getPropCallCostTime() {
        return this.mPropCallCostTime;
    }

    public void clearPropCallCostTime() {
        this.mPropCallCostTime = 0.0f;
    }

    public void addPropCallTime(float f) {
        this.mPropCallCostTime += f;
    }

    public int getJsonNotLoadNum() {
        return this.mJsonproxyNotLoad;
    }

    public void addJsonNotLoadNum(int i) {
        this.mJsonproxyNotLoad += i;
    }

    public void clearJsonNotLoadNum() {
        this.mJsonproxyNotLoad = 0;
    }

    public static ByteBuffer newDirectBuffer(int i, int i2) {
        ByteBuffer byteBufferAllocateDirect;
        if (i2 < 0) {
            byteBufferAllocateDirect = ByteBuffer.allocateDirect(i);
        } else {
            byteBufferAllocateDirect = ByteBuffer.allocateDirect(i);
            sDirectBuffers[i2] = byteBufferAllocateDirect;
        }
        if (byteBufferAllocateDirect != null) {
            return byteBufferAllocateDirect;
        }
        throw new RuntimeException("fail to allocate " + i + " for directbuffer in " + i2);
    }

    private void onEnterStack() {
        synchronized (this) {
            if (this.mJsStackLevel == 0) {
                this.mSessionId++;
            }
            this.mJsStackLevel++;
        }
    }

    private void onExitStack() {
        boolean z;
        synchronized (this) {
            z = true;
            this.mJsStackLevel--;
            if (this.mJsStackLevel != 0) {
                z = false;
            }
        }
        if (!z || this.released || this.isPendingReleased) {
            return;
        }
        while (!this.mPendingAction.isEmpty()) {
            this.mPendingAction.remove(0).run();
        }
    }

    public void addPendingAction(Runnable runnable) {
        this.mPendingAction.add(runnable);
    }

    public void removePendingAction(Runnable runnable) {
        this.mPendingAction.remove(runnable);
    }

    class MethodDescriptor {
        JavaCallback callback;
        V8Function function;
        String functionName;
        boolean includeReceiver;
        Object object;
        JavaVoidCallback voidCallback;

        private MethodDescriptor() {
        }
    }

    private static synchronized void load(String str, NativeLibraryLoader nativeLibraryLoader) {
        try {
            LibraryLoader.loadLibrary(str, nativeLibraryLoader);
            nativeLibraryLoaded = true;
        } catch (Error e) {
            nativeLoadError = e;
            throw e;
        } catch (Exception e2) {
            nativeLoadException = e2;
            throw e2;
        }
    }

    public static boolean isLoaded() {
        return nativeLibraryLoaded;
    }

    public static void setFlags(String str) {
        v8Flags = str;
        initialized = false;
    }

    public static V8 createV8Runtime() {
        return createV8Runtime(null, null);
    }

    public static V8 createV8Runtime(String str) {
        return createV8Runtime(str, null);
    }

    public static V8 createV8Runtime(String str, String str2, long j) {
        if (!nativeLibraryLoaded) {
            synchronized (lock) {
                if (!nativeLibraryLoaded) {
                    load(str2, null);
                }
            }
        }
        checkNativeLibraryLoaded();
        if (!initialized) {
            if (!TextUtils.isEmpty(v8Flags)) {
                _setFlags(v8Flags);
            }
            initialized = true;
        }
        V8 v8 = new V8(str, j, false);
        synchronized (lock) {
            runtimeCounter++;
        }
        return v8;
    }

    public static V8 createV8Runtime(String str, String str2) {
        return createV8Runtime(str, str2, 0L);
    }

    private static void checkNativeLibraryLoaded() {
        if (nativeLibraryLoaded) {
            return;
        }
        Error error = nativeLoadError;
        if (error != null) {
            throw new IllegalStateException("tkruntime native library not loaded", error);
        }
        Exception exc = nativeLoadException;
        if (exc != null) {
            throw new IllegalStateException("tkruntime native library not loaded", exc);
        }
        throw new IllegalStateException("tkruntime native library not loaded");
    }

    protected V8(long j, boolean z) {
        this(null, j, z);
    }

    protected V8(String str, long j, boolean z) {
        super(null);
        this.v8WeakReferences = new HashMap();
        this.v8ExportDescriptorMapping = null;
        this.gcBuffer = null;
        this.data = null;
        this.objectReferences = 0L;
        this.v8RuntimePtr = 0L;
        this.isolatePtr = 0L;
        this.functionRegistry = new HashMap();
        this.mJsStackLevel = 0;
        this.mPendingAction = new ArrayList();
        this.isPendingReleased = false;
        this.mSessionId = 0L;
        this.runtimeRelesed = false;
        this.mJsonproxyNotLoad = 0;
        this.mPropCallCostTime = 0.0f;
        this.jsCallbackIndex = 0L;
        this.v8ExportDescriptorIndex = null;
        this.v8ExportDescriptor = null;
        this.mTrackedObjs = new HashMap();
        this.mPendingRemovingObjs = new HashMap();
        this.mIsGcing = false;
        this.mCmds = new SparseArray<>();
        this.mReceiver = null;
        this.mCurrentStyle = null;
        this.mStyleSeq = -1;
        this.released = false;
        this.isolatePtr = j;
        if (!sGlobalEnvInited) {
            synchronized (V8.class) {
                if (!sGlobalEnvInited) {
                    _initGlobalEnv();
                    sGlobalEnvInited = true;
                }
            }
        }
        this.v8RuntimePtr = _createIsolate(str, this.isolatePtr, this.gcBuffer, z);
        if (this.isolatePtr == 0) {
            this.isolatePtr = _getIsolatePtr(this.v8RuntimePtr);
        }
        this.objectHandle = _getGlobalObject(this.v8RuntimePtr);
        this.locker = new V8Locker.DeprecatedV8Locker(this.isolatePtr);
    }

    public long getBindingIsolatePtr() {
        return this.isolatePtr;
    }

    public static V8Value getUndefined() {
        return undefined;
    }

    public static int getActiveRuntimes() {
        return runtimeCounter;
    }

    public long getObjectReferenceCount() {
        return this.objectReferences - this.v8WeakReferences.size();
    }

    protected long getV8RuntimePtr() {
        return this.v8RuntimePtr;
    }

    public static String getV8Version() {
        return _getVersion();
    }

    public static int injectProps(String[] strArr, String[] strArr2, String[] strArr3) {
        return _injectProps(0L, strArr, strArr2, strArr3);
    }

    public static void injectSEnv(String str) {
        _injectSEnv(str);
    }

    @Override // com.tkruntime.v8.V8Value, com.tkruntime.v8.Releasable, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        close(true);
    }

    public void close(boolean z) {
        release(true, z);
    }

    @Override // com.tkruntime.v8.V8Value, com.tkruntime.v8.Releasable
    @Deprecated
    public void release() {
        close(true);
    }

    public void release(boolean z, boolean z2) {
        if (isReleased() || this.isPendingReleased) {
            return;
        }
        synchronized (this) {
            if (this.isPendingReleased) {
                return;
            }
            this.isPendingReleased = true;
            _markReleasing(getV8RuntimePtr());
            try {
                notifyReleaseHandlers(this);
                this.mPendingAction.clear();
                synchronized (lock) {
                    runtimeCounter--;
                }
                if (z) {
                    getObjectReferenceCount();
                }
                Log.v("v8", "leaked object cnt = " + this.mTrackedObjs.size());
                for (V8Value v8Value : this.mTrackedObjs.values()) {
                    if (!v8Value.isReleased()) {
                        if (this.mBindingObjectCreator != null && (v8Value instanceof V8ObjectProxy)) {
                            this.mBindingObjectCreator.onJsRefDestroy(((V8ObjectProxy) v8Value).getNativeObject(), false);
                        }
                        v8Value.released = true;
                        v8Value.objectHandle = 0L;
                    }
                }
                synchronized (this.mPendingRemovingObjs) {
                    for (V8Value v8Value2 : this.mPendingRemovingObjs.values()) {
                        if (!v8Value2.isReleased()) {
                            if (this.mBindingObjectCreator != null && (v8Value2 instanceof V8ObjectProxy)) {
                                this.mBindingObjectCreator.onJsRefDestroy(((V8ObjectProxy) v8Value2).getNativeObject(), false);
                            }
                            v8Value2.released = true;
                            v8Value2.objectHandle = 0L;
                        }
                    }
                }
                this.v8WeakReferences.clear();
                this.mTrackedObjs.clear();
                if (this.released) {
                    return;
                }
                if (z2) {
                    releaseRuntime();
                }
                this.released = true;
            } catch (Throwable th) {
                this.mPendingAction.clear();
                synchronized (lock) {
                    runtimeCounter--;
                    if (z) {
                        getObjectReferenceCount();
                    }
                    Log.v("v8", "leaked object cnt = " + this.mTrackedObjs.size());
                    for (V8Value v8Value3 : this.mTrackedObjs.values()) {
                        if (!v8Value3.isReleased()) {
                            if (this.mBindingObjectCreator != null && (v8Value3 instanceof V8ObjectProxy)) {
                                this.mBindingObjectCreator.onJsRefDestroy(((V8ObjectProxy) v8Value3).getNativeObject(), false);
                            }
                            v8Value3.released = true;
                            v8Value3.objectHandle = 0L;
                        }
                    }
                    synchronized (this.mPendingRemovingObjs) {
                        for (V8Value v8Value4 : this.mPendingRemovingObjs.values()) {
                            if (!v8Value4.isReleased()) {
                                if (this.mBindingObjectCreator != null && (v8Value4 instanceof V8ObjectProxy)) {
                                    this.mBindingObjectCreator.onJsRefDestroy(((V8ObjectProxy) v8Value4).getNativeObject(), false);
                                }
                                v8Value4.released = true;
                                v8Value4.objectHandle = 0L;
                            }
                        }
                        this.v8WeakReferences.clear();
                        this.mTrackedObjs.clear();
                        if (!this.released) {
                            if (z2) {
                                releaseRuntime();
                            }
                            this.released = true;
                        }
                        throw th;
                    }
                }
            }
        }
    }

    public void releaseRuntime() {
        if (this.runtimeRelesed) {
            return;
        }
        _releaseRuntime(this.v8RuntimePtr, 0);
        this.v8RuntimePtr = 0L;
        this.runtimeRelesed = true;
    }

    public Object executeScript(String str) {
        return executeScript(str, null, 0);
    }

    public long compileCodeCache(String str, String str2, boolean z) {
        checkReleased();
        return _compileCodeCache(getV8RuntimePtr(), str, z, str2, 0);
    }

    public static void destroyCodeCache(long j) {
        _destroyCodeCache(j);
    }

    public Object executeScript(String str, String str2) {
        checkThread();
        checkScript(str);
        return executeScript(getV8RuntimePtr(), 0, str, str2, 0, 0L);
    }

    public Object executeScript(String str, String str2, int i) {
        checkThread();
        checkScript(str);
        return executeScript(getV8RuntimePtr(), 0, str, str2, i, 0L);
    }

    public Object executeScript(String str, String str2, int i, long j) {
        checkThread();
        checkScript(str);
        return executeScript(getV8RuntimePtr(), 0, str, str2, i, j);
    }

    public void executeVoidScript(String str) {
        executeVoidScript(str, null, 0);
    }

    public void executeVoidScript(String str, String str2, int i) {
        checkThread();
        checkScript(str);
        executeVoidScript(this.v8RuntimePtr, str, str2, i, 0L);
    }

    public V8Locker getLocker() {
        return this.locker;
    }

    void checkRuntime(V8Value v8Value) {
        if (v8Value == null || v8Value.isUndefined()) {
            return;
        }
        V8 runtime = v8Value.getRuntime();
        if (runtime == null || runtime.isReleased() || runtime != this) {
            throw new Error("Invalid target runtime");
        }
    }

    void checkThread() {
        this.locker.checkThread();
        if (isReleased()) {
            throw new Error("Runtime disposed error");
        }
    }

    static void checkScript(String str) {
        if (str == null) {
            throw new NullPointerException("Script is null");
        }
    }

    void createAndRegisterMethodDescriptor(JavaCallback javaCallback, long j, String str) {
        MethodDescriptor methodDescriptor = new MethodDescriptor();
        methodDescriptor.callback = javaCallback;
        methodDescriptor.functionName = str;
        this.functionRegistry.put(Long.valueOf(j), methodDescriptor);
    }

    void createAndRegisterVoidMethodDescriptor(JavaVoidCallback javaVoidCallback, long j, String str) {
        MethodDescriptor methodDescriptor = new MethodDescriptor();
        methodDescriptor.voidCallback = javaVoidCallback;
        methodDescriptor.functionName = str;
        this.functionRegistry.put(Long.valueOf(j), methodDescriptor);
    }

    public void registerInternalFunction(long j, JavaCallback javaCallback) {
        MethodDescriptor methodDescriptor = new MethodDescriptor();
        methodDescriptor.callback = javaCallback;
        this.functionRegistry.put(Long.valueOf(j), methodDescriptor);
    }

    public void registerInternalFunction(long j, JavaVoidCallback javaVoidCallback) {
        MethodDescriptor methodDescriptor = new MethodDescriptor();
        methodDescriptor.voidCallback = javaVoidCallback;
        this.functionRegistry.put(Long.valueOf(j), methodDescriptor);
    }

    protected void disposeMethodID(long j) {
        this.functionRegistry.remove(Long.valueOf(j));
    }

    public Object callObjectJavaMethodQuick(long j, int i, int i2, ByteBuffer byteBuffer) {
        MethodDescriptor methodDescriptor;
        V8MemBufferFromJS v8MemBufferFromJSObtain = V8MemBufferFromJS.obtain(byteBuffer, this.v8);
        V8Object v8Object = (V8Object) v8MemBufferFromJSObtain.readObject();
        Object[] allObjects = v8MemBufferFromJSObtain.getAllObjects();
        v8MemBufferFromJSObtain.recycle();
        MethodDescriptor methodDescriptor2 = this.functionRegistry.get(Long.valueOf(j));
        if (methodDescriptor2 != null || i < 0 || i2 < 0) {
            methodDescriptor = methodDescriptor2;
        } else {
            String str = this.v8ExportDescriptorIndex[i];
            JavaCallback javaCallback = (JavaCallback) this.mBindingObjectCreator.onExportMethodCall(v8Object, v8Object.getNativeObject(), str, i2);
            if (javaCallback == null) {
                throw new RuntimeException("can't find method for " + str + " with propIndex = " + i2);
            }
            methodDescriptor = new MethodDescriptor();
            methodDescriptor.callback = javaCallback;
            this.functionRegistry.put(Long.valueOf(j), methodDescriptor);
        }
        if (methodDescriptor.callback != null) {
            return getQuickReturnObject(methodDescriptor.callback.invoke(v8Object, allObjects), byteBuffer);
        }
        return null;
    }

    public Object callObjectJavaMethod(long j, int i, int i2, V8Object v8Object, Object[] objArr) {
        MethodDescriptor methodDescriptor;
        MethodDescriptor methodDescriptor2 = this.functionRegistry.get(Long.valueOf(j));
        if (methodDescriptor2 != null || i < 0 || i2 < 0) {
            methodDescriptor = methodDescriptor2;
        } else {
            String str = this.v8ExportDescriptorIndex[i];
            JavaCallback javaCallback = (JavaCallback) this.mBindingObjectCreator.onExportMethodCall(v8Object, v8Object.getNativeObject(), str, i2);
            if (javaCallback == null) {
                throw new RuntimeException("can't find method for " + str + " with propIndex = " + i2);
            }
            methodDescriptor = new MethodDescriptor();
            methodDescriptor.callback = javaCallback;
            this.functionRegistry.put(Long.valueOf(j), methodDescriptor);
        }
        if (methodDescriptor.callback == null) {
            return null;
        }
        return V8ObjectUtilsQuick.toReturnObjectForV8(this.v8, methodDescriptor.callback.invoke(v8Object, objArr));
    }

    public static V8Object getV8Receiver() {
        return sV8Receiver;
    }

    public void callVoidJavaMethodQuick(long j, int i, int i2, ByteBuffer byteBuffer) {
        V8MemBufferFromJS v8MemBufferFromJSObtain = V8MemBufferFromJS.obtain(byteBuffer, this.v8);
        V8Object v8Object = (V8Object) v8MemBufferFromJSObtain.readObject();
        Object[] allObjects = v8MemBufferFromJSObtain.getAllObjects();
        v8MemBufferFromJSObtain.recycle();
        callVoidJavaMethod(j, i, i2, v8Object, allObjects);
    }

    public void callVoidJavaMethod(long j, int i, int i2, V8Object v8Object, Object[] objArr) {
        MethodDescriptor methodDescriptor;
        MethodDescriptor methodDescriptor2 = this.functionRegistry.get(Long.valueOf(j));
        if (methodDescriptor2 != null || i < 0 || i2 < 0) {
            methodDescriptor = methodDescriptor2;
        } else {
            String str = this.v8ExportDescriptorIndex[i];
            JavaVoidCallback javaVoidCallback = (JavaVoidCallback) this.mBindingObjectCreator.onExportMethodCall(v8Object, v8Object.getNativeObject(), str, i2);
            if (javaVoidCallback == null) {
                throw new RuntimeException("can't find method for " + str + " with propIndex = " + i2);
            }
            methodDescriptor = new MethodDescriptor();
            methodDescriptor.voidCallback = javaVoidCallback;
            this.functionRegistry.put(Long.valueOf(j), methodDescriptor);
        }
        if (methodDescriptor.voidCallback != null) {
            methodDescriptor.voidCallback.invoke(v8Object, objArr);
        }
    }

    public static void setLooper(Looper looper) {
        if (sAsyncHandler == null) {
            sAsyncHandler = new Handler(looper);
        }
    }

    public static Handler getHandler() {
        return sAsyncHandler;
    }

    boolean pumpMessageLoop() {
        return _pumpMessageLoop(this.v8RuntimePtr);
    }

    protected long initNewV8Object(long j, Object obj) {
        return _initNewV8Object(j, obj);
    }

    protected long initNewV8Map(long j) {
        return _initNewV8Map(j);
    }

    protected long initNewV8ObjectProxy(long j, Object obj, int i, boolean z) {
        return _initNewV8ObjectProxy(j, obj, i, z);
    }

    protected Object executeScript(long j, int i, String str, String str2, int i2, long j2) {
        if (this.isPendingReleased) {
            return null;
        }
        onEnterStack();
        Object obj_executeScript = _executeScript(this.mSessionId, j, i, str, str2, i2, j2);
        onExitStack();
        return obj_executeScript;
    }

    protected void executeVoidScript(long j, String str, String str2, int i, long j2) {
        if (this.isPendingReleased) {
            return;
        }
        onEnterStack();
        _executeScript(this.mSessionId, j, 0, str, str2, i, j2);
        onExitStack();
    }

    protected void setWeak(long j, long j2) {
        if (this.isPendingReleased) {
            return;
        }
        _setWeak(j, j2);
    }

    protected void clearWeak(long j, long j2) {
        if (this.isPendingReleased) {
            return;
        }
        _clearWeak(j, j2);
    }

    protected boolean isWeak(long j, long j2) {
        return _isWeak(j, j2);
    }

    protected void release(long j, long j2) {
        _release(j, j2);
    }

    protected boolean contains(long j, long j2, String str) {
        return _contains(j, j2, str);
    }

    protected int getInteger(long j, long j2, String str) {
        return _getInteger(j, j2, str);
    }

    protected boolean getBoolean(long j, long j2, String str) {
        return _getBoolean(j, j2, str);
    }

    protected double getDouble(long j, long j2, String str) {
        return _getDouble(j, j2, str);
    }

    protected String getString(long j, long j2, String str) {
        return _getString(j, j2, str);
    }

    protected Object get(long j, int i, long j2, String str) {
        return _get(j, i, j2, str);
    }

    protected Object executeFunction(long j, int i, long j2, String str, Object... objArr) {
        V8JSONProxy[] v8JSONProxyArr;
        String str2;
        if (this.isPendingReleased) {
            return null;
        }
        Object[] returnArrayForV8 = V8ObjectUtilsQuick.toReturnArrayForV8(this, Boolean.FALSE, objArr);
        try {
            onEnterStack();
        } catch (Throwable th) {
            th = th;
            v8JSONProxyArr = returnArrayForV8;
            str2 = "v8";
        }
        try {
            Object obj_executeFunction = _executeFunction(this.mSessionId, j, i, j2, str, 0L, returnArrayForV8 == null ? 0 : returnArrayForV8.length, returnArrayForV8);
            onExitStack();
            if (returnArrayForV8 != null) {
                try {
                    for (Object obj : returnArrayForV8) {
                        if (obj instanceof V8OneTimeObject) {
                            ((V8Value) obj).close();
                        } else if (obj instanceof V8JSONProxy) {
                            weakJSONProxy((V8JSONProxy) obj);
                        }
                    }
                } catch (Throwable th2) {
                    Log.e("v8", "executeFunction with expectedType finally exception: " + Log.getStackTraceString(th2));
                }
            }
            return obj_executeFunction;
        } catch (Throwable th3) {
            th = th3;
            v8JSONProxyArr = returnArrayForV8;
            str2 = "v8";
            Throwable th4 = th;
            if (v8JSONProxyArr == null) {
                throw th4;
            }
            try {
                for (V8JSONProxy v8JSONProxy : v8JSONProxyArr) {
                    if (v8JSONProxy instanceof V8OneTimeObject) {
                        v8JSONProxy.close();
                    } else if (v8JSONProxy instanceof V8JSONProxy) {
                        weakJSONProxy(v8JSONProxy);
                    }
                }
                throw th4;
            } catch (Throwable th5) {
                Log.e(str2, "executeFunction with expectedType finally exception: " + Log.getStackTraceString(th5));
                throw th4;
            }
        }
    }

    protected Object executeFunction(long j, long j2, long j3, Object... objArr) throws Throwable {
        V8JSONProxy[] v8JSONProxyArr;
        String str;
        if (this.isPendingReleased) {
            return null;
        }
        Object[] returnArrayForV8 = V8ObjectUtilsQuick.toReturnArrayForV8(this, Boolean.FALSE, objArr);
        try {
            onEnterStack();
            try {
                Object obj_executeFunction = _executeFunction(this.mSessionId, j, j2, j3, 0L, returnArrayForV8 == null ? 0 : returnArrayForV8.length, returnArrayForV8);
                onExitStack();
                if (returnArrayForV8 != null) {
                    try {
                        for (Object obj : returnArrayForV8) {
                            if (obj instanceof V8OneTimeObject) {
                                ((V8Value) obj).close();
                            } else if (obj instanceof V8JSONProxy) {
                                weakJSONProxy((V8JSONProxy) obj);
                            }
                        }
                    } catch (Throwable th) {
                        Log.e("v8", "executeFunction finally exception: " + Log.getStackTraceString(th));
                    }
                }
                return obj_executeFunction;
            } catch (Throwable th2) {
                th = th2;
                v8JSONProxyArr = returnArrayForV8;
                str = "v8";
                Throwable th3 = th;
                if (v8JSONProxyArr == null) {
                    throw th3;
                }
                try {
                    for (V8JSONProxy v8JSONProxy : v8JSONProxyArr) {
                        if (v8JSONProxy instanceof V8OneTimeObject) {
                            v8JSONProxy.close();
                        } else if (v8JSONProxy instanceof V8JSONProxy) {
                            weakJSONProxy(v8JSONProxy);
                        }
                    }
                    throw th3;
                } catch (Throwable th4) {
                    Log.e(str, "executeFunction finally exception: " + Log.getStackTraceString(th4));
                    throw th3;
                }
            }
        } catch (Throwable th5) {
            th = th5;
            v8JSONProxyArr = returnArrayForV8;
            str = "v8";
        }
    }

    protected void executeVoidFunction(long j, long j2, String str, Object... objArr) {
        if (this.isPendingReleased) {
            return;
        }
        Object[] returnArrayForV8 = V8ObjectUtilsQuick.toReturnArrayForV8(this, Boolean.FALSE, objArr);
        int i = 0;
        try {
            onEnterStack();
            _executeVoidFunction(this.mSessionId, j, j2, str, returnArrayForV8 == null ? 0 : returnArrayForV8.length, returnArrayForV8);
            onExitStack();
        } finally {
            if (returnArrayForV8 != null) {
                int length = returnArrayForV8.length;
                while (i < length) {
                    Object obj = returnArrayForV8[i];
                    if (obj instanceof V8OneTimeObject) {
                        ((V8Value) obj).close();
                    } else if (obj instanceof V8JSONProxy) {
                        weakJSONProxy((V8JSONProxy) obj);
                    }
                    i++;
                }
            }
        }
    }

    private void weakJSONProxy(V8JSONProxy v8JSONProxy) {
        if (v8JSONProxy == null || v8JSONProxy.isReleased() || v8JSONProxy.isWeak()) {
            return;
        }
        v8JSONProxy.setWeak();
    }

    protected boolean equals(long j, long j2, long j3) {
        return _equals(j, j2, j3);
    }

    protected String toString(long j, long j2) {
        return _toString(j, j2);
    }

    protected boolean strictEquals(long j, long j2, long j3) {
        return _strictEquals(j, j2, j3);
    }

    protected int identityHash(long j, long j2) {
        return _identityHash(j, j2);
    }

    protected void add(long j, long j2, String str, int i) {
        _add(j, j2, str, str.length(), i);
    }

    protected void addObject(long j, long j2, String str, long j3) {
        _addObject(j, j2, str, str.length(), j3);
    }

    public void callObjectCreate(int i, ByteBuffer byteBuffer, Object obj) {
        if (byteBuffer == null) {
            return;
        }
        int i2 = 0;
        if (i == 100) {
            Map map = (Map) obj;
            V8MemBufferFromJS v8MemBufferFromJSObtain = V8MemBufferFromJS.obtain(byteBuffer, this);
            int objectCnt = v8MemBufferFromJSObtain.getObjectCnt();
            while (i2 < objectCnt) {
                String str = (String) v8MemBufferFromJSObtain.readObject();
                Object object = v8MemBufferFromJSObtain.readObject();
                if (object instanceof V8Array) {
                    object = getList(((V8Array) object).getHandle());
                } else if (object instanceof V8Map) {
                    object = getAll(((V8Map) object).getHandle());
                } else if (!(object instanceof V8Function) && (object instanceof V8Object)) {
                    object = getAll(((V8Object) object).getHandle());
                }
                map.put(str, object);
                i2 += 2;
            }
            v8MemBufferFromJSObtain.recycle();
            return;
        }
        if (i != 101) {
            return;
        }
        List list = (List) obj;
        V8MemBufferFromJS v8MemBufferFromJSObtain2 = V8MemBufferFromJS.obtain(byteBuffer, this);
        int objectCnt2 = v8MemBufferFromJSObtain2.getObjectCnt();
        while (i2 < objectCnt2) {
            Object object2 = v8MemBufferFromJSObtain2.readObject();
            if (object2 instanceof V8Array) {
                object2 = getList(((V8Array) object2).getHandle());
            } else if (object2 instanceof V8Map) {
                object2 = getAll(((V8Map) object2).getHandle());
            } else if (!(object2 instanceof V8Function) && (object2 instanceof V8Object)) {
                object2 = getAll(((V8Object) object2).getHandle());
            }
            list.add(object2);
            i2++;
        }
        v8MemBufferFromJSObtain2.recycle();
    }

    public Map getAll(long j) {
        if (j == 0) {
            throw new RuntimeException("invalid object handle = " + j);
        }
        AutoExpandedMap autoExpandedMap = new AutoExpandedMap();
        ByteBuffer byteBuffer_getAllQuick = _getAllQuick(this.v8RuntimePtr, j, true, autoExpandedMap);
        if (byteBuffer_getAllQuick != null) {
            callObjectCreate(100, byteBuffer_getAllQuick, autoExpandedMap);
            int i = 0;
            while (true) {
                if (i >= 16) {
                    break;
                }
                if (sDirectBuffers[i] == byteBuffer_getAllQuick) {
                    _recycleDirectBuffer(i);
                    break;
                }
                i++;
            }
            return autoExpandedMap;
        }
        Map map_getAll = _getAll(this.v8RuntimePtr, j, autoExpandedMap);
        for (Object obj : map_getAll.keySet()) {
            Object all = map_getAll.get(obj);
            if (all instanceof V8Array) {
                all = getList(((V8Array) all).getHandle());
            } else if (all instanceof V8Map) {
                all = getAll(((V8Map) all).getHandle());
            } else if (!(all instanceof V8Function) && (all instanceof V8Object)) {
                all = getAll(((V8Object) all).getHandle());
            }
            autoExpandedMap.put(obj, all);
        }
        return autoExpandedMap;
    }

    public List getList(long j) {
        if (j == 0) {
            throw new RuntimeException("invalid object handle = " + j);
        }
        List autoExpandedList = new AutoExpandedList();
        ByteBuffer byteBuffer_getListQuick = _getListQuick(this.v8RuntimePtr, j, autoExpandedList);
        if (byteBuffer_getListQuick != null) {
            callObjectCreate(101, byteBuffer_getListQuick, autoExpandedList);
            int i = 0;
            while (true) {
                if (i >= 16) {
                    break;
                }
                if (sDirectBuffers[i] == byteBuffer_getListQuick) {
                    _recycleDirectBuffer(i);
                    break;
                }
                i++;
            }
            return autoExpandedList;
        }
        AutoExpandedList autoExpandedList2 = new AutoExpandedList();
        for (Object all : _getList(this.v8RuntimePtr, j, autoExpandedList)) {
            if (all instanceof V8Array) {
                all = getList(((V8Array) all).getHandle());
            } else if (all instanceof V8Map) {
                all = getAll(((V8Map) all).getHandle());
            } else if (!(all instanceof V8Function) && (all instanceof V8Object)) {
                all = getAll(((V8Object) all).getHandle());
            }
            autoExpandedList2.add(all);
        }
        return autoExpandedList2;
    }

    protected void add(long j, long j2, String str, boolean z) {
        _add(j, j2, str, str.length(), z);
    }

    protected void add(long j, long j2, String str, double d) {
        _add(j, j2, str, str.length(), d);
    }

    protected void add(long j, long j2, String str, String str2) {
        _add(j, j2, str, str.length(), str2, str2.length());
    }

    protected void addUndefined(long j, long j2, String str) {
        _addUndefined(j, j2, str, str.length());
    }

    protected void addNull(long j, long j2, String str) {
        _addNull(j, j2, str, str.length());
    }

    protected long initNewV8ArrayBuffer(long j, ByteBuffer byteBuffer, int i) {
        return _initNewV8ArrayBuffer(j, byteBuffer, i);
    }

    protected long initNewV8ArrayBuffer(long j, int i) {
        return _initNewV8ArrayBuffer(j, i);
    }

    protected ByteBuffer createV8ArrayBufferBackingStore(long j, long j2, int i) {
        return _createV8ArrayBufferBackingStore(j, j2, i);
    }

    protected long initNewV8Array(long j) {
        return _initNewV8Array(j);
    }

    protected long[] initNewV8Function(long j, String str, boolean z) {
        checkThread();
        return _initNewV8Function(j, str, z);
    }

    protected int arrayGetSize(long j, long j2) {
        return _arrayGetSize(j, j2);
    }

    protected int arrayGetInteger(long j, long j2, int i) {
        return _arrayGetInteger(j, j2, i);
    }

    protected boolean arrayGetBoolean(long j, long j2, int i) {
        return _arrayGetBoolean(j, j2, i);
    }

    protected byte arrayGetByte(long j, long j2, int i) {
        return _arrayGetByte(j, j2, i);
    }

    protected double arrayGetDouble(long j, long j2, int i) {
        return _arrayGetDouble(j, j2, i);
    }

    protected String arrayGetString(long j, long j2, int i) {
        return _arrayGetString(j, j2, i);
    }

    protected Object arrayGet(long j, int i, long j2, int i2) {
        return _arrayGet(j, i, j2, i2);
    }

    protected void addArrayIntItem(long j, long j2, int i) {
        _addArrayIntItem(j, j2, i);
    }

    protected void addArrayBooleanItem(long j, long j2, boolean z) {
        _addArrayBooleanItem(j, j2, z);
    }

    protected void addArrayDoubleItem(long j, long j2, double d) {
        _addArrayDoubleItem(j, j2, d);
    }

    protected void addArrayStringItem(long j, long j2, String str) {
        _addArrayStringItem(j, j2, str);
    }

    protected void addArrayObjectItem(long j, long j2, long j3) {
        _addArrayObjectItem(j, j2, j3);
    }

    protected void addArrayUndefinedItem(long j, long j2) {
        _addArrayUndefinedItem(j, j2);
    }

    protected void addArrayNullItem(long j, long j2) {
        _addArrayNullItem(j, j2);
    }

    protected int getArrayType(long j, long j2) {
        return _getArrayType(j, j2);
    }

    protected void releaseMethodDescriptor(long j, long j2) {
        _releaseMethodDescriptor(j, j2);
    }

    public long getContextHandle() {
        return _getContextHandle(this.v8RuntimePtr);
    }

    public long getIsolateHandle() {
        return _getIsolateHandle(this.v8RuntimePtr);
    }

    private long _getIsolateHandle(long j) {
        return getBindingIsolatePtr();
    }

    public static void setConstructors(String[] strArr) {
        if (sJSConstructors != null) {
            if (strArr.length == sJSConstructors.length) {
                return;
            }
            throw new RuntimeException("cache constructor cnt = " + sJSConstructors.length);
        }
        synchronized (V8.class) {
            if (sJSConstructors == null) {
                String[] strArr2 = new String[strArr.length];
                System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
                sJSConstructors = strArr2;
            }
            String[] strArr3 = sJSConstructors;
            boolean z = false;
            for (String str : strArr3) {
                if ("TKView".equals(str)) {
                    z = true;
                }
            }
            if (!z) {
                throw new RuntimeException("contructors is not valid, constructors = " + TextUtils.join(",", strArr3));
            }
        }
    }

    public int registerExposedComponents() {
        String[] strArr = sJSConstructors;
        this.v8ExportDescriptorIndex = strArr;
        int i_registerExposedComponents = _registerExposedComponents(this.v8RuntimePtr, strArr.length, strArr, null, true);
        if (i_registerExposedComponents > 0) {
            if (this.v8ExportDescriptorMapping == null) {
                HashMap map = new HashMap();
                for (int i = 0; i < strArr.length; i++) {
                    map.put(strArr[i], Integer.valueOf(i));
                }
                this.v8ExportDescriptorMapping = map;
            }
            return i_registerExposedComponents;
        }
        throw new RuntimeException("register exposed component failed with registerCnt = " + i_registerExposedComponents);
    }

    public static void loadNativeLibraries(NativeLibraryLoader nativeLibraryLoader) {
        if (nativeLibraryLoaded) {
            return;
        }
        synchronized (lock) {
            if (!nativeLibraryLoaded) {
                load(null, nativeLibraryLoader);
            }
        }
    }

    public void addTrackedObj(long j, V8Value v8Value) {
        if (this.isPendingReleased) {
            synchronized (this.mPendingRemovingObjs) {
                this.mPendingRemovingObjs.put(Long.valueOf(j), v8Value);
            }
            return;
        }
        this.mTrackedObjs.put(Long.valueOf(j), v8Value);
    }

    public boolean removeTrackedObj(long j) {
        V8Value v8ValueRemove;
        if (this.isPendingReleased || (v8ValueRemove = this.mTrackedObjs.remove(Long.valueOf(j))) == null) {
            return false;
        }
        v8ValueRemove.released = true;
        v8ValueRemove.objectHandle = 0L;
        v8ValueRemove.onJsRefDestroy();
        return true;
    }

    public void removeTrackedObjs(ByteBuffer byteBuffer, int i) {
        this.mIsGcing = true;
        byte[] bArrArray = byteBuffer.array();
        int iArrayOffset = byteBuffer.arrayOffset();
        for (int i2 = 0; i2 < i; i2++) {
            V8Value v8ValueRemove = this.mTrackedObjs.remove(Long.valueOf(V8MemBufferFromJS.readLong(bArrArray, (i2 * 8) + iArrayOffset)));
            if (v8ValueRemove != null) {
                v8ValueRemove.released = true;
                v8ValueRemove.objectHandle = 0L;
                v8ValueRemove.onJsRefDestroy();
            }
        }
        this.mIsGcing = false;
    }

    public Object getTrackedObj(long j) {
        return j == this.v8RuntimePtr ? this : this.mTrackedObjs.get(Long.valueOf(j));
    }

    public Object getTrackedObjOrCreate(long j, long j2, int i, Object obj) {
        if (j == this.v8RuntimePtr) {
            return this;
        }
        V8Value v8Value = this.mTrackedObjs.get(Long.valueOf(j));
        if (v8Value == null) {
            if (i == 5) {
                return new V8Array(this, j);
            }
            if (i == 6) {
                return new V8Object(this, j);
            }
            if (i == 7) {
                return new V8Function(this, j);
            }
            if (i == 8) {
                return new V8TypedArray(this, j);
            }
            if (i == 10) {
                return new V8ArrayBuffer(this, j, (ByteBuffer) obj);
            }
            if (i == 17) {
                if (j2 == 0) {
                    return null;
                }
                return new V8ObjectProxy(this, j, j2, null);
            }
            if (i == 22) {
                return new V8Map(this, j);
            }
        }
        return v8Value;
    }

    private Object getQuickReturnObject(Object obj, ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            return null;
        }
        if (obj == null) {
            _setDByte(byteBuffer, (byte) 0, (byte) 0);
            return null;
        }
        if (obj instanceof Integer) {
            _setDInt(byteBuffer, (byte) 1, ((Integer) obj).intValue());
            return null;
        }
        if (obj instanceof Double) {
            _setDDouble(byteBuffer, (byte) 2, ((Double) obj).doubleValue());
            return null;
        }
        if (obj instanceof Float) {
            _setDDouble(byteBuffer, (byte) 2, ((Float) obj).doubleValue());
            return null;
        }
        if (obj instanceof Long) {
            _setDLong(byteBuffer, (byte) 23, ((Long) obj).longValue());
            return null;
        }
        if (obj instanceof Boolean) {
            _setDByte(byteBuffer, (byte) 3, ((Boolean) obj).booleanValue() ? (byte) 1 : (byte) 0);
            return null;
        }
        if (obj instanceof String) {
            _setUnProcessed(byteBuffer);
            return obj;
        }
        if (obj instanceof V8OneTimeObject) {
            _setDLong(byteBuffer, (byte) 19, ((V8OneTimeObject) obj).getHandle());
            return null;
        }
        if (obj instanceof V8Value) {
            _setDLong(byteBuffer, (byte) 18, ((V8Value) obj).getHandle());
            return null;
        }
        if (obj instanceof TypedArray) {
            _setDLong(byteBuffer, (byte) 18, V8ObjectUtilsQuick.toV8TypedArray(this.v8, (TypedArray) obj, null).getHandle());
            return null;
        }
        if (obj instanceof ArrayBuffer) {
            _setDLong(byteBuffer, (byte) 18, V8ObjectUtilsQuick.toV8ArrayBuffer(this.v8, (ArrayBuffer) obj, null).getHandle());
            return null;
        }
        if (obj instanceof Map) {
            _setDLong(byteBuffer, (byte) 19, V8ObjectUtilsQuick.toV8Object(this.v8, (Map) obj, null).getHandle());
            return null;
        }
        if (obj instanceof List) {
            _setDLong(byteBuffer, (byte) 19, V8ObjectUtilsQuick.toV8Array(this.v8, (List) obj, null).getHandle());
            return null;
        }
        _setUnProcessed(byteBuffer);
        throw new RuntimeException("Unsupported return object " + obj);
    }

    private static void _setUnProcessed(ByteBuffer byteBuffer) {
        byteBuffer.array()[byteBuffer.arrayOffset()] = 1;
    }

    private static void _setPropIgnored(ByteBuffer byteBuffer) {
        byteBuffer.array()[byteBuffer.arrayOffset()] = 8;
    }

    private static void _setDLong(ByteBuffer byteBuffer, byte b, long j) {
        byte[] bArrArray = byteBuffer.array();
        int iArrayOffset = byteBuffer.arrayOffset();
        bArrArray[iArrayOffset] = RETURN_BYTE_MAGIC_NUMBER;
        bArrArray[iArrayOffset + 1] = b;
        V8MemBufferFromJS.loadLongIntoBytes(bArrArray, iArrayOffset + 2, j);
    }

    private static void _setDInt(ByteBuffer byteBuffer, byte b, int i) {
        byte[] bArrArray = byteBuffer.array();
        int iArrayOffset = byteBuffer.arrayOffset();
        bArrArray[iArrayOffset] = RETURN_BYTE_MAGIC_NUMBER;
        bArrArray[iArrayOffset + 1] = b;
        V8MemBufferFromJS.loadIntIntoBytes(bArrArray, iArrayOffset + 2, i);
    }

    private static void _setDDouble(ByteBuffer byteBuffer, byte b, double d) {
        byte[] bArrArray = byteBuffer.array();
        int iArrayOffset = byteBuffer.arrayOffset();
        bArrArray[iArrayOffset] = RETURN_BYTE_MAGIC_NUMBER;
        bArrArray[iArrayOffset + 1] = b;
        V8MemBufferFromJS.loadDoubleIntoBytes(bArrArray, iArrayOffset + 2, d);
    }

    private static void _setDByte(ByteBuffer byteBuffer, byte b, byte b2) {
        byte[] bArrArray = byteBuffer.array();
        int iArrayOffset = byteBuffer.arrayOffset();
        bArrArray[iArrayOffset] = RETURN_BYTE_MAGIC_NUMBER;
        bArrArray[iArrayOffset + 1] = b;
        bArrArray[iArrayOffset + 2] = b2;
    }

    public void commitBatchCommands(ByteBuffer byteBuffer) {
        V8MemBufferFromJS v8MemBufferFromJSObtain = V8MemBufferFromJS.obtain(byteBuffer, this);
        while (v8MemBufferFromJSObtain.hasRemaining()) {
            long jNanoTime = BuildConfig.ENABLE_ANALYZE_PERFORMANCE.booleanValue() ? System.nanoTime() : 0L;
            int i = v8MemBufferFromJSObtain.readInt();
            int i2 = i & 255;
            int i3 = i >> 8;
            int i4 = 0;
            Object[] objArr = null;
            switch (i2) {
                case 1:
                    execSetReceiver((V8Object) v8MemBufferFromJSObtain.readObject());
                    break;
                case 2:
                    execSetStyle(i3, (String) v8MemBufferFromJSObtain.readObject(), v8MemBufferFromJSObtain.readObject());
                    break;
                case 3:
                    execSetProp(i3, v8MemBufferFromJSObtain.readInt(), (String) v8MemBufferFromJSObtain.readObject(), v8MemBufferFromJSObtain.readObject());
                    break;
                case 4:
                    long jLongValue = ((Long) v8MemBufferFromJSObtain.readObject()).longValue();
                    int i5 = v8MemBufferFromJSObtain.readInt();
                    int i6 = v8MemBufferFromJSObtain.readInt();
                    int iIntValue = ((Integer) v8MemBufferFromJSObtain.readObject()).intValue();
                    if (iIntValue > 0) {
                        objArr = new Object[iIntValue];
                        while (i4 < iIntValue) {
                            objArr[i4] = v8MemBufferFromJSObtain.readObject();
                            i4++;
                        }
                    }
                    execCallMethod(i3, jLongValue, i5, i6, null, objArr, false);
                    break;
                case 5:
                    long jLongValue2 = ((Long) v8MemBufferFromJSObtain.readObject()).longValue();
                    int i7 = v8MemBufferFromJSObtain.readInt();
                    int i8 = v8MemBufferFromJSObtain.readInt();
                    int i9 = v8MemBufferFromJSObtain.readInt();
                    if (i9 > 0) {
                        objArr = new Object[i9];
                        while (i4 < i9) {
                            objArr[i4] = v8MemBufferFromJSObtain.readObject();
                            i4++;
                        }
                    }
                    execCallMethod(i3, jLongValue2, i7, i8, null, objArr, true);
                    break;
                case 6:
                    execGetProp(i3, v8MemBufferFromJSObtain.readInt(), (String) v8MemBufferFromJSObtain.readObject());
                    break;
            }
            if (BuildConfig.ENABLE_ANALYZE_PERFORMANCE.booleanValue()) {
                V8Trace.addCommunicationCost(this, (((System.nanoTime() - jNanoTime) / 1000.0f) / 1000.0f) * 2.0f);
            }
        }
        v8MemBufferFromJSObtain.recycle();
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void commitCommand(int r17, int r18, int r19, long r20, int r22, int r23, int r24, java.lang.Object[] r25) {
        /*
            r16 = this;
            r10 = r16
            r11 = r18
            r12 = r19
            r0 = r23
            r13 = r25
            java.lang.Boolean r1 = com.tkruntime.v8.BuildConfig.ENABLE_ANALYZE_PERFORMANCE
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L17
            long r1 = java.lang.System.nanoTime()
            goto L19
        L17:
            r1 = 0
        L19:
            r14 = r1
            r1 = 1
            r2 = 0
            switch(r11) {
                case 1: goto L63;
                case 2: goto L59;
                case 3: goto L4f;
                case 4: goto L3d;
                case 5: goto L2a;
                case 6: goto L21;
                default: goto L1f;
            }
        L1f:
            goto Lba
        L21:
            r1 = r13[r2]     // Catch: java.lang.Exception -> L6b
            java.lang.String r1 = (java.lang.String) r1     // Catch: java.lang.Exception -> L6b
            r10.execGetProp(r12, r0, r1)     // Catch: java.lang.Exception -> L6b
            goto Lba
        L2a:
            r7 = 0
            r9 = 1
            r1 = r16
            r2 = r19
            r3 = r20
            r5 = r22
            r6 = r23
            r8 = r25
            r1.execCallMethod(r2, r3, r5, r6, r7, r8, r9)     // Catch: java.lang.Exception -> L6b
            goto Lba
        L3d:
            r7 = 0
            r9 = 0
            r1 = r16
            r2 = r19
            r3 = r20
            r5 = r22
            r6 = r23
            r8 = r25
            r1.execCallMethod(r2, r3, r5, r6, r7, r8, r9)     // Catch: java.lang.Exception -> L6b
            goto Lba
        L4f:
            r2 = r13[r2]     // Catch: java.lang.Exception -> L6b
            java.lang.String r2 = (java.lang.String) r2     // Catch: java.lang.Exception -> L6b
            r1 = r13[r1]     // Catch: java.lang.Exception -> L6b
            r10.execSetProp(r12, r0, r2, r1)     // Catch: java.lang.Exception -> L6b
            goto Lba
        L59:
            r0 = r13[r2]     // Catch: java.lang.Exception -> L6b
            java.lang.String r0 = (java.lang.String) r0     // Catch: java.lang.Exception -> L6b
            r1 = r13[r1]     // Catch: java.lang.Exception -> L6b
            r10.execSetStyle(r12, r0, r1)     // Catch: java.lang.Exception -> L6b
            goto Lba
        L63:
            r0 = r13[r2]     // Catch: java.lang.Exception -> L6b
            com.tkruntime.v8.V8Object r0 = (com.tkruntime.v8.V8Object) r0     // Catch: java.lang.Exception -> L6b
            r10.execSetReceiver(r0)     // Catch: java.lang.Exception -> L6b
            goto Lba
        L6b:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Java ErrorMsg :  fromIndex = "
            r1.<init>(r2)
            r2 = r17
            r1.append(r2)
            java.lang.String r2 = " , "
            r1.append(r2)
            java.lang.String r2 = r0.getMessage()
            r1.append(r2)
            java.lang.String r2 = " , cmd = "
            r1.append(r2)
            r1.append(r11)
            java.lang.String r2 = " , seqNum = "
            r1.append(r2)
            r1.append(r12)
            java.lang.String r2 = " , methid = "
            r1.append(r2)
            r2 = r20
            r1.append(r2)
            java.lang.String r2 = " ,argLen = "
            r1.append(r2)
            r2 = r24
            r1.append(r2)
            java.lang.String r2 = " , params = "
            r1.append(r2)
            r1.append(r13)
            java.lang.String r1 = r1.toString()
            java.lang.RuntimeException r2 = new java.lang.RuntimeException
            r2.<init>(r1, r0)
            throw r2
        Lba:
            java.lang.Boolean r0 = com.tkruntime.v8.BuildConfig.ENABLE_ANALYZE_PERFORMANCE
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto Ld3
            long r0 = java.lang.System.nanoTime()
            long r0 = r0 - r14
            float r0 = (float) r0
            r1 = 1148846080(0x447a0000, float:1000.0)
            float r0 = r0 / r1
            float r0 = r0 / r1
            r1 = 1073741824(0x40000000, float:2.0)
            float r0 = r0 * r1
            com.tkruntime.v8.V8Trace.addCommunicationCost(r10, r0)
        Ld3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tkruntime.v8.V8.commitCommand(int, int, int, long, int, int, int, java.lang.Object[]):void");
    }

    public Object flush(ByteBuffer byteBuffer) {
        commitBatchCommands(byteBuffer);
        commitStyleIfNecessary();
        this.mReceiver = null;
        SparseArray<SeqCommandRunner> sparseArray = this.mCmds;
        this.mCmds = new SparseArray<>();
        int size = sparseArray.size();
        if (BuildConfig.ENABLE_ANALYZE_PERFORMANCE.booleanValue()) {
            V8Trace.logD("V8", "flush begin >>>>>>>>>>>>>>>>>>>> " + size);
        }
        SeqCommandRunner seqCommandRunnerValueAt = null;
        Object objExec = null;
        for (int i = 0; i < size; i++) {
            seqCommandRunnerValueAt = sparseArray.valueAt(i);
            BindingObjectCreator bindingObjectCreator = this.mBindingObjectCreator;
            if (bindingObjectCreator != null) {
                objExec = bindingObjectCreator.onFlushCmd(seqCommandRunnerValueAt, this);
            } else {
                objExec = seqCommandRunnerValueAt.exec(this);
            }
        }
        if (BuildConfig.ENABLE_ANALYZE_PERFORMANCE.booleanValue()) {
            V8Trace.logD("V8", "flush end <<<<<<<<<<<<<<<<<<<< " + size);
        }
        if (seqCommandRunnerValueAt instanceof RTMethodRunner) {
            return getQuickReturnObject(objExec, byteBuffer);
        }
        if ((seqCommandRunnerValueAt instanceof PropRunner) && ((PropRunner) seqCommandRunnerValueAt).isGetter) {
            if (objExec == sPropUnSupported) {
                _setPropIgnored(byteBuffer);
                return null;
            }
            return getQuickReturnObject(objExec, byteBuffer);
        }
        return objExec;
    }

    private void commitStyleIfNecessary() {
        if (this.mCurrentStyle == null || this.mReceiver == null) {
            return;
        }
        StyleRunner styleRunner = new StyleRunner();
        styleRunner.seqNum = this.mStyleSeq;
        styleRunner.mReceiver = this.mReceiver;
        styleRunner.style = this.mCurrentStyle;
        this.mCmds.append(styleRunner.seqNum, styleRunner);
        this.mCurrentStyle = null;
        this.mStyleSeq = -1;
    }

    private void execSetReceiver(V8Object v8Object) {
        commitStyleIfNecessary();
        this.mReceiver = (V8ObjectProxy) v8Object;
    }

    private void execSetStyle(int i, String str, Object obj) {
        if (this.mCurrentStyle == null) {
            this.mCurrentStyle = new AutoExpandedMap();
            this.mStyleSeq = i;
        }
        this.mCurrentStyle.put(str, V8ObjectUtilsQuick.getValue(obj));
    }

    private void execSetProp(int i, int i2, String str, Object obj) {
        commitStyleIfNecessary();
        if (this.mReceiver == null) {
            return;
        }
        PropRunner propRunner = new PropRunner();
        propRunner.mReceiver = this.mReceiver;
        propRunner.seqNum = i;
        propRunner.key = str;
        propRunner.value = obj;
        propRunner.propIndex = i2;
        if (obj instanceof V8Value) {
            propRunner.hasRef = true;
        }
        this.mCmds.append(propRunner.seqNum, propRunner);
    }

    private void execGetProp(int i, int i2, String str) {
        commitStyleIfNecessary();
        if (this.mReceiver == null) {
            return;
        }
        PropRunner propRunner = new PropRunner();
        propRunner.mReceiver = this.mReceiver;
        propRunner.seqNum = i;
        propRunner.key = str;
        propRunner.isGetter = true;
        propRunner.propIndex = i2;
        this.mCmds.append(propRunner.seqNum, propRunner);
    }

    private void execCallMethod(int i, long j, int i2, int i3, String str, Object[] objArr, boolean z) {
        MethodRunner methodRunner;
        commitStyleIfNecessary();
        if (this.mReceiver == null) {
            return;
        }
        if (z) {
            methodRunner = new RTMethodRunner();
        } else {
            methodRunner = new MethodRunner();
        }
        methodRunner.mReceiver = this.mReceiver;
        methodRunner.seqNum = i;
        methodRunner.args = objArr;
        methodRunner.funcName = str;
        methodRunner.methId = j;
        methodRunner.descriptorIndex = i2;
        methodRunner.methodIndex = i3;
        this.mCmds.append(methodRunner.seqNum, methodRunner);
    }

    public static abstract class SeqCommandRunner implements CommandRunner {
        V8ObjectProxy mReceiver;
        int seqNum = -1;
        int propIndex = -1;
        boolean hasRef = false;

        @Override // com.tkruntime.v8.V8.CommandRunner
        public boolean hasJSRef() {
            return this.hasRef;
        }

        public String toString() {
            if (BuildConfig.ENABLE_ANALYZE_PERFORMANCE.booleanValue()) {
                return this.mReceiver.getOriginClzzName();
            }
            return super.toString();
        }
    }

    public static class StyleRunner extends SeqCommandRunner {
        HashMap style;

        @Override // com.tkruntime.v8.V8.CommandRunner
        public Object exec(V8 v8) {
            return this.mReceiver.onPropCall(false, "style", this.style);
        }

        @Override // com.tkruntime.v8.V8.SeqCommandRunner
        public String toString() {
            if (BuildConfig.ENABLE_ANALYZE_PERFORMANCE.booleanValue()) {
                return super.toString() + ".style = " + this.style;
            }
            return super.toString();
        }
    }

    public static class PropRunner extends SeqCommandRunner {
        boolean isGetter = false;
        String key;
        Object value;

        @Override // com.tkruntime.v8.V8.CommandRunner
        public Object exec(V8 v8) {
            if (this.key == null && this.propIndex >= 0) {
                V8ObjectProxy v8ObjectProxy = this.mReceiver;
                this.key = v8.getBindingObjectCreator().getPropNameByIndex(v8ObjectProxy, v8ObjectProxy.getOriginClzzName(), this.propIndex);
            }
            return this.mReceiver.onPropCall(this.isGetter, this.key, this.value);
        }

        @Override // com.tkruntime.v8.V8.SeqCommandRunner
        public String toString() {
            Object all;
            if (BuildConfig.ENABLE_ANALYZE_PERFORMANCE.booleanValue()) {
                try {
                    String propNameByIndex = this.mReceiver.v8.getBindingObjectCreator().getPropNameByIndex(this.mReceiver, this.mReceiver.getOriginClzzName(), this.propIndex);
                    if (this.isGetter) {
                        return super.toString() + " get " + propNameByIndex;
                    }
                    StringBuilder sb = new StringBuilder();
                    sb.append(super.toString());
                    sb.append(".");
                    sb.append(propNameByIndex);
                    sb.append(" = ");
                    if (this.value instanceof V8Array) {
                        all = ((V8Array) this.value).getList();
                    } else {
                        all = this.value instanceof V8Object ? ((V8Object) this.value).getAll() : this.value;
                    }
                    sb.append(all);
                    return sb.toString();
                } catch (Throwable unused) {
                }
            }
            return super.toString();
        }
    }

    public static class MethodRunner extends SeqCommandRunner {
        Object[] args;
        String funcName;
        long methId;
        int descriptorIndex = -1;
        int methodIndex = -1;

        @Override // com.tkruntime.v8.V8.CommandRunner
        public Object exec(V8 v8) {
            try {
                v8.callVoidJavaMethod(this.methId, this.descriptorIndex, this.methodIndex, this.mReceiver, this.args);
                return null;
            } catch (Throwable th) {
                StringBuilder sb = new StringBuilder("call non-rtfunc ");
                sb.append(this.funcName);
                sb.append(", ");
                sb.append(this.mReceiver == null ? ILogConst.CACHE_PLAY_REASON_NULL : this.mReceiver.getOriginClzzName());
                throw new RuntimeException(sb.toString(), th);
            }
        }

        @Override // com.tkruntime.v8.V8.SeqCommandRunner
        public String toString() {
            if (BuildConfig.ENABLE_ANALYZE_PERFORMANCE.booleanValue()) {
                try {
                    return super.toString() + "." + this.mReceiver.v8.getBindingObjectCreator().getPropNameByIndex(this.mReceiver, this.mReceiver.getOriginClzzName(), this.methodIndex) + "(" + getParametersString(this.args) + ")";
                } catch (Throwable unused) {
                }
            }
            return super.toString();
        }

        private String getParametersString(Object[] objArr) {
            String string;
            if (!BuildConfig.ENABLE_ANALYZE_PERFORMANCE.booleanValue()) {
                return "";
            }
            try {
                StringBuilder sb = new StringBuilder();
                if (objArr != null && objArr.length != 0) {
                    int length = objArr.length;
                    for (int i = 0; i < length; i++) {
                        if (objArr[i] instanceof V8ObjectProxy) {
                            string = ((V8ObjectProxy) objArr[i]).getOriginClzzName();
                        } else {
                            string = objArr[i] == null ? ILogConst.CACHE_PLAY_REASON_NULL : objArr[i].toString();
                        }
                        sb.append(string);
                        if (i != length - 1) {
                            sb.append(", ");
                        }
                    }
                    return sb.toString();
                }
                return sb.toString();
            } catch (Throwable unused) {
                return "";
            }
        }
    }

    public static class RTMethodRunner extends MethodRunner {
        @Override // com.tkruntime.v8.V8.MethodRunner, com.tkruntime.v8.V8.CommandRunner
        public Object exec(V8 v8) {
            try {
                return v8.callObjectJavaMethod(this.methId, this.descriptorIndex, this.methodIndex, this.mReceiver, this.args);
            } catch (Throwable th) {
                StringBuilder sb = new StringBuilder("call rtfunc ");
                sb.append(this.funcName);
                sb.append(", ");
                sb.append(this.mReceiver == null ? ILogConst.CACHE_PLAY_REASON_NULL : this.mReceiver.getOriginClzzName());
                throw new RuntimeException(sb.toString(), th);
            }
        }
    }

    public Object onPropCallQuick(long j, boolean z, int i, ByteBuffer byteBuffer) {
        V8MemBufferFromJS v8MemBufferFromJSObtain = V8MemBufferFromJS.obtain(byteBuffer, this.v8);
        V8Object v8Object = (V8Object) getTrackedObj(j);
        String propNameByIndex = (String) v8MemBufferFromJSObtain.readObject();
        if (propNameByIndex == null && i >= 0) {
            V8ObjectProxy v8ObjectProxy = (V8ObjectProxy) v8Object;
            propNameByIndex = this.mBindingObjectCreator.getPropNameByIndex(v8ObjectProxy, v8ObjectProxy.getOriginClzzName(), i);
        }
        Object object = !z ? v8MemBufferFromJSObtain.readObject() : null;
        v8MemBufferFromJSObtain.recycle();
        if (z) {
            Object objOnPropCall = v8Object.onPropCall(z, propNameByIndex, object);
            if (objOnPropCall == sPropUnSupported) {
                _setPropIgnored(byteBuffer);
                return null;
            }
            return getQuickReturnObject(objOnPropCall, byteBuffer);
        }
        return v8Object.onPropCall(z, propNameByIndex, object);
    }

    public Object onPropCall(long j, boolean z, String str, int i, Object obj) {
        V8Object v8Object = (V8Object) getTrackedObj(j);
        if (str == null && i >= 0) {
            V8ObjectProxy v8ObjectProxy = (V8ObjectProxy) v8Object;
            str = this.mBindingObjectCreator.getPropNameByIndex(v8ObjectProxy, v8ObjectProxy.getOriginClzzName(), i);
        }
        Object objOnPropCall = v8Object.onPropCall(z, str, obj);
        if (z && objOnPropCall == sPropUnSupported) {
            return null;
        }
        return objOnPropCall;
    }

    public String[] onPropEnumerator(long j) {
        V8Object v8Object = (V8Object) this.mTrackedObjs.get(Long.valueOf(j));
        if (v8Object == null) {
            return null;
        }
        return v8Object.onPropEnumerator();
    }

    public void setBindingObjectCreator(BindingObjectCreator bindingObjectCreator) {
        this.mBindingObjectCreator = bindingObjectCreator;
    }

    public BindingObjectCreator getBindingObjectCreator() {
        return this.mBindingObjectCreator;
    }

    Object constructRealObject(V8ObjectProxy v8ObjectProxy, String str, Object[] objArr) {
        BindingObjectCreator bindingObjectCreator = this.mBindingObjectCreator;
        if (bindingObjectCreator != null) {
            return bindingObjectCreator.constructRealObject(v8ObjectProxy, str, objArr);
        }
        return null;
    }

    Object onPropCall(V8Object v8Object, Object obj, String str, boolean z, String str2, Object obj2) {
        BindingObjectCreator bindingObjectCreator = this.mBindingObjectCreator;
        if (bindingObjectCreator != null) {
            return bindingObjectCreator.onPropCall(v8Object, obj, str, z, str2, obj2);
        }
        return null;
    }

    String[] onPropEnumerator(V8ObjectProxy v8ObjectProxy) {
        BindingObjectCreator bindingObjectCreator = this.mBindingObjectCreator;
        if (bindingObjectCreator != null) {
            return bindingObjectCreator.onPropEnumerator(v8ObjectProxy);
        }
        return null;
    }

    void onJsRefDestroy(Object obj) {
        BindingObjectCreator bindingObjectCreator = this.mBindingObjectCreator;
        if (bindingObjectCreator != null) {
            bindingObjectCreator.onJsRefDestroy(obj, true);
        }
    }

    public void initTracing(String str) {
        if (BuildConfig.ENABLE_ANALYZE_PERFORMANCE.booleanValue()) {
            _initTracing(getV8RuntimePtr(), str);
        }
    }

    public void startTracing() {
        if (BuildConfig.ENABLE_ANALYZE_PERFORMANCE.booleanValue()) {
            _startTracing(getV8RuntimePtr());
        }
    }

    public void stopTracing() {
        if (BuildConfig.ENABLE_ANALYZE_PERFORMANCE.booleanValue()) {
            _stopTracing(getV8RuntimePtr());
        }
    }

    public Map<String, Integer> getHeapInfo() {
        if (BuildConfig.ENABLE_ANALYZE_PERFORMANCE.booleanValue()) {
            return _getHeapInfo(getV8RuntimePtr());
        }
        return null;
    }
}
