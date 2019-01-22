package cn.stylefeng.guns.modular.app.service.impl;

import cn.stylefeng.guns.modular.system.model.Video;
import cn.stylefeng.guns.modular.system.dao.VideoMapper;
import cn.stylefeng.guns.modular.app.service.IVideoAppService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhao
 * @since 2019-01-17
 */
@Service
public class VideoAppServiceImpl extends ServiceImpl<VideoMapper, Video> implements IVideoAppService {

}
