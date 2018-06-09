# Protecting Spring Boot Admin dashboard and Actuator Endpoints with Keycloak

# Setup Keycloak

Import `keycloakconfig/oga-management-realm.json` to keycloak

Then you will have to reset the admin user password to be able to use the monitoring dashboard

# Run the examples

## Run microservices

Services :

 - my-service
 - discovery-server
 - monitoring-dashboard

Run the services using the default ports or feel free to change them (if you change the ports you will have to set the new urls in keycloak)
