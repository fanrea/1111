package com.fendasz.moku.liulishuo.okdownload.core.interceptor;

import com.fendasz.moku.liulishuo.okdownload.core.connection.DownloadConnection;
import com.fendasz.moku.liulishuo.okdownload.core.download.DownloadCache;
import com.fendasz.moku.liulishuo.okdownload.core.download.DownloadChain;
import com.fendasz.moku.liulishuo.okdownload.core.exception.InterruptException;
import com.fendasz.moku.liulishuo.okdownload.core.exception.RetryException;
import com.fendasz.moku.liulishuo.okdownload.core.interceptor.Interceptor;
import java.io.IOException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class RetryInterceptor implements Interceptor.Connect, Interceptor.Fetch {
    @Override // com.fendasz.moku.liulishuo.okdownload.core.interceptor.Interceptor.Connect
    public DownloadConnection.Connected interceptConnect(DownloadChain downloadChain) throws IOException {
        DownloadCache cache = downloadChain.getCache();
        while (true) {
            try {
                if (cache.isInterrupt()) {
                    throw InterruptException.SIGNAL;
                }
                return downloadChain.processConnect();
            } catch (IOException e) {
                if (e instanceof RetryException) {
                    downloadChain.resetConnectForRetry();
                } else {
                    downloadChain.getCache().catchException(e);
                    downloadChain.getOutputStream().catchBlockConnectException(downloadChain.getBlockIndex());
                    throw e;
                }
            }
        }
    }

    @Override // com.fendasz.moku.liulishuo.okdownload.core.interceptor.Interceptor.Fetch
    public long interceptFetch(DownloadChain downloadChain) throws IOException {
        try {
            return downloadChain.processFetch();
        } catch (IOException e) {
            downloadChain.getCache().catchException(e);
            throw e;
        }
    }
}
