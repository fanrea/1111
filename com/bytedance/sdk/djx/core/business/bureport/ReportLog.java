package com.bytedance.sdk.djx.core.business.bureport;

import com.bytedance.sdk.djx.core.log.BLogAgent;
import com.bytedance.sdk.djx.core.log.ILogConst;
import com.bytedance.sdk.djx.model.DramaDetail;
import com.bytedance.sdk.djx.model.ReportModel;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ReportLog.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/bytedance/sdk/djx/core/business/bureport/ReportLog;", "", "()V", "E_SKIT_REPORT", "", "reportSkit", "", "dramaDetail", "Lcom/bytedance/sdk/djx/model/DramaDetail;", "reportModel", "Lcom/bytedance/sdk/djx/model/ReportModel;", "complainDes", "sdk_core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: D:\123Browser\下载\dump_dex_com.awfgwfd.joiyuevgyftrsa\class4.dex */
public final class ReportLog {
    private static final String E_SKIT_REPORT = "skit_report";
    public static final ReportLog INSTANCE = new ReportLog();

    private ReportLog() {
    }

    @JvmStatic
    public static final void reportSkit(DramaDetail dramaDetail, ReportModel reportModel, String complainDes) {
        Intrinsics.checkNotNullParameter(dramaDetail, "dramaDetail");
        Intrinsics.checkNotNullParameter(reportModel, "reportModel");
        Intrinsics.checkNotNullParameter(complainDes, "complainDes");
        BLogAgent bLogAgentBuild = BLogAgent.build(null, E_SKIT_REPORT, null);
        bLogAgentBuild.putLong(ILogConst.Keys.KEY_SKIT_ID, dramaDetail.getSkitId());
        bLogAgentBuild.putLong("group_id", dramaDetail.getGroupId());
        bLogAgentBuild.putString("skit_name", dramaDetail.getSkitName());
        bLogAgentBuild.putInt("skit_index", dramaDetail.getIndex());
        bLogAgentBuild.putString("skit_class", dramaDetail.getDrama().type);
        bLogAgentBuild.putInt("type", reportModel.getReportType());
        bLogAgentBuild.putString("description", complainDes);
        bLogAgentBuild.send();
    }
}
