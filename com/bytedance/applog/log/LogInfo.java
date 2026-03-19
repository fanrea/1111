package com.bytedance.applog.log;

import com.baidu.mobads.sdk.internal.ca;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public class LogInfo {
    private static final ThreadLocal<SimpleDateFormat> threadLocalDateFormat = new ThreadLocal<SimpleDateFormat>() { // from class: com.bytedance.applog.log.LogInfo.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
    };
    private String appId;
    private String message;
    private List<String> tags;
    private String thread;
    private Throwable throwable;
    private int level = 1;
    private int category = 0;
    private long time = System.currentTimeMillis();

    public static class Category {
        public static final int ABTEST = 2;
        public static final int ALINK = 3;
        public static final int COMPRESS = 14;
        public static final int DATABASE = 5;
        public static final int DEFAULT = 0;
        public static final int DEVICE_REGISTER = 1;
        public static final int EVENT = 4;
        public static final int EVENT_PRIORITY = 13;
        public static final int EVENT_SAMPLING = 12;
        public static final int EVENT_VERIFY = 6;
        public static final int MONITOR = 8;
        public static final int ONE_ID = 15;
        public static final int PICKER = 10;
        public static final int REQUEST = 11;
        public static final int USER_PROFILE = 9;
        public static final int VIEW_EXPOSURE = 7;
    }

    public static class Level {
        public static final int ASSERT = 5;
        public static final int DEBUG = 1;
        public static final int ERROR = 4;
        public static final int INFO = 2;
        public static final int VERBOSE = 0;
        public static final int WARNING = 3;
    }

    public static LogInfoBuilder builder() {
        return new LogInfoBuilder();
    }

    public long getTime() {
        return this.time;
    }

    public void setTime(long j) {
        this.time = j;
    }

    public String getAppId() {
        return this.appId;
    }

    public void setAppId(String str) {
        this.appId = str;
    }

    public String getThread() {
        return this.thread;
    }

    public void setThread(String str) {
        this.thread = str;
    }

    public int getLevel() {
        return this.level;
    }

    public void setLevel(int i) {
        this.level = i;
    }

    public int getCategory() {
        return this.category;
    }

    public void setCategory(int i) {
        this.category = i;
    }

    public List<String> getTags() {
        return this.tags;
    }

    public void setTags(List<String> list) {
        this.tags = list;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public Throwable getThrowable() {
        return this.throwable;
    }

    public void setThrowable(Throwable th) {
        this.throwable = th;
    }

    public String getLevelString() {
        int i = this.level;
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? "" : "ASSERT" : ca.l : "WARN" : "INFO" : "DEBUG" : "VERBOSE";
    }

    public String getCategoryString() {
        switch (this.category) {
            case 1:
                return "DEVICE_REGISTER";
            case 2:
                return "ABTEST";
            case 3:
                return "ALINK";
            case 4:
                return "EVENT";
            case 5:
                return "DATABASE";
            case 6:
                return "EVENT_VERIFY";
            case 7:
                return "VIEW_EXPOSURE";
            case 8:
                return "MONITOR";
            case 9:
                return "USER_PROFILE";
            case 10:
                return "PICKER";
            case 11:
                return "REQUEST";
            case 12:
                return "EVENT_SAMPLING";
            case 13:
                return "EVENT_PRIORITY";
            case 14:
                return "COMPRESS";
            case 15:
                return "ONE_ID";
            default:
                return "DEFAULT";
        }
    }

    public String getTagString() {
        List<String> list = this.tags;
        if (list == null || list.size() <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.tags.size(); i++) {
            sb.append(this.tags.get(i));
            if (i < this.tags.size() - 1) {
                sb.append(",");
            }
        }
        return sb.toString();
    }

    public String getTimeString() {
        return this.time > 0 ? threadLocalDateFormat.get().format(new Date(this.time)) : "--";
    }

    public String toString() {
        String str = "[" + getTimeString() + "][" + getLevelString() + "][" + toString(this.appId) + "][" + toString(this.thread) + "][" + getCategoryString() + "][" + getTagString() + "] " + toString(this.message);
        return getThrowable() != null ? str + "\nstacktrace: " + getExceptionStackString(getThrowable()) : str;
    }

    public String toLiteString() {
        return "[" + getLevelString() + "][" + toString(this.appId) + "] " + toString(this.message);
    }

    public String toMessage() {
        return toString(this.message);
    }

    private String toString(Object obj) {
        return obj != null ? obj.toString() : "";
    }

    private String getExceptionStackString(Throwable th) {
        StringBuilder sb = new StringBuilder();
        while (th != null) {
            appendStackString(sb, th);
            th = th.getCause();
        }
        return sb.toString();
    }

    private void appendStackString(StringBuilder sb, Throwable th) {
        sb.append(th.toString());
        for (StackTraceElement stackTraceElement : th.getStackTrace()) {
            sb.append("\n\tat ").append(stackTraceElement);
        }
    }
}
