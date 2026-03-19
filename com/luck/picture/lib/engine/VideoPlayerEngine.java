package com.luck.picture.lib.engine;

import android.content.Context;
import android.view.View;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.interfaces.OnPlayerListener;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public interface VideoPlayerEngine<T> {
    void addPlayListener(OnPlayerListener onPlayerListener);

    void destroy(T t);

    boolean isPlaying(T t);

    View onCreateVideoPlayer(Context context);

    void onPause(T t);

    void onPlayerAttachedToWindow(T t);

    void onPlayerDetachedFromWindow(T t);

    void onResume(T t);

    void onStarPlayer(T t, LocalMedia localMedia);

    void removePlayListener(OnPlayerListener onPlayerListener);
}
