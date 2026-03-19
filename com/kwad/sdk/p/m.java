package com.kwad.sdk.p;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.z;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class m {
    private static Application cqP;

    public static void z(Context context, boolean z) {
        try {
            context.getSharedPreferences("kssdk_api_pref", 0).edit().putBoolean("useContextClassLoader", z).apply();
        } catch (Throwable th) {
            com.kwad.sdk.core.d.c.printStackTrace(th);
        }
    }

    public static int getThemeResId(Context context) {
        if (context instanceof ContextThemeWrapper) {
            Object objA = z.a((Object) context, "android.view.ContextThemeWrapper", "getThemeResId");
            if (objA != null) {
                return ((Integer) objA).intValue();
            }
            return 0;
        }
        if (context instanceof androidx.appcompat.view.ContextThemeWrapper) {
            return ((androidx.appcompat.view.ContextThemeWrapper) context).getThemeResId();
        }
        return 0;
    }

    private static boolean ark() {
        if (f.ard().apB()) {
            return true;
        }
        ServiceProvider.reportSdkCaughtException(new RuntimeException("please init KSPlugin"));
        return false;
    }

    public static View a(Context context, int i, ViewGroup viewGroup, boolean z) {
        return fi(context).inflate(i, viewGroup, z);
    }

    public static View inflate(Context context, int i, ViewGroup viewGroup) {
        return fi(context).inflate(i, viewGroup);
    }

    public static void a(Application application) {
        if (cqP == null) {
            cqP = application;
        }
    }

    public static Application arl() {
        ark();
        Application applicationArm = arm();
        if (j.ari()) {
            cqP = (Application) j.wrapContextIfNeed(applicationArm);
        }
        return cqP;
    }

    private static Application arm() {
        Context applicationContext;
        Application application = cqP;
        if (application != null) {
            return application;
        }
        Context contextAnu = ServiceProvider.anu();
        if (contextAnu instanceof Application) {
            Application application2 = (Application) contextAnu;
            cqP = application2;
            return application2;
        }
        Context applicationContext2 = contextAnu.getApplicationContext();
        if (applicationContext2 instanceof Application) {
            Application application3 = (Application) applicationContext2;
            cqP = application3;
            return application3;
        }
        if (aY(applicationContext2)) {
            applicationContext = j.eZ(applicationContext2);
        } else if (k.aY(applicationContext2)) {
            applicationContext = k.eZ(applicationContext2);
        } else {
            applicationContext = contextAnu.getApplicationContext();
        }
        if (applicationContext instanceof Application) {
            cqP = (Application) applicationContext;
        } else {
            Application application4 = com.kwad.sdk.core.c.b.aaf().getApplication();
            if (application4 != null) {
                cqP = application4;
            } else if (applicationContext instanceof ContextWrapper) {
                Context baseContext = ((ContextWrapper) applicationContext).getBaseContext();
                if (baseContext != null) {
                    baseContext = baseContext.getApplicationContext();
                }
                if (baseContext instanceof Application) {
                    cqP = (Application) baseContext;
                }
            }
        }
        if (cqP == null) {
            cqP = arn();
        }
        Application applicationFf = ff(cqP);
        cqP = applicationFf;
        return applicationFf;
    }

    private static Application arn() {
        Application application = (Application) z.a("android.app.ActivityThread", "currentApplication", new Object[0]);
        return application != null ? application : (Application) z.a("android.app.AppGlobals", "getInitialApplication", new Object[0]);
    }

    public static Activity fb(Context context) {
        if (context instanceof Activity) {
            return (Activity) context;
        }
        Context contextFd = fd(context);
        if (contextFd instanceof Activity) {
            return (Activity) contextFd;
        }
        com.kwad.sdk.core.c.b.aaf();
        return com.kwad.sdk.core.c.b.getCurrentActivity();
    }

    public static Context wrapContextIfNeed(Context context) {
        Context contextWrapContextIfNeed;
        if (!ark() || !aro()) {
            return context;
        }
        if (j.ari()) {
            contextWrapContextIfNeed = j.wrapContextIfNeed(context);
        } else {
            contextWrapContextIfNeed = k.wrapContextIfNeed(context);
        }
        return fc(contextWrapContextIfNeed);
    }

    public static boolean aro() {
        return ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).TQ() || f.ard().are();
    }

    private static Context fc(Context context) {
        if (j.ari() && !aY(context)) {
            ServiceProvider.reportSdkCaughtException(new RuntimeException("expect KSContext in external --context:" + context.getClass().getName() + "--initFinish:" + ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).TT()));
        } else if (!j.ari() && !k.aY(context)) {
            ServiceProvider.reportSdkCaughtException(new RuntimeException("expect ResContext in external --context:" + context.getClass().getName() + "--initFinish:" + ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).TT()));
        }
        return context;
    }

    public static Context fd(Context context) {
        Context contextUnwrapContextIfNeed;
        if (!ark() || !aro() || fg(context)) {
            return context;
        }
        if (aY(context)) {
            contextUnwrapContextIfNeed = j.eY(context);
        } else {
            contextUnwrapContextIfNeed = k.unwrapContextIfNeed(context);
        }
        return fe(contextUnwrapContextIfNeed);
    }

    private static Context fe(Context context) {
        if (k.aY(context) || (context instanceof b)) {
            ServiceProvider.reportSdkCaughtException(new RuntimeException("expect normalContext --context:" + context.getClass().getName() + "--initFinish:" + ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).TT()));
        }
        return context;
    }

    private static Application ff(Context context) {
        if (context instanceof Application) {
            return (Application) context;
        }
        ServiceProvider.reportSdkCaughtException(new RuntimeException("expect normalContext --context:" + context.getClass().getName() + "--initFinish:" + ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).TT() + "--isExternal:" + ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).TQ() + "--isInnerDex:" + f.ard().are()));
        return null;
    }

    public static boolean fg(Context context) {
        return (aY(context) || k.aY(context)) ? false : true;
    }

    private static boolean aY(Context context) {
        return context instanceof b;
    }

    public static Context fh(Context context) {
        try {
            if (k.aY(context)) {
                context = k.aX(context);
            }
            if (context instanceof b) {
                context = ((b) context).getDelegatedContext();
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
        if (fg(context)) {
            return context;
        }
        for (int i = 0; i < 5; i++) {
            if (k.aY(context)) {
                context = k.aX(context);
            }
            if (context instanceof b) {
                context = ((b) context).getDelegatedContext();
            }
            if (fg(context)) {
                return context;
            }
        }
        return context;
    }

    public static LayoutInflater fi(Context context) {
        Context contextWrapContextIfNeed = wrapContextIfNeed(context);
        if (k.aY(contextWrapContextIfNeed)) {
            LayoutInflater layoutInflaterFrom = LayoutInflater.from(contextWrapContextIfNeed);
            a(layoutInflaterFrom);
            return layoutInflaterFrom;
        }
        return LayoutInflater.from(contextWrapContextIfNeed);
    }

    public static LayoutInflater b(Context context, Context context2) {
        LayoutInflater layoutInflaterCloneInContext = LayoutInflater.from(fj(context)).cloneInContext(context2);
        a(layoutInflaterCloneInContext);
        return layoutInflaterCloneInContext;
    }

    private static Context fj(Context context) {
        return context instanceof ContextWrapper ? ((ContextWrapper) context).getBaseContext() : context;
    }

    private static void a(LayoutInflater layoutInflater) {
        z.a(layoutInflater, "mFactory", (Object) null);
        z.a(layoutInflater, "mFactory2", (Object) null);
    }

    public static void z(Activity activity) {
        k.onDestroy(activity);
    }
}
