<g:if test="${ownerInstance && ownerInstance instanceof frontlinesms2.Poll}">
	<g:select class="dropdown more-actions poll-btn" name="more-actions"
		from="${['Export', 'Rename ' + ownerInstance?.type, 'Edit ' + ownerInstance?.type, 'Delete ' + ownerInstance?.type]}"
			keys="${['export', 'rename', 'edit', 'delete']}"
			noSelection="${['': 'More actions...']}"/>
</g:if>
<g:else>
	<g:select class="dropdown more-actions poll-btn" name="more-actions"
		from="${['Export', 'Rename ' + ownerInstance?.type, 'Delete ' + ownerInstance?.type]}"
			keys="${['export', 'rename', 'delete']}"
			noSelection="${['': 'More actions...']}"/>
</g:else>
