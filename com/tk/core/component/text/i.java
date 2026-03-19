package com.tk.core.component.text;

import android.text.TextUtils;
import com.sigmob.sdk.base.mta.PointCategory;
import com.tk.core.o.ad;
import com.tkruntime.v8.V8Array;
import com.tkruntime.v8.V8Function;
import com.tkruntime.v8.V8Object;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public final class i {
    public String KS;
    public int Vo;
    public String aei;
    public boolean afA;
    public String afB;
    public int afC;
    public int afD;
    public float afE;
    public float afF;
    public float afG;
    public String afH;
    public V8Function afI;
    public String afz;
    public int end;
    public String imageUrl;
    public int index;
    public int size;
    public int start;
    public String url;

    public static i a(h hVar) {
        if (hVar == null) {
            return null;
        }
        i iVar = new i();
        iVar.afz = hVar.afz;
        iVar.url = hVar.url;
        iVar.start = hVar.start;
        iVar.end = hVar.end;
        iVar.aei = hVar.aei;
        iVar.size = hVar.size;
        iVar.KS = hVar.KS;
        iVar.afB = hVar.afB;
        iVar.imageUrl = hVar.imageUrl;
        iVar.afC = hVar.afC;
        iVar.afD = hVar.afD;
        iVar.Vo = hVar.Vo;
        iVar.afE = hVar.afE;
        iVar.index = hVar.index;
        iVar.afF = hVar.afF;
        iVar.afG = hVar.afG;
        iVar.afI = hVar.mV8FunctionRef != null ? hVar.mV8FunctionRef.get() : null;
        iVar.afH = hVar.afH;
        iVar.afA = hVar.afA;
        return iVar;
    }

    public static List<i> z(V8Object v8Object) {
        int length;
        if (!ad.isV8Valid(v8Object)) {
            return null;
        }
        try {
            V8Array array = v8Object.getArray("spanArray");
            if (array == null || (length = array.length()) <= 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int iIntValue = ((Integer) a(v8Object, "start", -1)).intValue();
            int iIntValue2 = ((Integer) a(v8Object, PointCategory.END, -1)).intValue();
            int iIntValue3 = ((Integer) a(v8Object, "index", -1)).intValue();
            if (-1 == iIntValue && -1 == iIntValue2 && -1 == iIntValue3) {
                return null;
            }
            for (int i = 0; i < length; i++) {
                i iVarA = a(iIntValue, iIntValue2, iIntValue3, array.getObject(i));
                if (iVarA != null) {
                    arrayList.add(iVarA);
                }
            }
            return arrayList;
        } catch (Throwable th) {
            com.tk.core.i.a.a("SpanItemModel", "parseSpanItem", th);
            return null;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:38:0x008e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.tk.core.component.text.i a(int r6, int r7, int r8, com.tkruntime.v8.V8Object r9) {
        /*
            Method dump skipped, instructions count: 484
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tk.core.component.text.i.a(int, int, int, com.tkruntime.v8.V8Object):com.tk.core.component.text.i");
    }

    private static <T> T a(V8Object v8Object, String str, T t) {
        if (ad.isV8Valid(v8Object) && !TextUtils.isEmpty(str)) {
            try {
                T t2 = (T) v8Object.get(str);
                return t2 instanceof V8Object.Undefined ? t : t2;
            } catch (Throwable th) {
                com.tk.core.i.a.a("SpanItemModel", "parseV8Object --> key --> " + str, th);
            }
        }
        return t;
    }
}
