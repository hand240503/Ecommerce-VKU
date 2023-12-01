<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<nav aria-label="breadcrumb" class="breadcrumb-nav border-0 mb-0">
	<div class="container d-flex align-items-center">
		<ol class="breadcrumb">
			<li class="breadcrumb-item"><a href="<c:url value="/trang-chu" />">Home</a></li>
			<li class="breadcrumb-item"><a href="<c:url value="/products?code=${product.category.categoryCode}&page=1" />">${product.category.categoryName}</a></li>
			<li class="breadcrumb-item active" aria-current="page">${product.nameProduct}</li>
		</ol>
	</div>
</nav>
<div class="page-content">
	<div class="container">
		<div class="product-details-top">
			<div class="row">
				<div class="col-md-6">
					<div class="product-gallery product-gallery-vertical">
						<div class="row">
							<figure class="product-main-image">
								<img id="product-zoom" src="<c:url value="${product.imageModel.pathImageProduct }"/>"
									data-zoom-image=""
									alt="product image">
							</figure>
						</div>
						<!-- End .row -->
					</div>
					<!-- End .product-gallery -->
				</div>
				<!-- End .col-md-6 -->

				<div class="col-md-6">
					<div class="product-details">
						<h1 class="product-title">${product.nameProduct}</h1>
						<!-- End .product-title -->

						<div class="ratings-container">
							<a class="ratings-text" href="#product-review-link"
								id="review-link">( 2 Reviews )</a>
						</div>
						<!-- End .rating-container -->

						<div class="product-price">${product.priceModel.productPrice}</div>
						<!-- End .product-price -->

						<div class="product-content">
							<p>${product.description}</p>
						</div>
						<!-- End .product-content -->

						<div class="details-filter-row details-row-size">
							<label for="qty">Qty:</label>
							<div class="product-details-quantity">
								<input type="number" id="qty" class="form-control form-quantity" value="1" min="1" max="10" step="1" data-decimals="0" required pattern="[0-9]+">
							</div>
							<!-- End .product-details-quantity -->
						</div>
						<!-- End .details-filter-row -->

						<div class="product-details-action">
							<a href="#" class="btn-product btn-cart btn-addToCart" data-id="${product.id}"><span>add to
									cart</span></a>
						</div>
						<!-- End .product-details-action -->

						<div class="product-details-footer">
							<div class="product-cat">
								<span>Category:</span>
								<a href="">${product.category.categoryName }</a>
							</div>
							<!-- End .product-cat -->
						</div>
					</div>
					<!-- End .product-details -->
				</div>
				<!-- End .col-md-6 -->
			</div>
			<!-- End .row -->
		</div>
		<!-- End .product-details-top -->

		<div class="product-details-tab">
			<ul class="nav nav-pills justify-content-center" role="tablist">
				<li class="nav-item"><a class="nav-link active"
					id="product-desc-link" data-toggle="tab" href="#product-desc-tab"
					role="tab" aria-controls="product-desc-tab" aria-selected="true">Description</a>
				</li>
				<li class="nav-item"><a class="nav-link"
					id="product-review-link" data-toggle="tab"
					href="#product-review-tab" role="tab"
					aria-controls="product-review-tab" aria-selected="false">Reviews
						(2)</a></li>
			</ul>
			<div class="tab-content">
				<div class="tab-pane fade show active" id="product-desc-tab"
					role="tabpanel" aria-labelledby="product-desc-link">
					<div class="product-desc-content">
						<h3>Product Information</h3>
						<p>${product.description}</p>
					</div>
					<!-- End .product-desc-content -->
				</div>
				<!-- .End .tab-pane -->
				<div class="tab-pane fade" id="product-review-tab" role="tabpanel"
					aria-labelledby="product-review-link">
					<div class="reviews">
						<h3>Reviews (2)</h3>
						<section class="content-item" id="comments">
							<div class="container">
								<div class="row">
									<div class="col-sm-8">
										<form>
											<fieldset>
												<div class="row">
													<div class="form-group col-xs-12 col-sm-9 col-lg-10">
														<textarea class="form-control" id="message" placeholder="Your message" required=""></textarea>
													</div>
												</div>
											</fieldset>
                                            <button type="submit" class="btn btn-normal pull-right">Submit</button>
										</form>
										<h3>4 Comments</h3>
										<!-- COMMENT 1 - START -->
										<div class="media">
											<div class="media-body">
												<h4 class="media-heading">John Doe</h4>
												<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
												<ul class="list-unstyled list-inline media-detail pull-left">
													<li><i class="icon-calendar"></i>27/02/2014</li>
												</ul>
											</div>
										</div>
										<!-- COMMENT 1 - END -->
									</div>
								</div>
							</div>
						</section>

					</div>
					<!-- End .reviews -->
				</div>
				<!-- .End .tab-pane -->
			</div>
			<!-- End .tab-content -->
		</div>
		<!-- End .product-details-tab -->
	</div>
	<!-- End .container -->
</div>
<!-- End .page-content -->
