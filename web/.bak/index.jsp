<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
  <title>Ant Installer</title>
  <link href="style.css" type="text/css" rel="stylesheet">
  <link href="css/nav.css" rel="stylesheet" type="text/css">
  <link rel="SHORTCUT ICON" type="image/png" href="images/antinstaller-icon.png">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta name="keywords"
 content="Ant, installer, AntInstall, gui, console, input, parameters, properties, swing, user interface, validation, configuration">
 <script type="text/javascript" src="js/menu.js"></script>
 <script type="text/javascript" src="js/sstree.js"></script>
 <script type="text/javascript" src="js/winfix.js"></script>
</head>
<body onload="collapseAll('contents-panel', ['ol']); "><div id="tpallcontent">
<table cellspacing="0" width="100%">
  <tbody>
    <tr class="tpheader">
      <th class="tpleft">
			<a target="_top" href="index.html" title="home"><img src="images/ant-install-small.png" alt="AntInstaller" id="logo" width="76" height="50"/></a>
			<script type="text/javascript">winFix();</script>
      </th>
      <th class="tptop" valign="bottom">
				<img src="space.gif" height="1" width="440" alt="spacer"/><br/>
				
				<table>
					<tr>
						<td valign="top">
							<div class="tpheadertitle">AntInstaller</div>
							<!--img src="images/ant-install-title.png" alt="AntInstaller"/-->
						</td>
						<td width="100%" align="right" valign="bottom" nowrap="NOWRAP">
				<div class="tpraised">
				<a class="tpbutton" target="_top" href="index.html">home</a>
				<a class="tpbutton" target="_top" href="http://sourceforge.net/project/showfiles.php?group_id=123466&amp;package_id=134917">download</a>
				<a class="tpbutton" target="_top" href="http://sf.net">sourceforge</a> 
				<a class="tpbutton" target="_top" href="manual-ant.html">antmanual</a> 
				<a class="tpbutton" target="_top" href="http://sourceforge.net/tracker/?group_id=123466&amp;atid=696615">RFEs</a> 
				<a class="tpbutton" target="_top" href="http://sourceforge.net/tracker/?group_id=123466&amp;atid=696612">Bugs</a></div>
						</td>
					</tr>
				</table>
      </th>
    </tr>
    <tr class="tpbody">
		<td class="tpleft" valign="bottom">
			<br/>
			<div id="logoset">
			<a target="_top" href="http://sourceforge.net"><img src="http://sourceforge.net/sflogo.php?group_id=123466&amp;type=2" alt="SourceForge.net Logo" border="0" height="37" width="125"></a>
			<br/><br/>
			<a target="_top" href="http://sourceforge.net/donate/index.php?group_id=123466">
			<img src="http://sourceforge.net/images/project-support.jpg" alt="donate to AntInstaller"/>
			</a>
			</div>
		</td>
      <td class="tpright" valign="top">
      <div class="tpcontent">
			<!--[segment-content] page content start -->
<script type="text/javascript">
function gooSrch(){
  var text = document.getElementById('gf').elements['q'].value;
	document.getElementById('gf').elements['q'].value = text + " site:antinstaller.sourceforge.net";
	document.getElementById('gf').submit();
}
collapseAll('frontpage-panel', ['ol']); 
</script>
<%@page import="java.io.*" %><%@page import="java.util.*" %>
            <div align="right">
							<form action="http://www.google.com/search" method="get" id="gf" style="display:inline" onsubmit="return gooSrch();">
								<input type="text" name="q" size="10" class="winFix" />
								<input type="image" src="images/toolbar.gif" /><span class="tpsmall"> Google Search this site</span>
							</form>
						</div>
		<hr/>
		AntInstaller enables you to quickly build installers for your applications using an XML config file and all the power of <a  href="http://ant.apache.org">Ant</a>.<br/><br/>
		
		The beauty of AntInstaller, from a user point of view, is that it lets you install an app with a user friendly swing GUI. If working over ssh or without an X environment you can still install on the command line with no changes to the installer.<br/><br/>
		
		To start using AntInstaller <a href="http://sourceforge.net/project/showfiles.php?group_id=123466&amp;package_id=134917" title="download">download</a> and install the binaries. Then either read the <a href="quickstart.html" title="AntInstaller quick start">quick start</a> page, or use the <a href="quickstart.html#wizard" title="AntInstaller wizard">wizard</a> provided to generate an initial installer for your project.  You will need to edit the <code>antinstall-config.xml</code> file following instructions in the AntInstaller <a href="manual.html" title="AntInstaller manual">manual</a> and create an Ant <code>build.xml</code> file referencing the Ant <a href="manual/manual/index.html" title="Ant manual">manual</a>.  You can include the custom Ant <a href="installertask.html" title="AntInstaller manual">task</a> into your project's build to generate the installer.<br/><br/>

		In a move to be compatible with Apache projects the code in this project is now licensed under the less restrictive Apache 2.0 license.  The new (18/05/2005) license can be viewed here <a href="http://www.apache.org/licenses/LICENSE-2.0">Apache License 2.0</a>
		<br/><br/>
		All core code is available in CVS, and can be browsed online <a href="http://antinstaller.cvs.sourceforge.net/antinstaller/" title="CVS Browse">here</a>.
		<h2>Site map</h2>
		<div id="frontpage-panel">
		<jsp:include page="contents-include.html" flush="true"/>
		</div>
		<h2>Core Developers</h2>
		<ul>
			<li>Paul Hinds - project lead, core dev, and slacking for months on end ;)</li>
			<li>Mark Wilson - core development, bug fixings RFEs</li>
		</ul>
		<br/>
		<h2>Contributors</h2>
		
		P.S. Big thanks to Contributors and bug fixers
		<ul>
			<li>Marcia Choy - for inital comments and corrections in the web pages</li>
			<li>Dueringer Markus - for hints on showing hidden directories</li>
			<li>Simon Brooke - for feedback and suggestions.</li>
			<li>Mark Anderson - for the TargetSelectInput and -lib fix.</li>
			<li>Mohan Kishore - for improvement to the build process.</li>
			<li>Mike Watts - for comment and suggestions</li>
			<li>Eddyrun - for suggestions for ifProperty enhancements</li>
			<li>Upayavira - for help with Apache licensing</li>
			<li>Dabintxi - for work on i18n</li>
			<li>Michael Lipp - for german translation</li>
		</ul>
		<br/>
		
		<h2>Contact</h2>
		
		To get in contact the following channels are available.<br/><br/>
		
		<ul>
			<li><a href="http://sourceforge.net/tracker/?group_id=123466&atid=696615" title="Request for enhancements">RFEs</a> - Request for enhancements</li>
			<li><a href="http://sourceforge.net/tracker/?group_id=123466&atid=696612" title="Bug reporting">Bugs</a> - Bug reporting</li>
			<li><a href="http://sourceforge.net/forum/forum.php?forum_id=420821" title="Help Forum">Help Forum</a> - Help mailing list</li>
			<li><a href="http://sourceforge.net/forum/forum.php?forum_id=420820" title="Open Forum">Open Forum</a> - Open discussion forum</li>
			<li><a href="http://sourceforge.net/forum/forum.php?forum_id=420822" title="Dev Forum">Dev Forum</a> - Developers forum (closed group)</li>
			<li><a href="http://sourceforge.net/sendmessage.php?touser=616485" title="General contact">General contact</a> - Drop me a line</li>
		</ul>
		<h2>Version</h2>
		<%
		String strJspDir = (String)application.getAttribute("myjasper.jsp.dir");
		File fleJspDir = new File(strJspDir);
		Properties versionProps = new Properties();
		versionProps.load(new FileInputStream(new File(fleJspDir, "../build/version.properties")));
		%>
		CVS AntInstaller development version: <b><%=versionProps.getProperty("ant.install.version")%></b>
		<br/><br/>
		
		<h2>Firefox</h2>

		Site designed for FireFox, other browsers should be ok see <a href="browsersupport.html" alt="Browser support" >Browser support</a> and report bugs if you find them.<br/><br/>

		<a href="http://getfirefox.com/"
				title="Get Firefox - The Browser, Reloaded."><img
				src="images/browser/firefox-spread-btn-2.png"
				width="180" height="60" alt="Get Firefox"></a>
		<br/>
		<script language="JavaScript" type="text/javascript">
		function addSidebar(title, link){ 
			if ((typeof window.sidebar == "object") && (typeof window.sidebar.addPanel == "function")){
				window.sidebar.addPanel (title, link, "");
			}
		} 
		</script>
		<br/>
		If you have Mozilla/Firefox
		<a href="#" onclick="javascript:addSidebar('AntInstaller SideBar', 'http://antinstaller.sourceforge.net/contents.html');return false;">Add a sidebar</a> for this site.<br/><br/>

		
		
		<hr/>
		Site last generated: <b><%=new java.util.Date()%></b>

<!-- content end [segment-end]-->
		 	</div>
      </td>
    </tr>
  </tbody>
</table>
<div id="contents-panel">
<!--[segment-file://contents-include.html] menu start -->
<div id="contents-menu">
<ol class="sidebar" id="root">
	<li class="panel"><a href="#default" class="folder" onclick="toggle(this)"></a><b>Site map</b>
		<ol>
			<li class="sidebar"><a href="introduction.html">Introduction</a></li>
			<li class="panel"><a href="#default" class="folder" onclick="toggle(this)"></a><b>Developer References</b>
				<ol>
					<li class="sidebar"><a href="quickstart.html">Quick Start</a></li>
					<li class="panel"><a href="#default" class="folder" onclick="toggle(this)"></a><a href="manual.html">Manual</a>
						<ol class="init-hidden">
							<li class="sidebar"><a href="manual.html#config">antinstall-config.xml</a></li>
							<li class="panel"><a href="#default" class="folder" onclick="toggle(this)"></a><a href="manual.html#page">Pages</a>
								<ol class="init-hidden">
									<li class="sidebar"><a href="manual.html#pagesplash">Splash Page</a></li>
									<li class="sidebar"><a href="manual.html#pagetext">Text Page</a></li>
									<li class="sidebar"><a href="manual.html#pagelicense">License Page</a></li>
									<li class="sidebar"><a href="manual.html#pageinput">Input Page</a></li>
									<li class="sidebar"><a href="manual.html#pageprogress">Progress Page</a></li>
								</ol>
							</li>
							<li class="panel"><a href="#default" class="folder" onclick="toggle(this)"></a><a href="manual.html#inputtypes">Input types</a>
								<ol class="init-hidden">
									<li class="sidebar"><a href="manual.html#app-root">Application Root</a></li>
									<li class="sidebar"><a href="manual.html#checkbox">Checkbox</a></li>
									<li class="sidebar"><a href="manual.html#comment">Comment</a></li>
									<li class="sidebar"><a href="manual.html#date">Date</a></li>
									<li class="sidebar"><a href="manual.html#directory">Directory</a></li>
									<li class="sidebar"><a href="manual.html#file">File</a></li>
									<li class="sidebar"><a href="manual.html#large-select">Large Select</a></li>
									<li class="sidebar"><a href="manual.html#password">Password Text</a></li>
									<li class="sidebar"><a href="manual.html#password-confirm">Confirm Password</a></li>
									<li class="sidebar"><a href="manual.html#select">Select</a></li>
									<li class="sidebar"><a href="manual.html#target">Target</a></li>
									<li class="sidebar"><a href="manual.html#target-select">Target Select</a></li>
									<li class="sidebar"><a href="manual.html#text">Unvalidated Text</a></li>
									<li class="sidebar"><a href="manual.html#validated">Validated Text</a></li>
									<li class="sidebar"><a href="manual.html#extvalidated">Externally Validated Text</a></li>
								</ol>
							</li>
							<li class="sidebar"><a href="manual.html#extractor">Self Extractor</a></li>
							<li class="sidebar"><a href="manual.html#non-extractor">Non Extractor</a></li>
							<li class="sidebar"><a href="manual.html#scripts">Start Scripts</a></li>
							<li class="sidebar"><a href="manual.html#refs">Dynamic References</a></li>
							<li class="sidebar"><a href="manual.html#pagedisplay">Page Displaying</a></li>
						</ol>
					</li>
					<li class="sidebar"><a href="installertask.html">Installer Ant task</a></li>
					<li class="sidebar"><a href="validationofconfig.html">Validation of config</a></li>
					<li class="sidebar"><a href="lookandfeels.html">LookAndFeels</a> <br/>(inc screenshots)</li>
					<li class="sidebar"><a href="classpathresources.html">Resources/Classpath issues</a></li>
					<li class="sidebar"><a href="i18n.html">Internationalisation</a></li>
					<li class="sidebar"><a href="auto.html">Automated installs</a></li>
					<li class="sidebar"><a href="installtypes.html">Multiple install types</a></li>
					<li class="sidebar"><a href="posttargets.html">Post display targets</a></li>
					<li class="sidebar"><a href="icons.html">Button Icons</a></li>
					<li class="sidebar"><a href="antinstall-config-example.html">Example antinstall-config.xml</a></li>
				</ol>
			</li>
			<li class="sidebar"><a href="manual-ant.html">Ant Manual</a></li>
			<li class="sidebar"><a href="antlinks.html">Ant links</a></li>
			<li class="sidebar"><a href="userusage.html">User usage</a></li>
			<li class="sidebar"><a href="licenses.html">Licenses</a></li>
			<li class="sidebar"><a href="potentialuses.html">Potential uses</a></li>
			<li class="sidebar"><a href="roadmap.html">Road Map</a></li>
			<li class="sidebar"><a href="wanted.html">Wanted</a></li>
			<li class="sidebar"><a href="dtds.html">DTDs</a></li>
			<li class="sidebar"><a href="changelog.html">Changelog</a></li>
			<li class="sidebar"><a href="http://sourceforge.net/projects/antinstaller">Project page on SourceForge</a></li>
			<li class="sidebar"><a href="java2html/antinstaller/index.html">Java2HTML (main)</a></li>
			<li class="sidebar"><a href="java2html/ext/index.html">Java2HTML (extensions)</a></li>
			<li class="sidebar"><a href="http://antinstaller.cvs.sourceforge.net/antinstaller">Public CVS over HTTP</a></li>
			<li class="sidebar"><a href="http://sourceforge.net/sendmessage.php?touser=616485">Contact AntInstaller Admin</a></li>
		</ol>
	</li>
</ol>
<br/>
<br/>
</div>


<!-- menu end [segment-end]-->
</div>
<div id="contents-options">
<a id="toggle" href="#" onclick="toggleMenu(); return false;">show menu</a>
</div>

</div>
</body>
</html>
