package com.example.jpa.api;

import com.example.jpa.vo.GatherUserVo;

/**
 * @author zhaojh0912
 */


public interface GatherUserApiService {

    /**
     * 添加用户
     * @param gatherUserVo
     */
    String addGatherUser(GatherUserVo gatherUserVo);
}
