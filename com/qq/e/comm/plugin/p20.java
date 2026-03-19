package com.qq.e.comm.plugin;

import androidx.exifinterface.media.ExifInterface;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public class p20 {
    private static final long a = r1.d().f().a("tlrfs", 512) * 1024;
    private static final File b;
    private static final File c;
    private static final File d;

    static {
        File file = new File(r1.d().a().getApplicationContext().getCacheDir(), "tools_log");
        b = file;
        StringBuilder sb = new StringBuilder();
        sb.append(file);
        String str = File.separator;
        sb.append(str);
        sb.append(ExifInterface.GPS_MEASUREMENT_IN_PROGRESS);
        c = new File(sb.toString());
        d = new File(file + str + "B");
    }

    public static void a(String str, Object obj, Object... objArr) throws Throwable {
        if (a()) {
            try {
                File file = b;
                if (!file.exists()) {
                    file.mkdir();
                }
                File file2 = c;
                if (!file2.exists()) {
                    file2.createNewFile();
                }
                File file3 = d;
                if (!file3.exists()) {
                    file3.createNewFile();
                }
                if (objArr != null && objArr.length > 0) {
                    obj = String.format(obj.toString(), objArr);
                }
                String strA = a(obj.toString(), str);
                long length = file2.length();
                long j = a;
                if (length < j) {
                    gu.a(file2, strA);
                } else {
                    if (file3.length() < j) {
                        gu.a(file3, strA);
                        return;
                    }
                    if (file2.lastModified() >= file3.lastModified()) {
                        file2 = file3;
                    }
                    gu.b(file2, strA);
                }
            } catch (Exception e) {
                e.toString();
            }
        }
    }

    private static boolean a() {
        return n3.a() && r1.d().a().getSharedPreferences("gdt_mock", 0).getBoolean("needRecord", false);
    }

    private static String a(String str, String str2) {
        return "------------------------------------------------------------" + hv.a(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA).format(new Date()) + str2 + str, "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEApbco3xK9deb07zYc2Kot\njdDnU4aR3J6Tr4QNcei0lDFyb5l9twwTlAhwx+jDxCFQE2GvZPw0ru3fLlnwIOGv\nxvBRozZiXsmNYGnR/ntK708th9huZ2TWB3cfqepevOWEyMP3dasnY5puz/6BMxUL\nMbbLGPR5eWpaqUra6mZ8k6tKlNQoItSwAQTikVztS7SW23FTMB5z5gdhJ1EDV5+w\n8w8/fcwsgP+aR5FwkPYRRzPukspt4N+fJq1cyxTwCmKkobmvWzn699IXHItAOqqH\nt3ZW6EbgELlLFd94dtVL7OyiIxhQiyJ0Ulv3XOdjiCqLWSMCUImTnRCmmX+Kdka9\nzQIDAQAB");
    }
}
