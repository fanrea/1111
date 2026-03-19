package com.kwad.sdk.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.kwad.sdk.R;
import java.math.BigDecimal;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class KSRatingBar extends LinearLayout {
    private boolean cpB;
    private boolean cpC;
    private int cpD;
    private int cpE;
    private a cpF;
    private float cpG;
    private float cpH;
    private float cpI;
    private Drawable cpJ;
    private Drawable cpK;
    private Drawable cpL;
    private boolean cpM;
    private int y;

    public interface a {
    }

    static /* synthetic */ int e(KSRatingBar kSRatingBar) {
        int i = kSRatingBar.y;
        kSRatingBar.y = i + 1;
        return i;
    }

    public void setStarHalfDrawable(Drawable drawable) {
        this.cpL = drawable;
    }

    public void setOnRatingChangeListener(a aVar) {
        this.cpF = aVar;
    }

    public void setmClickable(boolean z) {
        this.cpB = z;
    }

    public void setStarFillDrawable(Drawable drawable) {
        this.cpK = drawable;
    }

    public void setStarEmptyDrawable(Drawable drawable) {
        this.cpJ = drawable;
    }

    public void setStarImageWidth(float f) {
        this.cpG = f;
    }

    public void setStarImageHeight(float f) {
        this.cpH = f;
    }

    public void setTotalStarCount(int i) {
        this.cpD = i;
    }

    public void setImagePadding(float f) {
        this.cpI = f;
    }

    public KSRatingBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.y = 1;
        this.cpM = false;
        setOrientation(0);
        setDividerDrawable(getResources().getDrawable(R.drawable.ksad_reward_apk_stars_divider));
        setShowDividers(2);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ksad_KSRatingBar);
        this.cpL = typedArrayObtainStyledAttributes.getDrawable(R.styleable.ksad_KSRatingBar_ksad_starHalf);
        this.cpJ = typedArrayObtainStyledAttributes.getDrawable(R.styleable.ksad_KSRatingBar_ksad_starEmpty);
        this.cpK = typedArrayObtainStyledAttributes.getDrawable(R.styleable.ksad_KSRatingBar_ksad_starFill);
        this.cpG = typedArrayObtainStyledAttributes.getDimension(R.styleable.ksad_KSRatingBar_ksad_starImageWidth, 60.0f);
        this.cpH = typedArrayObtainStyledAttributes.getDimension(R.styleable.ksad_KSRatingBar_ksad_starImageHeight, 120.0f);
        this.cpI = typedArrayObtainStyledAttributes.getDimension(R.styleable.ksad_KSRatingBar_ksad_starImagePadding, 15.0f);
        this.cpD = typedArrayObtainStyledAttributes.getInteger(R.styleable.ksad_KSRatingBar_ksad_totalStarCount, 5);
        this.cpE = typedArrayObtainStyledAttributes.getInteger(R.styleable.ksad_KSRatingBar_ksad_starCount, 5);
        this.cpB = typedArrayObtainStyledAttributes.getBoolean(R.styleable.ksad_KSRatingBar_ksad_clickable, true);
        this.cpC = typedArrayObtainStyledAttributes.getBoolean(R.styleable.ksad_KSRatingBar_ksad_halfstart, false);
        for (int i = 0; i < this.cpD; i++) {
            ImageView imageViewY = y(context, this.cpM);
            imageViewY.setOnClickListener(new View.OnClickListener() { // from class: com.kwad.sdk.widget.KSRatingBar.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    if (KSRatingBar.this.cpB) {
                        if (KSRatingBar.this.cpC) {
                            if (KSRatingBar.this.y % 2 == 0) {
                                KSRatingBar.this.setStar(r0.indexOfChild(view) + 1.0f);
                            } else {
                                KSRatingBar.this.setStar(r0.indexOfChild(view) + 0.5f);
                            }
                            if (KSRatingBar.this.cpF != null) {
                                if (KSRatingBar.this.y % 2 == 0) {
                                    a unused = KSRatingBar.this.cpF;
                                    KSRatingBar.this.indexOfChild(view);
                                    KSRatingBar.e(KSRatingBar.this);
                                    return;
                                } else {
                                    a unused2 = KSRatingBar.this.cpF;
                                    KSRatingBar.this.indexOfChild(view);
                                    KSRatingBar.e(KSRatingBar.this);
                                    return;
                                }
                            }
                            return;
                        }
                        KSRatingBar.this.setStar(r0.indexOfChild(view) + 1.0f);
                        if (KSRatingBar.this.cpF != null) {
                            a unused3 = KSRatingBar.this.cpF;
                            KSRatingBar.this.indexOfChild(view);
                        }
                    }
                }
            });
            addView(imageViewY);
        }
        setStar(this.cpE);
    }

    private ImageView y(Context context, boolean z) {
        ImageView imageView = new ImageView(context);
        imageView.setLayoutParams(new ViewGroup.LayoutParams(Math.round(this.cpG), Math.round(this.cpH)));
        imageView.setPadding(0, 0, Math.round(this.cpI), 0);
        if (z) {
            imageView.setImageDrawable(this.cpJ);
        } else {
            imageView.setImageDrawable(this.cpK);
        }
        return imageView;
    }

    public void setStar(float f) {
        int i = (int) f;
        float fFloatValue = new BigDecimal(Float.toString(f)).subtract(new BigDecimal(Integer.toString(i))).floatValue();
        int i2 = this.cpD;
        float f2 = i > i2 ? i2 : i;
        if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        for (int i3 = 0; i3 < f2; i3++) {
            ((ImageView) getChildAt(i3)).setImageDrawable(this.cpK);
        }
        if (fFloatValue > 0.0f) {
            ((ImageView) getChildAt(i)).setImageDrawable(this.cpL);
            int i4 = this.cpD;
            while (true) {
                i4--;
                if (i4 < 1.0f + f2) {
                    return;
                } else {
                    ((ImageView) getChildAt(i4)).setImageDrawable(this.cpJ);
                }
            }
        } else {
            int i5 = this.cpD;
            while (true) {
                i5--;
                if (i5 < f2) {
                    return;
                } else {
                    ((ImageView) getChildAt(i5)).setImageDrawable(this.cpJ);
                }
            }
        }
    }
}
