package com.baidu.enan.e.a.h;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Base64;
import com.alipay.sdk.m.u.i;
import com.baidu.enan.f.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class a {
    public static String a = "MpCX1OuVYmYc0jCEPsoByvpdOJuQBaILxdh/EVNLzWnOA9W4xw6EANV3gZutRxswJ23w9ie1uwz5J8S3dikFXcqRiqyCWWNlCaCASfDMuMx9F2cayJapTDN5X8pRy9L7OXvq6vLarGDXbgssXcsubFYOKX4HkrB1DRymKRBqYt6qJwNn2Ks9sKqHeBCh2X+iCUUtc+/1ZChPnjW86zN7LCZtrWTV7pPsttnmrikGuOu9zlsOxnXO+gxrOMV6RI18V4HNfvCAyzwarX24tZHW+fMibDgeVeo4zTfekIn4bD9hZwHz4dBCmryP7PEWyuUgtT1rjnIJO9vphY/B82ZWvvkmHd7erG9qTE4jvAOkrTBLm845wd7vImbM/oHHaj+F/Y/ZPjuBNS6FUMC0oelNVbGC2xqJkIQeX4vIkNCOOd2mK9UlloQ0SR7a3aCsEj2WKoiDXxbesVTtpf9teejeACBMOuaM1wqUKIpdNIyAe8TeIfDzbmvy/5pmt3EAmv8F7fjcK1AcVu5EbAHjosbdjeFOCxaXDEe7656G3ePF6BlaqmwQzS+j1kzCQbt0iWKllFetXwYofQCjZBMMwWSgCFunIFXipH/xq0iiy129m6v5jtUGD6jZYzKcxaHl9eTJtVorSUJ+poz3EQ1pZ/Rhj2Iq6ZnWD0BMShIzfVkZpc8ZEdKYOglZB5KEz4C4oGcOtYO7wCgQS5LSbjvfose7R4H52EcOozn6PhSRDI+kq139kphE+DzQuiqpO872RzeBiWGjb+H3BhFVZjVmXxVZKTe3iee3Fvc8BZ17VGOzrZ2BxCVpKYkqOFBZ6plJ4Pv57+1Zm5mZSYfP5ywaMxHm7Ksba7+nxRZW4tfrUFDFZ0kZrAONY4N2dy5YxWXXZP16kQV3gEWZfhCfebMREigtO/6YeVM4qDPb3oYsesuaQkNrGcCTGUJUTbkeFZs02XWZcVWN8XGu9SBh7vpt5KOm3opqXiFkbAPfDx4mpiiIBt7lrr5Bv1sQyrX2HxQ1nwbbVLQrYspz/kdJT1/5Tuhrz/D7GJJu4gpCpuPGH7s4MwuZxuHVQdaF9FOILGyNTsKU";

    public static String a(Context context) {
        try {
            return a(b(context));
        } catch (Throwable th) {
            com.baidu.enan.f.a.a(th);
            return "";
        }
    }

    private static List<String> b(Context context) {
        try {
            List<String> listA = a(context, a());
            if (listA != null && listA.size() > 0) {
                for (String str : listA) {
                }
            }
            return listA;
        } catch (Throwable th) {
            b.a(th);
            return null;
        }
    }

    public static String a(List<String> list) {
        if (list == null) {
            return "";
        }
        try {
            if (list.size() <= 0) {
                return "";
            }
            StringBuffer stringBuffer = new StringBuffer();
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                stringBuffer.append(it.next());
                stringBuffer.append(i.b);
            }
            return stringBuffer.substring(0, stringBuffer.length() - 1);
        } catch (Throwable th) {
            b.a(th);
            return "";
        }
    }

    private static List<String> a(Context context, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            PackageManager packageManager = context.getPackageManager();
            JSONArray jSONArray = new JSONArray(str);
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < jSONArray.length(); i++) {
                packageManager.getPackageInfo(jSONArray.getString(i), 0);
            }
            return arrayList;
        } catch (Throwable th) {
            b.a(th);
            return null;
        }
    }

    public static String a() {
        try {
            return new String(com.baidu.enan.b.b.c(Base64.decode(a, 2), "30212102dicudiab".getBytes()));
        } catch (Throwable th) {
            b.a(th);
            return "";
        }
    }
}
