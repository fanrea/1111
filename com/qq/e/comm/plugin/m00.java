package com.qq.e.comm.plugin;

import android.text.TextUtils;
import org.json.JSONException;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class m00 {
    private boolean a = true;

    m00() {
    }

    public void a(Thread thread) throws JSONException {
        StackTraceElement[] stackTrace = thread.getStackTrace();
        int length = stackTrace.length - 1;
        if (this.a) {
            while (length >= 0) {
                String string = stackTrace[length].toString();
                if (string.startsWith("com.qq.e") || string.startsWith("com.tencent.ams") || string.startsWith("com.tencent.gatherer")) {
                    length = Math.min(length + 1, stackTrace.length - 1);
                    break;
                }
                length--;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= length; i++) {
            sb.append(stackTrace[i].toString());
            sb.append("\r\n");
        }
        a(sb.toString());
    }

    private void a(String str) throws JSONException {
        ja jaVar = new ja();
        boolean zIsEmpty = TextUtils.isEmpty(str);
        if ((!zIsEmpty ? 1 : 0) != 0) {
            jaVar.a("msg", str);
        }
        qc qcVar = new qc(9130010);
        qcVar.d(zIsEmpty ? 1 : 0);
        qcVar.a(jaVar);
        b10.a(qcVar);
    }

    public void a(boolean z) {
        this.a = z;
    }
}
