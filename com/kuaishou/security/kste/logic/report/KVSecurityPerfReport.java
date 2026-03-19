package com.kuaishou.security.kste.logic.report;

import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.TextUtils;
import com.kuaishou.security.kste.logic.base.InitCommonKSTEParams;
import java.util.Random;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class KVSecurityPerfReport {
    private static final float CUSTOM_EVENT_RATIO_RANDOM = new Random().nextFloat();
    private static final String KWAI_LOGGER_KSGUARD = "ksguard_custom_perf_key";
    private static final String KWAI_LOGGER_KSGUARD_APPEND = "append";
    private static final String KWAI_LOGGER_KSGUARD_APPKEY = "appkey";
    private static final String KWAI_LOGGER_KSGUARD_DID = "did";
    private static final String KWAI_LOGGER_KSGUARD_DINFO = "dinfo";
    private static final String KWAI_LOGGER_KSGUARD_EGID = "egid";
    private static final String KWAI_LOGGER_KSGUARD_ERRORCODE = "errorCode";
    private static final String KWAI_LOGGER_KSGUARD_ERRPRTRACK = "errorTrack";
    private static final String KWAI_LOGGER_KSGUARD_FAILRECORDS = "failRecord";
    private static final String KWAI_LOGGER_KSGUARD_FEATURE = "feature";
    private static final String KWAI_LOGGER_KSGUARD_FIRSTRUNAPP = "firstRunApp";
    private static final String KWAI_LOGGER_KSGUARD_INITMODE = "initMode";
    private static final String KWAI_LOGGER_KSGUARD_ISCOLDSTART = "isColdStart";
    private static final String KWAI_LOGGER_KSGUARD_ISFOREGROUND = "isForeground";
    private static final String KWAI_LOGGER_KSGUARD_KGUNIQUEUUID = "kgUniqueUUID";
    private static final String KWAI_LOGGER_KSGUARD_KWAIGUNIQUEUUID = "kwaigUniqueUUID";
    private static final String KWAI_LOGGER_KSGUARD_MEMINFO = "memInfo";
    private static final String KWAI_LOGGER_KSGUARD_MSG = "msg";
    private static final String KWAI_LOGGER_KSGUARD_OCCURTIME = "occurTime";
    private static final String KWAI_LOGGER_KSGUARD_OSAPIVERSION = "osVersion";
    private static final String KWAI_LOGGER_KSGUARD_PID = "pid";
    private static final String KWAI_LOGGER_KSGUARD_PKGNAME = "pkgname";
    private static final String KWAI_LOGGER_KSGUARD_PROCESSNAME = "processName";
    private static final String KWAI_LOGGER_KSGUARD_PRODUCTNAME = "productName";
    private static final String KWAI_LOGGER_KSGUARD_REPORTTAG = "reportTag";
    private static final String KWAI_LOGGER_KSGUARD_REPORTTYPE = "reportType";
    private static final String KWAI_LOGGER_KSGUARD_SBEOLOAD = "beo";
    private static final String KWAI_LOGGER_KSGUARD_SDKVERSION = "sdkversion";
    private static final String KWAI_LOGGER_KSGUARD_SPFAILDETAIL = "spFailDetail";
    private static final String KWAI_LOGGER_KSGUARD_SPFAILTIMES = "spFailTimes";
    private static final String KWAI_LOGGER_KSGUARD_THREADID = "threadId";
    private static final String KWAI_LOGGER_KSGUARD_THREADNASME = "threadName";
    private static final String KWAI_LOGGER_KSGUARD_WBINDEX = "wbindex";
    public static String ksSessionId = "";

    public enum REPORTTYPE {
        RATIO(0),
        FULL(1),
        IGNORE(2);

        private final int value;

        REPORTTYPE(int i) {
            this.value = i;
        }

        public final int getValue() {
            return this.value;
        }
    }

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'KSG_INITFAILURE' uses external variables
    	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
    	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    public final class TAG {
        private static final /* synthetic */ TAG[] $VALUES;
        public static final TAG KSG_EXCEPTION;
        public static final TAG KSG_INITFAILURE;
        public static final TAG KSG_INITSUCCESS;
        public static final TAG KSG_LITE;
        public static final TAG KSG_LOADSOFAIL;
        public static final TAG KSG_PREFWATCH;
        private final REPORTTYPE reportType;
        private final int value;

        static {
            REPORTTYPE reporttype = REPORTTYPE.FULL;
            TAG tag = new TAG("KSG_INITFAILURE", 0, 0, reporttype);
            KSG_INITFAILURE = tag;
            TAG tag2 = new TAG("KSG_INITSUCCESS", 1, 1);
            KSG_INITSUCCESS = tag2;
            TAG tag3 = new TAG("KSG_PREFWATCH", 2, 2, REPORTTYPE.RATIO);
            KSG_PREFWATCH = tag3;
            TAG tag4 = new TAG("KSG_EXCEPTION", 3, 3, reporttype);
            KSG_EXCEPTION = tag4;
            TAG tag5 = new TAG("KSG_LOADSOFAIL", 4, 4, reporttype);
            KSG_LOADSOFAIL = tag5;
            TAG tag6 = new TAG("KSG_LITE", 5, 5, reporttype);
            KSG_LITE = tag6;
            $VALUES = new TAG[]{tag, tag2, tag3, tag4, tag5, tag6};
        }

        private TAG(String str, int i, int i2) {
            this.value = i2;
            this.reportType = REPORTTYPE.IGNORE;
        }

        private TAG(String str, int i, int i2, REPORTTYPE reporttype) {
            this.value = i2;
            this.reportType = reporttype;
        }

        public static TAG valueOf(String str) {
            return (TAG) Enum.valueOf(TAG.class, str);
        }

        public static TAG[] values() {
            return (TAG[]) $VALUES.clone();
        }

        public final REPORTTYPE getReportType() {
            return this.reportType;
        }

        public final int getValue() {
            return this.value;
        }
    }

    public static String getKgSessionId() {
        if (TextUtils.isEmpty(ksSessionId)) {
            ksSessionId = String.format("%d-%d-%d", Long.valueOf(System.currentTimeMillis()), Long.valueOf(new Random().nextLong()), Long.valueOf(new Random().nextLong()));
        }
        return ksSessionId;
    }

    public static void report(TAG tag, InitCommonKSTEParams initCommonKSTEParams, String str, int i) {
        reportImpl(tag, initCommonKSTEParams, str, i, null);
    }

    private static void reportImpl(TAG tag, InitCommonKSTEParams initCommonKSTEParams, String str, int i, JSONObject jSONObject) {
        if (initCommonKSTEParams.context() == null) {
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        if (tag.getReportType() == REPORTTYPE.FULL || (tag.getReportType() == REPORTTYPE.RATIO && CUSTOM_EVENT_RATIO_RANDOM < 0.001f)) {
            try {
                jSONObject2.put(KWAI_LOGGER_KSGUARD_OSAPIVERSION, String.valueOf(Build.VERSION.SDK_INT));
                jSONObject2.put(KWAI_LOGGER_KSGUARD_MEMINFO, String.format("use/total[%d/%d]", Long.valueOf(Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()), Long.valueOf(Runtime.getRuntime().totalMemory())));
                jSONObject2.put("did", initCommonKSTEParams.did());
                jSONObject2.put(KWAI_LOGGER_KSGUARD_PRODUCTNAME, initCommonKSTEParams.appKPN());
                jSONObject2.put("appkey", initCommonKSTEParams.appkey());
                jSONObject2.put(KWAI_LOGGER_KSGUARD_INITMODE, initCommonKSTEParams.initMode().getIntValue());
                jSONObject2.put(KWAI_LOGGER_KSGUARD_ERRORCODE, i);
                if (str == null) {
                    str = "";
                }
                jSONObject2.put("msg", str);
                jSONObject2.put(KWAI_LOGGER_KSGUARD_PKGNAME, initCommonKSTEParams.context().getPackageName());
                jSONObject2.put(KWAI_LOGGER_KSGUARD_ERRPRTRACK, KVGTrace.shuffleE());
                jSONObject2.put(KWAI_LOGGER_KSGUARD_KGUNIQUEUUID, getKgSessionId());
                jSONObject2.put(KWAI_LOGGER_KSGUARD_REPORTTAG, tag.getValue());
                jSONObject2.put(KWAI_LOGGER_KSGUARD_PID, String.valueOf(Process.myPid()));
                jSONObject2.put(KWAI_LOGGER_KSGUARD_THREADNASME, String.valueOf(Thread.currentThread().getName()));
                jSONObject2.put(KWAI_LOGGER_KSGUARD_THREADID, String.valueOf(Thread.currentThread().getId()));
                String strValueOf = "UNKNOWN";
                jSONObject2.put(KWAI_LOGGER_KSGUARD_KWAIGUNIQUEUUID, KVSecurityTrack.getDelegateCb() == null ? "UNKNOWN" : KVSecurityTrack.getDelegateCb().getSessionId());
                jSONObject2.put(KWAI_LOGGER_KSGUARD_ISFOREGROUND, KVSecurityTrack.getDelegateCb() == null ? "UNKNOWN" : String.valueOf(KVSecurityTrack.getDelegateCb().isAppOnForeground()));
                if (KVSecurityTrack.getDelegateCb() != null) {
                    strValueOf = String.valueOf(KVSecurityTrack.getDelegateCb().isColdStart());
                }
                jSONObject2.put(KWAI_LOGGER_KSGUARD_ISCOLDSTART, strValueOf);
                jSONObject2.put(KWAI_LOGGER_KSGUARD_OCCURTIME, System.currentTimeMillis());
                jSONObject2.put(KWAI_LOGGER_KSGUARD_FIRSTRUNAPP, KVSecurityUtility.get(initCommonKSTEParams.context()).isFirstRunHostApp());
                if (jSONObject != null) {
                    jSONObject2.put(KWAI_LOGGER_KSGUARD_APPEND, jSONObject);
                }
                jSONObject2.put(KWAI_LOGGER_KSGUARD_REPORTTYPE, tag.getReportType().getValue());
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("ua", System.getProperty("http.agent"));
                jSONObject3.put("model", Build.MODEL);
                jSONObject3.put("abi", Build.CPU_ABI + "," + Build.CPU_ABI2);
                jSONObject3.put("board", Build.BOARD);
                jSONObject3.put("device", Build.DEVICE);
                jSONObject3.put("manufacturer", Build.MANUFACTURER);
                jSONObject3.put("fp", Build.FINGERPRINT);
                KVSecurityUtility.get(initCommonKSTEParams.context());
                jSONObject3.put("signmd5", KVSecurityUtility.getSignatureMd5(initCommonKSTEParams.context()));
                jSONObject3.put(KWAI_LOGGER_KSGUARD_PKGNAME, initCommonKSTEParams.context().getPackageName());
                jSONObject3.put("apkpath", initCommonKSTEParams.context().getPackageCodePath());
                jSONObject3.put("udid", Settings.Secure.getString(initCommonKSTEParams.context().getContentResolver(), "android_id"));
                jSONObject3.put("apkmd5", KVSecurityUtility.get(initCommonKSTEParams.context()).getHostApkMd5());
                jSONObject3.put("startuptime", System.currentTimeMillis() - SystemClock.elapsedRealtime());
                jSONObject2.put(KWAI_LOGGER_KSGUARD_DINFO, jSONObject3);
            } catch (JSONException e) {
                e.printStackTrace();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void reportSchedule() {
    }
}
