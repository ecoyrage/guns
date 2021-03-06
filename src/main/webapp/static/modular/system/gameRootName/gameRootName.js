/**
 * 管理初始化
 */
var GameRootName = {
    id: "GameRootNameTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
GameRootName.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '主键id', field: 'id', visible: true, align: 'center', valign: 'middle'},
            {title: '游戏编码', field: 'gameCode', visible: true, align: 'center', valign: 'middle'},
            {title: '游戏名称', field: 'gameName', visible: true, align: 'center', valign: 'middle'},
            {title: '游戏对于的数据库', field: 'gameTable', visible: true, align: 'center', valign: 'middle'},
            {title: '房间倍率', field: 'rootRate', visible: true, align: 'center', valign: 'middle'},
            {title: '房间名称', field: 'rootName', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
GameRootName.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        GameRootName.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加
 */
GameRootName.openAddGameRootName = function () {
    var index = layer.open({
        type: 2,
        title: '添加',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/gameRootName/gameRootName_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看详情
 */
GameRootName.openGameRootNameDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/gameRootName/gameRootName_update/' + GameRootName.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除
 */
GameRootName.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/gameRootName/delete", function (data) {
            Feng.success("删除成功!");
            GameRootName.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("gameRootNameId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询列表
 */
GameRootName.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    GameRootName.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = GameRootName.initColumn();
    var table = new BSTable(GameRootName.id, "/gameRootName/list", defaultColunms);
    table.setPaginationType("client");
    GameRootName.table = table.init();
});
