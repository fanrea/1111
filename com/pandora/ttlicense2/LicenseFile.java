package com.pandora.ttlicense2;

import android.text.TextUtils;
import android.util.Base64;
import com.pandora.ttlicense2.utils.IOUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class LicenseFile {
    private final String backupUrl;
    private final String content;
    private final long fileVersion;
    private final String id;
    private final String mainUrl;
    private final String signature;

    public static LicenseFile parse(String json) throws JSONException {
        JSONObject jSONObject = new JSONObject(json);
        String strOptString = jSONObject.optString("Id");
        String string = jSONObject.getString("Signature");
        String string2 = jSONObject.getString("Content");
        return new LicenseFile(strOptString, parseFileVersion(string2), string, string2, jSONObject.getString("MainURL"), jSONObject.getString("BackupURL"));
    }

    private LicenseFile(String id, long fileVersion, String signature, String content, String mainUrl, String backupUrl) {
        this.id = id;
        this.fileVersion = fileVersion;
        this.signature = signature;
        this.content = content;
        this.mainUrl = mainUrl;
        this.backupUrl = backupUrl;
    }

    public String getId() {
        return this.id;
    }

    public long getFileVersion() {
        return this.fileVersion;
    }

    public String getSignature() {
        return this.signature;
    }

    public String getContent() {
        return this.content;
    }

    public String getMainUrl() {
        return this.mainUrl;
    }

    public String getBackupUrl() {
        return this.backupUrl;
    }

    public String toString() {
        return "LicenseFile{id='" + this.id + "', fileVersion=" + this.fileVersion + ", mainUrl='" + this.mainUrl + "', backupUrl='" + this.backupUrl + "'}";
    }

    public String cacheKey() {
        if (!TextUtils.isEmpty(this.mainUrl)) {
            return this.mainUrl;
        }
        if (TextUtils.isEmpty(this.backupUrl)) {
            return !TextUtils.isEmpty(this.id) ? this.id : "";
        }
        return this.backupUrl;
    }

    public boolean isUpdateAble() {
        return (TextUtils.isEmpty(getMainUrl()) && TextUtils.isEmpty(getBackupUrl())) ? false : true;
    }

    private static long parseFileVersion(String content) {
        byte[] bArrDecode;
        if (!TextUtils.isEmpty(content) && (bArrDecode = Base64.decode(content, 0)) != null) {
            try {
                String strOptString = new JSONObject(new String(bArrDecode)).optString("FileVersion");
                if (!TextUtils.isEmpty(strOptString)) {
                    return IOUtils.parseLong(strOptString);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return -1L;
    }
}
