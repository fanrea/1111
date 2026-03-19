package com.fendasz.moku.liulishuo.okdownload;

import com.fendasz.moku.liulishuo.okdownload.core.breakpoint.BreakpointInfo;
import com.fendasz.moku.liulishuo.okdownload.core.cause.EndCause;
import com.fendasz.moku.liulishuo.okdownload.core.cause.ResumeFailedCause;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public interface DownloadListener {
    void connectEnd(DownloadTask downloadTask, int i, int i2, Map<String, List<String>> map);

    void connectStart(DownloadTask downloadTask, int i, Map<String, List<String>> map);

    void connectTrialEnd(DownloadTask downloadTask, int i, Map<String, List<String>> map);

    void connectTrialStart(DownloadTask downloadTask, Map<String, List<String>> map);

    void downloadFromBeginning(DownloadTask downloadTask, BreakpointInfo breakpointInfo, ResumeFailedCause resumeFailedCause);

    void downloadFromBreakpoint(DownloadTask downloadTask, BreakpointInfo breakpointInfo);

    void fetchEnd(DownloadTask downloadTask, int i, long j);

    void fetchProgress(DownloadTask downloadTask, int i, long j);

    void fetchStart(DownloadTask downloadTask, int i, long j);

    void taskEnd(DownloadTask downloadTask, EndCause endCause, Exception exc);

    void taskStart(DownloadTask downloadTask);
}
