package com.bytedance.sdk.component.h.hc.d;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.keva.Keva;
import com.bytedance.keva.KevaBuilder;
import com.bytedance.keva.KevaMonitor;
import com.bytedance.sdk.component.c.d.hc;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d implements hc {
    private Keva d;
    private static final Map<String, hc> hc = new HashMap();
    private static volatile boolean b = false;
    private static volatile boolean c = true;

    @Override // android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        return null;
    }

    @Override // com.bytedance.sdk.component.c.d.hc
    public void hc() {
    }

    @Override // android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
    }

    @Override // android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
    }

    public static hc d(Context context, String str, boolean z, int i) {
        if (!c) {
            return null;
        }
        try {
            if (!b) {
                b = d(context);
            }
            if (TextUtils.isEmpty(str)) {
                str = "tt_ad_sdk_keva";
            }
            if (!c) {
                return null;
            }
            Map<String, hc> map = hc;
            hc dVar = map.get(str);
            if (dVar == null) {
                dVar = new d(str, z, i);
                if (c) {
                    map.put(str, dVar);
                }
            }
            if (c) {
                return dVar;
            }
            return null;
        } catch (Throwable unused) {
            c = false;
            return null;
        }
    }

    private static boolean d(Context context) {
        if (context == null) {
            return false;
        }
        KevaBuilder kevaBuilder = KevaBuilder.getInstance();
        kevaBuilder.setMonitor(new KevaMonitor() { // from class: com.bytedance.sdk.component.h.hc.d.d.1
        });
        kevaBuilder.setContext(context);
        return true;
    }

    private d(String str, boolean z, int i) {
        if (i == 1) {
            b(str, z);
        } else {
            c(str, z);
        }
    }

    private void b(String str, boolean z) {
        if (z) {
            this.d = Keva.getRepo(str, 1);
        } else {
            this.d = Keva.getRepo(str, 0);
        }
    }

    private void c(String str, boolean z) {
        if (z) {
            this.d = Keva.getRepoSync(str, 1);
        } else {
            this.d = Keva.getRepoSync(str, 0);
        }
    }

    @Override // com.bytedance.sdk.component.c.d.hc
    public void d(hc.d<Map<String, ?>> dVar) {
        dVar.d(getAll());
    }

    @Override // com.bytedance.sdk.component.c.d.hc
    public void d(String str, int i) {
        this.d.storeInt(str, i);
    }

    @Override // com.bytedance.sdk.component.c.d.hc
    public void d(String str, long j) {
        this.d.storeLong(str, j);
    }

    @Override // com.bytedance.sdk.component.c.d.hc
    public void d(String str, float f) {
        this.d.storeFloat(str, f);
    }

    @Override // com.bytedance.sdk.component.c.d.hc
    public void d(String str, boolean z) {
        this.d.storeBoolean(str, z);
    }

    @Override // com.bytedance.sdk.component.c.d.hc
    public void d(String str, String str2) {
        this.d.storeString(str, str2);
    }

    @Override // com.bytedance.sdk.component.c.d.hc
    public void d(String str, Set<String> set) {
        this.d.getStringSet(str, set);
    }

    @Override // com.bytedance.sdk.component.c.d.hc
    public void d(String str) {
        this.d.erase(str);
    }

    @Override // com.bytedance.sdk.component.c.d.hc
    public void d() {
        this.d.clear();
    }

    @Override // com.bytedance.sdk.component.c.d.hc
    public int hc(String str, int i) {
        return getInt(str, i);
    }

    @Override // com.bytedance.sdk.component.c.d.hc
    public long hc(String str, long j) {
        return getLong(str, j);
    }

    @Override // com.bytedance.sdk.component.c.d.hc
    public float hc(String str, float f) {
        return getFloat(str, f);
    }

    @Override // com.bytedance.sdk.component.c.d.hc
    public boolean hc(String str, boolean z) {
        return getBoolean(str, z);
    }

    @Override // com.bytedance.sdk.component.c.d.hc
    public String hc(String str, String str2) {
        return getString(str, str2);
    }

    @Override // com.bytedance.sdk.component.c.d.hc
    public Set<String> hc(String str, Set<String> set) {
        return getStringSet(str, set);
    }

    @Override // android.content.SharedPreferences
    public Map<String, ?> getAll() {
        return this.d.getAll();
    }

    @Override // android.content.SharedPreferences
    public String getString(String str, String str2) {
        return this.d.getString(str, str2);
    }

    @Override // android.content.SharedPreferences
    public Set<String> getStringSet(String str, Set<String> set) {
        return this.d.getStringSet(str, set);
    }

    @Override // android.content.SharedPreferences
    public int getInt(String str, int i) {
        return this.d.getInt(str, i);
    }

    @Override // android.content.SharedPreferences
    public long getLong(String str, long j) {
        return this.d.getLong(str, j);
    }

    @Override // android.content.SharedPreferences
    public float getFloat(String str, float f) {
        return this.d.getFloat(str, f);
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z) {
        return this.d.getBoolean(str, z);
    }

    @Override // android.content.SharedPreferences
    public boolean contains(String str) {
        return this.d.contains(str);
    }
}
