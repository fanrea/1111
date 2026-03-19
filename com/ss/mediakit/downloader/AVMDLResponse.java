package com.ss.mediakit.downloader;

import android.text.TextUtils;
import com.ss.mediakit.medialoader.AVMDLLog;
import java.io.IOException;
import java.util.Locale;
import okhttp3.Call;
import okhttp3.Response;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class AVMDLResponse {
    private static final String TAG = "AVMDLResponse";
    public Call call;
    public long readOff;
    public AVMDLRequest request;
    public Response response;
    public long contentlength = -1;
    public int statusCode = -1;
    public boolean isReadErr = false;

    public AVMDLResponse(AVMDLRequest aVMDLRequest, Response response, Call call) {
        this.request = aVMDLRequest;
        this.response = response;
        this.call = call;
        this.readOff = aVMDLRequest.reqOff;
        parseResponse();
    }

    private void parseResponse() {
        int iLastIndexOf;
        Response response = this.response;
        if (response == null) {
            return;
        }
        int iCode = response.code();
        this.statusCode = iCode;
        if (iCode == 200) {
            this.contentlength = toInt(this.response.header("Content-Length"));
            return;
        }
        if (iCode == 206) {
            String strHeader = this.response.header("Content-Range");
            if (TextUtils.isEmpty(strHeader) || (iLastIndexOf = strHeader.lastIndexOf("/")) < 0 || iLastIndexOf >= strHeader.length() - 1) {
                return;
            }
            this.contentlength = toInt(strHeader.substring(iLastIndexOf + 1), -1);
        }
    }

    public int readData(byte[] bArr) throws IOException {
        if (this.response.body() == null) {
            return 0;
        }
        try {
            int i = this.response.body().byteStream().read(bArr);
            if (i <= 0) {
                return -1;
            }
            AVMDLLog.d(TAG, String.format(Locale.US, "before read off:%d reqoff:%d req size:%d", Long.valueOf(this.readOff), Long.valueOf(this.request.reqOff), Long.valueOf(this.request.size)));
            long j = i;
            this.readOff += j;
            this.request.reqOff += j;
            if (this.request.size > 0) {
                this.request.size -= j;
            }
            AVMDLLog.d(TAG, String.format(Locale.US, "after read,ret:%d off:%d reqoff:%d req size:%d", Integer.valueOf(i), Long.valueOf(this.readOff), Long.valueOf(this.request.reqOff), Long.valueOf(this.request.size)));
            return i;
        } catch (IOException e) {
            this.isReadErr = true;
            AVMDLLog.e(TAG, "read data exception:" + e.getLocalizedMessage());
            return -1;
        }
    }

    public void cancel() {
        Call call = this.call;
        if (call != null) {
            call.cancel();
        }
    }

    public void reset() {
        this.response = null;
        this.call = null;
        this.contentlength = -1L;
        this.statusCode = -1;
        this.isReadErr = false;
    }

    public boolean isOpenSuccessful() {
        int i = this.statusCode;
        return i >= 200 && i < 300;
    }

    public boolean isFinish() {
        long j = this.request.size >= 0 ? this.request.reqOff + this.request.size : this.contentlength;
        long j2 = this.contentlength;
        if (j > j2) {
            j = j2;
        }
        AVMDLLog.d(TAG, String.format(Locale.US, "check readoff:%d reqoff:%d reqsize:%d contentlen:%d endoff:%d", Long.valueOf(this.readOff), Long.valueOf(this.request.reqOff), Long.valueOf(this.request.size), Long.valueOf(this.contentlength), Long.valueOf(j)));
        return this.readOff >= j;
    }

    public boolean isReadSuccessful() {
        return !this.isReadErr;
    }

    public static int toInt(String str) {
        return toInt(str, 0);
    }

    public static int toInt(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return i;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return i;
        }
    }
}
