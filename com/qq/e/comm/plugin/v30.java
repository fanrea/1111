package com.qq.e.comm.plugin;

import android.graphics.Color;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseIntArray;
import com.qq.e.comm.plugin.u6;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class v30 {
    private static final int[] a = {48, 80, 3, 5, 16, 1};
    private static final int b = 6;
    private static final Map<String, Integer> c = new HashMap();

    /* compiled from: A */
    public interface c {
        void a(int i);
    }

    /* compiled from: A */
    public interface d {
        void a(Object[] objArr);
    }

    public static void a(cm cmVar, pk pkVar, c cVar) {
        String string = cmVar.toString();
        if (TextUtils.isEmpty(string)) {
            return;
        }
        Map<String, Integer> map = c;
        Integer num = map.get(string);
        if (num != null) {
            cVar.a(num.intValue());
            return;
        }
        if ('#' != string.charAt(0)) {
            if (pkVar == null) {
                return;
            }
            u6.a(pkVar, string, new a(cVar));
            return;
        }
        try {
            int color = Color.parseColor(string);
            map.put(string, Integer.valueOf(color));
            cVar.a(color);
        } catch (Exception e) {
            e.getMessage();
        } finally {
            cVar.a(0);
        }
    }

    /* compiled from: A */
    class a implements u6.b {
        final /* synthetic */ c a;

        a(c cVar) {
            this.a = cVar;
        }

        @Override // com.qq.e.comm.plugin.u6.b
        public void a(int i) {
            this.a.a(i);
        }
    }

    public static int c(cm cmVar) {
        int i = 0;
        int i2 = 0;
        for (int iF = cmVar.f(new JSONObject[0]); iF > 0 && i < b; iF >>= 1) {
            if ((iF & 1) > 0) {
                i2 |= a[i];
            }
            i++;
        }
        return i2;
    }

    /* compiled from: A */
    class b implements c {
        final /* synthetic */ SparseIntArray a;
        final /* synthetic */ int b;
        final /* synthetic */ int c;
        final /* synthetic */ JSONArray d;
        final /* synthetic */ d e;

        b(SparseIntArray sparseIntArray, int i, int i2, JSONArray jSONArray, d dVar) {
            this.a = sparseIntArray;
            this.b = i;
            this.c = i2;
            this.d = jSONArray;
            this.e = dVar;
        }

        @Override // com.qq.e.comm.plugin.v30.c
        public void a(int i) {
            this.a.put(this.b, i);
            int size = this.a.size();
            int i2 = this.c;
            if (size != i2) {
                return;
            }
            int[] iArr = new int[i2];
            int i3 = 0;
            while (true) {
                int i4 = this.c;
                if (i3 >= i4) {
                    v30.b(this.d, iArr, i4, this.e);
                    return;
                } else {
                    iArr[i3] = this.a.valueAt(i3);
                    i3++;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(JSONArray jSONArray, int[] iArr, int i, d dVar) {
        int length;
        int iOptInt = jSONArray.optInt(1);
        JSONArray jSONArrayOptJSONArray = jSONArray.optJSONArray(2);
        int length2 = jSONArrayOptJSONArray == null ? 0 : jSONArrayOptJSONArray.length();
        float[] fArr = null;
        float[] fArr2 = (length2 == 0 || length2 != i) ? null : new float[length2];
        if (fArr2 != null) {
            for (int i2 = 0; i2 < length2; i2++) {
                fArr2[i2] = (float) jSONArrayOptJSONArray.optDouble(i2);
            }
        }
        JSONArray jSONArrayOptJSONArray2 = jSONArray.optJSONArray(3);
        if (jSONArrayOptJSONArray2 != null && (length = jSONArrayOptJSONArray2.length()) >= 0) {
            fArr = new float[length];
            for (int i3 = 0; i3 < length; i3++) {
                fArr[i3] = (float) jSONArrayOptJSONArray2.optDouble(i3);
            }
        }
        dVar.a(new Object[]{iArr, Integer.valueOf(iOptInt), fArr2, fArr});
    }

    public static Pair<Float, Float> f(cm cmVar) {
        Object objE = cmVar.e(new JSONObject[0]);
        if (objE instanceof JSONArray) {
            if (((JSONArray) objE).length() == 0) {
                return null;
            }
            return new Pair<>(Float.valueOf(t30.c(r1.opt(0)).c(new JSONObject[0]).e()), Float.valueOf(t30.c(r1.opt(1)).c(new JSONObject[0]).e()));
        }
        Float fValueOf = Float.valueOf(cmVar.c(new JSONObject[0]).e());
        return new Pair<>(fValueOf, fValueOf);
    }

    public static int b(cm cmVar) {
        Integer numValueOf;
        String string = cmVar.toString();
        if (TextUtils.isEmpty(string)) {
            numValueOf = null;
        } else {
            Map<String, Integer> map = c;
            if (map.size() <= 0 || (numValueOf = map.get(string)) == null) {
                numValueOf = Integer.valueOf(Color.parseColor(string));
                map.put(string, numValueOf);
            }
        }
        if (numValueOf == null) {
            return 0;
        }
        return numValueOf.intValue();
    }

    public static Pair<Float, Float> e(cm cmVar) {
        Object objE = cmVar.e(new JSONObject[0]);
        if (objE instanceof JSONArray) {
            JSONArray jSONArray = (JSONArray) objE;
            if (jSONArray.length() == 0) {
                return null;
            }
            return new Pair<>(Float.valueOf((float) jSONArray.optDouble(0, 1.0d)), Float.valueOf((float) jSONArray.optDouble(1, 1.0d)));
        }
        float fB = cmVar.b(new JSONObject[0]);
        return new Pair<>(Float.valueOf(fB), Float.valueOf(fB));
    }

    public static int[] d(cm cmVar) {
        Object objE = cmVar.e(new JSONObject[0]);
        if (objE instanceof JSONArray) {
            JSONArray jSONArray = (JSONArray) objE;
            if (jSONArray.length() < 2) {
                return null;
            }
            int iOptInt = jSONArray.optInt(0);
            int iOptInt2 = jSONArray.optInt(1);
            if (iOptInt >= 0 && iOptInt2 > 0 && iOptInt2 >= iOptInt) {
                return new int[]{iOptInt, iOptInt2};
            }
        }
        return null;
    }

    public static int[] a(cm cmVar) {
        int[] iArr = new int[3];
        Object objE = cmVar.e(new JSONObject[0]);
        if (!(objE instanceof JSONArray)) {
            return null;
        }
        JSONArray jSONArray = (JSONArray) objE;
        if (jSONArray.length() < 3) {
            return null;
        }
        for (int i = 0; i < 3; i++) {
            iArr[i] = t30.c(jSONArray.opt(i)).f(new JSONObject[0]);
        }
        return iArr;
    }

    public static int[] b(cm cmVar, r8 r8Var) {
        int[] iArr = new int[4];
        Object objE = cmVar.e(new JSONObject[0]);
        if (!(objE instanceof JSONArray)) {
            return null;
        }
        JSONArray jSONArray = (JSONArray) objE;
        if (jSONArray.length() != 4) {
            return null;
        }
        for (int i = 0; i < 3; i++) {
            iArr[i] = t30.c(jSONArray.opt(i)).c(new JSONObject[0]).a(r8Var);
        }
        double d2 = iArr[2];
        Double.isNaN(d2);
        iArr[2] = (int) (d2 * 0.8d);
        iArr[3] = b(t30.c(jSONArray.opt(3)));
        return iArr;
    }

    public static int[] a(cm cmVar, r8 r8Var) {
        int[] iArr = new int[4];
        if (cmVar.e(new JSONObject[0]) instanceof JSONArray) {
            JSONArray jSONArray = (JSONArray) cmVar.e(new JSONObject[0]);
            int iMin = Math.min(4, jSONArray.length());
            boolean z = false;
            for (int i = 0; i < iMin; i++) {
                int iA = t30.c(jSONArray.opt(i)).c(new JSONObject[0]).a(r8Var);
                if (iA > 0) {
                    iArr[i] = iA;
                    z = true;
                }
            }
            if (z) {
                return iArr;
            }
        } else {
            int iA2 = cmVar.c(new JSONObject[0]).a(r8Var);
            if (iA2 > 0) {
                iArr[3] = iA2;
                iArr[2] = iA2;
                iArr[1] = iA2;
                iArr[0] = iA2;
                return iArr;
            }
        }
        return null;
    }

    public static void a(cm cmVar, pk pkVar, d dVar) {
        int length;
        Object objE = cmVar.e(new JSONObject[0]);
        if (objE instanceof String) {
            try {
                objE = new JSONArray(objE.toString());
            } catch (Throwable unused) {
            }
        }
        if (!(objE instanceof JSONArray)) {
            dVar.a(null);
            return;
        }
        JSONArray jSONArray = (JSONArray) objE;
        if (jSONArray.length() < 2) {
            dVar.a(null);
        }
        JSONArray jSONArrayOptJSONArray = jSONArray.optJSONArray(0);
        if (jSONArrayOptJSONArray != null && (length = jSONArrayOptJSONArray.length()) >= 2) {
            SparseIntArray sparseIntArray = new SparseIntArray(length);
            for (int i = 0; i < length; i++) {
                Object objOpt = jSONArrayOptJSONArray.opt(i);
                if (objOpt == null) {
                    dVar.a(null);
                    return;
                }
                a(t30.c(objOpt), pkVar, new b(sparseIntArray, i, length, jSONArray, dVar));
            }
            return;
        }
        dVar.a(null);
    }
}
