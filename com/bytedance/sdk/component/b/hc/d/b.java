package com.bytedance.sdk.component.b.hc.d;

import androidx.core.location.LocationRequestCompat;
import com.bytedance.sdk.component.b.d.an;
import com.bytedance.sdk.component.b.d.rf;
import com.bytedance.sdk.component.b.d.u;
import com.bytedance.sdk.component.b.hc.s;
import com.bytedance.sdk.component.b.hc.sy;
import com.bytedance.sdk.component.b.hc.vv;
import com.fendasz.moku.planet.utils.thirdparty.codec.CharEncoding;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.IDN;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class b {
    public static final s b;
    public static final vv c;
    public static final byte[] d;
    public static final String[] hc = new String[0];
    private static final an tt = an.hc("efbbbf");
    private static final an tc = an.hc("feff");
    private static final an mk = an.hc("fffe");
    private static final an mq = an.hc("0000ffff");
    private static final an uo = an.hc("ffff0000");
    public static final Charset u = Charset.forName("UTF-8");
    public static final Charset an = Charset.forName(CharEncoding.ISO_8859_1);
    private static final Charset k = Charset.forName(CharEncoding.UTF_16BE);
    private static final Charset e = Charset.forName(CharEncoding.UTF_16LE);
    private static final Charset cb = Charset.forName("UTF-32BE");
    private static final Charset w = Charset.forName("UTF-32LE");
    public static final TimeZone h = TimeZone.getTimeZone("GMT");
    public static final Comparator<String> gb = new Comparator<String>() { // from class: com.bytedance.sdk.component.b.hc.d.b.1
        @Override // java.util.Comparator
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public int compare(String str, String str2) {
            return str.compareTo(str2);
        }
    };
    private static final Pattern yo = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");

    public static int d(char c2) {
        if (c2 >= '0' && c2 <= '9') {
            return c2 - '0';
        }
        char c3 = 'a';
        if (c2 < 'a' || c2 > 'f') {
            c3 = 'A';
            if (c2 < 'A' || c2 > 'F') {
                return -1;
            }
        }
        return (c2 - c3) + 10;
    }

    static {
        byte[] bArr = new byte[0];
        d = bArr;
        b = s.d(null, bArr);
        c = vv.d((sy) null, bArr);
    }

    public static void d(long j, long j2, long j3) {
        if ((j2 | j3) < 0 || j2 > j || j - j2 < j3) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public static boolean d(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static void d(Closeable closeable) throws IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception unused) {
            }
        }
    }

    public static void d(Socket socket) throws IOException {
        if (socket != null) {
            try {
                socket.close();
            } catch (AssertionError e2) {
                if (!d(e2)) {
                    throw e2;
                }
            } catch (RuntimeException unused) {
            } catch (Exception unused2) {
            }
        }
    }

    public static boolean d(rf rfVar, int i, TimeUnit timeUnit) {
        try {
            return hc(rfVar, i, timeUnit);
        } catch (IOException unused) {
            return false;
        }
    }

    public static boolean hc(rf rfVar, int i, TimeUnit timeUnit) throws IOException {
        long jNanoTime = System.nanoTime();
        long jO_ = rfVar.d().b() ? rfVar.d().o_() - jNanoTime : Long.MAX_VALUE;
        rfVar.d().d(Math.min(jO_, timeUnit.toNanos(i)) + jNanoTime);
        try {
            com.bytedance.sdk.component.b.d.b bVar = new com.bytedance.sdk.component.b.d.b();
            while (rfVar.d(bVar, 8192L) != -1) {
                bVar.yo();
            }
            if (jO_ == LocationRequestCompat.PASSIVE_INTERVAL) {
                rfVar.d().an();
                return true;
            }
            rfVar.d().d(jNanoTime + jO_);
            return true;
        } catch (InterruptedIOException unused) {
            if (jO_ == LocationRequestCompat.PASSIVE_INTERVAL) {
                rfVar.d().an();
                return false;
            }
            rfVar.d().d(jNanoTime + jO_);
            return false;
        } catch (Throwable th) {
            if (jO_ == LocationRequestCompat.PASSIVE_INTERVAL) {
                rfVar.d().an();
            } else {
                rfVar.d().d(jNanoTime + jO_);
            }
            throw th;
        }
    }

    public static <T> List<T> d(List<T> list) {
        return Collections.unmodifiableList(new ArrayList(list));
    }

    public static <T> List<T> d(T... tArr) {
        return Collections.unmodifiableList(Arrays.asList((Object[]) tArr.clone()));
    }

    public static ThreadFactory d(final String str, final boolean z) {
        return new ThreadFactory() { // from class: com.bytedance.sdk.component.b.hc.d.b.2
            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                com.bytedance.sdk.component.tc.c.b bVar = new com.bytedance.sdk.component.tc.c.b(runnable, "csj_" + str);
                bVar.setDaemon(z);
                bVar.setPriority(10);
                return bVar;
            }
        };
    }

    public static String[] d(Comparator<? super String> comparator, String[] strArr, String[] strArr2) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            int length = strArr2.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                if (comparator.compare(str, strArr2[i]) == 0) {
                    arrayList.add(str);
                    break;
                }
                i++;
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static boolean hc(Comparator<String> comparator, String[] strArr, String[] strArr2) {
        if (strArr != null && strArr2 != null && strArr.length != 0 && strArr2.length != 0) {
            for (String str : strArr) {
                for (String str2 : strArr2) {
                    if (comparator.compare(str, str2) == 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static String d(com.bytedance.sdk.component.b.hc.rf rfVar, boolean z) {
        String strH;
        if (rfVar.h().contains(":")) {
            strH = "[" + rfVar.h() + "]";
        } else {
            strH = rfVar.h();
        }
        return (z || rfVar.gb() != com.bytedance.sdk.component.b.hc.rf.d(rfVar.b())) ? strH + ":" + rfVar.gb() : strH;
    }

    public static boolean d(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }

    public static int d(Comparator<String> comparator, String[] strArr, String str) {
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            if (comparator.compare(strArr[i], str) == 0) {
                return i;
            }
        }
        return -1;
    }

    public static String[] d(String[] strArr, String str) {
        int length = strArr.length + 1;
        String[] strArr2 = new String[length];
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        strArr2[length - 1] = str;
        return strArr2;
    }

    public static int d(String str, int i, int i2) {
        while (i < i2) {
            char cCharAt = str.charAt(i);
            if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\f' && cCharAt != '\r' && cCharAt != ' ') {
                return i;
            }
            i++;
        }
        return i2;
    }

    public static int hc(String str, int i, int i2) {
        for (int i3 = i2 - 1; i3 >= i; i3--) {
            char cCharAt = str.charAt(i3);
            if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\f' && cCharAt != '\r' && cCharAt != ' ') {
                return i3 + 1;
            }
        }
        return i;
    }

    public static String b(String str, int i, int i2) {
        int iD = d(str, i, i2);
        return str.substring(iD, hc(str, iD, i2));
    }

    public static int d(String str, int i, int i2, String str2) {
        while (i < i2) {
            if (str2.indexOf(str.charAt(i)) != -1) {
                return i;
            }
            i++;
        }
        return i2;
    }

    public static int d(String str, int i, int i2, char c2) {
        while (i < i2) {
            if (str.charAt(i) == c2) {
                return i;
            }
            i++;
        }
        return i2;
    }

    public static String d(String str) {
        InetAddress inetAddressC;
        if (str.contains(":")) {
            if (str.startsWith("[") && str.endsWith("]")) {
                inetAddressC = c(str, 1, str.length() - 1);
            } else {
                inetAddressC = c(str, 0, str.length());
            }
            if (inetAddressC == null) {
                return null;
            }
            byte[] address = inetAddressC.getAddress();
            if (address.length == 16) {
                return d(address);
            }
            throw new AssertionError("Invalid IPv6 address: '" + str + "'");
        }
        try {
            if (!str.contains("toutiao") && !str.contains("bytedance")) {
                str = IDN.toASCII(str);
            }
            String lowerCase = str.toLowerCase(Locale.US);
            if (lowerCase.isEmpty()) {
                return null;
            }
            if (c(lowerCase)) {
                return null;
            }
            return lowerCase;
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    private static boolean c(String str) {
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt <= 31 || cCharAt >= 127 || " #%/:?@[\\]".indexOf(cCharAt) != -1) {
                return true;
            }
        }
        return false;
    }

    public static int hc(String str) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt <= 31 || cCharAt >= 127) {
                return i;
            }
        }
        return -1;
    }

    public static boolean b(String str) {
        return yo.matcher(str).matches();
    }

    public static String d(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    public static Charset d(u uVar, Charset charset) throws IOException {
        if (uVar.d(0L, tt)) {
            uVar.gb(r0.h());
            return u;
        }
        if (uVar.d(0L, tc)) {
            uVar.gb(r0.h());
            return k;
        }
        if (uVar.d(0L, mk)) {
            uVar.gb(r0.h());
            return e;
        }
        if (uVar.d(0L, mq)) {
            uVar.gb(r0.h());
            return cb;
        }
        if (!uVar.d(0L, uo)) {
            return charset;
        }
        uVar.gb(r0.h());
        return w;
    }

    public static int d(String str, long j, TimeUnit timeUnit) {
        if (j < 0) {
            throw new IllegalArgumentException(str + " < 0");
        }
        if (timeUnit == null) {
            throw new NullPointerException("unit == null");
        }
        long millis = timeUnit.toMillis(j);
        if (millis > 2147483647L) {
            throw new IllegalArgumentException(str + " too large.");
        }
        if (millis != 0 || j <= 0) {
            return (int) millis;
        }
        throw new IllegalArgumentException(str + " too small.");
    }

    public static AssertionError d(String str, Exception exc) {
        return (AssertionError) new AssertionError(str).initCause(exc);
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x0079, code lost:
    
        if (r4 == 16) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x007b, code lost:
    
        if (r5 != (-1)) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x007d, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x007e, code lost:
    
        r11 = r4 - r5;
        java.lang.System.arraycopy(r1, r5, r1, 16 - r11, r11);
        java.util.Arrays.fill(r1, r5, (16 - r4) + r5, (byte) 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x008e, code lost:
    
        return java.net.InetAddress.getByAddress(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0094, code lost:
    
        throw new java.lang.AssertionError();
     */
    /* JADX WARN: Removed duplicated region for block: B:31:0x004f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.net.InetAddress c(java.lang.String r11, int r12, int r13) {
        /*
            r0 = 16
            byte[] r1 = new byte[r0]
            r2 = -1
            r3 = 0
            r5 = r2
            r6 = r5
            r4 = r3
        L9:
            r7 = 0
            if (r12 >= r13) goto L79
            if (r4 != r0) goto Lf
            return r7
        Lf:
            int r8 = r12 + 2
            if (r8 > r13) goto L27
            java.lang.String r9 = "::"
            r10 = 2
            boolean r9 = r11.regionMatches(r12, r9, r3, r10)
            if (r9 == 0) goto L27
            if (r5 == r2) goto L1f
            return r7
        L1f:
            int r4 = r4 + 2
            r5 = r4
            if (r8 != r13) goto L25
            goto L79
        L25:
            r6 = r8
            goto L4b
        L27:
            if (r4 == 0) goto L4a
            java.lang.String r8 = ":"
            r9 = 1
            boolean r8 = r11.regionMatches(r12, r8, r3, r9)
            if (r8 == 0) goto L35
            int r12 = r12 + 1
            goto L4a
        L35:
            java.lang.String r8 = "."
            boolean r12 = r11.regionMatches(r12, r8, r3, r9)
            if (r12 == 0) goto L49
            int r12 = r4 + (-2)
            boolean r11 = d(r11, r6, r13, r1, r12)
            if (r11 != 0) goto L46
            return r7
        L46:
            int r4 = r4 + 2
            goto L79
        L49:
            return r7
        L4a:
            r6 = r12
        L4b:
            r8 = r3
            r12 = r6
        L4d:
            if (r12 >= r13) goto L5f
            char r9 = r11.charAt(r12)
            int r9 = d(r9)
            if (r9 == r2) goto L5f
            int r8 = r8 << 4
            int r8 = r8 + r9
            int r12 = r12 + 1
            goto L4d
        L5f:
            int r9 = r12 - r6
            if (r9 == 0) goto L78
            r10 = 4
            if (r9 <= r10) goto L67
            goto L78
        L67:
            int r7 = r4 + 1
            int r9 = r8 >>> 8
            r9 = r9 & 255(0xff, float:3.57E-43)
            byte r9 = (byte) r9
            r1[r4] = r9
            int r4 = r7 + 1
            r8 = r8 & 255(0xff, float:3.57E-43)
            byte r8 = (byte) r8
            r1[r7] = r8
            goto L9
        L78:
            return r7
        L79:
            if (r4 == r0) goto L8a
            if (r5 != r2) goto L7e
            return r7
        L7e:
            int r11 = r4 - r5
            int r12 = 16 - r11
            java.lang.System.arraycopy(r1, r5, r1, r12, r11)
            int r0 = r0 - r4
            int r0 = r0 + r5
            java.util.Arrays.fill(r1, r5, r0, r3)
        L8a:
            java.net.InetAddress r11 = java.net.InetAddress.getByAddress(r1)     // Catch: java.net.UnknownHostException -> L8f
            return r11
        L8f:
            java.lang.AssertionError r11 = new java.lang.AssertionError
            r11.<init>()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.b.hc.d.b.c(java.lang.String, int, int):java.net.InetAddress");
    }

    private static boolean d(String str, int i, int i2, byte[] bArr, int i3) {
        int i4 = i3;
        while (i < i2) {
            if (i4 == bArr.length) {
                return false;
            }
            if (i4 != i3) {
                if (str.charAt(i) != '.') {
                    return false;
                }
                i++;
            }
            int i5 = i;
            int i6 = 0;
            while (i5 < i2) {
                char cCharAt = str.charAt(i5);
                if (cCharAt < '0' || cCharAt > '9') {
                    break;
                }
                if ((i6 == 0 && i != i5) || (i6 = ((i6 * 10) + cCharAt) - 48) > 255) {
                    return false;
                }
                i5++;
            }
            if (i5 - i == 0) {
                return false;
            }
            bArr[i4] = (byte) i6;
            i4++;
            i = i5;
        }
        return i4 == i3 + 4;
    }

    private static String d(byte[] bArr) {
        int i = 0;
        int i2 = -1;
        int i3 = 0;
        int i4 = 0;
        while (i3 < bArr.length) {
            int i5 = i3;
            while (i5 < 16 && bArr[i5] == 0 && bArr[i5 + 1] == 0) {
                i5 += 2;
            }
            int i6 = i5 - i3;
            if (i6 > i4 && i6 >= 4) {
                i2 = i3;
                i4 = i6;
            }
            i3 = i5 + 2;
        }
        com.bytedance.sdk.component.b.d.b bVar = new com.bytedance.sdk.component.b.d.b();
        while (i < bArr.length) {
            if (i == i2) {
                bVar.tt(58);
                i += i4;
                if (i == 16) {
                    bVar.tt(58);
                }
            } else {
                if (i > 0) {
                    bVar.tt(58);
                }
                bVar.mk(((bArr[i] & 255) << 8) | (bArr[i + 1] & 255));
                i += 2;
            }
        }
        return bVar.e();
    }
}
