package com.fendasz.moku.liulishuo.okdownload.core.download;

import com.fendasz.moku.liulishuo.okdownload.DownloadTask;
import com.fendasz.moku.liulishuo.okdownload.OkDownload;
import com.fendasz.moku.liulishuo.okdownload.core.breakpoint.BreakpointInfo;
import com.fendasz.moku.liulishuo.okdownload.core.cause.ResumeFailedCause;
import com.fendasz.moku.liulishuo.okdownload.core.exception.FileBusyAfterRunException;
import com.fendasz.moku.liulishuo.okdownload.core.exception.ServerCanceledException;
import java.io.IOException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class BreakpointRemoteCheck {
    private boolean acceptRange;
    ResumeFailedCause failedCause;
    private final BreakpointInfo info;
    private long instanceLength;
    private boolean resumable;
    private final DownloadTask task;

    boolean isTrialSpecialPass(int i, long j, boolean z) {
        return i == 416 && j >= 0 && z;
    }

    public BreakpointRemoteCheck(DownloadTask downloadTask, BreakpointInfo breakpointInfo) {
        this.task = downloadTask;
        this.info = breakpointInfo;
    }

    public String toString() {
        return "acceptRange[" + this.acceptRange + "] resumable[" + this.resumable + "] failedCause[" + this.failedCause + "] instanceLength[" + this.instanceLength + "] " + super.toString();
    }

    public ResumeFailedCause getCause() {
        return this.failedCause;
    }

    public ResumeFailedCause getCauseOrThrow() {
        ResumeFailedCause resumeFailedCause = this.failedCause;
        if (resumeFailedCause != null) {
            return resumeFailedCause;
        }
        throw new IllegalStateException("No cause find with resumable: " + this.resumable);
    }

    public boolean isResumable() {
        return this.resumable;
    }

    public boolean isAcceptRange() {
        return this.acceptRange;
    }

    public long getInstanceLength() {
        return this.instanceLength;
    }

    public void check() throws IOException {
        DownloadStrategy downloadStrategy = OkDownload.with().downloadStrategy();
        ConnectTrial connectTrialCreateConnectTrial = createConnectTrial();
        connectTrialCreateConnectTrial.executeTrial();
        boolean zIsAcceptRange = connectTrialCreateConnectTrial.isAcceptRange();
        boolean zIsChunked = connectTrialCreateConnectTrial.isChunked();
        long instanceLength = connectTrialCreateConnectTrial.getInstanceLength();
        String responseEtag = connectTrialCreateConnectTrial.getResponseEtag();
        String responseFilename = connectTrialCreateConnectTrial.getResponseFilename();
        int responseCode = connectTrialCreateConnectTrial.getResponseCode();
        downloadStrategy.validFilenameFromResponse(responseFilename, this.task, this.info);
        this.info.setChunked(zIsChunked);
        this.info.setEtag(responseEtag);
        if (OkDownload.with().downloadDispatcher().isFileConflictAfterRun(this.task)) {
            throw FileBusyAfterRunException.SIGNAL;
        }
        ResumeFailedCause preconditionFailedCause = downloadStrategy.getPreconditionFailedCause(responseCode, this.info.getTotalOffset() != 0, this.info, responseEtag);
        boolean z = preconditionFailedCause == null;
        this.resumable = z;
        this.failedCause = preconditionFailedCause;
        this.instanceLength = instanceLength;
        this.acceptRange = zIsAcceptRange;
        if (isTrialSpecialPass(responseCode, instanceLength, z)) {
            return;
        }
        if (downloadStrategy.isServerCanceled(responseCode, this.info.getTotalOffset() != 0)) {
            throw new ServerCanceledException(responseCode, this.info.getTotalOffset());
        }
    }

    ConnectTrial createConnectTrial() {
        return new ConnectTrial(this.task, this.info);
    }
}
