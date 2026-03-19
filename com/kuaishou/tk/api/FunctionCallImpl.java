package com.kuaishou.tk.api;

import com.kuaishou.tk.api.export.sdk.FunctionCallback;
import com.kuaishou.tk.api.export.sdk.IFunction;
import com.tk.core.bridge.IsolatePool;
import com.tk.core.bridge.b;
import com.tk.core.exception.a;
import com.tk.core.o.ad;
import com.tkruntime.v8.JsValueRef;
import com.tkruntime.v8.V8Function;
import com.tkruntime.v8.utils.V8ObjectUtilsQuick;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
class FunctionCallImpl implements IFunction {
    private final b mTKJSContext;
    private final JsValueRef<V8Function> mV8FunctionRef;

    FunctionCallImpl(V8Function v8Function, b bVar) {
        this.mV8FunctionRef = ad.retainJsValue(v8Function, this);
        this.mTKJSContext = bVar;
    }

    @Override // com.kuaishou.tk.api.export.sdk.IFunction
    public Object call(final Object... objArr) {
        if (this.mTKJSContext.po()) {
            IsolatePool.a(false, this.mTKJSContext.pj().getBindingIsolateRef()).execute(new Runnable() { // from class: com.kuaishou.tk.api.FunctionCallImpl.1
                @Override // java.lang.Runnable
                public void run() {
                    FunctionCallImpl.this.callFunction(null, objArr);
                }
            });
            return null;
        }
        return callFunction(null, objArr);
    }

    @Override // com.kuaishou.tk.api.export.sdk.IFunction
    public void callWithCallback(final FunctionCallback functionCallback, final Object... objArr) {
        if (this.mTKJSContext.po()) {
            IsolatePool.a(false, this.mTKJSContext.pj().getBindingIsolateRef()).execute(new Runnable() { // from class: com.kuaishou.tk.api.FunctionCallImpl.2
                @Override // java.lang.Runnable
                public void run() {
                    FunctionCallImpl.this.callFunction(functionCallback, objArr);
                }
            });
        } else {
            callFunction(functionCallback, objArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object callFunction(FunctionCallback functionCallback, Object... objArr) {
        JsValueRef<V8Function> jsValueRef = this.mV8FunctionRef;
        if (jsValueRef == null || !ad.isV8Valid(jsValueRef.get())) {
            if (functionCallback != null) {
                functionCallback.onFailed(new Throwable("Function is inValid"));
            }
            return null;
        }
        try {
            Object value = V8ObjectUtilsQuick.getValue(this.mV8FunctionRef.get().call(null, objArr));
            if (functionCallback != null) {
                functionCallback.onSuccess(value);
            }
            return value;
        } catch (Throwable th) {
            if (functionCallback != null) {
                functionCallback.onFailed(th);
            }
            a.a(this.mTKJSContext, th);
            return null;
        }
    }

    @Override // com.kuaishou.tk.api.export.sdk.IFunction
    public void destroy() {
        if (this.mTKJSContext.po()) {
            IsolatePool.a(false, this.mTKJSContext.pj().getBindingIsolateRef()).execute(new Runnable() { // from class: com.kuaishou.tk.api.FunctionCallImpl.3
                @Override // java.lang.Runnable
                public void run() {
                    ad.unRetainJsValue(FunctionCallImpl.this.mV8FunctionRef);
                }
            });
        } else {
            ad.unRetainJsValue(this.mV8FunctionRef);
        }
    }
}
