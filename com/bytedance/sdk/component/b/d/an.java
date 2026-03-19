package com.bytedance.sdk.component.b.d;

import com.bytedance.common.utility.StringEncryptUtils;
import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class an implements Serializable, Comparable<an> {
    static final char[] d = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    public static final an hc = d(new byte[0]);
    final byte[] b;
    transient int c;
    transient String u;

    an(byte[] bArr) {
        this.b = bArr;
    }

    public static an d(byte... bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("data == null");
        }
        return new an((byte[]) bArr.clone());
    }

    public static an d(String str) {
        if (str == null) {
            throw new IllegalArgumentException("s == null");
        }
        an anVar = new an(str.getBytes(sy.d));
        anVar.u = str;
        return anVar;
    }

    public String d() {
        String str = this.u;
        if (str != null) {
            return str;
        }
        String str2 = new String(this.b, sy.d);
        this.u = str2;
        return str2;
    }

    public String hc() {
        return hc.d(this.b);
    }

    public an b() {
        return b(StringEncryptUtils.SHA_1);
    }

    public an c() {
        return b(StringEncryptUtils.SHA_256);
    }

    private an b(String str) {
        try {
            return d(MessageDigest.getInstance(str).digest(this.b));
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        }
    }

    public String u() {
        byte[] bArr = this.b;
        char[] cArr = new char[bArr.length * 2];
        int i = 0;
        for (byte b : bArr) {
            int i2 = i + 1;
            char[] cArr2 = d;
            cArr[i] = cArr2[(b >> 4) & 15];
            i = i2 + 1;
            cArr[i2] = cArr2[b & 15];
        }
        return new String(cArr);
    }

    public static an hc(String str) {
        if (str == null) {
            throw new IllegalArgumentException("hex == null");
        }
        if (str.length() % 2 != 0) {
            throw new IllegalArgumentException("Unexpected hex string: ".concat(String.valueOf(str)));
        }
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            bArr[i] = (byte) ((d(str.charAt(i2)) << 4) + d(str.charAt(i2 + 1)));
        }
        return d(bArr);
    }

    private static int d(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        }
        char c2 = 'a';
        if (c < 'a' || c > 'f') {
            c2 = 'A';
            if (c < 'A' || c > 'F') {
                throw new IllegalArgumentException("Unexpected hex digit: ".concat(String.valueOf(c)));
            }
        }
        return (c - c2) + 10;
    }

    public an an() {
        int i = 0;
        while (true) {
            byte[] bArr = this.b;
            if (i >= bArr.length) {
                return this;
            }
            byte b = bArr[i];
            if (b >= 65 && b <= 90) {
                byte[] bArr2 = (byte[]) bArr.clone();
                bArr2[i] = (byte) (b + 32);
                for (int i2 = i + 1; i2 < bArr2.length; i2++) {
                    byte b2 = bArr2[i2];
                    if (b2 >= 65 && b2 <= 90) {
                        bArr2[i2] = (byte) (b2 + 32);
                    }
                }
                return new an(bArr2);
            }
            i++;
        }
    }

    public an d(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException("beginIndex < 0");
        }
        byte[] bArr = this.b;
        if (i2 > bArr.length) {
            throw new IllegalArgumentException("endIndex > length(" + this.b.length + ")");
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
        return new an(bArr2);
    }

    public byte d(int i) {
        return this.b[i];
    }

    public int h() {
        return this.b.length;
    }

    public byte[] gb() {
        return (byte[]) this.b.clone();
    }

    void d(b bVar) {
        byte[] bArr = this.b;
        bVar.b(bArr, 0, bArr.length);
    }

    public boolean d(int i, an anVar, int i2, int i3) {
        return anVar.d(i2, this.b, i, i3);
    }

    public boolean d(int i, byte[] bArr, int i2, int i3) {
        if (i < 0) {
            return false;
        }
        byte[] bArr2 = this.b;
        return i <= bArr2.length - i3 && i2 >= 0 && i2 <= bArr.length - i3 && sy.d(bArr2, i, bArr, i2, i3);
    }

    public final boolean d(an anVar) {
        return d(0, anVar, 0, anVar.h());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof an) {
            an anVar = (an) obj;
            int iH = anVar.h();
            byte[] bArr = this.b;
            if (iH == bArr.length && anVar.d(0, bArr, 0, bArr.length)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i = this.c;
        if (i != 0) {
            return i;
        }
        int iHashCode = Arrays.hashCode(this.b);
        this.c = iHashCode;
        return iHashCode;
    }

    @Override // java.lang.Comparable
    /* renamed from: hc, reason: merged with bridge method [inline-methods] */
    public int compareTo(an anVar) {
        int iH = h();
        int iH2 = anVar.h();
        int iMin = Math.min(iH, iH2);
        for (int i = 0; i < iMin; i++) {
            int iD = d(i) & 255;
            int iD2 = anVar.d(i) & 255;
            if (iD != iD2) {
                return iD < iD2 ? -1 : 1;
            }
        }
        if (iH == iH2) {
            return 0;
        }
        return iH < iH2 ? -1 : 1;
    }

    public String toString() {
        if (this.b.length == 0) {
            return "[size=0]";
        }
        String strD = d();
        int iD = d(strD, 64);
        if (iD == -1) {
            if (this.b.length <= 64) {
                return "[hex=" + u() + "]";
            }
            return "[size=" + this.b.length + " hex=" + d(0, 64).u() + "…]";
        }
        String strReplace = strD.substring(0, iD).replace("\\", "\\\\").replace("\n", "\\n").replace("\r", "\\r");
        return iD < strD.length() ? "[size=" + this.b.length + " text=" + strReplace + "…]" : "[text=" + strReplace + "]";
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
