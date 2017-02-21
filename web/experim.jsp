<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
  <head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    
    <title>NSFC-NSF</title>
    <meta name="description" content="" />
    <meta name="author" content="" />
    
	<!-- http://davidbcalhoun.com/2010/viewport-metatag -->
	<meta name="HandheldFriendly" content="True" />
	<meta name="MobileOptimized" content="320" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />

	<!--// OPTIONAL & CONDITIONAL CSS FILES //-->   
	</head>
<body>

					<!-- page header -->
					<!-- <h1 id="page-header">Create An Experiment</h1>	 -->
					<!-- wizard steps -->
														<ul class="bwizard-steps">
														  	<li class="active">
														  		<span class="label badge-inverse">1</span>
														  		<a href="#inverse-tab1" data-toggle="tab">Step 1: Create An Experiment</a>
														  	</li>
															<li>
																<span class="label badge-inverse">2</span>
																<a>Step 2</a>
															</li>
															<li>
																<span class="label badge-inverse">3</span>
																<a>Step 3</a>
															</li>
														</ul>
														<!-- end wizard steps -->
					<div class="fluid-container">
						
						<!-- widget grid -->
						<section id="widget-grid" class="">
							
							<!-- row-fluid -->
							
							<div class="row-fluid">
								<article class="span12">
									<!-- new widget -->
									<div class="jarviswidget jarviswidget-sortable" id="widget-id-0" data-widget-deletebutton="false" data-widget-editbutton="false" role="widget">
									    <header>
									        <h2></h2>                           
									    </header>
									    <!-- wrap div -->
									    <div>
       
									        <div class="inner-spacer"> 
									        <!-- content goes here -->
												<form class="form-horizontal themed" >
												
													<fieldset class="form-horizontal themed" id="uislider-demo">
														<div class="control-group">
															<label class="control-label" for="input01">Experiment Name</label>
															<div class="controls">
																<input type="text" class="span12" name="expName" id="testName" />
															</div>
														</div>


														<div class="form-actions">
															<button type="reset" class="btn medium btn-danger">
																Cancel
															</button>
															
															<!-- <button type="submit" class="btn medium btn-primary">
																Continue										
															</button> -->
															<a class="ajax-link" href="#" id="te.jsp">Continue</a>
														</div>
													</fieldset>
												</form>
										    </div>
										    <!-- end content-->
									    </div>
									    <!-- end wrap div -->
									</div>
									<!-- end widget -->
								</article>
							</div>
							
							<!-- end row-fluid -->
							
						</section>
						<!-- end widget grid -->
					</div>		
				
				<!-- end main content -->  
</body>

</html>
