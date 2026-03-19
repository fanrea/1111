package com.bytedance.sdk.djx.core.vod;

import android.content.Context;
import com.bytedance.sdk.djx.core.business.web.bridge.IFunc;
import com.bytedance.sdk.djx.core.vod.player.AbstractPlayer;
import com.bytedance.sdk.djx.model.Feed;
import com.bytedance.sdk.djx.model.VideoM;
import com.sigmob.sdk.base.mta.PointCategory;
import com.ss.texturerender.TextureRenderKeys;
import java.util.List;
import kotlin.Metadata;

/* compiled from: IVideoService.kt */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH&J\b\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\rH&J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H&J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H&J\b\u0010\u0013\u001a\u00020\u000fH&J\b\u0010\u0014\u001a\u00020\u000fH&J\u001a\u0010\u0015\u001a\u00020\r2\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0016\u001a\u00020\u0007H&J,\u0010\u0015\u001a\u00020\r2\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0016\u001a\u00020\u00072\u0010\u0010\u0017\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u0018H&J,\u0010\u0015\u001a\u00020\r2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0016\u001a\u00020\u00072\u0010\u0010\u0017\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0018\u00010\u0018H&J\u001a\u0010\u0015\u001a\u00020\r2\u0010\u0010\u001b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0018\u00010\u001cH&¨\u0006\u001d"}, d2 = {"Lcom/bytedance/sdk/djx/core/vod/IVideoService;", "", "createTTPlayer", "Lcom/bytedance/sdk/djx/core/vod/player/AbstractPlayer;", "context", "Landroid/content/Context;", "getCacheSize", "", "feed", "Lcom/bytedance/sdk/djx/model/Feed;", IFunc.IVK_VERSION, "", PointCategory.INIT, "", "isErrorCodec", "", "errorCode", "", "isErrorRetryable", "isNewPlayer", "isNewPreload", "preload", "size", TextureRenderKeys.KEY_IS_CALLBACK, "Lcom/bytedance/sdk/djx/core/vod/IPreloadCallback;", "videoM", "Lcom/bytedance/sdk/djx/model/VideoM;", "list", "", "base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public interface IVideoService {
    AbstractPlayer createTTPlayer(Context context);

    long getCacheSize(Feed feed);

    String getVersion();

    void init();

    boolean isErrorCodec(int errorCode);

    boolean isErrorRetryable(int errorCode);

    boolean isNewPlayer();

    boolean isNewPreload();

    void preload(Feed feed, long size);

    void preload(Feed feed, long size, IPreloadCallback<Feed> callback);

    void preload(VideoM videoM, long size, IPreloadCallback<VideoM> callback);

    void preload(List<? extends VideoM> list);
}
