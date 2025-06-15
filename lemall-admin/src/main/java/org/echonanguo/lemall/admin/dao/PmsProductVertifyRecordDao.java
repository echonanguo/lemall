package org.echonanguo.lemall.admin.dao;

import org.echonanguo.lemall.mbg.model.PmsProductVertifyRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 自定义商品审核日志管理Dao
 * Created by echonanguo on 2025/4/27.
 */
public interface PmsProductVertifyRecordDao {
    /**
     * 批量创建
     */
    int insertList(@Param("list") List<PmsProductVertifyRecord> list);
}
