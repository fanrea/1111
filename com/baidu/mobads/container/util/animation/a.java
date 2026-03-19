package com.baidu.mobads.container.util.animation;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Interpolator;
import com.baidu.mobads.container.util.bq;
import java.util.List;
import org.json.JSONArray;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class a {
    public static final String a = "paint";
    private final c b;

    /* renamed from: com.baidu.mobads.container.util.animation.a$a, reason: collision with other inner class name */
    public enum EnumC0133a {
        BACKGROUND,
        PAINT,
        VIEW
    }

    public static class c {
        private final View a;
        private b b;
        private int c;
        private int d;
        private int e;
        private Interpolator f;
        private JSONArray g;
        private String h;
        private String i;
        private int[] j;
        private List<a> k;
        private int l;
        private float m;
        private EnumC0133a n;

        private c(View view) {
            this.c = -1;
            this.d = -1;
            this.e = -2;
            this.m = -2.0f;
            this.a = view;
        }

        public c a(int i) {
            this.c = i;
            return this;
        }

        public c b(int i) {
            this.d = i;
            return this;
        }

        public c c(int i) {
            this.e = i;
            return this;
        }

        public c a(String str) {
            this.f = e.a(str);
            return this;
        }

        public c a(Interpolator interpolator) {
            this.f = interpolator;
            return this;
        }

        public c a(JSONArray jSONArray) {
            this.g = jSONArray;
            return this;
        }

        public c b(String str) {
            this.h = str;
            return this;
        }

        public c c(String str) {
            this.i = str;
            return this;
        }

        public c a(boolean z) {
            if (z) {
                String str = this.i;
                this.i = this.h;
                this.h = str;
            }
            return this;
        }

        public c a(int[] iArr) {
            this.j = iArr;
            return this;
        }

        public c a(List<a> list) {
            this.k = list;
            return this;
        }

        public c d(int i) {
            this.l = i;
            return this;
        }

        public c a(float f) {
            this.m = f;
            return this;
        }

        public c a(EnumC0133a enumC0133a) {
            this.n = enumC0133a;
            return this;
        }

        public a d(String str) {
            this.b = b.b(str);
            return new a(this);
        }

        public a a(b bVar) {
            this.b = bVar;
            return new a(this);
        }
    }

    public enum b {
        UNKNOWN("unknown"),
        GROUP("group"),
        TRANSLATE_X("translate_x"),
        TRANSLATE_Y("translate_y"),
        ABSOLUTE_X("absolute_x"),
        ABSOLUTE_Y("absolute_y"),
        ROTATE("rotation"),
        ALPHA("alpha"),
        SCALE("scale"),
        SCALE_X("scale_x"),
        SCALE_Y("scale_y"),
        BACKGROUND_COLOR("bg_color"),
        HEARTBEAT(com.kwai.kanas.upload.e.b),
        GRADIENT("gradient"),
        SWIPE("swipe"),
        BOUNCE("bounce"),
        ZOOM("zoom"),
        GUIDE("guide"),
        BREATHE("breathe"),
        ENTER("enter"),
        EXIT(com.alipay.sdk.m.x.d.z);

        private final String v;

        b(String str) {
            this.v = str;
        }

        public String b() {
            return this.v;
        }

        public static b b(String str) {
            for (b bVar : values()) {
                if (TextUtils.equals(bVar.b(), str)) {
                    return bVar;
                }
            }
            return UNKNOWN;
        }
    }

    public static c a(View view) {
        return new c(view);
    }

    public a(c cVar) {
        this.b = cVar;
    }

    public View a() {
        return this.b.a;
    }

    public b b() {
        return this.b.b;
    }

    public int a(int i) {
        return this.b.c < 0 ? i : this.b.c;
    }

    public int b(int i) {
        return this.b.d < 0 ? i : this.b.d;
    }

    public int c(int i) {
        return this.b.e < -1 ? i : this.b.e;
    }

    public Interpolator a(Interpolator interpolator) {
        if (this.b.f != null) {
            return this.b.f;
        }
        return interpolator;
    }

    public JSONArray c() {
        if (this.b.g != null) {
            return this.b.g;
        }
        return new JSONArray();
    }

    public String a(String str) {
        return !TextUtils.isEmpty(this.b.h) ? this.b.h : str;
    }

    public int d(int i) {
        return a(this.b.h, i);
    }

    public float a(float f) {
        return a(this.b.h, f);
    }

    public String b(String str) {
        return !TextUtils.isEmpty(this.b.i) ? this.b.i : str;
    }

    public int e(int i) {
        return a(this.b.i, i);
    }

    public float b(float f) {
        return a(this.b.i, f);
    }

    public int[] d() {
        return this.b.j;
    }

    public int f(int i) {
        if (this.b.j != null && this.b.j.length > 0) {
            return this.b.j[0];
        }
        return i;
    }

    public List<a> e() {
        return this.b.k;
    }

    public int f() {
        return this.b.l;
    }

    public float g() {
        return this.b.m;
    }

    public EnumC0133a h() {
        return this.b.n;
    }

    public Animator i() {
        AnimatorSet animatorSetA;
        switch (this.b.b) {
            case TRANSLATE_X:
            case TRANSLATE_Y:
            case ROTATE:
            case ALPHA:
            case SCALE:
                animatorSetA = j.a(this);
                break;
            case GROUP:
                animatorSetA = j.c(this);
                break;
            case BACKGROUND_COLOR:
                animatorSetA = j.g(this);
                break;
            case HEARTBEAT:
                animatorSetA = j.i(this);
                break;
            case GRADIENT:
                animatorSetA = j.e(this);
                break;
            case SWIPE:
                animatorSetA = j.f(this);
                break;
            case BOUNCE:
                animatorSetA = j.j(this);
                break;
            case ZOOM:
                animatorSetA = j.k(this);
                break;
            case GUIDE:
                animatorSetA = j.h(this);
                break;
            case BREATHE:
                animatorSetA = j.d(this);
                break;
            case ENTER:
            case EXIT:
                animatorSetA = j.l(this);
                break;
            default:
                animatorSetA = null;
                break;
        }
        return animatorSetA;
    }

    private int a(String str, int i) {
        try {
            if (!TextUtils.isEmpty(str)) {
                return (int) Float.parseFloat(str);
            }
        } catch (Throwable th) {
            bq.a().d(th);
        }
        return i;
    }

    private float a(String str, float f) {
        try {
            if (!TextUtils.isEmpty(str)) {
                float f2 = Float.parseFloat(str);
                if (!Float.isNaN(f2)) {
                    return f2;
                }
            }
        } catch (Throwable th) {
            bq.a().d(th);
        }
        return f;
    }
}
