package com.kwad.sdk.crash.report.upload;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class e {
    public static e bON = new e(-11, "Please init.");
    public static e bOO = new e(-12, "error when zip_file");
    public static e bOP = new e(-13, "There is no valid network.");
    public static e bOQ = new e(-14, "Token is invalid.");
    public static e bOR = new e(-15, "upload task execute frequence exceed.");
    public static e bOS = new e(-16, "process request fail.");
    public static e bOT = new e(-17, "sever response error http code");
    public static e bOU = new e(-18, "sever response error result code");
    public static e bOV = new e(-19, "server bad response.");
    private final int bOW;
    private final String bOX;

    private e(int i, String str) {
        this.bOW = i;
        this.bOX = str;
    }

    public final String Ox() {
        return this.bOX;
    }
}
