package cn.stylefeng.guns.modular.system.service.impl;

import cn.stylefeng.guns.modular.system.model.Pet;
import cn.stylefeng.guns.modular.system.dao.PetMapper;
import cn.stylefeng.guns.modular.system.service.IPetService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 宠物管理表 服务实现类
 * </p>
 *
 * @author zhao
 * @since 2019-01-11
 */
@Service
public class PetServiceImpl extends ServiceImpl<PetMapper, Pet> implements IPetService {

}
