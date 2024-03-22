package org.example.uniapp.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.example.uniapp.entity.Advice;

import java.util.List;

/**
 * (Advice)表服务接口
 *
 * @author 12444
 * @since 2024-03-21 10:56:41
 */
public interface AdviceService extends IService<Advice> {

    List<Advice> getFive(String param);

    Page<Advice> getPage(Page<Advice> page, String param);
}

