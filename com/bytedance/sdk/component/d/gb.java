package com.bytedance.sdk.component.d;

import com.alipay.sdk.m.u.i;
import java.lang.reflect.Type;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
class gb {
    private mq d;

    static gb d(mq mqVar) {
        return new gb(mqVar);
    }

    private gb(mq mqVar) {
        this.d = mqVar;
    }

    <T> T d(String str, Type type) throws JSONException {
        d(str);
        if (type.equals(JSONObject.class) || ((type instanceof Class) && JSONObject.class.isAssignableFrom((Class) type))) {
            return (T) new JSONObject(str);
        }
        return (T) this.d.d(str, type);
    }

    <T> String d(T t) {
        String string;
        if (t == null) {
            return "{}";
        }
        if ((t instanceof JSONObject) || (t instanceof JSONArray)) {
            string = t.toString();
        } else {
            string = this.d.d(t);
        }
        d(string);
        return string;
    }

    private static void d(String str) {
        if (str.startsWith("{") && str.endsWith(i.d)) {
            return;
        }
        tt.d(new IllegalArgumentException("Param is not allowed to be List or JSONArray, rawString:\n ".concat(String.valueOf(str))));
    }
}
