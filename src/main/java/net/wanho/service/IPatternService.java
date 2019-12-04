package net.wanho.service;

import net.wanho.pojo.Pattern;
import net.wanho.pojo.PatternConfig;

import java.util.List;

/**
 * Created by songb on 2019/10/9.
 */
public interface IPatternService {
    List<PatternConfig> getPatternConfigs(PatternConfig patternConfig);

    List<Pattern> getPatterns(Pattern pattern);
}
