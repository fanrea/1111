package com.kwad.components.ct.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.kwad.sdk.core.page.widget.RoundAngleImageView;
import com.kwad.sdk.glide.framesequence.FrameSequence;
import com.kwad.sdk.glide.framesequence.FrameSequenceDrawable;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class WebpAnimationImageView extends RoundAngleImageView {
    private FrameSequenceDrawable baR;
    private a baS;
    private FrameSequenceDrawable.b baT;
    private int mLoopCount;

    public interface a {
    }

    public WebpAnimationImageView(Context context) {
        super(context);
        this.mLoopCount = 1;
    }

    public WebpAnimationImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mLoopCount = 1;
        aP(context);
    }

    public WebpAnimationImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mLoopCount = 1;
        aP(context);
    }

    private void aP(Context context) {
        this.baT = new FrameSequenceDrawable.b() { // from class: com.kwad.components.ct.widget.WebpAnimationImageView.1
            @Override // com.kwad.sdk.glide.framesequence.FrameSequenceDrawable.b
            public final void LF() {
                if (WebpAnimationImageView.this.baS != null) {
                    a unused = WebpAnimationImageView.this.baS;
                }
            }
        };
        com.kwad.components.ct.b.c.init(context);
    }

    public void setWebpStream(FrameSequence frameSequence) {
        if (frameSequence == null) {
            return;
        }
        try {
            FrameSequenceDrawable frameSequenceDrawable = new FrameSequenceDrawable(frameSequence);
            frameSequenceDrawable.setLoopCount(this.mLoopCount);
            frameSequenceDrawable.setOnFinishedListener(this.baT);
            setImageDrawable(frameSequenceDrawable);
            FrameSequenceDrawable frameSequenceDrawable2 = this.baR;
            if (frameSequenceDrawable2 != null) {
                frameSequenceDrawable2.destroy();
            }
            this.baR = frameSequenceDrawable;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setOnFinishedListener(a aVar) {
        this.baS = aVar;
    }
}
