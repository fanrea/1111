package com.component.interfaces;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.container.components.command.j;
import com.baidu.mobads.container.components.command.m;
import com.baidu.mobads.container.components.command.o;
import com.baidu.mobads.container.components.e.b;
import com.baidu.mobads.container.f;
import java.io.File;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class RemoteReflectInterface {
    public static void pauseDlByPk(String str, int i) {
        b bVarB;
        try {
            if (!TextUtils.isEmpty(str) && (bVarB = f.b(str)) != null) {
                bVarB.a(i);
            }
        } catch (Throwable th) {
        }
    }

    public static void cancelDlByPk(String str) {
        Context contextC;
        try {
            if (!TextUtils.isEmpty(str) && (contextC = com.baidu.mobads.container.config.b.a().c()) != null) {
                com.baidu.mobads.container.components.e.f.a(contextC).c(str);
            }
        } catch (Throwable th) {
        }
    }

    public static boolean resumeDownload(Context context, JSONObject jSONObject, String str, String str2) {
        try {
            o oVarA = o.a(jSONObject);
            oVarA.b = str;
            oVarA.x = str2;
            return new m(context, oVarA).b();
        } catch (Throwable th) {
            return false;
        }
    }

    public static int getDownloadStatus(String str) {
        b.a aVarI;
        String strL;
        int iH;
        try {
            b bVarB = f.b(str);
            if (bVarB != null) {
                aVarI = bVarB.i();
                iH = (int) bVarB.h();
                strL = bVarB.l();
            } else {
                j jVarA = j.a(f.b(), str);
                if (jVarA != null && jVarA.X == b.a.COMPLETED) {
                    b.a aVar = jVarA.X;
                    iH = jVarA.V;
                    strL = jVarA.T + jVarA.S;
                    aVarI = aVar;
                } else {
                    aVarI = null;
                    strL = "";
                    iH = 0;
                }
            }
            if (aVarI != null) {
                if (aVarI == b.a.INITING || aVarI == b.a.DOWNLOADING) {
                    return iH;
                }
                if (aVarI == b.a.COMPLETED) {
                    if (!a(strL)) {
                        return -1;
                    }
                    return 101;
                }
                if (aVarI == b.a.PAUSED) {
                    return 102;
                }
                if (aVarI != b.a.ERROR && aVarI != b.a.COMPLETE_BUT_FILE_REMOVED) {
                    return -1;
                }
                return 104;
            }
        } catch (Throwable th) {
        }
        return -1;
    }

    private static boolean a(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                File file = new File(str);
                if (file.exists()) {
                    return file.length() > 0;
                }
                return false;
            }
        } catch (Throwable th) {
        }
        return false;
    }
}
