package com.bytedance.sdk.component.b.hc;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class yo {
    public final String[] d;

    yo(d dVar) {
        this.d = (String[]) dVar.d.toArray(new String[dVar.d.size()]);
    }

    private yo(String[] strArr) {
        this.d = strArr;
    }

    public String d(String str) {
        return d(this.d, str);
    }

    public int d() {
        return this.d.length / 2;
    }

    public String d(int i) {
        return this.d[i * 2];
    }

    public String hc(int i) {
        return this.d[(i * 2) + 1];
    }

    public List<String> hc(String str) {
        int iD = d();
        ArrayList arrayList = null;
        for (int i = 0; i < iD; i++) {
            if (str.equalsIgnoreCase(d(i))) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(hc(i));
            }
        }
        if (arrayList != null) {
            return Collections.unmodifiableList(arrayList);
        }
        return Collections.emptyList();
    }

    public d hc() {
        d dVar = new d();
        Collections.addAll(dVar.d, this.d);
        return dVar;
    }

    public boolean equals(Object obj) {
        return (obj instanceof yo) && Arrays.equals(((yo) obj).d, this.d);
    }

    public int hashCode() {
        return Arrays.hashCode(this.d);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int iD = d();
        for (int i = 0; i < iD; i++) {
            sb.append(d(i)).append(": ").append(hc(i)).append("\n");
        }
        return sb.toString();
    }

    public Map<String, List<String>> b() {
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        int iD = d();
        for (int i = 0; i < iD; i++) {
            String lowerCase = d(i).toLowerCase(Locale.US);
            List arrayList = (List) treeMap.get(lowerCase);
            if (arrayList == null) {
                arrayList = new ArrayList(2);
                treeMap.put(lowerCase, arrayList);
            }
            arrayList.add(hc(i));
        }
        return treeMap;
    }

    private static String d(String[] strArr, String str) {
        for (int length = strArr.length - 2; length >= 0; length -= 2) {
            if (str.equalsIgnoreCase(strArr[length])) {
                return strArr[length + 1];
            }
        }
        return null;
    }

    public static yo d(String... strArr) {
        if (strArr == null) {
            throw new NullPointerException("namesAndValues == null");
        }
        if (strArr.length % 2 != 0) {
            throw new IllegalArgumentException("Expected alternating header names and values");
        }
        String[] strArr2 = (String[]) strArr.clone();
        for (int i = 0; i < strArr2.length; i++) {
            String str = strArr2[i];
            if (str == null) {
                throw new IllegalArgumentException("Headers cannot be null");
            }
            strArr2[i] = str.trim();
        }
        for (int i2 = 0; i2 < strArr2.length; i2 += 2) {
            String str2 = strArr2[i2];
            String str3 = strArr2[i2 + 1];
            if (str2.length() == 0 || str2.indexOf(0) != -1 || str3.indexOf(0) != -1) {
                throw new IllegalArgumentException("Unexpected header: " + str2 + ": " + str3);
            }
        }
        return new yo(strArr2);
    }

    public static final class d {
        final List<String> d = new ArrayList(20);

        d d(String str) {
            int iIndexOf = str.indexOf(":", 1);
            if (iIndexOf != -1) {
                return hc(str.substring(0, iIndexOf), str.substring(iIndexOf + 1));
            }
            if (str.startsWith(":")) {
                return hc("", str.substring(1));
            }
            return hc("", str);
        }

        public d d(String str, String str2) {
            try {
                c(str, str2);
            } catch (Throwable unused) {
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    try {
                        StringBuilder sb = new StringBuilder();
                        int length = str2.length();
                        for (int i = 0; i < length; i++) {
                            char cCharAt = str2.charAt(i);
                            if ((cCharAt <= 31 && cCharAt != '\t') || cCharAt >= 127) {
                                sb.append(URLEncoder.encode(String.valueOf(cCharAt), "UTF-8"));
                            } else {
                                sb.append(cCharAt);
                            }
                        }
                        str2 = sb.toString();
                    } catch (UnsupportedEncodingException e) {
                        com.bytedance.sdk.component.utils.mq.d(e);
                        return this;
                    }
                }
                return this;
            }
            return hc(str, str2);
        }

        d hc(String str, String str2) {
            this.d.add(str);
            this.d.add(str2.trim());
            return this;
        }

        public d hc(String str) {
            int i = 0;
            while (i < this.d.size()) {
                if (str.equalsIgnoreCase(this.d.get(i))) {
                    this.d.remove(i);
                    this.d.remove(i);
                    i -= 2;
                }
                i += 2;
            }
            return this;
        }

        public d b(String str, String str2) {
            try {
                c(str, str2);
            } catch (Throwable unused) {
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    try {
                        StringBuilder sb = new StringBuilder();
                        int length = str2.length();
                        for (int i = 0; i < length; i++) {
                            char cCharAt = str2.charAt(i);
                            if ((cCharAt <= 31 && cCharAt != '\t') || cCharAt >= 127) {
                                sb.append(URLEncoder.encode(String.valueOf(cCharAt), "UTF-8"));
                            } else {
                                sb.append(cCharAt);
                            }
                        }
                        str2 = sb.toString();
                    } catch (UnsupportedEncodingException e) {
                        com.bytedance.sdk.component.utils.mq.d(e);
                        return this;
                    }
                }
                return this;
            }
            hc(str);
            hc(str, str2);
            return this;
        }

        private void c(String str, String str2) {
            if (str == null) {
                throw new NullPointerException("name == null");
            }
            if (str.isEmpty()) {
                throw new IllegalArgumentException("name is empty");
            }
            int length = str.length();
            for (int i = 0; i < length; i++) {
                char cCharAt = str.charAt(i);
                if (cCharAt <= ' ' || cCharAt >= 127) {
                    throw new IllegalArgumentException(com.bytedance.sdk.component.b.hc.d.b.d("Unexpected char %#04x at %d in header name: %s", Integer.valueOf(cCharAt), Integer.valueOf(i), str));
                }
            }
            if (str2 == null) {
                throw new NullPointerException("value for name " + str + " == null");
            }
            int length2 = str2.length();
            for (int i2 = 0; i2 < length2; i2++) {
                char cCharAt2 = str2.charAt(i2);
                if ((cCharAt2 <= 31 && cCharAt2 != '\t') || cCharAt2 >= 127) {
                    throw new IllegalArgumentException(com.bytedance.sdk.component.b.hc.d.b.d("Unexpected char %#04x at %d in %s value: %s", Integer.valueOf(cCharAt2), Integer.valueOf(i2), str, str2));
                }
            }
        }

        public yo d() {
            return new yo(this);
        }
    }
}
