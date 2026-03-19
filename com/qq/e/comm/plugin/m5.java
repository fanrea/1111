package com.qq.e.comm.plugin;

import android.animation.PropertyValuesHolder;
import android.util.Property;
import com.qq.e.comm.plugin.x7;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class m5 extends x7.a {
    private final Property<w40, Integer> b = new a(Integer.class, "borderWidth");

    m5() {
    }

    /* compiled from: A */
    class a extends Property<w40, Integer> {
        a(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        public void set(w40 w40Var, Integer num) {
            w40Var.h(num.intValue());
        }

        @Override // android.util.Property
        public Integer get(w40 w40Var) {
            return 0;
        }
    }

    @Override // com.qq.e.comm.plugin.x7.a
    PropertyValuesHolder[] a(s2 s2Var) {
        JSONArray jSONArray = s2Var.c;
        if (jSONArray.length() < 2) {
            return null;
        }
        return new PropertyValuesHolder[]{PropertyValuesHolder.ofInt(this.b, t30.c(jSONArray.opt(0)).a(new JSONObject[0]), t30.c(jSONArray.opt(1)).a(new JSONObject[0]))};
    }
}
