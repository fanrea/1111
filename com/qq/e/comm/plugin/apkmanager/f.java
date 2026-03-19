package com.qq.e.comm.plugin.apkmanager;

import com.baidu.mobads.container.util.bu;
import com.kuaishou.socket.nano.SocketMessages;
import com.qq.e.comm.plugin.wj;
import java.io.File;
import yaq.pro;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class f {
    static void a(File file) {
        pro.getVresult(bu.l, 1, file);
    }

    private static final void a(File file, long j, String str) {
        pro.getVresult(SocketMessages.PayloadType.SC_WISH_LIST_OPENED, 1, file, Long.valueOf(j), str);
    }

    private static boolean a() {
        return pro.getZresult(SocketMessages.PayloadType.SC_WISH_LIST_CLOSED, 1, new Object[0]);
    }

    private static boolean a(ApkDownloadTask apkDownloadTask, long j, File file, int i) {
        return pro.getZresult(SocketMessages.PayloadType.SC_RIDE_CHANGED, 1, apkDownloadTask, Long.valueOf(j), file, Integer.valueOf(i));
    }

    static boolean a(ApkDownloadTask apkDownloadTask, wj wjVar, File file) {
        return pro.getZresult(bu.aL, 1, apkDownloadTask, wjVar, file);
    }

    static boolean a(ApkDownloadTask apkDownloadTask, File file) {
        return pro.getZresult(414, 1, apkDownloadTask, file);
    }

    private static File b(File file) {
        return (File) pro.getobjresult(415, 1, file);
    }
}
