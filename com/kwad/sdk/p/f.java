package com.kwad.sdk.p;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.kwad.sdk.api.core.IKsAdSDK;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.u;
import com.kwad.sdk.utils.z;
import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class f {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private boolean cqA;
    private ClassLoader cqB;
    private boolean cqC;
    private Resources cqx;
    private Resources cqy;
    private i cqz;
    private final AtomicBoolean mHasInit;

    /* synthetic */ f(byte b) {
        this();
    }

    private f() {
        this.mHasInit = new AtomicBoolean(false);
        this.cqC = com.kwad.framework.a.a.bcJ.booleanValue();
    }

    static class a {
        private static final f cqD = new f(0);
    }

    public static f ard() {
        return a.cqD;
    }

    public final void init() {
        if (this.mHasInit.get()) {
            return;
        }
        try {
            if (((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).TQ()) {
                if (Us() && arg()) {
                    this.cqB = getClass().getClassLoader();
                    j.dQ(Ut());
                    com.kwad.sdk.core.d.c.d("KSDY/KSPlugin", toString());
                    this.cqA = true;
                } else {
                    this.cqA = false;
                }
            } else if (this.cqC) {
                j.dQ(true);
                arf();
                this.cqB = getClass().getClassLoader();
                this.cqA = true;
            }
        } catch (Throwable th) {
            ((com.kwad.sdk.service.a.e) ServiceProvider.get(com.kwad.sdk.service.a.e.class)).gatherException(th);
        }
        this.mHasInit.set(true);
    }

    public final boolean are() {
        return this.cqC;
    }

    private boolean Us() {
        boolean zTQ = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).TQ();
        if (!this.cqC || zTQ) {
            return ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).Us();
        }
        return false;
    }

    private static boolean Ut() {
        return ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).Ut();
    }

    public final boolean apB() {
        return this.mHasInit.get();
    }

    public final ClassLoader getClassLoader() {
        return this.cqB;
    }

    public final Resources getResources() {
        boolean zTQ = ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).TQ();
        com.kwad.sdk.core.d.c.d("KSDY/KSPlugin", "getResources mIsInnerDexMode: " + this.cqC + ", mHostResources: " + this.cqx + ", isExternal: " + zTQ);
        if (this.cqC && !zTQ) {
            return this.cqx;
        }
        return this.cqz;
    }

    public String toString() {
        return "KSPlugin{mHostResources=" + this.cqx + ", mResResources=" + this.cqy + ", mPluginResources=" + this.cqz + ", mEnable=" + this.cqA + '}';
    }

    private boolean arf() {
        Context contextAnu = ServiceProvider.anu();
        if (!m.fg(contextAnu)) {
            ((com.kwad.sdk.service.a.e) ServiceProvider.get(com.kwad.sdk.service.a.e.class)).gatherException(new IllegalArgumentException("KSPlugin unwrapContextIfNeed fail"));
            return false;
        }
        this.cqx = contextAnu.getResources();
        return true;
    }

    private boolean arg() {
        Context contextAnu;
        Object objA;
        try {
            contextAnu = ServiceProvider.anu();
        } catch (Throwable th) {
            ((com.kwad.sdk.service.a.e) ServiceProvider.get(com.kwad.sdk.service.a.e.class)).gatherException(th);
        }
        if (!m.fg(contextAnu)) {
            ((com.kwad.sdk.service.a.e) ServiceProvider.get(com.kwad.sdk.service.a.e.class)).gatherException(new IllegalArgumentException("KSPlugin unwrapContextIfNeed fail"));
            return false;
        }
        Class<?> cls = Class.forName("com.kwad.sdk.api.loader.Loader", false, getClass().getClassLoader());
        Resources resourcesA = null;
        Object objInvoke = cls.getDeclaredMethod("get", new Class[0]).invoke(null, new Object[0]);
        for (Field field : cls.getDeclaredFields()) {
            if (field.getType() != IKsAdSDK.class && field.getType() != Context.class && field.getType() != AtomicBoolean.class && (objA = z.a(field, objInvoke)) != null) {
                for (Field field2 : objA.getClass().getDeclaredFields()) {
                    if (field2.getType() == Resources.class) {
                        field2.setAccessible(true);
                        String strF = com.kwad.sdk.p.a.F(contextAnu, u.bj(contextAnu));
                        if (!TextUtils.isEmpty(strF)) {
                            resourcesA = com.kwad.library.b.b.a.a(contextAnu, contextAnu.getResources(), strF);
                            com.kwad.sdk.core.d.c.d("KSDY/KSPlugin", "use merge res ");
                        } else {
                            com.kwad.sdk.core.d.c.d("KSDY/KSPlugin", "find dynamicFile failed");
                        }
                        if (resourcesA == null) {
                            resourcesA = (Resources) field2.get(objA);
                        }
                        Resources resources = contextAnu.getResources();
                        i iVar = new i(resourcesA, resources);
                        z.a(field2, objA, iVar);
                        this.cqx = resources;
                        this.cqy = resourcesA;
                        this.cqz = iVar;
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
