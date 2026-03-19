package com.kuaishou.security.kste.logic.base;

import android.os.ConditionVariable;
import android.util.Pair;
import com.kuaishou.security.kste.export.HostAppInfoService;
import com.kuaishou.security.kste.export.KSTEResult;
import com.kuaishou.security.kste.logic.base.InitCommonKSTEParams;
import com.kuaishou.security.kste.logic.base.KSTEContext;
import com.kuaishou.security.kste.logic.event.KSTEException;
import com.kuaishou.security.kste.logic.model.BCInvokeTask;
import com.kuaishou.security.kste.logic.model.BitcodeHistory;
import com.kuaishou.security.kste.logic.model.ForwardBiz;
import com.kuaishou.security.kste.logic.model.InterpHistory;
import com.kuaishou.security.kste.logic.report.KVGuardPerf;
import com.kuaishou.security.kste.logic.util.KWLog;
import com.kuaishou.security.kste.logic.util.Utils;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public final class XRay {
    private int SDK_INIT_RET_FAILURE;
    private HostAppInfoService appInfoService;
    private InitCommonKSTEParams mInitParams;
    private String preHistoryBCVersConfig;
    private InterpHistory preInterpHistory;
    private int SDK_INIT_RET_SUCCESS = 1;
    private List fwBizIds = new ArrayList();
    private List bcPluginStatus = new ArrayList();
    private ReentrantLock reenLock = new ReentrantLock();
    private ConditionVariable kSecurityCV = new ConditionVariable(false);
    private boolean isInitialize = false;
    private boolean isLoadding = false;
    private volatile boolean isRetryed = false;
    private ConditionVariable invokeInitCV = new ConditionVariable(false);
    private Lock reentrantLock = new ReentrantLock();
    private ConditionVariable syncInitializeCV = new ConditionVariable(false);

    final class Holder {
        private static final XRay sInstance = new XRay();

        private Holder() {
        }
    }

    public XRay() {
        this.SDK_INIT_RET_FAILURE = 0;
        this.SDK_INIT_RET_FAILURE = 1;
    }

    public static XRay get() {
        return Holder.sInstance;
    }

    private final KSTEResult invokeImpl(BCInvokeTask bCInvokeTask) {
        KSTEResult kSTEResult = new KSTEResult(KSTEResult.Code.INVOKE_FAIL, new byte[0]);
        if (!isInitialize()) {
            this.mInitParams.initCallback().onError(new KSTEException(121));
            KWLog.error("SEC_ERROR_INTERP_LOAD_OLD_LIBRARY_ERROR");
            KVGuardPerf.error(KVGuardPerf.RType.ALL, "SEC_ERROR_NOT_INITIALIZE", 121);
            return kSTEResult;
        }
        KSTEResult kSTEResult2 = kSTEResult;
        boolean z = false;
        for (BitcodeHistory bitcodeHistory : this.bcPluginStatus) {
            if (bitcodeHistory.getVmBizId().equals(bCInvokeTask.vmBizId())) {
                this.reenLock.lock();
                z = true;
                if (bitcodeHistory.getLoadFinishStatus() && bitcodeHistory.isDoLoaded()) {
                    KWLog.debug(bCInvokeTask.vmBizId() + " do single invoke");
                    kSTEResult2 = new KSTEResult(KSTEResult.Code.INVOKE_OK, TEInterface.invokeFunction(bCInvokeTask.vmBizId(), bCInvokeTask.input(), bCInvokeTask.maxOutLen()));
                } else {
                    KWLog.error(bCInvokeTask.vmBizId() + " can not perform invoke function");
                    KVGuardPerf.error(KVGuardPerf.RType.ALL, "SEC_ERROR_BC_INVOKE_FUNCTION_ERROR " + bCInvokeTask.vmBizId() + "loadFinishStatus:" + bitcodeHistory.getLoadFinishStatus() + " isDoLoaded: " + bitcodeHistory.isDoLoaded(), 202);
                    kSTEResult2 = new KSTEResult(KSTEResult.Code.INVOKE_FAIL, new byte[0]);
                }
                this.reenLock.unlock();
            }
        }
        if (z) {
            return kSTEResult2;
        }
        this.mInitParams.initCallback().onError(new KSTEException(122));
        KWLog.error("SEC_ERROR_INVOKE_BIZID_NOT_EXISTS " + bCInvokeTask.appkey() + " " + bCInvokeTask.vmBizId() + ")");
        KVGuardPerf.error(KVGuardPerf.RType.ALL, "SEC_ERROR_INVOKE_BIZID_NOT_EXISTS " + bCInvokeTask.appkey() + "=" + bCInvokeTask.vmBizId(), 122);
        return kSTEResult;
    }

    private final void retryPerformInit() {
        try {
            KWLog.debug("retry Init kste sdk begin");
            KWLog.debug("retry Init kste SDK ret=" + performInit(this.mInitParams.toBuilder().initMode(KSTEContext.Mode.SYNC)));
        } catch (Throwable th) {
            th.printStackTrace();
            KVGuardPerf.error(KVGuardPerf.RType.ALL, "SEC_ERROR_PREFORM_RETRY_INIT_EXCEPTION  exception:" + th.getMessage() + " stack:" + th.getMessage() + ' ', 121);
        }
    }

    public final List getBcPluginStatus() {
        return this.bcPluginStatus;
    }

    public final List getFwBizIds() {
        return this.fwBizIds;
    }

    public final InitCommonKSTEParams getMInitParams() {
        return this.mInitParams;
    }

    public final String getPreHistoryBCVersConfig() {
        return this.preHistoryBCVersConfig;
    }

    public final InterpHistory getPreInterpHistory() {
        return this.preInterpHistory;
    }

    public final ReentrantLock getReenLock() {
        return this.reenLock;
    }

    public final KSTEResult invokeDirectly(BCInvokeTask bCInvokeTask) {
        return invokeImpl(bCInvokeTask);
    }

    public final boolean isInitialize() {
        if (!this.isInitialize) {
            if (!this.isLoadding) {
                this.invokeInitCV.block();
            }
            this.kSecurityCV.block();
        }
        if (!this.isInitialize) {
            this.reentrantLock.lock();
            if (!this.isRetryed) {
                this.isRetryed = true;
                this.invokeInitCV.close();
                this.kSecurityCV.close();
                retryPerformInit();
                int i = 0;
                while (!this.isInitialize) {
                    retryPerformInit();
                    int i2 = i + 1;
                    if (i > 5) {
                        break;
                    }
                    i = i2;
                }
                KWLog.error(this.isInitialize ? "kste initialize retry success" : "kste initialize retry failure");
            }
            this.reentrantLock.unlock();
        }
        return this.isInitialize;
    }

    public final int performInit(InitCommonKSTEParams.Builder builder) throws JSONException {
        if (this.isInitialize) {
            return this.SDK_INIT_RET_SUCCESS;
        }
        this.invokeInitCV.open();
        this.isLoadding = true;
        this.mInitParams = builder.build();
        try {
            System.loadLibrary(KSTEConst.KSTE_SO_NAME);
            System.loadLibrary(KSTEConst.KSTE_SO_NAME);
            System.loadLibrary(KSTEConst.KSTE_SO_NAME);
        } catch (Throwable th) {
            this.mInitParams.initCallback().onError(new KSTEException(101));
            KWLog.error("SEC_ERROR_INTERP_LOAD_OLD_LIBRARY_ERROR" + th.getMessage());
            this.isLoadding = false;
            KVGuardPerf.error(KVGuardPerf.RType.ALL, "SEC_ERROR_INTERP_LOAD_OLD_LIBRARY_ERROR exp: " + th.getMessage() + " trace: ", 101);
            this.kSecurityCV.open();
            this.syncInitializeCV.open();
            th.printStackTrace();
        }
        JSONArray jSONArray = new JSONArray();
        JSONArray jSONArray2 = new JSONArray();
        if (this.fwBizIds.size() > 0) {
            for (int i = 0; i < this.fwBizIds.size(); i++) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(KSTEConst.MSP_BCVERS_VMBIZID, ((ForwardBiz) this.fwBizIds.get(i)).getBizId());
                    jSONObject.put(KSTEConst.MSP_BCVERS_VERSION, 0);
                    jSONArray.put(jSONObject);
                    Pair fileFromAssets = Utils.getFileFromAssets(this.mInitParams.context(), ((ForwardBiz) this.fwBizIds.get(i)).getBizId(), ((ForwardBiz) this.fwBizIds.get(i)).getBizId() + ".tmp.cache");
                    if (fileFromAssets.first != null && !((String) fileFromAssets.second).isEmpty()) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put(KSTEConst.MSP_BCVERS_VMBIZID, ((ForwardBiz) this.fwBizIds.get(i)).getBizId());
                        jSONObject2.put(KSTEConst.MSP_BCVERS_VERSION, 0);
                        jSONObject2.put(KSTEConst.MSP_BCVERS_BITS, 32);
                        jSONObject2.put(KSTEConst.MSP_BCVERS_CDN_URL, "");
                        jSONObject2.put(KSTEConst.MSP_BCVERS_FILE_MD5, fileFromAssets.second);
                        jSONObject2.put(KSTEConst.MSP_BCVERS_VMBCPATH, ((File) fileFromAssets.first).getAbsolutePath());
                        jSONArray2.put(jSONObject2);
                        this.bcPluginStatus.add(new BitcodeHistory(((ForwardBiz) this.fwBizIds.get(i)).getBizId(), 0, 32, "", "", false, false, new ConditionVariable(false), false));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        for (String str : TEInterface.initVM(this.mInitParams.context(), jSONArray2.toString())) {
            String str2 = str.split("\\|")[0];
            boolean zEquals = str.split("\\|")[1].equals("1");
            for (BitcodeHistory bitcodeHistory : this.bcPluginStatus) {
                if (bitcodeHistory.getVmBizId().equals(str2)) {
                    bitcodeHistory.setLoadFinishStatus(zEquals);
                    bitcodeHistory.setDoLoaded(true);
                }
            }
        }
        this.isLoadding = false;
        this.isInitialize = true;
        this.kSecurityCV.open();
        this.syncInitializeCV.open();
        return this.SDK_INIT_RET_SUCCESS;
    }

    public final void setBcPluginStatus(List list) {
        this.bcPluginStatus = list;
    }

    public final void setFwBizIds(List list) {
        this.fwBizIds = list;
    }

    public final void setMInitParams(InitCommonKSTEParams initCommonKSTEParams) {
        this.mInitParams = initCommonKSTEParams;
    }

    public final void setPreHistoryBCVersConfig(String str) {
        this.preHistoryBCVersConfig = str;
    }

    public final void setPreInterpHistory(InterpHistory interpHistory) {
        this.preInterpHistory = interpHistory;
    }

    public final void setReenLock(ReentrantLock reentrantLock) {
        this.reenLock = reentrantLock;
    }
}
