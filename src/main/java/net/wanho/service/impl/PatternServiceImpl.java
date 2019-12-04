package net.wanho.service.impl;

import net.wanho.mapper.PatternMapper;
import net.wanho.pojo.Pattern;
import net.wanho.pojo.PatternConfig;
import net.wanho.service.IPatternService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by songb on 2019/10/9.
 */
@Service
public class PatternServiceImpl implements IPatternService {
    @Autowired
    private PatternMapper patternMapper;

    @Override
    public List<PatternConfig> getPatternConfigs(PatternConfig patternConfig) {
        return patternMapper.getPatternConfigs(patternConfig);
    }

    @Override
    public List<Pattern> getPatterns(Pattern pattern) {
        //如果有父类则查询子类，没有直接查询
        if(pattern.getParentCode()!=null && ""!=pattern.getParentCode()){
            return patternMapper.getSubPatterns(pattern);
        }else{
            return patternMapper.getPatterns(pattern);
        }

    }
}
