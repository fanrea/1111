package io.netty.util.internal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Formatter;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class StringUtil {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final char CARRIAGE_RETURN = '\r';
    public static final char COMMA = ',';
    private static final int CSV_NUMBER_ESCAPE_CHARACTERS = 7;
    public static final char DOUBLE_QUOTE = '\"';
    public static final String EMPTY_STRING = "";
    public static final char LINE_FEED = '\n';
    public static final String NEWLINE;
    private static final char PACKAGE_SEPARATOR_CHAR = '.';
    public static final char TAB = '\t';
    private static final String[] BYTE2HEX_PAD = new String[256];
    private static final String[] BYTE2HEX_NOPAD = new String[256];

    private static boolean isDoubleQuote(char c) {
        return c == '\"';
    }

    public static boolean isSurrogate(char c) {
        return c >= 55296 && c <= 57343;
    }

    static {
        String string;
        Formatter formatter = new Formatter();
        int i = 0;
        try {
            string = formatter.format("%n", new Object[0]).toString();
            formatter.close();
        } catch (Exception unused) {
            formatter.close();
            string = "\n";
        } catch (Throwable th) {
            formatter.close();
            throw th;
        }
        NEWLINE = string;
        while (i < 10) {
            StringBuilder sb = new StringBuilder(2);
            sb.append('0');
            sb.append(i);
            BYTE2HEX_PAD[i] = sb.toString();
            BYTE2HEX_NOPAD[i] = String.valueOf(i);
            i++;
        }
        while (i < 16) {
            StringBuilder sb2 = new StringBuilder(2);
            char c = (char) ((i + 97) - 10);
            sb2.append('0');
            sb2.append(c);
            BYTE2HEX_PAD[i] = sb2.toString();
            BYTE2HEX_NOPAD[i] = String.valueOf(c);
            i++;
        }
        while (i < BYTE2HEX_PAD.length) {
            StringBuilder sb3 = new StringBuilder(2);
            sb3.append(Integer.toHexString(i));
            String string2 = sb3.toString();
            BYTE2HEX_PAD[i] = string2;
            BYTE2HEX_NOPAD[i] = string2;
            i++;
        }
    }

    public static String[] split(String str, char c) {
        int length = str.length();
        ArrayList arrayList = new ArrayList();
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            if (str.charAt(i2) == c) {
                if (i == i2) {
                    arrayList.add("");
                } else {
                    arrayList.add(str.substring(i, i2));
                }
                i = i2 + 1;
            }
        }
        if (i == 0) {
            arrayList.add(str);
        } else if (i != length) {
            arrayList.add(str.substring(i, length));
        } else {
            for (int size = arrayList.size() - 1; size >= 0 && ((String) arrayList.get(size)).isEmpty(); size--) {
                arrayList.remove(size);
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static String[] split(String str, char c, int i) {
        int length = str.length();
        ArrayList arrayList = new ArrayList();
        int i2 = 1;
        int i3 = 0;
        for (int i4 = 0; i4 < length && i2 < i; i4++) {
            if (str.charAt(i4) == c) {
                if (i3 == i4) {
                    arrayList.add("");
                } else {
                    arrayList.add(str.substring(i3, i4));
                }
                i3 = i4 + 1;
                i2++;
            }
        }
        if (i3 == 0) {
            arrayList.add(str);
        } else if (i3 != length) {
            arrayList.add(str.substring(i3, length));
        } else {
            for (int size = arrayList.size() - 1; size >= 0 && ((String) arrayList.get(size)).isEmpty(); size--) {
                arrayList.remove(size);
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static String substringAfter(String str, char c) {
        int iIndexOf = str.indexOf(c);
        if (iIndexOf >= 0) {
            return str.substring(iIndexOf + 1);
        }
        return null;
    }

    public static boolean commonSuffixOfLength(String str, String str2, int i) {
        return str != null && str2 != null && i >= 0 && str.regionMatches(str.length() - i, str2, str2.length() - i, i);
    }

    public static String byteToHexStringPadded(int i) {
        return BYTE2HEX_PAD[i & 255];
    }

    public static <T extends Appendable> T byteToHexStringPadded(T t, int i) throws Throwable {
        try {
            t.append(byteToHexStringPadded(i));
        } catch (IOException e) {
            PlatformDependent.throwException(e);
        }
        return t;
    }

    public static String toHexStringPadded(byte[] bArr) {
        return toHexStringPadded(bArr, 0, bArr.length);
    }

    public static String toHexStringPadded(byte[] bArr, int i, int i2) {
        return ((StringBuilder) toHexStringPadded(new StringBuilder(i2 << 1), bArr, i, i2)).toString();
    }

    public static <T extends Appendable> T toHexStringPadded(T t, byte[] bArr) {
        return (T) toHexStringPadded(t, bArr, 0, bArr.length);
    }

    public static <T extends Appendable> T toHexStringPadded(T t, byte[] bArr, int i, int i2) throws Throwable {
        int i3 = i2 + i;
        while (i < i3) {
            byteToHexStringPadded(t, bArr[i]);
            i++;
        }
        return t;
    }

    public static String byteToHexString(int i) {
        return BYTE2HEX_NOPAD[i & 255];
    }

    public static <T extends Appendable> T byteToHexString(T t, int i) throws Throwable {
        try {
            t.append(byteToHexString(i));
        } catch (IOException e) {
            PlatformDependent.throwException(e);
        }
        return t;
    }

    public static String toHexString(byte[] bArr) {
        return toHexString(bArr, 0, bArr.length);
    }

    public static String toHexString(byte[] bArr, int i, int i2) {
        return ((StringBuilder) toHexString(new StringBuilder(i2 << 1), bArr, i, i2)).toString();
    }

    public static <T extends Appendable> T toHexString(T t, byte[] bArr) {
        return (T) toHexString(t, bArr, 0, bArr.length);
    }

    public static <T extends Appendable> T toHexString(T t, byte[] bArr, int i, int i2) throws Throwable {
        if (i2 == 0) {
            return t;
        }
        int i3 = i2 + i;
        int i4 = i3 - 1;
        while (i < i4 && bArr[i] == 0) {
            i++;
        }
        int i5 = i + 1;
        byteToHexString(t, bArr[i]);
        toHexStringPadded(t, bArr, i5, i3 - i5);
        return t;
    }

    public static String simpleClassName(Object obj) {
        return obj == null ? "null_object" : simpleClassName(obj.getClass());
    }

    public static String simpleClassName(Class<?> cls) {
        String name = ((Class) ObjectUtil.checkNotNull(cls, "clazz")).getName();
        int iLastIndexOf = name.lastIndexOf(46);
        return iLastIndexOf >= 0 ? name.substring(iLastIndexOf + 1) : name;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0078  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.CharSequence escapeCsv(java.lang.CharSequence r13) {
        /*
            java.lang.String r0 = "value"
            java.lang.Object r0 = io.netty.util.internal.ObjectUtil.checkNotNull(r13, r0)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            int r0 = r0.length()
            if (r0 != 0) goto Lf
            return r13
        Lf:
            int r1 = r0 + (-1)
            r2 = 0
            char r3 = r13.charAt(r2)
            boolean r3 = isDoubleQuote(r3)
            r4 = 1
            if (r3 == 0) goto L2b
            char r3 = r13.charAt(r1)
            boolean r3 = isDoubleQuote(r3)
            if (r3 == 0) goto L2b
            if (r0 == r4) goto L2b
            r3 = 1
            goto L2c
        L2b:
            r3 = 0
        L2c:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            int r6 = r0 + 7
            r5.<init>(r6)
            r6 = 34
            r5.append(r6)
            r7 = 0
            r8 = 0
        L3a:
            if (r2 >= r0) goto L7f
            char r9 = r13.charAt(r2)
            r10 = 10
            if (r9 == r10) goto L78
            r10 = 13
            if (r9 == r10) goto L78
            if (r9 == r6) goto L4f
            r10 = 44
            if (r9 == r10) goto L78
            goto L79
        L4f:
            if (r2 == 0) goto L73
            if (r2 != r1) goto L54
            goto L73
        L54:
            int r10 = r2 + 1
            char r11 = r13.charAt(r10)
            boolean r11 = isDoubleQuote(r11)
            int r12 = r2 + (-1)
            char r12 = r13.charAt(r12)
            boolean r12 = isDoubleQuote(r12)
            if (r12 != 0) goto L79
            if (r11 == 0) goto L6e
            if (r10 != r1) goto L79
        L6e:
            r5.append(r6)
            r7 = 1
            goto L79
        L73:
            if (r3 != 0) goto L7c
            r5.append(r6)
        L78:
            r8 = 1
        L79:
            r5.append(r9)
        L7c:
            int r2 = r2 + 1
            goto L3a
        L7f:
            if (r7 != 0) goto L87
            if (r8 == 0) goto L86
            if (r3 != 0) goto L86
            goto L87
        L86:
            return r13
        L87:
            r5.append(r6)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.util.internal.StringUtil.escapeCsv(java.lang.CharSequence):java.lang.CharSequence");
    }

    public static int length(String str) {
        if (str == null) {
            return 0;
        }
        return str.length();
    }

    public static boolean isNullOrEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private StringUtil() {
    }
}
