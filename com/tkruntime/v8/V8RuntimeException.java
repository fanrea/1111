package com.tkruntime.v8;

import java.io.PrintWriter;
import java.io.StringWriter;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class16.dex */
public class V8RuntimeException extends RuntimeException {
    V8RuntimeException() {
    }

    V8RuntimeException(String str) {
        super(str);
    }

    public static String getMessage(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }
}
