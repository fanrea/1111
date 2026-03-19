package com.lingku.xuanshang.xutils.http.body;

import android.text.TextUtils;
import com.bytedance.sdk.djx.net.req.MediaTypeUtils;
import com.lingku.xuanshang.xutils.common.Callback;
import com.lingku.xuanshang.xutils.common.util.IOUtil;
import com.lingku.xuanshang.xutils.common.util.LogUtil;
import com.lingku.xuanshang.xutils.http.ProgressHandler;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class InputStreamBody implements ProgressBody {
    public InputStream a;
    public String b;
    public final long c;
    public long d;
    public ProgressHandler e;

    public InputStreamBody(InputStream inputStream) {
        this(inputStream, null);
    }

    public InputStreamBody(InputStream inputStream, String str) {
        this.d = 0L;
        this.a = inputStream;
        this.b = str;
        this.c = getInputStreamLength(inputStream);
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

    @Override // com.lingku.xuanshang.xutils.http.body.RequestBody
    public long getContentLength() {
        return this.c;
    }

    @Override // com.lingku.xuanshang.xutils.http.body.RequestBody
    public String getContentType() {
        return TextUtils.isEmpty(this.b) ? MediaTypeUtils.APPLICATION_OCTET_STREAM : this.b;
    }

    @Override // com.lingku.xuanshang.xutils.http.body.RequestBody
    public void setContentType(String str) {
        this.b = str;
    }

    @Override // com.lingku.xuanshang.xutils.http.body.ProgressBody
    public void setProgressHandler(ProgressHandler progressHandler) {
        this.e = progressHandler;
    }

    @Override // com.lingku.xuanshang.xutils.http.body.RequestBody
    public void writeTo(OutputStream outputStream) {
        ProgressHandler progressHandler = this.e;
        if (progressHandler != null && !progressHandler.updateProgress(this.c, this.d, true)) {
            throw new Callback.CancelledException("upload stopped!");
        }
        byte[] bArr = new byte[4096];
        while (true) {
            try {
                int i = this.a.read(bArr);
                if (i == -1) {
                    outputStream.flush();
                    ProgressHandler progressHandler2 = this.e;
                    if (progressHandler2 != null) {
                        progressHandler2.updateProgress(this.c, this.d, true);
                    }
                    return;
                }
                outputStream.write(bArr, 0, i);
                long j = this.d + i;
                this.d = j;
                ProgressHandler progressHandler3 = this.e;
                if (progressHandler3 != null && !progressHandler3.updateProgress(this.c, j, false)) {
                    throw new Callback.CancelledException("upload stopped!");
                }
            } finally {
                IOUtil.closeQuietly(this.a);
            }
        }
    }
}
