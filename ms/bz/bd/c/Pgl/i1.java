package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.view.Display;
import android.view.WindowManager;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public final class i1 {
    public static int d;
    public static int hc;

    public static String d(Context context) {
        Display defaultDisplay;
        Point point;
        int i;
        int height;
        try {
            defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            point = new Point();
            i = Build.VERSION.SDK_INT;
        } catch (Throwable unused) {
        }
        if (i >= 17) {
            defaultDisplay.getRealSize(point);
        } else {
            if (i < 13) {
                d = defaultDisplay.getWidth();
                height = defaultDisplay.getHeight();
                hc = height;
                return d + "*" + hc;
            }
            defaultDisplay.getSize(point);
        }
        d = point.x;
        height = point.y;
        hc = height;
        return d + "*" + hc;
    }
}
