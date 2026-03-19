package com.qq.e.comm.plugin;

import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.util.Property;
import com.qq.e.comm.plugin.x7;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class l5 extends x7.a {
    private final Property<w40, Integer> b = new a(Integer.class, "sameBorderRadius");
    private final Property<w40, int[]> c = new b(int[].class, "diffBorderRadius");

    l5() {
    }

    /* compiled from: A */
    class a extends Property<w40, Integer> {
        a(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        public void set(w40 w40Var, Integer num) {
            int iIntValue = num.intValue();
            w40Var.a(new int[]{iIntValue, iIntValue, iIntValue, iIntValue});
        }

        @Override // android.util.Property
        public Integer get(w40 w40Var) {
            return 0;
        }
    }

    /* compiled from: A */
    class b extends Property<w40, int[]> {
        @Override // android.util.Property
        public int[] get(w40 w40Var) {
            return new int[4];
        }

        b(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        public void set(w40 w40Var, int[] iArr) {
            w40Var.a(iArr);
        }
    }

    /* compiled from: A */
    private static class c implements TypeEvaluator<int[]> {
        private final int[] a;

        private c() {
            this.a = new int[]{-1, -1, -1, -1};
        }

        @Override // android.animation.TypeEvaluator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int[] evaluate(float f, int[] iArr, int[] iArr2) {
            int i = 0;
            while (true) {
                int[] iArr3 = this.a;
                if (i >= iArr3.length) {
                    return iArr3;
                }
                int i2 = iArr[i];
                if (i2 >= 0) {
                    iArr3[i] = (int) (i2 + ((iArr2[i] - i2) * f));
                }
                i++;
            }
        }

        /* synthetic */ c(a aVar) {
            this();
        }
    }

    private PropertyValuesHolder a(JSONArray jSONArray, JSONArray jSONArray2) {
        int[] iArr = {-1, -1, -1, -1};
        int[] iArr2 = {-1, -1, -1, -1};
        int iMin = Math.min(jSONArray2.length(), 4);
        int i = 0;
        do {
            if (jSONArray != null && jSONArray.length() > 1) {
                iArr[i] = t30.c(jSONArray.opt(0)).c(new JSONObject[0]).e();
                iArr2[i] = t30.c(jSONArray.opt(1)).c(new JSONObject[0]).e();
            }
            i++;
            jSONArray = jSONArray2.optJSONArray(i);
        } while (i < iMin);
        return PropertyValuesHolder.ofObject(this.c, new c(null), iArr, iArr2);
    }

    @Override // com.qq.e.comm.plugin.x7.a
    PropertyValuesHolder[] a(s2 s2Var) {
        JSONArray jSONArray = s2Var.c;
        if (jSONArray.length() < 1) {
            return null;
        }
        Object objOpt = jSONArray.opt(0);
        if (!JSONObject.NULL.equals(objOpt) && !(objOpt instanceof JSONArray)) {
            if (jSONArray.length() >= 2) {
                return new PropertyValuesHolder[]{a(objOpt, jSONArray)};
            }
            return null;
        }
        return new PropertyValuesHolder[]{a(objOpt instanceof JSONArray ? (JSONArray) objOpt : null, jSONArray)};
    }

    private PropertyValuesHolder a(Object obj, JSONArray jSONArray) {
        return PropertyValuesHolder.ofInt(this.b, t30.c(obj).c(new JSONObject[0]).e(), t30.c(jSONArray.opt(1)).c(new JSONObject[0]).e());
    }
}
