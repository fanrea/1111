package com.sigmob.sdk.base.utils;

import aegon.chrome.net.impl.CronetUrlRequest;
import com.czhj.sdk.logger.SigmobLogger;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class g {
    private static final String a = "g";

    public static <T> T a(String str, Class<T> cls) throws JSONException {
        if (cls == null || str == null || str.isEmpty()) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        if (d(jSONObject)) {
            return null;
        }
        return (T) a(jSONObject, cls);
    }

    public static <T> T a(JSONObject jSONObject, Class<T> cls) throws Exception {
        T t;
        if (cls == null || d(jSONObject) || (t = (T) h(cls)) == null) {
            return null;
        }
        if (f(cls)) {
            a(t, jSONObject);
        } else {
            Method[] declaredMethods = cls.getDeclaredMethods();
            for (Field field : cls.getDeclaredFields()) {
                String strA = a(field.getName(), "set");
                if (a(declaredMethods, strA)) {
                    try {
                        a(t, cls.getMethod(strA, field.getType()), field, jSONObject);
                    } catch (Exception e) {
                        SigmobLogger.e(a, "parseObject: error = " + e.getMessage(), new Object[0]);
                    }
                } else {
                    field.setAccessible(true);
                    if (jSONObject.opt(field.getName()) != null) {
                        a(t, field, jSONObject);
                    }
                }
            }
        }
        return t;
    }

    public static String a(Object obj) throws JSONException, IllegalAccessException, SecurityException, IllegalArgumentException, InvocationTargetException {
        JSONStringer jSONStringer = new JSONStringer();
        a(jSONStringer, obj);
        return jSONStringer.toString();
    }

    public static String a(String fieldName, String methodType) {
        if (fieldName == null || fieldName.isEmpty()) {
            return null;
        }
        return methodType + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
    }

    public static <T> Collection<T> a(String jsonStr, Class<?> collectionClazz, Class<T> genericType) throws JSONException {
        JSONArray jSONArray;
        if (collectionClazz == null || genericType == null || jsonStr == null || jsonStr.isEmpty()) {
            return null;
        }
        try {
            int iIndexOf = jsonStr.indexOf("[");
            String strSubstring = -1 != iIndexOf ? jsonStr.substring(iIndexOf) : null;
            jSONArray = strSubstring != null ? new JSONArray(strSubstring) : new JSONArray(jsonStr);
        } catch (JSONException e) {
            SigmobLogger.e(a, "parseCollection: error = " + e.getMessage(), new Object[0]);
            jSONArray = null;
        }
        if (d(jSONArray)) {
            return null;
        }
        return a(jSONArray, collectionClazz, genericType);
    }

    public static <T> Collection<T> a(JSONArray jSONArray, Class<?> cls, Class<T> cls2) throws JSONException, SecurityException {
        if (cls == null || cls2 == null || d(jSONArray)) {
            return null;
        }
        CronetUrlRequest.HeadersList headersList = (Collection<T>) ((Collection) h(cls));
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                Object objA = jSONArray.get(i);
                if (objA != null) {
                    if (objA instanceof JSONObject) {
                        objA = a((JSONObject) objA, cls2);
                    }
                    headersList.add(objA);
                }
            } catch (JSONException e) {
                SigmobLogger.e(a, "parseCollection: error = " + e.getMessage(), new Object[0]);
            }
        }
        return headersList;
    }

    private static void a(Object obj, Field field, JSONObject jo) throws Exception {
        Object objA;
        String name = field.getName();
        Class<?> type = field.getType();
        try {
            if (d(type)) {
                Class<?> componentType = type.getComponentType();
                JSONArray jSONArrayOptJSONArray = jo.optJSONArray(name);
                if (d(jSONArrayOptJSONArray)) {
                    return;
                } else {
                    objA = a(jSONArrayOptJSONArray, componentType);
                }
            } else if (e(type)) {
                Class cls = null;
                Type genericType = field.getGenericType();
                if (genericType instanceof ParameterizedType) {
                    Type[] actualTypeArguments = ((ParameterizedType) genericType).getActualTypeArguments();
                    if (n.b(actualTypeArguments) && actualTypeArguments.length > 0) {
                        cls = (Class) actualTypeArguments[0];
                    }
                }
                JSONArray jSONArrayOptJSONArray2 = jo.optJSONArray(name);
                if (d(jSONArrayOptJSONArray2)) {
                    return;
                } else {
                    objA = a(jSONArrayOptJSONArray2, type, cls);
                }
            } else if (i(type)) {
                objA = jo.opt(name);
                if (objA == null) {
                    return;
                }
                if (type == String.class) {
                    objA = objA.toString();
                } else if (type == Date.class) {
                    objA = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA).parse(objA.toString());
                } else if (type == Integer.class) {
                    objA = Integer.valueOf(Integer.parseInt(objA.toString()));
                } else if (type == Long.class) {
                    objA = Long.valueOf(Long.parseLong(objA.toString()));
                } else if (type == Double.class) {
                    objA = Double.valueOf(Double.parseDouble(objA.toString()));
                } else if (type == Boolean.class) {
                    objA = Boolean.valueOf(Boolean.parseBoolean(objA.toString()));
                } else {
                    String str = a;
                    SigmobLogger.e(str, str + "setField: not supper type = " + objA.getClass().getName(), new Object[0]);
                }
            } else if (j(type)) {
                JSONObject jSONObjectOptJSONObject = jo.optJSONObject(name);
                if (d(jSONObjectOptJSONObject)) {
                    return;
                } else {
                    objA = a(jSONObjectOptJSONObject, type);
                }
            } else {
                if (!g(type)) {
                    throw new Exception("Unknown type");
                }
                JSONObject jSONObjectOptJSONObject2 = jo.optJSONObject(name);
                if (d(jSONObjectOptJSONObject2)) {
                    return;
                } else {
                    objA = a(jSONObjectOptJSONObject2, type);
                }
            }
            field.set(obj, objA);
        } catch (Exception e) {
            SigmobLogger.e(a, "setField: error = " + e.getMessage(), new Object[0]);
        }
    }

    public static void a(Object obj, Method fieldSetMethod, String fieldType, Object value) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (value == null || "".equals(value)) {
            return;
        }
        try {
            if ("String".equals(fieldType)) {
                fieldSetMethod.invoke(obj, value.toString());
            } else if ("Date".equals(fieldType)) {
                fieldSetMethod.invoke(obj, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA).parse(value.toString()));
            } else if ("Integer".equals(fieldType) || "int".equals(fieldType)) {
                fieldSetMethod.invoke(obj, Integer.valueOf(Integer.parseInt(value.toString())));
            } else if ("Long".equalsIgnoreCase(fieldType)) {
                fieldSetMethod.invoke(obj, Long.valueOf(Long.parseLong(value.toString())));
            } else if ("Double".equalsIgnoreCase(fieldType)) {
                fieldSetMethod.invoke(obj, Double.valueOf(Double.parseDouble(value.toString())));
            } else if ("Boolean".equalsIgnoreCase(fieldType)) {
                fieldSetMethod.invoke(obj, Boolean.valueOf(Boolean.parseBoolean(value.toString())));
            } else {
                fieldSetMethod.invoke(obj, value);
                String str = a;
                SigmobLogger.e(str, str + "setFieldValue: not supper type = " + fieldType, new Object[0]);
            }
        } catch (Exception e) {
            String str2 = a;
            SigmobLogger.e(str2, str2 + "setFieldValue: error = " + e.getMessage(), new Object[0]);
        }
    }

    private static void a(Object obj, Method fieldSetMethod, Field field, JSONObject jo) throws Exception {
        Object objA;
        String simpleName;
        String name = field.getName();
        Class<?> type = field.getType();
        try {
            if (d(type)) {
                Class<?> componentType = type.getComponentType();
                JSONArray jSONArrayOptJSONArray = jo.optJSONArray(name);
                if (d(jSONArrayOptJSONArray)) {
                    return;
                }
                objA = a(jSONArrayOptJSONArray, componentType);
                simpleName = type.getSimpleName();
            } else if (e(type)) {
                Class cls = null;
                Type genericType = field.getGenericType();
                if (genericType instanceof ParameterizedType) {
                    Type[] actualTypeArguments = ((ParameterizedType) genericType).getActualTypeArguments();
                    if (n.b(actualTypeArguments) && actualTypeArguments.length > 0) {
                        cls = (Class) actualTypeArguments[0];
                    }
                }
                JSONArray jSONArrayOptJSONArray2 = jo.optJSONArray(name);
                if (d(jSONArrayOptJSONArray2)) {
                    return;
                }
                objA = a(jSONArrayOptJSONArray2, type, cls);
                simpleName = type.getSimpleName();
            } else if (i(type)) {
                objA = jo.opt(name);
                if (objA == null) {
                    return;
                } else {
                    simpleName = type.getSimpleName();
                }
            } else if (!j(type)) {
                if (!g(type)) {
                    throw new Exception("Unknown type");
                }
                return;
            } else {
                JSONObject jSONObjectOptJSONObject = jo.optJSONObject(name);
                if (d(jSONObjectOptJSONObject)) {
                    return;
                }
                objA = a(jSONObjectOptJSONObject, type);
                simpleName = type.getSimpleName();
            }
            a(obj, fieldSetMethod, simpleName, objA);
        } catch (Exception e) {
            SigmobLogger.e(a, "setField: error = " + e.getMessage(), new Object[0]);
        }
    }

    public static void a(Object obj, Map<String, String> valMap) throws IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
        Class<?> cls = obj.getClass();
        Method[] declaredMethods = cls.getDeclaredMethods();
        for (Field field : cls.getDeclaredFields()) {
            try {
                String strA = a(field.getName(), "set");
                if (a(declaredMethods, strA)) {
                    Method method = cls.getMethod(strA, field.getType());
                    String str = valMap.get(field.getName());
                    if (str != null && !str.isEmpty()) {
                        String simpleName = field.getType().getSimpleName();
                        if ("String".equals(simpleName)) {
                            method.invoke(obj, str);
                        } else if ("Date".equals(simpleName)) {
                            method.invoke(obj, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).parse(str));
                        } else if ("Integer".equals(simpleName) || "int".equals(simpleName)) {
                            method.invoke(obj, Integer.valueOf(Integer.parseInt(str)));
                        } else if ("Long".equalsIgnoreCase(simpleName)) {
                            method.invoke(obj, Long.valueOf(Long.parseLong(str)));
                        } else if ("Double".equalsIgnoreCase(simpleName)) {
                            method.invoke(obj, Double.valueOf(Double.parseDouble(str)));
                        } else if ("Boolean".equalsIgnoreCase(simpleName)) {
                            method.invoke(obj, Boolean.valueOf(Boolean.parseBoolean(str)));
                        } else {
                            SigmobLogger.e(a, "setFieldValue: not supper type = " + simpleName, new Object[0]);
                        }
                    }
                }
            } catch (Exception e) {
                SigmobLogger.e(a, "setFieldValue: error = " + e.getMessage(), new Object[0]);
            }
        }
    }

    private static void a(Object obj, JSONObject jo) {
        try {
            Iterator<String> itKeys = jo.keys();
            Map map = (Map) obj;
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                map.put(next, jo.get(next));
            }
        } catch (JSONException e) {
            SigmobLogger.e(a, "setField: error = " + e.getMessage(), new Object[0]);
        }
    }

    private static void a(JSONStringer js, Object o) throws JSONException, IllegalAccessException, SecurityException, IllegalArgumentException, InvocationTargetException {
        if (d(o)) {
            try {
                js.value((Object) null);
                return;
            } catch (JSONException e) {
                SigmobLogger.e(a, "serialize: error = " + e.getMessage(), new Object[0]);
                return;
            }
        }
        Class<?> cls = o.getClass();
        if (j(cls)) {
            c(js, o);
            return;
        }
        if (d(cls)) {
            b(js, o);
            return;
        }
        if (e(cls)) {
            a(js, (Collection<?>) o);
            return;
        }
        if (f(cls)) {
            a(js, (Map<?, ?>) o);
            return;
        }
        try {
            js.value(o);
        } catch (JSONException e2) {
            SigmobLogger.e(a, "serialize: error = " + e2.getMessage(), new Object[0]);
        }
    }

    private static void a(JSONStringer js, Collection<?> collection) throws JSONException {
        try {
            js.array();
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                a(js, it.next());
            }
            js.endArray();
        } catch (Exception e) {
            SigmobLogger.e(a, "serializeCollect: error = " + e.getMessage(), new Object[0]);
        }
    }

    private static void a(JSONStringer js, Map<?, ?> map) throws JSONException {
        try {
            js.object();
            for (Map.Entry<?, ?> entry : map.entrySet()) {
                js.key((String) entry.getKey());
                a(js, entry.getValue());
            }
            js.endObject();
        } catch (Exception e) {
            SigmobLogger.e(a, "serializeMap: error = " + e.getMessage(), new Object[0]);
        }
    }

    public static boolean a(Class<?> clazz) {
        return clazz != null && (Boolean.TYPE.isAssignableFrom(clazz) || Boolean.class.isAssignableFrom(clazz));
    }

    public static boolean a(Method[] methods, String fieldMethod) {
        for (Method method : methods) {
            if (fieldMethod.equals(method.getName())) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T[] a(JSONArray jSONArray, Class<T> cls) throws JSONException, SecurityException {
        if (cls == null || d(jSONArray)) {
            return null;
        }
        int length = jSONArray.length();
        T[] tArr = (T[]) ((Object[]) Array.newInstance((Class<?>) cls, length));
        for (int i = 0; i < length; i++) {
            try {
                Object objA = jSONArray.get(i);
                if (objA != null) {
                    if (objA instanceof JSONObject) {
                        objA = a((JSONObject) objA, cls);
                    }
                    tArr[i] = objA;
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return tArr;
    }

    public static Map<String, Object> b(Object obj) throws IllegalAccessException, SecurityException, IllegalArgumentException, InvocationTargetException {
        Object objInvoke;
        Class<?> cls = obj.getClass();
        HashMap map = new HashMap();
        Method[] declaredMethods = cls.getDeclaredMethods();
        for (Field field : cls.getDeclaredFields()) {
            try {
                String name = field.getName();
                String simpleName = field.getType().getSimpleName();
                String strA = a(name, "get");
                if (a(declaredMethods, strA)) {
                    objInvoke = cls.getMethod(strA, new Class[0]).invoke(obj, new Object[0]);
                } else {
                    boolean zIsAccessible = field.isAccessible();
                    if (!zIsAccessible) {
                        field.setAccessible(true);
                    }
                    Object obj2 = field.get(obj);
                    if (!zIsAccessible) {
                        field.setAccessible(false);
                    }
                    objInvoke = obj2;
                }
                if (objInvoke != null) {
                    if ("Date".equals(simpleName)) {
                        objInvoke = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA).format((Date) objInvoke);
                    }
                    map.put(field.getName(), objInvoke);
                }
            } catch (Exception e) {
                SigmobLogger.e(a, "beanToMap: error = " + e.getMessage(), new Object[0]);
            }
        }
        return map;
    }

    private static void b(JSONStringer js, Object array) throws JSONException {
        try {
            js.array();
            for (int i = 0; i < Array.getLength(array); i++) {
                a(js, Array.get(array, i));
            }
            js.endArray();
        } catch (Exception e) {
            SigmobLogger.e(a, "serializeArray: error = " + e.getMessage(), new Object[0]);
        }
    }

    public static boolean b(Class<?> clazz) {
        return clazz != null && (Byte.TYPE.isAssignableFrom(clazz) || Short.TYPE.isAssignableFrom(clazz) || Integer.TYPE.isAssignableFrom(clazz) || Long.TYPE.isAssignableFrom(clazz) || Float.TYPE.isAssignableFrom(clazz) || Double.TYPE.isAssignableFrom(clazz) || Number.class.isAssignableFrom(clazz));
    }

    public static <T> T[] b(String str, Class<T> cls) {
        JSONArray jSONArray;
        if (cls == null || str == null || str.isEmpty()) {
            return null;
        }
        try {
            jSONArray = new JSONArray(str);
        } catch (JSONException e) {
            SigmobLogger.e(a, "parseArray: error = " + e.getMessage(), new Object[0]);
            jSONArray = null;
        }
        if (d(jSONArray)) {
            return null;
        }
        return (T[]) a(jSONArray, cls);
    }

    public static JSONObject c(Object obj) throws IllegalAccessException, SecurityException, IllegalArgumentException, InvocationTargetException {
        try {
            String strA = a(obj);
            SigmobLogger.d(a, "bean2JSONObject: json = " + strA, new Object[0]);
            return new JSONObject(strA);
        } catch (JSONException e) {
            SigmobLogger.e(a, "bean2JSONObject: error = " + e.getMessage(), new Object[0]);
            return null;
        }
    }

    private static void c(JSONStringer js, Object obj) throws JSONException, IllegalAccessException, SecurityException, IllegalArgumentException, InvocationTargetException {
        Object objInvoke;
        try {
            js.object();
            Class<?> cls = obj.getClass();
            Method[] declaredMethods = cls.getDeclaredMethods();
            for (Field field : cls.getDeclaredFields()) {
                try {
                    if (!Modifier.isStatic(field.getModifiers())) {
                        String name = field.getName();
                        String simpleName = field.getType().getSimpleName();
                        String strA = a(name, "get");
                        if (a(declaredMethods, strA)) {
                            objInvoke = cls.getMethod(strA, new Class[0]).invoke(obj, new Object[0]);
                        } else {
                            boolean zIsAccessible = field.isAccessible();
                            if (!zIsAccessible) {
                                field.setAccessible(true);
                            }
                            Object obj2 = field.get(obj);
                            if (!zIsAccessible) {
                                field.setAccessible(false);
                            }
                            objInvoke = obj2;
                        }
                        if (objInvoke != null) {
                            if ("Date".equals(simpleName)) {
                                objInvoke = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format((Date) objInvoke);
                            }
                            js.key(field.getName());
                            a(js, objInvoke);
                        }
                    }
                } catch (Exception e) {
                    SigmobLogger.e(a, "serializeObject: error = " + e.getMessage(), new Object[0]);
                }
            }
            js.endObject();
        } catch (Exception e2) {
            SigmobLogger.e(a, "serializeObject: error = " + e2.getMessage(), new Object[0]);
        }
    }

    public static boolean c(Class<?> clazz) {
        return clazz != null && (String.class.isAssignableFrom(clazz) || Character.TYPE.isAssignableFrom(clazz) || Character.class.isAssignableFrom(clazz));
    }

    public static boolean d(Class<?> clazz) {
        return clazz != null && clazz.isArray();
    }

    private static boolean d(Object obj) {
        return obj instanceof JSONObject ? JSONObject.NULL.equals(obj) : obj == null;
    }

    public static boolean e(Class<?> clazz) {
        return clazz != null && Collection.class.isAssignableFrom(clazz);
    }

    public static boolean f(Class<?> clazz) {
        return clazz != null && Map.class.isAssignableFrom(clazz);
    }

    public static boolean g(Class<?> clazz) {
        return clazz != null && List.class.isAssignableFrom(clazz);
    }

    private static <T> T h(Class<T> cls) throws JSONException {
        if (cls == null) {
            return null;
        }
        if (!cls.isInterface()) {
            try {
                return cls.newInstance();
            } catch (Exception unused) {
                throw new JSONException("Unknown class type: " + cls);
            }
        }
        if (cls.equals(Map.class)) {
            return (T) new HashMap();
        }
        if (cls.equals(List.class)) {
            return (T) new ArrayList();
        }
        if (cls.equals(Set.class)) {
            return (T) new HashSet();
        }
        throw new JSONException("Unknown interface: " + cls);
    }

    private static boolean i(Class<?> clazz) {
        return a(clazz) || b(clazz) || c(clazz);
    }

    private static boolean j(Class<?> clazz) {
        return (clazz == null || i(clazz) || d(clazz) || e(clazz) || f(clazz)) ? false : true;
    }
}
