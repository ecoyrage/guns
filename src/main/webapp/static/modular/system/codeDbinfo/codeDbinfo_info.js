/**
 * 初始化详情对话框
 */
var CodeDbinfoInfoDlg = {
    codeDbinfoInfoData : {}
};

/**
 * 清除数据
 */
CodeDbinfoInfoDlg.clearData = function() {
    this.codeDbinfoInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
CodeDbinfoInfoDlg.set = function(key, val) {
    this.codeDbinfoInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
CodeDbinfoInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
CodeDbinfoInfoDlg.close = function() {
    parent.layer.close(window.parent.CodeDbinfo.layerIndex);
}

/**
 * 收集数据
 */
CodeDbinfoInfoDlg.collectData = function() {
    this
    .set('id')
    .set('name')
    .set('dbDriver')
    .set('dbUrl')
    .set('dbUserName')
    .set('dbPassword')
    .set('dbType')
    .set('createTime')
    .set('updateTime');
}

/**
 * 提交添加
 */
CodeDbinfoInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/codeDbinfo/add", function(data){
        Feng.success("添加成功!");
        window.parent.CodeDbinfo.table.refresh();
        CodeDbinfoInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.codeDbinfoInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
CodeDbinfoInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/codeDbinfo/update", function(data){
        Feng.success("修改成功!");
        window.parent.CodeDbinfo.table.refresh();
        CodeDbinfoInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.codeDbinfoInfoData);
    ajax.start();
}

$(function() {

});
