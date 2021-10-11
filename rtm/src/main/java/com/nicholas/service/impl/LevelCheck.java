package com.nicholas.service.impl;

import com.nicholas.domain.Level;
import com.nicholas.mapper.LevelMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * 根据经验值查询属于哪个经验级别
 * */

@Slf4j
@Service
public class LevelCheck {

    @Autowired
    private LevelMapper levelMapper;

    public int levelCheck(Long levelValue){

        List<Level> levels = levelMapper.selectAll();
        //遍历集合结果，如果传入参数小于原来参数，返回当前遍历对象的levelId
        for (Level level: levels) {
            if (levelValue == level.getValue()){
                log.info("符合的经验值等级为：" + level.getLevelId());
                return level.getLevelId();
            }
            if (levelValue < level.getValue()){
                log.info("符合的经验值等级为：" + (level.getLevelId() - 1));
                return level.getLevelId() - 1;
            }
        }
        //如果没有找到，返回集合中末尾对象的levelId
        return (levels.get(levels.size() - 1).getLevelId());
    }
}
