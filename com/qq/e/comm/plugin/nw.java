package com.qq.e.comm.plugin;

import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class nw {
    private static final SharedPreferences a = r1.d().a().getSharedPreferences(gp.a("a8bbc7bfd79e65d1e333a2625cffd14a"), 0);
    private static final String b = "nw";

    private static long b(String str) {
        return new jn(l.a(str)).a().optLong("clickTime");
    }

    public static void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        SharedPreferences.Editor editorEdit = a.edit();
        editorEdit.remove(l.b(str));
        editorEdit.apply();
    }

    public static void a(String str, long j, int i) throws JSONException {
        if (TextUtils.isEmpty(str) || j <= 0) {
            return;
        }
        SharedPreferences sharedPreferences = a;
        HashMap map = new HashMap(sharedPreferences.getAll());
        int size = map.size();
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        if (size >= i) {
            long jA = k20.a(-1);
            for (Map.Entry entry : map.entrySet()) {
                Object value = entry.getValue();
                String str2 = value instanceof String ? (String) value : "";
                String str3 = (String) entry.getKey();
                if (b(str2) < jA) {
                    editorEdit.remove(str3);
                } else if (!q.b(r1.d().a(), l.a(str3))) {
                    editorEdit.remove(str3);
                }
                size--;
            }
        }
        if (size < i) {
            jn jnVar = new jn();
            jnVar.a("clickTime", j);
            editorEdit.putString(l.b(str), l.b(jnVar.toString()));
        }
        editorEdit.apply();
    }

    public static String a() {
        String strA;
        System.currentTimeMillis();
        long jA = k20.a(-1);
        long jA2 = k20.a(0);
        SharedPreferences sharedPreferences = a;
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        Iterator it = new HashMap(sharedPreferences.getAll()).entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                strA = null;
                break;
            }
            Map.Entry entry = (Map.Entry) it.next();
            Object value = entry.getValue();
            String str = value instanceof String ? (String) value : "";
            String str2 = (String) entry.getKey();
            long jB = b(str);
            if (jB >= jA && jB < jA2) {
                strA = l.a(str2);
                if (q.b(r1.d().a(), strA)) {
                    break;
                }
                editorEdit.remove(str2);
            } else if (jB < jA) {
                editorEdit.remove(str2);
            }
        }
        editorEdit.apply();
        System.currentTimeMillis();
        return strA;
    }
}
