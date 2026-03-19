package com.qq.e.comm.plugin;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
public enum j40 {
    ERROR(0),
    UNINITIALIZED(1),
    PREPARED(2),
    PLAY(3),
    STOP(4),
    PAUSE(5),
    END(6);

    int a;

    j40(int i2) {
        this.a = i2;
    }

    public int b() {
        return this.a;
    }

    public static j40 a(int i2) {
        switch (i2) {
            case 1:
                return ERROR;
            case 2:
                return UNINITIALIZED;
            case 3:
                return PLAY;
            case 4:
                return STOP;
            case 5:
                return PAUSE;
            case 6:
                return END;
            default:
                return UNINITIALIZED;
        }
    }
}
