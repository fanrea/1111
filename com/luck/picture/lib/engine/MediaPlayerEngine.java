package com.luck.picture.lib.engine;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.View;
import com.luck.picture.lib.config.PictureMimeType;
import com.luck.picture.lib.config.SelectorProviders;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.interfaces.OnPlayerListener;
import com.luck.picture.lib.widget.MediaPlayerView;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class MediaPlayerEngine implements VideoPlayerEngine<MediaPlayerView> {
    private final CopyOnWriteArrayList<OnPlayerListener> listeners = new CopyOnWriteArrayList<>();

    @Override // com.luck.picture.lib.engine.VideoPlayerEngine
    public View onCreateVideoPlayer(Context context) {
        return new MediaPlayerView(context);
    }

    @Override // com.luck.picture.lib.engine.VideoPlayerEngine
    public void onStarPlayer(MediaPlayerView mediaPlayerView, LocalMedia localMedia) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        String availablePath = localMedia.getAvailablePath();
        MediaPlayer mediaPlayer = mediaPlayerView.getMediaPlayer();
        mediaPlayerView.getSurfaceView().setZOrderOnTop(PictureMimeType.isHasHttp(availablePath));
        mediaPlayer.setLooping(SelectorProviders.getInstance().getSelectorConfig().isLoopAutoPlay);
        mediaPlayerView.start(availablePath);
    }

    @Override // com.luck.picture.lib.engine.VideoPlayerEngine
    public void onResume(MediaPlayerView mediaPlayerView) throws IllegalStateException {
        MediaPlayer mediaPlayer = mediaPlayerView.getMediaPlayer();
        if (mediaPlayer != null) {
            mediaPlayer.start();
        }
    }

    @Override // com.luck.picture.lib.engine.VideoPlayerEngine
    public void onPause(MediaPlayerView mediaPlayerView) throws IllegalStateException {
        MediaPlayer mediaPlayer = mediaPlayerView.getMediaPlayer();
        if (mediaPlayer != null) {
            mediaPlayer.pause();
        }
    }

    @Override // com.luck.picture.lib.engine.VideoPlayerEngine
    public boolean isPlaying(MediaPlayerView mediaPlayerView) {
        MediaPlayer mediaPlayer = mediaPlayerView.getMediaPlayer();
        return mediaPlayer != null && mediaPlayer.isPlaying();
    }

    @Override // com.luck.picture.lib.engine.VideoPlayerEngine
    public void addPlayListener(OnPlayerListener onPlayerListener) {
        if (this.listeners.contains(onPlayerListener)) {
            return;
        }
        this.listeners.add(onPlayerListener);
    }

    @Override // com.luck.picture.lib.engine.VideoPlayerEngine
    public void removePlayListener(OnPlayerListener onPlayerListener) {
        if (onPlayerListener != null) {
            this.listeners.remove(onPlayerListener);
        } else {
            this.listeners.clear();
        }
    }

    @Override // com.luck.picture.lib.engine.VideoPlayerEngine
    public void onPlayerAttachedToWindow(final MediaPlayerView mediaPlayerView) {
        MediaPlayer mediaPlayerInitMediaPlayer = mediaPlayerView.initMediaPlayer();
        mediaPlayerInitMediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() { // from class: com.luck.picture.lib.engine.MediaPlayerEngine.1
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(MediaPlayer mediaPlayer) throws IllegalStateException {
                mediaPlayer.start();
                for (int i = 0; i < MediaPlayerEngine.this.listeners.size(); i++) {
                    ((OnPlayerListener) MediaPlayerEngine.this.listeners.get(i)).onPlayerReady();
                }
            }
        });
        mediaPlayerInitMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.luck.picture.lib.engine.MediaPlayerEngine.2
            @Override // android.media.MediaPlayer.OnCompletionListener
            public void onCompletion(MediaPlayer mediaPlayer) {
                mediaPlayer.reset();
                for (int i = 0; i < MediaPlayerEngine.this.listeners.size(); i++) {
                    ((OnPlayerListener) MediaPlayerEngine.this.listeners.get(i)).onPlayerEnd();
                }
                mediaPlayerView.clearCanvas();
            }
        });
        mediaPlayerInitMediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() { // from class: com.luck.picture.lib.engine.MediaPlayerEngine.3
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                for (int i3 = 0; i3 < MediaPlayerEngine.this.listeners.size(); i3++) {
                    ((OnPlayerListener) MediaPlayerEngine.this.listeners.get(i3)).onPlayerError();
                }
                return false;
            }
        });
    }

    @Override // com.luck.picture.lib.engine.VideoPlayerEngine
    public void onPlayerDetachedFromWindow(MediaPlayerView mediaPlayerView) {
        mediaPlayerView.release();
    }

    @Override // com.luck.picture.lib.engine.VideoPlayerEngine
    public void destroy(MediaPlayerView mediaPlayerView) {
        mediaPlayerView.release();
    }
}
