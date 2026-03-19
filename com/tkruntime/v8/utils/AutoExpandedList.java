package com.tkruntime.v8.utils;

import com.tkruntime.v8.V8Value;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public class AutoExpandedList extends ArrayList<Object> {
    public AutoExpandedList() {
    }

    public AutoExpandedList(List list) {
        super(list);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public Object get(int i) {
        Object obj = super.get(i);
        if (!(obj instanceof V8Value)) {
            return obj;
        }
        Object value = V8ObjectUtilsQuick.getValue((V8Value) obj);
        if (value != obj) {
            set(i, value);
        }
        return value;
    }
}
