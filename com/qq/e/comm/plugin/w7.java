package com.qq.e.comm.plugin;

import android.os.Build;
import com.qq.e.comm.plugin.a8;
import com.qq.e.comm.plugin.s6;
import com.qq.e.comm.plugin.x7;
import com.qq.e.comm.plugin.y7;
import com.qq.e.comm.plugin.z7;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class w7 {
    static final boolean c;
    private static final Map<Integer, x7.a> d;
    private Map<String, y7> a;
    private List<x7> b;

    static {
        c = Build.VERSION.SDK_INT > 21 && r1.d().f().a("dlans", 1) == 1;
        HashMap map = new HashMap(10);
        d = map;
        map.put(1, new n2());
        map.put(2, new s6.b());
        map.put(3, new cy());
        map.put(4, new ex(ex.c));
        map.put(5, new w20());
        map.put(6, new m5());
        map.put(7, new l5());
        map.put(8, new s6.c());
        map.put(9, new ex(ex.d));
        map.put(10, new ex(ex.e));
        map.put(11, new di());
        map.put(12, new w50());
        map.put(13, new pi());
    }

    public y7 a(String str) {
        Map<String, y7> map = this.a;
        if (map == null) {
            return null;
        }
        return map.get(str);
    }

    public void c() {
        Map<String, y7> map = this.a;
        if (map == null || map.size() == 0) {
            return;
        }
        Iterator<Map.Entry<String, y7>> it = this.a.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().pause();
        }
    }

    public void d() {
        Map<String, y7> map = this.a;
        if (map == null || map.size() == 0) {
            return;
        }
        Iterator<Map.Entry<String, y7>> it = this.a.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().resume();
        }
    }

    public void b() {
        List<x7> list = this.b;
        if (list == null || list.size() == 0) {
            return;
        }
        HashMap map = new HashMap();
        for (x7 x7Var : this.b) {
            String str = x7Var.a.b;
            y7.a bVar = (y7.a) map.get(str);
            if (bVar == null) {
                bVar = c ? new a8.b(str) : new z7.b(str);
                map.put(str, bVar);
            }
            bVar.a(x7Var);
        }
        HashMap map2 = new HashMap(map.size());
        for (Map.Entry entry : map.entrySet()) {
            map2.put(entry.getKey(), ((y7.a) entry.getValue()).a());
        }
        this.a = map2;
        this.b = null;
    }

    public void a() {
        y7 value;
        Map<String, y7> map = this.a;
        if (map == null || map.size() <= 0) {
            return;
        }
        for (Map.Entry<String, y7> entry : this.a.entrySet()) {
            if (entry != null && (value = entry.getValue()) != null) {
                value.cancel();
            }
        }
    }

    public void a(s2[] s2VarArr, w40 w40Var) {
        if (s2VarArr == null || s2VarArr.length <= 0 || w40Var == null) {
            return;
        }
        if (this.b == null) {
            this.b = new LinkedList();
        }
        for (s2 s2Var : s2VarArr) {
            x7.a aVar = d.get(Integer.valueOf(s2Var.a));
            if (aVar != null) {
                if (t30.a(s2Var.b())) {
                    w40Var.a(s2Var);
                }
                x7 x7VarA = aVar.a(s2Var, w40Var);
                if (x7VarA != null) {
                    this.b.add(x7VarA);
                }
            }
        }
    }
}
