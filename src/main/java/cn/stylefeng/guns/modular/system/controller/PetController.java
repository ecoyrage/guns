package cn.stylefeng.guns.modular.system.controller;

import cn.stylefeng.roses.core.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import cn.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import cn.stylefeng.guns.modular.system.model.Pet;
import cn.stylefeng.guns.modular.system.service.IPetService;

/**
 * 宠物管理控制器
 *
 * @author fengshuonan
 * @Date 2019-01-11 00:45:32
 */
@Controller
@RequestMapping("/pet")
public class PetController extends BaseController {

    private String PREFIX = "/system/pet/";

    @Autowired
    private IPetService petService;

    /**
     * 跳转到宠物管理首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "pet.html";
    }

    /**
     * 跳转到添加宠物管理
     */
    @RequestMapping("/pet_add")
    public String petAdd() {
        return PREFIX + "pet_add.html";
    }

    /**
     * 跳转到修改宠物管理
     */
    @RequestMapping("/pet_update/{petId}")
    public String petUpdate(@PathVariable Integer petId, Model model) {
        Pet pet = petService.selectById(petId);
        model.addAttribute("item",pet);
        LogObjectHolder.me().set(pet);
        return PREFIX + "pet_edit.html";
    }

    /**
     * 获取宠物管理列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return petService.selectList(null);
    }

    /**
     * 新增宠物管理
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(Pet pet) {
        petService.insert(pet);
        return SUCCESS_TIP;
    }

    /**
     * 删除宠物管理
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer petId) {
        petService.deleteById(petId);
        return SUCCESS_TIP;
    }

    /**
     * 修改宠物管理
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Pet pet) {
        petService.updateById(pet);
        return SUCCESS_TIP;
    }

    /**
     * 宠物管理详情
     */
    @RequestMapping(value = "/detail/{petId}")
    @ResponseBody
    public Object detail(@PathVariable("petId") Integer petId) {
        return petService.selectById(petId);
    }
}
