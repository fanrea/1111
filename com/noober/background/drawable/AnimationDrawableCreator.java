package com.noober.background.drawable;

import android.content.res.TypedArray;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import com.noober.background.R;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class AnimationDrawableCreator implements ICreateDrawable {
    private TypedArray animationTa;
    private int duration = 0;
    private AnimationDrawable drawable = new AnimationDrawable();

    public AnimationDrawableCreator(TypedArray typedArray) {
        this.animationTa = typedArray;
    }

    @Override // com.noober.background.drawable.ICreateDrawable
    public Drawable create() throws Exception {
        Drawable drawable;
        for (int i = 0; i < this.animationTa.getIndexCount(); i++) {
            int index = this.animationTa.getIndex(i);
            if (index == R.styleable.bl_anim_bl_duration) {
                this.duration = this.animationTa.getInt(index, 0);
            } else if (index == R.styleable.bl_anim_bl_oneshot) {
                this.drawable.setOneShot(this.animationTa.getBoolean(index, false));
            }
        }
        if (this.animationTa.hasValue(R.styleable.bl_anim_bl_frame_drawable_item0) && (drawable = this.animationTa.getDrawable(R.styleable.bl_anim_bl_frame_drawable_item0)) != null) {
            if (this.animationTa.hasValue(R.styleable.bl_anim_bl_duration_item0)) {
                this.drawable.addFrame(drawable, this.animationTa.getInt(R.styleable.bl_anim_bl_duration_item0, 0));
            } else {
                this.drawable.addFrame(drawable, this.duration);
            }
        }
        addFrame(R.styleable.bl_anim_bl_frame_drawable_item0, R.styleable.bl_anim_bl_duration_item0);
        addFrame(R.styleable.bl_anim_bl_frame_drawable_item1, R.styleable.bl_anim_bl_duration_item1);
        addFrame(R.styleable.bl_anim_bl_frame_drawable_item2, R.styleable.bl_anim_bl_duration_item2);
        addFrame(R.styleable.bl_anim_bl_frame_drawable_item3, R.styleable.bl_anim_bl_duration_item3);
        addFrame(R.styleable.bl_anim_bl_frame_drawable_item4, R.styleable.bl_anim_bl_duration_item4);
        addFrame(R.styleable.bl_anim_bl_frame_drawable_item5, R.styleable.bl_anim_bl_duration_item5);
        addFrame(R.styleable.bl_anim_bl_frame_drawable_item6, R.styleable.bl_anim_bl_duration_item6);
        addFrame(R.styleable.bl_anim_bl_frame_drawable_item7, R.styleable.bl_anim_bl_duration_item7);
        addFrame(R.styleable.bl_anim_bl_frame_drawable_item8, R.styleable.bl_anim_bl_duration_item8);
        addFrame(R.styleable.bl_anim_bl_frame_drawable_item9, R.styleable.bl_anim_bl_duration_item9);
        addFrame(R.styleable.bl_anim_bl_frame_drawable_item10, R.styleable.bl_anim_bl_duration_item10);
        addFrame(R.styleable.bl_anim_bl_frame_drawable_item11, R.styleable.bl_anim_bl_duration_item11);
        addFrame(R.styleable.bl_anim_bl_frame_drawable_item12, R.styleable.bl_anim_bl_duration_item12);
        addFrame(R.styleable.bl_anim_bl_frame_drawable_item13, R.styleable.bl_anim_bl_duration_item13);
        addFrame(R.styleable.bl_anim_bl_frame_drawable_item14, R.styleable.bl_anim_bl_duration_item14);
        return this.drawable;
    }

    private void addFrame(int i, int i2) {
        Drawable drawable;
        if (!this.animationTa.hasValue(i) || (drawable = this.animationTa.getDrawable(i)) == null) {
            return;
        }
        if (this.animationTa.hasValue(i2)) {
            this.drawable.addFrame(drawable, this.animationTa.getInt(i2, 0));
        } else {
            this.drawable.addFrame(drawable, this.duration);
        }
    }
}
