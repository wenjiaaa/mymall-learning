package com.mall.tiny.controller;

import com.mall.tiny.common.api.CommonPage;
import com.mall.tiny.common.api.CommonResult;
import com.mall.tiny.mbg.model.PmsBrand;
import com.mall.tiny.service.PmsBrandService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author kongwenjia
 * @date 2023/8/6 11:48
 * @description 品牌管理 Controller
 */
@Controller
@Api(tags = "PmsBrandController")
@Tag(name = "PmsBrandController",description = "商品品牌管理")
@RequestMapping("/brand")
public class PmsBrandController {
    @Autowired
    private PmsBrandService brandService;
    private static final Logger LOGGER = LoggerFactory.getLogger(PmsBrandController.class);

    @ApiOperation("获取所有品牌列表")
    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<PmsBrand>> getBrandList(){
        return CommonResult.success(brandService.listAllBrand());
    }

    @ApiOperation("添加品牌")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public  CommonResult createBrand(@RequestBody PmsBrand pmsBrand){
        CommonResult commonResult;
        int count = brandService.createBrand(pmsBrand);
        if(count == 1){
            commonResult = CommonResult.success(pmsBrand);
            LOGGER.debug("createBrand success:{}", pmsBrand);
        } else {
            commonResult = CommonResult.failed("操作失败");
            LOGGER.debug("createBrand failed: {}",pmsBrand);
        }
        return commonResult;

    }

    @ApiOperation("更新指定id品牌信息")
    @RequestMapping(value = "/update/{id}",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateBrand(@PathVariable("id") Long id, @RequestBody PmsBrand pmsBrandDto, BindingResult result){
        CommonResult commonResult;
        int count = brandService.updateBrand(id, pmsBrandDto);
        if (count == 1){
            commonResult = CommonResult.success(pmsBrandDto);
            LOGGER.info("updateBrand success:{}", pmsBrandDto);
        } else{
            commonResult = CommonResult.failed("操作失败");
            LOGGER.info("updateBrand failed:{}",pmsBrandDto);
        }
        return commonResult;
    }

    @ApiOperation("删除指定id的品牌")
    @RequestMapping(value =  "/delete/{id}",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult deleteBrand(@PathVariable("id") Long id){
        int count = brandService.deleteBrand(id);
        if (count == 1){
            LOGGER.info("deleteBrand success, id = {}",id);
            return CommonResult.success(null);
        } else {
            LOGGER.info("deleteBrand failed, id = {}",id);
            return CommonResult.failed("操作失败");
        }
    }

    /**
     * 分页查询
     * 请求路径：http://localhost:8081/brand/list/?pageNum=1&pageSize=3
     * @param pageNum 第几页
     * @param pageSize 每页几条数据
     * @return 返回的数据包括分页信息
     */
    @ApiOperation("分页查询品牌列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<PmsBrand>> listBrand(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                                        @RequestParam(value = "pageSize", defaultValue = "3") Integer pageSize){
        List<PmsBrand> brandList = brandService.listBrand(pageNum,pageSize);
        return CommonResult.success(CommonPage.restPage(brandList));
    }

    @ApiOperation("获取指定id的品牌详情")
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<PmsBrand> brand(@PathVariable("id") Long id) {
        return CommonResult.success(brandService.getBrand(id));
    }


}
