<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>Мероприятия - Портал профессионального развития юристов</title>
    <link rel="stylesheet" href="/resources/bower/select2/dist/css/select2.css">
    <link rel="stylesheet" href="/resources/css/main.css">
    <link rel="stylesheet" href="/resources/css/activities.css">
</head>
<body>
<div class="wrapper">
    <header class="header clearfix">
        <a href="/" class="logo" tabindex="-1"><h1>Портал профессиональ-<br>ного развития юристов</h1></a>

        <menu>
            <li><a href="/archive" tabindex="-1">Архив рассылок</a></li>
            <li><a href="#partners" tabindex="-1">Партнеры</a></li>
            <li><a href="activities.html" tabindex="-1">Мероприятия</a></li>
        </menu>
    </header>
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
            <ul class="partners" id="partners">
                <li><a href="#" tabindex="-1"><img src="/resources/img/1.jpg" alt="1"></a></li>
                <li><a href="#" tabindex="-1"><img src="/resources/img/2.jpg" alt="1"></a></li>
                <li><a href="#" tabindex="-1"><img src="/resources/img/3.jpg" alt="1"></a></li>
                <li><a href="#" tabindex="-1"><img src="/resources/img/4.jpg" alt="1"></a></li>
                <li><a href="#" tabindex="-1"><img src="/resources/img/5.jpg" alt="1"></a></li>
                <li><a href="#" tabindex="-1"><img src="/resources/img/6.jpg" alt="1"></a></li>
                <li><a href="#" tabindex="-1"><img src="/resources/img/7.jpg" alt="1"></a></li>
            </ul>

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