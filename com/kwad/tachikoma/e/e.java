package com.kwad.tachikoma.e;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.kuaishou.tk.export.NativeModuleInitParams;
import com.kwad.components.offline.api.tk.IOfflineApkLoader;
import com.kwad.components.offline.api.tk.IOfflineApkLoaderHolder;
import com.kwad.components.offline.api.tk.IOfflineHostActionHandler;
import com.kwad.components.offline.api.tk.IOfflineTKCallHandler;
import com.kwad.components.offline.api.tk.IOfflineTKDialog;
import com.kwad.components.offline.api.tk.IOfflineTKNativeIntent;
import com.kwad.sdk.utils.KsLocalBroadcastManager;
import com.kwad.tachikoma.t.g;
import com.tk.core.component.TKBaseNativeModule;
import com.tkruntime.v8.V8Function;
import com.tkruntime.v8.V8Object;
import com.tkruntime.v8.V8ObjectProxy;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class e extends TKBaseNativeModule {
    private IOfflineHostActionHandler BS;
    private IOfflineApkLoaderHolder BT;
    private final AtomicInteger BU;
    private final ConcurrentMap<Integer, BroadcastReceiver> BV;
    private final ConcurrentMap<Integer, BroadcastReceiver> BW;
    private final ConcurrentMap<Integer, g> BX;

    public e(NativeModuleInitParams nativeModuleInitParams) {
        super(nativeModuleInitParams);
        this.BU = new AtomicInteger(0);
        this.BV = new ConcurrentHashMap();
        this.BW = new ConcurrentHashMap();
        this.BX = new ConcurrentHashMap();
    }

    public final void registerHostActionHandler(IOfflineHostActionHandler iOfflineHostActionHandler) {
        this.BS = iOfflineHostActionHandler;
    }

    public final void a(IOfflineApkLoaderHolder iOfflineApkLoaderHolder) {
        this.BT = iOfflineApkLoaderHolder;
    }

    public final IOfflineApkLoader bW(int i) {
        return this.BT.getApkLoader(i);
    }

    public final IOfflineApkLoader p(String str) {
        return this.BT.getApkLoader(str);
    }

    public final void a(com.kwad.tachikoma.f.a aVar) {
        this.BS.showDialog(c(aVar));
    }

    public final void b(com.kwad.tachikoma.f.a aVar) {
        this.BS.dismissDialog(c(aVar));
    }

    public final int a(V8Object v8Object, V8Function v8Function, boolean z) {
        final int iIncrementAndGet = this.BU.incrementAndGet();
        IntentFilter intentFilterIT = ((com.kwad.tachikoma.o.b) getNativeModule(v8Object)).iT();
        BroadcastReceiver broadcastReceiver = new BroadcastReceiver() { // from class: com.kwad.tachikoma.e.e.1
            @Override // android.content.BroadcastReceiver
            public final void onReceive(Context context, Intent intent) {
                g gVar = (g) e.this.BX.get(Integer.valueOf(iIncrementAndGet));
                if (gVar == null || gVar.getRuntime() == null) {
                    return;
                }
                V8ObjectProxy v8ObjectProxy = new V8ObjectProxy(gVar.getRuntime(), "KSAdNativeIntent");
                com.kwad.tachikoma.o.a aVar = new com.kwad.tachikoma.o.a(new NativeModuleInitParams.Builder(e.this.getTKContext(), v8ObjectProxy).setArgs(new Object[]{Boolean.FALSE}).build());
                aVar.b(intent);
                v8ObjectProxy.setNativeObject(aVar);
                gVar.call(null, v8ObjectProxy);
            }
        };
        this.BX.put(Integer.valueOf(iIncrementAndGet), new g(v8Function, pO()));
        if (z) {
            KsLocalBroadcastManager.getInstance(getContext()).registerReceiver(broadcastReceiver, intentFilterIT);
            this.BW.put(Integer.valueOf(iIncrementAndGet), broadcastReceiver);
        } else {
            getContext().registerReceiver(broadcastReceiver, intentFilterIT);
            this.BV.put(Integer.valueOf(iIncrementAndGet), broadcastReceiver);
        }
        return iIncrementAndGet;
    }

    public final void bX(int i) {
        if (this.BW.get(Integer.valueOf(i)) != null) {
            KsLocalBroadcastManager.getInstance(getContext()).unregisterReceiver(this.BW.get(Integer.valueOf(i)));
            this.BW.remove(Integer.valueOf(i));
        } else {
            getContext().unregisterReceiver(this.BV.get(Integer.valueOf(i)));
            this.BV.remove(Integer.valueOf(i));
        }
        g gVar = this.BX.get(Integer.valueOf(i));
        if (gVar != null) {
            gVar.destroy();
        }
        this.BX.remove(Integer.valueOf(i));
    }

    public final void a(V8Object v8Object, boolean z) {
        com.kwad.tachikoma.o.a aVar = (com.kwad.tachikoma.o.a) getNativeModule(v8Object);
        if (z) {
            KsLocalBroadcastManager.getInstance(getContext()).sendBroadcast(aVar.getIntent());
        } else {
            getContext().sendBroadcast(aVar.getIntent());
        }
    }

    public final void h(V8Object v8Object) {
        this.BS.startActivity(a((com.kwad.tachikoma.o.a) getNativeModule(v8Object)));
    }

    /* renamed from: if, reason: not valid java name */
    public final V8Object m463if() {
        if (getJsObj() == null) {
            return null;
        }
        V8ObjectProxy v8ObjectProxy = new V8ObjectProxy(getJsObj().getRuntime(), "KSAdTKPackageManager");
        v8ObjectProxy.setNativeObject(new com.kwad.tachikoma.n.a(new NativeModuleInitParams.Builder(getTKContext(), v8ObjectProxy).build()));
        return v8ObjectProxy;
    }

    private IOfflineTKNativeIntent a(final com.kwad.tachikoma.o.a aVar) {
        return new IOfflineTKNativeIntent() { // from class: com.kwad.tachikoma.e.e.2
            @Override // com.kwad.components.offline.api.tk.IOfflineTKNativeIntent
            public final Intent getIntent() {
                return aVar.getIntent();
            }

            @Override // com.kwad.components.offline.api.tk.IOfflineTKNativeIntent
            public final void callbackPageStatus(boolean z, String str) {
                aVar.callbackPageStatus(z, str);
            }

            @Override // com.kwad.components.offline.api.tk.IOfflineTKNativeIntent
            public final void callbackDismiss() {
                aVar.callbackDismiss();
            }

            @Override // com.kwad.components.offline.api.tk.IOfflineTKNativeIntent
            public final void registerJSCallHandler(final IOfflineTKCallHandler iOfflineTKCallHandler) {
                aVar.a(new com.kwad.tachikoma.l.c() { // from class: com.kwad.tachikoma.e.e.2.1
                    @Override // com.kwad.tachikoma.l.c
                    public final void callJS(String str) {
                        iOfflineTKCallHandler.callJS(str);
                    }
                });
            }

            @Override // com.kwad.components.offline.api.tk.IOfflineTKNativeIntent
            public final void callTKBridge(String str) {
                aVar.callTKBridge(str);
            }

            @Override // com.kwad.components.offline.api.tk.IOfflineTKNativeIntent
            public final String getTemplateString() {
                return aVar.getTemplateString();
            }

            @Override // com.kwad.components.offline.api.tk.IOfflineTKNativeIntent
            public final String getViewKey() {
                return aVar.getViewKey();
            }

            @Override // com.kwad.components.offline.api.tk.IOfflineTKNativeIntent
            public final String getClassName() {
                return aVar.getClassName();
            }

            @Override // com.kwad.components.offline.api.tk.IOfflineTKNativeIntent
            public final String getUrl() {
                return aVar.getUrl();
            }
        };
    }

    private IOfflineTKDialog c(final com.kwad.tachikoma.f.a aVar) {
        return new IOfflineTKDialog() { // from class: com.kwad.tachikoma.e.e.3
            @Override // com.kwad.components.offline.api.tk.IOfflineTKDialog
            public final int getDialogId() {
                return aVar.getDialogId();
            }

            @Override // com.kwad.components.offline.api.tk.IOfflineTKDialog
            public final String getStyleTemplate() {
                return aVar.getTemplateString();
            }

            @Override // com.kwad.components.offline.api.tk.IOfflineTKDialog
            public final String getViewKey() {
                return aVar.getViewKey();
            }

            @Override // com.kwad.components.offline.api.tk.IOfflineTKDialog
            public final boolean isHideNavigationBar() {
                return aVar.isHideNavigationBar();
            }

            @Override // com.kwad.components.offline.api.tk.IOfflineTKDialog
            public final void registerJSCallHandler(final IOfflineTKCallHandler iOfflineTKCallHandler) {
                aVar.a(new com.kwad.tachikoma.l.c() { // from class: com.kwad.tachikoma.e.e.3.1
                    @Override // com.kwad.tachikoma.l.c
                    public final void callJS(String str) {
                        iOfflineTKCallHandler.callJS(str);
                    }
                });
            }

            @Override // com.kwad.components.offline.api.tk.IOfflineTKDialog
            public final void callTKBridge(String str) {
                aVar.callTKBridge(str);
            }

            @Override // com.kwad.components.offline.api.tk.IOfflineTKDialog
            public final void callbackPageStatus(boolean z, String str) {
                aVar.callbackPageStatus(z, str);
            }

            @Override // com.kwad.components.offline.api.tk.IOfflineTKDialog
            public final void callbackDialogDismiss() {
                aVar.callbackDialogDismiss();
            }
        };
    }

    public final V8Object ig() {
        if (getJsObj() == null) {
            return null;
        }
        V8ObjectProxy v8ObjectProxy = new V8ObjectProxy(getJsObj().getRuntime(), "KSAdContentResolver");
        a aVar = new a(new NativeModuleInitParams.Builder(getTKContext(), v8ObjectProxy).build());
        aVar.a(getTKContext().getContext().getContentResolver());
        v8ObjectProxy.setNativeObject(aVar);
        return v8ObjectProxy;
    }

    @Override // com.tk.core.component.TKBaseNativeModule
    public final void ih() {
        super.ih();
        Iterator<Integer> it = this.BX.keySet().iterator();
        while (it.hasNext()) {
            int iIntValue = it.next().intValue();
            g gVar = this.BX.get(Integer.valueOf(iIntValue));
            if (gVar != null) {
                gVar.destroy();
            }
            BroadcastReceiver broadcastReceiver = this.BW.get(Integer.valueOf(iIntValue));
            if (broadcastReceiver != null) {
                KsLocalBroadcastManager.getInstance(getContext()).unregisterReceiver(broadcastReceiver);
            } else {
                BroadcastReceiver broadcastReceiver2 = this.BV.get(Integer.valueOf(iIntValue));
                if (broadcastReceiver2 != null) {
                    getContext().unregisterReceiver(broadcastReceiver2);
                }
            }
        }
        this.BX.clear();
        this.BV.clear();
        this.BW.clear();
    }
}
