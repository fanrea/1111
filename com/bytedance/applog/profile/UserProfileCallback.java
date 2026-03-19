package com.bytedance.applog.profile;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public interface UserProfileCallback {
    public static final int NET_ERROR = 1;
    public static final int NOT_SATISFY = 3;
    public static final int NO_NET = 0;
    public static final int REQUEST_LIMIT = 4;
    public static final int RESULT_ERROR = 2;

    void onFail(int i);

    void onSuccess();
}
