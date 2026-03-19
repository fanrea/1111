package com.tkruntime.v8;

import android.os.Handler;
import android.os.Looper;
import android.util.LruCache;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public class V8JSONProxy extends V8ObjectProxy {
    private static final boolean ENABLE_ANALYZE_PERFORMANCE = false;
    private static final String JSON_PROXY_NAME = "JSON_PROXY";
    private static final int MAX_ENTRY_SIZE = 96;
    private static Gson sGson;
    private static final LruCache<Class, ObjectMeta> sMetaCache = new LruCache<>(96);
    private JsonObject mJsonObject;
    private Object mSerial;
    private V8 mV8;

    private void beginAnalyzePerformance() {
    }

    private void endAnalyzePerformance() {
    }

    public static V8JsonProxyObject composeJsObjectForJSON(V8 v8, JsonObject jsonObject) {
        return new V8JsonProxyObject(v8, new V8JSONProxy(v8, jsonObject).getHandle());
    }

    public static V8JsonProxyObject composeJsonObjectForSerializable(V8 v8, Serializable serializable) {
        V8JSONProxy v8JSONProxy = new V8JSONProxy(v8, serializable);
        if (ObjectMeta.isSerializableObject(serializable) && ObjectMeta.tryGetMeta(serializable) == null) {
            initMetaAsync(serializable.getClass());
        }
        return new V8JsonProxyObject(v8, v8JSONProxy.getHandle());
    }

    public static V8JSONProxy createProxyForWrapper(V8 v8, NativeObjectWrapper nativeObjectWrapper) {
        if (nativeObjectWrapper != null && nativeObjectWrapper.getNativeObject() != null) {
            Object nativeObject = nativeObjectWrapper.getNativeObject();
            if (!nativeObjectWrapper.isNeedReadPropertyFromJs()) {
                return new V8JSONProxy(v8, nativeObject);
            }
            if (nativeObject instanceof Serializable) {
                Serializable serializable = (Serializable) nativeObject;
                V8JSONProxy v8JSONProxy = new V8JSONProxy(v8, serializable);
                if (ObjectMeta.isSerializableObject(serializable) && ObjectMeta.tryGetMeta(serializable) == null) {
                    initMetaAsync(serializable.getClass());
                }
                return v8JSONProxy;
            }
            if (nativeObject instanceof JsonObject) {
                return new V8JSONProxy(v8, (JsonObject) nativeObject);
            }
        }
        return null;
    }

    public static V8ObjectProxy createProxyForNativeObject(V8 v8, Object obj) {
        return new V8JSONProxy(v8, obj);
    }

    public static void initSerializableMetaAsync(Class cls) {
        if ((cls == null || sMetaCache.get(cls) == null) && Serializable.class.isAssignableFrom(cls)) {
            initMetaAsync(cls);
        }
    }

    public static V8Array composeJsonObjectForSerializableList(V8 v8, List<? extends Serializable> list) {
        if (list == null) {
            return null;
        }
        V8Array v8Array = new V8Array(v8);
        int size = list.size();
        for (int i = 0; i < size; i++) {
            v8Array.push((V8Value) composeJsonObjectForSerializable(v8, list.get(i)));
        }
        return v8Array;
    }

    private static void setGson(Gson gson) {
        if (gson != null) {
            sGson = gson;
        }
    }

    private static void initMetaAsync(final Class cls) {
        Handler handler = V8.getHandler();
        if (handler == null || cls == null) {
            return;
        }
        handler.post(new Runnable() { // from class: com.tkruntime.v8.V8JSONProxy.1
            @Override // java.lang.Runnable
            public final void run() {
                ObjectMeta.loadMetaAsync(cls);
            }
        });
    }

    private V8JSONProxy(V8 v8, Serializable serializable) {
        super(v8, JSON_PROXY_NAME);
        this.mJsonObject = null;
        this.mSerial = null;
        this.mV8 = null;
        this.mSerial = serializable;
        setNativeObject(this.mSerial);
        this.mV8 = v8;
    }

    private V8JSONProxy(V8 v8, JsonObject jsonObject) {
        super(v8, JSON_PROXY_NAME);
        this.mJsonObject = null;
        this.mSerial = null;
        this.mV8 = null;
        this.mJsonObject = jsonObject;
        setNativeObject(this.mJsonObject);
        this.mV8 = v8;
    }

    private V8JSONProxy(V8 v8, Object obj) {
        super(v8, JSON_PROXY_NAME);
        this.mJsonObject = null;
        this.mSerial = null;
        this.mV8 = null;
        setNativeObject(obj);
    }

    private Object convertJsonToV8Value(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof JsonObject) {
            return new V8JSONProxy(this.v8, (JsonObject) obj);
        }
        if (obj instanceof JsonArray) {
            JsonArray jsonArray = (JsonArray) obj;
            V8Array v8Array = new V8Array(this.v8);
            int size = jsonArray.size();
            for (int i = 0; i < size; i++) {
                Object objConvertJsonToV8Value = convertJsonToV8Value(jsonArray.get(i));
                if (objConvertJsonToV8Value == null) {
                    v8Array.pushNull();
                } else {
                    v8Array.push(objConvertJsonToV8Value);
                    if (objConvertJsonToV8Value instanceof V8Value) {
                        ((V8Value) objConvertJsonToV8Value).setWeak();
                    }
                }
            }
            return v8Array;
        }
        if (!(obj instanceof JsonPrimitive)) {
            return obj;
        }
        JsonPrimitive jsonPrimitive = (JsonPrimitive) obj;
        if (jsonPrimitive.isString()) {
            return jsonPrimitive.getAsString();
        }
        if (jsonPrimitive.isNumber()) {
            return Double.valueOf(jsonPrimitive.getAsDouble());
        }
        if (jsonPrimitive.isBoolean()) {
            return Boolean.valueOf(jsonPrimitive.getAsBoolean());
        }
        return null;
    }

    private boolean isPrimaryOrString(Object obj) {
        return (obj instanceof String) || (obj instanceof Number) || (obj instanceof Boolean);
    }

    private void addPrimaryType(String str, Object obj) {
        if (obj == null) {
            addNull(str);
            return;
        }
        if (obj instanceof String) {
            add(str, (String) obj);
            return;
        }
        if (obj instanceof Number) {
            if (obj instanceof Integer) {
                add(str, ((Integer) obj).intValue());
                return;
            }
            if (obj instanceof Double) {
                add(str, ((Double) obj).doubleValue());
                return;
            }
            if (obj instanceof Float) {
                add(str, ((Float) obj).doubleValue());
                return;
            } else if (obj instanceof Boolean) {
                add(str, ((Boolean) obj).booleanValue());
                return;
            } else {
                if (obj instanceof Short) {
                    add(str, ((Short) obj).intValue());
                    return;
                }
                return;
            }
        }
        if (obj instanceof Boolean) {
            add(str, ((Boolean) obj).booleanValue());
        } else {
            addNull(str);
        }
    }

    private Object convertSerializableToV8Value(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof Short) {
            return Integer.valueOf(((Short) obj).intValue());
        }
        if ((obj instanceof String) || (obj instanceof Number) || (obj instanceof Boolean)) {
            return obj;
        }
        int i = 0;
        if (obj instanceof Serializable[]) {
            V8Array v8Array = new V8Array(this.v8);
            if (obj != null) {
                Serializable[] serializableArr = (Serializable[]) obj;
                int length = serializableArr.length;
                while (i < length) {
                    Object objConvertSerializableToV8Value = convertSerializableToV8Value(serializableArr[i]);
                    v8Array.push(objConvertSerializableToV8Value);
                    if (objConvertSerializableToV8Value != null && (objConvertSerializableToV8Value instanceof V8Value)) {
                        ((V8Value) objConvertSerializableToV8Value).setWeak();
                    }
                    i++;
                }
            }
            return v8Array;
        }
        if (obj instanceof List) {
            V8Array v8Array2 = new V8Array(this.v8);
            if (obj != null) {
                List list = (List) obj;
                int size = list.size();
                while (i < size) {
                    Object objConvertSerializableToV8Value2 = convertSerializableToV8Value(list.get(i));
                    v8Array2.push(objConvertSerializableToV8Value2);
                    if (objConvertSerializableToV8Value2 != null && (objConvertSerializableToV8Value2 instanceof V8Value)) {
                        ((V8Value) objConvertSerializableToV8Value2).setWeak();
                    }
                    i++;
                }
            }
            return v8Array2;
        }
        if (obj instanceof Serializable) {
            return new V8JSONProxy(this.v8, (Serializable) obj);
        }
        return null;
    }

    public boolean isToJSONMethod(String str) {
        return "toJSON".equals(str) && this.mV8 != null;
    }

    public V8Function createToJSONFunction(final boolean z) {
        V8Function v8Function = new V8Function(this.mV8, new JavaCallback() { // from class: com.tkruntime.v8.V8JSONProxy.2
            @Override // com.tkruntime.v8.JavaCallback
            public Object invoke(V8Object v8Object, Object[] objArr) {
                if (!z) {
                    return V8JSONProxy.this.mJsonObject.toString();
                }
                if (V8JSONProxy.sGson == null) {
                    Gson unused = V8JSONProxy.sGson = new Gson();
                }
                return V8JSONProxy.sGson.toJson(V8JSONProxy.this.mSerial);
            }
        });
        if (BuildConfig.ENABLE_ANALYZE_PERFORMANCE.booleanValue()) {
            v8Function.setFunctionName("V8JSONProxy_createToJSONFunction");
        }
        return v8Function;
    }

    @Override // com.tkruntime.v8.V8ObjectProxy, com.tkruntime.v8.V8Object
    public Object onPropCall(boolean z, String str, Object obj) {
        if (!z) {
            return PROP_SET_IGNORE;
        }
        beginAnalyzePerformance();
        if (this.mSerial != null) {
            long jNanoTime = System.nanoTime();
            if (isToJSONMethod(str)) {
                V8Function v8FunctionCreateToJSONFunction = createToJSONFunction(true);
                add("toJSON", v8FunctionCreateToJSONFunction);
                getDurationTime(jNanoTime, this.mV8);
                return v8FunctionCreateToJSONFunction;
            }
            ObjectMeta meta = ObjectMeta.getMeta(this.mSerial, this);
            if (meta == null) {
                getDurationTime(jNanoTime, this.mV8);
                endAnalyzePerformance();
                return null;
            }
            Object objConvertSerializableToV8Value = convertSerializableToV8Value(meta.getValue(str, this.mSerial));
            addProp(objConvertSerializableToV8Value, str);
            endAnalyzePerformance();
            getDurationTime(jNanoTime, this.mV8);
            return objConvertSerializableToV8Value;
        }
        try {
            long jNanoTime2 = System.nanoTime();
            if (this.mJsonObject == null) {
                endAnalyzePerformance();
                getDurationTime(jNanoTime2, this.mV8);
                return null;
            }
            if (isToJSONMethod(str)) {
                V8Function v8FunctionCreateToJSONFunction2 = createToJSONFunction(false);
                add("toJSON", v8FunctionCreateToJSONFunction2);
                getDurationTime(jNanoTime2, this.mV8);
                return v8FunctionCreateToJSONFunction2;
            }
            Object objConvertJsonToV8Value = convertJsonToV8Value(this.mJsonObject.get(str));
            addProp(objConvertJsonToV8Value, str);
            endAnalyzePerformance();
            getDurationTime(jNanoTime2, this.mV8);
            return objConvertJsonToV8Value;
        } catch (Exception unused) {
            endAnalyzePerformance();
            return null;
        }
    }

    public void getDurationTime(long j, V8 v8) {
        if (v8 == null) {
            return;
        }
        v8.addPropCallTime((System.nanoTime() - j) / 1000000.0f);
    }

    public void addProp(Object obj, String str) {
        if (obj instanceof V8Value) {
            V8Value v8Value = (V8Value) obj;
            add(str, v8Value);
            v8Value.setWeak();
        } else if (obj == null) {
            addNull(str);
        } else if (isPrimaryOrString(obj)) {
            addPrimaryType(str, obj);
        }
    }

    static class ObjectMeta {
        Class mClz = null;
        Map<String, Field> mFields = null;

        private ObjectMeta() {
        }

        public static boolean isSerializableObject(Object obj) {
            return obj != null && (obj instanceof Serializable);
        }

        public static ObjectMeta tryGetMeta(Object obj) {
            if (!isSerializableObject(obj)) {
                return null;
            }
            return (ObjectMeta) V8JSONProxy.sMetaCache.get(obj.getClass());
        }

        public static void loadMetaAsync(Class cls) {
            if (cls.isPrimitive() || cls == String.class) {
                return;
            }
            if (Looper.myLooper() != Looper.getMainLooper()) {
                if (((ObjectMeta) V8JSONProxy.sMetaCache.get(cls)) != null) {
                    return;
                }
                LinkedList linkedList = new LinkedList();
                linkedList.offer(cls);
                while (!linkedList.isEmpty()) {
                    Class cls2 = (Class) linkedList.poll();
                    if (V8JSONProxy.sMetaCache.get(cls2) == null) {
                        ObjectMeta objectMeta = new ObjectMeta();
                        objectMeta.mClz = cls2;
                        objectMeta.mFields = new HashMap();
                        try {
                            Field[] declaredFields = cls2.getDeclaredFields();
                            if (declaredFields == null) {
                                return;
                            }
                            for (Field field : declaredFields) {
                                field.setAccessible(true);
                                SerializedName serializedName = (SerializedName) field.getAnnotation(SerializedName.class);
                                if (serializedName != null) {
                                    objectMeta.mFields.put(serializedName.value(), field);
                                    if (!field.getType().isPrimitive() && field.getType() != String.class) {
                                        linkedList.offer(field.getType());
                                    }
                                }
                            }
                            V8JSONProxy.sMetaCache.put(cls2, objectMeta);
                        } catch (Exception unused) {
                        }
                    }
                }
                return;
            }
            throw new RuntimeException("can't load meta on main thread");
        }

        public static ObjectMeta getMeta(Object obj, V8JSONProxy v8JSONProxy) {
            if (!isSerializableObject(obj)) {
                return null;
            }
            Class<?> cls = obj.getClass();
            ObjectMeta objectMeta = (ObjectMeta) V8JSONProxy.sMetaCache.get(cls);
            if (objectMeta != null) {
                return objectMeta;
            }
            if (v8JSONProxy.mV8 != null) {
                v8JSONProxy.mV8.addJsonNotLoadNum(1);
            }
            ObjectMeta objectMeta2 = new ObjectMeta();
            objectMeta2.mClz = cls;
            objectMeta2.mFields = new HashMap();
            try {
                Field[] declaredFields = cls.getDeclaredFields();
                if (declaredFields == null) {
                    return null;
                }
                for (Field field : declaredFields) {
                    field.setAccessible(true);
                    SerializedName serializedName = (SerializedName) field.getAnnotation(SerializedName.class);
                    if (serializedName != null) {
                        objectMeta2.mFields.put(serializedName.value(), field);
                    }
                }
                V8JSONProxy.sMetaCache.put(cls, objectMeta2);
                return objectMeta2;
            } catch (Exception unused) {
                return null;
            }
        }

        public Object getValue(String str, Object obj) {
            Field field;
            Map<String, Field> map = this.mFields;
            if (map == null || (field = map.get(str)) == null) {
                return null;
            }
            if (this.mClz != obj.getClass()) {
                throw new RuntimeException("type of ObjectMeta should be " + this.mClz + ", current type = " + obj);
            }
            try {
                return field.get(obj);
            } catch (Exception unused) {
                return null;
            }
        }
    }
}
