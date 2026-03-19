package com.fendasz.moku.liulishuo.okdownload.core.breakpoint;

import com.fendasz.moku.liulishuo.okdownload.DownloadTask;
import java.io.IOException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public interface BreakpointStore {
    BreakpointInfo createAndInsert(DownloadTask downloadTask) throws IOException;

    BreakpointInfo findAnotherInfoFromCompare(DownloadTask downloadTask, BreakpointInfo breakpointInfo);

    int findOrCreateId(DownloadTask downloadTask);

    BreakpointInfo get(int i);

    String getResponseFilename(String str);

    boolean isFileDirty(int i);

    boolean isOnlyMemoryCache();

    void remove(int i);

    boolean update(BreakpointInfo breakpointInfo) throws IOException;
}
