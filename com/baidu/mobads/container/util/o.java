package com.baidu.mobads.container.util;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.just.agentweb.DefaultWebClient;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class o {
    public static HashMap<String, String> a(String str) {
        HashMap<String, String> map = new HashMap<>();
        Uri uri = Uri.parse(str);
        for (String str2 : a(uri)) {
            if (str2 != null && str2.length() > 0) {
                map.put(str2, uri.getQueryParameter(str2));
            }
        }
        return map;
    }

    public static Set<String> a(Uri uri) {
        try {
            if (x.a(null).a() >= 11) {
                return uri.getQueryParameterNames();
            }
            String encodedQuery = uri.getEncodedQuery();
            if (encodedQuery == null) {
                return Collections.emptySet();
            }
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            int i = 0;
            do {
                int iIndexOf = encodedQuery.indexOf(38, i);
                if (iIndexOf == -1) {
                    iIndexOf = encodedQuery.length();
                }
                int iIndexOf2 = encodedQuery.indexOf(61, i);
                if (iIndexOf2 > iIndexOf || iIndexOf2 == -1) {
                    iIndexOf2 = iIndexOf;
                }
                linkedHashSet.add(Uri.decode(encodedQuery.substring(i, iIndexOf2)));
                i = iIndexOf + 1;
            } while (i < encodedQuery.length());
            return Collections.unmodifiableSet(linkedHashSet);
        } catch (Exception e) {
            return new HashSet();
        }
    }

    public static String a(String str, HashMap<String, String> map) {
        String str2;
        StringBuilder sb = new StringBuilder();
        if (map != null) {
            int i = 0;
            for (String str3 : map.keySet()) {
                i++;
                String str4 = map.get(str3) + "";
                if (i == 1) {
                    sb.append(str3).append("=").append(str4);
                } else {
                    sb.append(com.alipay.sdk.m.s.a.n).append(str3).append("=").append(str4);
                }
            }
        }
        if (com.baidu.mobads.container.j.c.booleanValue()) {
            if (map != null) {
                for (String str5 : map.keySet()) {
                    try {
                        String str6 = map.get(str5);
                        if (str6 != null) {
                            map.put(str5, URLEncoder.encode(str6, "UTF-8"));
                        }
                    } catch (UnsupportedEncodingException e) {
                    }
                }
            }
            str2 = b(str, map) + "&b" + System.currentTimeMillis() + "=1";
        } else {
            str2 = str + "?code2=" + u.a(sb.toString() + "&b" + System.currentTimeMillis() + "=1");
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("&b").append(System.currentTimeMillis()).append("=").append("1");
        return str2 + sb2.toString();
    }

    public static String a(HashMap<String, String> map) {
        StringBuilder sb = new StringBuilder();
        if (map != null) {
            int i = 0;
            for (String str : map.keySet()) {
                i++;
                String str2 = map.get(str);
                if (i == 1) {
                    sb.append(str).append("=").append(str2);
                } else {
                    sb.append(com.alipay.sdk.m.s.a.n).append(str).append("=").append(str2);
                }
            }
        }
        sb.append("&b").append(System.currentTimeMillis()).append("=1");
        return u.a(sb.toString());
    }

    @Deprecated
    public static String a(String str, String str2, String str3) {
        String str4;
        String strI = i(str);
        String strJ = j(str);
        if (TextUtils.isEmpty(strJ)) {
            str4 = str2 + "=" + str3;
        } else {
            str4 = strJ + com.alipay.sdk.m.s.a.n + str2 + "=" + str3;
        }
        return strI + "?" + str4;
    }

    public static String b(String str, HashMap<String, String> map) {
        StringBuilder sb = new StringBuilder(str);
        if (map == null || map.isEmpty()) {
            return sb.toString();
        }
        sb.append("?");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            try {
                sb.append(entry.getKey());
                sb.append("=");
                sb.append(entry.getValue());
                sb.append(com.alipay.sdk.m.s.a.n);
            } catch (Exception e) {
                bq.a().c(e);
            }
        }
        return sb.toString().substring(0, r2.length() - 1);
    }

    public static String b(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static Boolean c(String str) {
        return a(str, "http:");
    }

    public static Boolean d(String str) {
        return a(str, "https:");
    }

    public static String e(String str) {
        if (com.baidu.mobads.container.h.a.a().e() && c(str).booleanValue()) {
            return str.replaceFirst("(?i)http", "https");
        }
        return str;
    }

    public static Boolean f(String str) {
        return Boolean.valueOf(a(str, DefaultWebClient.SCHEME_SMS).booleanValue() || a(str, "smsto:").booleanValue() || a(str, "mms:").booleanValue());
    }

    private static Boolean a(String str, String str2) {
        boolean z = false;
        if (str != null && str.trim().toLowerCase(Locale.getDefault()).indexOf(str2) == 0) {
            z = true;
        }
        return Boolean.valueOf(z);
    }

    public static HttpURLConnection a(URL url) {
        if (url.getProtocol().toLowerCase().equals("https")) {
            return (HttpsURLConnection) url.openConnection();
        }
        return (HttpURLConnection) url.openConnection();
    }

    public static boolean g(String str) {
        if (!TextUtils.isEmpty(str) && str.contains("/thefatherofsalmon.com")) {
            return false;
        }
        return true;
    }

    public static void a(URL url, HttpURLConnection httpURLConnection) throws NoSuchAlgorithmException, KeyManagementException {
        try {
            if (url.getHost().equals("mobads.baidu.com") && url.getPath().equals("/cpro/ui/mads.php")) {
                TrustManager[] trustManagerArr = {new p(u.b("mh7GuZR8mvqV"), u.b("fhNGph-8uzKamy-bIiKrugwWUvY6RvPGuy4WuiKRuyPCUhq_UvI4cDPEQBfb"))};
                SSLContext sSLContext = SSLContext.getInstance("TLS");
                sSLContext.init(null, trustManagerArr, null);
                ((HttpsURLConnection) httpURLConnection).setSSLSocketFactory(sSLContext.getSocketFactory());
            }
        } catch (Exception e) {
        }
    }

    public static void b(URL url, HttpURLConnection httpURLConnection) {
        try {
            if (url.getHost().equals("mobads.baidu.com") && url.getPath().equals("/cpro/ui/mads.php")) {
                ((HttpsURLConnection) httpURLConnection).setHostnameVerifier(new q());
            }
        } catch (Exception e) {
        }
    }

    public static String h(String str) {
        if (!TextUtils.isEmpty(str)) {
            String lowerCase = str.trim().toLowerCase();
            if (lowerCase.startsWith("http:")) {
                return str.replaceFirst("(?i)http:", "");
            }
            if (lowerCase.startsWith("https:")) {
                return str.replaceFirst("(?i)http:", "");
            }
        }
        return str;
    }

    public static String i(String str) {
        if (str == null) {
            return null;
        }
        return (c(str).booleanValue() || d(str).booleanValue()) ? str.split("\\?")[0] : str;
    }

    public static String j(String str) {
        String[] strArrSplit;
        if (str == null) {
            return null;
        }
        if (!c(str).booleanValue() && !d(str).booleanValue()) {
            strArrSplit = null;
        } else {
            strArrSplit = str.split("\\?");
        }
        if (strArrSplit == null || strArrSplit.length < 2) {
            return null;
        }
        return strArrSplit[1];
    }

    public static String k(String str) {
        try {
            return Uri.encode(str);
        } catch (Exception e) {
            return str;
        }
    }

    public static String l(String str) {
        if (str == null) {
            return null;
        }
        try {
            return URLDecoder.decode(str, "UTF-8");
        } catch (Exception e) {
            return str;
        }
    }

    public static boolean m(String str) {
        return str != null && str.length() > 0;
    }

    public static String a(String str, boolean z) {
        if (TextUtils.isEmpty(str) || !str.startsWith("//")) {
            return str;
        }
        return (z ? "https:" : "http:") + str;
    }

    public static String n(String str) {
        try {
            String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(str);
            if (!TextUtils.isEmpty(fileExtensionFromUrl)) {
                return MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtensionFromUrl);
            }
            return "text/html";
        } catch (Throwable th) {
            com.baidu.mobads.container.l.g.b(th);
            return "text/html";
        }
    }
}
