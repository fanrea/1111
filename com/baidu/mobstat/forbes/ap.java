package com.baidu.mobstat.forbes;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class ap {
    private static volatile ap b;
    private static OnAppBackgroundListener l;
    private String f;
    private String g;
    private String h;
    private static final Pattern c = Pattern.compile("\\s*|\t|\r|\n");
    private static boolean j = false;
    private static boolean k = false;
    private static boolean m = true;
    private List<PermissionEnum> d = new ArrayList();
    private String e = "android.permission.APP_LIST";
    public final int a = 100;
    private List<JSONObject> i = new ArrayList();

    public static ap a() {
        if (b == null) {
            synchronized (ap.class) {
                if (b == null) {
                    b = new ap();
                }
            }
        }
        return b;
    }

    public String b() {
        if (TextUtils.isEmpty(this.h)) {
            return "";
        }
        return this.h;
    }

    public void a(String str) {
        this.h = str;
    }

    public void b(String str) {
        this.g = str;
    }

    public String c() {
        return TextUtils.isEmpty(this.f) ? "" : ar.a(c.matcher(this.f).replaceAll(""));
    }

    public void c(String str) {
        this.f = str;
    }

    public String a(Context context) {
        return al.a().u(context);
    }

    public void a(Context context, String str) throws JSONException {
        if (this.i == null) {
            return;
        }
        if (this.i.size() == 0) {
            String strA = a(context);
            if (!TextUtils.isEmpty(strA)) {
                try {
                    JSONArray jSONArray = new JSONArray(strA);
                    if (jSONArray.length() > 0) {
                        for (int i = 0; i < jSONArray.length(); i++) {
                            this.i.add(jSONArray.getJSONObject(i));
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        if (this.i.size() >= 100) {
            this.i.remove(0);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(com.baidu.mobads.container.components.h.b.e.a, str);
            jSONObject.put("time", System.currentTimeMillis());
            this.i.add(jSONObject);
            al.a().l(context, this.i.toString());
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public void b(Context context) {
        String strA = a(context);
        if (!TextUtils.isEmpty(strA)) {
            try {
                JSONArray jSONArray = new JSONArray(strA);
                if (jSONArray.length() > 0) {
                    JSONArray jSONArray2 = new JSONArray();
                    jSONArray2.put(jSONArray.getJSONObject(jSONArray.length() - 1));
                    al.a().l(context, jSONArray2.toString());
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        if (this.i != null) {
            this.i.clear();
        }
    }

    public void a(List<PermissionEnum> list) {
        this.d = list;
    }

    public boolean d(String str) {
        if (this.d == null || this.d.size() <= 0) {
            return false;
        }
        for (int i = 0; i < this.d.size(); i++) {
            if ((str.equals("android.permission.ACCESS_FINE_LOCATION") || str.equals(com.kuaishou.weapon.p0.g.h)) && this.d.get(i) == PermissionEnum.LOCATION) {
                return true;
            }
            if (str.equals(this.e) && this.d.get(i) == PermissionEnum.APP_LIST) {
                return true;
            }
            if (str.equals("android.permission.READ_PHONE_STATE") && this.d.get(i) == PermissionEnum.READ_PHONE_STATE) {
                return true;
            }
        }
        return false;
    }

    public String d() {
        return this.e;
    }

    public boolean e() {
        return a(true);
    }

    public boolean a(boolean z) {
        if (z) {
            return j && !g();
        }
        return j;
    }

    public void b(boolean z) {
        j = z;
    }

    private boolean g() {
        if (l != null) {
            return l.isBackground();
        }
        return k;
    }

    public void a(OnAppBackgroundListener onAppBackgroundListener) {
        l = onAppBackgroundListener;
    }

    public boolean f() {
        return m;
    }

    public void c(boolean z) {
        m = z;
    }
}
