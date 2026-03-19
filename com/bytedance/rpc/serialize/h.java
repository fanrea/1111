package com.bytedance.rpc.serialize;

import com.bytedance.rpc.callback.RpcInvokeInterceptor;
import com.bytedance.rpc.k;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import io.netty.util.internal.StringUtil;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* compiled from: SerializeManager.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class h {
    private static final Pattern d = Pattern.compile("\\Wcharset=([^\\s;]+)", 2);
    private String a = "";
    private final Map<SerializeType, f> c = new HashMap(2);
    private boolean b = true;

    public void a(f fVar) {
        SerializeType serializeType;
        if (fVar == null || (serializeType = fVar.getSerializeType()) == null) {
            return;
        }
        synchronized (this.c) {
            if (this.c.put(serializeType, fVar) == null) {
                String str = this.a;
                if (str == null || str.length() == 0) {
                    this.a = serializeType.getContentType();
                } else {
                    this.a = String.format("%s,%s", this.a, serializeType.getContentType());
                }
            }
        }
    }

    public void a(SerializeType serializeType) {
        if (serializeType != null) {
            synchronized (this.c) {
                if (this.b) {
                    b();
                }
                if (this.c.remove(serializeType) != null) {
                    StringBuilder sb = new StringBuilder(this.a.length());
                    Iterator<SerializeType> it = this.c.keySet().iterator();
                    while (it.hasNext()) {
                        sb.append(it.next().getContentType()).append(StringUtil.COMMA);
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    this.a = sb.toString();
                }
            }
        }
    }

    public f b(SerializeType serializeType) {
        if (serializeType == null) {
            return null;
        }
        synchronized (this.c) {
            f fVar = this.c.get(serializeType);
            if (fVar != null) {
                return fVar;
            }
            if (!this.b) {
                return null;
            }
            b();
            return this.c.get(serializeType);
        }
    }

    public String a() {
        if (this.b) {
            synchronized (this.c) {
                if (this.b) {
                    b();
                }
            }
        }
        return this.a;
    }

    private void b() {
        if (this.c.get(SerializeType.JSON) == null) {
            a(a("com.bytedance.rpc.serialize.JsonSerializeFactory"));
        }
        if (this.c.get(SerializeType.PB) == null) {
            f fVarA = a("com.bytedance.rpc.serialize.PbSerializeFactory");
            f fVarA2 = a("com.bytedance.rpc.serialize.WireSerializeFactory");
            if (fVarA != null && fVarA2 != null) {
                a((f) new g(fVarA.getSerializeType(), new f[]{fVarA, fVarA2}));
            } else {
                a(fVarA);
                a(fVarA2);
            }
        }
        if (this.c.get(SerializeType.THRIFT) == null) {
            a(a("com.bytedance.rpc.serialize.ThriftSerializeFactory"));
        }
        Object objB = com.bytedance.sdk.djx.proguard3.c.f.b("com.bytedance.rpc.rxjava.RxJavaInvokeInterceptor");
        if (objB instanceof RpcInvokeInterceptor) {
            k.a((RpcInvokeInterceptor) objB);
        }
        this.b = false;
    }

    private f a(String str) {
        Object objB = com.bytedance.sdk.djx.proguard3.c.f.b(str);
        if (objB instanceof f) {
            return (f) objB;
        }
        return null;
    }

    public SerializeType a(String str, Type type, SerializeType serializeType) {
        SerializeType rVar = SerializeType.parser(str);
        if (rVar == null && str != null) {
            String[] typeAndSubType = SerializeType.getTypeAndSubType(str);
            if (typeAndSubType.length > 0) {
                SerializeType[] serializeTypeArrValues = SerializeType.values();
                int length = serializeTypeArrValues.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    SerializeType serializeType2 = serializeTypeArrValues[i];
                    if (Arrays.equals(typeAndSubType, serializeType2.getTypeAndSubType())) {
                        rVar = serializeType2;
                        break;
                    }
                    i++;
                }
            }
        }
        if (rVar == null && type == String.class && (str.contains("text") || str.contains("html"))) {
            rVar = SerializeType.JSON;
        }
        return rVar == null ? serializeType : rVar;
    }

    private static Object a(Type type, String str) {
        if (!(type instanceof Class)) {
            return null;
        }
        Class<?> cls = (Class) type;
        try {
            if (!Integer.class.isAssignableFrom(cls) && !Integer.TYPE.isAssignableFrom(cls)) {
                if (!Long.class.isAssignableFrom(cls) && !Long.TYPE.isAssignableFrom(cls)) {
                    if (!Float.class.isAssignableFrom(cls) && !Float.TYPE.isAssignableFrom(cls)) {
                        if (!Double.class.isAssignableFrom(cls) && !Double.TYPE.isAssignableFrom(cls)) {
                            if (BigDecimal.class.isAssignableFrom(cls)) {
                                return new BigDecimal(str);
                            }
                            return null;
                        }
                        return Double.valueOf(Double.parseDouble(str));
                    }
                    return Float.valueOf(Float.parseFloat(str));
                }
                return Long.valueOf(Long.parseLong(str));
            }
            return Integer.valueOf(Integer.parseInt(str));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void a(Object obj, Map<String, String> map) throws IllegalAccessException, IllegalArgumentException {
        Field[] declaredFields;
        e eVarA;
        if (obj.getClass().getAnnotation(com.bytedance.rpc.annotation.d.class) == null || (declaredFields = obj.getClass().getDeclaredFields()) == null || declaredFields.length <= 0) {
            return;
        }
        for (Field field : declaredFields) {
            if (!Modifier.isStatic(field.getModifiers())) {
                com.bytedance.rpc.annotation.b bVar = (com.bytedance.rpc.annotation.b) field.getAnnotation(com.bytedance.rpc.annotation.b.class);
                com.bytedance.rpc.annotation.c cVar = (com.bytedance.rpc.annotation.c) field.getAnnotation(com.bytedance.rpc.annotation.c.class);
                if (bVar == null) {
                    eVarA = cVar == null ? null : cVar.a();
                } else {
                    eVarA = bVar.a();
                }
                if (eVarA != null && eVarA == e.HEADER) {
                    try {
                        SerializedName serializedName = (SerializedName) field.getAnnotation(SerializedName.class);
                        String str = map.get(serializedName == null ? field.getName() : serializedName.value());
                        if (str != null) {
                            field.setAccessible(true);
                            if (CharSequence.class.isAssignableFrom(field.getType())) {
                                field.set(obj, str);
                            } else {
                                Object objA = a(field.getType(), str);
                                if (objA != null) {
                                    field.set(obj, objA);
                                }
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void a(Object obj, Map<String, String> map, Map<String, String> map2, Map<String, Object> map3, f fVar) {
        Field[] declaredFields;
        e eVarA;
        if (obj != null) {
            if ((map == null && map2 == null && map3 == null) || (declaredFields = obj.getClass().getDeclaredFields()) == null || declaredFields.length <= 0) {
                return;
            }
            for (Field field : declaredFields) {
                if (!Modifier.isStatic(field.getModifiers())) {
                    com.bytedance.rpc.annotation.b bVar = (com.bytedance.rpc.annotation.b) field.getAnnotation(com.bytedance.rpc.annotation.b.class);
                    com.bytedance.rpc.annotation.e eVar = (com.bytedance.rpc.annotation.e) field.getAnnotation(com.bytedance.rpc.annotation.e.class);
                    if (bVar == null) {
                        eVarA = eVar == null ? null : eVar.a();
                    } else {
                        eVarA = bVar.a();
                    }
                    if (eVarA != null) {
                        try {
                            field.setAccessible(true);
                            Object obj2 = field.get(obj);
                            if (obj2 != null) {
                                if (eVarA == e.HEADER || eVarA == e.QUERY) {
                                    Map<String, String> map4 = eVarA == e.HEADER ? map : map2;
                                    if (map4 != null) {
                                        if (obj2 instanceof Map) {
                                            a(map4, (Map<?, ?>) obj2, fVar);
                                        } else {
                                            SerializedName serializedName = (SerializedName) field.getAnnotation(SerializedName.class);
                                            map4.put(serializedName == null ? field.getName() : serializedName.value(), String.valueOf(a(obj2, fVar)));
                                        }
                                    }
                                } else if (eVarA == e.BODY && map3 != null) {
                                    SerializedName serializedName2 = (SerializedName) field.getAnnotation(SerializedName.class);
                                    map3.put(serializedName2 == null ? field.getName() : serializedName2.value(), a(obj2));
                                }
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    public static Map<String, String> a(Object obj, Map<String, String> map, f fVar) throws Exception {
        if (map == null) {
            map = new HashMap<>(8);
        }
        for (Object obj2 : obj instanceof Object[] ? (Object[]) obj : new Object[]{obj}) {
            if (obj2 != null) {
                Class<?> cls = obj2.getClass();
                if (Map.class.isAssignableFrom(cls)) {
                    a(map, (Map<?, ?>) obj2, fVar);
                } else if (JsonObject.class.isAssignableFrom(cls)) {
                    a(map, (JsonObject) obj2);
                } else if (JSONObject.class.isAssignableFrom(cls)) {
                    a(map, (JSONObject) obj2);
                } else {
                    Field[] declaredFields = obj2.getClass().getDeclaredFields();
                    if (declaredFields != null && declaredFields.length > 0) {
                        for (Field field : declaredFields) {
                            if (!Modifier.isStatic(field.getModifiers()) && field.getAnnotation(com.bytedance.rpc.annotation.e.class) == null && field.getAnnotation(com.bytedance.rpc.annotation.b.class) == null) {
                                field.setAccessible(true);
                                Object obj3 = field.get(obj2);
                                if (obj3 != null) {
                                    if (obj3 instanceof Map) {
                                        a(map, (Map<?, ?>) obj3, fVar);
                                    } else if (obj3 instanceof List) {
                                        SerializedName serializedName = (SerializedName) field.getAnnotation(SerializedName.class);
                                        String name = serializedName == null ? field.getName() : serializedName.value();
                                        StringBuilder sb = new StringBuilder();
                                        for (Object obj4 : (List) obj3) {
                                            if (obj4 != null) {
                                                sb.append(a(obj4, fVar).toString()).append(",");
                                            }
                                        }
                                        String string = sb.toString();
                                        if (string.length() > 0) {
                                            string = string.substring(0, string.length() - 1);
                                        }
                                        map.put(name, string);
                                    } else {
                                        SerializedName serializedName2 = (SerializedName) field.getAnnotation(SerializedName.class);
                                        map.put(serializedName2 == null ? field.getName() : serializedName2.value(), String.valueOf(a(obj3, fVar)));
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return map;
    }

    private static Object a(Object obj) throws NoSuchFieldException {
        if (!(obj instanceof Enum)) {
            return obj;
        }
        SerializedName serializedName = (SerializedName) obj.getClass().getField(String.valueOf(obj)).getAnnotation(SerializedName.class);
        String strValue = serializedName == null ? null : serializedName.value();
        return (strValue == null || strValue.length() <= 0) ? obj : strValue;
    }

    private static Object a(Object obj, f fVar) throws NoSuchFieldException {
        if (obj instanceof Enum) {
            SerializedName serializedName = (SerializedName) obj.getClass().getField(String.valueOf(obj)).getAnnotation(SerializedName.class);
            String strValue = serializedName == null ? null : serializedName.value();
            return (strValue == null || strValue.length() <= 0) ? obj : strValue;
        }
        if (!(obj instanceof String) && !(obj instanceof Long) && !(obj instanceof Integer) && !(obj instanceof Float) && !(obj instanceof Double) && !(obj instanceof Boolean) && !(obj instanceof Byte)) {
            try {
                return new String(fVar.getSerializer(obj, fVar.getSerializeType()).b().a());
            } catch (Throwable unused) {
            }
        }
        return obj;
    }

    private static void a(Map<String, String> map, Map<?, ?> map2, f fVar) throws NoSuchFieldException {
        if (map2.isEmpty()) {
            return;
        }
        for (Map.Entry<?, ?> entry : map2.entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (key != null && value != null) {
                map.put(String.valueOf(key), String.valueOf(a(value, fVar)));
            }
        }
    }

    private static void a(Map<String, String> map, JsonObject jsonObject) {
        Set<Map.Entry<String, JsonElement>> setEntrySet = jsonObject.entrySet();
        if (setEntrySet == null || setEntrySet.size() <= 0) {
            return;
        }
        for (Map.Entry<String, JsonElement> entry : setEntrySet) {
            String key = entry.getKey();
            JsonElement value = entry.getValue();
            if (key != null && value != null) {
                map.put(key, value.getAsString());
            }
        }
    }

    private static void a(Map<String, String> map, JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() == 0) {
            return;
        }
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            Object objOpt = jSONObject.opt(next);
            if (next != null && objOpt != null) {
                map.put(next, String.valueOf(objOpt));
            }
        }
    }

    public static String a(String str, String str2) {
        Matcher matcher = d.matcher(str);
        return matcher.find() ? matcher.group(1).replaceAll("[\"\\\\]", "") : str2;
    }
}
