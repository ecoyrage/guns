/**
 * 管理初始化
 */
var CodeDbinfo = {
    id: "CodeDbinfoTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
CodeDbinfo.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '', field: 'id', visible: true, align: 'center', valign: 'middle'},
            {title: '别名', field: 'name', visible: true, align: 'center', valign: 'middle'},
            {title: '数据库驱动', field: 'dbDriver', visible: true, align: 'center', valign: 'middle'},
            {title: '数据库地址', field: 'dbUrl', visible: true, align: 'center', valign: 'middle'},
            {title: '数据库账户', field: 'dbUserName', visible: true, align: 'center', valign: 'middle'},
            {title: '连接密码', field: 'dbPassword', visible: true, align: 'center', valign: 'middle'},
            {title: '数据库类型', field: 'dbType', visible: true, align: 'center', valign: 'middle'},
            {title: '创建时间', field: 'createTime', visible: true, align: 'center', valign: 'middle'},
            {title: '修改时间', field: 'updateTime', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
CodeDbinfo.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        CodeDbinfo.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加
 */
CodeDbinfo.openAddCodeDbinfo = function () {
    var index = layer.open({
        type: 2,
        title: '添加',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/codeDbinfo/codeDbinfo_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看详情
 */
CodeDbinfo.openCodeDbinfoDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/codeDbinfo/codeDbinfo_update/' + CodeDbinfo.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除
 */
CodeDbinfo.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/codeDbinfo/delete", function (data) {
            Feng.success("删除成功!");
            CodeDbinfo.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("codeDbinfoId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询列表
 */
CodeDbinfo.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    CodeDbinfo.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = CodeDbinfo.initColumn();
    var table = new BSTable(CodeDbinfo.id, "/codeDbinfo/list", defaultColunms);
    table.setPaginationType("client");
    CodeDbinfo.table = table.init();
});
