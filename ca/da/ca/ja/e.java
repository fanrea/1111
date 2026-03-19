package ca.da.ca.ja;

import android.text.TextUtils;
import java.io.File;
import java.util.ArrayList;

/* compiled from: DeprecatedFileCleaner.java */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class e {
    public final ArrayList<String> a = new ArrayList<>();

    public final void a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        File file = new File(ca.ca.ca.ca.a.a(str).append(File.separator).append(str2).append(".dat").toString());
        if (file.exists()) {
            file.delete();
        }
    }
}
