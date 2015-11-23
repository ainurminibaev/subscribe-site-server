<#macro header>
<header class="header clearfix">
    <a href="/" class="logo" tabindex="-1"><h1>Портал профессиональ&shy;ного&shy; развития юристов</h1></a>
    <@menu_common/>

    <a href="/" class="logo logo-adaptive" tabindex="-1"><img src="/resources/img/menu.png" alt="menu" class="for_adaptive">

        <h1>Портал профессионального развития юристов</h1></a>

    <div class="adaptive_menu">
        <img src="/resources/img/menu.png" alt="menu" class="for_adaptive" id="close_adaptive">
        <@menu_common/>
    </div>
    <div id="adaptive_body"></div>
</header>
</#macro>

<#macro menu_common>
<menu>
    <li><a href="/archive" tabindex="-1">Архив рассылок</a></li>
    <li><a href="#partners" tabindex="-1">Партнеры</a></li>
    <li><a href="/activities" tabindex="-1">Мероприятия</a></li>
</menu>
</#macro>