# hexagonal-school
Simple application with HEXAGONAL architecture. Details: https://blog.ndepend.com/hexagonal-architecture/

Domain:  All the business logic will be in the domain. It will have no dependency on any framework.

Infrastructure: Infrastructure contains all the dependency on spring, fluent-jdbc, etc.

Bootstrap: All the spring-boot configurations are in bootstrap which does the wiring of the application.
