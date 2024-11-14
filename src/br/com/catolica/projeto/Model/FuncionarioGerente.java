package br.com.catolica.projeto.Model;

import br.com.catolica.projeto.Contracts.IAdmin;
import br.com.catolica.projeto.Enums.EnumCargo;
import br.com.catolica.projeto.Enums.EnumDias;
import br.com.catolica.projeto.Enums.EnumStatusPedido;

import java.util.Scanner;

public class FuncionarioGerente extends Pessoa implements IAdmin {

    private double salario;
    private boolean loginEfetuadoAdmin;
    Verificar verificar;


    EnumStatusPedido statusPedido = EnumStatusPedido.ZERO;
    EnumCargo enumCargo;
    EnumDias enumDias = EnumDias.SEGUNDA;

    public FuncionarioGerente(String senha,
                              String user,
                              Verificar verificar
    ) {
        super(senha,user);
        this.verificar = verificar;

    }

    public void terminarDia(){
        double saldoDiario;
        if(enumDias.equals(EnumDias.SEGUNDA)){
            enumDias = EnumDias.TERCA;
            System.out.println("Dia(SEGUNDA)terminado!");
            saldoDiario = verificar.pegarPreco;
            System.out.printf("Saldo de Hoje foi: %.2f\n",saldoDiario);
            verificar.pegarPreco = 0;
        }
        else if (enumDias.equals(EnumDias.TERCA)) {
            enumDias = EnumDias.QUARTA;
            System.out.println("Dia(TERCA)terminado!");
            saldoDiario = verificar.pegarPreco;
            System.out.printf("Saldo de Hoje foi: %.2f\n",saldoDiario);
            verificar.pegarPreco = 0;
        }
        else if (enumDias.equals(EnumDias.QUARTA)) {
            enumDias = EnumDias.QUINTA;
            System.out.println("Dia(QUARTA)terminado!");
            saldoDiario = verificar.pegarPreco;
            System.out.printf("Saldo de Hoje foi: %.2f\n",saldoDiario);
            verificar.pegarPreco = 0;
        } else if (enumDias.equals(EnumDias.QUINTA)) {
            enumDias = EnumDias.SEXTA;
            System.out.println("Dia(QUINTA)terminado!");
            saldoDiario = verificar.pegarPreco;
            System.out.printf("Saldo de Hoje foi: %.2f\n",saldoDiario);
            verificar.pegarPreco = 0;
        } else if (enumDias.equals(EnumDias.SEXTA)) {
            enumDias = EnumDias.SABADO;
            System.out.println("Dia(SEXTA)terminado!");
            saldoDiario = verificar.pegarPreco;
            System.out.printf("Saldo de Hoje foi: %.2f\n",saldoDiario);
            verificar.pegarPreco = 0;
        } else if (enumDias.equals(EnumDias.SABADO)) {
            enumDias = EnumDias.SEGUNDA;
            System.out.println("Dia(SABADO)terminado!");
            saldoDiario = verificar.pegarPreco;
            System.out.printf("Saldo de Hoje foi: %.2f\n",saldoDiario);
            verificar.pegarPreco = 0;
        }
    }

    @Override
    public void statusLanche() {
            if (statusPedido.equals(EnumStatusPedido.ZERO)) {
                System.out.println("---Pedido colocado em Analise---");
                statusPedido = EnumStatusPedido.PEDENTE;
            } else if (statusPedido.equals(EnumStatusPedido.PEDENTE)) {
                System.out.println("---Pedido colocado em Preparo---");
                statusPedido = EnumStatusPedido.PREPARO;
            } else if (statusPedido.equals(EnumStatusPedido.PREPARO)) {
                System.out.println("---Pedido colocado em Pronto---");
                statusPedido = EnumStatusPedido.PRONTO;
            } else if (statusPedido.equals(EnumStatusPedido.PRONTO)) {
                System.out.println("---Sem Pedido---");
                statusPedido = EnumStatusPedido.ZERO;
            }
    }

    @Override
    public void saldoLanchonete() {
        System.out.printf("Saldo Restaurante eh: %s\n", verificar.saldoRestaurante);
    }

    @Override
    public void contratarFuncionarios(String user, String senha) {
        verificar.addFuncionario(user,senha,verificar.marcar);
        verificar.marcar +=1;
    }

    @Override
    public void demitirFuncionarios(){
        Scanner entrada =  new Scanner(System.in);
        for (int x = 0; x < verificar.idFuncionario.length;x++){
            if(verificar.funcioarioUser[x] != null && verificar.funcionarioSenha[x] != null){
                System.out.printf("User: %s ---- Senha: %s ---- Id: %d\n", verificar.funcioarioUser[x],
                        verificar.funcionarioSenha[x],verificar.idFuncionario[x]);
            }
        }
        System.out.println("Insira quem Voce deseja Demitir: ");
        String demitir  = entrada.nextLine();
        verificar.removerFuncionario(demitir,verificar);
    }

    @Override
    public void remocaoLanches(Lanches lanches){
        verificar.removerLanches(lanches);
    }

    @Override
    public void adicionarLanches(Lanches lanches){
        verificar.addLanchesNovos(lanches);
    }
}

