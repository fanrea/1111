package com.qq.e.comm.plugin;

import android.animation.ArgbEvaluator;
import android.animation.PropertyValuesHolder;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Property;
import android.view.View;
import com.qq.e.comm.plugin.x7;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class s6 extends x7.a {
    private final Property<w40, Integer> b;

    /* compiled from: A */
    public static class b extends s6 {

        /* compiled from: A */
        class a extends Property<w40, Integer> {
            a(Class cls, String str) {
                super(cls, str);
            }

            @Override // android.util.Property
            public void set(w40 w40Var, Integer num) {
                w40Var.f(num.intValue());
            }

            @Override // android.util.Property
            public Integer get(w40 w40Var) {
                View viewA = w40Var.A();
                if (viewA == null) {
                    return 0;
                }
                Drawable background = viewA.getBackground();
                if (!(background instanceof ColorDrawable)) {
                    return 0;
                }
                return Integer.valueOf(((ColorDrawable) background).getColor());
            }
        }

        b() {
            super(new a(Integer.class, com.baidu.mobads.container.n.f.T));
        }
    }

    /* compiled from: A */
    public static class c extends s6 {

        /* compiled from: A */
        class a extends Property<w40, Integer> {
            a(Class cls, String str) {
                super(cls, str);
            }

            @Override // android.util.Property
            public void set(w40 w40Var, Integer num) {
                w40Var.g(num.intValue());
            }

            @Override // android.util.Property
            public Integer get(w40 w40Var) {
                return 0;
            }
        }

        c() {
            super(new a(Integer.class, "borderColor"));
        }
    }

    private s6(Property<w40, Integer> property) {
        this.b = property;
    }

    @Override // com.qq.e.comm.plugin.x7.a
    PropertyValuesHolder[] a(s2 s2Var) {
        if (s2Var.c.length() < 2) {
            return null;
        }
        try {
            String strOptString = s2Var.c.optString(0);
            if (TextUtils.isEmpty(strOptString)) {
                return null;
            }
            int color = Color.parseColor(strOptString);
            try {
                String strOptString2 = s2Var.c.optString(1);
                if (TextUtils.isEmpty(strOptString2)) {
                    return null;
                }
                PropertyValuesHolder propertyValuesHolderOfInt = PropertyValuesHolder.ofInt(this.b, color, Color.parseColor(strOptString2));
                propertyValuesHolderOfInt.setEvaluator(new ArgbEvaluator());
                return new PropertyValuesHolder[]{propertyValuesHolderOfInt};
            } catch (IllegalArgumentException e) {
                e.toString();
                return null;
            }
        } catch (IllegalArgumentException e2) {
            e2.toString();
            return null;
        }
    }
}
