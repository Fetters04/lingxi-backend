package com.fetters.lingxi.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.fetters.lingxi.model.domain.Team;
import com.fetters.lingxi.model.domain.User;
import com.fetters.lingxi.model.dto.TeamQuery;
import com.fetters.lingxi.model.request.TeamJoinRequest;
import com.fetters.lingxi.model.request.TeamQuitRequest;
import com.fetters.lingxi.model.request.TeamUpdateRequest;
import com.fetters.lingxi.model.vo.TeamUserVO;

import java.util.List;

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


    /**
     * 搜索队伍
     *
     * @param teamQuery
     * @param isAdmin
     * @return
     */
    List<TeamUserVO> listTeams(TeamQuery teamQuery, boolean isAdmin);

    /**
     * 更新队伍信息
     *
     * @param teamUpdateRequest
     * @param loginUser
     * @return
     */
    boolean updateTeam(TeamUpdateRequest teamUpdateRequest, User loginUser);

    /**
     * 加入队伍
     *
     * @param teamJoinRequest
     * @param loginUser
     * @return
     */
    boolean joinTeam(TeamJoinRequest teamJoinRequest, User loginUser);

    /**
     * 退出队伍
     *
     * @param teamQuitRequest
     * @param loginUser
     * @return
     */
    boolean quitTeam(TeamQuitRequest teamQuitRequest, User loginUser);

    /**
     * 删除队伍
     *
     * @param id
     * @param loginUser
     * @return
     */
    boolean deleteTeam(long id, User loginUser);
}
