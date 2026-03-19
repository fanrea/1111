package com.kuaishou.security.kste.logic.util;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class KVSecPreferences {
    private static final String CONFIG_NAME = "kste_sp_config";
    private final SharedPreferences.Editor mEditor;
    private final SharedPreferences mPref;

    public KVSecPreferences(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(CONFIG_NAME, 0);
        this.mPref = sharedPreferences;
        this.mEditor = sharedPreferences.edit();
    }

    public boolean decodeBool(String str, boolean z) {
        return this.mPref.getBoolean(str, z);
    }

    public int decodeInt(String str, int i) {
        return this.mPref.getInt(str, i);
    }

    public String decodeString(String str, String str2) {
        return this.mPref.getString(str, str2);
    }

    public void encode(String str, int i) {
        this.mEditor.putInt(str, i);
        this.mEditor.commit();
    }

    public void encode(String str, String str2) {
        this.mEditor.putString(str, str2);
        this.mEditor.commit();
    }

    public void encode(String str, boolean z) {
        this.mEditor.putBoolean(str, z);
        this.mEditor.commit();
    }
}
