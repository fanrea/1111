package com.android.gdt.qone.ao;

import android.text.TextUtils;
import com.android.gdt.qone.sdk.S.DataFormatter;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public final class c {
    public final void a(DataFormatter dataFormatter) {
        synchronized (DataFormatter.class) {
            com.android.gdt.qone.af.c.b("SpreadQM", "writeToCache blockWrite result %b", Boolean.valueOf(new com.android.gdt.qone.x.b().a("spread_data", new a(this, a(), dataFormatter), 3)));
        }
    }

    public final DataFormatter a() {
        DataFormatter dataFormatter = new DataFormatter();
        synchronized (DataFormatter.class) {
            DataFormatter[] dataFormatterArr = new DataFormatter[1];
            com.android.gdt.qone.af.c.b("SpreadQM", "readFromCache blockRead result %b", Boolean.valueOf(new com.android.gdt.qone.x.b().a("spread_data", new b(this, dataFormatterArr), 2)));
            DataFormatter dataFormatter2 = dataFormatterArr[0];
            if (dataFormatter2 != null) {
                dataFormatter = dataFormatter2;
            }
        }
        return dataFormatter;
    }

    public static String a(DataFormatter dataFormatter, String str) {
        try {
            Class<?> cls = Class.forName("com.google.gson.Gson");
            String str2 = (String) cls.getMethod("toJson", Object.class).invoke(cls.getDeclaredConstructor(null).newInstance(null), dataFormatter);
            return TextUtils.isEmpty(str2) ? "" : com.android.gdt.qone.t.a.b(str2, str);
        } catch (Throwable th) {
            com.android.gdt.qone.af.c.a(th);
            return "";
        }
    }

    public static DataFormatter a(String str, String str2) {
        String strA;
        DataFormatter dataFormatter;
        DataFormatter dataFormatter2 = new DataFormatter();
        if (TextUtils.isEmpty(str)) {
            return dataFormatter2;
        }
        try {
            strA = com.android.gdt.qone.t.a.a(str, str2);
        } catch (Exception e) {
            com.android.gdt.qone.af.c.a(e);
            strA = null;
        }
        if (TextUtils.isEmpty(strA)) {
            return dataFormatter2;
        }
        try {
            Class<?> cls = Class.forName("com.google.gson.Gson");
            dataFormatter = (DataFormatter) cls.getMethod("fromJson", String.class, Class.forName("java.lang.Class")).invoke(cls.getDeclaredConstructor(null).newInstance(null), strA, DataFormatter.class);
        } catch (Throwable th) {
            com.android.gdt.qone.af.c.a(th);
            dataFormatter = null;
        }
        return dataFormatter == null ? new DataFormatter() : dataFormatter;
    }
}
