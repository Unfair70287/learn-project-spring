<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="shortcut icon" type="image/x-icon" href="backend/img/smalllogo.png" />

<title>好學生後台管理首頁</title>
</head>
<body data-ma-theme="green">
<jsp:include page="BackendHeader.jsp"/>

<section class="content">
<header class="content__title">
                <h1>好學生後台管理首頁</h1>

            </header>
            <div class="row quick-stats">
                <div class="col-sm-6 col-md-3">
                    <div class="quick-stats__item bg-blue">
                        <div class="quick-stats__info">
                            <h2>987,459</h2><small>網頁瀏覽人次</small>
                        </div>
                        <div class="quick-stats__chart sparkline-bar-stats">6,4,8,6,5,6,7,8,3,5,9,5</div>
                    </div>
                </div>
                <div class="col-sm-6 col-md-3">
                    <div class="quick-stats__item bg-amber">
                        <div class="quick-stats__info">
                            <h2>356,785</h2><small>活動參加人次</small>
                        </div>
                        <div class="quick-stats__chart sparkline-bar-stats">4,7,6,2,5,3,8,6,6,4,8,6</div>
                    </div>
                </div>
                <div class="col-sm-6 col-md-3">
                    <div class="quick-stats__item bg-purple">
                        <div class="quick-stats__info">
                            <h2>$58,778K</h2><small>課程收入</small>
                        </div>
                        <div class="quick-stats__chart sparkline-bar-stats">9,4,6,5,6,4,5,7,9,3,6,5</div>
                    </div>
                </div>
                <div class="col-sm-6 col-md-3">
                    <div class="quick-stats__item bg-red">
                        <div class="quick-stats__info">
                            <h2>178,214</h2><small>專欄閱讀次數</small>
                        </div>
                        <div class="quick-stats__chart sparkline-bar-stats">5,6,3,9,7,5,4,6,5,6,4,9</div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6">
                    <div class="card">
                        <div class="card-body">
                            <h4 class="card-title">課程購買人數</h4>
                            <h6 class="card-subtitle">numbers of course bought</h6>
                            <div class="flot-chart flot-curved-line"></div>
                            <div class="flot-chart-legends flot-chart-legends--curved"></div>
                        </div>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="card">
                        <div class="card-body">
                            <h4 class="card-title">試卷作答人數</h4>
                            <h6 class="card-subtitle">numbers of exam practiced</h6>
                            <div class="flot-chart flot-line"></div>
                            <div class="flot-chart-legends flot-chart-legends--line"></div>
                        </div>
                    </div>
                </div>
            </div>

            <footer class="footer hidden-xs-down">
                <p>Copyright © 2022 Good Student. All rights <a href="http://www.bootstrapmb.com/"
                        title="bootstrapmb">Reserved</a>.
                </p>

            </footer>


            
           
        </section>
    
</body>
</html>