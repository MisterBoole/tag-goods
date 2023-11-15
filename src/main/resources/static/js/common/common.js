// 公共弹出层
function openLayer(url, title) {
    //先设置完同步
    $.ajaxSettings.async = false;
    $.get(url, function (res) {
        layer.open({
            type: 1
            , title: title
            , area: ['800px', '450px']
            , content: res
        });
    });
    //再设置异步
    $.ajaxSettings.async = true;
}

// 监听提交事件
function mySubmit(filter, type, func) {
    layui.form.on('submit('+ filter + ')', function (data) {

        if (typeof(func) != 'undefined') {
            func(data.field)
        }

        if((filter === 'goodsSubmit' || filter === 'goodsUpdateSubmit') && _goodsImage !== '') {
            data.field.img = _goodsImage;
        }

        $.ajax({
            url: data.form.action
            , async: false
            , type: type
            , contentType: 'application/json;charset=utf-8'
            , data: JSON.stringify(data.field)
            , success: function (res) {
                if (res.code == 0) {
                    layer.closeAll();
                    query();
                } else {
                    layer.alert(res.msg);
                }
            }
        })
        return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
    });
}


function myDelete(url) {
    $.ajax({
        url: url
        , async: false
        , type: "DELETE"
        , success: function (res) {
            if (res.code == 0) {
                // layer.closeAll();
                query();
            } else {
                layer.alert(res.msg);
            }
        }
    })
}