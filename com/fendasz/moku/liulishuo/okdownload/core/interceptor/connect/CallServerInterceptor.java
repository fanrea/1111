package com.fendasz.moku.liulishuo.okdownload.core.interceptor.connect;

import com.fendasz.moku.liulishuo.okdownload.OkDownload;
import com.fendasz.moku.liulishuo.okdownload.core.connection.DownloadConnection;
import com.fendasz.moku.liulishuo.okdownload.core.download.DownloadChain;
import com.fendasz.moku.liulishuo.okdownload.core.interceptor.Interceptor;
import java.io.IOException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class CallServerInterceptor implements Interceptor.Connect {
    @Override // com.fendasz.moku.liulishuo.okdownload.core.interceptor.Interceptor.Connect
    public DownloadConnection.Connected interceptConnect(DownloadChain downloadChain) throws IOException {
        OkDownload.with().downloadStrategy().inspectNetworkOnWifi(downloadChain.getTask());
        OkDownload.with().downloadStrategy().inspectNetworkAvailable();
        return downloadChain.getConnectionOrCreate().execute();
    }
}
