package org.nanguo.lemall.aspect;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Objects;
import java.util.function.Supplier;

/**
 * 自动填充
 */
@Component
public class FillMetaObjectHandler implements MetaObjectHandler {

    /**
     * 创建时间
     */
    private static final String CREATE_TIME = "createTime";
    /**
     * 更新时间
     */
    private static final String UPDATE_TIME = "updateTime";

    /**
     * 重写不管原值是否为null，都进行填充
     * @param metaObject
     * @param fieldName
     * @param fieldVal
     * @return
     */
    @Override
    public MetaObjectHandler strictFillStrategy(MetaObject metaObject, String fieldName, Supplier<?> fieldVal) {
        Object obj = fieldVal.get();
        if (Objects.nonNull(obj)) {
            metaObject.setValue(fieldName, obj);
        }
        return this;
    }

    @Override
    public void insertFill(MetaObject metaObject) {
        this.strictInsertFill(metaObject, CREATE_TIME, Date.class, new Date());
        this.strictInsertFill(metaObject, UPDATE_TIME, Date.class, new Date());
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.strictUpdateFill(metaObject, UPDATE_TIME, Date.class, new Date());
    }
}
