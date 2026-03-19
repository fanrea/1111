package com.bytedance.sdk.component.h.b.d;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.sdk.component.c.d.hc;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d implements com.bytedance.sdk.component.c.d.hc {
    private static final Map<String, com.bytedance.sdk.component.c.d.hc> hc = new ConcurrentHashMap();
    private String d;

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

    public static com.bytedance.sdk.component.c.d.hc hc(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "tt_ad_sdk_multi_sp";
        }
        Map<String, com.bytedance.sdk.component.c.d.hc> map = hc;
        com.bytedance.sdk.component.c.d.hc hcVar = map.get(str);
        if (hcVar != null) {
            return hcVar;
        }
        d dVar = new d(str);
        map.put(str, dVar);
        return dVar;
    }

    private d(String str) {
        this.d = str;
    }

    @Override // com.bytedance.sdk.component.c.d.hc
    public void d(hc.d<Map<String, ?>> dVar) {
        dVar.d(getAll());
    }

    @Override // com.bytedance.sdk.component.c.d.hc
    public void d(String str, int i) {
        hc.d(this.d, str, Integer.valueOf(i));
    }

    @Override // com.bytedance.sdk.component.c.d.hc
    public void d(String str, long j) {
        hc.d(this.d, str, Long.valueOf(j));
    }

    @Override // com.bytedance.sdk.component.c.d.hc
    public void d(String str, float f) {
        hc.d(this.d, str, Float.valueOf(f));
    }

    @Override // com.bytedance.sdk.component.c.d.hc
    public void d(String str, boolean z) {
        hc.d(this.d, str, Boolean.valueOf(z));
    }

    @Override // com.bytedance.sdk.component.c.d.hc
    public void d(String str, String str2) {
        hc.d(this.d, str, str2);
    }

    @Override // com.bytedance.sdk.component.c.d.hc
    public void d(String str, Set<String> set) {
        hc.d(this.d, str, set);
    }

    @Override // android.content.SharedPreferences
    public Map<String, ?> getAll() {
        return hc.hc(this.d);
    }

    @Override // android.content.SharedPreferences
    public String getString(String str, String str2) {
        return hc.hc(this.d, str, str2);
    }

    @Override // android.content.SharedPreferences
    public Set<String> getStringSet(String str, Set<String> set) {
        return hc.hc(this.d, str, set);
    }

    @Override // android.content.SharedPreferences
    public int getInt(String str, int i) {
        return hc.d(this.d, str, i);
    }

    @Override // android.content.SharedPreferences
    public long getLong(String str, long j) {
        return hc.d(this.d, str, j);
    }

    @Override // android.content.SharedPreferences
    public float getFloat(String str, float f) {
        return hc.d(this.d, str, f);
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z) {
        return hc.d(this.d, str, z);
    }

    @Override // android.content.SharedPreferences
    public boolean contains(String str) {
        return hc.d(this.d, str);
    }

    @Override // com.bytedance.sdk.component.c.d.hc
    public void d(String str) {
        hc.hc(this.d, str);
    }

    @Override // com.bytedance.sdk.component.c.d.hc
    public void d() {
        hc.d(this.d);
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
}
