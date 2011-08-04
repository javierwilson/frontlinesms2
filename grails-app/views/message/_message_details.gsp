<g:hiddenField id="message-src" name="message-src" value="${messageInstance.src}" />
<g:hiddenField id="message-id" name="message-id" value="${messageInstance.id}" />
<div id="message-details">
	<p class="message-name">${messageInstance.displayName}</p>
	<g:def var="thisAddress" value="${messageInstance.src}" />
	<g:if test="${!messageInstance.contactExists}">
		<g:link class="button" controller="contact" action="createContact" params="[primaryMobile: thisAddress]">+</g:link>
	</g:if>
	<p class="message-date"><g:formatDate format="dd-MMM-yyyy hh:mm" date="${messageInstance.dateCreated}" /></p>
	<p class="message-body" id="message-body">${messageInstance.text}</p>
	<div class="buttons">
		<g:if test="${messageSection != 'trash'}">
			<button id="btn_reply">Reply</button>
			<button id='btn_dropdown'></button>
			<ol id="dropdown_options">
				<button id="btn_forward">Forward</button>
			</ol>
			<g:link elementId="message-delete" action="deleteMessage" params="[messageSection: messageSection, ownerId: ownerInstance?.id, ids: messageInstance.id]">Delete</g:link>
			<g:link elementId="message-archive" action="archiveMessage" params="[messageSection: messageSection, ownerId: ownerInstance?.id, ids: messageInstance.id]">Archive</g:link>
		</g:if>
	</div>
</div>
<g:render template="/message/action_list"/>
