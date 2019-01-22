/**
 * 初始化宠物管理详情对话框
 */
var PetInfoDlg = {
    petInfoData : {}
};

/**
 * 清除数据
 */
PetInfoDlg.clearData = function() {
    this.petInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
PetInfoDlg.set = function(key, val) {
    this.petInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
PetInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
PetInfoDlg.close = function() {
    parent.layer.close(window.parent.Pet.layerIndex);
}

/**
 * 收集数据
 */
PetInfoDlg.collectData = function() {
    this
    .set('id')
    .set('pname')
    .set('pgender')
    .set('page');
}

/**
 * 提交添加
 */
PetInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/pet/add", function(data){
        Feng.success("添加成功!");
        window.parent.Pet.table.refresh();
        PetInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.petInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
PetInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/pet/update", function(data){
        Feng.success("修改成功!");
        window.parent.Pet.table.refresh();
        PetInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.petInfoData);
    ajax.start();
}

$(function() {

});
