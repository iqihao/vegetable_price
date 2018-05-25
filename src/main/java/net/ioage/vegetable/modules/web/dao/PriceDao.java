package net.ioage.vegetable.modules.web.dao;

import net.ioage.vegetable.core.orm.BaseDao;
import net.ioage.vegetable.core.orm.mapper.PriceMapper;
import net.ioage.vegetable.modules.web.model.Price;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by qihao on 2018/5/3.
 */
@Repository
public class PriceDao extends BaseDao<Price, PriceMapper> {

    @Autowired
    private PriceMapper priceMapper;

    public List<Price> getPriceByDateTime(Date date) {
        Price price = new Price();
        price.setDateTime(date);
        List<Price> priceList = priceMapper.select(price);
        return CollectionUtils.isEmpty(priceList) ? new ArrayList<>() : priceList;
    }
}
