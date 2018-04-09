package com.hivescm.scm.service.scm.api;

import com.hivescm.common.domain.DataResult;
import com.hivescm.scm.service.common.bean.ESResponse;
import com.hivescm.scm.service.scm.dto.QueryGoodsDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author:
 * @Description: 搜索商品
 * @Date: 2018/4/9 14:40
 */
@FeignClient(value="es-scm-center-service", path="es-scm-center-service")
public abstract interface QueryGoodsService {
    @PostMapping({"/info/goods/list"})
    public abstract DataResult<ESResponse> queryGoodsByFilter(@RequestBody QueryGoodsDto paramQueryGoodsDto);

    @PostMapping({"/info/top/brand"})
    public abstract DataResult<ESResponse> queryToBrandByFilter(@RequestParam("firstSaleTypeId") Long paramLong1, @RequestParam("stationId") Long paramLong2, @RequestParam(value="num", defaultValue="30") Integer paramInteger);
}
