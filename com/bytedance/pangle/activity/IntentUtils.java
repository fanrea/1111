package com.bytedance.pangle.activity;

import android.content.Intent;
import android.os.Bundle;
import com.bytedance.pangle.Zeus;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class IntentUtils {
    static HashMap<Long, WeakReference<Bundle>> d = new HashMap<>();

    public static void setUseMemory(Intent intent) {
        intent.putExtra("pangle_use_memory", System.currentTimeMillis());
    }

    public static void d(Intent intent, String str) {
        long longExtra = intent.getLongExtra("pangle_use_memory", 0L);
        if (Zeus.getPlugin(str).mUseMemoryForActivityIntent && longExtra == 0) {
            longExtra = System.currentTimeMillis();
        }
        if (longExtra != 0) {
            Bundle extras = intent.getExtras();
            intent.replaceExtras((Bundle) null);
            d(longExtra, extras);
            intent.putExtra("pangle_use_memory", longExtra);
        }
    }

    private static void d(long j, Bundle bundle) {
        d.put(Long.valueOf(j), new WeakReference<>(bundle));
    }

    public static void d(Intent intent) {
        Bundle bundleD;
        long longExtra = intent.getLongExtra("pangle_use_memory", 0L);
        if (longExtra == 0 || (bundleD = d(longExtra)) == null) {
            return;
        }
        intent.putExtras(bundleD);
    }

    private static Bundle d(long j) {
        WeakReference<Bundle> weakReferenceRemove = d.remove(Long.valueOf(j));
        if (weakReferenceRemove != null) {
            return weakReferenceRemove.get();
        }
        return null;
    }
}
