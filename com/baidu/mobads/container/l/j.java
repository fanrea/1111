package com.baidu.mobads.container.l;

import com.baidu.mobads.container.util.bq;
import java.util.regex.Matcher;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public class j implements b {
    @Override // com.baidu.mobads.container.l.b
    public void a(int i, String str, String str2, Throwable th) {
        StringBuilder sb = new StringBuilder();
        sb.append("当前线程：").append(Thread.currentThread().getName()).append(";  ").append("调用位置：").append(a()).append(";  ").append("打印消息：");
        if (str2.length() > 4000) {
            for (String str3 : i.a(str2)) {
                i.a(i, str, sb.toString() + str3);
            }
            return;
        }
        sb.append(str2);
        i.a(i, str, sb.toString());
    }

    protected static String a() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        boolean z = false;
        int i = 0;
        for (StackTraceElement stackTraceElement : stackTrace) {
            String className = stackTraceElement.getClassName();
            Matcher matcher = i.c.matcher(className);
            if (matcher.find()) {
                className = matcher.replaceAll("");
            }
            if (className.equals(g.class.getName()) || className.equals(bq.class.getName())) {
                z = true;
            } else if (z) {
                break;
            }
            i++;
        }
        return "   (" + stackTrace[i].getFileName() + ":" + stackTrace[i].getLineNumber() + ")# " + stackTrace[i].getMethodName();
    }
}
