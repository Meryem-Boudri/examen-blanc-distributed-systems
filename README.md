kc.bat start-dev
consul agent -server -bootstrap-expect=1 -data-dir=consul-data -ui -bind=192.168.0.192
admin 1234
http://localhost:8080/realms/sdia-realm
http://localhost:8080/realms/sdia-realm/.well-known/openid-configuration

ng new secure-front-angular --no-standalone
npm install bootstrap  
npm i bootstrap bootstrap-icons    
ng g c conference
ng g c keynote
ng g guard guards/auth
npm install keycloak-js
npm install keycloak-angular
add to assets keycloak.json
ng generate service services/keycloak
ng generate interceptor interceptors/auth

