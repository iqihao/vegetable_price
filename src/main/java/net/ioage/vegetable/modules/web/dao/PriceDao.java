package net.ioage.vegetable.modules.web.dao;

import net.ioage.vegetable.core.orm.BaseDao;
import net.ioage.vegetable.core.orm.mapper.PriceMapper;
import net.ioage.vegetable.modules.web.model.Price;
import org.springframework.stereotype.Repository;

/**
 * Created by qihao on 2018/5/3.
 */
@Repository
public class PriceDao extends BaseDao<Price, PriceMapper> {
}
