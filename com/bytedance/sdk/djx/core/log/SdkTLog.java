package com.bytedance.sdk.djx.core.log;

import com.baidu.mobstat.forbes.Config;
import com.bytedance.sdk.djx.core.log.ILogConst;
import com.bytedance.sdk.djx.model.DJXDramaUnlockAdMode;
import com.bytedance.sdk.djx.model.DJXDramaUnlockMethod;
import com.bytedance.sdk.djx.model.Drama;
import com.bytedance.sdk.djx.params.DJXWidgetDramaDetailParams;
import io.reactivex.annotations.SchedulerSupport;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SdkTLog.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 #2\u00020\u0001:\u0001#B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ\u0016\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\tJ*\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005J*\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\fJW\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u001a\u001a\u00020\f¢\u0006\u0002\u0010 J\u001c\u0010!\u001a\u00020\u00072\u0014\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0004J\f\u0010\"\u001a\u00020\u0005*\u00020\u0019H\u0002J\f\u0010\"\u001a\u00020\u0005*\u00020\u0017H\u0002R\u001c\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/bytedance/sdk/djx/core/log/SdkTLog;", "", "()V", "commonParams", "", "", "sendDeleteCustomDrawAd", "", "adPosition", "", "sendGetCustomDrawAd", "isEmpty", "", "sendPageEvent", "pageScene", "eventName", "drama", "Lcom/bytedance/sdk/djx/model/Drama;", "fromScene", "sendUnlockBegin", "skitId", "", "unlockMethod", "Lcom/bytedance/sdk/djx/model/DJXDramaUnlockMethod;", "adMode", "Lcom/bytedance/sdk/djx/model/DJXDramaUnlockAdMode;", "isContinuesMode", "sendUnlockEnd", "isSuccess", "duration", "lockSet", "memberPeriod", "(ZJJLcom/bytedance/sdk/djx/model/DJXDramaUnlockMethod;Lcom/bytedance/sdk/djx/model/DJXDramaUnlockAdMode;Ljava/lang/Integer;Ljava/lang/Long;Z)V", "setParams", "toLog", "Companion", "sdk_core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class SdkTLog {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "DJXSdkTLog";
    private Map<String, ? extends Object> commonParams;

    /* compiled from: SdkTLog.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[DJXDramaUnlockMethod.values().length];
            iArr[DJXDramaUnlockMethod.METHOD_AD.ordinal()] = 1;
            iArr[DJXDramaUnlockMethod.METHOD_PAY_SKIT.ordinal()] = 2;
            iArr[DJXDramaUnlockMethod.METHOD_PAY_MEMBER.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[DJXDramaUnlockAdMode.values().length];
            iArr2[DJXDramaUnlockAdMode.MODE_COMMON.ordinal()] = 1;
            iArr2[DJXDramaUnlockAdMode.MODE_SPECIFIC.ordinal()] = 2;
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    /* compiled from: SdkTLog.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/bytedance/sdk/djx/core/log/SdkTLog$Companion;", "", "()V", "TAG", "", "getEnterScene", "enterFrom", "Lcom/bytedance/sdk/djx/params/DJXWidgetDramaDetailParams$DJXDramaEnterFrom;", "sdk_core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {

        /* compiled from: SdkTLog.kt */
        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[DJXWidgetDramaDetailParams.DJXDramaEnterFrom.values().length];
                iArr[DJXWidgetDramaDetailParams.DJXDramaEnterFrom.DEFAULT.ordinal()] = 1;
                iArr[DJXWidgetDramaDetailParams.DJXDramaEnterFrom.SKIT_MIXED.ordinal()] = 2;
                iArr[DJXWidgetDramaDetailParams.DJXDramaEnterFrom.DRAMA_HOME.ordinal()] = 3;
                iArr[DJXWidgetDramaDetailParams.DJXDramaEnterFrom.DRAMA_HOME_RECENTLY_WATCHED.ordinal()] = 4;
                iArr[DJXWidgetDramaDetailParams.DJXDramaEnterFrom.DRAMA_HISTORY.ordinal()] = 5;
                iArr[DJXWidgetDramaDetailParams.DJXDramaEnterFrom.DRAMA_CARD.ordinal()] = 6;
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
        public final String getEnterScene(DJXWidgetDramaDetailParams.DJXDramaEnterFrom enterFrom) throws NoWhenBranchMatchedException {
            switch (enterFrom == null ? -1 : WhenMappings.$EnumSwitchMapping$0[enterFrom.ordinal()]) {
                case -1:
                case 1:
                    return null;
                case 0:
                default:
                    throw new NoWhenBranchMatchedException();
                case 2:
                    return ILogConst.Params.SCENE_DRAW_PAGE;
                case 3:
                case 4:
                    return "home_page";
                case 5:
                    return ILogConst.Params.SCENE_HISTORY_PAGE;
                case 6:
                    return ILogConst.Params.SCENE_SKIT_CARD;
            }
        }
    }

    public final void setParams(Map<String, ? extends Object> commonParams) {
        this.commonParams = commonParams;
    }

    public final void sendPageEvent(String pageScene, String eventName, Drama drama, String fromScene) {
        Intrinsics.checkNotNullParameter(pageScene, "pageScene");
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        BLogAgent bLogAgentBuild = BLogAgent.build(null, eventName, this.commonParams);
        bLogAgentBuild.putString("page_scene", pageScene);
        if (fromScene != null) {
            bLogAgentBuild.putString("from_scene", fromScene);
        }
        if (drama != null) {
            bLogAgentBuild.putString(ILogConst.Keys.KEY_SKIT_ID, String.valueOf(drama.id));
            bLogAgentBuild.putString("class", drama.type);
            bLogAgentBuild.putString(Config.EXCEPTION_MEMORY_TOTAL, String.valueOf(drama.total));
            bLogAgentBuild.putString("unlock_index", String.valueOf(drama.unlockIndex));
        }
        bLogAgentBuild.send();
    }

    public static /* synthetic */ void sendUnlockBegin$default(SdkTLog sdkTLog, long j, DJXDramaUnlockMethod dJXDramaUnlockMethod, DJXDramaUnlockAdMode dJXDramaUnlockAdMode, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            dJXDramaUnlockAdMode = null;
        }
        sdkTLog.sendUnlockBegin(j, dJXDramaUnlockMethod, dJXDramaUnlockAdMode, z);
    }

    public final void sendUnlockBegin(long skitId, DJXDramaUnlockMethod unlockMethod, DJXDramaUnlockAdMode adMode, boolean isContinuesMode) {
        Intrinsics.checkNotNullParameter(unlockMethod, "unlockMethod");
        BLogAgent bLogAgentBuild = BLogAgent.build(null, ILogConst.EVENT_UNLOCK_BEGIN, this.commonParams);
        bLogAgentBuild.putString(ILogConst.Keys.KEY_SKIT_ID, String.valueOf(skitId));
        bLogAgentBuild.putString("unlock_method", toLog(unlockMethod));
        if (adMode != null) {
            bLogAgentBuild.putString("ad_type", toLog(adMode));
        }
        bLogAgentBuild.putString("unlock_type", isContinuesMode ? "continuous" : "common");
        bLogAgentBuild.send();
    }

    public final void sendUnlockEnd(boolean isSuccess, long skitId, long duration, DJXDramaUnlockMethod unlockMethod, DJXDramaUnlockAdMode adMode, Integer lockSet, Long memberPeriod, boolean isContinuesMode) {
        Intrinsics.checkNotNullParameter(unlockMethod, "unlockMethod");
        BLogAgent bLogAgentBuild = BLogAgent.build(null, ILogConst.EVENT_UNLOCK_END, this.commonParams);
        bLogAgentBuild.putInt("success", isSuccess ? 1 : 0);
        bLogAgentBuild.putString(ILogConst.Keys.KEY_SKIT_ID, String.valueOf(skitId));
        bLogAgentBuild.putString("duration", String.valueOf(duration));
        bLogAgentBuild.putString("unlock_method", toLog(unlockMethod));
        bLogAgentBuild.putString("unlock_type", isContinuesMode ? "continuous" : "common");
        if (adMode != null) {
            bLogAgentBuild.putString("ad_type", toLog(adMode));
        }
        if (lockSet != null) {
            lockSet.intValue();
            bLogAgentBuild.putString("count", lockSet.toString());
        }
        if (memberPeriod != null) {
            memberPeriod.longValue();
            bLogAgentBuild.putString("minutes", memberPeriod.toString());
        }
        bLogAgentBuild.send();
    }

    public final void sendGetCustomDrawAd(boolean isEmpty, int adPosition) {
        BLogAgent bLogAgentBuild = BLogAgent.build(null, ILogConst.EVENT_GET_CUSTOM_DRAW_AD, this.commonParams);
        bLogAgentBuild.putInt("is_empty", isEmpty ? 1 : 0);
        bLogAgentBuild.putInt("ad_index", adPosition);
        bLogAgentBuild.send();
    }

    public final void sendDeleteCustomDrawAd(int adPosition) {
        BLogAgent bLogAgentBuild = BLogAgent.build(null, ILogConst.EVENT_DELETE_CUSTOM_DRAW_AD, this.commonParams);
        bLogAgentBuild.putInt("ad_index", adPosition);
        bLogAgentBuild.send();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    private final String toLog(DJXDramaUnlockMethod dJXDramaUnlockMethod) throws NoWhenBranchMatchedException {
        int i = WhenMappings.$EnumSwitchMapping$0[dJXDramaUnlockMethod.ordinal()];
        if (i == 1) {
            return "ad";
        }
        if (i == 2) {
            return "pay_skit";
        }
        if (i == 3) {
            return "pay_member";
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: kotlin.NoWhenBranchMatchedException */
    private final String toLog(DJXDramaUnlockAdMode dJXDramaUnlockAdMode) throws NoWhenBranchMatchedException {
        int i = WhenMappings.$EnumSwitchMapping$1[dJXDramaUnlockAdMode.ordinal()];
        if (i == 1) {
            return "sdk";
        }
        if (i == 2) {
            return SchedulerSupport.CUSTOM;
        }
        throw new NoWhenBranchMatchedException();
    }
}
