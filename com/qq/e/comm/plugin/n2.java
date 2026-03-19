package com.qq.e.comm.plugin;

import android.animation.PropertyValuesHolder;
import android.util.Property;
import android.view.View;
import com.qq.e.comm.plugin.x7;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class n2 extends x7.a {
    private final Property<w40, Float> b = new a(Float.class, "alpha");

    n2() {
    }

    /* compiled from: A */
    class a extends Property<w40, Float> {
        a(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        public void set(w40 w40Var, Float f) {
            w40Var.a(f.floatValue());
        }

        @Override // android.util.Property
        public Float get(w40 w40Var) {
            View viewA = w40Var.A();
            return Float.valueOf(viewA == null ? 1.0f : viewA.getAlpha());
        }
    }

    @Override // com.qq.e.comm.plugin.x7.a
    PropertyValuesHolder[] a(s2 s2Var) {
        if (s2Var.c.length() < 2) {
            return null;
        }
        double d = -1;
        float fOptDouble = (float) s2Var.c.optDouble(0, d);
        if (fOptDouble <= 1.0f && fOptDouble >= 0.0f) {
            float fOptDouble2 = (float) s2Var.c.optDouble(1, d);
            if (fOptDouble2 <= 1.0f && fOptDouble2 >= 0.0f) {
                return new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(this.b, fOptDouble, fOptDouble2)};
            }
        }
        return null;
    }
}
