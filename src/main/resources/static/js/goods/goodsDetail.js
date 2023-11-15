window.onload = function () {
    // 商品数据
    let goodsDetail = {
        goodsList: []
    };

    // mock
    // goodsDetail = goodsDetailMock;

    let request = function () {
        $.ajax({
            url: "/goods",
            type: "GET",
            success: function (res) {
                // 真实数据
                goodsDetail.goodsList=res.data;
                // 模板绑定
                var goodsDetailDom = document.getElementById("goodsDetail").innerHTML;
                var goodsDetailData = Mustache.render(goodsDetailDom, goodsDetail);
                var goodsListDom = document.getElementById("goodsList");
                goodsListDom.innerHTML = goodsDetailData;
            },
        });
    };

    // 请求数据
    request();
};