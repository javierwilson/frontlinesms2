package frontlinesms2.contact

import frontlinesms2.*

abstract class GroupBaseSpec extends grails.plugin.geb.GebSpec {
	def createTestGroups() {
		new Group(name:'Listeners').save(failOnError:true, flush:true)
		new Group(name:'Friends').save(failOnError:true, flush:true)
	}

	def createTestGroupsAndContacts() {
		def friendsGroup = createTestGroups()
		def bobby = new Contact(name:'Bobby').save(failOnError:true, flush:true)
		def duchamps = new Contact(name:'Duchamps').save(failOnError:true, flush:true)
		[bobby, duchamps].each() { friendsGroup.addToMembers(it) }
		friendsGroup.save(failOnError:true, flush:true)
	}
	
	def createManyContactsAddToGroups() {
		(11..90).each {
			def c = new Contact(name: "Contact${it}", mobile: "987654321${it}", notes: 'notes').save(failOnError:true, flush:true)
			c.addToGroups(Group.findByName('Friends')).save(failOnError:true, flush:true)
		}
	}
	
}

