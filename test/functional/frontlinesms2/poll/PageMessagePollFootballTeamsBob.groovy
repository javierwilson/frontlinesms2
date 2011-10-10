package frontlinesms2.poll

import frontlinesms2.*

class PageMessagePollFootballTeamsBob extends geb.Page {
	static getUrl() { "message/poll/${Poll.findByTitle('Football Teams').id}/show/${Fmessage.findBySrc("Bob").id}" }
	static at = {
		title.endsWith('Poll')
	}
	static content = {
		selectedMenuItem { $('#messages-menu .selected') }
		messagesList { $('#messages-submenu') }
		messagesSelect(required:false) { $(".message-select") }
	}
}