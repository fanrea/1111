package com.kwad.sdk.core.config;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bp;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class b {
    public static final Map<String, Set<com.kwad.sdk.core.config.item.b>> bwO = new ConcurrentHashMap();
    private static SharedPreferences bwP = null;

    public static <T> void a(com.kwad.sdk.core.config.item.b<T> bVar) {
        String key = bVar.getKey();
        if (TextUtils.isEmpty(key)) {
            return;
        }
        Set<com.kwad.sdk.core.config.item.b> setEN = eN(key);
        if (setEN == null) {
            setEN = new CopyOnWriteArraySet<>();
            bwO.put(key, setEN);
        }
        setEN.add(bVar);
    }

    private static Set<com.kwad.sdk.core.config.item.b> eN(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return bwO.get(str);
    }

    public static void n(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        for (String str : bwO.keySet()) {
            Set<com.kwad.sdk.core.config.item.b> set = bwO.get(str);
            if (set != null && !set.isEmpty() && jSONObject.has(str)) {
                for (com.kwad.sdk.core.config.item.b bVar : set) {
                    if (bVar != null) {
                        bVar.g(jSONObject);
                    }
                }
            }
        }
    }

    private static SharedPreferences Xv() {
        if (bwP == null) {
            bwP = bp.iH("ksadsdk_config");
        }
        return bwP;
    }

    public static synchronized void bD(Context context) {
        try {
            SharedPreferences sharedPreferencesXv = Xv();
            if (sharedPreferencesXv != null) {
                SharedPreferences.Editor editorEdit = sharedPreferencesXv.edit();
                b(editorEdit);
                editorEdit.commit();
            }
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static synchronized void bE(Context context) {
        SharedPreferences sharedPreferencesXv = Xv();
        if (sharedPreferencesXv != null) {
            a(sharedPreferencesXv);
        }
    }

    private static void b(SharedPreferences.Editor editor) {
        if (editor != null) {
            Iterator<String> it = bwO.keySet().iterator();
            while (it.hasNext()) {
                Set<com.kwad.sdk.core.config.item.b> set = bwO.get(it.next());
                if (set != null && !set.isEmpty()) {
                    for (com.kwad.sdk.core.config.item.b bVar : set) {
                        if (bVar != null) {
                            bVar.a(editor);
                        }
                    }
                }
            }
        }
    }

    private static void a(SharedPreferences sharedPreferences) {
        if (sharedPreferences != null) {
            Iterator<String> it = bwO.keySet().iterator();
            while (it.hasNext()) {
                Set<com.kwad.sdk.core.config.item.b> set = bwO.get(it.next());
                if (set != null && !set.isEmpty()) {
                    for (com.kwad.sdk.core.config.item.b bVar : set) {
                        if (bVar != null) {
                            try {
                                bVar.a(sharedPreferences);
                            } catch (Exception e) {
                                com.kwad.sdk.core.d.c.printStackTraceOnly(e);
                            }
                        }
                    }
                }
            }
        }
    }

    static void a(Context context, com.kwad.sdk.core.config.item.b<?> bVar) {
        SharedPreferences sharedPreferencesXv;
        if (bVar == null || (sharedPreferencesXv = Xv()) == null) {
            return;
        }
        try {
            bVar.a(sharedPreferencesXv);
        } catch (Exception e) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(e);
        }
    }
}
