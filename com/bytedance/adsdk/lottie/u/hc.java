package com.bytedance.adsdk.lottie.u;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.io.IOException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class hc {
    private static final String d = "tt_derive" + File.separator + "lottie" + File.separator + "anim_img";
    private static final String hc = "tt_derive" + File.separator + "lottie" + File.separator + "anim_video";

    public interface d<T> {
        void d(int i, String str);

        void d(T t);
    }

    public static String d(Context context) {
        return com.bytedance.sdk.component.utils.an.d(context, com.bytedance.sdk.component.adexpress.d.d.d.d().b().mq(), d).getAbsolutePath();
    }

    public static String hc(Context context) {
        return com.bytedance.sdk.component.utils.an.d(context, com.bytedance.sdk.component.adexpress.d.d.d.d().b().mq(), hc).getAbsolutePath();
    }

    public static void d(String str, Context context, final d<File> dVar) {
        if (context == null || TextUtils.isEmpty(str)) {
            if (dVar != null) {
                dVar.d(2, "url is empty");
                return;
            }
            return;
        }
        com.bytedance.sdk.component.tt.hc.hc hcVarC = com.bytedance.sdk.component.adexpress.d.d.d.d().b().c();
        if (hcVarC == null) {
            if (dVar != null) {
                dVar.d(3, "exec is null");
            }
        } else {
            final String strD = d(context);
            final String strHc = com.bytedance.sdk.component.utils.u.hc(str);
            hcVarC.d(str);
            hcVarC.d(strD, strHc);
            hcVarC.d(new com.bytedance.sdk.component.tt.d.d() { // from class: com.bytedance.adsdk.lottie.u.hc.1
                @Override // com.bytedance.sdk.component.tt.d.d
                public void d(com.bytedance.sdk.component.tt.hc.c cVar, com.bytedance.sdk.component.tt.hc hcVar) {
                    if (dVar != null) {
                        File file = new File(strD, strHc);
                        if (file.exists()) {
                            dVar.d(file);
                        } else {
                            dVar.d(4, "file not exist");
                        }
                    }
                }

                @Override // com.bytedance.sdk.component.tt.d.d
                public void d(com.bytedance.sdk.component.tt.hc.c cVar, IOException iOException) {
                    d dVar2 = dVar;
                    if (dVar2 != null) {
                        dVar2.d(1, "net err: " + iOException.getMessage());
                    }
                }
            });
        }
    }
}
