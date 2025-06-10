package org.echonanguo.lemall.portal.dao;

import org.apache.ibatis.annotations.Param;
import org.echonanguo.lemall.model.SmsCoupon;
import org.echonanguo.lemall.portal.domain.SmsCouponHistoryDetail;

import java.util.List;

/**
 * 会员优惠券领取历史自定义Dao
 * Created by echonanguo on 2025/8/29.
 */
public interface SmsCouponHistoryDao {
    List<SmsCouponHistoryDetail> getDetailList(@Param("memberId") Long memberId);
    List<SmsCoupon> getCouponList(@Param("memberId") Long memberId, @Param("useStatus")Integer useStatus);
}
