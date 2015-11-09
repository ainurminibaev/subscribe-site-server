/**
 * Created by ainurminibaev on 29.11.14.
 */
function getParameterByName(name) {
    name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
    var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"),
        results = regex.exec(location.search);
    return results === null ? "" : decodeURIComponent(results[1].replace(/\+/g, " "));
}

$(document).ready(function () {
    var page = 1;
    //$("#find-btn").click(function (e) {
    //    var $this = $(this);
    //    if (!$this.hasClass('active')) {
    //        $(".js-catalog").removeClass('active');
    //        $this.addClass("active");
    //        page = 0;
    //        $("#slider-range").slider("values", min_price, max_price);
    //        catalogAjaxReloader();
    //    }
    //    return false;
    //});

    $("#find-btn").click(function () {

    });
    $("#filter-form").submit(function (e){
        e.preventDefault();
        catalogAjaxReloader();
    });
//    var QueryString = function () {
//        // This function is anonymous, is executed immediately and
//        // the return value is assigned to QueryString!
//        var query_string = {};
//        var query = window.location.search.substring(1);
//        var vars = query.split("&");
//        for (var i = 0; i < vars.length; i++) {
//            var pair = vars[i].split("=");
//            // If first entry with this name
//            if (typeof query_string[pair[0]] === "undefined") {
//                query_string[pair[0]] = pair[1];
//                // If second entry with this name
//            } else if (typeof query_string[pair[0]] === "string") {
//                var arr = [ query_string[pair[0]], pair[1] ];
//                query_string[pair[0]] = arr;
//                // If third or later entry with this name
//            } else {
//                query_string[pair[0]].push(pair[1]);
//            }
//        }
//        return query_string;
//    }();
//    var catalog = getParameterByName("catalog");
//    if (catalog) {
//        $(".js-catalog").removeClass('active');
//        var catalog_li = $(".js-catalog[data-id=" + catalog + "]");
//        catalog_li.addClass('active');
//        $("#catalog-title").html(catalog_li.text());
//    }

    //$("#slider-range").slider({
    //    range: true,
    //    min: min_price,
    //    max: max_price,
    //    values: [c_price_l, c_price_r],
    //    slide: function (event, ui) {
    //        $("#amount").val("$" + ui.values[0] + " - $" + ui.values[1]);
    //    },
    //    stop: function (event, ui) {
    //        page = 0;
    //        catalogAjaxReloader();
    //    }
    //});

    function catalogAjaxReloader() {
        var param_map = {};
        //var catalog = $(".js-catalog.active");
        //var id = null;
        //if (catalog.length) {
        //    id = parseInt(catalog.data('id'));
        //    if (id < 0) {
        //        id = null;
        //        $("#catalog-title").html("");
        //    } else {
        //        $("#catalog-title").html(catalog.text());
        //    }
        //}

        //var values = $("#slider-range").slider("values");
        //param_map.min_price = values[0];
        //param_map.max_price = values[1];

        //param_map.catalog = id;
        param_map.page = page;
        //history.replaceState(document.URL, "Результаты поиска", "/catalog?" + buildStr(param_map));
        //param_map.csrfmiddlewaretoken = csrf_token;
        $.ajax({
            "method": "POST",
            "url": "/activities/filter",
            "data": param_map,
            "success": function (data) {
                var ddiv = $("<div></div>").append(data);
                var goods = ddiv.find(".js-good");
//                if (goods.length < 3) {
////TODO hide more btn
//                    $("#load_more").addClass('hidden');
//                } else {
//                    $("#load_more").removeClass('hidden')
//                }
                if (page == 0) {
                    $("#activities_list").html(data);
                } else {
                    $("#activities_list").append(data);
                }
                page++;
            },
            "error": function (data) {
                console.log("data loading error");
            }
        });

    }

    function buildStr(obj) {
        var str = "";
        for (var key in obj) {
            str += key + '=';
            if (obj[key]) {
                str += obj[key];
            }
            str += "&";
        }
        return str;
    }
});

