package com.bytedance.sdk.djx.core.log;

import android.os.SystemClock;
import androidx.core.app.NotificationCompat;
import com.bytedance.sdk.djx.core.DevInfo;
import com.bytedance.sdk.djx.model.CacheStatus;
import com.bytedance.sdk.djx.utils.LG;
import com.component.a.g.b;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: T2WLog.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u000f\u0018\u0000 /2\u00020\u0001:\u0001/B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u0003H\u0002J\u0010\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u0010\u0010 \u001a\u00020!2\u0006\u0010\u001d\u001a\u00020\u0015H\u0002J\u000e\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020\u000eJ\u0006\u0010$\u001a\u00020!J\u000e\u0010%\u001a\u00020!2\u0006\u0010#\u001a\u00020\u000eJ\u0006\u0010&\u001a\u00020!J*\u0010'\u001a\u00020!2\u0006\u0010(\u001a\u00020\n2\u0006\u0010)\u001a\u00020\u000e2\b\u0010*\u001a\u0004\u0018\u00010\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u0006\u0010+\u001a\u00020!J\u0006\u0010,\u001a\u00020!J\u000e\u0010-\u001a\u00020!2\u0006\u0010.\u001a\u00020\nR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u000f\"\u0004\b\u0018\u0010\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u000f\"\u0004\b\u001c\u0010\u0011¨\u00060"}, d2 = {"Lcom/bytedance/sdk/djx/core/log/T2WLog;", "", "scene", "", "(Ljava/lang/String;)V", "cacheStatus", "Lcom/bytedance/sdk/djx/model/CacheStatus;", "fragmentShowTime", "", "hasFirstFrame", "", "hasLoaded", "initTime", "isFirst", "", "()I", "setFirst", "(I)V", "mIsFragmentShow", "mLogAgentLists", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/bytedance/sdk/djx/core/log/BLogAgent;", "reqRetryNum", "getReqRetryNum", "setReqRetryNum", "taskStartTime", "videoRetryNum", "getVideoRetryNum", "setVideoRetryNum", "agent", NotificationCompat.CATEGORY_EVENT, "getMode", "send", "", "sendFirstFrame", "position", "sendInit", "sendLoad", "sendReqBegin", "sendReqEnd", "success", "code", "msg", "sendTotalLog", "sendViewFinish", "setIsFragmentShow", "isShow", "Companion", "base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class T2WLog {
    public static final int DEFAULT_ERROR_CODE = -4567;
    public static final String SCENE_CARD = "card";
    public static final String SCENE_DRAW = "draw";
    public static final String SCENE_HISTORY = "history";
    public static final String SCENE_HOME = "home";
    public static final String SCENE_NOV_HOME = "nov_home";
    public static final String SCENE_NOV_READER = "nov_reader";
    public static final String SCENE_PLAY = "play";
    public static final String SCENE_SEARCH = "search";
    private CacheStatus cacheStatus;
    private long fragmentShowTime;
    private boolean hasFirstFrame;
    private boolean hasLoaded;
    private long initTime;
    private int isFirst;
    private boolean mIsFragmentShow;
    private CopyOnWriteArrayList<BLogAgent> mLogAgentLists;
    private int reqRetryNum;
    private String scene;
    private long taskStartTime;
    private int videoRetryNum;

    /* JADX WARN: Illegal instructions before constructor call */
    public T2WLog() {
        String str = null;
        this(str, 1, str);
    }

    public T2WLog(String str) {
        Intrinsics.checkNotNullParameter(str, "scene");
        this.scene = str;
        this.mLogAgentLists = new CopyOnWriteArrayList<>();
    }

    public /* synthetic */ T2WLog(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str);
    }

    /* renamed from: isFirst, reason: from getter */
    public final int getIsFirst() {
        return this.isFirst;
    }

    public final void setFirst(int i) {
        this.isFirst = i;
    }

    public final int getReqRetryNum() {
        return this.reqRetryNum;
    }

    public final void setReqRetryNum(int i) {
        this.reqRetryNum = i;
    }

    public final int getVideoRetryNum() {
        return this.videoRetryNum;
    }

    public final void setVideoRetryNum(int i) {
        this.videoRetryNum = i;
    }

    public final void sendInit() {
        this.initTime = SystemClock.elapsedRealtime();
        this.isFirst = 0;
        this.reqRetryNum = 0;
        this.videoRetryNum = 0;
        this.hasFirstFrame = false;
        send(agent("t2_widget_start"));
        this.taskStartTime = SystemClock.elapsedRealtime();
    }

    public final void sendViewFinish() {
        BLogAgent bLogAgentPutLong = agent("t2_widget_view_load_finish").putLong("duration", SystemClock.elapsedRealtime() - this.taskStartTime);
        Intrinsics.checkNotNullExpressionValue(bLogAgentPutLong, "agent");
        send(bLogAgentPutLong);
        this.taskStartTime = SystemClock.elapsedRealtime();
    }

    public final void sendReqBegin() {
        if (this.hasFirstFrame) {
            return;
        }
        BLogAgent bLogAgentPutLong = agent("t2_widget_req_send").putLong("duration", SystemClock.elapsedRealtime() - this.taskStartTime);
        Intrinsics.checkNotNullExpressionValue(bLogAgentPutLong, "agent");
        send(bLogAgentPutLong);
        this.taskStartTime = SystemClock.elapsedRealtime();
    }

    public final void sendReqEnd(boolean success, int code, String msg, CacheStatus cacheStatus) {
        if (this.hasFirstFrame) {
            return;
        }
        BLogAgent bLogAgentPutString = agent("t2_widget_req_callback").putLong("duration", SystemClock.elapsedRealtime() - this.taskStartTime).putString("success", success ? "yes" : b.t).putInt("code", code).putString("msg", msg);
        if (cacheStatus != null) {
            this.cacheStatus = cacheStatus;
            bLogAgentPutString.putInt("drama_cache_status", cacheStatus.getValue());
        }
        Intrinsics.checkNotNullExpressionValue(bLogAgentPutString, "agent");
        send(bLogAgentPutString);
        this.taskStartTime = SystemClock.elapsedRealtime();
    }

    public final void sendLoad(int position) {
        if (this.hasLoaded || this.hasFirstFrame) {
            return;
        }
        BLogAgent bLogAgentPutInt = agent("t2_widget_load_video").putLong("duration", SystemClock.elapsedRealtime() - this.taskStartTime).putInt("pos_index", position);
        CacheStatus cacheStatus = this.cacheStatus;
        if (cacheStatus != null) {
            bLogAgentPutInt.putInt("drama_cache_status", cacheStatus.getValue());
        }
        this.hasLoaded = true;
        Intrinsics.checkNotNullExpressionValue(bLogAgentPutInt, "agent");
        send(bLogAgentPutInt);
        this.taskStartTime = SystemClock.elapsedRealtime();
    }

    public final void sendFirstFrame(int position) {
        if (this.hasFirstFrame) {
            return;
        }
        this.hasFirstFrame = true;
        BLogAgent bLogAgentPutInt = agent("t2_widget_first_frame").putLong("duration", SystemClock.elapsedRealtime() - this.taskStartTime).putInt("pos_index", position);
        CacheStatus cacheStatus = this.cacheStatus;
        if (cacheStatus != null) {
            bLogAgentPutInt.putInt("drama_cache_status", cacheStatus.getValue());
        }
        if (this.mIsFragmentShow) {
            if (this.fragmentShowTime > this.taskStartTime) {
                long jElapsedRealtime = SystemClock.elapsedRealtime() - this.fragmentShowTime;
                bLogAgentPutInt.putLong("duration", jElapsedRealtime);
                bLogAgentPutInt.putLong("total_duration", jElapsedRealtime + (this.taskStartTime - this.initTime));
            }
            bLogAgentPutInt.send();
        } else {
            this.mLogAgentLists.add(bLogAgentPutInt);
        }
        this.taskStartTime = SystemClock.elapsedRealtime();
        this.isFirst++;
    }

    public final void sendTotalLog() {
        this.fragmentShowTime = SystemClock.elapsedRealtime();
        if (this.mLogAgentLists.isEmpty()) {
            return;
        }
        Iterator<T> it = this.mLogAgentLists.iterator();
        while (it.hasNext()) {
            ((BLogAgent) it.next()).send();
        }
        this.mLogAgentLists.clear();
    }

    public final void setIsFragmentShow(boolean isShow) {
        this.mIsFragmentShow = isShow;
    }

    private final BLogAgent agent(String event) {
        String mode = getMode(this.scene);
        BLogAgent bLogAgentBuild = BLogAgent.build("", event, null, mode);
        bLogAgentBuild.putString("dj_scene", this.scene);
        if (this.initTime > 0) {
            long jElapsedRealtime = SystemClock.elapsedRealtime() - this.initTime;
            bLogAgentBuild.putLong("total_duration", jElapsedRealtime);
            LG.d("T2WLog", "event: " + event + ", total_duration: " + jElapsedRealtime + ", drama_cache_status: " + this.cacheStatus);
        }
        bLogAgentBuild.putInt("is_first", getIsFirst());
        bLogAgentBuild.putInt("req_retry_num", getReqRetryNum());
        if (Intrinsics.areEqual(mode, "playlet")) {
            bLogAgentBuild.putInt("video_retry_num", getVideoRetryNum());
        }
        bLogAgentBuild.putString("is_teenager", DevInfo.getPrivacyController().isTeenagerMode() ? "true" : "false");
        Intrinsics.checkNotNullExpressionValue(bLogAgentBuild, "agent");
        return bLogAgentBuild;
    }

    private final void send(BLogAgent agent) {
        if (this.mIsFragmentShow) {
            agent.send();
        } else {
            this.mLogAgentLists.add(agent);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterative(DepthRegionTraversal.java:31)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visit(SwitchOverStringVisitor.java:60)
     */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0047 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0053 A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0056 A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.lang.String getMode(java.lang.String r2) {
        /*
            r1 = this;
            int r0 = r2.hashCode()
            switch(r0) {
                case -1933917843: goto L4a;
                case -906336856: goto L3e;
                case 3046160: goto L35;
                case 3091780: goto L2c;
                case 3208415: goto L23;
                case 3443508: goto L1a;
                case 926934164: goto L11;
                case 1633452041: goto L8;
                default: goto L7;
            }
        L7:
            goto L56
        L8:
            java.lang.String r0 = "nov_home"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L53
            goto L56
        L11:
            java.lang.String r0 = "history"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L47
            goto L56
        L1a:
            java.lang.String r0 = "play"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L47
            goto L56
        L23:
            java.lang.String r0 = "home"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L47
            goto L56
        L2c:
            java.lang.String r0 = "draw"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L47
            goto L56
        L35:
            java.lang.String r0 = "card"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L47
            goto L56
        L3e:
            java.lang.String r0 = "search"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L47
            goto L56
        L47:
            java.lang.String r2 = "playlet"
            goto L58
        L4a:
            java.lang.String r0 = "nov_reader"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L53
            goto L56
        L53:
            java.lang.String r2 = "mini_story"
            goto L58
        L56:
            java.lang.String r2 = ""
        L58:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.djx.core.log.T2WLog.getMode(java.lang.String):java.lang.String");
    }
}
