package com.fendasz.moku.liulishuo.okdownload.core.listener;

import com.fendasz.moku.liulishuo.okdownload.DownloadListener;
import com.fendasz.moku.liulishuo.okdownload.DownloadTask;
import com.fendasz.moku.liulishuo.okdownload.core.breakpoint.BreakpointInfo;
import com.fendasz.moku.liulishuo.okdownload.core.cause.ResumeFailedCause;
import java.util.List;
import java.util.Map;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public abstract class DownloadListener2 implements DownloadListener {
    @Override // com.fendasz.moku.liulishuo.okdownload.DownloadListener
    public void connectEnd(DownloadTask downloadTask, int i, int i2, Map<String, List<String>> map) {
    }

    @Override // com.fendasz.moku.liulishuo.okdownload.DownloadListener
    public void connectStart(DownloadTask downloadTask, int i, Map<String, List<String>> map) {
    }

    @Override // com.fendasz.moku.liulishuo.okdownload.DownloadListener
    public void connectTrialEnd(DownloadTask downloadTask, int i, Map<String, List<String>> map) {
    }

    @Override // com.fendasz.moku.liulishuo.okdownload.DownloadListener
    public void connectTrialStart(DownloadTask downloadTask, Map<String, List<String>> map) {
    }

    @Override // com.fendasz.moku.liulishuo.okdownload.DownloadListener
    public void downloadFromBeginning(DownloadTask downloadTask, BreakpointInfo breakpointInfo, ResumeFailedCause resumeFailedCause) {
    }

    @Override // com.fendasz.moku.liulishuo.okdownload.DownloadListener
    public void downloadFromBreakpoint(DownloadTask downloadTask, BreakpointInfo breakpointInfo) {
    }

    @Override // com.fendasz.moku.liulishuo.okdownload.DownloadListener
    public void fetchEnd(DownloadTask downloadTask, int i, long j) {
    }

    @Override // com.fendasz.moku.liulishuo.okdownload.DownloadListener
    public void fetchProgress(DownloadTask downloadTask, int i, long j) {
    }

    @Override // com.fendasz.moku.liulishuo.okdownload.DownloadListener
    public void fetchStart(DownloadTask downloadTask, int i, long j) {
    }
}
