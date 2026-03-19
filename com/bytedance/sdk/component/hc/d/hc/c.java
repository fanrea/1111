package com.bytedance.sdk.component.hc.d.hc;

import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Arrays;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class c implements Serializable, Comparable<c> {
    transient String an;
    final byte[] c;
    transient int u;
    static final char[] d = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    public static final Charset hc = Charset.forName("UTF-8");
    public static final c b = d(new byte[0]);

    c(byte[] bArr) {
        this.c = bArr;
    }

    public static c d(byte... bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("data == null");
        }
        return new c((byte[]) bArr.clone());
    }

    public String d() {
        String str = this.an;
        if (str != null) {
            return str;
        }
        String str2 = new String(this.c, hc);
        this.an = str2;
        return str2;
    }

    public static c d(String str) {
        if (str == null) {
            throw new IllegalArgumentException("s == null");
        }
        c cVar = new c(str.getBytes(tc.d));
        cVar.an = str;
        return cVar;
    }

    public String hc() {
        byte[] bArr = this.c;
        char[] cArr = new char[bArr.length * 2];
        int i = 0;
        for (byte b2 : bArr) {
            int i2 = i + 1;
            char[] cArr2 = d;
            cArr[i] = cArr2[(b2 >> 4) & 15];
            i = i2 + 1;
            cArr[i2] = cArr2[b2 & 15];
        }
        return new String(cArr);
    }

    public c d(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException("beginIndex < 0");
        }
        byte[] bArr = this.c;
        if (i2 > bArr.length) {
            throw new IllegalArgumentException("endIndex > length(" + this.c.length + ")");
        }
        int i3 = i2 - i;
        if (i3 < 0) {
            throw new IllegalArgumentException("endIndex < beginIndex");
        }
        if (i == 0 && i2 == bArr.length) {
            return this;
        }
        byte[] bArr2 = new byte[i3];
        System.arraycopy(bArr, i, bArr2, 0, i3);
        return new c(bArr2);
    }

    public byte d(int i) {
        return this.c[i];
    }

    public int b() {
        return this.c.length;
    }

    public byte[] c() {
        return (byte[]) this.c.clone();
    }

    public boolean d(int i, c cVar, int i2, int i3) {
        return cVar.d(i2, this.c, i, i3);
    }

    public boolean d(int i, byte[] bArr, int i2, int i3) {
        if (i < 0) {
            return false;
        }
        byte[] bArr2 = this.c;
        return i <= bArr2.length - i3 && i2 >= 0 && i2 <= bArr.length - i3 && tc.d(bArr2, i, bArr, i2, i3);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof c) {
            c cVar = (c) obj;
            int iB = cVar.b();
            byte[] bArr = this.c;
            if (iB == bArr.length && cVar.d(0, bArr, 0, bArr.length)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i = this.u;
        if (i != 0) {
            return i;
        }
        int iHashCode = Arrays.hashCode(this.c);
        this.u = iHashCode;
        return iHashCode;
    }

    @Override // java.lang.Comparable
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public int compareTo(c cVar) {
        int iB = b();
        int iB2 = cVar.b();
        int iMin = Math.min(iB, iB2);
        for (int i = 0; i < iMin; i++) {
            int iD = d(i) & 255;
            int iD2 = cVar.d(i) & 255;
            if (iD != iD2) {
                return iD < iD2 ? -1 : 1;
            }
        }
        if (iB == iB2) {
            return 0;
        }
        return iB < iB2 ? -1 : 1;
    }

    public String toString() {
        if (this.c.length == 0) {
            return "[size=0]";
        }
        String strD = d();
        int iD = d(strD, 64);
        if (iD == -1) {
            if (this.c.length <= 64) {
                return "[hex=" + hc() + "]";
            }
            return "[size=" + this.c.length + " hex=" + d(0, 64).hc() + "…]";
        }
        String strReplace = strD.substring(0, iD).replace("\\", "\\\\").replace("\n", "\\n").replace("\r", "\\r");
        return iD < strD.length() ? "[size=" + this.c.length + " text=" + strReplace + "…]" : "[text=" + strReplace + "]";
    }

    static int d(String str, int i) {
        int length = str.length();
        int iCharCount = 0;
        int i2 = 0;
        while (iCharCount < length) {
            if (i2 == i) {
                return iCharCount;
            }
            int iCodePointAt = str.codePointAt(iCharCount);
            if ((Character.isISOControl(iCodePointAt) && iCodePointAt != 10 && iCodePointAt != 13) || iCodePointAt == 65533) {
                return -1;
            }
            i2++;
            iCharCount += Character.charCount(iCodePointAt);
        }
        return str.length();
    }
}
