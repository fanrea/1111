package com.pangrowth.adclog;

/* renamed from: com.pangrowth.adclog.r, reason: case insensitive filesystem */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class C0964r implements k {
    @Override // com.pangrowth.adclog.k
    public String a(Object obj) {
        StackTraceElement[] stackTraceElementArr = (StackTraceElement[]) obj;
        StringBuilder sb = new StringBuilder(256);
        if (stackTraceElementArr == null || stackTraceElementArr.length == 0) {
            return null;
        }
        if (stackTraceElementArr.length == 1) {
            return "\t─ " + stackTraceElementArr[0].toString();
        }
        int length = stackTraceElementArr.length;
        for (int i = 0; i < length; i++) {
            String string = "\n";
            if (i == 0) {
                sb.append("\n");
            }
            if (i != length - 1) {
                sb.append("\t├ ");
                sb.append(stackTraceElementArr[i].toString());
            } else {
                sb.append("\t└ ");
                string = stackTraceElementArr[i].toString();
            }
            sb.append(string);
        }
        return sb.toString();
    }
}
