package com.kwad.library.solder.lib;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.library.solder.lib.ext.PluginError;
import com.kwad.sdk.utils.al;
import com.kwad.sdk.utils.w;
import java.io.File;
import java.io.IOException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
final class c implements com.kwad.library.solder.lib.a.b {
    private final File bhT;
    private final File bhU;
    private final com.kwad.library.solder.lib.ext.c bhV;
    private final Context mContext;

    c(Context context, com.kwad.library.solder.lib.ext.c cVar) {
        Context applicationContext = context.getApplicationContext();
        this.mContext = applicationContext;
        this.bhV = cVar;
        this.bhT = applicationContext.getDir(cVar.PK(), 0);
        this.bhU = applicationContext.getCacheDir();
    }

    private boolean k(String str, String str2, boolean z) {
        if (!w.im(str)) {
            return false;
        }
        if (TextUtils.isEmpty(str2) || TextUtils.equals(str2, al.getFileMD5Digest(str))) {
            return true;
        }
        new StringBuilder("checkSafety md5 fail fileMd5: ").append(str2).append(", filePath = ").append(str);
        delete(str);
        return false;
    }

    private static void delete(String str) {
        w.delete(str);
    }

    @Override // com.kwad.library.solder.lib.a.b
    public final void cP(String str) {
        File file = new File(cQ(str));
        if (file.exists()) {
            w.ad(file);
        }
    }

    @Override // com.kwad.library.solder.lib.a.b
    public final void J(String str, String str2) {
        File file = new File(K(str, str2));
        if (file.exists()) {
            w.ad(file);
        }
    }

    @Override // com.kwad.library.solder.lib.a.b
    public final void Pg() throws IOException {
        if (this.bhT.getFreeSpace() < 10000000) {
            throw new IOException("No enough capacity.");
        }
    }

    @Override // com.kwad.library.solder.lib.a.b
    public final File h(String str, boolean z) {
        String md5;
        if (str == null || (md5 = com.kwad.library.solder.lib.d.b.getMD5(str)) == null) {
            return null;
        }
        if (z) {
            StringBuilder sb = new StringBuilder();
            sb.append(md5);
            if (this.bhV.PO() != null) {
                sb.append(this.bhV.PO());
            }
            File file = new File(this.bhU, sb.toString());
            if (file.exists() || file.createNewFile()) {
                return file;
            }
            return null;
        }
        return File.createTempFile(md5 + System.currentTimeMillis(), this.bhV.PO(), this.bhU);
    }

    private String Ph() {
        return this.bhT.getAbsolutePath();
    }

    @Override // com.kwad.library.solder.lib.a.b
    public final String cQ(String str) {
        return Ph() + File.separator + str;
    }

    private String K(String str, String str2) {
        return Ph() + File.separator + str + File.separator + str2;
    }

    @Override // com.kwad.library.solder.lib.a.b
    public final String L(String str, String str2) {
        return Ph() + File.separator + str + File.separator + str2 + File.separator + this.bhV.PP();
    }

    private String a(com.kwad.library.solder.lib.a.a aVar) {
        return L(aVar.getId(), aVar.getVersion());
    }

    @Override // com.kwad.library.solder.lib.a.b
    public final boolean a(String str, String str2, String str3) {
        if (this.bhV.PQ()) {
            return false;
        }
        return k(L(str, str2), str3, true);
    }

    @Override // com.kwad.library.solder.lib.a.b
    public final String b(com.kwad.library.solder.lib.a.a aVar) throws PluginError.InstallError {
        String strA = a(aVar);
        if (TextUtils.isEmpty(strA)) {
            throw new PluginError.InstallError("Can not get install path.", 3006);
        }
        new StringBuilder("install pluginId ").append(aVar.getId()).append(", install path:").append(strA);
        File file = new File(strA);
        if (file.exists() && !this.bhV.PQ() && k(file.getAbsolutePath(), aVar.Pu(), true)) {
            return strA;
        }
        String strPt = aVar.Pt();
        new StringBuilder("install pluginId ").append(aVar.getId()).append(", source path:").append(strPt);
        File file2 = new File(strPt);
        if (!file2.exists()) {
            throw new PluginError.InstallError("Plugin file not exist.", 3001);
        }
        new StringBuilder("check plugin md5 pluginId: ").append(aVar.getId());
        if (!k(strPt, aVar.Pu(), true)) {
            new StringBuilder("check plugin md5 fail:").append(aVar.Pu()).append(" ").append(strPt);
            throw new PluginError.InstallError("check plugin md5 fail:" + aVar.Pu() + " " + strPt, 3003);
        }
        if (file2.renameTo(file)) {
            new StringBuilder("install plugin success pluginId: ").append(aVar.getId());
            return strA;
        }
        try {
            Pg();
            try {
                w.f(file2, file);
                w.ad(file2);
                return strA;
            } catch (Throwable th) {
                a.e("PluginInstallerImpl", th);
                throw new PluginError.InstallError(th, 3004);
            }
        } catch (Throwable th2) {
            a.e("PluginInstallerImpl", th2);
            throw new PluginError.InstallError(th2, 3005);
        }
    }
}
