package com.bykv.vk.openvk.component.video.d.hc.u;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.baidu.mobads.container.util.bu;
import com.baidu.mobads.sdk.internal.ca;
import com.bykv.vk.openvk.component.video.d.hc.tt;
import com.kuaishou.socket.nano.SocketMessages;
import java.io.InputStream;
import java.util.List;

/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public abstract class d {
    List<tt.hc> d;
    u hc;

    public abstract String an();

    public abstract List<tt.hc> b();

    public abstract InputStream c();

    public abstract int d();

    protected String d(int i) {
        switch (i) {
            case 200:
                return ca.k;
            case 201:
                return "Created";
            case 202:
                return "Accepted";
            case 203:
                return "Non-Authoritative";
            case 204:
                return "No Content";
            case 205:
                return "Reset Content";
            case 206:
                return "Partial Content";
            default:
                switch (i) {
                    case 300:
                        return "Multiple Choices";
                    case 301:
                        return "Moved Permanently";
                    case 302:
                        return "Temporary Redirect";
                    case 303:
                        return "See Other";
                    case 304:
                        return "Not Modified";
                    case 305:
                        return "Use Proxy";
                    default:
                        switch (i) {
                            case 400:
                                return "Bad Request";
                            case 401:
                                return "Unauthorized";
                            case 402:
                                return "Payment Required";
                            case 403:
                                return "Forbidden";
                            case 404:
                                return "Not Found";
                            case 405:
                                return "Method Not Allowed";
                            case 406:
                                return "Not Acceptable";
                            case 407:
                                return "Proxy Authentication Required";
                            case 408:
                                return "Request Time-Out";
                            case bu.l /* 409 */:
                                return "Conflict";
                            case SocketMessages.PayloadType.SC_WISH_LIST_OPENED /* 410 */:
                                return "Gone";
                            case SocketMessages.PayloadType.SC_WISH_LIST_CLOSED /* 411 */:
                                return "Length Required";
                            case SocketMessages.PayloadType.SC_RIDE_CHANGED /* 412 */:
                                return "Precondition Failed";
                            case bu.aL /* 413 */:
                                return "Request Entity Too Large";
                            case 414:
                                return "Request-URI Too Large";
                            case 415:
                                return "Unsupported Media Type";
                            default:
                                switch (i) {
                                    case 500:
                                        return "Internal Server Error";
                                    case 501:
                                        return "Not Implemented";
                                    case 502:
                                        return "Bad Gateway";
                                    case 503:
                                        return "Service Unavailable";
                                    case 504:
                                        return "Gateway Timeout";
                                    case TypedValues.PositionType.TYPE_SIZE_PERCENT /* 505 */:
                                        return "HTTP Version Not Supported";
                                    default:
                                        return "";
                                }
                        }
                }
        }
    }

    public abstract String d(String str, String str2);

    public abstract boolean hc();

    public abstract String u();

    public u h() {
        return this.hc;
    }

    protected tt.hc d(String str) {
        List<tt.hc> list;
        if (str != null && (list = this.d) != null && list.size() > 0) {
            for (tt.hc hcVar : this.d) {
                if (str.equals(hcVar.d)) {
                    return hcVar;
                }
            }
        }
        return null;
    }
}
