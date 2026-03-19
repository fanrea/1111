package com.kwad.library.solder.lib;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.kwad.library.solder.lib.a.f;
import com.kwad.library.solder.lib.ext.PluginError;
import com.kwad.sdk.utils.al;
import com.kwad.sdk.utils.w;
import java.io.File;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
final class f implements com.kwad.library.solder.lib.a.f {
    private f.a bii;
    private final Context mContext;

    f(Context context) {
        this.mContext = context.getApplicationContext();
    }

    @Override // com.kwad.library.solder.lib.a.f
    public final boolean k(com.kwad.library.solder.lib.a.e eVar) {
        new StringBuilder("start update pluginId: ").append(eVar.Pz());
        eVar.cX("Update");
        e(eVar);
        if (eVar.PA()) {
            eVar.Pv().Pl().cP(eVar.Pz());
        }
        if (eVar.isCanceled()) {
            f(eVar);
            return false;
        }
        try {
            eVar.Pv().Pl().Pg();
            if (eVar.PE()) {
                try {
                    File fileH = eVar.Pv().Pl().h(eVar.PF(), false);
                    if (eVar.isCanceled()) {
                        f(eVar);
                        return false;
                    }
                    try {
                        w.a(this.mContext, eVar.PF(), fileH);
                        eVar.cY(fileH.getAbsolutePath());
                        eVar.dQ(3);
                        l(eVar);
                    } catch (Throwable th) {
                        a.e("PluginUpdaterImpl", th);
                        a(eVar, new PluginError.UpdateError(th, 2004));
                    }
                } catch (Throwable th2) {
                    new StringBuilder("Can not get temp file, error = ").append(th2.getLocalizedMessage());
                    a(eVar, new PluginError.UpdateError(th2, 2003));
                    return false;
                }
            } else {
                new StringBuilder("requestPlugin use online plugin resource version:").append(eVar.Pz()).append(", url: ").append(eVar.getDownloadUrl());
                try {
                    File fileH2 = eVar.Pv().Pl().h(eVar.getDownloadUrl(), eVar.Pv().Pi().PR());
                    if (eVar.PG() != null && fileH2.exists() && TextUtils.equals(al.getFileMD5Digest(fileH2), eVar.PG())) {
                        eVar.cY(fileH2.getAbsolutePath());
                        eVar.dQ(4);
                        l(eVar);
                        return true;
                    }
                    try {
                        a(eVar, fileH2);
                        eVar.cY(fileH2.getAbsolutePath());
                        eVar.dQ(4);
                        l(eVar);
                    } catch (PluginError.CancelError unused) {
                        f(eVar);
                        return false;
                    } catch (PluginError.UpdateError e) {
                        a.e("PluginUpdaterImpl", "Download plugin fail, error = " + e.getLocalizedMessage());
                        eVar.m(e);
                        a(eVar, e);
                        return false;
                    }
                } catch (Throwable th3) {
                    a.e("PluginUpdaterImpl", "Can not get temp file, error = " + th3.getLocalizedMessage());
                    a(eVar, new PluginError.UpdateError(th3, 2003));
                    return false;
                }
            }
            return true;
        } catch (Throwable th4) {
            a.e("PluginUpdaterImpl", th4);
            a(eVar, new PluginError.UpdateError(th4, 2005));
            return false;
        }
    }

    @Override // com.kwad.library.solder.lib.a.f
    public final com.kwad.library.solder.lib.a.f a(f.a aVar) {
        this.bii = aVar;
        return this;
    }

    private static void e(com.kwad.library.solder.lib.a.e eVar) {
        new StringBuilder("onPreUpdate state = ").append(eVar.getState());
        eVar.Pv().Pm().o(eVar);
    }

    private static void f(com.kwad.library.solder.lib.a.e eVar) {
        new StringBuilder("onCanceled state = ").append(eVar.getState());
        eVar.dQ(0);
        eVar.Pv().Pm().n(eVar);
    }

    private static void a(com.kwad.library.solder.lib.a.e eVar, PluginError.UpdateError updateError) {
        new StringBuilder("onError state = ").append(eVar.getState());
        eVar.dQ(1);
        eVar.m(updateError);
        eVar.Pv().Pm().c(eVar, updateError);
    }

    private static void l(com.kwad.library.solder.lib.a.e eVar) {
        new StringBuilder("onPostUpdate state = ").append(eVar.getState());
        eVar.Pv().Pm().p(eVar);
    }

    private void a(com.kwad.library.solder.lib.a.e eVar, File file) throws PluginError.UpdateError {
        long jCurrentTimeMillis = System.currentTimeMillis();
        Log.d("PluginUpdaterImpl", "start download pluginId: " + eVar.Pz());
        f.a aVar = this.bii;
        if (aVar == null) {
            throw new PluginError.UpdateError("update ", PluginError.ERROR_UPD_NO_DOWNLOADER);
        }
        aVar.a(eVar, file);
        Log.i("PluginUpdaterImpl", "finish download pluginId: " + eVar.Pz() + " cost:" + (System.currentTimeMillis() - jCurrentTimeMillis));
    }
}
