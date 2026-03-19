package com.baidu.mobads.container.o;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.container.util.au;
import com.baidu.mobads.container.util.bw;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class e {
    public static final int a = 0;
    public static final int b = 408;
    public static final int c = 999;
    public static final int d = 502;
    public static final int e = 404;
    public static final String f = "failreqrea";
    public static final String g = "failreqtim";
    public static final String h = "timeout";
    private static final String i = "rqst/";
    private static e j;
    private final String k;
    private final Map<String, ConcurrentLinkedQueue<a>> l = new HashMap();
    private final Map<String, String> m = new HashMap();

    public @interface b {
    }

    public @interface c {
    }

    private e(Context context) {
        this.k = bw.j(context) + i;
        if (!com.baidu.mobads.container.h.a.a().E()) {
            return;
        }
        com.baidu.mobads.container.d.b.a().a(new f(this));
    }

    public static e a(Context context) {
        if (j == null) {
            synchronized (e.class) {
                if (j == null && context != null) {
                    j = new e(context.getApplicationContext());
                }
            }
        }
        return j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(File[] fileArr) throws IOException {
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        for (File file : fileArr) {
            if (file.isFile() && file.exists()) {
                String name = file.getName();
                if (!TextUtils.isEmpty(name)) {
                    String strSubstring = name.substring(0, name.length() - 1);
                    if (name.endsWith("0")) {
                        map2.put(strSubstring, a(file));
                    } else if (name.endsWith("1")) {
                        map.put(strSubstring, a(file));
                    }
                    au.h(file);
                }
            }
        }
        for (String str : map.keySet()) {
            List list = (List) map.get(str);
            List list2 = (List) map2.get(str);
            if (list != null && list2 != null && list.size() == list2.size()) {
                for (int i2 = 0; i2 < list.size(); i2++) {
                    a(str, ((Integer) list.get(i2)).intValue(), ((Integer) list2.get(i2)).intValue());
                }
            }
        }
    }

    private List<Integer> a(File file) {
        ArrayList arrayList = new ArrayList();
        for (String str : au.g(file).split(",")) {
            try {
                arrayList.add(Integer.valueOf(Integer.parseInt(str)));
            } catch (NumberFormatException e2) {
                arrayList.clear();
            }
        }
        return arrayList;
    }

    public void a(String str, int i2, long j2) {
        if (!com.baidu.mobads.container.h.a.a().E()) {
            return;
        }
        ConcurrentLinkedQueue<a> concurrentLinkedQueue = this.l.get(str);
        if (concurrentLinkedQueue == null) {
            concurrentLinkedQueue = new ConcurrentLinkedQueue<>();
            this.l.put(str, concurrentLinkedQueue);
        }
        if (concurrentLinkedQueue.size() >= 10) {
            return;
        }
        concurrentLinkedQueue.add(new a(i2, j2));
        if (concurrentLinkedQueue.size() % 5 == 0) {
            com.baidu.mobads.container.d.b.a().a(new g(this, str));
        }
        if (TextUtils.equals("rsplash", str)) {
            com.baidu.mobads.container.d.b.a().a(new h(this, str), 3L, TimeUnit.SECONDS);
        }
    }

    public void a(String str, String str2) {
        if (!com.baidu.mobads.container.h.a.a().E()) {
            return;
        }
        this.m.put(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String b(String str, String str2) {
        if (TextUtils.equals(str2, "timeout")) {
            return this.m.get(str) == null ? "" : this.m.get(str);
        }
        ConcurrentLinkedQueue<a> concurrentLinkedQueue = this.l.get(str);
        if (concurrentLinkedQueue == null || concurrentLinkedQueue.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Iterator<a> it = concurrentLinkedQueue.iterator();
        while (it.hasNext()) {
            a next = it.next();
            if (TextUtils.equals(str2, f)) {
                sb.append(next.a).append(",");
            } else if (TextUtils.equals(str2, g)) {
                sb.append(next.b).append(",");
            }
        }
        return sb.toString();
    }

    public HashMap<String, String> a(String str) {
        ConcurrentLinkedQueue<a> concurrentLinkedQueue;
        HashMap<String, String> map = new HashMap<>();
        if (!com.baidu.mobads.container.h.a.a().E() || (concurrentLinkedQueue = this.l.get(str)) == null || concurrentLinkedQueue.isEmpty()) {
            return map;
        }
        String strB = b(str, f);
        String strB2 = b(str, g);
        String strB3 = b(str, "timeout");
        if (!strB.isEmpty() && !strB2.isEmpty()) {
            map.put(f, strB.substring(0, strB.length() - 1));
            map.put(g, strB2.substring(0, strB2.length() - 1));
        }
        map.put("timeout", strB3);
        concurrentLinkedQueue.clear();
        com.baidu.mobads.container.d.b.a().a(new i(this, str));
        return map;
    }

    public static class a {
        public int a;
        public long b;

        public a(int i, long j) {
            this.a = i;
            this.b = j;
        }
    }
}
