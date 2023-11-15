var table = layui.table
// 第一个实例
var tableIns = table.render({
    elem: '#tagList'
    , url: '/tag'
    , page: true
    , parseData: function (res) { //res 即为原始返回的数据
        return {
            "code": res.code, //解析接口状态
            "msg": res.msg, //解析提示文本
            "count": res.data.size, //解析数据长度
            "data": res.data //解析数据列表
        };
    }
    , cols: [[
        {field: 'id', title: '标签id'}
        // , {field: 'name', title: '标签名称'}
        , {field: 'style', title: '标签样式', templet: '#tagStyleReal'}
        , {field: 'description', title: '标签描述'}
        , {field: 'creator', title: '创建人'}
        , {field: 'createTime', title: '创建时间'}
        , {field: 'modifier', title: '修改人'}
        , {field: 'modifyTime', title: '修改时间'}
        , {title: '操作', toolbar: '#tagBar'}
    ]]
});

// 按条件查询
function query() {
    tableIns.reload({
        where: {
            tagId: $("#tagId").val(),
            tagName: $("#tagName").val()
        }
        , page: {
            curr: 1 //重新从第 1 页开始
        }
    });

}


function toAdd() {
    openLayer('/tag/tagAdd', '新增标签');

    layui.form.render();

    mySubmit('addSubmit', 'POST');

}


//监听工具条
table.on('tool(tagTable)', function (obj) { //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
    var data = obj.data; //获得当前行数据
    var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
    let id = data.id;

    if (layEvent === 'del') { //删除
        layer.confirm('真的删除标签么', function (index) {
            myDelete("/tag/" + id);
            layer.close(index);
        });
    }
    if (layEvent === 'edit') { //编辑
        openLayer('/tag/tagUpdate/' + id, '修改标签')
        layui.form.render();
        mySubmit("updateSubmit", "PUT")
    }
});