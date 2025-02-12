<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>租房系统</title>
    <link rel="stylesheet" href="/assets/css/styles.css">
    <link rel="stylesheet" href="/assets/css/colors.css">
    <script src="/assets/js/jquery.min.js"> </script>
    <script src="/assets/js/popper.min.js"> </script>
    <script src="/assets/js/bootstrap.min.js"> </script>
    <script src="/assets/js/custom.js"> </script>
    <script src="/assets/js/moment.min.js"> </script>
    <script src="/assets/js/daterangepicker.js"> </script>
    <script src="/assets/js/dropzone.js"> </script>
    <script src="/assets/js/imagesloaded.js"> </script>
    <script src="/assets/js/ion.rangeSlider.min.js"> </script>
    <script src="/assets/js/jquery.magnific-popup.min.js"> </script>
    <script src="/assets/js/lightbox.js"> </script>
    <script src="/assets/js/markerclusterer.js"> </script>
    <script src="/assets/js/raphael.min.js"> </script>
   <!-- <script src="/assets/js/morris.js"> </script>-->
    <script src="/assets/js/select2.min.js"> </script>
    <script src="/assets/js/slick.js"> </script>
    <script src="/assets/js/slider-bg.js"> </script>
    <script src="/assets/js/script.js"> </script>

</head>
<body class="yellow-skin">
      <div class="header header-light dark-text">
          <div class="container">
              <nav class="navigation navigation-landscape">
                  <div class="nav-header">
                      <a class="nav-brand" href="/">租房系统</a>
                  </div>
                  <div class="nav-menus-wrapper">
                      <ul class="nav-menu">
                          <li><a href="/" style="font-size: 15px;">首页</a> </li>
                          <li><a href="/house?rentType=whole" style="font-size: 15px;">整租</a> </li>
                          <li><a href="/house?rentType=share" style="font-size: 15px;">合租</a> </li>
                          <li><a href="/news" style="font-size: 15px;">新闻资讯</a> </li>
                          <li><a href="/feedback" style="font-size: 15px;">用户反馈</a> </li>
                      </ul>
                  </div>
                  <c:choose>
                      <c:when test="${sessionScope.user==null}">
                          <ul class="nav-menu nav-menu-social align-to-right">
                              <li>
                                  <a href="#" class="text-blue" data-toggle="modal" data-target="#login">
                                      <i class="fas fa-user-circle mr-1"></i>
                                      <span class="dn-lg">登录</span>
                                  </a>
                              </li>
                              <li class="add-listing dark-bg">
                                  <a href="#" class="theme-cl" data-toggle="modal" data-target="#signup">
                                      <i class="fas fa-arrow-alt-circle-right mr-1"></i>
                                      <span class="dn-lg">注册</span>
                                  </a>
                              </li>
                          </ul>
                      </c:when>
                      <c:otherwise>
                          <ul class="nav-menu nav-menu-social align-to-right">
                              <li>
                                  <div class="btn-group account-drop">
                                       <button type="button" class="btn btn-order-by-filt" data-toggle="dropdown">
                                           <img src="${sessionScope.user.userAvatar}" class="avater-img">
                                               ${sessionScope.user.userDisplayName}(
                                                  <c:choose>
                                                      <c:when test="${sessionScope.user.role=='admin'}">管理员</c:when>
                                                      <c:when test="${sessionScope.user.role=='owner'}">房东</c:when>
                                                      <c:when test="${sessionScope.user.role=='customer'}">租客</c:when>
                                                      <c:otherwise>未知角色</c:otherwise>
                                                  </c:choose>
                                           )
                                       </button>
                                      <c:choose>
                                          <%--管理员--%>
                                          <c:when test="${sessionScope.user.role=='admin'}">
                                              <div class="dropdown-menu pull-right animated flipInX">
                                                  <a href="/admin/house">
                                                      <i class="ti-layers"></i>房子管理
                                                  </a>
                                                  <a href="/admin/order/">
                                                      <i class="ti-gift"></i>订单管理
                                                  </a>
                                                  <a href="/admin/news">
                                                      <i class="ti-info"></i>新闻管理
                                                  </a>
                                                  <a href="/login/logout">
                                                      <i class="ti-power-off"></i>退出登录
                                                  </a>
                                              </div>
                                          </c:when>
                                          <%--房东--%>
                                          <c:when test="${sessionScope.user.role=='owner'}">
                                              <div class="dropdown-menu pull-right animated flipInX">
                                                  <a href="/admin/profile">
                                                      <i class="ti-user"></i>个人信息
                                                  </a>
                                                  <a href="/admin/house">
                                                      <i class="ti-layers"></i>房子管理
                                                  </a>
                                                  <a href="/admin/order/">
                                                      <i class="ti-gift"></i>订单管理
                                                  </a>
                                                  <a href="/login/logout">
                                                      <i class="ti-power-off"></i>退出登录
                                                  </a>
                                              </div>
                                          </c:when>
                                          <%--租客--%>
                                          <c:when test="${sessionScope.user.role=='customer'}">
                                              <div class="dropdown-menu pull-right animated flipInX">
                                                  <a href="/admin/profile">
                                                      <i class="ti-user"></i>个人信息
                                                  </a>
                                                      <a href="/admin/home">
                                                          <i class="ti-home"></i>我的家
                                                  </a>
                                                  <a href="/admin/mark">
                                                      <i class="ti-bookmark"></i>我的收藏
                                                  </a>
                                                  <a href="/login/logout">
                                                      <i class="ti-power-off"></i>退出登录
                                                  </a>
                                              </div>
                                          </c:when>
                                      </c:choose>
                                  </div>
                              </li>
                          </ul>
                      </c:otherwise>
                  </c:choose>
              </nav>
          </div>
      </div>


