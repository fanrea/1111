package com.tkruntime.v8.utils;

import com.tkruntime.v8.NativeObjectWrapper;
import com.tkruntime.v8.V8;
import com.tkruntime.v8.V8Array;
import com.tkruntime.v8.V8ArrayBuffer;
import com.tkruntime.v8.V8Function;
import com.tkruntime.v8.V8JSONProxy;
import com.tkruntime.v8.V8Map;
import com.tkruntime.v8.V8Object;
import com.tkruntime.v8.V8OneTimeObject;
import com.tkruntime.v8.V8TypedArray;
import com.tkruntime.v8.V8Value;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public class V8ObjectUtilsQuick {
    public static V8Object toV8Object(V8 v8, Map<String, ? extends Object> map) {
        return toV8Object(v8, map, null);
    }

    public static V8Array toV8Array(V8 v8, List<? extends Object> list) {
        return toV8Array(v8, list, null);
    }

    public static void pushValue(V8 v8, V8Array v8Array, Object obj) {
        pushValue(v8, v8Array, obj, null);
    }

    public static V8Object toV8Object(V8 v8, Map<String, ? extends Object> map, Map<Object, V8Value> map2) {
        V8Object v8Object = new V8Object(v8);
        try {
            for (Map.Entry<String, ? extends Object> entry : map.entrySet()) {
                setValue(v8, v8Object, entry.getKey(), entry.getValue(), null);
            }
            return v8Object;
        } catch (IllegalStateException e) {
            v8Object.close();
            throw e;
        }
    }

    public static V8Array toV8Array(V8 v8, List<? extends Object> list, Map<Object, V8Value> map) {
        V8Array v8Array = new V8Array(v8);
        for (int i = 0; i < list.size(); i++) {
            try {
                pushValue(v8, v8Array, list.get(i), map);
            } catch (IllegalStateException e) {
                v8Array.close();
                throw e;
            }
        }
        return v8Array;
    }

    public static Object[] toReturnArrayForV8(V8 v8, Boolean bool, Object... objArr) {
        if (objArr == null || objArr.length == 0) {
            return null;
        }
        int length = objArr.length;
        Object[] objArr2 = new Object[length];
        for (int i = 0; i < length; i++) {
            objArr2[i] = toReturnObjectForV8(v8, objArr[i]);
            if (bool != null && (objArr2[i] instanceof String)) {
                bool = Boolean.TRUE;
            }
        }
        return objArr2;
    }

    public static Object toReturnObjectForV8(V8 v8, Object obj) {
        if (obj == null || (obj instanceof Integer) || (obj instanceof Double) || (obj instanceof Long)) {
            return obj;
        }
        if (obj instanceof Float) {
            return Double.valueOf(((Float) obj).doubleValue());
        }
        if ((obj instanceof String) || (obj instanceof Boolean)) {
            return obj;
        }
        if (obj instanceof TypedArray) {
            return toV8TypedArray(v8, (TypedArray) obj, null);
        }
        if (obj instanceof ArrayBuffer) {
            return toV8ArrayBuffer(v8, (ArrayBuffer) obj, null);
        }
        if (obj instanceof V8Value) {
            return obj;
        }
        if (obj instanceof Map) {
            return new V8OneTimeObject(v8, toV8Object(v8, (Map) obj, null).getHandle());
        }
        if (obj instanceof List) {
            return new V8OneTimeObject(v8, toV8Array(v8, (List) obj, null).getHandle());
        }
        if (obj instanceof NativeObjectWrapper) {
            return V8JSONProxy.createProxyForWrapper(v8, (NativeObjectWrapper) obj);
        }
        throw new IllegalStateException("Unsupported Object of type: " + obj.getClass());
    }

    private static void pushValue(V8 v8, V8Array v8Array, Object obj, Map<Object, V8Value> map) {
        if (obj == null) {
            v8Array.pushUndefined();
            return;
        }
        if (obj instanceof Integer) {
            v8Array.push(obj);
            return;
        }
        if (obj instanceof Double) {
            v8Array.push(obj);
            return;
        }
        if (obj instanceof Float) {
            v8Array.push(((Float) obj).doubleValue());
            return;
        }
        if (obj instanceof String) {
            v8Array.push((String) obj);
            return;
        }
        if (obj instanceof Boolean) {
            v8Array.push(obj);
            return;
        }
        if (obj instanceof TypedArray) {
            v8Array.push((V8Value) toV8TypedArray(v8, (TypedArray) obj, map));
            return;
        }
        if (obj instanceof ArrayBuffer) {
            v8Array.push((V8Value) toV8ArrayBuffer(v8, (ArrayBuffer) obj, map));
            return;
        }
        if (obj instanceof V8Value) {
            v8Array.push((V8Value) obj);
            return;
        }
        if (obj instanceof Map) {
            V8Object v8Object = toV8Object(v8, (Map) obj, map);
            v8Array.push((V8Value) v8Object);
            v8Object.setWeak();
        } else if (obj instanceof List) {
            V8Array v8Array2 = toV8Array(v8, (List) obj, map);
            v8Array.push((V8Value) v8Array2);
            v8Array2.setWeak();
        } else if (obj instanceof NativeObjectWrapper) {
            v8Array.push((V8Value) V8JSONProxy.createProxyForWrapper(v8, (NativeObjectWrapper) obj));
        } else {
            throw new IllegalStateException("Unsupported Object of type: " + obj.getClass());
        }
    }

    public static V8TypedArray toV8TypedArray(V8 v8, TypedArray typedArray, Map<Object, V8Value> map) {
        return typedArray.getV8TypedArray();
    }

    public static V8ArrayBuffer toV8ArrayBuffer(V8 v8, ArrayBuffer arrayBuffer, Map<Object, V8Value> map) {
        return arrayBuffer.getV8ArrayBuffer();
    }

    private static void setValue(V8 v8, V8Object v8Object, String str, Object obj, Map<Object, V8Value> map) {
        if (obj == null) {
            v8Object.addUndefined(str);
            return;
        }
        if (obj instanceof Integer) {
            v8Object.add(str, ((Integer) obj).intValue());
            return;
        }
        if (obj instanceof Double) {
            v8Object.add(str, ((Double) obj).doubleValue());
            return;
        }
        if (obj instanceof Float) {
            v8Object.add(str, ((Float) obj).doubleValue());
            return;
        }
        if (obj instanceof String) {
            v8Object.add(str, (String) obj);
            return;
        }
        if (obj instanceof Boolean) {
            v8Object.add(str, ((Boolean) obj).booleanValue());
            return;
        }
        if (obj instanceof TypedArray) {
            v8Object.add(str, toV8TypedArray(v8, (TypedArray) obj, null));
            return;
        }
        if (obj instanceof ArrayBuffer) {
            v8Object.add(str, toV8ArrayBuffer(v8, (ArrayBuffer) obj, null));
            return;
        }
        if (obj instanceof V8Value) {
            v8Object.add(str, (V8Value) obj);
            return;
        }
        if (obj instanceof Map) {
            V8Object v8Object2 = toV8Object(v8, (Map) obj, null);
            v8Object.add(str, v8Object2);
            v8Object2.setWeak();
        } else if (obj instanceof List) {
            V8Array v8Array = toV8Array(v8, (List) obj, null);
            v8Object.add(str, v8Array);
            v8Array.setWeak();
        } else {
            throw new IllegalStateException("Unsupported Object of type: " + obj.getClass());
        }
    }

    private V8ObjectUtilsQuick() {
    }

    public static Object transferV8Value(V8 v8, V8Value v8Value) {
        if (v8Value == null) {
            return null;
        }
        if (v8Value instanceof V8Array) {
            return v8.getList(v8Value.getHandle());
        }
        if (v8Value instanceof V8Map) {
            return v8.getAll(v8Value.getHandle());
        }
        return V8Object.class == v8Value.getClass() ? v8.getAll(v8Value.getHandle()) : v8Value;
    }

    public static Object getValue(Object obj) {
        if (!(obj instanceof V8Value) || (obj instanceof V8Function)) {
            return obj;
        }
        if (obj instanceof V8ArrayBuffer) {
            return new ArrayBuffer((V8ArrayBuffer) obj);
        }
        if (obj instanceof V8TypedArray) {
            return new TypedArray((V8TypedArray) obj);
        }
        if (obj instanceof V8Array) {
            V8Array v8Array = (V8Array) obj;
            return v8Array.v8.getList(v8Array.getHandle());
        }
        if (obj instanceof V8Map) {
            V8Map v8Map = (V8Map) obj;
            return v8Map.v8.getAll(v8Map.getHandle());
        }
        if (obj instanceof V8JSONProxy) {
            return ((V8JSONProxy) obj).getNativeObject();
        }
        if (!(obj instanceof V8Object)) {
            return obj;
        }
        V8Object v8Object = (V8Object) obj;
        return v8Object.v8.getAll(v8Object.getHandle());
    }

    static class DefaultTypeAdapter implements TypeAdapter {
        DefaultTypeAdapter() {
        }

        @Override // com.tkruntime.v8.utils.TypeAdapter
        public Object adapt(int i, Object obj) {
            return TypeAdapter.DEFAULT;
        }
    }
}
