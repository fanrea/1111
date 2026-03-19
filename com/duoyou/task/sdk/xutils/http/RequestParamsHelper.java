package com.duoyou.task.sdk.xutils.http;

import android.os.Parcelable;
import com.duoyou.task.sdk.xutils.common.util.LogUtil;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class RequestParamsHelper {
    private static final ClassLoader BOOT_CL = String.class.getClassLoader();

    public interface ParseKVListener {
        void onParseKV(String str, Object obj);
    }

    private RequestParamsHelper() {
    }

    public static void parseKV(Object obj, Class<?> cls, ParseKVListener parseKVListener) {
        ClassLoader classLoader;
        if (obj == null || cls == null || cls == RequestParams.class || cls == Object.class || (classLoader = cls.getClassLoader()) == null || classLoader == BOOT_CL) {
            return;
        }
        Field[] declaredFields = cls.getDeclaredFields();
        if (declaredFields != null && declaredFields.length > 0) {
            for (Field field : declaredFields) {
                String name = field.getName();
                if (!Modifier.isTransient(field.getModifiers()) && !"serialVersionUID".equals(name) && field.getType() != Parcelable.Creator.class) {
                    try {
                        field.setAccessible(true);
                        Object obj2 = field.get(obj);
                        if (obj2 != null) {
                            parseKVListener.onParseKV(name, obj2);
                        }
                    } catch (Throwable th) {
                        LogUtil.e(th.getMessage(), th);
                    }
                }
            }
        }
        parseKV(obj, cls.getSuperclass(), parseKVListener);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r0v2, types: [org.json.JSONArray] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4, types: [org.json.JSONArray] */
    public static Object parseJSONObject(Object obj) throws JSONException {
        Object jSONObject;
        if (obj == null) {
            return null;
        }
        Class<?> cls = obj.getClass();
        if (cls.isArray()) {
            jSONObject = new JSONArray();
            int length = Array.getLength(obj);
            for (int i = 0; i < length; i++) {
                jSONObject.put(parseJSONObject(Array.get(obj, i)));
            }
        } else if (obj instanceof Iterable) {
            jSONObject = new JSONArray();
            Iterator it = ((Iterable) obj).iterator();
            while (it.hasNext()) {
                jSONObject.put(parseJSONObject(it.next()));
            }
        } else if (obj instanceof Map) {
            jSONObject = new JSONObject();
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                Object key = entry.getKey();
                Object value = entry.getValue();
                if (key != null && value != null) {
                    jSONObject.put(String.valueOf(key), parseJSONObject(value));
                }
            }
        } else {
            ClassLoader classLoader = cls.getClassLoader();
            if (classLoader == null || classLoader == BOOT_CL) {
                return obj;
            }
            final JSONObject jSONObject2 = new JSONObject();
            parseKV(obj, cls, new ParseKVListener() { // from class: com.duoyou.task.sdk.xutils.http.RequestParamsHelper.1
                @Override // com.duoyou.task.sdk.xutils.http.RequestParamsHelper.ParseKVListener
                public void onParseKV(String str, Object obj2) throws JSONException {
                    try {
                        jSONObject2.put(str, RequestParamsHelper.parseJSONObject(obj2));
                    } catch (JSONException e) {
                        throw new IllegalArgumentException("parse RequestParams to json failed", e);
                    }
                }
            });
            return jSONObject2;
        }
        return jSONObject;
    }
}
