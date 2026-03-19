package lkxssdk.e;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import androidx.core.content.FileProvider;
import java.io.File;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public class x {
    public Activity a;
    public a b;
    public Uri c;

    public interface a {
    }

    public x(Activity activity, a aVar) {
        this.a = activity;
        this.b = aVar;
    }

    public static Uri a(Context context, File file) {
        return Build.VERSION.SDK_INT >= 24 ? FileProvider.getUriForFile(context, context.getPackageName() + ".lkxs.fileprovider", file) : Uri.fromFile(file);
    }
}
