package com.tencent.turingfd.sdk.ams.au;

import android.text.TextUtils;
import android.util.JsonWriter;
import androidx.core.app.NotificationCompat;
import com.alipay.sdk.m.u.i;
import com.baidu.mobstat.forbes.Config;
import com.tencent.turingfd.sdk.ams.au.Olive;
import io.netty.util.internal.StringUtil;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;
import org.aspectj.runtime.reflect.SignatureImpl;

/* compiled from: A */
/* renamed from: com.tencent.turingfd.sdk.ams.au.while, reason: invalid class name */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class Cwhile {
    public static final HashSet<Character> a;
    public static final String[] b;
    public static final HashSet<String> c;

    static {
        char[] cArr = {'/', '.', SignatureImpl.SEP, '_', '@', StringUtil.COMMA, ':', '|'};
        a = new HashSet<>();
        b = new String[]{"ls", "grep", "cat", Config.DEVICE_UPTIME};
        c = new HashSet<>();
        for (int i = 0; i < 8; i++) {
            a.add(Character.valueOf(cArr[i]));
        }
        c.addAll(Arrays.asList(b));
    }

    public static String a() throws IOException {
        int i;
        String strA = Lemon.f.a("s_h");
        if (strA == null || strA.isEmpty()) {
            return "";
        }
        HashSet hashSet = new HashSet(Arrays.asList(strA.split(i.b)));
        StringWriter stringWriter = new StringWriter();
        JsonWriter jsonWriter = new JsonWriter(stringWriter);
        try {
            jsonWriter.beginObject();
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                if (!TextUtils.isEmpty(str)) {
                    StringTokenizer stringTokenizer = new StringTokenizer(str, "|");
                    while (true) {
                        if (!stringTokenizer.hasMoreTokens()) {
                            if (!TextUtils.isEmpty(str)) {
                                char[] charArray = str.toCharArray();
                                int length = charArray.length;
                                while (true) {
                                    if (i >= length) {
                                        jsonWriter.name(str);
                                        Olive.Cif cifB = Cascara.b(str);
                                        jsonWriter.beginObject();
                                        jsonWriter.name("std");
                                        jsonWriter.value(cifB.a);
                                        jsonWriter.name(NotificationCompat.CATEGORY_ERROR);
                                        jsonWriter.value(cifB.b);
                                        jsonWriter.endObject();
                                        break;
                                    }
                                    char c2 = charArray[i];
                                    i = (Character.isLetterOrDigit(c2) || Character.isSpaceChar(c2) || a.contains(Character.valueOf(c2))) ? i + 1 : 0;
                                }
                            }
                        } else {
                            String[] strArrSplit = stringTokenizer.nextToken().trim().split("\\s+", 2);
                            if (strArrSplit.length != 0 && !c.contains(strArrSplit[0])) {
                                break;
                            }
                        }
                    }
                }
            }
            jsonWriter.endObject();
            return stringWriter.toString();
        } catch (IOException unused) {
            return "";
        }
    }
}
