package com.duoyou.task.sdk.xutils.http.loader;

import java.io.File;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public final class LoaderFactory {
    private static final HashMap<Type, Loader> converterHashMap;

    private LoaderFactory() {
    }

    static {
        HashMap<Type, Loader> map = new HashMap<>();
        converterHashMap = map;
        map.put(JSONObject.class, new JSONObjectLoader());
        map.put(JSONArray.class, new JSONArrayLoader());
        map.put(String.class, new StringLoader());
        map.put(File.class, new FileLoader());
        map.put(byte[].class, new ByteArrayLoader());
        map.put(InputStream.class, new InputStreamLoader());
        BooleanLoader booleanLoader = new BooleanLoader();
        map.put(Boolean.TYPE, booleanLoader);
        map.put(Boolean.class, booleanLoader);
        IntegerLoader integerLoader = new IntegerLoader();
        map.put(Integer.TYPE, integerLoader);
        map.put(Integer.class, integerLoader);
    }

    public static Loader<?> getLoader(Type type) {
        Loader loader = converterHashMap.get(type);
        if (loader == null) {
            return new ObjectLoader(type);
        }
        return loader.newInstance();
    }

    public static <T> void registerLoader(Type type, Loader<T> loader) {
        converterHashMap.put(type, loader);
    }
}
