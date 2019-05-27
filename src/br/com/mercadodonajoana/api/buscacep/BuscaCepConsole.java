package br.com.mercadodonajoana.api.buscacep;

import br.com.mercadodonajoana.api.buscacep.control.BuscaCep;
import br.com.mercadodonajoana.api.buscacep.exceptions.BuscaCepException;
import br.com.mercadodonajoana.api.buscacep.interfaces.BuscaCepEventosImpl;
import br.com.mercadodonajoana.api.buscacep.interfaces.BuscaCepEventos;

/**
 *
 * @author Will
 */
public class BuscaCepConsole {

    public static void main(String[] args) {

        BuscaCepEventos buscaCepEvents = new BuscaCepEventosImpl();

        /**
         * Buscador de CEP - Main Teste.
         */
        BuscaCep buscaCEP = new BuscaCep();
        try {

            buscaCEP.buscar("88133810");
            System.out.println("UF:" + buscaCEP.getUf());
            System.out.println("Cidade:" + buscaCEP.getCidade());
            System.out.println("Bairro: " + buscaCEP.getBairro());
            System.out.println("Logradouro: " + buscaCEP.getLogradouro());
            buscaCepEvents.sucessoAoEncontrar(buscaCEP);
        } catch (BuscaCepException viaCEPException) {
            System.out.println("Deu erro");
        }
    }
}
