package com.bytedance.bdtracker;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewParent;
import android.widget.ImageView;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.InputDeviceCompat;
import com.bytedance.applog.IEventObserver;
import com.bytedance.applog.IPresetEventObserver;
import com.bytedance.applog.log.LoggerImpl;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class l0 implements IPresetEventObserver, IEventObserver {
    public final IEventObserver a;
    public final IPresetEventObserver b;

    public /* synthetic */ l0(IEventObserver iEventObserver, IPresetEventObserver iPresetEventObserver, a aVar) {
        this.a = iEventObserver;
        this.b = iPresetEventObserver;
    }

    @Override // com.bytedance.applog.IEventObserver
    public void onEvent(String str, String str2, String str3, long j, long j2, String str4) {
        IEventObserver iEventObserver = this.a;
        if (iEventObserver == null) {
            return;
        }
        iEventObserver.onEvent(str, str2, str3, j, j2, str4);
    }

    @Override // com.bytedance.applog.IEventObserver
    public void onEventV3(String str, JSONObject jSONObject) {
        IEventObserver iEventObserver = this.a;
        if (iEventObserver == null) {
            return;
        }
        iEventObserver.onEventV3(str, jSONObject);
    }

    @Override // com.bytedance.applog.IPresetEventObserver
    public void onLaunch(JSONObject jSONObject) {
        IPresetEventObserver iPresetEventObserver = this.b;
        if (iPresetEventObserver == null) {
            return;
        }
        iPresetEventObserver.onLaunch(jSONObject);
    }

    @Override // com.bytedance.applog.IPresetEventObserver
    public void onPageEnter(JSONObject jSONObject) {
        IPresetEventObserver iPresetEventObserver = this.b;
        if (iPresetEventObserver == null) {
            return;
        }
        iPresetEventObserver.onPageEnter(jSONObject);
    }

    @Override // com.bytedance.applog.IPresetEventObserver
    public void onPageLeave(JSONObject jSONObject) {
        IPresetEventObserver iPresetEventObserver = this.b;
        if (iPresetEventObserver == null) {
            return;
        }
        iPresetEventObserver.onPageLeave(jSONObject);
    }

    public static class b {
        public static String a;

        public static Activity a(Context context) {
            if (!(context instanceof ContextWrapper)) {
                return null;
            }
            do {
                ContextWrapper contextWrapper = (ContextWrapper) context;
                if (contextWrapper instanceof Activity) {
                    return (Activity) contextWrapper;
                }
                context = contextWrapper.getBaseContext();
            } while (context instanceof ContextWrapper);
            return null;
        }

        public static l0 a(IEventObserver iEventObserver, IPresetEventObserver iPresetEventObserver) {
            return new l0(iEventObserver, iPresetEventObserver, null);
        }

        public static Class<?> a(String... strArr) {
            if (strArr != null && strArr.length != 0) {
                for (String str : strArr) {
                    Class<?> clsB = b(str);
                    if (clsB != null) {
                        return clsB;
                    }
                }
            }
            return null;
        }

        public static String a(Object obj) {
            return obj != null ? obj.toString() : "";
        }

        public static String a(boolean z) {
            return z ? "yes" : com.component.a.g.b.t;
        }

        public static List a() {
            return CollectionsKt.listOf(new String[]{"metrics_category", "metrics_name"});
        }

        public static JSONObject a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            JSONObject jSONObject2 = new JSONObject();
            a(jSONObject2, jSONObject);
            try {
                String strA = h5.a(jSONObject2.optJSONObject("oaid"));
                if (TextUtils.isEmpty(strA)) {
                    return jSONObject2;
                }
                jSONObject2.put("oaid", strA);
                return jSONObject2;
            } catch (Throwable th) {
                LoggerImpl.global().error("transferHeaderOaid error", th, new Object[0]);
                return jSONObject2;
            }
        }

        public static JSONObject a(JSONObject jSONObject, JSONObject jSONObject2) {
            if (jSONObject2 != null) {
                try {
                    Iterator<String> itKeys = jSONObject2.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        jSONObject.put(next, jSONObject2.opt(next));
                    }
                } catch (Throwable th) {
                    LoggerImpl.global().error("copy json error", th, new Object[0]);
                }
            }
            return jSONObject;
        }

        public static void a(Cursor cursor) {
            if (cursor != null) {
                try {
                    cursor.close();
                } catch (Throwable th) {
                    LoggerImpl.global().error("closeSafely error", th, new Object[0]);
                }
            }
        }

        public static void a(SQLiteDatabase sQLiteDatabase) {
            if (sQLiteDatabase != null) {
                try {
                    sQLiteDatabase.endTransaction();
                } catch (Throwable th) {
                    LoggerImpl.global().error("endDbTransactionSafely error", th, new Object[0]);
                }
            }
        }

        public static void a(Closeable closeable) {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (Throwable th) {
                    LoggerImpl.global().error("closeSafely error", th, new Object[0]);
                }
            }
        }

        public static boolean a(Object obj, Object obj2) {
            return (obj != null || obj2 == null) && (obj == null || obj2 != null);
        }

        public static boolean a(Object obj, Object obj2, String str) throws JSONException {
            if (!a(obj, obj2)) {
                return false;
            }
            if (obj instanceof JSONObject) {
                return a((JSONObject) obj, (JSONObject) obj2, str);
            }
            if (!(obj instanceof JSONArray)) {
                if (obj.getClass() != obj2.getClass()) {
                    return false;
                }
                String string = obj.toString();
                String string2 = obj2.toString();
                return a((Object) string, (Object) string2) && string.equals(string2);
            }
            JSONArray jSONArray = (JSONArray) obj;
            JSONArray jSONArray2 = (JSONArray) obj2;
            if (!a(jSONArray, jSONArray2)) {
                return false;
            }
            HashMap map = new HashMap();
            for (int i = 0; i < jSONArray.length(); i++) {
                Object obj3 = jSONArray.get(i);
                map.put(obj3, (!map.containsKey(obj3) || map.get(obj3) == null) ? 1 : Integer.valueOf(((Integer) map.get(obj3)).intValue() + 1));
            }
            HashMap map2 = new HashMap();
            for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                Object obj4 = jSONArray2.get(i2);
                map2.put(obj4, (!map2.containsKey(obj4) || map2.get(obj4) == null) ? 1 : Integer.valueOf(((Integer) map2.get(obj4)).intValue() + 1));
            }
            if (map.size() != map2.size()) {
                return false;
            }
            for (Map.Entry entry : map.entrySet()) {
                if (!((Integer) entry.getValue()).equals((Integer) map2.get(entry.getKey()))) {
                    return false;
                }
            }
            return true;
        }

        public static boolean a(Object obj, String str) {
            return a(obj == null, str);
        }

        public static boolean a(Object obj, String... strArr) {
            if (strArr != null && strArr.length != 0) {
                for (String str : strArr) {
                    Class<?> clsB = b(str);
                    if (clsB != null && clsB.isInstance(obj)) {
                        return true;
                    }
                }
            }
            return false;
        }

        public static boolean a(String str) {
            boolean z = false;
            if (TextUtils.isEmpty(str) || "unknown".equalsIgnoreCase(str) || "Null".equalsIgnoreCase(str)) {
                return false;
            }
            int i = 0;
            while (true) {
                if (i >= str.length()) {
                    z = true;
                    break;
                }
                if (str.charAt(i) != '0') {
                    break;
                }
                i++;
            }
            return !z;
        }

        public static boolean a(String str, String str2) {
            return (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) || (str != null && str.equals(str2));
        }

        public static boolean a(JSONObject jSONObject, JSONObject jSONObject2, String str) throws JSONException {
            if (!a((Object) jSONObject, (Object) jSONObject2)) {
                return false;
            }
            if (jSONObject != null && jSONObject.length() != jSONObject2.length()) {
                return false;
            }
            Iterator<String> itKeys = jSONObject.keys();
            boolean zA = true;
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                zA = a(jSONObject.get(next), jSONObject2.get(next), next);
                if (!zA) {
                    break;
                }
            }
            return zA;
        }

        public static boolean a(JSONObject jSONObject, Class<?>[] clsArr, Class<?>[] clsArr2) throws JSONException {
            if (jSONObject == null) {
                return false;
            }
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                Object obj = jSONObject.get(itKeys.next());
                if (obj == null) {
                    return false;
                }
                if (obj instanceof JSONArray) {
                    JSONArray jSONArray = (JSONArray) obj;
                    for (int i = 0; i < jSONArray.length(); i++) {
                        Object obj2 = jSONArray.get(i);
                        if (clsArr2 != null && !a(clsArr2, obj2.getClass())) {
                            return false;
                        }
                    }
                } else if (clsArr != null && !a(clsArr, obj.getClass())) {
                    return false;
                }
            }
            return true;
        }

        public static <T> boolean a(T[] tArr, T t) {
            for (T t2 : tArr) {
                if (t2 == t) {
                    return true;
                }
            }
            return false;
        }

        public static Class<?> b(String str) {
            try {
                return Class.forName(str);
            } catch (ClassNotFoundException unused) {
                return null;
            }
        }

        public static String b() {
            BufferedReader bufferedReader;
            String str = a;
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
            String string = null;
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));
                try {
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        int i = bufferedReader.read();
                        if (i <= 0) {
                            break;
                        }
                        sb.append((char) i);
                    }
                    string = sb.toString();
                } catch (Throwable unused) {
                }
            } catch (Throwable unused2) {
                bufferedReader = null;
            }
            a((Closeable) bufferedReader);
            a = string;
            LoggerImpl.global().debug(com.bytedance.bdtracker.a.a("getProcessName: ").append(a).toString(), new Object[0]);
            return a;
        }

        public static String b(View view) {
            if (view == null) {
                return null;
            }
            return c(view) + "$$" + view.hashCode();
        }

        public static JSONObject b(JSONObject jSONObject, JSONObject jSONObject2) {
            if (jSONObject == null) {
                return jSONObject2;
            }
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                try {
                    String next = itKeys.next();
                    jSONObject2.put(next, jSONObject.opt(next));
                } catch (JSONException e) {
                    LoggerImpl.global().error(Collections.singletonList("JsonUtils"), "Merge json interrupted.", e, new Object[0]);
                }
            }
            return jSONObject2;
        }

        public static boolean b(Object obj, Object obj2) {
            return obj == obj2 || (obj != null && obj.equals(obj2));
        }

        public static synchronized String c() {
            return UUID.randomUUID().toString().replace("-", "").toLowerCase() + System.currentTimeMillis();
        }

        /* JADX WARN: Removed duplicated region for block: B:62:0x009c  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static java.lang.String c(android.view.View r8) {
            /*
                Method dump skipped, instructions count: 237
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.bdtracker.l0.b.c(android.view.View):java.lang.String");
        }

        public static boolean c(String str) {
            return !d(str);
        }

        public static List d() {
            return CollectionsKt.emptyList();
        }

        public static boolean d(View view) {
            if (view == null) {
                return false;
            }
            if (e5.a(view)) {
                return true;
            }
            if (view.getWidth() <= 0 || view.getHeight() <= 0 || view.getAlpha() <= 0.0f || !view.getLocalVisibleRect(new Rect())) {
                return false;
            }
            return !(view.getVisibility() == 0 || view.getAnimation() == null || !view.getAnimation().getFillAfter()) || view.getVisibility() == 0;
        }

        public static boolean d(String str) {
            return str != null && str.length() > 0;
        }

        public static boolean e(View view) {
            boolean zD = d(view);
            if (!zD) {
                return zD;
            }
            for (ViewParent parent = view.getParent(); parent != null; parent = parent.getParent()) {
                if (!(parent instanceof View)) {
                    return zD;
                }
                if (!d((View) parent)) {
                    break;
                }
            }
            return false;
        }

        public static boolean e(String str) {
            int length = str != null ? str.length() : 0;
            if (length < 13 || length > 128) {
                return false;
            }
            for (int i = 0; i < length; i++) {
                char cCharAt = str.charAt(i);
                if ((cCharAt < '0' || cCharAt > '9') && ((cCharAt < 'a' || cCharAt > 'f') && ((cCharAt < 'A' || cCharAt > 'F') && cCharAt != '-'))) {
                    return false;
                }
            }
            return true;
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.TypeCastException */
        public static final void b(View view, boolean z) throws TypeCastException {
            Intrinsics.checkParameterIsNotNull(view, "$this$setViewExposureVisible");
            if (Build.VERSION.SDK_INT >= 16) {
                int i = z ? SupportMenu.CATEGORY_MASK : InputDeviceCompat.SOURCE_ANY;
                if (view instanceof ImageView) {
                    ImageView imageView = (ImageView) view;
                    if (imageView.getDrawable() instanceof p0) {
                        Drawable drawable = imageView.getDrawable();
                        if (drawable != null) {
                            ((p0) drawable).b.setColor(i);
                        } else {
                            throw new TypeCastException("null cannot be cast to non-null type com.bytedance.applog.exposure.DebugDrawable");
                        }
                    }
                }
                if (view.getBackground() instanceof p0) {
                    Drawable background = view.getBackground();
                    if (background != null) {
                        ((p0) background).b.setColor(i);
                    } else {
                        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.applog.exposure.DebugDrawable");
                    }
                }
                view.invalidate();
            }
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.TypeCastException */
        public static final void a(View view) throws TypeCastException {
            Intrinsics.checkParameterIsNotNull(view, "$this$disableViewExposureDebugMode");
            if (Build.VERSION.SDK_INT >= 16) {
                if (view instanceof ImageView) {
                    ImageView imageView = (ImageView) view;
                    if (imageView.getDrawable() instanceof p0) {
                        Drawable drawable = imageView.getDrawable();
                        if (drawable == null) {
                            throw new TypeCastException("null cannot be cast to non-null type com.bytedance.applog.exposure.DebugDrawable");
                        }
                        imageView.setImageDrawable(((p0) drawable).a);
                    }
                }
                if (view.getBackground() instanceof p0) {
                    Drawable background = view.getBackground();
                    if (background == null) {
                        throw new TypeCastException("null cannot be cast to non-null type com.bytedance.applog.exposure.DebugDrawable");
                    }
                    view.setBackground(((p0) background).a);
                }
            }
        }

        public static boolean a(boolean z, String str) {
            if (!z) {
                return false;
            }
            LoggerImpl.global().ast("[Assert failed] {}", null, str);
            return true;
        }

        /* JADX WARN: Removed duplicated region for block: B:106:0x01ff  */
        /* JADX WARN: Removed duplicated region for block: B:117:0x0229  */
        /* JADX WARN: Removed duplicated region for block: B:134:0x0381  */
        /* JADX WARN: Removed duplicated region for block: B:151:0x03a9  */
        /* JADX WARN: Removed duplicated region for block: B:154:0x03b0  */
        /* JADX WARN: Removed duplicated region for block: B:163:0x0426  */
        /* JADX WARN: Removed duplicated region for block: B:178:0x0487  */
        /* JADX WARN: Removed duplicated region for block: B:182:0x04c2  */
        /* JADX WARN: Removed duplicated region for block: B:213:0x0563  */
        /* JADX WARN: Removed duplicated region for block: B:214:0x0570  */
        /* JADX WARN: Removed duplicated region for block: B:236:0x05dc  */
        /* JADX WARN: Removed duplicated region for block: B:34:0x0082  */
        /* JADX WARN: Removed duplicated region for block: B:52:0x00ee A[PHI: r7
  0x00ee: PHI (r7v6 java.lang.String) = (r7v5 java.lang.String), (r7v5 java.lang.String), (r7v50 java.lang.String) binds: [B:42:0x00a2, B:44:0x00aa, B:46:0x00cd] A[DONT_GENERATE, DONT_INLINE]] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static com.bytedance.bdtracker.v3 a(android.view.View r35, boolean r36) {
            /*
                Method dump skipped, instructions count: 1559
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bytedance.bdtracker.l0.b.a(android.view.View, boolean):com.bytedance.bdtracker.v3");
        }

        public static void a(b3 b3Var, JSONObject jSONObject) {
            Intrinsics.checkParameterIsNotNull(jSONObject, "params");
            Intrinsics.checkParameterIsNotNull(jSONObject, "params");
        }
    }
}
