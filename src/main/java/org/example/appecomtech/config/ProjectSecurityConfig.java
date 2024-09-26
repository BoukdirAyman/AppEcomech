//package org.example.appecomtech.config;
//
//
////
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.context.annotation.Bean;
////import org.springframework.context.annotation.Configuration;
////import org.springframework.security.config.Customizer;
////import org.springframework.security.config.annotation.web.builders.HttpSecurity;
////import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
////import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
////import org.springframework.security.core.userdetails.User;
////import org.springframework.security.core.userdetails.UserDetails;
////import org.springframework.security.crypto.password.NoOpPasswordEncoder;
////import org.springframework.security.crypto.password.PasswordEncoder;
////import org.springframework.security.provisioning.InMemoryUserDetailsManager;
////import org.springframework.security.web.SecurityFilterChain;
////
////@Configuration
////@EnableWebSecurity
////public class SecurityConfig {
////
////
////
////    @Bean
////    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
////
////        http
////                .csrf((csrf) -> csrf.disable())
////                .authorizeHttpRequests((requests) -> requests
////                        .requestMatchers("/editProfile", "/post", "/deleteVideo", "/logout", "/my-videos", "/index", "/updateVideo", "/produits/panier").authenticated()
////                        .requestMatchers("/**", "/webjars/**", "/sign", "/login", "/static/**", "/css/**", "/javascript/**").permitAll()
////                        .anyRequest().authenticated())
////                .formLogin(form -> form
////                        .defaultSuccessUrl("/telephone", true)) // Redirige vers /listeReclamations après une connexion réussie
////                .httpBasic(Customizer.withDefaults());
////
////        return http.build();
////    }
////    }
////
////
////
////
//
//
//
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;



@Configuration
@EnableWebSecurity
public class ProjectSecurityConfig {



    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {

        http
                .csrf((csrf)->csrf.disable())

                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/login", "/inscription"
                        ).authenticated()
                        .requestMatchers("/", "/produits/allproduits", "/webjars/**","/h2-console/**" , "/recherche" ,"/Apple" ,
                                "/panier","/panier/ajouter","/panier/viewpanier" , "/panier/passer-commande" ,"/Smartphones","/Accessoires"
                                ,"/Tablettes","/Samsung","/Huawei","/panier","","","","","","",""
                        ).permitAll())
//                .formLogin((form -> form.loginPage("/loginpage").permitAll()))
                .formLogin(form -> form
                        .defaultSuccessUrl("/", true)) // Redirige vers /listeReclamations après une connexion réussie
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }



    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

}


