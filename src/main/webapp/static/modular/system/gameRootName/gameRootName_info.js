/**
 * 初始化详情对话框
 */
var GameRootNameInfoDlg = {
    gameRootNameInfoData : {}
};

/**
 * 清除数据
 */
GameRootNameInfoDlg.clearData = function() {
    this.gameRootNameInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
GameRootNameInfoDlg.set = function(key, val) {
    this.gameRootNameInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
GameRootNameInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
GameRootNameInfoDlg.close = function() {
    parent.layer.close(window.parent.GameRootName.layerIndex);
}

/**
 * 收集数据
 */
GameRootNameInfoDlg.collectData = function() {
    this
    .set('id')
    .set('gameCode')
    .set('gameName')
    .set('gameTable')
    .set('rootRate')
    .set('rootName');
}

/**
 * 提交添加
 */
GameRootNameInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/gameRootName/add", function(data){
        Feng.success("添加成功!");
        window.parent.GameRootName.table.refresh();
        GameRootNameInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.gameRootNameInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
GameRootNameInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/gameRootName/update", function(data){
        Feng.success("修改成功!");
        window.parent.GameRootName.table.refresh();
        GameRootNameInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.gameRootNameInfoData);
    ajax.start();
}

$(function() {

});
