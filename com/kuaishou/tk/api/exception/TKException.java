package com.kuaishou.tk.api.exception;

import android.text.TextUtils;
import com.baidu.mobstat.forbes.Config;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public class TKException extends RuntimeException {
    public TKException(String str) {
        this(str, null);
    }

    public TKException(String str, Throwable th) {
        super(attachExtraInfo(str, th), th);
    }

    public TKException(Throwable th) {
        this(null, th);
    }

    private static String attachExtraInfo(String str, Throwable th) {
        StringBuilder sb = new StringBuilder();
        sb.append("##");
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
            sb.append(Config.replace);
        }
        if (th != null) {
            sb.append(th.getMessage());
        } else {
            sb.append("TACHIKOMA异常了");
        }
        sb.append("##");
        sb.append("\n");
        return sb.toString();
    }

    public List<String> getStackTraceList() {
        ArrayList arrayList = new ArrayList();
        StackTraceElement[] stackTrace = getStackTrace();
        if (stackTrace != null && stackTrace.length > 0) {
            for (StackTraceElement stackTraceElement : stackTrace) {
                arrayList.add(stackTraceElement.toString());
            }
        }
        return arrayList;
    }
}
