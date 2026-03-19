package com.alliance.ssp.ad.o;

import com.alliance.ssp.ad.o0.r;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/* compiled from: RequestEncryptUtil.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class e {
    public static String[] b(String str) {
        String strEncode;
        String str2;
        String strEncode2 = "";
        if (r.b(str)) {
            try {
                strEncode = URLEncoder.encode(d.a("7600B4C005A5D4A09318E9AFFE02FE0B5487DC951E892ED1,D3579468AA6A2371"), "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e = e;
                strEncode = "";
            }
            try {
                strEncode2 = URLEncoder.encode(new b("7600B4C005A5D4A09318E9AFFE02FE0B5487DC951E892ED1", "D3579468AA6A2371").b(str), "UTF-8");
            } catch (UnsupportedEncodingException e2) {
                e = e2;
                e.printStackTrace();
                str2 = strEncode2;
                strEncode2 = strEncode;
                return new String[]{strEncode2, str2};
            }
            str2 = strEncode2;
            strEncode2 = strEncode;
        } else {
            str2 = "";
        }
        return new String[]{strEncode2, str2};
    }

    public static String a(String str) throws UnsupportedEncodingException {
        if (r.b(str)) {
            try {
                return "cipher=" + URLEncoder.encode(d.a("7600B4C005A5D4A09318E9AFFE02FE0B5487DC951E892ED1,D3579468AA6A2371"), "UTF-8") + "&encryptParams=" + URLEncoder.encode(new b("7600B4C005A5D4A09318E9AFFE02FE0B5487DC951E892ED1", "D3579468AA6A2371").b(str), "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return "";
    }

    public static String a(String str, String str2) throws UnsupportedEncodingException {
        try {
            if (r.b(str) && r.b(str2)) {
                String str3 = "7600B4C005A5D4A09318E9AFFE02FE0B5487DC951E892ED1";
                String str4 = "D3579468AA6A2371";
                String strDecode = URLDecoder.decode(str, "utf-8");
                byte[] bArr = d.a;
                byte[] bArrB = null;
                try {
                    bArrB = d.b(strDecode.getBytes("UTF-8"), a.a(""));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                String str5 = bArrB == null ? "" : new String(bArrB);
                if (!r.a(str5)) {
                    String[] strArrSplit = str5.split(",");
                    str3 = strArrSplit[0];
                    str4 = strArrSplit[1];
                }
                return new b(str3, str4).a(URLDecoder.decode(str2, "utf-8"));
            }
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        }
        return "";
    }
}
