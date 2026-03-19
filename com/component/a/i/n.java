package com.component.a.i;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.mobads.container.util.bq;
import com.component.a.f.e;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class n {
    public static final int a = 3;
    public static final int b = 4;

    public interface a {
        void a(String str, com.component.a.f.e eVar);
    }

    public static boolean a(int i) {
        return (i & 4) == 4;
    }

    public static Typeface a(e.i iVar, int i) {
        int iE = iVar.e(i);
        if (iE > 0) {
            switch (iE & 3) {
                case 1:
                    return Typeface.defaultFromStyle(1);
                case 2:
                    return Typeface.defaultFromStyle(2);
                case 3:
                    return Typeface.defaultFromStyle(3);
                default:
                    return Typeface.defaultFromStyle(0);
            }
        }
        return Typeface.defaultFromStyle(i);
    }

    public static float a(JSONObject jSONObject, String str, float f) {
        if (jSONObject != null && !TextUtils.isEmpty(str)) {
            try {
                return (float) jSONObject.optDouble(str, f);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return f;
    }

    public static int a(JSONObject jSONObject, String str, int i) {
        if (jSONObject != null && !TextUtils.isEmpty(str)) {
            try {
                String strOptString = jSONObject.optString(str);
                if (TextUtils.isEmpty(strOptString)) {
                    return i;
                }
                return Color.parseColor(strOptString);
            } catch (Throwable th) {
                bq.a().b(th);
            }
        }
        return i;
    }

    public static int[] a(JSONObject jSONObject, String str, int[] iArr) {
        if (jSONObject != null && !TextUtils.isEmpty(str)) {
            try {
                JSONArray jSONArrayB = b(jSONObject, str);
                if (jSONArrayB != null) {
                    int length = jSONArrayB.length();
                    int[] iArr2 = new int[length];
                    for (int i = 0; i < length; i++) {
                        iArr2[i] = Color.parseColor(jSONArrayB.optString(i));
                    }
                    return iArr2;
                }
            } catch (Throwable th) {
                bq.a().b(th);
            }
        }
        return iArr;
    }

    public static int[] b(JSONObject jSONObject, String str, int[] iArr) {
        if (jSONObject != null && !TextUtils.isEmpty(str)) {
            try {
                JSONArray jSONArrayB = b(jSONObject, str);
                if (jSONArrayB != null && jSONArrayB.length() >= iArr.length) {
                    for (int i = 0; i < iArr.length; i++) {
                        String strOptString = jSONArrayB.optString(i);
                        if (!TextUtils.isEmpty(strOptString)) {
                            iArr[i] = Color.parseColor(strOptString);
                        }
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return iArr;
    }

    public static JSONObject a(JSONObject jSONObject, String str) {
        try {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(str);
            if (jSONObjectOptJSONObject == null) {
                String strOptString = jSONObject.optString(str);
                if (!TextUtils.isEmpty(strOptString)) {
                    return new JSONObject(strOptString);
                }
                return jSONObjectOptJSONObject;
            }
            return jSONObjectOptJSONObject;
        } catch (Throwable th) {
            return null;
        }
    }

    public static JSONArray b(JSONObject jSONObject, String str) {
        try {
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(str);
            if (jSONArrayOptJSONArray == null) {
                String strOptString = jSONObject.optString(str);
                if (!TextUtils.isEmpty(strOptString)) {
                    return new JSONArray(strOptString);
                }
                return jSONArrayOptJSONArray;
            }
            return jSONArrayOptJSONArray;
        } catch (Throwable th) {
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T a(JSONObject jSONObject, String str, T t) {
        if (jSONObject != null && !TextUtils.isEmpty(str)) {
            try {
                JSONArray jSONArrayB = b(jSONObject, str);
                if (jSONArrayB != null) {
                    int i = 0;
                    if ((t instanceof int[]) && jSONArrayB.length() >= ((int[]) t).length) {
                        while (i < ((int[]) t).length) {
                            ((int[]) t)[i] = jSONArrayB.optInt(i);
                            i++;
                        }
                    } else if ((t instanceof float[]) && jSONArrayB.length() >= ((float[]) t).length) {
                        while (i < ((float[]) t).length) {
                            ((float[]) t)[i] = (float) jSONArrayB.optDouble(i);
                            i++;
                        }
                    } else if ((t instanceof String[]) && jSONArrayB.length() >= ((String[]) t).length) {
                        while (i < ((String[]) t).length) {
                            ((String[]) t)[i] = jSONArrayB.optString(i);
                            i++;
                        }
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return t;
    }

    public static void a(Context context, float[] fArr) {
        float fA = com.component.a.i.a.a(context);
        for (int i = 0; i < fArr.length; i++) {
            fArr[i] = fArr[i] * fA;
        }
    }

    public static void a(Context context, int[] iArr) {
        float fA = com.component.a.i.a.a(context);
        for (int i = 0; i < iArr.length; i++) {
            iArr[i] = (int) ((iArr[i] * fA) + 0.5f);
        }
    }

    public static boolean a(String str) {
        if (!TextUtils.isEmpty(str)) {
            return str.startsWith("@res/");
        }
        return false;
    }

    public static void b(JSONObject jSONObject, String str, Object obj) {
        if (jSONObject != null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    jSONObject.put(str, obj);
                }
            } catch (Throwable th) {
                bq.a().a(th);
            }
        }
    }

    public static void a(JSONObject jSONObject, JSONObject jSONObject2) {
        a(jSONObject, jSONObject2, true);
    }

    public static void a(JSONObject jSONObject, JSONObject jSONObject2, boolean z) {
        boolean z2;
        JSONObject jSONObjectA;
        if (jSONObject == null || jSONObject2 == null) {
            return;
        }
        Iterator<String> itKeys = jSONObject2.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            if (!TextUtils.equals("id", next)) {
                if (!z && jSONObject.has(next)) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                for (String str : com.component.a.f.e.a) {
                    if (TextUtils.equals(str, next) && (jSONObjectA = a(jSONObject, str)) != null) {
                        a(jSONObjectA, a(jSONObject2, str), z);
                        if (jSONObject.optJSONObject(str) == null) {
                            b(jSONObject, str, jSONObjectA);
                        }
                        z2 = false;
                    }
                }
                if (z2 && !TextUtils.isEmpty(next)) {
                    b(jSONObject, next, jSONObject2.opt(next));
                }
            }
        }
    }

    public static void b(JSONObject jSONObject, JSONObject jSONObject2) {
        JSONArray jSONArrayNames;
        if (jSONObject == null || jSONObject2 == null || (jSONArrayNames = jSONObject.names()) == null) {
            return;
        }
        for (int i = 0; i < jSONArrayNames.length(); i++) {
            if (!TextUtils.equals("id", jSONArrayNames.optString(i))) {
                jSONObject.remove(jSONArrayNames.optString(i));
            }
        }
        Iterator<String> itKeys = jSONObject2.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            if (!TextUtils.equals("id", next) && !TextUtils.isEmpty(next)) {
                try {
                    jSONObject.put(next, jSONObject2.opt(next));
                } catch (Throwable th) {
                    bq.a().a(th);
                }
            }
        }
    }

    public static List<JSONObject> a(JSONObject jSONObject, Map<String, Map<JSONObject, String>> map) {
        JSONArray jSONArrayOptJSONArray;
        boolean z;
        Map<JSONObject, String> map2;
        if (jSONObject == null || map == null || map.isEmpty() || (jSONArrayOptJSONArray = jSONObject.optJSONArray("child_view")) == null) {
            return null;
        }
        int i = 0;
        while (true) {
            if (i >= jSONArrayOptJSONArray.length()) {
                z = false;
                break;
            }
            JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null) {
                String strOptString = jSONObjectOptJSONObject.optString("id");
                if (!TextUtils.isEmpty(strOptString) && map.containsKey(strOptString)) {
                    z = true;
                    break;
                }
            }
            i++;
        }
        if (!z) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
            JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray.optJSONObject(i2);
            String strOptString2 = jSONObjectOptJSONObject2.optString("id");
            arrayList.add(jSONObjectOptJSONObject2);
            if (!TextUtils.isEmpty(strOptString2) && (map2 = map.get(strOptString2)) != null) {
                for (Map.Entry<JSONObject, String> entry : map2.entrySet()) {
                    JSONObject key = entry.getKey();
                    String value = entry.getValue();
                    if ("before".equalsIgnoreCase(value)) {
                        arrayList.add(arrayList.size() - 1, key);
                        arrayList2.add(key);
                    } else if ("behind".equalsIgnoreCase(value)) {
                        arrayList.add(key);
                        arrayList2.add(key);
                    }
                }
            }
        }
        b(jSONObject, "child_view", new JSONArray((Collection) arrayList));
        return arrayList2;
    }

    public static JSONObject a(String str, String str2) {
        JSONObject jSONObjectB = b(str);
        if (jSONObjectB != null) {
            return jSONObjectB;
        }
        return b(str2);
    }

    public static JSONObject b(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                JSONObject jSONObject = new JSONObject(str);
                if (a(jSONObject)) {
                    return jSONObject;
                }
                return null;
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static boolean a(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() == 0) {
            return false;
        }
        Iterator<com.component.a.f.e> it = new com.component.a.f.e(jSONObject).iterator();
        while (it.hasNext()) {
            com.component.a.f.e next = it.next();
            if (!TextUtils.equals("render", next.n("")) && TextUtils.isEmpty(next.t(""))) {
                return false;
            }
        }
        return true;
    }

    public static JSONObject c(String str) {
        try {
            return new JSONObject(str);
        } catch (Throwable th) {
            bq.a().a(th);
            return new JSONObject();
        }
    }

    public static JSONObject b(JSONObject jSONObject) {
        try {
            return new JSONObject(jSONObject.toString());
        } catch (Throwable th) {
            bq.a().a(th);
            return null;
        }
    }

    public static JSONArray d(String str) {
        try {
            return new JSONArray(str);
        } catch (Throwable th) {
            bq.a().a(th);
            return new JSONArray();
        }
    }

    public static void a(List<View> list, boolean z) {
        Collections.sort(list, new o(z));
    }

    public static String a(View view, String str) {
        f fVarA = f.a(view);
        if (fVarA != null && fVarA.b() != null) {
            return fVarA.b().l(str);
        }
        return str;
    }

    public static Map<View, com.component.a.f.e> a(View view) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        LinkedList linkedList = new LinkedList();
        if (view instanceof com.component.a.c.c) {
            linkedList.add(view);
            while (!linkedList.isEmpty()) {
                KeyEvent.Callback callback = (View) linkedList.poll();
                if (callback instanceof com.component.a.c.c) {
                    f lifeCycle = ((com.component.a.c.c) callback).getLifeCycle();
                    if (lifeCycle != null) {
                        linkedHashMap.put(callback, lifeCycle.b());
                    }
                    if (callback instanceof ViewGroup) {
                        ViewGroup viewGroup = (ViewGroup) callback;
                        int childCount = viewGroup.getChildCount();
                        for (int i = 0; i < childCount; i++) {
                            View childAt = viewGroup.getChildAt(i);
                            if (childAt instanceof com.component.a.c.c) {
                                linkedList.add(childAt);
                            }
                        }
                    }
                }
            }
        }
        return linkedHashMap;
    }

    public static View a(Map<View, com.component.a.f.e> map, String str) {
        if (map != null && !map.isEmpty() && !TextUtils.isEmpty(str)) {
            for (View view : map.keySet()) {
                com.component.a.f.e eVar = map.get(view);
                if (view != null && eVar != null && TextUtils.equals(str, eVar.m(""))) {
                    return view;
                }
            }
            return null;
        }
        return null;
    }

    public static Map<String, com.component.a.f.e> a(com.component.a.f.e eVar) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<com.component.a.f.e> it = eVar.iterator();
        while (it.hasNext()) {
            com.component.a.f.e next = it.next();
            String strL = next.l("");
            if (!TextUtils.isEmpty(strL)) {
                linkedHashMap.put(strL, next);
            }
        }
        return linkedHashMap;
    }

    public static Map<String, com.component.a.f.e> c(JSONObject jSONObject) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<com.component.a.f.e> it = new com.component.a.f.e(jSONObject).iterator();
        while (it.hasNext()) {
            com.component.a.f.e next = it.next();
            String strL = next.l("");
            if (!TextUtils.isEmpty(strL)) {
                linkedHashMap.put(strL, next);
            }
        }
        return linkedHashMap;
    }

    public static JSONObject a(String str, a aVar) {
        try {
            return a(new JSONObject(str), aVar);
        } catch (Throwable th) {
            th.printStackTrace();
            return new JSONObject();
        }
    }

    public static JSONObject a(JSONObject jSONObject, a aVar) {
        a(new com.component.a.f.e(jSONObject), aVar);
        return jSONObject;
    }

    public static void a(com.component.a.f.e eVar, a aVar) {
        if (eVar != null && aVar != null) {
            try {
                aVar.a(eVar.l(""), eVar);
            } catch (JSONException e) {
                bq.a().a(e);
            }
            Iterator<com.component.a.f.e> it = eVar.o().iterator();
            while (it.hasNext()) {
                a(it.next(), aVar);
            }
        }
    }

    public static String a(CharSequence charSequence, String str) {
        Matcher matcher = Pattern.compile(str).matcher(charSequence);
        if (matcher.find()) {
            return matcher.group();
        }
        return "";
    }
}
