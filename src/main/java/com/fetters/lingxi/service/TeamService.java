package com.fetters.lingxi.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fetters.lingxi.model.domain.Team;
import com.fetters.lingxi.model.domain.User;

/**
 * @author Fetters
 * @description 针对表【team(队伍)】的数据库操作Service
 * @createDate 2025-04-09 15:48:05
 */
public interface TeamService extends IService<Team> {
    /**
     * 创建队伍
     *
     * @param team
     * @param loginUser
     * @return
     */
    long addTeam(Team team, User loginUser);
}
