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
					<h1 id="page-header">${expName}</h1>	
					
					<div class="fluid-container">
						
						<!-- widget grid -->
						<section id="widget-grid" class="">
							
							<!-- row-fluid -->
							
							<div class="row-fluid">
								<article class="span12">
									<!-- new widget -->
									<div class="jarviswidget jarviswidget-sortable" id="widget-id-0" data-widget-deletebutton="false" role="widget">
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
												<form  class="form-horizontal themed" id="uislider-demo" action="test"  method="post" novalidate="novalidate">
													<fieldset>
														<div class="control-group">
															<label class="control-label" for="input01">Experiment Name</label>
															<div class="controls">
																<input type="text" class="span12" name="testName" id="testName"/>
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
																	<option value="SCP">SCP</option>
														        </select>
															</div>
														</div>
														<div class="control-group">
															<label class="control-label" for="select01">Protocol</label>
															<div class="controls">
																<select name="protocol" class="span12 with-search">
													                <option value="ipv4">IPv4</option>
																	<option value="ipv6">IPv6</option>
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
																		<input type="text" name="dataNumber" id="amount2" class="ui-display-label" /> 
																	</p>
																	<label class="radio inline">
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
																	</label>
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
		    													<input type="text" name="number" id="amount6" class="ui-display-label" />
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

														<div class="form-actions">
															<button type="reset" class="btn medium btn-danger">
																Cancel
															</button>
															<button type="submit" class="btn medium btn-primary">
																Save changes
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
  </body>
</html>
