package com.noober.background.drawable;

import android.content.res.TypedArray;
import android.graphics.drawable.StateListDrawable;
import com.noober.background.R;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class6.dex */
public class GradientStateDrawableCreator implements ICreateDrawable {
    private TypedArray typedArray;

    public GradientStateDrawableCreator(TypedArray typedArray) {
        this.typedArray = typedArray;
    }

    @Override // com.noober.background.drawable.ICreateDrawable
    public StateListDrawable create() throws Exception {
        StateListDrawable stateListDrawable = new StateListDrawable();
        if (this.typedArray.hasValue(R.styleable.background_bl_checkable_gradient_startColor) && this.typedArray.hasValue(R.styleable.background_bl_unCheckable_gradient_startColor)) {
            setSelectorDrawable(stateListDrawable, android.R.attr.state_checkable);
            setSelectorDrawable(stateListDrawable, -16842911);
        }
        if (this.typedArray.hasValue(R.styleable.background_bl_checked_gradient_startColor) && this.typedArray.hasValue(R.styleable.background_bl_unChecked_gradient_startColor)) {
            setSelectorDrawable(stateListDrawable, android.R.attr.state_checked);
            setSelectorDrawable(stateListDrawable, -16842912);
        }
        if (this.typedArray.hasValue(R.styleable.background_bl_enabled_gradient_startColor) && this.typedArray.hasValue(R.styleable.background_bl_unEnabled_gradient_startColor)) {
            setSelectorDrawable(stateListDrawable, android.R.attr.state_enabled);
            setSelectorDrawable(stateListDrawable, -16842910);
        }
        if (this.typedArray.hasValue(R.styleable.background_bl_selected_gradient_startColor) && this.typedArray.hasValue(R.styleable.background_bl_unSelected_gradient_startColor)) {
            setSelectorDrawable(stateListDrawable, android.R.attr.state_selected);
            setSelectorDrawable(stateListDrawable, -16842913);
        }
        if (this.typedArray.hasValue(R.styleable.background_bl_pressed_gradient_startColor) && this.typedArray.hasValue(R.styleable.background_bl_unPressed_gradient_startColor)) {
            setSelectorDrawable(stateListDrawable, android.R.attr.state_pressed);
            setSelectorDrawable(stateListDrawable, -16842919);
        }
        if (this.typedArray.hasValue(R.styleable.background_bl_focused_gradient_startColor) && this.typedArray.hasValue(R.styleable.background_bl_unFocused_gradient_startColor)) {
            setSelectorDrawable(stateListDrawable, android.R.attr.state_focused);
            setSelectorDrawable(stateListDrawable, -16842908);
        }
        return stateListDrawable;
    }

    private void setSelectorDrawable(StateListDrawable stateListDrawable, int i) throws Exception {
        stateListDrawable.addState(new int[]{i}, DrawableFactory.getDrawable(this.typedArray, i));
    }
}
