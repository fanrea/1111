package com.sigmob.sdk.videoplayer;

import java.util.HashMap;
import java.util.LinkedHashMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class g {
    public static final String a = "URL_KEY_DEFAULT";
    public int b;
    public LinkedHashMap c;
    public HashMap<String, String> d;
    public boolean e;
    public String title;

    public g(Object url) {
        this.c = new LinkedHashMap();
        this.title = "";
        this.d = new HashMap<>();
        this.e = false;
        this.c.put(a, url);
        this.b = 0;
    }

    public g(String url) {
        this.c = new LinkedHashMap();
        this.title = "";
        this.d = new HashMap<>();
        this.e = false;
        this.c.put(a, url);
        this.b = 0;
    }

    public g(String url, String title) {
        this.c = new LinkedHashMap();
        this.title = "";
        this.d = new HashMap<>();
        this.e = false;
        this.c.put(a, url);
        this.title = title;
        this.b = 0;
    }

    public g(LinkedHashMap urlsMap) {
        this.c = new LinkedHashMap();
        this.title = "";
        this.d = new HashMap<>();
        this.e = false;
        this.c.clear();
        this.c.putAll(urlsMap);
        this.b = 0;
    }

    public g(LinkedHashMap urlsMap, String title) {
        this.c = new LinkedHashMap();
        this.title = "";
        this.d = new HashMap<>();
        this.e = false;
        this.c.clear();
        this.c.putAll(urlsMap);
        this.title = title;
        this.b = 0;
    }

    public Object a() {
        return b(this.b);
    }

    public String a(int index) {
        int i = 0;
        for (Object obj : this.c.keySet()) {
            if (i == index) {
                return obj.toString();
            }
            i++;
        }
        return null;
    }

    public boolean a(Object object) {
        if (object == null) {
            return false;
        }
        return this.c.containsValue(object);
    }

    public Object b() {
        return a(this.b);
    }

    public Object b(int index) {
        int i = 0;
        for (Object obj : this.c.keySet()) {
            if (i == index) {
                return this.c.get(obj);
            }
            i++;
        }
        return null;
    }

    public g c() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.putAll(this.c);
        return new g(linkedHashMap, this.title);
    }
}
