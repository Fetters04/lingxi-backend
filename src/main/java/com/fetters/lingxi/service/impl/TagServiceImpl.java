package com.fetters.lingxi.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fetters.lingxi.model.domain.Tag;
import com.fetters.lingxi.service.TagService;
import com.fetters.lingxi.mapper.TagMapper;
import org.springframework.stereotype.Service;

/**
* @author Fetters
* @description 针对表【tag(标签表)】的数据库操作Service实现
* @createDate 2025-03-18 10:40:52
*/
@Service
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag>
    implements TagService{

}




