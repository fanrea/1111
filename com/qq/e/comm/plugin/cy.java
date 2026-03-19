package com.qq.e.comm.plugin;

import android.animation.PropertyValuesHolder;
import android.util.Property;
import android.view.View;
import com.qq.e.comm.plugin.x7;
import org.json.JSONArray;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class cy extends x7.a {
    private final Property<w40, Float> b = new a(Float.class, "scaleX");
    private final Property<w40, Float> c = new b(Float.class, "scaleY");

    cy() {
    }

    /* compiled from: A */
    class a extends Property<w40, Float> {
        a(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        public void set(w40 w40Var, Float f) {
            w40Var.a(f, (Float) null);
        }

        @Override // android.util.Property
        public Float get(w40 w40Var) {
            View viewA = w40Var.A();
            return Float.valueOf(viewA == null ? 1.0f : viewA.getScaleX());
        }
    }

    /* compiled from: A */
    class b extends Property<w40, Float> {
        b(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        public void set(w40 w40Var, Float f) {
            w40Var.a((Float) null, f);
        }

        @Override // android.util.Property
        public Float get(w40 w40Var) {
            View viewA = w40Var.A();
            return Float.valueOf(viewA == null ? 1.0f : viewA.getScaleY());
        }
    }

    private PropertyValuesHolder a(Property<?, Float> property, JSONArray jSONArray) {
        int i;
        if (this.b == property) {
            i = 0;
        } else {
            if (this.c != property) {
                return null;
            }
            i = 2;
        }
        if (jSONArray.length() <= i) {
            return null;
        }
        return PropertyValuesHolder.ofFloat(property, (float) jSONArray.optDouble(i, 1.0d), (float) jSONArray.optDouble(i + 1, 1.0d));
    }

    @Override // com.qq.e.comm.plugin.x7.a
    PropertyValuesHolder[] a(s2 s2Var) {
        JSONArray jSONArray = s2Var.c;
        if (jSONArray.length() < 2) {
            return null;
        }
        PropertyValuesHolder propertyValuesHolderA = a(this.b, jSONArray);
        PropertyValuesHolder propertyValuesHolderA2 = a(this.c, jSONArray);
        if (propertyValuesHolderA == null && propertyValuesHolderA2 == null) {
            return null;
        }
        return (propertyValuesHolderA == null || propertyValuesHolderA2 == null) ? propertyValuesHolderA != null ? new PropertyValuesHolder[]{propertyValuesHolderA} : new PropertyValuesHolder[]{propertyValuesHolderA2} : new PropertyValuesHolder[]{propertyValuesHolderA, propertyValuesHolderA2};
    }
}
