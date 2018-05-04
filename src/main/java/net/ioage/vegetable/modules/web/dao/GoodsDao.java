package net.ioage.vegetable.modules.web.dao;

import net.ioage.vegetable.core.orm.BaseDao;
import net.ioage.vegetable.core.orm.mapper.GoodsMapper;
import net.ioage.vegetable.modules.web.model.Goods;
import org.springframework.stereotype.Repository;

/**
 * Created by qihao on 2018/5/3.
 */
@Repository
public class GoodsDao extends BaseDao<Goods, GoodsMapper> {
}
