def call(String server, String scanner,String sonarproperties) {
  //def scannerHome = tool 'Mysonarscanner'
  
  withSonarQubeEnv("${server}") {

     sh "${tool("${scanner}")}/bin/sonar-scanner -Dproject.settings=${sonarproperties}"
}
}
