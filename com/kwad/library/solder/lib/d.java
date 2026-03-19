package com.kwad.library.solder.lib;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.library.solder.lib.ext.PluginError;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.w;
import java.io.File;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
final class d implements com.kwad.library.solder.lib.a.c {
    private final ConcurrentHashMap<String, com.kwad.library.solder.lib.a.a> bhW = new ConcurrentHashMap<>();
    private final Context mContext;

    d(Context context) {
        this.mContext = context.getApplicationContext();
    }

    @Override // com.kwad.library.solder.lib.a.c
    public final void g(com.kwad.library.solder.lib.a.e eVar) {
        new StringBuilder("start load pluginId: ").append(eVar.Pz());
        eVar.cX("Load");
        c(eVar);
        if (eVar.isCanceled()) {
            f(eVar);
            return;
        }
        com.kwad.library.solder.lib.a.a aVar = this.bhW.get(eVar.Pz());
        if (aVar != null && aVar.isLoaded()) {
            eVar.c(aVar);
            new StringBuilder("load plugin success pluginId: ").append(eVar.Pz()).append(", path = ").append(aVar.Pt());
            a(eVar, aVar);
            return;
        }
        com.kwad.library.solder.lib.c.b bVarPH = eVar.PH();
        if (bVarPH == null) {
            b(eVar, new PluginError.LoadError("not pluginInfo", 2006));
            return;
        }
        List<com.kwad.library.solder.lib.c.a> listPI = eVar.PI();
        com.kwad.library.solder.lib.c.a aVar2 = null;
        if (listPI != null && !listPI.isEmpty()) {
            for (com.kwad.library.solder.lib.c.a aVar3 : listPI) {
                if (eVar.getVersion().equals(aVar3.version)) {
                    aVar2 = aVar3;
                } else {
                    eVar.Pv().Pl().J(eVar.Pz(), aVar3.version);
                }
            }
        }
        if (aVar2 == null) {
            if (!ao.isWifiConnected(this.mContext) && (bVarPH.bjh || (bVarPH.bji && eVar.PB() > 0))) {
                b(eVar, new PluginError.NotWifiDownloadError("It can be downloaded only on WiFi", PluginError.ERROR_UPD_NOT_WIFI_DOWNLOAD));
                return;
            }
            try {
                if (!eVar.Pv().Pk().k(eVar)) {
                    return;
                }
            } catch (Throwable th) {
                b(eVar, new PluginError.UpdateError(th, 2006));
                return;
            }
        } else {
            String strL = eVar.Pv().Pl().L(aVar2.bjd, aVar2.version);
            new StringBuilder("-------本地已存在--------").append(strL);
            eVar.cY(strL);
            eVar.cZ(strL);
            eVar.dQ(2);
            eVar.cU(aVar2.version);
        }
        if (eVar.getState() == 2 || eVar.getState() == 3 || eVar.getState() == 4) {
            String strPC = eVar.PC();
            new StringBuilder("-------更新成功或者获取到本地成功------------pluginId: ").append(eVar.Pz()).append(", path: ").append(strPC);
            if (TextUtils.isEmpty(strPC)) {
                b(eVar, new PluginError.LoadError("path not found", PluginError.ERROR_UPD_FILE_NOT_FOUND));
                return;
            }
            if (eVar.isCanceled()) {
                f(eVar);
                return;
            }
            try {
                com.kwad.library.solder.lib.a.a aVarH = h(eVar);
                eVar.c(aVarH);
                new StringBuilder("load plugin success pluginId: ").append(eVar.Pz()).append(", path: ").append(strPC);
                a(eVar, aVarH);
                return;
            } catch (PluginError.InstallError e) {
                e = e;
                b(eVar, e);
                return;
            } catch (PluginError.LoadError e2) {
                e = e2;
                b(eVar, e);
                return;
            } catch (Throwable th2) {
                a.e("PluginLoaderImpl", "load plugin failed, path = " + strPC, th2);
                b(eVar, new PluginError.InstallError("load or install plugin failed:" + th2.getMessage(), 4004));
                return;
            }
        }
        b(eVar, new PluginError.InstallError("state exception", 2002));
    }

    private com.kwad.library.solder.lib.a.a h(com.kwad.library.solder.lib.a.e eVar) throws PluginError.LoadError {
        b(eVar);
        com.kwad.library.solder.lib.a.a aVarA = eVar.da(eVar.PC()).a(eVar.PH());
        String strPt = aVarA.Pt();
        File file = new File(strPt);
        new StringBuilder("install pluginId: ").append(eVar.Pz()).append(", path: ").append(strPt);
        com.kwad.library.solder.lib.a.d dVarPv = eVar.Pv();
        if (!file.exists()) {
            throw new PluginError.LoadError("Apk file not exist.", 3001);
        }
        String strPz = eVar.Pz();
        String version = eVar.getVersion();
        com.kwad.library.solder.lib.a.a aVarCR = cR(strPz);
        if (aVarCR != null) {
            new StringBuilder("the current plugin has been loaded, id = ").append(version);
            a(eVar);
            return aVarCR;
        }
        aVarA.cV(strPz);
        aVarA.cU(version);
        if (dVarPv.Pl().a(strPz, version, eVar.PG())) {
            String strL = dVarPv.Pl().L(strPz, version);
            if (w.il(strL)) {
                new StringBuilder("The current version has been installed before pluginId: ").append(strPz);
                aVarA.cW(strL);
                aVarA.t(this.mContext, strL);
                a(strPz, aVarA);
                a(eVar);
                return aVarA;
            }
        }
        new StringBuilder("plugin is not install start install pluginId: ").append(strPz);
        String strB = dVarPv.Pl().b(aVarA);
        aVarA.cW(strB);
        aVarA.t(this.mContext, strB);
        a(strPz, aVarA);
        if (strPt.endsWith(dVarPv.Pi().PO())) {
            w.delete(strPt);
        }
        a(eVar);
        return aVarA;
    }

    @Override // com.kwad.library.solder.lib.a.c
    public final synchronized com.kwad.library.solder.lib.a.a cR(String str) {
        com.kwad.library.solder.lib.a.a aVar = this.bhW.get(str);
        if (aVar != null) {
            if (!aVar.isLoaded()) {
                return null;
            }
        }
        return aVar;
    }

    private synchronized void a(String str, com.kwad.library.solder.lib.a.a aVar) {
        if (aVar != null) {
            if (aVar.isLoaded()) {
                this.bhW.put(str, aVar);
            }
        }
    }

    private static void c(com.kwad.library.solder.lib.a.e eVar) {
        new StringBuilder("onPreLoad state = ").append(eVar.getState());
        eVar.Pv().Pm().q(eVar);
    }

    private static void b(com.kwad.library.solder.lib.a.e eVar) {
        new StringBuilder("onInstall state = ").append(eVar.getState());
        eVar.dQ(7);
        eVar.Pv().Pm().r(eVar);
    }

    private static void a(com.kwad.library.solder.lib.a.e eVar) {
        new StringBuilder("onInstall state = ").append(eVar.getState());
        eVar.dQ(8);
        eVar.Pv().Pm().a(eVar);
    }

    private static void b(com.kwad.library.solder.lib.a.e eVar, PluginError pluginError) {
        new StringBuilder("onError state = ").append(eVar.getState());
        eVar.dQ(6);
        eVar.m(pluginError);
        eVar.Pv().Pm().c(eVar, pluginError);
    }

    private static void f(com.kwad.library.solder.lib.a.e eVar) {
        new StringBuilder("onCanceled state = ").append(eVar.getState());
        eVar.dQ(0);
        eVar.Pv().Pm().n(eVar);
    }

    private static void a(com.kwad.library.solder.lib.a.e eVar, com.kwad.library.solder.lib.a.a aVar) {
        new StringBuilder("onLoadSuccess state = ").append(eVar.getState());
        eVar.dQ(5);
        eVar.Pv().Pm().b(eVar, aVar);
    }
}
