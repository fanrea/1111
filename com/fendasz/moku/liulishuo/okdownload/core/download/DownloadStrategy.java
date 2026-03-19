package com.fendasz.moku.liulishuo.okdownload.core.download;

import android.net.ConnectivityManager;
import com.fendasz.moku.liulishuo.okdownload.DownloadTask;
import com.fendasz.moku.liulishuo.okdownload.OkDownload;
import com.fendasz.moku.liulishuo.okdownload.core.Util;
import com.fendasz.moku.liulishuo.okdownload.core.breakpoint.BlockInfo;
import com.fendasz.moku.liulishuo.okdownload.core.breakpoint.BreakpointInfo;
import com.fendasz.moku.liulishuo.okdownload.core.breakpoint.BreakpointStore;
import com.fendasz.moku.liulishuo.okdownload.core.breakpoint.DownloadStore;
import com.fendasz.moku.liulishuo.okdownload.core.cause.ResumeFailedCause;
import com.fendasz.moku.liulishuo.okdownload.core.connection.DownloadConnection;
import com.fendasz.moku.liulishuo.okdownload.core.exception.NetworkPolicyException;
import com.fendasz.moku.liulishuo.okdownload.core.exception.ResumeFailedException;
import com.fendasz.moku.liulishuo.okdownload.core.exception.ServerCanceledException;
import com.kuaishou.weapon.p0.g;
import java.io.File;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class DownloadStrategy {
    private static final long FOUR_CONNECTION_UPPER_LIMIT = 104857600;
    private static final long ONE_CONNECTION_UPPER_LIMIT = 1048576;
    private static final String TAG = "DownloadStrategy";
    private static final long THREE_CONNECTION_UPPER_LIMIT = 52428800;
    private static final Pattern TMP_FILE_NAME_PATTERN = Pattern.compile(".*\\\\|/([^\\\\|/|?]*)\\??");
    private static final long TWO_CONNECTION_UPPER_LIMIT = 5242880;
    Boolean isHasAccessNetworkStatePermission = null;
    private ConnectivityManager manager = null;

    public boolean isServerCanceled(int i, boolean z) {
        if (i == 206 || i == 200) {
            return i == 200 && z;
        }
        return true;
    }

    public long reuseIdledSameInfoThresholdBytes() {
        return 10240L;
    }

    public ResumeAvailableResponseCheck resumeAvailableResponseCheck(DownloadConnection.Connected connected, int i, BreakpointInfo breakpointInfo) {
        return new ResumeAvailableResponseCheck(connected, i, breakpointInfo);
    }

    public int determineBlockCount(DownloadTask downloadTask, long j) {
        if (downloadTask.getSetConnectionCount() != null) {
            return downloadTask.getSetConnectionCount().intValue();
        }
        if (j < 1048576) {
            return 1;
        }
        if (j < TWO_CONNECTION_UPPER_LIMIT) {
            return 2;
        }
        if (j < 52428800) {
            return 3;
        }
        return j < FOUR_CONNECTION_UPPER_LIMIT ? 4 : 5;
    }

    public boolean inspectAnotherSameInfo(DownloadTask downloadTask, BreakpointInfo breakpointInfo, long j) {
        BreakpointStore breakpointStore;
        BreakpointInfo breakpointInfoFindAnotherInfoFromCompare;
        if (!downloadTask.isFilenameFromResponse() || (breakpointInfoFindAnotherInfoFromCompare = (breakpointStore = OkDownload.with().breakpointStore()).findAnotherInfoFromCompare(downloadTask, breakpointInfo)) == null) {
            return false;
        }
        breakpointStore.remove(breakpointInfoFindAnotherInfoFromCompare.getId());
        if (breakpointInfoFindAnotherInfoFromCompare.getTotalOffset() <= OkDownload.with().downloadStrategy().reuseIdledSameInfoThresholdBytes()) {
            return false;
        }
        if ((breakpointInfoFindAnotherInfoFromCompare.getEtag() != null && !breakpointInfoFindAnotherInfoFromCompare.getEtag().equals(breakpointInfo.getEtag())) || breakpointInfoFindAnotherInfoFromCompare.getTotalLength() != j || breakpointInfoFindAnotherInfoFromCompare.getFile() == null || !breakpointInfoFindAnotherInfoFromCompare.getFile().exists()) {
            return false;
        }
        breakpointInfo.reuseBlocks(breakpointInfoFindAnotherInfoFromCompare);
        Util.d(TAG, "Reuse another same info: " + breakpointInfo);
        return true;
    }

    public boolean isUseMultiBlock(boolean z) {
        if (OkDownload.with().outputStreamFactory().supportSeek()) {
            return z;
        }
        return false;
    }

    public void inspectFilenameFromResume(String str, DownloadTask downloadTask) {
        if (Util.isEmpty(downloadTask.getFilename())) {
            downloadTask.getFilenameHolder().set(str);
        }
    }

    public void validFilenameFromResponse(String str, DownloadTask downloadTask, BreakpointInfo breakpointInfo) throws IOException {
        if (Util.isEmpty(downloadTask.getFilename())) {
            String strDetermineFilename = determineFilename(str, downloadTask);
            if (Util.isEmpty(downloadTask.getFilename())) {
                synchronized (downloadTask) {
                    if (Util.isEmpty(downloadTask.getFilename())) {
                        downloadTask.getFilenameHolder().set(strDetermineFilename);
                        breakpointInfo.getFilenameHolder().set(strDetermineFilename);
                    }
                }
            }
        }
    }

    protected String determineFilename(String str, DownloadTask downloadTask) throws IOException {
        if (!Util.isEmpty(str)) {
            return str;
        }
        String url = downloadTask.getUrl();
        Matcher matcher = TMP_FILE_NAME_PATTERN.matcher(url);
        String strMd5 = null;
        while (matcher.find()) {
            strMd5 = matcher.group(1);
        }
        if (Util.isEmpty(strMd5)) {
            strMd5 = Util.md5(url);
        }
        if (strMd5 != null) {
            return strMd5;
        }
        throw new IOException("Can't find valid filename.");
    }

    public boolean validFilenameFromStore(DownloadTask downloadTask) {
        String responseFilename = OkDownload.with().breakpointStore().getResponseFilename(downloadTask.getUrl());
        if (responseFilename == null) {
            return false;
        }
        downloadTask.getFilenameHolder().set(responseFilename);
        return true;
    }

    public void validInfoOnCompleted(DownloadTask downloadTask, DownloadStore downloadStore) {
        long length;
        BreakpointInfo afterCompleted = downloadStore.getAfterCompleted(downloadTask.getId());
        if (afterCompleted == null) {
            afterCompleted = new BreakpointInfo(downloadTask.getId(), downloadTask.getUrl(), downloadTask.getParentFile(), downloadTask.getFilename());
            if (Util.isUriContentScheme(downloadTask.getUri())) {
                length = Util.getSizeFromContentUri(downloadTask.getUri());
            } else {
                File file = downloadTask.getFile();
                if (file == null) {
                    length = 0;
                    Util.w(TAG, "file is not ready on valid info for task on complete state " + downloadTask);
                } else {
                    length = file.length();
                }
            }
            long j = length;
            afterCompleted.addBlock(new BlockInfo(0L, j, j));
        }
        DownloadTask.TaskHideWrapper.setBreakpointInfo(downloadTask, afterCompleted);
    }

    public ResumeFailedCause getPreconditionFailedCause(int i, boolean z, BreakpointInfo breakpointInfo, String str) {
        String etag = breakpointInfo.getEtag();
        if (i == 412) {
            return ResumeFailedCause.RESPONSE_PRECONDITION_FAILED;
        }
        if (!Util.isEmpty(etag) && !Util.isEmpty(str) && !str.equals(etag)) {
            return ResumeFailedCause.RESPONSE_ETAG_CHANGED;
        }
        if (i == 201 && z) {
            return ResumeFailedCause.RESPONSE_CREATED_RANGE_NOT_FROM_0;
        }
        if (i == 205 && z) {
            return ResumeFailedCause.RESPONSE_RESET_RANGE_NOT_FROM_0;
        }
        return null;
    }

    public void inspectNetworkAvailable() throws UnknownHostException {
        if (this.isHasAccessNetworkStatePermission == null) {
            this.isHasAccessNetworkStatePermission = Boolean.valueOf(Util.checkPermission(g.b));
        }
        if (this.isHasAccessNetworkStatePermission.booleanValue()) {
            if (this.manager == null) {
                this.manager = (ConnectivityManager) OkDownload.with().context().getSystemService("connectivity");
            }
            if (!Util.isNetworkAvailable(this.manager)) {
                throw new UnknownHostException("network is not available!");
            }
        }
    }

    public void inspectNetworkOnWifi(DownloadTask downloadTask) throws IOException {
        if (this.isHasAccessNetworkStatePermission == null) {
            this.isHasAccessNetworkStatePermission = Boolean.valueOf(Util.checkPermission(g.b));
        }
        if (downloadTask.isWifiRequired()) {
            if (!this.isHasAccessNetworkStatePermission.booleanValue()) {
                throw new IOException("required for access network state but don't have the permission of Manifest.permission.ACCESS_NETWORK_STATE, please declare this permission first on your AndroidManifest, so we can handle the case of downloading required wifi state.");
            }
            if (this.manager == null) {
                this.manager = (ConnectivityManager) OkDownload.with().context().getSystemService("connectivity");
            }
            if (Util.isNetworkNotOnWifiType(this.manager)) {
                throw new NetworkPolicyException();
            }
        }
    }

    public static class FilenameHolder {
        private volatile String filename;
        private final boolean filenameProvidedByConstruct = false;

        public FilenameHolder() {
        }

        public FilenameHolder(String str) {
            this.filename = str;
        }

        void set(String str) {
            this.filename = str;
        }

        public String get() {
            return this.filename;
        }

        public boolean isFilenameProvidedByConstruct() {
            return this.filenameProvidedByConstruct;
        }

        public boolean equals(Object obj) {
            if (super.equals(obj)) {
                return true;
            }
            if (!(obj instanceof FilenameHolder)) {
                return false;
            }
            if (this.filename == null) {
                return ((FilenameHolder) obj).filename == null;
            }
            return this.filename.equals(((FilenameHolder) obj).filename);
        }

        public int hashCode() {
            if (this.filename == null) {
                return 0;
            }
            return this.filename.hashCode();
        }
    }

    public static class ResumeAvailableResponseCheck {
        private int blockIndex;
        private DownloadConnection.Connected connected;
        private BreakpointInfo info;

        protected ResumeAvailableResponseCheck(DownloadConnection.Connected connected, int i, BreakpointInfo breakpointInfo) {
            this.connected = connected;
            this.info = breakpointInfo;
            this.blockIndex = i;
        }

        public void inspect() throws IOException {
            BlockInfo block = this.info.getBlock(this.blockIndex);
            int responseCode = this.connected.getResponseCode();
            ResumeFailedCause preconditionFailedCause = OkDownload.with().downloadStrategy().getPreconditionFailedCause(responseCode, block.getCurrentOffset() != 0, this.info, this.connected.getResponseHeaderField("Etag"));
            if (preconditionFailedCause != null) {
                throw new ResumeFailedException(preconditionFailedCause);
            }
            if (OkDownload.with().downloadStrategy().isServerCanceled(responseCode, block.getCurrentOffset() != 0)) {
                throw new ServerCanceledException(responseCode, block.getCurrentOffset());
            }
        }
    }
}
