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
	<!-- date picker css -->
	<link rel="stylesheet" href="css/datepicker.css?v=1" />
	<!-- full calander css -->
	<link rel="stylesheet" href="css/fullcalendar.css?v=1" />
	<!-- data tables extended CSS -->
	<link rel="stylesheet" href="css/TableTools.css?v=1" />
	<!-- bootstrap wysimhtml5 editor -->
	<link rel="stylesheet" href="css/bootstrap-wysihtml5.css?v=1" />
	<link rel="stylesheet" href="css/wysiwyg-color.css" />
	<!-- custom/responsive growl messages -->
	<link rel="stylesheet" href="css/toastr.custom.css?v=1" />
	<link rel="stylesheet" href="css/toastr-responsive.css?v=1" />
	<link rel="stylesheet" href="css/jquery.jgrowl.css?v=1" />
	
	<!-- // DO NOT REMOVE OR CHANGE ORDER OF THE FOLLOWING // -->
	<!-- bootstrap default css (DO NOT REMOVE) -->
	<link rel="stylesheet" href="css/bootstrap.min.css?v=1" />
	<link rel="stylesheet" href="css/bootstrap-responsive.min.css?v=1" />
	<!-- font awsome and custom icons -->
	<link rel="stylesheet" href="css/font-awesome.min.css?v=1" />
	<link rel="stylesheet" href="css/cus-icons.css?v=1" />
	<!-- jarvis widget css -->
	<link rel="stylesheet" href="css/jarvis-widgets.css?v=1" />
	<!-- Data tables, normal tables and responsive tables css -->
	<link rel="stylesheet" href="css/DT_bootstrap.css?v=1" />
	<link rel="stylesheet" href="css/responsive-tables.css?v=1" />
	<!-- used where radio, select and form elements are used -->
	<link rel="stylesheet" href="css/uniform.default.css?v=1" />
	<link rel="stylesheet" href="css/select2.css?v=1" />
	<!-- main theme files -->
	<link rel="stylesheet" href="css/theme.css?v=1" />
	<link rel="stylesheet" href="css/theme-responsive.css?v=1" />
    
	<!-- // THEME CSS changed by javascript: the CSS link below will override the rules above // -->
	<!-- For more information, please see the documentation for "THEMES" -->
    <link rel="stylesheet" id="switch-theme-js" href="css/themes/default.css?v=1" />   
   	<!-- To switch to full width -->
    <link rel="stylesheet" id="switch-width" href="css/full-width.css?v=1" />
    
	<!-- Webfonts -->
	<!-- <link rel='stylesheet' href='http://fonts.googleapis.com/css?family=Lato:300,400,700' type='text/css' /> -->
	
	<!-- All javascripts are located at the bottom except for HTML5 Shim -->
    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
   		<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
   		<script src="js/include/respond.min.js"></script>
   	<![endif]-->

	<!-- For Modern Browsers -->
	<!-- <link rel="shortcut icon" href="img/favicons/favicon.png" /> -->
	<!-- For everything else -->
	<!-- <link rel="shortcut icon" href="img/favicons/favicon.ico" /> -->
	<!-- For retina screens -->
	<!-- <link rel="apple-touch-icon-precomposed" sizes="114x114" href="img/favicons/apple-touch-icon-retina.png" /> -->
	<!-- For iPad 1-->
	<!-- <link rel="apple-touch-icon-precomposed" sizes="72x72" href="img/favicons/apple-touch-icon-ipad.png" /> -->
	<!-- For iPhone 3G, iPod Touch and Android -->
	<!-- <link rel="apple-touch-icon-precomposed" href="img/favicons/apple-touch-icon.png" /> -->
	
	<!-- iOS web-app metas -->
	<meta name="apple-mobile-web-app-capable" content="yes" />
	<meta name="apple-mobile-web-app-status-bar-style" content="black" />

	<!-- Startup image for web apps -->
	<link rel="apple-touch-startup-image" href="img/splash/ipad-landscape.png" media="screen and (min-device-width: 481px) and (max-device-width: 1024px) and (orientation:landscape)" />
	<link rel="apple-touch-startup-image" href="img/splash/ipad-portrait.png" media="screen and (min-device-width: 481px) and (max-device-width: 1024px) and (orientation:portrait)" />
	<link rel="apple-touch-startup-image" href="img/splash/iphone.png" media="screen and (max-device-width: 320px)" />
	
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" /></head>

  <body>
  	<!-- .height-wrapper -->
	<div class="height-wrapper">
		
		<!-- header -->
		<header>
			<!-- tool bar -->
			<div id="header-toolbar" class="container-fluid">
				<!-- .contained -->
				<div class="contained">
					
					<!-- theme name -->
					<h1> NSFC-NSF <span class="hidden-phone"></span> </h1>
					<!-- end theme name -->
					
					<!-- span4 -->
					<div class="pull-right">
						<!-- demo theme switcher-->
						<div id="theme-switcher" class="btn-toolbar">
							
							<!-- search and log off button for phone devices -->
							<div class="btn-group pull-right visible-phone">
								<a href="javascript:void(0)" class="btn btn-inverse btn-small"><i class="icon-search"></i></a>
								<a href="javascript:void(0)" class="btn btn-inverse btn-small"><i class="icon-off"></i></a>
							</div>
							<!-- end buttons for phone device -->
							
								
						</div>
					  	<!-- end demo theme switcher-->
					</div>
					<!-- end span4 -->
				</div>
				<!-- end .contained -->
			</div>
			<!-- end tool bar -->
			
		</header>
		<!-- end header -->
		
	    <div id="main" role="main" class="container-fluid">
			<div class="contained">
				<!-- aside -->	
				<aside>	
									
					<!-- aside item: Mini profile -->
					<div class="my-profile">
						<a href="javascript:void(0)" class="my-profile-pic">
							<!-- <img src="img/avatar/avatar_0.jpg" alt="" /> -->
						</a>
						<span class="first-child">Welcome <strong><%=session.getAttribute("username")%></strong>!</span>
						<!-- <span><a href="javascript:void(0);">Edit Profile </a></span> -->
					</div>
					<div class="divider"></div>
					<!-- end aside item: Mini profile -->

					<!-- aside item: Menu -->
					<div class="sidebar-nav-fixed">
						
						<ul class="menu" id="accordion-menu-js">
							
							<!-- 
							<li class="">
								<a href="inbox.html" class="expanded"><i class="icon-envelope"></i>Inbox</a>
							</li>
							 -->
							<li class="current">
								<a href="javascript:void(0)"><i class="icon-check"></i>Experiment<span class="badge">2</span></a>
								<ul>
									<li>
										<a href="./experiment.jsp" class="expanded">Create</a>
									</li>
									<li>
										<a href="showExperiment">Result</a>
									</li>
								</ul>
							</li>
							<li class="">
								<a href="javascript:void(0)"><i class="icon-user"></i>Information<span class="badge">2</span></a>
								<ul>
									<li>
										<a href="logout">Logout</a>
									</li>
								</ul>
							</li>
							
						</ul>
						
					</div>
					<div class="divider"></div>
					<!-- end aside item: Menu -->
					

					<!-- aside buttons -->
<!-- 					<div class="aside-buttons">
		                <a href="javascript:void(0);" title="" class="btn btn-info">Create Experiment</a>
		                <a href="javascript:void(0);" title="" class="btn btn-success">Add Step</a>
			            <a href="javascript:void(0);" title="" class="btn btn-danger">Delete Step</a>
		            </div>
		            <div class="divider"></div>
		            <!-- end aside buttons -->
					
				</aside>
				<!-- aside end -->
				
				<!-- main content -->
				<div id="page-content">	
					<!-- page header -->
					<%-- <h1 id="page-header">${expName}</h1> --%>	
					
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
									    
									        <div class="jarviswidget-editbox">
									            <div>
									                <label>Title:</label>
									                <input type="text" />
									            </div>
									            <div>
									                <label>Styles:</label>
									                <span data-widget-setstyle="purple" class="purple-btn"></span>
									                <span data-widget-setstyle="navyblue" class="navyblue-btn"></span>
									                <span data-widget-setstyle="green" class="green-btn"></span>
									                <span data-widget-setstyle="yellow" class="yellow-btn"></span>
									                <span data-widget-setstyle="orange" class="orange-btn"></span>
									                <span data-widget-setstyle="pink" class="pink-btn"></span>
									                <span data-widget-setstyle="red" class="red-btn"></span>
									                <span data-widget-setstyle="darkgrey" class="darkgrey-btn"></span>
									                <span data-widget-setstyle="black" class="black-btn"></span>
									            </div>
									        </div>
            
									        <div class="inner-spacer"> 
									        <!-- content goes here -->
									        	<s:if test="note!=null">
									        	<div class="widget alert alert-warning adjusted">
													<button class="close" data-dismiss="alert">×</button>
													<i class="cus-exclamation-octagon-fram"></i>
													<strong>ALERT:</strong> <strong>${note}</strong>
												</div>
									        	</s:if>
												<form  class="form-horizontal themed" id="uislider-demo" action="updateStage2?recordId=${record.recordId}&experimentId=${experimentId}" method="post" novalidate="novalidate">
													<fieldset>
														<div class="control-group">
															<label class="control-label" for="input01">Stage Name</label>
															<div class="controls">
																<input type="text" class="span12" name="testName" id="testName" value="${record.testName}"/>
															</div>
														</div>
														<div class="control-group">
															<label class="control-label" for="select01">Way</label>
															<div class="controls">
																<select name="way" class="span12 with-search"  onchange="method_change()">
										
														                <option value="PUT">PUT</option>
																		<option value="GET">GET</option>
																	
														        </select>
															</div>
														</div>
														<div class="control-group">
															<label class="control-label" for="select01">Method</label>
															<div class="controls">
																<select name="method" class="span12 with-search">
																	
														                <option value="FTP">FTP</option>
														                <!-- <option value="SCP">SCP</option> -->
													                
														        </select>
															</div>
														</div>
														<div class="control-group">
															<label class="control-label" for="select01">Protocol</label>
															<div class="controls">
																<select name="protocol" class="span12 with-search">
																	<s:if test="record.protocol=='ipv4'">
														                <option value="ipv4">IPv4</option>
																		<option value="ipv6">IPv6</option>
																	</s:if>
																	<s:else>
																		<option value="ipv6">IPv6</option>
																		<option value="ipv4">IPv4</option>
																	</s:else>
														        </select>
															</div>
														</div>
														<div class="control-group">
															<label class="control-label" for="select01">Data Source</label>
															<div class="controls">
																<select name="dataSource" class="span12 with-search" onchange="receiver_change()">
													                <option value="BUAA">BUAA</option>
																	<option value="CNIC">CNIC</option>
																	<option value="UCSD">UCSD</option>
																	<option value="WISC">WISC</option>
														        </select>
															</div>
														</div>
														<div class="control-group">
															<label class="control-label" for="select01">Data Destination</label>
															<div class="controls">
																<select name="dataDestination" class="span12 with-search">
																	<option value="CNIC">CNIC</option>
																	<option value="UCSD">UCSD</option>
																	<option value="WISC">WISC</option>
														        </select>
															</div>
														</div>
														<div class="control-group">
															<label class="control-label">Data Size</label>
																<div class="controls">
																	<p class="info-block">		
																		<input type="text" name="dataNumber" id="amount2" class="ui-display-label"/> 
																	</p>
																	<!-- <label class="radio inline">
																	  <input type="radio" name="dataSize" id="optionsRadios4" value="K" checked="" />
																	  KB
																	</label>
																	<label class="radio inline">
																	  <input type="radio" name="dataSize" id="optionsRadios5" value="M" />
																	  MB
																	</label>
																	<label class="radio inline">
																	  <input type="radio" name="dataSize" id="optionsRadios6" value="G"  />
																	  GB
																	</label> -->
																</div>
															<!-- <label class="control-label">Number</label> -->
															<div class="controls">																  
																<div id="slider-range-min" class="warning-slider"></div>
															</div>															
														</div>
														
														<div class="control-group">
															<label class="control-label">Repeat</label>
															<div class="controls">
																<p class="info-block">
		    													<input type="text" name="repeat" id="amount5" class="ui-display-label" />
																</p>
																<div id="slider-range-min2" class="info-slider"></div>
		
															</div>
														</div>
														
														<div class="control-group">
															<label class="control-label">Number</label>
															<div class="controls">
																<p class="info-block">
		    													<input type="text" name="number" id="amount6" class="ui-display-label"/>
																</p>
																<div id="slider-range-min3" class="important-slider"></div>
															</div>
														</div>
														
														<div class="control-group">
															<label class="control-label">Parallel</label>
															<div class="controls">
																<p class="info-block">
		    													<input type="text" name="parallel" id="amount7" class="ui-display-label" />
																</p>
																<div id="slider-range-min4" class="success-slider"></div>
															</div>
														</div>
														
														<%-- 
														<div class="control-group" id="timepicker-demo">
															<label class="control-label">Time (Start)</label>
															<div class="controls">
																
																<div class="input-append date" id="datepicker-js" data-date-format="yyyy-mm-dd">
																	<input id="timeStart_date" name="timeStart_date" class="datepicker-input" size="16" type="text" value="" placeholder="Select a date" />
																	<span class="add-on"><i class="cus-calendar-2"></i></span>
																</div>
																
																
																<div class="input-append bootstrap-timepicker-component">
														           	<input id="timeStart_time" name="timeStart_time" type="text" class="timepicker-input" value="" />
														            <span class="add-on"><i class="cus-clock"></i></span>
														        </div>
																
															</div>
														</div>
														
														<div class="control-group" id="timepicker-demo">
															<label class="control-label">Time (End)</label>
															<div class="controls">
																
																<div class="input-append date" id="datepicker-js" data-date-format="yyyy-mm-dd">
																	<input id="timeEnd_date" name="timeEnd_date" class="datepicker-input" size="16" type="text" value="" placeholder="Select a date" />
																	<span class="add-on"><i class="cus-calendar-2"></i></span>
																</div>
																
																
																<div class="input-append bootstrap-timepicker-component">
														           	<input id="timeEnd_time" name="timeEnd_time" type="text" class="timepicker-input" value="" />
														            <span class="add-on"><i class="cus-clock"></i></span>
														        </div>
																
															</div>
														</div> 
														--%>
														<div class="form-actions">
															<a href="showTest?experimentId=${experimentId}"><button type="button" class="btn medium btn-danger">
																Cancel
															</button></a>
															<button type="submit" class="btn medium btn-primary">
																Save
															</button>
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
				</div>
				<!-- end main content -->
			
				<!-- aside right on high res -->
				<aside class="right">
		
					<!-- date picker -->
					<div id="datepicker"></div>
					<div class="divider"></div>
					<!-- end date picker -->
		            
				</aside>
				
				<!-- end aside right -->
			</div>
			
	    </div><!--/.fluid-container-->
		<div class="push"></div>
	</div>
	<!-- end .height-wrapper -->	
	
	<!-- footer -->
	
	<!-- if you like you can insert your footer here -->
	
	<!-- end footer -->

    <!--================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    
    <!-- Link to Google CDN's jQuery + jQueryUI; fall back to local -->
    <!-- <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.0/jquery.min.js"></script> -->
    <script src="js/libs/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src="js/libs/jquery.min.js"><\/script>')</script>
    <!-- <script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.9.2/jquery-ui.min.js"></script> -->
    <script src="js/libs/jquery-ui.min.js"></script>
    <script>window.jQuery.ui || document.write('<script src="js/libs/jquery.ui.min.js"><\/script>')</script>
    
    <!-- IMPORTANT: Jquery Touch Punch is always placed under Jquery UI -->
    <script src="js/include/jquery.ui.touch-punch.min.js"></script>

	<!-- REQUIRED: Datatable components -->
    <script src="js/include/jquery.accordion.min.js"></script>

	<!-- REQUIRED: Toastr & Jgrowl notifications  -->
    <script src="js/include/toastr.min.js"></script>
    <script src="js/include/jquery.jgrowl.min.js"></script>
    
    <!-- REQUIRED: Sleek scroll UI  -->
    <script src="js/include/slimScroll.min.js"></script>
	
	<!-- REQUIRED: Datatable components -->
	<!-- DISABLED <script src="js/include/jquery.dataTables.min.js"></script> -->
	<!-- DISABLED <script src="js/include/DT_bootstrap.min.js"></script> -->

	<script type="text/javascript">
		var ismobile = (/iphone|ipad|ipod|android|blackberry|mini|windows\sce|palm/i.test(navigator.userAgent.toLowerCase()));	
	    if(!ismobile){
	    	
	    	/** ONLY EXECUTE THESE CODES IF MOBILE DETECTION IS FALSE **/
	    	
	    	/* REQUIRED: Datatable PDF/Excel output componant */
	    	
	    	/*-- document.write('<script src="js/include/ZeroClipboard.min.js"><\/script>'); --*/
	    	/*-- document.write('<script src="js/include/TableTools.min.js"><\/script>'); --*/
	    	document.write('<script src="js/include/jquery.uniform.min.js"><\/script>'); 
	    	document.write('<script src="js/include/select2.min.js"><\/script>'); 
	    	document.write('<script src="js/include/jquery.excanvas.min.js"><\/script>');
	    	document.write('<script src="js/include/jquery.placeholder.min.js"><\/script>');
	    }else{
	    	
	    	/** ONLY EXECUTE THESE CODES IF MOBILE DETECTION IS TRUE **/
	    	
			document.write('<script src="js/include/selectnav.min.js"><\/script>');
	    	document.write('<script src="js/include/responsive-tables.min.js"><\/script>');
	    }
	</script>

    <!-- REQUIRED: iButton -->
    <!-- DISABLED <script src="js/include/jquery.ibutton.min.js"></script> --> 
    
    <!-- REQUIRED: Justgage animated charts -->
    <!-- DISABLED <script src="js/include/justgage.min.js"></script> -->
    <!-- DISABLED <script src="js/include/raphael.2.1.0.min.js"></script> -->
    
    <!-- REQUIRED: Animated pie chart -->
    <script src="js/include/jquery.easy-pie-chart.min.js"></script>
    
    <!-- REQUIRED: Functional Widgets -->
    <script src="js/include/jarvis.widget.min.js"></script>
    <script src="js/include/mobiledevices.min.js"></script>
    <!-- DISABLED (only needed for IE7 <script src="js/include/json2.js"></script> -->
	
    <!-- REQUIRED: Full Calendar -->
    <!-- DISABLED <script src="js/include/jquery.fullcalendar.min.js"></script> -->		
    
    <!-- REQUIRED: Flot Chart Engine -->
    <!-- DISABLED <script src="js/include/jquery.flot.cust.min.js"></script> -->			
    <!-- DISABLED <script src="js/include/jquery.flot.resize.min.js"></script> -->		
    <!-- DISABLED <script src="js/include/jquery.flot.tooltip.min.js"></script> -->		
    <!-- DISABLED <script src="js/include/jquery.flot.orderBar.min.js"></script> -->	
    <!-- DISABLED <script src="js/include/jquery.flot.fillbetween.min.js"></script> -->	
    <!-- DISABLED <script src="js/include/jquery.flot.pie.min.js"></script> --> 	 
    
    <!-- REQUIRED: Sparkline Charts -->
    <script src="js/include/jquery.sparkline.min.js"></script>
    
    <!-- REQUIRED: Form validation plugin -->
    <script src="js/include/jquery.validate.min.js"></script>

	<!-- REQUIRED: Infinite Sliding Menu (used with inbox page) -->
	<!-- DISABLED  <script src="js/include/jquery.inbox.slashc.sliding-menu.js"></script> -->

	<!-- REQUIRED: Form validation plugin -->
    <!-- DISABLED <script src="js/include/jquery.validate.min.js"></script> -->
    
    <!-- REQUIRED: Progress bar animation -->
    <script src="js/include/bootstrap-progressbar.min.js"></script>
    
    <!-- REQUIRED: wysihtml5 editor -->
    <script src="js/include/wysihtml5-0.3.0.min.js"></script>
    <script src="js/include/bootstrap-wysihtml5.min.js"></script>

	<!-- REQUIRED: Masked Input -->
    <script src="js/include/jquery.maskedinput.min.js"></script>
    
    <!-- REQUIRED: Bootstrap Date Picker -->
    <script src="js/include/bootstrap-datepicker.min.js"></script>
    
    <!-- REQUIRED: Bootstrap Wizard -->
    <!-- DISABLED  <script src="js/include/bootstrap.wizard.min.js"></script> -->
    
	<!-- REQUIRED: Bootstrap Color Picker -->
    <script src="js/include/bootstrap-colorpicker.min.js"></script>
    
	<!-- REQUIRED: Bootstrap Time Picker -->
    <script src="js/include/bootstrap-timepicker.min.js"></script>
    
    <!-- REQUIRED: Bootstrap Prompt -->
    <!-- DISABLED  <script src="js/include/bootbox.min.js"></script> -->
    
    <!-- REQUIRED: Bootstrap engine -->
    <script src="js/include/bootstrap.min.js"></script>
    
    <!-- DO NOT REMOVE: Theme Config file -->
    <script src="js/config.js"></script>
    
    <script src="js/dataplace.js"></script>
    
    <!-- d3 library placed at the bottom for better performance -->
    <!-- DISABLED  <script src="js/include/d3.v3.min.js"></script> -->
    <!-- DISABLED  <script src="js/include/adv_charts/d3-chart-1.js"></script> -->
    <!-- DISABLED  <script src="js/include/adv_charts/d3-chart-2.js"></script> -->
    
    <!-- Google Geo Chart -->
    <!-- DISABLED <script src="http://maps.google.com/maps/api/js?sensor=true" type="text/javascript"></script> -->
    <!-- DISABLED <script type='text/javascript' src='https://www.google.com/jsapi'></script>-->
    <!-- DISABLED <script src="js/include/adv_charts/geochart.js"></script> -->
    <!-- QQ -->
    <script type="text/javascript" src="http://tajs.qq.com/stats?sId=43882702" charset="UTF-8"></script>
    
    <!-- end scripts -->
 <!--  <div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div> -->
</body>
</html>
