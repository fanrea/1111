package com.kuaishou.tk.api;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Looper;
import android.view.ViewGroup;
import com.kuaishou.tk.api.app.ILibraryLoader;
import com.kuaishou.tk.api.app.ITKCache;
import com.kuaishou.tk.api.app.ITKLog;
import com.kuaishou.tk.api.exception.ContainerInfoMap;
import com.kuaishou.tk.api.exception.ITKExceptionHandler;
import com.kuaishou.tk.api.exception.TKExceptionHandlerInnerImpl;
import com.kuaishou.tk.export.NativeModuleInitParams;
import com.sigmob.sdk.base.mta.PointType;
import com.tk.component.imageview.b;
import com.tk.component.imageview.g;
import com.tk.component.imageview.l;
import com.tk.core.a;
import com.tk.core.a.e;
import com.tk.core.a.h;
import com.tk.core.a.i;
import com.tk.core.a.p;
import com.tk.core.a.r;
import com.tk.core.a.s;
import com.tk.core.bridge.IsolatePool;
import com.tk.core.component.c.c;
import com.tk.core.component.text.q;
import com.tk.core.component.view.TKView;
import com.tk.core.component.view.TKViewBackgroundDrawable;
import com.tk.core.manager.d;
import com.tk.core.manager.f;
import com.tk.core.o.ac;
import com.tk.core.o.k;
import com.tkruntime.v8.StringPool;
import com.tkruntime.v8.V8;
import com.tkruntime.v8.V8ObjectProxy;
import com.tkruntime.v8.env.DynamicEnv;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public class TachikomaApi {
    private static final TachikomaApi instance = new TachikomaApi();
    private static volatile boolean sIsPreRunJs = false;
    private static volatile boolean sProxyPropsInjected = false;
    private Application mApplication;

    private TachikomaApi() {
    }

    public static void registerExtraLib(String... strArr) {
        d.registerExtraLib(strArr);
    }

    public static TachikomaApi getInstance() {
        return instance;
    }

    public void setCacheDelegate(final ITKCache iTKCache) {
        a.oP().a(new e() { // from class: com.kuaishou.tk.api.TachikomaApi.1
            @Override // com.tk.core.a.e
            public void set(String str, Object obj) {
                ITKCache iTKCache2 = iTKCache;
                if (iTKCache2 != null) {
                    iTKCache2.set(str, obj);
                }
            }

            @Override // com.tk.core.a.e
            public Object get(String str) {
                ITKCache iTKCache2 = iTKCache;
                if (iTKCache2 != null) {
                    return iTKCache2.get(str);
                }
                return null;
            }

            @Override // com.tk.core.a.e
            public void remove(String str) {
                ITKCache iTKCache2 = iTKCache;
                if (iTKCache2 != null) {
                    iTKCache2.remove(str);
                }
            }

            @Override // com.tk.core.a.e
            public boolean exist(String str) {
                ITKCache iTKCache2 = iTKCache;
                if (iTKCache2 != null) {
                    return iTKCache2.exist(str);
                }
                return false;
            }
        });
    }

    public void setLoggerDelegate(final ITKLog iTKLog) {
        a.oP().a(new i() { // from class: com.kuaishou.tk.api.TachikomaApi.2
            public void v(String str, String str2) {
                ITKLog iTKLog2 = iTKLog;
                if (iTKLog2 != null) {
                    iTKLog2.v(str, str2);
                }
            }

            public void v(String str, String str2, Throwable th) {
                ITKLog iTKLog2 = iTKLog;
                if (iTKLog2 != null) {
                    iTKLog2.v(str, str2, th);
                }
            }

            public void d(String str, String str2) {
                ITKLog iTKLog2 = iTKLog;
                if (iTKLog2 != null) {
                    iTKLog2.d(str, str2);
                }
            }

            @Override // com.tk.core.a.i
            public void d(String str, String str2, Throwable th) {
                ITKLog iTKLog2 = iTKLog;
                if (iTKLog2 != null) {
                    iTKLog2.d(str, str2, th);
                }
            }

            @Override // com.tk.core.a.i
            public void i(String str, String str2) {
                ITKLog iTKLog2 = iTKLog;
                if (iTKLog2 != null) {
                    iTKLog2.i(str, str2);
                }
            }

            public void i(String str, String str2, Throwable th) {
                ITKLog iTKLog2 = iTKLog;
                if (iTKLog2 != null) {
                    iTKLog2.i(str, str2, th);
                }
            }

            @Override // com.tk.core.a.i
            public void w(String str, String str2) {
                ITKLog iTKLog2 = iTKLog;
                if (iTKLog2 != null) {
                    iTKLog2.w(str, str2);
                }
            }

            public void w(String str, String str2, Throwable th) {
                ITKLog iTKLog2 = iTKLog;
                if (iTKLog2 != null) {
                    iTKLog2.w(str, str2, th);
                }
            }

            public void w(String str, Throwable th) {
                ITKLog iTKLog2 = iTKLog;
                if (iTKLog2 != null) {
                    iTKLog2.w(str, th);
                }
            }

            @Override // com.tk.core.a.i
            public void e(String str, String str2) {
                ITKLog iTKLog2 = iTKLog;
                if (iTKLog2 != null) {
                    iTKLog2.e(str, str2);
                }
            }

            @Override // com.tk.core.a.i
            public void e(String str, String str2, Throwable th) {
                ITKLog iTKLog2 = iTKLog;
                if (iTKLog2 != null) {
                    iTKLog2.e(str, str2, th);
                }
            }

            public String getStackTraceString(Throwable th) {
                ITKLog iTKLog2 = iTKLog;
                return iTKLog2 != null ? iTKLog2.getStackTraceString(th) : "";
            }
        });
    }

    public void setLibraryLoaderDelegate(final ILibraryLoader iLibraryLoader) {
        a.oP().a(new h() { // from class: com.kuaishou.tk.api.TachikomaApi.3
            @Override // com.tk.core.a.h
            public void loadLibrary(String str) {
                ILibraryLoader iLibraryLoader2 = iLibraryLoader;
                if (iLibraryLoader2 != null) {
                    iLibraryLoader2.loadLibrary(str);
                }
            }
        });
    }

    public void setITKNetworkProvider(p pVar) {
        a.oP().setITKNetworkProvider(pVar);
    }

    public void init(Application application, s sVar, boolean z) {
        this.mApplication = application;
        a.oP().init(application, sVar, z);
    }

    public void preloadWithoutV8() {
        com.tk.core.o.p.execute(new Runnable() { // from class: com.kuaishou.tk.api.TachikomaApi.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.tk.core.manager.a.rV();
                    TKViewBackgroundDrawable.preLoad();
                    f.st().preLoad();
                    ContainerInfoMap.preload();
                    com.tk.core.component.text.a.f.ae();
                    b.preload();
                    com.tk.component.imageview.f.preload();
                    l.preload();
                    com.tk.component.imageview.i.preLoad();
                    DynamicEnv.getInstance();
                } catch (Exception unused) {
                }
            }
        });
    }

    public void preloadYoga() {
        com.tk.core.h.b.rU();
        com.tk.core.h.b.b(0, PointType.SIGMOB_APP);
    }

    public void preLoad(final boolean z) {
        final IsolatePool.b bVarA = IsolatePool.a(true, "");
        IsolatePool.a(true, bVarA).execute(new Runnable() { // from class: com.kuaishou.tk.api.TachikomaApi.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    final com.tk.core.bridge.b bVarA2 = a.oP().a(true, bVarA, "");
                    final TKContext tKContext = new TKContext(bVarA2);
                    final V8ObjectProxy v8ObjectProxy = tKContext.getV8Context() != null ? new V8ObjectProxy(tKContext.getV8Context(), "preload-class") : null;
                    if (V8.getHandler() == null) {
                        V8.setLooper(com.tk.core.manager.a.rV().rW().getLooper());
                    }
                    com.tk.core.o.p.execute(new Runnable() { // from class: com.kuaishou.tk.api.TachikomaApi.5.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Runnable runnable;
                            try {
                                if (Looper.myLooper() == null) {
                                    Looper.prepare();
                                }
                                if (!z) {
                                    com.tk.core.h.b.rU();
                                    com.tk.core.h.b.b(0, PointType.SIGMOB_APP);
                                    TKViewBackgroundDrawable.preLoad();
                                    f.st().preLoad();
                                    ContainerInfoMap.preload();
                                    com.tk.core.component.text.a.f.ae();
                                    com.tk.component.imageview.i.preLoad();
                                }
                                com.tk.core.component.text.f.rh().preload();
                                com.tk.core.bridge.d.preLoad();
                                if (v8ObjectProxy != null) {
                                    NativeModuleInitParams nativeModuleInitParamsBuild = new NativeModuleInitParams.Builder(tKContext.getContext(), v8ObjectProxy).build();
                                    com.tk.core.k.a.t(new TKView(nativeModuleInitParamsBuild, true));
                                    com.tk.core.k.a.t(new q(nativeModuleInitParamsBuild, true));
                                    if (Build.VERSION.SDK_INT <= 29) {
                                        com.tk.core.k.a.t(new com.tk.component.imageview.i(nativeModuleInitParamsBuild, true));
                                    }
                                    try {
                                        if (com.tk.core.component.e.qv() || (Build.VERSION.SDK_INT != 27 && Build.VERSION.SDK_INT != 30 && Build.VERSION.SDK_INT != 25)) {
                                            com.tk.core.k.a.t(new c(nativeModuleInitParamsBuild, true));
                                        }
                                        if (com.tk.core.component.e.qv() || Build.VERSION.SDK_INT > 25) {
                                            com.tk.core.k.a.t(new com.tk.core.component.b.b(nativeModuleInitParamsBuild, true));
                                        }
                                    } catch (Exception e) {
                                        com.tk.core.i.a.a("tachikoma_preload", "async create component exception", e);
                                    }
                                    new b(nativeModuleInitParamsBuild, true);
                                    new com.tk.component.imageview.f(nativeModuleInitParamsBuild, true);
                                    new l(nativeModuleInitParamsBuild, true);
                                    k.P(bVarA2.getContext());
                                } else {
                                    com.tk.core.i.a.a("TachikomaApi", "preLoad: tkContext is not valid", null);
                                }
                                runnable = new Runnable() { // from class: com.kuaishou.tk.api.TachikomaApi.5.1.1
                                    @Override // java.lang.Runnable
                                    public void run() throws Throwable {
                                        tKContext.onDestroy();
                                    }
                                };
                            } catch (Throwable th) {
                                try {
                                    com.tk.core.exception.a.a((com.tk.core.bridge.b) null, th);
                                    runnable = new Runnable() { // from class: com.kuaishou.tk.api.TachikomaApi.5.1.1
                                        @Override // java.lang.Runnable
                                        public void run() throws Throwable {
                                            tKContext.onDestroy();
                                        }
                                    };
                                } catch (Throwable th2) {
                                    ac.runOnUiThread(new Runnable() { // from class: com.kuaishou.tk.api.TachikomaApi.5.1.1
                                        @Override // java.lang.Runnable
                                        public void run() throws Throwable {
                                            tKContext.onDestroy();
                                        }
                                    });
                                    throw th2;
                                }
                            }
                            ac.runOnUiThread(runnable);
                        }
                    });
                } catch (Throwable th) {
                    com.tk.core.exception.a.a((com.tk.core.bridge.b) null, th);
                }
            }
        });
    }

    public void injectProps() {
        if (sProxyPropsInjected) {
            return;
        }
        sProxyPropsInjected = true;
        try {
            String[] strArrSh = d.rZ().sh();
            String[] strArr = new String[strArrSh.length];
            String[] strArr2 = new String[strArrSh.length];
            String[] strArr3 = new String[strArrSh.length];
            for (int i = 0; i < strArrSh.length; i++) {
                String strReplace = strArrSh[i];
                strArr2[i] = strArrSh[i];
                if (strReplace.endsWith("_stub")) {
                    strReplace = strReplace.replace("_stub", "");
                }
                com.tk.core.manager.a.a aVarCN = d.rZ().cN(strReplace);
                if (aVarCN == null) {
                    strArr[i] = null;
                } else {
                    strArr[i] = aVarCN.hG();
                    strArr3[i] = aVarCN.hH();
                }
            }
            V8.injectProps(strArr2, strArr, strArr3);
            V8._injectStyleKeys(StringPool.sSortedHighFrequencyStrings);
        } catch (Throwable th) {
            com.tk.core.exception.a.a((com.tk.core.bridge.b) null, th);
        }
    }

    public void setInitResult(boolean z) {
        a.oP().setInitResult(z);
    }

    public boolean isInitSuccess() {
        return a.oP().isInitSuccess();
    }

    public TKContext newTKJSContext(Context context, boolean z, String str) {
        com.tk.core.bridge.b bVarA;
        if (!isInitSuccess()) {
            return null;
        }
        if (context == null) {
            bVarA = a.oP().a(z, IsolatePool.a(z, str), str);
        } else {
            bVarA = a.oP().a(context, z, IsolatePool.a(z, str), str);
        }
        return new TKContext(bVarA);
    }

    public TKContext newTKJSContext(Context context, boolean z, String str, ViewGroup viewGroup) {
        if (isInitSuccess()) {
            return new TKContext(a.oP().a(context, z, IsolatePool.a(z, str), viewGroup, str));
        }
        return null;
    }

    public void setExceptionHandler(ITKExceptionHandler iTKExceptionHandler) {
        com.tk.core.exception.a.a(new TKExceptionHandlerInnerImpl(iTKExceptionHandler));
    }

    public void setWebImageHandler(com.tk.component.imageview.a.c cVar) {
        g.ng().a(cVar);
    }

    public void setAnimatedImageHandler(com.tk.component.imageview.a.a aVar) {
        g.ng().setAnimatedImageHandler(aVar);
    }

    public s getTKInitParams() {
        return a.oP().getTKInitParams();
    }

    public r getCommonParams() {
        return a.oP().getCommonParams();
    }

    public boolean isReleaseMode() {
        getCommonParams();
        return true;
    }

    public boolean isDebugMode() {
        getCommonParams();
        return false;
    }

    public Application getAppContext() {
        return getCommonParams().hS();
    }

    public void setTKSwitch(com.tk.core.a.q qVar) {
        a.oP().setTKSwitch(qVar);
    }

    public void setExtraExceptionProvider(com.tk.core.a.g gVar) {
        a.oP().a(gVar);
    }

    public com.tk.core.a.g getExtraExceptionProvider() {
        return a.oP().getExtraExceptionProvider();
    }

    public com.tk.core.a.q getTKSwitch() {
        return a.oP().getTKSwitch();
    }

    public void setDownloadDelegate(com.tk.core.a.b bVar) {
        a.oP().setDownloadDelegate(bVar);
    }
}
