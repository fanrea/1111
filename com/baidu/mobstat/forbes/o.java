package com.baidu.mobstat.forbes;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class o {
    private static final o a = new o();
    private HashMap<String, String> b = new HashMap<>();
    private HashMap<Character, Integer> c = new HashMap<>();
    private HashMap<String, String> d = new HashMap<>();
    private HashMap<Character, Integer> e = new HashMap<>();
    private HashMap<String, String> f = new HashMap<>();
    private HashMap<Character, Integer> g = new HashMap<>();

    public static class a {
        public static int a = 0;
        public static int b = 1;
        public static int c = 2;
    }

    public static o a() {
        return a;
    }

    public String a(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (i == a.a) {
            String str2 = this.b.get(str);
            if (TextUtils.isEmpty(str2)) {
                a(str, this.c, this.b);
                return this.b.get(str);
            }
            return str2;
        }
        if (i == a.c) {
            String str3 = this.f.get(str);
            if (TextUtils.isEmpty(str3)) {
                a(str, this.g, this.f);
                return this.f.get(str);
            }
            return str3;
        }
        String str4 = this.d.get(str);
        if (TextUtils.isEmpty(str4)) {
            a(str, this.e, this.d);
            return this.d.get(str);
        }
        return str4;
    }

    private void a(String str, HashMap<Character, Integer> map, HashMap<String, String> map2) {
        int iIntValue = 0;
        char lowerCase = Character.toLowerCase(str.charAt(0));
        Integer num = map.get(Character.valueOf(lowerCase));
        if (num != null) {
            iIntValue = num.intValue() + 1;
        }
        String str2 = Character.toString(lowerCase) + iIntValue;
        map.put(Character.valueOf(lowerCase), Integer.valueOf(iIntValue));
        map2.put(str, str2);
    }

    public JSONObject a(int i) throws JSONException {
        HashMap<String, String> map;
        if (i == a.a) {
            map = this.b;
        } else if (i == a.c) {
            map = this.f;
        } else {
            map = this.d;
        }
        JSONObject jSONObject = new JSONObject();
        if (map == null) {
            return jSONObject;
        }
        ArrayList<Map.Entry> arrayList = new ArrayList(map.entrySet());
        try {
            Collections.sort(arrayList, new Comparator<Map.Entry<String, String>>() { // from class: com.baidu.mobstat.forbes.o.1
                @Override // java.util.Comparator
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public int compare(Map.Entry<String, String> entry, Map.Entry<String, String> entry2) {
                    return entry.getValue().compareTo(entry2.getValue());
                }
            });
        } catch (Exception e) {
        }
        for (Map.Entry entry : arrayList) {
            try {
                jSONObject.put((String) entry.getValue(), (String) entry.getKey());
            } catch (Exception e2) {
            }
        }
        return jSONObject;
    }

    public void b(int i) {
        if (i == a.a) {
            this.c.clear();
            this.b.clear();
        } else if (i == a.c) {
            this.g.clear();
            this.f.clear();
        } else {
            this.e.clear();
            this.d.clear();
        }
    }

    public void b() {
        b(a.a);
        b(a.c);
        b(a.b);
    }
}
