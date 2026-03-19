package com.baidu.mobads.container.l;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class f extends e {
    public static final String c = "logout";

    public f(Context context) {
        super(new a(context));
    }

    public static void a(Context context, String str) {
        a.a(context, str);
    }

    @Override // com.baidu.mobads.container.l.e, com.baidu.mobads.container.l.g.a
    String a() {
        return "logout";
    }

    private static class a extends j {
        private static final String[] a = {"#", "#", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "D", "I", ExifInterface.LONGITUDE_WEST, ExifInterface.LONGITUDE_EAST, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS};
        private final Context b;

        public a(Context context) {
            this.b = context;
        }

        @Override // com.baidu.mobads.container.l.j, com.baidu.mobads.container.l.b
        public void a(int i, String str, String str2, Throwable th) {
            if (this.b == null && i > 1 && i < 8) {
                return;
            }
            a(this.b, (new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS", Locale.getDefault()).format(new Date()) + " " + a[i] + "/" + str + ": ") + "当前线程：" + Thread.currentThread().getName() + ";  调用位置：" + a() + ";  打印消息：" + str2 + "\n");
        }

        public static void a(Context context, String str) {
            com.baidu.mobads.container.util.d.d.a(context).b("_debug", str);
        }
    }
}
