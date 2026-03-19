package com.component.a.e.b;

import com.bytedance.sdk.djx.core.log.T2WLog;
import com.component.a.g.g;
import com.component.a.i.n;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class b implements g.a {
    private final int a;
    private final int b;
    private final boolean c;

    public b(int i, int i2, boolean z) {
        this.a = i;
        this.b = i2;
        this.c = z;
    }

    private c b(String str) {
        if (str.contains("int_9_16")) {
            return new g();
        }
        if (str.contains("int_1_1")) {
            return new h();
        }
        if (str.contains("int_full")) {
            return new e();
        }
        if (str.contains("int_hor")) {
            return new f();
        }
        if (str.contains("int_2_3")) {
            return new d();
        }
        return new g();
    }

    @Override // com.component.a.g.g.a
    public String a(String str) {
        c cVarB = b(str);
        if (str.contains("vert") && (str.contains("img") || str.contains("image"))) {
            if (str.contains("sec") && (cVarB instanceof h)) {
                return ((h) cVarB).h(str);
            }
            return cVarB.c(str);
        }
        if (str.contains("vert") && str.contains("video")) {
            if (str.contains(T2WLog.SCENE_CARD)) {
                return cVarB.e(str);
            }
            if (str.contains("sec") && (cVarB instanceof h)) {
                return ((h) cVarB).f(str);
            }
            return cVarB.a(str);
        }
        if (str.contains("hor") && (str.contains("img") || str.contains("image"))) {
            if (str.contains("sec") && (cVarB instanceof h)) {
                return ((h) cVarB).i(str);
            }
            return cVarB.d(str);
        }
        if (str.contains("hor") && str.contains("video")) {
            if (str.contains("sec") && (cVarB instanceof h)) {
                return ((h) cVarB).g(str);
            }
            return cVarB.b(str);
        }
        if (str.contains("adv") && (cVarB instanceof e)) {
            return ((e) cVarB).a();
        }
        if ((str.contains("img") || str.contains("image")) && (cVarB instanceof g)) {
            return ((g) cVarB).g(str);
        }
        if (str.contains("video") && (cVarB instanceof g)) {
            return ((g) cVarB).f(str);
        }
        return "";
    }

    @Override // com.component.a.g.g.a
    public JSONObject a() {
        String str;
        if (this.a > this.b) {
            if (this.c) {
                str = "int_9_16_hor_video";
            } else {
                str = "int_9_16_hor_img";
            }
        } else if (this.c) {
            str = "int_9_16_vert_video";
        } else {
            str = "int_9_16_vert_img";
        }
        return n.b(a(str));
    }
}
