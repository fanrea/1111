package com.alipay.sdk.app;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class2.dex */
public class EnvUtils {
    public static EnvEnum mEnv = EnvEnum.ONLINE;

    public enum EnvEnum {
        ONLINE,
        PRE_SANDBOX,
        SANDBOX
    }

    public static EnvEnum geEnv() {
        return mEnv;
    }

    public static boolean isNewSanBox() {
        return mEnv == EnvEnum.SANDBOX;
    }

    public static boolean isPreSandBox() {
        return mEnv == EnvEnum.PRE_SANDBOX;
    }

    public static boolean isSandBox() {
        return isPreSandBox() || isNewSanBox();
    }

    public static void setEnv(EnvEnum envEnum) {
        mEnv = envEnum;
    }
}
