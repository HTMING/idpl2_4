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
	<!-- custom/responsive growl messages -->
	<link rel="stylesheet" href="css/toastr.custom.css?v=1" />
	<link rel="stylesheet" href="css/toastr-responsive.css?v=1" />
	
	<!-- // DO NOT REMOVE OR CHANGE ORDER OF THE FOLLOWING // -->
	<!-- bootstrap default css (DO NOT REMOVE) -->
	<link rel="stylesheet" href="css/bootstrap.min.css?v=1" />
	<link rel="stylesheet" href="css/bootstrap-responsive.min.css?v=1" />
	<!-- font awsome and custom icons -->
	<link rel="stylesheet" href="css/font-awesome.min.css?v=1" />
	<link rel="stylesheet" href="css/cus-icons.css?v=1" />
	<!-- jarvis widget css -->
	<link rel="stylesheet" href="css/jarvis-widgets.css?v=1" />
	<!-- main theme files -->
	<link rel="stylesheet" href="css/theme.css?v=1" />
	<link rel="stylesheet" href="css/theme-responsive.css?v=1" />
	<link rel="stylesheet" href="css/jquery.jgrowl.css?v=1" />
    
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
								<a href="login.html" class="btn btn-inverse btn-small"><i class="icon-off"></i></a>
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
						<span class="first-child">Welcome <strong><%=session.getAttribute("username")%></strong></span>
						<%-- <span><a href="javascript:void(0);">Edit Profile </a></span> --%>
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
								<a href="javascript:void(0)"><i class="icon-user"></i>Statis<span class="badge">2</span></a>
								<ul>
									<li>
										<a href="./ManagerDirectionShow.jsp">Direction</a>
									</li>
									<li>
										<a href="logout">Logout</a>
									</li>
								</ul>
							</li>
							
						</ul>
						
					</div>
					<div class="divider"></div>
					<!-- end aside item: Menu -->
					
<!-- 
					aside buttons
					<div class="aside-buttons">
		                <a href="javascript:void(0);" title="" class="btn btn-info">Add new table</a>
		                <a href="javascript:void(0);" title="" class="btn btn-success">Add a new row</a>
		                <a href="javascript:void(0);" title="" class="btn btn-warning">Update table</a>
		                <a href="javascript:void(0);" title="" class="btn btn-danger">Delete Table</a>
		            </div>
		            <div class="divider"></div>
		            end aside buttons
					 -->
				</aside>
				<!-- aside end -->
				
				<!-- main content -->
				<div id="page-content">
					<!-- page header -->
					<h1 id="page-header">Charts & Graphs</h1>	
					
					<div class="fluid-container">
						
						<!-- widget grid -->
						<section id="widget-grid" class="">
							
							<!-- row-fluid -->
							<div class="row-fluid">
								<article class="span12">
									
									<!-- new widget -->
									<div class="jarviswidget" id="widget-id-0">
									    <header>
									        <h2>Bar Chart</h2>                           
									    </header>
									    <div>
									    
									        <div class="jarviswidget-editbox">
									            <button id="directionButton" class="btn medium btn-primary">
													Draw
												</button>   
									        </div>
            
									        <div class="inner-spacer"> 
									        <!-- content goes here -->

												<!-- sin chart -->
								        		<div id="bar_chart" class="chart"></div>

									        </div>
									        
									    </div>
									</div>
									<!-- end widget -->
									
									<!-- new widget -->
									<div class="jarviswidget" id="widget-id-1">
									    <header>
									        <h2>Sin Chart</h2>                           
									    </header>
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
												
												<!-- sin chart -->
								        		<div id="sin-chart" class="chart has-legend"></div>

									        </div>
									        
									    </div>
									</div>
									<!-- end widget -->

								</article>
							</div>
							
							<!-- end row-fluid -->
							
							<!-- row-fluid -->
							
							<div class="row-fluid">

								<article class="span6">

									<!-- new widget -->
									<div class="jarviswidget" id="widget-id-2">
									    <header>
									        <h2>Auto Updating Chart</h2>                           
									    </header>
									    
									    <!-- widget div-->
									    <div>
									    	<!-- widget edit box -->
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
									        <!-- end widget edit box -->
            
									        <div class="inner-spacer"> 
									        <!-- content goes here -->
												
												<!-- updating chart -->
								        		<div id="updating-chart" class="chart"></div>

									        </div>
									        
									    </div>
									    <!-- end widget div -->
									</div>
									<!-- end widget -->

								</article>
										
								<article class="span6">
									
									<!-- new widget -->
									<div class="jarviswidget" id="widget-id-13">
									    <header>
									        <h2>Horizontal Bar Chart</h2>                           
									    </header>
									    
									    <!-- widget div-->
									    <div>
									    	<!-- widget edit box -->
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
									        <!-- end widget edit box -->

									        <!-- content -->	            
									        <div class="inner-spacer"> 
									        <!-- content goes here -->
												
												<!-- bar chart -->
								        		<div id="bar-chart-h" class="chart"></div>

									        </div>
									        <!-- end content -->	
									        
									    </div>
									    <!-- end widget div -->
									</div>
									<!-- end widget -->
									
								</article>
								
							</div>
							
							<!-- end row-fluid -->
							
							<!-- row-fluid -->
							
							<div class="row-fluid">
								<article class="span12">
									<!-- new widget -->
									<div class="jarviswidget" id="widget-id-4">
									    <header>
									        <h2>Campaign Monitor</h2>                           
									    </header>
									    
									    <!-- widget div-->
									    <div>
									    	<!-- widget edit box -->
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
									        <!-- end widget edit box -->
            
									        <div class="inner-spacer"> 
									        <!-- content -->	
												<!-- sales chart -->
								        		<div id="saleschart" class="chart"></div>
											<!-- end content -->	
									        </div>
									        
									    </div>
									    <!-- end widget div -->
									</div>
									<!-- end widget -->
								</article>
							</div>
							
							<!-- end row-fluid -->
							
							<!-- row-fluid -->
							
							<div class="row-fluid">
								
								<article class="span8">
									<!-- new widget -->
									<div class="jarviswidget" id="widget-id-5">
									    <header>
									        <h2>Plot Percentiles</h2>                           
									    </header>
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
									        <!-- content -->	
 												<!-- bar chart -->
								        		<div id="fill-chart" class="chart has-legend"></div>
											<!-- end content -->	
									        </div>
									        <!-- end inner spacer -->
									    </div>
									</div>
									<!-- end widget -->
								</article>
							
								<article class="span4">
									
									<!-- new widget -->
									<div class="jarviswidget" id="widget-id-6">
									    <header>
									        <h2>Pie Chart</h2>                           
									    </header>
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
												<!-- bar chart -->
								        		<div id="pie-chart" class="chart has-legend"></div>
									        <!-- end content -->
									        </div>
									        
									        
									    </div>
									</div>
									<!-- end widget -->
								</article>
								
							</div>
							
							<!-- end row-fluid -->
							
							<!-- row-fluid -->
							
							<div class="row-fluid">
								<article class="span12">
									<!-- new widget -->
									<div class="jarviswidget" id="widget-id-7">
									    <header>
									        <h2>Site Stats Chart</h2>                           
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
												<!-- site stats -->
								        		<div id="site-stats" class="chart has-legend"></div>
											<!-- end content-->
										    </div>
										    
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
	    	/*-- document.write('<script src="js/include/jquery.uniform.min.js"><\/script>'); --*/
	    	/*-- document.write('<script src="js/include/select2.min.js"><\/script>'); --*/
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
    <script src="js/include/justgage.min.js"></script>
    <script src="js/include/raphael.2.1.0.min.js"></script>
    
    <!-- REQUIRED: Animated pie chart -->
    <script src="js/include/jquery.easy-pie-chart.min.js"></script>
    
    <!-- REQUIRED: Functional Widgets -->
    <script src="js/include/jarvis.widget.min.js"></script>
    <script src="js/include/mobiledevices.min.js"></script>
    <!-- DISABLED (only needed for IE7 <script src="js/include/json2.js"></script> -->
	
	<!-- REQUIRED: Full Calendar -->
    <script src="js/include/jquery.fullcalendar.min.js"></script>
    
    <!-- REQUIRED: Flot Chart Engine -->
    <script src="js/include/jquery.flot.cust.min.js"></script>			
    <script src="js/include/jquery.flot.resize.min.js"></script>		
    <script src="js/include/jquery.flot.tooltip.min.js"></script>		
    <script src="js/include/jquery.flot.orderBar.min.js"></script>	
    <script src="js/include/jquery.flot.fillbetween.min.js"></script>	
    <script src="js/include/jquery.flot.pie.min.js"></script> 	 
    
    <!-- REQUIRED: Sparkline Charts -->
    <script src="js/include/jquery.sparkline.min.js"></script>

	<!-- REQUIRED: Infinite Sliding Menu (used with inbox page) -->
	<!-- DISABLED  <script src="js/include/jquery.inbox.slashc.sliding-menu.js"></script> -->

	<!-- REQUIRED: Form validation plugin -->
    <!-- DISABLED <script src="js/include/jquery.validate.min.js"></script> -->
    
    <!-- REQUIRED: Progress bar animation -->
    <script src="js/include/bootstrap-progressbar.min.js"></script>
    
    <!-- REQUIRED: wysihtml5 editor -->
    <!-- DISABLED <script src="js/include/wysihtml5-0.3.0.min.js"></script> -->
    <!-- DISABLED <script src="js/include/bootstrap-wysihtml5.min.js"></script> -->

	<!-- REQUIRED: Masked Input -->
    <!-- DISABLED  <script src="js/include/jquery.maskedinput.min.js"></script> -->
    
    <script src="js/include/bootstrap-datepicker.min.js"></script>
    
    <!-- REQUIRED: Bootstrap Wizard -->
    <!-- DISABLED  <script src="js/include/bootstrap.wizard.min.js"></script> -->
    
	<!-- REQUIRED: Bootstrap Color Picker -->
    <!-- DISABLED  <script src="js/include/bootstrap-colorpicker.min.js"></script> -->
    
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
  <script type="text/javascript" src="js/highcharts.js"></script>
  <script type="text/javascript" src="js/exporting.js"></script>
  <script type="text/javascript" src="js/dark-unica.js"></script>
  <script>
    $(function () {
    var arrayList = ["BUAAtoCNIC", 
    				"BUAAtoUCSD", 
    				"BUAAtoWISC", 
    				"CNICtoBUAA",
    				"CNICtoUCSD",
    				"CNICtoWISC",
    				"UCSDtoBUAA",
    				"UCSDtoCNIC",
    				"USCDtoWISC",
    				"WISCtoBUAA",
    				"WISCtoCNIC",
    				"WISCtoUCSD"];
   	var putDataList = new Array();   	
   	var getDataList = new Array();
   	/*
   	<s:iterator id="directionStatis" value="directionStatisList">
   		putDataList.push(${directionStatis.putNumber});
   		getDataList.push(${directionStatis.getNumber});
   	</s:iterator>
   	*/
   	$.ajax({
   			url: "managerShowDirection",
   			type: "POST",
   			data: "{}",
   			dataType: "json",
   			success: function(data){
   				$.each(data.directionStatisList,function(i,value) { 
   					putDataList.push(value.putNumber);
   					getDataList.push(value.getNumber);
   				});  
   			},
   			fail: function(){
   				alert("error");
   			}
   		});
   		
   	$("#directionButton").click(function () {
   		$('#bar_chart').highcharts({
        chart: {
            type: 'column'
        },
        title: {
            text: 'Data Source and Data Destination Charts'
        },
        subtitle: {
            text: ''
        },
        xAxis: {
            categories: arrayList
        },
        yAxis: {
            min: 0,
            title: {
                text: 'Number'
            }
        },
        tooltip: {
            headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
            pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
                '<td style="padding:0"><b>{point.y:.1f} mm</b></td></tr>',
            footerFormat: '</table>',
            shared: true,
            useHTML: true
        },
        plotOptions: {
            column: {
                pointPadding: 0.2,
                borderWidth: 0
            }
        },
        series: [{
            name: 'PUT',
            data: putDataList

        }, {
            name: 'GET',
            data: getDataList
        }]
    });
   	});
    $('#bar_chart').highcharts({
        chart: {
            type: 'column'
        },
        title: {
            text: 'Data Source and Data Destination Charts'
        },
        subtitle: {
            text: ''
        },
        xAxis: {
            categories: arrayList
        },
        yAxis: {
            min: 0,
            title: {
                text: 'Number'
            }
        },
        tooltip: {
            headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
            pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
                '<td style="padding:0"><b>{point.y:.1f} mm</b></td></tr>',
            footerFormat: '</table>',
            shared: true,
            useHTML: true
        },
        plotOptions: {
            column: {
                pointPadding: 0.2,
                borderWidth: 0
            }
        },
        series: [{
            name: 'PUT',
            data: putDataList

        }, {
            name: 'GET',
            data: getDataList
        }]
    });
});				
  </script>
    <!-- end scripts -->
  <!-- <div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div> -->
  
</body>
</html>
