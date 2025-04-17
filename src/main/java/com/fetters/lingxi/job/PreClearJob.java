package com.fetters.lingxi.job;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fetters.lingxi.model.domain.Team;
import com.fetters.lingxi.model.domain.UserTeam;
import com.fetters.lingxi.service.TeamService;
import com.fetters.lingxi.service.UserTeamService;
import jakarta.annotation.Resource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * @author : Fetters
 * @description : 定时删除过期的队伍和关联数据任务
 * @createDate : 2025/4/17 18:12
 */
@Component
public class PreClearJob {
    @Resource
    private TeamService teamService;
    @Resource
    private UserTeamService userTeamService;

    /**
     * 每天00:00执行，删除过期的队伍和关联数据
     */
    @Scheduled(cron = "0 0 0 * * ?")
    public void clearExpiredTeams() {
        // 1. 查询所有过期的队伍
        QueryWrapper<Team> teamQueryWrapper = new QueryWrapper<>();
        // 过期时间小于当前时间
        teamQueryWrapper.lt("expireTime", new Date());
        List<Team> expiredTeams = teamService.list(teamQueryWrapper);

        // 2. 删除过期的队伍
        for (Team team : expiredTeams) {
            // 删除队伍关联的用户数据
            QueryWrapper<UserTeam> userTeamQueryWrapper = new QueryWrapper<>();
            userTeamQueryWrapper.eq("teamId", team.getId());
            userTeamService.remove(userTeamQueryWrapper);

            // 删除队伍
            teamService.removeById(team.getId());
        }
    }
}

