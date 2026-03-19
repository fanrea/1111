package com.qq.e.comm.plugin;

import com.qq.e.comm.util.GDTLogger;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import javax.net.ssl.SSLHandshakeException;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public abstract class hz implements qr {
    public abstract void a(aw awVar, int i, Exception exc);

    @Override // com.qq.e.comm.plugin.qr
    public final void a(aw awVar, Exception exc) {
        int i;
        if (exc instanceof SocketTimeoutException) {
            GDTLogger.e("网络超时：网络请求出现异常" + exc.getMessage());
            i = 3002;
        } else if (exc instanceof UnknownHostException) {
            GDTLogger.e("网络不可用：网络请求出现异常" + exc.getMessage());
            i = 3003;
        } else if (exc instanceof ConnectException) {
            GDTLogger.e("网络异常：网络请求出现异常" + exc.getMessage());
            i = 3001;
        } else if (exc instanceof SSLHandshakeException) {
            GDTLogger.e("网络异常：网络请求出现异常" + exc.getMessage());
            i = 3004;
        } else {
            GDTLogger.e("网络异常：网络请求出现异常" + exc.getMessage());
            i = 3000;
        }
        a(awVar, i, exc);
    }
}
