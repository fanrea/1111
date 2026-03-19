package com.qq.e.comm.plugin;

import com.qq.e.comm.plugin.dysi.IGDTBiz;
import org.json.JSONException;

/* compiled from: A */
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class18.dex */
class of implements IGDTBiz {
    private final com.qq.e.comm.dynamic.b a;
    private final f5 b;
    private int c;

    /* compiled from: A */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[j40.values().length];
            a = iArr;
            try {
                iArr[j40.UNINITIALIZED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[j40.PREPARED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[j40.PLAY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[j40.STOP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[j40.PAUSE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[j40.END.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[j40.ERROR.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    @Override // com.qq.e.comm.plugin.dysi.IGDTBiz
    public void onDialogDismiss(int i) throws JSONException {
        in.b().a(IGDTBiz.KEY_GDTBIZ, "onDialogDismiss", Integer.valueOf(i)).d().a("event_onDialogDismiss", Integer.valueOf(i)).c().a(this.a, this.b);
    }

    @Override // com.qq.e.comm.plugin.dysi.IGDTBiz
    public void onDialogShow(int i) throws JSONException {
        in.b().a(IGDTBiz.KEY_GDTBIZ, "onDialogShow", Integer.valueOf(i)).d().a("event_onDialogShow", Integer.valueOf(i)).c().a(this.a, this.b);
    }

    @Override // com.qq.e.comm.plugin.dysi.IGDTBiz
    public void onReward(int i) throws JSONException {
        in.b().a(IGDTBiz.KEY_GDTBIZ, "onReward", Integer.valueOf(i)).d().a("event_onReward", Integer.valueOf(i)).c().a(this.a, this.b);
    }

    of(com.qq.e.comm.dynamic.b bVar, h4 h4Var, yq yqVar) {
        this.a = bVar;
        this.b = f5.a(h4Var, yqVar);
    }

    @Override // com.qq.e.comm.plugin.dysi.IGDTBiz
    public void setObserveFlag(int i) {
        this.c = i;
    }

    @Override // com.qq.e.comm.plugin.dysi.IGDTBiz
    public boolean isTimerTickEnable() {
        return (this.c & 1) != 0;
    }

    @Override // com.qq.e.comm.plugin.dysi.IGDTBiz
    public void onTimerTick(long j) throws JSONException {
        if ((this.c & 1) == 0) {
            return;
        }
        in.b().a(IGDTBiz.KEY_GDTBIZ, "onTimerTick", Long.valueOf(j)).d().a("event_onTimerTick", Long.valueOf(j)).c().a(this.a, this.b);
    }

    @Override // com.qq.e.comm.plugin.dysi.IGDTBiz
    public void onPlayStateChange(j40 j40Var, int i) throws JSONException {
        String strA = a(j40Var);
        in.b().a(IGDTBiz.KEY_GDTBIZ, "onPlayStateChange", strA, Integer.valueOf(i)).d().a("event_onPlayStateChange", strA, Integer.valueOf(i)).c().a(this.a, this.b);
    }

    @Override // com.qq.e.comm.plugin.dysi.IGDTBiz
    public void onLandingPageOpen() throws JSONException {
        if ((this.c & 2) == 0) {
            return;
        }
        in.b().a(IGDTBiz.KEY_GDTBIZ, "onLandingPageOpen", new Object[0]).d().a("event_onLandingPageOpen", new Object[0]).c().a(this.a, this.b);
    }

    @Override // com.qq.e.comm.plugin.dysi.IGDTBiz
    public void onLandingPageClose() throws JSONException {
        if ((this.c & 2) == 0) {
            return;
        }
        in.b().a(IGDTBiz.KEY_GDTBIZ, "onLandingPageClose", new Object[0]).d().a("event_onLandingPageClose", new Object[0]).c().a(this.a, this.b);
    }

    @Override // com.qq.e.comm.plugin.dysi.IGDTBiz
    public void onApkStartInstall(String str) throws JSONException {
        if ((this.c & 4) == 0) {
            return;
        }
        in.b().a("event_onApkStartInstall", str).c().a(this.a, this.b);
    }

    @Override // com.qq.e.comm.plugin.dysi.IGDTBiz
    public void onGoAppStore(String str) throws JSONException {
        if ((this.c & 8) == 0) {
            return;
        }
        in.b().a("event_onGoAppStore", str).c().a(this.a, this.b);
    }

    @Override // com.qq.e.comm.plugin.dysi.IGDTBiz
    public void onVideoLandingPageClicked() throws JSONException {
        if ((this.c & 16) == 0) {
            return;
        }
        in.b().a("event_onVideoLandingPageClicked", new Object[0]).c().a(this.a, this.b);
    }

    @Override // com.qq.e.comm.plugin.dysi.IGDTBiz
    public void onViewAppearanceChanged(String str) throws JSONException {
        if (isOnViewAppearanceChangedEnable()) {
            in.b().a("event_onViewAppearanceChanged", str).c().a(this.a, this.b);
        }
    }

    @Override // com.qq.e.comm.plugin.dysi.IGDTBiz
    public boolean isOnViewAppearanceChangedEnable() {
        return (this.c & 64) != 0;
    }

    @Override // com.qq.e.comm.plugin.dysi.IGDTBiz
    public void onBizCustomEventTriggered(String str) throws JSONException {
        if ((this.c & 128) == 0) {
            return;
        }
        in.b().a("event_onBizCustomEventTriggered", str).c().a(this.a, this.b);
    }

    @Override // com.qq.e.comm.plugin.dysi.IGDTBiz
    public void onPageLoadStart(String str) throws JSONException {
        if ((this.c & 256) == 0) {
            return;
        }
        in.b().a("event_onPageLoadStart", str).c().a(this.a, this.b);
    }

    @Override // com.qq.e.comm.plugin.dysi.IGDTBiz
    public void onPageLoadEnd(String str) throws JSONException {
        if ((this.c & 256) == 0) {
            return;
        }
        in.b().a("event_onPageLoadEnd", str).c().a(this.a, this.b);
    }

    private String a(j40 j40Var) {
        if (j40Var == null) {
            return "";
        }
        switch (a.a[j40Var.ordinal()]) {
        }
        return "";
    }
}
