package br.com.catolica.projeto.Contracts;

import br.com.catolica.projeto.Enums.EnumCargo;
import br.com.catolica.projeto.Model.Lanches;
import br.com.catolica.projeto.Model.Verificar;

public interface ILogar {

    EnumCargo loginVerificar(String user, String senha);
    double tabelaPrecosLanches(String lanche, Lanches lanches);
    void addFuncionario(String user, String senha, int idF);
    void removerFuncionario(String user, Verificar verificar);
    void cadastrarCliente(String user, String senha);
    void addLanchesNovos(Lanches lanches);
    void removerLanches(Lanches lanches);
}
