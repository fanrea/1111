package com.baidu.mobstat.forbes;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import com.baidu.mobstat.forbes.o;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class ae {
    public static View a(Activity activity) {
        Window window;
        if (activity == null || (window = activity.getWindow()) == null) {
            return null;
        }
        return window.getDecorView();
    }

    public static String a(View view) {
        String string;
        CharSequence textOff;
        CharSequence text;
        if (view == null) {
            return "";
        }
        if (view instanceof TextView) {
            if ((view instanceof EditText) || (text = ((TextView) view).getText()) == null) {
                string = "";
            } else {
                string = text.toString();
            }
            if (Build.VERSION.SDK_INT >= 14 && (view instanceof Switch)) {
                Switch r4 = (Switch) view;
                if (r4.isChecked()) {
                    textOff = r4.getTextOn();
                } else {
                    textOff = r4.getTextOff();
                }
                if (textOff != null) {
                    string = textOff.toString();
                }
            }
        } else if (!(view instanceof Spinner)) {
            string = "";
        } else {
            Spinner spinner = (Spinner) view;
            Object selectedItem = spinner.getSelectedItem();
            if (selectedItem != null && (selectedItem instanceof String)) {
                string = (String) selectedItem;
            } else {
                return a(spinner.getSelectedView());
            }
        }
        byte[] bytes = string.getBytes();
        if (bytes.length <= 4096) {
            return string;
        }
        if (Build.VERSION.SDK_INT < 9) {
            return "";
        }
        return new String(Arrays.copyOf(bytes, 4096));
    }

    public static String b(View view) throws ClassNotFoundException {
        String simpleName;
        Class<?> cls;
        if (view instanceof ListView) {
            simpleName = ListView.class.getSimpleName();
        } else if (!(view instanceof WebView)) {
            simpleName = "";
        } else {
            simpleName = WebView.class.getSimpleName();
        }
        if (TextUtils.isEmpty(simpleName)) {
            String strA = a(view.getClass());
            if (!"android.widget".equals(strA) && !"android.view".equals(strA)) {
                try {
                    cls = Class.forName("android.support.v7.widget.RecyclerView");
                } catch (Exception e) {
                    cls = null;
                }
                if (cls != null && cls.isAssignableFrom(view.getClass())) {
                    simpleName = "RecyclerView";
                }
            }
        }
        if (TextUtils.isEmpty(simpleName)) {
            simpleName = c(view.getClass());
        }
        if (TextUtils.isEmpty(simpleName)) {
            return "Object";
        }
        return simpleName;
    }

    private static String c(Class<?> cls) {
        if (cls == null) {
            return "";
        }
        String strA = a(cls);
        if ("android.widget".equals(strA) || "android.view".equals(strA)) {
            return d(cls);
        }
        return c(cls.getSuperclass());
    }

    public static String a(Class<?> cls) {
        String name;
        if (cls == null) {
            return "";
        }
        Package r1 = cls.getPackage();
        if (r1 == null) {
            name = "";
        } else {
            name = r1.getName();
        }
        if (name == null) {
            return "";
        }
        return name;
    }

    public static String a(View view, View view2) {
        if (view == null) {
            return String.valueOf(0);
        }
        if (view == view2) {
            return String.valueOf(0);
        }
        ViewParent parent = view.getParent();
        if (parent == null || !(parent instanceof ViewGroup)) {
            return String.valueOf(0);
        }
        Class<?> cls = view.getClass();
        if (cls == null) {
            return String.valueOf(0);
        }
        String strB = b(cls);
        if (TextUtils.isEmpty(strB)) {
            return String.valueOf(0);
        }
        ViewGroup viewGroup = (ViewGroup) parent;
        int i = 0;
        for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
            View childAt = viewGroup.getChildAt(i2);
            if (childAt != null) {
                if (childAt == view) {
                    break;
                }
                if (childAt.getClass() != null && strB.equals(b(childAt.getClass()))) {
                    i++;
                }
            }
        }
        return String.valueOf(i);
    }

    public static String a(View view, String str) {
        RecyclerView parent;
        if (TextUtils.isEmpty(str) || view == null || (parent = view.getParent()) == null || !(parent instanceof View)) {
            return "";
        }
        RecyclerView recyclerView = (View) parent;
        if (ListView.class.getSimpleName().equals(str)) {
            try {
                return (!(recyclerView instanceof ListView) || view.getParent() == null) ? "" : String.valueOf(((ListView) recyclerView).getPositionForView(view));
            } catch (Throwable th) {
                return "";
            }
        }
        if (GridView.class.getSimpleName().equals(str)) {
            try {
                return (!(recyclerView instanceof GridView) || view.getParent() == null) ? "" : String.valueOf(((GridView) recyclerView).getPositionForView(view));
            } catch (Throwable th2) {
                return "";
            }
        }
        if (!"RecyclerView".equals(str)) {
            return "";
        }
        try {
            return String.valueOf(recyclerView.getChildLayoutPosition(view));
        } catch (Throwable th3) {
            return "";
        }
    }

    public static String c(View view) throws ClassNotFoundException {
        ViewPager parent;
        Class<?> cls;
        if (view == null || (parent = view.getParent()) == null || !(parent instanceof ViewGroup)) {
            return "";
        }
        String strA = a(parent.getClass());
        if ("android.widget".equals(strA) || "android.view".equals(strA)) {
            return "";
        }
        ViewPager viewPager = (ViewGroup) parent;
        try {
            cls = Class.forName("android.support.v4.view.ViewPager");
        } catch (ClassNotFoundException e) {
            cls = null;
        }
        if (cls == null || !cls.isAssignableFrom(viewPager.getClass())) {
            return "";
        }
        try {
            ViewPager viewPager2 = viewPager;
            ArrayList arrayList = new ArrayList();
            int childCount = viewPager2.getChildCount();
            int i = 0;
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = viewPager2.getChildAt(i2);
                arrayList.add(childAt);
                if (e(childAt) != null) {
                    i++;
                }
            }
            if (arrayList.size() >= 2 && i >= 2) {
                try {
                    Collections.sort(arrayList, new Comparator<View>() { // from class: com.baidu.mobstat.forbes.ae.1
                        @Override // java.util.Comparator
                        /* renamed from: a, reason: merged with bridge method [inline-methods] */
                        public int compare(View view2, View view3) {
                            return view2.getLeft() - view3.getLeft();
                        }
                    });
                } catch (Exception e2) {
                }
                int left = view.getLeft() / Math.abs(((View) arrayList.get(1)).getLeft() - ((View) arrayList.get(0)).getLeft());
                int count = viewPager2.getAdapter().getCount();
                if (count != 0) {
                    left %= count;
                }
                return String.valueOf(left);
            }
            return String.valueOf(viewPager2.getCurrentItem());
        } catch (Throwable th) {
            return "";
        }
    }

    public static boolean d(View view) {
        if (view.getVisibility() != 0) {
            return false;
        }
        return a(view, new Rect());
    }

    public static Rect e(View view) {
        if (view.getVisibility() != 0) {
            return null;
        }
        Rect rect = new Rect();
        if (a(view, rect) && rect.right > rect.left && rect.bottom > rect.top) {
            return rect;
        }
        return null;
    }

    private static boolean a(View view, Rect rect) {
        if (view == null || rect == null) {
            return false;
        }
        try {
            return view.getGlobalVisibleRect(rect);
        } catch (Throwable th) {
            return false;
        }
    }

    public static String f(View view) throws Resources.NotFoundException {
        int iLastIndexOf;
        int length;
        String strSubstring = null;
        try {
            if (view.getId() != 0) {
                strSubstring = view.getResources().getResourceName(view.getId());
            }
        } catch (Exception e) {
        }
        if (!TextUtils.isEmpty(strSubstring) && strSubstring.contains(":id/") && (iLastIndexOf = strSubstring.lastIndexOf(":id/")) != -1 && (length = iLastIndexOf + ":id/".length()) < strSubstring.length()) {
            strSubstring = strSubstring.substring(length);
        }
        if (strSubstring == null) {
            return "";
        }
        return strSubstring;
    }

    public static JSONArray a(Activity activity, View view) throws JSONException {
        View viewA;
        JSONArray jSONArray = new JSONArray();
        if (activity == null || view == null) {
            return jSONArray;
        }
        try {
            viewA = a(activity);
        } catch (Exception e) {
            viewA = null;
        }
        if (viewA == null) {
            return jSONArray;
        }
        while (view != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("p", l(view));
                String strC = c(view);
                if (TextUtils.isEmpty(strC)) {
                    String strB = "";
                    Object parent = view.getParent();
                    if (parent != null && (parent instanceof View)) {
                        strB = b((View) parent);
                    }
                    strC = a(view, strB);
                    if (TextUtils.isEmpty(strC)) {
                        strC = a(view, viewA);
                    }
                }
                jSONObject.put("i", strC);
                jSONObject.put("t", b(view));
                jSONArray.put(jSONObject);
                Object parent2 = view.getParent();
                if (parent2 == null || view == viewA || !(parent2 instanceof View) || A(view) || jSONArray.length() > 1000) {
                    break;
                }
                view = (View) parent2;
            } catch (Exception e2) {
                jSONArray = new JSONArray();
            }
        }
        JSONArray jSONArray2 = new JSONArray();
        try {
            for (int length = jSONArray.length() - 1; length >= 0; length--) {
                jSONArray2.put(jSONArray.get(length));
            }
        } catch (Exception e3) {
        }
        return jSONArray2;
    }

    public static Map<String, String> g(View view) {
        Map<String, String> map;
        Object tag = view.getTag(-96000);
        if (tag == null || !(tag instanceof Map)) {
            return null;
        }
        try {
            map = (Map) tag;
        } catch (Exception e) {
            map = null;
        }
        if (map == null || map.size() == 0) {
            return null;
        }
        return map;
    }

    public static boolean b(View view, String str) {
        return "ListView".equals(str) || "RecyclerView".equals(str) || "GridView".equals(str) || view.isClickable();
    }

    public static String h(View view) {
        String string = null;
        if (view instanceof TextView) {
            CharSequence text = ((TextView) view).getText();
            if (text != null) {
                string = text.toString();
            }
        } else if (view instanceof ViewGroup) {
            StringBuilder sb = new StringBuilder();
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            boolean z = false;
            for (int i = 0; i < childCount && sb.length() < 128; i++) {
                String strH = h(viewGroup.getChildAt(i));
                if (strH != null && strH.length() > 0) {
                    if (z) {
                        sb.append(", ");
                    }
                    sb.append(strH);
                    z = true;
                }
            }
            if (sb.length() > 128) {
                string = sb.substring(0, 128);
            } else if (z) {
                string = sb.toString();
            }
        }
        if (TextUtils.isEmpty(string)) {
            return "";
        }
        return string;
    }

    public static String a(JSONArray jSONArray) throws JSONException {
        if (jSONArray == null || jSONArray.length() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                JSONObject jSONObject = (JSONObject) jSONArray.get(i);
                sb.append("/" + jSONObject.getString("p") + "[" + jSONObject.getString("i") + "]");
            } catch (Exception e) {
                return "";
            }
        }
        return sb.toString();
    }

    public static String b(JSONArray jSONArray) throws JSONException {
        if (jSONArray == null || jSONArray.length() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                JSONObject jSONObject = (JSONObject) jSONArray.get(i);
                sb.append("/" + jSONObject.getString("p") + "[" + jSONObject.getString("i") + "]");
                String strOptString = jSONObject.optString("d");
                if (!TextUtils.isEmpty(strOptString)) {
                    sb.append("#" + strOptString);
                }
            } catch (Exception e) {
                return "";
            }
        }
        return sb.toString();
    }

    public static String c(JSONArray jSONArray) throws JSONException {
        if (jSONArray == null || jSONArray.length() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                JSONObject jSONObject = (JSONObject) jSONArray.get(i);
                sb.append("/" + d(jSONObject.getString("p")) + "[" + jSONObject.getString("i") + "]");
            } catch (Exception e) {
                return "";
            }
        }
        return sb.toString();
    }

    public static String d(JSONArray jSONArray) throws JSONException {
        if (jSONArray == null || jSONArray.length() == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                JSONObject jSONObject = (JSONObject) jSONArray.get(i);
                sb.append("/" + d(jSONObject.getString("p")) + "[" + jSONObject.getString("i") + "]");
                String strOptString = jSONObject.optString("d");
                if (!TextUtils.isEmpty(strOptString)) {
                    sb.append("#" + strOptString);
                }
            } catch (Exception e) {
                return "";
            }
        }
        return sb.toString();
    }

    public static List<String> a(View view, boolean z) {
        ArrayList arrayList = new ArrayList();
        if (view == null) {
            return arrayList;
        }
        if ((view instanceof ImageView) && !z) {
            try {
                if (view.getVisibility() == 0) {
                    arrayList.add((view.getWidth() + "") + "|" + (view.getHeight() + ""));
                    return arrayList;
                }
                return arrayList;
            } catch (Exception e) {
                return arrayList;
            }
        }
        if (view instanceof ViewGroup) {
            try {
                ArrayList arrayList2 = new ArrayList();
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount && arrayList2.size() <= 9; i++) {
                    List<String> listA = a(viewGroup.getChildAt(i), false);
                    if (listA != null && listA.size() > 0) {
                        arrayList2.addAll(listA);
                    }
                }
                arrayList.addAll(arrayList2);
                return arrayList;
            } catch (Exception e2) {
                return arrayList;
            }
        }
        if (z) {
            try {
                ViewGroup viewGroup2 = (ViewGroup) view.getParent();
                if (viewGroup2 != null) {
                    return a((View) viewGroup2, false);
                }
                return arrayList;
            } catch (Exception e3) {
                return arrayList;
            }
        }
        return arrayList;
    }

    public static String i(View view) {
        String string = null;
        if (view instanceof TextView) {
            CharSequence text = ((TextView) view).getText();
            if (text != null) {
                string = text.toString();
                if (b(string) || c(string)) {
                    string = "*******";
                } else if (view instanceof EditText) {
                    string = "edit_view";
                }
            }
        } else if (view instanceof ViewGroup) {
            StringBuilder sb = new StringBuilder();
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            boolean z = false;
            for (int i = 0; i < childCount && sb.length() < 128; i++) {
                String strI = i(viewGroup.getChildAt(i));
                if (strI != null && strI.length() > 0) {
                    if (z) {
                        sb.append("| ");
                    }
                    sb.append(strI);
                    z = true;
                }
            }
            if (sb.length() > 4096) {
                string = sb.substring(0, 4096);
            } else if (z) {
                string = sb.toString();
            }
        }
        if (TextUtils.isEmpty(string)) {
            return "";
        }
        return string;
    }

    public static JSONObject j(View view) throws JSONException {
        String url;
        JSONObject jSONObject = new JSONObject();
        String string = null;
        if (!(view instanceof TextView)) {
            if (view instanceof WebView) {
                try {
                    url = ((WebView) view).getUrl();
                    if (!url.startsWith("http://")) {
                        if (!url.startsWith("https://")) {
                            url = "";
                        }
                    }
                } catch (Exception e) {
                }
            } else if (view instanceof ViewGroup) {
                StringBuilder sb = new StringBuilder();
                StringBuilder sb2 = new StringBuilder();
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                boolean z = false;
                boolean z2 = false;
                for (int i = 0; i < childCount && sb.length() < 128; i++) {
                    JSONObject jSONObjectJ = j(viewGroup.getChildAt(i));
                    String strOptString = jSONObjectJ.optString("content", "");
                    if (strOptString != null && strOptString.length() > 0) {
                        if (z) {
                            sb.append("| ");
                        }
                        sb.append(strOptString);
                        z = true;
                    }
                    String strOptString2 = jSONObjectJ.optString("webview", "");
                    if (strOptString2 != null && strOptString2.length() > 0) {
                        if (z2) {
                            sb2.append("| ");
                        }
                        sb2.append(strOptString2);
                        z2 = true;
                    }
                }
                if (sb.length() > 4096) {
                    string = sb.substring(0, 4096);
                } else if (z) {
                    string = sb.toString();
                }
                url = sb2.length() > 4096 ? sb2.substring(0, 4096) : z2 ? sb2.toString() : "";
            } else {
                url = "";
            }
        } else {
            CharSequence text = ((TextView) view).getText();
            if (text != null) {
                string = text.toString();
                if (b(string) || c(string)) {
                    string = "*******";
                } else if (view instanceof EditText) {
                    string = "edit_view";
                }
            }
            url = "";
        }
        if (TextUtils.isEmpty(string)) {
            string = "";
        }
        String str = TextUtils.isEmpty(url) ? "" : url;
        jSONObject.put("content", string);
        jSONObject.put("webview", str);
        return jSONObject;
    }

    public static String k(View view) {
        int collectTitleMaxLevel;
        String strI = null;
        if (view == null) {
            return "";
        }
        try {
            collectTitleMaxLevel = CooperService.instance().getCollectTitleMaxLevel();
            if (view != null && x(view.getRootView()) && CooperService.instance().getAndroidVersion() >= 29) {
                collectTitleMaxLevel = 7;
            }
            if (view != null && y(view)) {
                collectTitleMaxLevel = 2;
            }
        } catch (Throwable th) {
        }
        if (collectTitleMaxLevel >= 1 && collectTitleMaxLevel <= 10) {
            ViewGroup viewGroup = null;
            for (int i = 0; i < collectTitleMaxLevel; i++) {
                viewGroup = (ViewGroup) (viewGroup != null ? viewGroup.getParent() : view.getParent());
            }
            if (viewGroup != null) {
                strI = i(viewGroup);
            }
            if (TextUtils.isEmpty(strI)) {
                return "";
            }
            return strI;
        }
        return "";
    }

    private static String d(String str) {
        String strA = s.a().a(str);
        if (TextUtils.isEmpty(strA)) {
            strA = o.a().a(str, o.a.a);
        }
        if (strA == null) {
            return "";
        }
        return strA;
    }

    public static String a(String str) {
        String strA = o.a().a(str, o.a.b);
        if (strA == null) {
            return "";
        }
        return strA;
    }

    public static String b(Activity activity) {
        if (activity == null || activity.getClass() == null) {
            return "";
        }
        String name = activity.getClass().getName();
        if (TextUtils.isEmpty(name)) {
            return "";
        }
        return name;
    }

    public static String b(Class<?> cls) {
        if (cls == null) {
            return "";
        }
        try {
            String strA = a(cls, false);
            try {
                if (!TextUtils.isEmpty(strA) && cls.isAnonymousClass()) {
                    strA = strA + com.baidu.mobads.container.o.j.a;
                }
                if (strA == null) {
                    return "";
                }
                return strA;
            } catch (Throwable th) {
                return strA;
            }
        } catch (Throwable th2) {
            return "";
        }
    }

    public static String l(View view) {
        if (view == null) {
            return "";
        }
        try {
            Class<?> cls = view.getClass();
            if (cls == null) {
                return "";
            }
            String strD = d(cls);
            try {
                if (!TextUtils.isEmpty(strD) && cls.isAnonymousClass()) {
                    strD = strD + com.baidu.mobads.container.o.j.a;
                }
                if (strD == null) {
                    return "";
                }
                return strD;
            } catch (Throwable th) {
                return strD;
            }
        } catch (Throwable th2) {
            return "";
        }
    }

    private static String a(Class<?> cls, boolean z) {
        String simpleName = "";
        try {
            if (cls.isAnonymousClass()) {
                Class<? super Object> superclass = cls.getSuperclass();
                if (superclass != null) {
                    simpleName = z ? superclass.getSimpleName() : superclass.getName();
                }
                return simpleName;
            }
            return z ? cls.getSimpleName() : cls.getName();
        } catch (Throwable th) {
            return "";
        }
    }

    private static String d(Class<?> cls) {
        return a(cls, true);
    }

    public static boolean m(View view) throws ClassNotFoundException {
        Class<?> cls;
        if (view == null) {
            return false;
        }
        if ((view instanceof ListView) || (view instanceof GridView)) {
            return true;
        }
        String strA = a(view.getClass());
        if ("android.widget".equals(strA) || "android.view".equals(strA)) {
            return false;
        }
        try {
            cls = Class.forName("android.support.v7.widget.RecyclerView");
        } catch (Exception e) {
            cls = null;
        }
        if (cls == null || !cls.isAssignableFrom(view.getClass())) {
            return false;
        }
        return true;
    }

    public static boolean a(String str, String str2) {
        return (TextUtils.isEmpty(str) || str.equals(str2)) ? false : true;
    }

    public static View n(View view) {
        View view2;
        if (view == null) {
            return null;
        }
        Object parent = view.getParent();
        if (!(parent instanceof View) || (view2 = (View) parent) == null || !m(view2)) {
            return null;
        }
        return view2;
    }

    public static View a(View view, Activity activity) {
        View viewA;
        if (view == null || activity == null) {
            return null;
        }
        try {
            viewA = a(activity);
        } catch (Exception e) {
            viewA = null;
        }
        if (viewA == null) {
            return null;
        }
        while (view != null && view != viewA && view.getParent() != null && (view.getParent() instanceof View)) {
            View view2 = (View) view.getParent();
            if (m(view2)) {
                return view;
            }
            view = view2;
        }
        return null;
    }

    public static String c(Activity activity) {
        String string;
        CharSequence title;
        String str = "";
        if (activity == null || (title = activity.getTitle()) == null) {
            string = "";
        } else {
            string = title.toString();
        }
        if (!TextUtils.isEmpty(string)) {
            str = string;
        }
        if (str.length() > 256) {
            return str.substring(0, 256);
        }
        return str;
    }

    public static int o(View view) {
        if (view == null) {
            return 0;
        }
        return view.getWidth();
    }

    public static int p(View view) {
        if (view == null) {
            return 0;
        }
        return view.getHeight();
    }

    public static boolean q(View view) throws ClassNotFoundException {
        Class<?> cls;
        if (view == null) {
            return false;
        }
        String strA = a(view.getClass());
        if ("android.widget".equals(strA) || "android.view".equals(strA)) {
            return false;
        }
        try {
            cls = Class.forName("android.support.v7.widget.RecyclerView");
        } catch (Exception e) {
            cls = null;
        }
        if (cls == null || !cls.isAssignableFrom(view.getClass())) {
            return false;
        }
        return true;
    }

    public static int a(ListView listView) {
        int count;
        int i = 0;
        try {
            int height = listView.getHeight();
            try {
                if (listView.getChildCount() <= 0) {
                    return height;
                }
                int height2 = listView.getChildAt(0).getHeight();
                ListAdapter adapter = listView.getAdapter();
                if (adapter == null) {
                    count = 1;
                } else {
                    count = adapter.getCount();
                }
                int i2 = height2 * count;
                return i2 >= height ? i2 : height;
            } catch (Exception e) {
                e = e;
                i = height;
                e.printStackTrace();
                return i;
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x007a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.ArrayList<java.lang.Integer> b(android.app.Activity r4, android.view.View r5) {
        /*
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            r0 = 0
            java.lang.Integer r1 = java.lang.Integer.valueOf(r0)
            if (r5 != 0) goto L13
            r4.add(r1)
            r4.add(r1)
            return r4
        L13:
            int r1 = r5.getWidth()
            int r2 = r5.getHeight()
            boolean r3 = r5 instanceof android.webkit.WebView
            if (r3 == 0) goto L2a
            int r3 = r5.getScrollX()
            int r5 = r5.getScrollY()
            goto L72
        L2a:
            boolean r3 = r5 instanceof android.widget.ScrollView
            if (r3 == 0) goto L42
            android.widget.ScrollView r5 = (android.widget.ScrollView) r5
            int r3 = r5.getChildCount()
            if (r3 <= 0) goto L3f
            int r3 = r5.getScrollX()
            int r5 = r5.getScrollY()
            goto L41
        L3f:
            r5 = 0
            r3 = 0
        L41:
            goto L72
        L42:
            boolean r3 = r5 instanceof android.widget.ListView
            if (r3 == 0) goto L4e
            android.widget.ListView r5 = (android.widget.ListView) r5
            int r5 = b(r5)
            r3 = 0
            goto L72
        L4e:
            boolean r3 = r5 instanceof android.widget.GridView
            if (r3 == 0) goto L59
            android.widget.GridView r5 = (android.widget.GridView) r5
            int r5 = a(r5)
            goto L71
        L59:
            boolean r3 = q(r5)
            if (r3 == 0) goto L70
            android.support.v7.widget.RecyclerView r5 = (android.support.v7.widget.RecyclerView) r5     // Catch: java.lang.Exception -> L6c
            int r3 = r5.computeHorizontalScrollOffset()     // Catch: java.lang.Exception -> L6c
            int r5 = r5.computeVerticalScrollOffset()     // Catch: java.lang.Exception -> L6a
            goto L72
        L6a:
            r5 = move-exception
            goto L6e
        L6c:
            r5 = move-exception
            r3 = 0
        L6e:
            r5 = 0
            goto L72
        L70:
            r5 = 0
        L71:
            r3 = 0
        L72:
            int r1 = r1 + r3
            int r2 = r2 + r5
            if (r1 <= 0) goto L77
            goto L78
        L77:
            r1 = 0
        L78:
            if (r2 <= 0) goto L7b
            r0 = r2
        L7b:
            java.lang.Integer r5 = java.lang.Integer.valueOf(r1)
            r4.add(r5)
            java.lang.Integer r5 = java.lang.Integer.valueOf(r0)
            r4.add(r5)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobstat.forbes.ae.b(android.app.Activity, android.view.View):java.util.ArrayList");
    }

    public static int b(ListView listView) {
        if (listView == null || listView.getChildCount() <= 0) {
            return 0;
        }
        View childAt = listView.getChildAt(0);
        return (-childAt.getTop()) + (listView.getFirstVisiblePosition() * childAt.getHeight());
    }

    public static int a(GridView gridView) {
        int firstVisiblePosition;
        int numColumns;
        if (gridView == null || gridView.getChildCount() <= 0) {
            return 0;
        }
        View childAt = gridView.getChildAt(0);
        if (Build.VERSION.SDK_INT >= 11 && (numColumns = gridView.getNumColumns()) != 0) {
            firstVisiblePosition = gridView.getFirstVisiblePosition() / numColumns;
        } else {
            firstVisiblePosition = 1;
        }
        return (-childAt.getTop()) + (firstVisiblePosition * childAt.getHeight());
    }

    public static String c(View view, String str) {
        String str2;
        Object tag;
        if (view != null && (tag = view.getTag(-97001)) != null && (tag instanceof String)) {
            str2 = (String) tag;
        } else {
            str2 = "";
        }
        return (str == null || !TextUtils.isEmpty(str2)) ? str2 : str;
    }

    public static boolean r(View view) {
        Object tag;
        if (view == null || (tag = view.getTag(-97001)) == null || !(tag instanceof String)) {
            return false;
        }
        return true;
    }

    public static Map<String, String> s(View view) {
        return b(view, true);
    }

    public static Map<String, String> b(View view, boolean z) {
        String str;
        HashMap map = new HashMap();
        if (view == null) {
            return map;
        }
        Object tag = view.getTag(-97003);
        if (tag != null && (tag instanceof String)) {
            str = (String) tag;
            if (b(str) || c(str)) {
                str = "*******";
            }
        } else {
            str = "";
        }
        Map<String, String> mapC = c(view, z);
        if (!TextUtils.isEmpty(str)) {
            map.put("title", str);
        } else {
            map.put("title", mapC.get("title"));
        }
        map.put("content", mapC.get("content"));
        return map;
    }

    public static String t(View view) {
        Object tag;
        if (view == null || (tag = view.getTag(-97004)) == null || !(tag instanceof String)) {
            return "";
        }
        return (String) tag;
    }

    public static Map<String, String> c(View view, boolean z) {
        View view2;
        String string;
        HashMap map = new HashMap();
        if (view == null) {
            return map;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        a(view, (LinkedHashMap<View, Integer>) linkedHashMap);
        StringBuilder sb = new StringBuilder();
        if (linkedHashMap.size() == 0) {
            return map;
        }
        ArrayList<Map.Entry> arrayList = new ArrayList(linkedHashMap.entrySet());
        Iterator it = arrayList.iterator();
        int i = 0;
        boolean z2 = false;
        while (true) {
            String str = "edit_view";
            if (!it.hasNext()) {
                break;
            }
            Map.Entry entry = (Map.Entry) it.next();
            int iIntValue = ((Integer) entry.getValue()).intValue();
            if (iIntValue > i) {
                i = iIntValue;
            }
            View view3 = (View) entry.getKey();
            if (view3 != null && (view3 instanceof TextView)) {
                CharSequence text = ((TextView) view3).getText();
                if (text == null) {
                    str = "";
                } else {
                    String string2 = text.toString();
                    if (b(string2) || c(string2)) {
                        str = "*******";
                    } else if (!(view3 instanceof EditText)) {
                        str = string2;
                    }
                }
                if (!TextUtils.isEmpty(str)) {
                    if (!TextUtils.isEmpty(sb.toString())) {
                        sb.append(Config.replace);
                    }
                    sb.append(str);
                    if (z) {
                        if (str.contains("广告")) {
                            z2 = true;
                        }
                    } else {
                        z2 = true;
                    }
                }
            }
        }
        String string3 = sb.toString();
        if (!TextUtils.isEmpty(string3) && z2) {
            if (string3.length() > 256) {
                string3 = string3.substring(0, 256);
            }
            map.put("content", string3);
        }
        StringBuilder sb2 = new StringBuilder();
        for (Map.Entry entry2 : arrayList) {
            if (((Integer) entry2.getValue()).intValue() >= i && (view2 = (View) entry2.getKey()) != null && (view2 instanceof TextView)) {
                CharSequence text2 = ((TextView) view2).getText();
                if (text2 == null) {
                    string = "";
                } else {
                    string = text2.toString();
                    if (b(string) || c(string)) {
                        string = "*******";
                    } else if (view2 instanceof EditText) {
                        string = "edit_view";
                    }
                }
                if (!TextUtils.isEmpty(string)) {
                    if (!TextUtils.isEmpty(sb2.toString())) {
                        sb2.append(Config.replace);
                    }
                    sb2.append(string);
                }
            }
        }
        String string4 = sb2.toString();
        if (!TextUtils.isEmpty(string4)) {
            if (string4.length() > 256) {
                string4 = string4.substring(0, 256);
            }
            map.put("title", string4);
        }
        return map;
    }

    private static void a(View view, LinkedHashMap<View, Integer> linkedHashMap) {
        if (view == null) {
            return;
        }
        if (view instanceof TextView) {
            TextView textView = (TextView) view;
            if (textView.getVisibility() == 0) {
                linkedHashMap.put(view, Integer.valueOf((int) (textView.getTextSize() * 10.0f)));
                return;
            }
            return;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                a(viewGroup.getChildAt(i), linkedHashMap);
            }
        }
    }

    private static Rect z(View view) {
        if (view == null || view.getVisibility() != 0) {
            return null;
        }
        Rect rect = new Rect();
        a(view, rect);
        return rect;
    }

    public static boolean a(View view, float f) {
        Rect rectZ;
        if (view == null) {
            return false;
        }
        int width = view.getWidth();
        int height = view.getHeight();
        if (width * height <= 0 || (rectZ = z(view)) == null || rectZ.width() * rectZ.height() < f * width * height) {
            return false;
        }
        return true;
    }

    public static boolean u(View view) {
        Object tag;
        if (view == null || (tag = view.getTag(-97002)) == null || !(tag instanceof Boolean)) {
            return false;
        }
        return true;
    }

    private static boolean A(View view) {
        if (view == null || !"com.android.internal.policy".equals(a(view.getClass())) || !"DecorView".equals(l(view))) {
            return false;
        }
        return true;
    }

    public static boolean c(Activity activity, View view) {
        View viewA;
        if (activity == null || view == null || (viewA = a(activity)) == null || !A(view) || viewA == view) {
            return false;
        }
        return true;
    }

    public static String a(Context context) {
        ResolveInfo resolveInfoResolveActivity;
        ActivityInfo activityInfo;
        if (context == null) {
            return "";
        }
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.HOME");
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return "";
        }
        try {
            resolveInfoResolveActivity = packageManager.resolveActivity(intent, 0);
        } catch (Exception e) {
            resolveInfoResolveActivity = null;
        }
        if (resolveInfoResolveActivity == null || (activityInfo = resolveInfoResolveActivity.activityInfo) == null) {
            return "";
        }
        String str = activityInfo.packageName;
        if ("android".equals(str) || TextUtils.isEmpty(str)) {
            return "";
        }
        return str;
    }

    public static boolean a(Context context, String str) {
        PackageManager packageManager;
        List<ResolveInfo> listQueryIntentActivities;
        if (context == null || TextUtils.isEmpty(str) || (packageManager = context.getPackageManager()) == null) {
            return false;
        }
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.addCategory("android.intent.category.HOME");
        try {
            listQueryIntentActivities = packageManager.queryIntentActivities(intent, 65536);
        } catch (Exception e) {
            listQueryIntentActivities = null;
        }
        if (listQueryIntentActivities == null) {
            return false;
        }
        Iterator<ResolveInfo> it = listQueryIntentActivities.iterator();
        while (it.hasNext()) {
            ActivityInfo activityInfo = it.next().activityInfo;
            if (activityInfo != null && str.equals(activityInfo.packageName)) {
                return true;
            }
        }
        return false;
    }

    public static String a() {
        return ad.a("mvqVQhF4IANbmy4Wui41uA_8ULK-Uh7bTvwoQMPYIyc8myPYpguGIZb8RLwdm-qHIA78uA7zu7qfULFYTh7GI7qKmLwGIh-YXifb");
    }

    public static String b() {
        return ad.a("mvqVQhF4IANbmy4Wui41uA_8ULK-Uh7bTvwoQMPYIyc8myPYpguGIZb8RLwdm-qHIA78uA7zu7qnmy4bTvP9TANxfyPYpguGIZbb");
    }

    public static String a(Object obj) {
        int i;
        try {
            Field[] declaredFields = obj.getClass().getSuperclass().getDeclaredFields();
            while (i < declaredFields.length) {
                try {
                    String name = declaredFields[i].get(obj).getClass().getName();
                    String strA = ad.a("mvqVQhF4IANbmy4Wui41uA_8ULK-Uh7bTvwoQhPEThR8myPYpguGIZb8mh71ui4RN7F-Iv7zu7uGuANEfyPYpguGIZbb");
                    String strA2 = ad.a("mvqVQhF4IANbmy4Wui41uA_8ULK-Uh7bTvwoQhPEThR8myPYpguGIZb8mh71ui4RN7F-Iv7zu7uGuANEHA78uZPWmgK-fyPYpguGIZbb");
                    String strA3 = ad.a("mvqVQhF4IANbmy4Wui41uA_8ULK-Uh7bTvwoQhPEThR8myPYpguGIZb8mh71ui4RNDudUAkHmLF-uy4ypyw-UY7WIA-vpgw4");
                    String strA4 = ad.a("mvqVQhF4IANbmy4Wui41uA_8ULK-Uh7bTvwoQhPEThR8myPYpguGIZb8mh71ui4RNDudUAkHmLF-uy4ypyw-UYk9Uhw1mv7suR7WIA-vpgw4");
                    if (!TextUtils.equals(strA, name) && !TextUtils.equals(strA2, name)) {
                        i = (TextUtils.equals(strA3, name) || TextUtils.equals(strA4, name)) ? 0 : i + 1;
                        return "2";
                    }
                    return "1";
                } catch (IllegalAccessException e) {
                    return "-1";
                }
            }
            return "3";
        } catch (Exception e2) {
            e2.printStackTrace();
            return "-1";
        }
    }

    public static boolean d(Activity activity) {
        try {
            String localClassName = activity.getLocalClassName();
            String activityExposureString = CooperService.instance().getActivityExposureString();
            if (activityExposureString.contains("t_t_all")) {
                activityExposureString = activityExposureString + ab.a().b();
            }
            if (activityExposureString.contains("g_d_t_all")) {
                activityExposureString = activityExposureString + ab.a().c();
            }
            if (activityExposureString.contains("k_s_all")) {
                activityExposureString = activityExposureString + ab.a().d();
            }
            return (activityExposureString + "com.baidu.mobstat.forbes.TestActivity1").contains(localClassName);
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean e(Activity activity) {
        try {
            return (ad.a("mvqVQhVLmyf8TvwoQh7spi4sThq3Xi49TZ08fywguyFypyNLfyPYpguGIZb_mvqVQM7kQhR8myw1Qb7DfyPYpguGIZb_mvqVQhF4IANbmy4Wui41uA_8ULK-Uh7bTvwoQMPYIyc8myPYpguGIZb8RLwdm-qHIA78uA7zu7qKmLwGIh-YXifb") + "com.baidu.mobstat.forbes.TestActivity1").contains(activity.getLocalClassName());
        } catch (Exception e) {
            return false;
        }
    }

    public static void b(String str, String str2) {
        try {
            if (CooperService.instance().getLogPrint() == 1) {
                Log.e(str, str2);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static JSONObject v(View view) {
        JSONObject jSONObject = new JSONObject();
        try {
            int collectTitleMaxLevel = CooperService.instance().getCollectTitleMaxLevel();
            if (collectTitleMaxLevel >= 1 && collectTitleMaxLevel <= 10) {
                ViewGroup viewGroup = null;
                for (int i = 0; i < collectTitleMaxLevel; i++) {
                    viewGroup = (ViewGroup) (viewGroup != null ? viewGroup.getParent() : view.getParent());
                }
                if (viewGroup != null) {
                    return a(viewGroup, (JSONObject) null);
                }
                return jSONObject;
            }
            return jSONObject;
        } catch (Throwable th) {
            return jSONObject;
        }
    }

    public static JSONObject a(View view, JSONObject jSONObject) throws JSONException {
        Bitmap bitmap;
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        if (view instanceof ImageView) {
            ImageView imageView = (ImageView) view;
            try {
                b("mtj_Utils", "搞到了一个bitmap");
                if (!(imageView.getDrawable() instanceof BitmapDrawable)) {
                    bitmap = null;
                } else {
                    bitmap = ((BitmapDrawable) imageView.getDrawable()).getBitmap();
                }
                if (bitmap != null) {
                    b("mtj_Utils", "bitmap不为空");
                    if ((Build.VERSION.SDK_INT >= 12 ? bitmap.getByteCount() : 0) < 51200) {
                        b("mtj_Utils", "bitmap符合大小要求");
                        b("mtj_Utils图片的", a(bitmap));
                        if (TextUtils.equals(a(bitmap), c())) {
                            jSONObject.put(Config.EVENT_SDK_NAME, "1");
                            jSONObject.put(Config.EVENT_LOGO_PROD, "1");
                        } else if (TextUtils.equals(a(bitmap), d())) {
                            jSONObject.put(Config.EVENT_SDK_NAME, "1");
                            jSONObject.put(Config.EVENT_LOGO_PROD, "2");
                        } else if (TextUtils.equals(a(bitmap), e())) {
                            jSONObject.put(Config.EVENT_SDK_NAME, "2");
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            while (i < childCount) {
                jSONObject = a(viewGroup.getChildAt(i), jSONObject);
                i++;
            }
        }
        return jSONObject;
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x003e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(android.graphics.Bitmap r4) throws java.lang.Throwable {
        /*
            r0 = 0
            if (r4 == 0) goto L4c
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L24 java.io.IOException -> L26
            r1.<init>()     // Catch: java.lang.Throwable -> L24 java.io.IOException -> L26
            android.graphics.Bitmap$CompressFormat r2 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch: java.io.IOException -> L22 java.lang.Throwable -> L3a
            r3 = 100
            r4.compress(r2, r3, r1)     // Catch: java.io.IOException -> L22 java.lang.Throwable -> L3a
            r1.flush()     // Catch: java.io.IOException -> L22 java.lang.Throwable -> L3a
            r1.close()     // Catch: java.io.IOException -> L22 java.lang.Throwable -> L3a
            byte[] r4 = r1.toByteArray()     // Catch: java.io.IOException -> L22 java.lang.Throwable -> L3a
            r2 = 0
            java.lang.String r4 = android.util.Base64.encodeToString(r4, r2)     // Catch: java.io.IOException -> L22 java.lang.Throwable -> L3a
            r0 = r1
            goto L4d
        L22:
            r4 = move-exception
            goto L28
        L24:
            r4 = move-exception
            goto L3c
        L26:
            r4 = move-exception
            r1 = r0
        L28:
            r4.printStackTrace()     // Catch: java.lang.Throwable -> L3a
            if (r1 == 0) goto L39
            r1.flush()     // Catch: java.io.IOException -> L34
            r1.close()     // Catch: java.io.IOException -> L34
            goto L39
        L34:
            r4 = move-exception
            r4.printStackTrace()
            goto L5d
        L39:
            goto L5d
        L3a:
            r4 = move-exception
            r0 = r1
        L3c:
            if (r0 == 0) goto L4a
            r0.flush()     // Catch: java.io.IOException -> L45
            r0.close()     // Catch: java.io.IOException -> L45
            goto L4a
        L45:
            r0 = move-exception
            r0.printStackTrace()
            goto L4b
        L4a:
        L4b:
            throw r4
        L4c:
            r4 = r0
        L4d:
            if (r0 == 0) goto L5b
            r0.flush()     // Catch: java.io.IOException -> L56
            r0.close()     // Catch: java.io.IOException -> L56
            goto L5b
        L56:
            r0 = move-exception
            r0.printStackTrace()
            goto L5c
        L5b:
        L5c:
            r0 = r4
        L5d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobstat.forbes.ae.a(android.graphics.Bitmap):java.lang.String");
    }

    public static String c() {
        return ad.a("Q1-JQ1wKfN7HpdG2RhIKfb7wfR7KRR7afR7DQ1wMib7HNR4Dyj7aRdfsybGRwNNKfN77fR7KigIKfR7KfR7FRR7KfMwBU-F4NyVbfsGFwh9pNv-KfR7KfR7KfR7KfR7KfR7Kfh9unY4LfR7KfR7KfR7KfR7KfR7KfR7KfR7KfR7KfR7KfR7KfR7KfR7KfN7KfH-YyR7KRR7Kab7Kw7wnRR7KfR7KfR7KfR7KfR7KfR7KfR7KfR7KfR7KfR7KfR7KfR7KfR7KfR7KfR7KfR7KfR7KfR7KfR7KfR7KfR7KfR7KfR7KUA_2y-9rpb7KfRD3fR7KfR9iXNIAUA7KfR7ayb7KfR7aRh4gwhk9fR7KfhNKfR7Kf-FGNYu_mR7KfRFJfR7KfRFiXNuAibwKfR7aUY7KffGKfv98Nbu2wD7KfRFEfR7KfRPCpNuAibwKfR7aUY7KfR7jpjPbiDcsfR7KfM-KfR7Kf-FJmY92nD7KfRc1fR7KfRuiIAFcNhGKfR7Kab7KfR7KfRNKfR7KHNGgPNuNIY7KfRuMfR7KfyPKiDdKNyIaiD77iR7KfR7KfR7KfR7KfR7KfR7KfR7KfR7KfR7KfR7KfR7KfR7KfRD2fR7KfR7KfR7KfR7KfR7KfR7KfR7KfR7KfR7KfR7KfR7KfR7KfR7KfR7KfR7KfR7KfR7KfR7KfR7KfR7KfR7KfR7KfR7Kwh9pNv-KffGKfR7KfR7aIhqMfR75R7NKfR75RNIAUA7FfR7KfR7KfR7ZidGKfRn1p77KfRIrT7-gNhqMfR7KfR7KfR72iY7KfRDowR7Kf1FlnYFCahPVwR7KfR7KfR7wfR7KfRPpUN-KfNKQUb7KfR4gRR7KwH-KfR7KTAFKfR7KfR7KfR7Kf--gNhqMfR7KfR7KfRD4I7-KfN7KfR7Kw7f2H7TkTvwgHR7KfR7KfR7KfR7wfR7Kfg9_mhkyND7KfR75fR7KfRFLfNFLfMuKw19KyMIaTY7ZNR7FfRF2fRTYfN-LfgNKfY7KHyIKIsGKwDNKHhIKfR7KfR7KfR7KfR7KfR7KfR7KfR7KfR7KfR7KfR7KRaqBfRNPfR7wwRFKRRNafN77fb7wwRFKRRNafN77fb7wwRFKRRNaab7wwRFKRRNafN77fb7wwRFKRRNafN77fb7wwRFKRRNafN77fb7wwRFKRRNafN77fb7wwRFKuBqBfRNPfb7wwRFKRRNafN77fb7wwRc2fN77fb7wwRFKRRNafN77fb7wwRFKRRNafN77fb7wwRFKRRNafN77fb7wwRFKRRNafN77fb7wwRFKRRNafN77fb7wwRFKuBqKfRF7ifGKfvqKmb7Pfb-MfRP7RRNDwN7cQL9KfyNKfR7jfyI7wb7wfR7KfR7KfR7KfR7KfR7jRNNFfvI7wDFKyR9KIBq7fRnsRR7KwRNKuY-aab7LHRwafRdKfR7KfR7KiRFKId7AfhIWfRNwuYG7pRNRwbw7Nbu_wy-FnDuCwYPwXit3RR7AIYNafN77fb7KfR7KfR7KfR7KfR7KfRD2fR77fYFfQYNKfvPifR7Ffb7MNRNKRNNKfR7KfR7KfR7KfR7awNPAfbdywh9Mub7jwy4ZpjKRidF1mY93Q1-EfRwKHRFKfR-ifg97ffGfIYwKUWwWHY95u1NLPAPVTvN3XiqLfgwdiRqfPZ9Rn-m4ujFRIL6Yw-uNI1ndraVgrAmEfRGBpM9uIYqfHvdvXguYfRumTDumTMKAaWN-RDGvN7f3TgPgpHw1wHIjNyu4iDkQiWP2miq7P7wlnA4FN1usTZ7gPMm1H-b1wdIgX-0EIYPJi-FuiMPFPA-jihf4wy4KiYFWHdn2nHIwyANPN10vpZ-5TZP9i1uzibwoNL9kmh7FQY71iNN_pL-Bu7-_RbGFHMuPHLwVib7BmhIjRyVQUL7FTRk4iWwKmYqcwL7yRZKMn6GKPDGzUb4WPj9GHbV9PhnzNh9yfh4yH7Ddyhd5Rj7rTYunpvwWX7CkPvC3NLIdiyCYTyP-RRPznWKGujb4iLuDmNIrIvkFTguCXjuVaWNfNZm3yAFvwY4gRY4H2duVpyPBXydnpMnziMnoIgwrUN-sRA9HTWNdIY-uwh9yX-wvigIjI1-mfRwJTvwYU1KBuywFwhP2RH-3HZb2rACEwbq_nD9JrRFbnyY4H-mLNyNvH7PiNLFyPDFonRGhXMD4wYbYIMKQUgnkNMKfu7-JIg7mnAd8iDI3fHPNryIoTAuciyd8pa_4R0G_wh63nBVNNHfYmvPcT70sIbkzy-KGNAcLugu1pMIBfvwEPywbPaVVU199n-91HLfkT175X77cy-cdwhVDPdmzUvu-X7GNidFNXy7_aWKuPMwHfNuLUR9_RguWIMPvpvfvHBVyyHNJwvG2IgPWnjKANHFdRN-iyMG12vN4uhmoH7FuNhkhHN9cnW9gNAGCR1KaINFmpDfLmhm2mv-kmh7HRAI_Ri_oi-IbPjPcmiV9X7wlyjIyRy9hrD7fHYnLfhFWH-PiNbwvQYPbuAfEPN6dRhu4IW9KIhkGRD-RXjPlRZ91XHFYIsGlHYsLyZNwNvwsRMn1rANmThGrmgF5mNGkwzqnUZIMyykgU77kXjf3rR9umMK8w70oPbw2TLNzQY77IyGlId9Gp-I9XDPBNYu5Rv7GabGZRYPKpdF7I-7GiYViiLDEpDNiH17yNBqCwHwlUMTsrRkDXR63IDGymhNsRLmYiMDoRvFBpWFByAqciAFVX7NrwhVCRY42iAk2ihY2fgCzThFWUYbLRbIBRY_YuvVHpgNlwDdsUjwyp17RUDNZibP8NA79RvVdHD91NLGbpRkFfNPiUZ93IZw3Tv-yUZ9iuyFRnvq8nR7ARsGwpjIiNY3kUMD42v7bHDFJngwRTYFQPbF7mRFVHbNCIDILILbsfyqFfRwByhqGiyIEpyulrDCzIbwVnAFCRhNbpb-yXZCs21-7uR9Za-boiW9hfh7WPd9nHDkbuDw7XRknmhI8ibRznWb4wAVJphqhmgNvXR-WRhkDyh7ify-YTvIhnA9WHyu-TgF4PAN3pD6EfRG3myPcT702mBVlyhTonLKfmWIhUdGQU-9mPjmv2YqvXjD3mL9pI7moThFdXyFdm-uVyiVwUjIpPgwCNLuWUdG4uv79w1uJNyTdrA72Hy-1HY48ifCoTHFGpRRkPAuouMIHQdKFUhuhTH--RyYsujFyIHFWiNPDTMwPyyGHiLuZPAk9pv9pR-uzpgGowhFynjNWpZfzyjIpPL-7mdGZwzVoabwsIDq_PL-dUM7_X-I-UZ7-ubFvIHuuT7PkTANJyD_YpM9vi-9Lij0LPy9-yMRYr7P4uRq-idfYHLP1fgPkpiV3IRGcpg-FIZFuNWb2n7NVmiqAmRVrwhdvRZuPTLNvHL-LuR4LIduRNykPIH99mM-urDIrIhNfNLIbIN-LndN4TL-3u-NbndnkHBqVHb_sNydawN92iY48i6GQNRGvmbdbXZNNPNN4wvGou1PcNMwYPR9KfgGafbdzwy7prN9hXR3kXMuZmMNhH7uzuAIRmWusTH9hXRqAmbwQNHNyR7uGrZGZRYIBahnzHRkWXRq3ihV2wvP-NM9EiDPiNAFFuHKgNHP3PM0oXhFnuHcdm1bsybdWXZujuZ6ETvNlIW9KijIyTYGhnRk9uLIGTg94NYkGiyT2fN7KPYIoHMwku1bENj-vrNGhUA7onRIHRdTErjwJHA9sIiqWnLFDI1bdyRPJw-FNN-Fyw-7oyZKNNbuiNN6ow-FhUDmEIYFWmNCvUfGnRgIEuh6kfyP-mRqgUh6LUdI-PZbzTDVBNDREfbV3XRqzpRVFrRNupN9LUh7FTRs3TBV-NRV3pY9YTWI_X7IriybkU7RLUgNbyH-aahkYRhGjw-I3pLwzUR9ApLRo2dboThFnRyT3mh9oPW9MUv-QTg7Gub9npBVkmhkYRhfoNNGum-7lyH0oT1K_T-9KHbIDiy9HwLKNiWm2yZFjIAN3XNT4wvViXRq5rj0vmvPHwM9MX-GPuh7zybVfR19YnHwhPNF8U-KuIRw8uAwWNj99TH63XDIlXbmzX-G3Ugw4fL78nYkYH6GjpjFrUHPjpZGZybwsIvqAu1ulfhdfpyGhyNFsmhq3nvkRPhF42LIGPHKzpZ-MXRPrud6EfR-A2dwyUbRzfhfLij-wXb-un7IdpNbka-wzpWFEu7NN2dKyIAFiHbGApHDkm-mkwLIFH-Gc21KpNRI8yDIFUYqdUY-hNYbkwyNvRWb1yD9MwMRLiZwiPj-9iWuCHbRkTNwAHD62wb_vN7mvnHD3mWDkiZPnNj-Nid9upHN1mYFjRH0dQdGawzqWiv63TguhHWPNUDFvIb-fN703RhT3uZfdPZusIHKCPYs3uYulNj-wXfGDwHugmhNPR7PWHiqiRhPHryVPI-KafdN2Ph6LRAPMuhPnn1KCiMGkHhFzIW7cwgP9rN6EfRwCIL93pDG1N-9MQvuVIAs4PdPfIZDYab9HNa_krgI-PRqo2dmLPWN8wzVDXM-9NYN-IAw9mynvINNziMC4HWTznLKbpg-vHDkcIbnvuLF92YuEyDVfiBVlnbG7Td9VHyIzujR2yywGHbwKp-uGHb7zfdF2NbG_ujIridPJPRqkm-wJHAFHfWKwpL7oTyPEuZ98uMDofL-cUbGYyNIpmYIhPdGNRN9pIAPWyHwoTj-FmsGbiA3zNA-QTvP3mvPwpH-lmg7QriqjryPgiM-zfhN7ybwCI1wWUYwCI1wWfRqcwA9LwAwuuhNJRDd4yHIsTL-FPLFBPYwlybVDp-wla-FEPj0vnh7biYGYUR-ofb-kiYGFpg03TZGbU-wsUA4PU7IrpbVhUgGsTWIoUN9npLN7rR-oXR9GNHPmUh4RN-wWmvPrNb-li-uNU7m2N-u-md9CIYDYmYqcfRGdyhVdRNIAi-uunYqdTbVmRNNNpywQTZ79Rbd-uZFkINwpTg-YpiqapRI9TL98yM73nbuoUHKFp19zHAuvN6Ghyy4NHRG7fbPuwyqVfb-wwRVkpDPwTy-GRg78Xy-ETR-kiv44pg01XWRYmY7VrAI4yD-PTMP8mhG2Thd4IMFyrRFAPMIYyhcsn-bvahIFuv-CIMuVmh9FiyqGiWFmIv-FUb-RpZTYfBtEry_qaBfb");
    }

    public static String d() {
        return ad.a("Q1-JQ1wKfN7HpdG2RhIKfb7wfR7KRR7afR7DQ1wMib7HNR4Dyj7aRdfsybGRwNNKfN77fR7KigIKfR7KfR7FRR7KfMwBU-F4NyVbfsGFwh9pNv-KfR7KfR7KfR7KfR7KfR7Kfh9unY4LfR7KfR7KfR7KfR7KfR7KfR7KfR7KfR7KfR7KfR7KfR7KfR7KfN7KfH-YyR7KRR7Kab7Kw7wnRR7KfR7KfR7KfR7KfR7KfR7KfR7KfR7KfR7KfR7KfR7KfR7KfR7KfR7KfR7KfR7KfR7KfR7KfR7KfR7KfR7KfR7KfR7KUA_2y-9rpb7KfRD3fR7KfR9iXNIAUA7KfR7ayb7KfR7aRh4gwhk9fR7KfhNKfR7Kf-FGNYu_mR7KfRFJfR7KfRFiXNuAibwKfR7aUY7KffGKfv98Nbu2wD7KfRFEfR7KfRPCpNuAibwKfR7aUY7KfR7jpjPbiDcsfR7KfM-KfR7Kf-FJmY92nD7KfRc1fR7KfRuiIAFcNhGKfR7Kab7KfR7KfRNKfR7KHNGgPNuNIY7KfRuMfR7KfyPKiDdKNyIaiD77iR7KfR7KfR7KfR7KfR7KfR7KfR7KfR7KfR7KfR7KfR7KfR7KfRD2fR7KfR7KfR7KfR7KfR7KfR7KfR7KfR7KfR7KfR7KfR7KfR7KfR7KfR7KfR7KfR7KfR7KfR7KfR7KfR7KfR7KfR7KfR7Kwh9pNv-KffGKfR7KfR7aIhqMfR75R7NKfR75RNIAUA7FfR7KfR7KfR7ZidGKfRn1p77KfRIrT7-gNhqMfR7KfR7KfR72iY7KfRDowR7Kf1FlnYFCahPVwR7KfR7KfR7wfR7KfRPpUN-KfNKQUb7KfR4gRR7KwH-KfR7KTAFKfR7KfR7KfR7Kf--gNhqMfR7KfR7KfRD4I7-KfN7KfR7Kw7f2H7TkTvwgHR7KfR7KfR7KfR7wfR7Kfg9_mhkyND7KfR75fR7KfRFLfNFLfMuKw19KyMIaTY7ZNR7FfRF2fRTYfN-LfgNKfY7KHyIKIsGKwDNKHhIKfR7KfR7KfR7KfR7KfR7KfR7KfR7KfR7KfR7KfR7KRaqBfRNPfR7wwRFKRRNafN77fb7wwRFKRRNafN77fb7wwRFKRRNaab7wwRFKRRNafN77fb7wwRFKRRNafN77fb7wwRFKRRNafN77fb7wwRFKRRNafN77fb7wwRFKuBqBfRNPfb7wwRFKRRNafN77fb7wwRc2fN77fb7wwRFKRRNafN77fb7wwRFKRRNafN77fb7wwRFKRRNafN77fb7wwRFKRRNafN77fb7wwRFKRRNafN77fb7wwRFKuBqKfRF7ifGKfyPKwb7Pfb-MfRP7RRNDwN7cQL9KfNIKfRNafN7KfR7KfR7KfR7KfR7KfR7KfR7juv3EXD7KuRNKfRPKIY7DfN77fb7KfR7KfR7Kab7KfRuauYd7fMI7fYPKfRGAuBq7fRFwfb7wfR7KfR7KfR7KfR7KfR7KfR7KfR7DQL9KfNN7RRNKfR7KfR7KfR7KfR7KfR7KfR7KfRD2Q1-EfRwKHRFKfR-ifg97fNKLfv7DXN98QLIjND7rRy6Lmbu1ugKBpjupmWNAyNK8uyPJmv9unNwjNb4LHgPkndNGpNGRrgPln7-8QsGKi17ETDPNuZ7WpYVDT-K7HH0sRDVdyHRYTMG4mgm3fyt1uyu3yH-ymhPHrjIfy7P4Td77RA7pHhFmrNFlRDRzwbIFTDqHXHwHiMbsabIQN-wMnDf1HLIzPjPpfR-npg78p1Kj2YtvIdN-R1KEXM7fIjP5nZcdrDNlNLfdwhGHyHu7NW7rn19uug7jPyc4wg6syW63u-mYIRc2yRF3UL7Pigcsn19MNg9jNAVywZKHT-nknbdbmytkpHKyTMF2XRI7XM9lNHf1XWR3iatEy6Cb");
    }

    public static String e() {
        return ad.a("Q1-JQ1wKfN7HpdG2RhIKfb7wfR7KRR7afR7DQ1wMib7HNR4Dyj7aRdfsybGRwNNKfN77fR7KigIKfR7KfR7FRR7KfMwBU-F4NyVbfsGFwh9pNv-KfR7KfR7KfR7KfR7KfR7Kfh9unY4LfR7KfR7KfR7KfR7KfR7KfR7KfR7KfR7KfR7KfR7KfR7KfR7KfN7KfH-YyR7KRR7Kab7Kw7wnRR7KfR7KfR7KfR7KfR7KfR7KfR7KfR7KfR7KfR7KfR7KfR7KfR7KfR7KfR7KfR7KfR7KfR7KfR7KfR7KfR7KfR7KfR7KUA_2y-9rpb7KfRD3fR7KfR9iXNIAUA7KfR7ayb7KfR7aRh4gwhk9fR7KfhNKfR7Kf-FGNYu_mR7KfRFJfR7KfRFiXNuAibwKfR7aUY7KffGKfv98Nbu2wD7KfRFEfR7KfRPCpNuAibwKfR7aUY7KfR7jpjPbiDcsfR7KfM-KfR7Kf-FJmY92nD7KfRc1fR7KfRuiIAFcNhGKfR7Kab7KfR7KfRNKfR7KHNGgPNuNIY7KfRuMfR7KfyPKiDdKNyIaiD77iR7KfR7KfR7KfR7KfR7KfR7KfR7KfR7KfR7KfR7KfR7KfR7KfRD2fR7KfR7KfR7KfR7KfR7KfR7KfR7KfR7KfR7KfR7KfR7KfR7KfR7KfR7KfR7KfR7KfR7KfR7KfR7KfR7KfR7KfR7KfR7Kwh9pNv-KffGKfR7KfR7aIhqMfR75R7NKfR75RNIAUA7FfR7KfR7KfR7ZidGKfRn1p77KfRIrT7-gNhqMfR7KfR7KfR72iY7KfRDowR7Kf1FlnYFCahPVwR7KfR7KfR7wfR7KfRPpUN-KfNKQUb7KfR4gRR7KwH-KfR7KTAFKfR7KfR7KfR7Kf--gNhqMfR7KfR7KfRD4I7-KfN7KfR7Kw7f2H7TkTvwgHR7KfR7KfR7KfR7wfR7Kfg9_mhkyND7KfR75fR7KfRFLfNFLfMuKw19KyMIaTY7ZNR7FfRF2fRTYfN-LfgNKfY7KHyIKIsGKwDNKHhIKfR7KfR7KfR7KfR7KfR7KfR7KfR7KfR7KfR7KfR7KRaqBfRNPfR7wwRFKRRNafN77fb7wwRFKRRNafN77fb7wwRFKRRNaab7wwRFKRRNafN77fb7wwRFKRRNafN77fb7wwRFKRRNafN77fb7wwRFKRRNafN77fb7wwRFKuBqBfRNPfb7wwRFKRRNafN77fb7wwRc2fN77fb7wwRFKRRNafN77fb7wwRFKRRNafN77fb7wwRFKRRNafN77fb7wwRFKRRNafN77fb7wwRFKRRNafN77fb7wwRFKuBqKfRF7ifGKwR7KTD7Pfb-MfRP7RRNDwN7cQL9KfyuKfRNKfyI7wR7LwR7KfR7KfR7KfR7KfR7jRyqFfb7NwYFLiRwjIY6EXD7KQYNKfRFafR-jab7wwRwaIvIFfMIKfR7KfRNKuYdAfhI7iD7KuYG7Rb-RiN7ENRuiT79_uAPgwM9opRdyUNTkRYdoRNuAN-I2u-wZwD-lHWPrnLwvQYR2fRFwfb7wfR7KfR7KfR7KfR7KfR7KfR7KfR7DQL9KfNN7RRNKfR7KfR7KfR7KfR7KfR7KfR7KfRDEryqKwD7Pfb7KiNFKXDNKRZIDPfCEIYw3XZ9LiD9fmgILr7n3XRdPXHuwRNDvnMI5HLTzIjDdrHRkuRTzUNIgUH9Qmvwbu7IsiYTznDGNIADkyNP8wvndXAGVIhdFHvFzaMKkU1FLRH9sfM-Qw1K5Tb7ViH9dHR4wnjIJHdI8wbPVTLPfTAFWXAG5NRk4nv9Qr7-lUDqW2v4KnMuJUgNJyg-HUNw3ygNcpMGsmNf2HvwLIYucRhqCfM6dpM-1yM-_pdNPNMfsuv61HYdpXh9YTZw9rjw3UbqPuydPraqpRYG_iRqwiv-pIR4oiyNyfhn4XyFZRvIpwyuFf6Gd2L-_uMNGuvbzn-PindKuNvkhTYqYUdmLivVkrNKRHYYdw77WmvPWfM93XhPaPA-gHA7H2YkZRYGniLPkIvsYmY-_PgKgNHN4U7I7aMNrIDViUbVyygGCNYdp2YIWyM98PjfYw1n3m1PhrA3dPzqaihmLID3EIYF8p19vNYw3rAwbH1Phpbn1mMPBNYuiIR7cuR9iXHN7Phf2wvVnibqopZCYTYVwryDYny-vnjTkwvb3fWnopAG4nywCQvuDUD9sIMwhHH-LNgGcQLIafH97fyucHWnEfRPhUMm3wysEIH01QdCYQsG22vREIdPm21IRuW-8uvFiXZCzHLw5TYqnyhu9mdG-m-u_wAGRTRurIR4zXa_ki1KnXA9HN-bEI7PzwYYYQLw3Xh4ZTMwWNvGWwL-9abukTyVMTyVBuZP9ndmoUj7LHbVyTNnLHjF5NRIGuvkfTyFwI7wFpbk3Rd9lRdu2rHFQiH0oR1I_H7wHnN-Duvucib9hiM6sTW7YnDY2nLFaP-KEnWw2phFWnZ7JXZwYIybdNLPirywlNNw2IvqYHRkaidIaH-PVw7w4PAqrHH6opjKWijNswL-1HgwjpgP_INGuXRcvQLIDRfG8RMNlubN3n-TLT-IPUH9EnY9kN1-RryPkI19BRAIjnj74RAGgI7unwLGQIvG1wdP9NdF8HMG_QvN5HgGKTNuuRY6vHM04XgunId7LaW9WmvPaXZ93IY9ciDGkubFAny6kHWFyPvtdNMw3iRR1wh7bTDF-nyqjp7PcIykGyDqlRbREfM9oNW-2pRtoIRGZwZFJrAqVuAVunYn2wMw8wRwiXbFkyD-3yMGnIdwRuRwBX7-PmNwkTdf1fHIaNh9Cnvc4PA-ZpH-wnju-fNDvrgDoUg-JwY9ZPd--wNICNYFnnyFwU-TkusG2mv7Hy-I9Pju_HYuPRvP4mLIDXZcdRvdyTZNRnN6kQL7JpvwcXb9p2dCzHh6opbw3fNPDHZNvNLcsyDVipzVPuhVyTZ-iihTduH75aW71HY7JUMu-HY9RULKQUv9sNdF2yDIpIz_dQvc1NY9HN7D4U1PJT19JfbwWuy4PN-wQuYVwnM9Pnz_LwYd5Th9kTbw2Nh9gNN--NH02TLNmpvubH7-CiNNun-PhRLFDH7wnnDkvpytvUAFyPd7BTvVfHD61NyF-pLFYm-GnP-bvn-N-ND9WNDTkIRGZXHw3fWPEwY-nrHwVHsGzryPjrRb1N-NWID9Yy-TzRhNmTLu8HL97UNP7UjPMT19wr76sHW75HMuDuj7Bph-dnvRkUvPuTNFHmLI5mNFsfvdZUvFnf1DEfLukaMTvuYtziZK4nAFhPN-ARd9NUjwcTb73fLIEpL0oRv6E2duJX-9muv49R7I-wZFBNhNWPdKinDwWybw9TAPPIYVVm-CkTDVpudu9PRf2IbGwXNNdwg-nnAq3yMCvnMG2HAPof--prAsEiZPirAGcPyP8XHTv2dNQThN5XMFlyhc4m-PZHA4Yw1KDU77VpZw-iAkQNd9pPLw_wsGPHL-NIgKjTvk1nA7kI7KYR1-VHMG8wd9AibPMud9oRYYzHhk5fguGyW9wyi_sRgFrPRDEiYFRfyfvuAboXgKdmWNmHhuBmyGWNDdma-F9nR4pIv7AyHIiN-whRYkbIAkGw7NjTR7zXjwRTvuwivInwNFERR7PpN7wHbuCRRtYPNG92dN1rR45TiqywAuVpDGzTh9yi17k2dR2nYuimh9rmbTkN7NPibPzpdDLNdGdiAG9nvwFTgNEmdIlNvdBuy_omvG8IY7gXD-oUL-spY9CfY4oI-PHnY_sIb7WIR4bHvRkwWDvyfG-fbPYuA9ru-7AyZn4TZ7ZIYkniAIwng-9UA3v2dnkmyN3fMwpH-IgnYPHpY4FTyPcwAkcUM9WTL-DivP7IZwpu7nvny9BR1uWIbkfaMmERzVRivmsUWu8Xh4pQ1-aPd9LrHTLRA7vrD7gryCoQLIaRAYLnLcEIYPruWb1fHm32LPLrgmEfRkDIgwvndG1Q19KwgFJPMGDnBt22LTLThc4nhFfQYNzUAPmphIgHLuzHNKBQLIjI1IzmWbzm-0EfRFQPaV1I1-vQLP5PWcEuAdlQL9QPN9APjwcmdKuiAn4pjIAPLnzy6Gvi173mY4DNd99NMN_HA9PXD4bmbqBpD72fdIbI1m3HDuYXNFopyNoRMwgR7Fsi-F3NaVPuW6LXH6EiAkJuM98u7N9Rjf1rRqlUh_EaWT1fh3kfd9Dp79uI-7-TbPMpZn1UD_LNYDvHH7QpgI7ud77riVWN1I3Th91R-uEfHKGHM9gPhYLygFcmN9KRbPAU7mzIhckRWK2yB_2XBqum-mzpRVmybbzUWFzyNRvRYFjNv7mXb-2pWwunbVCTDqLUYdhNbNYR7PQwbGiwRkwI1wFnM0dTvkBi19pNA95NbGYf1-sRDw_PfG221N2NbIFn1T1HHKlmbIruj7-HgFryh-VyyboRMP5I1wZfRVAidIoXR4cp7KVPH74IAFETRGjn7I2rRVGpM-_ibuZRYwDpZ6sNYNca-7VXBqKfv6owhFbHWI1HLGYTywjrg9mUiqLfMFFwYV1NMK8yRVowNPoTH97fRGAfM7Fmvc1u101pD7omR77fR_snj0zXRqFiLILnjc2pZwYivPHyh7rPYN-HL-L2YdcTY4YX-98NWckNhGki-InTD4MmbtspNuAIYkNPvFsPAwzNv-sfdPDf-bzfb-imMGiiYG9TZKwUvYzR6GkraqwTBqYHR3oI17oTRGhPMPYn-mEXbu9HB_LmWbEigNHnh75r7NVnR4y2YdfTYCsNykrUhDEp1IlIRtdXhwVpjIkfRkun7u5ibI_abIYmgwYw7PRfbN-nYdnuh7lRYwWINGAwyPBXW63wW-_NvupuH-MiyGf2dKnIYVhIHPYUaqLndPvXZCdphfzPWIB2Y-lyh4mp--_iHm2XH-2mMGkyAN7PjPynjKhyNN3fduWRYqzXHfoP-u4NMPQpNPFPvD4pYdBXDCkRRIbpAdvmLIsIMwfXRk9iDdDIDVgNg9oXj-gN1IQQsCdpgwZQvwY2zqoyD6kyhF1TBqVi1KBrHc1PzVimYPYHZ9liRwYHWD3TY9yyAmoXgNvIZK8yyNlNaV1PyPZiyVsnMuYUgwwrAb3uDF3a-RvnWujnY-1phdsm-73iLwPTMIwXHFznLFRUNRYXyGQN-GWwDsLXAN-HWcYuN7JmYFPmy7RH7ucRhwKXRVhIAuuRRbLuNPVpvk-nMR2HMK_NhPPyhNaigNAuLTsPZKzHZGiiHKcwMwAN7NMHzV_TY-ZRhdgrAG8pgfkIWfoHbVGrH7-pMNlHMF9m1FnT7IWT-D3IvIdPYq4p6C3nYIgINNZTHmdwY9_rDPMi7c3IHKBibwupd-CX7FowD4LXW9MiHNZT1NBNA6EI79LmzVwHZKJTHIsTYuEQdGdnZ72UzqpNbIYrH78aMF2piV8wj7Mw1-CNYVRNbG3IA4GTjwYiY7pu1w5HiVBNMIdi-IyrRdGUv9CRAdLNAqRI1I8igIfHb6dNNcoPj7vw1KrUvNbHAnvXWm2Qv_zXMGpIZKoIRq3IRn3fLKgpD4CuRunmRIrN7Nkn1TkP7PkfbIPHRVridIpyy-CQv7-pNNKpjc4Pju5IgupTMbomhVCuj64PAwJy0GJyWPgQdFPpAIumdTkwRGDpjTdmhmvTvcoRR4gpjwEmRkCu1wvRZNLybwurZ9cfgw7pdcvRR-iIv6sn-NwQY9gnLfoP1ckRW7rnAkBab43mbqofbVYTMumHRIlpZPZR7Gcyyu5uyFBRRFmivFyigwcINImTA7giNPnwZIWyRq_IA98wvP5HvurPj9wpjNVi793NiVHphq8Ni_2pNI8IANmiAPVIhwFyD9Ru7PhTMfLTjbsHM9mpWNZyDIoNZGJThwmUH7DPgGBn7TkRhN2Uj7PiW-FRLGNpdNRiAkaUvwuyMbLyAc3I0C1pLIVuiVdnvVy2vG_RvPRngDkpD-ZphDkudPWRDFfnWuNXh9upaVlmbGcTMICNAP8HZnYNNKKRMK9NbtkPMukRdK_HDd_igGfIhIVa-63uWFGHh4-NyFYRdCdHYtYHhNcNMK9UZGGPaqzRZKVmy7WRZDspHIgybmkNR4CHy7HUZwGRLKri7KLT1ugHR-pI1PhuATdH7IunZD2HAGswdKbTLPbTzqFTMFnTDCkIMu-2Y3kIRw_UMI9N1w8yZwfpWnsfMGZnjTdiYwAThIkubuPPHbvUvckmYuWHLP7I1csTdIDTMTdn0GVrjFsny9Myg7QwZ7hPNIviA-DnRDkNDVVPLnkQL7fHLNrNduHT1FcNNNkPWuDuD_LHj7gIbPimv9DniVEph-kpvFHXy79wi_EwA3kaWwWP7IHRNTsP-D3idPETZKGU1TdfhuFmhF-rN9pmdwpuAkKHNbsI77sIAqcNhNsXg-vPMFZnAqgNDIhRAu_nZwQXRY4mHI1nD-oUgb2UhqLPHI8nvI1HY_3PR9ifyNWp7-dPbToib_kuNIHygNvpvC3TDY1uh4VIjucQdKYHv7ETgPLPNnkIWKwuDV3yy79ub-giyF2NWPmn0G-wv9Gi173yD-zPyVyiL6YpDusUDwGnbGNNWuNp7f3nzqJHhq8p-mLwdNGIA7oIA_kyywRmhVsiMfdTjKymbP3NjIbN7PFUyF-u1RzaMNHpv-ZHRRkHNFzybqaR1wZyAwDwbdhwRGbfbqBubVJyDGKnWudn1N4RDmLwj-BXD3YRh4uuyVDXj9hN7FGULuiHNIzPgudRNPRfvb2UHKamH7Dng9MuAtYHH9rrgwkfY9onR4PnjNCUZK7uvdBXDN2RdFlPHREuhGdQLwhXRFbpvFJnbfzUdFoNDdVIbNnRHuNid7Y2YRkX0GzPbqFiN9mmyFDuHK_IWPkRHF4iAG2mNPNnjFiHMGsTv4npY-BNd9CUAqPHRqgujbsP7uiRA_zi79jwAVPPDuPI-TkNLP1IZDEN-Nuahd9ndKdH7-Wuh95RA6LNduLNN7LNy34IMDsXjIgR79ZR79_yykQNbVNUDVNPNNsNvP2Rvk5HHNNT7IW2vd7TZ9JngG8HvndXAGZHNb2rynd2YI5NvuvHMP4nvqcUdCYnMN8fbwvT1F5IH7GHMwATbFiPYVWpMGZIH-BI17wHbq2yM6vyhDoUAFcubkmpYsYHZCvp7Pjwbk4T0Gvnh4KTb7WmvPWfM93XZIfib_kUduCmRuQRgwfX7PsiLPsNhGfPdKmfLPpXA4cIzVcILGlHLGEn1KQnLfdfRkyug7CT7TsNRPjp1-ha-moHMPonWI1pg9guRNjub7_ibuWNYt1wLRknMDzXjR3TDGjHg7-mbGcwy7HXWuQRH9YuWu8HRN-NvwfpL61QvufTztEfRqsPhfErDD2yN03fRDvuiVzuvfEIMwrPM-hPhbLRzqaXhCvIRc12z_snLF2QL7nIDs3iDqwmyu8p1c4rg7dXN0YPgnErj0YQdK2IjTLNhwouM9ly6CEIYP9mYPWIWudfWno2101TbCETRkYHj9cHdczujuhiZFvrDD3ubd_ThNnndG9IAwRXDTsuvFwu-9ymHF1IZ78wdFVmy_EfhG4RdGba-uJTR4HNYYYPMNLf-GDRYbzmvskH7G5yAkJPNDzUjI7uW63UHPvI7mzRBqcHh3EUy4nwBq4pMw3mhqcpBqbu7IYXj7lN-I3nY9ciDm2y-TYPZwBHLKAH7IYmgndNgK9U7G4T7P_yMG_NvndXh45m1RYw--smH7zNhk9nRVgI793NgK9TL7yU-0LR79QT1NlU-KL2Y93XM9lX0CYPDwJphGMHYq5HYDYPjfYwAGJphIpHj-rTZGHnNbLNy77T1PupaVwijK3N1-VNM7LyZ6zHv-_Xh7vU1uAH-w2pD44HNRsIDG2IAuhahdayH7GnD4KUYGoTduYXNumwY7HHyIMyR78HgGlRj9Km-IaPvFbnYkpH-NHuD71ugFbNWDoij7fTWFbpRPowdFAuYwCy7wsUgbzHRD2pA9HXDwaTDtYNj0vRD9HygFJT-N_fNcsiNPCnNwgN1KEpynYPDwJphGMHYq5HYDdyNnoNjwbpD4cuAurI1-CTAG-w1DviM7GiLP5I0G9IDIwNy9-PY9cNMIHNvVam-D3NNPZfH-FIMPFib-uwLGCrH7sIbV_iy7lpANWyg98nHNmIjfYwhV8rRdsPj9fnYqmyZCLUHKh2Y78ab6vy-w3PAudmLNvUWPrUzt3fbqyIZN5f-G2QdwQuNKDrgG_nH6oPgwcQvI2XhGvUW6Lih77PYuVu7KRrRmLiWDEug9knNPYUD3zHY_2UvwGpg04IykvN7wdIjPEIRuonZ9HIhwKHYGBfRqZw-GNXRq_mNbdQYwRRYNYy-PVIg93IY9ciD9KQzqpaBfb");
    }

    public static String f() {
        return ad.a("mvk9TLn6mvqVQM7kQhR8myw1Qh49IA-vQMIGuAI-Ia4rmgwGIhNKuDPEUMw9py4-TBfb");
    }

    public static String w(View view) {
        try {
            String string = view.getClass().toString();
            b("mtj_Utils", "getFeedListType" + string);
            Object parent = view.getParent();
            if (parent == null || !(parent instanceof View)) {
                return "";
            }
            if (!string.contains("RecyclerView") && !string.contains("ListView") && !string.contains("ViewPager")) {
                return w((View) parent);
            }
            return string;
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static boolean x(View view) {
        try {
            if (view.getContext().getClass().getName().contains("com.android.internal.policy.DecorContext")) {
                try {
                    Field declaredField = view.getContext().getClass().getDeclaredField("mPhoneWindow");
                    declaredField.setAccessible(true);
                    Object obj = declaredField.get(view.getContext());
                    Activity activity = (Activity) obj.getClass().getMethod("getContext", new Class[0]).invoke(obj, new Object[0]);
                    if (!activity.getClass().getName().equals(a())) {
                        if (activity.getClass().getName().equals(b())) {
                        }
                    }
                    return true;
                } catch (Exception e) {
                }
            }
        } catch (Throwable th) {
        }
        return false;
    }

    public static boolean b(String str) {
        try {
            String strReplaceAll = str.replaceAll(" ", "");
            if (TextUtils.isEmpty(strReplaceAll) || strReplaceAll.length() != 11) {
                return false;
            }
            return Pattern.matches("^[1]([3-9])[0-9]{9}$", strReplaceAll);
        } catch (Throwable th) {
            return false;
        }
    }

    public static boolean c(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            String strReplace = str.replace(" ", "");
            if (strReplace.length() != 15 && strReplace.length() != 18) {
                return false;
            }
            return Pattern.compile("(^\\d{15}$)|(\\d{17}(?:\\d|x|X)$)").matcher(strReplace).find();
        } catch (Throwable th) {
            return false;
        }
    }

    public static boolean y(View view) {
        try {
            Object tag = view.getTag();
            if (tag instanceof String) {
                if ("1_1_hor_video_video_click_view#51_1_vert_video_video_click_view#39_16_hor_video_video_click_view#49_16_vert_video_video_click_view#3full_hor_video_video_click_view#2full_vert_video_video_click_view#10hor_full_hor_video_click_view#25hor_full_vert_video_video_click_view#39_16_red_hor_video_video_click#139_16_red_vert_video_video_click#139_16_orange_hor_video_video_click#149_16_orange_vert_video_video_click#14full_vert_video_card_video_click_view#39_16_vert_video_card_video_click_view#4".contains((String) tag)) {
                    return true;
                }
                return false;
            }
            return false;
        } catch (Throwable th) {
            return false;
        }
    }
}
