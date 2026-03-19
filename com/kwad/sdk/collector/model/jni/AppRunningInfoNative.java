package com.kwad.sdk.collector.model.jni;

import com.kwad.sdk.collector.AppStatusNative;
import com.kwad.sdk.collector.model.b;
import com.kwad.sdk.collector.model.c;
import com.kwad.sdk.utils.aa;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class AppRunningInfoNative extends NativeObject implements b<AppRunningInfoNative> {
    private static SimpleDateFormat agK = new SimpleDateFormat("yyyy-MM-dd:HH:mm:ss");

    @Override // com.kwad.sdk.core.b
    public void parseJson(JSONObject jSONObject) {
    }

    public AppRunningInfoNative(long j, String str, String str2) {
        this.mPtr = AppStatusNative.nativeCreateAppRunningInfo(j, str, str2);
    }

    public AppRunningInfoNative(long j) {
        this.mPtr = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Wu, reason: merged with bridge method [inline-methods] */
    public AppRunningInfoNative clone() {
        AppRunningInfoNative appRunningInfoNative = new AppRunningInfoNative(AppStatusNative.appRunningInfoGetGranularity(this), AppStatusNative.appRunningInfoGetName(this), AppStatusNative.appRunningInfoGetPackageName(this));
        c.a(appRunningInfoNative, AppStatusNative.appRunningInfoGetLastRunningTime(this));
        return appRunningInfoNative;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AppRunningInfoNative appRunningInfoNative = (AppRunningInfoNative) obj;
        long jAppRunningInfoGetGranularity = AppStatusNative.appRunningInfoGetGranularity(this);
        if (jAppRunningInfoGetGranularity != AppStatusNative.appRunningInfoGetGranularity(appRunningInfoNative)) {
            return false;
        }
        long jAppRunningInfoGetLastRunningTime = AppStatusNative.appRunningInfoGetLastRunningTime(this);
        String strAppRunningInfoGetName = AppStatusNative.appRunningInfoGetName(this);
        String strAppRunningInfoGetPackageName = AppStatusNative.appRunningInfoGetPackageName(this);
        if (jAppRunningInfoGetGranularity == 0) {
            jAppRunningInfoGetGranularity = 1;
        }
        if (jAppRunningInfoGetLastRunningTime / jAppRunningInfoGetGranularity == AppStatusNative.appRunningInfoGetLastRunningTime(appRunningInfoNative) / jAppRunningInfoGetGranularity && strAppRunningInfoGetName.equals(AppStatusNative.appRunningInfoGetName(appRunningInfoNative))) {
            return strAppRunningInfoGetPackageName.equals(AppStatusNative.appRunningInfoGetPackageName(appRunningInfoNative));
        }
        return false;
    }

    public int hashCode() {
        long jAppRunningInfoGetGranularity = AppStatusNative.appRunningInfoGetGranularity(this);
        if (jAppRunningInfoGetGranularity == 0) {
            jAppRunningInfoGetGranularity = 1;
        }
        long jAppRunningInfoGetLastRunningTime = AppStatusNative.appRunningInfoGetLastRunningTime(this) / jAppRunningInfoGetGranularity;
        return (((AppStatusNative.appRunningInfoGetName(this).hashCode() * 31) + AppStatusNative.appRunningInfoGetPackageName(this).hashCode()) * 31) + ((int) (jAppRunningInfoGetLastRunningTime ^ (jAppRunningInfoGetLastRunningTime >>> 32)));
    }

    public String toString() {
        return "AppRunningInfo{packageName='" + c.b(this) + "', lastRunningTime=" + aP(c.c(this)) + '}';
    }

    private static String aP(long j) {
        return agK.format(new Date(j));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(AppRunningInfoNative appRunningInfoNative) {
        if (appRunningInfoNative == null) {
            return 1;
        }
        long jAppRunningInfoGetLastRunningTime = AppStatusNative.appRunningInfoGetLastRunningTime(this) - c.c(appRunningInfoNative);
        if (jAppRunningInfoGetLastRunningTime == 0) {
            return 0;
        }
        return jAppRunningInfoGetLastRunningTime > 0 ? 1 : -1;
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        aa.putValue(jSONObject, "name", AppStatusNative.appRunningInfoGetName(this));
        aa.putValue(jSONObject, "packageName", AppStatusNative.appRunningInfoGetPackageName(this));
        aa.putValue(jSONObject, "lastRunningTime", AppStatusNative.appRunningInfoGetLastRunningTime(this));
        return jSONObject;
    }

    @Override // com.kwad.sdk.collector.model.jni.NativeObject
    public void destroy() {
        if (this.mPtr != 0) {
            AppStatusNative.nativeDeleteAppRunningInfo(this.mPtr);
            this.mPtr = 0L;
        }
    }
}
