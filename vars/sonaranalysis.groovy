def call(String Sonarserver, String scanner, String scannerproperties) {
   //def scannerHome = tool '${scanner}';
   withSonarQubeEnv('${Sonarserver}') {
      sh "/opt/sonar-scanner/bin/sonar-scanner -Dproject.settings=${scannerproperties}"    
   }
}
