package cn.stylefeng.guns.modular.system.dao;

import cn.stylefeng.guns.modular.system.model.GameRootName;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 游戏房间类型 Mapper 接口
 * </p>
 *
 * @author stylefeng
 * @since 2018-11-15
 */
public interface GameRootNameMapper extends BaseMapper<GameRootName> {
    List<Map<String,Object>> selectGameNameList();
    List<Map<String,Object>> selectRootNameList();

}
