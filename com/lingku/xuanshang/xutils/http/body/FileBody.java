package com.lingku.xuanshang.xutils.http.body;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.sdk.djx.net.req.MediaTypeUtils;
import com.lingku.xuanshang.xutils.common.util.LogUtil;
import java.io.File;
import java.io.FileInputStream;
import java.net.HttpURLConnection;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class FileBody extends InputStreamBody {
    public File f;
    public String g;

    public FileBody(File file) {
        this(file, null);
    }

    public FileBody(File file, String str) {
        super(new FileInputStream(file));
        this.f = file;
        this.g = str;
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

    @Override // com.lingku.xuanshang.xutils.http.body.InputStreamBody, com.lingku.xuanshang.xutils.http.body.RequestBody
    public String getContentType() {
        if (TextUtils.isEmpty(this.g)) {
            this.g = getFileContentType(this.f);
        }
        return this.g;
    }

    @Override // com.lingku.xuanshang.xutils.http.body.InputStreamBody, com.lingku.xuanshang.xutils.http.body.RequestBody
    public void setContentType(String str) {
        this.g = str;
    }
}
