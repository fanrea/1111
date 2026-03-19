package com.duoyou.task.sdk.xutils.http.body;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.djx.net.req.MediaTypeUtils;
import com.duoyou.task.sdk.xutils.common.util.LogUtil;
import java.io.File;
import java.io.FileInputStream;
import java.net.HttpURLConnection;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class FileBody extends InputStreamBody {
    private String contentType;
    private File file;

    public FileBody(File file) {
        this(file, null);
    }

    public FileBody(File file, String str) {
        super(new FileInputStream(file));
        this.file = file;
        this.contentType = str;
    }

    @Override // com.duoyou.task.sdk.xutils.http.body.InputStreamBody, com.duoyou.task.sdk.xutils.http.body.RequestBody
    public void setContentType(String str) {
        this.contentType = str;
    }

    @Override // com.duoyou.task.sdk.xutils.http.body.InputStreamBody, com.duoyou.task.sdk.xutils.http.body.RequestBody
    public String getContentType() {
        if (TextUtils.isEmpty(this.contentType)) {
            this.contentType = getFileContentType(this.file);
        }
        return this.contentType;
    }

    public static String getFileContentType(File file) {
        String strGuessContentTypeFromName;
        try {
            strGuessContentTypeFromName = HttpURLConnection.guessContentTypeFromName(Uri.encode(file.getName(), "-![.:/,?&=]"));
        } catch (Exception e) {
            LogUtil.e(e.toString());
            strGuessContentTypeFromName = null;
        }
        return TextUtils.isEmpty(strGuessContentTypeFromName) ? MediaTypeUtils.APPLICATION_OCTET_STREAM : strGuessContentTypeFromName.replaceFirst("\\/jpg$", "/jpeg");
    }
}
