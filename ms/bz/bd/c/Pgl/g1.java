package ms.bz.bd.c.Pgl;

import android.content.Context;
import android.util.Log;
import com.bytedance.sdk.openadsdk.api.plugin.hc;
import com.bytedance.sdk.openadsdk.zw.an;
import java.io.File;
import java.util.HashSet;
import java.util.Locale;
import ms.bz.bd.c.Pgl.e1;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class8.dex */
public final class g1 {
    protected final e1.pgla b;
    protected final HashSet d = new HashSet();
    protected final e1.pblb hc;

    protected g1(e1.pblb pblbVar, pbld pbldVar) {
        this.hc = pblbVar;
        this.b = pbldVar;
    }

    public final void d(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("Given context is null");
        }
        String.format(Locale.US, "Beginning load of %s...", "Pglbizssdk_ml");
        d(context, "Pglbizssdk_ml", null);
    }

    private void d(Context context, String str, String str2) {
        File file;
        File file2;
        if (this.d.contains(str)) {
            String.format(Locale.US, "%s already loaded previously!", str);
            return;
        }
        try {
            ((s1) this.hc).getClass();
            an.d(str);
            this.d.add(str);
            String.format(Locale.US, "%s (%s) was loaded normally!", str, str2);
        } catch (UnsatisfiedLinkError e) {
            Object[] objArr = {Log.getStackTraceString(e)};
            Locale locale = Locale.US;
            String.format(locale, "Loading the library normally failed: %s", objArr);
            String.format(locale, "%s (%s) was not loaded normally, re-linking...", str, str2);
            ((s1) this.hc).getClass();
            String strMapLibraryName = (str.startsWith("lib") && str.endsWith(".so")) ? str : System.mapLibraryName(str);
            if (str2 == null || str2.length() == 0) {
                file = new File(hc.d(context, "lib", 0), strMapLibraryName);
            } else {
                file = new File(hc.d(context, "lib", 0), strMapLibraryName + "." + str2);
            }
            File file3 = file;
            if (!file3.exists()) {
                File fileD = hc.d(context, "lib", 0);
                ((s1) this.hc).getClass();
                String strMapLibraryName2 = (str.startsWith("lib") && str.endsWith(".so")) ? str : System.mapLibraryName(str);
                if (str2 == null || str2.length() == 0) {
                    file2 = new File(hc.d(context, "lib", 0), strMapLibraryName2);
                } else {
                    file2 = new File(hc.d(context, "lib", 0), strMapLibraryName2 + "." + str2);
                }
                ((s1) this.hc).getClass();
                File[] fileArrListFiles = fileD.listFiles(new f1((str.startsWith("lib") && str.endsWith(".so")) ? str : System.mapLibraryName(str)));
                if (fileArrListFiles != null) {
                    for (File file4 : fileArrListFiles) {
                        if (!file4.getAbsolutePath().equals(file2.getAbsolutePath())) {
                            file4.delete();
                        }
                    }
                }
                e1.pgla pglaVar = this.b;
                String[] strArrD = ((s1) this.hc).d();
                ((s1) this.hc).getClass();
                ((pbld) pglaVar).d(context, strArrD, (str.startsWith("lib") && str.endsWith(".so")) ? str : System.mapLibraryName(str), file3, this);
            }
            e1.pblb pblbVar = this.hc;
            String absolutePath = file3.getAbsolutePath();
            ((s1) pblbVar).getClass();
            System.load(absolutePath);
            this.d.add(str);
            String.format(Locale.US, "%s (%s) was re-linked!", str, str2);
        }
    }
}
