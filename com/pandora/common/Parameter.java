package com.pandora.common;

import android.os.Build;
import android.os.Bundle;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class Parameter {
    private Bundle mBundle;

    public Parameter() {
        this.mBundle = new Bundle();
    }

    private Parameter(Bundle bundle) {
        this.mBundle = bundle;
    }

    public void setInt(String key, int value) {
        this.mBundle.putInt(key, value);
    }

    public int getInt(String key, int defaultValue) {
        return containsKey(key) ? this.mBundle.getInt(key) : defaultValue;
    }

    public int getInt(String key) {
        return getInt(key, 0);
    }

    public void setLong(String key, long value) {
        this.mBundle.putLong(key, value);
    }

    public long getLong(String key, long defaultValue) {
        return containsKey(key) ? this.mBundle.getLong(key) : defaultValue;
    }

    public long getLong(String key) {
        return getLong(key, 0L);
    }

    public void setString(String key, String value) {
        this.mBundle.putString(key, value);
    }

    public void setBoolean(String key, boolean value) {
        this.mBundle.putBoolean(key, value);
    }

    public boolean getBoolean(String key, boolean defaultValue) {
        return containsKey(key) ? this.mBundle.getBoolean(key) : defaultValue;
    }

    public boolean getBoolean(String key) {
        return getBoolean(key, false);
    }

    public String getString(String key, String defaultValue) {
        return containsKey(key) ? this.mBundle.getString(key) : defaultValue;
    }

    public String getString(String key) {
        return getString(key, null);
    }

    public void setFloat(String key, float value) {
        this.mBundle.putFloat(key, value);
    }

    public float getFloat(String key, float defaultValue) {
        return containsKey(key) ? this.mBundle.getFloat(key) : defaultValue;
    }

    public float getFloat(String key) {
        return getFloat(key, 0.0f);
    }

    public void setDouble(String key, double value) {
        this.mBundle.putDouble(key, value);
    }

    public double getDouble(String key, float defaultValue) {
        return containsKey(key) ? this.mBundle.getDouble(key) : defaultValue;
    }

    public double getDouble(String key) {
        return getDouble(key, 0.0f);
    }

    public boolean containsKey(String key) {
        return this.mBundle.containsKey(key);
    }

    public void setParameter(String key, Parameter value) {
        this.mBundle.putBundle(key, value.mBundle);
    }

    public Parameter getParameter(String key, Parameter p) {
        Bundle bundle = this.mBundle.getBundle(key);
        return bundle == null ? p : new Parameter(bundle);
    }

    public Parameter getParameter(String key) {
        return getParameter(key, null);
    }

    public void reset() {
        this.mBundle.clear();
    }

    public void copyTo(Parameter p) {
        if (Build.VERSION.SDK_INT >= 26) {
            p.mBundle = this.mBundle.deepCopy();
        } else {
            p.mBundle = (Bundle) this.mBundle.clone();
        }
    }

    public String toString() {
        return this.mBundle.toString();
    }
}
