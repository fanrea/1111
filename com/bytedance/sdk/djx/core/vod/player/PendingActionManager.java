package com.bytedance.sdk.djx.core.vod.player;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class PendingActionManager {
    private boolean executingActions;
    private List<Runnable> pendingActions;

    public void execPendingActions() {
        if (this.executingActions || isPendingActionEmpty()) {
            return;
        }
        this.executingActions = true;
        Iterator it = new ArrayList(this.pendingActions).iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        this.pendingActions.clear();
        this.executingActions = false;
    }

    public void clearPendingActions() {
        if (isPendingActionEmpty()) {
            return;
        }
        this.pendingActions.clear();
    }

    public void enqueueAction(Runnable runnable) {
        if (this.pendingActions == null) {
            this.pendingActions = new ArrayList();
        }
        this.pendingActions.add(runnable);
    }

    public boolean isPendingActionEmpty() {
        List<Runnable> list = this.pendingActions;
        return list == null || list.isEmpty();
    }
}
