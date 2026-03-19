package com.kuaishou.tk.export;

import com.tkruntime.v8.V8Function;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public interface IStorage {
    void clear();

    Map<String, Object> getAll();

    void getItem(String str, V8Function v8Function);

    void removeItem(String str);

    void setItem(String str, Object obj, V8Function v8Function);
}
