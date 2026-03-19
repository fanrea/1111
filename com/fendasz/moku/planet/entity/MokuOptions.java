package com.fendasz.moku.planet.entity;

import com.fendasz.moku.planet.utils.LogUtils;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class MokuOptions {
    private static final String TAG = "MokuOptions";
    private Map<String, String> stringMap = new HashMap();
    private Map<String, Boolean> booleanMap = new HashMap();
    private Map<String, Integer> integerMap = new HashMap();
    private Map<String, Long> longMap = new HashMap();
    private Map<String, Float> floatMap = new HashMap();
    private Map<String, Double> doubleMap = new HashMap();

    public void putString(String str, String str2) {
        LogUtils.log(TAG, hashCode() + " putString key >> " + str + " value >> " + str2);
        this.stringMap.put(str, str2);
    }

    public String getString(String str, String str2) {
        String str3 = this.stringMap.get(str);
        return str3 != null ? str3 : str2;
    }

    public void putBoolean(String str, boolean z) {
        LogUtils.log(TAG, hashCode() + " putBoolean key >> " + str + " value >> " + z);
        this.booleanMap.put(str, Boolean.valueOf(z));
    }

    public boolean getBoolean(String str, boolean z) {
        Boolean bool = this.booleanMap.get(str);
        return bool != null ? bool.booleanValue() : z;
    }

    public void putInteger(String str, int i) {
        LogUtils.log(TAG, hashCode() + " putInteger key >> " + str + " value >> " + i);
        this.integerMap.put(str, Integer.valueOf(i));
    }

    public int getInteger(String str, int i) {
        Integer num = this.integerMap.get(str);
        return num != null ? num.intValue() : i;
    }

    public void putLong(String str, Long l) {
        LogUtils.log(TAG, hashCode() + " putLong key >> " + str + " value >> " + l);
        this.longMap.put(str, l);
    }

    public long getLong(String str, long j) {
        Long l = this.longMap.get(str);
        return l != null ? l.longValue() : j;
    }

    public void putFloat(String str, float f) {
        LogUtils.log(TAG, hashCode() + " putFloat key >> " + str + " value >> " + f);
        this.floatMap.put(str, Float.valueOf(f));
    }

    public float getFloat(String str, float f) {
        Float f2 = this.floatMap.get(str);
        return f2 != null ? f2.floatValue() : f;
    }

    public void putDouble(String str, double d) {
        LogUtils.log(TAG, hashCode() + " putDouble key >> " + str + " value >> " + d);
        this.doubleMap.put(str, Double.valueOf(d));
    }

    public double getDouble(String str, double d) {
        Double d2 = this.doubleMap.get(str);
        return d2 != null ? d2.doubleValue() : d;
    }

    public Map<String, String> getStringMap() {
        return this.stringMap;
    }

    public void setStringMap(Map<String, String> map) {
        this.stringMap = map;
    }

    public Map<String, Boolean> getBooleanMap() {
        return this.booleanMap;
    }

    public void setBooleanMap(Map<String, Boolean> map) {
        this.booleanMap = map;
    }

    public Map<String, Integer> getIntegerMap() {
        return this.integerMap;
    }

    public void setIntegerMap(Map<String, Integer> map) {
        this.integerMap = map;
    }

    public Map<String, Long> getLongMap() {
        return this.longMap;
    }

    public void setLongMap(Map<String, Long> map) {
        this.longMap = map;
    }

    public Map<String, Float> getFloatMap() {
        return this.floatMap;
    }

    public void setFloatMap(Map<String, Float> map) {
        this.floatMap = map;
    }

    public Map<String, Double> getDoubleMap() {
        return this.doubleMap;
    }

    public void setDoubleMap(Map<String, Double> map) {
        this.doubleMap = map;
    }
}
