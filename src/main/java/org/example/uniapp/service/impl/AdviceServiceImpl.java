package org.example.uniapp.service.impl;

import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.uniapp.dao.AdviceDao;
import org.example.uniapp.entity.Advice;
import org.example.uniapp.service.AdviceService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * (Advice)表服务实现类
 *
 * @author 12444
 * @since 2024-03-21 10:56:42
 */
@Service("adviceService")
public class AdviceServiceImpl extends ServiceImpl<AdviceDao, Advice> implements AdviceService {

    @Override
    public List<Advice> getFive(String param) {
        return this.lambdaQuery()
                .like(StringUtils.isNotEmpty(param), Advice::getTitle, param)
                .last("limit 5").list();
    }

    @Override
    public Page<Advice> getPage(Page<Advice> page, String param) {
        return this.lambdaQuery()
                .like(StringUtils.isNotEmpty(param), Advice::getTitle, param)
                .page(page);
    }
}

