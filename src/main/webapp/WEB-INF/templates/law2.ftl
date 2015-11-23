<#include "parts/partners.ftl"/>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Поздравляем! - Портал профессионального развития юристов</title>
    <link rel="stylesheet" href="/resources/bower/select2/dist/css/select2.css">
    <link rel="stylesheet" href="/resources/css/index.css">
</head>
<body>

<section id="info">

    <div class="wrapper clearfix">
        <header class="header clearfix">
            <a href="/" class="logo" tabindex="-1"><h1>Портал профессиональ-<br>ного развития юристов</h1></a>

            <menu>
                <li><a href="/archive" tabindex="-1">Архив рассылок</a></li>
                <li><a href="#partners" tabindex="-1">Партнеры</a></li>
                <li><a href="activities.html" tabindex="-1">Мероприятия</a></li>
            </menu>
        </header>
        <div class="header_info">

            <div class="info">
                <div>
                    <h2>Поздравляем<span id="userName">, Ильнур Ильнурович</span>!</h2>
                </div>
                <div>
                    <p class="law2_text">Теперь вы подписаны на рассылки и будете<br>
                        в курсе интересующих вас новостей!</p>
                </div>
            </div>

        </div>
    </div>


</section>

<main>
    <div class="wrapper">
        <form id="subscribeForm" action="/activities" method="get">
            <p class="about"> Пожалуйста, расскажите больше о себе, чтобы наша<br>
                рассылка стала более полезной для вас:</p>
            <span class="job">Каким родом деятельности вы занимаетесь?</span>

            <div class="buttons">
                <button class="btn">Учусь</button>
                <button class="btn">Работаю</button>
            </div>
            <div class="job_wrap">

                <p><a href="#" id="back"><img src="img/back.png" alt="back"></a>Учусь</p>

                <div id="study">
                    <div class="row">
                        <select class="js-example-basic-single highSchool" style="width: 100%">
                            <option></option>
                        </select>
                    </div>


                    <div class="row">
                        <select class="js-example-basic-single" id="start" style="width: 100%">
                            <option></option>
                        </select>
                    </div>

                    <div class="row">
                        <select class="js-example-basic-single over" style="width: 100%">
                            <option></option>
                        </select>
                    </div>
                </div>

                <div id="work">
                    <div class="row">
                        <select class="js-example-basic-single" style="width: 100%" id="city">
                            <option></option>
                            <option value="AL">Казань</option>
                            <option value="WY">Москва</option>
                        </select>
                    </div>

                    <div class="row">
                        <input type="text" name="job" placeholder="Профессия">
                    </div>

                    <div class="row">
                        <select class="js-example-basic-single" style="width: 100%" id="xp">
                            <option value="AL">0-5</option>
                            <option value="WY">5-10</option>
                            <option value="WY">10-15</option>
                        </select>
                    </div>

                    <div class="row">
                        <select class="js-example-basic-single highSchool" style="width: 100%" id="highSchool">
                            <option></option>
                        </select>
                    </div>

                    <div class="row">
                        <select class="js-example-basic-single over" style="width: 100%" disabled id="over">
                            <option></option>
                        </select>
                    </div>

                </div>


                <button class="btn">Сохранить</button>
            </div>
        </form>
        <@partners/>
    </div>
</main>
<footer class="footer">
    <div id="quote-div" class="wrapper">
        <p>Mauris id condimentum justo. Suspendisse cursus finibus neque. Interdum et malesuada fames ac ante ipsum
            primis in faucibus. Mauris porta eu lacus at ultricies. Quisque mattis gravida dolor, sit amet scelerisque
            mauris facilisis non. Maecenas iaculis urna eu diam venenatis, molestie tempus volutpat.</p>
        <span>- Джордж Бернард Шоу</span>
    </div>
</footer>
<script id="template_highSchool" type="text/html">
    {{~it:value:key}}
    <option value="{{=value}}">{{=value}}</option>
    {{~}}
</script>
<script src="/resources/bower/jquery/dist/jquery.min.js"></script>
<script src="/resources/bower/select2/dist/js/select2.full.min.js"></script>
<script src="/resources/js/data_subscribs.js"></script>
<script src="/resources/js/data_highSchool.js"></script>
<script src="/resources/js/doT.js"></script>
<script src="/resources/js/law2.js"></script>
<script src="/resources/js/smooth.js"></script>
<script src="/resources/js/data_quotes.js"></script>
<script src="/resources/js/common.js"></script>

</body>
</html>