package com.lingku.xuanshang.xutils.common.util;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class KeyValue {
    public final String key;
    public final Object value;

    public KeyValue(String str, Object obj) {
        this.key = str;
        this.value = obj;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        String str = this.key;
        String str2 = ((KeyValue) obj).key;
        return str == null ? str2 == null : str.equals(str2);
    }

    public String getValueStrOrEmpty() {
        Object obj = this.value;
        return obj == null ? "" : obj.toString();
    }

    public String getValueStrOrNull() {
        Object obj = this.value;
        if (obj == null) {
            return null;
        }
        return obj.toString();
    }

    public int hashCode() {
        String str = this.key;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "KeyValue{key='" + this.key + "', value=" + this.value + '}';
    }
}
