package com.bytedance.sdk.component.b.hc.d.gb;

import com.bytedance.sdk.component.b.d.mq;
import com.bytedance.sdk.component.b.d.tc;
import com.bytedance.sdk.component.b.hc.d.b;
import com.bytedance.sdk.component.b.hc.d.h.u;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.IDN;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class d {
    private byte[] gb;
    private byte[] h;
    private static final byte[] d = {42};
    private static final String[] hc = new String[0];
    private static final String[] b = {"*"};
    private static final d c = new d();
    private final AtomicBoolean u = new AtomicBoolean(false);
    private final CountDownLatch an = new CountDownLatch(1);

    public static d d() {
        return c;
    }

    public String d(String str) throws InterruptedException {
        int length;
        int length2;
        if (str == null) {
            throw new NullPointerException("domain == null");
        }
        String[] strArrSplit = IDN.toUnicode(str).split("\\.");
        String[] strArrD = d(strArrSplit);
        if (strArrSplit.length == strArrD.length && strArrD[0].charAt(0) != '!') {
            return null;
        }
        if (strArrD[0].charAt(0) == '!') {
            length = strArrSplit.length;
            length2 = strArrD.length;
        } else {
            length = strArrSplit.length;
            length2 = strArrD.length + 1;
        }
        StringBuilder sb = new StringBuilder();
        String[] strArrSplit2 = str.split("\\.");
        for (int i = length - length2; i < strArrSplit2.length; i++) {
            sb.append(strArrSplit2[i]).append('.');
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    private String[] d(String[] strArr) throws InterruptedException {
        String str;
        String strD;
        String strD2;
        int i = 0;
        if (!this.u.get() && this.u.compareAndSet(false, true)) {
            hc();
        } else {
            try {
                this.an.await();
            } catch (InterruptedException unused) {
            }
        }
        synchronized (this) {
            if (this.h == null) {
                throw new IllegalStateException("Unable to load publicsuffixes.gz resource from the classpath.");
            }
        }
        int length = strArr.length;
        byte[][] bArr = new byte[length][];
        for (int i2 = 0; i2 < strArr.length; i2++) {
            bArr[i2] = strArr[i2].getBytes(b.u);
        }
        int i3 = 0;
        while (true) {
            str = null;
            if (i3 >= length) {
                strD = null;
                break;
            }
            strD = d(this.h, bArr, i3);
            if (strD != null) {
                break;
            }
            i3++;
        }
        if (length > 1) {
            byte[][] bArr2 = (byte[][]) bArr.clone();
            for (int i4 = 0; i4 < bArr2.length - 1; i4++) {
                bArr2[i4] = d;
                strD2 = d(this.h, bArr2, i4);
                if (strD2 != null) {
                    break;
                }
            }
            strD2 = null;
        } else {
            strD2 = null;
        }
        if (strD2 != null) {
            while (true) {
                if (i >= length - 1) {
                    break;
                }
                String strD3 = d(this.gb, bArr, i);
                if (strD3 != null) {
                    str = strD3;
                    break;
                }
                i++;
            }
        }
        if (str != null) {
            return ("!" + str).split("\\.");
        }
        if (strD == null && strD2 == null) {
            return b;
        }
        String[] strArrSplit = strD != null ? strD.split("\\.") : hc;
        String[] strArrSplit2 = strD2 != null ? strD2.split("\\.") : hc;
        return strArrSplit.length > strArrSplit2.length ? strArrSplit : strArrSplit2;
    }

    private static String d(byte[] bArr, byte[][] bArr2, int i) {
        int i2;
        boolean z;
        int i3;
        int i4;
        int length = bArr.length;
        int i5 = 0;
        while (i5 < length) {
            int i6 = (i5 + length) / 2;
            while (i6 >= 0 && bArr[i6] != 10) {
                i6--;
            }
            int i7 = i6 + 1;
            int i8 = 1;
            while (true) {
                i2 = i7 + i8;
                if (bArr[i2] == 10) {
                    break;
                }
                i8++;
            }
            int i9 = i2 - i7;
            int i10 = i;
            boolean z2 = false;
            int i11 = 0;
            int i12 = 0;
            while (true) {
                if (z2) {
                    i3 = 46;
                    z = false;
                } else {
                    z = z2;
                    i3 = bArr2[i10][i11] & 255;
                }
                i4 = i3 - (bArr[i7 + i12] & 255);
                if (i4 != 0) {
                    break;
                }
                i12++;
                i11++;
                if (i12 == i9) {
                    break;
                }
                if (bArr2[i10].length != i11) {
                    z2 = z;
                } else {
                    if (i10 == bArr2.length - 1) {
                        break;
                    }
                    i10++;
                    i11 = -1;
                    z2 = true;
                }
            }
            if (i4 >= 0) {
                if (i4 <= 0) {
                    int i13 = i9 - i12;
                    int length2 = bArr2[i10].length - i11;
                    while (true) {
                        i10++;
                        if (i10 >= bArr2.length) {
                            break;
                        }
                        length2 += bArr2[i10].length;
                    }
                    if (length2 >= i13) {
                        if (length2 <= i13) {
                            return new String(bArr, i7, i9, b.u);
                        }
                    }
                }
                i5 = i2 + 1;
            }
            length = i7 - 1;
        }
        return null;
    }

    private void hc() {
        boolean z = false;
        while (true) {
            try {
                try {
                    b();
                    break;
                } catch (InterruptedIOException unused) {
                    z = true;
                } catch (IOException e) {
                    u.hc().d(5, "Failed to read public suffix list", e);
                    if (z) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                    return;
                }
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
    }

    private void b() throws IOException {
        InputStream resourceAsStream = d.class.getResourceAsStream("publicsuffixes.gz");
        if (resourceAsStream == null) {
            return;
        }
        com.bytedance.sdk.component.b.d.u uVarD = mq.d(new tc(mq.d(resourceAsStream)));
        try {
            byte[] bArr = new byte[uVarD.tc()];
            uVarD.d(bArr);
            byte[] bArr2 = new byte[uVarD.tc()];
            uVarD.d(bArr2);
            synchronized (this) {
                this.h = bArr;
                this.gb = bArr2;
            }
            this.an.countDown();
        } finally {
            b.d(uVarD);
        }
    }
}
