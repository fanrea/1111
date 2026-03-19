package com.kwad.tachikoma.c;

import com.kuaishou.tk.api.TKContext;
import com.kuaishou.tk.export.NativeModuleInitParams;
import com.kwad.components.offline.api.OfflineHostProvider;
import com.kwad.components.offline.api.core.api.IBundleLoadListener;
import com.kwad.tachikoma.t.g;
import com.tk.core.component.TKBaseNativeModule;
import com.tkruntime.v8.V8Function;
import com.tkruntime.v8.V8Object;
import com.tkruntime.v8.V8Value;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class a extends TKBaseNativeModule {
    private TKContext BH;
    private String bundleName;

    public a(NativeModuleInitParams nativeModuleInitParams) {
        super(nativeModuleInitParams);
    }

    public final void a(TKContext tKContext, String str) {
        this.BH = tKContext;
        this.bundleName = str;
    }

    public final void b(String str, V8Function v8Function) {
        final g gVar = new g(v8Function, this.BH.getContext());
        OfflineHostProvider.getApi().bundleService().loadBundle(this.BH.getContext().getContext(), str, new IBundleLoadListener() { // from class: com.kwad.tachikoma.c.a.1
            @Override // com.kwad.components.offline.api.core.api.IBundleLoadListener
            public final void onSuccess() {
                g gVar2 = gVar;
                if (gVar2 != null) {
                    gVar2.call(null, Boolean.TRUE, null);
                    gVar.destroy();
                }
            }

            @Override // com.kwad.components.offline.api.core.api.IBundleLoadListener
            public final void onFailed(String str2) {
                g gVar2 = gVar;
                if (gVar2 != null) {
                    gVar2.call(null, Boolean.FALSE, null);
                    gVar.destroy();
                }
            }
        });
    }

    public final void c(String str, V8Function v8Function) {
        final g gVar = new g(v8Function, this.BH.getContext());
        OfflineHostProvider.getApi().bundleService().loadBundleWithString(this.BH.getContext().getContext(), str, new IBundleLoadListener() { // from class: com.kwad.tachikoma.c.a.2
            @Override // com.kwad.components.offline.api.core.api.IBundleLoadListener
            public final void onSuccess() {
                g gVar2 = gVar;
                if (gVar2 != null) {
                    gVar2.call(null, Boolean.TRUE, null);
                    gVar.destroy();
                }
            }

            @Override // com.kwad.components.offline.api.core.api.IBundleLoadListener
            public final void onFailed(String str2) {
                g gVar2 = gVar;
                if (gVar2 != null) {
                    gVar2.call(null, Boolean.FALSE, null);
                    gVar.destroy();
                }
            }
        });
    }

    public static void unloadBundle(String str) {
        OfflineHostProvider.getApi().bundleService().unloadBundle(str);
        b.id().unloadBundle(str);
    }

    public final void a(String str, V8Object v8Object) {
        b.id().a(this.bundleName, str, v8Object);
    }

    public final void d(String str, V8Function v8Function) {
        b.id().a(this.bundleName, str, v8Function);
    }

    public final V8Value a(String str, String str2, Object obj) {
        return b.id().a(this.BH, str, str2, obj);
    }

    public static void f(V8Object v8Object) {
        b.id();
    }
}
