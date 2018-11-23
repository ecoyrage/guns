package cn.stylefeng.guns.modular.system.controller;

import cn.stylefeng.guns.modular.system.dao.GameRootNameMapper;
import cn.stylefeng.roses.core.base.controller.BaseController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import cn.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import cn.stylefeng.guns.modular.system.model.GameRootName;
import cn.stylefeng.guns.modular.system.service.IGameRootNameService;

import java.util.List;
import java.util.Map;

/**
 * 控制器
 *
 * @author fengshuonan
 * @Date 2018-11-15 14:08:08
 */
@Controller
@RequestMapping("/gameRootName")
public class GameRootNameController extends BaseController {

    private String PREFIX = "/system/gameRootName/";

    @Autowired
    private IGameRootNameService gameRootNameService;
    @Autowired
    private GameRootNameMapper gameRootNameMapper;

    /**
     * 跳转到首页
     */
    @RequestMapping("")
    public String index(Model model) {
        List<Map<String,Object>> gameNameList=gameRootNameMapper.selectGameNameList();
        model.addAttribute("gameNameList",gameNameList);
        List<Map<String,Object>> rootNameList=gameRootNameMapper.selectRootNameList();
        model.addAttribute("rootNameList",rootNameList);
        return PREFIX + "gameRootName.html";
    }

    /**
     * 跳转到添加
     */
    @RequestMapping("/gameRootName_add")
    public String gameRootNameAdd() {
        return PREFIX + "gameRootName_add.html";
    }

    /**
     * 跳转到修改
     */
    @RequestMapping("/gameRootName_update/{gameRootNameId}")
    public String gameRootNameUpdate(@PathVariable Integer gameRootNameId, Model model) {
        GameRootName gameRootName = gameRootNameService.selectById(gameRootNameId);
        model.addAttribute("item",gameRootName);
        LogObjectHolder.me().set(gameRootName);
        return PREFIX + "gameRootName_edit.html";
    }

    /**
     * 获取列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return gameRootNameService.selectList(null);
    }

    /**
     * 新增
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(GameRootName gameRootName) {
        gameRootNameService.insert(gameRootName);
        return SUCCESS_TIP;
    }

    /**
     * 删除
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer gameRootNameId) {
        gameRootNameService.deleteById(gameRootNameId);
        return SUCCESS_TIP;
    }

    /**
     * 修改
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(GameRootName gameRootName) {
        gameRootNameService.updateById(gameRootName);
        return SUCCESS_TIP;
    }

    /**
     * 详情
     */
    @RequestMapping(value = "/detail/{gameRootNameId}")
    @ResponseBody
    public Object detail(@PathVariable("gameRootNameId") Integer gameRootNameId) {
        return gameRootNameService.selectById(gameRootNameId);
    }
}
