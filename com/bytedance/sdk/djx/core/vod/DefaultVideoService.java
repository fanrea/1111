package com.bytedance.sdk.djx.core.vod;

import android.content.Context;
import com.bytedance.sdk.djx.core.business.web.bridge.IFunc;
import com.bytedance.sdk.djx.core.vod.player.AbstractPlayer;
import com.bytedance.sdk.djx.core.vod.player.AndroidPlayer;
import com.bytedance.sdk.djx.model.Feed;
import com.bytedance.sdk.djx.model.VideoM;
import com.sigmob.sdk.base.mta.PointCategory;
import com.ss.texturerender.TextureRenderKeys;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DefaultVideoService.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0014\u001a\u00020\u0010H\u0016J\b\u0010\u0015\u001a\u00020\u0010H\u0016J\u001a\u0010\u0016\u001a\u00020\u000e2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0017\u001a\u00020\bH\u0016J,\u0010\u0016\u001a\u00020\u000e2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0017\u001a\u00020\b2\u0010\u0010\u0018\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\u0019H\u0016J,\u0010\u0016\u001a\u00020\u000e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0017\u001a\u00020\b2\u0010\u0010\u0018\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001b\u0018\u00010\u0019H\u0016J\u001a\u0010\u0016\u001a\u00020\u000e2\u0010\u0010\u001c\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001b\u0018\u00010\u001dH\u0016¨\u0006\u001e"}, d2 = {"Lcom/bytedance/sdk/djx/core/vod/DefaultVideoService;", "Lcom/bytedance/sdk/djx/core/vod/IVideoService;", "()V", "createTTPlayer", "Lcom/bytedance/sdk/djx/core/vod/player/AbstractPlayer;", "context", "Landroid/content/Context;", "getCacheSize", "", "feed", "Lcom/bytedance/sdk/djx/model/Feed;", IFunc.IVK_VERSION, "", PointCategory.INIT, "", "isErrorCodec", "", "errorCode", "", "isErrorRetryable", "isNewPlayer", "isNewPreload", "preload", "size", TextureRenderKeys.KEY_IS_CALLBACK, "Lcom/bytedance/sdk/djx/core/vod/IPreloadCallback;", "videoM", "Lcom/bytedance/sdk/djx/model/VideoM;", "list", "", "base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class DefaultVideoService implements IVideoService {
    @Override // com.bytedance.sdk.djx.core.vod.IVideoService
    public long getCacheSize(Feed feed) {
        return 0L;
    }

    @Override // com.bytedance.sdk.djx.core.vod.IVideoService
    public String getVersion() {
        return "";
    }

    @Override // com.bytedance.sdk.djx.core.vod.IVideoService
    public void init() {
    }

    @Override // com.bytedance.sdk.djx.core.vod.IVideoService
    public boolean isErrorCodec(int errorCode) {
        return false;
    }

    @Override // com.bytedance.sdk.djx.core.vod.IVideoService
    public boolean isErrorRetryable(int errorCode) {
        return false;
    }

    @Override // com.bytedance.sdk.djx.core.vod.IVideoService
    public boolean isNewPlayer() {
        return false;
    }

    @Override // com.bytedance.sdk.djx.core.vod.IVideoService
    public boolean isNewPreload() {
        return false;
    }

    @Override // com.bytedance.sdk.djx.core.vod.IVideoService
    public void preload(Feed feed, long size) {
    }

    @Override // com.bytedance.sdk.djx.core.vod.IVideoService
    public void preload(Feed feed, long size, IPreloadCallback<Feed> callback) {
    }

    @Override // com.bytedance.sdk.djx.core.vod.IVideoService
    public void preload(VideoM videoM, long size, IPreloadCallback<VideoM> callback) {
    }

    @Override // com.bytedance.sdk.djx.core.vod.IVideoService
    public void preload(List<? extends VideoM> list) {
    }

    @Override // com.bytedance.sdk.djx.core.vod.IVideoService
    public AbstractPlayer createTTPlayer(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new AndroidPlayer(context);
    }
}
