# EazyBankApp
This is a simple bank application using microservices implemented in SpringBoot

Architecture Context
Controller Layer (@Controller, @RestController)
↓
Service Layer (@Service)          ← Your class is here
↓
Repository Layer (@Repository)
Relationship to Other Annotations
Annotation        Purpose              Layer 
@Service         Business logic    Service layer
@Repository      Data access      Persistence layer
@Controller      Web requests     Presentation layer
@Component    Generic component     Any layer