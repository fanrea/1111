package com.fendasz.moku.planet.ui.dialog;

import android.content.Context;
import android.view.View;
import com.fendasz.moku.planet.ui.dialog.CustomBuildDialog;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class CustomDialogParams {
    private Integer animationStyleId;
    private Boolean cancelable;
    private Context context;
    private View customView;
    private String detailText;
    private Integer dialogWidth;
    private Integer guideImage;
    private CustomBuildDialog.DialogGuideTouchListener guideTouchListener;
    private String leftBtn;
    private CustomBuildDialog.DialogButtonOnClickListener leftBtnListener;
    private CustomBuildDialog.OnDialogButtonCreated onDialogButtonCreated;
    private String rightBtn;
    private CustomBuildDialog.DialogButtonOnClickListener rightBtnListener;
    private Boolean showClose;
    private Integer titleImage;
    private String titleText;

    public Integer getTitleImage() {
        return this.titleImage;
    }

    public void setTitleImage(Integer num) {
        this.titleImage = num;
    }

    public String getTitleText() {
        return this.titleText;
    }

    public void setTitleText(String str) {
        this.titleText = str;
    }

    public String getDetailText() {
        return this.detailText;
    }

    public void setDetailText(String str) {
        this.detailText = str;
    }

    public View getCustomView() {
        return this.customView;
    }

    public void setCustomView(View view) {
        this.customView = view;
    }

    public String getLeftBtn() {
        return this.leftBtn;
    }

    public void setLeftBtn(String str) {
        this.leftBtn = str;
    }

    public String getRightBtn() {
        return this.rightBtn;
    }

    public void setRightBtn(String str) {
        this.rightBtn = str;
    }

    public CustomBuildDialog.DialogButtonOnClickListener getLeftBtnListener() {
        return this.leftBtnListener;
    }

    public void setLeftBtnListener(CustomBuildDialog.DialogButtonOnClickListener dialogButtonOnClickListener) {
        this.leftBtnListener = dialogButtonOnClickListener;
    }

    public CustomBuildDialog.DialogButtonOnClickListener getRightBtnListener() {
        return this.rightBtnListener;
    }

    public void setRightBtnListener(CustomBuildDialog.DialogButtonOnClickListener dialogButtonOnClickListener) {
        this.rightBtnListener = dialogButtonOnClickListener;
    }

    public Boolean getShowClose() {
        return this.showClose;
    }

    public void setShowClose(Boolean bool) {
        this.showClose = bool;
    }

    public Boolean getCancelable() {
        return this.cancelable;
    }

    public void setCancelable(Boolean bool) {
        this.cancelable = bool;
    }

    public Context getContext() {
        return this.context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public Integer getAnimationStyleId() {
        return this.animationStyleId;
    }

    public void setAnimationStyleId(Integer num) {
        this.animationStyleId = num;
    }

    public Integer getGuideImage() {
        return this.guideImage;
    }

    public void setGuideImage(Integer num) {
        this.guideImage = num;
    }

    public CustomBuildDialog.DialogGuideTouchListener getGuideTouchListener() {
        return this.guideTouchListener;
    }

    public void setGuideTouchListener(CustomBuildDialog.DialogGuideTouchListener dialogGuideTouchListener) {
        this.guideTouchListener = dialogGuideTouchListener;
    }

    public void setOnDialogButtonCreated(CustomBuildDialog.OnDialogButtonCreated onDialogButtonCreated) {
        this.onDialogButtonCreated = onDialogButtonCreated;
    }

    public Integer getDialogWidth() {
        return this.dialogWidth;
    }

    public void setDialogWidth(Integer num) {
        this.dialogWidth = num;
    }

    public CustomBuildDialog.OnDialogButtonCreated getOnDialogButtonCreated() {
        return this.onDialogButtonCreated;
    }
}
