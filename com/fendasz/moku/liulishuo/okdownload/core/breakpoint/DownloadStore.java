package com.fendasz.moku.liulishuo.okdownload.core.breakpoint;

import com.fendasz.moku.liulishuo.okdownload.core.cause.EndCause;
import java.io.IOException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public interface DownloadStore extends BreakpointStore {
    BreakpointInfo getAfterCompleted(int i);

    boolean markFileClear(int i);

    boolean markFileDirty(int i);

    void onSyncToFilesystemSuccess(BreakpointInfo breakpointInfo, int i, long j) throws IOException;

    void onTaskEnd(int i, EndCause endCause, Exception exc);

    void onTaskStart(int i);
}
