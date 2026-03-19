package com.component.lottie.e;

import com.bytedance.common.utility.StringEncryptUtils;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class j implements Serializable, Comparable<j> {
    static final char[] a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    public static final j b = a(new byte[0]);
    private static final long f = 1;
    final byte[] c;
    transient int d;
    transient String e;

    j(byte[] bArr) {
        this.c = bArr;
    }

    public static j a(byte... bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("data == null");
        }
        return new j((byte[]) bArr.clone());
    }

    public static j a(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new IllegalArgumentException("data == null");
        }
        k.a(bArr.length, i, i2);
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return new j(bArr2);
    }

    public static j a(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            throw new IllegalArgumentException("data == null");
        }
        byte[] bArr = new byte[byteBuffer.remaining()];
        byteBuffer.get(bArr);
        return new j(bArr);
    }

    public static j a(String str) {
        if (str == null) {
            throw new IllegalArgumentException("s == null");
        }
        j jVar = new j(str.getBytes(k.a));
        jVar.e = str;
        return jVar;
    }

    public static j a(String str, Charset charset) {
        if (str == null) {
            throw new IllegalArgumentException("s == null");
        }
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        return new j(str.getBytes(charset));
    }

    public String a() {
        String str = this.e;
        if (str != null) {
            return str;
        }
        String str2 = new String(this.c, k.a);
        this.e = str2;
        return str2;
    }

    public String a(Charset charset) {
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        return new String(this.c, charset);
    }

    public String b() {
        return d.b(this.c);
    }

    public j c() {
        return d("MD5");
    }

    public j d() {
        return d(StringEncryptUtils.SHA_1);
    }

    public j e() {
        return d(StringEncryptUtils.SHA_256);
    }

    public j f() {
        return d("SHA-512");
    }

    private j d(String str) {
        try {
            return a(MessageDigest.getInstance(str).digest(this.c));
        } catch (NoSuchAlgorithmException e) {
            throw new AssertionError(e);
        }
    }

    public j a(j jVar) {
        return a("HmacSHA1", jVar);
    }

    public j b(j jVar) {
        return a("HmacSHA256", jVar);
    }

    public j c(j jVar) {
        return a("HmacSHA512", jVar);
    }

    private j a(String str, j jVar) throws NoSuchAlgorithmException, InvalidKeyException {
        try {
            Mac mac = Mac.getInstance(str);
            mac.init(new SecretKeySpec(jVar.l(), str));
            return a(mac.doFinal(this.c));
        } catch (InvalidKeyException e) {
            throw new IllegalArgumentException(e);
        } catch (NoSuchAlgorithmException e2) {
            throw new AssertionError(e2);
        }
    }

    public String g() {
        return d.a(this.c);
    }

    public static j b(String str) {
        if (str == null) {
            throw new IllegalArgumentException("base64 == null");
        }
        byte[] bArrA = d.a(str);
        if (bArrA != null) {
            return new j(bArrA);
        }
        return null;
    }

    public String h() {
        char[] cArr = new char[this.c.length * 2];
        int i = 0;
        for (byte b2 : this.c) {
            int i2 = i + 1;
            cArr[i] = a[(b2 >> 4) & 15];
            i = i2 + 1;
            cArr[i2] = a[b2 & 15];
        }
        return new String(cArr);
    }

    public static j c(String str) {
        if (str == null) {
            throw new IllegalArgumentException("hex == null");
        }
        if (str.length() % 2 != 0) {
            throw new IllegalArgumentException("Unexpected hex string: " + str);
        }
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            bArr[i] = (byte) ((a(str.charAt(i2)) << 4) + a(str.charAt(i2 + 1)));
        }
        return a(bArr);
    }

    private static int a(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        }
        if (c >= 'a' && c <= 'f') {
            return (c - 'a') + 10;
        }
        if (c >= 'A' && c <= 'F') {
            return (c - 'A') + 10;
        }
        throw new IllegalArgumentException("Unexpected hex digit: " + c);
    }

    public static j a(InputStream inputStream, int i) throws IOException {
        if (inputStream == null) {
            throw new IllegalArgumentException("in == null");
        }
        if (i < 0) {
            throw new IllegalArgumentException("byteCount < 0: " + i);
        }
        byte[] bArr = new byte[i];
        int i2 = 0;
        while (i2 < i) {
            int i3 = inputStream.read(bArr, i2, i - i2);
            if (i3 != -1) {
                i2 += i3;
            } else {
                throw new EOFException();
            }
        }
        return new j(bArr);
    }

    public j i() {
        for (int i = 0; i < this.c.length; i++) {
            byte b2 = this.c[i];
            if (b2 >= 65 && b2 <= 90) {
                byte[] bArr = (byte[]) this.c.clone();
                bArr[i] = (byte) (b2 + 32);
                for (int i2 = i + 1; i2 < bArr.length; i2++) {
                    byte b3 = bArr[i2];
                    if (b3 >= 65 && b3 <= 90) {
                        bArr[i2] = (byte) (b3 + 32);
                    }
                }
                return new j(bArr);
            }
        }
        return this;
    }

    public j j() {
        for (int i = 0; i < this.c.length; i++) {
            byte b2 = this.c[i];
            if (b2 >= 97 && b2 <= 122) {
                byte[] bArr = (byte[]) this.c.clone();
                bArr[i] = (byte) (b2 - 32);
                for (int i2 = i + 1; i2 < bArr.length; i2++) {
                    byte b3 = bArr[i2];
                    if (b3 >= 97 && b3 <= 122) {
                        bArr[i2] = (byte) (b3 - 32);
                    }
                }
                return new j(bArr);
            }
        }
        return this;
    }

    public j a(int i) {
        return a(i, this.c.length);
    }

    public j a(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException("beginIndex < 0");
        }
        if (i2 > this.c.length) {
            throw new IllegalArgumentException("endIndex > length(" + this.c.length + ")");
        }
        int i3 = i2 - i;
        if (i3 < 0) {
            throw new IllegalArgumentException("endIndex < beginIndex");
        }
        if (i == 0 && i2 == this.c.length) {
            return this;
        }
        byte[] bArr = new byte[i3];
        System.arraycopy(this.c, i, bArr, 0, i3);
        return new j(bArr);
    }

    public byte b(int i) {
        return this.c[i];
    }

    public int k() {
        return this.c.length;
    }

    public byte[] l() {
        return (byte[]) this.c.clone();
    }

    byte[] m() {
        return this.c;
    }

    public ByteBuffer n() {
        return ByteBuffer.wrap(this.c).asReadOnlyBuffer();
    }

    public void a(OutputStream outputStream) throws IOException {
        if (outputStream == null) {
            throw new IllegalArgumentException("out == null");
        }
        outputStream.write(this.c);
    }

    void a(e eVar) {
        eVar.c(this.c, 0, this.c.length);
    }

    public boolean a(int i, j jVar, int i2, int i3) {
        return jVar.a(i2, this.c, i, i3);
    }

    public boolean a(int i, byte[] bArr, int i2, int i3) {
        return i >= 0 && i <= this.c.length - i3 && i2 >= 0 && i2 <= bArr.length - i3 && k.a(this.c, i, bArr, i2, i3);
    }

    public final boolean d(j jVar) {
        return a(0, jVar, 0, jVar.k());
    }

    public final boolean b(byte[] bArr) {
        return a(0, bArr, 0, bArr.length);
    }

    public final boolean e(j jVar) {
        return a(k() - jVar.k(), jVar, 0, jVar.k());
    }

    public final boolean c(byte[] bArr) {
        return a(k() - bArr.length, bArr, 0, bArr.length);
    }

    public final int f(j jVar) {
        return a(jVar.m(), 0);
    }

    public final int a(j jVar, int i) {
        return a(jVar.m(), i);
    }

    public final int d(byte[] bArr) {
        return a(bArr, 0);
    }

    public int a(byte[] bArr, int i) {
        int length = this.c.length - bArr.length;
        for (int iMax = Math.max(i, 0); iMax <= length; iMax++) {
            if (k.a(this.c, iMax, bArr, 0, bArr.length)) {
                return iMax;
            }
        }
        return -1;
    }

    public final int g(j jVar) {
        return b(jVar.m(), k());
    }

    public final int b(j jVar, int i) {
        return b(jVar.m(), i);
    }

    public final int e(byte[] bArr) {
        return b(bArr, k());
    }

    public int b(byte[] bArr, int i) {
        for (int iMin = Math.min(i, this.c.length - bArr.length); iMin >= 0; iMin--) {
            if (k.a(this.c, iMin, bArr, 0, bArr.length)) {
                return iMin;
            }
        }
        return -1;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof j) {
            j jVar = (j) obj;
            if (jVar.k() == this.c.length && jVar.a(0, this.c, 0, this.c.length)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i = this.d;
        if (i != 0) {
            return i;
        }
        int iHashCode = Arrays.hashCode(this.c);
        this.d = iHashCode;
        return iHashCode;
    }

    @Override // java.lang.Comparable
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public int compareTo(j jVar) {
        int iK = k();
        int iK2 = jVar.k();
        int iMin = Math.min(iK, iK2);
        for (int i = 0; i < iMin; i++) {
            int iB = b(i) & 255;
            int iB2 = jVar.b(i) & 255;
            if (iB != iB2) {
                return iB < iB2 ? -1 : 1;
            }
        }
        if (iK == iK2) {
            return 0;
        }
        return iK < iK2 ? -1 : 1;
    }

    public String toString() {
        if (this.c.length == 0) {
            return "[size=0]";
        }
        String strA = a();
        int iA = a(strA, 64);
        if (iA == -1) {
            if (this.c.length > 64) {
                return "[size=" + this.c.length + " hex=" + a(0, 64).h() + "…]";
            }
            return "[hex=" + h() + "]";
        }
        String strReplace = strA.substring(0, iA).replace("\\", "\\\\").replace("\n", "\\n").replace("\r", "\\r");
        if (iA < strA.length()) {
            return "[size=" + this.c.length + " text=" + strReplace + "…]";
        }
        return "[text=" + strReplace + "]";
    }

    static int a(String str, int i) {
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

    private void a(ObjectInputStream objectInputStream) throws IllegalAccessException, NoSuchFieldException, IOException, IllegalArgumentException {
        j jVarA = a(objectInputStream, objectInputStream.readInt());
        try {
            Field declaredField = j.class.getDeclaredField("c");
            declaredField.setAccessible(true);
            declaredField.set(this, jVarA.c);
        } catch (IllegalAccessException e) {
            throw new AssertionError();
        } catch (NoSuchFieldException e2) {
            throw new AssertionError();
        }
    }

    private void a(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(this.c.length);
        objectOutputStream.write(this.c);
    }
}
