package com.fendasz.moku.liulishuo.okdownload.core.interceptor;

import com.fendasz.moku.liulishuo.okdownload.DownloadTask;
import com.fendasz.moku.liulishuo.okdownload.OkDownload;
import com.fendasz.moku.liulishuo.okdownload.core.dispatcher.CallbackDispatcher;
import com.fendasz.moku.liulishuo.okdownload.core.download.DownloadChain;
import com.fendasz.moku.liulishuo.okdownload.core.exception.InterruptException;
import com.fendasz.moku.liulishuo.okdownload.core.file.MultiPointOutputStream;
import com.fendasz.moku.liulishuo.okdownload.core.interceptor.Interceptor;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class FetchDataInterceptor implements Interceptor.Fetch {
    private final int blockIndex;
    private final CallbackDispatcher dispatcher = OkDownload.with().callbackDispatcher();
    private final InputStream inputStream;
    private final MultiPointOutputStream outputStream;
    private final byte[] readBuffer;
    private final DownloadTask task;

    public FetchDataInterceptor(int i, InputStream inputStream, MultiPointOutputStream multiPointOutputStream, DownloadTask downloadTask) {
        this.blockIndex = i;
        this.inputStream = inputStream;
        this.readBuffer = new byte[downloadTask.getReadBufferSize()];
        this.outputStream = multiPointOutputStream;
        this.task = downloadTask;
    }

    @Override // com.fendasz.moku.liulishuo.okdownload.core.interceptor.Interceptor.Fetch
    public long interceptFetch(DownloadChain downloadChain) throws IOException {
        if (downloadChain.getCache().isInterrupt()) {
            throw InterruptException.SIGNAL;
        }
        OkDownload.with().downloadStrategy().inspectNetworkOnWifi(downloadChain.getTask());
        int i = this.inputStream.read(this.readBuffer);
        if (i == -1) {
            return i;
        }
        this.outputStream.write(this.blockIndex, this.readBuffer, i);
        long j = i;
        downloadChain.increaseCallbackBytes(j);
        if (this.dispatcher.isFetchProcessMoment(this.task)) {
            downloadChain.flushNoCallbackIncreaseBytes();
        }
        return j;
    }
}
