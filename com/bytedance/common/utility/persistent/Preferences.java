package com.bytedance.common.utility.persistent;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Parcel;
import android.util.Base64;
import java.util.Map;
import java.util.Set;

@Deprecated
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class Preferences implements SharedPreferences {
    public static final String PREFERENCE_PREFIX = "pref_id_";
    private SharedPreferences mPreference;

    public static Preferences getById(Context context, String str) {
        return new Preferences(context.getSharedPreferences(PREFERENCE_PREFIX + str, 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Deprecated
    public static String bundleToString(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        Parcel parcelObtain = Parcel.obtain();
        try {
            bundle.writeToParcel(parcelObtain, 0);
            String strEncodeToString = Base64.encodeToString(parcelObtain.marshall(), 0);
            parcelObtain.recycle();
            return strEncodeToString;
        } catch (Throwable unused) {
            parcelObtain.recycle();
            return null;
        }
    }

    @Deprecated
    private static Bundle stringToBundle(String str) {
        byte[] bArrDecode = Base64.decode(str, 0);
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.unmarshall(bArrDecode, 0, bArrDecode.length);
            parcelObtain.setDataPosition(0);
            return (Bundle) Bundle.CREATOR.createFromParcel(parcelObtain);
        } finally {
            parcelObtain.recycle();
        }
    }

    public Preferences(SharedPreferences sharedPreferences) {
        this.mPreference = sharedPreferences;
    }

    @Override // android.content.SharedPreferences
    public boolean contains(String str) {
        return this.mPreference.contains(str);
    }

    @Override // android.content.SharedPreferences
    public CustomEditor edit() {
        return new CustomEditor(this.mPreference.edit());
    }

    @Override // android.content.SharedPreferences
    public Map<String, ?> getAll() {
        return this.mPreference.getAll();
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z) {
        return this.mPreference.getBoolean(str, z);
    }

    public Bundle getBundle(String str, Bundle bundle) {
        String string = this.mPreference.getString(str, null);
        return string == null ? bundle : stringToBundle(string);
    }

    @Override // android.content.SharedPreferences
    public float getFloat(String str, float f) {
        return this.mPreference.getFloat(str, f);
    }

    @Override // android.content.SharedPreferences
    public int getInt(String str, int i) {
        return this.mPreference.getInt(str, i);
    }

    @Override // android.content.SharedPreferences
    public long getLong(String str, long j) {
        return this.mPreference.getLong(str, j);
    }

    @Override // android.content.SharedPreferences
    public String getString(String str, String str2) {
        return this.mPreference.getString(str, str2);
    }

    @Override // android.content.SharedPreferences
    public Set<String> getStringSet(String str, Set<String> set) {
        return this.mPreference.getStringSet(str, set);
    }

    @Override // android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.mPreference.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    @Override // android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.mPreference.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    public static class CustomEditor implements SharedPreferences.Editor {
        private SharedPreferences.Editor mEditor;

        public CustomEditor(SharedPreferences.Editor editor) {
            this.mEditor = editor;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor clear() {
            this.mEditor.clear();
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public boolean commit() {
            return this.mEditor.commit();
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putBoolean(String str, boolean z) {
            this.mEditor.putBoolean(str, z);
            return this;
        }

        @Deprecated
        public SharedPreferences.Editor putBundle(String str, Bundle bundle) {
            this.mEditor.putString(str, Preferences.bundleToString(bundle));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putFloat(String str, float f) {
            this.mEditor.putFloat(str, f);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putInt(String str, int i) {
            this.mEditor.putInt(str, i);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putLong(String str, long j) {
            this.mEditor.putLong(str, j);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putString(String str, String str2) {
            this.mEditor.putString(str, str2);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor remove(String str) {
            this.mEditor.remove(str);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putStringSet(String str, Set<String> set) {
            this.mEditor.putStringSet(str, set);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public void apply() {
            this.mEditor.apply();
        }
    }
}
