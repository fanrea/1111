package com.kwad.sdk.utils;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Build;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public final class i {
    private AudioManager bII;
    private AudioManager.OnAudioFocusChangeListener clm = new AudioManager.OnAudioFocusChangeListener() { // from class: com.kwad.sdk.utils.i.1
        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public final void onAudioFocusChange(final int i) {
            if (i.this.lW == null) {
                return;
            }
            bx.postOnUiThread(new Runnable() { // from class: com.kwad.sdk.utils.i.1.1
                @Override // java.lang.Runnable
                public final void run() {
                    if (i < 0) {
                        i.this.lW.onAudioBeOccupied();
                    } else {
                        i.this.lW.onAudioBeReleased();
                    }
                }
            });
        }
    };
    private a lW;

    public interface a {
        void onAudioBeOccupied();

        void onAudioBeReleased();
    }

    public i(Context context) {
        this.bII = (AudioManager) context.getSystemService("audio");
    }

    public final boolean anK() {
        try {
            if (this.clm != null && this.bII != null) {
                if (Build.VERSION.SDK_INT >= 26) {
                    return 1 == this.bII.requestAudioFocus(anM());
                }
                if (1 == this.bII.requestAudioFocus(this.clm, 3, 2)) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public final boolean anL() {
        try {
            if (this.clm != null && this.bII != null) {
                if (Build.VERSION.SDK_INT >= 26) {
                    return 1 == this.bII.abandonAudioFocusRequest(anM());
                }
                if (1 == this.bII.abandonAudioFocus(this.clm)) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    private AudioFocusRequest anM() {
        return new AudioFocusRequest.Builder(2).setAudioAttributes(new AudioAttributes.Builder().setLegacyStreamType(3).setUsage(1).setContentType(2).build()).setAcceptsDelayedFocusGain(false).setOnAudioFocusChangeListener(this.clm).build();
    }

    public final void c(a aVar) {
        this.lW = aVar;
    }
}
