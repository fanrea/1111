package com.kwad.tachikoma.network;

import com.kuaishou.tk.export.NativeModuleInitParams;
import com.kwad.components.offline.api.OfflineHostProvider;
import com.kwad.components.offline.api.tk.IOfflineApkLoadStatusListener;
import com.kwad.components.offline.api.tk.IOfflineApkLoader;
import com.kwad.tachikoma.t.g;
import com.tk.core.component.TKBaseNativeModule;
import com.tkruntime.v8.V8Function;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class a extends TKBaseNativeModule {
    private g BE;
    private IOfflineApkLoader DR;
    private int DS;
    private float DT;
    private long DU;
    private long DV;
    private float DW;

    public a(NativeModuleInitParams nativeModuleInitParams) {
        super(nativeModuleInitParams);
        if (nativeModuleInitParams.args.length > 0) {
            try {
                com.kwad.tachikoma.e.e eVar = (com.kwad.tachikoma.e.e) ((com.tk.core.bridge.b) nativeModuleInitParams.tkContext).getGlobalNativeObject("KSAdNativeContext");
                Object obj = nativeModuleInitParams.args[0];
                if (obj instanceof Number) {
                    this.DR = eVar.bW(((Number) nativeModuleInitParams.args[0]).intValue());
                } else if (obj instanceof String) {
                    this.DR = eVar.p((String) nativeModuleInitParams.args[0]);
                }
                iy();
            } catch (Throwable th) {
                OfflineHostProvider.getApi().log().printStackTrace(th);
            }
        }
    }

    private void iy() {
        IOfflineApkLoader iOfflineApkLoader = this.DR;
        if (iOfflineApkLoader != null) {
            iOfflineApkLoader.addLoadStatusListener(new IOfflineApkLoadStatusListener() { // from class: com.kwad.tachikoma.network.a.1
                @Override // com.kwad.components.offline.api.tk.IOfflineApkLoadStatusListener
                public final void onIdle() {
                    a.this.c(1, 0.0f);
                }

                @Override // com.kwad.components.offline.api.tk.IOfflineApkLoadStatusListener
                public final void onDownloadStarted() {
                    a aVar = a.this;
                    aVar.c(2, aVar.DT);
                }

                @Override // com.kwad.components.offline.api.tk.IOfflineApkLoadStatusListener
                public final void onProgressUpdate(int i, long j, long j2) {
                    a.this.DU = j;
                    a.this.DV = j2;
                    if (j > 0) {
                        a.this.DW = (j2 * 1.0f) / j;
                    } else {
                        a.this.DW = 0.0f;
                    }
                    a.this.c(2, (i * 1.0f) / 100.0f);
                }

                @Override // com.kwad.components.offline.api.tk.IOfflineApkLoadStatusListener
                public final void onDownloadFinished() {
                    a.this.c(5, 1.0f);
                }

                @Override // com.kwad.components.offline.api.tk.IOfflineApkLoadStatusListener
                public final void onDownloadFailed() {
                    a.this.c(4, 0.0f);
                }

                @Override // com.kwad.components.offline.api.tk.IOfflineApkLoadStatusListener
                public final void onInstalled() {
                    a.this.c(6, 1.0f);
                }

                @Override // com.kwad.components.offline.api.tk.IOfflineApkLoadStatusListener
                public final void onPaused(int i, long j, long j2) {
                    a.this.DU = j;
                    a.this.DV = j2;
                    if (j > 0) {
                        a.this.DW = (j2 * 1.0f) / j;
                    } else {
                        a.this.DW = 0.0f;
                    }
                    a.this.c(3, (i * 1.0f) / 100.0f);
                }
            });
        }
    }

    final void c(int i, float f) {
        this.DS = i;
        this.DT = f;
        g gVar = this.BE;
        if (gVar != null) {
            gVar.call(null, Integer.valueOf(this.DS), Float.valueOf(this.DT));
        }
    }

    final void t(V8Function v8Function) {
        this.BE = new g(v8Function, pO());
    }

    final int iz() {
        return this.DS;
    }

    final float getProgress() {
        return this.DT;
    }

    final boolean iA() {
        IOfflineApkLoader iOfflineApkLoader = this.DR;
        if (iOfflineApkLoader == null) {
            return false;
        }
        iOfflineApkLoader.startDownload();
        return true;
    }

    final boolean iB() {
        IOfflineApkLoader iOfflineApkLoader = this.DR;
        if (iOfflineApkLoader == null) {
            return false;
        }
        iOfflineApkLoader.pauseDownload();
        return true;
    }

    final boolean iC() {
        IOfflineApkLoader iOfflineApkLoader = this.DR;
        if (iOfflineApkLoader == null) {
            return false;
        }
        iOfflineApkLoader.resumeDownload();
        return true;
    }

    final boolean iD() {
        IOfflineApkLoader iOfflineApkLoader = this.DR;
        if (iOfflineApkLoader == null) {
            return false;
        }
        iOfflineApkLoader.stopDownload();
        return true;
    }

    final boolean iE() {
        IOfflineApkLoader iOfflineApkLoader = this.DR;
        if (iOfflineApkLoader == null) {
            return false;
        }
        iOfflineApkLoader.cancelDownload();
        return true;
    }

    final boolean iF() {
        IOfflineApkLoader iOfflineApkLoader = this.DR;
        if (iOfflineApkLoader == null) {
            return false;
        }
        iOfflineApkLoader.installApp();
        return true;
    }

    final boolean iG() {
        IOfflineApkLoader iOfflineApkLoader = this.DR;
        if (iOfflineApkLoader == null) {
            return false;
        }
        iOfflineApkLoader.uninstallApp();
        return true;
    }

    final boolean iH() {
        IOfflineApkLoader iOfflineApkLoader = this.DR;
        if (iOfflineApkLoader == null) {
            return false;
        }
        iOfflineApkLoader.openApp();
        return true;
    }

    final boolean iI() {
        IOfflineApkLoader iOfflineApkLoader = this.DR;
        if (iOfflineApkLoader == null) {
            return false;
        }
        iOfflineApkLoader.clearFileCache();
        return true;
    }

    final long getTotalBytes() {
        return this.DU;
    }

    final long iJ() {
        return this.DV;
    }

    final float iK() {
        return this.DW;
    }

    @Override // com.tk.core.component.TKBaseNativeModule
    public final void a(TKBaseNativeModule.DestroyReason destroyReason, boolean z) {
        super.a(destroyReason, z);
        g gVar = this.BE;
        if (gVar != null) {
            gVar.destroy();
        }
    }
}
