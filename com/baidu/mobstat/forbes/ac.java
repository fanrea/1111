package com.baidu.mobstat.forbes;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class ac {
    private boolean a;
    private List<b> b = new ArrayList();
    private String c;
    private af d;
    private boolean e;

    public interface a {
        void a(View view, boolean z);
    }

    public ac(Activity activity, af afVar, boolean z) {
        this.c = activity.getClass().getName();
        this.d = afVar;
        this.e = z;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            this.a = ((JSONObject) jSONObject.get("meta")).getInt("matchAll") != 0;
        } catch (Exception e) {
        }
        if (this.a) {
            return;
        }
        try {
            JSONArray jSONArray = (JSONArray) jSONObject.get("data");
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObject2 = (JSONObject) jSONArray.get(i);
                String strOptString = jSONObject2.optString("page");
                String strOptString2 = jSONObject2.optString("layout");
                int iOptInt = jSONObject2.optInt("contentAsLabel");
                boolean z = jSONObject2.optInt("ignoreCellIndex") != 0;
                if (this.c.equals(strOptString)) {
                    this.b.add(new b(strOptString, strOptString2, z, iOptInt));
                }
            }
        } catch (Exception e2) {
        }
    }

    public void a(Activity activity) {
        if (!this.e && !this.a && (this.b == null || this.b.size() == 0)) {
            return;
        }
        View viewA = ae.a(activity);
        a(activity, viewA, null, viewA);
    }

    private void a(Activity activity, View view, c cVar, View view2) {
        if (view == null || e.a(view) || ae.c(activity, view)) {
            return;
        }
        c cVar2 = new c(view, cVar, view2);
        if (cVar != null) {
            boolean zB = this.a ? ae.b(view, cVar2.c()) : a(this.b, cVar2.a(), cVar2.b());
            if (zB || this.e) {
                if (w.c().b() && zB) {
                    w.c().a("accumulate view:" + view.getClass().getName() + "; content:" + ae.h(view));
                }
                if (aa.c().b()) {
                    aa.c().a("accumulate view:" + view.getClass().getName() + "; content:" + ae.h(view));
                }
                this.d.a(view, zB);
            }
        }
        if (!(view instanceof WebView) && (view instanceof ViewGroup)) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                a(activity, viewGroup.getChildAt(i), cVar2, view2);
            }
        }
    }

    private boolean a(List<b> list, String str, String str2) {
        for (b bVar : list) {
            String str3 = bVar.c ? str2 : str;
            if (!TextUtils.isEmpty(str3) && str3.equals(bVar.b)) {
                return true;
            }
        }
        return false;
    }

    public class b {
        public String a;
        public String b;
        public boolean c;
        public int d;

        public b(String str, String str2, boolean z, int i) {
            this.a = str;
            this.b = str2;
            this.c = z;
            this.d = i;
        }
    }

    static class c {
        public String a;
        public String b;
        public String c;
        public c d;

        public c(View view, c cVar, View view2) throws ClassNotFoundException {
            this.d = cVar;
            this.a = ae.l(view);
            this.b = ae.b(view);
            String strC = ae.c(view);
            if (TextUtils.isEmpty(strC)) {
                strC = ae.a(view, c());
                if (TextUtils.isEmpty(strC)) {
                    strC = ae.a(view, view2);
                }
            }
            this.c = strC;
        }

        public String a() {
            StringBuilder sb = new StringBuilder();
            for (c cVar = this; cVar != null; cVar = cVar.d) {
                sb.insert(0, cVar.a(false));
            }
            return sb.toString();
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x002f  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.String b() {
            /*
                r6 = this;
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                r1 = 0
                r3 = 0
                r2 = r6
            La:
                if (r2 == 0) goto L3c
            Ld:
                if (r3 != 0) goto L2f
                java.lang.String r4 = r2.c()
                java.lang.String r5 = "ListView"
                boolean r5 = r5.equals(r4)
                if (r5 != 0) goto L2b
                java.lang.String r5 = "RecyclerView"
                boolean r5 = r5.equals(r4)
                if (r5 != 0) goto L2b
                java.lang.String r5 = "GridView"
                boolean r4 = r5.equals(r4)
                if (r4 == 0) goto L2f
            L2b:
            L2c:
                r3 = 1
                r4 = 1
                goto L31
            L2f:
                r4 = r3
                r3 = 0
            L31:
                java.lang.String r3 = r2.a(r3)
                r0.insert(r1, r3)
                com.baidu.mobstat.forbes.ac$c r2 = r2.d
                r3 = r4
                goto La
            L3c:
                java.lang.String r0 = r0.toString()
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobstat.forbes.ac.c.b():java.lang.String");
        }

        public String a(boolean z) {
            StringBuilder sb = new StringBuilder();
            sb.append("/");
            sb.append(this.a);
            if (!z) {
                sb.append("[");
                sb.append(this.c);
                sb.append("]");
            }
            return sb.toString();
        }

        public String c() {
            return this.d == null ? "" : this.d.b;
        }
    }
}
