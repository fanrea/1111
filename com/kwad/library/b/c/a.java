package com.kwad.library.b.c;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import com.kwad.sdk.utils.z;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class a {
    private static final String CLAZZ_NAME = "com.kwad.library.b.c.a";
    private static final ThreadLocal<C0563a> sAutoUnWrapModelTL = new ThreadLocal<>();
    private static final List<String> sAutoUnWrapStackList = new ArrayList();
    private static final Map<String, WeakReference<Context>> sResContextCache = new HashMap();

    /* renamed from: com.kwad.library.b.c.a$a, reason: collision with other inner class name */
    static class C0563a {
        private WeakReference<Context> bhH;
        private int bhI;
        private StackTraceElement[] bhJ;
        private int bhK;
        private long bhL;

        private C0563a() {
            this.bhH = new WeakReference<>(null);
            this.bhI = 0;
            this.bhJ = null;
            this.bhK = 0;
        }

        /* synthetic */ C0563a(byte b) {
            this();
        }

        static /* synthetic */ int c(C0563a c0563a) {
            int i = c0563a.bhI;
            c0563a.bhI = i + 1;
            return i;
        }

        static /* synthetic */ int g(C0563a c0563a) {
            int i = c0563a.bhK;
            c0563a.bhK = i + 1;
            return i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clear() {
            this.bhH = new WeakReference<>(null);
            this.bhI = 0;
            this.bhJ = null;
            this.bhK = 0;
            this.bhL = 0L;
        }
    }

    private static com.kwad.library.b.a cO(String str) {
        return com.kwad.library.solder.a.a.q(null, str);
    }

    public static Context p(Context context, String str) {
        Context eVar;
        if (context == null) {
            return null;
        }
        com.kwad.library.b.a aVarCO = cO(str);
        if (aVarCO == null || !aVarCO.isLoaded() || (context instanceof b) || b(str, context)) {
            return context;
        }
        Context contextA = a(str, context);
        if (contextA != null) {
            return contextA;
        }
        if (context instanceof ContextThemeWrapper) {
            eVar = new c((ContextThemeWrapper) context, str);
        } else if (context instanceof androidx.appcompat.view.ContextThemeWrapper) {
            eVar = new d((androidx.appcompat.view.ContextThemeWrapper) context, str);
        } else if (context instanceof ContextWrapper) {
            eVar = new e(context, str);
        } else {
            eVar = new e(context, str);
        }
        a(str, context, eVar);
        return eVar;
    }

    private static Context a(String str, Context context) {
        WeakReference<Context> weakReference = sResContextCache.get(str + System.identityHashCode(context));
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    private static void a(String str, Context context, Context context2) {
        sResContextCache.put(str + System.identityHashCode(context), new WeakReference<>(context2));
    }

    private static boolean b(String str, Context context) {
        ThreadLocal<C0563a> threadLocal = sAutoUnWrapModelTL;
        C0563a c0563a = threadLocal.get();
        byte b = 0;
        if (c0563a != null) {
            if (c0563a.bhH.get() != context || Math.abs(System.currentTimeMillis() - c0563a.bhL) >= 150) {
                c0563a.clear();
                c0563a.bhH = new WeakReference(context);
                c0563a.bhL = System.currentTimeMillis();
            } else {
                C0563a.c(c0563a);
                if (c0563a.bhI >= (context instanceof Application ? 15 : 5) && a(str, context, c0563a)) {
                    c0563a.clear();
                    return true;
                }
            }
        } else {
            threadLocal.set(new C0563a(b));
        }
        return false;
    }

    private static boolean a(String str, Context context, C0563a c0563a) {
        Context contextA = a(str, context);
        String name = contextA != null ? contextA.getClass().getName() : "";
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (!Arrays.equals(stackTrace, c0563a.bhJ)) {
            if (c0563a.bhJ != null) {
                c0563a.clear();
                return false;
            }
            c0563a.bhJ = stackTrace;
            int i = 0;
            int i2 = 0;
            while (i < stackTrace.length) {
                StackTraceElement stackTraceElement = stackTrace[i];
                String className = stackTraceElement.getClassName();
                Iterator<String> it = getAutoUnWrapStackList().iterator();
                while (it.hasNext()) {
                    if (className.contains(it.next())) {
                        Log.d("PluginWrapper", "needAutoUnWrap true 命中白名单");
                        return true;
                    }
                }
                String methodName = stackTraceElement.getMethodName();
                i++;
                if (i < stackTrace.length && CLAZZ_NAME.equals(className) && "wrapContextIfNeed".equals(methodName)) {
                    StackTraceElement stackTraceElement2 = stackTrace[i];
                    if (TextUtils.equals(name, stackTraceElement2.getClassName()) && "getBaseContext".equals(stackTraceElement2.getMethodName()) && (i2 = i2 + 1) >= 5) {
                        return true;
                    }
                }
            }
            return false;
        }
        C0563a.g(c0563a);
        c0563a.bhJ = stackTrace;
        if (c0563a.bhK < 5) {
            return false;
        }
        Log.d("PluginWrapper", "needAutoUnWrap true 连续相同堆栈");
        return true;
    }

    private static List<String> getAutoUnWrapStackList() {
        List<String> list = sAutoUnWrapStackList;
        if (list.isEmpty()) {
            list.add("com.sensorsdata.analytics.android.sdk");
        }
        return list;
    }

    public static LayoutInflater a(LayoutInflater layoutInflater, String str) {
        com.kwad.library.b.a aVarCO = cO(str);
        if (aVarCO == null || !aVarCO.isLoaded()) {
            return layoutInflater;
        }
        Context context = layoutInflater.getContext();
        if (context instanceof b) {
            return layoutInflater;
        }
        Context contextP = p(context, str);
        return contextP instanceof b ? layoutInflater.cloneInContext(contextP) : layoutInflater;
    }

    public static Context unwrapContextIfNeed(Context context) {
        if (aY(context)) {
            context = aX(context);
        }
        if (!aY(context)) {
            return context;
        }
        for (int i = 0; i < 10; i++) {
            context = aX(context);
            if (!aY(context)) {
                return context;
            }
        }
        return context;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static Context aX(Context context) {
        return ((b) context).getDelegatedContext();
    }

    private static boolean aY(Context context) {
        return context instanceof b;
    }

    static Resources a(Resources resources, String str) {
        com.kwad.library.b.a aVarCO = cO(str);
        if (aVarCO == null || !aVarCO.isLoaded()) {
            new StringBuilder("replaceExternalResources pluginId: ").append(str).append(" , plugin: ").append(aVarCO).append(", isLoaded(): false");
            return resources;
        }
        Resources resources2 = aVarCO.getResources();
        new StringBuilder("replaceExternalResources pluginId: ").append(str).append(", wrappedResources: ").append(resources2);
        return resources2 != null ? resources2 : resources;
    }

    static Resources.Theme a(Resources.Theme theme, Resources.Theme theme2, int i, String str) {
        Resources resources;
        com.kwad.library.b.a aVarCO = cO(str);
        if (aVarCO == null || !aVarCO.isLoaded() || (resources = aVarCO.getResources()) == null) {
            return theme;
        }
        if (theme2 != null) {
            return theme2;
        }
        Resources.Theme themeNewTheme = resources.newTheme();
        themeNewTheme.applyStyle(i, true);
        return themeNewTheme;
    }

    static ClassLoader a(ClassLoader classLoader, String str) {
        com.kwad.library.b.a.b bVarPe;
        com.kwad.library.b.a aVarCO = cO(str);
        return (aVarCO == null || !aVarCO.isLoaded() || (bVarPe = aVarCO.Pe()) == null) ? classLoader : bVarPe;
    }

    static Object wrapSystemService(Object obj, String str, Context context) {
        if (!"layout_inflater".equals(str) || !(obj instanceof LayoutInflater)) {
            return obj;
        }
        LayoutInflater layoutInflater = (LayoutInflater) obj;
        return layoutInflater.getContext() instanceof b ? layoutInflater : layoutInflater.cloneInContext(context);
    }

    static int getThemeResId(Context context) {
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
}
