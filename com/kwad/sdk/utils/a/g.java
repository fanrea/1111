package com.kwad.sdk.utils.a;

import com.kwad.sdk.utils.a.c;
import java.util.LinkedHashSet;
import java.util.Set;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
final class g implements c.b<Set<String>> {
    static final g cpl = new g();

    @Override // com.kwad.sdk.utils.a.c.b
    public final String aqM() {
        return "StringSet";
    }

    @Override // com.kwad.sdk.utils.a.c.b
    public final /* synthetic */ byte[] L(Set<String> set) {
        return e(set);
    }

    @Override // com.kwad.sdk.utils.a.c.b
    public final /* synthetic */ Set<String> g(byte[] bArr, int i, int i2) {
        return h(bArr, i, i2);
    }

    private g() {
    }

    private static byte[] e(Set<String> set) {
        if (set.isEmpty()) {
            return new byte[0];
        }
        int size = set.size();
        int[] iArr = new int[size];
        String[] strArr = new String[size];
        int iHE = 0;
        int i = 0;
        for (String str : set) {
            if (str == null) {
                iHE += 5;
                iArr[i] = -1;
            } else {
                int iIY = b.iY(str);
                strArr[i] = str;
                iArr[i] = iIY;
                iHE += b.hE(iIY) + iIY;
            }
            i++;
        }
        b bVar = new b(iHE);
        for (int i2 = 0; i2 < size; i2++) {
            int i3 = iArr[i2];
            bVar.hD(i3);
            if (i3 >= 0) {
                bVar.iX(strArr[i2]);
            }
        }
        return bVar.cow;
    }

    private static Set<String> h(byte[] bArr, int i, int i2) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (i2 > 0) {
            b bVar = new b(bArr, i);
            int i3 = i + i2;
            while (bVar.position < i3) {
                linkedHashSet.add(bVar.getString(bVar.aqt()));
            }
            if (bVar.position != i3) {
                throw new IllegalArgumentException("Invalid String set");
            }
        }
        return linkedHashSet;
    }
}
