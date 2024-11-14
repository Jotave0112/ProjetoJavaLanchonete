package br.com.catolica.projeto.Contracts;

import br.com.catolica.projeto.Model.Lanches;
import br.com.catolica.projeto.Model.Verificar;

public interface IClient {

    void comprarLanches(int qnt, String lanche, Lanches lanches, Verificar verificar);
    void sairSistema();
    void cadastramentoCliente();
}
