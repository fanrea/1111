package com.bytedance.pangle.res.d;

import android.text.TextUtils;
import com.netease.htprotect.p010Ooo.p014o0o0.O8oO888;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class mk {
    static byte[] d(int i) {
        return new byte[]{(byte) (i >> 0), (byte) (i >> 8), (byte) (i >> 16), (byte) (i >> 24)};
    }

    static int d(h hVar) {
        return (int) hVar.d.d().hc();
    }

    static int d(byte[] bArr, int i, int i2, gb gbVar) {
        if (i < 2130706432) {
            return i;
        }
        int iD = gbVar.d(i);
        byte[] bArrD = d(iD);
        bArr[i2] = bArrD[0];
        bArr[i2 + 1] = bArrD[1];
        bArr[i2 + 2] = bArrD[2];
        bArr[i2 + 3] = bArrD[3];
        return iD;
    }

    static void d(byte[] bArr, gb gbVar) throws IOException {
        hc hcVar = new hc(bArr, gbVar);
        hcVar.hc(new ByteArrayInputStream(bArr));
        while (hcVar.b() != 1) {
        }
    }

    static void d(String str, byte[] bArr, gb gbVar) throws Throwable {
        if (!TextUtils.isEmpty(str) && gbVar.d(str)) {
            if (str.equals(O8oO888.f344Ooo)) {
                d(bArr, gbVar);
                return;
            }
            if ((str.endsWith(".xml") && str.startsWith("res/")) || TextUtils.equals(str, O8oO888.f344Ooo)) {
                d(bArr, gbVar);
            } else if (str.equals(O8oO888.f342O8oO888)) {
                new d(bArr, gbVar).d();
            }
        }
    }

    public static void d(int i, byte[] bArr, int[] iArr, int i2, HashMap<Integer, Integer> map) {
        HashMap map2 = new HashMap();
        HashMap map3 = new HashMap();
        int i3 = -1;
        for (int i4 = 0; i4 < i2; i4++) {
            int i5 = i4 * 5;
            int i6 = iArr[i5 + 1];
            if (map.containsKey(Integer.valueOf(i6))) {
                if (i3 == -1) {
                    i3 = i4;
                }
                int i7 = (i5 * 4) + i;
                map2.put(Integer.valueOf(i4), Arrays.copyOfRange(bArr, i7, i7 + 20));
                map3.put(Integer.valueOf(map.get(Integer.valueOf(i6)).intValue()), Integer.valueOf(i4));
            }
        }
        ArrayList arrayList = new ArrayList(map3.keySet());
        Collections.sort(arrayList);
        Iterator it = arrayList.iterator();
        int i8 = 0;
        while (it.hasNext()) {
            byte[] bArr2 = (byte[]) map2.get(Integer.valueOf(((Integer) map3.get((Integer) it.next())).intValue()));
            System.arraycopy(bArr2, 0, bArr, ((i8 + i3) * 5 * 4) + i, bArr2.length);
            i8++;
        }
    }
}
