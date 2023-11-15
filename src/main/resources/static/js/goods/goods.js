var table = layui.table

// 第一个实例
var tableIns = table.render({
    elem: '#goodsList'
    , url: '/goods'
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
        {field: 'id', title: '商品id', width: 90}
        , {field: 'name', title: '商品名称', width: 150, templet: "#goodsNameAndTag"}
        , {field: 'img', title: '商品图片', templet: '#goodsListImage'}
        , {field: 'description', title: '商品描述'}
        , {field: 'creator', title: '创建人', width: 90}
        , {field: 'createTime', title: '创建时间'}
        , {field: 'modifier', title: '修改人', width: 90}
        , {field: 'modifyTime', title: '修改时间'}
        , {title: '操作', toolbar: '#goodsBar'}
    ]]
});

// 按条件查询
function query() {
    tableIns.reload({
        where: {
            goodsId: $("#goodsId").val(),
            goodsName: $("#goodsName").val()
        }
        , page: {
            curr: 1 //重新从第 1 页开始
        }
    });
}


var _goodsImage = ''; // 商品图片base64

function handleFiles(files) {
    for (var i = 0; i < files.length; i++) {
        var file = files[i];
        var imageType = /^image\//;

        if (!imageType.test(file.type)) {
            continue;
        }

        var img = document.getElementById("goodsImage")
        img.classList.add("obj");
        img.file = file;

        var reader = new FileReader();
        reader.onload = (function (aImg) {
            return function (e) {
                _goodsImage = e.target.result;
                aImg.src = e.target.result;
            };
        })(img);
        reader.readAsDataURL(file);
    }
}


function goodsAdd() {
    openLayer('/goods/goodsAdd', '新增商品');

    layui.form.render();

    mySubmit('goodsSubmit', 'POST');

}


//监听工具条
table.on('tool(goodsTable)', function (obj) { //注：tool 是工具条事件名，test 是 table 原始容器的属性 lay-filter="对应的值"
    var data = obj.data; //获得当前行数据
    var layEvent = obj.event; //获得 lay-event 对应的值（也可以是表头的 event 参数对应的值）
    let id = data.id;

    if (layEvent === 'del') { //删除
        layer.confirm('真的删除商品么', function (index) {
            myDelete("/goods/" + id);
            layer.close(index);
        });
    } else if (layEvent === 'edit') { //编辑
        openLayer('/goods/goodsUpdate/' + id, '修改商品')
        layui.form.render();
        mySubmit("goodsUpdateSubmit", "PUT")
    } else if (layEvent === 'tag') { //打标
        openLayer('/goods/goodsTag/' + id, '打标')
        layui.form.render();
    }
});