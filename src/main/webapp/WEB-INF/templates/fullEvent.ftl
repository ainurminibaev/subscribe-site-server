<#-- @ftlvariable name="event" type="ru.jblab.subscribe.dto.EventFull"-->
<#include "parts/partners.ftl"/>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>Мероприятие - Портал профессионального развития юристов</title>
    <link rel="stylesheet" href="/resources/css/main.css">
    <link rel="stylesheet" href="/resources/css/full.css">
</head>
<body>
<div class="wrapper clearfix">
    <header class="header clearfix">
        <a href="/" class="logo" tabindex="-1"><h1>Портал профессиональ-<br>ного развития юристов</h1></a>

        <menu>
            <li><a href="/archive" tabindex="-1">Архив рассылок</a></li>
            <li><a href="#partners" tabindex="-1">Партнеры</a></li>
            <li><a href="/activities" tabindex="-1">Мероприятия</a></li>
        </menu>
    </header>
</div>
<main>


    <div class="wrapper">

        <div class="event_wrap clearfix">
            <div class="event_img">
                <img src="${event.img}" alt="third">
            </div>
            <div class="event_info">
                <h2>${event.name}</h2>
                <table class="info">
                    <tr>
                        <td>Что:</td>
                        <td>${event.type}</td>
                    </tr>
                    <tr>
                        <td>Где:</td>
                        <td>${event.place}</td>
                    </tr>
                    <tr>
                        <td>Когда:</td>
                        <td>${event.when}</td>
                    </tr>
                    <tr>
                        <td>Для кого:</td>
                        <td>${event.forWhom}</td>
                    </tr>
                    <tr>
                        <td>Стоимость:</td>
                        <td class="price">${event.cost}</td>
                    </tr>
                    <tr>
                        <td>Организатор:</td>
                        <td>${event.organizerFIO}</td>
                    </tr>
                    <tr>
                        <td></td>
                        <td class="tel"><img src="/resources/img/telephone.png" alt="tel">${event.organizerPhone}</td>
                    </tr>
                    <tr>
                        <td></td>
                        <td class="mail"><img src="/resources/img/mail.png" alt="mail">${event.organizerEmail}</td>
                        <td>
                            <button class="btn go-btn"><a href="${event.link!"#"}">Хочу пойти</a></button>
                        </td>
                    </tr>
                </table>

                <p class="program">В программе:</p>
                <ul class="program_list">
                    <li>-Трудовой договор и договор гражданско-правового характера.</li>
                    <li>-Трудовой договор и договор гражданско-правового характера.</li>
                    <li>-Трудовой договор и договор гражданско-правового характера.</li>
                    <li>-Трудовой договор и договор гражданско-правового характера.</li>
                </ul>

                <p class="more">Дополнительная информация:</p>

                <table class="more_info">
                    <tr>
                        <td>Режим занятости:</td>
                        <td>Мастер класс</td>
                    </tr>
                    <tr>
                        <td>Входные испытания:</td>
                        <td>Собеседование</td>
                    </tr>
                    <tr>
                        <td>Итоговые испытания:</td>
                        <td>Тестирование</td>
                    </tr>
                    <tr>
                        <td>Уровень образования:</td>
                        <td>Высшее</td>
                    </tr>
                    <tr>
                        <td>Документ об окончаниях:</td>
                        <td>Сертификат</td>
                    </tr>
                    <tr>
                        <td>Условия проживания:</td>
                        <td>Гостиница "Чехов"</td>
                    </tr>
                    <tr>
                        <td>Транспортные расходы:</td>
                        <td>Оплачивает организатор</td>
                    </tr>
                </table>
                <button class="btn go-btn"><a href="${event.link!"#"}">Хочу пойти</a></button>

            </div>
        </div>
    </div>


    <div class="partners_wrap">
        <div class="wrapper">
        <@partners/>
        </div>
    </div>

    <footer class="footer">
        <div id="quote-div" class="wrapper">
            <p>Mauris id condimentum justo. Suspendisse cursus finibus neque. Interdum et malesuada fames ac ante ipsum
                primis in faucibus. Mauris porta eu lacus at ultricies. Quisque mattis gravida dolor, sit amet
                scelerisque
                mauris facilisis non. Maecenas iaculis urna eu diam venenatis, molestie tempus volutpat.</p>
            <span>- Джордж Бернард Шоу</span>
        </div>
    </footer>
</main>
<script src="/resources/bower/jquery/dist/jquery.min.js"></script>
<script src="/resources/js/clickToggle.js"></script>
<script src="/resources/js/smooth.js"></script>
<script>
    ///блок дополнительная информация
    if ($(window).width() >= 887) {
        $('.more').clickToggle(function () {
            $('.more_info').show(0);
        }, function () {
            $('.more_info').hide(0);
        });
    }

    //});
</script>
<script src="/resources/js/data_quotes.js"></script>
<script src="/resources/js/common.js"></script>

</body>
</html>