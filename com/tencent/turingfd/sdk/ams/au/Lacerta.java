package com.tencent.turingfd.sdk.ams.au;

import android.os.Build;
import android.os.LocaleList;
import com.baidu.mobstat.forbes.Config;
import java.util.Locale;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public final class Lacerta {
    public static final Lacerta b = a(new Locale[0]);
    public final Leo a;

    public Lacerta(Leo leo) {
        this.a = leo;
    }

    public static Lacerta a(Locale... localeArr) {
        return Build.VERSION.SDK_INT >= 24 ? new Lacerta(new Lynx(new LocaleList(localeArr))) : new Lacerta(new LeoMinor(localeArr));
    }

    public static Lacerta a(String str) {
        Locale locale;
        if (str != null && !str.isEmpty()) {
            String[] strArrSplit = str.split(",", -1);
            int length = strArrSplit.length;
            Locale[] localeArr = new Locale[length];
            for (int i = 0; i < length; i++) {
                if (Build.VERSION.SDK_INT >= 21) {
                    locale = Locale.forLanguageTag(strArrSplit[i]);
                } else {
                    String str2 = strArrSplit[i];
                    if (str2.contains("-")) {
                        String[] strArrSplit2 = str2.split("-", -1);
                        if (strArrSplit2.length > 2) {
                            locale = new Locale(strArrSplit2[0], strArrSplit2[1], strArrSplit2[2]);
                        } else if (strArrSplit2.length > 1) {
                            locale = new Locale(strArrSplit2[0], strArrSplit2[1]);
                        } else if (strArrSplit2.length == 1) {
                            locale = new Locale(strArrSplit2[0]);
                        } else {
                            throw new IllegalArgumentException("Can not parse language tag: [" + str2 + "]");
                        }
                    } else if (str2.contains(Config.replace)) {
                        String[] strArrSplit3 = str2.split(Config.replace, -1);
                        if (strArrSplit3.length > 2) {
                            locale = new Locale(strArrSplit3[0], strArrSplit3[1], strArrSplit3[2]);
                        } else if (strArrSplit3.length > 1) {
                            locale = new Locale(strArrSplit3[0], strArrSplit3[1]);
                        } else if (strArrSplit3.length == 1) {
                            locale = new Locale(strArrSplit3[0]);
                        } else {
                            throw new IllegalArgumentException("Can not parse language tag: [" + str2 + "]");
                        }
                    } else {
                        locale = new Locale(str2);
                    }
                }
                localeArr[i] = locale;
            }
            return a(localeArr);
        }
        return b;
    }
}
