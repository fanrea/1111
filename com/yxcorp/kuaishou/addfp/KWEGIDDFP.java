package com.yxcorp.kuaishou.addfp;

import android.content.Context;
import android.os.Build;
import android.os.ConditionVariable;
import android.text.TextUtils;
import android.util.Pair;
import com.github.lzyzsd.library.BuildConfig;
import com.kuaishou.security.kste.export.KSTEApi;
import com.kuaishou.security.kste.logic.base.InitCommonKSTEParams;
import com.yxcorp.kuaishou.addfp.android.Orange;
import com.yxcorp.kuaishou.addfp.android.a.d;
import com.yxcorp.kuaishou.addfp.android.a.e;
import com.yxcorp.kuaishou.addfp.android.b.f;
import java.util.LinkedHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex */
public class KWEGIDDFP {
    private static final int EGID_LENGTH = 64;
    public static final int ERROR_TYPE_ACCESS_EXPTION = -1;
    public static final int ERROR_TYPE_NULL = -3;
    public static final int ERROR_TYPE_PROCESS = -4;
    public static final int ERROR_TYPE_UNKNOW = -2;
    private static int PROCESSALLOW = -1;
    private static String adBizid = "1e785005-09c5-42fb-9b5d-f66da1b3640d";
    private static String adEncBizId = "fad53b68-1781-4fc7-968e-d93582d35cce";
    private static String appkey = "adsense";
    private static boolean isKsteInit = false;
    private static String kpn = "ad";
    private ConditionVariable invokeInitCV;
    private volatile boolean isInitialize;
    private volatile boolean isLoadding;
    private volatile boolean isRetryed;
    private ConditionVariable kSecurityCV;
    private ResponseDfpCallback mCallBack;
    private String mEgid;
    private String mLocal;
    private Context mParamContext;
    private String mPkgName;
    private boolean mUserAgree;
    private Lock reentrantLock;

    private KWEGIDDFP() {
        this.mPkgName = "";
        this.mEgid = "";
        this.mLocal = "";
        this.mUserAgree = false;
        this.kSecurityCV = new ConditionVariable();
        this.isInitialize = false;
        this.isLoadding = false;
        this.isRetryed = false;
        this.invokeInitCV = new ConditionVariable();
        this.reentrantLock = new ReentrantLock();
    }

    /* synthetic */ KWEGIDDFP(a aVar) {
        this();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getEGid(ResponseDfpCallback responseDfpCallback) {
        try {
            getEGidImpl(new e(this.mParamContext).a());
            this.mLocal = com.yxcorp.kuaishou.addfp.android.a.c.c().a(this.mParamContext, responseDfpCallback, TextUtils.isEmpty(this.mEgid));
            if (responseDfpCallback == null) {
                return;
            }
            if (!TextUtils.isEmpty(this.mEgid) || (!TextUtils.isEmpty(this.mLocal) && !this.mLocal.startsWith("KWE"))) {
                responseDfpCallback.onSuccess(this.mEgid, this.mLocal);
            } else {
                if (this.mLocal.equals("KWE_PE")) {
                    return;
                }
                responseDfpCallback.onFailed(-2, "need check");
            }
        } catch (Throwable th) {
            if (responseDfpCallback != null) {
                try {
                    responseDfpCallback.onFailed(-1, f.a(th));
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
        }
    }

    private void getEGidImpl(boolean z) {
        Object obj;
        try {
            Pair pairA = d.a(this.mParamContext).a();
            if (pairA != null && (obj = pairA.second) != null) {
                String str = (String) ((ConcurrentHashMap) obj).get("cache_e");
                if (!TextUtils.isEmpty(str)) {
                    this.mEgid = str;
                }
            }
            if (TextUtils.isEmpty(this.mEgid)) {
                try {
                    String strA = Build.VERSION.SDK_INT < 29 ? com.yxcorp.kuaishou.addfp.d.a.a.a(this.mParamContext, "k_w_o_d_out_dtt") : null;
                    String strA2 = (TextUtils.isEmpty(strA) && !d.a(this.mParamContext).b() && f.a(this.mParamContext, new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"})) ? d.a(this.mParamContext).a("Lm91a2R0ZnQ=") : "";
                    if (TextUtils.isEmpty(strA) && TextUtils.isEmpty(strA2)) {
                        return;
                    }
                    LinkedHashMap linkedHashMapB = d.a(this.mParamContext).b(strA);
                    if (linkedHashMapB == null || linkedHashMapB.size() == 0) {
                        linkedHashMapB = d.a(this.mParamContext).b(strA2);
                    }
                    if (linkedHashMapB == null || linkedHashMapB.size() <= 0) {
                        return;
                    }
                    String str2 = (String) linkedHashMapB.get(com.yxcorp.kuaishou.addfp.android.a.c.c().a());
                    if (TextUtils.isEmpty(str2)) {
                        return;
                    }
                    this.mEgid = str2;
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static KWEGIDDFP instance() {
        return c.a;
    }

    public synchronized byte[] doEncrypt(Context context, byte[] bArr) {
        byte[] magicWrapper = new byte[0];
        if (context == null || bArr.length == 0) {
            return magicWrapper;
        }
        if (isKsteInit) {
            magicWrapper = KSTEApi.invoke(appkey, kpn, adEncBizId, bArr, bArr.length + 200).getResult();
        }
        if (magicWrapper.length == 0) {
            magicWrapper = Orange.getInstance().getMagicWrapper(context, bArr, 0);
        }
        return magicWrapper;
    }

    public synchronized String doSign(Context context, String str) {
        String str2;
        str2 = isKsteInit ? new String(KSTEApi.invoke(appkey, kpn, adBizid, str.getBytes(), 50).getResult()) : "";
        if (str2.isEmpty()) {
            str2 = Orange.getInstance().getClockWrapper(context, str.getBytes(), 20);
        }
        return str2;
    }

    public void getEGidByCallback(Context context, boolean z, ResponseDfpCallback responseDfpCallback) {
        try {
            this.mCallBack = responseDfpCallback;
            this.mParamContext = context;
            this.mUserAgree = z;
            Thread thread = new Thread(new b(this));
            thread.setName("adsence-dfp");
            thread.start();
        } catch (Throwable th) {
            String strA = f.a(th);
            if (responseDfpCallback != null) {
                responseDfpCallback.onFailed(-1, strA);
            }
        }
    }

    public String getEGidLocal(Context context, String str, boolean z) {
        if (TextUtils.isEmpty(this.mEgid)) {
            return null;
        }
        return this.mEgid;
    }

    public Context getParamContext() {
        return this.mParamContext;
    }

    public void ksteInit(Context context) {
        if (this.isInitialize) {
            return;
        }
        this.invokeInitCV.open();
        this.isLoadding = true;
        InitCommonKSTEParams.Builder builder = InitCommonKSTEParams.builder();
        builder.appkey(appkey).context(context).did("").userId("17373383838111").appKPN(kpn).appVer(BuildConfig.VERSION_NAME).initCallback(new a(this));
        KSTEApi.registerBizId(appkey, kpn, adBizid);
        KSTEApi.registerBizId(appkey, kpn, adEncBizId);
        KSTEApi.initialize(builder);
        isKsteInit = true;
    }

    public boolean setEgid(Context context, String str) {
        if (TextUtils.isEmpty(str) || !str.startsWith("DFP") || str.length() != 64) {
            return false;
        }
        d.a(context).a(str, "");
        return true;
    }

    public void setLog(boolean z) {
        f.a(z);
    }
}
