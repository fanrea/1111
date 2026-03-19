package com.kwad.tachikoma;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.kuaishou.tk.api.CustomEnv;
import com.kuaishou.tk.api.TKContext;
import com.kuaishou.tk.api.TKViewContainer;
import com.kuaishou.tk.api.TachikomaApi;
import com.kuaishou.tk.api.export.sdk.FunctionCallback;
import com.kuaishou.tk.api.export.sdk.IFunction;
import com.kuaishou.tk.api.export.sdk.TkBundleInfo;
import com.kuaishou.tk.api.export.sdk.V8Proxy;
import com.kwad.components.offline.api.OfflineHostProvider;
import com.kwad.components.offline.api.tk.IOfflineApkLoaderHolder;
import com.kwad.components.offline.api.tk.IOfflineCompoTachikomaContext;
import com.kwad.components.offline.api.tk.IOfflineHostActionHandler;
import com.kwad.components.offline.api.tk.IOfflineTKFunction;
import com.kwad.components.offline.api.tk.IOfflineTKRenderListener;
import com.kwad.components.offline.api.tk.IOfflineTKView;
import com.kwad.components.offline.api.tk.jsbridge.IOfflineCompoBridgeHandler;
import com.kwad.components.offline.api.tk.jsbridge.IOfflineCompoTKBridgeHandler;
import com.kwad.tachikoma.a;
import com.tk.core.a.j;
import com.tk.core.a.o;
import com.tk.core.a.p;
import com.tk.core.bridge.c;
import com.tk.core.component.TKBaseNativeModule;
import com.tkruntime.v8.V8Object;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class i implements IOfflineCompoTachikomaContext {
    private static final Map<String, String> Bd = new HashMap();
    private static p Bj = new p() { // from class: com.kwad.tachikoma.i.4
        @Override // com.tk.core.a.p
        public final o hX() {
            return new com.kwad.tachikoma.network.d();
        }
    };
    private String AS;
    private int AT;
    private int AU;
    private TKContext Be;
    private FrameLayout Bf;
    c Bg;
    private IOfflineTKRenderListener Bh;
    private String Bi;
    private j Bk = new j() { // from class: com.kwad.tachikoma.i.5
        @Override // com.tk.core.a.j
        public final void failed(Throwable th) {
        }

        @Override // com.tk.core.a.j
        public final void success() {
            if (i.this.Bh != null) {
                i.this.Bh.onSuccess();
            }
        }
    };
    private Context mContext;

    public i(Context context, boolean z) {
        this.mContext = context;
        if (z) {
            this.Bf = new FrameLayout(context);
            this.Bf.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        }
        hU();
    }

    public final void l(String str) {
        this.AS = str;
        c cVar = this.Bg;
        if (cVar != null) {
            cVar.l(str);
        }
    }

    public final void bN(int i) {
        this.AT = i;
        c cVar = this.Bg;
        if (cVar != null) {
            cVar.bN(i);
        }
    }

    public final void bO(int i) {
        c cVar = this.Bg;
        if (cVar != null) {
            cVar.bO(i);
        }
        this.AU = i;
    }

    @Override // com.kwad.components.offline.api.tk.IOfflineCompoTachikomaContext
    public final void execute(String str, String str2, IOfflineTKRenderListener iOfflineTKRenderListener) {
        if (this.Be != null) {
            this.Bh = iOfflineTKRenderListener;
            this.Be.setBundleInfo(new TkBundleInfo("TK_DEFAULT_SCRIPT_ID", this.AS, "", this.AT, "", 0L, "", String.valueOf(this.AU)), this.AS);
            com.kwad.tachikoma.c.a aVar = (com.kwad.tachikoma.c.a) this.Be.getGlobalNativeObject("KSAdTKBundleService");
            if (aVar != null) {
                aVar.a(this.Be, this.AS);
            }
            String str3 = this.Bi;
            if (str3 != null && n(str3) == null) {
                b(this.Bi, str);
            }
            com.kwad.tachikoma.s.a aVar2 = (com.kwad.tachikoma.s.a) this.Be.getGlobalNativeObject("KSAdSystemUtil");
            if (aVar2 != null) {
                aVar2.a(this.Be, str2);
            }
            TKContext tKContext = this.Be;
            String str4 = this.AS;
            if (str4 == null) {
                str4 = "jsURL";
            }
            tKContext.evaluateScript(str, str4, str2, this.Bk);
        }
    }

    @Override // com.kwad.components.offline.api.tk.IOfflineCompoTachikomaContext
    public final Object execute(String str) {
        TKContext tKContext = this.Be;
        if (tKContext != null) {
            return tKContext.getV8Context().executeScript(str);
        }
        return null;
    }

    @Override // com.kwad.components.offline.api.tk.IOfflineCompoTachikomaContext
    public final IOfflineTKView getTKView(String str, Object... objArr) {
        final TKViewContainer tKViewContainerCreateView;
        TKContext tKContext = this.Be;
        if (tKContext == null || (tKViewContainerCreateView = tKContext.createView(str, objArr)) == null) {
            return null;
        }
        return new IOfflineTKView() { // from class: com.kwad.tachikoma.i.1
            @Override // com.kwad.components.offline.api.tk.IOfflineTKView
            public final View getView() {
                return tKViewContainerCreateView.getView();
            }

            @Override // com.kwad.components.offline.api.tk.IOfflineTKView
            public final void bindActivity(Activity activity) throws IllegalAccessException, NoSuchFieldException, IllegalArgumentException {
                try {
                    Field declaredField = TKViewContainer.class.getDeclaredField("tkView");
                    declaredField.setAccessible(true);
                    Object obj = declaredField.get(tKViewContainerCreateView);
                    if (obj instanceof TKBaseNativeModule) {
                        V8Object v8ObjectPL = ((TKBaseNativeModule) obj).pL();
                        if (V8Proxy.isV8Valid(v8ObjectPL)) {
                            v8ObjectPL.executeFunction("bindPage", com.kwad.tachikoma.a.e.a(activity, i.this.Be.getContext()));
                        }
                    }
                } catch (Exception e) {
                    com.tk.core.exception.a.a(i.this.Be.getContext(), e);
                }
            }

            @Override // com.kwad.components.offline.api.tk.IOfflineTKView
            public final void setData(Object... objArr2) {
                try {
                    tKViewContainerCreateView.setData(objArr2);
                } catch (Throwable th) {
                    com.tk.core.exception.a.a(i.this.Be.getContext(), th);
                }
            }

            @Override // com.kwad.components.offline.api.tk.IOfflineTKView
            public final void render() {
                callJSFunc("render", null, null);
            }

            @Override // com.kwad.components.offline.api.tk.IOfflineTKView
            public final boolean onBackPressed() {
                Object objCallJSFunc = callJSFunc("onBackPressed", null, null);
                if (objCallJSFunc instanceof Boolean) {
                    return ((Boolean) objCallJSFunc).booleanValue();
                }
                return false;
            }

            @Override // com.kwad.components.offline.api.tk.IOfflineTKView
            public final void setLifeStatus(String str2) {
                callJSFunc("setLifeStatus", str2, null);
            }

            @Override // com.kwad.components.offline.api.tk.IOfflineTKView
            public final void setDownloadProgress(String str2) {
                callJSFunc("setDownloadProgress", str2, null);
            }

            @Override // com.kwad.components.offline.api.tk.IOfflineTKView
            public final Object callJSFunc(String str2, String str3, final IOfflineTKFunction iOfflineTKFunction) {
                try {
                    return tKViewContainerCreateView.invokeJSFunctionWithJSONString(str2, str3, new IFunction() { // from class: com.kwad.tachikoma.i.1.1
                        @Override // com.kuaishou.tk.api.export.sdk.IFunction
                        public final void callWithCallback(FunctionCallback functionCallback, Object... objArr2) {
                        }

                        @Override // com.kuaishou.tk.api.export.sdk.IFunction
                        public final void destroy() {
                        }

                        @Override // com.kuaishou.tk.api.export.sdk.IFunction
                        public final Object call(Object... objArr2) {
                            return iOfflineTKFunction.call(objArr2);
                        }
                    });
                } catch (Throwable th) {
                    com.tk.core.exception.a.a(i.this.Be.getContext(), th);
                    return null;
                }
            }
        };
    }

    @Override // com.kwad.components.offline.api.tk.IOfflineCompoTachikomaContext
    public final View getView() {
        return this.Bf;
    }

    @Override // com.kwad.components.offline.api.tk.IOfflineCompoTachikomaContext
    public final void onDestroy() throws Throwable {
        TKContext tKContext = this.Be;
        if (tKContext != null) {
            com.kwad.tachikoma.s.a aVar = (com.kwad.tachikoma.s.a) tKContext.getGlobalNativeObject("KSAdSystemUtil");
            if (aVar != null) {
                aVar.destroy();
            }
            this.Be.onDestroy();
            this.Be = null;
        }
        o(this.Bi);
        a.k(this.Bi);
    }

    @Override // com.kwad.components.offline.api.tk.IOfflineCompoTachikomaContext
    public final void registerJsBridge(IOfflineCompoBridgeHandler iOfflineCompoBridgeHandler) {
        this.Bg.a(iOfflineCompoBridgeHandler);
    }

    @Override // com.kwad.components.offline.api.tk.IOfflineCompoTachikomaContext
    public final void unregisterJsBridge() {
        this.Bg.hO();
    }

    @Override // com.kwad.components.offline.api.tk.IOfflineCompoTachikomaContext
    public final void registerTKBridge(IOfflineCompoTKBridgeHandler iOfflineCompoTKBridgeHandler) {
        this.Bg.a(iOfflineCompoTKBridgeHandler);
    }

    @Override // com.kwad.components.offline.api.tk.IOfflineCompoTachikomaContext
    public final void registerHostActionHandler(IOfflineHostActionHandler iOfflineHostActionHandler) {
        com.kwad.tachikoma.e.e eVar = (com.kwad.tachikoma.e.e) this.Be.getGlobalNativeObject("KSAdNativeContext");
        if (eVar != null) {
            eVar.registerHostActionHandler(iOfflineHostActionHandler);
        }
    }

    @Override // com.kwad.components.offline.api.tk.IOfflineCompoTachikomaContext
    public final void registerApkLoadCreator(IOfflineApkLoaderHolder iOfflineApkLoaderHolder) {
        com.kwad.tachikoma.e.e eVar = (com.kwad.tachikoma.e.e) this.Be.getGlobalNativeObject("KSAdNativeContext");
        if (eVar != null) {
            eVar.a(iOfflineApkLoaderHolder);
        }
    }

    private void hU() {
        if (this.Bf != null) {
            this.Be = TachikomaApi.getInstance().newTKJSContext(this.mContext, false, "TK_DEFAULT_SCRIPT_ID", this.Bf);
        } else {
            this.Be = TachikomaApi.getInstance().newTKJSContext(this.mContext, false, "TK_DEFAULT_SCRIPT_ID");
        }
        this.Bi = UUID.randomUUID().toString();
        this.Be.setSessionId(this.Bi);
        a.a(this.Bi, new a.InterfaceC0637a() { // from class: com.kwad.tachikoma.i.2
            @Override // com.kwad.tachikoma.a.InterfaceC0637a
            public final void a(Throwable th) {
                if (i.this.Bh != null) {
                    i.this.Bh.onFailed(th);
                }
            }
        });
        this.Bg = (c) this.Be.getGlobalNativeObject("KwaiAd");
        this.Bg.a(this.Be);
        TachikomaApi.getInstance().setITKNetworkProvider(Bj);
        if (OfflineHostProvider.getApi().env().isTKCrashCollectEnable() && (this.Be.getV8Context() instanceof com.tk.core.bridge.c)) {
            ((com.tk.core.bridge.c) this.Be.getV8Context()).a(new c.a() { // from class: com.kwad.tachikoma.i.3
                @Override // com.tk.core.bridge.c.a
                public final void hV() {
                    a.c(i.this.AS, i.this.AT);
                }

                @Override // com.tk.core.bridge.c.a
                public final void hW() {
                    a.hL();
                }
            });
        }
    }

    @Override // com.kwad.components.offline.api.tk.IOfflineCompoTachikomaContext
    public final void setCustomEnv(Map<String, Object> map) {
        if (this.Be == null || map == null || map.isEmpty()) {
            return;
        }
        this.Be.setCustomEnv(a(map));
    }

    private static Map<String, CustomEnv> a(Map<String, Object> map) {
        HashMap map2 = new HashMap();
        if (!map.isEmpty()) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                if (entry != null) {
                    String key = entry.getKey();
                    Object value = entry.getValue();
                    if (!TextUtils.isEmpty(key) && value != null) {
                        map2.put(key, new CustomEnv(value, false));
                    }
                }
            }
        }
        return map2;
    }

    @Override // com.kwad.components.offline.api.tk.IOfflineCompoTachikomaContext
    public final int getUniqId() {
        TKContext tKContext = this.Be;
        if (tKContext == null || tKContext.getContext() == null) {
            return 0;
        }
        return this.Be.getContext().hashCode();
    }

    public static String n(String str) {
        return Bd.get(str);
    }

    private static void b(String str, String str2) {
        Bd.put(str, str2);
    }

    private static void o(String str) {
        Bd.remove(str);
    }
}
