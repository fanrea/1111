package io.netty.util;

import io.netty.util.internal.StringUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.StringTokenizer;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class NetUtil {
    private static final int IPV4_BYTE_COUNT = 4;
    private static final int IPV4_MAX_CHAR_BETWEEN_SEPARATOR = 3;
    private static final int IPV4_SEPARATORS = 3;
    private static final int IPV6_BYTE_COUNT = 16;
    private static final int IPV6_MAX_CHAR_BETWEEN_SEPARATOR = 4;
    private static final int IPV6_MAX_CHAR_COUNT = 39;
    private static final int IPV6_MAX_SEPARATORS = 8;
    private static final int IPV6_MIN_SEPARATORS = 2;
    private static final int IPV6_WORD_COUNT = 8;
    public static final InetAddress LOCALHOST;
    public static final Inet4Address LOCALHOST4;
    public static final Inet6Address LOCALHOST6;
    public static final NetworkInterface LOOPBACK_IF;
    public static final int SOMAXCONN;
    private static final boolean IPV4_PREFERRED = Boolean.getBoolean("java.net.preferIPv4Stack");
    private static final InternalLogger logger = InternalLoggerFactory.getInstance((Class<?>) NetUtil.class);

    private static boolean inRangeEndExclusive(int i, int i2, int i3) {
        return i >= i2 && i < i3;
    }

    private static boolean isValidHexChar(char c) {
        if (c >= '0' && c <= '9') {
            return true;
        }
        if (c < 'A' || c > 'F') {
            return c >= 'a' && c <= 'f';
        }
        return true;
    }

    private static boolean isValidNumericChar(char c) {
        return c >= '0' && c <= '9';
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x00ba, code lost:
    
        r9 = r7.nextElement();
        r4 = r6;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00f1  */
    /* JADX WARN: Type inference failed for: r0v5, types: [io.netty.util.internal.logging.InternalLogger] */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4, types: [java.lang.Object, java.net.Inet6Address] */
    /* JADX WARN: Type inference failed for: r4v8, types: [java.net.InetAddress] */
    /* JADX WARN: Type inference failed for: r9v9, types: [java.net.InetAddress] */
    static {
        /*
            Method dump skipped, instructions count: 324
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.util.NetUtil.<clinit>():void");
    }

    public static boolean isIpV4StackPreferred() {
        return IPV4_PREFERRED;
    }

    public static byte[] createByteArrayFromIpAddressString(String str) {
        int i = 0;
        if (isValidIpV4Address(str)) {
            StringTokenizer stringTokenizer = new StringTokenizer(str, ".");
            byte[] bArr = new byte[4];
            while (i < 4) {
                bArr[i] = (byte) Integer.parseInt(stringTokenizer.nextToken());
                i++;
            }
            return bArr;
        }
        if (!isValidIpV6Address(str)) {
            return null;
        }
        if (str.charAt(0) == '[') {
            str = str.substring(1, str.length() - 1);
        }
        int iIndexOf = str.indexOf(37);
        if (iIndexOf >= 0) {
            str = str.substring(0, iIndexOf);
        }
        StringTokenizer stringTokenizer2 = new StringTokenizer(str, ":.", true);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        String str2 = "";
        String str3 = "";
        int size = -1;
        while (stringTokenizer2.hasMoreTokens()) {
            String strNextToken = stringTokenizer2.nextToken();
            if (":".equals(strNextToken)) {
                if (":".equals(str3)) {
                    size = arrayList.size();
                } else if (!str3.isEmpty()) {
                    arrayList.add(str3);
                }
            } else if (".".equals(strNextToken)) {
                arrayList2.add(str3);
            }
            String str4 = str3;
            str3 = strNextToken;
            str2 = str4;
        }
        if (":".equals(str2)) {
            if (":".equals(str3)) {
                size = arrayList.size();
            } else {
                arrayList.add(str3);
            }
        } else if (".".equals(str2)) {
            arrayList2.add(str3);
        }
        int i2 = arrayList2.isEmpty() ? 8 : 6;
        if (size != -1) {
            int size2 = i2 - arrayList.size();
            for (int i3 = 0; i3 < size2; i3++) {
                arrayList.add(size, "0");
            }
        }
        byte[] bArr2 = new byte[16];
        for (int i4 = 0; i4 < arrayList.size(); i4++) {
            convertToBytes((String) arrayList.get(i4), bArr2, i4 << 1);
        }
        while (i < arrayList2.size()) {
            bArr2[i + 12] = (byte) (Integer.parseInt((String) arrayList2.get(i)) & 255);
            i++;
        }
        return bArr2;
    }

    private static void convertToBytes(String str, byte[] bArr, int i) {
        int i2;
        int length = str.length();
        int i3 = 0;
        bArr[i] = 0;
        int i4 = i + 1;
        bArr[i4] = 0;
        if (length > 3) {
            bArr[i] = (byte) ((getIntValue(str.charAt(0)) << 4) | bArr[i]);
            i3 = 1;
        }
        if (length > 2) {
            bArr[i] = (byte) (getIntValue(str.charAt(i3)) | bArr[i]);
            i3++;
        }
        if (length > 1) {
            i2 = i3 + 1;
            bArr[i4] = (byte) ((getIntValue(str.charAt(i3)) << 4) | bArr[i4]);
        } else {
            i2 = i3;
        }
        bArr[i4] = (byte) ((getIntValue(str.charAt(i2)) & 15) | bArr[i4]);
    }

    private static int getIntValue(char c) {
        switch (c) {
            case '0':
                break;
            case '1':
                break;
            case '2':
                break;
            case '3':
                break;
            case '4':
                break;
            case '5':
                break;
            case '6':
                break;
            case '7':
                break;
            case '8':
                break;
            case '9':
                break;
            default:
                switch (Character.toLowerCase(c)) {
                }
        }
        return 0;
    }

    public static String intToIpAddress(int i) {
        StringBuilder sb = new StringBuilder(15);
        sb.append((i >> 24) & 255);
        sb.append('.');
        sb.append((i >> 16) & 255);
        sb.append('.');
        sb.append((i >> 8) & 255);
        sb.append('.');
        sb.append(i & 255);
        return sb.toString();
    }

    public static String bytesToIpAddress(byte[] bArr, int i, int i2) throws Throwable {
        if (i2 == 4) {
            StringBuilder sb = new StringBuilder(15);
            int i3 = i + 1;
            sb.append((bArr[i] >> 24) & 255);
            sb.append('.');
            int i4 = i3 + 1;
            sb.append((bArr[i3] >> 16) & 255);
            sb.append('.');
            sb.append((bArr[i4] >> 8) & 255);
            sb.append('.');
            sb.append(bArr[i4 + 1] & 255);
            return sb.toString();
        }
        if (i2 == 16) {
            StringBuilder sb2 = new StringBuilder(39);
            int i5 = i + 14;
            while (i < i5) {
                StringUtil.toHexString(sb2, bArr, i, 2);
                sb2.append(':');
                i += 2;
            }
            StringUtil.toHexString(sb2, bArr, i, 2);
            return sb2.toString();
        }
        throw new IllegalArgumentException("length: " + i2 + " (expected: 4 or 16)");
    }

    public static boolean isValidIpV6Address(String str) {
        int i;
        int i2;
        int length = str.length();
        StringBuilder sb = new StringBuilder();
        int length2 = str.length();
        if (length2 < 2) {
            return false;
        }
        if (str.charAt(0) != '[') {
            i = length2;
            i2 = 0;
        } else {
            if (str.charAt(length2 - 1) != ']') {
                return false;
            }
            i = length2 - 1;
            i2 = 1;
        }
        int iIndexOf = str.indexOf(37, i2);
        if (iIndexOf >= 0) {
            i = iIndexOf;
        }
        int i3 = i2;
        int i4 = 0;
        char c = 0;
        int i5 = 0;
        boolean z = false;
        while (i3 < i) {
            char cCharAt = str.charAt(i3);
            if (cCharAt == '.') {
                i4++;
                if (i4 > 3 || !isValidIp4Word(sb.toString())) {
                    return false;
                }
                if (i5 != 6 && !z) {
                    return false;
                }
                if (i5 == 7 && str.charAt(i2) != ':' && str.charAt(i2 + 1) != ':') {
                    return false;
                }
                sb.delete(0, sb.length());
            } else if (cCharAt == ':') {
                if ((i3 == i2 && (str.length() <= i3 || str.charAt(i3 + 1) != ':')) || (i5 = i5 + 1) > 7 || i4 > 0) {
                    return false;
                }
                if (c == ':') {
                    if (z) {
                        return false;
                    }
                    z = true;
                }
                sb.delete(0, sb.length());
            } else {
                if (sb.length() > 3 || !isValidHexChar(cCharAt)) {
                    return false;
                }
                sb.append(cCharAt);
            }
            i3++;
            c = cCharAt;
        }
        if (i4 > 0) {
            return i4 == 3 && isValidIp4Word(sb.toString()) && i5 < 7;
        }
        if (i5 == 7 || z) {
            return (sb.length() == 0 && str.charAt((length + (-1)) - i2) == ':' && str.charAt((length - 2) - i2) != ':') ? false : true;
        }
        return false;
    }

    private static boolean isValidIp4Word(String str) {
        if (str.length() > 0 && str.length() <= 3) {
            for (int i = 0; i < str.length(); i++) {
                char cCharAt = str.charAt(i);
                if (cCharAt < '0' || cCharAt > '9') {
                    return false;
                }
            }
            if (Integer.parseInt(str) <= 255) {
                return true;
            }
        }
        return false;
    }

    public static boolean isValidIpV4Address(String str) {
        int length = str.length();
        if (length > 15) {
            return false;
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = str.charAt(i2);
            if (cCharAt == '.') {
                i++;
                if (i > 3 || sb.length() == 0 || Integer.parseInt(sb.toString()) > 255) {
                    return false;
                }
                sb.delete(0, sb.length());
            } else {
                if (!Character.isDigit(cCharAt) || sb.length() > 2) {
                    return false;
                }
                sb.append(cCharAt);
            }
        }
        return sb.length() != 0 && Integer.parseInt(sb.toString()) <= 255 && i == 3;
    }

    public static Inet6Address getByName(CharSequence charSequence) {
        return getByName(charSequence, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:123:0x018b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.net.Inet6Address getByName(java.lang.CharSequence r17, boolean r18) {
        /*
            Method dump skipped, instructions count: 714
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.util.NetUtil.getByName(java.lang.CharSequence, boolean):java.net.Inet6Address");
    }

    public static String toAddressString(InetAddress inetAddress) {
        return toAddressString(inetAddress, false);
    }

    public static String toAddressString(InetAddress inetAddress, boolean z) {
        int i;
        int i2;
        if (inetAddress instanceof Inet4Address) {
            return inetAddress.getHostAddress();
        }
        if (!(inetAddress instanceof Inet6Address)) {
            throw new IllegalArgumentException("Unhandled type: " + inetAddress.getClass());
        }
        byte[] address = inetAddress.getAddress();
        int[] iArr = new int[8];
        boolean z2 = false;
        int i3 = 0;
        while (true) {
            i = 1;
            if (i3 >= 8) {
                break;
            }
            int i4 = i3 << 1;
            iArr[i3] = (address[i4 + 1] & 255) | ((address[i4] & 255) << 8);
            i3++;
        }
        int i5 = -1;
        int i6 = 0;
        int i7 = -1;
        int i8 = 0;
        int i9 = -1;
        while (i6 < 8) {
            if (iArr[i6] == 0) {
                if (i7 < 0) {
                    i7 = i6;
                }
            } else if (i7 >= 0) {
                int i10 = i6 - i7;
                if (i10 > i8) {
                    i8 = i10;
                } else {
                    i7 = i9;
                }
                i9 = i7;
                i7 = -1;
            }
            i6++;
        }
        if (i7 < 0 || (i2 = i6 - i7) <= i8) {
            i2 = i8;
            i7 = i9;
        }
        if (i2 == 1) {
            i2 = 0;
        } else {
            i5 = i7;
        }
        int i11 = i2 + i5;
        StringBuilder sb = new StringBuilder(39);
        if (i11 < 0) {
            sb.append(Integer.toHexString(iArr[0]));
            while (i < 8) {
                sb.append(':');
                sb.append(Integer.toHexString(iArr[i]));
                i++;
            }
        } else {
            if (inRangeEndExclusive(0, i5, i11)) {
                sb.append("::");
                if (z && i11 == 5 && iArr[5] == 65535) {
                    z2 = true;
                }
            } else {
                sb.append(Integer.toHexString(iArr[0]));
            }
            while (i < 8) {
                if (!inRangeEndExclusive(i, i5, i11)) {
                    if (!inRangeEndExclusive(i - 1, i5, i11)) {
                        if (!z2 || i == 6) {
                            sb.append(':');
                        } else {
                            sb.append('.');
                        }
                    }
                    if (z2 && i > 5) {
                        sb.append(iArr[i] >> 8);
                        sb.append('.');
                        sb.append(iArr[i] & 255);
                    } else {
                        sb.append(Integer.toHexString(iArr[i]));
                    }
                } else if (!inRangeEndExclusive(i - 1, i5, i11)) {
                    sb.append("::");
                }
                i++;
            }
        }
        return sb.toString();
    }

    private NetUtil() {
    }
}
