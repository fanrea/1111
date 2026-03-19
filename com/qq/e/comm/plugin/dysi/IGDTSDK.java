package com.qq.e.comm.plugin.dysi;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public interface IGDTSDK {
    void bindData(String str);

    void cancelAnimation(String str);

    void clickAdContinued(String str);

    void cod(String str);

    int findViewByTag(String str);

    String gdm();

    @Deprecated
    int getSettingInt(String str);

    int getSettingIntWithDef(String str, int i);

    @Deprecated
    String getSettingString(String str);

    String getSettingStringWithDef(String str, String str2);

    int grt();

    String gti(String str);

    void interactionContinued(String str);

    void loadAd(String str, String str2);

    void log(String str);

    boolean oa(String str);

    void observeDLEngine(String str);

    void pauseTimer();

    void playAnimatableImage(String str);

    void rco(String str);

    void resumeTimer();

    void setEventTimeout(String str, int i);

    void setReducedTime(int i);

    @Deprecated
    void setTimeout(String str, int i);

    void showAnimation(String str);

    void showAnimationFraction(String str, double d);

    @Deprecated
    void tar(int i);

    void tar2(String str);

    void track(String str);

    void ue(String str);

    void vibrateMobilePhone(String str);
}
