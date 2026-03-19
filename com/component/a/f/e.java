package com.component.a.f;

import android.graphics.Bitmap;
import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.baidu.mobads.container.util.animation.a;
import com.baidu.mobads.container.util.animation.j;
import com.component.a.a.b;
import com.component.a.f.c;
import com.component.a.i.n;
import com.sigmob.sdk.base.mta.PointCategory;
import com.ss.texturerender.TextureRenderKeys;
import io.reactivex.annotations.SchedulerSupport;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class e implements Iterable<e> {
    public static final String[] a = {"text", "background", "button", "config", com.baidu.mobads.container.adrequest.a.a};
    private final JSONObject b;
    private f c;
    private i d;
    private g e;
    private C0316e f;
    private JSONObject g;
    private List<e> h;
    private List<h> i;
    private b j;
    private b k;
    private int[] l;
    private float[] m;
    private int[] n;
    private com.component.a.f.c o;
    private com.component.a.c.a p;

    public static e a(e eVar) {
        e eVar2 = new e(n.b(eVar.f()));
        eVar2.a(eVar.o);
        eVar2.a(eVar.p);
        return eVar2;
    }

    public e(String str) {
        this(n.c(str));
    }

    public e(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.b = jSONObject;
        } else {
            this.b = new JSONObject();
        }
        a();
    }

    public void a() {
        this.c = new f(n.a(this.b, "background"));
        this.d = new i(n.a(this.b, "text"));
        this.e = new g(n.a(this.b, "button"));
        this.f = new C0316e(n.b(this.b, "anim"));
        this.i = h.a(n.b(this.b, "lottie"));
        JSONObject jSONObjectA = n.a(this.b, "config");
        if (jSONObjectA != null) {
            this.g = jSONObjectA;
        } else {
            this.g = new JSONObject();
        }
        this.j = new b(n.a(this.b, "on_ad_event"));
        this.k = new b(n.a(this.b, "on_component_event"));
        a(this.j);
        a(this.k);
        this.h = new ArrayList();
        JSONArray jSONArrayOptJSONArray = this.b.optJSONArray("child_view");
        if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray.length() > 0) {
            for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                e eVar = new e(jSONArrayOptJSONArray.optJSONObject(i2));
                if (this.o != null) {
                    eVar.a(this.o);
                }
                this.h.add(eVar);
            }
        }
    }

    private void a(b bVar) {
        Iterator<String> it = bVar.b().iterator();
        while (it.hasNext()) {
            Iterator<a> it2 = bVar.a(it.next()).iterator();
            while (it2.hasNext()) {
                List<String> listD = it2.next().d();
                for (int i2 = 0; i2 < listD.size(); i2++) {
                    String str = listD.get(i2);
                    if (!TextUtils.isEmpty(str) && str.startsWith("config_")) {
                        listD.set(i2, this.g.optString(str.replace("config_", "")));
                    }
                }
            }
        }
    }

    public void a(com.component.a.f.c cVar) {
        this.o = cVar;
        if (this.h != null) {
            Iterator<e> it = this.h.iterator();
            while (it.hasNext()) {
                it.next().a(cVar);
            }
        }
    }

    public void a(com.component.a.c.a aVar) {
        this.p = aVar;
        if (this.h != null) {
            Iterator<e> it = this.h.iterator();
            while (it.hasNext()) {
                it.next().a(aVar);
            }
        }
    }

    public Bitmap a(String str) {
        if (this.p != null) {
            return this.p.b(str);
        }
        return null;
    }

    public static class f {
        public static final String a = "round_rect";
        public static final String b = "oval";
        public static final String c = "triangle";
        private final JSONObject d;
        private int[] e;

        private f(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.d = jSONObject;
            } else {
                this.d = new JSONObject();
            }
        }

        public JSONObject a() {
            return this.d;
        }

        public String a(String str) {
            return this.d.optString("shape", str);
        }

        public int a(int i) {
            return n.a(this.d, TypedValues.Custom.S_COLOR, i);
        }

        public float a(float f) {
            return n.a(this.d, "alpha", f);
        }

        public int b(int i) {
            return n.a(this.d, "foreground_color", i);
        }

        public float b(float f) {
            return n.a(this.d, "foreground_alpha", f);
        }

        public int b() {
            return this.d.optInt("orientation", 0);
        }

        public int c(int i) {
            return n.a(this.d, "start_color", i);
        }

        public float c(float f) {
            return n.a(this.d, "start_alpha", f);
        }

        public int d(int i) {
            return n.a(this.d, "end_color", i);
        }

        public float d(float f) {
            return n.a(this.d, "end_alpha", f);
        }

        public int e(int i) {
            return n.a(this.d, "border_color", i);
        }

        public int f(int i) {
            return this.d.optInt("border_width", i);
        }

        public float e(float f) {
            return n.a(this.d, "border_alpha", f);
        }

        public int[] a(int[] iArr) {
            return (int[]) n.a(this.d, "radius", (int[]) iArr.clone());
        }

        public float[] a(float[] fArr) {
            return (float[]) n.a(this.d, "radius", (float[]) fArr.clone());
        }

        public int g(int i) {
            if (this.e == null) {
                this.e = new int[8];
            }
            Arrays.fill(this.e, i);
            return a(this.e)[0];
        }

        public float f(float f) {
            return n.a(this.d, "radius_rate", f);
        }
    }

    public static class i {
        private final JSONObject a;

        private i(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.a = jSONObject;
            } else {
                this.a = new JSONObject();
            }
        }

        public JSONObject a() {
            return this.a;
        }

        public int a(int i) {
            return this.a.optInt("gravity", i);
        }

        public int b(int i) {
            return this.a.optInt("toast", i);
        }

        public int c(int i) {
            return this.a.optInt("size", i);
        }

        public int d(int i) {
            return n.a(this.a, TypedValues.Custom.S_COLOR, i);
        }

        public float a(float f) {
            return n.a(this.a, "alpha", f);
        }

        public int e(int i) {
            return this.a.optInt("style", i);
        }

        public int f(int i) {
            return this.a.optInt("line_num", i);
        }

        public int g(int i) {
            if (this.a.has("break_mode")) {
                return this.a.optInt("break_mode", i);
            }
            return this.a.optInt("beak_mode", i);
        }

        public float b(float f) {
            return n.a(this.a, "shadow_r", f);
        }

        public float c(float f) {
            return n.a(this.a, "shadow_x", f);
        }

        public float d(float f) {
            return n.a(this.a, "shadow_y", f);
        }

        public int h(int i) {
            return n.a(this.a, "shadow_c", i);
        }

        public float e(float f) {
            return n.a(this.a, "shadow_a", f);
        }
    }

    public static class g {
        private final JSONObject a;

        private g(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.a = jSONObject;
            } else {
                this.a = new JSONObject();
            }
        }

        public JSONObject a() {
            return this.a;
        }

        public int a(int i) {
            return n.a(this.a, "progress_color", i);
        }

        public String a(String str) {
            return this.a.optString(SchedulerSupport.CUSTOM, str);
        }

        public int b(int i) {
            return this.a.optInt("style", i);
        }

        public boolean b() {
            return this.a.optInt("left_icon") == 1;
        }

        public boolean c() {
            return this.a.optInt("right_icon") == 1;
        }
    }

    /* renamed from: com.component.a.f.e$e, reason: collision with other inner class name */
    public static class C0316e {
        private JSONObject a;
        private final List<C0316e> b;

        private C0316e(JSONArray jSONArray) {
            this.a = new JSONObject();
            this.b = new ArrayList();
            if (jSONArray != null) {
                if (jSONArray.length() == 1) {
                    this.a = jSONArray.optJSONObject(0);
                } else if (jSONArray.length() > 1) {
                    for (int i = 0; i < jSONArray.length(); i++) {
                        C0316e c0316e = new C0316e(jSONArray.optJSONObject(i));
                        if (a.b.GROUP.b().equals(c0316e.a(""))) {
                            this.a = jSONArray.optJSONObject(i);
                        } else {
                            this.b.add(c0316e);
                        }
                    }
                }
            }
            if (this.a == null) {
                this.a = new JSONObject();
            }
        }

        private C0316e(JSONObject jSONObject) {
            this.a = new JSONObject();
            this.b = new ArrayList();
            if (jSONObject != null) {
                this.a = jSONObject;
            }
        }

        public JSONObject a() {
            return this.a;
        }

        public String a(String str) {
            return this.a.optString("type", str);
        }

        public int a(int i) {
            return this.a.optInt("duration", i);
        }

        public int b(int i) {
            return this.a.optInt(b.e.c, i);
        }

        public int c(int i) {
            int iOptInt = this.a.optInt("repeat", i);
            return iOptInt > 0 ? iOptInt - 1 : iOptInt;
        }

        public JSONArray b() {
            return n.b(this.a, "params");
        }

        public String b(String str) {
            return this.a.optString("interpolator", str);
        }

        public String c(String str) {
            return this.a.optString("start", str);
        }

        public String d(String str) {
            return this.a.optString(PointCategory.END, str);
        }

        public int[] a(int[] iArr) {
            return n.a(this.a, "colors", iArr);
        }

        public List<C0316e> c() {
            return this.b;
        }
    }

    public static class h {
        private final JSONObject a;
        private final HashMap<String, String> b;

        public static List<h> a(JSONArray jSONArray) {
            ArrayList arrayList = new ArrayList();
            if (jSONArray != null && jSONArray.length() > 0) {
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                    if (jSONObjectOptJSONObject != null) {
                        arrayList.add(new h(jSONObjectOptJSONObject));
                    }
                }
            }
            return arrayList;
        }

        public h(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.a = jSONObject;
            } else {
                this.a = new JSONObject();
            }
            JSONObject jSONObjectOptJSONObject = this.a.optJSONObject("images");
            this.b = new HashMap<>();
            if (jSONObjectOptJSONObject != null) {
                Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    String strOptString = jSONObjectOptJSONObject.optString(next);
                    if (!TextUtils.isEmpty(next) && !TextUtils.isEmpty(strOptString)) {
                        this.b.put(next, strOptString);
                    }
                }
            }
        }

        public String a(String str) {
            return this.a.optString("click", str);
        }

        public String b(String str) {
            return this.a.optString("view_id", str);
        }

        public String c(String str) {
            return this.a.optString("name", str);
        }

        public String d(String str) {
            return this.a.optString("start_input", str);
        }

        public String e(String str) {
            return this.a.optString("end_output", str);
        }

        public String f(String str) {
            return this.a.optString(TextureRenderKeys.KEY_BMF_SCALE_TYPE, str);
        }

        public String g(String str) {
            return this.a.optString("id", str);
        }

        public int a(int i) {
            return this.a.optInt("auto_play", i);
        }

        public int b(int i) {
            return this.a.optInt("duration", i);
        }

        public int c(int i) {
            return this.a.optInt(b.e.c, i);
        }

        public float a(float f) {
            return n.a(this.a, b.e.a, f);
        }

        public int d(int i) {
            int iOptInt = this.a.optInt("repeat", i);
            return iOptInt > 0 ? iOptInt - 1 : iOptInt;
        }

        public int e(int i) {
            return this.a.optInt("repeat_mode", i);
        }

        public String h(String str) {
            return this.a.optString("json", str);
        }

        public Map<String, String> a() {
            return this.b;
        }

        public JSONObject b() {
            return this.a;
        }
    }

    public static class b {
        private final JSONObject a;
        private final Map<String, List<a>> b;

        public b(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.a = jSONObject;
            } else {
                this.a = new JSONObject();
            }
            this.b = new HashMap();
            JSONArray jSONArrayNames = this.a.names();
            if (jSONArrayNames != null) {
                for (int i = 0; i < jSONArrayNames.length(); i++) {
                    String strOptString = jSONArrayNames.optString(i);
                    JSONObject jSONObjectOptJSONObject = this.a.optJSONObject(strOptString);
                    if (jSONObjectOptJSONObject != null && !TextUtils.isEmpty(strOptString)) {
                        JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("actions");
                        ArrayList arrayList = new ArrayList();
                        if (jSONArrayOptJSONArray != null) {
                            for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                                JSONObject jSONObjectOptJSONObject2 = jSONArrayOptJSONArray.optJSONObject(i2);
                                if (jSONObjectOptJSONObject2 != null) {
                                    arrayList.add(new a(jSONObjectOptJSONObject2));
                                }
                            }
                        }
                        this.b.put(strOptString, arrayList);
                    }
                }
            }
        }

        public JSONObject a() {
            return this.a;
        }

        public Set<String> b() {
            return this.b.keySet();
        }

        public List<a> a(String str) {
            return this.b.get(str);
        }
    }

    public static class a {
        private final JSONObject a;
        private final String b;
        private final List<String> c;
        private final List<String> d;

        public a(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.a = jSONObject;
            } else {
                this.a = new JSONObject();
            }
            this.b = this.a.optString("what");
            this.c = new ArrayList();
            JSONArray jSONArrayOptJSONArray = this.a.optJSONArray("params");
            if (jSONArrayOptJSONArray != null) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    this.c.add(jSONArrayOptJSONArray.optString(i));
                }
            }
            this.d = new ArrayList();
            JSONArray jSONArrayOptJSONArray2 = this.a.optJSONArray("conditions");
            if (jSONArrayOptJSONArray2 != null) {
                for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                    this.d.add(jSONArrayOptJSONArray2.optString(i2));
                }
            }
        }

        public JSONObject a() {
            return this.a;
        }

        public String b() {
            return this.b;
        }

        public List<String> c() {
            return this.c;
        }

        public List<String> d() {
            return this.d;
        }
    }

    public enum d {
        LAYOUT_RELATIVE("relative"),
        LAYOUT_ITERATIVE("iterative"),
        LAYOUT_SCROLL("scrollview"),
        IMAGE("image"),
        TEXT("text"),
        BUTTON("button"),
        VIDEO("video"),
        LOTTIE("lottie"),
        WEB_VIEW("render"),
        UNKNOWN("unknown");

        private final String k;

        d(String str) {
            this.k = str;
        }

        public String b() {
            return this.k;
        }

        public static d b(String str) {
            for (d dVar : values()) {
                if (TextUtils.equals(dVar.b(), str)) {
                    return dVar;
                }
            }
            return UNKNOWN;
        }
    }

    public float a(float f2) {
        return n.a(this.b, "aspect_rate", f2);
    }

    public float b(float f2) {
        return n.a(this.b, "w_rate", f2);
    }

    public float c(float f2) {
        return n.a(this.b, "h_rate", f2);
    }

    public int a(int i2) {
        return this.b.optInt("w", i2);
    }

    public int b(int i2) {
        return this.b.optInt("h", i2);
    }

    public int c(int i2) {
        return this.b.optInt("gravity", i2);
    }

    public int[] a(int i2, int i3, int i4, int i5) {
        if (this.l == null) {
            this.l = new int[]{i2, i3, i4, i5};
        } else {
            this.l[0] = i2;
            this.l[1] = i3;
            this.l[2] = i4;
            this.l[3] = i5;
        }
        return (int[]) n.a(this.b, "margins", this.l);
    }

    public float[] a(float f2, float f3, float f4, float f5) {
        if (this.m == null) {
            this.m = new float[]{f2, f3, f4, f5};
        } else {
            this.m[0] = f2;
            this.m[1] = f3;
            this.m[2] = f4;
            this.m[3] = f5;
        }
        return (float[]) n.a(this.b, "margin_rate", this.m);
    }

    public int[] b(int i2, int i3, int i4, int i5) {
        if (this.n == null) {
            this.n = new int[]{i2, i3, i4, i5};
        } else {
            this.n[0] = i2;
            this.n[1] = i3;
            this.n[2] = i4;
            this.n[3] = i5;
        }
        return (int[]) n.a(this.b, "safe_margins", this.n);
    }

    public int d(int i2) {
        return this.b.optInt("auto_scale", i2);
    }

    public String b(String str) {
        return this.b.optString("above", str);
    }

    public String c(String str) {
        return this.b.optString("below", str);
    }

    public String d(String str) {
        return this.b.optString(j.d, str);
    }

    public String e(String str) {
        return this.b.optString(j.e, str);
    }

    public String f(String str) {
        return this.b.optString("center", str);
    }

    public String g(String str) {
        return this.b.optString("align_top", str);
    }

    public String h(String str) {
        return this.b.optString("align_bottom", str);
    }

    public String i(String str) {
        return this.b.optString("align_left", str);
    }

    public String j(String str) {
        return this.b.optString("align_right", str);
    }

    public String k(String str) {
        return this.b.optString("match_width", str);
    }

    public String l(String str) {
        return this.b.optString("id", str);
    }

    public String m(String str) {
        return this.b.optString("name", str);
    }

    public String n(String str) {
        return this.b.optString("scene", str);
    }

    public String b() {
        return this.b.optString(com.baidu.mobads.container.adrequest.a.a, "");
    }

    public String o(String str) {
        String strOptString = this.b.optString("src", str);
        if (this.o != null && this.o.a(strOptString)) {
            return this.o.a(strOptString, str);
        }
        return strOptString;
    }

    public int e(int i2) {
        return this.b.optInt("visibility", i2);
    }

    public JSONObject c() {
        return this.g;
    }

    public c.a d() {
        if (this.o != null) {
            return this.o.a();
        }
        return new c.a();
    }

    public String p(String str) {
        return this.b.optString(TextureRenderKeys.KEY_BMF_SCALE_TYPE, str);
    }

    public String q(String str) {
        return this.b.optString("click", str);
    }

    public String r(String str) {
        return this.b.optString(com.component.a.f.d.d, str);
    }

    public String s(String str) {
        return this.b.optString(SchedulerSupport.CUSTOM, str);
    }

    public d e() {
        return d.b(this.b.optString("type"));
    }

    public String t(String str) {
        return this.b.optString("type", str);
    }

    public int f(int i2) {
        return this.b.optInt("count", i2);
    }

    public int g(int i2) {
        return this.b.optInt("orientation", i2);
    }

    public int h(int i2) {
        return this.b.optInt("fill_type", i2);
    }

    public int i(int i2) {
        return this.b.optInt("space", i2);
    }

    public int j(int i2) {
        return this.b.optInt("start", i2);
    }

    public int k(int i2) {
        return this.b.optInt(PointCategory.END, i2);
    }

    public JSONObject f() {
        return this.b;
    }

    public i g() {
        return this.d;
    }

    public f h() {
        return this.c;
    }

    public g i() {
        return this.e;
    }

    public C0316e j() {
        return this.f;
    }

    public JSONObject k() {
        return this.b.optJSONObject(com.baidu.mobads.container.adrequest.a.a);
    }

    public List<h> l() {
        return this.i;
    }

    public b m() {
        return this.j;
    }

    public b n() {
        return this.k;
    }

    public List<e> o() {
        return this.h;
    }

    @Override // java.lang.Iterable
    public Iterator<e> iterator() {
        return new c(this);
    }

    public static class c implements Iterator<e> {
        private final LinkedList<e> a = new LinkedList<>();

        public c(e eVar) {
            this.a.add(eVar);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return !this.a.isEmpty();
        }

        @Override // java.util.Iterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public e next() {
            e eVarPoll = this.a.poll();
            if (eVarPoll != null && eVarPoll.o() != null) {
                this.a.addAll(eVarPoll.o());
            }
            return eVarPoll;
        }

        @Override // java.util.Iterator
        public void remove() {
        }
    }
}
