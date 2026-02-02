package com.stockcar.exception;


public class CpfJaCadastadoException extends RuntimeException{

    public CpfJaCadastadoException(){
        super("CPF já cadastrado");
    }
}
