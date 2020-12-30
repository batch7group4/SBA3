/*
 * package ibs.security;
 * 
 * import java.time.LocalDate; import java.util.Collections;
 * 
 * import javax.transaction.Transactional;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.data.jpa.repository.Modifying; import
 * org.springframework.security.core.authority.SimpleGrantedAuthority; import
 * org.springframework.security.core.userdetails.User; import
 * org.springframework.security.core.userdetails.UserDetails; import
 * org.springframework.security.core.userdetails.UserDetailsService; import
 * org.springframework.security.core.userdetails.UsernameNotFoundException;
 * import org.springframework.security.crypto.password.PasswordEncoder; //import
 * org.springframework.security.crypto.password.PasswordEncoder; import
 * org.springframework.stereotype.Service; import
 * ibs.entities.LoginDetailsEntity; import ibs.exception.BankException; import
 * ibs.model.RegistrationModel; import ibs.repo.LoginRepository; import
 * ibs.repo.RegistrationRepo; import ibs.util.EMParser;
 * 
 * @Service public class UserDetailsServiceImpl implements UserDetailsService{
 * 
 * 
 * @Autowired private LoginRepository loginRepository;
 * 
 * @Autowired private RegistrationRepo subRepo;
 * 
 * 
 * 
 * @Autowired private PasswordEncoder encoder;
 * 
 * 
 * 
 * @Override public UserDetails loadUserByUsername(String username) throws
 * UsernameNotFoundException {
 * 
 * 
 * if(!loginRepository.existsByUserName(username)) { throw new
 * UsernameNotFoundException("invlaid user credits!"); }
 * 
 * LoginDetailsEntity user = loginRepository.findByUserName(username);
 * 
 * return new User(user.getUserName(), user.getPassword(),
 * Collections.singletonList(new SimpleGrantedAuthority(user.getRole())));
 * 
 * }
 * 
 * public void register(RegistrationModel user) throws BankException {
 * 
 * if(user!=null) { if(user.getPassword().equals(user.getPassword())) {
 * user.setPassword(encoder.encode(user.getPassword()));
 * subRepo.save(EMParser.parse(user)); }else { throw new
 * BankException("Password do not match"); } }
 * 
 * }
 * 
 * 
 * }
 */