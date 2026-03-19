package com.fendasz.moku.planet.utils;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import com.fendasz.moku.liulishuo.okdownload.DownloadListener;
import com.fendasz.moku.liulishuo.okdownload.DownloadTask;
import com.fendasz.moku.liulishuo.okdownload.StatusUtil;
import com.fendasz.moku.liulishuo.okdownload.core.breakpoint.BreakpointInfo;
import java.io.File;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class MokuDownloadUtils {
    private static final String DOWNLOAD_DIR = "/download/";
    private static final String TAG = "MokuDownloadUtils";
    private DownloadListener mDownloadListener;
    private File mDownloadPath;
    private DownloadTask mDownloadTask;
    private String mDownloadUrl;

    private MokuDownloadUtils(String str, File file, DownloadListener downloadListener, int i) {
        this.mDownloadUrl = str;
        this.mDownloadPath = file;
        this.mDownloadListener = downloadListener;
        initDownload(str, file, i);
    }

    private void initDownload(String str, File file, int i) {
        if (TextUtils.isEmpty(str) || file == null) {
            return;
        }
        DownloadTask downloadTask = this.mDownloadTask;
        if (downloadTask != null) {
            downloadTask.cancel();
            this.mDownloadTask = null;
        }
        this.mDownloadTask = new DownloadTask.Builder(str, file).setFilename(Md5Utils.getMD5String(str) + ".apk").setMinIntervalMillisCallbackProcess(50).setPassIfAlreadyCompleted(false).setConnectionCount(1).build();
        LogUtils.log(TAG, "downloadPath >>> " + this.mDownloadTask.getFile());
        this.mDownloadTask.setTag(Integer.valueOf(i));
    }

    public static class Builder {
        private DownloadListener downloadListener;
        private File downloadPath;
        private String downloadUrl;
        private int tagTaskId;

        public Builder() {
            File file = new File(Environment.getExternalStorageDirectory().toString() + MokuDownloadUtils.DOWNLOAD_DIR);
            file.mkdirs();
            this.downloadPath = file;
        }

        public Builder(Context context) {
            File file = new File(context.getExternalFilesDir(null) + MokuDownloadUtils.DOWNLOAD_DIR);
            file.mkdirs();
            this.downloadPath = file;
        }

        public Builder setDownloadUrl(String str) {
            this.downloadUrl = str;
            return this;
        }

        public Builder setDownloadListener(DownloadListener downloadListener) {
            this.downloadListener = downloadListener;
            return this;
        }

        public Builder setTagTaskId(int i) {
            this.tagTaskId = i;
            return this;
        }

        public MokuDownloadUtils build() {
            return new MokuDownloadUtils(this.downloadUrl, this.downloadPath, this.downloadListener, this.tagTaskId);
        }
    }

    public File getDownloadApkPath() throws NullPointerException {
        if (this.mDownloadPath == null || this.mDownloadUrl == null) {
            Log.e(TAG, "download apk path error,mDownloadPath:" + this.mDownloadPath + ",mDownloadUrl:" + this.mDownloadUrl);
            throw new NullPointerException("download error");
        }
        return new File(this.mDownloadPath, Md5Utils.getMD5String(this.mDownloadUrl) + ".apk");
    }

    public BreakpointInfo getDownloadInfo(String str) {
        File file = this.mDownloadPath;
        if (file == null) {
            return null;
        }
        return StatusUtil.getCurrentInfo(str, file.getPath(), Md5Utils.getMD5String(str) + ".apk");
    }

    public boolean getIsDownloadedByTaskId(int i) {
        DownloadTask downloadTask = this.mDownloadTask;
        return downloadTask != null && ((Integer) downloadTask.getTag()).intValue() == i;
    }

    public void startDownload() {
        if (this.mDownloadTask == null || this.mDownloadListener == null) {
            return;
        }
        new Thread(new Runnable() { // from class: com.fendasz.moku.planet.utils.MokuDownloadUtils.1
            @Override // java.lang.Runnable
            public void run() {
                MokuDownloadUtils.this.mDownloadTask.execute(MokuDownloadUtils.this.mDownloadListener);
            }
        }).start();
    }

    public void stopDownload() {
        DownloadTask downloadTask = this.mDownloadTask;
        if (downloadTask != null) {
            downloadTask.cancel();
            this.mDownloadTask = null;
        }
    }
}
