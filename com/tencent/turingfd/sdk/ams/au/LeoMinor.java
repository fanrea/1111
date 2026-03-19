package com.tencent.turingfd.sdk.ams.au;

import io.netty.util.internal.StringUtil;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Locale;
import org.aspectj.runtime.reflect.SignatureImpl;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public final class LeoMinor implements Leo {
    public static final Locale[] b = new Locale[0];
    public final Locale[] a;

    public LeoMinor(Locale... localeArr) {
        if (localeArr.length == 0) {
            this.a = b;
            return;
        }
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < localeArr.length; i++) {
            Locale locale = localeArr[i];
            if (locale == null) {
                throw new NullPointerException("list[" + i + "] is null");
            }
            if (!hashSet.contains(locale)) {
                Locale locale2 = (Locale) locale.clone();
                arrayList.add(locale2);
                a(sb, locale2);
                if (i < localeArr.length - 1) {
                    sb.append(StringUtil.COMMA);
                }
                hashSet.add(locale2);
            }
        }
        this.a = (Locale[]) arrayList.toArray(new Locale[0]);
    }

    @Override // com.tencent.turingfd.sdk.ams.au.Leo
    public Locale a(int i) {
        if (i >= 0) {
            Locale[] localeArr = this.a;
            if (i < localeArr.length) {
                return localeArr[i];
            }
        }
        return null;
    }

    @Override // com.tencent.turingfd.sdk.ams.au.Leo
    public int a() {
        return this.a.length;
    }

    public static void a(StringBuilder sb, Locale locale) {
        sb.append(locale.getLanguage());
        String country = locale.getCountry();
        if (country == null || country.isEmpty()) {
            return;
        }
        sb.append(SignatureImpl.SEP);
        sb.append(locale.getCountry());
    }
}
