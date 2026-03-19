package io.netty.util;

import io.netty.util.Constant;
import io.netty.util.internal.ObjectUtil;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public abstract class ConstantPool<T extends Constant<T>> {
    private final Map<String, T> constants = new HashMap();
    private int nextId = 1;

    protected abstract T newConstant(int i, String str);

    public T valueOf(Class<?> cls, String str) {
        if (cls == null) {
            throw new NullPointerException("firstNameComponent");
        }
        if (str == null) {
            throw new NullPointerException("secondNameComponent");
        }
        return (T) valueOf(cls.getName() + '#' + str);
    }

    public T valueOf(String str) {
        T t;
        synchronized (this.constants) {
            if (exists(str)) {
                t = this.constants.get(str);
            } else {
                t = (T) newInstance0(str);
            }
        }
        return t;
    }

    public boolean exists(String str) {
        boolean zContainsKey;
        checkNotNullAndNotEmpty(str);
        synchronized (this.constants) {
            zContainsKey = this.constants.containsKey(str);
        }
        return zContainsKey;
    }

    public T newInstance(String str) {
        if (exists(str)) {
            throw new IllegalArgumentException(String.format("'%s' is already in use", str));
        }
        return (T) newInstance0(str);
    }

    private T newInstance0(String str) {
        T t;
        synchronized (this.constants) {
            t = (T) newConstant(this.nextId, str);
            this.constants.put(str, t);
            this.nextId++;
        }
        return t;
    }

    private String checkNotNullAndNotEmpty(String str) {
        ObjectUtil.checkNotNull(str, "name");
        if (str.isEmpty()) {
            throw new IllegalArgumentException("empty name");
        }
        return str;
    }

    @Deprecated
    public final int nextId() {
        int i;
        synchronized (this.constants) {
            i = this.nextId;
            this.nextId++;
        }
        return i;
    }
}
