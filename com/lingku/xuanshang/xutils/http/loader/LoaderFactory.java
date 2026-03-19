package com.lingku.xuanshang.xutils.http.loader;

import java.io.File;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.HashMap;
import lkxssdk.r0.a;
import lkxssdk.r0.b;
import lkxssdk.r0.c;
import lkxssdk.r0.d;
import lkxssdk.r0.e;
import lkxssdk.r0.f;
import lkxssdk.r0.g;
import lkxssdk.r0.h;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class LoaderFactory {
    public static final HashMap<Type, Loader> a;

    static {
        HashMap<Type, Loader> map = new HashMap<>();
        a = map;
        map.put(JSONObject.class, new f());
        map.put(JSONArray.class, new e());
        map.put(String.class, new h());
        map.put(File.class, new FileLoader());
        map.put(byte[].class, new b());
        map.put(InputStream.class, new c());
        a aVar = new a();
        map.put(Boolean.TYPE, aVar);
        map.put(Boolean.class, aVar);
        d dVar = new d();
        map.put(Integer.TYPE, dVar);
        map.put(Integer.class, dVar);
    }

    public static Loader<?> getLoader(Type type) {
        Loader loader = a.get(type);
        return loader == null ? new g(type) : loader.newInstance();
    }

    public static <T> void registerLoader(Type type, Loader<T> loader) {
        a.put(type, loader);
    }
}
