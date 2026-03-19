package com.bytedance.sdk.component.panglearmor.hc;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.sdk.component.panglearmor.SoftDecTool;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class hc {
    private static volatile hc d;
    private long an;
    private LinkedList<JSONObject> b;
    private LinkedList<JSONObject> c;
    private SharedPreferences hc;
    private LinkedList<JSONObject> u;

    public hc() {
        this.hc = null;
        this.b = null;
        this.c = null;
        this.u = null;
        this.an = 0L;
        this.hc = SoftDecTool.getSharedPreferences("pithar");
        this.b = b("sp_angle");
        this.c = b("sp_screen");
        this.u = b("sp_net");
        this.an = u.d().b() / u.d().c();
    }

    public static hc d() {
        if (d == null) {
            synchronized (hc.class) {
                if (d == null) {
                    d = new hc();
                }
            }
        }
        return d;
    }

    public LinkedList<JSONObject> d(String str) {
        if ("sp_angle".equals(str)) {
            return this.b;
        }
        if ("sp_screen".equals(str)) {
            return this.c;
        }
        if ("sp_net".equals(str)) {
            return this.u;
        }
        return null;
    }

    public void d(JSONObject jSONObject, String str) {
        LinkedList<JSONObject> linkedListD = d(str);
        if (linkedListD == null) {
            return;
        }
        linkedListD.add(jSONObject);
        if (linkedListD.size() > this.an) {
            linkedListD.removeFirst();
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        long jB = jCurrentTimeMillis - u.d().b();
        JSONObject jSONObject2 = null;
        Iterator<JSONObject> it = linkedListD.iterator();
        while (it.hasNext()) {
            JSONObject next = it.next();
            long jOptLong = next.optLong("t", 0L);
            if (jOptLong < jB) {
                it.remove();
                jSONObject2 = next;
            } else if (jOptLong > jCurrentTimeMillis) {
                it.remove();
            }
        }
        if (jSONObject2 != null && linkedListD.size() < 2) {
            linkedListD.addFirst(jSONObject2);
        }
        d(str, linkedListD);
    }

    public synchronized void hc(String str) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if ("android.intent.action.SCREEN_OFF".equals(str)) {
            LinkedList<JSONObject> linkedListD = d("sp_screen");
            int iOptInt = 1;
            if (linkedListD != null && linkedListD.size() > 0) {
                JSONObject last = linkedListD.getLast();
                if (last.optLong("t", 0L) / 3600000 == jCurrentTimeMillis / 3600000) {
                    iOptInt = 1 + last.optInt("val", 0);
                    linkedListD.removeLast();
                }
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("t", jCurrentTimeMillis);
                jSONObject.put("val", iOptInt);
                d(jSONObject, "sp_screen");
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public synchronized void d(int i) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        int iOptInt = i == 4 ? 1 : i > 0 ? 2 : 0;
        LinkedList<JSONObject> linkedListD = d("sp_net");
        if (linkedListD != null && linkedListD.size() > 0) {
            JSONObject last = linkedListD.getLast();
            if (last.optLong("t", 0L) / 3600000 == jCurrentTimeMillis / 3600000) {
                iOptInt |= last.optInt("val", 0);
                linkedListD.removeLast();
            }
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("t", jCurrentTimeMillis);
            jSONObject.put("val", iOptInt);
            d(jSONObject, "sp_net");
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    private LinkedList<JSONObject> b(String str) {
        LinkedList<JSONObject> linkedList = new LinkedList<>();
        SharedPreferences sharedPreferences = this.hc;
        if (sharedPreferences == null) {
            return linkedList;
        }
        String string = sharedPreferences.getString(str, "");
        if (!TextUtils.isEmpty(string)) {
            for (String str2 : string.split("\\|")) {
                if (!TextUtils.isEmpty(str2)) {
                    try {
                        linkedList.add(new JSONObject(str2));
                    } catch (Exception unused) {
                    }
                }
            }
        }
        return linkedList;
    }

    public void d(String str, LinkedList<JSONObject> linkedList) {
        if (linkedList == null || this.hc == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        Iterator<JSONObject> it = linkedList.iterator();
        while (it.hasNext()) {
            sb.append(it.next().toString());
            sb.append("\\|");
        }
        SharedPreferences.Editor editorEdit = this.hc.edit();
        editorEdit.putString(str, sb.toString());
        editorEdit.apply();
    }

    public LinkedList<JSONObject> d(long j) {
        if (j == 0) {
            return this.b;
        }
        LinkedList<JSONObject> linkedList = new LinkedList<>();
        long jCurrentTimeMillis = System.currentTimeMillis();
        JSONObject jSONObject = null;
        Iterator<JSONObject> it = this.b.iterator();
        while (it.hasNext()) {
            JSONObject next = it.next();
            if (jCurrentTimeMillis - next.optLong("t", 0L) < j) {
                linkedList.add(next);
            } else {
                jSONObject = next;
            }
        }
        if (jSONObject != null && linkedList.size() < 2) {
            linkedList.addFirst(jSONObject);
        }
        return linkedList;
    }
}
