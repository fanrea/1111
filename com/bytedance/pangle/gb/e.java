package com.bytedance.pangle.gb;

import android.content.pm.Signature;
import android.util.ArraySet;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.PublicKey;
import java.security.cert.CertificateException;
import java.util.Arrays;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
final class e {
    public static final e d = new e(null, 0, null, null, null);
    public final int[] an;
    public final int b;
    public final ArraySet<PublicKey> c;
    public final Signature[] hc;
    public final Signature[] u;

    public static ArraySet<PublicKey> d(Signature[] signatureArr) throws NoSuchMethodException, SecurityException, CertificateException {
        ArraySet<PublicKey> arraySet = new ArraySet<>(signatureArr.length);
        for (Signature signature : signatureArr) {
            Method method = null;
            try {
                method = Signature.class.getMethod("getPublicKey", new Class[0]);
            } catch (NoSuchMethodException e) {
                com.bytedance.sdk.openadsdk.api.an.d(e);
            }
            if (method != null && method.isAccessible()) {
                try {
                    arraySet.add((PublicKey) method.invoke(signature, new Object[0]));
                } catch (IllegalAccessException e2) {
                    com.bytedance.sdk.openadsdk.api.an.d(e2);
                } catch (InvocationTargetException e3) {
                    com.bytedance.sdk.openadsdk.api.an.d(e3);
                } catch (Exception e4) {
                    com.bytedance.sdk.openadsdk.api.an.d(e4);
                }
            }
        }
        return arraySet;
    }

    public static boolean d(Signature[] signatureArr, Signature[] signatureArr2) {
        return signatureArr.length == signatureArr2.length && com.bytedance.pangle.util.c.d((Object[]) signatureArr, (Object[]) signatureArr2) && com.bytedance.pangle.util.c.d((Object[]) signatureArr2, (Object[]) signatureArr);
    }

    public static boolean d(byte[] bArr, byte[] bArr2) {
        if (bArr.length != bArr2.length) {
            return false;
        }
        for (int i = 0; i < bArr.length; i++) {
            if (bArr[i] != bArr2[i]) {
                return false;
            }
        }
        return true;
    }

    public e(Signature[] signatureArr, int i, ArraySet<PublicKey> arraySet, Signature[] signatureArr2, int[] iArr) {
        this.hc = signatureArr;
        this.b = i;
        this.c = arraySet;
        this.u = signatureArr2;
        this.an = iArr;
    }

    public e(Signature[] signatureArr, int i, Signature[] signatureArr2, int[] iArr) throws CertificateException {
        this(signatureArr, i, d(signatureArr), signatureArr2, iArr);
    }

    public e(Signature[] signatureArr, int i) throws CertificateException {
        this(signatureArr, i, null, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        if (this.b != eVar.b || !d(this.hc, eVar.hc)) {
            return false;
        }
        ArraySet<PublicKey> arraySet = this.c;
        if (arraySet != null) {
            if (!arraySet.equals(eVar.c)) {
                return false;
            }
        } else if (eVar.c != null) {
            return false;
        }
        return Arrays.equals(this.u, eVar.u) && Arrays.equals(this.an, eVar.an);
    }

    public int hashCode() {
        int iHashCode = ((Arrays.hashCode(this.hc) * 31) + this.b) * 31;
        ArraySet<PublicKey> arraySet = this.c;
        return ((((iHashCode + (arraySet != null ? arraySet.hashCode() : 0)) * 31) + Arrays.hashCode(this.u)) * 31) + Arrays.hashCode(this.an);
    }
}
