<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.fancytree/2.6.0/jquery.fancytree-all.js" type="text/javascript"></script>
<link href="fancytree/src/skin-lion/ui.fancytree.css" rel="stylesheet" type="text/css">

<script type="text/javascript">
	$(function(){
	  // Create the tree inside the <div id="tree"> element.
	  $("#tree").fancytree({ ... });
	  $("#selector").fancytree({
		    activeVisible: true, // Make sure, active nodes are visible (expanded).
		    aria: false, // Enable WAI-ARIA support.
		    autoActivate: true, // Automatically activate a node when it is focused (using keys).
		    autoCollapse: false, // Automatically collapse all siblings, when a node is expanded.
		    autoScroll: false, // Automatically scroll nodes into visible area.
		    clickFolderMode: 4, // 1:activate, 2:expand, 3:activate and expand, 4:activate (dblclick expands)
		    checkbox: false, // Show checkboxes.
		    debugLevel: 2, // 0:quiet, 1:normal, 2:debug
		    disabled: false, // Disable control
		    focusOnSelect: true, // Set focus when node is checked by a mouse click
		    generateIds: false, // Generate id attributes like <span id='fancytree-id-KEY'>
		    idPrefix: "ft_", // Used to generate node id´s like <span id='fancytree-id-<key>'>.
		    icons: true, // Display node icons.
		    keyboard: true, // Support keyboard navigation.
		    keyPathSeparator: "/", // Used by node.getKeyPath() and tree.loadKeyPath().
		    minExpandLevel: 1, // 1: root node is not collapsible
		    quicksearch: true, // Navigate to next node by typing the first letters.
		    selectMode: 2, // 1:single, 2:multi, 3:multi-hier
		    tabbable: true, // Whole tree behaves as one single control
		    titlesTabbable: true // Node titles can receive keyboard focus
		});
	});
</script>
 

<div id="tree">...</div>
  