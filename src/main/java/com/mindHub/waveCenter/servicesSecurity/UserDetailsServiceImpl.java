package com.mindHub.waveCenter.servicesSecurity;


import ch.qos.logback.core.net.server.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
//Implementamos la logica de la interfaz UserDetailsService
public class UserDetailsServiceImpl implements UserDetailsService {

    //Inyectamos el repositorio de clientes
    @Autowired
    private ClientRepository clientRepository;

    //Implementamos el metodo
    //Metodo de la interfaz que estamos sobrescribiendo
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //Se busca el cliente para autenticarlo
        Client client = clientRepository.findByEmail(username);

        if (client == null) {
            throw new UsernameNotFoundException(username);
        }

        if (username.contains("admin")) {
            return User.withUsername(username)
                    .password(client.getPassword())
                    .roles("ADMIN")
                    .build();
        }

        return User.withUsername(username)
                .password(client.getPassword())
                .roles("CLIENT")
                .build();


    }
}
