package com.fetters.lingxi.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fetters.lingxi.common.ErrorCode;
import com.fetters.lingxi.exception.BusinessException;
import com.fetters.lingxi.mapper.TeamMapper;
import com.fetters.lingxi.model.domain.Team;
import com.fetters.lingxi.model.domain.User;
import com.fetters.lingxi.model.domain.UserTeam;
import com.fetters.lingxi.model.enums.TeamStatusEnum;
import com.fetters.lingxi.service.TeamService;
import com.fetters.lingxi.service.UserTeamService;
import io.micrometer.common.util.StringUtils;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Objects;

/**
 * @author Fetters
 * @description 针对表【team(队伍)】的数据库操作Service实现
 * @createDate 2025-04-09 15:48:05
 */
@Service
public class TeamServiceImpl extends ServiceImpl<TeamMapper, Team>
        implements TeamService {
    @Resource
    private UserTeamService userTeamService;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public long addTeam(Team team, User loginUser) {
        // 校验逻辑
        validateTeam(team, loginUser);

        final long userId = loginUser.getId();

        // 插入队伍信息到队伍表
        team.setId(null);
        team.setUserId(userId);
        boolean result = this.save(team);
        Long teamId = team.getId();
        checkResult(result || teamId == null, "创建队伍失败");

        // 插入用户 => 队伍关系到关系表
        UserTeam userTeam = new UserTeam();
        userTeam.setUserId(userId);
        userTeam.setTeamId(teamId);
        userTeam.setJoinTime(new Date());
        result = userTeamService.save(userTeam);
        checkResult(result, "创建队伍失败");

        return teamId;
    }

    private void validateTeam(Team team, User loginUser) {
        Objects.requireNonNull(team, "Team cannot be null");
        Objects.requireNonNull(loginUser, "LoginUser cannot be null");

        // 队伍人数 > 1 且 <= 20
        int maxNum = team.getMaxNum() == null ? 0 : team.getMaxNum();
        if (maxNum < 1 || maxNum > 20) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "队伍人数不满足要求");
        }

        // 队伍标题 <= 20
        String teamName = team.getName();
        if (StringUtils.isBlank(teamName)) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "必须填写队伍名称");
        } else if (teamName.trim().length() > 20) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "队伍名称过长");
        }

        // 描述 <= 512
        String description = team.getDescription();
        if (StringUtils.isBlank(description)) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "必须填写队伍描述");
        } else if (description.trim().length() > 512) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "队伍描述过长");
        }

        // status 是否公开（int）不传默认为 0（公开）
        int status = team.getStatus() == null ? 0 : team.getStatus();
        TeamStatusEnum statusEnum = TeamStatusEnum.getEnumByValue(status);
        if (statusEnum == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "队伍状态不满足要求");
        }

        // 如果 status 是加密状态，一定要有密码，且密码 <= 32
        String password = team.getPassword();
        if (TeamStatusEnum.SECRET.equals(statusEnum)) {
            if (StringUtils.isBlank(password) || password.trim().length() > 32) {
                throw new BusinessException(ErrorCode.PARAMS_ERROR, "密码设置不正确");
            }
        }

        // 超时时间 > 当前时间
        Date expireTime = team.getExpireTime();
        if (expireTime == null || new Date().after(expireTime)) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "超时时间不能早于当前时间");
        }

        // 校验用户最多创建 5 个队伍
        QueryWrapper<Team> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userId", loginUser.getId());
        if (this.count(queryWrapper) >= 5) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "最多创建5个队伍");
        }
    }

    private void checkResult(boolean result, String errorMessage) {
        if (!result) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, errorMessage);
        }
    }

}




