package com.tk.core.bridge;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import com.kuaishou.tk.api.export.sdk.TkBundleInfo;
import com.kuaishou.tk.export.INativeModule;
import com.kuaishou.tk.export.ITKContext;
import com.kuaishou.tk.export.NativeModuleInitParams;
import com.tk.core.bridge.IsolatePool;
import com.tk.core.component.e;
import com.tk.core.component.view.TKView;
import com.tk.core.exception.CreateViewFailException;
import com.tk.core.manager.f;
import com.tkruntime.v8.JavaCallback;
import com.tkruntime.v8.JavaUnifiedCallback;
import com.tkruntime.v8.JavaVoidCallback;
import com.tkruntime.v8.JsValueRef;
import com.tkruntime.v8.V8;
import com.tkruntime.v8.V8Function;
import com.tkruntime.v8.V8Object;
import com.tkruntime.v8.V8ObjectProxy;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.Stack;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class b implements ITKContext, com.tk.core.c.a {
    private static String Zh;
    private com.tk.core.bridge.a YV;
    private WeakReference<Activity> YW;
    private com.tk.core.manager.d YX;
    private WeakReference<ViewGroup> YY;
    private JsValueRef<V8Object> YZ;
    private boolean Za;
    private long Zb;
    private boolean Zc;
    private Map<String, CustomEnv> Zd;
    private com.tk.core.a.d Ze;
    private a Zf;
    private TKView Zg;
    private Boolean Zi;
    private final V8.BindingObjectCreator mBindingObjectCreator;
    private String mBundleId;
    private int mCliValue;
    private String mRootDir;
    private TkBundleInfo mTkBundleInfo;

    @Override // com.kuaishou.tk.export.ITKContext
    public final Context getContext() {
        Activity activity;
        WeakReference<Activity> weakReference = this.YW;
        return (weakReference == null || (activity = weakReference.get()) == null) ? com.tk.core.a.Yb : activity;
    }

    @Override // com.kuaishou.tk.export.ITKContext
    public final INativeModule getNativeModule(V8Object v8Object) {
        Object nativeObject = v8Object instanceof V8ObjectProxy ? ((V8ObjectProxy) v8Object).getNativeObject() : null;
        if (nativeObject instanceof INativeModule) {
            return (INativeModule) nativeObject;
        }
        return null;
    }

    public b(Context context, boolean z, IsolatePool.b bVar, com.tk.core.manager.d dVar, String str) {
        this(context, z, bVar, null, dVar, str);
    }

    public b(Context context, boolean z, IsolatePool.b bVar, ViewGroup viewGroup, com.tk.core.manager.d dVar, String str) {
        com.tk.core.bridge.a aVarPd;
        this.YV = null;
        this.YW = null;
        this.YY = null;
        this.mRootDir = "";
        this.Za = false;
        this.Zb = 0L;
        this.Zc = false;
        this.mCliValue = 0;
        this.Zi = null;
        this.mBindingObjectCreator = new V8.BindingObjectCreator() { // from class: com.tk.core.bridge.b.1
            @Override // com.tkruntime.v8.V8.BindingObjectCreator
            public final String[] onPropEnumerator(V8ObjectProxy v8ObjectProxy) {
                return new String[0];
            }

            @Override // com.tkruntime.v8.V8.BindingObjectCreator
            public final Object constructRealObject(V8ObjectProxy v8ObjectProxy, String str2, Object[] objArr) {
                com.tk.core.manager.a.a aVarCN;
                if (v8ObjectProxy != null && v8ObjectProxy.getCliValue() > 0) {
                    b.this.mCliValue = v8ObjectProxy.getCliValue();
                }
                if (b.this.Zb == 0) {
                    b.this.Zb = System.currentTimeMillis();
                }
                if (TextUtils.isEmpty(str2) || (aVarCN = com.tk.core.manager.d.rZ().cN(str2)) == null) {
                    return null;
                }
                return aVarCN.b(new NativeModuleInitParams.Builder(b.this, v8ObjectProxy).setArgs(objArr).build());
            }

            @Override // com.tkruntime.v8.V8.BindingObjectCreator
            public final Object onPropCall(V8Object v8Object, Object obj, String str2, boolean z2, String str3, Object obj2) {
                Object objA;
                if (b.this.Zb == 0) {
                    b.this.Zb = System.currentTimeMillis();
                }
                if (str2.endsWith("_stub")) {
                    str2 = str2.replace("_stub", "");
                }
                com.tk.core.manager.a.a aVarCN = com.tk.core.manager.d.rZ().cN(str2);
                Object obj3 = V8ObjectProxy.PROP_SET_IGNORE;
                if (TextUtils.isEmpty(str3) || !(v8Object instanceof V8ObjectProxy) || aVarCN == null) {
                    return obj3;
                }
                if (obj == null) {
                    obj = b.this.a((V8ObjectProxy) v8Object, (com.tk.core.manager.a.a<?>) aVarCN);
                }
                if (obj == null) {
                    return obj3;
                }
                V8 v8Pi = b.this.YV.pi();
                int iH = aVarCN.h(str3);
                if (iH > 0) {
                    Object obj4 = V8ObjectProxy.PROP_SET_HANDLED;
                    if (!z2) {
                        return obj4;
                    }
                    if (iH == 1) {
                        return new V8Function(v8Pi, b.this.a(str2, str3, (com.tk.core.manager.a.a<?>) aVarCN));
                    }
                    return new V8Function(v8Pi, str3, b.this.b(str2, str3, aVarCN));
                }
                if (!aVarCN.g(str3)) {
                    return obj3;
                }
                if (z2) {
                    objA = aVarCN.a(obj, str3);
                } else {
                    objA = aVarCN.b(obj, str3, obj2) ? V8ObjectProxy.PROP_SET_HANDLED : V8ObjectProxy.PROP_SET_IGNORE;
                }
                return objA;
            }

            @Override // com.tkruntime.v8.V8.BindingObjectCreator
            public final JavaUnifiedCallback onExportMethodCall(V8Object v8Object, Object obj, String str2, int i) {
                if (str2.endsWith("_stub")) {
                    str2 = str2.replace("_stub", "");
                }
                com.tk.core.manager.a.a aVarCN = com.tk.core.manager.d.rZ().cN(str2);
                if (obj == null) {
                    if (v8Object instanceof V8ObjectProxy) {
                        b.this.a((V8ObjectProxy) v8Object, (com.tk.core.manager.a.a<?>) aVarCN);
                    } else {
                        b.this.getGlobalNativeObject(str2);
                    }
                }
                String strBM = aVarCN.bM(i);
                return aVarCN.h(strBM) == 1 ? b.this.a(str2, strBM, (com.tk.core.manager.a.a<?>) aVarCN) : b.this.b(str2, strBM, aVarCN);
            }

            @Override // com.tkruntime.v8.V8.BindingObjectCreator
            public final String getPropNameByIndex(V8ObjectProxy v8ObjectProxy, String str2, int i) {
                if (str2.endsWith("_stub")) {
                    str2 = str2.replace("_stub", "");
                }
                return com.tk.core.manager.d.rZ().cN(str2).bM(i);
            }

            @Override // com.tkruntime.v8.V8.BindingObjectCreator
            public final void onJsRefDestroy(Object obj, boolean z2) {
                if (obj == null) {
                    return;
                }
                try {
                    if (obj instanceof com.tk.core.c.a) {
                        ((com.tk.core.c.a) obj).onDestroy();
                    } else if (obj instanceof INativeModule) {
                        ((INativeModule) obj).destroy(!z2);
                    }
                } catch (Throwable th) {
                    com.tk.core.exception.a.a(b.this, th);
                }
            }

            @Override // com.tkruntime.v8.V8.BindingObjectCreator
            public final Object onFlushCmd(V8.SeqCommandRunner seqCommandRunner, V8 v8) {
                try {
                    return seqCommandRunner.exec(v8);
                } catch (Exception e) {
                    com.tk.core.exception.a.a(b.this, e);
                    return null;
                }
            }
        };
        if (context instanceof Activity) {
            this.YW = new WeakReference<>((Activity) context);
        }
        if (viewGroup != null) {
            this.YY = new WeakReference<>(viewGroup);
        }
        this.Zf = new a();
        this.YX = dVar;
        if (z && (aVarPd = bVar.pd()) != null && aVarPd.getBindingIsolateRef().Yz == bVar.Yz) {
            this.YV = aVarPd;
        }
        if (this.YV == null) {
            this.Zc = false;
            this.YV = com.tk.core.bridge.a.b(z, bVar, str);
        }
        this.YV.dt(hashCode());
    }

    @Override // com.tk.core.c.a
    public final void onCreate() {
        if (this.YX == null) {
            this.YX = com.tk.core.manager.d.rZ();
        }
        pk();
    }

    @Override // com.tk.core.c.a
    public final void onDestroy() {
        com.tk.core.i.a.z("TKJSContext", "onDestroy: " + this.mBundleId);
        WeakReference<ViewGroup> weakReference = this.YY;
        if (weakReference != null) {
            weakReference.clear();
            this.YY = null;
        }
        try {
            this.YV.destroy();
        } catch (Exception e) {
            com.tk.core.exception.a.a(this, e);
        }
        Map<String, CustomEnv> map = this.Zd;
        if (map != null) {
            map.clear();
        }
        WeakReference<Activity> weakReference2 = this.YW;
        if (weakReference2 != null) {
            weakReference2.clear();
            this.YW = null;
        }
    }

    public final com.tk.core.component.e a(String str, Object... objArr) {
        V8Function v8FunctionBc;
        Object objCall;
        d dVar = (d) getGlobalNativeObject("Tachikoma");
        V8Function v8FunctionPB = dVar.pB();
        if (v8FunctionPB == null) {
            v8FunctionBc = dVar.bc(str);
            if (v8FunctionBc == null) {
                throw new CreateViewFailException(0, str);
            }
        } else {
            v8FunctionBc = null;
        }
        this.YV.getBindingIsolateRef().an(true);
        try {
            if (v8FunctionPB != null) {
                if (objArr == null || objArr.length == 0) {
                    objCall = v8FunctionPB.call(null, str);
                } else {
                    int length = objArr.length + 1;
                    Object[] objArr2 = new Object[length];
                    objArr2[0] = str;
                    System.arraycopy(objArr, 0, objArr2, 1, length - 1);
                    objCall = v8FunctionPB.call(null, objArr2);
                }
            } else {
                objCall = v8FunctionBc.call(null, objArr);
            }
            if (objCall == null) {
                throw new CreateViewFailException(1, str);
            }
            if (!(objCall instanceof V8Object)) {
                throw new CreateViewFailException(2, str);
            }
            INativeModule nativeModule = getNativeModule((V8Object) objCall);
            if (!(nativeModule instanceof com.tk.core.component.e)) {
                throw new CreateViewFailException(2, str);
            }
            com.tk.core.component.e eVar = (com.tk.core.component.e) nativeModule;
            eVar.pL();
            if (eVar instanceof TKView) {
                TKView tKView = this.Zg;
                if (tKView != null) {
                    tKView.getView().qE();
                }
                this.Zg = (TKView) eVar;
                this.Zg.aC(true);
            } else {
                com.tk.core.exception.a.a(this, new Throwable("rootView is not TKView"));
            }
            return eVar;
        } finally {
            this.YV.getBindingIsolateRef().an(false);
        }
    }

    public final Object getGlobalNativeObject(String str) {
        pj().checkReleased();
        V8ObjectProxy v8ObjectProxyBa = pj().ba(str);
        if (v8ObjectProxyBa == null) {
            return null;
        }
        Object nativeObject = v8ObjectProxyBa.getNativeObject();
        if (nativeObject == null) {
            nativeObject = a(v8ObjectProxyBa, com.tk.core.manager.d.rZ().sc().get(str));
        }
        return nativeObject == null ? a(v8ObjectProxyBa, com.tk.core.manager.d.rZ().sd().get(str)) : nativeObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object a(V8ObjectProxy v8ObjectProxy, com.tk.core.manager.a.a<?> aVar) {
        if (aVar == null) {
            return null;
        }
        Object objB = aVar.b(new NativeModuleInitParams.Builder(this, v8ObjectProxy).build());
        if (objB instanceof com.tk.core.c.a) {
            ((com.tk.core.c.a) objB).onCreate();
        }
        v8ObjectProxy.setNativeObject(objB);
        return objB;
    }

    public final com.tk.core.bridge.a pj() {
        return this.YV;
    }

    @Override // com.kuaishou.tk.export.ITKContext
    public final String getTag() {
        return String.valueOf(hashCode());
    }

    private void pk() {
        V8 v8Pi = this.YV.pi();
        f.st().a(this.YV, this, v8Pi);
        v8Pi.setBindingObjectCreator(this.mBindingObjectCreator);
        V8.setConstructors(com.tk.core.manager.d.rZ().sh());
        v8Pi.registerExposedComponents();
        String[] strArr = (String[]) com.tk.core.manager.d.rZ().sc().keySet().toArray(new String[0]);
        String[] strArrSf = com.tk.core.manager.d.rZ().sf();
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            V8ObjectProxy v8ObjectProxy = new V8ObjectProxy(v8Pi, strArrSf[i]);
            this.YV.a(strArr[i], v8ObjectProxy);
            v8Pi.add(strArr[i], v8ObjectProxy);
        }
        String[] strArr2 = (String[]) com.tk.core.manager.d.rZ().sd().keySet().toArray(new String[0]);
        String[] strArrSg = com.tk.core.manager.d.rZ().sg();
        int length2 = strArr2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            V8ObjectProxy v8ObjectProxy2 = new V8ObjectProxy(v8Pi, strArrSg[i2], true);
            this.YV.a(strArr2[i2], v8ObjectProxy2);
            v8Pi.add(strArr2[i2], v8ObjectProxy2);
        }
    }

    public final JsValueRef<V8Object> pl() {
        return this.YZ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JavaVoidCallback a(final String str, final String str2, final com.tk.core.manager.a.a<?> aVar) {
        return new JavaVoidCallback() { // from class: com.tk.core.bridge.b.2
            @Override // com.tkruntime.v8.JavaVoidCallback
            public final void invoke(V8Object v8Object, Object[] objArr) {
                b.this.a(v8Object, objArr, str, str2, aVar);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JavaCallback b(final String str, final String str2, final com.tk.core.manager.a.a<?> aVar) {
        return new JavaCallback() { // from class: com.tk.core.bridge.b.3
            @Override // com.tkruntime.v8.JavaCallback
            public final Object invoke(V8Object v8Object, Object[] objArr) {
                return b.this.a(v8Object, objArr, str, str2, aVar);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object a(V8Object v8Object, Object[] objArr, String str, String str2, com.tk.core.manager.a.a<?> aVar) {
        Object globalNativeObject;
        if (v8Object instanceof V8ObjectProxy) {
            globalNativeObject = ((V8ObjectProxy) v8Object).getNativeObject();
        } else {
            globalNativeObject = getGlobalNativeObject(str);
        }
        if (globalNativeObject == null) {
            com.tk.core.exception.a.a(this, new Throwable("function call, nativeObject is null: " + str + ", methodName: " + str2));
            return null;
        }
        try {
            return aVar.a(globalNativeObject, str2, objArr);
        } catch (Exception e) {
            com.tk.core.exception.a.a(this, new RuntimeException(str + " call " + str2 + " error: " + e.getLocalizedMessage() + "\nparams: " + getParametersString(objArr), e));
            return null;
        }
    }

    public static String getParametersString(Object[] objArr) {
        StringBuilder sb = new StringBuilder();
        if (objArr == null || objArr.length == 0) {
            return sb.toString();
        }
        sb.append("[ ");
        int length = objArr.length;
        for (int i = 0; i < length; i++) {
            sb.append(z(objArr[i]));
            if (i != length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static String z(Object obj) {
        if (obj == null) {
            return "";
        }
        if (obj instanceof V8ObjectProxy) {
            return obj.getClass().getSimpleName() + " : " + ((V8ObjectProxy) obj).getOriginClzzName();
        }
        return obj.getClass().getSimpleName() + " : " + obj;
    }

    public final void w(V8Object v8Object) {
        com.tk.core.component.e eVar = (com.tk.core.component.e) getNativeModule(v8Object);
        if (eVar == null) {
            return;
        }
        eVar.pL();
        if (eVar instanceof TKView) {
            this.Zg = (TKView) eVar;
            this.Zg.aC(true);
        } else {
            com.tk.core.exception.a.a(this, new Throwable("rootView is not TKView"));
        }
        ViewGroup viewGroup = (ViewGroup) eVar.getView();
        WeakReference<ViewGroup> weakReference = this.YY;
        ViewGroup viewGroup2 = weakReference != null ? weakReference.get() : null;
        if (viewGroup2 == null) {
            com.tk.core.exception.a.a(this, new Throwable("rootView is null, bundleId: " + this.mBundleId));
        } else if (viewGroup != null) {
            viewGroup2.removeAllViews();
            viewGroup2.addView(viewGroup);
        }
    }

    public final void a(com.tk.core.a.d dVar) {
        this.Ze = dVar;
    }

    public final com.tk.core.a.d pm() {
        return this.Ze;
    }

    public final String pn() {
        if (!TextUtils.isEmpty(this.mRootDir) && !this.mRootDir.endsWith("/")) {
            this.mRootDir = this.mRootDir.concat("/");
        }
        return this.mRootDir;
    }

    public final void bb(String str) {
        this.mRootDir = str;
    }

    public final void setRenderWithoutUI(boolean z) {
        this.Za = z;
    }

    public final boolean po() {
        return this.Za;
    }

    public final long getFirstToNativeTime() {
        return this.Zb;
    }

    public final boolean getUseCleanContext() {
        return this.Zc;
    }

    public final Map<String, CustomEnv> pp() {
        return this.Zd;
    }

    public final void setCustomEnv(Map<String, CustomEnv> map) {
        this.Zd = map;
    }

    public final int getCliValue() {
        return this.mCliValue;
    }

    public final String pq() {
        return this.mBundleId;
    }

    public final void setBundleId(String str) {
        this.mBundleId = str;
    }

    public final TkBundleInfo pr() {
        return this.mTkBundleInfo;
    }

    public final void a(TkBundleInfo tkBundleInfo) {
        this.mTkBundleInfo = tkBundleInfo;
    }

    public final a ps() {
        return this.Zf;
    }

    public final TKView pt() {
        return this.Zg;
    }

    public static class a {
        int index = 0;
        private Stack<C0817a> Zn = new Stack<>();

        /* renamed from: com.tk.core.bridge.b$a$a, reason: collision with other inner class name */
        public static class C0817a {
            public String Zo = null;
            public e.a Zp = null;
        }

        public final C0817a pv() {
            if (this.Zn.isEmpty()) {
                return null;
            }
            return this.Zn.peek();
        }
    }

    public final boolean pu() {
        Boolean bool = this.Zi;
        if (bool != null) {
            return bool.booleanValue();
        }
        if (Zh == null && com.tk.core.a.oP().getTKSwitch() != null) {
            Zh = com.tk.core.a.oP().getTKSwitch().oZ();
        }
        if (Zh == null) {
            this.Zi = Boolean.TRUE;
            return true;
        }
        String strPq = pq();
        if (!TextUtils.isEmpty(Zh) && !TextUtils.isEmpty(strPq)) {
            String str = Zh;
            this.Zi = Boolean.valueOf(!str.contains("\"" + strPq + "\""));
        } else {
            this.Zi = Boolean.TRUE;
        }
        return this.Zi.booleanValue();
    }
}
