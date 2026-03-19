package com.bykv.vk.openvk.component.video.d.hc;

import android.net.Uri;
import android.text.TextUtils;
import com.alipay.sdk.m.s.a;
import com.kuaishou.weapon.p0.t;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class tt {
    public final d b;
    public final b d;
    public final List<hc> hc;

    public tt(b bVar, List<hc> list, d dVar) {
        this.d = bVar;
        this.hc = list;
        this.b = dVar;
    }

    public static tt d(InputStream inputStream) throws c, IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, com.bykv.vk.openvk.component.video.d.b.d.d));
        ArrayList arrayList = new ArrayList();
        b bVarD = null;
        while (true) {
            String line = bufferedReader.readLine();
            if (TextUtils.isEmpty(line)) {
                break;
            }
            String strTrim = line.trim();
            if (bVarD == null) {
                bVarD = b.d(strTrim);
            } else {
                arrayList.add(hc.d(strTrim));
            }
        }
        if (bVarD == null) {
            throw new c("request line is null");
        }
        return new tt(bVarD, arrayList, d.d(bVarD, arrayList));
    }

    static final class b {
        final String b;
        final String d;
        final String hc;

        private b(String str, String str2, String str3) {
            this.d = str;
            this.hc = str2;
            this.b = str3;
        }

        static b d(String str) throws c {
            int iIndexOf = str.indexOf(32);
            if (iIndexOf == -1) {
                throw new c("request line format error, line: ".concat(String.valueOf(str)));
            }
            int iLastIndexOf = str.lastIndexOf(32);
            if (iLastIndexOf <= iIndexOf) {
                throw new c("request line format error, line: ".concat(String.valueOf(str)));
            }
            String strTrim = str.substring(0, iIndexOf).trim();
            String strTrim2 = str.substring(iIndexOf + 1, iLastIndexOf).trim();
            String strTrim3 = str.substring(iLastIndexOf + 1).trim();
            if (strTrim.length() == 0 || strTrim2.length() == 0 || strTrim3.length() == 0) {
                throw new c("request line format error, line: ".concat(String.valueOf(str)));
            }
            return new b(strTrim, strTrim2, strTrim3);
        }

        public String toString() {
            return "RequestLine{method='" + this.d + "', path='" + this.hc + "', version='" + this.b + "'}";
        }
    }

    public static final class hc {
        public final String d;
        public final String hc;

        public hc(String str, String str2) {
            this.d = str;
            this.hc = str2;
        }

        static hc d(String str) throws c {
            int iIndexOf = str.indexOf(":");
            if (iIndexOf == -1) {
                throw new c("request header format error, header: ".concat(String.valueOf(str)));
            }
            String strTrim = str.substring(0, iIndexOf).trim();
            String strTrim2 = str.substring(iIndexOf + 1).trim();
            if (strTrim.length() == 0 || strTrim2.length() == 0) {
                throw new c("request header format error, header: ".concat(String.valueOf(str)));
            }
            return new hc(strTrim, strTrim2);
        }

        public String toString() {
            return "Header{name='" + this.d + "', value='" + this.hc + "'}";
        }
    }

    static final class d {
        final String an;
        final String b;
        final int c;
        final int d;
        final List<String> h;
        final String hc;
        final int u;

        private d(int i, String str, String str2, int i2, int i3, String str3, List<String> list) {
            this.d = i;
            this.hc = str;
            this.b = str2;
            this.c = i2;
            this.u = i3;
            this.an = str3;
            this.h = list;
        }

        static d d(b bVar, List<hc> list) throws c, NumberFormatException {
            String str;
            int i;
            int i2;
            int iIndexOf = bVar.hc.indexOf("?");
            if (iIndexOf == -1) {
                throw new c("path format error, path: " + bVar.hc);
            }
            ArrayList arrayList = new ArrayList();
            String str2 = null;
            String strDecode = null;
            String strDecode2 = null;
            int i3 = 0;
            for (String str3 : bVar.hc.substring(iIndexOf + 1).split(a.n)) {
                String[] strArrSplit = str3.split("=");
                if (strArrSplit.length == 2) {
                    if ("rk".equals(strArrSplit[0])) {
                        strDecode = Uri.decode(strArrSplit[1]);
                    } else if ("k".equals(strArrSplit[0])) {
                        strDecode2 = Uri.decode(strArrSplit[1]);
                    } else if (strArrSplit[0].startsWith(t.i)) {
                        arrayList.add(Uri.decode(strArrSplit[1]));
                    } else if ("f".equals(strArrSplit[0]) && com.bykv.vk.openvk.component.video.d.b.d.hc(strArrSplit[1]) == 1) {
                        i3 = 1;
                    }
                }
            }
            if (TextUtils.isEmpty(strDecode) || TextUtils.isEmpty(strDecode2)) {
                throw new c("rawKey or key is empty, path: " + bVar.hc);
            }
            if (list != null) {
                i2 = 0;
                int i4 = 0;
                for (hc hcVar : list) {
                    if (hcVar != null && "Range".equalsIgnoreCase(hcVar.d)) {
                        int iIndexOf2 = hcVar.hc.indexOf("=");
                        if (iIndexOf2 == -1) {
                            throw new c("Range format error, Range: " + hcVar.hc);
                        }
                        if (!"bytes".equalsIgnoreCase(hcVar.hc.substring(0, iIndexOf2).trim())) {
                            throw new c("Range format error, Range: " + hcVar.hc);
                        }
                        String strSubstring = hcVar.hc.substring(iIndexOf2 + 1);
                        if (strSubstring.contains(",")) {
                            throw new c("Range format error, Range: " + hcVar.hc);
                        }
                        int iIndexOf3 = strSubstring.indexOf("-");
                        if (iIndexOf3 == -1) {
                            throw new c("Range format error, Range: " + hcVar.hc);
                        }
                        String strTrim = strSubstring.substring(0, iIndexOf3).trim();
                        String strTrim2 = strSubstring.substring(iIndexOf3 + 1).trim();
                        try {
                            if (strTrim.length() > 0) {
                                i2 = Integer.parseInt(strTrim);
                            }
                            if (strTrim2.length() > 0 && i2 > (i4 = Integer.parseInt(strTrim2))) {
                                throw new c("Range format error, Range: " + hcVar.hc);
                            }
                            str2 = hcVar.hc;
                        } catch (NumberFormatException unused) {
                            throw new c("Range format error, Range: " + hcVar.hc);
                        }
                    }
                }
                i = i4;
                str = str2;
            } else {
                str = null;
                i = 0;
                i2 = 0;
            }
            if (arrayList.isEmpty()) {
                throw new c("no url found: path: " + bVar.hc);
            }
            return new d(i3, strDecode, strDecode2, i2, i, str, arrayList);
        }

        public String toString() {
            return "Extra{flag=" + this.d + ", rawKey='" + this.hc + "', key='" + this.b + "', from=" + this.c + ", to=" + this.u + ", urls=" + this.h + '}';
        }
    }

    static String d(String str, String str2, List<String> list) {
        StringBuilder sb = new StringBuilder(512);
        String strD = null;
        do {
            if (strD != null) {
                if (list.size() == 1) {
                    return null;
                }
                list.remove(list.size() - 1);
            }
            strD = d(sb, str, str2, list);
        } while (strD.length() > 3072);
        return strD;
    }

    private static String d(StringBuilder sb, String str, String str2, List<String> list) {
        sb.delete(0, sb.length());
        sb.append("rk=").append(Uri.encode(str));
        sb.append("&k=").append(Uri.encode(str2));
        int size = list.size();
        for (int i = 0; i < size; i++) {
            sb.append("&u").append(i).append("=").append(Uri.encode(list.get(i)));
        }
        return sb.toString();
    }

    public String toString() {
        return "Request{requestLine=" + this.d + ", headers=" + this.hc + ", extra=" + this.b + '}';
    }

    static final class c extends Exception {
        c(String str) {
            super(str);
        }
    }
}
