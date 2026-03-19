package com.bytedance.msdk.d;

import android.text.TextUtils;
import com.baidu.mobstat.forbes.Config;
import com.bytedance.msdk.core.hc;
import com.bytedance.msdk.gb.np;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public abstract class d {
    public static String d(String str, String str2, String str3) {
        return TextUtils.isEmpty(str3) ? str2 : (TextUtils.equals(str, "gdt") || TextUtils.equals(str, "pangle")) ? str2 + Config.replace + str3 : str2;
    }

    public static String d(String str, String str2) {
        String[] strArrSplit;
        if (TextUtils.isEmpty(str2)) {
            return "";
        }
        if (TextUtils.equals(str, "pangle")) {
            String[] strArrSplit2 = str2.split("message:");
            if (strArrSplit2 != null && strArrSplit2.length > 0) {
                String str3 = strArrSplit2[0];
                if (!TextUtils.isEmpty(str3) && (strArrSplit = str3.trim().split(":")) != null && strArrSplit.length >= 2) {
                    String str4 = strArrSplit[1];
                    if (!TextUtils.isEmpty(str4)) {
                        return str4.trim();
                    }
                }
            }
            return "";
        }
        ArrayList arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder();
        char[] charArray = str2.toCharArray();
        int i = 0;
        while (true) {
            if (i >= charArray.length) {
                break;
            }
            char c = charArray[i];
            if (c >= '0' && c <= '9') {
                sb.append(c);
                if (i == charArray.length - 1) {
                    arrayList.add(sb.toString());
                    break;
                }
            } else if (sb.length() > 0) {
                arrayList.add(sb.toString());
                sb.delete(0, sb.length());
            }
            if (arrayList.size() > 0) {
                return (String) arrayList.get(0);
            }
            i++;
        }
        StringBuilder sb2 = new StringBuilder();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            sb2.append((String) it.next());
            sb2.append(Config.replace);
        }
        if (sb2.length() > 0) {
            sb2.delete(sb2.length() - 1, sb2.length());
        }
        return sb2.toString();
    }

    public static boolean d() {
        boolean zB = np.b(hc.getContext());
        boolean zHc = np.hc(hc.getContext());
        if (hc.hc().mq()) {
            return zB || zHc;
        }
        return false;
    }
}
