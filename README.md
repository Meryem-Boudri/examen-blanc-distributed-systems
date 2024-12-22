kc.bat start-dev
consul agent -server -bootstrap-expect=1 -data-dir=consul-data -ui -bind=192.168.1.4
admin 1234
http://localhost:8080/realms/sdia-realm
http://localhost:8080/realms/sdia-realm/.well-known/openid-configuration