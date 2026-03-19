package com.fendasz.moku.liulishuo.okdownload;

import com.fendasz.moku.liulishuo.okdownload.DownloadTask;
import com.fendasz.moku.liulishuo.okdownload.core.breakpoint.BreakpointInfo;
import com.fendasz.moku.liulishuo.okdownload.core.breakpoint.BreakpointStore;
import com.fendasz.moku.liulishuo.okdownload.core.dispatcher.DownloadDispatcher;
import java.io.File;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class StatusUtil {

    public enum Status {
        PENDING,
        RUNNING,
        COMPLETED,
        IDLE,
        UNKNOWN
    }

    public static boolean isSameTaskPendingOrRunning(DownloadTask downloadTask) {
        return OkDownload.with().downloadDispatcher().findSameTask(downloadTask) != null;
    }

    public static Status getStatus(DownloadTask downloadTask) {
        Status statusIsCompletedOrUnknown = isCompletedOrUnknown(downloadTask);
        if (statusIsCompletedOrUnknown == Status.COMPLETED) {
            return Status.COMPLETED;
        }
        DownloadDispatcher downloadDispatcher = OkDownload.with().downloadDispatcher();
        return downloadDispatcher.isPending(downloadTask) ? Status.PENDING : downloadDispatcher.isRunning(downloadTask) ? Status.RUNNING : statusIsCompletedOrUnknown;
    }

    public static Status getStatus(String str, String str2, String str3) {
        return getStatus(createFinder(str, str2, str3));
    }

    public static boolean isCompleted(DownloadTask downloadTask) {
        return isCompletedOrUnknown(downloadTask) == Status.COMPLETED;
    }

    public static Status isCompletedOrUnknown(DownloadTask downloadTask) {
        BreakpointStore breakpointStore = OkDownload.with().breakpointStore();
        BreakpointInfo breakpointInfo = breakpointStore.get(downloadTask.getId());
        String filename = downloadTask.getFilename();
        File parentFile = downloadTask.getParentFile();
        File file = downloadTask.getFile();
        if (breakpointInfo != null) {
            if (!breakpointInfo.isChunked() && breakpointInfo.getTotalLength() <= 0) {
                return Status.UNKNOWN;
            }
            if (file != null && file.equals(breakpointInfo.getFile()) && file.exists() && breakpointInfo.getTotalOffset() == breakpointInfo.getTotalLength()) {
                return Status.COMPLETED;
            }
            if (filename == null && breakpointInfo.getFile() != null && breakpointInfo.getFile().exists()) {
                return Status.IDLE;
            }
            if (file != null && file.equals(breakpointInfo.getFile()) && file.exists()) {
                return Status.IDLE;
            }
        } else {
            if (breakpointStore.isOnlyMemoryCache() || breakpointStore.isFileDirty(downloadTask.getId())) {
                return Status.UNKNOWN;
            }
            if (file != null && file.exists()) {
                return Status.COMPLETED;
            }
            String responseFilename = breakpointStore.getResponseFilename(downloadTask.getUrl());
            if (responseFilename != null && new File(parentFile, responseFilename).exists()) {
                return Status.COMPLETED;
            }
        }
        return Status.UNKNOWN;
    }

    public static boolean isCompleted(String str, String str2, String str3) {
        return isCompleted(createFinder(str, str2, str3));
    }

    public static BreakpointInfo getCurrentInfo(String str, String str2, String str3) {
        return getCurrentInfo(createFinder(str, str2, str3));
    }

    public static BreakpointInfo getCurrentInfo(DownloadTask downloadTask) {
        BreakpointStore breakpointStore = OkDownload.with().breakpointStore();
        BreakpointInfo breakpointInfo = breakpointStore.get(breakpointStore.findOrCreateId(downloadTask));
        if (breakpointInfo == null) {
            return null;
        }
        return breakpointInfo.copy();
    }

    static DownloadTask createFinder(String str, String str2, String str3) {
        return new DownloadTask.Builder(str, str2, str3).build();
    }
}
