package com.mall.tiny.service;

import com.mall.tiny.mbg.model.PmsBrand;

import java.util.List;

/**
 * @author kongwenjia
 * @date 2023/8/15 21:55
 * @description
 */
public interface PmsBrandService {
    List<PmsBrand> listAllBrand();

    int createBrand(PmsBrand brand);

    int updateBrand(Long id, PmsBrand brand);

    int deleteBrand(Long id);

    List<PmsBrand> listBrand(int pageNum, int pageSize);

    PmsBrand getBrand(Long id);
}
