package com.kuaishou.tk.api;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.kuaishou.tk.api.export.ITKViewContainer;
import com.kuaishou.tk.api.export.sdk.FunctionCallback;
import com.kuaishou.tk.api.export.sdk.IFunction;
import com.tk.core.component.e;
import com.tk.core.d.a.a;
import com.tk.core.o.ad;
import com.tk.core.o.t;
import com.tkruntime.v8.JavaCallback;
import com.tkruntime.v8.JsValueRef;
import com.tkruntime.v8.V8Function;
import com.tkruntime.v8.V8Object;
import com.tkruntime.v8.V8Trace;
import com.tkruntime.v8.utils.V8ObjectUtilsQuick;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public class TKViewContainer extends FrameLayout implements ITKViewContainer {
    private ITKViewContainer.IJS2NativeInvoker mInvoker;
    private long mLastSetDataBeginTime;
    private long mLastSetDataEndTime;
    private int mSetDataCount;
    private int mSetDataIndex;
    private String mV8TraceTag;
    private int mViewContainerIndex;
    private String mViewKey;
    private String mViewSessionID;
    private a param;
    public e tkView;

    private boolean canHotReload() {
        return false;
    }

    @Override // com.kuaishou.tk.api.export.ITKViewContainer
    public ITKViewContainer getContainer() {
        return this;
    }

    @Override // com.kuaishou.tk.api.export.ITKViewContainer
    public FrameLayout getView() {
        return this;
    }

    public TKViewContainer(String str, e eVar) {
        super(eVar.getContext());
        this.mSetDataCount = 0;
        this.mViewKey = str;
        bindTKView(eVar);
        e eVar2 = this.tkView;
        if (eVar2 != null && eVar2.pP() != null && !this.tkView.pP().isReleased()) {
            this.mV8TraceTag = this.tkView.pP().pi().getTraceTag(this.mViewKey, "");
        }
        initHotReloadParam();
    }

    public void setViewContainerIndex(int i) {
        this.mViewContainerIndex = i;
    }

    public void setViewSessionID(String str) {
        this.mViewSessionID = str;
    }

    @Override // com.kuaishou.tk.api.export.ITKViewContainer
    public void setData(Object... objArr) {
        e eVar = this.tkView;
        if (eVar != null) {
            V8Object v8ObjectPL = eVar.pL();
            if (v8ObjectPL != null && !v8ObjectPL.isReleased()) {
                try {
                    this.mSetDataCount++;
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    com.tk.core.i.a.z("TKViewContainer", "setData bundleId: " + this.tkView.pO().pq());
                    this.tkView.pP().getBindingIsolateRef().an(true);
                    try {
                        v8ObjectPL.executeVoidFunction(V8Trace.SECTION_SET_DATA, objArr);
                        this.tkView.pP().getBindingIsolateRef().an(false);
                        long jCurrentTimeMillis2 = System.currentTimeMillis();
                        this.mLastSetDataBeginTime = jCurrentTimeMillis;
                        this.mLastSetDataEndTime = jCurrentTimeMillis2;
                        saveHotReloadParamData(objArr);
                        return;
                    } catch (Throwable th) {
                        this.tkView.pP().getBindingIsolateRef().an(false);
                        throw th;
                    }
                } catch (Throwable th2) {
                    com.tk.core.exception.a.b(th2, this.tkView.pP().pg());
                    return;
                }
            }
            if (t.isDebug()) {
                throw new IllegalStateException("未找到 TKBase 对应的 js object handler，setData 只对 jsContext.createView 创建的 view 有效");
            }
            com.tk.core.i.a.a("TKViewContainer", "未找到 TKBase 对应的 js object handler，setData 只对 jsContext.createView 创建的 view 有效", null);
            return;
        }
        throw new IllegalStateException("TKViewContainer 里没有 view，代码不应该执行到这里");
    }

    private void initHotReloadParam() {
        if (canHotReload()) {
            this.param = new a();
        }
    }

    private void saveHotReloadParamData(Object... objArr) {
        a aVar;
        if (!canHotReload() || (aVar = this.param) == null) {
            return;
        }
        aVar.setData(objArr);
    }

    private void saveHotReloadParamInvoker(ITKViewContainer.IJS2NativeInvoker iJS2NativeInvoker) {
        a aVar;
        if (!canHotReload() || (aVar = this.param) == null) {
            return;
        }
        aVar.a(iJS2NativeInvoker);
    }

    @Override // com.kuaishou.tk.api.export.ITKViewContainer
    public void setIJS2NativeInvoker(ITKViewContainer.IJS2NativeInvoker iJS2NativeInvoker) {
        this.mInvoker = iJS2NativeInvoker;
        registerInvoker();
        saveHotReloadParamInvoker(iJS2NativeInvoker);
    }

    public void setIJS2NativeInvoker(ITKViewContainer.IJS2NativeInvoker iJS2NativeInvoker, e.a aVar) {
        if (iJS2NativeInvoker == null || aVar == null) {
            return;
        }
        this.mInvoker = iJS2NativeInvoker;
        e eVar = this.tkView;
        if (eVar != null) {
            eVar.a(aVar);
        }
        saveHotReloadParamInvoker(iJS2NativeInvoker);
    }

    @Override // com.kuaishou.tk.api.export.ITKViewContainer
    public Object invokeJSFunctionWithJSONString(String str, String str2, final IFunction iFunction) {
        return this.tkView.a(str, str2, iFunction == null ? null : new JavaCallback() { // from class: com.kuaishou.tk.api.TKViewContainer.1
            @Override // com.tkruntime.v8.JavaCallback
            public Object invoke(V8Object v8Object, Object[] objArr) {
                Object[] objArr2;
                if (objArr == null || objArr.length == 0) {
                    objArr2 = objArr;
                } else {
                    objArr2 = new Object[objArr.length];
                    for (int i = 0; i < objArr.length; i++) {
                        objArr2[i] = V8ObjectUtilsQuick.getValue(objArr[i]);
                    }
                }
                return iFunction.call(objArr2);
            }
        });
    }

    @Override // com.kuaishou.tk.api.export.ITKViewContainer
    public void close() {
        e eVar = this.tkView;
        if (eVar == null || eVar.pP() == null || !this.tkView.pP().isReleased()) {
            dfsDestroyChildren(this.tkView.getView());
        }
    }

    private void dfsDestroyChildren(View view) {
        if (view == null) {
            return;
        }
        if (view instanceof ViewGroup) {
            int i = 0;
            while (true) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (i >= viewGroup.getChildCount()) {
                    break;
                }
                dfsDestroyChildren(viewGroup.getChildAt(i));
                i++;
            }
        }
        e eVarAN = e.aN(view);
        if (eVarAN != null) {
            eVarAN.pM();
        }
    }

    void bindTKView(e eVar) {
        if (this.tkView == eVar) {
            return;
        }
        clearOldView();
        this.tkView = eVar;
        registerInvoker();
        ViewGroup viewGroup = (ViewGroup) eVar.getView();
        if (viewGroup != null) {
            addView(viewGroup);
        }
    }

    private void clearOldView() {
        e eVar = this.tkView;
        if (eVar != null) {
            eVar.a((e.a) null);
            removeView(this.tkView.getView());
            this.tkView.destroy(true);
        }
    }

    private void registerInvoker() {
        e eVar = this.tkView;
        if (eVar == null) {
            return;
        }
        final ITKViewContainer.IJS2NativeInvoker iJS2NativeInvoker = this.mInvoker;
        if (iJS2NativeInvoker == null) {
            eVar.a((e.a) null);
        } else {
            eVar.a(new e.a() { // from class: com.kuaishou.tk.api.TKViewContainer.2
                @Override // com.tk.core.component.e.a
                public Object onJSInvokeNativeWithJSONString(final String str, String str2, V8Function v8Function) {
                    final JsValueRef jsValueRefRetainJsValue = ad.retainJsValue(v8Function, TKViewContainer.this);
                    return iJS2NativeInvoker.onJSInvokeNativeWithJSONString(str, str2, jsValueRefRetainJsValue != null ? new IFunction() { // from class: com.kuaishou.tk.api.TKViewContainer.2.1
                        @Override // com.kuaishou.tk.api.export.sdk.IFunction
                        public void callWithCallback(FunctionCallback functionCallback, Object... objArr) {
                        }

                        @Override // com.kuaishou.tk.api.export.sdk.IFunction
                        public Object call(Object... objArr) {
                            try {
                                if (ad.isV8Valid((V8Object) jsValueRefRetainJsValue.get())) {
                                    return V8ObjectUtilsQuick.getValue(((V8Function) jsValueRefRetainJsValue.get()).call(null, objArr));
                                }
                                return null;
                            } catch (Throwable th) {
                                com.tk.core.exception.a.a(TKViewContainer.this.tkView.pO(), th, "onJSInvokeNativeWithJSONString fail, function name is " + str);
                                return null;
                            }
                        }

                        @Override // com.kuaishou.tk.api.export.sdk.IFunction
                        public void destroy() {
                            ad.unRetainJsValue(jsValueRefRetainJsValue);
                        }
                    } : null);
                }
            });
        }
    }

    public a getParam() {
        return this.param;
    }

    public e getBaseView() {
        e eVar = this.tkView;
        if (eVar != null) {
            removeView(eVar.getView());
        }
        return this.tkView;
    }

    public void replaceBaseView(e eVar) {
        if (eVar == null || this.tkView == eVar) {
            return;
        }
        clearOldView();
        this.tkView = eVar;
        registerInvoker();
        addView(eVar.getView(), 0);
        a aVar = this.param;
        if (aVar == null || aVar.rB() == null) {
            return;
        }
        setData(this.param.rB());
    }
}
