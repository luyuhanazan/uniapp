package org.example.uniapp.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.example.uniapp.entity.Advice;
import org.example.uniapp.service.AdviceService;
import org.example.uniapp.util.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

import static org.example.uniapp.util.Result.success;

/**
 * (Advice)表控制层
 *
 * @author 12444
 * @since 2024-03-21 10:56:39
 */
@RestController
@RequestMapping("advice")
public class AdviceController {
    /**
     * 服务对象
     */
    @Resource
    private AdviceService adviceService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @return 所有数据
     */
    @PostMapping(value = {"/list/{param}", "/list"})
    public Result selectAll(@RequestBody Page<Advice> page, @PathVariable(value = "param", required = false) String param) {
        return success(this.adviceService.getPage(page, param));
    }

    @GetMapping("five")
    public Result selectFive(String param) {
        return success(this.adviceService.getFive(param));
    }

}

