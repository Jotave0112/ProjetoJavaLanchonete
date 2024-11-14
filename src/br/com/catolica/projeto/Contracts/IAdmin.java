package br.com.catolica.projeto.Contracts;

import br.com.catolica.projeto.Enums.EnumStatusPedido;
import br.com.catolica.projeto.Model.Lanches;
import br.com.catolica.projeto.Model.Verificar;

public interface IAdmin {


   void statusLanche();
    void saldoLanchonete();
    void contratarFuncionarios(String user, String senha);
    void remocaoLanches(Lanches lanches);
    void adicionarLanches(Lanches lanches);
    void demitirFuncionarios();


}
