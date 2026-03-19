package com.bytedance.bmf;

import com.bytedance.hmp.Ptr;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class JsonParam extends Ptr {
    public static JsonParam wrap(long p, boolean own) {
        return new JsonParam(p, own);
    }

    JsonParam(long p, boolean own) {
        this.ptr = p;
        this.own = own;
    }

    public JsonParam() {
        this.ptr = API.bmf_json_make();
        this.own = true;
    }

    public void free() {
        if (this.own) {
            API.bmf_json_free(this.ptr);
        }
    }

    public boolean hasKey(String key) {
        return API.bmf_json_has_key(this.ptr, key);
    }

    public boolean erase(String key) {
        return API.bmf_json_erase(this.ptr, key);
    }

    public String dump() {
        return API.bmf_json_dump(this.ptr);
    }

    public void set(String key, Object value) throws Exception {
        if (value instanceof Integer) {
            API.bmf_json_set_int(this.ptr, key, ((Integer) value).intValue());
            return;
        }
        if (value instanceof Long) {
            API.bmf_json_set_long(this.ptr, key, ((Long) value).longValue());
            return;
        }
        if (value instanceof Float) {
            API.bmf_json_set_float(this.ptr, key, ((Float) value).floatValue());
            return;
        }
        if (value instanceof Double) {
            API.bmf_json_set_double(this.ptr, key, ((Double) value).doubleValue());
            return;
        }
        if (value instanceof String) {
            API.bmf_json_set_string(this.ptr, key, (String) value);
            return;
        }
        if (value.getClass().isArray()) {
            if (value instanceof int[]) {
                API.bmf_json_set_int_list(this.ptr, key, (int[]) value);
                return;
            }
            if (value instanceof float[]) {
                API.bmf_json_set_float_list(this.ptr, key, (float[]) value);
                return;
            } else if (value instanceof double[]) {
                API.bmf_json_set_double_list(this.ptr, key, (double[]) value);
                return;
            } else {
                if (value instanceof String[]) {
                    API.bmf_json_set_string_list(this.ptr, key, (String[]) value);
                    return;
                }
                throw new IllegalArgumentException("Unknown array type for Jsonparam set()");
            }
        }
        throw new IllegalArgumentException("Unknown type for Jsonparam set()");
    }

    public int getInt(String key) {
        return API.bmf_json_get_int(this.ptr, key);
    }

    public long getLong(String key) {
        return API.bmf_json_get_long(this.ptr, key);
    }

    public float getFloat(String key) {
        return API.bmf_json_get_float(this.ptr, key);
    }

    public double getDouble(String key) {
        return API.bmf_json_get_double(this.ptr, key);
    }

    public String getString(String key) {
        return API.bmf_json_get_string(this.ptr, key);
    }

    public int[] getIntList(String key) {
        return API.bmf_json_get_int_list(this.ptr, key);
    }

    public float[] getFloatList(String key) {
        return API.bmf_json_get_float_list(this.ptr, key);
    }

    public double[] getDoubleList(String key) {
        return API.bmf_json_get_double_list(this.ptr, key);
    }

    public String[] getStringList(String key) {
        return API.bmf_json_get_string_list(this.ptr, key);
    }
}
