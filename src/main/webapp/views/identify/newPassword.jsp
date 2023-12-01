
<body oncontextmenu='return false' class='snippet-body bg-info'>

	<div>
		<!-- Container containing all contents -->
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-12 col-md-9 col-lg-7 col-xl-6 mt-5">
					<!-- White Container -->
					<div class="container bg-white rounded mt-2 mb-2 px-0">
						<!-- Main Heading -->
						<div class="row justify-content-center align-items-center pt-3">
							<h1>
								<strong>Reset Password</strong>
							</h1>
						</div>
						<div class="pt-3 pb-3">
							<form class="form-horizontal" action="Ecommerce/account/reset/" method="POST">
								<input type="hidden" name="userId" value="${idUser}" />
								<!-- User Name Input -->
								<div class="form-group row justify-content-center px-3">
									<div class="col-9 px-0">
										<input type="text" name="password" placeholder="&#xf084; &nbsp; New Password"
											class="form-control border-info placeicon" id="pass">
										<span class="message"></span>
									</div>
								</div>
								<!-- Password Input -->
								<div class="form-group row justify-content-center px-3">
									<div class="col-9 px-0">
										<input type="password" name="confPassword"
											placeholder="&#xf084; &nbsp; Confirm New Password"
											class="form-control border-info placeicon" id="re_pass">
										<span class="message"></span>
									</div>
								</div>
							
								<!-- Log in Button -->
								<div class="form-group row justify-content-center">
									<div class="col-3 px-3 mt-3">
										<input type="submit" value="Reset"
											class="btn btn-block btn-info">
									</div>
								</div>

							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>