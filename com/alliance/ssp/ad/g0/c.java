package com.alliance.ssp.ad.g0;

import android.app.KeyguardManager;
import android.content.Context;
import com.alliance.ssp.ad.oaidgithub.gzuliyujiang.oaid.YTOAIDException;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;

/* compiled from: CooseaImpl.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class c implements com.alliance.ssp.ad.f0.c {
    public final Context a;
    public final KeyguardManager b;

    public c(Context context) {
        this.a = context;
        this.b = (KeyguardManager) context.getSystemService("keyguard");
    }

    @Override // com.alliance.ssp.ad.f0.c
    public boolean a() {
        KeyguardManager keyguardManager;
        if (this.a == null || (keyguardManager = this.b) == null) {
            return false;
        }
        try {
            return ((Boolean) Objects.requireNonNull(keyguardManager.getClass().getDeclaredMethod("isSupported", new Class[0]).invoke(this.b, new Object[0]))).booleanValue();
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.alliance.ssp.ad.f0.c
    public void a(com.alliance.ssp.ad.f0.b bVar) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (this.a == null || bVar == null) {
            return;
        }
        KeyguardManager keyguardManager = this.b;
        if (keyguardManager == null) {
            bVar.a(new YTOAIDException("KeyguardManager not found"));
            return;
        }
        try {
            Object objInvoke = keyguardManager.getClass().getDeclaredMethod("obtainOaid", new Class[0]).invoke(this.b, new Object[0]);
            if (objInvoke != null) {
                bVar.a(objInvoke.toString());
                return;
            }
            throw new YTOAIDException("OAID obtain failed");
        } catch (Exception unused) {
        }
    }
}
