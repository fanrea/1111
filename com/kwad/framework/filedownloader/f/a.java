package com.kwad.framework.filedownloader.f;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class a {
    public static boolean j(String str, String str2, boolean z) {
        b("request start the task([%s], [%s], [%B]) in the download service", str, str2, Boolean.valueOf(z));
        return false;
    }

    public static boolean df(int i) {
        b("request pause the task[%d] in the download service", Integer.valueOf(i));
        return false;
    }

    public static byte dg(int i) {
        b("request get the status for the task[%d] in the download service", Integer.valueOf(i));
        return (byte) 0;
    }

    public static boolean dh(int i) {
        b("request clear the task[%d] data in the database", Integer.valueOf(i));
        return false;
    }

    private static void b(String str, Object... objArr) {
        d.d(a.class, str + ", but the download service isn't connected yet.\nYou can use FileDownloader#isServiceConnected() to check whether the service has been connected, \nbesides you can use following functions easier to control your requestHttpCode invoke after the service has been connected: \n1. FileDownloader#bindService(Runnable)\n2. FileDownloader#insureServiceBind()\n3. FileDownloader#insureServiceBindAsync()", objArr);
    }
}
