
- Project is using postgres, create databases: customer, custmer-order, product
- auth-service uses Basic authentication, send username,password in Authorization header to get JWT token
- api-gateway is only checking for ROLE_USER authorization at the moment
- order-service, product-service, auth-service, api-gateway: registers with eureka server
- api-gateway have zuul routes defined for other services :  order-service, product-service, auth-service
- order-serivice uses product-service to get product details via feign-client




