
$(function(){

    //учусь/работаю
    var job = $('.job_wrap'),
        buttons = $('.buttons');
    //job.children('div').hide();

    buttons.find('button').click(function(e) {
        e.preventDefault();
        var text = $(this).text();
        $(this).parent('div').fadeOut();
        if (text === "Учусь") {

            $('#study').addClass('active').siblings().removeClass('active');
        }
        else {
            $('#work').addClass('active').siblings().removeClass('active');
        }
        job.slideDown(1150, function () {
            job.find('#back').click(function (e) {
                e.preventDefault();
                job.slideUp(300);
                buttons.fadeIn(300);
            });
        });
        job.children('p').html('<a href="#" id="back"><img src="/resources/img/back.png" alt="back"></a>' + text);
    });

    $('.highSchool').append(
        doT.template(
            $('#template_highSchool').text()
        )(_data.highSchool)
    );

    $('.highSchool').select2({
        placeholder: "ВУЗ"
    });

    $('.js-cities').append(
        doT.template(
            $('#template_city').text()
        )(_data.cities)
    );
    ////selects
    $(".js-cities").select2();

    $('#highSchool').on('change',function(){
       $('#over').prop('disabled',false);
    });

    $('#start').select2({
        placeholder: "Год поступления"
    });

    $('.over').select2({
        placeholder: "Год окончания"
    });



    $('#city').select2({
        placeholder: "Город"
    });

    $('#xp').select2({
        placeholder: "Опыт работы",
        minimumResultsForSearch: -1
    });

    for(var i=1950; i<=2015;i++){
        $('#start, .over').append('<option>' + i + '</option>');
    }





    // send form data
    (function(){
        var data = $.extend({
            'subscribe': 'Подписаться',
            'tid': 0,
            'lang': 'ru'
        }, _data.formData);
        function send(){
            var d;
            if(_data.subscribeTo.length){
                d = $.extend(data, _data.subscribs[_data.subscribeTo.shift()]);
                $.ajax({
                    url:"https://smartresponder.ru/subscribe.html",
                    type:'POST',
                    data:d,
                    accepts:{
                        'Access-Control-Allow-Origin':'*',
                        'Access-Control-Allow-Methods': 'POST',
                        'Access-Control-Allow-Headers': 'Content-Type, Authorization, X-Requested-With'
                    },
                    crossDomain:true,
                    dataType:'jsonp'
                }).success(send).error(send)
            }
        }
        send();
    })();
});