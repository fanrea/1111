package com.bykv.d.d.d.d;

import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bykv.vk.openvk.api.proto.ValueSet;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Supplier;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d {
    public static final PluginValueSet d = d(0).hc();
    public static final Function<SparseArray<Object>, Object> hc = new C0153d();
    private final SparseArray<Object> b;
    private PluginValueSet c;

    private d(SparseArray<Object> sparseArray, PluginValueSet pluginValueSet) {
        this.b = sparseArray;
        this.c = pluginValueSet;
    }

    private d(SparseArray<Object> sparseArray) {
        this.b = sparseArray == null ? new SparseArray<>() : sparseArray;
    }

    public static final d d() {
        return new d(new SparseArray());
    }

    public static final d d(int i) {
        return new d(new SparseArray(i));
    }

    public static final d d(SparseArray<Object> sparseArray) {
        return new d(sparseArray);
    }

    public static final d d(PluginValueSet pluginValueSet) {
        return new d(new SparseArray(), pluginValueSet);
    }

    public d d(int i, Object obj) {
        this.b.put(i, obj);
        return this;
    }

    public d d(int i, String str) {
        this.b.put(i, str);
        return this;
    }

    public d d(int i, int i2) {
        this.b.put(i, Integer.valueOf(i2));
        return this;
    }

    public d d(int i, double d2) {
        this.b.put(i, Double.valueOf(d2));
        return this;
    }

    public d d(int i, boolean z) {
        this.b.put(i, Boolean.valueOf(z));
        return this;
    }

    public d d(int i, float f) {
        this.b.put(i, Float.valueOf(f));
        return this;
    }

    public PluginValueSet hc() {
        return new hc(this.b, this.c);
    }

    /* renamed from: com.bykv.d.d.d.d.d$d, reason: collision with other inner class name */
    private static final class C0153d<T, R> implements Function<T, R> {
        private C0153d() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.function.Function
        public R apply(T t) {
            if (!(t instanceof SparseArray)) {
                return null;
            }
            Class cls = (Class) ((SparseArray) t).get(-99999985);
            if (cls != Boolean.class && cls != Boolean.TYPE) {
                if (cls != Integer.TYPE && cls != Integer.class) {
                    if (cls != Long.TYPE && cls != Long.class) {
                        if (cls != Double.TYPE && cls != Double.class) {
                            if (cls == Float.TYPE || cls == Float.class) {
                                return (R) Float.valueOf(0.0f);
                            }
                            return null;
                        }
                        return (R) Double.valueOf(0.0d);
                    }
                    return (R) 0L;
                }
                return (R) 0;
            }
            return (R) Boolean.FALSE;
        }
    }

    private static final class hc implements PluginValueSet {
        private int b;
        private final SparseArray<Object> d;
        private PluginValueSet hc;

        private hc(SparseArray<Object> sparseArray, PluginValueSet pluginValueSet) {
            this.b = -1;
            this.d = sparseArray;
            this.hc = pluginValueSet;
        }

        @Override // com.bykv.vk.openvk.api.proto.PluginValueSet
        public <T> T[] arrayValue(int i, Class<T> cls) {
            Object obj = this.d.get(i);
            if (obj == null) {
                PluginValueSet pluginValueSet = this.hc;
                if (pluginValueSet != null) {
                    return (T[]) pluginValueSet.arrayValue(i, cls);
                }
                return null;
            }
            Class<?> cls2 = obj.getClass();
            if (cls2.isArray() && cls.isAssignableFrom(cls2.getComponentType())) {
                return (T[]) ((Object[]) obj);
            }
            return null;
        }

        private boolean d() {
            return com.bykv.d.d().hc() >= 6803 && com.bykv.d.d().hc() < 7000;
        }

        private boolean d(Object obj) {
            return d() ? (!(obj instanceof Supplier) || (obj instanceof Function) || (obj instanceof ValueSet)) ? false : true : (obj instanceof Supplier) && !(obj instanceof Function);
        }

        @Override // com.bykv.vk.openvk.api.proto.PluginValueSet
        public <T> T objectValue(int i, Class<T> cls) {
            Supplier supplier = (T) this.d.get(i);
            if (supplier == null) {
                PluginValueSet pluginValueSet = this.hc;
                if (pluginValueSet != null) {
                    return (T) pluginValueSet.objectValue(i, cls);
                }
                return null;
            }
            if (d(supplier)) {
                supplier = (T) supplier.get();
            }
            if (cls.isInstance(supplier)) {
                return (T) supplier;
            }
            return null;
        }

        @Override // com.bykv.vk.openvk.api.proto.PluginValueSet
        public String stringValue(int i) {
            return stringValue(i, null);
        }

        @Override // com.bykv.vk.openvk.api.proto.PluginValueSet
        public int intValue(int i) {
            return intValue(i, 0);
        }

        @Override // com.bykv.vk.openvk.api.proto.PluginValueSet
        public boolean booleanValue(int i) {
            return booleanValue(i, false);
        }

        @Override // com.bykv.vk.openvk.api.proto.PluginValueSet
        public long longValue(int i) {
            return longValue(i, 0L);
        }

        @Override // com.bykv.vk.openvk.api.proto.PluginValueSet
        public float floatValue(int i) {
            return floatValue(i, 0.0f);
        }

        @Override // com.bykv.vk.openvk.api.proto.PluginValueSet
        public double doubleValue(int i) {
            PluginValueSet pluginValueSet;
            Object obj = this.d.get(i);
            if (obj == null && (pluginValueSet = this.hc) != null) {
                return pluginValueSet.doubleValue(i);
            }
            if (obj instanceof Supplier) {
                obj = ((Supplier) obj).get();
            }
            if (obj instanceof Double) {
                return ((Double) obj).doubleValue();
            }
            return 0.0d;
        }

        @Override // com.bykv.vk.openvk.api.proto.PluginValueSet
        public String stringValue(int i, String str) {
            PluginValueSet pluginValueSet;
            Object obj = this.d.get(i);
            if (obj == null && (pluginValueSet = this.hc) != null) {
                return pluginValueSet.stringValue(i, str);
            }
            if (obj instanceof Supplier) {
                obj = ((Supplier) obj).get();
            }
            return obj instanceof String ? obj.toString() : str;
        }

        @Override // com.bykv.vk.openvk.api.proto.PluginValueSet
        public int intValue(int i, int i2) {
            PluginValueSet pluginValueSet;
            Object obj = this.d.get(i);
            if (obj == null && (pluginValueSet = this.hc) != null) {
                return pluginValueSet.intValue(i, i2);
            }
            if (obj instanceof Supplier) {
                obj = ((Supplier) obj).get();
            }
            return obj instanceof Integer ? ((Integer) obj).intValue() : i2;
        }

        @Override // com.bykv.vk.openvk.api.proto.PluginValueSet
        public boolean booleanValue(int i, boolean z) {
            PluginValueSet pluginValueSet;
            Object obj = this.d.get(i);
            if (obj == null && (pluginValueSet = this.hc) != null) {
                return pluginValueSet.booleanValue(i, z);
            }
            if (obj instanceof Supplier) {
                obj = ((Supplier) obj).get();
            }
            return obj instanceof Boolean ? ((Boolean) obj).booleanValue() : z;
        }

        @Override // com.bykv.vk.openvk.api.proto.PluginValueSet
        public long longValue(int i, long j) {
            PluginValueSet pluginValueSet;
            Object obj = this.d.get(i);
            if (obj == null && (pluginValueSet = this.hc) != null) {
                return pluginValueSet.longValue(i, j);
            }
            if (obj instanceof Supplier) {
                obj = ((Supplier) obj).get();
            }
            return obj instanceof Long ? ((Long) obj).longValue() : j;
        }

        @Override // com.bykv.vk.openvk.api.proto.PluginValueSet
        public float floatValue(int i, float f) {
            PluginValueSet pluginValueSet;
            Object obj = this.d.get(i);
            if (obj == null && (pluginValueSet = this.hc) != null) {
                return pluginValueSet.floatValue(i, f);
            }
            if (obj instanceof Supplier) {
                obj = ((Supplier) obj).get();
            }
            return obj instanceof Float ? ((Float) obj).floatValue() : f;
        }

        @Override // com.bykv.vk.openvk.api.proto.PluginValueSet
        public boolean containsKey(int i) {
            PluginValueSet pluginValueSet;
            int iIndexOfKey = this.d.indexOfKey(i);
            if (iIndexOfKey >= 0 || (pluginValueSet = this.hc) == null) {
                return iIndexOfKey >= 0;
            }
            return pluginValueSet.containsKey(i);
        }

        @Override // com.bykv.vk.openvk.api.proto.PluginValueSet
        public Set<Integer> keys() {
            int size = this.d.size();
            HashSet hashSet = new HashSet();
            for (int i = 0; i < size; i++) {
                hashSet.add(Integer.valueOf(this.d.keyAt(i)));
            }
            PluginValueSet pluginValueSet = this.hc;
            if (pluginValueSet != null) {
                hashSet.addAll(pluginValueSet.keys());
            }
            this.b = hashSet.size();
            return hashSet;
        }

        @Override // com.bykv.vk.openvk.api.proto.PluginValueSet
        public boolean isEmpty() {
            return size() <= 0;
        }

        @Override // com.bykv.vk.openvk.api.proto.PluginValueSet
        public int size() {
            if (this.b < 0) {
                keys();
            }
            return this.b;
        }

        private boolean hc() {
            if (this.d instanceof com.bytedance.sdk.openadsdk.w.hc.d) {
                return true;
            }
            PluginValueSet pluginValueSet = this.hc;
            return pluginValueSet != null && (pluginValueSet.sparseArray() instanceof com.bytedance.sdk.openadsdk.w.hc.d);
        }

        @Override // com.bykv.vk.openvk.api.proto.PluginValueSet
        public SparseArray<Object> sparseArray() {
            SparseArray<Object> sparseArray;
            if (com.bykv.d.d().hc() < 6803 && hc()) {
                return new com.bytedance.sdk.openadsdk.w.hc.d(this);
            }
            SparseArray<Object> sparseArray2 = new SparseArray<>();
            PluginValueSet pluginValueSet = this.hc;
            if (pluginValueSet != null && (sparseArray = pluginValueSet.sparseArray()) != null && sparseArray.size() > 0) {
                for (int i = 0; i < sparseArray.size(); i++) {
                    sparseArray2.put(sparseArray.keyAt(i), sparseArray.valueAt(i));
                }
            }
            SparseArray<Object> sparseArray3 = this.d;
            if (sparseArray3 != null && sparseArray3.size() > 0) {
                for (int i2 = 0; i2 < this.d.size(); i2++) {
                    sparseArray2.put(this.d.keyAt(i2), this.d.valueAt(i2));
                }
            }
            return sparseArray2;
        }

        @Override // com.bykv.vk.openvk.api.proto.PluginValueSet
        public void remove(int i) {
            this.d.remove(i);
        }
    }
}
