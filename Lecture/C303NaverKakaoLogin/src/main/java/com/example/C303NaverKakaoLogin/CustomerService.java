package com.example.C303NaverKakaoLogin;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Service
public class CustomerService implements UserDetailsService {
    
    @Autowired
    private CustomerRepository customerRepository;
    
    @Autowired
    private HttpServletRequest req;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Customer> tcustomer = customerRepository.findByUsername(username);
        if (tcustomer.isEmpty()) {
            throw new UsernameNotFoundException("You need to Sign up first...");
        }
        Customer customer = tcustomer.get();
        List<GrantedAuthority> authorities = new ArrayList<>();
        if ("ROLE_USER".equals(customer.getRole())) {
            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        } else if ("ROLE_MANAGER".equals(customer.getRole())) {
            authorities.add(new SimpleGrantedAuthority("ROLE_MANAGER"));
        } else {
            authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        }
        return new User(customer.getUsername(), customer.getPassword(), authorities);
    }
    
    public void create(Customer customer) {
        customer.setEnabled(true);
        customer.setRole("ROLE_USER"); // ROLE_ADMIN, ROLE_MANAGER, ROLE_PAID...
        customer.setCdate(LocalDateTime.now());
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        customer.setPassword(passwordEncoder.encode(customer.getPassword()));
        customerRepository.save(customer);
    }
    
    public List<Customer> readlist() {
        return customerRepository.findAll();
    }
    
    public Customer readdetail(Integer cid) {
        Optional<Customer> oc = customerRepository.findById(cid);
        return oc.orElse(null);
    }
    
    public void update(Customer customer) {
        customerRepository.save(customer);
    }
    
    public void updaterole() {
        Customer customer = authen();
        customer.setRole("ROLE_MANAGER");
        customerRepository.save(customer);
    }
    
    @Autowired
    private Principal principal;
    
    public Customer authen() {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        Object principal = authentication.getPrincipal();
//        String username;
//        if (principal instanceof UserDetails) {
//            username = ((UserDetails) principal).getUsername();
//        } else if (principal instanceof String) {
//            username = (String) principal;
//        } else {
//            throw new IllegalArgumentException("Unexpected principal type: " + principal.getClass());
//        }
//        Optional<Customer> oc = customerRepository.findByUsername(username);
//        return oc.orElse(null);
    	
        Optional<Customer> oc = customerRepository.findByUsername(principal.getName());
            return oc.get();
    }
   
    
    // Naver login check
    public int logincheck(String username) throws UsernameNotFoundException {
        Optional<Customer> tcustomer = customerRepository.findByUsername(username);
        if (tcustomer.isEmpty()) {
            return 1; // DB에 없음, 회원 가입으로
        }
        Customer customer = tcustomer.get();
        List<GrantedAuthority> authorities = new ArrayList<>();
        if ("ROLE_USER".equals(customer.getRole())) {
            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        } else if ("ROLE_MANAGER".equals(customer.getRole())) {
            authorities.add(new SimpleGrantedAuthority("ROLE_MANAGER"));
        } else {
            authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        }
		SecurityContext sc = SecurityContextHolder.getContext();
		sc.setAuthentication(new UsernamePasswordAuthenticationToken(customer.getUsername(), customer.getPassword(), authorities));
		HttpSession session = req.getSession(true);
		session.setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY,sc);
	
//        SecurityContext sc = SecurityContextHolder.createEmptyContext();
//        sc.setAuthentication(new UsernamePasswordAuthenticationToken(customer.getUsername(), customer.getPassword(), authorities));
//        HttpSession session = req.getSession(true);
//        session.setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY, sc);
//        WebAuthenticationDetailsSource detailsSource = new WebAuthenticationDetailsSource();
//        Authentication authentication = new UsernamePasswordAuthenticationToken(customer.getUsername(), customer.getPassword(), authorities);
//        ((AbstractAuthenticationToken) authentication).setDetails(detailsSource.buildDetails(req));
//        SecurityContextHolder.setContext(sc);
        return 0; // DB에 있음, 세션 처리까지 완료
    }
}