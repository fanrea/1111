package com.qq.e.comm.plugin;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import java.io.ByteArrayOutputStream;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import yaq.pro;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class zv {
    private static final AtomicLong a = new AtomicLong(0);
    private static final AtomicLong b = new AtomicLong(60000);
    private static Pair<Integer, Integer> c;

    /* compiled from: A */
    public interface e {
        boolean a(h4 h4Var, String str);
    }

    public static Bitmap a(View view) {
        return (Bitmap) pro.getobjresult(525, 1, view);
    }

    /* compiled from: A */
    class a implements Runnable {
        final /* synthetic */ WeakReference a;
        final /* synthetic */ h4 b;

        a(WeakReference weakReference, h4 h4Var) {
            this.a = weakReference;
            this.b = h4Var;
        }

        @Override // java.lang.Runnable
        public void run() throws JSONException {
            View view = (View) this.a.get();
            if (view == null) {
                return;
            }
            if (zv.c == null) {
                Pair unused = zv.c = pa.b();
            }
            b10.a(1402003, f5.a(this.b), null, null, new ja().a("w", Integer.valueOf(view.getWidth())).a("h", Integer.valueOf(view.getHeight())).a("dh", zv.c.first).a("dw", zv.c.second));
        }
    }

    /* compiled from: A */
    class b implements Runnable {
        final /* synthetic */ int a;
        final /* synthetic */ String b;
        final /* synthetic */ h4 c;
        final /* synthetic */ e d;
        final /* synthetic */ WeakReference e;
        final /* synthetic */ String f;
        final /* synthetic */ WeakReference g;

        b(int i, String str, h4 h4Var, e eVar, WeakReference weakReference, String str2, WeakReference weakReference2) {
            this.a = i;
            this.b = str;
            this.c = h4Var;
            this.d = eVar;
            this.e = weakReference;
            this.f = str2;
            this.g = weakReference2;
        }

        /* JADX WARN: Removed duplicated region for block: B:16:0x0055 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:17:0x0056  */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() {
            /*
                r12 = this;
                java.lang.String r0 = ""
                int r1 = r12.a
                r2 = 60
                org.json.JSONObject r3 = new org.json.JSONObject     // Catch: org.json.JSONException -> L4c
                java.lang.String r4 = r12.b     // Catch: org.json.JSONException -> L4c
                r3.<init>(r4)     // Catch: org.json.JSONException -> L4c
                java.lang.String r4 = "quality"
                int r4 = r3.optInt(r4)     // Catch: org.json.JSONException -> L4c
                java.lang.String r5 = "task_id"
                java.lang.String r5 = r3.optString(r5)     // Catch: org.json.JSONException -> L4a
                java.lang.String r6 = "tid"
                java.lang.String r0 = r3.optString(r6)     // Catch: org.json.JSONException -> L46
                java.lang.String r6 = "cover_limit"
                int r6 = r3.optInt(r6, r2)     // Catch: org.json.JSONException -> L46
                java.util.concurrent.atomic.AtomicLong r7 = com.qq.e.comm.plugin.zv.b()     // Catch: org.json.JSONException -> L42
                java.lang.String r8 = "period"
                r9 = 1
                int r8 = r3.optInt(r8, r9)     // Catch: org.json.JSONException -> L42
                int r8 = r8 * 60
                long r8 = (long) r8     // Catch: org.json.JSONException -> L42
                r10 = 1000(0x3e8, double:4.94E-321)
                long r8 = r8 * r10
                r7.set(r8)     // Catch: org.json.JSONException -> L42
                java.lang.String r2 = "delay_time"
                int r1 = r3.optInt(r2, r1)     // Catch: org.json.JSONException -> L42
                r8 = r1
                goto L53
            L42:
                r2 = r0
                r0 = r5
                goto L50
            L46:
                r2 = r0
                r0 = r5
                goto L4e
            L4a:
                goto L4d
            L4c:
                r4 = 0
            L4d:
                r2 = r0
            L4e:
                r6 = 60
            L50:
                r5 = r0
                r8 = r1
                r0 = r2
            L53:
                if (r4 > 0) goto L56
                return
            L56:
                boolean r1 = android.text.TextUtils.isEmpty(r0)
                if (r1 != 0) goto L69
                com.qq.e.comm.plugin.h4 r1 = r12.c
                java.lang.String r1 = r1.O0()
                boolean r0 = r0.equals(r1)
                if (r0 != 0) goto L69
                return
            L69:
                com.qq.e.comm.plugin.zv$e r0 = r12.d
                if (r0 == 0) goto L76
                com.qq.e.comm.plugin.h4 r1 = r12.c
                boolean r0 = r0.a(r1, r5)
                if (r0 == 0) goto L76
                return
            L76:
                java.lang.ref.WeakReference r1 = r12.e
                com.qq.e.comm.plugin.h4 r2 = r12.c
                java.lang.String r3 = r12.f
                java.lang.ref.WeakReference r7 = r12.g
                com.qq.e.comm.plugin.zv.a(r1, r2, r3, r4, r5, r6, r7, r8)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.plugin.zv.b.run():void");
        }
    }

    /* compiled from: A */
    class c implements Runnable {
        final /* synthetic */ WeakReference a;
        final /* synthetic */ WeakReference b;
        final /* synthetic */ int c;
        final /* synthetic */ int d;
        final /* synthetic */ h4 e;
        final /* synthetic */ String f;
        final /* synthetic */ String g;
        final /* synthetic */ int h;

        c(WeakReference weakReference, WeakReference weakReference2, int i, int i2, h4 h4Var, String str, String str2, int i3) {
            this.a = weakReference;
            this.b = weakReference2;
            this.c = i;
            this.d = i2;
            this.e = h4Var;
            this.f = str;
            this.g = str2;
            this.h = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            View view;
            Bitmap bitmapA;
            Boolean boolValueOf;
            Window window;
            WeakReference weakReference = this.a;
            if (weakReference == null || (view = (View) weakReference.get()) == null || (bitmapA = zv.a(view)) == null) {
                return;
            }
            View view2 = (View) this.b.get();
            Integer num = (Integer) d50.a(view, this.c).second;
            JSONObject jSONObjectB = zv.b(view, view2);
            Activity activityA = c1.a(view);
            if (activityA == null || (window = activityA.getWindow()) == null) {
                boolValueOf = null;
            } else {
                boolValueOf = Boolean.valueOf((window.getAttributes().flags & 8192) != 0);
            }
            qg.f.schedule(new a(bitmapA, boolValueOf, jSONObjectB, num), this.h, TimeUnit.SECONDS);
        }

        /* compiled from: A */
        class a implements Runnable {
            final /* synthetic */ Bitmap a;
            final /* synthetic */ Boolean b;
            final /* synthetic */ JSONObject c;
            final /* synthetic */ Integer d;

            a(Bitmap bitmap, Boolean bool, JSONObject jSONObject, Integer num) {
                this.a = bitmap;
                this.b = bool;
                this.c = jSONObject;
                this.d = num;
            }

            @Override // java.lang.Runnable
            public void run() throws JSONException {
                Bitmap bitmap = this.a;
                c cVar = c.this;
                zv.b(bitmap, cVar.d, cVar.e, cVar.f, this.b, this.c, cVar.g, this.d.intValue());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Bitmap bitmap, int i, h4 h4Var, String str, Boolean bool, JSONObject jSONObject, String str2, int i2) throws JSONException {
        boolean z;
        String str3;
        String strA = a(i, bitmap);
        JSONObject jSONObject2 = new JSONObject();
        boolean z2 = !TextUtils.isEmpty(str2);
        if (z2) {
            try {
                JSONObject jSONObject3 = new JSONObject(str2);
                String strOptString = jSONObject3.optString("aa");
                String strOptString2 = jSONObject3.optString("ab");
                String strOptString3 = jSONObject3.optString("ba");
                z = z2;
                try {
                    String strOptString4 = jSONObject3.optString("bb");
                    str3 = strA;
                    try {
                        String strOptString5 = jSONObject3.optString("da");
                        String strOptString6 = jSONObject3.optString("db");
                        String strOptString7 = jSONObject3.optString("sld");
                        jSONObject2.put("aa", strOptString);
                        jSONObject2.put("ab", strOptString2);
                        jSONObject2.put("ba", strOptString3);
                        jSONObject2.put("bb", strOptString4);
                        jSONObject2.put("da", strOptString5);
                        jSONObject2.put("db", strOptString6);
                        jSONObject2.put("sld", strOptString7);
                    } catch (Throwable unused) {
                    }
                } catch (Throwable unused2) {
                    str3 = strA;
                }
            } catch (Throwable unused3) {
            }
        } else {
            str3 = strA;
            z = z2;
        }
        JSONObject jSONObject4 = new JSONObject();
        try {
            jSONObject4.put("task_id", str);
            jSONObject4.put("render_type", h4Var.D0());
            jSONObject4.put("aid", h4Var.g());
            jSONObject4.put("tid", h4Var.O0());
            jSONObject4.put("task_id", str);
            jSONObject4.put("ad_view", str3);
            jSONObject4.put("ov", Build.VERSION.RELEASE);
            jSONObject4.put("mn", Build.PRODUCT);
            jSONObject4.put("is_video", h4Var.C1());
            jSONObject4.put("os", "android");
            if (jSONObject != null) {
                jSONObject4.put("hierarchy", jSONObject.toString());
            }
            jSONObject4.put("view", jSONObject2);
            jSONObject4.put("covered_ratio", i2);
            jSONObject4.put("stage", z ? 1 : 0);
            if (bool != null) {
                jSONObject4.put("secure", bool.booleanValue() ? 1 : 2);
            } else {
                jSONObject4.put("secure", 0);
            }
        } catch (JSONException unused4) {
        }
        a(jSONObject4, h4Var);
    }

    /* compiled from: A */
    class d extends hz {
        @Override // com.qq.e.comm.plugin.qr
        public void a(aw awVar, hw hwVar) {
        }

        d() {
        }

        @Override // com.qq.e.comm.plugin.hz
        public void a(aw awVar, int i, Exception exc) {
            b10.b(9700002, null, Integer.valueOf(i));
        }
    }

    public static String a(int i, Bitmap bitmap) {
        if (bitmap == null) {
            return "";
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.WEBP, i, byteArrayOutputStream);
        return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
    }

    public static JSONObject b(View view, View view2) {
        try {
            return a(view, a(view, view2), view2);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static JSONObject b(View view, JSONArray jSONArray, View view2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        if (view != null) {
            jSONObject.put("name", view);
            jSONObject.put("width", view.getWidth());
            jSONObject.put("height", view.getHeight());
            jSONObject.put("x", view.getX());
            jSONObject.put("y", view.getY());
            jSONObject.put("visible", view.getVisibility());
            if (view2 != null && view2 == view) {
                jSONObject.put("clicked", true);
            }
        } else {
            jSONObject.put("name", "nullView");
        }
        jSONObject.put("children", jSONArray);
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(WeakReference<View> weakReference, h4 h4Var, String str, int i, String str2, int i2, WeakReference<View> weakReference2, int i3) {
        xo.c(new c(weakReference, weakReference2, i2, i, h4Var, str2, str, i3));
    }

    private static JSONArray a(View view, View view2) throws Throwable {
        JSONArray jSONArray = new JSONArray();
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt instanceof ViewGroup) {
                    jSONArray.put(b(childAt, a(childAt, view2), view2));
                } else {
                    jSONArray.put(b(childAt, null, view2));
                }
            }
        }
        return jSONArray;
    }

    private static JSONObject a(View view, JSONArray jSONArray, View view2) throws Throwable {
        ViewParent parent = view.getParent();
        if (parent instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) parent;
            int childCount = viewGroup.getChildCount();
            JSONArray jSONArray2 = new JSONArray();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                jSONArray2.put(b(childAt, childAt == view ? jSONArray : null, view2));
            }
            return a(viewGroup, jSONArray2, view2);
        }
        return b(view, jSONArray, view2);
    }

    private static void a(View view, h4 h4Var, int i) {
        e2 e2VarK = h4Var.k();
        if ((e2VarK.g() || e2VarK.j()) && r1.d().f().a("resion", h4Var.y0(), 0) == 1) {
            view.postDelayed(new a(new WeakReference(view), h4Var), i * 1000);
        }
    }

    public static void a(View view, h4 h4Var, String str) {
        a(view, h4Var, str, null, null);
    }

    public static void a(View view, h4 h4Var) {
        a(view, h4Var, 2, null);
    }

    public static void a(View view, h4 h4Var, int i, e eVar) {
        a(view, h4Var, i);
        String strA = a("radss", h4Var);
        if (TextUtils.isEmpty(strA)) {
            return;
        }
        a(view, h4Var, i, strA, null, null, eVar);
    }

    public static void a(View view, h4 h4Var, String str, View view2, e eVar) {
        String strA = a("radssc", h4Var);
        if (TextUtils.isEmpty(strA)) {
            return;
        }
        a(view, h4Var, 0, strA, str, view2, eVar);
    }

    private static String a(String str, h4 h4Var) {
        String strC = r1.d().f().c(vx.a(str, h4Var.k()), h4Var.y0());
        return TextUtils.isEmpty(strC) ? r1.d().f().c(str, h4Var.y0()) : strC;
    }

    private static void a(View view, h4 h4Var, int i, String str, String str2, View view2, e eVar) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        AtomicLong atomicLong = a;
        if (jCurrentTimeMillis - atomicLong.get() < b.get()) {
            return;
        }
        atomicLong.set(jCurrentTimeMillis);
        qg.b.submit(new b(i, str, h4Var, eVar, new WeakReference(view), str2, new WeakReference(view2)));
    }

    private static void a(JSONObject jSONObject, h4 h4Var) {
        sx.a(1011, jSONObject, new j(h4Var.k(), h4Var.y0()), new d());
    }
}
