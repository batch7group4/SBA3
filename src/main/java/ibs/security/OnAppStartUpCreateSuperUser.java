/*
 * package ibs.security;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.boot.context.event.ApplicationStartedEvent; import
 * org.springframework.context.event.EventListener; import
 * org.springframework.security.crypto.password.PasswordEncoder; import
 * org.springframework.stereotype.Component;
 * 
 * import ibs.entities.CustAcctEntity; import ibs.entities.LoginDetailsEntity;
 * import ibs.repo.CustomerRepo; import ibs.repo.LoginRepository;
 * 
 * 
 * 
 * @Component public class OnAppStartUpCreateSuperUser {
 * 
 * @Autowired private LoginRepository loginRepository;
 * 
 * @Autowired private PasswordEncoder encoder;
 * 
 * @EventListener public void createSuperUserOnStartUp(ApplicationStartedEvent
 * event) { if(!loginRepository.existsByUserName("BankRep")) {
 * loginRepository.save(new LoginDetailsEntity(null, "BankRep",
 * encoder.encode("BankRep"),"ADMIN")); } }
 * 
 * }
 * 
 */