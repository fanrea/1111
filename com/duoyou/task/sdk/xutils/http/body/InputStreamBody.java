package com.duoyou.task.sdk.xutils.http.body;

import android.text.TextUtils;
import com.bytedance.sdk.djx.net.req.MediaTypeUtils;
import com.duoyou.task.sdk.xutils.common.Callback;
import com.duoyou.task.sdk.xutils.common.util.IOUtil;
import com.duoyou.task.sdk.xutils.common.util.LogUtil;
import com.duoyou.task.sdk.xutils.http.ProgressHandler;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class InputStreamBody implements ProgressBody {
    private ProgressHandler callBackHandler;
    private InputStream content;
    private String contentType;
    private long current;
    private final long total;

    public InputStreamBody(InputStream inputStream) {
        this(inputStream, null);
    }

    public InputStreamBody(InputStream inputStream, String str) {
        this.current = 0L;
        this.content = inputStream;
        this.contentType = str;
        this.total = getInputStreamLength(inputStream);
    }

    @Override // com.duoyou.task.sdk.xutils.http.body.ProgressBody
    public void setProgressHandler(ProgressHandler progressHandler) {
        this.callBackHandler = progressHandler;
    }

    @Override // com.duoyou.task.sdk.xutils.http.body.RequestBody
    public long getContentLength() {
        return this.total;
    }

    @Override // com.duoyou.task.sdk.xutils.http.body.RequestBody
    public void setContentType(String str) {
        this.contentType = str;
    }

    @Override // com.duoyou.task.sdk.xutils.http.body.RequestBody
    public String getContentType() {
        return TextUtils.isEmpty(this.contentType) ? MediaTypeUtils.APPLICATION_OCTET_STREAM : this.contentType;
    }

    @Override // com.duoyou.task.sdk.xutils.http.body.RequestBody
    public void writeTo(OutputStream outputStream) {
        ProgressHandler progressHandler = this.callBackHandler;
        if (progressHandler != null && !progressHandler.updateProgress(this.total, this.current, true)) {
            throw new Callback.CancelledException("upload stopped!");
        }
        byte[] bArr = new byte[4096];
        while (true) {
            try {
                int i = this.content.read(bArr);
                if (i != -1) {
                    outputStream.write(bArr, 0, i);
                    long j = this.current + i;
                    this.current = j;
                    ProgressHandler progressHandler2 = this.callBackHandler;
                    if (progressHandler2 != null && !progressHandler2.updateProgress(this.total, j, false)) {
                        throw new Callback.CancelledException("upload stopped!");
                    }
                } else {
                    outputStream.flush();
                    ProgressHandler progressHandler3 = this.callBackHandler;
                    if (progressHandler3 != null) {
                        progressHandler3.updateProgress(this.total, this.current, true);
                    }
                    return;
                }
            } finally {
                IOUtil.closeQuietly(this.content);
            }
        }
    }

    public static long getInputStreamLength(InputStream inputStream) {
        try {
            if ((inputStream instanceof FileInputStream) || (inputStream instanceof ByteArrayInputStream)) {
                return inputStream.available();
            }
            return -1L;
        } catch (Throwable th) {
            LogUtil.w(th.getMessage(), th);
            return -1L;
        }
    }
}
