package net.ioage.vegetable.modules.web.model;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

public class Price {
    /**
     * 编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 商品ID
     */
    @Column(name = "goods_id")
    private Integer goodsId;

    /**
     * 市场ID
     */
    @Column(name = "market_id")
    private Integer marketId;

    /**
     * 区域ID
     */
    @Column(name = "area_id")
    private Integer areaId;

    /**
     * 日期
     */
    @Column(name = "date_time")
    private Date dateTime;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    private BigDecimal price;

    /**
     * 获取编号
     *
     * @return id - 编号
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置编号
     *
     * @param id 编号
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取商品ID
     *
     * @return goods_id - 商品ID
     */
    public Integer getGoodsId() {
        return goodsId;
    }

    /**
     * 设置商品ID
     *
     * @param goodsId 商品ID
     */
    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    /**
     * 获取市场ID
     *
     * @return market_id - 市场ID
     */
    public Integer getMarketId() {
        return marketId;
    }

    /**
     * 设置市场ID
     *
     * @param marketId 市场ID
     */
    public void setMarketId(Integer marketId) {
        this.marketId = marketId;
    }

    /**
     * 获取区域ID
     *
     * @return area_id - 区域ID
     */
    public Integer getAreaId() {
        return areaId;
    }

    /**
     * 设置区域ID
     *
     * @param areaId 区域ID
     */
    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    /**
     * 获取日期
     *
     * @return date_time - 日期
     */
    public Date getDateTime() {
        return dateTime;
    }

    /**
     * 设置日期
     *
     * @param dateTime 日期
     */
    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return price
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * @param price
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}