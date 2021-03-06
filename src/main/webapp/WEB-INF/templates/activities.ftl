<#include "parts/activities-list.ftl"/>
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
<main>
    <div class="wrapper">
        <div class="activities_wrap">
            <h2>Мероприятия</h2>

            <div class="activities">
                <div class="filter">
                    <form>
                        <p>Поиск по мероприятиям</p>

                        <div class="row">
                            <p>Название</p>
                            <input type="text" name="name" tabindex="1">
                        </div>

                        <div class="row clearfix" id="price">
                            <p>Цена</p>
                            <input type="text" name="price1" tabindex="2" placeholder="От 100 Р">
                            <input type="text" name="price2" tabindex="3" placeholder="До 10 000 Р">
                        </div>

                        <div class="row bold">
                            <p>Статус</p>
                            <select class="js-example-basic-single" style="width: 100%">
                                <option value="AL">Открытое мероприятие</option>
                                <option value="WY">Закрытое мероприятие</option>
                            </select>
                        </div>

                        <div class="row clearfix bold">
                            <p>Дата проведения</p>
                            <select class="js-example-basic-single" id="date" style="width: 70%">
                                <option value="AL">Сентябрь</option>
                                <option value="WY">Октябрь</option>
                            </select>
                            <select id="year">
                                <option>2010</option>
                                <option>2011</option>
                                <option>2012</option>
                                <option>2013</option>
                                <option>2014</option>
                                <option selected>2015</option>
                                <option>2016</option>
                                <option>2017</option>
                                <option>2018</option>
                                <option>2019</option>
                                <option>2020</option>
                            </select>
                        </div>

                        <div class="row">
                            <p>Тип мероприятия</p>
                            <select class="js-example-basic-single" style="width: 100%">
                                <option value="AL">Мастер-класс</option>
                                <option value="WY">Кастер-мласс</option>
                            </select>
                        </div>

                        <div class="row">
                            <p>Для кого</p>
                            <select class="js-example-basic-single" style="width: 100%">
                                <option value="AL">Юрист</option>
                                <option value="WY">Каратист</option>
                            </select></div>

                        <div class="row">
                            <p>Тематика мероприятия</p>
                            <select class="js-example-basic-single" style="width: 100%">
                                <option value="AL">Тематика 1</option>
                                <option value="WY">Тематика 2</option>
                            </select></div>


                        <button type="submit" name="submit" class="btn">Найти</button>

                    </form>
                </div>
                <div class="activities_block" id="activities_list">
                <@activities_list activities/>
                </div>

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
<script src="/resources/bower/select2/dist/js/select2.full.min.js"></script>
<script src="/resources/js/smooth.js"></script>
<script>
    $(".js-example-basic-single").select2({
        minimumResultsForSearch: -1
    });
</script>
<script src="/resources/js/data_quotes.js"></script>
<script src="/resources/js/common.js"></script>
<script src="/resources/js/catalog.js"></script>

</body>
</html>