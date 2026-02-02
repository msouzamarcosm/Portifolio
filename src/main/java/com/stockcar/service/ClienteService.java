package com.stockcar.service;


import com.stockcar.domain.entity.Cliente;
import com.stockcar.dto.ClienteRequestDTO;
import com.stockcar.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public Cliente cadastrarCliente(ClienteRequestDTO dto){

          clienteRepository.findByCpf(dto.getCpf())
                  .ifPresent(cliente -> {
                      throw new RuntimeException("CPF já cadastrado");
                  });

     Cliente cliente = Cliente.builder()
             .nomeCompleto(dto.getNomeCompleto())
             .cpf(dto.getCpf())
             .dataNascimento(dto.getDataNascimento())
             .build();

     return clienteRepository.save(cliente);
    }
}
