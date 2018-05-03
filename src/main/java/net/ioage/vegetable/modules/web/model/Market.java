package net.ioage.vegetable.modules.web.model;

import javax.persistence.*;

public class Market {
    /**
     * 编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 名称
     */
    private String name;

    /**
     * 区域
     */
    @Column(name = "area_id")
    private Integer areaId;

    /**
     * 类别
     */
    @Column(name = "market_type")
    private String marketType;

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
     * 获取名称
     *
     * @return name - 名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置名称
     *
     * @param name 名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取区域
     *
     * @return area_id - 区域
     */
    public Integer getAreaId() {
        return areaId;
    }

    /**
     * 设置区域
     *
     * @param areaId 区域
     */
    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    /**
     * 获取类别
     *
     * @return market_type - 类别
     */
    public String getMarketType() {
        return marketType;
    }

    /**
     * 设置类别
     *
     * @param marketType 类别
     */
    public void setMarketType(String marketType) {
        this.marketType = marketType;
    }
}