<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<link href="${pageContext.request.contextPath}/resources/fancytree/skin-lion/ui.fancytree.css" rel="stylesheet" type="text/css">
<script src="${pageContext.request.contextPath}/resources/fancytree/src/jquery.fancytree.js" type="text/javascript"></script>

<script type="text/javascript">
	$(function(){
		$("#tree").fancytree({
			activate: function(event,data, msg) {
				//alert(data.node);
			}
		});
	});
</script>

<div class="menuContainer">

<h1>Key Chain Store</h1>
<div class="description">
	Select An Item Below.<br>
</div>
<div id="tree">
	<ul id="treeData" style="display: none;">
		<li id="id1" title="Look, a tool tip!">item1 with key and tooltip
		<li id="id2">item2
		<li id="id3" class="folder">Folder <em>with some</em> children
			<ul>
				<li id="id3.1">Sub-item 3.1
					<ul>
						<li id="id3.1.1">Sub-item 3.1.1
						<li id="id3.1.2">Sub-item 3.1.2
					</ul>
				<li id="id3.2">Sub-item 3.2
					<ul>
						<li id="id3.2.1">Sub-item 3.2.1
						<li id="id3.2.2">Sub-item 3.2.2
					</ul>
			</ul>
		<li id="id4" class="expanded">Document with some children (expanded on init)
			<ul>
				<li id="id4.1"  class="active focused">Sub-item 4.1 (active and focus on init)
					<ul>
						<li id="id4.1.1">Sub-item 4.1.1
						<li id="id4.1.2">Sub-item 4.1.2
					</ul>
				<li id="id4.2">Sub-item 4.2
					<ul>
						<li id="id4.2.1">Sub-item 4.2.1
						<li id="id4.2.2">Sub-item 4.2.2
					</ul>
			</ul>
	</ul>
</div>
</div>
