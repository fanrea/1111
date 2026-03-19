package lkxssdk.t;

import android.content.Context;
import android.util.Log;
import com.lingku.xuanshang.silicompressorr.videocompression.MediaController;
import java.io.File;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public class a {
    public static final String a = "a";
    public static volatile a b;
    public static Context c;

    public a(Context context) {
        c = context;
    }

    public String a(String str, String str2, int i, int i2, int i3) {
        String str3;
        String str4;
        Context context = c;
        MediaController mediaController = MediaController.c;
        MediaController.b = context;
        if (mediaController == null) {
            synchronized (MediaController.class) {
                mediaController = MediaController.c;
                if (mediaController == null) {
                    mediaController = new MediaController();
                    MediaController.c = mediaController;
                }
            }
        }
        if (mediaController.a(null, null, str, new File(str2), i, i2, i3)) {
            str3 = a;
            str4 = "Video Conversion Complete";
        } else {
            str3 = a;
            str4 = "Video conversion in progress";
        }
        Log.v(str3, str4);
        return MediaController.a.getPath();
    }

    public static a a(Context context) {
        if (b == null) {
            synchronized (a.class) {
                if (b == null) {
                    if (context != null) {
                        b = new a(context.getApplicationContext());
                    } else {
                        throw new IllegalArgumentException("Context must not be null.");
                    }
                }
            }
        }
        return b;
    }
}
