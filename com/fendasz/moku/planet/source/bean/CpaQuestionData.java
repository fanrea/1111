package com.fendasz.moku.planet.source.bean;

import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class7.dex */
public class CpaQuestionData {
    public static final int QUESTION_TYPE_0 = 0;
    public static final int QUESTION_TYPE_1 = 1;
    public static final int QUESTION_TYPE_2 = 2;
    public static final int QUESTION_TYPE_3 = 3;
    private List<AnserDataEntity> answerList;
    private List<String> formList;
    private Integer questionNum;
    private Integer questionType;
    private List<List<TaskDataStep>> steps;

    public Integer getQuestionType() {
        return this.questionType;
    }

    public void setQuestionType(Integer num) {
        this.questionType = num;
    }

    public List<List<TaskDataStep>> getSteps() {
        return this.steps;
    }

    public void setSteps(List<List<TaskDataStep>> list) {
        this.steps = list;
    }

    public List<String> getFormList() {
        return this.formList;
    }

    public void setFormList(List<String> list) {
        this.formList = list;
    }

    public List<AnserDataEntity> getAnswerList() {
        return this.answerList;
    }

    public void setAnswerList(List<AnserDataEntity> list) {
        this.answerList = list;
    }

    public Integer getQuestionNum() {
        return this.questionNum;
    }

    public void setQuestionNum(Integer num) {
        this.questionNum = num;
    }
}
