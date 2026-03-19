package com.bytedance.sdk.djx.base.dynamic;

import com.bytedance.sdk.djx.utils.JSON;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class LicenseModel {
    public String licenseBackupURL;
    public String licenseContent;
    public String licenseExpireTime;
    public String licenseId;
    public String licenseMainURL;
    public String licensePackageName;
    public String licenseSignature;

    public JSONObject toJson() {
        JSONObject jSONObjectBuild = JSON.build();
        JSON.putObject(jSONObjectBuild, "PackageName", this.licensePackageName);
        JSON.putObject(jSONObjectBuild, "ExpireTime", this.licenseExpireTime);
        JSON.putObject(jSONObjectBuild, "Signature", this.licenseSignature);
        JSON.putObject(jSONObjectBuild, "Content", this.licenseContent);
        JSON.putObject(jSONObjectBuild, "MainURL", this.licenseMainURL);
        JSON.putObject(jSONObjectBuild, "BackupURL", this.licenseBackupURL);
        JSON.putObject(jSONObjectBuild, "Id", this.licenseId);
        return jSONObjectBuild;
    }
}
