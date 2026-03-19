package com.bytedance.sdk.component.h.b;

import android.content.SharedPreferences;
import com.bytedance.sdk.component.c.d.hc;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class c implements com.bytedance.sdk.component.c.d.hc {
    SharedPreferences d;

    @Override // com.bytedance.sdk.component.c.d.hc
    public void hc() {
    }

    public c(SharedPreferences sharedPreferences) {
        this.d = sharedPreferences;
    }

    @Override // com.bytedance.sdk.component.c.d.hc
    public void d(hc.d<Map<String, ?>> dVar) {
        if (dVar != null) {
            dVar.d(getAll());
        }
    }

    @Override // com.bytedance.sdk.component.c.d.hc
    public void d(String str, int i) {
        try {
            this.d.edit().putInt(str, i).apply();
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.sdk.component.c.d.hc
    public void d(String str, long j) {
        try {
            this.d.edit().putLong(str, j).apply();
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.sdk.component.c.d.hc
    public void d(String str, float f) {
        try {
            this.d.edit().putFloat(str, f).apply();
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.sdk.component.c.d.hc
    public void d(String str, boolean z) {
        try {
            this.d.edit().putBoolean(str, z).apply();
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.sdk.component.c.d.hc
    public void d(String str, String str2) {
        try {
            this.d.edit().putString(str, str2).apply();
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.sdk.component.c.d.hc
    public void d(String str, Set<String> set) {
        try {
            this.d.edit().putStringSet(str, set).apply();
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.sdk.component.c.d.hc
    public void d(String str) {
        try {
            this.d.edit().remove(str).apply();
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.sdk.component.c.d.hc
    public void d() {
        try {
            this.d.edit().clear().apply();
        } catch (Throwable unused) {
        }
    }

    @Override // com.bytedance.sdk.component.c.d.hc
    public int hc(String str, int i) {
        try {
            return this.d.getInt(str, i);
        } catch (Exception unused) {
            return i;
        }
    }

    @Override // com.bytedance.sdk.component.c.d.hc
    public long hc(String str, long j) {
        try {
            return this.d.getLong(str, j);
        } catch (Exception unused) {
            return j;
        }
    }

    @Override // com.bytedance.sdk.component.c.d.hc
    public float hc(String str, float f) {
        try {
            return this.d.getFloat(str, f);
        } catch (Exception unused) {
            return f;
        }
    }

    @Override // com.bytedance.sdk.component.c.d.hc
    public boolean hc(String str, boolean z) {
        try {
            return this.d.getBoolean(str, z);
        } catch (Exception unused) {
            return z;
        }
    }

    @Override // com.bytedance.sdk.component.c.d.hc
    public String hc(String str, String str2) {
        try {
            return this.d.getString(str, str2);
        } catch (Exception unused) {
            return str2;
        }
    }

    @Override // com.bytedance.sdk.component.c.d.hc
    public Set<String> hc(String str, Set<String> set) {
        try {
            return this.d.getStringSet(str, set);
        } catch (Exception unused) {
            return set;
        }
    }

    @Override // android.content.SharedPreferences
    public Map<String, ?> getAll() {
        try {
            return this.d.getAll();
        } catch (Exception unused) {
            return Collections.emptyMap();
        }
    }

    @Override // android.content.SharedPreferences
    public String getString(String str, String str2) {
        try {
            return this.d.getString(str, str2);
        } catch (Exception unused) {
            return str2;
        }
    }

    @Override // android.content.SharedPreferences
    public Set<String> getStringSet(String str, Set<String> set) {
        try {
            return this.d.getStringSet(str, set);
        } catch (Exception unused) {
            return set;
        }
    }

    @Override // android.content.SharedPreferences
    public int getInt(String str, int i) {
        try {
            return this.d.getInt(str, i);
        } catch (Exception unused) {
            return i;
        }
    }

    @Override // android.content.SharedPreferences
    public long getLong(String str, long j) {
        try {
            return this.d.getLong(str, j);
        } catch (Exception unused) {
            return j;
        }
    }

    @Override // android.content.SharedPreferences
    public float getFloat(String str, float f) {
        try {
            return this.d.getFloat(str, f);
        } catch (Exception unused) {
            return f;
        }
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z) {
        try {
            return this.d.getBoolean(str, z);
        } catch (Exception unused) {
            return z;
        }
    }

    @Override // android.content.SharedPreferences
    public boolean contains(String str) {
        return this.d.contains(str);
    }

    @Override // android.content.SharedPreferences
    public SharedPreferences.Editor edit() {
        return this.d.edit();
    }

    @Override // android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.d.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    @Override // android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.d.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }
}
