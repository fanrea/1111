package com.component.lottie.f.a;

import kotlin.text.Typography;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
final class d {
    static final int a = 1;
    static final int b = 2;
    static final int c = 3;
    static final int d = 4;
    static final int e = 5;
    static final int f = 6;
    static final int g = 7;
    static final int h = 8;

    private d() {
    }

    static String a(int i, int[] iArr, String[] strArr, int[] iArr2) {
        StringBuilder sbAppend = new StringBuilder().append(Typography.dollar);
        for (int i2 = 0; i2 < i; i2++) {
            switch (iArr[i2]) {
                case 1:
                case 2:
                    sbAppend.append('[').append(iArr2[i2]).append(']');
                    break;
                case 3:
                case 4:
                case 5:
                    sbAppend.append('.');
                    if (strArr[i2] != null) {
                        sbAppend.append(strArr[i2]);
                        break;
                    } else {
                        break;
                    }
            }
        }
        return sbAppend.toString();
    }
}
