package com.hivescm.scm.client.service;

import com.hivescm.common.domain.DataResult;
import com.hivescm.scm.client.common.DeleteESObject;
import com.hivescm.scm.client.common.ESQueryResponse;
import com.hivescm.scm.client.common.QueryESObject;
import com.hivescm.scm.client.common.SaveESObject;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author:
 * @Description: esService
 * @Date: 2018/4/9 13:56
 */
@FeignClient("es-scm-center")
public abstract interface ESSearchService {
    @RequestMapping(value={"/esSave"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
    public abstract DataResult<Boolean> esSave(@RequestBody SaveESObject paramSaveESObject);

    @RequestMapping(value={"/esDelete"}, method={org.springframework.web.bind.annotation.RequestMethod.DELETE})
    public abstract DataResult<Boolean> esDelete(@RequestBody DeleteESObject paramDeleteESObject);

    @RequestMapping(value={"/esQuery"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
    public abstract DataResult<ESQueryResponse> esQuery(@RequestBody QueryESObject paramQueryESObject);
}
