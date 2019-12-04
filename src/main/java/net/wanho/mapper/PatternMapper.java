package net.wanho.mapper;

import net.wanho.pojo.Pattern;
import net.wanho.pojo.PatternConfig;

import java.util.List;

/**
 * Created by songb on 2019/10/9.
 */
public interface PatternMapper {
    List<PatternConfig> getPatternConfigs(PatternConfig patternConfig);

    List<Pattern> getPatterns(Pattern pattern);

    List<Pattern> getSubPatterns(Pattern pattern);
}
