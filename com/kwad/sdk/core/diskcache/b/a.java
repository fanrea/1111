package com.kwad.sdk.core.diskcache.b;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.core.network.a.a;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.f;
import com.kwad.sdk.utils.ax;
import com.kwad.sdk.utils.bf;
import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class a {
    private com.kwad.sdk.core.diskcache.a.a bBs;

    /* renamed from: com.kwad.sdk.core.diskcache.b.a$a, reason: collision with other inner class name */
    static final class C0581a {
        static final a bBt = new a(0);
    }

    /* synthetic */ a(byte b) {
        this();
    }

    private a() {
    }

    private synchronized void init(Context context) {
        if (this.bBs != null || context == null) {
            return;
        }
        try {
            this.bBs = com.kwad.sdk.core.diskcache.a.a.a(bf.ew(context), 1, 1, 209715200L);
        } catch (Throwable unused) {
        }
    }

    public static a ZH() {
        return C0581a.bBt;
    }

    public final void eV(String str) {
        if (ZI() || TextUtils.isEmpty(str)) {
            return;
        }
        b.a(this.bBs, str, c.eX(str));
    }

    public final boolean a(String str, a.C0589a c0589a) throws NoSuchAlgorithmException {
        File fileEW;
        if (!ZI() && !TextUtils.isEmpty(str)) {
            String strEX = c.eX(str);
            if (b.a(this.bBs, str, strEX, c0589a) && (fileEW = eW(strEX)) != null && fileEW.exists()) {
                return true;
            }
        }
        return false;
    }

    public final boolean b(String str, String str2, a.C0589a c0589a) throws NoSuchAlgorithmException {
        File fileEW;
        if (!ZI() && !TextUtils.isEmpty(str)) {
            String strEX = c.eX(str2);
            if (b.a(this.bBs, str, strEX, c0589a) && (fileEW = eW(strEX)) != null && fileEW.exists()) {
                return true;
            }
        }
        return false;
    }

    public final File dw(String str) {
        if (ZI() || TextUtils.isEmpty(str)) {
            return null;
        }
        return eW(c.eX(str));
    }

    private File eW(String str) {
        if (ZI() || TextUtils.isEmpty(str)) {
            return null;
        }
        return b.a(this.bBs, str);
    }

    public final boolean remove(String str) {
        if (ZI()) {
            return false;
        }
        try {
            ax.aD(str, "cacheKey is not allowed empty");
            return this.bBs.remove(c.eX(str));
        } catch (IOException unused) {
            return false;
        }
    }

    public final void delete() {
        if (ZI()) {
            return;
        }
        try {
            this.bBs.delete();
        } catch (IOException unused) {
        }
    }

    private boolean ZI() {
        init(((f) ServiceProvider.get(f.class)).getContext());
        return this.bBs == null;
    }
}
