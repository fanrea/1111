package com.pangrowth.adclog;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class s implements k {
    @Override // com.pangrowth.adclog.k
    public String a(Object obj) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Thread: ");
        stringBuffer.append(((Thread) obj).getName());
        return stringBuffer.toString();
    }
}
