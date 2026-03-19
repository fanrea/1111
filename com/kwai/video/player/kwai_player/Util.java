package com.kwai.video.player.kwai_player;

/* JADX WARN: Classes with same name are omitted:
  D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class17.dex
 */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class Util {
    public static boolean isCriticalErrorInMediaPlayer(int i, int i2) {
        if (i != -5108 && i != -5107 && i != -5104 && i != -5101 && i != -5013 && i != -1010 && i != -1007 && i != -1004 && i != -110 && i != 1 && i != 100 && i != 200) {
            switch (i) {
                case -5011:
                case -5010:
                case -5009:
                case -5008:
                case -5007:
                case -5006:
                case -5005:
                case -5004:
                case -5003:
                case -5002:
                case -5001:
                    break;
                default:
                    if ((i != -5012 || i2 >= 0) && i >= -20000) {
                    }
                    break;
            }
            return true;
        }
        return true;
    }

    public static boolean isHttpForbiddenErrorInMediaPlayer(int i, int i2) {
        return -5007 == i || -2403 == i2;
    }

    public static boolean isMarlinTokenInvalidInMediaPlayer(int i, int i2) {
        return -5122 == i || -5123 == i;
    }
}
