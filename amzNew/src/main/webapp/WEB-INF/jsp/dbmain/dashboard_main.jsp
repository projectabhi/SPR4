<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<title>Quick Search Amazon</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<link rel="stylesheet" href="../css/dboard_main.css">
<link rel="stylesheet" href="../css/fonts.css">
<link rel="stylesheet" href="../css/custom-min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/jquery-1.11.1.min.js"></script>
<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script type="text/javascript" src="../js/sockjs.js" /></script>
<script type="text/javascript" src="../js/stomp.js" /></script>
<script type="text/javascript" src="../js/application.js" /></script>
<script src="../js/customDbJquery.js"></script>
<style>
html, body, h1, h2, h3, h4, h5 {
	font-family: "Raleway", sans-serif
}
</style>
<body class="w3-light-grey">
	<form id="srchFrm" method="post">
		<!-- Top container -->
		<div class="w3-bar w3-top w3-black w3-large" style="z-index: 4">
			<button
				class="w3-bar-item w3-button w3-hide-large w3-hover-none w3-hover-text-light-grey"
				onclick="w3_open();">
				<i class="fa fa-bars"></i> Menu
			</button>
			<span class="w3-bar-item w3-right"><img
				src="../img/13DLogo.png" style="width: 48px"></span>
		</div>

		<!-- Sidebar/menu -->
		<nav class="w3-sidebar w3-collapse w3-white w3-animate-left"
			style="z-index: 3; width: 300px;" id="mySidebar">
			<br>
			<div class="w3-container w3-row">
				<div class="w3-col s4">
					<img src="../img/avatar_small.jpg"
						class="w3-circle w3-margin-right" style="width: 46px">
				</div>
				<div class="w3-col s8 w3-bar">
					<span>Welcome, <strong>Guest</strong></span><br> <a href="#"
						class="w3-bar-item w3-button"><i class="fa fa-envelope"></i></a> <a
						href="#" class="w3-bar-item w3-button"><i class="fa fa-user"></i></a>
					<a href="#" class="w3-bar-item w3-button"><i class="fa fa-cog"></i></a>
				</div>
			</div>
			<hr>
			<div class="w3-container">
				<h5>Dashboard</h5>
			</div>
			<div class="w3-bar-block">
				<a href="#"
					class="w3-bar-item w3-button w3-padding-16 w3-hide-large w3-dark-grey w3-hover-black"
					onclick="w3_close()" title="close menu"><i
					class="fa fa-remove fa-fw"></i> Close Menu</a> <a href="#"
					class="w3-bar-item w3-button w3-padding w3-blue"><i
					class="fa fa-users fa-fw"></i> Overview</a> <a href="#"
					class="w3-bar-item w3-button w3-padding"><i
					class="fa fa-eye fa-fw"></i> Views</a> <a href="#"
					class="w3-bar-item w3-button w3-padding"><i
					class="fa fa-users fa-fw"></i> Traffic</a> <a href="#"
					class="w3-bar-item w3-button w3-padding"><i
					class="fa fa-bullseye fa-fw"></i> Geo</a> <a href="#"
					class="w3-bar-item w3-button w3-padding"><i
					class="fa fa-diamond fa-fw"></i> Orders</a> <a href="#"
					class="w3-bar-item w3-button w3-padding"><i
					class="fa fa-bell fa-fw"></i> News</a> <a href="#"
					class="w3-bar-item w3-button w3-padding"><i
					class="fa fa-bank fa-fw"></i> General</a> <a href="#"
					class="w3-bar-item w3-button w3-padding"><i
					class="fa fa-history fa-fw"></i> History</a> <a href="#"
					class="w3-bar-item w3-button w3-padding"><i
					class="fa fa-cog fa-fw"></i> Settings</a><br>
				<br>
			</div>
		</nav>


		<!-- Overlay effect when opening sidebar on small screens -->
		<div class="w3-overlay w3-hide-large w3-animate-opacity"
			onclick="w3_close()" style="cursor: pointer" title="close side menu"
			id="myOverlay"></div>

		<!-- !PAGE CONTENT! -->
		<div class="w3-main" style="margin-left: 300px; margin-top: 43px;">

			<!-- Header -->
			<header class="w3-container" style="padding-top: 22px">
				<h5>
					<b><i class="fa fa-dashboard"></i> My Dashboard</b>
				</h5>
			</header>

			<div class="w3-row-padding w3-margin-bottom">
				<div class="w3-quarter">
					<div class="w3-container w3-red w3-padding-16">
						<div class="w3-left">
							<i class="fa fa-comment w3-xxxlarge"></i>
						</div>
						<div class="w3-right">
							<h3>52</h3>
						</div>
						<div class="w3-clear"></div>
						<h4>Messages</h4>
					</div>
				</div>
				<div class="w3-quarter">
					<div class="w3-container w3-blue w3-padding-16">
						<div class="w3-left">
							<i class="fa fa-eye w3-xxxlarge"></i>
						</div>
						<div class="w3-right">
							<div id="clientMsg">
								<h3 id="serverMsg"></h3>
							</div>
						</div>
						<div class="w3-clear"></div>
						<h4>Views</h4>
					</div>
				</div>
				<div class="w3-quarter">
					<div class="w3-container w3-teal w3-padding-16">
						<div class="w3-left">
							<i class="fa fa-share-alt w3-xxxlarge"></i>
						</div>
						<div class="w3-right">
							<h3>23</h3>
						</div>
						<div class="w3-clear"></div>
						<h4>Shares</h4>
					</div>
				</div>
				<div class="w3-quarter">
					<div class="w3-container w3-orange w3-text-white w3-padding-16">
						<div class="w3-left">
							<i class="fa fa-users w3-xxxlarge"></i>
						</div>
						<div class="w3-right">
							<div id="userMsg">
								<h3 id="users">1</h3>
							</div>
						</div>
						<div class="w3-clear"></div>
						<h4>Users</h4>
					</div>
				</div>
			</div>

			<div class="container">
				<div class="row">
					<div class="col-xs-8 col-xs-offset-2">
						<div class="input-group">
							<div class="input-group-btn search-panel">
								<button type="button" class="btn btn-default dropdown-toggle"
									data-toggle="dropdown" style="height: 34px;" onclick=""
									aria-expanded="true">
									<span id="search_concept">Filter by</span> <span class="caret"></span>
								</button>
								<ul class="dropdown-menu" role="menu">
									<c:forEach var="cat" items="${categories}">
										<li><a href="${cat.categoryName}"><c:out
													value="${cat.categoryName}"></c:out></a></li>
									</c:forEach>
									<li class="divider"></li>
									<li><a href="All">All</a></li>
								</ul>
							</div>
							<spring:bind path="searchForm.searchIndex">
								<input type="hidden"
									name="<c:out value="${status.expression}"/>"
									value="<c:out value="${status.value}"/>" id="search_param">
							</spring:bind>
							<spring:bind path="searchForm.keywords">
								<input type="text" id="<c:out value="${status.expression}"/>"
									name="<c:out value="${status.expression}"/>"
									value="<c:out value="${status.value}"/>" class="form-control"
									placeholder="Search term...">
							</spring:bind>
							<span class="input-group-btn">
								<button id="searchButton" class="btn btn-default" type="button"
									style="height: 34px; width: 50px;">
									<span class="glyphicon glyphicon-search"></span>
								</button>
							</span>
						</div>
					</div>
				</div>
			</div>
			<div class="container">
				<div class="row">
					<div class="col-xs-8 col-xs-offset-2">
						<script type="text/javascript" language="javascript">
				var aax_size = '728x90';
				var aax_pubname = 'amzborokali-21';
				var aax_src = '302';
			</script>
						<script type="text/javascript" language="javascript"
							src="http://c.amazon-adsystem.com/aax2/assoc.js"></script>
					</div>
				</div>
			</div>

			<div class="tab-content"
				<c:if test="${searchPresent eq 'Y'}">style="display: none;"</c:if>>
				<div id="RenderedSection" class="tab-pane fade active in">
					<div id="RenderedResponseDiv" class="well-R">
						<c:set var="itemOffers" value="${allItem}" />
						<c:forEach var="item" items="${itemOffers.listIemSearh}">
							<div class="product-box">
								<a target="_blank" href="${item.detailPageURL}"> <img
									src="${item.mediumImgUrl}" height="160" width="120">
								</a>
								<div class="product-title">
									<h3>${item.itemTitle}</h3>
								</div>
								<p class="product-price">
									${item.formattedPrice} <br> <a target="_blank"
										href="${item.allOffersUrl}">More Offers</a>
								</p>
								<div>
									<span class="a-button a-button-primary"> <a
										target="_blank" href="${item.detailPageURL}"
										style="text-decoration: none"> <span
											class="a-button-inner"> <img
												class="a-icon a-icon-shop-now"
												src="../img/Amazon-Favicon-64x64.png"> <input
												class="a-button-input" value="Add to Cart" type="submit">
												<span class="a-button-text">Shop Now</span>
										</span>
									</a>
									</span>
								</div>
							</div>
						</c:forEach>
						<div class="product-box" style="border: none;">
							<img src="../img/more_results.png" height="160" width="120">
							<div>
								<h4 style="text-align: center;">
									<a target="_blank" href="${itemOffers.moreResultUrl}">More
										Results</a> <br>
								</h4>
							</div>
						</div>
					</div>
				</div>
			</div>

			<!-- Search Result -->

			<div class="container-fluid">
				<div class="row">
					<c:forEach var="srchLst" items="${searchList}" varStatus="theCount">
						<div class="col-md-3">
							<div class="thumbnail">
								<img src="${srchLst.mediumImgUrl}" alt="" class="img-responsive">
								<div class="caption">
									<h4 class="pull-right">${srchLst.formattedPrice}</h4>
									<h6 small>
										<a class="w3-bar w3-padding w3-tag"	
											<c:if test="${srchLst.detailPageUrl ne null }"> href="${srchLst.detailPageUrl}" </c:if>>
										${srchLst.title}
										</a>
									</h6>
									<div  class="col-lg-12 col-md-12 col-sm-12" style="height:100px;overflow-y:auto;">
									${srchLst.editorReview}
									</div>
								
									<div class="space-ten"></div>
									<div class="btn-ground text-center">
										<button type="button" class="bmd-modalButton" data-toggle="modal" data-bmdSrc="${srchLst.customerReviewUrl}"
										data-bmdWidth="600" data-bmdHeight="450" data-target="#myModal" title="Reviews"><i class="fa fa-heartbeat"></i>
										</button>
										<button type="button" class="btn btn-primary" title="Add To Cart">
											<i class="fa fa-shopping-cart"></i> 
										</button>
										<button type="button" class="btn btn-primary"
											data-toggle="modal"
											data-target="#product_view_${theCount.count}" title="Quick View">
											<i class="fa fa-search"></i> 
										</button>
									</div>
									<div class="space-ten"></div>
								</div>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>

			<!-- Populate Modal -->
			<c:forEach var="srchLst" items="${searchList}" varStatus="theCount">
				<div class="modal fade product_view" id="product_view_${theCount.count}">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<a href="#" data-dismiss="modal" class="class pull-right">
									<span class="glyphicon glyphicon-remove"></span>
								</a>
								<h3 class="modal-title">${srchLst.title}</h3>
							</div>
							<div class="modal-body">
								<div class="row">
									<div class="col-md-6 product_img">
										<img src="${srchLst.largeImgUrl}" class="img-responsive">
									</div>
									<div class="col-md-6 product_content">
										<h4>
											Product Id: <span>${srchLst.asin}</span>
										</h4>
										<c:forEach items="${srchLst.feature}" var="ftrs">
											<p>${ftrs}</p>
										</c:forEach>
										<p></p>
										<h3 class="cost">
											${srchLst.actualFormattedPrc}
											<c:if test="${srchLst.formattedPrice ne null}"><small class="pre-cost">${srchLst.formattedPrice}</small></c:if>
											<c:if test="${srchLst.saved ne null}">Saved Amount:<small class="pre-cost">${srchLst.saved}</small></c:if>
											<c:if test="${srchLst.percentSaved ne null || srchLst.percentSaved != 0 }"><small class="pre-cost">${srchLst.percentSaved}</small>%</c:if>
										</h3>
										<div class="row">
											<div class="col-md-4 col-sm-6 col-xs-12">
												<select class="form-control" name="select">
													<option value="" selected="">Color</option>
													<option value="black">Black</option>
													<option value="white">White</option>
													<option value="gold">Gold</option>
													<option value="rose gold">Rose Gold</option>
												</select>
											</div>
											<!-- end col -->
											<div class="col-md-4 col-sm-6 col-xs-12">
												<select class="form-control" name="select">
													<option value="">Capacity</option>
													<option value="">16GB</option>
													<option value="">32GB</option>
													<option value="">64GB</option>
													<option value="">128GB</option>
												</select>
											</div>
											<!-- end col -->
											<div class="col-md-4 col-sm-12">
												<select class="form-control" name="select">
													<option value="" selected="">QTY</option>
													<option value="">1</option>
													<option value="">2</option>
													<option value="">3</option>
												</select>
											</div>
											<!-- end col -->
										</div>
										<div class="space-ten"></div>
										<div class="btn-ground">
											<button type="button" class="btn btn-primary">
												<span class="glyphicon glyphicon-shopping-cart"></span> Add
												To Cart
											</button>
											<button type="button" class="btn btn-primary">
												<span class="glyphicon glyphicon-heart"></span> <a
													href="${srchLst.addToWishUrl}" data-dismiss="modal"
													class="class pull-right"><span
													class="glyphicon glyphicon-remove"></span></a>Add To Wishlist
											</button>
										</div>
									</div>
								</div>
							</div>
							.
						</div>
					</div>
				</div>
			</c:forEach>
			<!-- Populate Modal -->
			<!-- Search Result -->
			<hr>
			<hr>
			<hr>
			<hr>
			<div class="w3-container">
				<h5>Recent Comments</h5>
				<div class="w3-row">
					<div class="w3-col m2 text-center">
						<img class="w3-circle" src="../img/geek.jpg"
							style="width: 96px; height: 96px">
					</div>
					<div class="w3-col m10 w3-container">
						<h4>
							John <span class="w3-opacity w3-medium">Sep 29, 2014, 9:12
								PM</span>
						</h4>
						<p>Keep up the GREAT work! I am cheering for you!! Lorem ipsum
							dolor sit amet, consectetur adipiscing elit, sed do eiusmod
							tempor incididunt ut labore et dolore magna aliqua.</p>
						<br>
					</div>
				</div>
				<div class="w3-row">
					<div class="w3-col m2 text-center">
						<img class="w3-circle" src="../img/medusa.jpg" style="width: 96px; height: 96px">
					</div>
					<div class="w3-col m10 w3-container">
						<h4>
							Medusa <span class="w3-opacity w3-medium">Sep 28, 2014,
								10:15 PM</span>
						</h4>
						<p>Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
						<br>
					</div>
				</div>
			</div>
			<br>
			<div class="modal fade" id="myModal">
				<div class="modal-dialog">
					<div class="modal-content bmd-modalContent">
						<div class="modal-body">
							<div class="close-button">
								<button type="button" class="close" data-dismiss="modal" aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
							</div>
							<div class="embed-responsive embed-responsive-16by9">
								<iframe class="embed-responsive-item" frameborder="0"></iframe>
							</div>
						</div>
					</div>
					<!-- /.modal-content -->
				</div>
				<!-- /.modal-dialog -->
			</div>
			<!-- /.modal -->

			<!-- Footer -->
			<footer class="w3-container w3-padding-16 w3-light-grey">
				<p>&copy; BOROKALI</p>
			</footer>

			<!-- End page content -->
		</div>
		<script>
			var mySidebar = document.getElementById("mySidebar");
			var overlayBg = document.getElementById("myOverlay");
			
			// Toggle between showing and hiding the sidebar, and add overlay effect
			function w3_open() {
			    if (mySidebar.style.display === 'block') {
			        mySidebar.style.display = 'none';
			        overlayBg.style.display = "none";
			    } else {
			        mySidebar.style.display = 'block';
			        overlayBg.style.display = "block";
			    }
			}
			
			// Close the sidebar with the close button
			function w3_close() {
			    mySidebar.style.display = "none";
			    overlayBg.style.display = "none";
			}
		</script>
</form>
</body>
</html>