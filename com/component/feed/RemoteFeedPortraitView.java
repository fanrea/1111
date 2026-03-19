package com.component.feed;

import android.content.Context;
import android.widget.RelativeLayout;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class15.dex */
public final class RemoteFeedPortraitView extends RelativeLayout {
    private a a;
    private IFeedPortraitListener b;
    private boolean c;
    private int d;
    private int e;
    private int f;
    private boolean g;

    public RemoteFeedPortraitView(Context context) {
        super(context);
        this.c = false;
        this.d = 2;
        this.e = -16777216;
        this.f = -1;
        this.g = false;
    }

    public void setAdData(Object obj) {
        if (obj != null) {
            try {
                com.baidu.mobads.container.a.d dVar = new com.baidu.mobads.container.a.d(obj);
                int mainPicWidth = dVar.getMainPicWidth();
                int mainPicHeight = dVar.getMainPicHeight();
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                if ("pvideo".equals(dVar.o()) && mainPicHeight > mainPicWidth) {
                    if (this.a == null) {
                        this.a = new au(getContext());
                        addView(this.a, layoutParams);
                    }
                } else if (!"feed".equals(dVar.o()) || mainPicWidth <= mainPicHeight) {
                    if ("pvideo".equals(dVar.o())) {
                        if (this.a == null) {
                            this.a = new au(getContext());
                            addView(this.a, layoutParams);
                        }
                    } else if (this.a == null) {
                        this.a = new aw(getContext());
                        addView(this.a, layoutParams);
                    }
                } else if (this.a == null) {
                    this.a = new aw(getContext());
                    addView(this.a, layoutParams);
                }
                this.a.d(this.c);
                this.a.c(this.e);
                this.a.d(this.f);
                this.a.e(this.d);
                this.a.c(obj);
                this.a.d(this.c);
                this.a.f(this.g);
                if (this.b != null) {
                    this.a.a(this.b);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void setCpuAdData(Object obj) {
        if (obj != null) {
            try {
                if (this.a == null) {
                    this.a = new m(getContext());
                    addView(this.a, new RelativeLayout.LayoutParams(-1, -1));
                }
                this.a.c(obj);
                if (this.b != null) {
                    this.a.a(this.b);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void setFeedPortraitListener(IFeedPortraitListener iFeedPortraitListener) {
        if (this.a != null) {
            this.a.a(iFeedPortraitListener);
        } else {
            this.b = iFeedPortraitListener;
        }
    }

    public void play() {
        if (this.a != null) {
            this.a.l();
        }
    }

    public void pause() {
        if (this.a != null) {
            this.a.g(true);
            this.a.m();
        }
    }

    public void resume() {
        if (this.a != null) {
            this.a.g(false);
            this.a.n();
        }
    }

    public void stop() {
        if (this.a != null) {
            this.a.s();
        }
    }

    public void setVideoMute(boolean z) {
        if (this.a != null) {
            this.a.a(z);
        }
    }

    public void userSetVideoMute(boolean z) {
        if (this.a != null) {
            this.a.b(z);
        }
    }

    public void seekTo(int i) {
        if (this.a != null) {
            this.a.b(i);
        }
    }

    public void setPlayBackSpeed(float f) {
        if (this.a != null) {
            this.a.a(f);
        }
    }

    public boolean isPlaying() {
        return this.a != null && this.a.x();
    }

    public long getCurrentPosition() {
        if (this.a != null) {
            return this.a.y();
        }
        return 0L;
    }

    public long getDuration() {
        if (this.a != null) {
            return this.a.z();
        }
        return 0L;
    }

    public void setCanClickVideo(boolean z) {
        if (this.a != null) {
            this.a.e(z);
        }
    }

    public boolean isShowEndFrame() {
        return this.a != null && this.a.A();
    }

    public void setShowProgressBar(boolean z) {
        this.c = z;
        if (this.a != null) {
            this.a.d(z);
        }
    }

    public void setProgressBackgroundColor(int i) {
        this.e = i;
        if (this.a != null) {
            this.a.c(i);
        }
    }

    public void setProgressBarColor(int i) {
        this.f = i;
        if (this.a != null) {
            this.a.d(i);
        }
    }

    public void setProgressHeightDp(int i) {
        this.d = i;
        if (this.a != null) {
            this.a.e(i);
        }
    }

    public void showNormalPic(Object obj) {
    }

    public void showFeedVideoCover(Object obj) {
        if (this.a != null) {
            this.a.e(obj);
        }
    }

    public void hidePauseBtn(Object obj) {
        if (this.a != null) {
            this.a.g(obj);
        }
    }

    public void hideFeedCoverPic(Object obj) {
        if (this.a != null) {
            this.a.C();
        }
    }

    public void handleCover(Object obj) {
        if (this.a != null) {
            this.a.b(obj);
        }
    }

    public void setUseDownloadFrame(boolean z) {
        this.g = z;
        if (this.a != null) {
            this.a.f(z);
        }
    }
}
