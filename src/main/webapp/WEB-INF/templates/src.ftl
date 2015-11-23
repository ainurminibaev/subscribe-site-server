<#include "parts/partners.ftl"/>
<#include "parts/header.ftl"/>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Мероприятия - Портал профессионального развития юристов</title>
    <link rel="stylesheet" href="/resources/bower/select2/dist/css/select2.css">
    <link rel="stylesheet" href="/resources/css/main.css">
    <link rel="stylesheet" href="/resources/css/activities.css">
</head>
<body>
<div class="wrapper">
    <@header/>
</div>
<main id="src">
    <div class="wrapper src-wrap">
        <h2>Архив рассылок</h2>

        <div class="row" id="src_theme">
            <p>Тематика</p>
            <select class="js-example-basic-single" style="width: 24.64788732394366%">
                <option value="AL">Все</option>
                <option value="WY">блабла</option>
            </select>
        </div>
        <ul>
            <li><a href="#">Рассылка # NB–463 / 21.09.15 тематика: законы</a></li>
            <li><a href="#">Рассылка # NB–463 / 21.09.15 тематика: законы</a></li>
            <li><a href="#">Рассылка # NB–463 / 21.09.15 тематика: законы</a></li>
            <li><a href="#">Рассылка # NB–463 / 21.09.15 тематика: законы</a></li>
            <li><a href="#">Рассылка # NB–463 / 21.09.15 тематика: законы</a></li>
            <li><a href="#">Рассылка # NB–463 / 21.09.15 тематика: законы</a></li>
            <li><a href="#">Рассылка # NB–463 / 21.09.15 тематика: законы</a></li>
            <li><a href="#">Рассылка # NB–463 / 21.09.15 тематика: законы</a></li>
            <li><a href="#">Рассылка # NB–463 / 21.09.15 тематика: законы</a></li>
            <li><a href="#">Рассылка # NB–463 / 21.09.15 тематика: законы</a></li>

        </ul>

    </div>

    <div class="partners_wrap">
        <div class="wrapper">
        <@partners/>
        </div>
    </div>

    <footer class="footer">
        <div id="quote-div" class="wrapper">
            <p>Mauris id condimentum justo. Suspendisse cursus finibus neque. Interdum et malesuada fames ac ante ipsum
                primis in faucibus. Mauris porta eu lacus at ultricies. Quisque mattis gravida dolor, sit amet scelerisque
                mauris facilisis non. Maecenas iaculis urna eu diam venenatis, molestie tempus volutpat.</p>
            <span>- Джордж Бернард Шоу</span>
        </div>
    </footer>
</main>
<script src="/resources/bower/jquery/dist/jquery.min.js"></script>
<script src="/resources/bower/select2/dist/js/select2.full.min.js"></script>
<script src="/resources/js/smooth.js"></script>
<script>
    function resize(){
        if($(window).width() < 483){
            $(".js-example-basic-single").select2({
                width: '100%'
            });
        }
        else {
            $(".js-example-basic-single").select2();
        }
    }
    resize();
    $(window).resize(function(){
        resize();
    });



</script>
<script src="/resources/js/data_quotes.js"></script>
<script src="/resources/js/common.js"></script>

</body>
</html>