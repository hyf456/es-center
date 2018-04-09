package com.hivescm.scm.service.scm.dto;

import com.hivescm.scm.service.common.bean.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * @Author:
 * @Description: 搜索实体
 * @Date: 2018/4/9 14:40
 */
@ApiModel(description = "查询商品请求参数", value = "QueryGoodsDto")
public class QueryGoodsDto extends Page implements Serializable {
    @ApiModelProperty("商户ID（必填）")
    private Integer merchantId;

    @ApiModelProperty("站点ID（必填）")
    private Long stationId;

    @ApiModelProperty("集团门店ID（必填）")
    private Integer groupStoreId;

    @ApiModelProperty("乡镇地址ID （必填）")
    private Long town;

    @ApiModelProperty("省ID  (必填）")
    private Long provId;

    @ApiModelProperty("市ID (必填 ")
    private Long cityId;

    @ApiModelProperty("镇ID (必填）")
    private Long countyId;

    @ApiModelProperty("门店ID（必填）")
    private Integer storeId;

    @ApiModelProperty("是否有货（1有，0无，2全部）")
    private Integer stock = Integer.valueOf(2);

    @ApiModelProperty("是否新品（1是，0否，2全部）")
    private Integer tagNew = Integer.valueOf(2);

    @ApiModelProperty("是否推荐（1是，0否，2全部）")
    private Integer tagRecommend = Integer.valueOf(2);

    @ApiModelProperty("是否热卖（1是，0否，2全部）")
    private Integer tagHot = Integer.valueOf(2);

    @ApiModelProperty("是否清仓（1是，0否，2全部）")
    private Integer tagClear = Integer.valueOf(2);

    @ApiModelProperty("商品名字")
    private String goodsName;

    @ApiModelProperty("品牌ID")
    private Long brandId;

    @ApiModelProperty("品牌名字")
    private String brandName;

    @ApiModelProperty("经销商ID")
    private Long dealerId;

    @ApiModelProperty("代理商经销商OrgID")
    private Long agentDealerId;

    @ApiModelProperty("经销商OrgID")
    private Long dealerOrgId;

    @ApiModelProperty("经销商名")
    private String dealerName;

    @ApiModelProperty("商品参数（参数名+值，如：产地_北京）")
    private String goodsParam;

    @ApiModelProperty("商品状态")
    private Integer status;

    @ApiModelProperty("商品类目ID")
    private Integer goodsCategoryId;

    @ApiModelProperty("商品类目名称")
    private String goodsCategoryName;

    @ApiModelProperty("商品ID IN")
    private Set<Long> goodsIdsIn;

    @ApiModelProperty("商品ID NOT IN")
    private List<String> goodsIdsOut;

    @ApiModelProperty("最小价格")
    private Double minPrice;

    @ApiModelProperty("最大价格")
    private Double maxPrice;
}

