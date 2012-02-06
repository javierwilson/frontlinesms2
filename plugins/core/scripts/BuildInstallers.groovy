includeTargets << grailsScript("Init") << grailsScript("War")

target(main: 'Build installers for various platforms.') {
	depends(clean, war)
	def appName = metadata.'app.name'
	def appVersion = metadata.'app.version'
	delete(dir:'install/webapp')
	unzip(src:"target/${appName}-${appVersion}.war", dest:'install/webapp')
	exec(dir:'install', executable:'mvn') {
		arg value:'clean'
		arg value:'package'
	}
}

target(main_old: "Build installers for various platforms.") {
	def appVersion = metadata.'app.version'
	def jarFile = new File("target/frontlinesms2-${appVersion}.jar")
	def warFile = new File("target/frontlinesms2-${appVersion}.war")
	if(!jarFile.exists()) {
		if(!warFile.exists()) {
			println "You have not built the standlone WAR so we can't actually run this target."
			println "Please execute `grails -Dgrails.env=standalone createStandaloneWar`"
			exit(-1)
		} else {
			println "Renaming WAR to JAR..."
			warFile.renameTo(jarFile)
		}
	} else println "JAR found."

	exec(dir:'install', executable:'install4jc') {
		arg value:"-D"
		arg value:"sys.version=$appVersion"
		arg value:"windows.install4j"
	}
}

setDefaultTarget(main)