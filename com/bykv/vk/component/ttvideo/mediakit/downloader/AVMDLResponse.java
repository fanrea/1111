package com.bykv.vk.component.ttvideo.mediakit.downloader;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLLog;
import com.bytedance.sdk.component.hc.d.cb;
import com.bytedance.sdk.component.hc.d.hc;
import java.io.IOException;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class AVMDLResponse {
    private static final String TAG = "AVMDLResponse";
    public hc call;
    public long readOff;
    public AVMDLRequest request;
    public cb response;
    public long contentlength = -1;
    public int statusCode = -1;
    public boolean isReadErr = false;

    public AVMDLResponse(AVMDLRequest aVMDLRequest, cb cbVar, hc hcVar) {
        this.request = aVMDLRequest;
        this.response = cbVar;
        this.call = hcVar;
        this.readOff = aVMDLRequest.reqOff;
        parseResponse();
    }

    private void parseResponse() {
        int iLastIndexOf;
        cb cbVar = this.response;
        if (cbVar == null) {
            return;
        }
        int iB = cbVar.b();
        this.statusCode = iB;
        if (iB == 200) {
            this.contentlength = toInt(this.response.d("Content-Length"));
            return;
        }
        if (iB == 206) {
            String strD = this.response.d("Content-Range");
            if (TextUtils.isEmpty(strD) || (iLastIndexOf = strD.lastIndexOf("/")) < 0 || iLastIndexOf >= strD.length() - 1) {
                return;
            }
            this.contentlength = toInt(strD.substring(iLastIndexOf + 1), -1);
        }
    }

    public int readData(byte[] bArr) throws IOException {
        if (this.response.an() == null) {
            return 0;
        }
        try {
            int i = this.response.an().b().read(bArr);
            if (i <= 0) {
                return -1;
            }
            String.format("before read off:%d reqoff:%d req size:%d", Long.valueOf(this.readOff), Long.valueOf(this.request.reqOff), Long.valueOf(this.request.size));
            long j = i;
            this.readOff += j;
            this.request.reqOff += j;
            if (this.request.size > 0) {
                this.request.size -= j;
            }
            String.format("after read,ret:%d off:%d reqoff:%d req size:%d", Integer.valueOf(i), Long.valueOf(this.readOff), Long.valueOf(this.request.reqOff), Long.valueOf(this.request.size));
            return i;
        } catch (IOException e) {
            this.isReadErr = true;
            AVMDLLog.e(TAG, "read data exception:" + e.getLocalizedMessage());
            return -1;
        }
    }

    public void cancel() {
        hc hcVar = this.call;
        if (hcVar != null) {
            hcVar.hc();
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
        String.format("check readoff:%d reqoff:%d reqsize:%d contentlen:%d endoff:%d", Long.valueOf(this.readOff), Long.valueOf(this.request.reqOff), Long.valueOf(this.request.size), Long.valueOf(this.contentlength), Long.valueOf(j));
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
