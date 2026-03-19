package com.bytedance.sdk.djx.core.business;

import com.bytedance.sdk.djx.DJXPlaySpeedScope;
import com.bytedance.sdk.djx.core.business.budrama.DramaLog;
import com.bytedance.sdk.djx.model.ev.BEGlobalSpeedUpdate;
import com.bytedance.sdk.djx.utils.SP;
import com.bytedance.sdk.djx.utils.bus.DJXBus;
import com.component.a.a.b;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SpeedPlayManager.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0004J\u0006\u0010\n\u001a\u00020\u0006J\u0006\u0010\u000b\u001a\u00020\u0006J\u0006\u0010\f\u001a\u00020\rJ\u0016\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0011R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/bytedance/sdk/djx/core/business/SpeedPlayManager;", "", "()V", "currentDramaId", "", "dramaSpeed", "", "episodeSpeed", "getDramaSpeed", "id", "getEpisodeSpeed", "getGlobalSpeed", "updateGlobalSpeed", "", "updateSpeed", b.e.a, "speedScope", "Lcom/bytedance/sdk/djx/DJXPlaySpeedScope;", "Companion", "sdk_core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class SpeedPlayManager {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static float globalSpeed;
    private long currentDramaId;
    private float dramaSpeed;
    private float episodeSpeed;

    /* compiled from: SpeedPlayManager.kt */
    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DJXPlaySpeedScope.values().length];
            iArr[DJXPlaySpeedScope.DJX_VIDEO_SPEED_SCOPE_DRAMA.ordinal()] = 1;
            iArr[DJXPlaySpeedScope.DJX_VIDEO_SPEED_SCOPE_EPISODE.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @JvmStatic
    public static final void setGlobalSpeed(float f) {
        INSTANCE.setGlobalSpeed(f);
    }

    /* compiled from: SpeedPlayManager.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/bytedance/sdk/djx/core/business/SpeedPlayManager$Companion;", "", "()V", "globalSpeed", "", "setGlobalSpeed", "", "speedPlay", "sdk_core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final void setGlobalSpeed(float speedPlay) {
            SpeedPlayManager.globalSpeed = speedPlay;
            if (speedPlay <= 0.0f) {
                SpeedPlayManager.globalSpeed = 1.0f;
            } else if (speedPlay > 3.0f) {
                SpeedPlayManager.globalSpeed = 3.0f;
            }
            SP.ttPlayerGlobalSpeed().put("djxsdk_tt_player_global_speed", SpeedPlayManager.globalSpeed);
            DJXBus.getInstance().sendEvent(BEGlobalSpeedUpdate.build());
            new DramaLog().sendGlobalSpeed(SpeedPlayManager.globalSpeed);
        }
    }

    public final void updateSpeed(float speed, DJXPlaySpeedScope speedScope) {
        Intrinsics.checkNotNullParameter(speedScope, "speedScope");
        if (speed <= 0.0f) {
            speed = 1.0f;
        } else if (speed > 3.0f) {
            speed = 3.0f;
        }
        int i = WhenMappings.$EnumSwitchMapping$0[speedScope.ordinal()];
        if (i == 1) {
            this.dramaSpeed = speed;
            this.episodeSpeed = speed;
        } else {
            if (i != 2) {
                return;
            }
            this.episodeSpeed = speed;
        }
    }

    public final void updateGlobalSpeed() {
        float f = globalSpeed;
        this.dramaSpeed = f;
        this.episodeSpeed = f;
    }

    public final float getGlobalSpeed() {
        if (globalSpeed == 0.0f) {
            globalSpeed = SP.ttPlayerGlobalSpeed().getFloat("djxsdk_tt_player_global_speed", 1.0f);
        }
        return globalSpeed;
    }

    public final float getEpisodeSpeed() {
        float f = this.episodeSpeed;
        return (f > 0.0f ? 1 : (f == 0.0f ? 0 : -1)) == 0 ? getGlobalSpeed() : f;
    }

    public final float getDramaSpeed(long id) {
        float f = this.dramaSpeed;
        if (!(f == 0.0f) && this.currentDramaId == id) {
            return f;
        }
        this.currentDramaId = id;
        return getGlobalSpeed();
    }
}
