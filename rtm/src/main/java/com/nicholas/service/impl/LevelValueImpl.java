package com.nicholas.service.impl;

import com.nicholas.domain.User;
import com.nicholas.mapper.UserMapper;
import com.nicholas.service.LevelValue;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class LevelValueImpl implements LevelValue {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private LevelCheck levelCheck;

    @Override
    public boolean addValue(String account, Long value) {
        User srcUser = userMapper.selectByPrimaryAccount(account);
        Long levelValue = srcUser.getLevelValue();
        log.info("当前经验值：" + levelValue);

        Long sumValue = levelValue + value;
        int levelId = levelCheck.levelCheck(sumValue);//查询更新后经验值属于哪个等级

        srcUser.setLevelValue(sumValue);//赋值
        srcUser.setUserLevel(levelId);

        int i = userMapper.updateByPrimaryKeySelective(srcUser);//更新
        if (i > 0){
            log.info("add"+ value + "经验值成功");
            return true;
        }
        return false;
    }

    @Override
    public boolean subValue(String account, Long value) {
        User srcUser = userMapper.selectByPrimaryAccount(account);
        Long levelValue = srcUser.getLevelValue();
        log.info("当前经验值：" + levelValue);

        if (levelValue < value){
            log.info("当前经验小于被减经验，当前经验：" + levelValue + ",被减经验：" + value);
            value = levelValue;
            log.info("同步：value =" + value);
        }

        Long subValue = levelValue - value;
        int levelId = levelCheck.levelCheck(subValue);//查询更新后经验值属于哪个等级

        srcUser.setLevelValue(subValue);//赋值
        srcUser.setUserLevel(levelId);

        int i = userMapper.updateByPrimaryKeySelective(srcUser);//更新
        if (i > 0){
            log.info("sub"+ value + "经验值成功");
            return true;
        }
        return false;
    }
}
