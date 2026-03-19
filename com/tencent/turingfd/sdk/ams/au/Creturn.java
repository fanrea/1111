package com.tencent.turingfd.sdk.ams.au;

import androidx.core.view.MotionEventCompat;
import com.baidu.mobstat.forbes.Config;
import com.kuaishou.weapon.p0.t;
import com.netease.htprotect.p010Ooo.p014o0o0.p015O8oO888.o0O0O;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/* compiled from: A */
/* renamed from: com.tencent.turingfd.sdk.ams.au.return, reason: invalid class name */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class Creturn {
    public static final String[] j = {"px", t.q, "sp", Config.PLATFORM_TYPE, "in", "mm"};
    public Cpublic a;
    public Map<String, String> b = new HashMap();
    public byte[] c;
    public String[] d;
    public int[] e;
    public int f;
    public int g;
    public int h;
    public int i;

    public Document a(InputStream inputStream) throws ParserConfigurationException, DOMException, IOException {
        String strB;
        String str;
        String strB2;
        byte[] bArr;
        Cpublic cpublic = new Cpublic();
        this.a = cpublic;
        byte[] bArr2 = new byte[inputStream.available()];
        this.c = bArr2;
        inputStream.read(bArr2);
        inputStream.close();
        while (true) {
            int i = this.i;
            if (i >= this.c.length) {
                this.a.getClass();
                return cpublic.b;
            }
            int iA = a(i);
            int i2 = -1;
            if (iA == -1) {
                this.a.getClass();
            } else if (iA == 524291) {
                Cpublic cpublic2 = this.a;
                Document documentNewDocument = cpublic2.c.newDocument();
                cpublic2.b = documentNewDocument;
                cpublic2.a.push(documentNewDocument);
                this.i += 8;
            } else if (iA == 524672) {
                int iA2 = a(this.i + 4);
                int i3 = (iA2 / 4) - 2;
                this.h = i3;
                this.e = new int[i3];
                for (int i4 = 0; i4 < this.h; i4++) {
                    this.e[i4] = a(((i4 + 2) * 4) + this.i);
                }
                this.i += iA2;
            } else if (iA != 1835009) {
                switch (iA) {
                    case 1048832:
                        a(true);
                        break;
                    case 1048833:
                        a(false);
                        break;
                    case 1048834:
                        int iA3 = a(this.i + 16);
                        int iA4 = a(this.i + 20);
                        int i5 = this.i;
                        byte[] bArr3 = this.c;
                        int i6 = (65280 & (bArr3[i5 + 29] << 8)) | (bArr3[i5 + 28] & 255);
                        String strB3 = b(iA4);
                        if (iA3 == -1) {
                            str = strB3;
                            strB = "";
                        } else {
                            strB = b(iA3);
                            str = this.b.containsKey(strB) ? this.b.get(strB) + ':' + strB3 : strB3;
                        }
                        this.i += 36;
                        Celse[] celseArr = new Celse[i6];
                        int i7 = 0;
                        while (i7 < i6) {
                            int iA5 = a(this.i);
                            int iA6 = a(this.i + 4);
                            int iA7 = a(this.i + 8);
                            int iA8 = a(this.i + 12);
                            int iA9 = a(this.i + 16);
                            Celse celse = new Celse();
                            celse.a = b(iA6);
                            if (iA5 == i2) {
                                celse.c = null;
                                celse.b = null;
                            } else {
                                String strB4 = b(iA5);
                                if (this.b.containsKey(strB4)) {
                                    celse.c = strB4;
                                    celse.b = this.b.get(strB4);
                                }
                            }
                            if (iA7 == i2) {
                                switch (iA8) {
                                    case o0O0O.Ooo.f421 /* 16777224 */:
                                        strB2 = String.format("@id/0x%08X", Integer.valueOf(iA9));
                                        break;
                                    case 33554440:
                                        strB2 = String.format("?id/0x%08X", Integer.valueOf(iA9));
                                        break;
                                    case 50331656:
                                        strB2 = b(iA9);
                                        break;
                                    case 67108872:
                                        strB2 = Float.toString(Float.intBitsToFloat(iA9));
                                        break;
                                    case 83886088:
                                        strB2 = Integer.toString(iA9 >> 8) + j[iA9 & 255];
                                        break;
                                    case 100663304:
                                        double d = iA9;
                                        Double.isNaN(d);
                                        strB2 = new DecimalFormat("#.##%").format(d / 2.147483647E9d);
                                        break;
                                    case 268435464:
                                    case 285212680:
                                        strB2 = Integer.toString(iA9);
                                        break;
                                    case 301989896:
                                        strB2 = Boolean.toString(iA9 != 0);
                                        break;
                                    case 469762056:
                                    case 486539272:
                                        strB2 = String.format("#%08X", Integer.valueOf(iA9));
                                        break;
                                    default:
                                        strB2 = String.format("%08X/0x%08X", Integer.valueOf(iA8), Integer.valueOf(iA9));
                                        break;
                                }
                                celse.d = strB2;
                            } else {
                                celse.d = b(iA7);
                            }
                            celseArr[i7] = celse;
                            this.i += 20;
                            i7++;
                            i2 = -1;
                        }
                        Cpublic cpublic3 = this.a;
                        cpublic3.getClass();
                        Element elementCreateElement = (strB == null || "".equals(strB)) ? cpublic3.b.createElement(strB3) : cpublic3.b.createElementNS(strB, str);
                        for (int i8 = 0; i8 < i6; i8++) {
                            Celse celse2 = celseArr[i8];
                            String str2 = celse2.c;
                            if (str2 == null || "".equals(str2)) {
                                elementCreateElement.setAttribute(celse2.a, celse2.d);
                            } else {
                                elementCreateElement.setAttributeNS(celse2.c, celse2.b + ':' + celse2.a, celse2.d);
                            }
                        }
                        cpublic3.a.peek().appendChild(elementCreateElement);
                        cpublic3.a.push(elementCreateElement);
                        break;
                    case 1048835:
                        int iA10 = a(this.i + 16);
                        b(a(this.i + 20));
                        if (iA10 != -1) {
                            b(iA10);
                        }
                        this.a.a.pop();
                        this.i += 24;
                        break;
                    case 1048836:
                        String strB5 = b(a(this.i + 16));
                        Cpublic cpublic4 = this.a;
                        cpublic4.a.peek().appendChild(cpublic4.b.createCDATASection(strB5));
                        this.i += 28;
                        break;
                    default:
                        this.i += 4;
                        break;
                }
            } else {
                int iA11 = a(this.i + 4);
                this.f = a(this.i + 8);
                this.g = a(this.i + 12);
                int i9 = this.i;
                int iA12 = a(i9 + 20) + i9;
                int iA13 = a(this.i + 24);
                this.d = new String[this.f];
                for (int i10 = 0; i10 < this.f; i10++) {
                    int iA14 = a(((i10 + 7) * 4) + this.i) + iA12;
                    String[] strArr = this.d;
                    byte[] bArr4 = this.c;
                    int i11 = bArr4[iA14 + 1];
                    int i12 = bArr4[iA14];
                    if (i11 == i12) {
                        bArr = new byte[i12];
                        for (int i13 = 0; i13 < i12; i13++) {
                            bArr[i13] = this.c[iA14 + 2 + i13];
                        }
                    } else {
                        int i14 = (i12 & 255) | ((i11 << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK);
                        bArr = new byte[i14];
                        for (int i15 = 0; i15 < i14; i15++) {
                            bArr[i15] = this.c[(i15 * 2) + iA14 + 2];
                        }
                    }
                    strArr[i10] = new String(bArr);
                }
                if (iA13 > 0) {
                    for (int i16 = 0; i16 < this.g; i16++) {
                    }
                }
                this.i += iA11;
            }
        }
    }

    public final String b(int i) {
        if (i < 0 || i >= this.f) {
            return null;
        }
        return this.d[i];
    }

    public final void a(boolean z) {
        int iA = a(this.i + 16);
        String strB = b(a(this.i + 20));
        String strB2 = b(iA);
        if (z) {
            this.a.getClass();
            this.b.put(strB, strB2);
        } else {
            this.a.getClass();
            this.b.remove(strB);
        }
        this.i += 24;
    }

    public final int a(int i) {
        byte[] bArr = this.c;
        return (bArr[i] & 255) | ((bArr[i + 3] << 24) & (-16777216)) | ((bArr[i + 2] << 16) & 16711680) | ((bArr[i + 1] << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK);
    }
}
