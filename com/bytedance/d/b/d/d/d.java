package com.bytedance.d.b.d.d;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.alipay.sdk.m.s.a;
import com.baidu.mobads.upgrade.remote.gray.c;
import com.bytedance.embedapplog.util.TTEncryptUtils;
import com.bytedance.sdk.component.utils.mq;
import com.fendasz.moku.planet.utils.thirdparty.codec.CharEncoding;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class d {
    private static InterfaceC0186d d = null;
    private static boolean hc = false;

    /* renamed from: com.bytedance.d.b.d.d.d$d, reason: collision with other inner class name */
    public interface InterfaceC0186d {
        boolean b();

        boolean d();

        boolean hc();
    }

    public static String d(String str, List<Pair<String, String>> list) {
        if (TextUtils.isEmpty(str) || d == null || hc) {
            return str;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        try {
            Uri uri = Uri.parse(str);
            d(uri, linkedHashMap);
            LinkedList linkedList = new LinkedList();
            d(linkedHashMap, linkedList, c.l);
            d(linkedHashMap, linkedList, "device_type");
            d(linkedHashMap, linkedList, "device_brand");
            d(linkedHashMap, linkedList, "uuid");
            d(linkedHashMap, linkedList, "openudid");
            String strD = d((List<Pair<String, List<String>>>) linkedList, false, "UTF-8");
            if (TextUtils.isEmpty(strD)) {
                return str;
            }
            byte[] bytes = strD.getBytes();
            byte[] bArrA = TTEncryptUtils.a(bytes, bytes.length);
            if (bArrA == null) {
                return str;
            }
            String strEncodeToString = Base64.encodeToString(bArrA, 2);
            LinkedList linkedList2 = new LinkedList();
            if (d.d()) {
                LinkedList linkedList3 = new LinkedList();
                linkedList3.add(strEncodeToString);
                linkedList2.add(new Pair("ss_queries", linkedList3));
            }
            if (d.hc() && list != null) {
                list.add(new Pair<>("X-SS-QUERIES", d(strEncodeToString, "UTF-8")));
            }
            if (!linkedHashMap.isEmpty()) {
                for (Map.Entry entry : linkedHashMap.entrySet()) {
                    if (entry != null) {
                        linkedList2.add(new Pair(entry.getKey(), entry.getValue()));
                    }
                }
            }
            return d(uri.getScheme(), uri.getHost(), uri.getPort(), uri.getPath(), d((List<Pair<String, List<String>>>) linkedList2, true, "UTF-8"), uri.getFragment()).toString();
        } catch (Throwable th) {
            mq.d(th);
            return str;
        }
    }

    private static boolean d(Map<String, List<String>> map, List<Pair<String, List<String>>> list, String str) throws UnsupportedEncodingException {
        if (TextUtils.isEmpty(str) || list == null || !map.containsKey(str)) {
            return false;
        }
        list.add(new Pair<>(str, map.get(str)));
        if (d.b()) {
            return true;
        }
        map.remove(str);
        return true;
    }

    public static void d(Uri uri, Map<String, List<String>> map) throws IOException {
        if (uri == null) {
            throw new IOException("parseUrl url is null !!!");
        }
        if (map != null) {
            try {
                String query = uri.getQuery();
                if (query != null) {
                    for (String str : query.split(a.n)) {
                        int iIndexOf = str.indexOf("=");
                        if (iIndexOf >= 0) {
                            String strDecode = URLDecoder.decode(str.substring(0, iIndexOf), "UTF-8");
                            List<String> linkedList = map.get(strDecode);
                            if (linkedList == null) {
                                linkedList = new LinkedList<>();
                            }
                            linkedList.add(URLDecoder.decode(str.substring(iIndexOf + 1), "UTF-8"));
                            map.put(strDecode, linkedList);
                        } else {
                            String strDecode2 = URLDecoder.decode(str, "UTF-8");
                            List<String> linkedList2 = map.get(strDecode2);
                            if (linkedList2 == null) {
                                linkedList2 = new LinkedList<>();
                            }
                            linkedList2.add("");
                            map.put(strDecode2, linkedList2);
                        }
                    }
                }
            } catch (Throwable th) {
                mq.d(th);
                throw new IOException("parseUrl url is null !!!");
            }
        }
    }

    private static Uri d(String str, String str2, int i, String str3, String str4, String str5) {
        StringBuilder sb = new StringBuilder();
        if (str2 != null) {
            if (str != null) {
                sb.append(str);
                sb.append("://");
            }
            sb.append(str2);
            if (i > 0) {
                sb.append(':');
                sb.append(i);
            }
        }
        if (str3 == null || !str3.startsWith("/")) {
            sb.append('/');
        }
        if (str3 != null) {
            sb.append(str3);
        }
        if (str4 != null) {
            sb.append('?');
            sb.append(str4);
        }
        if (str5 != null) {
            sb.append('#');
            sb.append(str5);
        }
        return Uri.parse(sb.toString());
    }

    private static String d(List<Pair<String, List<String>>> list, boolean z, String str) {
        StringBuilder sb = new StringBuilder();
        for (Pair<String, List<String>> pair : list) {
            String strD = (String) pair.first;
            if (z) {
                strD = d((String) pair.first, str);
            }
            List<String> list2 = (List) pair.second;
            if (list2 != null && list2.size() > 0) {
                for (String strD2 : list2) {
                    if (z) {
                        strD2 = strD2 != null ? d(strD2, str) : "";
                    }
                    if (sb.length() > 0) {
                        sb.append(a.n);
                    }
                    sb.append(strD);
                    sb.append("=");
                    sb.append(strD2);
                }
            }
        }
        return sb.toString();
    }

    private static String d(String str, String str2) {
        if (str2 == null) {
            str2 = CharEncoding.ISO_8859_1;
        }
        try {
            return URLEncoder.encode(str, str2);
        } catch (UnsupportedEncodingException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
