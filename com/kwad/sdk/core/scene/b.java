package com.kwad.sdk.core.scene;

import android.text.TextUtils;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.HashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class b {
    public static volatile b bHc;
    private static Object lock = new Object();
    private URLPackage bHf;
    private HashMap<String, URLPackage> bHd = new HashMap<>();
    private HashMap<String, URLPackage> bHe = new HashMap<>();
    private final URLPackage bHg = new URLPackage("", 0);
    private final EntryPackage bHh = new EntryPackage("", 0);

    public static b abP() {
        if (bHc == null) {
            synchronized (lock) {
                if (bHc == null) {
                    bHc = new b();
                }
            }
        }
        return bHc;
    }

    public final void s(SceneImpl sceneImpl) {
        URLPackage urlPackage = sceneImpl.getUrlPackage();
        if (urlPackage == null) {
            return;
        }
        this.bHe.put(urlPackage.identity, urlPackage);
        if (this.bHf != null) {
            if (!urlPackage.identity.equals(this.bHf.identity)) {
                a(urlPackage.identity, this.bHf);
            }
        } else {
            a(urlPackage.identity, this.bHg);
        }
        this.bHf = urlPackage;
    }

    private void a(String str, URLPackage uRLPackage) {
        if (this.bHd.containsKey(str)) {
            return;
        }
        this.bHd.put(str, uRLPackage);
    }

    public final URLPackage fQ(String str) {
        URLPackage uRLPackage;
        return (TextUtils.isEmpty(str) || (uRLPackage = this.bHd.get(str)) == null || (uRLPackage instanceof EntryPackage)) ? this.bHg : uRLPackage;
    }

    public final void a(String str, String str2, SceneImpl sceneImpl) {
        if (str == null || sceneImpl == null || sceneImpl.getUrlPackage() == null) {
            return;
        }
        EntryPackage entryPackage = new EntryPackage();
        entryPackage.entryPageSource = str;
        entryPackage.entryId = str2;
        a(sceneImpl.getUrlPackage().identity, entryPackage);
    }

    public final void b(String str, SceneImpl sceneImpl) {
        if (str == null || sceneImpl == null || sceneImpl.getUrlPackage() == null) {
            return;
        }
        String str2 = sceneImpl.getUrlPackage().identity;
        if (this.bHd.containsKey(str2)) {
            this.bHd.remove(str2);
        }
        a(str, "", sceneImpl);
    }

    public final void c(String str, SceneImpl sceneImpl) {
        a(str, "", sceneImpl);
    }

    public final EntryPackage fR(String str) {
        if (!TextUtils.isEmpty(str)) {
            URLPackage uRLPackage = this.bHd.get(str);
            int size = this.bHd.size();
            for (int i = 0; uRLPackage != null && !(uRLPackage instanceof EntryPackage) && i < size; i++) {
                String str2 = uRLPackage.identity;
                if (TextUtils.isEmpty(str2)) {
                    break;
                }
                uRLPackage = this.bHd.get(str2);
            }
            if (uRLPackage instanceof EntryPackage) {
                return (EntryPackage) uRLPackage;
            }
        }
        return this.bHh;
    }

    public final void fS(String str) {
        URLPackage uRLPackage;
        this.bHe.remove(str);
        if (this.bHe.size() == 0 && (uRLPackage = this.bHf) != null && uRLPackage.identity.equals(str)) {
            this.bHf = null;
        }
    }
}
